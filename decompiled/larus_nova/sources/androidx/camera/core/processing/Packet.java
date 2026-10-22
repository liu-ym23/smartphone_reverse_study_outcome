package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Packet<T> {
    public Packet() {
    }

    public abstract CameraCaptureResult getCameraCaptureResult();

    public abstract Rect getCropRect();

    public abstract T getData();

    public abstract Exif getExif();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    public abstract Matrix getSensorToBufferTransform();

    public abstract Size getSize();

    public boolean hasCropping() {
        return TransformUtils.hasCropping(getCropRect(), getSize());
    }

    public static Packet<Bitmap> of(Bitmap r110, Exif r111, Rect r112, int r113, Matrix r114, CameraCaptureResult r115) {
        return new AutoValue_Packet(r110, r111, 42, new Size(r110.getWidth(), r110.getHeight()), r112, r113, r114, r115);
    }

    public static Packet<ImageProxy> of(ImageProxy r100, Exif r101, Rect r102, int r110, Matrix r111, CameraCaptureResult r112) {
        return of(r100, r101, new Size(r100.getWidth(), r100.getHeight()), r102, r110, r111, r112);
    }

    public static Packet<ImageProxy> of(ImageProxy r110, Exif r111, Size r112, Rect r113, int r114, Matrix r115, CameraCaptureResult r116) {
        if (ImageUtil.isJpegFormats(r110.getFormat()) == false) goto L7;
        Preconditions.checkNotNull(r111, "JPEG image must have Exif.");
    L7:
        return new AutoValue_Packet(r110, r111, r110.getFormat(), r112, r113, r114, r115, r116);
    }

    public static Packet<byte[]> of(byte[] r110, Exif r111, int r112, Size r113, Rect r114, int r115, Matrix r116, CameraCaptureResult r117) {
        return new AutoValue_Packet(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
