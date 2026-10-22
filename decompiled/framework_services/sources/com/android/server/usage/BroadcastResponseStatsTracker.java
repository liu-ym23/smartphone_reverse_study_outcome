package com.android.server.usage;

import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.app.usage.BroadcastResponseStats;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.LongArrayQueue;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.IndentingPrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class BroadcastResponseStatsTracker {
    static final int NOTIFICATION_EVENT_TYPE_CANCELLED = 2;
    static final int NOTIFICATION_EVENT_TYPE_POSTED = 0;
    static final int NOTIFICATION_EVENT_TYPE_UPDATED = 1;
    static final String TAG = "ResponseStatsTracker";
    private AppStandbyInternal mAppStandby;
    private final Context mContext;
    private SparseArray<ArrayMap<String, List<String>>> mExemptedRoleHoldersCache;
    private final Object mLock;
    private BroadcastResponseStatsLogger mLogger;
    private final OnRoleHoldersChangedListener mRoleHoldersChangedListener;
    private RoleManager mRoleManager;
    private SparseArray<UserBroadcastEvents> mUserBroadcastEvents;
    private SparseArray<SparseArray<UserBroadcastResponseStats>> mUserResponseStats;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationEventType {
    }

    public static /* synthetic */ void $r8$lambda$q3U5spRGQ0QcFJiTSLlmc7ZqWdE(BroadcastResponseStatsTracker r0, String r1, UserHandle r2) {
        r0.onRoleHoldersChanged(r1, r2);
    }

    BroadcastResponseStatsTracker(AppStandbyInternal appStandby, Context context) {
        this.mLock = new Object();
        this.mUserBroadcastEvents = new SparseArray();
        this.mUserResponseStats = new SparseArray();
        this.mExemptedRoleHoldersCache = new SparseArray();
        this.mRoleHoldersChangedListener = new BroadcastResponseStatsTracker$$ExternalSyntheticLambda0(this);
        this.mAppStandby = appStandby;
        this.mContext = context;
        this.mLogger = new BroadcastResponseStatsLogger();
    }

    void onSystemServicesReady(Context context) {
        this.mRoleManager = (RoleManager) context.getSystemService(RoleManager.class);
        this.mRoleManager.addOnRoleHoldersChangedListenerAsUser(BackgroundThread.getExecutor(), this.mRoleHoldersChangedListener, UserHandle.ALL);
    }

    void reportBroadcastDispatchEvent(int sourceUid, String targetPackage, UserHandle targetUser, long idForResponseEvent, long timestampMs, int targetUidProcState) {
        this.mLogger.logBroadcastDispatchEvent(sourceUid, targetPackage, targetUser, idForResponseEvent, timestampMs, targetUidProcState);
        if (targetUidProcState > this.mAppStandby.getBroadcastResponseFgThresholdState()) goto L6;
        return;
    L6:
        if (doesPackageHoldExemptedRole(targetPackage, targetUser) == false) goto L9;
        return;
    L9:
        if (doesPackageHoldExemptedPermission(targetPackage, targetUser) == false) goto L11;
        return;
    L11:
        Object r9 = this.mLock;
        monitor-enter(r9);
        ArraySet<BroadcastEvent> broadcastEvents = getOrCreateBroadcastEventsLocked(targetPackage, targetUser);     // Catch: Throwable -> L20
        BroadcastEvent broadcastEvent = getOrCreateBroadcastEvent(broadcastEvents, sourceUid, targetPackage, targetUser.getIdentifier(), idForResponseEvent);     // Catch: Throwable -> L20
        broadcastEvent.addTimestampMs(timestampMs);     // Catch: Throwable -> L18
        recordAndPruneOldBroadcastDispatchTimestamps(broadcastEvent);     // Catch: Throwable -> L18
        monitor-exit(r9);     // Catch: Throwable -> L18
        return;
    L18:
        th = th;
    L22:
        monitor-exit(r9);     // Catch: Throwable -> L18
        throw th;
    L20:
        th = th;
        goto L22
    }

    void reportNotificationPosted(String packageName, UserHandle user, long timestampMs) {
        reportNotificationEvent(0, packageName, user, timestampMs);
    }

    void reportNotificationUpdated(String packageName, UserHandle user, long timestampMs) {
        reportNotificationEvent(1, packageName, user, timestampMs);
    }

    void reportNotificationCancelled(String packageName, UserHandle user, long timestampMs) {
        reportNotificationEvent(2, packageName, user, timestampMs);
    }

    private void reportNotificationEvent(int event, String packageName, UserHandle user, long timestampMs) {
        BroadcastResponseStatsTracker r1 = this;
        r1.mLogger.logNotificationEvent(event, packageName, user, timestampMs);
        Object r2 = r1.mLock;
        monitor-enter(r2);
        ArraySet<BroadcastEvent> broadcastEvents = r1.getBroadcastEventsLocked(packageName, user);     // Catch: Throwable -> L9
        if (broadcastEvents != null) goto L11;
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L11:
        long broadcastResponseWindowDurationMs = r1.mAppStandby.getBroadcastResponseWindowDurationMs();     // Catch: Throwable -> L9
        long broadcastsSessionWithResponseDurationMs = r1.mAppStandby.getBroadcastSessionsWithResponseDurationMs();     // Catch: Throwable -> L9
        boolean recordAllBroadcastsSessionsWithinResponseWindow = r1.mAppStandby.shouldNoteResponseEventForAllBroadcastSessions();     // Catch: Throwable -> L9
        int r12 = 1;
        int i = broadcastEvents.size() - 1;     // Catch: Throwable -> L9
    L12:
        if (i < 0) goto L41;
        BroadcastEvent broadcastEvent = broadcastEvents.valueAt(i);     // Catch: Throwable -> L9
        r1.recordAndPruneOldBroadcastDispatchTimestamps(broadcastEvent);     // Catch: Throwable -> L9
        LongArrayQueue dispatchTimestampsMs = broadcastEvent.getTimestampsMs();     // Catch: Throwable -> L9
        long broadcastsSessionEndTimestampMs = 0;
    L15:
        if (dispatchTimestampsMs.size() <= 0) goto L37;
        if (dispatchTimestampsMs.peekFirst() > timestampMs) goto L37;
        long dispatchTimestampMs = dispatchTimestampsMs.peekFirst();     // Catch: Throwable -> L9
        long elapsedDurationMs = timestampMs - dispatchTimestampMs;     // Catch: Throwable -> L9
        if (elapsedDurationMs <= broadcastResponseWindowDurationMs) goto L21;
    L32:
        int r4 = r12;
    L33:
        dispatchTimestampsMs.removeFirst();     // Catch: Throwable -> L9
        r1 = this;
        r12 = r4;
        goto L15
    L21:
        if (dispatchTimestampMs < broadcastsSessionEndTimestampMs) goto L32;
        if (broadcastsSessionEndTimestampMs == 0) goto L26;
        if (recordAllBroadcastsSessionsWithinResponseWindow == false) goto L37;
    L26:
        BroadcastResponseStats responseStats = r1.getOrCreateBroadcastResponseStats(broadcastEvent);     // Catch: Throwable -> L9
        responseStats.incrementBroadcastsDispatchedCount(r12);     // Catch: Throwable -> L9
        broadcastsSessionEndTimestampMs = dispatchTimestampMs + broadcastsSessionWithResponseDurationMs;     // Catch: Throwable -> L9
        switch(event) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            default: goto L28;
        };     // Catch: Throwable -> L9
    L28:
        Slog.wtf(TAG, "Unknown event: " + event);     // Catch: Throwable -> L9
        r4 = 1;
        goto L33
    L29:
        r4 = 1;
        responseStats.incrementNotificationsCancelledCount(1);     // Catch: Throwable -> L9
        goto L33
    L30:
        r4 = r12;
        responseStats.incrementNotificationsUpdatedCount(r4);     // Catch: Throwable -> L9
        goto L33
    L31:
        r4 = r12;
        responseStats.incrementNotificationsPostedCount(r4);     // Catch: Throwable -> L9
    L37:
        if (dispatchTimestampsMs.size() != 0) goto L39;
        broadcastEvents.removeAt(i);     // Catch: Throwable -> L9
    L39:
        i = i - 1;     // Catch: Throwable -> L9
        r1 = this;
        r12 = r12;
        goto L12
    L41:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void recordAndPruneOldBroadcastDispatchTimestamps(BroadcastEvent broadcastEvent) {
        LongArrayQueue timestampsMs = broadcastEvent.getTimestampsMs();
        long broadcastResponseWindowDurationMs = this.mAppStandby.getBroadcastResponseWindowDurationMs();
        long broadcastsSessionDurationMs = this.mAppStandby.getBroadcastSessionsDurationMs();
        long nowElapsedMs = SystemClock.elapsedRealtime();
        long broadcastsSessionEndTimestampMs = 0;
    L4:
        if (timestampsMs.size() <= 0) goto L11;
        if (timestampsMs.peekFirst() >= (nowElapsedMs - broadcastResponseWindowDurationMs)) goto L16;
        long eventTimestampMs = timestampsMs.peekFirst();
        if (eventTimestampMs < broadcastsSessionEndTimestampMs) goto L10;
        BroadcastResponseStats responseStats = getOrCreateBroadcastResponseStats(broadcastEvent);
        responseStats.incrementBroadcastsDispatchedCount(1);
        broadcastsSessionEndTimestampMs = eventTimestampMs + broadcastsSessionDurationMs;
    L10:
        timestampsMs.removeFirst();
        goto L4
    L16:
        return;
    }

    List<BroadcastResponseStats> queryBroadcastResponseStats(int callingUid, String packageName, long id, int userId) {
        List<BroadcastResponseStats> broadcastResponseStatsList = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseArray<UserBroadcastResponseStats> responseStatsForCaller = this.mUserResponseStats.get(callingUid);     // Catch: Throwable -> L8
        if (responseStatsForCaller != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return broadcastResponseStatsList;
    L10:
        UserBroadcastResponseStats responseStatsForUser = responseStatsForCaller.get(userId);     // Catch: Throwable -> L8
        if (responseStatsForUser != null) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return broadcastResponseStatsList;
    L14:
        responseStatsForUser.populateAllBroadcastResponseStats(broadcastResponseStatsList, packageName, id);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return broadcastResponseStatsList;
    L8:
        th = move-exception;
        throw th;
    }

    void clearBroadcastResponseStats(int callingUid, String packageName, long id, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<UserBroadcastResponseStats> responseStatsForCaller = this.mUserResponseStats.get(callingUid);     // Catch: Throwable -> L8
        if (responseStatsForCaller != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        UserBroadcastResponseStats responseStatsForUser = responseStatsForCaller.get(userId);     // Catch: Throwable -> L8
        if (responseStatsForUser != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        responseStatsForUser.clearBroadcastResponseStats(packageName, id);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void clearBroadcastEvents(int callingUid, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserBroadcastEvents userBroadcastEvents = this.mUserBroadcastEvents.get(userId);     // Catch: Throwable -> L8
        if (userBroadcastEvents != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        userBroadcastEvents.clear(callingUid);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    boolean isPackageExemptedFromBroadcastResponseStats(String packageName, UserHandle user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (doesPackageHoldExemptedPermission(packageName, user) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L11:
        if (doesPackageHoldExemptedRole(packageName, user) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    boolean doesPackageHoldExemptedRole(String packageName, UserHandle user) {
        List<String> exemptedRoles = this.mAppStandby.getBroadcastResponseExemptedRoles();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = exemptedRoles.size() - 1;     // Catch: Throwable -> L10
    L5:
        if (i < 0) goto L14;
        String roleName = exemptedRoles.get(i);     // Catch: Throwable -> L10
        List<String> roleHolders = getRoleHoldersLocked(roleName, user);     // Catch: Throwable -> L10
        if (CollectionUtils.contains(roleHolders, packageName) == true) goto L8;
        i = i - 1;     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return true;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    boolean doesPackageHoldExemptedPermission(String packageName, UserHandle user) {
        int uid = this.mContext.getPackageManager().getPackageUidAsUser(packageName, user.getIdentifier());     // Catch: PackageManager.NameNotFoundException -> L12
        List<String> exemptedPermissions = this.mAppStandby.getBroadcastResponseExemptedPermissions();
        int i = exemptedPermissions.size() - 1;
    L5:
        if (i < 0) goto L11;
        String permissionName = exemptedPermissions.get(i);
        if (this.mContext.checkPermission(permissionName, -1, uid) == 0) goto L8;
        i = i - 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    L13:
        return false;
    }

    private List<String> getRoleHoldersLocked(String roleName, UserHandle user) {
        ArrayMap<String, List<String>> roleHoldersForUser = this.mExemptedRoleHoldersCache.get(user.getIdentifier());
        if (roleHoldersForUser != null) goto L5;
        roleHoldersForUser = new ArrayMap();
        this.mExemptedRoleHoldersCache.put(user.getIdentifier(), roleHoldersForUser);
    L5:
        List<String> roleHolders = roleHoldersForUser.get(roleName);
        if (roleHolders == null) goto L8;
        return roleHolders;
    L8:
        if (this.mRoleManager == null) goto L12;
        List roleHolders2 = this.mRoleManager.getRoleHoldersAsUser(roleName, user);
        roleHoldersForUser.put(roleName, roleHolders2);
        return roleHolders2;
    L12:
        return roleHolders;
    }

    private void onRoleHoldersChanged(String roleName, UserHandle user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, List<String>> roleHoldersForUser = this.mExemptedRoleHoldersCache.get(user.getIdentifier());     // Catch: Throwable -> L8
        if (roleHoldersForUser != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        roleHoldersForUser.remove(roleName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserBroadcastEvents.remove(userId);     // Catch: Throwable -> L7
        int i = this.mUserResponseStats.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L9;
        this.mUserResponseStats.valueAt(i).remove(userId);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mExemptedRoleHoldersCache.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onPackageRemoved(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserBroadcastEvents userBroadcastEvents = this.mUserBroadcastEvents.get(userId);     // Catch: Throwable -> L7
        if (userBroadcastEvents == null) goto L9;
        userBroadcastEvents.onPackageRemoved(packageName);     // Catch: Throwable -> L7
    L9:
        int i = this.mUserResponseStats.size() - 1;     // Catch: Throwable -> L7
    L10:
        if (i < 0) goto L16;
        UserBroadcastResponseStats userResponseStats = this.mUserResponseStats.valueAt(i).get(userId);     // Catch: Throwable -> L7
        if (userResponseStats == null) goto L14;
        userResponseStats.onPackageRemoved(packageName);     // Catch: Throwable -> L7
    L14:
        i = i - 1;     // Catch: Throwable -> L7
        goto L10
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onUidRemoved(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mUserBroadcastEvents.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L9;
        this.mUserBroadcastEvents.valueAt(i).onUidRemoved(uid);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mUserResponseStats.remove(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ArraySet<BroadcastEvent> getBroadcastEventsLocked(String packageName, UserHandle user) {
        UserBroadcastEvents userBroadcastEvents = this.mUserBroadcastEvents.get(user.getIdentifier());
        if (userBroadcastEvents != null) goto L7;
        return null;
    L7:
        return userBroadcastEvents.getBroadcastEvents(packageName);
    }

    private ArraySet<BroadcastEvent> getOrCreateBroadcastEventsLocked(String packageName, UserHandle user) {
        UserBroadcastEvents userBroadcastEvents = this.mUserBroadcastEvents.get(user.getIdentifier());
        if (userBroadcastEvents != null) goto L6;
        userBroadcastEvents = new UserBroadcastEvents();
        this.mUserBroadcastEvents.put(user.getIdentifier(), userBroadcastEvents);
    L6:
        return userBroadcastEvents.getOrCreateBroadcastEvents(packageName);
    }

    private BroadcastResponseStats getBroadcastResponseStats(SparseArray<UserBroadcastResponseStats> responseStatsForUid, BroadcastEvent broadcastEvent) {
        if (responseStatsForUid != null) goto L5;
        return null;
    L5:
        UserBroadcastResponseStats userResponseStats = responseStatsForUid.get(broadcastEvent.getTargetUserId());
        if (userResponseStats != null) goto L9;
        return null;
    L9:
        return userResponseStats.getBroadcastResponseStats(broadcastEvent);
    }

    private BroadcastResponseStats getOrCreateBroadcastResponseStats(BroadcastEvent broadcastEvent) {
        int sourceUid = broadcastEvent.getSourceUid();
        SparseArray<UserBroadcastResponseStats> userResponseStatsForUid = this.mUserResponseStats.get(sourceUid);
        if (userResponseStatsForUid != null) goto L5;
        userResponseStatsForUid = new SparseArray();
        this.mUserResponseStats.put(sourceUid, userResponseStatsForUid);
    L5:
        UserBroadcastResponseStats userResponseStats = userResponseStatsForUid.get(broadcastEvent.getTargetUserId());
        if (userResponseStats != null) goto L9;
        userResponseStats = new UserBroadcastResponseStats();
        userResponseStatsForUid.put(broadcastEvent.getTargetUserId(), userResponseStats);
    L9:
        return userResponseStats.getOrCreateBroadcastResponseStats(broadcastEvent);
    }

    private static BroadcastEvent getOrCreateBroadcastEvent(ArraySet<BroadcastEvent> broadcastEvents, int sourceUid, String targetPackage, int targetUserId, long idForResponseEvent) {
        BroadcastEvent broadcastEvent = new BroadcastEvent(sourceUid, targetPackage, targetUserId, idForResponseEvent);
        int index = broadcastEvents.indexOf(broadcastEvent);
        if (index >= 0) goto L5;
        broadcastEvents.add(broadcastEvent);
        return broadcastEvent;
    L5:
        return broadcastEvents.valueAt(index);
    }

    void dump(IndentingPrintWriter ipw) {
        ipw.println("Broadcast response stats:");
        ipw.increaseIndent();
        Object r0 = this.mLock;
        monitor-enter(r0);
        dumpBroadcastEventsLocked(ipw);     // Catch: Throwable -> L8
        ipw.println();     // Catch: Throwable -> L8
        dumpResponseStatsLocked(ipw);     // Catch: Throwable -> L8
        ipw.println();     // Catch: Throwable -> L8
        dumpRoleHoldersLocked(ipw);     // Catch: Throwable -> L8
        ipw.println();     // Catch: Throwable -> L8
        this.mLogger.dumpLogs(ipw);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ipw.decreaseIndent();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void dumpBroadcastEventsLocked(IndentingPrintWriter ipw) {
        ipw.println("Broadcast events:");
        ipw.increaseIndent();
        int i = 0;
    L4:
        if (i >= this.mUserBroadcastEvents.size()) goto L6;
        int userId = this.mUserBroadcastEvents.keyAt(i);
        UserBroadcastEvents userBroadcastEvents = this.mUserBroadcastEvents.valueAt(i);
        ipw.println("User " + userId + ":");
        ipw.increaseIndent();
        userBroadcastEvents.dump(ipw);
        ipw.decreaseIndent();
        i = i + 1;
        goto L4
    L6:
        ipw.decreaseIndent();
    }

    private void dumpResponseStatsLocked(IndentingPrintWriter ipw) {
        ipw.println("Response stats:");
        ipw.increaseIndent();
        int i = 0;
    L4:
        if (i >= this.mUserResponseStats.size()) goto L10;
        int sourceUid = this.mUserResponseStats.keyAt(i);
        SparseArray<UserBroadcastResponseStats> userBroadcastResponseStats = this.mUserResponseStats.valueAt(i);
        ipw.println("Uid " + sourceUid + ":");
        ipw.increaseIndent();
        int j = 0;
    L7:
        if (j >= userBroadcastResponseStats.size()) goto L9;
        int userId = userBroadcastResponseStats.keyAt(j);
        UserBroadcastResponseStats broadcastResponseStats = userBroadcastResponseStats.valueAt(j);
        ipw.println("User " + userId + ":");
        ipw.increaseIndent();
        broadcastResponseStats.dump(ipw);
        ipw.decreaseIndent();
        j = j + 1;
        goto L7
    L9:
        ipw.decreaseIndent();
        i = i + 1;
        goto L4
    L10:
        ipw.decreaseIndent();
    }

    private void dumpRoleHoldersLocked(IndentingPrintWriter ipw) {
        ipw.println("Role holders:");
        ipw.increaseIndent();
        int userIdx = 0;
    L4:
        if (userIdx >= this.mExemptedRoleHoldersCache.size()) goto L16;
        int userId = this.mExemptedRoleHoldersCache.keyAt(userIdx);
        ArrayMap<String, List<String>> roleHoldersForUser = this.mExemptedRoleHoldersCache.valueAt(userIdx);
        ipw.println("User " + userId + ":");
        ipw.increaseIndent();
        int roleIdx = 0;
    L7:
        if (roleIdx >= roleHoldersForUser.size()) goto L15;
        String roleName = roleHoldersForUser.keyAt(roleIdx);
        List<String> holders = roleHoldersForUser.valueAt(roleIdx);
        ipw.print(roleName + ": ");
        int holderIdx = 0;
    L10:
        if (holderIdx >= holders.size()) goto L14;
        if (holderIdx <= 0) goto L13;
        ipw.print(", ");
    L13:
        ipw.print(holders.get(holderIdx));
        holderIdx = holderIdx + 1;
        goto L10
    L14:
        ipw.println();
        roleIdx = roleIdx + 1;
        goto L7
    L15:
        ipw.decreaseIndent();
        userIdx = userIdx + 1;
        goto L4
    L16:
        ipw.decreaseIndent();
    }
}
