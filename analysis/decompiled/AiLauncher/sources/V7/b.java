package V7;

import Z7.C1130b;
import Z7.C1139k;
import Z7.C1144p;
import Z7.C1146s;
import Z7.N;
import Z7.T;
import Z7.Y;
import Z7.r;
import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;

/* loaded from: classes4.dex */
public class b extends N {

    /* renamed from: e, reason: collision with root package name */
    public static int f6499e;

    /* renamed from: f, reason: collision with root package name */
    public static b f6500f = new b();

    /* renamed from: d, reason: collision with root package name */
    public boolean f6501d = false;

    public static b h() {
        b bVar = f6500f;
        bVar.f7336a = 1004;
        return bVar;
    }

    @Override // Z7.N
    public String[] a() {
        return new String[]{"t_cr"};
    }

    @Override // Z7.N
    public synchronized void b(Context context, boolean z10, a aVar) {
        if (context != null) {
            try {
                if (!this.f6501d) {
                    C1139k.d("Initializing crash module.", new Object[0]);
                    T tA = T.a();
                    int i10 = f6499e + 1;
                    f6499e = i10;
                    tA.e(i10);
                    this.f6501d = true;
                    W7.a.c(context);
                    g(context, aVar);
                    r rVarB = r.b(context, z10, null);
                    rVarB.f7599c.c();
                    rVarB.f7600d.p();
                    if (C1130b.l().f7455f.equals(Y.b(rVarB.f7597a))) {
                        rVarB.f7600d.x();
                    }
                    rVarB.f();
                    rVarB.g();
                    rVarB.c(0L);
                    rVarB.f7600d.o();
                    C1146s.a(context);
                    C1144p c1144pA = C1144p.a();
                    c1144pA.d("android.net.conn.CONNECTIVITY_CHANGE");
                    c1144pA.c(context);
                    T tA2 = T.a();
                    int i11 = f6499e - 1;
                    f6499e = i11;
                    tA2.e(i11);
                }
            } finally {
            }
        }
    }

    @Override // Z7.N
    public void f(StrategyBean strategyBean) {
        r rVarA;
        if (strategyBean == null || (rVarA = r.a()) == null) {
            return;
        }
        rVarA.f7599c.d(strategyBean);
        rVarA.f7600d.w(strategyBean);
        rVarA.f7603g.h();
    }

    public final synchronized void g(Context context, a aVar) {
    }
}
