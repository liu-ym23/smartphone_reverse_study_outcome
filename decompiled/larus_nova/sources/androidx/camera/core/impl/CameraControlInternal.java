package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = null;

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraControlInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$decrementVideoUsage(CameraControlInternal r100) {
        }

        public static CameraControlInternal $default$getImplementation(CameraControlInternal r100) {
            return r100;
        }

        public static void $default$incrementVideoUsage(CameraControlInternal r100) {
        }

        public static boolean $default$isInVideoUsage(CameraControlInternal r100) {
            return false;
        }

        public static void $default$setScreenFlash(CameraControlInternal r100, ImageCapture.ScreenFlash r101) {
        }

        public static ListenableFuture $default$getCameraCapturePipelineAsync(final CameraControlInternal r100, int r101, int r102) {
            return Futures.immediateFuture(new AnonymousClass1(r100));
        }
    }

    public static final class CameraControlException extends Exception {
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(CameraCaptureFailure r100) {
            this.mCameraCaptureFailure = r100;
        }

        public CameraControlException(CameraCaptureFailure r100, Throwable r101) {
            super(r101);
            this.mCameraCaptureFailure = r100;
        }
    }

    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(List<CaptureConfig> r100);

        void onCameraControlUpdateSessionConfig();
    }

    void addInteropConfig(Config r100);

    void addZslConfig(SessionConfig.Builder r100);

    void clearInteropConfig();

    void decrementVideoUsage();

    ListenableFuture<CameraCapturePipeline> getCameraCapturePipelineAsync(int r100, int r101);

    int getFlashMode();

    CameraControlInternal getImplementation();

    Config getInteropConfig();

    Rect getSensorRect();

    SessionConfig getSessionConfig();

    void incrementVideoUsage();

    boolean isInVideoUsage();

    boolean isZslDisabledByByUserCaseConfig();

    void setFlashMode(int r100);

    void setScreenFlash(ImageCapture.ScreenFlash r100);

    void setZslDisabledByUserCaseConfig(boolean r100);

    ListenableFuture<List<Void>> submitStillCaptureRequests(List<CaptureConfig> r100, int r101, int r102);

    static {
        DEFAULT_EMPTY_INSTANCE = new AnonymousClass2();
    }
}
