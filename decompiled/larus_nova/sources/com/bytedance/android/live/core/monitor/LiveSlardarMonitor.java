package com.bytedance.android.live.core.monitor;

import android.text.TextUtils;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import wm0.b;
import wy.a;
import y50.h;
import y50.j;

/* JADX INFO: loaded from: classes45.dex */
public class LiveSlardarMonitor {
    public static final boolean DEBUG = false;
    private static final String DEFALUT_MONITOR_ALOG_TAG = "ttlive_monitor";
    public static final int DELAY_3000 = 3000;
    private static final String MONITOR_TAG_PRE = "ttlive";
    public static final String SERVICE_ANCHOR_LIVE_EDN = "ttlive_anchor_close_room";
    public static final String SERVICE_APP_DEBUG_LOG = "ttlive_sdk_debug_log";
    public static final String SERVICE_GIF_DOWNLOAD_TIME = "download_time";
    public static final String SERVICE_LIVE_IMAGE_LOAD = "hotsoon_live_image_load";
    public static final String SERVICE_LOG_IMAGE_ERROR = "image_error";
    public static final String SERVICE_PUSH_IMAGE_LOAD_ERROR_RATE = "hotsoon_push_image_load_error_rate";
    public static final String SERVICE_VIDEO_DOWNLOAD_TIME = "download_time";
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final String TAG = "LiveSlardarMonitor";
    public static final String TYPE_GIF_DOWNLOAD = "hotsoon_gif_download_time";
    public static final String TYPE_GIF_TRANSFORM_FAILED_LOG_FILE_MD5 = "type_gif_transform_failed_log_file_md5";
    public static final String TYPE_IMAGE_API = "hotsoon_image_api";
    public static final String TYPE_LIVE_IAP = "hotsoon_live_iap";
    public static final String TYPE_LOCAL_VIDEO_CONVERT_GIF = "hotsoon_video_convert_gif";
    public static final String TYPE_LOG_IMAGE_LOAD = "hotsoon_image_load_log";
    public static final String TYPE_LOG_IMAGE_LOAD_DURATION = "hotsoon_image_load_duration";
    public static final String TYPE_VIDEO_DOWNLOAD = "hotsoon_video_download_time";
    public static final String TYPE_VIDEO_SERVER_GET_GIF = "hotsoon_server_gif_download";

    static {
        LocalTestManager.a(new Class[]{a.class});
        DEBUG = false;
    }

    public LiveSlardarMonitor() {
    }

    private static IHostMonitor monitor() {
        return (IHostMonitor) BaseServices.as(IHostMonitor.class);
    }

    private static JSONObject durationJson(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("duration", r100);     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private static JSONObject generateFinalExtra(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        r101.put("tag", "ttlive_sdk");     // Catch: JSONException -> L7
        r101.put("ttlive_sdk_version", String.valueOf(c.b()));     // Catch: JSONException -> L7
        if (r100 == null) goto L9;
        r101.put("extra", r100);     // Catch: JSONException -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        e.printStackTrace();
        Logger.e(TAG, e.getMessage());
        goto L9
    }

    private static JSONObject mapToJson(Map<String, ?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, ?>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, ?> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    L13:
        return r101;
    }

    public static void exceptionMonitor(Throwable r100, String r101) {
        int r102 = j.f566215a;
        b r103 = om0.c.j();
        if (r103 == null) goto L6;
        r103.ensureNotReachHere(r100, r101);
        return;
    }

    public static void monitorStatus(String r100, int r101) {
        monitorStatus(r100, r101, Collections.emptyMap());
    }

    public static void monitorCommonLog(String r100, String r101, JSONObject r102) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r101) == false) goto L8;
        return;
    L8:
        if (r102 != null) goto L20;
        r102 = new JSONObject();
    L20:
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        int r103 = j.f566215a;
        b r104 = om0.c.j();
        if (r104 == null) goto L22;
        r104.monitorCommonLog(r100, r102);
        return;
    L22:
        return;
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        r102.put("service", r101);     // Catch: JSONException -> L14
        goto L16
    }

    public static void monitorDuration(String r100, long r101, JSONObject r102) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        JSONObject r103 = durationJson(r101);
        JSONObject r104 = generateFinalExtra(r102);
        beforeMonitor("monitorDuration", r100, 0, r103, r104);
        monitorDuration(r100, r103, r104);
    }

    public static void monitorStatus(String r100, int r101, JSONObject r102) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r100) == false) goto L8;
        return;
    L8:
        JSONObject r103 = generateFinalExtra(r102);
        beforeMonitor("monitorStatus", r100, r101, r103);
        int r104 = j.f566215a;
        b r105 = om0.c.j();
        if (r105 == null) goto L12;
        r105.monitorStatusRate(r100, r101, r103);
        return;
    }

    public static void monitorStatusAndDuration(String r100, int r101, long r102) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        monitorStatusAndDuration(r100, r101, durationJson(r102), null);
    }

    public static void monitorStatusRate(String r100, int r101, JSONObject r102) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r100) == false) goto L8;
        return;
    L8:
        int r103 = j.f566215a;
        b r104 = om0.c.j();
        if (r104 == null) goto L12;
        r104.monitorStatusRate(r100, r101, r102);
        return;
    }

    private static void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        IHostMonitor r103 = monitor();
        if (r103 == null) goto L6;
        r103.monitorDuration(r100, r101, r102);
        return;
    }

    public static void monitorStatus(String r100, int r101, Map<String, ?> r102) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r100) == false) goto L8;
        return;
    L8:
        monitorStatus(r100, r101, mapToJson(r102));
    }

    public static void monitorStatusAndDuration(String r100, int r101, JSONObject r102) {
        monitorStatusAndDuration(r100, r101, null, r102);
    }

    private static void beforeMonitor(String r100, String r101, int r102, JSONObject r103) {
        beforeMonitor(r100, r101, r102, null, r103);
    }

    public static void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (DEBUG == false) goto L6;
        Logger.d(TAG, "serviceName = " + r100 + ", category = " + r101 + ", metric = " + r102 + ", extraLog = " + r103);
    L6:
        if (h.a(r100) == false) goto L8;
        return;
    L8:
        int r104 = j.f566215a;
        b r105 = om0.c.j();
        if (r105 == null) goto L12;
        r105.monitorEvent(r100, r101, r102, r103);
        return;
    }

    public static void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
        if (monitor() != null) goto L6;
        return;
    L6:
        if (h.a(r100) == false) goto L8;
        return;
    L8:
        JSONObject r104 = generateFinalExtra(r103);
        beforeMonitor("monitorStatusAndDuration", r100, r101, r102, r104);
        int r105 = j.f566215a;
        b r106 = om0.c.j();
        if (r106 == null) goto L12;
        r106.monitorStatusAndDuration(r100, r101, r102, r104);
        return;
    }

    public static void monitorStatusAndDurationDirect(String r100, int r101, JSONObject r102, JSONObject r103) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        beforeMonitor("monitorStatusAndDuration", r100, r101, r102, r103);
        int r104 = j.f566215a;
        b r105 = om0.c.j();
        if (r105 == null) goto L9;
        r105.monitorStatusAndDuration(r100, r101, r102, r103);
        return;
    }

    public static void monitorStatusAndDuration(String r100, int r101, long r102, Map<String, Object> r103) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        monitorStatusAndDuration(r100, r101, durationJson(r102), mapToJson(r103));
    }

    public static void monitorStatusAndDuration(String r100, int r101, long r102, JSONObject r103) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        monitorStatusAndDuration(r100, r101, durationJson(r102), r103);
    }

    private static void beforeMonitor(String r100, String r101, int r102, JSONObject r103, JSONObject r104) {
        if (DEBUG == false) goto L6;
        Logger.e(TAG, "method = " + r100 + ",key = " + r101 + ",status = " + r102 + ",duration = " + r103 + ",logJson = " + r104);
        return;
    }
}
