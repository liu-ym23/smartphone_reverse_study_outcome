package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static void close(ImageWriter r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 23) goto L7;
        ImageWriterCompatApi23Impl.close(r100);
        return;
    L7:
        throw new RuntimeException("Unable to call close() on API " + r101 + ". Version 23 or higher required.");
    }

    public static Image dequeueInputImage(ImageWriter r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 23) goto L7;
        return ImageWriterCompatApi23Impl.dequeueInputImage(r100);
    L7:
        throw new RuntimeException("Unable to call dequeueInputImage() on API " + r101 + ". Version 23 or higher required.");
    }

    public static ImageWriter newInstance(Surface r100, int r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 23) goto L7;
        return ImageWriterCompatApi23Impl.newInstance(r100, r101);
    L7:
        throw new RuntimeException("Unable to call newInstance(Surface, int) on API " + r102 + ". Version 23 or higher required.");
    }

    public static void queueInputImage(ImageWriter r100, Image r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 23) goto L7;
        ImageWriterCompatApi23Impl.queueInputImage(r100, r101);
        return;
    L7:
        throw new RuntimeException("Unable to call queueInputImage() on API " + r102 + ". Version 23 or higher required.");
    }

    public static ImageWriter newInstance(Surface r100, int r101, int r102) {
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 29) goto L7;
        return ImageWriterCompatApi29Impl.newInstance(r100, r101, r102);
    L7:
        if (r103 < 26) goto L11;
        return ImageWriterCompatApi26Impl.newInstance(r100, r101, r102);
    L11:
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + r103 + ". Version 26 or higher required.");
    }
}
