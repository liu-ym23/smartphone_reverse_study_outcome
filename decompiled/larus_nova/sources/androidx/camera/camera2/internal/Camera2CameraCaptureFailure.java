package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureFailure;
import androidx.camera.core.impl.CameraCaptureFailure;

/* JADX INFO: loaded from: classes2.dex */
public final class Camera2CameraCaptureFailure extends CameraCaptureFailure {
    private final CaptureFailure mCaptureFailure;

    @Override // androidx.camera.core.impl.CameraCaptureFailure
    public Object getCaptureFailure() {
        return this.mCaptureFailure;
    }

    public Camera2CameraCaptureFailure(CameraCaptureFailure.Reason r100, CaptureFailure r101) {
        super(r100);
        this.mCaptureFailure = r101;
    }
}
