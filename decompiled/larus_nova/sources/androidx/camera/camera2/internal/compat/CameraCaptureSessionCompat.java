package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraCaptureSessionCompat {
    private final CameraCaptureSessionCompatImpl mImpl;

    public interface CameraCaptureSessionCompatImpl {
        int captureBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

        int captureSingleRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

        int setRepeatingBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

        int setSingleRepeatingRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

        CameraCaptureSession unwrap();
    }

    public static final class CaptureCallbackExecutorWrapper extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.CaptureCallback mWrappedCallback;

        public static /* synthetic */ void a(CaptureCallbackExecutorWrapper r100, CameraCaptureSession r101, CaptureRequest r102, Surface r103, long r104) {
            r100.lambda$onCaptureBufferLost$6(r101, r102, r103, r104);
        }

        public static /* synthetic */ void b(CaptureCallbackExecutorWrapper r100, CameraCaptureSession r101, CaptureRequest r102, CaptureResult r103) {
            r100.lambda$onCaptureProgressed$1(r101, r102, r103);
        }

        public static /* synthetic */ void c(CaptureCallbackExecutorWrapper r100, CameraCaptureSession r101, int r102) {
            r100.lambda$onCaptureSequenceAborted$5(r101, r102);
        }

        public static /* synthetic */ void d(CaptureCallbackExecutorWrapper r100, CameraCaptureSession r101, CaptureRequest r102, long r103, long r104) {
            r100.lambda$onCaptureStarted$0(r101, r102, r103, r104);
        }

        public static /* synthetic */ void e(CaptureCallbackExecutorWrapper r100, CameraCaptureSession r101, int r102, long r103) {
            r100.lambda$onCaptureSequenceCompleted$4(r101, r102, r103);
        }

        public static /* synthetic */ void f(CaptureCallbackExecutorWrapper r100, CameraCaptureSession r101, CaptureRequest r102, TotalCaptureResult r103) {
            r100.lambda$onCaptureCompleted$2(r101, r102, r103);
        }

        public static /* synthetic */ void g(CaptureCallbackExecutorWrapper r100, CameraCaptureSession r101, CaptureRequest r102, CaptureFailure r103) {
            r100.lambda$onCaptureFailed$3(r101, r102, r103);
        }

        public CaptureCallbackExecutorWrapper(Executor r100, CameraCaptureSession.CaptureCallback r101) {
            this.mExecutor = r100;
            this.mWrappedCallback = r101;
        }

        private /* synthetic */ void lambda$onCaptureSequenceAborted$5(CameraCaptureSession r100, int r101) {
            this.mWrappedCallback.onCaptureSequenceAborted(r100, r101);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(final CameraCaptureSession r100, final int r101) {
            this.mExecutor.execute(new a(this, r100, r101));
        }

        private /* synthetic */ void lambda$onCaptureCompleted$2(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
            this.mWrappedCallback.onCaptureCompleted(r100, r101, r102);
        }

        private /* synthetic */ void lambda$onCaptureFailed$3(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
            this.mWrappedCallback.onCaptureFailed(r100, r101, r102);
        }

        private /* synthetic */ void lambda$onCaptureProgressed$1(CameraCaptureSession r100, CaptureRequest r101, CaptureResult r102) {
            this.mWrappedCallback.onCaptureProgressed(r100, r101, r102);
        }

        private /* synthetic */ void lambda$onCaptureSequenceCompleted$4(CameraCaptureSession r100, int r101, long r102) {
            this.mWrappedCallback.onCaptureSequenceCompleted(r100, r101, r102);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(final CameraCaptureSession r100, final CaptureRequest r101, final TotalCaptureResult r102) {
            this.mExecutor.execute(new e(this, r100, r101, r102));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(final CameraCaptureSession r100, final CaptureRequest r101, final CaptureFailure r102) {
            this.mExecutor.execute(new g(this, r100, r101, r102));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(final CameraCaptureSession r100, final CaptureRequest r101, final CaptureResult r102) {
            this.mExecutor.execute(new d(this, r100, r101, r102));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(final CameraCaptureSession r100, final int r110, final long r111) {
            this.mExecutor.execute(new c(this, r100, r110, r111));
        }

        private /* synthetic */ void lambda$onCaptureBufferLost$6(CameraCaptureSession r100, CaptureRequest r101, Surface r102, long r110) {
            ApiCompat.Api24Impl.onCaptureBufferLost(this.mWrappedCallback, r100, r101, r102, r110);
        }

        private /* synthetic */ void lambda$onCaptureStarted$0(CameraCaptureSession r100, CaptureRequest r101, long r110, long r111) {
            this.mWrappedCallback.onCaptureStarted(r100, r101, r110, r111);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(final CameraCaptureSession r110, final CaptureRequest r111, final Surface r112, final long r113) {
            this.mExecutor.execute(new b(this, r110, r111, r112, r113));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(final CameraCaptureSession r110, final CaptureRequest r111, final long r112, final long r113) {
            this.mExecutor.execute(new f(this, r110, r111, r112, r113));
        }
    }

    public static final class StateCallbackExecutorWrapper extends CameraCaptureSession.StateCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.StateCallback mWrappedCallback;

        public static /* synthetic */ void a(StateCallbackExecutorWrapper r100, CameraCaptureSession r101, Surface r102) {
            r100.lambda$onSurfacePrepared$6(r101, r102);
        }

        public static /* synthetic */ void b(StateCallbackExecutorWrapper r100, CameraCaptureSession r101) {
            r100.lambda$onActive$3(r101);
        }

        public static /* synthetic */ void c(StateCallbackExecutorWrapper r100, CameraCaptureSession r101) {
            r100.lambda$onClosed$5(r101);
        }

        public static /* synthetic */ void d(StateCallbackExecutorWrapper r100, CameraCaptureSession r101) {
            r100.lambda$onCaptureQueueEmpty$4(r101);
        }

        public static /* synthetic */ void e(StateCallbackExecutorWrapper r100, CameraCaptureSession r101) {
            r100.lambda$onConfigured$0(r101);
        }

        public static /* synthetic */ void f(StateCallbackExecutorWrapper r100, CameraCaptureSession r101) {
            r100.lambda$onConfigureFailed$1(r101);
        }

        public static /* synthetic */ void g(StateCallbackExecutorWrapper r100, CameraCaptureSession r101) {
            r100.lambda$onReady$2(r101);
        }

        private /* synthetic */ void lambda$onActive$3(CameraCaptureSession r100) {
            this.mWrappedCallback.onActive(r100);
        }

        private /* synthetic */ void lambda$onCaptureQueueEmpty$4(CameraCaptureSession r100) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mWrappedCallback, r100);
        }

        private /* synthetic */ void lambda$onClosed$5(CameraCaptureSession r100) {
            this.mWrappedCallback.onClosed(r100);
        }

        private /* synthetic */ void lambda$onConfigureFailed$1(CameraCaptureSession r100) {
            this.mWrappedCallback.onConfigureFailed(r100);
        }

        private /* synthetic */ void lambda$onConfigured$0(CameraCaptureSession r100) {
            this.mWrappedCallback.onConfigured(r100);
        }

        private /* synthetic */ void lambda$onReady$2(CameraCaptureSession r100) {
            this.mWrappedCallback.onReady(r100);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(final CameraCaptureSession r100) {
            this.mExecutor.execute(new k(this, r100));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(final CameraCaptureSession r100) {
            this.mExecutor.execute(new j(this, r100));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(final CameraCaptureSession r100) {
            this.mExecutor.execute(new i(this, r100));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(final CameraCaptureSession r100) {
            this.mExecutor.execute(new l(this, r100));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(final CameraCaptureSession r100) {
            this.mExecutor.execute(new h(this, r100));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(final CameraCaptureSession r100) {
            this.mExecutor.execute(new m(this, r100));
        }

        public StateCallbackExecutorWrapper(Executor r100, CameraCaptureSession.StateCallback r101) {
            this.mExecutor = r100;
            this.mWrappedCallback = r101;
        }

        private /* synthetic */ void lambda$onSurfacePrepared$6(CameraCaptureSession r100, Surface r101) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mWrappedCallback, r100, r101);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(final CameraCaptureSession r100, final Surface r101) {
            this.mExecutor.execute(new n(this, r100, r101));
        }
    }

    public CameraCaptureSession toCameraCaptureSession() {
        return this.mImpl.unwrap();
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession r100) {
        return toCameraCaptureSessionCompat(r100, MainThreadAsyncHandler.getInstance());
    }

    private CameraCaptureSessionCompat(CameraCaptureSession r100, Handler r101) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mImpl = new CameraCaptureSessionCompatApi28Impl(r100);
        return;
    L5:
        this.mImpl = CameraCaptureSessionCompatBaseImpl.create(r100, r101);
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession r100, Handler r101) {
        return new CameraCaptureSessionCompat(r100, r101);
    }

    public int captureBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mImpl.captureBurstRequests(r100, r101, r102);
    }

    public int captureSingleRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mImpl.captureSingleRequest(r100, r101, r102);
    }

    public int setRepeatingBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mImpl.setRepeatingBurstRequests(r100, r101, r102);
    }

    public int setSingleRepeatingRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException {
        return this.mImpl.setSingleRepeatingRequest(r100, r101, r102);
    }
}
