package com.stepos.statsapp.v3.lib.plugin.session;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.stepos.statsapp.v3.lib.plugin.events.e;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;

/* loaded from: classes2.dex */
class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: k, reason: collision with root package name */
    private static final String f30938k = "ActivityLifecycleCallback";

    /* renamed from: i, reason: collision with root package name */
    private final c f30947i;

    /* renamed from: j, reason: collision with root package name */
    private String f30948j;

    /* renamed from: a, reason: collision with root package name */
    private final int f30939a = 1;

    /* renamed from: g, reason: collision with root package name */
    private long f30945g = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f30944f = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f30943e = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f30942d = 0;

    /* renamed from: b, reason: collision with root package name */
    private final long f30940b = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    private final long f30941c = SystemClock.elapsedRealtime();

    /* renamed from: h, reason: collision with root package name */
    private final Handler f30946h = new HandlerC0369a(Looper.getMainLooper());

    /* renamed from: com.stepos.statsapp.v3.lib.plugin.session.a$a, reason: collision with other inner class name */
    public class HandlerC0369a extends Handler {
        public HandlerC0369a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Logger.d(a.f30938k, "msg.what: ONCE_USE");
                if (a.this.f30942d == 0) {
                    a.this.f30947i.h();
                    a aVar = a.this;
                    aVar.f30942d = aVar.f30940b;
                    a aVar2 = a.this;
                    aVar2.f30944f = aVar2.f30941c;
                }
                a.this.f30947i.g();
                a.this.e();
                a aVar3 = a.this;
                aVar3.f30942d = aVar3.f30943e = aVar3.f30944f = aVar3.f30945g = 0L;
            }
        }
    }

    public a(c cVar) {
        this.f30947i = cVar;
    }

    private void f() {
        if (this.f30947i.b().equals(this.f30948j)) {
            return;
        }
        com.stepos.statsapp.v3.lib.plugin.sdk.a.c().d("_startup_", null);
        this.f30948j = this.f30947i.b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Logger.d(f30938k, "onActivityPaused, process:" + Process.myPid());
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Logger.d(f30938k, "onActivityResumed, process:" + Process.myPid());
        d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long j10 = this.f30943e - this.f30942d;
        long j11 = this.f30945g - this.f30944f;
        Logger.d(f30938k, "onOnceUse, startTime:" + this.f30942d + ", endTime:" + this.f30943e + ", duration:" + j10);
        if (this.f30942d <= 0 || this.f30943e <= 0 || j10 <= 0) {
            return;
        }
        HashMap map = new HashMap();
        map.put("startTime", String.valueOf(this.f30942d));
        map.put("endTime", String.valueOf(this.f30943e));
        map.put("duration", String.valueOf(j10));
        map.put(e.f30796j, String.valueOf(j11));
        com.stepos.statsapp.v3.lib.plugin.sdk.a.c().d("_onceuse_", map);
    }

    private void c() {
        this.f30943e = System.currentTimeMillis();
        this.f30945g = SystemClock.elapsedRealtime();
        this.f30946h.removeMessages(1);
        this.f30946h.sendEmptyMessageDelayed(1, 1000L);
        f();
    }

    private void d() {
        if (this.f30942d == 0) {
            this.f30947i.h();
            this.f30942d = System.currentTimeMillis();
            this.f30944f = SystemClock.elapsedRealtime();
        }
        this.f30946h.removeMessages(1);
        f();
    }

    public void a() {
        Logger.d(f30938k, "onAppWidgetPaused, process:" + Process.myPid());
        c();
    }

    public void b() {
        Logger.d(f30938k, "onWidgetResumed, process:" + Process.myPid());
        d();
    }
}
