package Z7;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.bs;
import com.tencent.bugly.proguard.bt;
import java.util.List;
import java.util.Map;

/* renamed from: Z7.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1131c {

    /* renamed from: f, reason: collision with root package name */
    public static int f7494f = 1000;

    /* renamed from: g, reason: collision with root package name */
    public static C1131c f7495g;

    /* renamed from: h, reason: collision with root package name */
    public static String f7496h;

    /* renamed from: a, reason: collision with root package name */
    public final List<N> f7497a;

    /* renamed from: b, reason: collision with root package name */
    public final C1138j f7498b;

    /* renamed from: c, reason: collision with root package name */
    public final StrategyBean f7499c;

    /* renamed from: d, reason: collision with root package name */
    public StrategyBean f7500d = null;

    /* renamed from: e, reason: collision with root package name */
    public Context f7501e;

    /* renamed from: Z7.c$a */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                Map<String, byte[]> mapN = V.f().n(C1131c.f7494f, null);
                if (mapN != null) {
                    byte[] bArr = mapN.get(Parameters.DEVICE);
                    byte[] bArr2 = mapN.get("gateway");
                    if (bArr != null) {
                        C1130b.h(C1131c.this.f7501e).q(new String(bArr));
                    }
                    if (bArr2 != null) {
                        C1130b.h(C1131c.this.f7501e).o(new String(bArr2));
                    }
                }
                C1131c.this.f7500d = C1131c.j();
                if (C1131c.this.f7500d != null) {
                    if (C1143o.G(C1131c.f7496h) || !C1143o.N(C1131c.f7496h)) {
                        C1131c.this.f7500d.f31463q = StrategyBean.f31447a;
                        C1131c.this.f7500d.f31464r = StrategyBean.f31448b;
                    } else {
                        C1131c.this.f7500d.f31463q = C1131c.f7496h;
                        C1131c.this.f7500d.f31464r = C1131c.f7496h;
                    }
                }
            } catch (Throwable th) {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
            }
            C1131c c1131c = C1131c.this;
            c1131c.e(c1131c.f7500d, false);
        }
    }

    public C1131c(Context context, List<N> list) {
        this.f7501e = context;
        if (C1130b.h(context) != null) {
            String str = C1130b.h(context).f7452d0;
            if ("oversea".equals(str)) {
                StrategyBean.f31447a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f31448b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f31447a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f31448b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f7499c = new StrategyBean();
        this.f7497a = list;
        this.f7498b = C1138j.a();
    }

    public static synchronized C1131c a() {
        return f7495g;
    }

    public static synchronized C1131c b(Context context, List<N> list) {
        try {
            if (f7495g == null) {
                f7495g = new C1131c(context, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7495g;
    }

    public static StrategyBean j() {
        byte[] bArr;
        List<X> listM = V.f().m(2);
        if (listM == null || listM.size() <= 0 || (bArr = listM.get(0).f7414g) == null) {
            return null;
        }
        return (StrategyBean) C1143o.e(bArr, StrategyBean.CREATOR);
    }

    public final void e(StrategyBean strategyBean, boolean z10) {
        C1139k.h("[Strategy] Notify %s", S.class.getName());
        S.c(strategyBean, z10);
        for (N n10 : this.f7497a) {
            try {
                C1139k.h("[Strategy] Notify %s", n10.getClass().getName());
                n10.f(strategyBean);
            } catch (Throwable th) {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void f(bt btVar) throws NumberFormatException {
        int i10;
        if (btVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f7500d;
        if (strategyBean == null || btVar.f31663h != strategyBean.f31461o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f31452f = btVar.f31656a;
            strategyBean2.f31454h = btVar.f31658c;
            strategyBean2.f31453g = btVar.f31657b;
            if (C1143o.G(f7496h) || !C1143o.N(f7496h)) {
                if (C1143o.N(btVar.f31659d)) {
                    C1139k.h("[Strategy] Upload url changes to %s", btVar.f31659d);
                    strategyBean2.f31463q = btVar.f31659d;
                }
                if (C1143o.N(btVar.f31660e)) {
                    C1139k.h("[Strategy] Exception upload url changes to %s", btVar.f31660e);
                    strategyBean2.f31464r = btVar.f31660e;
                }
            }
            bs bsVar = btVar.f31661f;
            if (bsVar != null && !C1143o.G(bsVar.f31651a)) {
                strategyBean2.f31465s = btVar.f31661f.f31651a;
            }
            long j10 = btVar.f31663h;
            if (j10 != 0) {
                strategyBean2.f31461o = j10;
            }
            Map<String, String> map = btVar.f31662g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = btVar.f31662g;
                strategyBean2.f31466t = map2;
                String str = map2.get("B11");
                strategyBean2.f31455i = str != null && str.equals("1");
                String str2 = btVar.f31662g.get("B3");
                if (str2 != null) {
                    strategyBean2.f31469w = Long.parseLong(str2);
                }
                int i11 = btVar.f31667l;
                strategyBean2.f31462p = i11;
                strategyBean2.f31468v = i11;
                String str3 = btVar.f31662g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i12 = Integer.parseInt(str3);
                        if (i12 > 0) {
                            strategyBean2.f31467u = i12;
                        }
                    } catch (Exception e10) {
                        if (!C1139k.e(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                String str4 = btVar.f31662g.get("B25");
                strategyBean2.f31457k = str4 != null && str4.equals("1");
            }
            C1139k.d("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f31452f), Boolean.valueOf(strategyBean2.f31454h), Boolean.valueOf(strategyBean2.f31453g), Boolean.valueOf(strategyBean2.f31455i), Boolean.valueOf(strategyBean2.f31456j), Boolean.valueOf(strategyBean2.f31459m), Boolean.valueOf(strategyBean2.f31460n), Long.valueOf(strategyBean2.f31462p), Boolean.valueOf(strategyBean2.f31457k), Long.valueOf(strategyBean2.f31461o));
            this.f7500d = strategyBean2;
            if (C1143o.N(btVar.f31659d)) {
                i10 = 0;
            } else {
                i10 = 0;
                C1139k.h("[Strategy] download url is null", new Object[0]);
                this.f7500d.f31463q = "";
            }
            if (!C1143o.N(btVar.f31660e)) {
                C1139k.h("[Strategy] download crashurl is null", new Object[i10]);
                this.f7500d.f31464r = "";
            }
            V.f().x(2);
            X x10 = new X();
            x10.f7409b = 2;
            x10.f7408a = strategyBean2.f31450d;
            x10.f7412e = strategyBean2.f31451e;
            x10.f7414g = C1143o.w(strategyBean2);
            V.f().v(x10);
            e(strategyBean2, true);
        }
    }

    public final synchronized boolean h() {
        return this.f7500d != null;
    }

    public final StrategyBean i() {
        StrategyBean strategyBean = this.f7500d;
        if (strategyBean != null) {
            if (!C1143o.N(strategyBean.f31463q)) {
                this.f7500d.f31463q = StrategyBean.f31447a;
            }
            if (!C1143o.N(this.f7500d.f31464r)) {
                this.f7500d.f31464r = StrategyBean.f31448b;
            }
            return this.f7500d;
        }
        if (!C1143o.G(f7496h) && C1143o.N(f7496h)) {
            StrategyBean strategyBean2 = this.f7499c;
            String str = f7496h;
            strategyBean2.f31463q = str;
            strategyBean2.f31464r = str;
        }
        return this.f7499c;
    }
}
