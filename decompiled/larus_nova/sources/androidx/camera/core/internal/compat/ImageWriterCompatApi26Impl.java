package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class ImageWriterCompatApi26Impl {
    private static final String TAG = "ImageWriterCompatApi26";
    private static Method sNewInstanceMethod;

    static {
        Class r100 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
        sNewInstanceMethod = ImageWriter.class.getMethod("newInstance", new Class[]{Surface.class, r100, r100});     // Catch: NoSuchMethodException -> L4
        return;
    }

    private ImageWriterCompatApi26Impl() {
    }

    public static ImageWriter newInstance(Surface r100, int r101, int r102) {
        Throwable r103 = null;
        if (Build.VERSION.SDK_INT < 26) goto L11;
        return (ImageWriter) Preconditions.checkNotNull(sNewInstanceMethod.invoke(null, new Object[]{r100, Integer.valueOf(r101), Integer.valueOf(r102)}));
    L6:
        e = move-exception;
        r103 = e;
    L11:
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", r103);
    }
}
