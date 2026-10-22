package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_Packet<T> extends Packet<T> {
    private final CameraCaptureResult cameraCaptureResult;
    private final Rect cropRect;
    private final T data;
    private final Exif exif;
    private final int format;
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransform;
    private final Size size;

    public int hashCode() {
        int r100 = (this.data.hashCode() ^ 1000003) * 1000003;
        Exif r101 = this.exif;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((((((((r100 ^ r102) * 1000003) ^ this.format) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.cameraCaptureResult.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "Packet{data=" + this.data + ", exif=" + this.exif + ", format=" + this.format + ", size=" + this.size + ", cropRect=" + this.cropRect + ", rotationDegrees=" + this.rotationDegrees + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", cameraCaptureResult=" + this.cameraCaptureResult + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.processing.Packet
    public CameraCaptureResult getCameraCaptureResult() {
        return this.cameraCaptureResult;
    }

    @Override // androidx.camera.core.processing.Packet
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.processing.Packet
    public T getData() {
        return this.data;
    }

    @Override // androidx.camera.core.processing.Packet
    public Exif getExif() {
        return this.exif;
    }

    @Override // androidx.camera.core.processing.Packet
    public int getFormat() {
        return this.format;
    }

    @Override // androidx.camera.core.processing.Packet
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.processing.Packet
    public Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    @Override // androidx.camera.core.processing.Packet
    public Size getSize() {
        return this.size;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Packet) == false) goto L31;
        Packet r101 = (Packet) r100;
        if (this.data.equals(r101.getData()) == false) goto L29;
        Exif r102 = this.exif;
        if (r102 != null) goto L15;
        if (r101.getExif() != null) goto L29;
    L17:
        if (this.format != r101.getFormat()) goto L29;
        if (this.size.equals(r101.getSize()) == false) goto L29;
        if (this.cropRect.equals(r101.getCropRect()) == false) goto L29;
        if (this.rotationDegrees != r101.getRotationDegrees()) goto L29;
        if (this.sensorToBufferTransform.equals(r101.getSensorToBufferTransform()) == false) goto L29;
        if (this.cameraCaptureResult.equals(r101.getCameraCaptureResult()) == false) goto L29;
        return true;
    L15:
        if (r102.equals(r101.getExif()) == true) goto L17;
    L29:
        return false;
    L31:
        return false;
    }

    public AutoValue_Packet(T r100, Exif r101, int r102, Size r103, Rect r104, int r105, Matrix r106, CameraCaptureResult r107) {
        if (r100 == null) goto L23;
        this.data = r100;
        this.exif = r101;
        this.format = r102;
        if (r103 == null) goto L21;
        this.size = r103;
        if (r104 == null) goto L19;
        this.cropRect = r104;
        this.rotationDegrees = r105;
        if (r106 == null) goto L17;
        this.sensorToBufferTransform = r106;
        if (r107 == null) goto L15;
        this.cameraCaptureResult = r107;
        return;
    L15:
        throw new NullPointerException("Null cameraCaptureResult");
    L17:
        throw new NullPointerException("Null sensorToBufferTransform");
    L19:
        throw new NullPointerException("Null cropRect");
    L21:
        throw new NullPointerException("Null size");
    L23:
        throw new NullPointerException("Null data");
    }
}
