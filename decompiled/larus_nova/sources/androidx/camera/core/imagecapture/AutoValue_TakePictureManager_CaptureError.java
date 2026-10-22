package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_TakePictureManager_CaptureError extends TakePictureManager.CaptureError {
    private final ImageCaptureException imageCaptureException;
    private final int requestId;

    public int hashCode() {
        return ((this.requestId ^ 1000003) * 1000003) ^ this.imageCaptureException.hashCode();
    }

    public String toString() {
        return "CaptureError{requestId=" + this.requestId + ", imageCaptureException=" + this.imageCaptureException + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureManager.CaptureError
    public ImageCaptureException getImageCaptureException() {
        return this.imageCaptureException;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureManager.CaptureError
    public int getRequestId() {
        return this.requestId;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof TakePictureManager.CaptureError) == false) goto L14;
        TakePictureManager.CaptureError r101 = (TakePictureManager.CaptureError) r100;
        if (this.requestId == r101.getRequestId()) goto L10;
    L12:
        return false;
    L10:
        if (this.imageCaptureException.equals(r101.getImageCaptureException()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_TakePictureManager_CaptureError(int r100, ImageCaptureException r101) {
        this.requestId = r100;
        if (r101 == null) goto L7;
        this.imageCaptureException = r101;
        return;
    L7:
        throw new NullPointerException("Null imageCaptureException");
    }
}
