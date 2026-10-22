package J;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;

/* loaded from: classes.dex */
public interface c0 {
    void a(ImageCapture.g gVar);

    void b(ImageCaptureException imageCaptureException);

    void c(androidx.camera.core.i iVar);

    boolean d();

    void e(ImageCaptureException imageCaptureException);

    void f();

    void onCaptureProcessProgressed(int i10);

    void onCaptureStarted();

    void onPostviewBitmapAvailable(Bitmap bitmap);
}
