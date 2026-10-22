package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.ImageProcessorRequest;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapEffect implements Operation<Packet<Bitmap>, Packet<Bitmap>> {
    private final InternalImageProcessor mProcessor;

    public BitmapEffect(InternalImageProcessor r100) {
        this.mProcessor = r100;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<Bitmap> apply2(Packet<Bitmap> r110) throws ImageCaptureException {
        ImageProxy r100 = this.mProcessor.safeProcess(new ImageProcessorRequest(new RgbaImageProxy(r110), 1)).getOutputImage();
        Objects.requireNonNull(r100);
        Bitmap r101 = ImageUtil.createBitmapFromPlane(r100.getPlanes(), r100.getWidth(), r100.getHeight());
        Exif r102 = r110.getExif();
        Objects.requireNonNull(r102);
        return Packet.of(r101, r102, r110.getCropRect(), r110.getRotationDegrees(), r110.getSensorToBufferTransform(), r110.getCameraCaptureResult());
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<Bitmap> apply(Packet<Bitmap> r100) throws ImageCaptureException {
        return apply2(r100);
    }
}
