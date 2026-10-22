package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayRiskInfo {
    public Map<String, String> riskInfoParamsMap;

    public CJPayRiskInfo() {
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        Map<String, String> r101 = this.riskInfoParamsMap;     // Catch: JSONException -> L18
        if (r101 != null) goto L6;
    L11:
        SimpleDateFormat r102 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: JSONException -> L18
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L18
        int r104 = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;     // Catch: JSONException -> L18
        if (r104 <= 0) goto L15;
        StringBuilder r105 = new StringBuilder();     // Catch: JSONException -> L18
        r105.append(Marker.ANY_NON_NULL_MARKER);     // Catch: JSONException -> L18
        r105.append(r104);     // Catch: JSONException -> L18
    L16:
        r103.put("utc_offset", r105.toString());     // Catch: JSONException -> L18
        r103.put("timenow", r102.format(new Date()));     // Catch: JSONException -> L18
        r100.put("timestamp_local", r103);     // Catch: JSONException -> L18
        return r100;
    L15:
        r105 = new StringBuilder();     // Catch: JSONException -> L18
        r105.append("");     // Catch: JSONException -> L18
        r105.append(r104);     // Catch: JSONException -> L18
        goto L16
    L6:
        if (r101.size() <= 0) goto L11;
        Iterator<Map.Entry<String, String>> r106 = this.riskInfoParamsMap.entrySet().iterator();     // Catch: JSONException -> L18
    L9:
        if (r106.hasNext() == false) goto L11;
        Map.Entry<String, String> r107 = r106.next();     // Catch: JSONException -> L18
        r100.put(r107.getKey(), r107.getValue());     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayRiskInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayRiskInfo#toJson", e);
        return null;
    }

    public JSONObject toJsonNew() {
        JSONObject r100 = new JSONObject();
        r100.put("risk_str", toJson());     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayRiskInfo#toJsonNew", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayRiskInfo#toJsonNew", e);
        return null;
    }
}
