package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public interface SynchronizedCaptureSession {

    public interface Opener {
        SessionConfigurationCompat createSessionConfigurationCompat(int r100, List<OutputConfigurationCompat> r101, StateCallback r102);

        Executor getExecutor();

        ListenableFuture<Void> openCaptureSession(CameraDevice r100, SessionConfigurationCompat r101, List<DeferrableSurface> r102);

        ListenableFuture<List<Surface>> startWithDeferrableSurface(List<DeferrableSurface> r100, long r101);

        boolean stop();
    }

    public static class OpenerBuilder {
        private final Quirks mCameraQuirks;
        private final CaptureSessionRepository mCaptureSessionRepository;
        private final Handler mCompatHandler;
        private final Quirks mDeviceQuirks;
        private final Executor mExecutor;
        private final ScheduledExecutorService mScheduledExecutorService;

        public Opener build() {
            return new SynchronizedCaptureSessionImpl(this.mCameraQuirks, this.mDeviceQuirks, this.mCaptureSessionRepository, this.mExecutor, this.mScheduledExecutorService, this.mCompatHandler);
        }

        public OpenerBuilder(Executor r100, ScheduledExecutorService r101, Handler r102, CaptureSessionRepository r103, Quirks r104, Quirks r105) {
            this.mExecutor = r100;
            this.mScheduledExecutorService = r101;
            this.mCompatHandler = r102;
            this.mCaptureSessionRepository = r103;
            this.mCameraQuirks = r104;
            this.mDeviceQuirks = r105;
        }
    }

    public static abstract class StateCallback {
        public StateCallback() {
        }

        public void onActive(SynchronizedCaptureSession r100) {
        }

        public void onCaptureQueueEmpty(SynchronizedCaptureSession r100) {
        }

        public void onClosed(SynchronizedCaptureSession r100) {
        }

        public void onConfigureFailed(SynchronizedCaptureSession r100) {
        }

        public void onConfigured(SynchronizedCaptureSession r100) {
        }

        public void onReady(SynchronizedCaptureSession r100) {
        }

        public void onSessionFinished(SynchronizedCaptureSession r100) {
        }

        public void onSurfacePrepared(SynchronizedCaptureSession r100, Surface r101) {
        }
    }

    void abortCaptures() throws CameraAccessException;

    int captureBurstRequests(List<CaptureRequest> r100, CameraCaptureSession.CaptureCallback r101) throws CameraAccessException;

    int captureBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

    int captureSingleRequest(CaptureRequest r100, CameraCaptureSession.CaptureCallback r101) throws CameraAccessException;

    int captureSingleRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

    void close();

    void finishClose();

    CameraDevice getDevice();

    Surface getInputSurface();

    ListenableFuture<Void> getOpeningBlocker();

    StateCallback getStateCallback();

    void onCameraDeviceError(int r100);

    int setRepeatingBurstRequests(List<CaptureRequest> r100, CameraCaptureSession.CaptureCallback r101) throws CameraAccessException;

    int setRepeatingBurstRequests(List<CaptureRequest> r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

    int setSingleRepeatingRequest(CaptureRequest r100, CameraCaptureSession.CaptureCallback r101) throws CameraAccessException;

    int setSingleRepeatingRequest(CaptureRequest r100, Executor r101, CameraCaptureSession.CaptureCallback r102) throws CameraAccessException;

    void stopRepeating() throws CameraAccessException;

    CameraCaptureSessionCompat toCameraCaptureSessionCompat();
}
