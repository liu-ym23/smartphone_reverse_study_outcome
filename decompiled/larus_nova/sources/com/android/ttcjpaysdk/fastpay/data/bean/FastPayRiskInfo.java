package com.android.ttcjpaysdk.fastpay.data.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
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
public class FastPayRiskInfo implements CJPayObject {
    public String identity_token;
    public RiskStrInfo risk_str;

    public static class RiskStrInfo implements CJPayObject {
        public Map<String, String> riskInfoParamsMap;

        public RiskStrInfo() {
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
            CJBasicCommonUtils.reportCatchException("FastPayRiskInfo#toJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "FastPayRiskInfo#toJson", e);
            e.printStackTrace();
            return null;
        }
    }

    public FastPayRiskInfo() {
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("risk_str", this.risk_str.toJson());     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(this.identity_token) == true) goto L6;
        r100.put("identity_token", this.identity_token);     // Catch: JSONException -> L7
    L6:
        return r100;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FastPayRiskInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FastPayRiskInfo#toJson", e);
        e.printStackTrace();
        return null;
    }
}
