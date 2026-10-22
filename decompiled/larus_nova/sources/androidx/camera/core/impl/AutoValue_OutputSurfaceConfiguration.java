package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_OutputSurfaceConfiguration extends OutputSurfaceConfiguration {
    private final OutputSurface imageAnalysisOutputSurface;
    private final OutputSurface imageCaptureOutputSurface;
    private final OutputSurface postviewOutputSurface;
    private final OutputSurface previewOutputSurface;

    public int hashCode() {
        int r100 = (((this.previewOutputSurface.hashCode() ^ 1000003) * 1000003) ^ this.imageCaptureOutputSurface.hashCode()) * 1000003;
        OutputSurface r101 = this.imageAnalysisOutputSurface;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 ^ r103) * 1000003;
        OutputSurface r105 = this.postviewOutputSurface;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 ^ r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OutputSurfaceConfiguration{previewOutputSurface=" + this.previewOutputSurface + ", imageCaptureOutputSurface=" + this.imageCaptureOutputSurface + ", imageAnalysisOutputSurface=" + this.imageAnalysisOutputSurface + ", postviewOutputSurface=" + this.postviewOutputSurface + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getImageAnalysisOutputSurface() {
        return this.imageAnalysisOutputSurface;
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getImageCaptureOutputSurface() {
        return this.imageCaptureOutputSurface;
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getPostviewOutputSurface() {
        return this.postviewOutputSurface;
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getPreviewOutputSurface() {
        return this.previewOutputSurface;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof OutputSurfaceConfiguration) == false) goto L28;
        OutputSurfaceConfiguration r101 = (OutputSurfaceConfiguration) r100;
        if (this.previewOutputSurface.equals(r101.getPreviewOutputSurface()) == true) goto L10;
    L26:
        return false;
    L10:
        if (this.imageCaptureOutputSurface.equals(r101.getImageCaptureOutputSurface()) == false) goto L26;
        OutputSurface r102 = this.imageAnalysisOutputSurface;
        if (r102 != null) goto L17;
        if (r101.getImageAnalysisOutputSurface() != null) goto L26;
    L18:
        OutputSurface r103 = this.postviewOutputSurface;
        if (r103 != null) goto L24;
        if (r101.getPostviewOutputSurface() != null) goto L26;
        return true;
    L24:
        if (r103.equals(r101.getPostviewOutputSurface()) == false) goto L26;
        return true;
    L17:
        if (r102.equals(r101.getImageAnalysisOutputSurface()) == false) goto L26;
    L28:
        return false;
    }

    public AutoValue_OutputSurfaceConfiguration(OutputSurface r100, OutputSurface r101, OutputSurface r102, OutputSurface r103) {
        if (r100 == null) goto L11;
        this.previewOutputSurface = r100;
        if (r101 == null) goto L9;
        this.imageCaptureOutputSurface = r101;
        this.imageAnalysisOutputSurface = r102;
        this.postviewOutputSurface = r103;
        return;
    L9:
        throw new NullPointerException("Null imageCaptureOutputSurface");
    L11:
        throw new NullPointerException("Null previewOutputSurface");
    }
}
