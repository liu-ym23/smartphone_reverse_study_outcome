package com.stepos.ailauncher.chat.lowpower;

import Ua.C1060i;
import Ua.M;
import Ua.Y;
import Y8.t;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.lockscreen.H;
import com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker;
import com.stepos.ailauncher.chat.wake.DialogC3116e0;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.ailauncher.container.m0;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004*\u0001%\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowMonitor;", "", "<init>", "()V", "Landroid/app/Application;", "app", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/app/Application;)V", "Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", "f", "()Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;", "", "e", "()Z", "stat", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowChecker$a;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "TAG", "Ljava/lang/String;", "", "KILL_DELAY_MS", "J", "Landroid/net/Uri;", "URI", "Landroid/net/Uri;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "LUa/M;", "scope", "LUa/M;", "lastRestricted", "Z", RobotInfo.STATUS_STARTED, "com/stepos/ailauncher/chat/lowpower/TempPowerLowMonitor$a", "observer", "Lcom/stepos/ailauncher/chat/lowpower/TempPowerLowMonitor$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TempPowerLowMonitor {
    public static final TempPowerLowMonitor INSTANCE = new TempPowerLowMonitor();
    private static final long KILL_DELAY_MS = 2000;
    private static final String TAG = "TempPowerLowMonitor";
    private static final Uri URI;
    private static volatile boolean lastRestricted;
    private static final Handler mainHandler;
    private static final a observer;
    private static final M scope;
    private static volatile boolean started;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/lowpower/TempPowerLowMonitor$a", "Landroid/database/ContentObserver;", "", "selfChange", "LY8/t;", "onChange", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            TempPowerLowMonitor tempPowerLowMonitor = TempPowerLowMonitor.INSTANCE;
            tempPowerLowMonitor.d(tempPowerLowMonitor.f());
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/chat/lowpower/TempPowerLowMonitor$b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "LY8/t;", "onActivityResumed", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            p.i(activity, "activity");
            TempPowerLowChecker tempPowerLowChecker = TempPowerLowChecker.INSTANCE;
            if (tempPowerLowChecker.f()) {
                C4148a.k(TempPowerLowMonitor.TAG, "activity resumed while restricted -> show dialog", false, 4, null);
                d.INSTANCE.f(tempPowerLowChecker.c());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            p.i(activity, "activity");
            p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p.i(activity, "activity");
        }
    }

    static {
        Uri uriFor = Settings.System.getUriFor(TempPowerLowChecker.KEY);
        p.h(uriFor, "getUriFor(...)");
        URI = uriFor;
        Handler handler = new Handler(Looper.getMainLooper());
        mainHandler = handler;
        scope = kotlinx.coroutines.d.a(Y.c().getImmediate());
        observer = new a(handler);
    }

    public static final void h() {
        e.INSTANCE.b();
    }

    public final void d(TempPowerLowChecker.Stat stat) {
        TempPowerLowChecker tempPowerLowChecker = TempPowerLowChecker.INSTANCE;
        tempPowerLowChecker.i(stat);
        boolean zE = tempPowerLowChecker.e(stat);
        boolean z10 = !lastRestricted && zE;
        lastRestricted = zE;
        C4148a.d(TAG, "onChange: stat=" + stat + " restricted=" + zE + " rising=" + z10, false, 4, null);
        if (z10) {
            if (!e()) {
                C4148a.k(TAG, "rising but app not visible, defer to resume/overlay/wake fallback", false, 4, null);
            } else if (DialogC3116e0.INSTANCE.a()) {
                g(stat);
            } else {
                d.INSTANCE.f(stat);
            }
        }
    }

    public final boolean e() {
        return C3202f.INSTANCE.e() || m0.INSTANCE.h() || DialogC3116e0.INSTANCE.a();
    }

    public final TempPowerLowChecker.Stat f() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Settings.System.getString(C3197a.INSTANCE.a().getContentResolver(), TempPowerLowChecker.KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "read stat failed, treat as no signal", thE, false, 8, null);
            objB = null;
        }
        return TempPowerLowChecker.INSTANCE.h((String) objB);
    }

    public final void g(TempPowerLowChecker.Stat stat) {
        C4148a.k(TAG, "rising while wake dialog showing -> toast + kill process", false, 4, null);
        Application applicationA = C3197a.INSTANCE.a();
        String string = applicationA.getString(TempPowerLowChecker.INSTANCE.j(stat));
        p.h(string, "getString(...)");
        Object systemService = applicationA.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            Toast.makeText(applicationA, string, 0).show();
        } else {
            H.f(H.INSTANCE, applicationA, string, 0L, 4, null);
        }
        mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.lowpower.f
            @Override // java.lang.Runnable
            public final void run() {
                TempPowerLowMonitor.h();
            }
        }, 2000L);
    }

    public final void i(Application app) {
        Object objB;
        p.i(app, "app");
        if (started) {
            return;
        }
        started = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            app.getContentResolver().registerContentObserver(URI, false, observer);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "registerContentObserver failed", thE, false, 8, null);
        }
        TempPowerLowChecker.Stat statF = f();
        TempPowerLowChecker tempPowerLowChecker = TempPowerLowChecker.INSTANCE;
        tempPowerLowChecker.i(statF);
        lastRestricted = tempPowerLowChecker.e(statF);
        C4148a.k(TAG, "start: initial stat=" + statF + " restricted=" + lastRestricted, false, 4, null);
        C1060i.d(scope, null, null, new TempPowerLowMonitor$start$3(null), 3, null);
        app.registerActivityLifecycleCallbacks(new b());
    }
}
