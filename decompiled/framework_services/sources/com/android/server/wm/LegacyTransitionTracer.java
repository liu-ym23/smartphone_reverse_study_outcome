package com.android.server.wm;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.TraceBuffer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class LegacyTransitionTracer implements TransitionTracer {
    private static final int ACTIVE_TRACING_BUFFER_CAPACITY = 5120000;
    private static final int ALWAYS_ON_TRACING_CAPACITY = 15360;
    private static final int CHUNK_SIZE = 64;
    private static final String LOG_TAG = "TransitionTracer";
    private static final long MAGIC_NUMBER_VALUE = 4990904633914184276L;
    private static final String TRACE_FILE = "/data/misc/wmtrace/wm_transition_trace.winscope";
    static final String WINSCOPE_EXT = ".winscope";
    private volatile boolean mActiveTracingEnabled;
    private final Object mEnabledLock;
    private final TraceBuffer mTraceBuffer;

    private static class LogAndPrintln {
        /* JADX INFO: renamed from: -$$Nest$sme, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10051$$Nest$sme(PrintWriter r0, String r1) {
            e(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$sme, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10052$$Nest$sme(PrintWriter r0, String r1, Exception r2) {
            e(r0, r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$smi, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10053$$Nest$smi(PrintWriter r0, String r1) {
            i(r0, r1);
        }

        private LogAndPrintln() {
        }

        private static void i(PrintWriter pw, String msg) {
            Log.i(LegacyTransitionTracer.LOG_TAG, msg);
            if (pw == null) goto L6;
            pw.println(msg);
            pw.flush();
            return;
        }

        private static void e(PrintWriter pw, String msg) {
            Log.e(LegacyTransitionTracer.LOG_TAG, msg);
            if (pw == null) goto L6;
            pw.println("ERROR: " + msg);
            pw.flush();
            return;
        }

        private static void e(PrintWriter pw, String msg, Exception e) {
            Log.e(LegacyTransitionTracer.LOG_TAG, msg, e);
            if (pw == null) goto L6;
            pw.println("ERROR: " + msg + " ::\n " + e);
            pw.flush();
            return;
        }
    }

    LegacyTransitionTracer() {
        this.mTraceBuffer = new TraceBuffer(ALWAYS_ON_TRACING_CAPACITY);
        this.mEnabledLock = new Object();
        this.mActiveTracingEnabled = false;
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logSentTransition(Transition transition, ArrayList<Transition.ChangeInfo> targets) {
        ProtoOutputStream outputStream = new ProtoOutputStream(64);     // Catch: Exception -> L4
        long protoToken = outputStream.start(2246267895810L);     // Catch: Exception -> L4
        outputStream.write(1120986464257L, transition.getSyncId());     // Catch: Exception -> L4
        outputStream.write(1112396529668L, transition.mLogger.mCreateTimeNs);     // Catch: Exception -> L4
        outputStream.write(1112396529669L, transition.mLogger.mSendTimeNs);     // Catch: Exception -> L4
        outputStream.write(1116691496962L, transition.getStartTransaction().getId());     // Catch: Exception -> L4
        outputStream.write(1116691496963L, transition.getFinishTransaction().getId());     // Catch: Exception -> L4
        dumpTransitionTargetsToProto(outputStream, transition, targets);     // Catch: Exception -> L4
        outputStream.end(protoToken);     // Catch: Exception -> L4
        this.mTraceBuffer.add(outputStream);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Unexpected exception thrown while logging transitions", e);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logFinishedTransition(Transition transition) {
        ProtoOutputStream outputStream = new ProtoOutputStream(64);     // Catch: Exception -> L4
        long protoToken = outputStream.start(2246267895810L);     // Catch: Exception -> L4
        outputStream.write(1120986464257L, transition.getSyncId());     // Catch: Exception -> L4
        outputStream.write(1112396529670L, transition.mLogger.mFinishTimeNs);     // Catch: Exception -> L4
        outputStream.end(protoToken);     // Catch: Exception -> L4
        this.mTraceBuffer.add(outputStream);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Unexpected exception thrown while logging transitions", e);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logAbortedTransition(Transition transition) {
        ProtoOutputStream outputStream = new ProtoOutputStream(64);     // Catch: Exception -> L4
        long protoToken = outputStream.start(2246267895810L);     // Catch: Exception -> L4
        outputStream.write(1120986464257L, transition.getSyncId());     // Catch: Exception -> L4
        outputStream.write(1112396529674L, transition.mLogger.mAbortTimeNs);     // Catch: Exception -> L4
        outputStream.end(protoToken);     // Catch: Exception -> L4
        this.mTraceBuffer.add(outputStream);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Unexpected exception thrown while logging transitions", e);
    }

    @Override // com.android.server.wm.TransitionTracer
    public void logRemovingStartingWindow(StartingData startingData) {
        if (startingData.mTransitionId != 0) goto L10;
        return;
    L10:
        ProtoOutputStream outputStream = new ProtoOutputStream(64);     // Catch: Exception -> L7
        long protoToken = outputStream.start(2246267895810L);     // Catch: Exception -> L7
        outputStream.write(1120986464257L, startingData.mTransitionId);     // Catch: Exception -> L7
        outputStream.write(1112396529675L, SystemClock.elapsedRealtimeNanos());     // Catch: Exception -> L7
        outputStream.end(protoToken);     // Catch: Exception -> L7
        this.mTraceBuffer.add(outputStream);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "Unexpected exception thrown while logging transitions", e);
    }

    private void dumpTransitionTargetsToProto(ProtoOutputStream outputStream, Transition transition, ArrayList<Transition.ChangeInfo> targets) {
        Trace.beginSection("TransitionTracer#dumpTransitionTargetsToProto");
        if (this.mActiveTracingEnabled == false) goto L5;
        outputStream.write(1120986464257L, transition.getSyncId());
    L5:
        outputStream.write(1120986464263L, transition.mType);
        outputStream.write(1120986464265L, transition.getFlags());
        int i = 0;
    L7:
        if (i >= targets.size()) goto L16;
        long changeToken = outputStream.start(2246267895816L);
        Transition.ChangeInfo target = targets.get(i);
        if (target.mContainer.mSurfaceControl.isValid() == false) goto L11;
        int layerId = target.mContainer.mSurfaceControl.getLayerId();
    L12:
        outputStream.write(1120986464257L, target.mReadyMode);
        outputStream.write(1120986464260L, target.mReadyFlags);
        outputStream.write(1120986464258L, layerId);
        if (this.mActiveTracingEnabled == false) goto L15;
        int windowId = System.identityHashCode(target.mContainer);
        outputStream.write(1120986464259L, windowId);
    L15:
        outputStream.end(changeToken);
        i = i + 1;
        goto L7
    L11:
        layerId = -1;
        goto L12
    L16:
        Trace.endSection();
    }

    @Override // com.android.server.wm.TransitionTracer
    public void startTrace(PrintWriter pw) {
        if (Build.IS_USER == false) goto L6;
        LogAndPrintln.m10051$$Nest$sme(pw, "Tracing is not supported on user builds.");
        return;
    L6:
        Trace.beginSection("TransitionTracer#startTrace");
        LogAndPrintln.m10053$$Nest$smi(pw, "Starting shell transition trace.");
        Object r0 = this.mEnabledLock;
        monitor-enter(r0);
        this.mActiveTracingEnabled = true;     // Catch: Throwable -> L13
        this.mTraceBuffer.resetBuffer();     // Catch: Throwable -> L13
        this.mTraceBuffer.setCapacity(ACTIVE_TRACING_BUFFER_CAPACITY);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        Trace.endSection();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.TransitionTracer
    public void stopTrace(PrintWriter pw) {
        stopTrace(pw, new File(TRACE_FILE));
    }

    public void stopTrace(PrintWriter pw, File outputFile) {
        if (Build.IS_USER == false) goto L6;
        LogAndPrintln.m10051$$Nest$sme(pw, "Tracing is not supported on user builds.");
        return;
    L6:
        Trace.beginSection("TransitionTracer#stopTrace");
        LogAndPrintln.m10053$$Nest$smi(pw, "Stopping shell transition trace.");
        Object r0 = this.mEnabledLock;
        monitor-enter(r0);
        this.mActiveTracingEnabled = false;     // Catch: Throwable -> L13
        writeTraceToFileLocked(pw, outputFile);     // Catch: Throwable -> L13
        this.mTraceBuffer.resetBuffer();     // Catch: Throwable -> L13
        this.mTraceBuffer.setCapacity(ALWAYS_ON_TRACING_CAPACITY);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        Trace.endSection();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.TransitionTracer
    public void saveForBugreport(PrintWriter pw) {
        if (Build.IS_USER == false) goto L6;
        LogAndPrintln.m10051$$Nest$sme(pw, "Tracing is not supported on user builds.");
        return;
    L6:
        Trace.beginSection("TransitionTracer#saveForBugreport");
        Object r0 = this.mEnabledLock;
        monitor-enter(r0);
        File outputFile = new File(TRACE_FILE);     // Catch: Throwable -> L12
        writeTraceToFileLocked(pw, outputFile);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        Trace.endSection();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.TransitionTracer
    public boolean isTracing() {
        return this.mActiveTracingEnabled;
    }

    private void writeTraceToFileLocked(PrintWriter pw, File file) {
        Trace.beginSection("TransitionTracer#writeTraceToFileLocked");
        ProtoOutputStream proto = new ProtoOutputStream(64);     // Catch: IOException -> L5
        proto.write(1125281431553L, MAGIC_NUMBER_VALUE);     // Catch: IOException -> L5
        long timeOffsetNs = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()) - SystemClock.elapsedRealtimeNanos();     // Catch: IOException -> L5
        proto.write(1125281431555L, timeOffsetNs);     // Catch: IOException -> L5
        int pid = Process.myPid();     // Catch: IOException -> L5
        LogAndPrintln.m10053$$Nest$smi(pw, "Writing file to " + file.getAbsolutePath() + " from process " + pid);     // Catch: IOException -> L5
        this.mTraceBuffer.writeTraceToFile(file, proto);     // Catch: IOException -> L5
    L7:
        Trace.endSection();
        return;
    L5:
        e = move-exception;
        LogAndPrintln.m10052$$Nest$sme(pw, "Unable to write buffer to file", e);
        goto L7
    }
}
