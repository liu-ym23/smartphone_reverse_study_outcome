package com.google.android.material.sidesheet;

/* JADX INFO: loaded from: classes2.dex */
final class SheetUtils {
    private SheetUtils() {
    }

    static boolean isSwipeMostlyHorizontal(float r0, float r1) {
        if (Math.abs(r0) <= Math.abs(r1)) goto L5;
        return true;
    L5:
        return false;
    }
}
