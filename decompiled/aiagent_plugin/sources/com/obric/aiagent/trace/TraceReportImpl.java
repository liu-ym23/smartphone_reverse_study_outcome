package com.obric.aiagent.trace;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TraceReportImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TraceReportImpl implements ITraceReport {
    public TraceReportImpl() {
    }

    @Override // com.obric.aiagent.trace.ITraceReport
    public void init() {
        a.f22190a.a();
    }

    @Override // com.obric.aiagent.trace.ITraceReport
    public String getFlowDid() {
        return a.f22190a.b();
    }

    @Override // com.obric.aiagent.trace.ITraceReport
    public void whenFlowDidReady(b<? super String, x> r2) {
        b<? super String, x> r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        o.e(r1, "callback");
        a.f22190a.a(r1);
    }
}
