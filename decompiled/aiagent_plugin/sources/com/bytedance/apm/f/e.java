package com.bytedance.apm.f;

import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.util.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: LaunchPerfDataFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: LaunchPerfDataFetcher.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f4636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private double f4638e;
        private long f;
        private long g;
        private double h;
        private double i;
        private double j;
        private long k;
        private long l;
        private long m;
        private long n;
        private long o;
        private List<String> p;
        private long q;
        private long r;
        private List<v> s;

        public a() {
            this.f4634a = -1;
            this.f4635b = -1;
            this.f4636c = -1;
            this.f4637d = -1;
            this.f4638e = -1.0d;
            this.f = -1;
            this.g = -1;
            this.h = -1.0d;
            this.i = -1.0d;
            this.j = -1.0d;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = null;
            this.q = -1;
            this.r = -1;
        }

        static /* synthetic */ double a(a r0, double r1) {
            r0.h = r1;
            return r1;
        }

        static /* synthetic */ long a(a r2) {
            return r2.r;
        }

        static /* synthetic */ long a(a r0, long r1) {
            r0.f = r1;
            return r1;
        }

        static /* synthetic */ List a(a r2, List r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            r2.p = r4;
            return r4;
        }

        static /* synthetic */ double b(a r0, double r1) {
            r0.i = r1;
            return r1;
        }

        static /* synthetic */ long b(a r2) {
            return r2.q;
        }

        static /* synthetic */ long b(a r0, long r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ List b(a r2, List r3) {
            List<v> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            r2.s = r4;
            return r4;
        }

        static /* synthetic */ double c(a r0, double r1) {
            r0.j = r1;
            return r1;
        }

        static /* synthetic */ long c(a r0, long r1) {
            r0.m = r1;
            return r1;
        }

        static /* synthetic */ double d(a r0, double r1) {
            r0.f4638e = r1;
            return r1;
        }

        static /* synthetic */ long d(a r0, long r1) {
            r0.n = r1;
            return r1;
        }

        static /* synthetic */ long e(a r0, long r1) {
            r0.f4634a = r1;
            return r1;
        }

        static /* synthetic */ long f(a r0, long r1) {
            r0.f4635b = r1;
            return r1;
        }

        static /* synthetic */ long g(a r0, long r1) {
            r0.f4636c = r1;
            return r1;
        }

        static /* synthetic */ long h(a r0, long r1) {
            r0.f4637d = r1;
            return r1;
        }

        static /* synthetic */ long i(a r0, long r1) {
            r0.o = r1;
            return r1;
        }

        static /* synthetic */ long j(a r0, long r1) {
            r0.q = r1;
            return r1;
        }

        static /* synthetic */ long k(a r0, long r1) {
            r0.r = r1;
            return r1;
        }

        public List<String> a() {
            return this.p;
        }

        public long b() {
            return this.f4634a;
        }

        public long c() {
            return this.f4635b;
        }

        public long d() {
            return this.f4636c;
        }

        public long e() {
            return this.f4637d;
        }

        public double f() {
            return this.h;
        }

        public double g() {
            return this.i;
        }

        public double h() {
            return this.j;
        }

        public long i() {
            return this.m;
        }

        public long j() {
            return this.n;
        }

        public long k() {
            return this.o;
        }

        public double l() {
            return this.f4638e;
        }

        public long m() {
            return this.f;
        }

        public long n() {
            return this.g;
        }

        public long o() {
            return this.k;
        }

        public long p() {
            return this.l;
        }

        public void a(long r1) {
            this.l = r1;
        }

        public long q() {
            return this.q;
        }

        public long r() {
            return this.r;
        }

        public List<v> s() {
            return this.s;
        }

        public String toString() {
            return "LaunchTraceData{gcCount=" + this.f4634a + ", gcTime=" + this.f4635b + ", blockGcCount=" + this.f4636c + ", blockGcTime=" + this.f4637d + ", cpuTime=" + this.f4638e + ", voluntarySwitches=" + this.f + ", inVoluntarySwitches=" + this.g + ", iowaitTime=" + this.h + ", runnableTime=" + this.i + ", sleepTime=" + this.j + ", minorFault=" + this.m + ", majorFault=" + this.n + ", allThreadCount=" + this.o + ", javaThreadNameList=" + this.p + ", lockTime=" + this.k + ", binderTime=" + this.l + '}';
        }
    }

    public static a a(long r11) {
        a r3 = new a();
        int r4 = Process.myPid();     // Catch: Throwable -> L43
        BufferedReader r6 = null;
        BufferedReader r7 = new BufferedReader(new FileReader("/proc/" + r4 + "/task/" + r4 + "/sched"), 100);     // Catch: Throwable -> L52
    L69:
        String r8 = r7.readLine();     // Catch: Throwable -> L27
        if (r8 != null) goto L9;
    L61:
        BufferedReader r9 = new BufferedReader(new FileReader("/proc/" + r4 + "/task/" + r4 + "/stat"), 100);     // Catch: Throwable -> L51
        String[] r0 = r9.readLine().split(" ");     // Catch: Throwable -> L32
        a.c(r3, Long.parseLong(r0[9]));     // Catch: Throwable -> L32
        a.d(r3, Long.parseLong(r0[11]));     // Catch: Throwable -> L32
    L55:
        if (Build.VERSION.SDK_INT < 23) goto L57;
        a.e(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count")));     // Catch: Throwable -> L48
        a.f(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time")));     // Catch: Throwable -> L48
        a.g(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count")));     // Catch: Throwable -> L48
        a.h(r3, Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time")));     // Catch: Throwable -> L48
    L57:
        a(r3);     // Catch: Throwable -> L49
        if (com.bytedance.apm.internal.a.b(128) == false) goto L40;
        a(r3, r4, com.bytedance.apm.internal.a.d(), r11);     // Catch: Throwable -> L49
    L40:
        if (r9 != null) goto L63;
    L45:
        return r3;
    L63:
        r9.close();     // Catch: Throwable -> L50
    L32:
        r7 = r9;
    L33:
        r9 = r7;
        goto L55
    L9:
        if (r8.contains("se.statistics.iowait_sum") == true) goto L10;
        if (r8.contains("se.statistics.wait_sum") == true) goto L13;
        if (r8.contains("se.statistics.sum_sleep_runtime") == true) goto L16;
        if (r8.contains("nr_voluntary_switches") == true) goto L19;
        if (r8.contains("nr_involuntary_switches") == true) goto L22;
        if (r8.contains("se.sum_exec_runtime") == false) goto L69;
        a.d(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L69
    L22:
        a.b(r3, Long.parseLong(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L69
    L19:
        a.a(r3, Long.parseLong(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L69
    L16:
        a.c(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L69
    L13:
        a.b(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L69
    L10:
        a.a(r3, Double.parseDouble(r8.substring(r8.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
    L27:
        r6 = r7;
    L28:
        r7 = r6;
    L43:
        th = move-exception;
        com.bytedance.apm.f.a.a().a("error when fetch launch perf data: " + th.getLocalizedMessage());     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    private static void a(a r7) {
        int r0 = 0;
        int r1 = new File("/proc/self/task/").listFiles().length;     // Catch: Throwable -> L5
    L6:
        if (r1 != 0) goto L8;
        return;
    L8:
        ThreadGroup r2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getParent() == null) goto L14;
        r2 = r2.getParent();
        goto L12
    L14:
        int r3 = r2.activeCount();
        Thread[] r4 = new Thread[r3 + (r3 / 2)];
        int r5 = r2.enumerate(r4);
        LinkedList r6 = new LinkedList();
    L15:
        if (r0 >= r5) goto L20;
        String r8 = r4[r0].getName();
        if (TextUtils.isEmpty(r8) == true) goto L19;
        r6.add(r8);
    L19:
        r0 = r0 + 1;
        goto L15
    L20:
        a.i(r7, r1);
        a.a(r7, r6);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private static void a(a r4, int r5, int r6, long r7) {
        a.j(r4, com.bytedance.apm.util.b.d());
        a.k(r4, g.a(r5));
        long r8 = (r7 * com.bytedance.apm.util.b.a(100)) / 1000;
        if (a.a(r4) <= (2 * r8)) goto L9;
        if (com.bytedance.apm.c.i() == false) goto L7;
        com.bytedance.apm6.util.c.b.c("LaunchPerfData", "originProcessDuration: " + a.a(r4) + " new: " + r8);
    L7:
        a.k(r4, r8);
    L9:
        if (com.bytedance.apm.c.i() == false) goto L11;
        com.bytedance.apm6.util.c.b.b("LaunchPerfData", "processCpuTime: " + a.b(r4) + " processDuration: " + a.a(r4));
    L11:
        LinkedList<v> r9 = com.bytedance.apm.util.b.a(r5, true, a.a(r4));
        Collections.sort(r9, new AnonymousClass1());
        a.b(r4, r9.subList(0, Math.min(r9.size(), r6)));
    }
}
