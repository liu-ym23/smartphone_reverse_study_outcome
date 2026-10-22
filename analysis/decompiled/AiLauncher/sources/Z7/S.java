package Z7;

import Z7.Q.c;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;

/* loaded from: classes4.dex */
public class S {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7359a = false;

    /* renamed from: b, reason: collision with root package name */
    public static int f7360b = 10;

    /* renamed from: c, reason: collision with root package name */
    public static long f7361c = 300000;

    /* renamed from: d, reason: collision with root package name */
    public static long f7362d = 30000;

    /* renamed from: e, reason: collision with root package name */
    public static long f7363e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static int f7364f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static long f7365g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static long f7366h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static Q f7367i = null;

    /* renamed from: j, reason: collision with root package name */
    public static long f7368j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static Application.ActivityLifecycleCallbacks f7369k = null;

    /* renamed from: l, reason: collision with root package name */
    public static Class<?> f7370l = null;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f7371m = true;

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7372a;

        public a(Context context, V7.a aVar) {
            this.f7372a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            S.i(this.f7372a, null);
        }
    }

    public static class b implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (S.f7370l == null || S.f7370l.getName().equals(name)) {
                C1139k.h(">>> %s onCreated <<<", name);
                C1130b c1130bL = C1130b.l();
                if (c1130bL != null) {
                    c1130bL.f7460h0.add(S.a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (S.f7370l == null || S.f7370l.getName().equals(name)) {
                C1139k.h(">>> %s onDestroyed <<<", name);
                C1130b c1130bL = C1130b.l();
                if (c1130bL != null) {
                    c1130bL.f7460h0.add(S.a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (S.f7370l == null || S.f7370l.getName().equals(name)) {
                C1139k.h(">>> %s onPaused <<<", name);
                C1130b c1130bL = C1130b.l();
                if (c1130bL == null) {
                    return;
                }
                c1130bL.f7460h0.add(S.a(name, "onPaused"));
                long jCurrentTimeMillis = System.currentTimeMillis();
                c1130bL.f7441W = jCurrentTimeMillis;
                c1130bL.f7442X = jCurrentTimeMillis - c1130bL.f7440V;
                long unused = S.f7365g = jCurrentTimeMillis;
                if (c1130bL.f7442X < 0) {
                    c1130bL.f7442X = 0L;
                }
                c1130bL.f7439U = "background";
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (S.f7370l == null || S.f7370l.getName().equals(name)) {
                C1139k.h(">>> %s onResumed <<<", name);
                C1130b c1130bL = C1130b.l();
                if (c1130bL == null) {
                    return;
                }
                c1130bL.f7460h0.add(S.a(name, "onResumed"));
                c1130bL.f7439U = name;
                long jCurrentTimeMillis = System.currentTimeMillis();
                c1130bL.f7440V = jCurrentTimeMillis;
                c1130bL.f7443Y = jCurrentTimeMillis - S.f7366h;
                long j10 = c1130bL.f7440V - S.f7365g;
                if (j10 > (S.f7363e > 0 ? S.f7363e : S.f7362d)) {
                    c1130bL.n();
                    S.m();
                    C1139k.d("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j10 / 1000), Long.valueOf(S.f7362d / 1000));
                    if (S.f7364f % S.f7360b == 0) {
                        S.f7367i.e(4, S.f7371m);
                        return;
                    }
                    S.f7367i.e(4, false);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 - S.f7368j > S.f7361c) {
                        long unused = S.f7368j = jCurrentTimeMillis2;
                        C1139k.d("add a timer to upload hot start user info", new Object[0]);
                        if (S.f7371m) {
                            C1138j.a().c(S.f7367i.new c(null, true), S.f7361c);
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            C1139k.h(">>> %s onStart <<<", activity.getClass().getName());
            C1130b.l().i(activity.hashCode(), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            C1139k.h(">>> %s onStop <<<", activity.getClass().getName());
            C1130b.l().i(activity.hashCode(), false);
        }
    }

    public static /* synthetic */ String a(String str, String str2) {
        return C1143o.f() + "  " + str + "  " + str2 + "\n";
    }

    public static void b(Context context, V7.a aVar) {
        if (f7359a) {
            return;
        }
        f7371m = C1130b.h(context).f7459h;
        f7367i = new Q(context, f7371m);
        f7359a = true;
        if (0 <= 0) {
            i(context, aVar);
        } else {
            C1138j.a().c(new a(context, aVar), 0L);
        }
    }

    public static void c(StrategyBean strategyBean, boolean z10) {
        Q q10 = f7367i;
        if (q10 != null && !z10) {
            q10.q();
        }
        if (strategyBean == null) {
            return;
        }
        long j10 = strategyBean.f31462p;
        if (j10 > 0) {
            f7362d = j10;
        }
        int i10 = strategyBean.f31467u;
        if (i10 > 0) {
            f7360b = i10;
        }
        long j11 = strategyBean.f31468v;
        if (j11 > 0) {
            f7361c = j11;
        }
    }

    public static void i(Context context, V7.a aVar) {
        C1130b c1130bL = C1130b.l();
        if (c1130bL != null && Y.d()) {
            c1130bL.i(0, true);
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application != null) {
            try {
                if (f7369k == null) {
                    f7369k = new b();
                }
                application.registerActivityLifecycleCallbacks(f7369k);
            } catch (Exception e10) {
                if (!C1139k.e(e10)) {
                    e10.printStackTrace();
                }
            }
        }
        if (f7371m) {
            f7366h = System.currentTimeMillis();
            f7367i.e(1, false);
            C1139k.d("[session] launch app, new start", new Object[0]);
            f7367i.d();
            f7367i.f(Const.sMaxValidTimeInQueue);
        }
    }

    public static /* synthetic */ int m() {
        int i10 = f7364f;
        f7364f = i10 + 1;
        return i10;
    }
}
