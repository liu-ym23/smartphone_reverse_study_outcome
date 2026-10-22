package com.obric.aiagent.product.platform.impl.windoweffects.a;

/* JADX INFO: compiled from: NumberEx.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ boolean a(float r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1.0E-6f;
    L6:
        return a(r0, r1, r2);
    }

    public static final boolean a(float r0, float r1, float r2) {
        if (Math.abs(r0 - r1) >= r2) goto L5;
        return true;
    L5:
        return false;
    }
}
