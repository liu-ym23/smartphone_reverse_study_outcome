package androidx.camera.core;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraControl {

    public static final class OperationCanceledException extends Exception {
        public OperationCanceledException(String r100) {
            super(r100);
        }

        public OperationCanceledException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    ListenableFuture<Void> cancelFocusAndMetering();

    ListenableFuture<Void> enableTorch(boolean r100);

    ListenableFuture<Integer> setExposureCompensationIndex(int r100);

    ListenableFuture<Void> setLinearZoom(float r100);

    ListenableFuture<Void> setZoomRatio(float r100);

    ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction r100);
}
