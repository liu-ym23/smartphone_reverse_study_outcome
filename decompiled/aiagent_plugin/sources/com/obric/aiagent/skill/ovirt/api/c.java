package com.obric.aiagent.skill.ovirt.api;

import d.h.b.o;

/* JADX INFO: compiled from: OVirtExceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c extends RuntimeException {
    public /* synthetic */ c(String r1, Throwable r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public c(String r2, Throwable r3) {
        o.e(r2, "message");
        super(r2, r3);
    }
}
