package com.bytedance.ttnet.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ttnet.TTNetInit;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MultiProcessFileUtils {
    public static final String KEY_DNS = "dns";
    public static final String KEY_FRONTIER_URLS = "frontier_urls";
    public static final String KEY_HTTPS_DNS = "https_dns";
    public static final String KEY_IS_FULL_CONFIG = "is_full_config";
    public static final String KEY_SSIDS = "ssids";
    public static final String KEY_TNC_ABTEST = "tnc_abtest";
    public static final String KEY_TNC_CONFIG = "tnc_config";
    public static final String KEY_TNC_ETAG = "tnc_etag";
    private static final String TAG = "MultiProcessFileUtils";
    public static final int TYPE_DNS = 2;
    public static final int TYPE_HTTPS_DNS = 3;
    public static final int TYPE_SSIDS = 1;
    public static final int TYPE_TNC_ABTEST = 6;
    public static final int TYPE_TNC_CONFIG = 4;
    public static final int TYPE_TNC_ETAG = 5;
    public static final int TYPE_TNC_FULL_CONFIG_FLAG = 7;

    public MultiProcessFileUtils() {
    }

    public static void saveData(Context r3, int r4, String r5) {
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Exception -> L18
        switch(r4) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L14;
        };     // Catch: Exception -> L18
    L6:
        r1.put("is_full_config", r5);     // Catch: Exception -> L18
        goto L14
    L7:
        r1.put(KEY_TNC_ABTEST, r5);     // Catch: Exception -> L18
        goto L14
    L8:
        r1.put(KEY_TNC_ETAG, r5);     // Catch: Exception -> L18
        goto L14
    L9:
        r1.put(KEY_TNC_CONFIG, r5);     // Catch: Exception -> L18
        goto L14
    L10:
        r1.put(KEY_HTTPS_DNS, r5);     // Catch: Exception -> L18
        goto L14
    L11:
        r1.put(KEY_DNS, r5);     // Catch: Exception -> L18
        goto L14
    L12:
        r1.put(KEY_SSIDS, r5);     // Catch: Exception -> L18
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("PushService", "saveData = " + r5);     // Catch: Exception -> L18
    L16:
        TTNetInit.getTTNetDepend().saveMapToProvider(r3, r1);     // Catch: Exception -> L18
        return;
    }

    public static String getData(Context r2, int r3) {
        switch(r3) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L13;
        };
    L5:
        String r4 = TTNetInit.getTTNetDepend().getProviderString(r2, "is_full_config", "");     // Catch: Exception -> L18
    L19:
    L15:
        if ((r4 instanceof String) == true) goto L17;
        return "";
    L17:
        return String.valueOf(r4);
    L6:
        r4 = TTNetInit.getTTNetDepend().getProviderString(r2, KEY_TNC_ABTEST, "");     // Catch: Exception -> L18
        goto L19
    L7:
        r4 = TTNetInit.getTTNetDepend().getProviderString(r2, KEY_TNC_ETAG, "");     // Catch: Exception -> L18
        goto L19
    L8:
        r4 = TTNetInit.getTTNetDepend().getProviderString(r2, KEY_TNC_CONFIG, "");     // Catch: Exception -> L18
        goto L19
    L9:
        r4 = TTNetInit.getTTNetDepend().getProviderString(r2, KEY_HTTPS_DNS, "");     // Catch: Exception -> L18
        goto L19
    L10:
        r4 = TTNetInit.getTTNetDepend().getProviderString(r2, KEY_DNS, "");     // Catch: Exception -> L18
        goto L19
    L11:
        r4 = TTNetInit.getTTNetDepend().getProviderString(r2, KEY_SSIDS, "");     // Catch: Exception -> L18
    L13:
        r4 = "";
        goto L15
    }

    public static void saveSSIDs(Context r2, Map<String, String> r3) {
        if (r2 == null) goto L13;
        if (r3 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L11;
        Logger.d("PushService", "saveSSIDs start");
    L11:
        saveData(r2, 1, StringUtils.mapToString(r3));     // Catch: Exception -> L10
        return;
    L15:
        return;
    }

    public static void getSSIDs(Context r2, Map<String, String> r3) {
        if (r2 == null) goto L17;
        if (r3 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L15;
        Logger.d("PushService", "getSSIDs start");
    L15:
        String r4 = getData(r2, 1);     // Catch: Exception -> L14
        if (StringUtils.isEmpty(r4) == false) goto L12;
        return;
    L12:
        StringUtils.stringToMap(r4, r3);     // Catch: Exception -> L14
        return;
    L19:
        return;
    }

    public static String bool2Str(boolean r0) {
        return Boolean.valueOf(r0).toString();
    }

    public static boolean str2Bool(String r0) {
        return Boolean.parseBoolean(r0);
    }
}
