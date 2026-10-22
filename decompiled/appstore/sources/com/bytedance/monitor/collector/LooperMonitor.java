package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.block.ILooperObserver;
import com.bytedance.apm.block.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.LooperPrinterUtils;
import g1.d;
import g5.h;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class LooperMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f7806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Printer f7807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ILooperObserver f7808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList f7809d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static g5.a f7810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static g5.a f7811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile IReporter f7812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f7813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f7814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f7815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f7816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f7817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Printer f7818m;

    public interface IReporter {
        void reportCost(long r10);
    }

    public static class a implements Printer {
        public a() {
        }

        @Override // android.util.Printer
        public void println(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            if (r10.charAt(0) != '>') goto L12;
            if (h.f19950b == false) goto L10;
            i.e(r10);
            return;
        L10:
            LooperMonitor.d(true, r10, null);
            return;
        L12:
            if (r10.charAt(0) == '<') goto L14;
            return;
        L14:
            if (h.f19950b == false) goto L16;
            i.f(r10, null);
            return;
        L16:
            LooperMonitor.d(false, r10, null);
        }
    }

    public static class b implements ILooperObserver {
        public b() {
        }

        @Override // com.bytedance.apm.block.ILooperObserver
        public void messageDispatchStarting(String r10) {
            LooperMonitor.d(true, r10, null);
        }

        @Override // com.bytedance.apm.block.ILooperObserver
        public void messageDispatched(String r10, Message r11) {
            LooperMonitor.d(false, r10, r11);
        }
    }

    static {
        f7809d = new CopyOnWriteArrayList();
        f7813h = false;
        f7814i = 0;
        f7815j = 0;
    }

    public static void a() {
        if (f7806a == false) goto L21;
        if (f7816k == true) goto L21;
        if (f7811f != null) goto L21;
        if (b2.b.e("block_monitor") == true) goto L26;
        b();
        if (j() == true) goto L14;
        LooperPrinterUtils.g(f7807b);
    L18:
        f7816k = true;
        return;
    L14:
        if (c.B() == false) goto L16;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L16:
        i.i(f7808c);
        goto L18
    L26:
        return;
    L21:
        if (f7816k == true) goto L23;
        return;
    L23:
        if (f7817l == true) goto L28;
        b();
        return;
    }

    public static void b() {
        if (f7806a == true) goto L5;
        return;
    L5:
        if (f7817l == false) goto L7;
        return;
    L7:
        if (h.f19951c == true) goto L10;
        return;
    L10:
        if (j() == false) goto L18;
        List r10 = i.c();
        if (r10 == null) goto L28;
        if (r10.size() != 1) goto L28;
        if (r10.get(0) != f7808c) goto L28;
        i.j();
        f7817l = true;
    L28:
        if (c.B() == false) goto L33;
        Logger.i("LooperMonitor", "enable Looper Observer block.");
        return;
    L33:
        return;
    L18:
        List r11 = LooperPrinterUtils.e();
        if (r11 == null) goto L28;
        if (r11.size() != 1) goto L28;
        if (r11.get(0) != f7807b) goto L28;
        Printer r12 = f();
        f7818m = r12;
        if (r12 == null) goto L28;
        Looper.getMainLooper().setMessageLogging(null);
        f7817l = true;
        goto L28
    }

    public static void c() {
        if (f7806a == true) goto L5;
        return;
    L5:
        if (f7816k == false) goto L8;
        return;
    L8:
        if (d.A().E() == true) goto L10;
        return;
    L10:
        int r10 = d.A().B();
        if (f7809d.isEmpty() == false) goto L18;
        if (r10 == 0) goto L14;
        return;
    L14:
        if (f7811f != null) goto L20;
        a();
        return;
    L20:
        return;
    }

    public static void d(boolean r10, String r11, Message r12) {
        long r13 = System.nanoTime();
        g5.a.f19916b = r13 / BatteryFactorConfig.WIFI_BPS;
        g5.a.f19917c = SystemClock.currentThreadTimeMillis();
        if (r10 == false) goto L9;
        g5.a r14 = f7811f;
        if (r14 == null) goto L9;
        if (r14.d() == false) goto L9;
        f7811f.c(r11);
    L9:
        if (r10 == false) goto L57;
        g5.a r15 = f7810e;
        if (r15 == null) goto L57;
        if (r15.d() == false) goto L57;
        f7810e.c(r11);
    L57:
        CopyOnWriteArrayList r16 = f7809d;     // Catch: Exception -> L56
        int r17 = 0;
    L17:
        if (r17 >= r16.size()) goto L35;
        g5.a r18 = (g5.a) r16.get(r17);     // Catch: Exception -> L56
        if (r18 != null) goto L22;
    L30:
        if (r10 == true) goto L34;
        if (r18.f19918a == false) goto L34;
        r18.b("", null);     // Catch: Exception -> L56
    L34:
        r17 = r17 + 1;
        goto L17
    L22:
        if (r18.d() == false) goto L30;
        if (r10 == false) goto L28;
        if (r18.f19918a == true) goto L34;
        r18.c(r11);     // Catch: Exception -> L56
        goto L34
    L28:
        if (r18.f19918a == false) goto L34;
        r18.b(r11, r12);     // Catch: Exception -> L56
    L35:
        if (r10 == true) goto L41;
        g5.a r19 = f7810e;
        if (r19 == null) goto L41;
        if (r19.d() == false) goto L41;
        f7810e.b("", null);
    L41:
        if (r10 == true) goto L48;
        g5.a r20 = f7811f;
        if (r20 == null) goto L48;
        if (r20.d() == false) goto L48;
        f7811f.b("", null);
    L48:
        if (f7813h == false) goto L67;
        f7814i += System.nanoTime() - r13;
        int r21 = f7815j;
        f7815j = r21 + 1;
        if (r21 >= 1000) goto L52;
        return;
    L52:
        if (f7812g == null) goto L54;
        f7812g.reportCost(f7814i);
    L54:
        f7815j = 0;
        f7814i = 0;
        f7813h = false;
        return;
    }

    public static void e(boolean r10) {
        f7813h = r10;
    }

    public static Printer f() {
        Field r10 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r10.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static int g() {
        return f7809d.size();
    }

    public static void h() {
        if (h.f19949a == false) goto L6;
        return;
    L6:
        if (f7806a == false) goto L8;
        return;
    L8:
        f7806a = true;
        f7807b = new a();
        f7808c = new b();
        if (h.f19950b == true) goto L11;
    L19:
        i();
        return;
    L11:
        if (i.d(f7807b) == false) goto L19;
        if (c.B() == false) goto L16;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L16:
        if (i.f6402b == false) goto L18;
        i();
    L18:
        i.a(f7808c);
    }

    public static void i() {
        LooperPrinterUtils.f();
        LooperPrinterUtils.c(f7807b);
    }

    public static boolean j() {
        if (h.f19950b == true) goto L5;
    L9:
        return false;
    L5:
        if (i.d(f7807b) == false) goto L9;
        if (i.f6402b == true) goto L9;
        return true;
    }

    public static void k(g5.a r10) {
        CopyOnWriteArrayList r11 = f7809d;
        monitor-enter(r11);
        if (r10 != null) goto L16;
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L16:
        if (r11.contains(r10) == true) goto L12;
        r11.add(r10);     // Catch: Throwable -> L10
        if (d.A().E() == false) goto L12;
        n();     // Catch: Throwable -> L10
        goto L12
    }

    public static void l(g5.a r10) {
        f7810e = r10;
    }

    public static void m(IReporter r10) {
        f7812g = r10;
    }

    public static void n() {
        if (f7806a == true) goto L5;
        return;
    L5:
        if (f7816k == false) goto L17;
        o(false);
        if (j() == true) goto L10;
        i();
    L14:
        f7816k = false;
        return;
    L10:
        if (c.B() == false) goto L12;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L12:
        i.a(f7808c);
        goto L14
    }

    public static void o(boolean r10) {
        if (f7806a == true) goto L5;
        return;
    L5:
        if (f7817l == true) goto L7;
        return;
    L7:
        if (h.f19951c == true) goto L10;
        return;
    L10:
        if (j() == false) goto L14;
        if (r10 == false) goto L14;
        return;
    L14:
        if (j() == false) goto L17;
        i.b();
    L20:
        if (c.B() == false) goto L22;
        Logger.i("LooperMonitor", "enable Looper Observer unblock.");
    L22:
        f7817l = false;
        return;
    L17:
        if (f7818m == null) goto L20;
        Looper.getMainLooper().setMessageLogging(f7818m);
        goto L20
    }

    public static void p(g5.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList r11 = f7809d;
        monitor-enter(r11);
        r11.remove(r10);     // Catch: Throwable -> L15
        if (d.A().E() == true) goto L9;
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L9:
        if (r11.isEmpty() == false) goto L17;
        if (d.A().B() != 0) goto L17;
        if (f7811f != null) goto L17;
        a();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
