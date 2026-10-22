package com.bytedance.android.livesdkapi.livetrace;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILivePreviewTraceMonitor;", "", "monitorEvent", "", "traceMetaWrapper", "Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper;", "category", "Lorg/json/JSONObject;", "metric", "extra", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewTraceMonitor {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void monitorEvent$default(ILivePreviewTraceMonitor r100, TraceMetaWrapper r101, JSONObject r102, JSONObject r103, JSONObject r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r105 & 4) == 0) goto L10;
            r103 = null;
        L10:
            if ((r105 & 8) == 0) goto L12;
            r104 = null;
        L12:
            r100.monitorEvent(r101, r102, r103, r104);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitorEvent");
        }
    }

    void monitorEvent(TraceMetaWrapper r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
