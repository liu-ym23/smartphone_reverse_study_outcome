package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SupportedSurfaceCombination_FeatureSettings extends SupportedSurfaceCombination.FeatureSettings {
    private final int cameraMode;
    private final boolean previewStabilizationOn;
    private final int requiredMaxBitDepth;
    private final boolean ultraHdrOn;

    public int hashCode() {
        int r100 = (((this.cameraMode ^ 1000003) * 1000003) ^ this.requiredMaxBitDepth) * 1000003;
        int r101 = 1231;
        if (this.previewStabilizationOn == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 ^ r102) * 1000003;
        if (this.ultraHdrOn == true) goto L11;
        r101 = 1237;
    L11:
        return r103 ^ r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "FeatureSettings{cameraMode=" + this.cameraMode + ", requiredMaxBitDepth=" + this.requiredMaxBitDepth + ", previewStabilizationOn=" + this.previewStabilizationOn + ", ultraHdrOn=" + this.ultraHdrOn + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public int getCameraMode() {
        return this.cameraMode;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public int getRequiredMaxBitDepth() {
        return this.requiredMaxBitDepth;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isPreviewStabilizationOn() {
        return this.previewStabilizationOn;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isUltraHdrOn() {
        return this.ultraHdrOn;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SupportedSurfaceCombination.FeatureSettings) == false) goto L18;
        SupportedSurfaceCombination.FeatureSettings r101 = (SupportedSurfaceCombination.FeatureSettings) r100;
        if (this.cameraMode == r101.getCameraMode()) goto L10;
    L16:
        return false;
    L10:
        if (this.requiredMaxBitDepth != r101.getRequiredMaxBitDepth()) goto L16;
        if (this.previewStabilizationOn != r101.isPreviewStabilizationOn()) goto L16;
        if (this.ultraHdrOn != r101.isUltraHdrOn()) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_SupportedSurfaceCombination_FeatureSettings(int r100, int r101, boolean r102, boolean r103) {
        this.cameraMode = r100;
        this.requiredMaxBitDepth = r101;
        this.previewStabilizationOn = r102;
        this.ultraHdrOn = r103;
    }
}
