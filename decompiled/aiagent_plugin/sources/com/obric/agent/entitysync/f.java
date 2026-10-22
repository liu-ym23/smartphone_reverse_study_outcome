package com.obric.agent.entitysync;

import d.h.b.o;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14506a = null;

    static {
        f14506a = new f();
    }

    private f() {
    }

    public final d a(g r8, d r9, e r10) {
        o.e(r8, "change");
        o.e(r9, "item");
        o.e(r10, "deleteItemState");
        if (r8 != g.f14509c) goto L8;
        if (r9.a().a().getType() == 701) goto L8;
        return d.a(r9, null, r10, null, 5, null);
    L8:
        if (r8 == g.f14508b) goto L10;
        return r9;
    L10:
        if (r9.a().a().getType() == 701) goto L12;
        return r9;
    L12:
        return d.a(r9, null, e.f14502b, null, 5, null);
    }
}
