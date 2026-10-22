package com.obric.agent.h;

import com.obric.agent.d;
import d.h.b.o;

/* JADX INFO: compiled from: DeviceVariantManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f14570b;

    static {
        f14569a = new a();
    }

    private a() {
    }

    public final void a(String r3) {
        o.e(r3, "rawName");
        if (d.f14409a.a(r3) == false) goto L7;
        f14570b = r3;
        return;
    L7:
        throw new IllegalArgumentException("Unknown Obric variant: " + r3);
    }
}
