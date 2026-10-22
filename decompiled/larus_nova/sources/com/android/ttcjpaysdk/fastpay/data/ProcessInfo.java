package com.android.ttcjpaysdk.fastpay.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class ProcessInfo implements Serializable, CJPayObject {
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
        CJBasicCommonUtils.reportCatchException("ProcessInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ProcessInfo#toJson", e);
        e.printStackTrace();
        return null;
    }

    public ProcessInfo() {
        this.process_id = "";
        this.create_time = 0;
        this.process_info = "";
    }
}
