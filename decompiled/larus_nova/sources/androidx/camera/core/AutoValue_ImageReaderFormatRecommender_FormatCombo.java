package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_ImageReaderFormatRecommender_FormatCombo extends ImageReaderFormatRecommender.FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    public int hashCode() {
        return ((this.imageCaptureFormat ^ 1000003) * 1000003) ^ this.imageAnalysisFormat;
    }

    public String toString() {
        return "FormatCombo{imageCaptureFormat=" + this.imageCaptureFormat + ", imageAnalysisFormat=" + this.imageAnalysisFormat + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    public int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    public int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageReaderFormatRecommender.FormatCombo) == false) goto L14;
        ImageReaderFormatRecommender.FormatCombo r101 = (ImageReaderFormatRecommender.FormatCombo) r100;
        if (this.imageCaptureFormat == r101.imageCaptureFormat()) goto L10;
    L12:
        return false;
    L10:
        if (this.imageAnalysisFormat != r101.imageAnalysisFormat()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_ImageReaderFormatRecommender_FormatCombo(int r100, int r101) {
        this.imageCaptureFormat = r100;
        this.imageAnalysisFormat = r101;
    }
}
