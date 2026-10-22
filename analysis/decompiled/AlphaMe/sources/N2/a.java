package N2;

import L2.b;
import L2.c;
import T2.d;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import androidx.fragment.app.C0284f;
import f0.HandlerC0555a;

/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: h, reason: collision with root package name */
    public final C0284f f1487h;

    /* renamed from: i, reason: collision with root package name */
    public String f1488i;

    /* renamed from: f, reason: collision with root package name */
    public long f1485f = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f1484e = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f1483d = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f1482c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f1480a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public final long f1481b = SystemClock.elapsedRealtime();

    /* renamed from: g, reason: collision with root package name */
    public final HandlerC0555a f1486g = new HandlerC0555a(this, Looper.getMainLooper(), 2);

    public a(C0284f c0284f) {
        this.f1487h = c0284f;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        d.a("ActivityLifecycleCallback", "onActivityPaused, process:" + Process.myPid());
        this.f1483d = System.currentTimeMillis();
        this.f1485f = SystemClock.elapsedRealtime();
        HandlerC0555a handlerC0555a = this.f1486g;
        handlerC0555a.removeMessages(1);
        handlerC0555a.sendEmptyMessageDelayed(1, 1000L);
        C0284f c0284f = this.f1487h;
        if (c0284f.a().equals(this.f1488i)) {
            return;
        }
        c cVar = b.f1231a;
        cVar.f1239h.a(cVar.f1232a, "_startup_", null, null, 0);
        this.f1488i = c0284f.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        d.a("ActivityLifecycleCallback", "onActivityResumed, process:" + Process.myPid());
        long j4 = this.f1482c;
        C0284f c0284f = this.f1487h;
        if (j4 == 0) {
            c0284f.getClass();
            d.a("SessionController", "onForeground");
            ((Handler) c0284f.f3746c).removeCallbacksAndMessages(null);
            this.f1482c = System.currentTimeMillis();
            this.f1484e = SystemClock.elapsedRealtime();
        }
        this.f1486g.removeMessages(1);
        if (c0284f.a().equals(this.f1488i)) {
            return;
        }
        c cVar = b.f1231a;
        cVar.f1239h.a(cVar.f1232a, "_startup_", null, null, 0);
        this.f1488i = c0284f.a();
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
