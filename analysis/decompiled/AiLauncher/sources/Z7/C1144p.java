package Z7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.ab;

/* renamed from: Z7.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1144p extends BroadcastReceiver {

    /* renamed from: e, reason: collision with root package name */
    public static C1144p f7567e;

    /* renamed from: b, reason: collision with root package name */
    public Context f7569b;

    /* renamed from: c, reason: collision with root package name */
    public String f7570c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7571d = true;

    /* renamed from: a, reason: collision with root package name */
    public IntentFilter f7568a = new IntentFilter();

    /* renamed from: Z7.p$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1144p f7572a;

        public a(C1144p c1144p) {
            this.f7572a = c1144p;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                C1139k.c(C1144p.f7567e.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                synchronized (this.f7572a) {
                    C1144p.this.f7569b.registerReceiver(C1144p.f7567e, C1144p.this.f7568a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized C1144p a() {
        try {
            if (f7567e == null) {
                f7567e = new C1144p();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7567e;
    }

    public final synchronized void c(Context context) {
        this.f7569b = context;
        C1143o.v(new a(this));
    }

    public final synchronized void d(String str) {
        try {
            if (!this.f7568a.hasAction(str)) {
                this.f7568a.addAction(str);
            }
            C1139k.h("add action %s", str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean e(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f7571d) {
                    this.f7571d = false;
                    return true;
                }
                String strF = ab.f(this.f7569b);
                C1139k.h("is Connect BC ".concat(String.valueOf(strF)), new Object[0]);
                C1139k.d("network %s changed to %s", this.f7570c, String.valueOf(strF));
                if (strF == null) {
                    this.f7570c = null;
                    return true;
                }
                String str = this.f7570c;
                this.f7570c = strF;
                long jCurrentTimeMillis = System.currentTimeMillis();
                C1131c c1131cA = C1131c.a();
                C1136h c1136hC = C1136h.c();
                C1130b c1130bH = C1130b.h(context);
                if (c1131cA != null && c1136hC != null && c1130bH != null) {
                    if (!strF.equals(str) && jCurrentTimeMillis - c1136hC.a(r.f7580j) > 30000) {
                        C1139k.d("try to upload crash on network changed.", new Object[0]);
                        r rVarA = r.a();
                        if (rVarA != null) {
                            rVarA.c(0L);
                        }
                        C1139k.d("try to upload userinfo on network changed.", new Object[0]);
                        S.f7367i.q();
                    }
                    return true;
                }
                C1139k.i("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            e(context, intent);
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
