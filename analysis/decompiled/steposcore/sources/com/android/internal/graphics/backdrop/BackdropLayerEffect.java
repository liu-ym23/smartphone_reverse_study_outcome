package com.android.internal.graphics.backdrop;

/* loaded from: classes.dex */
public enum BackdropLayerEffect {
    DODGE(0),
    OVERLAY(1);

    private final int mEffect;

    BackdropLayerEffect(int effect) {
        this.mEffect = effect;
    }

    public int getEffect() {
        return this.mEffect;
    }
}
