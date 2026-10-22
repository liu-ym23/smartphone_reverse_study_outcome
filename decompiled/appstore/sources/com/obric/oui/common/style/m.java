package com.obric.oui.common.style;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m {
    public static final /* synthetic */ boolean a(float[] r10) {
        return b(r10);
    }

    public static final boolean b(float[] r10) {
        if (r10.length != 0) goto L5;
        return true;
    L5:
        float r11 = r10[0];
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L17;
        if (r10[r13] != r11) goto L10;
        boolean r14 = true;
    L11:
        if (r14 == false) goto L14;
        r13 = r13 + 1;
        goto L6
    L14:
        return false;
    L10:
        r14 = false;
        goto L11
    L17:
        return true;
    }
}
