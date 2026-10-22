package androidx.datastore.preferences.protobuf;

import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final t0 f1207c;

    /* renamed from: a, reason: collision with root package name */
    public f0 f1208a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f1209b;

    static {
        l0 l0Var;
        t0 t0Var = new t0();
        t0Var.f1209b = new ConcurrentHashMap();
        try {
            l0Var = (l0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            l0Var = f0.f1109b;
        }
        l0[] l0VarArr = {s.f1193b, l0Var};
        e0 e0Var = new e0();
        e0Var.f1104a = l0VarArr;
        f0 f0Var = new f0();
        Charset charset = x.f1218a;
        f0Var.f1110a = e0Var;
        VarHandle.storeStoreFence();
        t0Var.f1208a = f0Var;
        VarHandle.storeStoreFence();
        f1207c = t0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final w0 a(Class cls) {
        o oVar;
        n0 n0VarS;
        Class cls2;
        x.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f1209b;
        w0 w0Var = (w0) concurrentHashMap.get(cls);
        if (w0Var != null) {
            return w0Var;
        }
        f0 f0Var = this.f1208a;
        f0Var.getClass();
        Class cls3 = x0.f1220a;
        if (!v.class.isAssignableFrom(cls) && (cls2 = x0.f1220a) != null && !cls2.isAssignableFrom(cls)) {
            g5.f.s("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            return null;
        }
        v0 v0VarMessageInfoFor = ((e0) f0Var.f1110a).messageInfoFor(cls);
        int i = v0VarMessageInfoFor.f1217d;
        a aVar = v0VarMessageInfoFor.f1214a;
        if ((i & 2) == 2) {
            if (v.class.isAssignableFrom(cls)) {
                e1 e1Var = x0.f1222c;
                o oVar2 = p.f1177a;
                o0 o0Var = new o0();
                o0Var.f1175b = e1Var;
                o0Var.f1176c = oVar2;
                o0Var.f1174a = aVar;
                VarHandle.storeStoreFence();
                n0VarS = o0Var;
            } else {
                e1 e1Var2 = x0.f1221b;
                o oVar3 = p.f1178b;
                if (oVar3 == null) {
                    od.f.e("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                o0 o0Var2 = new o0();
                o0Var2.f1175b = e1Var2;
                o0Var2.f1176c = oVar3;
                o0Var2.f1174a = aVar;
                VarHandle.storeStoreFence();
                n0VarS = o0Var2;
            }
        } else if (v.class.isAssignableFrom(cls)) {
            p0 p0Var = q0.f1183b;
            c0 c0Var = d0.f1096b;
            e1 e1Var3 = x0.f1222c;
            o oVar4 = s.f.c(v0VarMessageInfoFor.a()) != 1 ? p.f1177a : null;
            j0 j0Var = k0.f1146b;
            if (!(v0VarMessageInfoFor instanceof v0)) {
                int[] iArr = n0.f1160n;
                v0VarMessageInfoFor.getClass();
                od.f.j();
                return null;
            }
            n0VarS = n0.s(v0VarMessageInfoFor, p0Var, c0Var, e1Var3, oVar4, j0Var);
        } else {
            p0 p0Var2 = q0.f1182a;
            c0 c0Var2 = d0.f1095a;
            e1 e1Var4 = x0.f1221b;
            if (s.f.c(v0VarMessageInfoFor.a()) != 1) {
                o oVar5 = p.f1178b;
                if (oVar5 == null) {
                    od.f.e("Protobuf runtime is not correctly loaded.");
                    return null;
                }
                oVar = oVar5;
            } else {
                oVar = null;
            }
            j0 j0Var2 = k0.f1145a;
            if (!(v0VarMessageInfoFor instanceof v0)) {
                int[] iArr2 = n0.f1160n;
                v0VarMessageInfoFor.getClass();
                od.f.j();
                return null;
            }
            n0VarS = n0.s(v0VarMessageInfoFor, p0Var2, c0Var2, e1Var4, oVar, j0Var2);
        }
        w0 w0Var2 = (w0) concurrentHashMap.putIfAbsent(cls, n0VarS);
        return w0Var2 != null ? w0Var2 : n0VarS;
    }
}
