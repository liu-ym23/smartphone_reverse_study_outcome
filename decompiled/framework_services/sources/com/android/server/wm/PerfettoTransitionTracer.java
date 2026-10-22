package com.android.server.wm;

import android.os.SystemClock;
import android.os.Trace;
import android.tracing.perfetto.DataSourceParams;
import android.tracing.perfetto.InitArguments;
import android.tracing.perfetto.Producer;
import android.tracing.perfetto.TracingContext;
import android.tracing.transition.TransitionDataSource;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
class PerfettoTransitionTracer implements TransitionTracer {
    private final AtomicInteger mActiveTraces;
    private final TransitionDataSource mDataSource;

    /* JADX INFO: renamed from: $r8$lambda$H5wVlqeH1DTkwv-Szsq8DHh1DTk, reason: not valid java name */
    public static /* synthetic */ void m10078$r8$lambda$H5wVlqeH1DTkwvSzsq8DHh1DTk(Transition r0, TracingContext r1) {
        lambda$doLogAbortedTransition$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JZkCQNdivAkAsLS9zDPgPjXKvwM(PerfettoTransitionTracer r0, Transition r1, ArrayList r2, TracingContext r3) {
        r0.lambda$doLogSentTransition$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$JtzJffuPDPLiddD6poCsLwR5bbU(Transition r0, TracingContext r1) {
        lambda$doLogFinishTransition$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TE1SY5-YqI6jeItAkU2z7hG8UjU, reason: not valid java name */
    public static /* synthetic */ void m10079$r8$lambda$TE1SY5YqI6jeItAkU2z7hG8UjU() {
        lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$YxztuhFFk_HN26p2zP9tP57N4EA(StartingData r0, TracingContext r1) {
        lambda$doLogRemovingStartingWindow$4(r0, r1);
    }

    private static /* synthetic */ void lambda$new$0() {
    }

    PerfettoTransitionTracer() {
        this.mActiveTraces = new AtomicInteger(0);
        final AtomicInteger r2 = this.mActiveTraces;
        r2.getClass();
        Runnable r3 = new PerfettoTransitionTracer$$ExternalSyntheticLambda0(r2);
        Runnable r4 = new PerfettoTransitionTracer$$ExternalSyntheticLambda1();
        final AtomicInteger r5 = this.mActiveTraces;
        r5.getClass();
        this.mDataSource = new TransitionDataSource(r3, r4, new PerfettoTransitionTracer$$ExternalSyntheticLambda2(r5));
        Producer.init(InitArguments.DEFAULTS);
        DataSourceParams params = new DataSourceParams.Builder().setBufferExhaustedPolicy(0).build();
        this.mDataSource.register(params);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logSentTransition(Transition transition, ArrayList<Transition.ChangeInfo> targets) {
        if (isTracing() == true) goto L5;
        return;
    L5:
        Trace.traceBegin(32, "logSentTransition");
        doLogSentTransition(transition, targets);     // Catch: Throwable -> L9
        Trace.traceEnd(32);
        return;
    L9:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private void doLogSentTransition(final Transition transition, final ArrayList<Transition.ChangeInfo> targets) {
        this.mDataSource.trace(new PerfettoTransitionTracer$$ExternalSyntheticLambda3(this, transition, targets));
    }

    private /* synthetic */ void lambda$doLogSentTransition$1(Transition transition, ArrayList targets, TracingContext ctx) {
        ProtoOutputStream os = ctx.newTracePacket();
        long token = os.start(1146756268128L);
        os.write(1120986464257L, transition.getSyncId());
        os.write(1112396529666L, transition.mLogger.mCreateTimeNs);
        os.write(1112396529667L, transition.mLogger.mSendTimeNs);
        os.write(1116691496970L, transition.getStartTransaction().getId());
        os.write(1116691496971L, transition.getFinishTransaction().getId());
        os.write(1120986464269L, transition.mType);
        os.write(1120986464272L, transition.getFlags());
        addTransitionTargetsToProto(os, targets);
        os.end(token);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logFinishedTransition(Transition transition) {
        if (isTracing() == true) goto L5;
        return;
    L5:
        Trace.traceBegin(32, "logFinishedTransition");
        doLogFinishTransition(transition);     // Catch: Throwable -> L9
        Trace.traceEnd(32);
        return;
    L9:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private void doLogFinishTransition(final Transition transition) {
        this.mDataSource.trace(new PerfettoTransitionTracer$$ExternalSyntheticLambda4(transition));
    }

    private static /* synthetic */ void lambda$doLogFinishTransition$2(Transition transition, TracingContext ctx) {
        ProtoOutputStream os = ctx.newTracePacket();
        long token = os.start(1146756268128L);
        os.write(1120986464257L, transition.getSyncId());
        os.write(1112396529673L, transition.mLogger.mFinishTimeNs);
        os.end(token);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logAbortedTransition(Transition transition) {
        if (isTracing() == true) goto L5;
        return;
    L5:
        Trace.traceBegin(32, "logAbortedTransition");
        doLogAbortedTransition(transition);     // Catch: Throwable -> L9
        Trace.traceEnd(32);
        return;
    L9:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private void doLogAbortedTransition(final Transition transition) {
        this.mDataSource.trace(new PerfettoTransitionTracer$$ExternalSyntheticLambda6(transition));
    }

    private static /* synthetic */ void lambda$doLogAbortedTransition$3(Transition transition, TracingContext ctx) {
        ProtoOutputStream os = ctx.newTracePacket();
        long token = os.start(1146756268128L);
        os.write(1120986464257L, transition.getSyncId());
        os.write(1112396529672L, transition.mLogger.mAbortTimeNs);
        os.end(token);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logRemovingStartingWindow(StartingData startingData) {
        if (isTracing() == true) goto L5;
        return;
    L5:
        Trace.traceBegin(32, "logRemovingStartingWindow");
        doLogRemovingStartingWindow(startingData);     // Catch: Throwable -> L9
        Trace.traceEnd(32);
        return;
    L9:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    public void doLogRemovingStartingWindow(final StartingData startingData) {
        this.mDataSource.trace(new PerfettoTransitionTracer$$ExternalSyntheticLambda5(startingData));
    }

    private static /* synthetic */ void lambda$doLogRemovingStartingWindow$4(StartingData startingData, TracingContext ctx) {
        ProtoOutputStream os = ctx.newTracePacket();
        long token = os.start(1146756268128L);
        os.write(1120986464257L, startingData.mTransitionId);
        os.write(1112396529681L, SystemClock.elapsedRealtimeNanos());
        os.end(token);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void startTrace(PrintWriter pw) {
    }

    @Override // com.android.server.wm.TransitionTracer
    public void stopTrace(PrintWriter pw) {
    }

    @Override // com.android.server.wm.TransitionTracer
    public void saveForBugreport(PrintWriter pw) {
    }

    @Override // com.android.server.wm.TransitionTracer
    public boolean isTracing() {
        if (this.mActiveTraces.get() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void addTransitionTargetsToProto(ProtoOutputStream os, ArrayList<Transition.ChangeInfo> targets) {
        int i = 0;
    L4:
        if (i >= targets.size()) goto L11;
        Transition.ChangeInfo target = targets.get(i);
        if (target.mContainer.mSurfaceControl.isValid() == false) goto L8;
        int layerId = target.mContainer.mSurfaceControl.getLayerId();
    L9:
        int windowId = System.identityHashCode(target.mContainer);
        long token = os.start(2246267895822L);
        os.write(1120986464257L, target.mReadyMode);
        os.write(1120986464260L, target.mReadyFlags);
        os.write(1120986464258L, layerId);
        os.write(1120986464259L, windowId);
        os.end(token);
        i = i + 1;
        goto L4
    L8:
        layerId = -1;
        goto L9
    }
}
