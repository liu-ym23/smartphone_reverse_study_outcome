package com.byted.cast.common;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class UrlUtils {
    public UrlUtils() {
    }

    public static String getGrayConfigDomain() {
        return "https://configure-platform.bytedance.com";
    }

    public static String getMonitorDomain() {
        return "https://mon.snssdk.com";
    }

    public static String getQRDataDomain(boolean r100) {
        if (r100 == false) goto L4;
        return "https://vcloud-openapi-boe.bytedance.net";
    L4:
        return "https://open.bytedanceapi.com";
    }

    public static String getQRTokenDomain(boolean r100) {
        if (r100 == false) goto L4;
        return "https://bytecast-boe.bytedance.net/bytecast/app_auth";
    L4:
        return "https://bytecast.bytedance.com/bytecast/app_auth";
    }

    public static void modifyOverseasTokenDomain(String r100) {
    }

    public static void setDefaultMonitorConfigUrl(ArrayList<String> r100) {
    }

    public static void setGrayConfigDomain(String r100) {
    }

    public static void setMapParams(Map<String, String> r100) {
    }

    public static List<String> getDefaultMonitorConfigUrl() {
        return Arrays.asList(new String[]{"https://mon.snssdk.com/monitor/appmonitor/v2/settings", "https://monsetting.toutiao.com/monitor/appmonitor/v2/settings"});
    }

    public static List<String> getDefaultMonitorReportUrl() {
        return Arrays.asList(new String[]{ReportConstant.DEFAULT_URL_REPORT});
    }

    public static String getLicenseDataDomain() {
        if (PreferenceUtils.getByteLicenseDomainType(Constants.sAppContext) != 2) goto L5;
        return "https://vcloud-openapi-boe.bytedance.net/";
    L5:
        return "https://open.bytedanceapi.com";
    }

    public static String getLicenseTokenDomain() {
        if (PreferenceUtils.getByteLicenseDomainType(Constants.sAppContext) != 2) goto L5;
        return "https://bytecast-boe.bytedance.net/";
    L5:
        return "https://bytecast.bytedance.com";
    }
}
