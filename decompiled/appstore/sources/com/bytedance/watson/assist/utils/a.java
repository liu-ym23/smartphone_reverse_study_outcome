package com.bytedance.watson.assist.utils;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f8238a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f8239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f8240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List f8241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static List f8242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List f8243f;

    /* JADX INFO: renamed from: com.bytedance.watson.assist.utils.a$a, reason: collision with other inner class name */
    public static class C0105a implements FilenameFilter {
        public C0105a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return Pattern.matches("cpu[0-9]", r11);
        }
    }

    public static class b implements FilenameFilter {
        public b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return Pattern.matches("state[0-9]", r11);
        }
    }

    public static class c implements FileUtils.ReadLineCallback {
        public c() {
        }

        @Override // com.bytedance.watson.assist.utils.FileUtils.ReadLineCallback
        public boolean onReadLine(String r10) {
            if (r10 != null) goto L5;
            return true;
        L5:
            if (r10.contains("Hardware") == false) goto L12;
            String[] r11 = r10.split(":");
            if (r11.length <= 1) goto L9;
            a.a(r11[1].trim());
        L9:
            return false;
        L12:
            return true;
        }
    }

    public static class d implements FilenameFilter {
        public d() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return Pattern.matches("policy[0-9]", r11);
        }
    }

    public static class e implements Comparator {
        public e() {
        }

        public int a(File r10, File r11) {
            return r10.getName().compareTo(r11.getName());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((File) r10, (File) r11);
        }
    }

    public static class f implements FileUtils.ReadLineCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f8244a;

        public f(List r10) {
            this.f8244a = r10;
        }

        @Override // com.bytedance.watson.assist.utils.FileUtils.ReadLineCallback
        public boolean onReadLine(String r10) {
            if (r10 != null) goto L5;
        L10:
            return true;
        L5:
            if (r10.isEmpty() == true) goto L10;
            String[] r11 = r10.split(" ");
            int r12 = r11.length;
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L10;
            String r14 = r11[r13];
            this.f8244a.add(Long.valueOf(Long.parseLong(r14)));
            r13 = r13 + 1;
            goto L8
        }
    }

    public static class g implements FileUtils.ReadLineCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f8245a;

        public g(List r10) {
            this.f8245a = r10;
        }

        @Override // com.bytedance.watson.assist.utils.FileUtils.ReadLineCallback
        public boolean onReadLine(String r10) {
            if (r10 != null) goto L5;
        L10:
            return true;
        L5:
            if (r10.isEmpty() == true) goto L10;
            String[] r11 = r10.split(" ");
            int r12 = r11.length;
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L10;
            String r14 = r11[r13];
            this.f8245a.add(Integer.valueOf(Integer.parseInt(r14)));
            r13 = r13 + 1;
            goto L8
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f8247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f8248c;

        public h(String r10) {
            this.f8247b = new ArrayList();
            this.f8248c = new ArrayList();
            this.f8246a = r10;
        }

        public List a() {
            return this.f8247b;
        }

        public List b() {
            return this.f8248c;
        }

        public String c() {
            return this.f8246a;
        }

        public void d(List r10) {
            this.f8247b = r10;
        }

        public void e(List r10) {
            this.f8248c = r10;
        }

        public String toString() {
            return "CpuClusterInfo{name='" + this.f8246a + "', affectedCpuList=" + this.f8247b + ", freqList=" + this.f8248c + '}';
        }
    }

    static {
    }

    public static /* synthetic */ String a(String r10) {
        f8239b = r10;
        return r10;
    }

    public static synchronized List b() {
        monitor-enter(a.class);
        List r10 = f8242e;     // Catch: Throwable -> L12
        if (r10 == null) goto L8;
        monitor-exit(a.class);
        return r10;
    L8:
        List r11 = h();     // Catch: Throwable -> L12
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L12
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L12
    L10:
        if (r13.hasNext() == false) goto L14;
        r12.add(Integer.valueOf(((h) r13.next()).a().size()));     // Catch: Throwable -> L12
        goto L10
    L14:
        f8242e = r12;     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r12;
    L12:
        th = move-exception;
        throw th;
    }

    public static long c(int r10) {
        return d(r10, "/scaling_cur_freq");
    }

    public static long d(int r10, String r11) {
        Long r12 = -1L;
        if (r10 < 0) goto L29;
        if (r11 == null) goto L29;
        List r13 = h();
        String r14 = LibrarianImpl.Constants.SEPARATOR;
        if (r13 != null) goto L9;
    L11:
        BufferedReader r15 = FileUtils.b(new File("/sys/devices/system/cpu/cpufreq" + r14 + r11));
        if (r15 != null) goto L32;
        return -1;
    L32:
        String r16 = r15.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r16 == null) goto L22;
        r12 = Long.valueOf(Long.parseLong(r16));     // Catch: Throwable -> L18 Exception -> L20
    L22:
        FileUtils.a(r15);
        return r12.longValue();
    L20:
        e = move-exception;
        a7.a.h("get cluster freq error : " + r11 + Log.getStackTraceString(e));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        FileUtils.a(r15);
        throw th;
    L9:
        if (r13.size() <= r10) goto L11;
        r14 = LibrarianImpl.Constants.SEPARATOR + ((h) r13.get(r10)).c();
    L29:
        return -1;
    }

    public static long e(int r10) {
        return d(r10, "/scaling_max_freq");
    }

    public static int f(int r10) {
        return m(r10, d(r10, "/scaling_max_freq"));
    }

    public static long g(int r10) {
        return d(r10, "/scaling_min_freq");
    }

    public static synchronized List h() {
        monitor-enter(a.class);
        List r10 = f8241d;     // Catch: Throwable -> L15
        if (r10 == null) goto L8;
        monitor-exit(a.class);
        return r10;
    L8:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L15
        File[] r12 = new File("/sys/devices/system/cpu/cpufreq").listFiles(new d());     // Catch: Throwable -> L15
        if (r12 != null) goto L11;
    L17:
        f8241d = r11;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r11;
    L11:
        if (r12.length <= 0) goto L17;
        Arrays.sort(r12, new e());     // Catch: Throwable -> L15
        int r13 = r12.length;     // Catch: Throwable -> L15
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L17;
        File r15 = r12[r14];     // Catch: Throwable -> L15
        h r16 = new h(r15.getName());     // Catch: Throwable -> L15
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L15
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L15
        FileUtils.d(r15.getAbsolutePath() + "/scaling_available_frequencies", new f(r17));     // Catch: Throwable -> L15
        FileUtils.d(r15.getAbsolutePath() + "/affected_cpus", new g(r18));     // Catch: Throwable -> L15
        r16.e(r17);     // Catch: Throwable -> L15
        r16.d(r18);     // Catch: Throwable -> L15
        r11.add(r16);     // Catch: Throwable -> L15
        r14 = r14 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static int i() {
        if (f8238a != (-1)) goto L10;
        File[] r10 = new File("/sys/devices/system/cpu").listFiles(new C0105a());
        if (r10 != null) goto L7;
        int r11 = 1;
    L8:
        f8238a = r11;
        goto L10
    L7:
        r11 = r10.length;
    L10:
        return f8238a;
    }

    public static String j() {
        String r10 = f8239b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        FileUtils.d("/proc/cpuinfo", new c());
        return f8239b;
    }

    public static String k() {
        String r10 = f8240c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        String r11 = a7.c.a("ro.board.platform", "");
        f8240c = r11;
        return r11;
    }

    public static synchronized List l() {
        monitor-enter(a.class);
        List r10 = f8243f;     // Catch: Throwable -> L21
        if (r10 == null) goto L8;
        monitor-exit(a.class);
        return r10;
    L8:
        int r11 = i();     // Catch: Throwable -> L21
        if (r11 != (-1)) goto L14;
        monitor-exit(a.class);
        return null;
    L14:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L21
        int r13 = 0;
    L15:
        if (r13 >= r11) goto L23;
        File[] r14 = new File("/sys/devices/system/cpu/cpu" + r13 + "/cpuidle").listFiles(new b());     // Catch: Throwable -> L21
        if (r14 != null) goto L19;
        int r15 = 0;
    L20:
        r12.add(Integer.valueOf(r15));     // Catch: Throwable -> L21
        r13 = r13 + 1;     // Catch: Throwable -> L21
        goto L15
    L19:
        r15 = r14.length;     // Catch: Throwable -> L21
        goto L20
    L23:
        f8243f = r12;     // Catch: Throwable -> L21
        monitor-exit(a.class);
        return r12;
    L21:
        th = move-exception;
        throw th;
    }

    public static int m(int r10, long r11) {
        if (r10 >= 0) goto L5;
    L26:
        return -1;
    L5:
        if (r11 <= 0) goto L26;
        List r12 = h();
        if (r12 == null) goto L26;
        if (r12.size() < (r10 + 1)) goto L26;
        h r13 = (h) r12.get(r10);
        if (r13 == null) goto L26;
        if (r13.b() == null) goto L26;
        int r14 = r13.b().size();
        int r15 = 0;
    L18:
        if (r15 >= r14) goto L26;
        if (((Long) r13.b().get(r15)).longValue() == r11) goto L21;
        r15 = r15 + 1;
        goto L18
    L21:
        int r16 = r15 / (r14 / 4);
        if (r16 > 3) goto L24;
        return r16;
    L24:
        return 3;
    }
}
