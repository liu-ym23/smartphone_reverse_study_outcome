package com.android.ttcjpaysdk.base.h5.utils;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayXBridgeUtils {
    public CJPayXBridgeUtils() {
    }

    public static HashMap<String, String> convertJsonToMap(JSONObject r100) {
        HashMap<String, String> r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.keys();
    L14:
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayXBridgeUtils#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayXBridgeUtils#unknown", e);
        return r101;
    L7:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();     // Catch: Exception -> L11
        r101.put(r103, r100.optString(r103));     // Catch: Exception -> L11
        goto L14
    L10:
        return r101;
    }
}
