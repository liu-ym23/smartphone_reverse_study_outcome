package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }

    public ImageCaptureException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.mImageCaptureError = r100;
    }
}
