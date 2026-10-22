package com.android.server.display.plugin.types;

import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;

/* JADX INFO: loaded from: classes2.dex */
public final class HdrBoostOverride extends Record {
    private static final HdrBoostOverride HDR_OFF = null;
    private final float customTransitionRate;
    private final float maxHdrBrightness;
    private final float sdrHdrRatio;

    private /* synthetic */ boolean $record$equals(Object r3) {
        if ((r3 instanceof HdrBoostOverride) == false) goto L12;
        HdrBoostOverride r4 = (HdrBoostOverride) r3;
        if (this.sdrHdrRatio == r4.sdrHdrRatio) goto L7;
        return false;
    L7:
        if (this.maxHdrBrightness == r4.maxHdrBrightness) goto L9;
        return false;
    L9:
        if (this.customTransitionRate != r4.customTransitionRate) goto L16;
        return true;
    L16:
        return false;
    L12:
        return false;
    }

    private /* synthetic */ Object[] $record$getFieldsAsObjects() {
        return new Object[]{Float.valueOf(this.sdrHdrRatio), Float.valueOf(this.maxHdrBrightness), Float.valueOf(this.customTransitionRate)};
    }

    public HdrBoostOverride(float sdrHdrRatio, float maxHdrBrightness, float customTransitionRate) {
        this.sdrHdrRatio = sdrHdrRatio;
        this.maxHdrBrightness = maxHdrBrightness;
        this.customTransitionRate = customTransitionRate;
    }

    public float customTransitionRate() {
        return this.customTransitionRate;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return $record$equals(o);
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return HdrBoostOverride$$ExternalSyntheticRecord0.m(this.sdrHdrRatio, this.maxHdrBrightness, this.customTransitionRate);
    }

    public float maxHdrBrightness() {
        return this.maxHdrBrightness;
    }

    public float sdrHdrRatio() {
        return this.sdrHdrRatio;
    }

    @Override // java.lang.Record
    public final String toString() {
        return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), HdrBoostOverride.class, "sdrHdrRatio;maxHdrBrightness;customTransitionRate");
    }

    static {
        HDR_OFF = new HdrBoostOverride(0.0f, 1.0f, -1.0f);
    }

    public static HdrBoostOverride forHdrOff() {
        return HDR_OFF;
    }

    public static HdrBoostOverride forSdrHdrRatio(float sdrHdrRatio) {
        return new HdrBoostOverride(sdrHdrRatio, 1.0f, -1.0f);
    }
}
