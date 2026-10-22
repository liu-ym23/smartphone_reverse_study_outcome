package m4;

import java.io.File;

/* loaded from: classes.dex */
public final class e0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6183f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6184g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f6185h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f6186i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(q0 q0Var, String str, g7.d dVar, int i2) {
        super(2, dVar);
        this.f6183f = i2;
        this.f6185h = q0Var;
        this.f6186i = str;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6183f) {
            case 0:
                e0 e0Var = new e0(this.f6185h, this.f6186i, dVar, 0);
                e0Var.f6184g = obj;
                return e0Var;
            case 1:
                e0 e0Var2 = new e0(this.f6185h, this.f6186i, dVar, 1);
                e0Var2.f6184g = obj;
                return e0Var2;
            default:
                e0 e0Var3 = new e0(this.f6185h, this.f6186i, dVar, 2);
                e0Var3.f6184g = obj;
                return e0Var3;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6183f) {
        }
        return ((e0) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        Object objN;
        String strN;
        Object objN2;
        Object objN3;
        int i2 = this.f6183f;
        String str = this.f6186i;
        q0 q0Var = this.f6185h;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                u0 u0Var = q0Var.f6312a;
                byte[] bArrB = q0Var.f6313b.b(str);
                d7.a0 a0Var = d7.a0.f2944f;
                if (bArrB == null) {
                    return new a6.m(false, null, "BLOB_NOT_FOUND", a1.a.j("blob ", str, " not in cache"), a0Var, 2);
                }
                try {
                    File parentFile = ((File) u0Var.f6342b).getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    n7.l.P((File) u0Var.f6342b, bArrB);
                    q0Var.e0("config.backup", "imported", null);
                    objN = new a6.m(true, null, null, null, null, 28);
                } catch (Throwable th) {
                    objN = w7.e0.n(th);
                }
                Throwable thA = c7.m.a(objN);
                return thA == null ? objN : new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), a0Var, 2);
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                try {
                    File fileL = q0Var.f6312a.l(str);
                    File file = fileL.exists() ? fileL : null;
                    strN = file != null ? n7.l.N(file) : "";
                } catch (Throwable th2) {
                    strN = w7.e0.n(th2);
                }
                Throwable thA2 = c7.m.a(strN);
                if (thA2 == null) {
                    return strN;
                }
                throw new IllegalArgumentException(thA2.getMessage());
            default:
                h7.a aVar3 = h7.a.f4212f;
                w7.e0.N(obj);
                u0 u0Var2 = q0Var.f6312a;
                u0Var2.getClass();
                q7.k.e(str, "id");
                File fileO = n7.l.O(n7.l.O((File) u0Var2.f6341a, "usr/local/lib/node_modules/openclaw/tools"), str);
                boolean zExists = fileO.exists();
                d7.a0 a0Var2 = d7.a0.f2944f;
                if (!zExists) {
                    return new a6.m(false, null, "NOT_FOUND", "tool ".concat(str), a0Var2, 2);
                }
                try {
                    objN2 = Boolean.valueOf(!q7.k.a(q0Var.f6316e.b(u0Var2.o(str)).get("source") instanceof String ? (String) r0 : null, "local"));
                } catch (Throwable th3) {
                    objN2 = w7.e0.n(th3);
                }
                Boolean bool = Boolean.TRUE;
                boolean z4 = objN2 instanceof c7.l;
                Object obj2 = objN2;
                if (z4) {
                    obj2 = bool;
                }
                if (((Boolean) obj2).booleanValue()) {
                    return new a6.m(false, null, "NOT_FOUND", a1.a.j("core tool ", str, " is not removable"), a0Var2, 2);
                }
                String str2 = this.f6186i;
                try {
                    n7.l.K(fileO);
                    q0Var.e0("tools", "uninstalled", str2);
                    objN3 = new a6.m(true, str2, null, null, null, 28);
                } catch (Throwable th4) {
                    objN3 = w7.e0.n(th4);
                }
                Throwable thA3 = c7.m.a(objN3);
                return thA3 == null ? objN3 : new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA3.getMessage(), a0Var2, 2);
        }
    }
}
