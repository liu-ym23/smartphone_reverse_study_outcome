package com.bytedance.android.gamecp.business.compress;

import com.bytedance.android.gamecp.business.download.AppLifecycleObserver;
import com.bytedance.android.gamecp.business.download.k1;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.common.utils.e0;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.ToolUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class AirCompressReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Double> f52263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f52264b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f52265c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AirCompressReport f52266d = null;

    public AirCompressReport() {
    }

    static {
        f52266d = new AirCompressReport();
        new LinkedHashMap();
        f52263a = new LinkedHashMap();
        f52264b = LazyKt.lazy(AirCompressReport$checkSumTrackingSwitch$2.INSTANCE);
        f52265c = LazyKt.lazy(AirCompressReport$executor$2.INSTANCE);
    }

    public static String a(AirCompressReport r100, String r110) {
        r100.getClass();
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L40;
        return "file path is null or empty";
    L40:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r110));     // Catch: Throwable -> L17
        byte[] r103 = new byte[100];     // Catch: Throwable -> L15
        r102.read(r103);     // Catch: Throwable -> L15
        String r111 = ArraysKt.joinToString$default(r103, "", null, null, 0, null, AirCompressReport$getFilePreBytes$1.INSTANCE, 30, null);     // Catch: Throwable -> L15
    L38:
        r102.close();     // Catch: Throwable -> L23
    L26:
        return r111;
    L23:
        th = move-exception;
        th.printStackTrace();
    L15:
        Throwable th10 = th;
    L42:
        th10.printStackTrace();     // Catch: Throwable -> L27
        r111 = yr.c.d(th10);     // Catch: Throwable -> L27
        if (r102 == null) goto L26;
    L27:
        th = move-exception;
        if (r102 != null) goto L34;
    L33:
        throw th;
    L34:
        r102.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
    L17:
        th = move-exception;
        th10 = th;
        r102 = null;
        goto L42
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static void e(com.bytedance.android.gamecp.business.download.b r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.putOpt("fail_msg", r101);     // Catch: Throwable -> L5
        r102.putOpt("fail_status", 1011);     // Catch: Throwable -> L5
    L7:
        f("compress_file_error", r102, r100);
        return;
    L5:
        th = move-exception;
        yr.c.a("AirCompressReport", "sendCompressFileError exception = " + th.getMessage());
        goto L7
    }

    public static void h(p r100, int r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == null) goto L6;
        String r103 = r100.f52855k;
        if (r103 == null) goto L6;
    L7:
        r102.put("unified_game_id", r103);
        r102.put("status", String.valueOf(r101));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("ac_install_app", r102);
        return;
    L6:
        r103 = "";
        goto L7
    }

    public static void f(String r100, JSONObject r101, com.bytedance.android.gamecp.business.download.b r102) {
        JSONObject r103 = null;
        AppLifecycleObserver r104 = k1.f52798a;     // Catch: Throwable -> L14
        if (r102 == null) goto L6;
        JSONObject r105 = r102.f52537f;     // Catch: Throwable -> L14
    L7:
        String r106 = k1.e(r105);     // Catch: Throwable -> L14
        r101.putOpt("available_space", Long.valueOf(ToolUtils.getReportableSpaceMB(ToolUtils.getExternalAvailableSpaceBytes(0)) / ((long) 20)));     // Catch: Throwable -> L14
        if (r106.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L16;
        r101.putOpt("download_speed", ((LinkedHashMap) f52263a).get(r106));     // Catch: Throwable -> L14
    L16:
        ModelManager r108 = ModelManager.getInstance();
        if (r102 == null) goto L19;
        String r109 = r102.f52538g;
    L20:
        NativeDownloadModel r110 = r108.getNativeModelByUrl(r109);
        if (r110 == null) goto L24;
        AdEventHandler.getInstance().sendEvent(r100, r101, r110);
        return;
    L24:
        int r111 = com.bytedance.android.gamecp.business.a.f51760a;
        Intrinsics.checkNotNullParameter(r100, "label");
        Map<String, String> r112 = e0.c(r101);
        if (r102 == null) goto L27;
        r103 = r102.f52537f;
    L27:
        ((HashMap) r112).putAll(e0.c(r103));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3(r100, r112);
        return;
    L19:
        r109 = null;
        goto L20
    L10:
        r107 = false;
        goto L11
    L6:
        r105 = null;
    L14:
        th = move-exception;
        yr.c.a("AirCompressReport", "sendEvent exception = " + th.getMessage());
        goto L16
    }

    public final void k(com.bytedance.android.gamecp.business.download.b r100, int r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        JSONObject r104 = new JSONObject();
        r104.putOpt("fail_status", Integer.valueOf(r101));     // Catch: Throwable -> L9
        r104.putOpt("fail_msg", r102);     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        String r105 = r100.f52534c;     // Catch: Throwable -> L9
    L7:
        r104.putOpt("file_magic", a(this, r105));     // Catch: Throwable -> L9
        r104.putOpt("restore_from", Integer.valueOf(r103));     // Catch: Throwable -> L9
    L11:
        f("restore_pre_start_failed", r104, r100);
        return;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        yr.c.a("AirCompressReport", "sendRestorePreStartFailed exception = " + th.getMessage());
        goto L11
    }

    public final void l(com.bytedance.android.gamecp.business.download.b r100, String r101, boolean r102, int r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "sourceApk");
        JSONObject r105 = new JSONObject();
        r105.putOpt("check_sum", Boolean.valueOf(r102));     // Catch: Throwable -> L8
        r105.putOpt("restore_from", Integer.valueOf(r103));     // Catch: Throwable -> L8
        if (r104 == 0) goto L6;
        r105.putOpt("duration", Long.valueOf(System.currentTimeMillis() - r104));     // Catch: Throwable -> L8
    L6:
        r105.putOpt("file_magic", a(this, r101));     // Catch: Throwable -> L8
        boolean r106 = AirCompressManager.f52225a;     // Catch: Throwable -> L8
        r105.putOpt("file_size", Double.valueOf(AirCompressManager.g(r101)));     // Catch: Throwable -> L8
    L10:
        f("restore_start", r105, r100);
        return;
    L8:
        th = move-exception;
        yr.c.a("AirCompressReport", "sendRestoreStart exception = " + th.getMessage());
        goto L10
    }

    public static void b(com.bytedance.android.gamecp.business.download.b r100, String r101, int r102, Long r103, Long r104, Boolean r105) {
        JSONObject r106 = new JSONObject();
        r106.putOpt("fail_msg", r101);     // Catch: Throwable -> L5
        r106.putOpt("fail_status", 1015);     // Catch: Throwable -> L5
        r106.putOpt("restore_from", Integer.valueOf(r102));     // Catch: Throwable -> L5
        r106.putOpt("init_succeed_cnt", r103);     // Catch: Throwable -> L5
        r106.putOpt("init_failed_cnt", r104);     // Catch: Throwable -> L5
        r106.putOpt("last_init_succeed", r105);     // Catch: Throwable -> L5
    L7:
        f("ac_plugin_status", r106, r100);
        return;
    L5:
        th = move-exception;
        yr.c.a("AirCompressReport", "sendACPluginStatus exception = " + th.getMessage());
        goto L7
    }

    public static void g(String r100, String r101, int r102, String r103, boolean r104, String r105, String r110) {
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r105, "from");
        LinkedHashMap r106 = new LinkedHashMap();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r106.put("game_id", r100);
        r106.put("package_name", r101);
        r106.put("version_code", String.valueOf(r102));
        r106.put("version_name", r103);
        r106.put("has_md5", String.valueOf(r104));
        r106.put("from", r105);
        if (r110 != null) goto L8;
        r110 = "";
    L8:
        r106.put("md5", r110);
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("patch_get_game_apk_md5", r106);
    }

    public static /* synthetic */ void d(String r110, String r111, String r112, int r113, String r114, Long r115, long r116, String r210) {
        Boolean r117 = Boolean.FALSE;
        c(r110, r111, r112, null, r113, r114, r115, r116, false, r210, r117, r117);
    }

    public static void i(String r100, String r101, int r102, String r103, String r104, Integer r105, String r106, String r107, int r110, Map r111) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JSONObject r108 = new JSONObject();
        r108.putOpt("from", r107);     // Catch: Throwable -> L13
        r108.putOpt("fail_status", Integer.valueOf(r102));     // Catch: Throwable -> L13
        r108.putOpt("fail_msg", r103);     // Catch: Throwable -> L13
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r108.putOpt("unified_game_id", r101);     // Catch: Throwable -> L13
        r108.putOpt("package_name", r106);     // Catch: Throwable -> L13
        r108.putOpt("local_apk_md5", r104);     // Catch: Throwable -> L13
        r108.putOpt("local_version_code", r105);     // Catch: Throwable -> L13
        r108.putOpt("ac_scene", Integer.valueOf(r110));     // Catch: Throwable -> L13
        if (r111 == null) goto L15;
        Iterator r109 = r111.entrySet().iterator();     // Catch: Throwable -> L13
    L10:
        if (r109.hasNext() == false) goto L15;
        Map.Entry r112 = (Map.Entry) r109.next();     // Catch: Throwable -> L13
        r108.putOpt((String) r112.getKey(), r112.getValue());     // Catch: Throwable -> L13
    L15:
        f(r100, r108, null);
        return;
    L13:
        th = move-exception;
        yr.c.a("AirCompressReport", "sendIsSupportAC exception = " + th.getMessage());
        goto L15
    }

    public static /* synthetic */ void j(String r110, String r111, int r112, String r113, String r114, Integer r115, String r116, String r210, int r211, Map r212, int r213) {
        if ((r213 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 16) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r213 & 32) == 0) goto L13;
        Integer r102 = 0;
    L15:
        if ((r213 & 64) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r213 & 128) == 0) goto L21;
        String r117 = "";
    L23:
        if ((r213 & 256) == 0) goto L25;
        int r118 = 0;
    L27:
        if ((r213 & 512) == 0) goto L29;
        Map r119 = null;
    L30:
        i(r110, r111, r112, r100, r101, r102, r103, r117, r118, r119);
        return;
    L29:
        r119 = r212;
        goto L30
    L25:
        r118 = r211;
        goto L27
    L21:
        r117 = r210;
        goto L23
    L17:
        r103 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r110, int r111, String r112, Long r113, long r114, boolean r115, String r116, Boolean r117, Boolean r118) {
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "from");
        LinkedHashMap r103 = new LinkedHashMap();
        String r104 = "";
        if (r100 != null) goto L5;
        String r105 = "";
    L6:
        r103.put("game_id", r105);
        r103.put("package_name", r101);
        r103.put("from", r102);
        if (r110 != null) goto L9;
        String r106 = "";
    L10:
        r103.put("md5", r106);
        r103.put("version_code", String.valueOf(r111));
        r103.put("version_name", r112);
        r103.put("file_length", String.valueOf(r113));
        r103.put("duration", String.valueOf(r114));
        r103.put("is_success", String.valueOf(r115));
        if (r116 == null) goto L14;
        r104 = r116;
    L14:
        r103.put("message", r104);
        r103.put("is_new_algorithm", String.valueOf(r117));
        r103.put("is_entire_file_calculated", String.valueOf(r118));
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("patch_calculate_game_apk_md5", r103);
        return;
    L9:
        r106 = r110;
        goto L10
    L5:
        r105 = r100;
        goto L6
    }
}
