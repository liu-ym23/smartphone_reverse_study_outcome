package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f89717a;

    public f() {
    }

    public abstract long b();

    public abstract String d();

    public abstract int e();

    public abstract String f();

    public abstract long g();

    public abstract int h();

    public final i c() {
        i r100 = this.f89717a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return r.f89735b;
    }

    public final int i() {
        return e() + h();
    }

    public final void a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "dealSet");
        if (this.f89717a != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        this.f89717a = r100;
        return;
    L10:
        throw new IllegalStateException("DealSet is already set.".toString());
    L5:
        r101 = false;
        goto L6
    }
}
