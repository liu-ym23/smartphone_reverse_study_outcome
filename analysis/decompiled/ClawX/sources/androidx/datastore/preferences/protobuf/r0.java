package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: c, reason: collision with root package name */
    public static final r0 f559c = new r0();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f561b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final e0 f560a = new e0();

    public final u0 a(Class cls) {
        u0 u0VarW;
        Class cls2;
        x.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f561b;
        u0 u0Var = (u0) concurrentHashMap.get(cls);
        if (u0Var != null) {
            return u0Var;
        }
        e0 e0Var = this.f560a;
        e0Var.getClass();
        Class cls3 = v0.f571a;
        if (!v.class.isAssignableFrom(cls) && (cls2 = v0.f571a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        t0 t0VarA = ((d0) e0Var.f466a).a(cls);
        int i8 = t0VarA.d;
        a aVar = t0VarA.f568a;
        if ((i8 & 2) == 2) {
            if (v.class.isAssignableFrom(cls)) {
                u0VarW = new n0(v0.f573c, p.f534a, aVar);
            } else {
                c1 c1Var = v0.f572b;
                o oVar = p.f535b;
                if (oVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                u0VarW = new n0(c1Var, oVar, aVar);
            }
        } else if (v.class.isAssignableFrom(cls)) {
            o oVar2 = null;
            o0 o0Var = p0.f537b;
            b0 b0Var = c0.f459b;
            c1 c1Var2 = v0.f573c;
            if (m.f.a(t0VarA.a()) != 1) {
                oVar2 = p.f534a;
            }
            o oVar3 = oVar2;
            i0 i0Var = j0.f505b;
            if (!(t0VarA instanceof t0)) {
                int[] iArr = m0.f515n;
                t0VarA.getClass();
                throw new ClassCastException();
            }
            u0VarW = m0.w(t0VarA, o0Var, b0Var, c1Var2, oVar3, i0Var);
        } else {
            o oVar4 = null;
            o0 o0Var2 = p0.f536a;
            b0 b0Var2 = c0.f458a;
            c1 c1Var3 = v0.f572b;
            if (m.f.a(t0VarA.a()) != 1 && (oVar4 = p.f535b) == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            o oVar5 = oVar4;
            i0 i0Var2 = j0.f504a;
            if (!(t0VarA instanceof t0)) {
                int[] iArr2 = m0.f515n;
                t0VarA.getClass();
                throw new ClassCastException();
            }
            u0VarW = m0.w(t0VarA, o0Var2, b0Var2, c1Var3, oVar5, i0Var2);
        }
        u0 u0Var2 = (u0) concurrentHashMap.putIfAbsent(cls, u0VarW);
        return u0Var2 != null ? u0Var2 : u0VarW;
    }
}
