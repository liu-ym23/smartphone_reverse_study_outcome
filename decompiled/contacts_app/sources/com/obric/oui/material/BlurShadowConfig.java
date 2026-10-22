package com.obric.oui.material;

import com.obric.oui.shadow.ShadowConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurShadowConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ(\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/material/BlurShadowConfig;", "", "blurRadius", "", MaterialConfigFormatNames.SHADOW, "", "Lcom/obric/oui/shadow/ShadowConfig;", "(F[Lcom/obric/oui/shadow/ShadowConfig;)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getShadow", "()[Lcom/obric/oui/shadow/ShadowConfig;", "setShadow", "([Lcom/obric/oui/shadow/ShadowConfig;)V", "[Lcom/obric/oui/shadow/ShadowConfig;", "component1", "component2", "copy", "(F[Lcom/obric/oui/shadow/ShadowConfig;)Lcom/obric/oui/material/BlurShadowConfig;", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlurShadowConfig {
    private float blurRadius;
    private ShadowConfig[] shadow;

    public static /* synthetic */ BlurShadowConfig copy$default(BlurShadowConfig r0, float r1, ShadowConfig[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.blurRadius;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.shadow;
    L9:
        return r0.copy(r1, r2);
    }

    public final float component1() {
        return this.blurRadius;
    }

    public final ShadowConfig[] component2() {
        return this.shadow;
    }

    public final BlurShadowConfig copy(float r1, ShadowConfig[] r2) {
        Intrinsics.checkNotNullParameter(r2, MaterialConfigFormatNames.SHADOW);
        return new BlurShadowConfig(r1, r2);
    }

    public String toString() {
        return "BlurShadowConfig(blurRadius=" + this.blurRadius + ", shadow=" + Arrays.toString(this.shadow) + ')';
    }

    public BlurShadowConfig(float r2, ShadowConfig[] r3) {
        Intrinsics.checkNotNullParameter(r3, MaterialConfigFormatNames.SHADOW);
        this.blurRadius = r2;
        this.shadow = r3;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius(float r1) {
        this.blurRadius = r1;
    }

    public final ShadowConfig[] getShadow() {
        return this.shadow;
    }

    public final void setShadow(ShadowConfig[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.shadow = r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r5 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        if (r5 == null) goto L24;
        BlurShadowConfig r6 = (BlurShadowConfig) r5;
        if (this.blurRadius != r6.blurRadius) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L20;
        return false;
    L20:
        if (Arrays.equals(this.shadow, r6.shadow) == true) goto L22;
        return false;
    L22:
        return true;
    L16:
        r3 = false;
        goto L17
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.BlurShadowConfig");
    L8:
        r2 = r5.getClass();
        goto L10
    }

    public int hashCode() {
        return (int) ((31 * this.blurRadius) + Arrays.hashCode(this.shadow));
    }
}
