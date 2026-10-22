package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OutputSurfaceConfiguration {
    public OutputSurfaceConfiguration() {
    }

    public abstract OutputSurface getImageAnalysisOutputSurface();

    public abstract OutputSurface getImageCaptureOutputSurface();

    public abstract OutputSurface getPostviewOutputSurface();

    public abstract OutputSurface getPreviewOutputSurface();

    public static OutputSurfaceConfiguration create(OutputSurface r100, OutputSurface r101, OutputSurface r102, OutputSurface r103) {
        return new AutoValue_OutputSurfaceConfiguration(r100, r101, r102, r103);
    }
}
