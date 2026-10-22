package androidx.camera.video;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_QualityRatioToResolutionsTable_QualityRatio extends QualityRatioToResolutionsTable.QualityRatio {
    private final int aspectRatio;
    private final Quality quality;

    public int hashCode() {
        return ((this.quality.hashCode() ^ 1000003) * 1000003) ^ this.aspectRatio;
    }

    public String toString() {
        return "QualityRatio{quality=" + this.quality + ", aspectRatio=" + this.aspectRatio + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    public int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    public Quality getQuality() {
        return this.quality;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof QualityRatioToResolutionsTable.QualityRatio) == false) goto L14;
        QualityRatioToResolutionsTable.QualityRatio r101 = (QualityRatioToResolutionsTable.QualityRatio) r100;
        if (this.quality.equals(r101.getQuality()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.aspectRatio != r101.getAspectRatio()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_QualityRatioToResolutionsTable_QualityRatio(Quality r100, int r101) {
        if (r100 == null) goto L7;
        this.quality = r100;
        this.aspectRatio = r101;
        return;
    L7:
        throw new NullPointerException("Null quality");
    }
}
