package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.util.OutConfig;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_DualOutConfig extends DualOutConfig {
    private final OutConfig primaryOutConfig;
    private final OutConfig secondaryOutConfig;

    public int hashCode() {
        return ((this.primaryOutConfig.hashCode() ^ 1000003) * 1000003) ^ this.secondaryOutConfig.hashCode();
    }

    public String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.primaryOutConfig + ", secondaryOutConfig=" + this.secondaryOutConfig + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.processing.concurrent.DualOutConfig
    public OutConfig getPrimaryOutConfig() {
        return this.primaryOutConfig;
    }

    @Override // androidx.camera.core.processing.concurrent.DualOutConfig
    public OutConfig getSecondaryOutConfig() {
        return this.secondaryOutConfig;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof DualOutConfig) == false) goto L14;
        DualOutConfig r101 = (DualOutConfig) r100;
        if (this.primaryOutConfig.equals(r101.getPrimaryOutConfig()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.secondaryOutConfig.equals(r101.getSecondaryOutConfig()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_DualOutConfig(OutConfig r100, OutConfig r101) {
        if (r100 == null) goto L11;
        this.primaryOutConfig = r100;
        if (r101 == null) goto L9;
        this.secondaryOutConfig = r101;
        return;
    L9:
        throw new NullPointerException("Null secondaryOutConfig");
    L11:
        throw new NullPointerException("Null primaryOutConfig");
    }
}
