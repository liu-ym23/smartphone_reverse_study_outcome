package androidx.camera.core.imagecapture;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.workaround.JpegMetadataCorrector;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.ByteArrayInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class Image2JpegBytes implements Operation<In, Packet<byte[]>> {
    private final JpegMetadataCorrector mJpegMetadataCorrector;

    public static abstract class In {
        public In() {
        }

        public abstract int getJpegQuality();

        public abstract Packet<ImageProxy> getPacket();

        public static In of(Packet<ImageProxy> r100, int r101) {
            return new AutoValue_Image2JpegBytes_In(r100, r101);
        }
    }

    public Image2JpegBytes(Quirks r100) {
        this.mJpegMetadataCorrector = new JpegMetadataCorrector(r100);
    }

    private static Exif extractExif(byte[] r100) throws ImageCaptureException {
        return Exif.createFromInputStream(new ByteArrayInputStream(r100));
    L4:
        e = move-exception;
        throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e);
    }

    private Packet<byte[]> processYuvImage(In r110) throws ImageCaptureException {
        Packet<ImageProxy> r100 = r110.getPacket();
        ImageProxy r101 = r100.getData();
        Rect r102 = r100.getCropRect();
        byte[] r103 = ImageUtil.yuvImageToJpegByteArray(r101, r102, r110.getJpegQuality(), r100.getRotationDegrees());     // Catch: ImageUtil.CodecFailedException -> L6
        return Packet.of(r103, extractExif(r103), 256, new Size(r102.width(), r102.height()), new Rect(0, 0, r102.width(), r102.height()), r100.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(r100.getSensorToBufferTransform(), r102), r100.getCameraCaptureResult());
    L6:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to encode the image to JPEG.", e);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<byte[]> apply2(In r100) throws ImageCaptureException {
        int r101 = r100.getPacket().getFormat();     // Catch: Throwable -> L17
        if (r101 != 35) goto L6;
        Packet<byte[]> r102 = processYuvImage(r100);     // Catch: Throwable -> L17
    L13:
        r100.getPacket().getData().close();
        return r102;
    L6:
        if (r101 != 256) goto L8;
    L12:
        r102 = processJpegImage(r100, r101);     // Catch: Throwable -> L17
        goto L13
    L8:
        if (r101 == 4101) goto L12;
        throw new IllegalArgumentException("Unexpected format: " + r101);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r100.getPacket().getData().close();
        throw th;
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<byte[]> apply(In r100) throws ImageCaptureException {
        return apply2(r100);
    }

    private Packet<byte[]> processJpegImage(In r110, int r111) {
        Packet<ImageProxy> r112 = r110.getPacket();
        byte[] r100 = this.mJpegMetadataCorrector.jpegImageToJpegByteArray(r112.getData());
        Exif r101 = r112.getExif();
        Objects.requireNonNull(r101);
        return Packet.of(r100, r101, r111, r112.getSize(), r112.getCropRect(), r112.getRotationDegrees(), r112.getSensorToBufferTransform(), r112.getCameraCaptureResult());
    }
}
