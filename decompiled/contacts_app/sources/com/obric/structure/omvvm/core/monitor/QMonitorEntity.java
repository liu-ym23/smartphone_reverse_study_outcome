package com.obric.structure.omvvm.core.monitor;

import com.bytedance.apm.constant.TraceStatsConsts;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QMonitorEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/obric/structure/omvvm/core/monitor/QMonitorEntity;", "", "key", "", "(J)V", TraceStatsConsts.STATS_KEY_END, "getEnd", "()J", "setEnd", "error", "", "getError", "()Z", "setError", "(Z)V", "getKey", "stack", "", "Ljava/lang/StackTraceElement;", "getStack", "()[Ljava/lang/StackTraceElement;", "setStack", "([Ljava/lang/StackTraceElement;)V", "[Ljava/lang/StackTraceElement;", "start", "getStart", "setStart", "toString", "", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QMonitorEntity {
    private long end;
    private boolean error;
    private final long key;
    private StackTraceElement[] stack;
    private long start;

    public QMonitorEntity(long r1) {
        this.key = r1;
    }

    public final long getKey() {
        return this.key;
    }

    public final long getStart() {
        return this.start;
    }

    public final void setStart(long r1) {
        this.start = r1;
    }

    public final long getEnd() {
        return this.end;
    }

    public final void setEnd(long r1) {
        this.end = r1;
    }

    public final StackTraceElement[] getStack() {
        return this.stack;
    }

    public final void setStack(StackTraceElement[] r1) {
        this.stack = r1;
    }

    public final boolean getError() {
        return this.error;
    }

    public final void setError(boolean r1) {
        this.error = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("QMonitorEntity(key=").append(this.key).append(", start=").append(this.start).append(", end=").append(this.end).append(", stack=");
        StackTraceElement[] r1 = this.stack;
        if (r1 == null) goto L5;
        String r2 = Arrays.toString(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "toString(this)");
    L7:
        return r0.append(r2).append(", error=").append(this.error).append(')').toString();
    L5:
        r2 = null;
        goto L7
    }
}
