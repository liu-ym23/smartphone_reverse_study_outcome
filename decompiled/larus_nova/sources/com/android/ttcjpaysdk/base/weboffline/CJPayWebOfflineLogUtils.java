package com.android.ttcjpaysdk.base.weboffline;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayWebOfflineLogUtils {
    public CJPayWebOfflineLogUtils() {
    }

    public static void uploadMonitorDownload(String r100, String r101, String r102, String r103, long r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L4
        r105.put("status", r100);     // Catch: Exception -> L4
        r105.put("channel", r101);     // Catch: Exception -> L4
        r105.put("url", r102);     // Catch: Exception -> L4
        r105.put("version", r103);     // Catch: Exception -> L4
        r105.put("time", r104);     // Catch: Exception -> L4
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_offline_web_download", r105);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayWebOfflineLogUtils#uploadMonitorDownload", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayWebOfflineLogUtils#uploadMonitorDownload", e);
    }

    public static void webOfflineReport(String r100, String r101, String r102, String r103, long r104) {
        JSONObject r105 = CJPayParamsUtils.getCommonLogParams("", "");
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L5
        r106.put("status", r100);     // Catch: Exception -> L5
        r106.put("channel", r101);     // Catch: Exception -> L5
        r106.put("url", r102);     // Catch: Exception -> L5
        r106.put("version", r103);     // Catch: Exception -> L5
        r106.put("time", r104);     // Catch: Exception -> L5
    L7:
        CJPayCallBackCenter.getInstance().onEvent("wallet_weboffline_info", new JSONObject[]{r105});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayWebOfflineLogUtils#webOfflineReport", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayWebOfflineLogUtils#webOfflineReport", e);
        goto L7
    }
}
