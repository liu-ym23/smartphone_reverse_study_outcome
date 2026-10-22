package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class Bitmap2JpegBytes implements Operation<In, Packet<byte[]>> {

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static boolean hasGainmap(Bitmap r100) {
            return r100.hasGainmap();
        }
    }

    public static abstract class In {
        public In() {
        }

        public abstract int getJpegQuality();

        public abstract Packet<Bitmap> getPacket();

        public static In of(Packet<Bitmap> r100, int r101) {
            return new AutoValue_Bitmap2JpegBytes_In(r100, r101);
        }
    }

    public Bitmap2JpegBytes() {
    }

    private static int getOutputFormat(Bitmap r100) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return 256;
    L5:
        if (Api34Impl.hasGainmap(r100) == false) goto L10;
        return 4101;
    L10:
        return 256;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<byte[]> apply2(In r110) throws ImageCaptureException {
        Packet<Bitmap> r100 = r110.getPacket();
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        r100.getData().compress(Bitmap.CompressFormat.JPEG, r110.getJpegQuality(), r101);
        byte[] r102 = r101.toByteArray();
        Exif r103 = r100.getExif();
        Objects.requireNonNull(r103);
        return Packet.of(r102, r103, getOutputFormat(r100.getData()), r100.getSize(), r100.getCropRect(), r100.getRotationDegrees(), r100.getSensorToBufferTransform(), r100.getCameraCaptureResult());
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<byte[]> apply(In r100) throws ImageCaptureException {
        return apply2(r100);
    }
}
