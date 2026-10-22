package com.obric.autogui.resourcemanage;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: RequestSingleFlight.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, d.x> f30636a;

    public l() {
        this.f30636a = new ConcurrentHashMap();
    }

    public final boolean a(String r2) {
        d.h.b.o.e(r2, "key");
        if (this.f30636a.putIfAbsent(r2, d.x.f38692a) != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(String r2) {
        d.h.b.o.e(r2, "key");
        this.f30636a.remove(r2);
    }
}
