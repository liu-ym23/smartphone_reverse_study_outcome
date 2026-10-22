package com.bytedance.safetyguard.lxc.internal.client;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f10003b;

    public j(String r2, Object r3) {
        d.h.b.o.e(r2, "attachmentId");
        d.h.b.o.e(r3, "token");
        this.f10002a = r2;
        this.f10003b = r3;
    }

    public final String a() {
        return this.f10002a;
    }

    public final Object b() {
        return this.f10003b;
    }
}
