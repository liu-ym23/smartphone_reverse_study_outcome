package com.bytedance.monitor.collector;

import android.util.Log;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BinderMonitor extends b {
    private static final List<a> f = null;
    private static final Object g = null;
    private static volatile int h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f8920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f8922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        StackTraceElement[] f8923d;

        public a() {
        }

        public long a() {
            return this.f8920a;
        }

        public long b() {
            return this.f8921b;
        }

        public StackTraceElement[] c() {
            return this.f8923d;
        }

        public String toString() {
            return "{\"start\":" + this.f8920a + ",\"end\":" + this.f8921b + ",\"parcel_size\":" + this.f8922c + ",\"cost_millis\":" + (this.f8921b - this.f8920a) + ",\"java_stack\":\"" + o.b(BinderMonitor.a(this.f8923d)) + "\"}";
        }
    }

    @Override // com.bytedance.monitor.collector.b
    public void b(int r1) {
    }

    static /* synthetic */ StackTraceElement[] a(StackTraceElement[] r0) {
        return b(r0);
    }

    static {
        f = new ArrayList(200);
        g = new Object();
        h = 0;
    }

    BinderMonitor(int r2) {
        super(r2, "binder_monitor");
    }

    void d() {
        MonitorJni.enableBinderHook();
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> c() {
        return new Pair(this.f8950a, f.toString());
    L4:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public Pair<String, String> a(long r3, long r5) {
        return new Pair(this.f8950a, b(r3, r5));
    L4:
        return null;
    }

    private String b(long r6, long r8) {
        List<a> r5 = e();
        ArrayList r0 = new ArrayList();
        int r1 = r5.size() - 1;
    L3:
        if (r1 < 0) goto L14;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r5.get(r1), a.class, "com.obric.aiagent.plugin");
        if (r2.f8920a <= r8) goto L7;
    L8:
        r0.add(r2);
    L10:
        if (r2.f8921b < r6) goto L14;
        r1 = r1 - 1;
        goto L3
    L7:
        if (r2.f8921b <= r6) goto L10;
    L14:
        return r0.toString();
    }

    public List<a> e() {
        ArrayList r6 = new ArrayList();
        Object r0 = g;
        monitor-enter(r0);
        int r1 = 0;
    L6:
        if (r1 >= 200) goto L10;
        int r3 = ((h - 1) + r1) % 200;     // Catch: Throwable -> L12
        List<a> r4 = f;     // Catch: Throwable -> L12
        if (r3 >= r4.size()) goto L10;
        r6.add(r4.get(((h - 1) + r1) % 200));     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    }

    public static void saveBinderInfo(long r8, long r10, long r12) {
        a(r8, r10, r12, Thread.currentThread().getStackTrace());
    }

    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    private static void a(long r4, long r6, long r8, StackTraceElement[] r10) {
        Object r0 = g;
        monitor-enter(r0);
        List<a> r1 = f;     // Catch: Throwable -> L11
        if (r1.size() != 200) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.get(h % 200), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r2.f8920a = r4;     // Catch: Throwable -> L11
        r2.f8921b = r6;     // Catch: Throwable -> L11
        r2.f8922c = r8;     // Catch: Throwable -> L11
        r2.f8923d = r10;     // Catch: Throwable -> L11
    L8:
        h++;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        a r3 = new a();     // Catch: Throwable -> L11
        r3.f8920a = r4;     // Catch: Throwable -> L11
        r3.f8921b = r6;     // Catch: Throwable -> L11
        r3.f8922c = r8;     // Catch: Throwable -> L11
        r3.f8923d = r10;     // Catch: Throwable -> L11
        r1.add(r3);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static StackTraceElement[] b(StackTraceElement[] r4) {
        if (r4 != null) goto L4;
        return r4;
    L4:
        if (r4.length == 0) goto L21;
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r1 >= r4.length) goto L13;
        if ("saveBinderInfo".equals(r4[r1].getMethodName()) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        r0 = r1;
    L13:
        int r2 = r0 + 1;
        if (r2 <= r4.length) goto L16;
        return r4;
    L16:
        return (StackTraceElement[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r4, r2, r4.length), StackTraceElement[].class, "com.obric.aiagent.plugin");
    L21:
        return r4;
    }
}
