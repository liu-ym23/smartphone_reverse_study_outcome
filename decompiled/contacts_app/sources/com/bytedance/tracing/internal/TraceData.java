package com.bytedance.tracing.internal;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.tracing.core.Span;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TraceData implements ITypeData {
    private final String service;
    private final Span span;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "tracing";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "tracing";
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
        return false;
    }

    public TraceData(Span r2) {
        this.service = r2.getServiceName();
        this.span = r2;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L17
        r1.put("log_type", TracingConstants.VALUE_TRACING);     // Catch: JSONException -> L17
        r1.put("service", this.service);     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_TRACE_ID, this.span.getTraceId() + "");     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_SPAN_ID, this.span.getSpanId() + "");     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_OP_NAME, this.span.getOperationName());     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_PARENT_ID, this.span.getParentId() + "");     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_REF_ID, this.span.getRefId() + "");     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_START_TIMESTAMP, this.span.getStartTs());     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_END_TIMESTAMP, this.span.getFinishTs());     // Catch: JSONException -> L17
        Map<String, String> r0 = this.span.getTags();     // Catch: JSONException -> L17
        if (r0 != null) goto L6;
    L8:
        List<LogData> r2 = this.span.getLogs();     // Catch: JSONException -> L17
        if (ListUtils.isEmpty(r2) == true) goto L15;
        JSONArray r3 = new JSONArray();     // Catch: JSONException -> L17
        Iterator<LogData> r4 = r2.iterator();     // Catch: JSONException -> L17
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.put(r4.next().toJson());     // Catch: JSONException -> L17
        goto L12
    L14:
        r1.put(TracingConstants.KEY_LOGS, r3);     // Catch: JSONException -> L17
    L15:
        r1.put(TracingConstants.KEY_THREAD_NAME, this.span.getThreadName());     // Catch: JSONException -> L17
        r1.put("hit_rules", TraceSettings.getInstance().isErrorOrSampleHit(this.span.isErrorTag(), this.service));     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_SAMPLE_RATE, TraceSettings.getInstance().getSampleRate(this.service));     // Catch: JSONException -> L17
        r1.put(TracingConstants.KEY_FINISH_FLAG, 1);     // Catch: JSONException -> L17
        return r1;
    L6:
        if (r0.isEmpty() == true) goto L8;
        r1.put(TracingConstants.KEY_TAGS, new JSONObject(this.span.getTags()));     // Catch: JSONException -> L17
    L17:
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r2) {
        if (TraceSettings.getInstance().isErrorOrSampleHit(this.span.isErrorTag(), this.service) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
