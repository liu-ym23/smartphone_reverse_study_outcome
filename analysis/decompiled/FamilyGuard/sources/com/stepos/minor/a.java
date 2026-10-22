package com.stepos.minor;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import f2.C0702g;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static Handler f15379d;

    /* renamed from: e, reason: collision with root package name */
    private static Context f15380e;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f15376a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f15377b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static volatile long f15378c = 0;

    /* renamed from: f, reason: collision with root package name */
    private static int f15381f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static final Runnable f15382g = new Runnable() { // from class: F2.h
        @Override // java.lang.Runnable
        public final void run() {
            com.stepos.minor.a.g();
        }
    };

    /* renamed from: com.stepos.minor.a$a, reason: collision with other inner class name */
    class C0187a extends ContentObserver {
        C0187a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            a.f();
        }
    }

    public static void c(Context context) {
        if (f15376a.compareAndSet(false, true)) {
            f15380e = context.getApplicationContext();
            f15379d = new Handler(Looper.getMainLooper());
            f15380e.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("minors_mode_enabled"), false, new C0187a(f15379d));
            Log.i("MinorModeBroadcastObserver", "registered minors_mode_enabled observer");
        }
    }

    private static boolean d(long j5) {
        return j5 > 0 && j5 < 255;
    }

    static void e(int i5) {
        f15377b = i5;
        f15378c = SystemClock.elapsedRealtime();
        Handler handler = f15379d;
        if (handler != null) {
            handler.removeCallbacks(f15382g);
        }
        f15381f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        f15381f = 0;
        Handler handler = f15379d;
        Runnable runnable = f15382g;
        handler.removeCallbacks(runnable);
        f15379d.postDelayed(runnable, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        Context context = f15380e;
        if (context == null) {
            return;
        }
        int i5 = Settings.Secure.getInt(context.getContentResolver(), "minors_mode_enabled", 0);
        long j5 = Settings.Secure.getLong(f15380e.getContentResolver(), "active_minor_id", -1L);
        int i6 = Settings.Secure.getInt(f15380e.getContentResolver(), "minors_mode_age_range", 0);
        if (i5 == 1 && !d(j5)) {
            int i7 = f15381f;
            if (i7 < 5) {
                f15381f = i7 + 1;
                Log.i("MinorModeBroadcastObserver", "wait for active_minor_id, retry = " + f15381f + ", activeMinorId = " + j5);
                f15379d.postDelayed(f15382g, 200L);
                return;
            }
            Log.w("MinorModeBroadcastObserver", "active_minor_id still invalid after retries, activeMinorId = " + j5);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (i5 == f15377b && jElapsedRealtime - f15378c < 500) {
            Log.i("MinorModeBroadcastObserver", "skip duplicate broadcast, mode = " + i5);
            return;
        }
        Log.i("MinorModeBroadcastObserver", "minor mode ready, mode = " + i5 + ", activeMinorId = " + j5 + ", ageRange = " + i6);
        C0702g.y("MinorModeBroadcastObserver", "minor mode ready, mode = " + i5 + ", activeMinorId = " + j5 + ", ageRange = " + i6);
        MinorProvider.x(f15380e, i5);
    }
}
