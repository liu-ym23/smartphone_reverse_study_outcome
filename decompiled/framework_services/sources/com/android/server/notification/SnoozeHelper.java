package com.android.server.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.service.notification.StatusBarNotification;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.Log;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.am.HostingRecord;
import com.android.server.pm.PackageManagerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class SnoozeHelper {
    static final int CONCURRENT_SNOOZE_LIMIT = 500;
    private static final boolean DEBUG = false;
    static final String EXTRA_KEY = "key";
    private static final String EXTRA_USER_ID = "userId";
    private static final String INDENT = "    ";
    static final int MAX_STRING_LENGTH = 1000;
    private static final String REPOST_ACTION = null;
    private static final String REPOST_SCHEME = "repost";
    private static final int REQUEST_CODE_REPOST = 1;
    private static final String TAG = "SnoozeHelper";
    private static final String XML_SNOOZED_NOTIFICATION = "notification";
    private static final String XML_SNOOZED_NOTIFICATION_CONTEXT = "context";
    private static final String XML_SNOOZED_NOTIFICATION_CONTEXT_ID = "id";
    private static final String XML_SNOOZED_NOTIFICATION_KEY = "key";
    private static final String XML_SNOOZED_NOTIFICATION_TIME = "time";
    public static final int XML_SNOOZED_NOTIFICATION_VERSION = 1;
    private static final String XML_SNOOZED_NOTIFICATION_VERSION_LABEL = "version";
    protected static final String XML_TAG_NAME = "snoozed-notifications";
    private AlarmManager mAm;
    private final BroadcastReceiver mBroadcastReceiver;
    private Callback mCallback;
    private final Context mContext;
    private final Object mLock;
    private final ArrayMap<String, Long> mPersistedSnoozedNotifications;
    private final ArrayMap<String, String> mPersistedSnoozedNotificationsWithContext;
    private ArrayMap<String, NotificationRecord> mSnoozedNotifications;
    private final ManagedServices.UserProfiles mUserProfiles;

    protected interface Callback {
        void repost(int r1, NotificationRecord r2, boolean r3);
    }

    private interface Inserter<T> {
        void insert(T r1) throws IOException;
    }

    /* JADX INFO: renamed from: $r8$lambda$4KBXZ-uYV7udlXsFArYPCUZ5TCo, reason: not valid java name */
    public static /* synthetic */ void m6283$r8$lambda$4KBXZuYV7udlXsFArYPCUZ5TCo(long r0, TypedXmlSerializer r2, Long r3) {
        lambda$writeXml$4(r0, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ORbxduI1i9EyexJqwlTWf9qBf98(SnoozeHelper r0, NotificationRecord r1) {
        r0.lambda$clearData$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$W-kKzRYYCH_u5eAHs7yYkqnwTHw, reason: not valid java name */
    public static /* synthetic */ void m6284$r8$lambda$WkKzRYYCH_u5eAHs7yYkqnwTHw(TypedXmlSerializer r0, String r1) {
        lambda$writeXml$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Y4-HUdiQ2mM_ipC0C5m0PuI047I, reason: not valid java name */
    public static /* synthetic */ void m6285$r8$lambda$Y4HUdiQ2mM_ipC0C5m0PuI047I(SnoozeHelper r0, NotificationRecord r1) {
        r0.lambda$clearData$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$hSfhIlBpHDWAqBTMC3IihDXCly8(SnoozeHelper r0, NotificationRecord r1) {
        r0.lambda$repostGroupSummary$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$oD-f4qe_OZa4J4cC3LIk_Z8cdgM, reason: not valid java name */
    public static /* synthetic */ void m6286$r8$lambda$oDf4qe_OZa4J4cC3LIk_Z8cdgM(SnoozeHelper r0, String r1, long r2) {
        r0.lambda$scheduleRepostAtTime$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6287$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetREPOST_ACTION, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6288$$Nest$sfgetREPOST_ACTION() {
        return REPOST_ACTION;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        REPOST_ACTION = SnoozeHelper.class.getSimpleName() + ".EVALUATE";
    }

    public SnoozeHelper(Context context, Callback callback, ManagedServices.UserProfiles userProfiles) {
        this.mSnoozedNotifications = new ArrayMap();
        this.mPersistedSnoozedNotifications = new ArrayMap();
        this.mPersistedSnoozedNotificationsWithContext = new ArrayMap();
        this.mLock = new Object();
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mContext = context;
        IntentFilter filter = new IntentFilter(REPOST_ACTION);
        filter.addDataScheme(REPOST_SCHEME);
        this.mContext.registerReceiver(this.mBroadcastReceiver, filter, 2);
        this.mAm = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mCallback = callback;
        this.mUserProfiles = userProfiles;
    }

    protected boolean canSnooze(int numberToSnooze) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if ((this.mSnoozedNotifications.size() + numberToSnooze) <= 500) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L7:
        if (((this.mPersistedSnoozedNotifications.size() + this.mPersistedSnoozedNotificationsWithContext.size()) + numberToSnooze) > 500) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    }

    protected Long getSnoozeTimeForUnpostedNotification(int userId, String pkg, String key) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Long time = this.mPersistedSnoozedNotifications.get(getTrimmedString(key));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (time == null) goto L8;
        return time;
    L8:
        return 0L;
    L9:
        th = move-exception;
        throw th;
    }

    protected String getSnoozeContextForUnpostedNotification(int userId, String pkg, String key) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mPersistedSnoozedNotificationsWithContext.get(getTrimmedString(key));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected boolean isSnoozed(int userId, String pkg, String key) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSnoozedNotifications.containsKey(key);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected Collection<NotificationRecord> getSnoozed(int userId, String pkg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList snoozed = new ArrayList();     // Catch: Throwable -> L12
        Iterator<NotificationRecord> r2 = this.mSnoozedNotifications.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L15;
        NotificationRecord r = r2.next();     // Catch: Throwable -> L12
        if (r.getUserId() != userId) goto L6;
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L6;
        snoozed.add(r);     // Catch: Throwable -> L12
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return snoozed;
    L12:
        th = move-exception;
        throw th;
    }

    ArrayList<NotificationRecord> getNotifications(String pkg, String groupKey, Integer userId) {
        ArrayList<NotificationRecord> records = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L22:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSnoozedNotifications.size()) goto L18;
        NotificationRecord r = this.mSnoozedNotifications.valueAt(i);     // Catch: Throwable -> L14
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L16;
        if (r.getUserId() != userId.intValue()) goto L16;
        if (Objects.equals(r.getSbn().getGroup(), groupKey) == false) goto L16;
        records.add(r);     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L22
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return records;
    }

    protected NotificationRecord getNotification(String key) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NotificationRecord r1 = this.mSnoozedNotifications.get(key);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected List<NotificationRecord> getSnoozed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<NotificationRecord> snoozed = new ArrayList();     // Catch: Throwable -> L7
        snoozed.addAll(this.mSnoozedNotifications.values());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return snoozed;
    L7:
        th = move-exception;
        throw th;
    }

    protected void snooze(NotificationRecord record, long duration) {
        String key = record.getKey();
        snooze(record);
        scheduleRepost(key, duration);
        Long activateAt = Long.valueOf(System.currentTimeMillis() + duration);
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mPersistedSnoozedNotifications.put(getTrimmedString(key), activateAt);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void snooze(NotificationRecord record, String contextId) {
        if (contextId == null) goto L11;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPersistedSnoozedNotificationsWithContext.put(getTrimmedString(record.getKey()), getTrimmedString(contextId));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        snooze(record);
    }

    private void snooze(NotificationRecord record) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Snoozing " + record.getKey());
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSnoozedNotifications.put(record.getKey(), record);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private String getTrimmedString(String key) {
        if (key != null) goto L4;
    L7:
        return key;
    L4:
        if (key.length() <= 1000) goto L7;
        return key.substring(0, 1000);
    }

    protected boolean cancel(int userId, String pkg, String tag, int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Set<Map.Entry<String, NotificationRecord>> records = this.mSnoozedNotifications.entrySet();     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, NotificationRecord>> r2 = records.iterator();     // Catch: Throwable -> L18
    L6:
        if (r2.hasNext() == false) goto L21;
        Map.Entry<String, NotificationRecord> record = r2.next();     // Catch: Throwable -> L18
        StatusBarNotification sbn = record.getValue().getSbn();     // Catch: Throwable -> L18
        if (sbn.getPackageName().equals(pkg) == false) goto L6;
        if (sbn.getUserId() != userId) goto L6;
        if (Objects.equals(sbn.getTag(), tag) == false) goto L6;
        if (sbn.getId() != id) goto L6;
        record.getValue().isCanceled = true;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return true;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    protected void cancel(int userId, boolean includeCurrentProfiles) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSnoozedNotifications.size() != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        IntArray userIds = new IntArray();     // Catch: Throwable -> L8
        userIds.add(userId);     // Catch: Throwable -> L8
        if (includeCurrentProfiles == false) goto L13;
        userIds = this.mUserProfiles.getCurrentProfileIds();     // Catch: Throwable -> L8
    L13:
        Iterator<NotificationRecord> r2 = this.mSnoozedNotifications.values().iterator();     // Catch: Throwable -> L8
    L15:
        if (r2.hasNext() == false) goto L20;
        NotificationRecord r = r2.next();     // Catch: Throwable -> L8
        if (userIds.binarySearch(r.getUserId()) < 0) goto L15;
        r.isCanceled = true;     // Catch: Throwable -> L8
        goto L15
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    protected boolean cancel(int userId, String pkg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int n = this.mSnoozedNotifications.size();     // Catch: Throwable -> L12
        int i = 0;
    L6:
        if (i >= n) goto L16;
        NotificationRecord r = this.mSnoozedNotifications.valueAt(i);     // Catch: Throwable -> L12
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L14;
        if (r.getUserId() != userId) goto L14;
        r.isCanceled = true;     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    protected void update(int userId, NotificationRecord record) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mSnoozedNotifications.containsKey(record.getKey()) == false) goto L9;
        this.mSnoozedNotifications.put(record.getKey(), record);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    protected void repostAll(IntArray userIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<NotificationRecord> snoozedNotifications = getSnoozed();     // Catch: Throwable -> L10
        Iterator<NotificationRecord> r2 = snoozedNotifications.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        NotificationRecord r = r2.next();     // Catch: Throwable -> L10
        if (userIds.binarySearch(r.getUserId()) < 0) goto L6;
        repost(r.getKey(), r.getUserId(), false);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected void repost(String key, boolean muteOnReturn) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NotificationRecord r = this.mSnoozedNotifications.get(key);     // Catch: Throwable -> L7
        if (r == null) goto L9;
        repost(key, r.getUserId(), muteOnReturn);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void repost(String key, int userId, boolean muteOnReturn) {
        String trimmedKey = getTrimmedString(key);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mPersistedSnoozedNotifications.remove(trimmedKey);     // Catch: Throwable -> L11
        this.mPersistedSnoozedNotificationsWithContext.remove(trimmedKey);     // Catch: Throwable -> L11
        NotificationRecord record = this.mSnoozedNotifications.remove(key);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (record != null) goto L8;
        return;
    L8:
        if (record.isCanceled == true) goto L17;
        PendingIntent pi = createPendingIntent(record.getKey());
        this.mAm.cancel(pi);
        MetricsLogger.action(record.getLogMaker().setCategory(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_SESSION).setType(1));
        this.mCallback.repost(record.getUserId(), record, muteOnReturn);
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    protected void repostGroupSummary(String pkg, int userId, String groupKey) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String groupSummaryKey = null;
        int n = this.mSnoozedNotifications.size();     // Catch: Throwable -> L18
        int i = 0;
    L6:
        if (i >= n) goto L21;
        NotificationRecord potentialGroupSummary = this.mSnoozedNotifications.valueAt(i);     // Catch: Throwable -> L18
        if (potentialGroupSummary.getSbn().getPackageName().equals(pkg) == false) goto L20;
        if (potentialGroupSummary.getUserId() != userId) goto L20;
        if (potentialGroupSummary.getSbn().isGroup() == false) goto L20;
        if (potentialGroupSummary.getNotification().isGroupSummary() == false) goto L20;
        if (groupKey.equals(potentialGroupSummary.getGroupKey()) == false) goto L20;
        groupSummaryKey = potentialGroupSummary.getKey();     // Catch: Throwable -> L18
    L20:
        i = i + 1;     // Catch: Throwable -> L18
    L21:
        if (groupSummaryKey == null) goto L27;
        final NotificationRecord record = this.mSnoozedNotifications.remove(groupSummaryKey);     // Catch: Throwable -> L18
        String trimmedKey = getTrimmedString(groupSummaryKey);     // Catch: Throwable -> L18
        this.mPersistedSnoozedNotificationsWithContext.remove(trimmedKey);     // Catch: Throwable -> L18
        this.mPersistedSnoozedNotifications.remove(trimmedKey);     // Catch: Throwable -> L18
        if (record == null) goto L27;
        if (record.isCanceled == true) goto L27;
        Runnable runnable = new SnoozeHelper$$ExternalSyntheticLambda1(this, record);     // Catch: Throwable -> L18
        runnable.run();     // Catch: Throwable -> L18
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$repostGroupSummary$0(NotificationRecord record) {
        MetricsLogger.action(record.getLogMaker().setCategory(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_SESSION).setType(1));
        this.mCallback.repost(record.getUserId(), record, false);
    }

    protected void clearData(int userId, String pkg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int n = this.mSnoozedNotifications.size();     // Catch: Throwable -> L11
        int i = n - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        final NotificationRecord record = this.mSnoozedNotifications.valueAt(i);     // Catch: Throwable -> L11
        if (record.getUserId() != userId) goto L13;
        if (record.getSbn().getPackageName().equals(pkg) == false) goto L13;
        this.mSnoozedNotifications.removeAt(i);     // Catch: Throwable -> L11
        String trimmedKey = getTrimmedString(record.getKey());     // Catch: Throwable -> L11
        this.mPersistedSnoozedNotificationsWithContext.remove(trimmedKey);     // Catch: Throwable -> L11
        this.mPersistedSnoozedNotifications.remove(trimmedKey);     // Catch: Throwable -> L11
        Runnable runnable = new SnoozeHelper$$ExternalSyntheticLambda0(this, record);     // Catch: Throwable -> L11
        runnable.run();     // Catch: Throwable -> L11
    L13:
        i = i - 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$clearData$1(NotificationRecord record) {
        PendingIntent pi = createPendingIntent(record.getKey());
        this.mAm.cancel(pi);
        MetricsLogger.action(record.getLogMaker().setCategory(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_SESSION).setType(5));
    }

    protected void clearData(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int n = this.mSnoozedNotifications.size();     // Catch: Throwable -> L9
        int i = n - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        final NotificationRecord record = this.mSnoozedNotifications.valueAt(i);     // Catch: Throwable -> L9
        if (record.getUserId() != userId) goto L11;
        this.mSnoozedNotifications.removeAt(i);     // Catch: Throwable -> L9
        String trimmedKey = getTrimmedString(record.getKey());     // Catch: Throwable -> L9
        this.mPersistedSnoozedNotificationsWithContext.remove(trimmedKey);     // Catch: Throwable -> L9
        this.mPersistedSnoozedNotifications.remove(trimmedKey);     // Catch: Throwable -> L9
        Runnable runnable = new SnoozeHelper$$ExternalSyntheticLambda4(this, record);     // Catch: Throwable -> L9
        runnable.run();     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$clearData$2(NotificationRecord record) {
        PendingIntent pi = createPendingIntent(record.getKey());
        this.mAm.cancel(pi);
        MetricsLogger.action(record.getLogMaker().setCategory(FrameworkStatsLog.SENSITIVE_NOTIFICATION_APP_PROTECTION_SESSION).setType(5));
    }

    private PendingIntent createPendingIntent(String key) {
        return PendingIntent.getBroadcast(this.mContext, 1, new Intent(REPOST_ACTION).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).setData(new Uri.Builder().scheme(REPOST_SCHEME).appendPath(key).build()).addFlags(268435456).putExtra("key", key), AudioFormat.DTS_HD);
    }

    public void scheduleRepostsForPersistedNotifications(long currentTime) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L20:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPersistedSnoozedNotifications.size()) goto L16;
        String key = this.mPersistedSnoozedNotifications.keyAt(i);     // Catch: Throwable -> L12
        Long time = this.mPersistedSnoozedNotifications.valueAt(i);     // Catch: Throwable -> L12
        if (time == null) goto L14;
        if (time.longValue() <= currentTime) goto L14;
        scheduleRepostAtTime(key, time.longValue());     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L20
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    private void scheduleRepost(String key, long duration) {
        scheduleRepostAtTime(key, System.currentTimeMillis() + duration);
    }

    private void scheduleRepostAtTime(final String key, final long time) {
        Runnable runnable = new SnoozeHelper$$ExternalSyntheticLambda5(this, key, time);
        runnable.run();
    }

    private /* synthetic */ void lambda$scheduleRepostAtTime$3(String key, long time) {
        long identity = Binder.clearCallingIdentity();
        PendingIntent pi = createPendingIntent(key);     // Catch: Throwable -> L6
        this.mAm.cancel(pi);     // Catch: Throwable -> L6
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Scheduling evaluate for " + new Date(time));     // Catch: Throwable -> L6
    L8:
        this.mAm.setExactAndAllowWhileIdle(0, time, pi);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void dump(PrintWriter pw, NotificationManagerService.DumpFilter filter) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("\n  Snoozed notifications:");     // Catch: Throwable -> L8
        Iterator<String> r1 = this.mSnoozedNotifications.keySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        String key = r1.next();     // Catch: Throwable -> L8
        pw.print(INDENT);     // Catch: Throwable -> L8
        pw.println("key: " + key);     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.println("\n Pending snoozed notifications");     // Catch: Throwable -> L8
        Iterator<String> r2 = this.mPersistedSnoozedNotifications.keySet().iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L14;
        String key2 = r2.next();     // Catch: Throwable -> L8
        pw.print(INDENT);     // Catch: Throwable -> L8
        pw.println("key: " + key2 + " until: " + this.mPersistedSnoozedNotifications.get(key2));     // Catch: Throwable -> L8
        goto L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    protected void writeXml(final TypedXmlSerializer out) throws IOException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        final long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L7
        out.startTag(null, XML_TAG_NAME);     // Catch: Throwable -> L7
        writeXml(out, this.mPersistedSnoozedNotifications, XML_SNOOZED_NOTIFICATION, new SnoozeHelper$$ExternalSyntheticLambda2(currentTime, out));     // Catch: Throwable -> L7
        writeXml(out, this.mPersistedSnoozedNotificationsWithContext, XML_SNOOZED_NOTIFICATION_CONTEXT, new SnoozeHelper$$ExternalSyntheticLambda3(out));     // Catch: Throwable -> L7
        out.endTag(null, XML_TAG_NAME);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$writeXml$4(long currentTime, TypedXmlSerializer out, Long value) throws IOException {
        if (value.longValue() >= currentTime) goto L5;
        return;
    L5:
        out.attributeLong(null, XML_SNOOZED_NOTIFICATION_TIME, value.longValue());
    }

    private static /* synthetic */ void lambda$writeXml$5(TypedXmlSerializer out, String value) throws IOException {
        out.attribute(null, XML_SNOOZED_NOTIFICATION_CONTEXT_ID, value);
    }

    private <T> void writeXml(TypedXmlSerializer out, ArrayMap<String, T> targets, String tag, Inserter<T> attributeInserter) throws IOException {
        int j = 0;
    L4:
        if (j >= targets.size()) goto L7;
        String key = targets.keyAt(j);
        T value = targets.valueAt(j);
        out.startTag(null, tag);
        attributeInserter.insert(value);
        out.attributeInt(null, XML_SNOOZED_NOTIFICATION_VERSION_LABEL, 1);
        out.attribute(null, "key", key);
        out.endTag(null, tag);
        j = j + 1;
        goto L4
    }

    protected void readXml(TypedXmlPullParser parser, long currentTime) throws XmlPullParserException, IOException {
    L2:
        int type = parser.next();
        if (type == 1) goto L44;
        String tag = parser.getName();
        if (type != 3) goto L10;
        if (XML_TAG_NAME.equals(tag) == false) goto L10;
        return;
    L10:
        if (type != 2) goto L2;
        if (XML_SNOOZED_NOTIFICATION.equals(tag) == true) goto L16;
        if (tag.equals(XML_SNOOZED_NOTIFICATION_CONTEXT) == false) goto L2;
    L16:
        if (parser.getAttributeInt(null, XML_SNOOZED_NOTIFICATION_VERSION_LABEL, -1) != 1) goto L2;
        String key = parser.getAttributeValue(null, "key");     // Catch: Exception -> L29
        if (tag.equals(XML_SNOOZED_NOTIFICATION) == false) goto L32;
        Long time = Long.valueOf(parser.getAttributeLong(null, XML_SNOOZED_NOTIFICATION_TIME, 0));     // Catch: Exception -> L29
        if (time.longValue() <= currentTime) goto L32;
        Object r5 = this.mLock;     // Catch: Exception -> L29
        monitor-enter(r5);     // Catch: Exception -> L29
        this.mPersistedSnoozedNotifications.put(key, time);     // Catch: Throwable -> L26
        monitor-exit(r5);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Exception -> L29
    L32:
        if (tag.equals(XML_SNOOZED_NOTIFICATION_CONTEXT) == false) goto L2;
        String creationId = parser.getAttributeValue(null, XML_SNOOZED_NOTIFICATION_CONTEXT_ID);     // Catch: Exception -> L29
        Object r4 = this.mLock;     // Catch: Exception -> L29
        monitor-enter(r4);     // Catch: Exception -> L29
        this.mPersistedSnoozedNotificationsWithContext.put(key, creationId);     // Catch: Throwable -> L38
        monitor-exit(r4);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Slog.e(TAG, "Exception in reading snooze data from policy xml", e);
        goto L2
    }

    void setAlarmManager(AlarmManager am) {
        this.mAm = am;
    }
}
