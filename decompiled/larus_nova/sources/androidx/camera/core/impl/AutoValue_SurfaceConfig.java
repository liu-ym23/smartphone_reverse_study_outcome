package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SurfaceConfig extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;
    private final long streamUseCase;

    public int hashCode() {
        int r100 = (((this.configType.hashCode() ^ 1000003) * 1000003) ^ this.configSize.hashCode()) * 1000003;
        long r101 = this.streamUseCase;
        return r100 ^ ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.configType + ", configSize=" + this.configSize + ", streamUseCase=" + this.streamUseCase + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public long getStreamUseCase() {
        return this.streamUseCase;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SurfaceConfig) == false) goto L16;
        SurfaceConfig r101 = (SurfaceConfig) r100;
        if (this.configType.equals(r101.getConfigType()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.configSize.equals(r101.getConfigSize()) == false) goto L14;
        if (this.streamUseCase != r101.getStreamUseCase()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_SurfaceConfig(SurfaceConfig.ConfigType r100, SurfaceConfig.ConfigSize r101, long r102) {
        if (r100 == null) goto L11;
        this.configType = r100;
        if (r101 == null) goto L9;
        this.configSize = r101;
        this.streamUseCase = r102;
        return;
    L9:
        throw new NullPointerException("Null configSize");
    L11:
        throw new NullPointerException("Null configType");
    }
}
