package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
final class ImageWriterCompatApi23Impl {
    private ImageWriterCompatApi23Impl() {
    }

    public static void close(ImageWriter r100) {
        r100.close();
    }

    public static Image dequeueInputImage(ImageWriter r100) {
        return r100.dequeueInputImage();
    }

    public static ImageWriter newInstance(Surface r100, int r101) {
        return ImageWriter.newInstance(r100, r101);
    }

    public static void queueInputImage(ImageWriter r100, Image r101) {
        r100.queueInputImage(r101);
    }
}
