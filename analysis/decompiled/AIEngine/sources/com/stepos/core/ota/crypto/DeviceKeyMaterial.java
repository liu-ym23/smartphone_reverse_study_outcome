package com.stepos.core.ota.crypto;

import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeviceKeyMaterial {
    private final boolean attested;
    private final List<String> certChain;

    public DeviceKeyMaterial(List<String> certChain, boolean z) {
        g.f(certChain, "certChain");
        this.certChain = certChain;
        this.attested = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceKeyMaterial copy$default(DeviceKeyMaterial deviceKeyMaterial, List list, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = deviceKeyMaterial.certChain;
        }
        if ((i10 & 2) != 0) {
            z = deviceKeyMaterial.attested;
        }
        return deviceKeyMaterial.copy(list, z);
    }

    public final List<String> component1() {
        return this.certChain;
    }

    public final boolean component2() {
        return this.attested;
    }

    public final DeviceKeyMaterial copy(List<String> certChain, boolean z) {
        g.f(certChain, "certChain");
        return new DeviceKeyMaterial(certChain, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceKeyMaterial)) {
            return false;
        }
        DeviceKeyMaterial deviceKeyMaterial = (DeviceKeyMaterial) obj;
        return g.b(this.certChain, deviceKeyMaterial.certChain) && this.attested == deviceKeyMaterial.attested;
    }

    public final boolean getAttested() {
        return this.attested;
    }

    public final List<String> getCertChain() {
        return this.certChain;
    }

    public int hashCode() {
        return Boolean.hashCode(this.attested) + (this.certChain.hashCode() * 31);
    }

    public String toString() {
        return "DeviceKeyMaterial(certChain=" + this.certChain + ", attested=" + this.attested + ")";
    }
}
