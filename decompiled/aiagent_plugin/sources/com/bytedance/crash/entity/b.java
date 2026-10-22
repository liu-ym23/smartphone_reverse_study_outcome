package com.bytedance.crash.entity;

import android.text.TextUtils;
import com.bytedance.crash.ag;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.g;
import com.bytedance.crash.dumper.m;
import com.bytedance.crash.dumper.o;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.s;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static String a(long r2) {
        if (r2 >= 0) goto L7;
        return "( - 0s)";
    L7:
        if (r2 >= 60000) goto L11;
        return "(0s - 1m)";
    L11:
        if (r2 >= 600000) goto L15;
        return "[1m - 10m)";
    L15:
        if (r2 >= DownloadConstants.HOUR) goto L19;
        return "[10m - 1h)";
    L19:
        if (r2 >= 10800000) goto L23;
        return "[1h - 3h)";
    L23:
        if (r2 >= 43200000) goto L27;
        return "[3h - 12h)";
    L27:
        if (r2 >= 86400000) goto L31;
        return "[12h - 1d)";
    L31:
        if (r2 >= 259200000) goto L35;
        return "[1d - 3d)";
    L35:
        if (r2 >= 604800000) goto L39;
        return "[3d - 7d)";
    L39:
        if (r2 >= 1209600000) goto L43;
        return "[7d - 14d)";
    L43:
        if (r2 >= 2592000000L) goto L46;
        return "[14d - 30d)";
    L46:
        return "[30d - )";
    }

    private static String a(long r0, long r2) {
        float r3 = r2;
        float r1 = r0;
        if (r3 <= (0.95f * r1)) goto L7;
        return "(95% - 100%]";
    L7:
        if (r3 <= (0.9f * r1)) goto L11;
        return "(90% - 95%]";
    L11:
        if (r3 <= (0.8f * r1)) goto L15;
        return "(80% - 90%]";
    L15:
        if (r3 <= (0.7f * r1)) goto L19;
        return "(70% - 80%]";
    L19:
        if (r3 <= (0.6f * r1)) goto L23;
        return "(60% - 70%]";
    L23:
        if (r3 <= (r1 * 0.5f)) goto L26;
        return "(50% - 60%]";
    L26:
        return "(0% - 50%]";
    }

    private static boolean a(File r2, String r3, int r4) {
        File r0 = new File(r2, r3);
        if (r0.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.length() <= r4) goto L7;
        return true;
    }

    public static void a(JSONObject r4, JSONObject r5, File r6) {
        JSONObject r0 = l.a(r5, "filters");
        g.b(r5, r6);
        g.a(r5, r6);
        l.b(r0, "has_dump", true);
        l.b(r0, "is_root", Boolean.valueOf(com.bytedance.crash.general.a.c()));
        l.b(r0, "alog_inited", Boolean.valueOf(com.bytedance.crash.alog.a.b()));
        l.b(r0, "sdk_version", com.bytedance.crash.config.g.f7298a);
        l.b(r0, "crash_thread_name", r5.optString("crash_thread_name", SensitiveType.UNKNOWN));
        l.b(r0, "is_64_runtime", Boolean.valueOf(NativeBridge.g()));
        l.b(r0, "is_hm_os", r4.optString("is_hm_os"));
        l.b(r0, "version_type", r4.optString("version_type"));
        l.b(r0, RomInfo.KEY_ROM_KERNEL_VERSION, r4.optString(RomInfo.KEY_ROM_KERNEL_VERSION));
        l.b(r0, "app_version_exact", r4.optString("app_version_exact"));
        l.b(r0, "crash_md5", r5.optString("crash_md5"));
        l.b(r0, HardwareInfo.KEY_HW_CPU_MODEL, r4.optString(HardwareInfo.KEY_HW_CPU_MODEL));
        l.b(r0, HardwareInfo.KEY_HW_CPU_HARDWARE, r4.optString(HardwareInfo.KEY_HW_CPU_HARDWARE));
        l.b(r0, HardwareInfo.KEY_HW_RAM_SIZE, r4.optString(HardwareInfo.KEY_HW_RAM_SIZE));
        l.b(r0, "last_resume_activity", ActivityLifecycle.c(r5));
        String r1 = NativeBridge.i(r6.getAbsolutePath());
        if (r1 == null) goto L5;
        l.b(r0, "abort_msg", r1);
    L5:
        JSONObject r2 = r5.optJSONObject(Scraps.STORAGE);
        if (r2 == null) goto L8;
        l.b(r0, Scraps.INNER_TOTAL, r2.optString(Scraps.INNER_TOTAL));
        l.b(r0, Scraps.INNER_FREE, r2.optString(Scraps.INNER_FREE));
    L8:
        String r3 = r4.optString(HardwareInfo.KEY_HW_CPU_ABI);
        if (TextUtils.isEmpty(r3) == true) goto L11;
        boolean r7 = r3.contains("64");
        l.b(r0, "is_x86_devices", Boolean.valueOf(r3.contains("86")));
        l.b(r0, "is_64_devices", Boolean.valueOf(r7));
        a(r0, r5, r6, r7);
    L11:
        a(r0, r4, r5);
        com.bytedance.crash.o.c.a(r0);
        c(r0, r6);
        d(r0, r6);
        e(r0, r6);
        a(r0, r6);
        f(r0, r6);
        g(r0, r6);
        d(r0, r5);
        e(r0, r5);
        com.bytedance.crash.resource.a.a(r0, r6);
        c(r0, r5);
        b(r0, r4, r5);
        b(r0, r5);
    }

    private static void a(JSONObject r10, JSONObject r11, JSONObject r12) {
        long r0 = r12.optLong("crash_time");
        long r2 = r12.optLong("app_start_time");
        if (r0 != 0) goto L5;
    L7:
        long r6 = r11.optLong("last_update_time");
        if (r6 != 0) goto L10;
        return;
    L10:
        String r8 = "true";
        if (r2 != 0) goto L13;
    L17:
        long r3 = com.bytedance.crash.general.a.a(0);
        if (r3 != 0) goto L21;
        return;
    L21:
        if (r6 != r3) goto L23;
        String r4 = "true";
    L24:
        l.b(r10, "crash_same_upload", r4);
        if (r6 == r3) goto L35;
        if (r0 == 0) goto L36;
        long r13 = com.bytedance.crash.general.a.a(r0);
        if (r13 != 0) goto L30;
        return;
    L30:
        if (r6 != r13) goto L33;
        r8 = "false";
    L33:
        l.b(r10, "crash_when_update", r8);
        return;
    L36:
        return;
    L35:
        return;
    L23:
        r4 = "false";
        goto L24
    L13:
        if (r2 <= r6) goto L15;
        String r14 = "true";
    L16:
        l.b(r10, "valid_app_info", r14);
        goto L17
    L15:
        r14 = "false";
        goto L16
    L5:
        if (r2 == 0) goto L7;
        l.b(r10, "use_time", Long.valueOf((r0 - r2) / 1000));
        goto L7
    }

    private static void b(JSONObject r5, JSONObject r6) {
        String r0 = r6.optString("process_name");
        long r1 = r6.optLong("app_start_time");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        if (r1 == 0) goto L9;
        ag.a(r5, r1, r0);
        return;
    }

    private static void b(JSONObject r4, JSONObject r5, JSONObject r6) {
        long r0 = r5.optLong("last_update_time");
        long r7 = r6.optLong("crash_time");
        if (r0 <= 0) goto L6;
        l.b(r4, "crash_since_updated", a(r7 - r0));
        return;
    }

    private static void c(JSONObject r6, JSONObject r7) {
        long r0 = r7.optLong("crash_time");
        long r2 = System.currentTimeMillis();
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r2 <= r0) goto L9;
        l.b(r6, "crash_length", a(r2 - r0));
        return;
    }

    private static void d(JSONObject r1, JSONObject r2) {
        l.b(r1, "has_logcat", Boolean.valueOf(!l.a(r2.optJSONArray("logcat"))));
    }

    private static void a(JSONObject r5, File r6) {
        l.b(r5, "has_tombstone_file", Boolean.valueOf(a(r6, "tombstone.txt", 10)));
        l.b(r5, "has_dlog_file", Boolean.valueOf(a(r6, "dlog.txt", 10)));
        l.b(r5, "has_logcat_file", Boolean.valueOf(a(r6, "logcat.txt", 512)));
        l.b(r5, "has_logcat_file_os", Boolean.valueOf(a(r6, "logcat_os.txt", 512)));
        l.b(r5, "has_malloc_file", Boolean.valueOf(a(r6, "malloc.txt", 64)));
        l.b(r5, "has_meminfo_file", Boolean.valueOf(a(r6, "meminfo.txt", 64)));
        l.b(r5, "has_maps_file", Boolean.valueOf(a(r6, "maps.txt", 1024)));
        l.b(r5, "has_smaps_file", Boolean.valueOf(a(r6, "smaps.txt", 1024)));
        l.b(r5, "has_pthreads_file", Boolean.valueOf(a(r6, "pthreads.txt", 64)));
        l.b(r5, "has_threads_file", Boolean.valueOf(a(r6, "threads.txt", 64)));
        l.b(r5, "has_fds_file", Boolean.valueOf(a(r6, "fds.txt", 64)));
        l.b(r5, "has_view_tree", Boolean.valueOf(a(r6, "viewTree.txt", 64)));
        l.b(r5, "has_pthread_key_map_file", Boolean.valueOf(a(r6, "pthread_key_map.txt", 10)));
        l.b(r5, "has_pthread_key_file", Boolean.valueOf(a(r6, "pthread_key_info.txt", 10)));
        l.b(r5, "has_routine_file", Boolean.valueOf(a(r6, "rountines.txt", 64)));
        l.b(r5, "has_gfx_file", Boolean.valueOf(a(r6, "gfxinfo.txt", 64)));
        l.b(r5, "has_os_memory", Boolean.valueOf(a(r6, "os_memory.txt", 64)));
        l.b(r5, "has_environ", Boolean.valueOf(a(r6, "environ.txt", 64)));
        l.b(r5, "has_signal_monitor_file", Boolean.valueOf(a(r6, "signal_monitor.txt", 64)));
        l.b(r5, "has_heaptrack_file", Boolean.valueOf(a(r6, "leak_heap.txt", 64)));
        l.b(r5, "has_setpriority_file", Boolean.valueOf(a(r6, "priority_stack.txt", 64)));
        l.b(r5, "has_setpriority_file", Boolean.valueOf(a(r6, "priority_jstack.txt", 64)));
        l.b(r5, "has_memtrack_dump", Boolean.valueOf(a(r6, "sys_memtrack.txt", 16)));
    }

    private static void b(JSONObject r2, File r3) {
        String[] r4 = NativeBridge.o(r3.getAbsolutePath());
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length != 5) goto L9;
        l.b(r2, "native_oom_reason", r4[0]);
        l.b(r2, "vma_leak_reason", r4[1]);
        l.b(r2, "mem_rss_reason", r4[2]);
        l.b(r2, "mem_pss_reason", r4[3]);
        l.b(r2, "mem_ref_reason", r4[4]);
        return;
    }

    private static void a(JSONObject r10, JSONObject r11, File r12, boolean r13) {
        boolean r0 = NativeBridge.g();
        long r1 = m.e(r12);
        boolean r3 = m.g(m.g(r12));
        l.b(r10, "vma_leak", Boolean.valueOf(r3));
        if (r1 <= 0) goto L7;
        if (r0 == false) goto L6;
        l.b(r10, "vm_peak_range", m.a(r1));
        goto L7
    L6:
        l.b(r10, "vm_peak_usage", m.a(r1, r13));
        boolean r2 = m.b(r1, r13);
        l.b(r10, "memory_leak", Boolean.valueOf(r2));
    L8:
        long r6 = m.d(r12);
        if (r6 <= 0) goto L13;
        if (r0 == false) goto L12;
        l.b(r10, "vmsize_range", m.a(r6));
    L14:
        l.a(r11, "memory_size", r6);
        long r7 = m.f(r12);
        l.a(r11, "rss", r7);
        boolean r14 = m.c(1024 * r7);
        if (r7 <= 0) goto L17;
        l.b(r10, "rss_size_range", m.b(r7));
    L17:
        if (r2 == true) goto L20;
        if (r3 == true) goto L20;
        if (r14 == true) goto L20;
        return;
    L20:
        b(r10, r12);
        return;
    L12:
        l.b(r10, "vmsize_range", m.a(r6, r13));
        goto L14
    L13:
        l.b(r10, "vmsize_range", "(0 - 0)");
    L7:
        r2 = false;
        goto L8
    }

    private static void c(JSONObject r3, File r4) {
        int r0 = m.a(r4);
        if (r0 == 0) goto L8;
        l.b(r3, "thread_count_range", m.a(r0));
        boolean r1 = m.b(r0);
        l.b(r3, "threads_leak", Boolean.valueOf(r1));
        if (r1 == false) goto L9;
        l.b(r3, "threads_leak_name", NativeBridge.c(r4));
        l.b(r3, "threads_leak_library", NativeBridge.d(r4));
        return;
    L9:
        return;
    }

    private static void d(JSONObject r3, File r4) {
        int r0 = m.b(r4);
        if (r0 == 0) goto L8;
        l.b(r3, "fd_count_range", m.c(r0));
        boolean r1 = m.d(r0);
        l.b(r3, "fd_leak", Boolean.valueOf(r1));
        if (r1 == false) goto L9;
        l.b(r3, "fd_leak_reason", NativeBridge.a(r4));
        return;
    L9:
        return;
    }

    private static void e(JSONObject r3, File r4) {
        int r0 = m.c(r4);
        if (r0 == 0) goto L8;
        l.b(r3, "pthread_key_range", m.e(r0));
        l.b(r3, "has_pthread_key_leak", Boolean.valueOf(m.f(r0)));
        if (m.f(r0) == false) goto L9;
        l.b(r3, "pthread_key_leak_lib", NativeBridge.b(r4));
        return;
    L9:
        return;
    }

    private static void f(JSONObject r7, File r8) {
        File r0 = new File(r8, "dlog.txt");
        boolean r9 = r0.exists();
        boolean r1 = false;
        String r2 = OProtocolTextEffectTextView.EffectNameNone;
        if (r9 == true) goto L5;
    L19:
        boolean r3 = false;
    L20:
        l.b(r7, "dumper_loaded", Boolean.valueOf(r1));
        l.b(r7, "dumper_exit_code", r2);
        l.b(r7, "npth_dumper_success", Boolean.valueOf(r3));
        return;
    L5:
        if (r0.length() <= 0) goto L19;
        BufferedReader r10 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L23
        r3 = false;
    L26:
        String r4 = r10.readLine();     // Catch: Throwable -> L22
        if (r4 == null) goto L20;
        if (r4.contains("[dumper] onload") == true) goto L12;
        if (r4.contains("[dumper] exit status:") == false) goto L26;
        int r5 = r4.lastIndexOf(58);     // Catch: Throwable -> L22
        if (r5 == (-1)) goto L26;
        r2 = r4.substring(r5 + 1).trim();     // Catch: Throwable -> L22
        r3 = r2.equals("0");     // Catch: Throwable -> L22
    L12:
        r1 = true;
        goto L26
    }

    private static void g(JSONObject r2, File r3) {
        o r0 = new o(r3);
        if (r0.a() == true) goto L5;
        return;
    L5:
        l.b(r2, "has_protector_history", Boolean.valueOf(r0.c()));
        if (r0.c() == false) goto L12;
        l.b(r2, "protector_sid", r0.d());
        l.b(r2, "protector_performed_count", Integer.valueOf(r0.e()));
        l.b(r2, "protector_total_performed_count", Integer.valueOf(r0.f()));
        l.b(r2, "protector_performed", Boolean.valueOf(r0.g()));
        l.b(r2, "protector_final_performed", Boolean.valueOf(r0.h()));
        l.b(r2, "protector_origin_scope", r0.j());
        l.b(r2, "protector_previous_scope", r0.i());
        if (r0.g() == false) goto L10;
        l.b(r2, "protector_scope", r0.k());
    L10:
        r0.b();
        return;
    }

    private static void e(JSONObject r12, JSONObject r13) {
        a(r12, r13);
        JSONObject r0 = r13.optJSONObject("app_memory_info");
        if (r0 == null) goto L17;
        long r3 = r0.optLong("native_heap_size");
        l.b(r12, "native_heap_range", c(r3));
        if (r3 <= 0) goto L17;
        l.b(r12, "native_heap_range", c(r3));
        boolean r8 = true;
        if (r3 <= 268435456) goto L9;
        boolean r7 = true;
    L10:
        l.b(r12, "native_heap_leak", Boolean.valueOf(r7));
        long r10 = r0.optLong("native_heap_alloc_size");
        if (r10 <= 0) goto L17;
        if (r10 > 268435456) goto L16;
        r8 = false;
    L16:
        l.b(r12, "native_heap_alloc_leak", Boolean.valueOf(r8));
        l.b(r12, "native_heap_alloc_usage", a(r3, r10));
        goto L17
    L9:
        r7 = false;
    L17:
        JSONObject r14 = r13.optJSONObject("memory_info");
        if (r14 == null) goto L23;
        long r4 = r14.optLong("totalPss");
        if (r4 <= 0) goto L24;
        l.b(r12, "total_pss_range", c(r4));
        return;
    L24:
        return;
    }

    private static String b(long r8) {
        s r7 = new s("MB");
        r7.a(0, 512, 64);
        return r7.a(r8);
    }

    private static String c(long r4) {
        s r0 = new s("MB");
        r0.a(new Long[]{0L, 1L, 64L, 128L, 256L, 384L, 512L, 768L, 1024L, 1536L});
        return r0.a(r4);
    }

    public static void a(JSONObject r8, JSONObject r9) {
        JSONObject r10 = r9.optJSONObject("app_memory_info");
        if (r10 == null) goto L15;
        long r0 = r10.optLong("max_memory");
        long r2 = r10.optLong("free_memory");
        long r4 = r10.optLong("total_memory");
        long r3 = r4 - r2;
        if (r3 <= 0) goto L10;
        l.b(r8, "java_heap_range", b(r3 / 1048576));
        if (r0 <= r3) goto L10;
        l.b(r8, "java_heap_alloc_usage", a(r4, r3));
        l.b(r8, "java_heap_usage", a(r0, r4));
    L10:
        if (r3 <= (r0 * 0.95f)) goto L12;
        boolean r11 = true;
    L13:
        l.b(r8, "java_heap_leak", String.valueOf(r11));
        return;
    L12:
        r11 = false;
        goto L13
    }
}
