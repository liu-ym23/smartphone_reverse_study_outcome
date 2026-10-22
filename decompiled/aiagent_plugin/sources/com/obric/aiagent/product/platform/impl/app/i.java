package com.obric.aiagent.product.platform.impl.app;

import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import d.h.b.o;

/* JADX INFO: compiled from: ObricAutoVirtualDisplayRecordSetFramework.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f18818a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f18819b = null;

    private i() {
    }

    static {
        f18818a = new i();
        f18819b = new f(j.b());
    }

    public final boolean a() {
        return f18819b.a();
    }

    public final long a(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        o.e(r3, "listener");
        return f18819b.a(r1, r2, r3);
    }

    public final boolean a(long r1, String[] r3) {
        o.e(r3, "packageNames");
        return f18819b.a(r1, r3);
    }

    public final void a(long r1) {
        f18819b.a(r1);
    }
}
