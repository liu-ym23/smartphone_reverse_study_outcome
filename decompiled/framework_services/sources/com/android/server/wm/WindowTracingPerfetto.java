package com.android.server.wm;

import android.os.ShellCommand;
import android.os.SystemClock;
import android.tracing.perfetto.TracingContext;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import android.view.Choreographer;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
class WindowTracingPerfetto extends WindowTracing {
    private static final String PRODUCTION_DATA_SOURCE_NAME = "android.windowmanager";
    private static final String TAG = "WindowTracing";
    private final AtomicInteger mCountSessionsOnFrame;
    private final AtomicInteger mCountSessionsOnTransaction;
    private final WindowTracingDataSource mDataSource;

    /* JADX INFO: renamed from: $r8$lambda$FVcHj5D-VNRpwx8tAWr3qy03_iI, reason: not valid java name */
    public static /* synthetic */ void m10486$r8$lambda$FVcHj5DVNRpwx8tAWr3qy03_iI(WindowTracingPerfetto r0, boolean r1, boolean r2, String r3, TracingContext r4) {
        r0.lambda$log$0(r1, r2, r3, r4);
    }

    WindowTracingPerfetto(WindowManagerService service, Choreographer choreographer) {
        this(service, choreographer, service.mGlobalLock, PRODUCTION_DATA_SOURCE_NAME);
    }

    WindowTracingPerfetto(WindowManagerService service, Choreographer choreographer, WindowManagerGlobalLock globalLock, String dataSourceName) {
        super(service, choreographer, globalLock);
        this.mCountSessionsOnFrame = new AtomicInteger();
        this.mCountSessionsOnTransaction = new AtomicInteger();
        this.mDataSource = new WindowTracingDataSource(this, dataSourceName);
    }

    @Override // com.android.server.wm.WindowTracing
    void setLogLevel(int logLevel, PrintWriter pw) {
        logAndPrintln(pw, "Log level must be configured through perfetto");
    }

    @Override // com.android.server.wm.WindowTracing
    void setLogFrequency(boolean onFrame, PrintWriter pw) {
        logAndPrintln(pw, "Log frequency must be configured through perfetto");
    }

    @Override // com.android.server.wm.WindowTracing
    void setBufferCapacity(int capacity, PrintWriter pw) {
        logAndPrintln(pw, "Buffer capacity must be configured through perfetto");
    }

    @Override // com.android.server.wm.WindowTracing
    boolean isEnabled() {
        if ((this.mCountSessionsOnFrame.get() + this.mCountSessionsOnTransaction.get()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.WindowTracing
    int onShellCommand(ShellCommand shell) {
        PrintWriter pw = shell.getOutPrintWriter();
        pw.println("Shell commands are ignored. Any type of action should be performed through perfetto.");
        return -1;
    }

    @Override // com.android.server.wm.WindowTracing
    String getStatus() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Status: ");
        if (isEnabled() == false) goto L5;
        String r1 = "Enabled";
    L6:
        r0.append(r1);
        r0.append("\nSessions logging 'on frame': ");
        r0.append(this.mCountSessionsOnFrame.get());
        r0.append("\nSessions logging 'on transaction': ");
        r0.append(this.mCountSessionsOnTransaction.get());
        r0.append("\n");
        return r0.toString();
    L5:
        r1 = "Disabled";
        goto L6
    }

    @Override // com.android.server.wm.WindowTracing
    protected void startTraceInternal(PrintWriter pw) {
        logAndPrintln(pw, "Tracing must be started through perfetto");
    }

    @Override // com.android.server.wm.WindowTracing
    protected void stopTraceInternal(PrintWriter pw) {
        logAndPrintln(pw, "Tracing must be stopped through perfetto");
    }

    @Override // com.android.server.wm.WindowTracing
    protected void saveForBugreportInternal(PrintWriter pw) {
        logAndPrintln(pw, "Tracing snapshot for bugreport must be handled through perfetto");
    }

    @Override // com.android.server.wm.WindowTracing
    protected void log(final String where) {
        final boolean isOnFrameLogEvent = false;
        if (where != "trace.enable") goto L5;
        final boolean isStartLogEvent = true;
    L7:
        if (where != "onFrame") goto L14;
        isOnFrameLogEvent = true;
    L14:
        this.mDataSource.trace(new WindowTracingPerfetto$$ExternalSyntheticLambda0(this, isStartLogEvent, isOnFrameLogEvent, where));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Log.wtf(TAG, "Exception while tracing state", e);
        return;
    L5:
        isStartLogEvent = false;
        goto L7
    }

    private /* synthetic */ void lambda$log$0(boolean isStartLogEvent, boolean isOnFrameLogEvent, String where, TracingContext context) {
        WindowTracingDataSource.Config dataSourceConfig = ((WindowTracingDataSource.TlsState) context.getCustomTlsState()).mConfig;
        boolean isDataSourceLoggingOnFrame = false;
        if (isStartLogEvent == false) goto L8;
        boolean isDataSourceStarting = ((WindowTracingDataSource.TlsState) context.getCustomTlsState()).mIsStarting.compareAndSet(true, false);
        if (isDataSourceStarting == true) goto L19;
        return;
    L19:
        ProtoOutputStream os = context.newTracePacket();
        long timestamp = SystemClock.elapsedRealtimeNanos();
        os.write(1116691496968L, timestamp);
        long tokenWinscopeExtensions = os.start(1146756268144L);
        long tokenExtensionsField = os.start(1146756268038L);
        dumpToProto(os, dataSourceConfig.mLogLevel, where, timestamp);
        os.end(tokenExtensionsField);
        os.end(tokenWinscopeExtensions);
        return;
    L8:
        if (isOnFrameLogEvent == false) goto L17;
        if (dataSourceConfig.mLogFrequency != 0) goto L12;
        isDataSourceLoggingOnFrame = true;
    L12:
        if (isDataSourceLoggingOnFrame == true) goto L19;
        return;
    L17:
        if (dataSourceConfig.mLogFrequency != 2) goto L19;
    }

    @Override // com.android.server.wm.WindowTracing
    protected boolean shouldLogOnFrame() {
        if (this.mCountSessionsOnFrame.get() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.WindowTracing
    protected boolean shouldLogOnTransaction() {
        if (this.mCountSessionsOnTransaction.get() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void onStart(WindowTracingDataSource.Config config) {
        if (config.mLogFrequency != 0) goto L6;
        Log.i(TAG, "Started session (frequency=FRAME, log level=" + config.mLogFrequency + ")");
        this.mCountSessionsOnFrame.incrementAndGet();
    L8:
        Log.i(TAG, getStatus());
        log("trace.enable");
        return;
    L6:
        if (config.mLogFrequency != 1) goto L8;
        Log.i(TAG, "Started session (frequency=TRANSACTION, log level=" + config.mLogFrequency + ")");
        this.mCountSessionsOnTransaction.incrementAndGet();
        goto L8
    }

    void onStop(WindowTracingDataSource.Config config) {
        if (config.mLogFrequency != 0) goto L6;
        Log.i(TAG, "Stopped session (frequency=FRAME)");
        this.mCountSessionsOnFrame.decrementAndGet();
        Log.i(TAG, "Stopped session (frequency=TRANSACTION)");
    L8:
        Log.i(TAG, getStatus());
        return;
    L6:
        if (config.mLogFrequency != 1) goto L8;
        this.mCountSessionsOnTransaction.decrementAndGet();
        goto L8
    }
}
