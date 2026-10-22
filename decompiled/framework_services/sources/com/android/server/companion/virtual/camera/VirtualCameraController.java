package com.android.server.companion.virtual.camera;

import android.companion.virtual.camera.VirtualCameraConfig;
import android.companion.virtualcamera.IVirtualCameraService;
import android.companion.virtualcamera.VirtualCameraConfiguration;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.modules.expresslog.Counter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class VirtualCameraController implements IBinder.DeathRecipient {
    private static final String TAG = "VirtualCameraController";
    private static final String VIRTUAL_CAMERA_SERVICE_NAME = "virtual_camera";
    private final int mCameraPolicy;
    private final Map<IBinder, CameraDescriptor> mCameras;
    private final int mDeviceId;
    private final Object mServiceLock;
    private IVirtualCameraService mVirtualCameraService;

    private final class CameraDescriptor implements IBinder.DeathRecipient {
        private final VirtualCameraConfig mConfig;
        final /* synthetic */ VirtualCameraController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmConfig, reason: not valid java name */
        static /* bridge */ /* synthetic */ VirtualCameraConfig m3035$$Nest$fgetmConfig(CameraDescriptor r0) {
            return r0.mConfig;
        }

        CameraDescriptor(VirtualCameraController r1, VirtualCameraConfig config) {
            this.this$0 = r1;
            this.mConfig = config;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.d(VirtualCameraController.TAG, "Virtual camera binder died");
            this.this$0.unregisterCamera(this.mConfig);
        }
    }

    public VirtualCameraController(int cameraPolicy, int deviceId) {
        this(null, cameraPolicy, deviceId);
    }

    VirtualCameraController(IVirtualCameraService virtualCameraService, int cameraPolicy, int deviceId) {
        this.mServiceLock = new Object();
        this.mCameras = new ArrayMap();
        this.mVirtualCameraService = virtualCameraService;
        this.mCameraPolicy = cameraPolicy;
        this.mDeviceId = deviceId;
    }

    public void registerCamera(VirtualCameraConfig cameraConfig, AttributionSource attributionSource) {
        checkConfigByPolicy(cameraConfig);
        connectVirtualCameraServiceIfNeeded();
    L13:
        e = move-exception;
        e.rethrowFromSystemServer();
    L18:
        Counter.logIncrementWithUid("virtual_devices.value_virtual_camera_created_count", attributionSource.getUid());
        return;
    L4:
        if (registerCameraWithService(cameraConfig) == false) goto L16;
        CameraDescriptor cameraDescriptor = new CameraDescriptor(this, cameraConfig);     // Catch: RemoteException -> L13
        IBinder binder = cameraConfig.getCallback().asBinder();     // Catch: RemoteException -> L13
        binder.linkToDeath(cameraDescriptor, 0);     // Catch: RemoteException -> L13
        Map<IBinder, CameraDescriptor> r2 = this.mCameras;     // Catch: RemoteException -> L13
        monitor-enter(r2);     // Catch: RemoteException -> L13
        this.mCameras.put(binder, cameraDescriptor);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L16:
        throw new RuntimeException("Failed to register virtual camera.");     // Catch: RemoteException -> L13
    }

    public void unregisterCamera(VirtualCameraConfig cameraConfig) {
        Map<IBinder, CameraDescriptor> r0 = this.mCameras;
        monitor-enter(r0);
        IBinder binder = cameraConfig.getCallback().asBinder();     // Catch: Throwable -> L7
        if (this.mCameras.containsKey(binder) == true) goto L9;
        Slog.w(TAG, "Virtual camera was not registered.");     // Catch: Throwable -> L7
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        connectVirtualCameraServiceIfNeeded();     // Catch: Throwable -> L7
        Object r2 = this.mServiceLock;     // Catch: Throwable -> L7 RemoteException -> L16
        monitor-enter(r2);     // Catch: Throwable -> L7 RemoteException -> L16
        this.mVirtualCameraService.unregisterCamera(binder);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        this.mCameras.remove(binder);     // Catch: Throwable -> L7 RemoteException -> L16
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7 RemoteException -> L16
    L16:
        e = move-exception;
        e.rethrowFromSystemServer();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public String getCameraId(VirtualCameraConfig cameraConfig) {
        connectVirtualCameraServiceIfNeeded();
        Object r0 = this.mServiceLock;     // Catch: RemoteException -> L11
        monitor-enter(r0);     // Catch: RemoteException -> L11
        String r1 = this.mVirtualCameraService.getCameraId(cameraConfig.getCallback().asBinder());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L11
    L11:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.d(TAG, "Virtual camera service died.");
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        this.mVirtualCameraService = null;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Map<IBinder, CameraDescriptor> r1 = this.mCameras;
        monitor-enter(r1);
        this.mCameras.clear();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public void close() {
        Map<IBinder, CameraDescriptor> r0 = this.mCameras;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.mCameras.isEmpty() == true) goto L26;
        connectVirtualCameraServiceIfNeeded();     // Catch: Throwable -> L22
        Object r1 = this.mServiceLock;     // Catch: Throwable -> L22
        monitor-enter(r1);     // Catch: Throwable -> L22
        Iterator<IBinder> r2 = this.mCameras.keySet().iterator();     // Catch: Throwable -> L14
    L10:
        if (r2.hasNext() == false) goto L19;
        IBinder binder = r2.next();     // Catch: Throwable -> L14
        this.mVirtualCameraService.unregisterCamera(binder);     // Catch: Throwable -> L14 RemoteException -> L16
    L16:
        e = move-exception;
        Slog.w(TAG, "close(): Camera failed to be removed on camera service.", e);     // Catch: Throwable -> L14
        goto L10
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L14
        this.mCameras.clear();     // Catch: Throwable -> L22
        goto L26
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L22
        Object r3 = this.mServiceLock;
        monitor-enter(r3);
        this.mVirtualCameraService = null;     // Catch: Throwable -> L33
        monitor-exit(r3);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter fout, String indent) {
        fout.println(indent + "VirtualCameraController:");
        String indent2 = indent + indent;
        Map<IBinder, CameraDescriptor> r0 = this.mCameras;
        monitor-enter(r0);
        fout.println(indent2 + "Registered cameras: " + this.mCameras.size());     // Catch: Throwable -> L8
        Iterator<CameraDescriptor> r1 = this.mCameras.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        CameraDescriptor descriptor = r1.next();     // Catch: Throwable -> L8
        fout.println(indent2 + " token: " + CameraDescriptor.m3035$$Nest$fgetmConfig(descriptor));     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void checkConfigByPolicy(VirtualCameraConfig config) {
        if (this.mCameraPolicy == 0) goto L10;
        if (isLensFacingAlreadyPresent(config.getLensFacing()) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Only a single virtual camera can be created with lens facing " + config.getLensFacing());
    L10:
        throw new IllegalArgumentException("Cannot create virtual camera with DEVICE_POLICY_DEFAULT for POLICY_TYPE_CAMERA");
    }

    private boolean isLensFacingAlreadyPresent(int lensFacing) {
        Map<IBinder, CameraDescriptor> r0 = this.mCameras;
        monitor-enter(r0);
        Iterator<CameraDescriptor> r1 = this.mCameras.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L15;
        CameraDescriptor cameraDescriptor = r1.next();     // Catch: Throwable -> L12
        if (CameraDescriptor.m3035$$Nest$fgetmConfig(cameraDescriptor).getLensFacing() != lensFacing) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    private void connectVirtualCameraServiceIfNeeded() {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualCameraService != null) goto L10;
        connectVirtualCameraService();     // Catch: Throwable -> L7
    L10:
        if (this.mVirtualCameraService == null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L14:
        throw new IllegalStateException("Virtual camera service is not connected.");     // Catch: Throwable -> L7
    }

    private void connectVirtualCameraService() {
        long callingId = Binder.clearCallingIdentity();
        IBinder virtualCameraBinder = ServiceManager.waitForService(VIRTUAL_CAMERA_SERVICE_NAME);     // Catch: Throwable -> L8 RemoteException -> L10
        if (virtualCameraBinder != null) goto L13;
        Slog.e(TAG, "connectVirtualCameraService: Failed to connect to the virtual camera service");     // Catch: Throwable -> L8 RemoteException -> L10
        Binder.restoreCallingIdentity(callingId);
        return;
    L13:
        virtualCameraBinder.linkToDeath(this, 0);     // Catch: Throwable -> L8 RemoteException -> L10
        this.mVirtualCameraService = IVirtualCameraService.Stub.asInterface(virtualCameraBinder);     // Catch: Throwable -> L8 RemoteException -> L10
    L14:
        Binder.restoreCallingIdentity(callingId);
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L10:
        e = move-exception;
        e.rethrowFromSystemServer();     // Catch: Throwable -> L8
        goto L14
    }

    private boolean registerCameraWithService(VirtualCameraConfig config) throws RemoteException {
        VirtualCameraConfiguration serviceConfiguration = VirtualCameraConversionUtil.getServiceCameraConfiguration(config);
        Object r1 = this.mServiceLock;
        monitor-enter(r1);
        boolean r2 = this.mVirtualCameraService.registerCamera(config.getCallback().asBinder(), serviceConfiguration, this.mDeviceId);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }
}
