package F2;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.TaskUtils;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import com.stepos.minor.ui.MinorMainActivity;
import f2.C0702g;
import java.util.concurrent.TimeUnit;
import z3.C1347a;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: g, reason: collision with root package name */
    private static volatile j f1684g;

    /* renamed from: h, reason: collision with root package name */
    private static final ComponentName f1685h = new ComponentName("com.stepos.familyguard", "com.stepos.minor.ui.MinorMainActivity");

    /* renamed from: a, reason: collision with root package name */
    private final Application f1686a;

    /* renamed from: b, reason: collision with root package name */
    private int f1687b;

    /* renamed from: c, reason: collision with root package name */
    private int f1688c;

    /* renamed from: d, reason: collision with root package name */
    private final W f1689d = new W();

    /* renamed from: e, reason: collision with root package name */
    private final y f1690e;

    /* renamed from: f, reason: collision with root package name */
    private final G2.v f1691f;

    class a implements X {
        a() {
        }

        @Override // androidx.lifecycle.X
        public W getViewModelStore() {
            return j.this.f1689d;
        }
    }

    class b implements U.c {
        b() {
        }

        @Override // androidx.lifecycle.U.c
        public <T extends T> T a(Class<T> cls) {
            return new y(j.this.f1686a);
        }
    }

    class c implements TaskUtils.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Long l5) {
            j.this.f1691f.j(7);
        }

        @Override // android.app.TaskUtils.a
        public void a(ActivityManager.RunningTaskInfo runningTaskInfo) {
            if (j.this.f1691f != null) {
                j.this.f1691f.j(8);
            }
        }

        @Override // android.app.TaskUtils.a
        public void b(ActivityManager.RunningTaskInfo runningTaskInfo) {
            C0702g.b("MinorModeManager", "onTaskMoveToFront() called with: info = [" + runningTaskInfo + "] mStarted = [" + j.this.f1688c + "]");
            x3.f.b0(300L, TimeUnit.MILLISECONDS).X(T3.a.c()).G(C1347a.a()).S(new D3.c() { // from class: F2.k
                @Override // D3.c
                public final void accept(Object obj) {
                    this.f1696a.d((Long) obj);
                }
            });
        }
    }

    class d implements Application.ActivityLifecycleCallbacks {
        d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (C2.a.a(activity, "minor.mode")) {
                j.this.f1687b++;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            C0702g.b("MinorModeManager", "onActivityDestroyed() called with: activity = [" + activity + "]");
            if (C2.a.a(activity, "minor.mode")) {
                j jVar = j.this;
                jVar.f1687b--;
                if (j.this.f1687b == 0 && !activity.isChangingConfigurations()) {
                    j.this.l();
                }
                String strE = j.this.f1691f.e();
                if (strE == null || !strE.equals(activity.getClass().getName()) || activity.isChangingConfigurations()) {
                    return;
                }
                j.this.f1691f.o(null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStopped(Activity activity) {
            super.onActivityPostStopped(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            super.onActivityPreStopped(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (!C2.a.a(activity, "minor.mode") || (activity instanceof MinorMainActivity)) {
                return;
            }
            j.this.f1691f.o(activity.getClass().getName());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            C0702g.b("MinorModeManager", "onActivityStarted() called with: activity = [" + activity + "]");
            boolean z5 = activity instanceof MinorMainActivity;
            if (z5) {
                j.this.f1691f.n((stepos.support.v7.app.d) activity);
            }
            if (C2.a.a(activity, "minor.mode")) {
                j.this.f1688c++;
                C0702g.b("MinorModeManager", "isAffinity started = " + j.this.f1688c);
                if (z5) {
                    return;
                }
                j.this.f1691f.o(activity.getClass().getName());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            C0702g.b("MinorModeManager", "onActivityStopped() called with: activity = [" + activity + "]");
            if (C2.a.a(activity, "minor.mode")) {
                j jVar = j.this;
                jVar.f1688c--;
                C0702g.b("MinorModeManager", "isAffinity started = " + j.this.f1688c);
                if (j.this.f1688c != 0 || (activity instanceof MinorMainActivity)) {
                    return;
                }
                stepos.support.v7.app.d dVarD = j.this.f1691f.d();
                if (dVarD == null || dVarD.isFinishing() || dVarD.isDestroyed()) {
                    activity.finish();
                }
            }
        }
    }

    private j(Application application) {
        this.f1686a = application;
        a aVar = new a();
        b bVar = new b();
        try {
            TaskUtils.b(f1685h, new c());
        } catch (Throwable th) {
            Log.w("MinorModeManager", "Failed to register task stack listener, minor mode will still work without it.", th);
        }
        y yVar = (y) new U(aVar, bVar).a(y.class);
        this.f1690e = yVar;
        this.f1691f = new G2.v(yVar, false);
        application.registerActivityLifecycleCallbacks(new d());
    }

    public static j j(Application application) {
        if (f1684g == null) {
            synchronized (j.class) {
                try {
                    if (f1684g == null) {
                        f1684g = new j(application);
                    }
                } finally {
                }
            }
        }
        return f1684g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Log.d("MinorModeManager", "onAllMinorActivityFinished() called");
        this.f1691f.a();
        this.f1689d.a();
    }

    public G2.v k() {
        return this.f1691f;
    }

    public void m(Configuration configuration) {
        stepos.support.v7.app.d dVarD = this.f1691f.d();
        if (dVarD instanceof MinorMainActivity) {
            final MinorMainActivity minorMainActivity = (MinorMainActivity) dVarD;
            final int i5 = configuration.uiMode & 48;
            dVarD.getWindow().getDecorView().post(new Runnable() { // from class: F2.i
                @Override // java.lang.Runnable
                public final void run() {
                    minorMainActivity.k0(i5);
                }
            });
        }
    }
}
