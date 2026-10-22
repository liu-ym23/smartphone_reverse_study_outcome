package com.android.server.wm;

import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import android.view.Choreographer;
import com.android.internal.util.TraceBuffer;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class WindowTracingLegacy extends WindowTracing {
    private static final int BUFFER_CAPACITY_ALL = 20971520;
    private static final int BUFFER_CAPACITY_CRITICAL = 5242880;
    private static final int BUFFER_CAPACITY_TRIM = 10485760;
    private static final long MAGIC_NUMBER_VALUE = 4990904633914181975L;
    private static final String TAG = "WindowTracing";
    private static final String TRACE_FILENAME = "/data/misc/wmtrace/wm_trace.winscope";
    static final String WINSCOPE_EXT = ".winscope";
    private final TraceBuffer mBuffer;
    private boolean mEnabled;
    private final Object mEnabledLock;
    private volatile boolean mEnabledLockFree;
    protected int mLogLevel;
    protected boolean mLogOnFrame;
    private final File mTraceFile;

    WindowTracingLegacy(WindowManagerService service, Choreographer choreographer) {
        this(new File(TRACE_FILENAME), service, choreographer, service.mGlobalLock, BUFFER_CAPACITY_TRIM);
    }

    WindowTracingLegacy(File traceFile, WindowManagerService service, Choreographer choreographer, WindowManagerGlobalLock globalLock, int bufferSize) {
        super(service, choreographer, globalLock);
        this.mEnabledLock = new Object();
        this.mLogLevel = 1;
        this.mLogOnFrame = false;
        this.mTraceFile = traceFile;
        this.mBuffer = new TraceBuffer(bufferSize);
    }

    @Override // com.android.server.wm.WindowTracing
    void setLogLevel(int logLevel, PrintWriter pw) {
        logAndPrintln(pw, "Setting window tracing log level to " + logLevel);
        this.mLogLevel = logLevel;
        switch(logLevel) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        setBufferCapacity(BUFFER_CAPACITY_CRITICAL, pw);
        return;
    L6:
        setBufferCapacity(BUFFER_CAPACITY_TRIM, pw);
        return;
    L7:
        setBufferCapacity(BUFFER_CAPACITY_ALL, pw);
        return;
    }

    @Override // com.android.server.wm.WindowTracing
    void setLogFrequency(boolean onFrame, PrintWriter pw) {
        StringBuilder r0 = new StringBuilder();
        r0.append("Setting window tracing log frequency to ");
        if (onFrame == false) goto L5;
        String r1 = "frame";
    L6:
        r0.append(r1);
        logAndPrintln(pw, r0.toString());
        this.mLogOnFrame = onFrame;
        return;
    L5:
        r1 = "transaction";
        goto L6
    }

    @Override // com.android.server.wm.WindowTracing
    void setBufferCapacity(int capacity, PrintWriter pw) {
        logAndPrintln(pw, "Setting window tracing buffer capacity to " + capacity + "bytes");
        this.mBuffer.setCapacity(capacity);
    }

    @Override // com.android.server.wm.WindowTracing
    boolean isEnabled() {
        return this.mEnabledLockFree;
    }

    @Override // com.android.server.wm.WindowTracing
    int onShellCommand(ShellCommand shell) {
        PrintWriter pw = shell.getOutPrintWriter();
        String cmd = shell.getNextArgRequired();
        byte r6 = -1;
        switch(cmd.hashCode()) {
            case -892481550: goto L27;
            case -390772652: goto L24;
            case 3530753: goto L21;
            case 3540994: goto L18;
            case 97692013: goto L15;
            case 102865796: goto L12;
            case 109757538: goto L9;
            case 2141246174: goto L6;
            default: goto L29;
        };
    L29:
        byte r2 = -1;
    L30:
        switch(r2) {
            case 0: goto L64;
            case 1: goto L62;
            case 2: goto L60;
            case 3: goto L58;
            case 4: goto L56;
            case 5: goto L54;
            case 6: goto L35;
            case 7: goto L33;
            default: goto L31;
        };
    L31:
        pw.println("Unknown command: " + cmd);
        pw.println("Window manager trace options:");
        pw.println("  start: Start logging");
        pw.println("  stop: Stop logging");
        pw.println("  save-for-bugreport: Save logging data to file if it's running.");
        pw.println("  frame: Log trace once per frame");
        pw.println("  transaction: Log each transaction");
        pw.println("  size: Set the maximum log size (in KB)");
        pw.println("  status: Print trace status");
        pw.println("  level [lvl]: Set the log level between");
        pw.println("    lvl may be one of:");
        pw.println("      critical: Only visible windows with reduced information");
        pw.println("      trim: All windows with reduced");
        pw.println("      all: All window and information");
        return -1;
    L33:
        setBufferCapacity(Integer.parseInt(shell.getNextArgRequired()) * 1024, pw);
        this.mBuffer.resetBuffer();
        return 0;
    L35:
        String logLevelStr = shell.getNextArgRequired().toLowerCase();
        switch(logLevelStr.hashCode()) {
            case 96673: goto L45;
            case 3568674: goto L42;
            case 1952151455: goto L39;
            default: goto L47;
        };
    L47:
        switch(r6) {
            case 0: goto L51;
            case 1: goto L50;
            case 2: goto L49;
            default: goto L48;
        };
    L48:
        setLogLevel(1, pw);
    L52:
        this.mBuffer.resetBuffer();
        return 0;
    L49:
        setLogLevel(2, pw);
        goto L52
    L50:
        setLogLevel(1, pw);
        goto L52
    L51:
        setLogLevel(0, pw);
        goto L52
    L39:
        if (logLevelStr.equals("critical") == false) goto L47;
        r6 = 2;
        goto L47
    L42:
        if (logLevelStr.equals("trim") == false) goto L47;
        r6 = 1;
        goto L47
    L45:
        if (logLevelStr.equals(IZswContentProviderHelper.DUMP_ALL) == false) goto L47;
        r6 = 0;
        goto L47
    L54:
        setLogFrequency(false, pw);
        this.mBuffer.resetBuffer();
        return 0;
    L56:
        setLogFrequency(true, pw);
        this.mBuffer.resetBuffer();
        return 0;
    L58:
        logAndPrintln(pw, getStatus());
        return 0;
    L60:
        saveForBugreport(pw);
        return 0;
    L62:
        stopTrace(pw);
        return 0;
    L64:
        startTrace(pw);
        return 0;
    L6:
        if (cmd.equals("transaction") == false) goto L66;
        r2 = 5;
        goto L30
    L66:
        r2 = -1;
        goto L30
    L9:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L67;
        r2 = 0;
        goto L30
    L67:
        r2 = -1;
        goto L30
    L12:
        if (cmd.equals("level") == false) goto L68;
        r2 = 6;
        goto L30
    L68:
        r2 = -1;
        goto L30
    L15:
        if (cmd.equals("frame") == false) goto L69;
        r2 = 4;
        goto L30
    L69:
        r2 = -1;
        goto L30
    L18:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == false) goto L70;
        r2 = 1;
        goto L30
    L70:
        r2 = -1;
        goto L30
    L21:
        if (cmd.equals("size") == false) goto L71;
        r2 = 7;
        goto L30
    L71:
        r2 = -1;
        goto L30
    L24:
        if (cmd.equals("save-for-bugreport") == false) goto L72;
        r2 = 2;
        goto L30
    L72:
        r2 = -1;
        goto L30
    L27:
        if (cmd.equals("status") == false) goto L73;
        r2 = 3;
        goto L30
    L73:
        r2 = -1;
        goto L30
    }

    @Override // com.android.server.wm.WindowTracing
    String getStatus() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Status: ");
        if (isEnabled() == false) goto L5;
        String r1 = "Enabled";
    L6:
        r0.append(r1);
        r0.append("\nLog level: ");
        r0.append(this.mLogLevel);
        r0.append("\n");
        r0.append(this.mBuffer.getStatus());
        return r0.toString();
    L5:
        r1 = "Disabled";
        goto L6
    }

    @Override // com.android.server.wm.WindowTracing
    protected void startTraceInternal(PrintWriter pw) {
        Object r0 = this.mEnabledLock;
        monitor-enter(r0);
        logAndPrintln(pw, "Start tracing to " + this.mTraceFile + ".");     // Catch: Throwable -> L8
        this.mBuffer.resetBuffer();     // Catch: Throwable -> L8
        this.mEnabledLockFree = true;     // Catch: Throwable -> L8
        this.mEnabled = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        log("trace.enable");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.WindowTracing
    protected void stopTraceInternal(PrintWriter pw) {
        Object r0 = this.mEnabledLock;
        monitor-enter(r0);
        logAndPrintln(pw, "Stop tracing to " + this.mTraceFile + ". Waiting for traces to flush.");     // Catch: Throwable -> L9
        this.mEnabledLockFree = false;     // Catch: Throwable -> L9
        this.mEnabled = false;     // Catch: Throwable -> L9
        if (this.mEnabled == true) goto L11;
        writeTraceToFileLocked();     // Catch: Throwable -> L9
        logAndPrintln(pw, "Trace written to " + this.mTraceFile + ".");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        logAndPrintln(pw, "ERROR: tracing was re-enabled while waiting for flush.");     // Catch: Throwable -> L9
        throw new IllegalStateException("tracing enabled while waiting for flush.");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.WindowTracing
    protected void saveForBugreportInternal(PrintWriter pw) {
        Object r0 = this.mEnabledLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mEnabledLockFree = false;     // Catch: Throwable -> L8
        this.mEnabled = false;     // Catch: Throwable -> L8
        logAndPrintln(pw, "Stop tracing to " + this.mTraceFile + ". Waiting for traces to flush.");     // Catch: Throwable -> L8
        writeTraceToFileLocked();     // Catch: Throwable -> L8
        logAndPrintln(pw, "Trace written to " + this.mTraceFile + ".");     // Catch: Throwable -> L8
        logAndPrintln(pw, "Start tracing to " + this.mTraceFile + ".");     // Catch: Throwable -> L8
        this.mBuffer.resetBuffer();     // Catch: Throwable -> L8
        this.mEnabledLockFree = true;     // Catch: Throwable -> L8
        this.mEnabled = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.wm.WindowTracing
    protected void log(String where) {
        ProtoOutputStream os = new ProtoOutputStream();     // Catch: Exception -> L8
        long token = os.start(2246267895810L);     // Catch: Exception -> L8
        dumpToProto(os, this.mLogLevel, where, SystemClock.elapsedRealtimeNanos());     // Catch: Exception -> L6
        os.end(token);     // Catch: Exception -> L6
        this.mBuffer.add(os);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Exception e = e;
    L10:
        Log.wtf(TAG, "Exception while tracing state", e);
        return;
    L8:
        e = move-exception;
        e = e;
        goto L10
    }

    @Override // com.android.server.wm.WindowTracing
    protected boolean shouldLogOnFrame() {
        return this.mLogOnFrame;
    }

    @Override // com.android.server.wm.WindowTracing
    protected boolean shouldLogOnTransaction() {
        return !this.mLogOnFrame;
    }

    private void writeTraceToFileLocked() {
        Trace.traceBegin(32, "writeTraceToFileLocked");     // Catch: Throwable -> L5 IOException -> L7
        ProtoOutputStream proto = new ProtoOutputStream();     // Catch: Throwable -> L5 IOException -> L7
        proto.write(1125281431553L, MAGIC_NUMBER_VALUE);     // Catch: Throwable -> L5 IOException -> L7
        long timeOffsetNs = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()) - SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L5 IOException -> L7
        proto.write(1125281431555L, timeOffsetNs);     // Catch: Throwable -> L5 IOException -> L7
        this.mBuffer.writeTraceToFile(this.mTraceFile, proto);     // Catch: Throwable -> L5 IOException -> L7
    L4:
        Trace.traceEnd(32);
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "Unable to write buffer to file", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }
}
