package com.stepos.core.ota.domain.port;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DrainSignal {
    private final boolean drained;
    private final String otaId;

    public DrainSignal(String otaId, boolean z) {
        g.f(otaId, "otaId");
        this.otaId = otaId;
        this.drained = z;
    }

    public static /* synthetic */ DrainSignal copy$default(DrainSignal drainSignal, String str, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = drainSignal.otaId;
        }
        if ((i10 & 2) != 0) {
            z = drainSignal.drained;
        }
        return drainSignal.copy(str, z);
    }

    public final String component1() {
        return this.otaId;
    }

    public final boolean component2() {
        return this.drained;
    }

    public final DrainSignal copy(String otaId, boolean z) {
        g.f(otaId, "otaId");
        return new DrainSignal(otaId, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrainSignal)) {
            return false;
        }
        DrainSignal drainSignal = (DrainSignal) obj;
        return g.b(this.otaId, drainSignal.otaId) && this.drained == drainSignal.drained;
    }

    public final boolean getDrained() {
        return this.drained;
    }

    public final String getOtaId() {
        return this.otaId;
    }

    public int hashCode() {
        return Boolean.hashCode(this.drained) + (this.otaId.hashCode() * 31);
    }

    public String toString() {
        return "DrainSignal(otaId=" + this.otaId + ", drained=" + this.drained + ")";
    }
}
