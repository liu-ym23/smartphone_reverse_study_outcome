package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: c, reason: collision with root package name */
    public static final x0 f2290c = new x0();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2292b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final k0 f2291a = new k0();

    public final a1 a(Class cls) {
        a1 a1VarB;
        Class cls2;
        z.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f2292b;
        a1 a1Var = (a1) concurrentHashMap.get(cls);
        if (a1Var != null) {
            return a1Var;
        }
        k0 k0Var = this.f2291a;
        k0Var.getClass();
        Class cls3 = b1.f2178a;
        if (!v.class.isAssignableFrom(cls) && (cls2 = b1.f2178a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
        z0 z0VarA = ((j0) k0Var.f2239a).a(cls);
        int i2 = z0VarA.f2301d;
        a aVar = z0VarA.f2298a;
        if ((i2 & 2) == 2) {
            if (v.class.isAssignableFrom(cls)) {
                a1VarB = new s0(b1.f2181d, p.f2256a, aVar);
            } else {
                e1 e1Var = b1.f2179b;
                o oVar = p.f2257b;
                if (oVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                a1VarB = new s0(e1Var, oVar, aVar);
            }
        } else if (v.class.isAssignableFrom(cls)) {
            a1VarB = (z0VarA.f2301d & 1) == 1 ? r0.B(z0VarA, u0.f2289b, h0.f2213b, b1.f2181d, p.f2256a, n0.f2254b) : r0.B(z0VarA, u0.f2289b, h0.f2213b, b1.f2181d, null, n0.f2254b);
        } else if ((z0VarA.f2301d & 1) == 1) {
            t0 t0Var = u0.f2288a;
            f0 f0Var = h0.f2212a;
            e1 e1Var2 = b1.f2179b;
            o oVar2 = p.f2257b;
            if (oVar2 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            a1VarB = r0.B(z0VarA, t0Var, f0Var, e1Var2, oVar2, n0.f2253a);
        } else {
            a1VarB = r0.B(z0VarA, u0.f2288a, h0.f2212a, b1.f2180c, null, n0.f2253a);
        }
        a1 a1Var2 = (a1) concurrentHashMap.putIfAbsent(cls, a1VarB);
        return a1Var2 != null ? a1Var2 : a1VarB;
    }
}
