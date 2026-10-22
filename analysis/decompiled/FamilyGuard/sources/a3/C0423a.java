package a3;

import Y2.f;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import g3.C0742e;
import java.util.HashMap;

/* renamed from: a3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0423a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: i, reason: collision with root package name */
    private final C0426d f7263i;

    /* renamed from: j, reason: collision with root package name */
    private String f7264j;

    /* renamed from: a, reason: collision with root package name */
    private final int f7255a = 1;

    /* renamed from: g, reason: collision with root package name */
    private long f7261g = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f7260f = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f7259e = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f7258d = 0;

    /* renamed from: b, reason: collision with root package name */
    private final long f7256b = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    private final long f7257c = SystemClock.elapsedRealtime();

    /* renamed from: h, reason: collision with root package name */
    private final Handler f7262h = new HandlerC0098a(Looper.getMainLooper());

    /* renamed from: a3.a$a, reason: collision with other inner class name */
    class HandlerC0098a extends Handler {
        HandlerC0098a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                C0742e.c("ActivityLifecycleCallback", "msg.what: ONCE_USE");
                if (C0423a.this.f7258d == 0) {
                    C0423a.this.f7263i.j();
                    C0423a c0423a = C0423a.this;
                    c0423a.f7258d = c0423a.f7256b;
                    C0423a c0423a2 = C0423a.this;
                    c0423a2.f7260f = c0423a2.f7257c;
                }
                C0423a.this.f7263i.i();
                C0423a.this.k();
                C0423a c0423a3 = C0423a.this;
                c0423a3.f7258d = c0423a3.f7259e = c0423a3.f7260f = c0423a3.f7261g = 0L;
            }
        }
    }

    C0423a(C0426d c0426d) {
        this.f7263i = c0426d;
    }

    private void g() {
        this.f7259e = System.currentTimeMillis();
        this.f7261g = SystemClock.elapsedRealtime();
        this.f7262h.removeMessages(1);
        this.f7262h.sendEmptyMessageDelayed(1, 1000L);
        m();
    }

    private void j() {
        if (this.f7258d == 0) {
            this.f7263i.j();
            this.f7258d = System.currentTimeMillis();
            this.f7260f = SystemClock.elapsedRealtime();
        }
        this.f7262h.removeMessages(1);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        long j5 = this.f7259e - this.f7258d;
        long j6 = this.f7261g - this.f7260f;
        C0742e.c("ActivityLifecycleCallback", "onOnceUse, startTime:" + this.f7258d + ", endTime:" + this.f7259e + ", duration:" + j5);
        if (this.f7258d <= 0 || this.f7259e <= 0 || j5 <= 0) {
            return;
        }
        HashMap map = new HashMap();
        map.put("startTime", String.valueOf(this.f7258d));
        map.put("endTime", String.valueOf(this.f7259e));
        map.put("duration", String.valueOf(j5));
        map.put("duration2", String.valueOf(j6));
        f.m().o("_onceuse_", map);
    }

    private void m() {
        if (this.f7263i.f().equals(this.f7264j)) {
            return;
        }
        f.m().o("_startup_", null);
        this.f7264j = this.f7263i.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        C0742e.c("ActivityLifecycleCallback", "onActivityPaused, process:" + Process.myPid());
        g();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C0742e.c("ActivityLifecycleCallback", "onActivityResumed, process:" + Process.myPid());
        j();
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
}
