package com.bytedance.crash.resource;

import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.s;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResourceMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    protected static boolean g = false;
    protected static boolean h = false;
    protected static boolean i = false;
    protected static boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.crash.resource.g.b f7684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.bytedance.crash.resource.a.b f7685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.bytedance.crash.resource.d.b f7686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.bytedance.crash.resource.b.b f7687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.bytedance.crash.resource.c.b f7688e;
    protected com.bytedance.crash.resource.e.b f;

    /* JADX INFO: renamed from: com.bytedance.crash.resource.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ResourceMonitor.java */
    private static class C0170a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7689a = null;

        static {
            f7689a = new a();
        }
    }

    static {
    }

    public a() {
    }

    public static void a(com.bytedance.crash.monitor.a r0) {
        com.bytedance.crash.resource.b.a.a(r0);
        com.bytedance.crash.resource.c.a.a(r0);
        com.bytedance.crash.resource.g.a.a(r0);
        com.bytedance.crash.resource.a.a.a(r0);
        com.bytedance.crash.resource.d.a.a(r0);
    }

    public static void a() {
        j.a(com.bytedance.crash.resource.f.b.d());     // Catch: Throwable -> L4
        j.a(com.bytedance.crash.resource.f.b.c());     // Catch: Throwable -> L4
        j.a(com.bytedance.crash.resource.f.b.e());     // Catch: Throwable -> L4
        j.a(com.bytedance.crash.resource.f.b.b());     // Catch: Throwable -> L4
        j.a(com.bytedance.crash.resource.f.b.f());     // Catch: Throwable -> L4
        j.a(com.bytedance.crash.resource.f.b.g());     // Catch: Throwable -> L4
        j.a(com.bytedance.crash.resource.f.b.h());     // Catch: Throwable -> L4
        return;
    }

    public static void a(JSONObject r1, JSONObject r2) {
        C0170a.f7689a.b(r1, r2);
    }

    public void b(JSONObject r11, JSONObject r12) {
        boolean r1 = false;
        if (r11.optInt("enable_native_heap_track") != 1) goto L5;
        boolean r0 = true;
    L7:
        if (r11.optInt("app_32_or_64") != 1) goto L9;
        boolean r3 = true;
    L11:
        if (r11.optInt("enable_gwp_asan") != 1) goto L13;
        boolean r4 = true;
    L15:
        if (r11.optInt("enable_mmap_monitor") != 1) goto L17;
        boolean r5 = true;
    L19:
        if (r11.optInt("enable_mprotect_monitor") != 1) goto L21;
        boolean r6 = true;
    L23:
        if (r11.optInt("enable_monitor_reference") != 1) goto L25;
        boolean r7 = true;
    L27:
        if (r12.optInt("enable_fd_track") != 1) goto L29;
        boolean r8 = true;
    L31:
        if (r11.optInt("enable_pthread_key_monitor") != 1) goto L33;
        boolean r9 = true;
    L34:
        if (r5 == true) goto L36;
        if (r6 == true) goto L36;
    L37:
        if (r9 == false) goto L39;
        b();
    L39:
        if (r0 == true) goto L41;
    L49:
        if (r4 == true) goto L51;
    L56:
        if (r1 == true) goto L58;
    L64:
        if (r8 == false) goto L71;
        if (g == true) goto L71;
        if (i == true) goto L71;
        j = true;
        a(r12);
    L71:
        if (i == true) goto L73;
    L76:
        if (r7 == false) goto L80;
        b(r11);
        return;
    L80:
        return;
    L73:
        if (g == true) goto L76;
        if (h == true) goto L76;
        return;
    L58:
        if (g == true) goto L64;
        if (h == true) goto L64;
        if (j == true) goto L64;
        i = true;
        a(r5, r6, r11);
        goto L64
    L51:
        if (g == true) goto L56;
        if (i == true) goto L56;
        if (r1 == true) goto L56;
        h = true;
        c(r11);
        goto L56
    L41:
        if (j == true) goto L49;
        if (h == true) goto L49;
        if (i == true) goto L49;
        g = true;
        if (NativeBridge.g() != r3) goto L49;
        d(r11);
    L36:
        r1 = true;
        goto L37
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L31
    L25:
        r7 = false;
        goto L27
    L21:
        r6 = false;
        goto L23
    L17:
        r5 = false;
        goto L19
    L13:
        r4 = false;
        goto L15
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    private void a(boolean r7, boolean r8, JSONObject r9) {
        if (r7 == false) goto L4;
        int r10 = 1;
    L5:
        if (r8 == false) goto L7;
        r10 = r10 | 2;
    L7:
        com.bytedance.crash.resource.g.b r11 = new com.bytedance.crash.resource.g.b(r10, r9.optJSONArray("mmap_water_config"), r9.optJSONArray("mmap_monitor_params"), r9.optJSONArray("mprotect_monitor_prots"), r9.optJSONArray("mmap_phy_config"));
        this.f7684a = r11;
        com.bytedance.crash.resource.g.a.a(r11);
        return;
    L4:
        r10 = 0;
        goto L5
    }

    private void a(JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        boolean r1 = true;
        if (r11.optInt("allow_loop_monitor") == 1) goto L8;
        r1 = false;
    L8:
        com.bytedance.crash.resource.a.b r12 = new com.bytedance.crash.resource.a.b(true, r1, r11.optInt("track_water_line"), r11.optInt("track_dump_line"), r11.optInt("track_sleep_time"), r11.optInt("backtrace_limit"));
        this.f7685b = r12;
        com.bytedance.crash.resource.a.a.a(r12);
    }

    private void b(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r5.optInt("ref_monitor_type");
        int r1 = r5.optInt("ref_monitor_bt_flag");
        JSONArray r6 = r5.optJSONArray("ref_monitor_limits");
        if (r6 != null) goto L7;
    L8:
        r6 = new JSONArray();
        r6.put(20000);
        r6.put(20000);
        r6.put(500);
    L9:
        com.bytedance.crash.resource.d.b r2 = new com.bytedance.crash.resource.d.b(r0, r6, r1);
        this.f7686c = r2;
        com.bytedance.crash.resource.d.a.a(r2);
        return;
    L7:
        if (r6.length() >= 3) goto L9;
        goto L8
    }

    private void c(JSONObject r2) {
        com.bytedance.crash.resource.b.b r0 = new com.bytedance.crash.resource.b.b(r2.optJSONArray("gwp_asan_set_init_param"));
        this.f7687d = r0;
        com.bytedance.crash.resource.b.a.a(r0);
    }

    public void b() {
        com.bytedance.crash.resource.e.b r0 = new com.bytedance.crash.resource.e.b();
        this.f = r0;
        com.bytedance.crash.resource.e.a.a(r0);
    }

    private void d(JSONObject r2) {
        com.bytedance.crash.resource.c.b r0 = new com.bytedance.crash.resource.c.b(r2.optJSONArray("native_heap_params"));
        this.f7688e = r0;
        com.bytedance.crash.resource.c.a.a(r0);
    }

    public static boolean a(JSONObject r2, File r3) {
        return b(r2, new File(r3, "ht_leak_tags.txt"));
    }

    public static boolean b(JSONObject r10, File r11) {
        if (r11.exists() == true) goto L23;
        return false;
    L23:
        s r0 = new s("MB");     // Catch: Throwable -> L19
        r0.a(new Long[]{0L, 1L, 128L, 256L, 384L, 512L, 768L, 1024L});     // Catch: Throwable -> L19
        String[] r12 = j.c(r11.getAbsolutePath()).split("\n");     // Catch: Throwable -> L19
        int r2 = r12.length;     // Catch: Throwable -> L19
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L18;
        String r6 = r12[r3];     // Catch: Throwable -> L19
        if (r6 == null) goto L17;
        if (r6.trim().isEmpty() == true) goto L17;
        String[] r7 = r6.split(":");     // Catch: Throwable -> L19
        if (r7.length != 2) goto L17;
        String r8 = r7[1].trim();     // Catch: Throwable -> L19
        r8 = r0.a(Long.parseLong(r8));     // Catch: NumberFormatException -> L20 Throwable -> L19
    L16:
        r10.put(r7[0].trim(), r8);     // Catch: Throwable -> L19
    L17:
        r3 = r3 + 1;
        goto L6
    L18:
        return true;
    L19:
        return false;
    }
}
