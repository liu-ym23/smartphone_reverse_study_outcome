package com.android.ttcjpaysdk.thirdparty.utils;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayResponseUtils {
    public CJPayResponseUtils() {
    }

    public static JSONObject getResponse(JSONObject r100) {
        return JSONObjectProtectorUtils.getJSONObject(r100, "response");
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayResponseUtils#getResponse", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayResponseUtils#getResponse", e);
        return new JSONObject();
    }
}
