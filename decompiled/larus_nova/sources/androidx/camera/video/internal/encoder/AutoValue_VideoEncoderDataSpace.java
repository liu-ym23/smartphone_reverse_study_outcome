package androidx.camera.video.internal.encoder;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_VideoEncoderDataSpace extends VideoEncoderDataSpace {
    private final int range;
    private final int standard;
    private final int transfer;

    public int hashCode() {
        return ((((this.standard ^ 1000003) * 1000003) ^ this.transfer) * 1000003) ^ this.range;
    }

    public String toString() {
        return "VideoEncoderDataSpace{standard=" + this.standard + ", transfer=" + this.transfer + ", range=" + this.range + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getRange() {
        return this.range;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getStandard() {
        return this.standard;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getTransfer() {
        return this.transfer;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoEncoderDataSpace) == false) goto L16;
        VideoEncoderDataSpace r101 = (VideoEncoderDataSpace) r100;
        if (this.standard == r101.getStandard()) goto L10;
    L14:
        return false;
    L10:
        if (this.transfer != r101.getTransfer()) goto L14;
        if (this.range != r101.getRange()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_VideoEncoderDataSpace(int r100, int r101, int r102) {
        this.standard = r100;
        this.transfer = r101;
        this.range = r102;
    }
}
