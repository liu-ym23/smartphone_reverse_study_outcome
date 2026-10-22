package com.obric.oui.shadow;

import android.content.res.TypedArray;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,BA\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\"\u001a\u00020\u0000J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\r\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lcom/obric/oui/shadow/ShadowConfig;", "", MaterialConfigFormatNames.X, "", MaterialConfigFormatNames.Y, "blurRadius", "color", "", MaterialConfigFormatNames.SPREAD, "blendMode", "(FFFIFI)V", "getBlendMode", "()I", "setBlendMode", "(I)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getColor", "setColor", "getSpread", "setSpread", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "deepCopy", "equals", "", "other", "hashCode", "toCore", "Lcom/obric/oui/shadow/ShadowConfigCore;", "toCore$OUI_standardRelease", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShadowConfig {
    public static final Companion Companion = null;
    private int blendMode;
    private float blurRadius;
    private int color;
    private float spread;
    private float x;
    private float y;

    /* JADX INFO: compiled from: ShadowConfig.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/shadow/ShadowConfig$Companion;", "", "()V", "fromStyleRes", "Lcom/obric/oui/shadow/ShadowConfig;", "typedArray", "Landroid/content/res/TypedArray;", "colorId", "", "radiusId", "offsetXId", "offsetYId", "spreadId", "getShadowBlendIntArray", "", "shadowConfig", "lerp", "start", TraceStatsConsts.STATS_KEY_END, "fraction", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShadowConfig fromStyleRes(TypedArray r1, int r2, int r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r1, "typedArray");
            ShadowConfigCore r0 = ShadowConfigCore.fromStyleRes(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r0, "result");
            return ShadowConfigKt.toConfig(r0);
        }

        @JvmStatic
        public final ShadowConfig lerp(ShadowConfig r1, ShadowConfig r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "start");
            Intrinsics.checkNotNullParameter(r2, TraceStatsConsts.STATS_KEY_END);
            ShadowConfigCore r0 = ShadowConfigCore.lerp(r1.toCore$OUI_standardRelease(), r2.toCore$OUI_standardRelease(), r3);
            Intrinsics.checkNotNullExpressionValue(r0, "lerp(start.toCore(), end.toCore(), fraction)");
            return ShadowConfigKt.toConfig(r0);
        }

        @JvmStatic
        public final int[] getShadowBlendIntArray(ShadowConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "shadowConfig");
            ShadowConfigCore r1 = r2.toCore$OUI_standardRelease();
            int[] r0 = ShadowConfigCore.getShadowBlendIntArray(r1);
            r2.setBlendMode(r1.getBlendMode());
            Intrinsics.checkNotNullExpressionValue(r0, "result");
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ShadowConfig(float r10, float r11, float r12, int r13) {
        this(r10, r11, r12, r13, 0.0f, 0, 48, null);
    }

    public ShadowConfig(float r10, float r11, float r12, int r13, float r14) {
        this(r10, r11, r12, r13, r14, 0, 32, null);
    }

    public ShadowConfig(float r10, float r11, int r12) {
        this(r10, r11, 0.0f, r12, 0.0f, 0, 52, null);
    }

    public ShadowConfig(float r10, int r11) {
        this(r10, 0.0f, 0.0f, r11, 0.0f, 0, 54, null);
    }

    public ShadowConfig(int r10) {
        this(0.0f, 0.0f, 0.0f, r10, 0.0f, 0, 55, null);
    }

    public static /* synthetic */ ShadowConfig copy$default(ShadowConfig r4, float r5, float r6, float r7, int r8, float r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.x;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.y;
    L8:
        float r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.blurRadius;
    L11:
        float r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.color;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.spread;
    L17:
        float r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.blendMode;
    L20:
        float r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    @JvmStatic
    public static final ShadowConfig fromStyleRes(TypedArray r7, int r8, int r9, int r10, int r11, int r12) {
        return Companion.fromStyleRes(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final int[] getShadowBlendIntArray(ShadowConfig r1) {
        return Companion.getShadowBlendIntArray(r1);
    }

    @JvmStatic
    public static final ShadowConfig lerp(ShadowConfig r1, ShadowConfig r2, float r3) {
        return Companion.lerp(r1, r2, r3);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final float component3() {
        return this.blurRadius;
    }

    public final int component4() {
        return this.color;
    }

    public final float component5() {
        return this.spread;
    }

    public final int component6() {
        return this.blendMode;
    }

    public final ShadowConfig copy(float r8, float r9, float r10, int r11, float r12, int r13) {
        return new ShadowConfig(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShadowConfig) == true) goto L8;
        return false;
    L8:
        ShadowConfig r6 = (ShadowConfig) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.x), Float.valueOf(r6.x)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.y), Float.valueOf(r6.y)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.blurRadius), Float.valueOf(r6.blurRadius)) == true) goto L18;
        return false;
    L18:
        if (this.color == r6.color) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.spread), Float.valueOf(r6.spread)) == true) goto L24;
        return false;
    L24:
        if (this.blendMode == r6.blendMode) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.blurRadius)) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.spread)) * 31) + Integer.hashCode(this.blendMode);
    }

    public String toString() {
        return "ShadowConfig(x=" + this.x + ", y=" + this.y + ", blurRadius=" + this.blurRadius + ", color=" + this.color + ", spread=" + this.spread + ", blendMode=" + this.blendMode + ')';
    }

    public ShadowConfig(float r1, float r2, float r3, int r4, float r5, int r6) {
        this.x = r1;
        this.y = r2;
        this.blurRadius = r3;
        this.color = r4;
        this.spread = r5;
        this.blendMode = r6;
    }

    public /* synthetic */ ShadowConfig(float r10, float r11, float r12, int r13, float r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        float r3 = 0.0f;
    L7:
        if ((r16 & 2) == 0) goto L9;
        float r4 = 0.0f;
    L11:
        if ((r16 & 4) == 0) goto L13;
        float r5 = 0.0f;
    L15:
        if ((r16 & 16) == 0) goto L17;
        float r7 = 0.0f;
    L19:
        if ((r16 & 32) == 0) goto L21;
        int r8 = -1;
    L22:
        this(r3, r4, r5, r13, r7, r8);
        return;
    L21:
        r8 = r15;
        goto L22
    L17:
        r7 = r14;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public final float getX() {
        return this.x;
    }

    public final void setX(float r1) {
        this.x = r1;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float r1) {
        this.y = r1;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius(float r1) {
        this.blurRadius = r1;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int r1) {
        this.color = r1;
    }

    public final float getSpread() {
        return this.spread;
    }

    public final void setSpread(float r1) {
        this.spread = r1;
    }

    public final int getBlendMode() {
        return this.blendMode;
    }

    public final void setBlendMode(int r1) {
        this.blendMode = r1;
    }

    public final ShadowConfigCore toCore$OUI_standardRelease() {
        return new ShadowConfigCore(this.x, this.y, this.blurRadius, this.color, this.spread, this.blendMode);
    }

    public final ShadowConfig deepCopy() {
        ShadowConfigCore r1 = ShadowConfigCore.deepCopy(toCore$OUI_standardRelease());
        Intrinsics.checkNotNullExpressionValue(r1, "deepCopy(toCore())");
        return ShadowConfigKt.toConfig(r1);
    }
}
