package Q5;

import A5.c;
import O5.d;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public final c h;
    public String i;
    public long f = 0;
    public long e = 0;
    public long d = 0;
    public long c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f1117a = System.currentTimeMillis();
    public final long b = SystemClock.elapsedRealtime();
    public final a g = new a(this, Looper.getMainLooper(), 0);

    public b(c cVar) {
        this.h = cVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        W5.c.a("ActivityLifecycleCallback", "onActivityPaused, process:" + Process.myPid());
        this.d = System.currentTimeMillis();
        this.f = SystemClock.elapsedRealtime();
        a aVar = this.g;
        aVar.removeMessages(1);
        aVar.sendEmptyMessageDelayed(1, 1000L);
        c cVar = this.h;
        if (cVar.l().equals(this.i)) {
            return;
        }
        d dVar = O5.c.f1037a;
        dVar.g.f(dVar.f1038a, "_startup_", null, null, 0);
        this.i = cVar.l();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        W5.c.a("ActivityLifecycleCallback", "onActivityResumed, process:" + Process.myPid());
        long j5 = this.c;
        c cVar = this.h;
        if (j5 == 0) {
            W5.c.a("SessionController", "onForeground");
            ((a) cVar.c).removeCallbacksAndMessages(null);
            this.c = System.currentTimeMillis();
            this.e = SystemClock.elapsedRealtime();
        }
        this.g.removeMessages(1);
        if (cVar.l().equals(this.i)) {
            return;
        }
        d dVar = O5.c.f1037a;
        dVar.g.f(dVar.f1038a, "_startup_", null, null, 0);
        this.i = cVar.l();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
