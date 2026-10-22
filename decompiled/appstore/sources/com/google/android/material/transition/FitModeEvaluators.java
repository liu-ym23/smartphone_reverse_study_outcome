package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
class FitModeEvaluators {
    private static final FitModeEvaluator HEIGHT = null;
    private static final FitModeEvaluator WIDTH = null;

    static {
        WIDTH = new AnonymousClass1();
        HEIGHT = new AnonymousClass2();
    }

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int r10, boolean r11, RectF r12, RectF r13) {
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L10;
        return HEIGHT;
    L10:
        throw new IllegalArgumentException("Invalid fit mode: " + r10);
    L12:
        return WIDTH;
    L14:
        if (shouldAutoFitToWidth(r11, r12, r13) == false) goto L17;
        return WIDTH;
    L17:
        return HEIGHT;
    }

    private static boolean shouldAutoFitToWidth(boolean r10, RectF r11, RectF r12) {
        float r13 = r11.width();
        float r14 = r11.height();
        float r15 = r12.width();
        float r16 = r12.height();
        float r17 = (r16 * r13) / r15;
        float r18 = (r15 * r14) / r13;
        if (r10 == false) goto L8;
        if (r17 >= r14) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (r18 >= r16) goto L11;
        return false;
    }
}
