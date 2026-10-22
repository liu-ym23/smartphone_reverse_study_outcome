package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: classes2.dex */
interface TakePictureCallback {
    boolean isAborted();

    void onCaptureFailure(ImageCaptureException r100);

    void onCaptureProcessProgressed(int r100);

    void onCaptureStarted();

    void onFinalResult(ImageCapture.OutputFileResults r100);

    void onFinalResult(ImageProxy r100);

    void onImageCaptured();

    void onPostviewBitmapAvailable(Bitmap r100);

    void onProcessFailure(ImageCaptureException r100);
}
