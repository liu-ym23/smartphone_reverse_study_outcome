package com.android.server.am;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.server.DropBoxManagerInternal;
import com.android.server.LocalServices;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class BroadcastQueue {
    public static final String TAG = "BroadcastQueue";
    public static final String TAG_DUMP = "broadcast_queue_dump";
    final Handler mHandler;
    final BroadcastHistory mHistory;
    final ActivityManagerService mService;
    final BroadcastSkipPolicy mSkipPolicy;
    private BroadcastQueueSmtBase mSmtEx;

    public static /* synthetic */ void $r8$lambda$6U3hn8U3Ba60Eiz62EmylzEwrSc(BroadcastQueue r0, String r1, FileDescriptor r2) {
        r0.lambda$dumpToDropBoxLocked$0(r1, r2);
    }

    public abstract boolean cleanupDisabledPackageReceiversLocked(String r1, Set<String> r2, int r3);

    public abstract String describeStateLocked();

    public abstract void dumpDebug(ProtoOutputStream r1, long r2);

    public abstract boolean dumpLocked(FileDescriptor r1, PrintWriter r2, String[] r3, int r4, boolean r5, boolean r6, boolean r7, String r8, String r9, boolean r10);

    public abstract void enqueueBroadcastLocked(BroadcastRecord r1);

    public abstract boolean finishReceiverLocked(ProcessRecord r1, int r2, String r3, Bundle r4, boolean r5, boolean r6);

    public abstract int getPreferredSchedulingGroupLocked(ProcessRecord r1);

    public abstract boolean isBeyondBarrierLocked(long r1);

    public abstract boolean isDispatchedLocked(Intent r1);

    public abstract boolean isIdleLocked();

    public abstract boolean onApplicationAttachedLocked(ProcessRecord r1) throws BroadcastDeliveryFailedException;

    public abstract void onApplicationCleanupLocked(ProcessRecord r1);

    public abstract void onApplicationProblemLocked(ProcessRecord r1);

    public abstract void onApplicationTimeoutLocked(ProcessRecord r1);

    public abstract void onProcessFreezableChangedLocked(ProcessRecord r1);

    public abstract void start(ContentResolver r1);

    public abstract void waitForBarrier(PrintWriter r1);

    public abstract void waitForDispatched(Intent r1, PrintWriter r2);

    public abstract void waitForIdle(PrintWriter r1);

    BroadcastQueue(ActivityManagerService service, Handler handler, BroadcastSkipPolicy skipPolicy, BroadcastHistory history) {
        this.mSmtEx = new BroadcastQueueSmtBase(this);
        service.getClass();
        this.mService = service;
        handler.getClass();
        this.mHandler = handler;
        skipPolicy.getClass();
        this.mSkipPolicy = skipPolicy;
        history.getClass();
        this.mHistory = history;
    }

    static void logw(String msg) {
        Slog.w(TAG, msg);
    }

    static void logv(String msg) {
        Slog.v(TAG, msg);
    }

    static void checkState(boolean expression, String msg) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(msg);
    }

    static int traceBegin(String methodName) {
        int cookie = methodName.hashCode();
        Trace.asyncTraceForTrackBegin(64, TAG, methodName, cookie);
        return cookie;
    }

    static void traceEnd(int cookie) {
        Trace.asyncTraceForTrackEnd(64, TAG, cookie);
    }

    public void forceDelayBroadcastDelivery(String targetPackage, long delayedDurationMs) {
    }

    public void dumpToDropBoxLocked(final String msg) {
        ((DropBoxManagerInternal) LocalServices.getService(DropBoxManagerInternal.class)).addEntry(TAG_DUMP, new BroadcastQueue$$ExternalSyntheticLambda0(this, msg), 2);
    }

    private /* synthetic */ void lambda$dumpToDropBoxLocked$0(String msg, FileDescriptor fd) throws IOException {
        FileOutputStream out = new FileOutputStream(fd);
        PrintWriter pw = new PrintWriter(out);     // Catch: Throwable -> L22
        pw.print("Message: ");     // Catch: Throwable -> L15
        pw.println(msg);     // Catch: Throwable -> L15
        dumpLocked(fd, pw, null, 0, false, false, false, null, null, false);     // Catch: Throwable -> L13
        pw.flush();     // Catch: Throwable -> L13
        pw.close();     // Catch: Throwable -> L11
        out.close();
        return;
    L13:
        th = move-exception;
        Throwable r15 = th;
    L33:
        pw.close();     // Catch: Throwable -> L19
    L40:
        throw r15;     // Catch: Throwable -> L11
    L19:
        th = move-exception;
        r15.addSuppressed(th);     // Catch: Throwable -> L11
        throw r15;     // Catch: Throwable -> L11
    L15:
        th = move-exception;
        r15 = th;
    L11:
        th = move-exception;
        Throwable r16 = th;
    L31:
        out.close();     // Catch: Throwable -> L26
        throw r16;
    L26:
        th = move-exception;
        r16.addSuppressed(th);
        throw r16;
    L22:
        th = move-exception;
        r16 = th;
        goto L31
    }

    public void setQueueStateForAppLocked(ProcessRecord app, boolean isDeferred) {
    }

    public BroadcastQueueSmtBase getSmtEx() {
        return this.mSmtEx;
    }
}
