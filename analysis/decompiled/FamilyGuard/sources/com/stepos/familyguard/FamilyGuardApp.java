package com.stepos.familyguard;

import B2.e;
import C2.k;
import D2.j;
import Y1.r;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemManager;
import android.provider.Settings;
import android.util.Log;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.FamilyGuardApp;
import com.stepos.minor.MinorProvider;
import f2.C0698c;
import f2.C0702g;
import f2.C0718w;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import m2.C0863f;
import p2.g;
import w2.C1245p0;

/* loaded from: classes.dex */
public class FamilyGuardApp extends Application implements ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f14721a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f14722b = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: g2.b
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return FamilyGuardApp.d(runnable);
        }
    });

    class a implements C0702g.a {
        a() {
        }

        @Override // f2.C0702g.a
        public boolean a(String str, int i5) {
            return Log.isLoggable(str, i5);
        }
    }

    class b extends ContentObserver {
        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            R1.a.e("FamilyGuardApp", "minors_mode_enabled changed, schedule async sync");
            FamilyGuardApp.this.n();
        }
    }

    class c extends ContentObserver {
        c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            super.onChange(z5);
            C0702g.b("FamilyGuardApp", "icon radius onChange: selfChange = " + z5);
            j.a().b().a();
            j.a().c().a();
        }
    }

    public static /* synthetic */ Thread d(Runnable runnable) {
        Thread thread = new Thread(runnable, "MinorModeProtection");
        thread.setPriority(5);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        boolean zH = MinorProvider.h(this);
        R1.a.e("FamilyGuardApp", "syncMinorModeProtectionAsync enabled = " + zH);
        C2.j.b(this, zH);
        if (zH) {
            long jB = MinorProvider.b(this);
            if (jB > 0) {
                C1245p0.f().g(jB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (g.x(this)) {
            C0718w.g().h();
            C0698c.c(this);
            DigitalWellbeingService.Q(this);
            i();
            e.c();
            B2.c.a();
        }
    }

    private void i() {
        AppWidgetManagerService.y(this);
    }

    private void j() {
        getContentResolver().registerContentObserver(Settings.System.getUriFor("current_launcher_icon_corner_size"), false, new c(new Handler()));
    }

    private void k() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(new F2.c(), intentFilter, 4);
    }

    private void l() {
        getContentResolver().registerContentObserver(Settings.Secure.getUriFor("minors_mode_enabled"), false, new b(new Handler(Looper.getMainLooper())));
    }

    private static void m() {
        System.setProperty("rx2.purge-period-seconds", "3600");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f14722b.execute(new Runnable() { // from class: g2.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f17229a.g();
            }
        });
    }

    public void f() {
        R1.a.e("FamilyGuardApp", "initAfterCTA");
        n();
        l();
        if (!this.f14721a) {
            Thread thread = new Thread(new Runnable() { // from class: g2.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17228a.h();
                }
            });
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: g2.d
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread2, Throwable th) {
                    R1.a.d("FamilyGuardApp", th);
                }
            });
            thread.setPriority(1);
            thread.start();
        }
        if (!this.f14721a) {
            if (g.x(this)) {
                i();
            }
            this.f14721a = true;
            j();
        }
        I2.c.l(this);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0702g.b("FamilyGuardApp", "onConfigurationChanged: newConfig = " + configuration);
        F2.j.j(this).m(configuration);
        I2.c.l(this);
    }

    @Override // android.app.Application
    public void onCreate() throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException, InvocationTargetException {
        C0702g.L(new a());
        R1.a.j(R1.c.c(this).a().c());
        R1.a.e("FamilyGuardApp", "onCreate start");
        Log.e("AIOSBUG-4839-fix-v3", "FamilyGuardApp onCreate AIOSBUG-4839-fix-v3");
        m();
        Log.i("steposInfo", " 07c05c0");
        super.onCreate();
        P1.a.c(this);
        C0863f.f(this);
        k.c(this);
        F2.j.j(this);
        if (T1.b.h()) {
            R1.a.e("FamilyGuardApp", "Monkey return");
            return;
        }
        g.t(this);
        if (Settings.Global.getInt(getContentResolver(), "device_provisioned", 0) == 0) {
            Log.w("FamilyGuardApp", "FamilyGuardApp in DEVICE_PROVISIONED");
            T1.b.k();
            return;
        }
        SystemManager.addPowerSaveWhitelistApp(getPackageName());
        r.c().d();
        k();
        g.F();
        if (g.x(this)) {
            com.stepos.digitalwellbeing.appwidget.b.d(this);
        } else {
            com.stepos.digitalwellbeing.appwidget.b.u(this);
        }
        try {
            if (!g.x(this)) {
                R1.a.e("FamilyGuardApp", "not pass cta return");
            } else {
                f();
                R1.a.e("yjie", "digitial health receiver finished");
            }
        } catch (Exception e6) {
            Log.d("FamilyGuardApp", "onCreate e = " + e6);
            e6.printStackTrace();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        j.a().d();
        PackageUtils.h(this).y();
        R1.a.e("FamilyGuardApp", "onLowMemory");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        if (i5 >= 20) {
            j.a().e(i5);
            PackageUtils.h(this).y();
        }
        R1.a.e("FamilyGuardApp", "onTrimMemory level = " + i5);
    }
}
