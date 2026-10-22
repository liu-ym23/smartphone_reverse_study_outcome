package com.bytedance.safetyguard.lxc.internal.b;

/* JADX INFO: compiled from: TargetParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t extends IllegalArgumentException {
    public /* synthetic */ t(String r1, Throwable r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public t(String r2, Throwable r3) {
        d.h.b.o.e(r2, "message");
        super(r2, r3);
    }
}
