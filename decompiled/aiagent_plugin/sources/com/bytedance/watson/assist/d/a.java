package com.bytedance.watson.assist.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CpuUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11861a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f11862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f11863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<C0263a> f11864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<Integer> f11865e;
    private static List<Integer> f;

    /* JADX INFO: renamed from: com.bytedance.watson.assist.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CpuUtils.java */
    public static class C0263a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<Integer> f11869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<Long> f11870c;

        public C0263a(String r2) {
            this.f11869b = new ArrayList();
            this.f11870c = new ArrayList();
            this.f11868a = r2;
        }

        public String a() {
            return this.f11868a;
        }

        public List<Integer> b() {
            return this.f11869b;
        }

        public void a(List<Integer> r3) {
            this.f11869b = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        public void b(List<Long> r3) {
            this.f11870c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        public String toString() {
            return "CpuClusterInfo{name='" + this.f11868a + "', affectedCpuList=" + this.f11869b + ", freqList=" + this.f11870c + '}';
        }
    }

    static {
    }

    public static int a() {
        if (f11861a != (-1)) goto L10;
        File[] r0 = new File("/sys/devices/system/cpu").listFiles(new AnonymousClass1());
        if (r0 != null) goto L7;
        int r1 = 1;
    L8:
        f11861a = r1;
        goto L10
    L7:
        r1 = r0.length;
    L10:
        return f11861a;
    }

    public static synchronized List<Integer> b() {
        monitor-enter(a.class);
        List<Integer> r1 = f;     // Catch: Throwable -> L24
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = a();     // Catch: Throwable -> L24
        if (r2 == (-1)) goto L12;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L24
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L21;
        File[] r5 = new File("/sys/devices/system/cpu/cpu" + r4 + "/cpuidle").listFiles(new AnonymousClass2());     // Catch: Throwable -> L24
        if (r5 != null) goto L19;
        int r6 = 0;
    L20:
        r3.add(Integer.valueOf(r6));     // Catch: Throwable -> L24
        r4 = r4 + 1;     // Catch: Throwable -> L24
        goto L15
    L19:
        r6 = r5.length;     // Catch: Throwable -> L24
        goto L20
    L21:
        f = r3;     // Catch: Throwable -> L24
        monitor-exit(a.class);
        return r3;
    L12:
        monitor-exit(a.class);
        return null;
    L24:
        th = move-exception;
        throw th;
    }

    public static String c() {
        String r0 = f11863c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = e.a("ro.board.platform", "");
        f11863c = r1;
        return r1;
    }

    public static synchronized List<C0263a> d() {
        monitor-enter(a.class);
        List<C0263a> r1 = f11864d;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L18
        File[] r3 = new File("/sys/devices/system/cpu/cpufreq").listFiles(new AnonymousClass3());     // Catch: Throwable -> L18
        if (r3 != null) goto L11;
    L15:
        f11864d = r2;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r2;
    L11:
        if (r3.length <= 0) goto L15;
        Arrays.sort(r3, new AnonymousClass4());     // Catch: Throwable -> L18
        int r4 = r3.length;     // Catch: Throwable -> L18
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L15;
        File r6 = r3[r5];     // Catch: Throwable -> L18
        C0263a r7 = new C0263a(r6.getName());     // Catch: Throwable -> L18
        final ArrayList r8 = new ArrayList();     // Catch: Throwable -> L18
        final ArrayList r9 = new ArrayList();     // Catch: Throwable -> L18
        c.a(r6.getAbsolutePath() + "/scaling_available_frequencies", new AnonymousClass5(r8));     // Catch: Throwable -> L18
        c.a(r6.getAbsolutePath() + "/affected_cpus", new AnonymousClass6(r9));     // Catch: Throwable -> L18
        r7.b(r8);     // Catch: Throwable -> L18
        r7.a(r9);     // Catch: Throwable -> L18
        r2.add(r7);     // Catch: Throwable -> L18
        r5 = r5 + 1;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized List<Integer> e() {
        monitor-enter(a.class);
        List<Integer> r1 = f11865e;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        List<C0263a> r2 = d();     // Catch: Throwable -> L15
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<C0263a> r4 = r2.iterator();     // Catch: Throwable -> L15
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(Integer.valueOf(((C0263a) ZeusTransformUtils.preCheckCast(r4.next(), C0263a.class, "com.obric.aiagent.plugin")).b().size()));     // Catch: Throwable -> L15
        goto L10
    L12:
        f11865e = r3;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r3;
    L15:
        th = move-exception;
        throw th;
    }
}
