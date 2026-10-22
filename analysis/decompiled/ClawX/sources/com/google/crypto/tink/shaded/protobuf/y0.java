package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: c, reason: collision with root package name */
    public static final y0 f1540c = new y0();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f1542b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final l0 f1541a = new l0();

    public final b1 a(Class cls) {
        b1 b1VarB;
        Class cls2;
        a0.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f1542b;
        b1 b1Var = (b1) concurrentHashMap.get(cls);
        if (b1Var != null) {
            return b1Var;
        }
        l0 l0Var = this.f1541a;
        l0Var.getClass();
        Class cls3 = c1.f1437a;
        if (!w.class.isAssignableFrom(cls) && (cls2 = c1.f1437a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
        a1 a1VarA = ((k0) l0Var.f1492a).a(cls);
        int i8 = a1VarA.d;
        a aVar = a1VarA.f1430a;
        if ((i8 & 2) == 2) {
            if (w.class.isAssignableFrom(cls)) {
                b1VarB = new t0(c1.d, q.f1508a, aVar);
            } else {
                f1 f1Var = c1.f1438b;
                p pVar = q.f1509b;
                if (pVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                b1VarB = new t0(f1Var, pVar, aVar);
            }
        } else if (w.class.isAssignableFrom(cls)) {
            b1VarB = (a1VarA.d & 1) == 1 ? s0.B(a1VarA, v0.f1539b, i0.f1469b, c1.d, q.f1508a, o0.f1506b) : s0.B(a1VarA, v0.f1539b, i0.f1469b, c1.d, null, o0.f1506b);
        } else if ((a1VarA.d & 1) == 1) {
            u0 u0Var = v0.f1538a;
            g0 g0Var = i0.f1468a;
            f1 f1Var2 = c1.f1438b;
            p pVar2 = q.f1509b;
            if (pVar2 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            b1VarB = s0.B(a1VarA, u0Var, g0Var, f1Var2, pVar2, o0.f1505a);
        } else {
            b1VarB = s0.B(a1VarA, v0.f1538a, i0.f1468a, c1.f1439c, null, o0.f1505a);
        }
        b1 b1Var2 = (b1) concurrentHashMap.putIfAbsent(cls, b1VarB);
        return b1Var2 != null ? b1Var2 : b1VarB;
    }
}
