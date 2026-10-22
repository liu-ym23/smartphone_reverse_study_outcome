package com.bytedance.crash.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.e;
import com.bytedance.crash.config.f;
import com.bytedance.crash.config.h;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.k;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: CoredumpAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7106a = "none";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7107b = "0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f7108c = "disable";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f7109d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f7110e = null;
    private static String f = null;
    private static String g = null;
    private static boolean h = false;
    private static File i;
    private static File j;
    private static a k;

    static {
    }

    public static String a() {
        Long r0 = Long.valueOf(Long.parseLong(f7107b.trim()));     // Catch: Throwable -> L7
        if (r0.longValue() < 1048576) goto L6;
        return Long.valueOf(r0.longValue() / 1048576).toString() + "MB";
    L6:
        return r0.toString() + "KB";
    L7:
        return "0";
    }

    public static String b() {
        long r0 = Long.parseLong(f7107b.trim());     // Catch: Throwable -> L36
        if (r0 >= 1048576) goto L6;
        return "size < 1MB";
    L6:
        long r1 = r0 / 1048576;     // Catch: Throwable -> L36
        if (r1 > 50) goto L11;
        return "1~50MB";
    L11:
        if (r1 > 100) goto L15;
        return "51~100MB";
    L15:
        if (r1 > 200) goto L19;
        return "101~200MB";
    L19:
        if (r1 > 300) goto L23;
        return "201~300MB";
    L23:
        if (r1 > 400) goto L27;
        return "301~400MB";
    L27:
        if (r1 > 500) goto L31;
        return "401~500MB";
    L31:
        if (r1 > 1000) goto L34;
        return "501MB~1GB";
    L34:
        return "size > 1GB";
    L36:
        return "0";
    }

    public static String c() {
        return f7106a;
    }

    public static void d() {
        File r0 = i;
        if (r0 == null) goto L6;
        j.a(r0);
        return;
    }

    public static void a(a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        k = r1;
        r.b("NPTH_CORE", "updateConfig init");
        e();
    }

    public static void e() {
        if (h == false) goto L6;
        return;
    L6:
        if (g() == false) goto L15;
        h = true;     // Catch: Exception -> L12
        File r0 = e.b();     // Catch: Exception -> L12
        if (r0.exists() == true) goto L10;
        r0.mkdirs();     // Catch: Exception -> L12
    L10:
        NativeBridge.c(new File(r0, com.bytedance.crash.crash.b.b()).toString());     // Catch: Exception -> L12
        r.b("NPTH_COREDUMP", "Coredump Init ok");     // Catch: Exception -> L12
        return;
    L15:
        return;
    }

    private static boolean g() {
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        f7108c = "config init exception";
        return false;
    L3:
        if (h.g() == false) goto L6;
        a("1#all#all#null#lib#SIG#0#0#7#");     // Catch: Throwable -> L12
        return true;
    L6:
        a r0 = k;     // Catch: Throwable -> L12
        if (r0 == null) goto L14;
        if (r0.b() == false) goto L14;
        a(k.a());     // Catch: Throwable -> L12
        return true;
    }

    private static void a(String r3) {
        if (r3 != null) goto L14;
        return;
    L14:
        File r0 = new File(i.e(), "core.config");     // Catch: Throwable -> L11
        j = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
    L9:
        r.b("NPTH_COREDUMP", "Core Init enable");     // Catch: Throwable -> L11
        j.a(j, r3, false);     // Catch: Throwable -> L11
        return;
    L7:
        if (r0.exists() == true) goto L9;
        j.createNewFile();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean f() {
        if (i != null) goto L5;
    L23:
        return false;
    L5:
        if ("0".equals(f7107b) == true) goto L23;
        File[] r0 = i.listFiles();
        if (r0 != null) goto L10;
        return false;
    L10:
        int r2 = r0.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L23;
        File r4 = r0[r3];
        if (r4.getName().startsWith("core-") == false) goto L22;
        if (r4.length() <= 0) goto L22;
        if (Long.valueOf(Long.parseLong(f7107b.trim())).longValue() != r4.length()) goto L22;
        return true;
    L22:
        r3 = r3 + 1;
        goto L11
    }

    private static boolean a(com.bytedance.crash.monitor.a r5, File r6, JSONObject r7) {
    L23:
        th = move-exception;
        f7108c = "check coredump upload error";
        th.printStackTrace();
        r.a("corefile upload failed:" + th);
        com.bytedance.crash.c.b.a(th);
    L25:
        return true;
    L4:
        if (f7107b == null) goto L22;
        if (r5 == null) goto L22;
        if (r6.exists() == false) goto L22;
        String[] r8 = r6.getAbsolutePath().split("/");     // Catch: Throwable -> L23
        f7106a = r8[r8.length - 1];     // Catch: Throwable -> L23
        File r9 = new File(e.a(), "asdawd/" + f7106a);     // Catch: Throwable -> L23
        i = r9;     // Catch: Throwable -> L23
        if (r9.exists() == true) goto L15;
        l.b(r7, "coredump_delete", "core_dir_null");     // Catch: Throwable -> L23
        return false;
    L15:
        if (h.g() == false) goto L17;
        return true;
    L17:
        a r10 = k;     // Catch: Throwable -> L23
        if (r10 == null) goto L25;
        if (r10.c() == true) goto L25;
        f7108c = "config no init";     // Catch: Throwable -> L23
        l.b(r7, "coredump_delete", "config no init");     // Catch: Throwable -> L23
        j.a(i);     // Catch: Throwable -> L23
    L22:
        return false;
    }

    private static Map<String, String> a(File r7) {
        BufferedReader r0 = null;
        HashMap r1 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        File r2 = new File(r7, "tombstone.txt");
        if (r2.exists() == true) goto L8;
    L45:
        return null;
    L8:
        if (r2.length() == 0) goto L45;
        BufferedReader r8 = new BufferedReader(new FileReader(r2));     // Catch: Throwable -> L37
    L12:
        boolean r3 = false;
    L46:
        String r4 = r8.readLine();     // Catch: Throwable -> L35
        if (r4 == null) goto L34;
        if (r3 == false) goto L17;
        if (r4.startsWith("--- --- --- ") == true) goto L12;
        int r5 = r4.indexOf(58);     // Catch: Throwable -> L35
        if (r5 == (-1)) goto L46;
        String r6 = r4.substring(0, r5);     // Catch: Throwable -> L35
        String r9 = r4.substring(r5 + 1).trim();     // Catch: Throwable -> L35
        if (r6.isEmpty() == true) goto L46;
        if (r9.isEmpty() == true) goto L46;
        if (r1 != null) goto L32;
        r1 = new HashMap();     // Catch: Throwable -> L35
    L32:
        r1.put(r6, r9);     // Catch: Throwable -> L35
        goto L46
    L17:
        if (r4.equals("metrics:") == false) goto L46;
        r3 = true;
        goto L46
    L34:
        k.a(r8);
        return r1;
    L35:
        th = th;
        HashMap r10 = r1;
        r0 = r8;
        HashMap r11 = r10;
    L48:
        r.a("Failed to read metrics from tombstone." + th);     // Catch: Throwable -> L42
        k.a(r0);
        return r11;
    L42:
        th = move-exception;
        k.a(r0);
        throw th;
    L37:
        th = th;
        r11 = null;
        goto L48
    }

    private static String b(String r4) {
        long r0 = Long.parseLong(r4);     // Catch: Throwable -> L68
        if (r0 > 50) goto L7;
        return "0~50ms";
    L7:
        if (r0 > 100) goto L11;
        return "50~100ms";
    L11:
        if (r0 > 150) goto L15;
        return "100~150ms";
    L15:
        if (r0 > 200) goto L19;
        return "150~200ms";
    L19:
        if (r0 > 300) goto L23;
        return "200~300ms";
    L23:
        if (r0 > 400) goto L27;
        return "300~400ms";
    L27:
        if (r0 > 500) goto L31;
        return "400~500ms";
    L31:
        if (r0 > 700) goto L35;
        return "500~700ms";
    L35:
        if (r0 > 1000) goto L39;
        return "700~1000ms";
    L39:
        if (r0 > 1500) goto L43;
        return "1000~1500ms";
    L43:
        if (r0 > 2000) goto L47;
        return "1500~2000ms";
    L47:
        if (r0 > WsConstants.EXIT_DELAY_TIME) goto L51;
        return "2000~3000ms";
    L51:
        if (r0 > 4000) goto L55;
        return "3000~4000ms";
    L55:
        if (r0 > 5000) goto L59;
        return "4000~5000ms";
    L59:
        if (r0 > 7000) goto L63;
        return "5000~7000ms";
    L63:
        if (r0 > 10000) goto L66;
        return "7000~10000ms";
    L66:
        return "> 10000ms";
    L68:
        return OProtocolTextEffectTextView.EffectNameNone;
    }

    private static String c(String r4) {
        long r0 = Long.parseLong(r4);     // Catch: Throwable -> L50
        if (r0 <= 200) goto L7;
        return "(200 - MAX)";
    L7:
        if (r0 <= 150) goto L11;
        return "(150 - 200]";
    L11:
        if (r0 <= 100) goto L15;
        return "(100 - 150]";
    L15:
        if (r0 <= 70) goto L19;
        return "(70 - 100]";
    L19:
        if (r0 <= 50) goto L23;
        return "(50 - 70]";
    L23:
        if (r0 <= 40) goto L27;
        return "(40 - 50]";
    L27:
        if (r0 <= 30) goto L31;
        return "(30 - 40]";
    L31:
        if (r0 <= 20) goto L35;
        return "(20 - 30]";
    L35:
        if (r0 <= 15) goto L39;
        return "(15 - 20]";
    L39:
        if (r0 <= 10) goto L43;
        return "(10 - 15]";
    L43:
        if (r0 <= 5) goto L47;
        return "(5 - 10]";
    L47:
        if (r0 <= 1) goto L54;
        return "(1 - 5]";
    L54:
        return r4;
    L50:
        return OProtocolTextEffectTextView.EffectNameNone;
    }

    private static String d(String r4) {
        long r0 = Long.parseLong(r4);     // Catch: Throwable -> L34
        if (r0 <= 5000) goto L7;
        return "(5000 - MAX)";
    L7:
        if (r0 <= 4000) goto L11;
        return "(4000 - 5000]";
    L11:
        if (r0 <= WsConstants.EXIT_DELAY_TIME) goto L15;
        return "(3000 - 4000]";
    L15:
        if (r0 <= 2000) goto L19;
        return "(2000 - 3000]";
    L19:
        if (r0 <= 1500) goto L23;
        return "(1500 - 2000]";
    L23:
        if (r0 <= 1000) goto L27;
        return "(1000 - 1500]";
    L27:
        if (r0 <= 500) goto L31;
        return "(500 - 1000]";
    L31:
        if (r0 <= 1) goto L38;
        return "(1 - 500]";
    L38:
        return r4;
    L34:
        return OProtocolTextEffectTextView.EffectNameNone;
    }

    private static String a(Map<String, String> r2, String r3, String r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(r3), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L9;
        if (r6.isEmpty() == true) goto L9;
        return r6;
    L9:
        return r4;
    }

    private static String a(Map<String, String> r2, String r3) {
        return a((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"), r3, OProtocolTextEffectTextView.EffectNameNone);
    }

    private static void a(JSONObject r2, Map<String, String> r3, String r4) {
        l.b(r2, r4, a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), r4));
    }

    private static void a(JSONObject r4, Map<String, String> r5, String[] r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = r6[r1];
        l.b(r4, r2, a(r7, r2));
        r1 = r1 + 1;
        goto L3
    }

    public static boolean a(com.bytedance.crash.monitor.a r18, CrashSummary r19, File r20, JSONObject r21) {
        if (r19.getCrashType() == CrashType.NATIVE) goto L5;
        return false;
    L5:
        Map<String, String> r5 = a(r20);
        a(r21, r5, new String[]{"unwind_return_code", "unwind_to_entrypoint", "unwind_last_name", "dumper_has_stack", "dumper_has_dex", "dump_crash_thread_done", "tombstone_done", "dumper_warning_code", "dumper_all_done", "has_protector"});
        l.b(r21, "has_dumper_metrics", true);
        String r9 = a(r5, "crash_frames_count");
        l.b(r21, "crash_frames_count", r9);
        l.b(r21, "crash_frames_count_range", c(r9));
        String r10 = a(r5, "all_frames_count");
        l.b(r21, "all_frames_count", r10);
        l.b(r21, "all_frames_count_range", d(r10));
        String r11 = a(r5, "tombstone_time");
        l.b(r21, "tombstone_time", r11);
        l.b(r21, "tombstone_time_range", b(r11));
        String r12 = a(r5, "dumper_total_time");
        l.b(r21, "dumper_total_time", r12);
        l.b(r21, "dumper_total_time_range", b(r12));
        String r13 = a(r5, "minidump_done");
        File r14 = new File(r20, "minidump");
        a(r21, r5, "minidump_enabled");
        l.b(r21, "minidump_done", r13);
        l.b(r21, "has_minidump", String.valueOf(r14.exists()));
        String r15 = a(r5, "minidump_time");
        l.b(r21, "minidump_time", r15);
        l.b(r21, "minidump_time_range", b(r15));
        a(r21, r5, "coredump_enabled");
        f7107b = a(r5, "coredump_size", "0");
        f7109d = a(r5, "coredump_async_mode");
        f7110e = a(r5, "coredump_return_code");
        g = a(r5, "coredump_time");
    L12:
        f = OProtocolTextEffectTextView.EffectNameNone;
    L14:
        if (a(r18, r20, r21) == true) goto L21;
        if (r21.length() <= 0) goto L18;
        l.b(r21, "coredump_miss", true);
    L18:
        l.b(r21, "may_have_core_dump", "false");
        return false;
    L21:
        if (f() == false) goto L69;
        File r16 = null;
        if ("wifi".equals(LocaleInfo.getNetworkAccessType()) == true) goto L76;
        String r17 = "coredump_delete";
        String r22 = "coredump_miss";
        f7108c = "network is not wifi";     // Catch: Throwable -> L57
        boolean r7 = false;
    L93:
        String r1 = r17;
        l.b(r21, r1, f7108c);     // Catch: Throwable -> L53
        if (r16 == null) goto L70;
    L52:
        j.a(r16);
    L70:
        if (r7 == false) goto L72;
    L75:
        return r7;
    L72:
        if (r21.length() <= 0) goto L74;
        l.b(r21, r22, true);
    L74:
        l.b(r21, "may_have_core_dump", "false");
    L53:
        th = th;
    L90:
        l.b(r21, r1, "execption");     // Catch: Throwable -> L65
        th.printStackTrace();     // Catch: Throwable -> L65
        r.a("corefile upload failed:" + th);     // Catch: Throwable -> L65
        com.bytedance.crash.c.b.a(th);     // Catch: Throwable -> L65
        if (r16 == null) goto L70;
    L65:
        th = move-exception;
        if (r16 == null) goto L68;
        j.a(r16);
    L68:
        throw th;
    L55:
        th = th;
    L56:
        r1 = r17;
    L57:
        th = th;
    L58:
        r1 = r17;
    L61:
        r7 = false;
        goto L90
    L76:
        File r110 = new File(e.a(), "asdawd/coredump.zip");     // Catch: Throwable -> L43
        j.b(i.getAbsolutePath(), r110.getAbsolutePath());     // Catch: Throwable -> L28
    L30:
        Header r0 = r19.assemblyCrashHeader(r18);     // Catch: Throwable -> L41
        r17 = "coredump_delete";
        r22 = "coredump_miss";
        boolean r2 = com.bytedance.crash.upload.b.a("coredump", f.k(), r0.b().toString(), new JSONObject().put("event_type", "raphael_file").put(DBHelper.COL_TIME, System.currentTimeMillis()).put("uuid", f7106a).toString(), r110);     // Catch: Throwable -> L39
        if (r2 == false) goto L35;
        f7108c = "corefile upload";     // Catch: Throwable -> L37
        l.b(r21, "may_have_core_dump", true);     // Catch: Throwable -> L37
        l.b(r21, "coredump_no_upload", "false");     // Catch: Throwable -> L37
        l.b(r21, "coredump_real_size", a());     // Catch: Throwable -> L37
        l.b(r21, "coredump_size_range", b());     // Catch: Throwable -> L37
        l.b(r21, "coredump_async_mode", f7109d);     // Catch: Throwable -> L37
        l.b(r21, "coredump_return_code", f7110e);     // Catch: Throwable -> L37
        l.b(r21, "coredump_done", f);     // Catch: Throwable -> L37
        l.b(r21, "coredump_time", g);     // Catch: Throwable -> L37
        l.b(r21, "coredump_time_range", b(g));     // Catch: Throwable -> L37
        r.b("corefile upload");     // Catch: Throwable -> L37
    L36:
        r7 = r2;
        r16 = r110;
        goto L93
    L35:
        f7108c = "corefile upload exception";     // Catch: Throwable -> L37
    L37:
        th = th;
        r7 = r2;
        r16 = r110;
    L39:
        th = th;
        r16 = r110;
        goto L58
    L28:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);     // Catch: Throwable -> L41
    L41:
        th = th;
        r22 = "coredump_miss";
        r1 = "coredump_delete";
        r16 = r110;
    L43:
        th = th;
        r22 = "coredump_miss";
        r1 = "coredump_delete";
    L59:
        th = th;
        r1 = "coredump_delete";
        r22 = "coredump_miss";
        goto L61
    L69:
        r22 = "coredump_miss";
        r7 = false;
        goto L70
    L7:
        if (Long.parseLong(f7110e) != 0) goto L9;
        boolean r6 = true;
    L10:
        f = String.valueOf(r6);     // Catch: Throwable -> L12
        goto L14
    L9:
        r6 = false;
        goto L10
    }
}
