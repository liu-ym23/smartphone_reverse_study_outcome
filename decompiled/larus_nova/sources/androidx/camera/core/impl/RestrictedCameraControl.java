package androidx.camera.core.impl;

import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.SessionProcessorUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictedCameraControl extends ForwardingCameraControl {
    private final CameraControlInternal mCameraControl;
    private final SessionProcessor mSessionProcessor;

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControl.cancelFocusAndMetering();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    public CameraControlInternal getImplementation() {
        return this.mCameraControl;
    }

    public SessionProcessor getSessionProcessor() {
        return this.mSessionProcessor;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> enableTorch(boolean r100) {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{6}) == true) goto L7;
        return Futures.immediateFailedFuture(new IllegalStateException("Torch is not supported"));
    L7:
        return this.mCameraControl.enableTorch(r100);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Integer> setExposureCompensationIndex(int r100) {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{7}) == true) goto L7;
        return Futures.immediateFailedFuture(new IllegalStateException("ExposureCompensation is not supported"));
    L7:
        return this.mCameraControl.setExposureCompensationIndex(r100);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> setLinearZoom(float r100) {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{0}) == true) goto L7;
        return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
    L7:
        return this.mCameraControl.setLinearZoom(r100);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<Void> setZoomRatio(float r100) {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{0}) == true) goto L7;
        return Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported"));
    L7:
        return this.mCameraControl.setZoomRatio(r100);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction r100) {
        FocusMeteringAction r101 = SessionProcessorUtil.getModifiedFocusMeteringAction(this.mSessionProcessor, r100);
        if (r101 != null) goto L7;
        return Futures.immediateFailedFuture(new IllegalStateException("FocusMetering is not supported"));
    L7:
        return this.mCameraControl.startFocusAndMetering(r101);
    }

    public RestrictedCameraControl(CameraControlInternal r100, SessionProcessor r101) {
        super(r100);
        this.mCameraControl = r100;
        this.mSessionProcessor = r101;
    }
}
