package com.bytedance.android.live.revenue.common;

import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class t {
    public static final String a(Object r100) {
        if (r100 == null) goto L4;
        int r101 = r100.hashCode();
    L6:
        return Integer.toString(r101, CharsKt.checkRadix(16));
    L4:
        r101 = 0;
        goto L6
    }
}
