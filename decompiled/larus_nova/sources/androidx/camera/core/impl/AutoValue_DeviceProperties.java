package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_DeviceProperties extends DeviceProperties {
    private final String manufacturer;
    private final String model;
    private final int sdkVersion;

    public int hashCode() {
        return ((((this.manufacturer.hashCode() ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.sdkVersion;
    }

    public String toString() {
        return "DeviceProperties{manufacturer=" + this.manufacturer + ", model=" + this.model + ", sdkVersion=" + this.sdkVersion + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.DeviceProperties
    public String manufacturer() {
        return this.manufacturer;
    }

    @Override // androidx.camera.core.impl.DeviceProperties
    public String model() {
        return this.model;
    }

    @Override // androidx.camera.core.impl.DeviceProperties
    public int sdkVersion() {
        return this.sdkVersion;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeviceProperties) == false) goto L16;
        DeviceProperties r101 = (DeviceProperties) r100;
        if (this.manufacturer.equals(r101.manufacturer()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.model.equals(r101.model()) == false) goto L14;
        if (this.sdkVersion != r101.sdkVersion()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_DeviceProperties(String r100, String r101, int r102) {
        if (r100 == null) goto L11;
        this.manufacturer = r100;
        if (r101 == null) goto L9;
        this.model = r101;
        this.sdkVersion = r102;
        return;
    L9:
        throw new NullPointerException("Null model");
    L11:
        throw new NullPointerException("Null manufacturer");
    }
}
