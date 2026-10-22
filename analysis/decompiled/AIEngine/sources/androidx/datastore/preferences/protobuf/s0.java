package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.z;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: c, reason: collision with root package name */
    public static final s0 f1880c = new s0();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f1882b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final b0 f1881a = new b0();

    public final <T> w0<T> a(Class<T> cls) {
        w0<T> w0VarW;
        Class<?> cls2;
        u.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f1882b;
        w0<T> w0Var = (w0) concurrentHashMap.get(cls);
        if (w0Var != null) {
            return w0Var;
        }
        b0 b0Var = this.f1881a;
        b0Var.getClass();
        Class<?> cls3 = x0.f1899a;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = x0.f1899a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        g0 g0VarA = b0Var.f1784a.a(cls);
        if (!g0VarA.a()) {
            boolean zIsAssignableFrom = GeneratedMessageLite.class.isAssignableFrom(cls);
            ProtoSyntax protoSyntax = ProtoSyntax.f1762a;
            if (zIsAssignableFrom) {
                w0VarW = g0VarA.c() == protoSyntax ? l0.w(g0VarA, p0.f1874b, z.f1904b, x0.f1902d, p.f1871a, f0.f1808b) : l0.w(g0VarA, p0.f1874b, z.f1904b, x0.f1902d, null, f0.f1808b);
            } else if (g0VarA.c() == protoSyntax) {
                n0 n0Var = p0.f1873a;
                z.a aVar = z.f1903a;
                c1<?, ?> c1Var = x0.f1900b;
                n<?> nVar = p.f1872b;
                if (nVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                w0VarW = l0.w(g0VarA, n0Var, aVar, c1Var, nVar, f0.f1807a);
            } else {
                w0VarW = l0.w(g0VarA, p0.f1873a, z.f1903a, x0.f1901c, null, f0.f1807a);
            }
        } else if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            w0VarW = new m0<>(x0.f1902d, p.f1871a, g0VarA.b());
        } else {
            c1<?, ?> c1Var2 = x0.f1900b;
            n<?> nVar2 = p.f1872b;
            if (nVar2 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            w0VarW = new m0<>(c1Var2, nVar2, g0VarA.b());
        }
        w0<T> w0Var2 = (w0) concurrentHashMap.putIfAbsent(cls, w0VarW);
        return w0Var2 != null ? w0Var2 : w0VarW;
    }
}
