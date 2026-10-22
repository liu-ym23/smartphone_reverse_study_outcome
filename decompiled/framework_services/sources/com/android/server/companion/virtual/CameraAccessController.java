package com.android.server.companion.virtual;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraInjectionSession;
import android.hardware.camera2.CameraManager;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class CameraAccessController extends CameraManager.AvailabilityCallback implements AutoCloseable {
    private static final String TAG = "CameraAccessController";
    private final ArrayMap<String, OpenCameraInfo> mAppsToBlockOnVirtualDevice;
    private final CameraAccessBlockedCallback mBlockedCallback;
    private final CameraManager mCameraManager;
    private final Context mContext;
    private final Object mLock;
    private int mObserverCount;
    private final Object mObserverLock;
    private final PackageManager mPackageManager;
    private final ArrayMap<String, InjectionSessionData> mPackageToSessionData;
    private final UserManager mUserManager;
    private final VirtualDeviceManagerInternal mVirtualDeviceManagerInternal;

    interface CameraAccessBlockedCallback {
        void onCameraAccessBlocked(int r1);
    }

    static class InjectionSessionData {
        public int appUid;
        public ArrayMap<String, CameraInjectionSession> cameraIdToSession;

        InjectionSessionData() {
            this.cameraIdToSession = new ArrayMap();
        }
    }

    static class OpenCameraInfo {
        public String packageName;
        public Set<Integer> packageUids;

        OpenCameraInfo() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$monInjectionError, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2975$$Nest$monInjectionError(CameraAccessController r0, String r1, String r2, int r3) {
        r0.onInjectionError(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monInjectionSucceeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2976$$Nest$monInjectionSucceeded(CameraAccessController r0, String r1, String r2, CameraInjectionSession r3) {
        r0.onInjectionSucceeded(r1, r2, r3);
    }

    CameraAccessController(Context context, VirtualDeviceManagerInternal virtualDeviceManagerInternal, CameraAccessBlockedCallback blockedCallback) {
        this.mLock = new Object();
        this.mObserverLock = new Object();
        this.mObserverCount = 0;
        this.mPackageToSessionData = new ArrayMap();
        this.mAppsToBlockOnVirtualDevice = new ArrayMap();
        this.mContext = context;
        this.mVirtualDeviceManagerInternal = virtualDeviceManagerInternal;
        this.mBlockedCallback = blockedCallback;
        this.mCameraManager = (CameraManager) this.mContext.getSystemService(CameraManager.class);
        this.mPackageManager = this.mContext.getPackageManager();
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
    }

    public int getUserId() {
        return this.mContext.getUserId();
    }

    public int getObserverCount() {
        Object r0 = this.mObserverLock;
        monitor-enter(r0);
        int r1 = this.mObserverCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void startObservingIfNeeded() {
        Object r0 = this.mObserverLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mObserverCount != 0) goto L9;
        this.mCameraManager.registerAvailabilityCallback(this.mContext.getMainExecutor(), this);     // Catch: Throwable -> L7
    L9:
        this.mObserverCount++;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void stopObservingIfNeeded() {
        Object r0 = this.mObserverLock;
        monitor-enter(r0);
        this.mObserverCount--;     // Catch: Throwable -> L7
        if (this.mObserverCount > 0) goto L9;
        close();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void blockCameraAccessIfNeeded(Set<Integer> runningUids) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L25:
    L15:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mAppsToBlockOnVirtualDevice.size()) goto L21;
        String cameraId = this.mAppsToBlockOnVirtualDevice.keyAt(i);     // Catch: Throwable -> L15
        OpenCameraInfo openCameraInfo = this.mAppsToBlockOnVirtualDevice.get(cameraId);     // Catch: Throwable -> L15
        String packageName = openCameraInfo.packageName;     // Catch: Throwable -> L15
        Iterator<Integer> r5 = openCameraInfo.packageUids.iterator();     // Catch: Throwable -> L15
    L9:
        if (r5.hasNext() == false) goto L19;
        int packageUid = r5.next().intValue();     // Catch: Throwable -> L15
        if (runningUids.contains(Integer.valueOf(packageUid)) == false) goto L9;
        if (this.mPackageToSessionData.get(packageName) != null) goto L17;
        InjectionSessionData data = new InjectionSessionData();     // Catch: Throwable -> L15
        data.appUid = packageUid;     // Catch: Throwable -> L15
        this.mPackageToSessionData.put(packageName, data);     // Catch: Throwable -> L15
    L17:
        startBlocking(packageName, cameraId);     // Catch: Throwable -> L15
    L19:
        i = i + 1;     // Catch: Throwable -> L15
        goto L25
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Object r0 = this.mObserverLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mObserverCount >= 0) goto L10;
        Slog.wtf(TAG, "Unexpected negative mObserverCount: " + this.mObserverCount);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<InjectionSessionData> r2 = this.mPackageToSessionData.values().iterator();     // Catch: Throwable -> L22
    L17:
        if (r2.hasNext() == false) goto L25;
        InjectionSessionData sessionData = r2.next();     // Catch: Throwable -> L22
        Iterator<CameraInjectionSession> r3 = sessionData.cameraIdToSession.values().iterator();     // Catch: Throwable -> L22
    L20:
        if (r3.hasNext() == false) goto L17;
        CameraInjectionSession session = r3.next();     // Catch: Throwable -> L22
        session.close();     // Catch: Throwable -> L22
        goto L20
    L25:
        this.mPackageToSessionData.clear();     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        this.mCameraManager.unregisterAvailabilityCallback(this);
        return;
    L22:
        th = move-exception;
        throw th;
    L10:
        if (this.mObserverCount <= 0) goto L12;
        Slog.w(TAG, "Unexpected close with observers remaining: " + this.mObserverCount);     // Catch: Throwable -> L7
        goto L12
    }

    public void onCameraOpened(String cameraId, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        InjectionSessionData data = this.mPackageToSessionData.get(packageName);     // Catch: Throwable -> L13
        List<UserInfo> aliveUsers = this.mUserManager.getAliveUsers();     // Catch: Throwable -> L13
        ArraySet<Integer> packageUids = new ArraySet();     // Catch: Throwable -> L13
        Iterator<UserInfo> r4 = aliveUsers.iterator();     // Catch: Throwable -> L13
    L6:
        if (r4.hasNext() == false) goto L26;
        UserInfo user = r4.next();     // Catch: Throwable -> L13
        int userId = user.getUserHandle().getIdentifier();     // Catch: Throwable -> L13
        int appUid = queryUidFromPackageName(userId, packageName);     // Catch: Throwable -> L13
        if (this.mVirtualDeviceManagerInternal == null) goto L23;
        if (this.mVirtualDeviceManagerInternal.isAppRunningOnAnyVirtualDevice(appUid) == false) goto L23;
        if (data != null) goto L16;
        data = new InjectionSessionData();     // Catch: Throwable -> L13
        data.appUid = appUid;     // Catch: Throwable -> L13
        this.mPackageToSessionData.put(packageName, data);     // Catch: Throwable -> L13
    L16:
        if (data.cameraIdToSession.containsKey(cameraId) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L19:
        startBlocking(packageName, cameraId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L23:
        if (appUid == (-1)) goto L6;
        packageUids.add(Integer.valueOf(appUid));     // Catch: Throwable -> L13
        goto L6
    L26:
        OpenCameraInfo openCameraInfo = new OpenCameraInfo();     // Catch: Throwable -> L13
        openCameraInfo.packageName = packageName;     // Catch: Throwable -> L13
        openCameraInfo.packageUids = packageUids;     // Catch: Throwable -> L13
        this.mAppsToBlockOnVirtualDevice.put(cameraId, openCameraInfo);     // Catch: Throwable -> L13
        if (data == null) goto L29;
        CameraInjectionSession existingSession = data.cameraIdToSession.get(cameraId);     // Catch: Throwable -> L13
    L30:
        if (existingSession == null) goto L34;
        existingSession.close();     // Catch: Throwable -> L13
        data.cameraIdToSession.remove(cameraId);     // Catch: Throwable -> L13
        if (data.cameraIdToSession.isEmpty() == false) goto L34;
        this.mPackageToSessionData.remove(packageName);     // Catch: Throwable -> L13
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L29:
        existingSession = null;
    L13:
        th = move-exception;
        throw th;
    }

    public void onCameraClosed(String cameraId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAppsToBlockOnVirtualDevice.remove(cameraId);     // Catch: Throwable -> L11
        int i = this.mPackageToSessionData.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        InjectionSessionData data = this.mPackageToSessionData.valueAt(i);     // Catch: Throwable -> L11
        CameraInjectionSession session = data.cameraIdToSession.get(cameraId);     // Catch: Throwable -> L11
        if (session == null) goto L13;
        session.close();     // Catch: Throwable -> L11
        data.cameraIdToSession.remove(cameraId);     // Catch: Throwable -> L11
        if (data.cameraIdToSession.isEmpty() == false) goto L13;
        this.mPackageToSessionData.removeAt(i);     // Catch: Throwable -> L11
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

    private void startBlocking(final String packageName, final String cameraId) {
        Slog.d(TAG, "startBlocking() cameraId: " + cameraId + " packageName: " + packageName);     // Catch: CameraAccessException -> L9
        String packageName2 = packageName;
        String cameraId2 = cameraId;
        this.mCameraManager.injectCamera(packageName2, cameraId2, "", this.mContext.getMainExecutor(), new AnonymousClass1(this, cameraId, packageName));     // Catch: CameraAccessException -> L7
        return;
    L7:
        e = move-exception;
        CameraAccessException e = e;
    L11:
        Slog.e(TAG, "Failed to injectCamera for cameraId:" + cameraId2 + " package:" + packageName2, e);
        return;
    L9:
        e = move-exception;
        packageName2 = packageName;
        cameraId2 = cameraId;
        e = e;
        goto L11
    }

    private void onInjectionSucceeded(String cameraId, String packageName, CameraInjectionSession session) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        InjectionSessionData data = this.mPackageToSessionData.get(packageName);     // Catch: Throwable -> L9
        if (data != null) goto L11;
        Slog.e(TAG, "onInjectionSucceeded didn't find expected entry for package " + packageName);     // Catch: Throwable -> L9
        session.close();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        CameraInjectionSession existingSession = data.cameraIdToSession.put(cameraId, session);     // Catch: Throwable -> L9
        if (existingSession == null) goto L14;
        Slog.e(TAG, "onInjectionSucceeded found unexpected existing session for camera " + cameraId);     // Catch: Throwable -> L9
        existingSession.close();     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onInjectionError(String cameraId, String packageName, int errorCode) {
        if (errorCode == 2) goto L6;
        Slog.e(TAG, "Unexpected injection error code:" + errorCode + " for camera:" + cameraId + " and package:" + packageName);
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        InjectionSessionData data = this.mPackageToSessionData.get(packageName);     // Catch: Throwable -> L11
        if (data == null) goto L13;
        this.mBlockedCallback.onCameraAccessBlocked(data.appUid);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private int queryUidFromPackageName(int userId, String packageName) {
        ApplicationInfo ainfo = this.mPackageManager.getApplicationInfoAsUser(packageName, 1, userId);     // Catch: PackageManager.NameNotFoundException -> L4
        return ainfo.uid;
    L4:
        e = move-exception;
        Slog.w(TAG, "queryUidFromPackageName - unknown package " + packageName, e);
        return -1;
    }
}
