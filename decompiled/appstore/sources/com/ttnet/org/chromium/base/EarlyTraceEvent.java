package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.SystemClock;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
@MainDex
public class EarlyTraceEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f18245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f18246b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f18247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List f18248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static List f18249e;

    public interface Natives {
        void recordEarlyAsyncBeginEvent(String r10, long r11, long r12);

        void recordEarlyAsyncEndEvent(String r10, long r11, long r12);

        void recordEarlyBeginEvent(String r10, long r11, int r12, long r13);

        void recordEarlyEndEvent(String r10, long r11, int r12, long r13);

        void recordEarlyToplevelBeginEvent(String r10, long r11, int r12, long r13);

        void recordEarlyToplevelEndEvent(String r10, long r11, int r12, long r13);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f18252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f18253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f18254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f18255f;

        public a(String r10, boolean r11, boolean r12) {
            this.f18250a = r11;
            this.f18251b = r12;
            this.f18252c = r10;
            this.f18253d = Process.myTid();
            this.f18254e = a();
            this.f18255f = SystemClock.currentThreadTimeMillis();
        }

        public static long a() {
            return SystemClock.elapsedRealtimeNanos();
        }
    }

    static {
        f18246b = new Object();
    }

    public static void a() {
        Object r10 = f18246b;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (d() == true) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L11:
        if (f18248d.isEmpty() == true) goto L14;
        c(f18248d);     // Catch: Throwable -> L8
        f18248d.clear();     // Catch: Throwable -> L8
    L14:
        if (f18249e.isEmpty() == true) goto L16;
        b(f18249e);     // Catch: Throwable -> L8
        f18249e.clear();     // Catch: Throwable -> L8
    L16:
        f18247c = 2;     // Catch: Throwable -> L8
        f18248d = null;     // Catch: Throwable -> L8
        f18249e = null;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    public static void b(List r10) {
        f();
        Iterator r11 = r10.iterator();
        if (r11.hasNext() == true) goto L5;
        return;
    L5:
        androidx.appcompat.widget.p.a(r11.next());
        throw null;
    }

    public static void c(List r19) {
        long r10 = f();
        Iterator r11 = r19.iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        a r12 = (a) r11.next();
        if (r12.f18250a == true) goto L8;
        if (r12.f18251b == true) goto L13;
        f.b().recordEarlyEndEvent(r12.f18252c, r12.f18254e + r10, r12.f18253d, r12.f18255f);
        goto L4
    L13:
        f.b().recordEarlyToplevelEndEvent(r12.f18252c, r12.f18254e + r10, r12.f18253d, r12.f18255f);
        goto L4
    L8:
        if (r12.f18251b == true) goto L9;
        f.b().recordEarlyBeginEvent(r12.f18252c, r12.f18254e + r10, r12.f18253d, r12.f18255f);
        goto L4
    L9:
        f.b().recordEarlyToplevelBeginEvent(r12.f18252c, r12.f18254e + r10, r12.f18253d, r12.f18255f);
        goto L4
    }

    public static boolean d() {
        if (f18247c == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void e(String r10, boolean r11) {
        if (d() == true) goto L5;
        return;
    L5:
        a r12 = new a(r10, false, r11);
        Object r13 = f18246b;
        monitor-enter(r13);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (d() == true) goto L13;
        monitor-exit(r13);     // Catch: Throwable -> L11
        return;
    L13:
        f18248d.add(r12);     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
    }

    public static long f() {
        return (q.b().getTimeTicksNowUs() * 1000) - a.a();
    }

    @CalledByNative
    public static boolean getBackgroundStartupTracingFlag() {
        return f18245a;
    }

    @CalledByNative
    public static void setBackgroundStartupTracingFlag(boolean r10) {
        e.c().edit().putBoolean("bg_startup_tracing", r10).apply();
    }
}
