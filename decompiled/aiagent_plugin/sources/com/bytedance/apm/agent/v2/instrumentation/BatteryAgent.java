package com.bytedance.apm.agent.v2.instrumentation;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BatteryAgent {
    private static boolean hasHook;
    private static final Map<String, a> sExecutedRecord = null;
    private static ThreadLocal<HashMap<String, b>> sExecutingRecord;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4148b;

        public a() {
            this.f4147a = 0;
            this.f4148b = 0;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f4148b;
        }

        public void a(b r7) {
            this.f4147a += b.a(r7);
            this.f4148b = (int) (((long) this.f4148b) + (b.b(r7) - b.c(r7)));
        }

        public String toString() {
            return "MethodExecutedValue{exeCount=" + this.f4147a + ", cpuCost=" + this.f4148b + '}';
        }

        public int a() {
            return this.f4147a;
        }

        public int b() {
            return this.f4148b;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4152d;

        public b() {
            this.f4149a = 0;
            this.f4150b = 0;
            this.f4151c = 0;
            this.f4152d = 0;
        }

        static /* synthetic */ int a(b r0) {
            return r0.f4152d;
        }

        static /* synthetic */ long b(b r2) {
            return r2.f4150b;
        }

        static /* synthetic */ long c(b r2) {
            return r2.f4149a;
        }

        public void a() {
            if (this.f4152d != 0) goto L5;
            this.f4149a = SystemClock.currentThreadTimeMillis();
        L5:
            this.f4151c++;
            this.f4152d++;
        }

        public boolean b() {
            int r0 = this.f4151c - 1;
            this.f4151c = r0;
            if (r0 != 0) goto L6;
            this.f4150b = SystemClock.currentThreadTimeMillis();
            return true;
        L6:
            return false;
        }
    }

    public BatteryAgent() {
    }

    static {
        sExecutedRecord = new HashMap();
        sExecutingRecord = new ThreadLocal();
        hasHook = false;
    }

    public static boolean hasHook() {
        return hasHook;
    }

    public static void s(String r4) {
        hasHook = true;
        HashMap<String, b> r0 = (HashMap) ZeusTransformUtils.preCheckCast(sExecutingRecord.get(), HashMap.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new HashMap();
        sExecutingRecord.set(r0);
    L5:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get(r4), b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        r1 = new b();
        r0.put(r4, r1);
    L8:
        r1.a();
    }

    public static void e(String r5) {
        HashMap r0 = (HashMap) ZeusTransformUtils.preCheckCast(sExecutingRecord.get(), HashMap.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get(r5), b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.b() == false) goto L21;
        r0.remove(r5);
        Map<String, a> r2 = sExecutedRecord;
        monitor-enter(r2);
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.get(r5), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r3 != null) goto L15;
        r3 = new a();     // Catch: Throwable -> L18
        r2.put(r5, r3);     // Catch: Throwable -> L18
    L15:
        r3.a(r1);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static Map<String, a> filterResultAndClear(long r7) {
        Map<String, a> r0 = sExecutedRecord;
        if (r0.isEmpty() == false) goto L6;
        return null;
    L6:
        monitor-enter(r0);
        HashMap r1 = new HashMap();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, a>> r2 = r0.entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r2.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (a.a((a) ZeusTransformUtils.preCheckCast(r3.getValue(), a.class, "com.obric.aiagent.plugin")) <= r7) goto L9;
        r1.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L16
        goto L9
    L13:
        sExecutedRecord.clear();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L16:
        th = move-exception;
        throw th;
    }
}
