package com.bytedance.crash.resource.a;

import android.content.Context;
import com.bytedance.crash.i;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.r;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: compiled from: FdTrackAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.crash.resource.b {
    private static a k;
    private int h;
    private boolean i;
    private b j;

    /* JADX INFO: renamed from: com.bytedance.crash.resource.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FdTrackAdapter.java */
    static class C0171a extends com.bytedance.crash.resource.b.a {
        public C0171a(com.bytedance.crash.monitor.a r1, File r2) {
            super(r1, r2);
        }

        @Override // com.bytedance.crash.resource.b.a
        public boolean a(File r11, com.bytedance.crash.resource.b.C0172b r12) {
            File r1 = new File(r11, "tombstone.txt");
            File r2 = new File(r11, "javastack.txt");
            File r3 = new File(r11, "fd_types.txt");
            if (r1.exists() == true) goto L57;
            return false;
        L57:
        L50:
            return false;
        L6:
            if (r2.exists() == false) goto L8;
            r12.f7705a = j.c(r2.getAbsolutePath());     // Catch: Throwable -> L50
        L8:
            JSONArray r13 = j.b(r1.getAbsolutePath());     // Catch: Throwable -> L50
            if (r13 != null) goto L12;
            r.b("FdTracker: ", "stack content is null");     // Catch: Throwable -> L50
            return false;
        L12:
            int r4 = a(r13, 0, "pid:");     // Catch: Throwable -> L50
            if (r4 < 0) goto L21;
            String[] r6 = r13.optString(r4, null).trim().split("\\s");     // Catch: Throwable -> L50
            int r7 = 0;
        L16:
            if (r7 >= r6.length) goto L21;
            if ("name:".equals(r6[r7]) == true) goto L19;
            r7 = r7 + 1;     // Catch: Throwable -> L50
            goto L16
        L19:
            int r8 = r7 + 1;     // Catch: Throwable -> L50
            r12.f7707c = r6[r8].substring(0, r6[r8].length());     // Catch: Throwable -> L50
        L21:
            StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L50
            int r5 = a(r13, r4 + 1, "Signal ");     // Catch: Throwable -> L50
            if (r5 < 0) goto L24;
            r9.append(r13.optString(r5, null)).append('\n');     // Catch: Throwable -> L50
        L24:
            int r10 = a(r13, r5 + 1, "Abort message:");     // Catch: Throwable -> L50
            if (r10 < 0) goto L32;
            r12.f7708d = r13.optString(r10, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L50
            r9.append(r12.f7708d).append('\n');     // Catch: Throwable -> L50
            if (r12.f7708d.startsWith("abort message:") == false) goto L32;
            Matcher r14 = Pattern.compile("^.*:\\s+(\\S+):.*,.*,\\s+\\S+\\s+(\\S+)\\(.*$").matcher(r12.f7708d);     // Catch: Throwable -> L51
            if (r14.find() == false) goto L32;
            r12.i.put("fd_leak_lib", r14.group(1));     // Catch: Throwable -> L51
            r12.i.put("fd_leak_reason", r14.group(2));     // Catch: Throwable -> L51
        L32:
            int r15 = a(r13, r10 + 1, "backtrace:");
            if (r15 < 0) goto L55;
            int r16 = r15 + 1;
        L36:
            if (r16 >= r13.length()) goto L40;
            String r0 = r13.optString(r16, null);
            if (r0.startsWith("    #") == false) goto L40;
            r9.append(r0.trim()).append('\n');
            r16 = r16 + 1;
        L40:
            r12.f7706b = r9.toString();
        L55:
            JSONArray r17 = j.b(r3.getAbsolutePath());     // Catch: Throwable -> L52
            if (r17 == null) goto L48;
            String r18 = r17.optString(0, null);     // Catch: Throwable -> L52
            if (r18 == null) goto L48;
            if ("".equals(r18) == true) goto L48;
            r12.i.put("fd_leak_count_range", b(r18.trim().split(" ")[1]));     // Catch: Throwable -> L52
        L48:
            r12.i.put("has_fd_track", "true");     // Catch: Throwable -> L52
        L49:
            return true;
        }

        @Override // com.bytedance.crash.resource.b.a
        public void a(Map<String, String> r3, com.bytedance.crash.resource.b.C0172b r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            super.a(r5, r4);
            if (com.bytedance.crash.general.a.c() == false) goto L5;
            String r2 = "true";
        L6:
            r5.put("is_root", r2);
            r5.put("fd_leak_app", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
            return;
        L5:
            r2 = "false";
            goto L6
        }

        private static String b(String r1) {
            int r2 = Integer.parseInt(r1);
            if (r2 >= 300) goto L7;
            return "0 ~ 200";
        L7:
            if (r2 >= 500) goto L11;
            return "200 ~ 500";
        L11:
            if (r2 >= 800) goto L15;
            return "500 ~ 800";
        L15:
            if (r2 >= 1024) goto L19;
            return "800 ~ 1000";
        L19:
            if (r2 >= 1500) goto L22;
            return "1000 ~ 1500";
        L22:
            return "> 1500";
        }
    }

    public a() {
    }

    static /* synthetic */ int a(a r0, int r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ b a(a r0) {
        return r0.j;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ int b(a r0) {
        return r0.h;
    }

    static /* synthetic */ int c(a r0) {
        return r0.h();
    }

    static /* synthetic */ int d(a r0) {
        return r0.i();
    }

    static /* synthetic */ int e(a r0) {
        return r0.j();
    }

    static /* synthetic */ int f(a r0) {
        return r0.k();
    }

    static /* synthetic */ int g(a r0) {
        return r0.l();
    }

    static /* synthetic */ com.bytedance.crash.resource.f.a h(a r0) {
        return r0.f7695e;
    }

    static /* synthetic */ int i(a r0) {
        return r0.m();
    }

    public static a f() {
        if (k != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (k != null) goto L9;
        k = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return k;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.crash.resource.a.a$1] */
    @Override // com.bytedance.crash.resource.b
    public void b() {
        r.b("FdTracker: ", "begin execute");
        if (g() == true) goto L5;
        return;
    L5:
        this.i = true;
        final String r1 = "npthFdTracker";
        new AnonymousClass1(this, r1).start();
    }

    private boolean g() {
        if (this.i == false) goto L7;
        r.b("FdTracker: ", "already is running");
        return false;
    L7:
        if (this.h == 0) goto L10;
        r.b("FdTracker: ", "invalid state");
        return false;
    L10:
        this.h = 1;
        return true;
    }

    public static void a(b r1) {
        a r0 = f();
        r0.j = r1;
        r0.a(r1);
    }

    private int h() {
        if (this.h > 2) goto L5;
        int r1 = 0;
    L7:
        return NativeResourceMonitor.d(r1);
    L5:
        r1 = 1;
        goto L7
    }

    private int i() {
        return NativeResourceMonitor.c(0);
    }

    private int j() {
        return NativeResourceMonitor.c(1);
    }

    private int k() {
        return NativeResourceMonitor.c(2);
    }

    private int l() {
        return NativeResourceMonitor.c(3);
    }

    private int m() {
        return NativeResourceMonitor.c(4);
    }

    public static void a(com.bytedance.crash.monitor.a r2) {
        new C0171a(r2, com.bytedance.crash.resource.f.b.e()).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        r.c("FdTracker: ", "upload exception:" + th);
    }
}
