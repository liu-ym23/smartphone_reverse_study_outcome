package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class JpegBytes2Image implements Operation<Packet<byte[]>, Packet<ImageProxy>> {
    private static final int MAX_IMAGES = 2;

    public JpegBytes2Image() {
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<ImageProxy> apply2(Packet<byte[]> r100) throws ImageCaptureException {
        SafeCloseImageReaderProxy r101 = new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r100.getSize().getWidth(), r100.getSize().getHeight(), 256, 2));
        ImageProxy r102 = ImageProcessingUtil.convertJpegBytesToImage(r101, r100.getData());
        r101.safeClose();
        Objects.requireNonNull(r102);
        Exif r103 = r100.getExif();
        Objects.requireNonNull(r103);
        return Packet.of(r102, r103, r100.getCropRect(), r100.getRotationDegrees(), r100.getSensorToBufferTransform(), r100.getCameraCaptureResult());
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<ImageProxy> apply(Packet<byte[]> r100) throws ImageCaptureException {
        return apply2(r100);
    }
}
