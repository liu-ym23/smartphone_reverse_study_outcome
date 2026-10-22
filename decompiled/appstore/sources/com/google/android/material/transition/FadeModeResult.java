package com.google.android.material.transition;

/* JADX INFO: loaded from: classes3.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int r10, int r11, boolean r12) {
        this.startAlpha = r10;
        this.endAlpha = r11;
        this.endOnTop = r12;
    }

    public static FadeModeResult endOnTop(int r10, int r11) {
        return new FadeModeResult(r10, r11, true);
    }

    public static FadeModeResult startOnTop(int r10, int r11) {
        return new FadeModeResult(r10, r11, false);
    }
}
