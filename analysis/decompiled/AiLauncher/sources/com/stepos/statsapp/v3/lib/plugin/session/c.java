package com.stepos.statsapp.v3.lib.plugin.session;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.UUID;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static final String f30958f = "SessionController";

    /* renamed from: g, reason: collision with root package name */
    private static final int f30959g = 30000;

    /* renamed from: h, reason: collision with root package name */
    private static final int f30960h = 1;

    /* renamed from: i, reason: collision with root package name */
    private static final String f30961i = "com.stepos.statsapp.v3.SessionControllerWorker";

    /* renamed from: a, reason: collision with root package name */
    private String f30962a;

    /* renamed from: b, reason: collision with root package name */
    private String f30963b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f30964c;

    /* renamed from: d, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.session.a f30965d;

    /* renamed from: e, reason: collision with root package name */
    private String f30966e;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Logger.d(c.f30958f, "session timeout");
            c.this.a();
            Logger.d(c.f30958f, "flush events when session end");
            com.stepos.statsapp.v3.lib.plugin.tracker.b bVarH = com.stepos.statsapp.v3.lib.plugin.sdk.a.c().h();
            if (bVarH == null || bVarH.a() == null) {
                return;
            }
            bVarH.a().flush();
        }
    }

    public c(Application application) {
        HandlerThread handlerThread = new HandlerThread(f30961i, 5);
        handlerThread.start();
        this.f30964c = new a(handlerThread.getLooper());
        a(application);
        Logger.d(f30958f, "SessionController init");
    }

    public String b() {
        if (this.f30962a == null) {
            synchronized (this) {
                this.f30962a = UUID.randomUUID().toString();
                Logger.d(f30958f, "generate a sessionId: " + this.f30962a);
            }
        }
        return this.f30962a;
    }

    public String c() {
        return this.f30962a;
    }

    public String d() {
        return this.f30963b;
    }

    public void e() {
        com.stepos.statsapp.v3.lib.plugin.session.a aVar = this.f30965d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void f() {
        com.stepos.statsapp.v3.lib.plugin.session.a aVar = this.f30965d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g() {
        Logger.d(f30958f, "onBackground");
        this.f30964c.removeCallbacksAndMessages(null);
        this.f30964c.sendEmptyMessageDelayed(1, 30000L);
    }

    public void h() {
        Logger.d(f30958f, "onForeground");
        this.f30964c.removeCallbacksAndMessages(null);
    }

    public void i() {
        if (TextUtils.isEmpty(this.f30966e)) {
            return;
        }
        b(this.f30966e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f30962a != null) {
            synchronized (this) {
                Logger.d(f30958f, "end a session id: " + this.f30962a);
                this.f30962a = null;
                this.f30963b = null;
                this.f30966e = null;
            }
        }
    }

    public void b(final String str) {
        if (!TextUtils.isEmpty(this.f30963b)) {
            Logger.d(f30958f, "source already exist: " + this.f30963b + ", session: " + this.f30962a + ", not set again");
            return;
        }
        this.f30964c.post(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.session.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f30968a.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(this.f30963b)) {
            this.f30963b = str;
            Logger.d(f30958f, "set source: " + this.f30963b);
            if (this.f30962a == null) {
                return;
            }
            com.stepos.statsapp.v3.lib.plugin.tracker.b bVarH = com.stepos.statsapp.v3.lib.plugin.sdk.a.c().h();
            if (bVarH != null) {
                this.f30966e = null;
                bVarH.a(this.f30962a, str);
            } else {
                this.f30966e = str;
            }
        }
    }

    private void a(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f30965d;
        if (activityLifecycleCallbacks != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.f30965d = null;
        }
        com.stepos.statsapp.v3.lib.plugin.session.a aVar = new com.stepos.statsapp.v3.lib.plugin.session.a(this);
        this.f30965d = aVar;
        application.registerActivityLifecycleCallbacks(aVar);
        Logger.d(f30958f, "registerApplicationLifeCycle");
    }
}
