package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
final class CaptureCallbackAdapter extends CameraCaptureSession.CaptureCallback {
    private final CameraCaptureCallback mCameraCaptureCallback;

    public CaptureCallbackAdapter(CameraCaptureCallback r100) {
        if (r100 == null) goto L7;
        this.mCameraCaptureCallback = r100;
        return;
    L7:
        throw new NullPointerException("cameraCaptureCallback is null");
    }

    private int getCaptureConfigId(CaptureRequest r100) {
        if ((r100.getTag() instanceof TagBundle) == true) goto L5;
        return -1;
    L5:
        Integer r101 = (Integer) ((TagBundle) r100.getTag()).getTag(CaptureConfig.CAPTURE_CONFIG_ID_TAG_KEY);
        if (r101 != null) goto L9;
        return -1;
    L9:
        return r101.intValue();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession r100, CaptureRequest r101, TotalCaptureResult r102) {
        super.onCaptureCompleted(r100, r101, r102);
        Object r103 = r101.getTag();
        if (r103 == null) goto L5;
        Preconditions.checkArgument(r103 instanceof TagBundle, "The tagBundle object from the CaptureResult is not a TagBundle object.");
        TagBundle r104 = (TagBundle) r103;
    L6:
        this.mCameraCaptureCallback.onCaptureCompleted(getCaptureConfigId(r101), new Camera2CameraCaptureResult(r104, r102));
        return;
    L5:
        r104 = TagBundle.emptyBundle();
        goto L6
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession r100, CaptureRequest r101, CaptureFailure r102) {
        super.onCaptureFailed(r100, r101, r102);
        CameraCaptureFailure r103 = new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR);
        this.mCameraCaptureCallback.onCaptureFailed(getCaptureConfigId(r101), r103);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession r100, CaptureRequest r101, long r102, long r103) {
        super.onCaptureStarted(r100, r101, r102, r103);
        this.mCameraCaptureCallback.onCaptureStarted(getCaptureConfigId(r101));
    }
}
