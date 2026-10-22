package hb;

import java.io.IOException;

/* loaded from: classes.dex */
public final class i extends db.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4290e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f4291f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4292g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, Object obj, Object obj2, int i2) {
        super(str, true);
        this.f4290e = i2;
        this.f4291f = obj;
        this.f4292g = obj2;
    }

    @Override // db.a
    public final long a() {
        long jA;
        int i2;
        x[] xVarArr;
        switch (this.f4290e) {
            case 0:
                p pVar = (p) this.f4291f;
                pVar.f4314f.a(pVar, (b0) ((q7.v) this.f4292g).f8820f);
                return -1L;
            case 1:
                try {
                    ((p) this.f4291f).f4314f.b((x) this.f4292g);
                } catch (IOException e10) {
                    ib.m mVar = ib.m.f5049a;
                    ib.m mVar2 = ib.m.f5049a;
                    String str = "Http2Connection.Listener failure for " + ((p) this.f4291f).f4316h;
                    mVar2.getClass();
                    ib.m.g(4, str, e10);
                    try {
                        ((x) this.f4292g).c(2, e10);
                    } catch (IOException unused) {
                    }
                }
                return -1L;
            default:
                k kVar = (k) this.f4291f;
                b0 b0Var = (b0) this.f4292g;
                q7.v vVar = new q7.v();
                p pVar2 = (p) kVar.f4299h;
                synchronized (pVar2.C) {
                    synchronized (pVar2) {
                        try {
                            b0 b0Var2 = pVar2.f4331w;
                            b0 b0Var3 = new b0();
                            b0Var3.b(b0Var2);
                            b0Var3.b(b0Var);
                            vVar.f8820f = b0Var3;
                            jA = b0Var3.a() - b0Var2.a();
                            i2 = 0;
                            xVarArr = (jA == 0 || pVar2.f4315g.isEmpty()) ? null : (x[]) pVar2.f4315g.values().toArray(new x[0]);
                            b0 b0Var4 = (b0) vVar.f8820f;
                            q7.k.e(b0Var4, "<set-?>");
                            pVar2.f4331w = b0Var4;
                            pVar2.f4323o.c(new i(pVar2.f4316h + " onSettings", pVar2, vVar, i2), 0L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        pVar2.C.a((b0) vVar.f8820f);
                    } catch (IOException e11) {
                        pVar2.a(2, 2, e11);
                    }
                }
                if (xVarArr != null) {
                    int length = xVarArr.length;
                    while (i2 < length) {
                        x xVar = xVarArr[i2];
                        synchronized (xVar) {
                            xVar.f4369f += jA;
                            if (jA > 0) {
                                xVar.notifyAll();
                            }
                        }
                        i2++;
                    }
                }
                return -1L;
        }
    }
}
