package com.bytedance.crash.monitor;

import android.os.Build;
import com.bytedance.crash.ah;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.upload.k;
import com.bytedance.crash.upload.m;
import com.bytedance.crash.upload.n;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppMonitorConfigService.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends e {
    private static boolean g = false;
    private static JSONObject h = null;
    private static JSONArray i = null;
    private static boolean j = false;
    private static boolean k = true;
    private static boolean l = true;
    private static boolean m = true;
    private static boolean n = true;
    private static boolean o = true;
    private static boolean p = false;
    private static boolean q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.crash.a.a f7572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected m f7573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.bytedance.crash.k.b f7574c;

    static {
    }

    public static boolean g() {
        return true;
    }

    public b(d r1) {
        super(r1);
    }

    public com.bytedance.crash.a.a b() {
        return this.f7572a;
    }

    public m c() {
        return this.f7573b;
    }

    public com.bytedance.crash.k.b d() {
        return this.f7574c;
    }

    @Override // com.bytedance.crash.monitor.e, com.bytedance.crash.config.b
    public void a(JSONObject r6) {
        super.a(r6);
        JSONObject r0 = o(r6);
        h = p(r6);
        i = r0.optJSONArray("gwp_asan_set_init_param");
        r(r6);
        s(r6);
        if (r0 == null) goto L59;
        boolean r3 = true;
        if (r0.optInt("enable_upload_custom_java_crash") != 1) goto L7;
        boolean r1 = true;
    L8:
        com.bytedance.crash.f.c(r1);
        if (r0.optInt("enable_dump_history_message_java") != 1) goto L11;
        boolean r2 = true;
    L12:
        com.bytedance.crash.crash.d.c(r2);
        if (r0.optInt("enable_dump_history_message_native") != 1) goto L15;
        boolean r4 = true;
    L16:
        com.bytedance.crash.crash.f.a(r4);
        if (r0.optInt("enable_dump_view_tree_java") != 1) goto L19;
        boolean r5 = true;
    L20:
        com.bytedance.crash.crash.d.b(r5);
        if (r0.optInt("enable_dump_view_tree_native") != 1) goto L23;
        boolean r7 = true;
    L24:
        com.bytedance.crash.crash.f.b(r7);
        if (r0.optInt("enable_dump_view_tree_anr") != 1) goto L27;
        boolean r8 = true;
    L28:
        com.bytedance.crash.anr.b.a(r8);
        t(r0);
        r0.optInt("disable_looper_monitor");
        if (r0.optInt("enable_npth_looper_monitor") != 1) goto L31;
        boolean r9 = true;
    L33:
        if (r0.optInt("disable_dump_trace_try_catch") != 1) goto L35;
        boolean r10 = true;
    L36:
        if (r9 == false) goto L38;
        com.bytedance.crash.g.d.a().b();
    L38:
        h(r0);
        n(r0);
        if (r0.optInt("SLI_exception") != 1) goto L41;
        boolean r11 = true;
    L42:
        p = r11;
        if (r0.optInt("scene_exception") != 1) goto L45;
        boolean r12 = true;
    L46:
        q = r12;
        if (r0.optInt("enable_profiler_java_lock_monitor") != 1) goto L49;
        boolean r13 = true;
    L50:
        com.bytedance.crash.anr.f.a(r13);
        if (r0.optInt("disable_anr_profiler") == 1) goto L54;
        r3 = false;
    L54:
        if (r3 == true) goto L56;
        r3 = b(r0.optJSONArray("disable_api_level_profiler"));
    L56:
        a(r3);
        if (r10 == false) goto L59;
        NativeBridge.c(false);
        goto L59
    L49:
        r13 = false;
        goto L50
    L45:
        r12 = false;
        goto L46
    L41:
        r11 = false;
        goto L42
    L35:
        r10 = false;
        goto L36
    L31:
        r9 = false;
        goto L33
    L27:
        r8 = false;
        goto L28
    L23:
        r7 = false;
        goto L24
    L19:
        r5 = false;
        goto L20
    L15:
        r4 = false;
        goto L16
    L11:
        r2 = false;
        goto L12
    L7:
        r1 = false;
    L59:
        com.bytedance.crash.j.b.b(q(r6));
    }

    public void a(boolean r3) {
        File r2 = new File(com.bytedance.crash.i.e(), "anr_profiler.config");
        j.a(r2, String.valueOf(r3), false);     // Catch: Throwable -> L5
        return;
    }

    public static boolean e() {
        return "true".equals(j.d(new File(com.bytedance.crash.i.e(), "anr_profiler.config")));
    L4:
        return false;
    }

    public void e(JSONObject r1) {
        int r0 = r1.optInt("disable_network_disaster");
        boolean r2 = true;
        if (r0 == 1) goto L6;
        r2 = false;
    L6:
        k.a(r2);
    }

    public void f(JSONObject r6) {
        boolean r1 = false;
        if (r6.optInt("enable_coredump") != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (r6.optInt("upload_core_dump") != 1) goto L10;
        boolean r3 = true;
    L12:
        if (r6.optInt("enable_async_coredump") != 1) goto L14;
        r1 = true;
    L14:
        this.f7572a = new com.bytedance.crash.a.a(r6.optJSONArray("enable_coredump_config"), r0, r3, r1);
        com.bytedance.crash.a.b.a(b());
        return;
    L10:
        r3 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public void g(JSONObject r3) {
        int r2 = r3.optInt("reg_memory_level");
        if (r2 != 0) goto L11;
        return;
    L11:
        File r4 = new File(com.bytedance.crash.i.e(), "tomb.config");     // Catch: Throwable -> L10
        if (r4.exists() == true) goto L8;
        r4.createNewFile();     // Catch: Throwable -> L10
    L8:
        j.a(r4, "V001\n" + r2, false);     // Catch: Throwable -> L10
        return;
    }

    public void h(JSONObject r2) {
        i(r2);
        m(r2);
        if (b(r2.optJSONArray("enable_api_level")) == true) goto L5;
    L7:
        g(r2);
        j(r2);
        k(r2);
        l(r2);
        e(r2);
        d(r2);
        n.a(c());
        return;
    L5:
        if (a(r2.optJSONArray("enable_device_brand")) == false) goto L7;
        f(r2);
        com.bytedance.crash.resource.a.a(r2, h);
        goto L7
    }

    public static JSONArray f() {
        return i;
    }

    public void d(JSONObject r9) {
        r.b("NPTH_CFG", "SimpleSettings:" + r9);
        this.f7573b = new m(r9.optInt("crash_limit_issue"), r9.optInt("crash_limit_all"), r9.optInt("crash_limit_exception"), r9.optInt("crash_limit_exception_md5"), r9.optInt("crash_limit_exception_stack"));
    }

    public void i(JSONObject r4) {
        boolean r0 = false;
        if (r4.optInt("enable_kill_history_err") != 1) goto L5;
        boolean r3 = true;
    L7:
        if (r4.optInt("enable_kill_history_fg") != 1) goto L9;
        r0 = true;
    L9:
        if (r3 == true) goto L13;
        if (r0 == true) goto L13;
        if (ah.k() == true) goto L13;
        return;
    L13:
        com.bytedance.crash.n.g.a();
        com.bytedance.crash.n.g.a(r3, r0);
        com.bytedance.crash.n.g.a(h.a());
        return;
    L5:
        r3 = false;
        goto L7
    }

    public void j(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r5.optInt("repair_type");
        int r1 = r5.optInt("repair_delayed_time");
        boolean r3 = true;
        if (r5.optInt("enable_debug_repair") == 1) goto L8;
        r3 = false;
    L8:
        this.f7574c = new com.bytedance.crash.k.b(r0, r1, r3, r5.optJSONArray("repair_portrait"));
        com.bytedance.crash.k.a.a(d());
    }

    public static boolean a(JSONArray r5) {
        if (r5 != null) goto L28;
        return false;
    L28:
    L25:
        th = move-exception;
        th.printStackTrace();
    L27:
        return false;
    L6:
        if (r5.toString().contains(OProtocolTextEffectTextView.EffectNameNone) == false) goto L8;
    L24:
        return false;
    L8:
        if (Build.BRAND.isEmpty() == true) goto L24;
        if (Build.BRAND.contains("ubia") == true) goto L24;
        if (r5.toString().contains("all") == false) goto L16;
        return true;
    L16:
        if (r5.length() <= 0) goto L27;
        int r1 = 0;
    L19:
        if (r1 >= r5.length()) goto L27;
        if (Build.BRAND.equals(r5.optString(r1)) == true) goto L22;
        r1 = r1 + 1;
        goto L19
    L22:
        return true;
    }

    public static boolean b(JSONArray r5) {
        if (r5 != null) goto L23;
        return false;
    L23:
    L20:
        th = move-exception;
        th.printStackTrace();
    L22:
        return false;
    L6:
        if (r5.toString().contains(OProtocolTextEffectTextView.EffectNameNone) == false) goto L9;
        return false;
    L9:
        if (r5.toString().contains("all") == false) goto L12;
        return true;
    L12:
        if (r5.length() <= 0) goto L22;
        int r1 = 0;
    L15:
        if (r1 >= r5.length()) goto L22;
        if (Build.VERSION.SDK_INT == Integer.parseInt(r5.optString(r1))) goto L18;
        r1 = r1 + 1;
        goto L15
    L18:
        return true;
    }

    public void k(JSONObject r3) {
        if (r3.optInt("disable_crash_with_custom_files") != 1) goto L5;
        boolean r2 = true;
    L6:
        com.bytedance.crash.dumper.f.a(!r2, r3.optInt("crash_file_size_limit"));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void l(JSONObject r1) {
        int r0 = r1.optInt("enable_hprof_all_java_crash");
        boolean r2 = true;
        if (r0 == 1) goto L6;
        r2 = false;
    L6:
        com.bytedance.crash.crash.d.a(r2);
    }

    public static void m(JSONObject r4) {
        if (r4.optInt("enable_setpriority_monitor") != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L16;
        JSONArray r5 = r4.optJSONArray("setpriority_params");     // Catch: Throwable -> L13
        NativeBridge.q(com.bytedance.crash.o.i.a(com.bytedance.crash.config.e.d(), com.bytedance.crash.crash.b.b()).toString());     // Catch: Throwable -> L13
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.length() <= 0) goto L18;
        NativeBridge.a(r5.optBoolean(0), r5.optBoolean(1), r5.optInt(2));     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L16:
        return;
    L5:
        r0 = false;
    }

    private static JSONObject o(JSONObject r1) {
        JSONObject r2 = r1.optJSONObject("custom_event_settings");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.optJSONObject("npth_simple_setting");
    }

    private static JSONObject p(JSONObject r1) {
        JSONObject r2 = r1.optJSONObject("custom_event_settings");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.optJSONObject("fd_track");
    }

    private static JSONObject q(JSONObject r1) {
        JSONObject r2 = r1.optJSONObject("exception_modules");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.optJSONObject("protector");
    }

    public void n(JSONObject r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        int r0 = r1.optInt("enable_upload_bg_anr");
        boolean r2 = true;
        if (r0 == 1) goto L8;
        r2 = false;
    L8:
        com.bytedance.crash.anr.e.a(r2);
    }

    public static void b(boolean r0) {
        j = r0;
    }

    private void r(JSONObject r4) {
        if (j == true) goto L6;
        com.bytedance.crash.runtime.a.a(l.b(r4, new String[]{"custom_event_settings", "npth_simple_setting", "crash_upload_domain"}), l.a(r4, new String[]{"custom_event_settings", "npth_simple_setting", "crash_upload_domain_list"}));
        return;
    }

    private void s(JSONObject r8) {
        JSONObject r7 = r8.optJSONObject("exception_modules");
        if (r7 != null) goto L5;
        return;
    L5:
        JSONObject r9 = r7.optJSONObject("biz_exception");
        if (r9 != null) goto L8;
        return;
    L8:
        boolean r0 = false;
        int r10 = r9.optInt("enable_upload", 0);
        HashSet r1 = new HashSet();
        JSONObject r11 = r9.optJSONObject("allow_log_type");
        if (r11 == null) goto L16;
        Iterator<String> r3 = r11.keys();
    L12:
        if (r3.hasNext() == false) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (r11.optInt(r4) != 1) goto L12;
        r1.add(r4);
    L16:
        com.bytedance.crash.d.c r12 = com.bytedance.crash.d.c.a();
        if (r10 != 1) goto L19;
        r0 = true;
    L19:
        r12.a(new com.bytedance.crash.d.b(r0, r1));
    }

    private static void t(JSONObject r3) {
        if (r3 == null) goto L24;
        boolean r1 = false;
        if (r3.optInt("enable_anrinfo_report") != 1) goto L6;
        boolean r0 = true;
    L7:
        l = r0;
        if (r3.optInt("enable_user_custom_data") != 1) goto L10;
        boolean r2 = true;
    L11:
        k = r2;
        if (r3.optInt("enable_logcat_report") != 1) goto L14;
        boolean r4 = true;
    L15:
        m = r4;
        if (r3.optInt("enable_native_info") != 1) goto L18;
        boolean r5 = true;
    L19:
        n = r5;
        if (r3.optInt("enable_dump_message") != 1) goto L22;
        r1 = true;
    L22:
        o = r1;
        return;
    L18:
        r5 = false;
        goto L19
    L14:
        r4 = false;
        goto L15
    L10:
        r2 = false;
        goto L11
    L6:
        r0 = false;
        goto L7
    }
}
