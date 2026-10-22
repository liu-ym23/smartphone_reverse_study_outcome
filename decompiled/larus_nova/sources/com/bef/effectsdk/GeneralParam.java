package com.bef.effectsdk;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GeneralParam {
    private static GetNetWorkInfo sGetNetworkInfo;

    /* JADX INFO: loaded from: classes39.dex */
    public interface GetNetWorkInfo {
        int checkUrl(String r100);

        HashMap<String, String> getHeader(String r100);

        HashMap<String, String> getParam(String r100);
    }

    public GeneralParam() {
    }

    private static native String nativeGetParamByKey(String r100);

    private static native void nativeSetParamWithKey(String r100, String r101);

    private static native void nativeSetParams(HashMap<String, String> r100);

    private static int checkUrlStr(String r100) {
        GetNetWorkInfo r101 = sGetNetworkInfo;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.checkUrl(r100);
    }

    private static String convertMapToString(HashMap<String, String> r100) {
        if (r100.isEmpty() == false) goto L6;
        return "";
    L6:
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
        Map.Entry<String, String> r102 = r101.next();
        String r103 = r102.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + r102.getValue();
    L8:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, String> r104 = r101.next();
        String r105 = r104.getKey();
        String r106 = r104.getValue();
        if (r105.isEmpty() == true) goto L8;
        if (r106.isEmpty() == true) goto L8;
        r103 = r103 + "&" + r105 + ContainerUtils.KEY_VALUE_DELIMITER + r106;
        goto L8
    L14:
        return r103;
    }

    private static String getHeaderStr(String r100) {
        GetNetWorkInfo r101 = sGetNetworkInfo;
        if (r101 != null) goto L7;
        return "";
    L7:
        return convertMapToString(r101.getHeader(r100));
    }

    public static String getParamByKey(String r100) {
        return nativeGetParamByKey(r100);
    }

    private static String getParamStr(String r100) {
        GetNetWorkInfo r101 = sGetNetworkInfo;
        if (r101 != null) goto L7;
        return "";
    L7:
        return convertMapToString(r101.getParam(r100));
    }

    public static void setNetWorkInfoCallback(GetNetWorkInfo r100) {
        sGetNetworkInfo = r100;
    }

    public static void setParams(HashMap<String, String> r100) {
        nativeSetParams(r100);
    }

    public static void setParamWithKey(String r100, String r101) {
        nativeSetParamWithKey(r100, r101);
    }
}
