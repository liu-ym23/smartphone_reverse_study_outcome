package com.bytedance.crash.resource.g;

import android.content.Context;
import com.bytedance.crash.i;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.r;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: compiled from: VmMonitorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.crash.resource.b {
    private static final String TAG = "VmMonitor: ";
    private static long i = 819200;
    private static long j = 512000;
    private static C0176a k;
    private static C0176a l;
    private static a m;
    protected com.bytedance.crash.resource.g.b h;

    /* JADX INFO: renamed from: com.bytedance.crash.resource.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VmMonitorAdapter.java */
    static class C0176a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f7726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f7727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f7729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f7730e;
        int f;

        public C0176a(int r3) {
            this.f7726a = false;
            this.f7727b = false;
            this.f7728c = true;
            this.f7729d = false;
            this.f = 0;
            this.f7730e = r3;
        }
    }

    /* JADX INFO: compiled from: VmMonitorAdapter.java */
    static class b extends com.bytedance.crash.resource.b.a {
        public b(com.bytedance.crash.monitor.a r1, File r2) {
            super(r1, r2);
        }

        @Override // com.bytedance.crash.resource.b.a
        public boolean a(File r11, com.bytedance.crash.resource.b.C0172b r12) {
            File r1 = new File(r11, "tombstone.txt");
            File r2 = new File(r11, "javastack.txt");
            if (r1.exists() == true) goto L47;
            return false;
        L47:
        L43:
            return false;
        L6:
            if (r2.exists() == false) goto L8;
            r12.f7705a = j.c(r2.getAbsolutePath());     // Catch: Throwable -> L43
        L8:
            JSONArray r13 = j.b(r1.getAbsolutePath());     // Catch: Throwable -> L43
            if (r13 != null) goto L12;
            r.b(a.TAG, "stack content is null");     // Catch: Throwable -> L43
            return false;
        L12:
            int r3 = a(r13, 0, "pid:");     // Catch: Throwable -> L43
            if (r3 < 0) goto L21;
            String[] r5 = r13.optString(r3, null).trim().split("\\s");     // Catch: Throwable -> L43
            int r6 = 0;
        L16:
            if (r6 >= r5.length) goto L21;
            if ("name:".equals(r5[r6]) == true) goto L19;
            r6 = r6 + 1;     // Catch: Throwable -> L43
            goto L16
        L19:
            r12.f7707c = r5[r6 + 1];     // Catch: Throwable -> L43
        L21:
            StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L43
            int r4 = a(r13, r3 + 1, "Signal ");     // Catch: Throwable -> L43
            if (r4 < 0) goto L24;
            r7.append(r13.optString(r4, null)).append('\n');     // Catch: Throwable -> L43
        L24:
            int r8 = a(r13, r4 + 1, "Abort message:");     // Catch: Throwable -> L43
            if (r8 < 0) goto L33;
            r12.f7708d = r13.optString(r8, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L43
            r7.append(r12.f7708d).append('\n');     // Catch: Throwable -> L43
            if (r12.f7708d.startsWith("abort message:") == false) goto L33;
            Matcher r10 = Pattern.compile("^.*:\\s+(\\S+):.*,.*,.*:\\s+(\\S+)\\(.*:(\\S+)\\s+(\\S+)\\).*$").matcher(r12.f7708d);     // Catch: Throwable -> L44
            if (r10.find() == false) goto L33;
            r12.i.put("mmap_leak_lib", r10.group(1));     // Catch: Throwable -> L44
            r12.i.put("mmap_leak_reason", r10.group(2));     // Catch: Throwable -> L44
            r12.i.put("mmap_leak_size", a(r10.group(3), r10.group(4)));     // Catch: Throwable -> L44
        L33:
            int r14 = a(r13, r8 + 1, "backtrace:");     // Catch: Throwable -> L43
            if (r14 < 0) goto L42;
            int r15 = r14 + 1;     // Catch: Throwable -> L43
        L37:
            if (r15 >= r13.length()) goto L41;
            String r0 = r13.optString(r15, null);     // Catch: Throwable -> L43
            if (r0.startsWith("    #") == false) goto L41;
            r7.append(r0.trim()).append('\n');     // Catch: Throwable -> L43
            r15 = r15 + 1;     // Catch: Throwable -> L43
        L41:
            r12.f7706b = r7.toString();     // Catch: Throwable -> L43
        L42:
            return true;
        }

        @Override // com.bytedance.crash.resource.b.a
        public void a(Map<String, String> r3, com.bytedance.crash.resource.b.C0172b r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            super.a(r5, r4);
            String r6 = "true";
            r5.put("mmap_monitor", "true");
            r5.put("has_mmap_leak", "true");
            if (com.bytedance.crash.general.a.c() == true) goto L6;
            r6 = "false";
        L6:
            r5.put("is_root", r6);
            r5.put("mmap_leak_app", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
        }
    }

    static {
    }

    private static String e(int r1) {
        if (r1 != 0) goto L4;
        return "recover";
    L4:
        if (r1 != 1) goto L6;
        return "hook";
    L6:
        if (r1 != 3) goto L8;
        return "start_monitor";
    L8:
        if (r1 != 4) goto L10;
        return "stop_monitor";
    L10:
        if (r1 != 5) goto L12;
        return "dump";
    L12:
        if (r1 != 6) goto L14;
        return "get_leak_size";
    L14:
        if (r1 == 7) goto L17;
        return "unknown command";
    L17:
        return "get_vm_size";
    }

    public a() {
    }

    static /* synthetic */ long a(long r0) {
        j = r0;
        return r0;
    }

    static /* synthetic */ com.bytedance.crash.resource.f.a a(a r0) {
        return r0.f7695e;
    }

    static /* synthetic */ void a(int r0) {
        f(r0);
    }

    static /* synthetic */ void a(a r0, int r1) {
        r0.i(r1);
    }

    static /* synthetic */ long b(boolean r2) {
        return c(r2);
    }

    static /* synthetic */ void b(a r0, int r1) {
        r0.j(r1);
    }

    static /* synthetic */ void c(a r0, int r1) {
        r0.h(r1);
    }

    static /* synthetic */ void d(a r0, int r1) {
        r0.k(r1);
    }

    static /* synthetic */ C0176a h() {
        return k;
    }

    static /* synthetic */ long i() {
        return i;
    }

    static /* synthetic */ long j() {
        return n();
    }

    public static a f() {
        if (m != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (m != null) goto L9;
        m = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return m;
    }

    public static void a(com.bytedance.crash.resource.g.b r1) {
        a r0 = f();
        r0.h = r1;
        r0.a(r1);
    }

    @Override // com.bytedance.crash.resource.b
    public void b() {
        k = new C0176a(1);
        l = new C0176a(2);
        if ((this.h.j & 1) == 0) goto L6;
        i = g();
        k();
    L6:
        if ((this.h.j & 2) == 0) goto L9;
        i(1);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.crash.resource.g.a$1] */
    private void k() {
        if (d(0) == true) goto L6;
        return;
    L6:
        if (k.f7729d == false) goto L9;
        r.a("VmMonitor: execute water line mode Already running");
        return;
    L9:
        k.f7729d = true;
        k.f = 0;
        final String r1 = "mmapWaterLineModeMonitor";
        new AnonymousClass1(this, r1).start();
    }

    private static C0176a b(int r0) {
        if (r0 != 0) goto L5;
        return k;
    L5:
        return l;
    }

    private void c(int r1) {
        b(r1).f7729d = false;
    }

    private boolean a(C0176a r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.f != 4) goto L8;
        return false;
    L8:
        if (r3.f != (-1)) goto L10;
        return false;
    L10:
        if (r3.f == 5) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean d(int r3) {
        C0176a r0 = b(r3);
        if (a(r0) == true) goto L7;
        return false;
    L7:
        if (r0.f7727b == true) goto L12;
        if (r0.f7728c == false) goto L12;
        g(r3);
    L12:
        return r0.f7727b;
    }

    private static void a(int r1, int r2, int r3) {
        if (r3 == 0) goto L5;
        b(r1).f = -1;
        r.a(TAG + e(r2) + ": " + r3);
        return;
    }

    private static long l() {
        long r0 = n();
        if (r0 >= j) goto L5;
        j = r0;
    L5:
        return r0;
    }

    public static long a(boolean r4) {
        if (r4 == false) goto L6;
        long r0 = l();
        long r2 = j;
    L5:
        return r0 - r2;
    L6:
        r0 = g();
        r2 = i;
        goto L5
    }

    public static long g() {
        return Math.max(0, NativeResourceMonitor.a(7, 0));
    }

    private static long c(boolean r4) {
        if (r4 == false) goto L6;
        return l() - j;
    L6:
        return m();
    }

    private static long m() {
        int r0 = NativeResourceMonitor.a(6, 0);
        if (r0 >= 0) goto L8;
        C0176a r2 = k;
        if (r2 == null) goto L8;
        r2.f = -1;
    L8:
        return Math.max(0, r0);
    }

    private static long n() {
        int r0 = NativeResourceMonitor.a(8, 0);
        if (r0 >= 0) goto L8;
        C0176a r2 = k;
        if (r2 == null) goto L8;
        r2.f = -1;
    L8:
        return Math.max(0, r0);
    }

    private static void f(int r2) {
        r.a("VmMonitor: recover");
        if (r2 != 1) goto L5;
        k.f = 5;
    L5:
        a(0, 0, NativeResourceMonitor.a(0, r2));
    }

    private void g(int r5) {
        r.a("VmMonitor: start hook: " + r5);
        if (r5 != 0) goto L5;
        C0176a r4 = k;
    L7:
        if (r4.f7727b == false) goto L9;
        return;
    L9:
        int r1 = NativeResourceMonitor.a(1, r5);
        if (r1 != 0) goto L12;
        boolean r3 = true;
    L13:
        r4.f7727b = r3;
        r4.f7728c = false;
        a(r5, 1, r1);
        return;
    L12:
        r3 = false;
        goto L13
    L5:
        r4 = l;
        goto L7
    }

    private void h(int r5) {
        r.a("VmMonitor: exit hook");
        if (r5 != 0) goto L5;
        C0176a r4 = k;
    L7:
        if (r4.f7727b == true) goto L9;
        return;
    L9:
        int r1 = NativeResourceMonitor.a(2, r5);
        if (r1 != 0) goto L12;
        boolean r3 = true;
    L13:
        r4.f7728c = r3;
        r4.f7727b = true ^ r4.f7728c;
        a(r5, 2, r1);
        return;
    L12:
        r3 = false;
        goto L13
    L5:
        r4 = l;
        goto L7
    }

    private void i(int r2) {
        r.a("VmMonitor: start monitor native");
        if (d(r2) == true) goto L5;
        return;
    L5:
        a(r2, 3, NativeResourceMonitor.a(3, r2));
    }

    private void j(int r2) {
        r.a("VmMonitor: stop monitor native");
        a(r2, 4, NativeResourceMonitor.a(4, r2));
    }

    private void k(int r4) {
        NativeResourceMonitor.a(this.f7692b);
        NativeResourceMonitor.a(5, 1);
        int r1 = NativeResourceMonitor.a(5, r4);
        a(r4, 5, r1);
        if (r1 == 0) goto L5;
        return;
    L5:
        DefaultWorkThread.postDelayed(new AnonymousClass2(this), 60000);
        c(r4);
    }

    public static void a(com.bytedance.crash.monitor.a r2) {
        new b(r2, com.bytedance.crash.resource.f.b.d()).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.c(TAG, "upload exception:" + th);
    }
}
