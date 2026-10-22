package com.bytedance.crash.n;

import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Process;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ad;
import com.bytedance.crash.dumper.l;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.k;
import com.bytedance.crash.o.r;
import com.bytedance.crash.p;
import com.bytedance.crash.q;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TerminateMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f7627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f7628b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7629c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7630d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7631e = false;
    private static boolean f = false;
    private static File g;
    private static File h;
    private static ConcurrentLinkedQueue<p> i;
    private static ConcurrentLinkedQueue<q> j;
    private static boolean k;
    private static boolean l;

    private static boolean b(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= 300) goto L6;
        return true;
    }

    static /* synthetic */ void a(com.bytedance.crash.monitor.a r0, ApplicationExitInfo r1, boolean r2, boolean r3) {
        b(r0, r1, r2, r3);
    }

    static /* synthetic */ boolean a(int r0) {
        return b(r0);
    }

    static /* synthetic */ void c() {
        e();
    }

    static /* synthetic */ boolean d() {
        return f7631e;
    }

    public static void a() {
        if (f7630d == false) goto L5;
        return;
    L5:
        File r0 = i.d();
        if (r0 == null) goto L9;
        f7630d = true;
        r.b("KillInfo", "init");
        a(r0);
        return;
    }

    public static void a(boolean r0, boolean r1) {
        f7631e = r0;
        f = r1;
    }

    static {
        i = new ConcurrentLinkedQueue();
        j = new ConcurrentLinkedQueue();
        k = false;
        l = false;
    }

    public static void a(p r2) {
        p r3 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.aiagent.plugin");
        i.add(r3);
    }

    static void a(List<ApplicationExitInfo> r4) {
        List<ApplicationExitInfo> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Iterator<q> r0 = j.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L19;
        ((q) ZeusTransformUtils.preCheckCast(r0.next(), q.class, "com.obric.aiagent.plugin")).a(r5);     // Catch: Throwable -> L10
        goto L5
    L19:
        return;
    }

    static void a(ApplicationExitInfo r4) {
        Iterator<p> r0 = i.iterator();     // Catch: Throwable -> L10
    L4:
        if (r0.hasNext() == false) goto L18;
        ((p) ZeusTransformUtils.preCheckCast(r0.next(), p.class, "com.obric.aiagent.plugin")).findOneExitReason(r4);     // Catch: Throwable -> L9
        goto L4
    L18:
        return;
    }

    private static void a(File r4) {
        File r5 = com.bytedance.crash.o.i.a(r4, "killHistory");
        f7627a = r5;
        f7628b = com.bytedance.crash.o.i.a(r5, "kill_info");
        h = com.bytedance.crash.o.i.a(f7627a, "proc");
        g = com.bytedance.crash.o.i.a(h, com.bytedance.crash.o.b.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).replace(".", "_").replace(":", "-"));
        new File(g, Process.myPid() + "_" + i.f()).createNewFile();     // Catch: IOException -> L5 Throwable -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        r.b(e);
        return;
    }

    public static void a(final com.bytedance.crash.monitor.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (f7630d == false) goto L37;
    L25:
        th = move-exception;
        r.c("TerminateMonitor", "upload exception:" + th);     // Catch: Throwable -> L29
        Runnable r4 = new AnonymousClass2();
    L28:
        DefaultWorkThread.post(r4);
        return;
    L29:
        th = move-exception;
        DefaultWorkThread.post(new AnonymousClass2());
        throw th;
    L6:
        if (ad.g() == false) goto L8;
    L24:
        Runnable r5 = new AnonymousClass2();
    L13:
        DefaultWorkThread.post(r5);
        return;
    L8:
        if (com.bytedance.crash.o.b.b() == false) goto L24;
        if (k == false) goto L16;
        r5 = new AnonymousClass2();
        goto L13
    L16:
        k = true;     // Catch: Throwable -> L25
        final List<ApplicationExitInfo> r0 = e.a();     // Catch: Throwable -> L25
        if (r0 != null) goto L19;
    L23:
        r5 = new AnonymousClass2();
        goto L13
    L19:
        if (r0.size() == 0) goto L23;
        DefaultWorkThread.post(new AnonymousClass1(r0, r3));     // Catch: Throwable -> L25
        r4 = new AnonymousClass2();
        goto L28
    }

    private static void e() {
        new File(f7627a, "custom_data").listFiles(new AnonymousClass3());     // Catch: Throwable -> L4
        return;
    }

    private static boolean a(com.bytedance.crash.monitor.a r3, long r4, JSONObject r6, File r7) {
        JSONObject r5 = Header.a(r3, r4, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).b();     // Catch: Exception -> L8
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L8
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L8
        r9.put(r6);     // Catch: Exception -> L8
        r8.put("data", r9);     // Catch: Exception -> L8
        r8.put("header", r5);     // Catch: Exception -> L8
        if (f7629c == null) goto L6;
        JSONArray r10 = new JSONArray();     // Catch: Exception -> L8
        r10.put(f7629c);     // Catch: Exception -> L8
        r8.put("logcat", r10);     // Catch: Exception -> L8
    L6:
        return com.bytedance.crash.upload.b.a(o.a(com.bytedance.crash.config.f.h(), r5), r8.toString(), new File[]{r7});
    L8:
        return false;
    }

    private static void a(File r2, Map<String, String> r3, b r4, long r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        File r7 = com.bytedance.crash.tracker.b.a().a(r4.d(), r5);     // Catch: Throwable -> L31
        if (r7 != null) goto L7;
    L29:
        r6.put("has_process_track", "false");     // Catch: Throwable -> L31
        return;
    L7:
        if (r7.exists() == false) goto L29;
        File r8 = new File(r2, "process_track.txt");     // Catch: Throwable -> L31
        String r9 = null;
        j.b(r7, r8);     // Catch: Throwable -> L25
        r6.put("has_process_track", "true");     // Catch: Throwable -> L25
        BufferedReader r10 = new BufferedReader(new FileReader(r8));     // Catch: Throwable -> L25
    L37:
        String r11 = r10.readLine();     // Catch: Throwable -> L23
        if (r11 == null) goto L16;
        if (r11.contains("onResume") == false) goto L37;
        r9 = r11;
        goto L37
    L16:
        if (r9 == null) goto L22;
        String[] r12 = r9.split(" ", 3);     // Catch: Throwable -> L23
        if (r12.length <= 1) goto L22;
        String r13 = r12[1];     // Catch: Throwable -> L23
        int r14 = r13.indexOf(".onResume");     // Catch: Throwable -> L23
        if (r14 <= 0) goto L22;
        r6.put(DBHelper.BATTERY_COL_SCENE, r13.substring(0, r14));     // Catch: Throwable -> L23
    L22:
        k.a(r10);     // Catch: Throwable -> L31
        return;
    L23:
        Throwable th = th;
    L27:
        k.a(r10);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L25:
        th = move-exception;
        r10 = null;
        th = th;
    L31:
        th = move-exception;
        com.bytedance.crash.c.b.c("dumpActivityInfo", th);
    }

    private static void b(com.bytedance.crash.monitor.a r11, ApplicationExitInfo r12, boolean r13, boolean r14) {
        HashMap r1 = new HashMap();
        final b r2 = b.a(r12);
        boolean r3 = true;
        final long[] r4 = {0};
        new File(h, r2.d().replace(".", "_").replace(":", "-")).listFiles(new AnonymousClass4(r2, r4));     // Catch: Throwable -> L36
    L5:
        if (r4[0] != 0) goto L7;
        return;
    L7:
        String r6 = r2.a(r4[0]);
        r1.put("exit_reason", r2.a());
        r1.put("exit_sub_reason", r2.b());
        r1.put("exit_description", r2.h());
        r1.put("exit_status", String.valueOf(r2.c()));
        r1.put("exit_pss", c.a(r2.i()));
        r1.put("exit_rss", c.a(r2.j()));
        r1.put("importance", String.valueOf(r2.g()));
        r1.put("has_exit_info", "true");
        if (((String) ZeusTransformUtils.preCheckCast(r1.get("exit_reason"), String.class, "com.obric.aiagent.plugin")).equals("not obtained") == false) goto L10;
    L13:
        if (r3 == true) goto L42;
        JSONObject r5 = r2.a(r4[0], r6);
        File r7 = new File(f7627a, "custom_data");     // Catch: Throwable -> L33
        r7.mkdirs();     // Catch: Throwable -> L33
        File r8 = new File(r7, r2.e() + "_" + r2.f());     // Catch: Throwable -> L33
        if (r8.exists() == true) goto L22;
        r8.mkdirs();     // Catch: Throwable -> L33
    L22:
        a(r8, r1, r2, r4[0]);     // Catch: Throwable -> L33
        if (r14 == false) goto L25;
        a(r8, r1);     // Catch: Throwable -> L33
    L25:
        b(r8, r1);     // Catch: Throwable -> L33
        if (r13 == false) goto L28;
        a(r12, r1);     // Catch: Throwable -> L33
    L28:
        r2.a(r5, r1);     // Catch: Throwable -> L33
        boolean r15 = a(r11, r2.e(), r5, r8);     // Catch: Throwable -> L33
        if (r15 == false) goto L31;
        r.b("KillInfo ", "upload success:" + r15);     // Catch: Throwable -> L33
        com.bytedance.crash.o.i.c(r8);     // Catch: Throwable -> L33
    L31:
        com.bytedance.crash.o.i.c(r8);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        r.a("KillInfo:" + th);
        return;
    L42:
        IApmAgent r16 = (IApmAgent) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L37
        if (r16 == null) goto L44;
        r17.put("reason", r1.get("exit_reason"));     // Catch: Throwable -> L37
        r16.monitorEvent("app_exit", r17, null, null);     // Catch: Throwable -> L37
        return;
    L44:
        return;
    L45:
        return;
    L10:
        if (((String) ZeusTransformUtils.preCheckCast(r1.get("exit_reason"), String.class, "com.obric.aiagent.plugin")).equals("USER REQUESTED") == true) goto L13;
        r3 = false;
        goto L13
    }

    public static long a(String r0, long r1) {
        return Long.decode(r0).longValue();
    L4:
        return r1;
    }

    private static boolean a(File r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        l.a(r3, true);     // Catch: Throwable -> L11
        if (l.a(r3) == false) goto L17;
        String r6 = j.d(new File(r3, "logcat.txt"));     // Catch: Throwable -> L11
        f7629c = r6;     // Catch: Throwable -> L11
        if (r6.isEmpty() == false) goto L8;
        return false;
    L8:
        if (f7629c.length() <= 10) goto L19;
        r5.put("has_logcat", "true");     // Catch: Throwable -> L11
        return true;
    L19:
        return false;
    L17:
        return false;
    L11:
        th = move-exception;
        r.a("KillInfo:" + th);
        return false;
    }

    private static boolean b(File r7, Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        NativeBridge.a(r7.getAbsolutePath(), true);     // Catch: IOException -> L16
        File r0 = new File(r7, "os_memory.txt");     // Catch: IOException -> L16
        if (r0.exists() == true) goto L7;
    L14:
        r9.put("has_os_memory", "false");     // Catch: IOException -> L16
        return false;
    L7:
        if (r0.length() <= 10) goto L14;
        String r10 = j.d(r0);     // Catch: IOException -> L16
        if (r10 == null) goto L14;
        if (r10.contains("kB") == false) goto L14;
        r9.put("has_os_memory", "true");     // Catch: IOException -> L16
        return true;
    L16:
        e = move-exception;
        r.a("KillInfo:" + e);
        return false;
    }

    private static void a(ApplicationExitInfo r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.crash.alog.a.a(r6.getProcessName(), 0, r6.getTimestamp(), CrashType.NATIVE_CUSTOMIZE);     // Catch: Throwable -> L5
        r8.put("has_alog", "true");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r.a("KillInfo:" + th);
    }

    static void b() {
        if (g.exists() == true) goto L6;
        return;
    L6:
        if (l == false) goto L8;
        return;
    L8:
        l = true;
        File[] r0 = g.listFiles(new AnonymousClass5());
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.length <= 20) goto L18;
        Arrays.sort(r0, new AnonymousClass6());
        int r1 = 0;
    L14:
        if (r1 >= (r0.length - 20)) goto L19;
        j.a(r0[r1]);
        r1 = r1 + 1;
        goto L14
    L19:
        return;
    }
}
