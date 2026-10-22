package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: classes2.dex */
public class JpegImage2Result implements Operation<Packet<ImageProxy>, ImageProxy> {
    public JpegImage2Result() {
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ImageProxy apply2(Packet<ImageProxy> r100) throws ImageCaptureException {
        ImageProxy r101 = r100.getData();
        ImageInfo r102 = ImmutableImageInfo.create(r101.getImageInfo().getTagBundle(), r101.getImageInfo().getTimestamp(), r100.getRotationDegrees(), r100.getSensorToBufferTransform());
        SettableImageProxy r103 = new SettableImageProxy(r101, r100.getSize(), r102);
        r103.setCropRect(r100.getCropRect());
        return r103;
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ ImageProxy apply(Packet<ImageProxy> r100) throws ImageCaptureException {
        return apply2(r100);
    }
}
