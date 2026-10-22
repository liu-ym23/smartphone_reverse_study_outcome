package androidx.camera.core.imagecapture;

import androidx.camera.core.impl.CaptureConfig;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraRequest {
    private final TakePictureCallback mCallback;
    private final List<CaptureConfig> mCaptureConfigs;

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }

    public List<CaptureConfig> getCaptureConfigs() {
        return this.mCaptureConfigs;
    }

    public CameraRequest(List<CaptureConfig> r100, TakePictureCallback r101) {
        this.mCaptureConfigs = r100;
        this.mCallback = r101;
    }
}
