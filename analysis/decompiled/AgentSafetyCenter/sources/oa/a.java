package oa;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import com.stepos.statsrpk.e;
import ma.d;
import p5.m;
import ua.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public long f9343a;

    /* renamed from: b, reason: collision with root package name */
    public long f9344b;

    /* renamed from: c, reason: collision with root package name */
    public long f9345c;

    /* renamed from: d, reason: collision with root package name */
    public long f9346d;

    /* renamed from: e, reason: collision with root package name */
    public long f9347e;

    /* renamed from: f, reason: collision with root package name */
    public long f9348f;

    /* renamed from: g, reason: collision with root package name */
    public e f9349g;

    /* renamed from: h, reason: collision with root package name */
    public m f9350h;
    public String i;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c.a("ActivityLifecycleCallback", "onActivityPaused, process:" + Process.myPid());
        this.f9346d = System.currentTimeMillis();
        this.f9348f = SystemClock.elapsedRealtime();
        e eVar = this.f9349g;
        eVar.removeMessages(1);
        eVar.sendEmptyMessageDelayed(1, 1000L);
        m mVar = this.f9350h;
        if (mVar.q().equals(this.i)) {
            return;
        }
        ma.e eVar2 = d.f8538a;
        eVar2.f8545g.a(eVar2.f8539a, "_startup_", null, null, 0);
        this.i = mVar.q();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        m mVar = this.f9350h;
        c.a("ActivityLifecycleCallback", "onActivityResumed, process:" + Process.myPid());
        if (this.f9345c == 0) {
            c.a("SessionController", "onForeground");
            ((e) mVar.f9742g).removeCallbacksAndMessages(null);
            this.f9345c = System.currentTimeMillis();
            this.f9347e = SystemClock.elapsedRealtime();
        }
        this.f9349g.removeMessages(1);
        if (mVar.q().equals(this.i)) {
            return;
        }
        ma.e eVar = d.f8538a;
        eVar.f8545g.a(eVar.f8539a, "_startup_", null, null, 0);
        this.i = mVar.q();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
