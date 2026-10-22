package com.stepos.statsapp.v3.lib.plugin.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class NetRequestUtil {
    public static String HEADER_If_Modified_Since = "If-Modified-Since";
    public static String HEADER_If_None_Match = "If-None-Match";
    public static String TAG = "NetRequestUtil";

    private static Map<String, String> flatMap(Map<String, String[]> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            map2.put(entry.getKey(), toString(entry.getValue()));
        }
        return map2;
    }

    public static String sign(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        String path;
        HashMap map3 = new HashMap(map);
        try {
            path = new URI(str2).getPath();
        } catch (URISyntaxException e10) {
            Logger.w(TAG, "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            path = "";
        }
        map3.put("key", UxipConstants.f30679r);
        if (map2 != null && map2.containsKey(HEADER_If_None_Match)) {
            String str3 = HEADER_If_None_Match;
            map3.put(str3, map2.get(str3));
        }
        if (map2 != null && map2.containsKey(HEADER_If_Modified_Since)) {
            String str4 = HEADER_If_Modified_Since;
            map3.put(str4, map2.get(str4));
        }
        ArrayList arrayList = new ArrayList(map3.keySet());
        Collections.sort(arrayList);
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            String str5 = (String) obj;
            sb2.append(Const.STR_MART_ADD);
            sb2.append(urlEncode(str5));
            sb2.append("=");
            sb2.append(urlEncode((String) map3.get(str5)));
        }
        return Utils.getMD5((str + "\n" + path + "\n" + sb2.toString().substring(1)).getBytes());
    }

    private static String toString(String[] strArr) {
        int length;
        if (strArr == null || strArr.length - 1 == -1) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (true) {
            sb2.append(strArr[i10]);
            if (i10 == length) {
                return sb2.toString();
            }
            sb2.append(",  ");
            i10++;
        }
    }

    private static String urlEncode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
