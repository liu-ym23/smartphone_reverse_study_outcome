package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_ImmutableImageInfo extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransformMatrix;
    private final TagBundle tagBundle;
    private final long timestamp;

    public int hashCode() {
        int r100 = (this.tagBundle.hashCode() ^ 1000003) * 1000003;
        long r101 = this.timestamp;
        return ((((r100 ^ ((int) (r101 ^ (r101 >>> 32)))) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.sensorToBufferTransformMatrix.hashCode();
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.tagBundle + ", timestamp=" + this.timestamp + ", rotationDegrees=" + this.rotationDegrees + ", sensorToBufferTransformMatrix=" + this.sensorToBufferTransformMatrix + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public Matrix getSensorToBufferTransformMatrix() {
        return this.sensorToBufferTransformMatrix;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public TagBundle getTagBundle() {
        return this.tagBundle;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableImageInfo) == false) goto L18;
        ImmutableImageInfo r101 = (ImmutableImageInfo) r100;
        if (this.tagBundle.equals(r101.getTagBundle()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.timestamp != r101.getTimestamp()) goto L16;
        if (this.rotationDegrees != r101.getRotationDegrees()) goto L16;
        if (this.sensorToBufferTransformMatrix.equals(r101.getSensorToBufferTransformMatrix()) == false) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_ImmutableImageInfo(TagBundle r100, long r101, int r102, Matrix r103) {
        if (r100 == null) goto L11;
        this.tagBundle = r100;
        this.timestamp = r101;
        this.rotationDegrees = r102;
        if (r103 == null) goto L9;
        this.sensorToBufferTransformMatrix = r103;
        return;
    L9:
        throw new NullPointerException("Null sensorToBufferTransformMatrix");
    L11:
        throw new NullPointerException("Null tagBundle");
    }
}
