package com.android.ttcjpaysdk.superpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayProcessInfo implements Serializable, CJPayObject {
    public long create_time;
    public String process_id;
    public String process_info;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put(CrashHianalyticsData.PROCESS_ID, this.process_id);     // Catch: JSONException -> L5
        r100.put("create_time", this.create_time);     // Catch: JSONException -> L5
        r100.put("process_info", this.process_info);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayProcessInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayProcessInfo#toJson", e);
        return null;
    }

    public CJPayProcessInfo() {
        this.process_id = "";
        this.create_time = 0;
        this.process_info = "";
    }
}
