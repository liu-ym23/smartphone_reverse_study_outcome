package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraDeviceCompat {
    public static final int SESSION_OPERATION_MODE_CONSTRAINED_HIGH_SPEED = 1;
    public static final int SESSION_OPERATION_MODE_NORMAL = 0;
    private final CameraDeviceCompatImpl mImpl;

    public interface CameraDeviceCompatImpl {
        void createCaptureSession(SessionConfigurationCompat r100) throws CameraAccessExceptionCompat;

        CameraDevice unwrap();
    }

    public static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {
        private final Executor mExecutor;
        final CameraDevice.StateCallback mWrappedCallback;

        public static /* synthetic */ void a(StateCallbackExecutorWrapper r100, CameraDevice r101) {
            r100.lambda$onDisconnected$1(r101);
        }

        public static /* synthetic */ void b(StateCallbackExecutorWrapper r100, CameraDevice r101) {
            r100.lambda$onOpened$0(r101);
        }

        public static /* synthetic */ void c(StateCallbackExecutorWrapper r100, CameraDevice r101, int r102) {
            r100.lambda$onError$2(r101, r102);
        }

        public static /* synthetic */ void d(StateCallbackExecutorWrapper r100, CameraDevice r101) {
            r100.lambda$onClosed$3(r101);
        }

        private /* synthetic */ void lambda$onClosed$3(CameraDevice r100) {
            this.mWrappedCallback.onClosed(r100);
        }

        private /* synthetic */ void lambda$onDisconnected$1(CameraDevice r100) {
            this.mWrappedCallback.onDisconnected(r100);
        }

        private /* synthetic */ void lambda$onOpened$0(CameraDevice r100) {
            this.mWrappedCallback.onOpened(r100);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(final CameraDevice r100) {
            this.mExecutor.execute(new o(this, r100));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(final CameraDevice r100) {
            this.mExecutor.execute(new p(this, r100));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(final CameraDevice r210) {
            ArrayList r110 = new ArrayList();
            Object[] r111 = {r210};
            f06.b r112 = new f06.b();
            g06.a r100 = ApiHookConfig.f245611b.get(Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE));
            if (r100 == null) goto L5;
            f06.a[] r101 = r100.f479473i;
        L6:
            f06.a[] r102 = r101;
            int r103 = r102.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L15;
            f06.a r105 = r102[r104];
            int r113 = r104;
            int r114 = r103;
            f06.a[] r115 = r102;
            f06.d r106 = r105.preInvoke(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE, "androidx/camera/camera2/internal/compat/CameraDeviceCompat$StateCallbackExecutorWrapper", "onOpened", this, r111, "void", r112);     // Catch: Exception -> L21
            if (r106.f474982a == true) goto L17;
            r110.add(r105);     // Catch: Exception -> L21
        L17:
            if (r106.f474982a == false) goto L19;
            return;
        L19:
            this.mExecutor.execute(new q(this, r210));
            return;
        L14:
            r104 = r113 + 1;
            r103 = r114;
            r102 = r115;
            goto L8
        L15:
            r106 = new f06.d(false, null);
            goto L17
        L5:
            r101 = ApiHookConfig.f245613d;
            goto L6
        }

        public StateCallbackExecutorWrapper(Executor r100, CameraDevice.StateCallback r101) {
            this.mExecutor = r100;
            this.mWrappedCallback = r101;
        }

        private /* synthetic */ void lambda$onError$2(CameraDevice r100, int r101) {
            this.mWrappedCallback.onError(r100, r101);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(final CameraDevice r100, final int r101) {
            this.mExecutor.execute(new r(this, r100, r101));
        }
    }

    public CameraDevice toCameraDevice() {
        return this.mImpl.unwrap();
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice r100) {
        return toCameraDeviceCompat(r100, MainThreadAsyncHandler.getInstance());
    }

    public void createCaptureSession(SessionConfigurationCompat r100) throws CameraAccessExceptionCompat {
        this.mImpl.createCaptureSession(r100);
    }

    private CameraDeviceCompat(CameraDevice r100, Handler r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 28) goto L6;
        this.mImpl = new CameraDeviceCompatApi28Impl(r100);
        return;
    L6:
        if (r102 < 24) goto L9;
        this.mImpl = CameraDeviceCompatApi24Impl.create(r100, r101);
        return;
    L9:
        if (r102 < 23) goto L11;
        this.mImpl = CameraDeviceCompatApi23Impl.create(r100, r101);
        return;
    L11:
        this.mImpl = CameraDeviceCompatBaseImpl.create(r100, r101);
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice r100, Handler r101) {
        return new CameraDeviceCompat(r100, r101);
    }
}
