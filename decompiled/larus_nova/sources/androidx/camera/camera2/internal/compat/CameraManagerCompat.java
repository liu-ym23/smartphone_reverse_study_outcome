package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraManagerCompat {
    private final Map<String, CameraCharacteristicsCompat> mCameraCharacteristicsMap;
    private final CameraManagerCompatImpl mImpl;

    public static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        private boolean mDisabled;
        private final Executor mExecutor;
        private final Object mLock;
        final CameraManager.AvailabilityCallback mWrappedCallback;

        public static /* synthetic */ void a(AvailabilityCallbackExecutorWrapper r100) {
            r100.lambda$onCameraAccessPrioritiesChanged$0();
        }

        public static /* synthetic */ void b(AvailabilityCallbackExecutorWrapper r100, String r101) {
            r100.lambda$onCameraAvailable$1(r101);
        }

        public static /* synthetic */ void c(AvailabilityCallbackExecutorWrapper r100, String r101) {
            r100.lambda$onCameraUnavailable$2(r101);
        }

        private /* synthetic */ void lambda$onCameraAccessPrioritiesChanged$0() {
            ApiCompat.Api29Impl.onCameraAccessPrioritiesChanged(this.mWrappedCallback);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAccessPrioritiesChanged() {
            Object r100 = this.mLock;
            monitor-enter(r100);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mDisabled == true) goto L7;
            this.mExecutor.execute(new s(this));     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
        }

        public void setDisabled() {
            Object r100 = this.mLock;
            monitor-enter(r100);
            this.mDisabled = true;     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$onCameraAvailable$1(String r100) {
            this.mWrappedCallback.onCameraAvailable(r100);
        }

        private /* synthetic */ void lambda$onCameraUnavailable$2(String r100) {
            this.mWrappedCallback.onCameraUnavailable(r100);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(final String r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mDisabled == true) goto L7;
            this.mExecutor.execute(new u(this, r100));     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);     // Catch: Throwable -> L9
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(final String r100) {
            Object r101 = this.mLock;
            monitor-enter(r101);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mDisabled == true) goto L7;
            this.mExecutor.execute(new t(this, r100));     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);     // Catch: Throwable -> L9
        }

        public AvailabilityCallbackExecutorWrapper(Executor r100, CameraManager.AvailabilityCallback r101) {
            this.mLock = new Object();
            this.mDisabled = false;
            this.mExecutor = r100;
            this.mWrappedCallback = r101;
        }
    }

    public interface CameraManagerCompatImpl {

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraManagerCompat$CameraManagerCompatImpl$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static CameraManagerCompatImpl from(Context r100, Handler r101) {
                int r102 = Build.VERSION.SDK_INT;
                if (r102 < 30) goto L7;
                return new CameraManagerCompatApi30Impl(r100);
            L7:
                if (r102 < 29) goto L11;
                return new CameraManagerCompatApi29Impl(r100);
            L11:
                if (r102 < 28) goto L15;
                return CameraManagerCompatApi28Impl.create(r100);
            L15:
                return CameraManagerCompatBaseImpl.create(r100, r101);
            }
        }

        CameraCharacteristics getCameraCharacteristics(String r100) throws CameraAccessExceptionCompat;

        String[] getCameraIdList() throws CameraAccessExceptionCompat;

        CameraManager getCameraManager();

        Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat;

        void openCamera(String r100, Executor r101, CameraDevice.StateCallback r102) throws CameraAccessExceptionCompat;

        void registerAvailabilityCallback(Executor r100, CameraManager.AvailabilityCallback r101);

        void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r100);
    }

    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        return this.mImpl.getCameraIdList();
    }

    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        return this.mImpl.getConcurrentCameraIds();
    }

    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }

    private CameraManagerCompat(CameraManagerCompatImpl r100) {
        this.mCameraCharacteristicsMap = new ArrayMap(4);
        this.mImpl = r100;
    }

    public static CameraManagerCompat from(Context r100) {
        return from(r100, MainThreadAsyncHandler.getInstance());
    }

    public CameraCharacteristicsCompat getCameraCharacteristicsCompat(String r100) throws CameraAccessExceptionCompat {
        Map<String, CameraCharacteristicsCompat> r101 = this.mCameraCharacteristicsMap;
        monitor-enter(r101);
        CameraCharacteristicsCompat r102 = this.mCameraCharacteristicsMap.get(r100);     // Catch: Throwable -> L13
        if (r102 == null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r102;
    L16:
        r102 = CameraCharacteristicsCompat.toCameraCharacteristicsCompat(this.mImpl.getCameraCharacteristics(r100), r100);     // Catch: AssertionError -> L8 Throwable -> L13
        this.mCameraCharacteristicsMap.put(r100, r102);     // Catch: AssertionError -> L8 Throwable -> L13
    L8:
        e = move-exception;
        throw new CameraAccessExceptionCompat(10002, e.getMessage(), e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r100) {
        this.mImpl.unregisterAvailabilityCallback(r100);
    }

    public static CameraManagerCompat from(CameraManagerCompatImpl r100) {
        return new CameraManagerCompat(r100);
    }

    public static CameraManagerCompat from(Context r100, Handler r101) {
        return new CameraManagerCompat(CameraManagerCompatImpl.CC.from(r100, r101));
    }

    public void registerAvailabilityCallback(Executor r100, CameraManager.AvailabilityCallback r101) {
        this.mImpl.registerAvailabilityCallback(r100, r101);
    }

    public void openCamera(String r100, Executor r101, CameraDevice.StateCallback r102) throws CameraAccessExceptionCompat {
        this.mImpl.openCamera(r100, r101, r102);
    }
}
