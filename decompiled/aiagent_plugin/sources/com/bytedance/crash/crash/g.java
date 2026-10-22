package com.bytedance.crash.crash;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.o.l;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NpthCheckUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static void a(CrashType r2, File r3, JSONObject r4, JSONObject r5) {
        JSONObject r0 = new JSONObject();
        l.a(r0, "crash_type", r2.getName());
        a(r0, r3);
        b(r4, r0);
        a(r5, r0);
        new com.bytedance.crash.c.b.a("crash_data_check", r0).a();
    }

    private static void a(Object r2, Object r3, String r4, JSONObject r5) {
        if (r2 != r3) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        a("err_" + r4 + "_not_" + r2, r5);
        return;
    L6:
        if (r2.equals(r3) == true) goto L11;
        a("err_" + r4 + "_not_" + r2, r5);
        return;
    }

    private static void a(JSONObject r3, JSONObject r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        a(r3.optString(AppInfo.KEY_NPTH_VERSION_NAME), AppInfo.KEY_NPTH_VERSION_NAME, r4);
        a(r3.optString("sdk_version"), "sdk_version", r4);
        a("Android", r3.optString(RomInfo.KEY_OS_TYPE), RomInfo.KEY_OS_TYPE, r4);
        a(r3.optString(RomInfo.KEY_ROM_OS_VERSION), RomInfo.KEY_ROM_OS_VERSION, r4);
        a(r3.optString(RomInfo.KEY_ROM_OS_API), RomInfo.KEY_ROM_OS_API, r4);
        a(r3.optString(HardwareInfo.KEY_HW_VENDOR_MODEL), HardwareInfo.KEY_HW_VENDOR_MODEL, r4);
        a(r3.optString(HardwareInfo.KEY_HW_VENDOR_BRAND), HardwareInfo.KEY_HW_VENDOR_BRAND, r4);
        a(r3.optString(HardwareInfo.KEY_HW_VENDOR_MANUFACTURER), HardwareInfo.KEY_HW_VENDOR_MANUFACTURER, r4);
        a(r3.optString(HardwareInfo.KEY_HW_CPU_ABI), HardwareInfo.KEY_HW_CPU_ABI, r4);
        a(r3.optString("unique_key"), "unique_key", r4);
    }

    private static void a(JSONObject r2, File r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (new File(r3, "logcat.txt").exists() == true) goto L8;
        a("has_logcat_file_false", r2);
    L8:
        if (new File(r3, "maps.txt").exists() == true) goto L11;
        a("has_maps_file_false", r2);
    L11:
        if (new File(r3, "threads.txt").exists() == true) goto L14;
        a("has_threads_file_false", r2);
    L14:
        if (new File(r3, "fds.txt").exists() == true) goto L17;
        a("has_fds_file_false", r2);
    L17:
        if (new File(r3, "meminfo.txt").exists() == true) goto L20;
        a("has_meminfo_file_false", r2);
    L20:
        if (new File(r3, "viewTree.txt").exists() == true) goto L23;
        a("has_view_tree_false", r2);
    L23:
        if (new File(r3, "pthread_key_info.txt").exists() == true) goto L26;
        a("has_pthread_key_file_false", r2);
    L26:
        if (new File(r3, "pthread_key_map.txt").exists() == true) goto L29;
        a("has_pthread_key_map_file_false", r2);
    L29:
        if (new File(r3, "malloc.txt").exists() == true) goto L32;
        a("has_malloc_file_false", r2);
    L32:
        if (new File(r3, "pthreads.txt").exists() == true) goto L35;
        a("has_pthreads_file_false", r2);
    L35:
        if (new File(r3, "setpriority.txt").exists() == true) goto L38;
        a("has_setpriority_file_false", r2);
    L38:
        if (new File(r3, "leak_heap.txt").exists() == true) goto L41;
        a("has_heaptrack_file_false", r2);
        return;
    }

    private static void b(JSONObject r4, JSONObject r5) {
        a(r4.opt("miniapp_info"), "miniapp_info", r5);
        a(r4.opt("plugin_info"), "plugin_info", r5);
        a(r4.opt("process_name"), "process_name", r5);
        a(r4.opt(Scraps.BATTERY), Scraps.BATTERY, r5);
        a(r4.opt("logcat"), "logcat", r5);
        a(r4.opt("crash_time"), "crash_time", r5);
        a(r4.opt(Scraps.STORAGE), Scraps.STORAGE, r5);
        a(r4.opt("filters"), "filters", r5);
        a(r4.opt("patch_info"), "patch_info", r5);
        a(r4.opt("pid"), "pid", r5);
        a(r4.opt("is_background"), "is_background", r5);
        a(r4.opt("activity_trace"), "activity_trace", r5);
        a(r4.opt("custom_long"), "custom_long", r5);
        if (com.bytedance.crash.monitor.b.g() == false) goto L6;
        a(r4.opt(MonitorConstants.CUSTOM), MonitorConstants.CUSTOM, r5);
    L6:
        if (r4.optJSONObject("custom_long") == null) goto L9;
        a(r4.optJSONObject("custom_long").opt("activity_track"), "activity_track", r5);
    L9:
        if (r4.opt("filters") == null) goto L12;
        a(r4.optJSONObject("filters").opt("sdk_version"), "filters:sdk_version", r5);
        a(r4.optJSONObject("filters").opt(AppInfo.KEY_NPTH_VERSION_NAME), "filters:sdk_version_name", r5);
        a(r4.optJSONObject("filters").opt("is_root"), "filters:is_root", r5);
        a(r4.optJSONObject("filters").opt("is_x86_devices"), "filters:is_x86_devices", r5);
        a(r4.optJSONObject("filters").opt("is_64_runtime"), "filters:is_64_runtime", r5);
        a(r4.optJSONObject("filters").opt(RomInfo.KEY_ROM_KERNEL_VERSION), "filters:kernel_version", r5);
        return;
    }

    private static void a(String r1, JSONObject r2) {
        r2.put(r1, 1);     // Catch: JSONException -> L5
        return;
    }

    private static void a(String r1, String r2, JSONObject r3) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        a("err_empty_" + r2, r3);
        return;
    }

    private static void a(Object r1, String r2, JSONObject r3) {
        if (r1 != null) goto L5;
        a("err_null_" + r2, r3);
        return;
    }
}
