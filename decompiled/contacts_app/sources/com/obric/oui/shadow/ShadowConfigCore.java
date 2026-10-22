package com.obric.oui.shadow;

import android.content.res.TypedArray;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.utils.AnimUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ShadowConfigCore {
    private int blendMode;
    private float blurRadius;
    private int color;
    private float spread;
    private float x;
    private float y;

    public ShadowConfigCore(int r8) {
        this(0.0f, 0.0f, 0.0f, r8, 0.0f, -1);
    }

    public ShadowConfigCore(float r8, float r9, float r10, int r11) {
        this(r8, r9, r10, r11, 0.0f, -1);
    }

    public ShadowConfigCore(float r8, float r9, float r10, int r11, float r12) {
        this(r8, r9, r10, r11, r12, -1);
    }

    public ShadowConfigCore(float r1, float r2, float r3, int r4, float r5, int r6) {
        this.x = r1;
        this.y = r2;
        this.blurRadius = r3;
        this.color = r4;
        this.spread = r5;
        this.blendMode = r6;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float r1) {
        this.x = r1;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float r1) {
        this.y = r1;
    }

    public float getBlurRadius() {
        return this.blurRadius;
    }

    public void setBlurRadius(float r1) {
        this.blurRadius = r1;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int r1) {
        this.color = r1;
    }

    public float getSpread() {
        return this.spread;
    }

    public void setSpread(float r1) {
        this.spread = r1;
    }

    public int getBlendMode() {
        return this.blendMode;
    }

    public void setBlendMode(int r1) {
        this.blendMode = r1;
    }

    public ShadowConfigCore deepCopy() {
        return deepCopy(this);
    }

    public static ShadowConfigCore deepCopy(ShadowConfigCore r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return new ShadowConfigCore(r8.x, r8.y, r8.blurRadius, r8.color, r8.spread, r8.blendMode);
    }

    public static ShadowConfigCore[] deepCopy(ShadowConfigCore[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ShadowConfigCore[] r0 = new ShadowConfigCore[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = deepCopy(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static ShadowConfigCore fromStyleRes(TypedArray r4, int r5, int r6, int r7, int r8, int r9) {
        return new ShadowConfigCore(r4.getDimension(r7, 0.0f), r4.getDimension(r8, 0.0f), r4.getDimension(r6, 0.0f), r4.getColor(r5, 0), r4.getDimension(r9, 0.0f));
    }

    public static ShadowConfigCore lerp(ShadowConfigCore r7, ShadowConfigCore r8, float r9) {
        return new ShadowConfigCore(AnimUtils.lerp(r7.x, r8.x, r9), AnimUtils.lerp(r7.y, r8.y, r9), AnimUtils.lerp(r7.blurRadius, r8.blurRadius, r9), AnimUtils.evaluateColor(r9, r7.color, r8.color), AnimUtils.lerp(r7.spread, r8.spread, r9));
    }

    public static int[] getShadowBlendIntArray(ShadowConfigCore r3) {
        if (r3.blendMode != (-1)) goto L6;
        r3.blendMode = BlendMode.SRC_OVER.getPorterDuffMode();
    L6:
        return new int[]{r3.color, r3.blendMode};
    }
}
