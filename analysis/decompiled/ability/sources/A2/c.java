package A2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;

/* loaded from: classes2.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f77a;

    public c(e eVar) {
        this.f77a = eVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String name = activity.getClass().getName();
        e eVar = this.f77a;
        eVar.f = name;
        eVar.g = System.currentTimeMillis();
        e.u = bundle != null;
        e.f80v = true;
        eVar.f84a.add(eVar.f);
        eVar.b.add(Long.valueOf(eVar.g));
        e.b(eVar.g, eVar, eVar.f, AppAgent.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        String name = activity.getClass().getName();
        e eVar = this.f77a;
        int iIndexOf = eVar.f84a.indexOf(name);
        if (iIndexOf > -1 && iIndexOf < eVar.f84a.size()) {
            eVar.f84a.remove(iIndexOf);
            eVar.b.remove(iIndexOf);
        }
        eVar.c.add(name);
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.d.add(Long.valueOf(jCurrentTimeMillis));
        e.b(jCurrentTimeMillis, eVar, name, "onDestroy");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        String name = activity.getClass().getName();
        e eVar = this.f77a;
        eVar.l = name;
        eVar.m = System.currentTimeMillis();
        int i = eVar.f88s - 1;
        eVar.f88s = i;
        if (i == 0) {
            eVar.p = false;
            e.f80v = false;
            eVar.f86q = SystemClock.uptimeMillis();
        } else if (i < 0) {
            eVar.f88s = 0;
            eVar.p = false;
            e.f80v = false;
            eVar.f86q = SystemClock.uptimeMillis();
        }
        e.b(eVar.m, eVar, eVar.l, "onPause");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        int i;
        String name = activity.getClass().getName();
        e eVar = this.f77a;
        eVar.f85j = name;
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.k = jCurrentTimeMillis;
        eVar.f88s++;
        if (!eVar.p) {
            eVar.p = true;
            if (e.f79t) {
                e.f79t = false;
                e.f81w = 1;
                e.y = jCurrentTimeMillis;
            }
            if (eVar.f85j.equals(eVar.l)) {
                boolean z10 = e.f80v;
                if (!z10 || e.u) {
                    i = z10 ? 4 : 3;
                }
                e.f81w = i;
                e.y = eVar.k;
            }
            N9.j.i("Background", "false");
        }
        e.b(eVar.k, eVar, eVar.f85j, "onResume");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        String name = activity.getClass().getName();
        e eVar = this.f77a;
        eVar.h = name;
        eVar.i = System.currentTimeMillis();
        e.b(eVar.i, eVar, eVar.h, "onStart");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        String name = activity.getClass().getName();
        e eVar = this.f77a;
        eVar.n = name;
        eVar.o = System.currentTimeMillis();
        e.b(eVar.o, eVar, eVar.n, "onStop");
    }
}
