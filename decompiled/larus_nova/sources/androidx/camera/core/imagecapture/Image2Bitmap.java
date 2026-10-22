package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class Image2Bitmap implements Operation<Packet<ImageProxy>, Bitmap> {
    public Image2Bitmap() {
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Bitmap apply2(Packet<ImageProxy> r110) throws ImageCaptureException {
        SafeCloseImageReaderProxy r100 = null;
    L35:
        e = e;
    L37:
        if (r110.getFormat() != 35) goto L39;
        String r111 = "YUV";
    L41:
        throw new ImageCaptureException(0, "Can't convert " + r111 + " to bitmap", e);     // Catch: Throwable -> L33
    L39:
        r111 = "JPEG";
        goto L41
    L4:
        if (r110.getFormat() != 35) goto L26;
        ImageProxy r101 = r110.getData();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        if ((r110.getRotationDegrees() % 180) == 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        int r103 = r101.getHeight();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
    L12:
        if (r102 == false) goto L14;
        int r104 = r101.getWidth();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
    L15:
        SafeCloseImageReaderProxy r105 = new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r103, r104, 1, 2));     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        ImageProxy r106 = ImageProcessingUtil.convertYUVToRGB(r101, r105, ByteBuffer.allocateDirect((r101.getWidth() * r101.getHeight()) * 4), r110.getRotationDegrees(), false);     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        r101.close();     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        if (r106 == null) goto L20;
        Bitmap r107 = ImageUtil.createBitmapFromImageProxy(r106);     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        r106.close();     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        r100 = r105;
    L28:
        if (r100 == null) goto L30;
        r100.close();
    L30:
        return r107;
    L20:
        throw new ImageCaptureException(0, "Can't covert YUV to RGB", null);     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
    L23:
        e = e;
    L21:
        th = th;
        r100 = r105;
    L42:
        if (r100 == null) goto L44;
        r100.close();
    L44:
        throw th;
    L14:
        r104 = r101.getHeight();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        goto L15
    L11:
        r103 = r101.getWidth();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        goto L12
    L8:
        r102 = false;
        goto L9
    L26:
        if (r110.getFormat() != 256) goto L32;
        ImageProxy r108 = r110.getData();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        Bitmap r109 = ImageUtil.createBitmapFromImageProxy(r108);     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        r108.close();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        r107 = ImageUtil.rotateBitmap(r109, r110.getRotationDegrees());     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        goto L28
    L32:
        throw new IllegalArgumentException("Invalid postview image format : " + r110.getFormat());     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
    L33:
        th = th;
        goto L42
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Bitmap apply(Packet<ImageProxy> r100) throws ImageCaptureException {
        return apply2(r100);
    }
}
