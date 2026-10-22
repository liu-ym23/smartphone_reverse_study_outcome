package com.obric.oui.common.style;

/* JADX INFO: compiled from: SmoothCornerH.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m {
    public static final /* synthetic */ boolean a(float[] r0) {
        return b(r0);
    }

    private static final boolean b(float[] r6) {
        if (r6.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        float r1 = r6[0];
        int r3 = r6.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L19;
        if (r6[r4] != r1) goto L13;
        boolean r5 = true;
    L15:
        if ((!r5) == true) goto L22;
        r4 = r4 + 1;
        goto L9
    L22:
        return false;
    L13:
        r5 = false;
        goto L15
    L19:
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
