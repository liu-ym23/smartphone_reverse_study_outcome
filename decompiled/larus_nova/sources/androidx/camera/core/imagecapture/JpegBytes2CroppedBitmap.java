package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class JpegBytes2CroppedBitmap implements Operation<Packet<byte[]>, Packet<Bitmap>> {
    public JpegBytes2CroppedBitmap() {
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<Bitmap> apply2(Packet<byte[]> r100) throws ImageCaptureException {
        Rect r101 = r100.getCropRect();
        Bitmap r102 = createCroppedBitmap(r100.getData(), r101);
        Exif r103 = r100.getExif();
        Objects.requireNonNull(r103);
        return Packet.of(r102, r103, new Rect(0, 0, r102.getWidth(), r102.getHeight()), r100.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(r100.getSensorToBufferTransform(), r101), r100.getCameraCaptureResult());
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<Bitmap> apply(Packet<byte[]> r100) throws ImageCaptureException {
        return apply2(r100);
    }

    private Bitmap createCroppedBitmap(byte[] r100, Rect r101) throws ImageCaptureException {
        BitmapRegionDecoder r102 = BitmapRegionDecoder.newInstance(r100, 0, r100.length, false);     // Catch: IOException -> L5
        return r102.decodeRegion(r101, new BitmapFactory.Options());
    L5:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to decode JPEG.", e);
    }
}
