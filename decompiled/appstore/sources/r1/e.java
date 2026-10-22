package r1;

import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f23702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f23703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f23704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f23705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f23706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f23707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f23708g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double f23709h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f23710i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f23711j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f23712k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f23713l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f23714m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f23715n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f23716o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List f23717p;

        public a() {
            this.f23702a = -1;
            this.f23703b = -1;
            this.f23704c = -1;
            this.f23705d = -1;
            this.f23706e = -1.0d;
            this.f23707f = -1;
            this.f23708g = -1;
            this.f23709h = -1.0d;
            this.f23710i = -1.0d;
            this.f23711j = -1.0d;
            this.f23712k = -1;
            this.f23713l = -1;
            this.f23714m = -1;
            this.f23715n = -1;
            this.f23716o = -1;
            this.f23717p = null;
        }

        public static /* synthetic */ double a(a r10, double r11) {
            r10.f23709h = r11;
            return r11;
        }

        public static /* synthetic */ long b(a r10, long r11) {
            r10.f23704c = r11;
            return r11;
        }

        public static /* synthetic */ double c(a r10, double r11) {
            r10.f23710i = r11;
            return r11;
        }

        public static /* synthetic */ long d(a r10, long r11) {
            r10.f23705d = r11;
            return r11;
        }

        public static /* synthetic */ long e(a r10, long r11) {
            r10.f23716o = r11;
            return r11;
        }

        public static /* synthetic */ List f(a r10, List r11) {
            r10.f23717p = r11;
            return r11;
        }

        public static /* synthetic */ double g(a r10, double r11) {
            r10.f23711j = r11;
            return r11;
        }

        public static /* synthetic */ long h(a r10, long r11) {
            r10.f23707f = r11;
            return r11;
        }

        public static /* synthetic */ long i(a r10, long r11) {
            r10.f23708g = r11;
            return r11;
        }

        public static /* synthetic */ double j(a r10, double r11) {
            r10.f23706e = r11;
            return r11;
        }

        public static /* synthetic */ long k(a r10, long r11) {
            r10.f23714m = r11;
            return r11;
        }

        public static /* synthetic */ long l(a r10, long r11) {
            r10.f23715n = r11;
            return r11;
        }

        public static /* synthetic */ long m(a r10, long r11) {
            r10.f23702a = r11;
            return r11;
        }

        public static /* synthetic */ long n(a r10, long r11) {
            r10.f23703b = r11;
            return r11;
        }

        public long A() {
            return this.f23714m;
        }

        public double B() {
            return this.f23710i;
        }

        public double C() {
            return this.f23711j;
        }

        public long D() {
            return this.f23707f;
        }

        public void E(long r10) {
            this.f23713l = r10;
        }

        public long o() {
            return this.f23716o;
        }

        public long p() {
            return this.f23713l;
        }

        public long q() {
            return this.f23704c;
        }

        public long r() {
            return this.f23705d;
        }

        public double s() {
            return this.f23706e;
        }

        public long t() {
            return this.f23702a;
        }

        public String toString() {
            return "LaunchTraceData{gcCount=" + this.f23702a + ", gcTime=" + this.f23703b + ", blockGcCount=" + this.f23704c + ", blockGcTime=" + this.f23705d + ", cpuTime=" + this.f23706e + ", voluntarySwitches=" + this.f23707f + ", inVoluntarySwitches=" + this.f23708g + ", iowaitTime=" + this.f23709h + ", runnableTime=" + this.f23710i + ", sleepTime=" + this.f23711j + ", minorFault=" + this.f23714m + ", majorFault=" + this.f23715n + ", allThreadCount=" + this.f23716o + ", javaThreadNameList=" + this.f23717p + ", lockTime=" + this.f23712k + ", binderTime=" + this.f23713l + '}';
        }

        public long u() {
            return this.f23703b;
        }

        public long v() {
            return this.f23708g;
        }

        public double w() {
            return this.f23709h;
        }

        public List x() {
            return this.f23717p;
        }

        public long y() {
            return this.f23712k;
        }

        public long z() {
            return this.f23715n;
        }
    }

    public static void a(a r10) {
        int r11 = 0;
        int r12 = new File("/proc/self/task/").listFiles().length;     // Catch: Throwable -> L5
    L6:
        if (r12 != 0) goto L8;
        return;
    L8:
        ThreadGroup r13 = Looper.getMainLooper().getThread().getThreadGroup();
        if (r13 != null) goto L12;
        return;
    L12:
        if (r13.getParent() == null) goto L14;
        r13 = r13.getParent();
        goto L12
    L14:
        int r14 = r13.activeCount();
        Thread[] r15 = new Thread[r14 + (r14 / 2)];
        int r16 = r13.enumerate(r15);
        LinkedList r17 = new LinkedList();
    L15:
        if (r11 >= r16) goto L20;
        String r18 = r15[r11].getName();
        if (TextUtils.isEmpty(r18) == true) goto L19;
        r17.add(r18);
    L19:
        r11 = r11 + 1;
        goto L15
    L20:
        a.e(r10, r12);
        a.f(r10, r17);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public static a b() {
        a r10 = new a();
        int r11 = Process.myPid();     // Catch: Throwable -> L39
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new FileReader("/proc/" + r11 + "/task/" + r11 + "/sched"), 100);     // Catch: Throwable -> L46
    L53:
        String r14 = r13.readLine();     // Catch: Throwable -> L11
        if (r14 != null) goto L9;
    L51:
        BufferedReader r15 = new BufferedReader(new FileReader("/proc/" + r11 + "/task/" + r11 + "/stat"), 100);     // Catch: Throwable -> L45
        String[] r16 = r15.readLine().split(" ");     // Catch: Throwable -> L32
        a.k(r10, Long.parseLong(r16[9]));     // Catch: Throwable -> L32
        a.l(r10, Long.parseLong(r16[11]));     // Catch: Throwable -> L32
    L55:
        a.m(r10, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_COUNT)));     // Catch: Throwable -> L42
        a.n(r10, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_GC_TIME)));     // Catch: Throwable -> L42
        a.b(r10, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_COUNT)));     // Catch: Throwable -> L42
        a.d(r10, Long.parseLong(Debug.getRuntimeStat(PerfConsts.ART_GC_BLOCKING_GC_TIME)));     // Catch: Throwable -> L42
    L57:
        a(r10);     // Catch: Throwable -> L43
    L36:
        if (r15 != null) goto L59;
    L41:
        return r10;
    L59:
        r15.close();     // Catch: Throwable -> L44
    L32:
        r13 = r15;
    L33:
        r15 = r13;
        goto L55
    L9:
        if (r14.contains("se.statistics.iowait_sum") == true) goto L10;
        if (r14.contains("se.statistics.wait_sum") == true) goto L14;
        if (r14.contains("se.statistics.sum_sleep_runtime") == true) goto L17;
        if (r14.contains("nr_voluntary_switches") == true) goto L20;
        if (r14.contains("nr_involuntary_switches") == true) goto L23;
        if (r14.contains("se.sum_exec_runtime") == false) goto L53;
        a.j(r10, Double.parseDouble(r14.substring(r14.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L53
    L23:
        a.i(r10, Long.parseLong(r14.substring(r14.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L53
    L20:
        a.h(r10, Long.parseLong(r14.substring(r14.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L53
    L17:
        a.g(r10, Double.parseDouble(r14.substring(r14.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L53
    L14:
        a.c(r10, Double.parseDouble(r14.substring(r14.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
        goto L53
    L10:
        a.a(r10, Double.parseDouble(r14.substring(r14.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L11
    L11:
        r12 = r13;
    L28:
        r13 = r12;
    L39:
        th = move-exception;
        r1.a.b().e("error when fetch launch perf data: " + th.getLocalizedMessage());
        goto L41
    }
}
