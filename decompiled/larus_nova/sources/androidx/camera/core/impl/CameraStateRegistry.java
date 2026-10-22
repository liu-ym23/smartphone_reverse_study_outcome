package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraStateRegistry implements CameraCoordinator.ConcurrentCameraModeListener {
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_CONCURRENT_MODE = 2;
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_SINGLE_MODE = 1;
    private static final String TAG = "CameraStateRegistry";
    private int mAvailableCameras;
    private final CameraCoordinator mCameraCoordinator;
    private final Map<Camera, CameraRegistration> mCameraStates;
    private final StringBuilder mDebugString;
    private final Object mLock;
    private int mMaxAllowedOpenedCameras;

    public static class CameraRegistration {
        private final Executor mNotifyExecutor;
        private final OnConfigureAvailableListener mOnConfigureAvailableListener;
        private final OnOpenAvailableListener mOnOpenAvailableListener;
        private CameraInternal.State mState;

        public void notifyOnConfigureAvailableListener() {
            Executor r100 = this.mNotifyExecutor;     // Catch: RejectedExecutionException -> L4
            final OnConfigureAvailableListener r101 = this.mOnConfigureAvailableListener;     // Catch: RejectedExecutionException -> L4
            Objects.requireNonNull(r101);     // Catch: RejectedExecutionException -> L4
            r100.execute(new h(r101));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to configure.", e);
        }

        public void notifyOnOpenAvailableListener() {
            Executor r100 = this.mNotifyExecutor;     // Catch: RejectedExecutionException -> L4
            final OnOpenAvailableListener r101 = this.mOnOpenAvailableListener;     // Catch: RejectedExecutionException -> L4
            Objects.requireNonNull(r101);     // Catch: RejectedExecutionException -> L4
            r100.execute(new g(r101));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to open.", e);
        }

        public CameraInternal.State getState() {
            return this.mState;
        }

        public CameraInternal.State setState(CameraInternal.State r100) {
            CameraInternal.State r101 = this.mState;
            this.mState = r100;
            return r101;
        }

        public CameraRegistration(CameraInternal.State r100, Executor r101, OnConfigureAvailableListener r102, OnOpenAvailableListener r103) {
            this.mState = r100;
            this.mNotifyExecutor = r101;
            this.mOnConfigureAvailableListener = r102;
            this.mOnOpenAvailableListener = r103;
        }
    }

    public interface OnConfigureAvailableListener {
        void onConfigureAvailable();
    }

    public interface OnOpenAvailableListener {
        void onOpenAvailable();
    }

    private void recalculateAvailableCameras() {
        if (Logger.isDebugEnabled(TAG) == false) goto L5;
        this.mDebugString.setLength(0);
        this.mDebugString.append("Recalculating open cameras:\n");
        this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{"Camera", "State"}));
        this.mDebugString.append("-------------------------------------------------------------------\n");
    L5:
        Iterator<Map.Entry<Camera, CameraRegistration>> r100 = this.mCameraStates.entrySet().iterator();
        int r101 = 0;
    L7:
        if (r100.hasNext() == false) goto L19;
        Map.Entry<Camera, CameraRegistration> r102 = r100.next();
        if (Logger.isDebugEnabled(TAG) == false) goto L16;
        if (r102.getValue().getState() == null) goto L13;
        String r103 = r102.getValue().getState().toString();
    L14:
        this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", new Object[]{r102.getKey().toString(), r103}));
        goto L16
    L13:
        r103 = "UNKNOWN";
    L16:
        if (isOpen(r102.getValue().getState()) == false) goto L7;
        r101 = r101 + 1;
        goto L7
    L19:
        if (Logger.isDebugEnabled(TAG) == false) goto L21;
        this.mDebugString.append("-------------------------------------------------------------------\n");
        this.mDebugString.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", new Object[]{Integer.valueOf(r101), Integer.valueOf(this.mMaxAllowedOpenedCameras)}));
        Logger.d(TAG, this.mDebugString.toString());
    L21:
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - r101, 0);
    }

    public boolean isCameraClosing() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Iterator<Map.Entry<Camera, CameraRegistration>> r101 = this.mCameraStates.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r101.hasNext() == false) goto L12;
        if (r101.next().getValue().getState() != CameraInternal.State.CLOSING) goto L6;
        monitor-exit(r100);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    private CameraRegistration getCameraRegistration(String r100) {
        Iterator<Camera> r101 = this.mCameraStates.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Camera r102 = r101.next();
        if (r100.equals(((CameraInfoInternal) r102.getCameraInfo()).getCameraId()) == false) goto L4;
        return this.mCameraStates.get(r102);
    L9:
        return null;
    }

    private static boolean isOpen(CameraInternal.State r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.holdsCameraSlot() == false) goto L6;
        return true;
    }

    private CameraInternal.State unregisterCamera(Camera r100) {
        CameraRegistration r101 = this.mCameraStates.remove(r100);
        if (r101 == null) goto L6;
        recalculateAvailableCameras();
        return r101.getState();
    L6:
        return null;
    }

    public boolean tryOpenCamera(Camera r110) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        CameraRegistration r101 = (CameraRegistration) Preconditions.checkNotNull(this.mCameraStates.get(r110), "Camera must first be registered with registerCamera()");     // Catch: Throwable -> L25
        if (Logger.isDebugEnabled(TAG) == false) goto L8;
        this.mDebugString.setLength(0);     // Catch: Throwable -> L25
        this.mDebugString.append(String.format(Locale.US, "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]", new Object[]{r110, Integer.valueOf(this.mAvailableCameras), Boolean.valueOf(isOpen(r101.getState())), r101.getState()}));     // Catch: Throwable -> L25
    L8:
        if (this.mAvailableCameras <= 0) goto L10;
    L13:
        CameraInternal.State r102 = CameraInternal.State.OPENING;     // Catch: Throwable -> L25
        r101.setState(r102);     // Catch: Throwable -> L25
        traceState(r110, r102);     // Catch: Throwable -> L25
        boolean r111 = true;
    L15:
        if (Logger.isDebugEnabled(TAG) == false) goto L21;
        StringBuilder r103 = this.mDebugString;     // Catch: Throwable -> L25
        Locale r104 = Locale.US;     // Catch: Throwable -> L25
        Object[] r105 = new Object[1];     // Catch: Throwable -> L25
        if (r111 == false) goto L19;
        String r106 = "SUCCESS";
    L20:
        r105[0] = r106;     // Catch: Throwable -> L25
        r103.append(String.format(r104, " --> %s", r105));     // Catch: Throwable -> L25
        Logger.d(TAG, this.mDebugString.toString());     // Catch: Throwable -> L25
        goto L21
    L19:
        r106 = "FAIL";
    L21:
        if (r111 == false) goto L23;
        recalculateAvailableCameras();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r100);     // Catch: Throwable -> L25
        return r111;
    L10:
        if (isOpen(r101.getState()) == true) goto L13;
        r111 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public CameraStateRegistry(CameraCoordinator r100, int r101) {
        this.mDebugString = new StringBuilder();
        Object r102 = new Object();
        this.mLock = r102;
        this.mCameraStates = new HashMap();
        this.mMaxAllowedOpenedCameras = r101;
        monitor-enter(r102);
        this.mCameraCoordinator = r100;     // Catch: Throwable -> L7
        this.mAvailableCameras = this.mMaxAllowedOpenedCameras;     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void traceState(Camera r100, CameraInternal.State r101) {
        if (Trace.isEnabled() == false) goto L6;
        Trace.setCounter("CX:State[" + r100 + "]", r101.ordinal());
        return;
    }

    private CameraInternal.State updateAndVerifyState(Camera r100, CameraInternal.State r101) {
        CameraInternal.State r102 = ((CameraRegistration) Preconditions.checkNotNull(this.mCameraStates.get(r100), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(r101);
        CameraInternal.State r103 = CameraInternal.State.OPENING;
        if (r101 == r103) goto L5;
    L11:
        if (r102 == r101) goto L13;
        traceState(r100, r101);
        recalculateAvailableCameras();
    L13:
        return r102;
    L5:
        if (isOpen(r101) == true) goto L9;
        if (r102 == r103) goto L9;
        boolean r104 = false;
    L10:
        Preconditions.checkState(r104, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
    L9:
        r104 = true;
        goto L10
    }

    public void markCameraState(Camera r100, CameraInternal.State r101) {
        markCameraState(r100, r101, true);
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator.ConcurrentCameraModeListener
    public void onCameraOperatingModeUpdated(int r100, int r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        boolean r103 = true;
        if (r101 != 2) goto L7;
        int r104 = 2;
    L25:
        this.mMaxAllowedOpenedCameras = r104;     // Catch: Throwable -> L22
        if (r100 == 2) goto L12;
        if (r101 != 2) goto L12;
        boolean r105 = true;
    L13:
        if (r100 != 2) goto L16;
        if (r101 == 2) goto L16;
    L17:
        if (r105 == true) goto L19;
        if (r103 == true) goto L19;
    L20:
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L19:
        recalculateAvailableCameras();     // Catch: Throwable -> L22
    L16:
        r103 = false;
    L12:
        r105 = false;
    L22:
        th = move-exception;
        throw th;
    L7:
        r104 = 1;
        goto L25
    }

    public boolean tryOpenCaptureSession(String r100, String r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        boolean r103 = true;
        if (this.mCameraCoordinator.getCameraOperatingMode() == 2) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L37
        return true;
    L8:
        CameraRegistration r104 = getCameraRegistration(r100);     // Catch: Throwable -> L37
        CameraInternal.State r105 = null;
        if (r104 == null) goto L11;
        CameraInternal.State r106 = r104.getState();     // Catch: Throwable -> L37
    L12:
        if (r101 == null) goto L14;
        CameraRegistration r107 = getCameraRegistration(r101);     // Catch: Throwable -> L37
    L15:
        if (r107 == null) goto L17;
        r105 = r107.getState();     // Catch: Throwable -> L37
    L17:
        CameraInternal.State r108 = CameraInternal.State.OPEN;     // Catch: Throwable -> L37
        if (r108.equals(r106) == false) goto L20;
    L23:
        boolean r109 = true;
    L25:
        if (r108.equals(r105) == false) goto L27;
    L30:
        boolean r110 = true;
    L31:
        if (r109 == false) goto L34;
        if (r110 == false) goto L34;
    L35:
        monitor-exit(r102);     // Catch: Throwable -> L37
        return r103;
    L34:
        r103 = false;
        goto L35
    L27:
        if (CameraInternal.State.CONFIGURED.equals(r105) == true) goto L30;
        r110 = false;
        goto L31
    L20:
        if (CameraInternal.State.CONFIGURED.equals(r106) == true) goto L23;
        r109 = false;
        goto L25
    L14:
        r107 = null;
        goto L15
    L11:
        r106 = null;
    L37:
        th = move-exception;
        throw th;
    }

    public void markCameraState(Camera r100, CameraInternal.State r101, boolean r102) {
        Object r103 = this.mLock;
        monitor-enter(r103);
        int r104 = this.mAvailableCameras;     // Catch: Throwable -> L46
        if (r101 != CameraInternal.State.RELEASED) goto L7;
        CameraInternal.State r105 = unregisterCamera(r100);     // Catch: Throwable -> L46
    L8:
        if (r105 != r101) goto L11;
        monitor-exit(r103);     // Catch: Throwable -> L46
        return;
    L11:
        HashMap r106 = null;
        if (this.mCameraCoordinator.getCameraOperatingMode() == 2) goto L14;
    L18:
        CameraRegistration r107 = null;
    L20:
        if (r104 >= 1) goto L30;
        if (this.mAvailableCameras <= 0) goto L30;
        r106 = new HashMap();     // Catch: Throwable -> L46
        Iterator<Map.Entry<Camera, CameraRegistration>> r108 = this.mCameraStates.entrySet().iterator();     // Catch: Throwable -> L46
    L25:
        if (r108.hasNext() == false) goto L34;
        Map.Entry<Camera, CameraRegistration> r109 = r108.next();     // Catch: Throwable -> L46
        if (r109.getValue().getState() != CameraInternal.State.PENDING_OPEN) goto L25;
        r106.put(r109.getKey(), r109.getValue());     // Catch: Throwable -> L46
    L34:
        if (r106 == null) goto L37;
        if (r102 == true) goto L37;
        r106.remove(r100);     // Catch: Throwable -> L46
    L37:
        monitor-exit(r103);     // Catch: Throwable -> L46
        if (r106 == null) goto L43;
        Iterator r110 = r106.values().iterator();
    L41:
        if (r110.hasNext() == false) goto L43;
        ((CameraRegistration) r110.next()).notifyOnOpenAvailableListener();
    L43:
        if (r107 == null) goto L56;
        r107.notifyOnConfigureAvailableListener();
        return;
    L56:
        return;
    L30:
        if (r101 != CameraInternal.State.PENDING_OPEN) goto L34;
        if (this.mAvailableCameras <= 0) goto L34;
        r106 = new HashMap();     // Catch: Throwable -> L46
        r106.put(r100, this.mCameraStates.get(r100));     // Catch: Throwable -> L46
        goto L34
    L14:
        if (r101 != CameraInternal.State.CONFIGURED) goto L18;
        String r111 = this.mCameraCoordinator.getPairedConcurrentCameraId(((CameraInfoInternal) r100.getCameraInfo()).getCameraId());     // Catch: Throwable -> L46
        if (r111 == null) goto L18;
        r107 = getCameraRegistration(r111);     // Catch: Throwable -> L46
        goto L20
    L7:
        r105 = updateAndVerifyState(r100, r101);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public void registerCamera(Camera r100, Executor r101, OnConfigureAvailableListener r102, OnOpenAvailableListener r103) {
        Object r104 = this.mLock;
        monitor-enter(r104);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameraStates.containsKey(r100) == true) goto L7;
        boolean r105 = true;
    L8:
        Preconditions.checkState(r105, "Camera is already registered: " + r100);     // Catch: Throwable -> L11
        this.mCameraStates.put(r100, new CameraRegistration(null, r101, r102, r103));     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
        return;
    L7:
        r105 = false;
        goto L8
    }
}
