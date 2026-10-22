package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import g5.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BinderMonitor extends AbsMonitor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f7712f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f7713g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f7714h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public StackTraceElement[] f7718d;

        public a() {
        }

        public long a() {
            return this.f7715a;
        }

        public StackTraceElement[] b() {
            return this.f7718d;
        }

        public long c() {
            return this.f7716b;
        }

        public String toString() {
            return "{\"start\":" + this.f7715a + ",\"end\":" + this.f7716b + ",\"parcel_size\":" + this.f7717c + ",\"cost_millis\":" + (this.f7716b - this.f7715a) + ",\"java_stack\":\"" + h.d(BinderMonitor.g(this.f7718d)) + "\"}";
        }
    }

    static {
        f7712f = new ArrayList(200);
        f7713g = new Object();
        f7714h = 0;
    }

    public BinderMonitor(int r10) {
        super(r10, MonitorType.BINDER_MONITOR);
    }

    public static /* synthetic */ StackTraceElement[] g(StackTraceElement[] r10) {
        return l(r10);
    }

    @Keep
    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    public static void h(long r10, long r11, long r12, StackTraceElement[] r13) {
        Object r14 = f7713g;
        monitor-enter(r14);
        List r15 = f7712f;     // Catch: Throwable -> L7
        if (r15.size() != 200) goto L9;
        a r16 = (a) r15.get(f7714h % 200);     // Catch: Throwable -> L7
        r16.f7715a = r10;     // Catch: Throwable -> L7
        r16.f7716b = r11;     // Catch: Throwable -> L7
        r16.f7717c = r12;     // Catch: Throwable -> L7
        r16.f7718d = r13;     // Catch: Throwable -> L7
    L10:
        f7714h++;     // Catch: Throwable -> L7
        monitor-exit(r14);     // Catch: Throwable -> L7
        return;
    L9:
        a r17 = new a();     // Catch: Throwable -> L7
        r17.f7715a = r10;     // Catch: Throwable -> L7
        r17.f7716b = r11;     // Catch: Throwable -> L7
        r17.f7717c = r12;     // Catch: Throwable -> L7
        r17.f7718d = r13;     // Catch: Throwable -> L7
        r15.add(r17);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static StackTraceElement[] l(StackTraceElement[] r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.length == 0) goto L21;
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L13;
        if ("saveBinderInfo".equals(r10[r12].getMethodName()) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        r11 = r12;
    L13:
        int r13 = r11 + 1;
        if (r13 <= r10.length) goto L16;
        return r10;
    L16:
        return (StackTraceElement[]) Arrays.copyOfRange(r10, r13, r10.length);
    L21:
        return r10;
    }

    @Keep
    public static void saveBinderInfo(long r10, long r11, long r12) {
        h(r10, r11, r12, Thread.currentThread().getStackTrace());
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair a() {
        return new Pair(this.f7705a, f7712f.toString());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair b(long r10, long r11) {
        return new Pair(this.f7705a, i(r10, r11));
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void f(int r10) {
    }

    public final String i(long r10, long r11) {
        List r12 = k();
        ArrayList r13 = new ArrayList();
        int r14 = r12.size() - 1;
    L3:
        if (r14 < 0) goto L14;
        a r15 = (a) r12.get(r14);
        if (r15.f7715a <= r11) goto L7;
    L8:
        r13.add(r15);
    L10:
        if (r15.f7716b < r10) goto L14;
        r14 = r14 - 1;
        goto L3
    L7:
        if (r15.f7716b <= r10) goto L10;
    L14:
        return r13.toString();
    }

    public void j() {
        MonitorJni.enableBinderHook();
    }

    public List k() {
        ArrayList r10 = new ArrayList();
        Object r11 = f7713g;
        monitor-enter(r11);
        int r12 = 0;
    L6:
        if (r12 >= 200) goto L12;
        int r13 = ((f7714h - 1) + r12) % 200;     // Catch: Throwable -> L10
        List r14 = f7712f;     // Catch: Throwable -> L10
        if (r13 >= r14.size()) goto L12;
        r10.add(r14.get(((f7714h - 1) + r12) % 200));     // Catch: Throwable -> L10
        r12 = r12 + 1;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r10;
    }
}
