package o4;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class y1 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7700a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7701b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7702c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7703d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f7704e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f7705f;

    public y1(k5.q qVar, a3.b bVar, y4.q qVar2, k5.t tVar, ia.b0 b0Var, y4.q qVar3) {
        q7.k.e(qVar, "internalBus");
        q7.k.e(bVar, "capabilityRegistry");
        q7.k.e(tVar, "logger");
        q7.k.e(b0Var, "scope");
        this.f7700a = bVar;
        this.f7701b = qVar2;
        this.f7702c = tVar;
        this.f7703d = b0Var;
        this.f7704e = qVar3;
        this.f7705f = d7.b0.f2947f;
    }

    public static final void a(y1 y1Var) {
        la.u0 u0Var = (la.u0) y1Var.f7702c;
        Collection collectionValues = ((ConcurrentHashMap) y1Var.f7701b).values();
        q7.k.d(collectionValues, "<get-values>(...)");
        List listM1 = d7.r.m1(d7.r.j1(collectionValues, new v1()));
        u0Var.getClass();
        u0Var.g(null, listM1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(o4.y1 r11, java.util.List r12, java.util.List r13, i7.c r14) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.y1.b(o4.y1, java.util.List, java.util.List, i7.c):java.lang.Object");
    }

    public static String d(NsdServiceInfo nsdServiceInfo, String str, Integer num) {
        if (str == null) {
            InetAddress host = nsdServiceInfo.getHost();
            str = host != null ? host.getHostAddress() : null;
            if (str == null) {
                str = "unknown";
            }
        }
        int iIntValue = num != null ? num.intValue() : nsdServiceInfo.getPort();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        q7.k.d(lowerCase, "toLowerCase(...)");
        return "mdns|" + lowerCase + "|" + iIntValue;
    }

    public void c() {
        y yVar;
        Set setQ1 = d7.r.q1(d7.t.B0(((a3.b) this.f7700a).u().values()));
        if (setQ1.equals((Set) this.f7705f)) {
            return;
        }
        this.f7705f = setQ1;
        t1 t1Var = ((y4.q) this.f7701b).f11639g.f11664r;
        if (t1Var == null || (yVar = ((y4.q) this.f7704e).f11639g.f11667u) == null) {
            return;
        }
        List listM1 = d7.r.m1(setQ1);
        String str = yVar.f7688a;
        List list = yVar.f7689b;
        List list2 = yVar.f7690c;
        Map map = yVar.f7692e;
        v vVar = yVar.f7693f;
        String str2 = yVar.f7694g;
        String str3 = yVar.f7695h;
        q7.k.e(str, "role");
        q7.k.e(list, "scopes");
        q7.k.e(list2, "caps");
        q7.k.e(map, "permissions");
        q7.k.e(vVar, "client");
        y yVar2 = new y(str, list, list2, listM1, map, vVar, str2, str3);
        k5.s.info$default((k5.t) this.f7702c, "EdgeCapsForwarder", "commands changed → reconnect node session with commands=" + setQ1, null, 4, null);
        i0 i0Var = t1Var.E;
        if (i0Var == null) {
            return;
        }
        t1Var.E = new i0(i0Var.f7394c, yVar2, i0Var.f7392a, i0Var.f7393b);
        t1Var.f7597y.l();
    }

    public y1(Context context, ia.b0 b0Var) {
        Object objN;
        q7.k.e(context, "context");
        q7.k.e(b0Var, "scope");
        try {
            objN = (NsdManager) context.getSystemService(NsdManager.class);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        this.f7700a = (NsdManager) (objN instanceof c7.l ? null : objN);
        this.f7701b = new ConcurrentHashMap();
        la.u0 u0VarC = la.k0.c(d7.z.f2978f);
        this.f7702c = u0VarC;
        this.f7704e = new la.f0(u0VarC);
        this.f7703d = la.k0.c("Idle");
    }
}
