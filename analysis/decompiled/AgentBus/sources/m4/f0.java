package m4;

import b0.b2;
import java.io.File;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class f0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6190f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6191g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f6192h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ a6.h f6193i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(q0 q0Var, a6.h hVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f6190f = i2;
        this.f6192h = q0Var;
        this.f6193i = hVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6190f) {
            case 0:
                f0 f0Var = new f0(this.f6192h, this.f6193i, dVar, 0);
                f0Var.f6191g = obj;
                return f0Var;
            default:
                f0 f0Var2 = new f0(this.f6192h, this.f6193i, dVar, 1);
                f0Var2.f6191g = obj;
                return f0Var2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6190f) {
        }
        return ((f0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        Object objN;
        Object objN2;
        int i2 = this.f6190f;
        a6.h hVar = this.f6193i;
        q0 q0Var = this.f6192h;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                f5.f fVar = q0Var.f6313b;
                String str = hVar.f321c;
                String str2 = hVar.f320b;
                String str3 = hVar.f319a;
                File fileD = fVar.d(str);
                d7.a0 a0Var = d7.a0.f2944f;
                if (fileD == null) {
                    return new a6.m(false, null, "BLOB_NOT_FOUND", a1.a.j("blob ", hVar.f321c, " not in cache"), a0Var, 2);
                }
                try {
                    u0 u0Var = q0Var.f6312a;
                    r0 r0Var = q0Var.f6316e;
                    a.a.L(fileD, u0Var.c(str3));
                    u0Var.getClass();
                    File fileO = n7.l.O(u0Var.c(str3), ".channel-meta.json");
                    r0Var.getClass();
                    Map mapB = r0Var.b(fileO);
                    mapB.put("id", str3);
                    mapB.put("version", str2);
                    String lowerCase = hVar.f322d.name().toLowerCase(Locale.ROOT);
                    q7.k.d(lowerCase, "toLowerCase(...)");
                    mapB.put("source", lowerCase);
                    String str4 = hVar.f324f;
                    if (str4 != null) {
                        mapB.put("catalog_description", str4);
                    }
                    r0Var.c(fileO, mapB);
                    r0Var.a((File) u0Var.f6342b, new b2(6, str3, str2));
                    q0Var.e0("channels", "installed", str3);
                    objN = new a6.m(true, str3, null, null, null, 28);
                } catch (Throwable th) {
                    objN = w7.e0.n(th);
                }
                Throwable thA = c7.m.a(objN);
                return thA == null ? objN : new a6.m(false, null, "INSTALL_FAILED", thA.getMessage(), a0Var, 2);
            default:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                u0 u0Var2 = q0Var.f6312a;
                f5.f fVar2 = q0Var.f6313b;
                String str5 = hVar.f321c;
                String str6 = hVar.f319a;
                File fileD2 = fVar2.d(str5);
                d7.a0 a0Var2 = d7.a0.f2944f;
                if (fileD2 == null) {
                    return new a6.m(false, null, "BLOB_NOT_FOUND", a1.a.j("blob ", hVar.f321c, " not in cache"), a0Var2, 2);
                }
                try {
                    u0Var2.getClass();
                    a.a.L(fileD2, n7.l.O(n7.l.O((File) u0Var2.f6341a, "usr/local/lib/node_modules/openclaw/tools"), str6));
                    r0 r0Var2 = q0Var.f6316e;
                    File fileO2 = u0Var2.o(str6);
                    r0Var2.getClass();
                    Map mapB2 = r0Var2.b(fileO2);
                    mapB2.put("id", str6);
                    mapB2.put("version", hVar.f320b);
                    String lowerCase2 = hVar.f322d.name().toLowerCase(Locale.ROOT);
                    q7.k.d(lowerCase2, "toLowerCase(...)");
                    mapB2.put("source", lowerCase2);
                    r0Var2.c(fileO2, mapB2);
                    q0Var.e0("tools", "installed", str6);
                    objN2 = new a6.m(true, str6, null, null, null, 28);
                } catch (Throwable th2) {
                    objN2 = w7.e0.n(th2);
                }
                Throwable thA2 = c7.m.a(objN2);
                return thA2 == null ? objN2 : new a6.m(false, null, "INSTALL_FAILED", thA2.getMessage(), a0Var2, 2);
        }
    }
}
