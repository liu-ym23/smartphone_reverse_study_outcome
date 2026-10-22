package com.bytedance.safetyguard.lxc.internal.client;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9960a;

    public final int a() {
        return this.f9960a;
    }

    public a(int r3, String r4) {
        d.h.b.o.e(r4, "message");
        super(n.a(r3) + ": " + r4);
        this.f9960a = r3;
    }
}
