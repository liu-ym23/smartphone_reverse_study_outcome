package com.obric.aiagent.skill.ovirt.api.a;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FileAccessException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.aiagent.skill.ovirt.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f20945a;

    public /* synthetic */ a(String r1, Throwable r2, b r3, int r4, h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = b.l;
    L8:
        this(r1, r2, r3);
    }

    public final b a() {
        return this.f20945a;
    }

    public a(String r2, Throwable r3, b r4) {
        o.e(r2, "message");
        o.e(r4, "reason");
        super(r2, r3);
        this.f20945a = r4;
    }
}
