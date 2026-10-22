package com.bytedance.safetyguard.lxc.internal.c;

/* JADX INFO: compiled from: ProxyProtocol.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k extends Exception {
    public /* synthetic */ k(String r1, Throwable r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public k(String r2, Throwable r3) {
        d.h.b.o.e(r2, "message");
        super(r2, r3);
    }
}
