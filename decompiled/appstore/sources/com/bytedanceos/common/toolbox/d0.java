package com.bytedanceos.common.toolbox;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 {
    public static final int a(String r10) {
        if (r10 == null) goto L6;
        Integer r11 = kotlin.text.n.g(r10);
        if (r11 == null) goto L6;
        return r11.intValue();
    L6:
        return -1;
    }

    public static final long b(String r10) {
        if (r10 == null) goto L6;
        Long r11 = kotlin.text.n.i(r10);
        if (r11 == null) goto L6;
        return r11.longValue();
    L6:
        return -1;
    }

    public static final long c(String r10) {
        if (r10 == null) goto L6;
        Long r11 = kotlin.text.n.i(r10);
        if (r11 == null) goto L6;
        return r11.longValue();
    L6:
        return 0;
    }
}
