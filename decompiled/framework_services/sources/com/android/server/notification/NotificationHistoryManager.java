package com.android.server.notification;

import android.app.NotificationHistory;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.server.IoThread;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationHistoryManager {
    private static final boolean DEBUG = false;
    static final String DIRECTORY_PER_USER = "notification_history";
    private static final String TAG = "NotificationHistory";
    private final Context mContext;
    private final SparseBooleanArray mHistoryEnabled;
    private final Object mLock;
    final SettingsObserver mSettingsObserver;
    private final UserManager mUserManager;
    private final SparseBooleanArray mUserPendingHistoryDisables;
    private final SparseArray<List<String>> mUserPendingPackageRemovals;
    private final SparseArray<NotificationHistoryDatabase> mUserState;
    private final SparseBooleanArray mUserUnlockedStates;

    final class SettingsObserver extends ContentObserver {
        private final Uri NOTIFICATION_HISTORY_URI;
        final /* synthetic */ NotificationHistoryManager this$0;

        SettingsObserver(NotificationHistoryManager this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
            this.NOTIFICATION_HISTORY_URI = Settings.Secure.getUriFor("notification_history_enabled");
        }

        void observe() {
            ContentResolver resolver = NotificationHistoryManager.m6122$$Nest$fgetmContext(this.this$0).getContentResolver();
            resolver.registerContentObserver(this.NOTIFICATION_HISTORY_URI, false, this, -1);
            Object r1 = NotificationHistoryManager.m6123$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            Iterator r2 = NotificationHistoryManager.m6124$$Nest$fgetmUserManager(this.this$0).getUsers().iterator();     // Catch: Throwable -> L8
        L6:
            if (r2.hasNext() == false) goto L10;
            UserInfo userInfo = (UserInfo) r2.next();     // Catch: Throwable -> L8
            update(null, userInfo.id);     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        void stopObserving() {
            ContentResolver resolver = NotificationHistoryManager.m6122$$Nest$fgetmContext(this.this$0).getContentResolver();
            resolver.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            update(uri, userId);
        }

        public void update(Uri uri, int userId) {
            ContentResolver resolver = NotificationHistoryManager.m6122$$Nest$fgetmContext(this.this$0).getContentResolver();
            if (uri != null) goto L5;
        L6:
            boolean historyEnabled = false;
            if (Settings.Secure.getIntForUser(resolver, "notification_history_enabled", 0, userId) == 0) goto L9;
            historyEnabled = true;
        L9:
            this.this$0.onHistoryEnabledChanged(userId, historyEnabled);
            return;
        L5:
            if (this.NOTIFICATION_HISTORY_URI.equals(uri) == true) goto L6;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$h_Z1DxUiaHb-t4mnDIKe8ap8bgM, reason: not valid java name */
    public static /* synthetic */ void m6121$r8$lambda$h_Z1DxUiaHbt4mnDIKe8ap8bgM(NotificationHistoryManager r0, NotificationHistory.HistoricalNotification r1) {
        r0.lambda$addNotification$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6122$$Nest$fgetmContext(NotificationHistoryManager r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6123$$Nest$fgetmLock(NotificationHistoryManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m6124$$Nest$fgetmUserManager(NotificationHistoryManager r0) {
        return r0.mUserManager;
    }

    static {
        DEBUG = NotificationManagerService.DBG;
    }

    public NotificationHistoryManager(Context context, Handler handler) {
        this.mLock = new Object();
        this.mUserState = new SparseArray();
        this.mUserUnlockedStates = new SparseBooleanArray();
        this.mUserPendingPackageRemovals = new SparseArray();
        this.mHistoryEnabled = new SparseBooleanArray();
        this.mUserPendingHistoryDisables = new SparseBooleanArray();
        this.mContext = context;
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        this.mSettingsObserver = new SettingsObserver(this, handler);
    }

    void onDestroy() {
        this.mSettingsObserver.stopObserving();
    }

    void onBootPhaseAppsCanStart() {
        NotificationHistoryJobService.scheduleJob(this.mContext);     // Catch: Throwable -> L4
    L6:
        this.mSettingsObserver.observe();
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to schedule cleanup job", e);
        goto L6
    }

    void onUserUnlocked(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserUnlockedStates.put(userId, true);     // Catch: Throwable -> L9
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(userId);     // Catch: Throwable -> L9
        if (userHistory != null) goto L11;
        Slog.i(TAG, "Attempted to unlock gone/disabled user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        List<String> pendingPackageRemovals = this.mUserPendingPackageRemovals.get(userId);     // Catch: Throwable -> L9
        if (pendingPackageRemovals == null) goto L19;
        int i = 0;
    L15:
        if (i >= pendingPackageRemovals.size()) goto L17;
        userHistory.onPackageRemoved(pendingPackageRemovals.get(i));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L15
    L17:
        this.mUserPendingPackageRemovals.remove(userId);     // Catch: Throwable -> L9
    L19:
        if (this.mUserPendingHistoryDisables.get(userId) == false) goto L21;
        disableHistory(userHistory, userId);     // Catch: Throwable -> L9
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void onUserAdded(int userId) {
        this.mSettingsObserver.update(null, userId);
    }

    public void onUserStopped(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserUnlockedStates.put(userId, false);     // Catch: Throwable -> L7
        this.mUserState.put(userId, null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserPendingPackageRemovals.remove(userId);     // Catch: Throwable -> L7
        this.mHistoryEnabled.put(userId, false);     // Catch: Throwable -> L7
        this.mUserPendingHistoryDisables.put(userId, false);     // Catch: Throwable -> L7
        onUserStopped(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onPackageRemoved(int userId, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserUnlockedStates.get(userId, false) == false) goto L7;
        NotificationHistoryDatabase userHistory = this.mUserState.get(userId);     // Catch: Throwable -> L9
        if (userHistory != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L17:
        userHistory.onPackageRemoved(packageName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mHistoryEnabled.get(userId, false) == false) goto L11;
        List<String> userPendingRemovals = this.mUserPendingPackageRemovals.get(userId, new ArrayList());     // Catch: Throwable -> L9
        userPendingRemovals.add(packageName);     // Catch: Throwable -> L9
        this.mUserPendingPackageRemovals.put(userId, userPendingRemovals);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void cleanupHistoryFiles() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int n = this.mUserUnlockedStates.size();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= n) goto L16;
        if (this.mUserUnlockedStates.valueAt(i) == false) goto L14;
        NotificationHistoryDatabase userHistory = this.mUserState.get(this.mUserUnlockedStates.keyAt(i));     // Catch: Throwable -> L12
        if (userHistory == null) goto L14;
        userHistory.prune();     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void deleteNotificationHistoryItem(String pkg, int uid, long postedTime) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L9
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(userId);     // Catch: Throwable -> L9
        if (userHistory != null) goto L11;
        Slog.w(TAG, "Attempted to remove notif for locked/gone/disabled user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        userHistory.deleteNotificationHistoryItem(pkg, postedTime);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void deleteConversations(String pkg, int uid, Set<String> conversationIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L9
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(userId);     // Catch: Throwable -> L9
        if (userHistory != null) goto L11;
        Slog.w(TAG, "Attempted to remove conversation for locked/gone/disabled user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        userHistory.deleteConversations(pkg, conversationIds);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void deleteNotificationChannel(String pkg, int uid, String channelId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L9
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(userId);     // Catch: Throwable -> L9
        if (userHistory != null) goto L11;
        Slog.w(TAG, "Attempted to remove channel for locked/gone/disabled user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        userHistory.deleteNotificationChannel(pkg, channelId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void triggerWriteToDisk() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userCount = this.mUserState.size();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= userCount) goto L16;
        int userId = this.mUserState.keyAt(i);     // Catch: Throwable -> L12
        if (this.mUserUnlockedStates.get(userId) == false) goto L14;
        NotificationHistoryDatabase userHistory = this.mUserState.get(userId);     // Catch: Throwable -> L12
        if (userHistory == null) goto L14;
        userHistory.forceWriteToDisk();     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void addNotification(final NotificationHistory.HistoricalNotification notification) {
        Binder.withCleanCallingIdentity(new NotificationHistoryManager$$ExternalSyntheticLambda0(this, notification));
    }

    private /* synthetic */ void lambda$addNotification$0(NotificationHistory.HistoricalNotification notification) throws Exception {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(notification.getUserId());     // Catch: Throwable -> L9
        if (userHistory != null) goto L11;
        Slog.w(TAG, "Attempted to add notif for locked/gone/disabled user " + notification.getUserId());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        userHistory.addNotification(notification);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public NotificationHistory readNotificationHistory(int[] userIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NotificationHistory mergedHistory = new NotificationHistory();     // Catch: Throwable -> L8
        if (userIds != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return mergedHistory;
    L10:
        int r2 = userIds.length;     // Catch: Throwable -> L8
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L17;
        int userId = userIds[r3];     // Catch: Throwable -> L8
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(userId);     // Catch: Throwable -> L8
        if (userHistory != null) goto L15;
        Slog.i(TAG, "Attempted to read history for locked/gone/disabled user " + userId);     // Catch: Throwable -> L8
    L16:
        r3 = r3 + 1;     // Catch: Throwable -> L8
        goto L11
    L15:
        mergedHistory.addNotificationsToWrite(userHistory.readNotificationHistory());     // Catch: Throwable -> L8
        goto L16
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return mergedHistory;
    L8:
        th = move-exception;
        throw th;
    }

    public NotificationHistory readFilteredNotificationHistory(int userId, String packageName, String channelId, int maxNotifications) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(userId);     // Catch: Throwable -> L9
        if (userHistory != null) goto L11;
        Slog.i(TAG, "Attempted to read history for locked/gone/disabled user " + userId);     // Catch: Throwable -> L9
        NotificationHistory r2 = new NotificationHistory();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        NotificationHistory r3 = userHistory.readNotificationHistory(packageName, channelId, maxNotifications);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    boolean isHistoryEnabled(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mHistoryEnabled.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void onHistoryEnabledChanged(int userId, boolean historyEnabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (historyEnabled == true) goto L21;
    L8:
        NotificationHistoryDatabase userHistory = getUserHistoryAndInitializeIfNeededLocked(userId);     // Catch: Throwable -> L6
        if (userHistory == null) goto L12;
        if (historyEnabled == true) goto L17;
        disableHistory(userHistory, userId);     // Catch: Throwable -> L6
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L12:
        SparseBooleanArray r2 = this.mUserPendingHistoryDisables;     // Catch: Throwable -> L6
        if (historyEnabled == true) goto L15;
        boolean r3 = true;
    L16:
        r2.put(userId, r3);     // Catch: Throwable -> L6
        goto L17
    L15:
        r3 = false;
        goto L16
    L21:
        this.mHistoryEnabled.put(userId, historyEnabled);     // Catch: Throwable -> L6
        goto L8
    }

    private void disableHistory(NotificationHistoryDatabase userHistory, int userId) {
        userHistory.disableHistory();
        this.mUserPendingHistoryDisables.put(userId, false);
        this.mHistoryEnabled.put(userId, false);
        this.mUserState.put(userId, null);
    }

    private NotificationHistoryDatabase getUserHistoryAndInitializeIfNeededLocked(int userId) {
        if (this.mHistoryEnabled.get(userId) == false) goto L5;
        NotificationHistoryDatabase userHistory = this.mUserState.get(userId);
        if (userHistory != null) goto L23;
        File historyDir = new File(Environment.getDataSystemCeDirectory(userId), DIRECTORY_PER_USER);
        userHistory = NotificationHistoryDatabaseFactory.create(this.mContext, IoThread.getHandler(), historyDir);
        if (this.mUserUnlockedStates.get(userId) == true) goto L24;
        Slog.w(TAG, "Attempted to initialize service for stopped or removed user " + userId);
        return null;
    L24:
        userHistory.init();     // Catch: Exception -> L15
        this.mUserState.put(userId, userHistory);
    L15:
        e = move-exception;
        if (this.mUserManager.isUserUnlocked(userId) == true) goto L20;
        Slog.w(TAG, "Attempted to initialize service for stopped or removed user " + userId);
        return null;
    L20:
        throw e;
    L23:
        return userHistory;
    L5:
        if (DEBUG == false) goto L7;
        Slog.i(TAG, "History disabled for user " + userId);
    L7:
        this.mUserState.put(userId, null);
        return null;
    }

    boolean isUserUnlocked(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mUserUnlockedStates.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean doesHistoryExistForUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserState.get(userId) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void replaceNotificationHistoryDatabase(int userId, NotificationHistoryDatabase replacement) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserState.get(userId) == null) goto L9;
        this.mUserState.put(userId, replacement);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    List<String> getPendingPackageRemovalsForUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<String> r1 = this.mUserPendingPackageRemovals.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
