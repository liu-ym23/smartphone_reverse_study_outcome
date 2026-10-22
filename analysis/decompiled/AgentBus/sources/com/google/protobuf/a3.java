package com.google.protobuf;

/* loaded from: classes.dex */
public final class a3 {

    /* renamed from: a, reason: collision with root package name */
    public final i5.l f2304a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2305b;

    public a3(s4 s4Var, s4 s4Var2, Object obj) {
        this.f2304a = new i5.l(s4Var, s4Var2, obj, 8);
        this.f2305b = obj;
    }

    public static int a(i5.l lVar, Object obj, Object obj2) {
        return b2.b((s4) lVar.f4688h, 2, obj2) + b2.b((s4) lVar.f4687g, 1, obj);
    }

    public static void b(r rVar, i5.l lVar, Object obj, Object obj2) {
        b2.f(rVar, (s4) lVar.f4687g, 1, obj);
        b2.f(rVar, (s4) lVar.f4688h, 2, obj2);
    }
}
