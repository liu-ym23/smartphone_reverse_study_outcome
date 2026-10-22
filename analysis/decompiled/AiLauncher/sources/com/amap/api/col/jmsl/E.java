package com.amap.api.col.jmsl;

import android.content.Context;

/* loaded from: classes.dex */
public class E {

    /* renamed from: c, reason: collision with root package name */
    public static E f15993c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f15994a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15995b = B0.a(C1604s2.m("RYW1hcF9kZXZpY2VfYWRpdQ"));

    public E(Context context) {
        this.f15994a = context.getApplicationContext();
    }

    public static E a(Context context) {
        if (f15993c == null) {
            synchronized (E.class) {
                try {
                    if (f15993c == null) {
                        f15993c = new E(context);
                    }
                } finally {
                }
            }
        }
        return f15993c;
    }

    public final synchronized void b() {
        try {
            if (S0.f16316e == null) {
                String str = C1606t0.f16954b;
                C1571k0 c1571k0 = new C1571k0();
                if (S0.f16316e == null) {
                    S0.f16316e = c1571k0;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        M.b(this.f15994a).d(this.f15995b);
        M.b(this.f15994a).g(str);
    }
}
