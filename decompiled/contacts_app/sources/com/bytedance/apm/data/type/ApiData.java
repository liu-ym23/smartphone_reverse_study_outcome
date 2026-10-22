package com.bytedance.apm.data.type;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.data.ITypeData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApiData implements ITypeData {
    public String apiType;
    public long duration;
    public JSONObject extJson;
    public String sendIp;
    public long sendTime;
    public String sendUrl;
    public int status;
    public String traceCode;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public ApiData(String r1, long r2, long r4, String r6, String r7, String r8, int r9, JSONObject r10) {
        this.apiType = r1;
        this.duration = r2;
        this.sendTime = r4;
        this.sendUrl = r6;
        this.sendIp = r7;
        this.traceCode = r8;
        this.status = r9;
        if (r10 != null) goto L5;
        this.extJson = new JSONObject();
        return;
    L5:
        this.extJson = r10;
    }

    public void appendFront(boolean r3) throws JSONException {
        if (this.extJson.isNull("front") == false) goto L6;
        this.extJson.put("front", r3 ? 1 : 0);
        return;
    }

    public void appendConsumeType(String r3) throws JSONException {
        if (this.extJson.isNull(TrafficConsts.KEY_NET_CONSUME_TYPE) == false) goto L6;
        this.extJson.put(TrafficConsts.KEY_NET_CONSUME_TYPE, r3);
        return;
    }

    public void appendLaunchTraceInfo() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put(TraceStatsConsts.STATS_KEY_TRACE_BASE, ApmContext.getAppLaunchStartTimestamp());     // Catch: JSONException -> L4
        this.extJson.put("relate_start_trace", r0);     // Catch: JSONException -> L4
        return;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        if (TextUtils.isEmpty(this.apiType) == false) goto L18;
        return null;
    L18:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L17
        r0.put("log_type", this.apiType);     // Catch: Exception -> L17
        r0.put("duration", this.duration);     // Catch: Exception -> L17
        r0.put("uri", Uri.parse(this.sendUrl));     // Catch: Exception -> L17
        long r2 = this.sendTime;     // Catch: Exception -> L17
        if (r2 <= 0) goto L8;
        r0.put("timestamp", r2);     // Catch: Exception -> L17
    L8:
        r0.put("status", this.status);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(this.sendIp) == true) goto L13;
        r0.put("ip", this.sendIp);     // Catch: Exception -> L17
    L13:
        if (TextUtils.isEmpty(this.traceCode) == true) goto L15;
        r0.put("trace_code", this.traceCode);     // Catch: Exception -> L17
    L16:
        return r0;
    L15:
        r0.put("trace_code", "");     // Catch: Exception -> L17
    L17:
        return null;
    }
}
