package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
final class ImageWriterCompatApi29Impl {
    private ImageWriterCompatApi29Impl() {
    }

    public static ImageWriter newInstance(Surface r100, int r101, int r102) {
        return ImageWriter.newInstance(r100, r101, r102);
    }
}
