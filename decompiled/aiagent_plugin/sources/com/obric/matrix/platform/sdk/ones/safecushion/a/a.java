package com.obric.matrix.platform.sdk.ones.safecushion.a;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: BaseRepair.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33712a;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(String r2) {
        o.e(r2, "alias");
        this.f33712a = r2;
    }

    public /* synthetic */ a(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}
