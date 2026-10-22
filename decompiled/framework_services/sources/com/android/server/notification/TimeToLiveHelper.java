package com.android.server.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Pair;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class TimeToLiveHelper {
    private static final String ACTION = "com.android.server.notification.TimeToLiveHelper";
    static final String EXTRA_KEY = "key";
    private static final int REQUEST_CODE_TIMEOUT = 1;
    private static final String SCHEME_TIMEOUT = "timeout";
    private static final String TAG = null;
    private final AlarmManager mAm;
    private final Context mContext;
    final TreeSet<Pair<Long, String>> mKeys;
    final Object mLock;
    private final NotificationManagerPrivate mNm;
    final BroadcastReceiver mNotificationTimeoutReceiver;

    /* JADX INFO: renamed from: $r8$lambda$-66tMOc0eo_h6TkGlRyu-muFTqg, reason: not valid java name */
    public static /* synthetic */ int m6289$r8$lambda$66tMOc0eo_h6TkGlRyumuFTqg(Pair r0, Pair r1) {
        return lambda$new$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNm, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManagerPrivate m6290$$Nest$fgetmNm(TimeToLiveHelper r0) {
        return r0.mNm;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveMatchingEntry, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6291$$Nest$mremoveMatchingEntry(TimeToLiveHelper r0, String r1) {
        r0.removeMatchingEntry(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6292$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = TimeToLiveHelper.class.getSimpleName();
    }

    public TimeToLiveHelper(NotificationManagerPrivate nm, Context context) {
        this.mLock = new Object();
        this.mNotificationTimeoutReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mNm = nm;
        this.mAm = (AlarmManager) context.getSystemService(AlarmManager.class);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mKeys = new TreeSet(new TimeToLiveHelper$$ExternalSyntheticLambda0());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        IntentFilter timeoutFilter = new IntentFilter(ACTION);
        timeoutFilter.addDataScheme(SCHEME_TIMEOUT);
        this.mContext.registerReceiver(this.mNotificationTimeoutReceiver, timeoutFilter, 4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ int lambda$new$0(Pair left, Pair right) {
        return Long.compare(((Long) left.first).longValue(), ((Long) right.first).longValue());
    }

    void destroy() {
        this.mContext.unregisterReceiver(this.mNotificationTimeoutReceiver);
    }

    void dump(PrintWriter pw, String indent) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println(indent + "mKeys " + this.mKeys);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private PendingIntent getAlarmPendingIntent(String nextKey, int flags) {
        Context r0 = this.mContext;
        Intent r1 = new Intent(ACTION).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).setData(new Uri.Builder().scheme(SCHEME_TIMEOUT).appendPath(nextKey).build()).putExtra(EXTRA_KEY, nextKey).addFlags(268435456);
        return PendingIntent.getBroadcast(r0, 1, r1, flags | 67108864);
    }

    void scheduleTimeoutLocked(NotificationRecord record, long currentTime) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeMatchingEntry(record.getKey());     // Catch: Throwable -> L15
        long timeoutAfter = record.getNotification().getTimeoutAfter() + currentTime;     // Catch: Throwable -> L15
        if (record.getNotification().getTimeoutAfter() > 0) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        if (this.mKeys.isEmpty() == false) goto L9;
        Long currentEarliestTime = null;
    L10:
        if (currentEarliestTime == null) goto L17;
        if (timeoutAfter < currentEarliestTime.longValue()) goto L17;
        this.mKeys.add(Pair.create(Long.valueOf(timeoutAfter), record.getKey()));     // Catch: Throwable -> L15
    L17:
        if (currentEarliestTime == null) goto L19;
        cancelFirstAlarm();     // Catch: Throwable -> L15
    L19:
        this.mKeys.add(Pair.create(Long.valueOf(timeoutAfter), record.getKey()));     // Catch: Throwable -> L15
        maybeScheduleFirstAlarm();     // Catch: Throwable -> L15
        goto L20
    L9:
        currentEarliestTime = (Long) this.mKeys.first().first;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    void cancelScheduledTimeoutLocked(NotificationRecord record) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeMatchingEntry(record.getKey());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeMatchingEntry(String key) {
        if (this.mKeys.isEmpty() == false) goto L5;
    L7:
        Pair<Long, String> trackedPair = null;
        Iterator<Pair<Long, String>> r1 = this.mKeys.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        Pair<Long, String> entry = r1.next();
        if (key.equals(entry.second) == false) goto L9;
        trackedPair = entry;
    L14:
        if (trackedPair == null) goto L21;
        this.mKeys.remove(trackedPair);
        return;
    L21:
        return;
    L5:
        if (key.equals(this.mKeys.first().second) == false) goto L7;
        cancelFirstAlarm();
        this.mKeys.remove(this.mKeys.first());
        maybeScheduleFirstAlarm();
    }

    private void cancelFirstAlarm() {
        PendingIntent pi = getAlarmPendingIntent((String) this.mKeys.first().second, 268435456);
        this.mAm.cancel(pi);
    }

    private void maybeScheduleFirstAlarm() {
        if (this.mKeys.isEmpty() == true) goto L6;
        PendingIntent piNewFirst = getAlarmPendingIntent((String) this.mKeys.first().second, 134217728);
        this.mAm.setExactAndAllowWhileIdle(2, ((Long) this.mKeys.first().first).longValue(), piNewFirst);
        return;
    }
}
