package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: c, reason: collision with root package name */
    public static final w0 f962c = new w0();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f964b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final i0 f963a = new i0();

    public final z0 a(Class cls) {
        z0 z0VarZ;
        Class cls2;
        y.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f964b;
        z0 z0Var = (z0) concurrentHashMap.get(cls);
        if (z0Var != null) {
            return z0Var;
        }
        i0 i0Var = this.f963a;
        i0Var.getClass();
        Class cls3 = a1.f795a;
        if (!w.class.isAssignableFrom(cls) && (cls2 = a1.f795a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
        y0 y0VarA = ((h0) i0Var.f880a).a(cls);
        int i2 = y0VarA.f973d;
        a aVar = y0VarA.f970a;
        if ((i2 & 2) == 2) {
            if (w.class.isAssignableFrom(cls)) {
                z0VarZ = new r0(a1.f798d, q.f917a, aVar);
            } else {
                k1 k1Var = a1.f796b;
                p pVar = q.f918b;
                if (pVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                z0VarZ = new r0(k1Var, pVar, aVar);
            }
        } else if (w.class.isAssignableFrom(cls)) {
            z0VarZ = (y0VarA.f973d & 1) == 1 ? q0.z(y0VarA, t0.f957b, g0.f855b, a1.f798d, q.f917a, n0.f911b) : q0.z(y0VarA, t0.f957b, g0.f855b, a1.f798d, null, n0.f911b);
        } else if ((y0VarA.f973d & 1) == 1) {
            s0 s0Var = t0.f956a;
            e0 e0Var = g0.f854a;
            k1 k1Var2 = a1.f796b;
            p pVar2 = q.f918b;
            if (pVar2 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            z0VarZ = q0.z(y0VarA, s0Var, e0Var, k1Var2, pVar2, n0.f910a);
        } else {
            z0VarZ = q0.z(y0VarA, t0.f956a, g0.f854a, a1.f797c, null, n0.f910a);
        }
        z0 z0Var2 = (z0) concurrentHashMap.putIfAbsent(cls, z0VarZ);
        return z0Var2 != null ? z0Var2 : z0VarZ;
    }
}
