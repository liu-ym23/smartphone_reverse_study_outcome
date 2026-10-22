package com.bytedance.apm.trace.api;

import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.model.AbsTracing;
import com.bytedance.apm.trace.model.BatchTracing;
import com.bytedance.apm.trace.model.cross.NativeSpan;
import com.bytedance.apm.trace.model.cross.TracingCrossManager;
import com.bytedance.tracing.internal.utils.RandomUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class TracingContext {
    private final boolean forceTrace;
    private boolean isEnd;
    private boolean isStart;
    private boolean isWithCross;
    private final String service;
    private long startTs;
    private final long traceId;
    private AbsTracing tracing;
    private final TracingMode tracingMode;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.api.TracingContext$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm$trace$api$TracingMode = null;

        static {
            int[] r0 = new int[TracingMode.values().length];
            $SwitchMap$com$bytedance$apm$trace$api$TracingMode = r0;
            r0[TracingMode.BATCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    static /* synthetic */ AbsTracing access$000(TracingContext r0) {
        return r0.tracing;
    }

    static /* synthetic */ AbsTracing access$002(TracingContext r0, AbsTracing r1) {
        r0.tracing = r1;
        return r1;
    }

    public TracingContext(String r2, TracingMode r3) {
        this(r2, r3, false);
    }

    public TracingContext(String r3, TracingMode r4, boolean r5) {
        this.service = r3;
        this.traceId = RandomUtil.uniqueId();
        this.tracingMode = r4;
        this.forceTrace = r5;
    }

    public synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        rawStart(false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void startWithCross() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isWithCross = true;     // Catch: Throwable -> L11
        rawStart(true);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private void rawStart(boolean r4) {
        this.tracing = parseTracingMode(this.tracingMode);
        long r0 = System.currentTimeMillis();
        this.startTs = r0;
        this.tracing.startTrace(r0);
        this.isStart = true;
        if (r4 == false) goto L6;
        TracingCrossManager.registerCross(this.traceId, this);
        return;
    }

    public synchronized void end() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L13;
        final long r0 = System.currentTimeMillis();     // Catch: Throwable -> L15
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r0));     // Catch: Throwable -> L15
        this.isEnd = true;     // Catch: Throwable -> L15
        if (this.isWithCross == false) goto L11;
        TracingCrossManager.unRegisterCross(this.traceId);     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
    }

    public synchronized void end(long r5) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L17:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L17;
        final long r0 = System.currentTimeMillis();     // Catch: Throwable -> L19
        if ((r0 - this.startTs) <= r5) goto L11;
        cancel();     // Catch: Throwable -> L19
    L12:
        this.isEnd = true;     // Catch: Throwable -> L19
        if (this.isWithCross == false) goto L15;
        TracingCrossManager.unRegisterCross(this.traceId);     // Catch: Throwable -> L19
    L15:
        monitor-exit(this);
        return;
    L11:
        AsyncEventManager.getInstance().post(new AnonymousClass2(this, r0));     // Catch: Throwable -> L19
        goto L12
    }

    public synchronized void cancel() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L13;
        this.tracing.cancelTrace();     // Catch: Throwable -> L15
        this.tracing = null;     // Catch: Throwable -> L15
        this.isEnd = true;     // Catch: Throwable -> L15
        if (this.isWithCross == false) goto L11;
        TracingCrossManager.unRegisterCross(this.traceId);     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
    }

    public synchronized ITracingSpan createSpan(String r3) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L11:
        LaunchAnalysisContext.getInstance().logE(r3 + " is start after Trace finish or before Trace begin, it will be ignore!!!!");     // Catch: Throwable -> L15
        monitor-exit(this);
        return null;
    L6:
        if (this.isStart == false) goto L11;
        ITracingSpan r4 = this.tracing.createSpan(r3);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r4;
    }

    public synchronized ITracingWindowSpan createWindowSpan(String r3) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L11:
        LaunchAnalysisContext.getInstance().logE(r3 + " is start after Trace finish or before Trace begin, it will be ignore!!!!");     // Catch: Throwable -> L15
        monitor-exit(this);
        return null;
    L6:
        if (this.isStart == false) goto L11;
        ITracingWindowSpan r4 = this.tracing.createWindowSpan(r3);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r4;
    }

    public synchronized void addTracingTag(String r2, String r3) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L11;
        this.tracing.addTag(r2, r3);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public synchronized void assembleAsChild(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L21;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L23
        boolean r0 = true;
    L9:
        if (r8.hasNext() == false) goto L19;
        NativeSpan r1 = r8.next();     // Catch: Throwable -> L23
        if (r1 == null) goto L9;
        ITracingWindowSpan r2 = r1.parseToSpan(this.tracing);     // Catch: Throwable -> L23
        if (r0 == false) goto L17;
        r2.setParentId(Long.parseLong(r6));     // Catch: Throwable -> L23
    L17:
        r2.endWindowSpan(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L23
        r0 = false;
        goto L9
    L19:
        monitor-exit(this);
    }

    public synchronized void assembleAsReference(String r6, ArrayList<NativeSpan> r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.isEnd == false) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L21;
        Iterator<NativeSpan> r8 = r7.iterator();     // Catch: Throwable -> L23
        boolean r0 = true;
    L9:
        if (r8.hasNext() == false) goto L19;
        NativeSpan r1 = r8.next();     // Catch: Throwable -> L23
        if (r1 == null) goto L9;
        ITracingWindowSpan r2 = r1.parseToSpan(this.tracing);     // Catch: Throwable -> L23
        if (r0 == false) goto L17;
        r2.setReferenceId(Long.parseLong(r6));     // Catch: Throwable -> L23
    L17:
        r2.endWindowSpan(r1.getStartTime(), r1.getFinishTime());     // Catch: Throwable -> L23
        r0 = false;
        goto L9
    L19:
        monitor-exit(this);
    }

    public String getService() {
        return this.service;
    }

    public long getTraceId() {
        return this.traceId;
    }

    public boolean isForceTrace() {
        return this.forceTrace;
    }

    private AbsTracing parseTracingMode(TracingMode r2) {
        if (AnonymousClass3.$SwitchMap$com$bytedance$apm$trace$api$TracingMode[r2.ordinal()] == 1) goto L7;
        return null;
    L7:
        return new BatchTracing(this);
    }
}
