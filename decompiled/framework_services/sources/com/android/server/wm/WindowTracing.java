package com.android.server.wm;

import android.os.Build;
import android.os.ShellCommand;
import android.os.Trace;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import android.view.Choreographer;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
abstract class WindowTracing {
    protected static final String TAG = "WindowTracing";
    protected static final String WHERE_ON_FRAME = "onFrame";
    protected static final String WHERE_START_TRACING = "trace.enable";
    private final Choreographer mChoreographer;
    private final Choreographer.FrameCallback mFrameCallback;
    private final WindowManagerGlobalLock mGlobalLock;
    private AtomicBoolean mScheduled;
    private final WindowManagerService mService;

    public static /* synthetic */ void $r8$lambda$PCVd_OZa7AR1VUIpYvVBTxPVKdE(WindowTracing r0, long r1) {
        r0.lambda$new$0(r1);
    }

    abstract String getStatus();

    abstract boolean isEnabled();

    protected abstract void log(String r1);

    abstract int onShellCommand(ShellCommand r1);

    protected abstract void saveForBugreportInternal(PrintWriter r1);

    abstract void setBufferCapacity(int r1, PrintWriter r2);

    abstract void setLogFrequency(boolean r1, PrintWriter r2);

    abstract void setLogLevel(int r1, PrintWriter r2);

    protected abstract boolean shouldLogOnFrame();

    protected abstract boolean shouldLogOnTransaction();

    protected abstract void startTraceInternal(PrintWriter r1);

    protected abstract void stopTraceInternal(PrintWriter r1);

    private /* synthetic */ void lambda$new$0(long frameTimeNanos) {
        log(WHERE_ON_FRAME);
    }

    static WindowTracing createDefaultAndStartLooper(WindowManagerService service, Choreographer choreographer) {
        return new WindowTracingLegacy(service, choreographer);
    }

    protected WindowTracing(WindowManagerService service, Choreographer choreographer, WindowManagerGlobalLock globalLock) {
        this.mFrameCallback = new WindowTracing$$ExternalSyntheticLambda0(this);
        this.mScheduled = new AtomicBoolean(false);
        this.mChoreographer = choreographer;
        this.mService = service;
        this.mGlobalLock = globalLock;
    }

    void startTrace(PrintWriter pw) {
        if (Build.IS_USER == false) goto L6;
        logAndPrintln(pw, "Error: Tracing is not supported on user builds.");
        return;
    L6:
        startTraceInternal(pw);
    }

    void stopTrace(PrintWriter pw) {
        if (Build.IS_USER == false) goto L6;
        logAndPrintln(pw, "Error: Tracing is not supported on user builds.");
        return;
    L6:
        stopTraceInternal(pw);
    }

    void saveForBugreport(PrintWriter pw) {
        if (Build.IS_USER == false) goto L6;
        logAndPrintln(pw, "Error: Tracing is not supported on user builds.");
        return;
    L6:
        saveForBugreportInternal(pw);
    }

    void logState(String where) {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (shouldLogOnTransaction() == false) goto L9;
        log(where);
    L9:
        if (shouldLogOnFrame() == false) goto L12;
        schedule();
        return;
    }

    private void schedule() {
        if (this.mScheduled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.mChoreographer.postFrameCallback(this.mFrameCallback);
    }

    protected void dumpToProto(ProtoOutputStream os, int logLevel, String where, long elapsedRealtimeNanos) {
        Trace.traceBegin(32, "traceStateLocked");
        boolean isOnFrameLogEvent = true;
        os.write(1125281431553L, elapsedRealtimeNanos);     // Catch: Throwable -> L15 Exception -> L17
        os.write(1138166333442L, where);     // Catch: Throwable -> L15 Exception -> L17
        long token = os.start(1146756268035L);     // Catch: Throwable -> L15 Exception -> L17
        WindowManagerGlobalLock r6 = this.mGlobalLock;     // Catch: Throwable -> L15 Exception -> L17
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L15 Exception -> L17
        monitor-enter(r6);     // Catch: Throwable -> L15 Exception -> L17
        this.mService.dumpDebugLocked(os, logLevel);     // Catch: Throwable -> L19
        monitor-exit(r6);     // Catch: Throwable -> L19
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L15 Exception -> L17
        os.end(token);     // Catch: Throwable -> L15 Exception -> L17
        if (where == WHERE_ON_FRAME) goto L12;
        isOnFrameLogEvent = false;
    L12:
        if (isOnFrameLogEvent == false) goto L14;
    L13:
        this.mScheduled.set(false);
    L14:
        Trace.traceEnd(32);
        return;
    L19:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L15 Exception -> L17
        throw th;     // Catch: Throwable -> L15 Exception -> L17
    L17:
        e = move-exception;
        Log.wtf(TAG, "Exception while tracing state", e);     // Catch: Throwable -> L15
        if (where == WHERE_ON_FRAME) goto L29;
        isOnFrameLogEvent = false;
    L29:
        if (isOnFrameLogEvent == false) goto L14;
    L15:
        th = move-exception;
        if (where == WHERE_ON_FRAME) goto L36;
        isOnFrameLogEvent = false;
    L36:
        if (isOnFrameLogEvent == false) goto L38;
        this.mScheduled.set(false);
    L38:
        Trace.traceEnd(32);
        throw th;
    }

    protected void logAndPrintln(PrintWriter pw, String msg) {
        Log.i(TAG, msg);
        if (pw == null) goto L6;
        pw.println(msg);
        pw.flush();
        return;
    }
}
