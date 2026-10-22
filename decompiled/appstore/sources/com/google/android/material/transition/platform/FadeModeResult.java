package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
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
