package com.bytedance.apm.trace.model;

import android.util.Log;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.tracing.internal.BatchTracingLogWrapUtils;
import com.bytedance.tracing.internal.TraceSettings;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.tracing.internal.TracingData;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BatchTracing extends AbsTracing {
    private AtomicBoolean isFinish;
    private List<JSONObject> spanCacheData;
    private List<Long> spanIdCache;

    public BatchTracing(TracingContext r2) {
        super(r2);
        this.spanCacheData = new CopyOnWriteArrayList();
        this.spanIdCache = new CopyOnWriteArrayList();
        this.isFinish = new AtomicBoolean(false);
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void endTrace(long r7) {
        if (this.isFinish.get() == false) goto L5;
        return;
    L5:
        this.isFinish.set(true);
        checkTagKey();     // Catch: Throwable -> L17 JSONException -> L19
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L17 JSONException -> L19
        r2.put(TracingConstants.KEY_START_TIMESTAMP, this.startTs);     // Catch: Throwable -> L17 JSONException -> L19
        r2.put(TracingConstants.KEY_END_TIMESTAMP, r7);     // Catch: Throwable -> L17 JSONException -> L19
        r2.put(TracingConstants.KEY_FINISH_FLAG, 1);     // Catch: Throwable -> L17 JSONException -> L19
        r2.put(TracingConstants.KEY_REPORT_MODE, 1);     // Catch: Throwable -> L17 JSONException -> L19
        r2.put(TracingConstants.KEY_INSERT_MODE, 2);     // Catch: Throwable -> L17 JSONException -> L19
        r2.put("log_type", TracingConstants.TRACE_LOG_TYPE);     // Catch: Throwable -> L17 JSONException -> L19
        packageCommonParam(r2, false);     // Catch: Throwable -> L17 JSONException -> L19
        if (this.tags != null) goto L9;
    L11:
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L17 JSONException -> L19
        r8.put(r2);     // Catch: Throwable -> L17 JSONException -> L19
        Iterator<JSONObject> r9 = this.spanCacheData.iterator();     // Catch: Throwable -> L17 JSONException -> L19
    L13:
        if (r9.hasNext() == false) goto L15;
        r8.put(r9.next());     // Catch: Throwable -> L17 JSONException -> L19
        goto L13
    L15:
        LaunchAnalysisContext.getInstance().logD(BatchTracingLogWrapUtils.wrapData(r8) + "");     // Catch: Throwable -> L17 JSONException -> L19
        CommonDataPipeline.getInstance().handle(new TracingData(BatchTracingLogWrapUtils.wrapData(r8), this.context.getService(), false, "batch_tracing"));     // Catch: Throwable -> L17 JSONException -> L19
    L21:
        this.spanCacheData.clear();
        return;
    L9:
        if (this.tags.isEmpty() == true) goto L11;
        r2.put(TracingConstants.KEY_TAGS, new JSONObject(this.tags));     // Catch: Throwable -> L17 JSONException -> L19
    L17:
        th = move-exception;
        this.spanCacheData.clear();
        throw th;
    L19:
        e = move-exception;
        Logger.e("TracingData", new String[]{"error when BatchTracing end trace: " + e.getLocalizedMessage()});     // Catch: Throwable -> L17
        goto L21
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void finishSpan(long r3, JSONObject r5, boolean r6) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.isFinish.get() == false) goto L9;
        LaunchAnalysisContext.getInstance().logE(r5 + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
        return;
    L9:
        if (this.spanIdCache.contains(Long.valueOf(r3)) == false) goto L21;
        return;
    L21:
    L18:
        th = move-exception;
        Log.e("TracingData", "error: " + th.getLocalizedMessage());
        return;
    L12:
        if (this.context.isForceTrace() == false) goto L14;
    L16:
        packageCommonParam(r5, r6);     // Catch: Throwable -> L18
        this.spanCacheData.add(r5);     // Catch: Throwable -> L18
        this.spanIdCache.add(Long.valueOf(r3));     // Catch: Throwable -> L18
        return;
    L14:
        if (TraceSettings.getInstance().isErrorOrSampleHit(r6, this.context.getService()) != 0) goto L16;
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void cancelTrace() {
        this.isFinish.set(true);
        this.spanCacheData.clear();
        this.spanIdCache.clear();
    }
}
