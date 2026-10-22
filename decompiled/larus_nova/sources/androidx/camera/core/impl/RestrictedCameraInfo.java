package androidx.camera.core.impl;

import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.SessionProcessorUtil;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictedCameraInfo extends ForwardingCameraInfo {
    public static final int CAMERA_OPERATION_AE_REGION = 3;
    public static final int CAMERA_OPERATION_AF_REGION = 2;
    public static final int CAMERA_OPERATION_AUTO_FOCUS = 1;
    public static final int CAMERA_OPERATION_AWB_REGION = 4;
    public static final int CAMERA_OPERATION_EXPOSURE_COMPENSATION = 7;
    public static final int CAMERA_OPERATION_EXTENSION_STRENGTH = 8;
    public static final int CAMERA_OPERATION_FLASH = 5;
    public static final int CAMERA_OPERATION_TORCH = 6;
    public static final int CAMERA_OPERATION_ZOOM = 0;
    private final CameraConfig mCameraConfig;
    private final CameraInfoInternal mCameraInfo;
    private boolean mIsCaptureProcessProgressSupported;
    private boolean mIsPostviewSupported;
    private final SessionProcessor mSessionProcessor;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraOperation {
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public ExposureState getExposureState() {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{7}) == true) goto L7;
        return new AnonymousClass1(this);
    L7:
        return this.mCameraInfo.getExposureState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public LiveData<Integer> getTorchState() {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{6}) == true) goto L7;
        return new MutableLiveData(0);
    L7:
        return this.mCameraInfo.getTorchState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public LiveData<ZoomState> getZoomState() {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{0}) == true) goto L7;
        return new MutableLiveData(ImmutableZoomState.create(1.0f, 1.0f, 1.0f, 0.0f));
    L7:
        return this.mCameraInfo.getZoomState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        if (SessionProcessorUtil.isOperationSupported(this.mSessionProcessor, new int[]{5}) == true) goto L6;
        return false;
    L6:
        return this.mCameraInfo.hasFlashUnit();
    }

    public CameraConfig getCameraConfig() {
        return this.mCameraConfig;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public CameraInfoInternal getImplementation() {
        return this.mCameraInfo;
    }

    public SessionProcessor getSessionProcessor() {
        return this.mSessionProcessor;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public boolean isCaptureProcessProgressSupported() {
        return this.mIsCaptureProcessProgressSupported;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public boolean isPostviewSupported() {
        return this.mIsPostviewSupported;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public boolean isFocusMeteringSupported(FocusMeteringAction r100) {
        FocusMeteringAction r101 = SessionProcessorUtil.getModifiedFocusMeteringAction(this.mSessionProcessor, r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return this.mCameraInfo.isFocusMeteringSupported(r101);
    }

    public void setCaptureProcessProgressSupported(boolean r100) {
        this.mIsCaptureProcessProgressSupported = r100;
    }

    public void setPostviewSupported(boolean r100) {
        this.mIsPostviewSupported = r100;
    }

    public RestrictedCameraInfo(CameraInfoInternal r100, CameraConfig r101) {
        super(r100);
        this.mIsPostviewSupported = false;
        this.mIsCaptureProcessProgressSupported = false;
        this.mCameraInfo = r100;
        this.mCameraConfig = r101;
        this.mSessionProcessor = r101.getSessionProcessor(null);
        setPostviewSupported(r101.isPostviewSupported());
        setCaptureProcessProgressSupported(r101.isCaptureProcessProgressSupported());
    }
}
