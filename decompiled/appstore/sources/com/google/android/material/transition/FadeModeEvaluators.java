package com.google.android.material.transition;

/* JADX INFO: loaded from: classes3.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = null;
    private static final FadeModeEvaluator IN = null;
    private static final FadeModeEvaluator OUT = null;
    private static final FadeModeEvaluator THROUGH = null;

    static {
        IN = new AnonymousClass1();
        OUT = new AnonymousClass2();
        CROSS = new AnonymousClass3();
        THROUGH = new AnonymousClass4();
    }

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int r10, boolean r11) {
        if (r10 != 0) goto L4;
        if (r11 == false) goto L22;
        return IN;
    L22:
        return OUT;
    L4:
        if (r10 != 1) goto L6;
        if (r11 == false) goto L18;
        return OUT;
    L18:
        return IN;
    L6:
        if (r10 == 2) goto L14;
        if (r10 != 3) goto L12;
        return THROUGH;
    L12:
        throw new IllegalArgumentException("Invalid fade mode: " + r10);
    L14:
        return CROSS;
    }
}
