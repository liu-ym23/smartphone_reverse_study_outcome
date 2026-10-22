package com.obric.aiagent.skill.ovirt.api;

import d.h.b.o;

/* JADX INFO: compiled from: OVirtExceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {
    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ e(String r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "OVirt shell is not supported";
    L5:
        this(r1);
    }

    public e(String r3) {
        o.e(r3, "message");
        super(r3, null, 2, null);
    }
}
