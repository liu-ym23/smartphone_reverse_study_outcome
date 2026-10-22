package com.stepos.agentframework.chatcore.intent;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.sdk.client.AgentServiceClient;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003J\u001b\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010$\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lkotlin/Function0;", "block", "n", "(Lp9/a;)V", "", Const.INTENT_KEY_UMID, "()Z", "k", "e", "o", "", "TAG", "Ljava/lang/String;", "", "RELEASE_DEBOUNCE_MS", "J", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "stateLock", "Ljava/lang/Object;", "appContext", "Landroid/content/Context;", RobotInfo.STATUS_STARTED, "Z", x5.d.EXTRA_ENABLED, "getEnabled", "setEnabled", "(Z)V", "Ljava/lang/Runnable;", "releaseRunnable", "Ljava/lang/Runnable;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {
    private static final long RELEASE_DEBOUNCE_MS = 5000;
    private static final String TAG = "AgentSvcConnMgr";
    private static volatile Context appContext;
    private static volatile boolean started;
    public static final d INSTANCE = new d();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Object stateLock = new Object();
    private static volatile boolean enabled = true;
    private static final Runnable releaseRunnable = new Runnable() { // from class: com.stepos.agentframework.chatcore.intent.a
        @Override // java.lang.Runnable
        public final void run() {
            d.m();
        }
    };

    public static final Y8.t g(Context context, boolean z10) {
        Object objB;
        if (z10) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TaskDispatcher.INSTANCE.a().p(context);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(TAG, "onConnected re-register failed", thE, false, 8, null);
            }
            C4148a.k(TAG, "AgentService connected, listener re-registered", false, 4, null);
        } else {
            C4148a.u(TAG, "AgentService connect failed/disconnected", false, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final void l() {
        INSTANCE.k();
    }

    public static final void m() {
        INSTANCE.e();
    }

    public final boolean d() {
        if (enabled) {
            return TaskDispatcher.INSTANCE.a().m();
        }
        return true;
    }

    public final void e() {
        Object objB;
        synchronized (stateLock) {
            d dVar = INSTANCE;
            if (dVar.d()) {
                C4148a.k(TAG, "release aborted: bind still desired", false, 4, null);
                return;
            }
            C4148a.k(TAG, "release AgentService (idle)", false, 4, null);
            dVar.o();
            try {
                Result.Companion companion = Result.INSTANCE;
                AgentServiceClient.f22085a.c0();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(TAG, "release failed", thE, false, 8, null);
            }
        }
    }

    public final void f() {
        final Context context = appContext;
        if (context == null) {
            return;
        }
        mainHandler.removeCallbacks(releaseRunnable);
        synchronized (stateLock) {
            AgentServiceClient agentServiceClient = AgentServiceClient.f22085a;
            if (agentServiceClient.W()) {
                return;
            }
            C4148a.k(TAG, "ensureBound -> init & bind", false, 4, null);
            agentServiceClient.S(context, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.intent.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return d.g(context, ((Boolean) obj).booleanValue());
                }
            });
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void h() {
        Object objB;
        mainHandler.removeCallbacks(releaseRunnable);
        synchronized (stateLock) {
            C4148a.k(TAG, "forceRelease", false, 4, null);
            INSTANCE.o();
            try {
                Result.Companion companion = Result.INSTANCE;
                AgentServiceClient.f22085a.c0();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(TAG, "forceRelease failed", thE, false, 8, null);
            }
        }
    }

    public final void i(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (started) {
            C4148a.k(TAG, "init ignored: already started", false, 4, null);
            return;
        }
        appContext = context.getApplicationContext();
        started = true;
        C4148a.k(TAG, "init done, enabled=" + enabled + " (bind driven by active ability tasks only)", false, 4, null);
        k();
    }

    public final void j() {
        if (started) {
            k();
        }
    }

    public final void k() {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.stepos.agentframework.chatcore.intent.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.l();
                }
            });
            return;
        }
        Handler handler = mainHandler;
        Runnable runnable = releaseRunnable;
        handler.removeCallbacks(runnable);
        if (d()) {
            f();
        } else {
            C4148a.k(TAG, "idle, schedule release in 5000ms", false, 4, null);
            handler.postDelayed(runnable, 5000L);
        }
    }

    public final void n(InterfaceC5063a<Y8.t> block) {
        Object objB;
        kotlin.jvm.internal.p.i(block, "block");
        f();
        try {
            Result.Companion companion = Result.INSTANCE;
            block.invoke();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "runWithService failed: " + thE.getMessage(), false, 4, null);
        }
    }

    public final void o() {
        Object objB;
        Context context = appContext;
        if (context != null && AgentServiceClient.f22085a.W()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TaskDispatcher.INSTANCE.a().u(context);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "unregisterTaskListener failed before release: " + thE.getMessage(), false, 4, null);
            }
        }
    }
}
