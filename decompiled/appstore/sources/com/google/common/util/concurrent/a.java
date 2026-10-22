package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ boolean a(Unsafe r10, Object r11, long r12, Object r13, Object r14) {
    L3:
        if (r10.compareAndSwapObject(r11, r12, r13, r14) == true) goto L4;
        if (r10.getObject(r11, r12) == r13) goto L3;
        return false;
    L4:
        return true;
    }
}
