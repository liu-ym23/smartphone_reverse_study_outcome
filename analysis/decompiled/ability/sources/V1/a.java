package V1;

import D2.b;
import D7.N;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import ca.AbstractC0897f;
import com.apm.insight.MonitorCrash;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import h2.d;
import n2.c;
import w2.f;
import z2.l;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1301a;
    public Context b;

    public /* synthetic */ a() {
        this.f1301a = 2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        MonitorCrash monitorCrash;
        switch (this.f1301a) {
            case 0:
                if (AbstractC0897f.h(this.b)) {
                    Q1.a.b().a();
                    return;
                }
                return;
            case 1:
                ((SharedPreferences) N.f.b(this.b)).edit().putBoolean("_install_started_v2", true).apply();
                return;
            default:
                try {
                    d.B();
                } catch (Throwable unused) {
                }
                try {
                    if (com.stepos.statsrpk.d.l(this.b)) {
                        f.c().f(b.f(this.b));
                    } else {
                        NativeImpl.x();
                    }
                } catch (Throwable th) {
                    try {
                        S0.b.p0(th);
                        u1.d.B().A(g.a().m(), c.g());
                        if (l.i().d == null || com.apm.insight.f.b == null) {
                            return;
                        }
                    } finally {
                        u1.d.B().A(g.a().m(), c.g());
                        if (l.i().d != null && com.apm.insight.f.b != null) {
                            stepos.support.v7.app.palette.b.a(this.b, l.i().d).b();
                        }
                    }
                }
                if (handler != null) {
                    if (monitorCrash == null) {
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public /* synthetic */ a(Context context, int i) {
        this.f1301a = i;
        this.b = context;
    }
}
