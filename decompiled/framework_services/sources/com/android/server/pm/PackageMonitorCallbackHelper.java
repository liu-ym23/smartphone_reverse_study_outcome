package com.android.server.pm;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IRemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
public class PackageMonitorCallbackHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "PackageMonitorCallbackHelper";
    IActivityManager mActivityManager;
    private final RemoteCallbackList<IRemoteCallback> mCallbacks;
    private final Object mLock;

    private final class RegisterUser {
        int mUid;
        int mUserId;

        RegisterUser(PackageMonitorCallbackHelper r1, int userId, int uid) {
            this.mUid = uid;
            this.mUserId = userId;
        }

        public int getUid() {
            return this.mUid;
        }

        public int getUserId() {
            return this.mUserId;
        }
    }

    public static /* synthetic */ void $r8$lambda$MNRzQYaV6JaxqeiTvi1sMiq30_4(int r0, ArrayList r1, IRemoteCallback r2, Object r3) {
        lambda$onUserRemoved$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Z5BB8H8hZPb-NY_2ywaCcSJdk6w, reason: not valid java name */
    public static /* synthetic */ void m6874$r8$lambda$Z5BB8H8hZPbNY_2ywaCcSJdk6w(PackageMonitorCallbackHelper r0, int r1, int[] r2, Intent r3, BiFunction r4) {
        r0.lambda$doNotifyCallbacks$2(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$aUWlqwCz-5h_-aMsuSrfdCoFYEM, reason: not valid java name */
    public static /* synthetic */ void m6875$r8$lambda$aUWlqwCz5h_aMsuSrfdCoFYEM(int r0, int[] r1, Intent r2, BiFunction r3, ArrayList r4, IRemoteCallback r5, Object r6) {
        lambda$doNotifyCallbacks$1(r0, r1, r2, r3, r4, r5, r6);
    }

    public PackageMonitorCallbackHelper() {
        this.mLock = new Object();
        this.mCallbacks = new RemoteCallbackList();
    }

    public void registerPackageMonitorCallback(IRemoteCallback callback, int userId, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCallbacks.register(callback, new RegisterUser(this, userId, uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterPackageMonitorCallback(IRemoteCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCallbacks.unregister(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUserRemoved(final int userId) {
        final ArrayList<IRemoteCallback> targetUnRegisteredCallbacks = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCallbacks.broadcast(new PackageMonitorCallbackHelper$$ExternalSyntheticLambda1(userId, targetUnRegisteredCallbacks));     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (targetUnRegisteredCallbacks.isEmpty() == true) goto L11;
        int count = targetUnRegisteredCallbacks.size();
        int i = 0;
    L9:
        if (i >= count) goto L18;
        unregisterPackageMonitorCallback(targetUnRegisteredCallbacks.get(i));
        i = i + 1;
        goto L9
    L18:
        return;
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$onUserRemoved$0(int userId, ArrayList targetUnRegisteredCallbacks, IRemoteCallback callback, Object user) {
        RegisterUser registerUser = (RegisterUser) user;
        if (registerUser.getUserId() != userId) goto L6;
        targetUnRegisteredCallbacks.add(callback);
        return;
    }

    public void notifyPackageAddedForNewUsers(String packageName, int appId, int[] userIds, int[] instantUserIds, boolean isArchived, int dataLoaderType, SparseArray<int[]> broadcastAllowList, Handler handler) {
        Bundle extras = new Bundle(2);
        if (ArrayUtils.isEmpty(userIds) == false) goto L5;
        int r0 = instantUserIds[0];
    L6:
        int uid = UserHandle.getUid(r0, appId);
        extras.putInt("android.intent.extra.UID", uid);
        if (isArchived == false) goto L9;
        extras.putBoolean("android.intent.extra.ARCHIVAL", true);
    L9:
        extras.putInt("android.content.pm.extra.DATA_LOADER_TYPE", dataLoaderType);
        notifyPackageMonitor("android.intent.action.PACKAGE_ADDED", packageName, extras, userIds, instantUserIds, broadcastAllowList, handler, null);
        return;
    L5:
        r0 = userIds[0];
        goto L6
    }

    public void notifyResourcesChanged(boolean mediaStatus, boolean replacing, String[] pkgNames, int[] uids, Handler handler) {
        Bundle extras = new Bundle();
        extras.putStringArray("android.intent.extra.changed_package_list", pkgNames);
        extras.putIntArray("android.intent.extra.changed_uid_list", uids);
        if (replacing == false) goto L5;
        extras.putBoolean("android.intent.extra.REPLACING", replacing);
    L5:
        if (mediaStatus == false) goto L7;
        String action = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    L8:
        notifyPackageMonitor(action, null, extras, null, null, null, handler, null);
        return;
    L7:
        action = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
        goto L8
    }

    public void notifyPackageChanged(String packageName, boolean dontKillApp, ArrayList<String> componentNames, int packageUid, String reason, int[] userIds, int[] instantUserIds, SparseArray<int[]> broadcastAllowList, Handler handler) {
        Bundle extras = new Bundle(4);
        extras.putString("android.intent.extra.changed_component_name", componentNames.get(0));
        String[] nameList = new String[componentNames.size()];
        componentNames.toArray(nameList);
        extras.putStringArray("android.intent.extra.changed_component_name_list", nameList);
        extras.putBoolean("android.intent.extra.DONT_KILL_APP", dontKillApp);
        extras.putInt("android.intent.extra.UID", packageUid);
        if (reason == null) goto L5;
        extras.putString("android.intent.extra.REASON", reason);
    L5:
        notifyPackageMonitor("android.intent.action.PACKAGE_CHANGED", packageName, extras, userIds, instantUserIds, broadcastAllowList, handler, null);
    }

    public void notifyPackageMonitor(String action, String pkg, Bundle extras, int[] userIds, int[] instantUserIds, SparseArray<int[]> broadcastAllowList, Handler handler, BiFunction<Integer, Bundle, Bundle> filterExtras) {
        if (isAllowedCallbackAction(action) == true) goto L5;
        return;
    L5:
        if (userIds == null) goto L22;
        int[] resolvedUserIds = userIds;
    L17:
        if (ArrayUtils.isEmpty(instantUserIds) == false) goto L19;
        doNotifyCallbacksByAction(action, pkg, extras, resolvedUserIds, broadcastAllowList, handler, filterExtras);     // Catch: RemoteException -> L9
        return;
    L19:
        doNotifyCallbacksByAction(action, pkg, extras, instantUserIds, broadcastAllowList, handler, filterExtras);     // Catch: RemoteException -> L9
        return;
    L22:
        if (this.mActivityManager != null) goto L12;
        this.mActivityManager = ActivityManager.getService();     // Catch: RemoteException -> L9
    L12:
        if (this.mActivityManager != null) goto L14;
        return;
    L14:
        resolvedUserIds = this.mActivityManager.getRunningUserIds();     // Catch: RemoteException -> L9
        goto L17
    }

    void notifyPackageMonitorWithIntent(Intent intent, int userId, int[] broadcastAllowList, Handler handler) {
        if (isAllowedCallbackAction(intent.getAction()) == true) goto L5;
        return;
    L5:
        doNotifyCallbacksByIntent(intent, userId, broadcastAllowList, handler);
    }

    private static boolean isAllowedCallbackAction(String action) {
        if (TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") == false) goto L5;
    L26:
        return true;
    L5:
        if (TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.PACKAGE_CHANGED") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.UID_REMOVED") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.PACKAGES_SUSPENDED") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.PACKAGES_UNSUSPENDED") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.PACKAGE_DATA_CLEARED") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.PACKAGE_RESTARTED") == true) goto L26;
        if (TextUtils.equals(action, "android.intent.action.PACKAGE_UNSTOPPED") == true) goto L26;
        return false;
    }

    private void doNotifyCallbacksByIntent(Intent intent, int userId, int[] broadcastAllowList, Handler handler) {
        doNotifyCallbacks(intent, userId, broadcastAllowList, handler, null);
    }

    private void doNotifyCallbacksByAction(String action, String pkg, Bundle extras, int[] userIds, SparseArray<int[]> broadcastAllowList, Handler handler, BiFunction<Integer, Bundle, Bundle> filterExtrasFunction) {
        int r2 = userIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L21;
        int userId = userIds[r3];
        int[] r4 = null;
        if (pkg == null) goto L7;
        Uri r7 = Uri.fromParts(Settings.ATTR_PACKAGE, pkg, null);
    L8:
        Intent intent = new Intent(action, r7);
        if (extras == null) goto L11;
        intent.putExtras(extras);
    L11:
        int uid = intent.getIntExtra("android.intent.extra.UID", -1);
        if (uid < 0) goto L17;
        if (UserHandle.getUserId(uid) == userId) goto L17;
        intent.putExtra("android.intent.extra.UID", UserHandle.getUid(userId, UserHandle.getAppId(uid)));
    L17:
        intent.putExtra("android.intent.extra.user_handle", userId);
        if (broadcastAllowList == null) goto L20;
        r4 = broadcastAllowList.get(userId);
    L20:
        int[] allowUids = r4;
        doNotifyCallbacks(intent, userId, allowUids, handler, filterExtrasFunction);
        r3 = r3 + 1;
        goto L3
    L7:
        r7 = null;
        goto L8
    }

    private void doNotifyCallbacks(final Intent intent, final int userId, final int[] allowUids, Handler handler, final BiFunction<Integer, Bundle, Bundle> filterExtrasFunction) {
        handler.post(new PackageMonitorCallbackHelper$$ExternalSyntheticLambda0(this, userId, allowUids, intent, filterExtrasFunction));
    }

    private /* synthetic */ void lambda$doNotifyCallbacks$2(final int userId, final int[] allowUids, final Intent intent, final BiFunction filterExtrasFunction) {
        final ArrayList<Pair<IRemoteCallback, Intent>> target = new ArrayList();
        Object r7 = this.mLock;
        monitor-enter(r7);
        RemoteCallbackList<IRemoteCallback> r0 = this.mCallbacks;     // Catch: Throwable -> L16
        r0.broadcast(new PackageMonitorCallbackHelper$$ExternalSyntheticLambda2(userId, allowUids, intent, filterExtrasFunction, target));     // Catch: Throwable -> L14
        monitor-exit(r7);     // Catch: Throwable -> L14
        int i = 0;
    L10:
        if (i >= target.size()) goto L13;
        Pair<IRemoteCallback, Intent> p = target.get(i);
        invokeCallback((IRemoteCallback) p.first, (Intent) p.second);
        i = i + 1;
        goto L10
    L13:
        return;
    L14:
        th = move-exception;
        Throwable r9 = th;
    L18:
        monitor-exit(r7);     // Catch: Throwable -> L14
        throw r9;
    L16:
        th = move-exception;
        r9 = th;
        goto L18
    }

    private static /* synthetic */ void lambda$doNotifyCallbacks$1(int userId, int[] allowUids, Intent intent, BiFunction filterExtrasFunction, ArrayList target, IRemoteCallback callback, Object user) {
        RegisterUser registerUser = (RegisterUser) user;
        if (registerUser.getUserId() != (-1)) goto L5;
    L7:
        int registerUid = registerUser.getUid();
        if (allowUids != null) goto L10;
    L14:
        Intent newIntent = intent;
        if (filterExtrasFunction == null) goto L22;
        Bundle extras = intent.getExtras();
        if (extras == null) goto L22;
        Bundle filteredExtras = (Bundle) filterExtrasFunction.apply(Integer.valueOf(registerUid), extras);
        if (filteredExtras != null) goto L21;
        return;
    L21:
        newIntent = new Intent(newIntent);
        newIntent.replaceExtras(filteredExtras);
    L22:
        target.add(new Pair(callback, newIntent));
        return;
    L10:
        if (UserHandle.isSameApp(registerUid, 1000) == true) goto L14;
        if (ArrayUtils.contains(allowUids, registerUid) == true) goto L14;
        return;
    L5:
        if (registerUser.getUserId() == userId) goto L7;
    }

    private void invokeCallback(IRemoteCallback callback, Intent intent) {
        Bundle bundle = new Bundle();     // Catch: RemoteException -> L4
        bundle.putParcelable("android.content.pm.extra.EXTRA_PACKAGE_MONITOR_CALLBACK_RESULT", intent);     // Catch: RemoteException -> L4
        callback.sendResult(bundle);     // Catch: RemoteException -> L4
        return;
    }
}
