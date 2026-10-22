package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.FinanceRisk;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayRiskInfo implements Serializable, CJPayObject {
    private static final String TAG = "CJPayRiskInfo";
    public FinanceRisk finance_risk;
    public String identity_token;
    public RiskStrInfo risk_str;

    public static class RiskStrInfo implements Serializable, CJPayObject {
        public JSONObject hostScanInfo;
        public Map<String, String> jsonStringParamsMap;
        public Map<String, String> riskInfoParamsMap;

        public RiskStrInfo() {
        }

        public JSONObject toJson() {
            JSONObject r100 = new JSONObject();
            Map<String, String> r101 = this.riskInfoParamsMap;     // Catch: JSONException -> L30
            if (r101 != null) goto L6;
        L11:
            Map<String, String> r102 = this.jsonStringParamsMap;     // Catch: JSONException -> L30
            if (r102 == null) goto L21;
            Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();     // Catch: JSONException -> L30
        L15:
            if (r103.hasNext() == false) goto L21;
            Map.Entry<String, String> r104 = r103.next();     // Catch: JSONException -> L30
            JSONObject r105 = new JSONObject(r104.getValue());     // Catch: JSONException -> L19
            r100.put(r104.getKey(), r105);     // Catch: JSONException -> L19
        L19:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayRiskInfo#toJson", e);     // Catch: JSONException -> L30
            CJLogger.b(CJPayRiskInfo.TAG, e.getMessage());     // Catch: JSONException -> L30
        L21:
            SimpleDateFormat r106 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: JSONException -> L30
            JSONObject r107 = new JSONObject();     // Catch: JSONException -> L30
            int r108 = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;     // Catch: JSONException -> L30
            if (r108 <= 0) goto L25;
            StringBuilder r109 = new StringBuilder();     // Catch: JSONException -> L30
            r109.append(Marker.ANY_NON_NULL_MARKER);     // Catch: JSONException -> L30
            r109.append(r108);     // Catch: JSONException -> L30
        L26:
            r107.put("utc_offset", r109.toString());     // Catch: JSONException -> L30
            r107.put("timenow", r106.format(new Date()));     // Catch: JSONException -> L30
            r100.put("timestamp_local", r107);     // Catch: JSONException -> L30
            JSONObject r110 = this.hostScanInfo;     // Catch: JSONException -> L30
            if (r110 == null) goto L29;
            r100.put("host_scan_info", r110);     // Catch: JSONException -> L30
        L29:
            return r100;
        L25:
            r109 = new StringBuilder();     // Catch: JSONException -> L30
            r109.append("");     // Catch: JSONException -> L30
            r109.append(r108);     // Catch: JSONException -> L30
            goto L26
        L6:
            if (r101.size() <= 0) goto L11;
            Iterator<Map.Entry<String, String>> r111 = this.riskInfoParamsMap.entrySet().iterator();     // Catch: JSONException -> L30
        L9:
            if (r111.hasNext() == false) goto L11;
            Map.Entry<String, String> r112 = r111.next();     // Catch: JSONException -> L30
            r100.put(r112.getKey(), r112.getValue());     // Catch: JSONException -> L30
        L30:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayRiskInfo#toJson", e);
            CJLogger.b(CJPayRiskInfo.TAG, e.getMessage());
            return null;
        }
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        RiskStrInfo r101 = this.risk_str;     // Catch: JSONException -> L13
        if (r101 == null) goto L7;
        r100.put("risk_str", r101.toJson());     // Catch: JSONException -> L13
    L7:
        if (TextUtils.isEmpty(this.identity_token) == true) goto L9;
        r100.put("identity_token", this.identity_token);     // Catch: JSONException -> L13
    L9:
        FinanceRisk r102 = this.finance_risk;     // Catch: JSONException -> L13
        if (r102 == null) goto L12;
        r100.put("finance_risk", CJPayJsonParser.toJsonObject(r102));     // Catch: JSONException -> L13
    L12:
        return r100;
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayRiskInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayRiskInfo#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayRiskInfo() {
        this.finance_risk = null;
    }
}
