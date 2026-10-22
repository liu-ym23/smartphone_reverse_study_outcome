package com.bytedance.android.live.effect.beauty.presets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/EffectParameter;", "", "tag", "", "value", "", "(Ljava/lang/String;F)V", "getTag", "()Ljava/lang/String;", "getValue", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectParameter {
    private final String tag;
    private final float value;

    public static /* synthetic */ EffectParameter copy$default(EffectParameter r100, String r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tag;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.value;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.tag;
    }

    public final float component2() {
        return this.value;
    }

    public final EffectParameter copy(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return new EffectParameter(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EffectParameter) == false) goto L10;
        EffectParameter r101 = (EffectParameter) r100;
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.value, r101.value) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.tag;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + Float.floatToIntBits(this.value);
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "EffectParameter(tag=" + this.tag + ", value=" + this.value + ")";
    }

    public final String getTag() {
        return this.tag;
    }

    public final float getValue() {
        return this.value;
    }

    public EffectParameter(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.tag = r100;
        this.value = r101;
    }
}
