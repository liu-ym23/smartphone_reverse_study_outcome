package com.stepos.agentbus.platform;

import android.app.Application;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import c7.r;
import g3.b;
import ia.d0;
import ia.f1;
import ia.n0;
import ia.x1;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import n7.m;
import na.d;
import pa.e;
import s1.u;
import u5.c;
import w7.e0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentbus/platform/AgentBusApp;", "Landroid/app/Application;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class AgentBusApp extends Application {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f2679h = 0;

    /* renamed from: f, reason: collision with root package name */
    public final d f2680f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f2681g;

    public AgentBusApp() {
        x1 x1VarC = d0.c();
        e eVar = n0.f4982a;
        this.f2680f = d0.b(f1.plus(x1VarC, pa.d.f8556h));
        this.f2681g = new AtomicBoolean(false);
    }

    public final void a() {
        Object objN;
        if (this.f2681g.compareAndSet(false, true)) {
            u uVar = AgentBusService.f2682m;
            AgentBusService.f2682m = new u(this);
            Log.i("AgentBusApp", "doFullInit pid=" + Process.myPid() + " → starting AgentBusService");
            try {
                m.H(this);
                objN = r.f1986a;
            } catch (Throwable th) {
                objN = e0.n(th);
            }
            Throwable thA = c7.m.a(objN);
            if (thA != null) {
                Log.e("AgentBusApp", "AgentBusService.start failed", thA);
            }
            d0.s(this.f2680f, null, null, new b(this, null, 5), 3);
        }
    }

    public final void b() {
        if (Settings.Secure.getInt(getContentResolver(), "user_setup_complete", 0) == 1) {
            a();
            return;
        }
        Log.i("AgentBusApp", "user setup not complete — deferring init, registering observer");
        ContentResolver contentResolver = getContentResolver();
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, new u5.b(new Handler(Looper.getMainLooper()), this, contentResolver));
        Log.i("AgentBusApp", "Registered user_setup_complete observer, waiting for setup complete");
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        if (userManager != null && userManager.isUserUnlocked()) {
            b();
            return;
        }
        Log.w("AgentBusApp", "onCreate before user unlock (CE unavailable) — deferring init");
        registerReceiver(new c(0, this), new IntentFilter("android.intent.action.USER_UNLOCKED"), null, new Handler(Looper.getMainLooper()));
    }
}
