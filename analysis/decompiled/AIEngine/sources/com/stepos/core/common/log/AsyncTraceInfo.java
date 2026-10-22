package com.stepos.core.common.log;

import com.stepos.core.common.log.PerfettoTrace;
import com.stepos.core.common.log.TraceContext;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsyncTraceInfo {
    private final PerfettoTrace.AsyncTraceToken asyncToken;
    private final TraceContext.TraceInfo traceInfo;

    public AsyncTraceInfo(TraceContext.TraceInfo traceInfo, PerfettoTrace.AsyncTraceToken asyncTraceToken) {
        g.f(traceInfo, "traceInfo");
        this.traceInfo = traceInfo;
        this.asyncToken = asyncTraceToken;
    }

    public static /* synthetic */ AsyncTraceInfo copy$default(AsyncTraceInfo asyncTraceInfo, TraceContext.TraceInfo traceInfo, PerfettoTrace.AsyncTraceToken asyncTraceToken, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            traceInfo = asyncTraceInfo.traceInfo;
        }
        if ((i10 & 2) != 0) {
            asyncTraceToken = asyncTraceInfo.asyncToken;
        }
        return asyncTraceInfo.copy(traceInfo, asyncTraceToken);
    }

    public final TraceContext.TraceInfo component1() {
        return this.traceInfo;
    }

    public final PerfettoTrace.AsyncTraceToken component2() {
        return this.asyncToken;
    }

    public final AsyncTraceInfo copy(TraceContext.TraceInfo traceInfo, PerfettoTrace.AsyncTraceToken asyncTraceToken) {
        g.f(traceInfo, "traceInfo");
        return new AsyncTraceInfo(traceInfo, asyncTraceToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsyncTraceInfo)) {
            return false;
        }
        AsyncTraceInfo asyncTraceInfo = (AsyncTraceInfo) obj;
        return g.b(this.traceInfo, asyncTraceInfo.traceInfo) && g.b(this.asyncToken, asyncTraceInfo.asyncToken);
    }

    public final PerfettoTrace.AsyncTraceToken getAsyncToken() {
        return this.asyncToken;
    }

    public final TraceContext.TraceInfo getTraceInfo() {
        return this.traceInfo;
    }

    public int hashCode() {
        int iHashCode = this.traceInfo.hashCode() * 31;
        PerfettoTrace.AsyncTraceToken asyncTraceToken = this.asyncToken;
        return iHashCode + (asyncTraceToken == null ? 0 : asyncTraceToken.hashCode());
    }

    public String toString() {
        return "AsyncTraceInfo(traceInfo=" + this.traceInfo + ", asyncToken=" + this.asyncToken + ")";
    }
}
