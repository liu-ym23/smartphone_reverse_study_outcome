package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ boolean a(AtomicReferenceArray r10, int r11, Object r12, Object r13) {
    L3:
        if (r10.compareAndSet(r11, r12, r13) == true) goto L4;
        if (r10.get(r11) == r12) goto L3;
        return false;
    L4:
        return true;
    }
}
