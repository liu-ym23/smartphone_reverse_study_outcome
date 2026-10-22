package com.obric.aiagent.skill.virt.api;

/* JADX INFO: compiled from: VirtShellExceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21616a;

    /* JADX WARN: Multi-variable type inference failed */
    public v() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f21616a;
    }

    public /* synthetic */ v(String r1, String r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L10;
        if (r1 != null) goto L9;
        r2 = "Virt is executing an exclusive segment";
        goto L10
    L9:
        r2 = "Virt shell execution is active: " + r1;
    L10:
        this(r1, r2);
    }

    public v(String r2, String r3) {
        d.h.b.o.e(r3, "message");
        super(r3);
        this.f21616a = r2;
    }
}
