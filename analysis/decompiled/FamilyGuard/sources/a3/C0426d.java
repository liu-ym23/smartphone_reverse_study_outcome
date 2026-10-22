package a3;

import Y2.f;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import b3.C0565c;
import g3.C0742e;
import java.util.UUID;

/* renamed from: a3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0426d {

    /* renamed from: a, reason: collision with root package name */
    private String f7271a;

    /* renamed from: b, reason: collision with root package name */
    private String f7272b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f7273c;

    /* renamed from: d, reason: collision with root package name */
    private C0423a f7274d;

    /* renamed from: e, reason: collision with root package name */
    private String f7275e;

    /* renamed from: a3.d$a */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0742e.c("SessionController", "session timeout");
            C0426d.this.b();
            C0742e.c("SessionController", "flush events when session end");
            C0565c c0565cQ = f.m().q();
            if (c0565cQ == null || c0565cQ.c() == null) {
                return;
            }
            c0565cQ.c().g();
        }
    }

    public C0426d(Application application) {
        HandlerThread handlerThread = new HandlerThread("com.stepos.statsapp.v3.SessionControllerWorker", 5);
        handlerThread.start();
        this.f7273c = new a(handlerThread.getLooper());
        d(application);
        C0742e.c("SessionController", "SessionController init");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f7271a != null) {
            synchronized (this) {
                C0742e.c("SessionController", "end a session id: " + this.f7271a);
                this.f7271a = null;
                this.f7272b = null;
                this.f7275e = null;
            }
        }
    }

    private void d(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f7274d;
        if (activityLifecycleCallbacks != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.f7274d = null;
        }
        C0423a c0423a = new C0423a(this);
        this.f7274d = c0423a;
        application.registerActivityLifecycleCallbacks(c0423a);
        C0742e.c("SessionController", "registerApplicationLifeCycle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        if (TextUtils.isEmpty(this.f7272b)) {
            this.f7272b = str;
            C0742e.c("SessionController", "set source: " + this.f7272b);
            if (this.f7271a == null) {
                return;
            }
            C0565c c0565cQ = f.m().q();
            if (c0565cQ == null) {
                this.f7275e = str;
            } else {
                this.f7275e = null;
                c0565cQ.f(this.f7271a, str);
            }
        }
    }

    public String f() {
        if (this.f7271a == null) {
            synchronized (this) {
                this.f7271a = UUID.randomUUID().toString();
                C0742e.c("SessionController", "generate a sessionId: " + this.f7271a);
            }
        }
        return this.f7271a;
    }

    public void g(final String str) {
        if (TextUtils.isEmpty(this.f7272b)) {
            this.f7273c.post(new Runnable() { // from class: a3.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7269a.e(str);
                }
            });
            return;
        }
        C0742e.c("SessionController", "source already exist: " + this.f7272b + ", session: " + this.f7271a + ", not set again");
    }

    public String h() {
        return this.f7272b;
    }

    public void i() {
        C0742e.c("SessionController", "onBackground");
        this.f7273c.removeCallbacksAndMessages(null);
        this.f7273c.sendEmptyMessageDelayed(1, 30000L);
    }

    public void j() {
        C0742e.c("SessionController", "onForeground");
        this.f7273c.removeCallbacksAndMessages(null);
    }

    public void k() {
        if (TextUtils.isEmpty(this.f7275e)) {
            return;
        }
        g(this.f7275e);
    }
}
