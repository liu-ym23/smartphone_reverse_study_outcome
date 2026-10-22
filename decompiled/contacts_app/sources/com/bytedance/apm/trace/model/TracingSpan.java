package com.bytedance.apm.trace.model;

import android.text.TextUtils;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.tracing.internal.LogData;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.tracing.internal.utils.RandomUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TracingSpan implements ITracingSpan, ITracingWindowSpan {
    private long endTime;
    private boolean errorTag;
    private final String logType;
    private List<LogData> logs;
    private long parentId;
    private long referenceId;
    private final long spanId;
    private final String spanName;
    private long startTime;
    private Map<String, String> tags;
    private String threadName;
    private final AbsTracing tracing;

    static /* synthetic */ long access$000(TracingSpan r2) {
        return r2.spanId;
    }

    static /* synthetic */ JSONObject access$100(TracingSpan r0) {
        return r0.packageData();
    }

    static /* synthetic */ boolean access$200(TracingSpan r0) {
        return r0.errorTag;
    }

    static /* synthetic */ AbsTracing access$300(TracingSpan r0) {
        return r0.tracing;
    }

    TracingSpan(String r7, String r8, AbsTracing r9) {
        this(r7, r8, r9, RandomUtil.uniqueId());
    }

    TracingSpan(String r1, String r2, AbsTracing r3, long r4) {
        this.spanName = r1;
        this.tracing = r3;
        this.logType = r2;
        this.spanId = r4;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan setParentId(long r1) {
        this.parentId = r1;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan setThreadName(String r1) {
        this.threadName = r1;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan setReferenceId(long r1) {
        this.referenceId = r1;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingWindowSpan
    public void endWindowSpan(long r2, long r4) {
        String r0 = this.threadName;
        if (r0 != null) goto L5;
    L6:
        this.threadName = Thread.currentThread().getName();
    L7:
        this.startTime = r2;
        this.endTime = r4;
        AsyncEventManager.getInstance().post(new AnonymousClass1(this));
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpan
    public void endSpan() {
        String r0 = this.threadName;
        if (r0 != null) goto L5;
    L6:
        this.threadName = Thread.currentThread().getName();
    L7:
        this.endTime = System.currentTimeMillis();
        AsyncEventManager.getInstance().post(new AnonymousClass2(this));
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpan
    public void startSpan() {
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan addTag(String r2, String r3) {
        this.tracing.addSpanTagKey(r2);
        if (this.tags != null) goto L6;
        this.tags = new HashMap();
    L6:
        if (TextUtils.equals(r2, "error") == false) goto L8;
        this.errorTag = true;
    L8:
        this.tags.put(r2, r3);
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan addLog(String r6) {
        if (r6 != null) goto L5;
        return this;
    L5:
        if (this.logs != null) goto L7;
        this.logs = new LinkedList();
    L7:
        this.logs.add(new LogData(System.currentTimeMillis(), r6, null));
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan addLog(String r5, Map<String, String> r6) {
        if (r5 != null) goto L5;
        return this;
    L5:
        if (this.logs != null) goto L7;
        this.logs = new LinkedList();
    L7:
        this.logs.add(new LogData(System.currentTimeMillis(), r5, r6));
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public void setErrorTag(String r2) {
        this.errorTag = true;
        this.tags.put("error", r2);
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getSpanId() {
        return this.spanId;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getParentId() {
        return this.parentId;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getReferenceId() {
        return this.referenceId;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public TracingContext getTracingContext() {
        return this.tracing.context;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public String getSpanName() {
        return this.spanName;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getFinishTime() {
        return this.endTime;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public List<LogData> getLogs() {
        return this.logs;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public Map<String, String> getTags() {
        return this.tags;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public String getThreadName() {
        return this.threadName;
    }

    private JSONObject packageData() {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L23
        r1.put("log_type", this.logType);     // Catch: JSONException -> L23
        r1.put(TracingConstants.KEY_SPAN_ID, this.spanId + "");     // Catch: JSONException -> L23
        r1.put(TracingConstants.KEY_OP_NAME, this.spanName);     // Catch: JSONException -> L23
        if (this.parentId == 0) goto L7;
        r1.put(TracingConstants.KEY_PARENT_ID, this.parentId + "");     // Catch: JSONException -> L23
    L7:
        if (this.referenceId == 0) goto L9;
        r1.put(TracingConstants.KEY_REF_ID, this.referenceId + "");     // Catch: JSONException -> L23
    L9:
        r1.put(TracingConstants.KEY_START_TIMESTAMP, this.startTime);     // Catch: JSONException -> L23
        r1.put(TracingConstants.KEY_END_TIMESTAMP, this.endTime);     // Catch: JSONException -> L23
        Map<String, String> r0 = this.tags;     // Catch: JSONException -> L23
        if (r0 == null) goto L15;
        if (r0.isEmpty() == true) goto L15;
        r1.put(TracingConstants.KEY_TAGS, new JSONObject(this.tags));     // Catch: JSONException -> L23
    L15:
        if (ListUtils.isEmpty(this.logs) == true) goto L21;
        JSONArray r2 = new JSONArray();     // Catch: JSONException -> L23
        Iterator<LogData> r3 = this.logs.iterator();     // Catch: JSONException -> L23
    L18:
        if (r3.hasNext() == false) goto L20;
        r2.put(r3.next().toJson());     // Catch: JSONException -> L23
        goto L18
    L20:
        r1.put(TracingConstants.KEY_LOGS, r2);     // Catch: JSONException -> L23
    L21:
        r1.put(TracingConstants.KEY_THREAD_NAME, this.threadName);     // Catch: JSONException -> L23
        r1.put(TracingConstants.KEY_FINISH_FLAG, 1);     // Catch: JSONException -> L23
        return r1;
    L23:
        return null;
    }
}
