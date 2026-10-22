package com.android.server.input;

import android.hardware.input.IStickyModifierStateListener;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
final class StickyModifierStateController {
    private static final boolean DEBUG = false;
    private static final String TAG = "ModifierStateController";
    private final SparseArray<StickyModifierStateListenerRecord> mStickyModifierStateListenerRecords;

    private class StickyModifierStateListenerRecord implements IBinder.DeathRecipient {
        public final IStickyModifierStateListener mListener;
        public final int mPid;
        final /* synthetic */ StickyModifierStateController this$0;

        StickyModifierStateListenerRecord(StickyModifierStateController r1, int pid, IStickyModifierStateListener listener) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (StickyModifierStateController.m4603$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(StickyModifierStateController.TAG, "Sticky modifier state listener for pid " + this.mPid + " died.");
        L5:
            StickyModifierStateController.m4602$$Nest$monStickyModifierStateListenerDied(this.this$0, this.mPid);
        }

        public void notifyStickyModifierStateChanged(int modifierState, int lockedModifierState) {
            this.mListener.onStickyModifierStateChanged(modifierState, lockedModifierState);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(StickyModifierStateController.TAG, "Failed to notify process " + this.mPid + " that sticky modifier state changed, assuming it died.", ex);
            binderDied();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$monStickyModifierStateListenerDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4602$$Nest$monStickyModifierStateListenerDied(StickyModifierStateController r0, int r1) {
        r0.onStickyModifierStateListenerDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4603$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    StickyModifierStateController() {
        this.mStickyModifierStateListenerRecords = new SparseArray();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public void notifyStickyModifierStateChanged(int modifierState, int lockedModifierState) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Sticky modifier state changed, modifierState = " + modifierState + ", lockedModifierState = " + lockedModifierState);
    L5:
        SparseArray<StickyModifierStateListenerRecord> r0 = this.mStickyModifierStateListenerRecords;
        monitor-enter(r0);
        int i = 0;
    L18:
    L11:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mStickyModifierStateListenerRecords.size()) goto L14;
        this.mStickyModifierStateListenerRecords.valueAt(i).notifyStickyModifierStateChanged(modifierState, lockedModifierState);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void registerStickyModifierStateListener(IStickyModifierStateListener listener, int pid) {
        SparseArray<StickyModifierStateListenerRecord> r0 = this.mStickyModifierStateListenerRecords;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mStickyModifierStateListenerRecords.get(pid) != null) goto L17;
        StickyModifierStateListenerRecord record = new StickyModifierStateListenerRecord(this, pid, listener);     // Catch: Throwable -> L11
        listener.asBinder().linkToDeath(record, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        this.mStickyModifierStateListenerRecords.put(pid, record);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L11
    L17:
        throw new IllegalStateException("The calling process has already registered a StickyModifierStateListener.");     // Catch: Throwable -> L11
    }

    public void unregisterStickyModifierStateListener(IStickyModifierStateListener listener, int pid) {
        SparseArray<StickyModifierStateListenerRecord> r0 = this.mStickyModifierStateListenerRecords;
        monitor-enter(r0);
        StickyModifierStateListenerRecord record = this.mStickyModifierStateListenerRecords.get(pid);     // Catch: Throwable -> L11
        if (record == null) goto L16;
        if (record.mListener.asBinder() != listener.asBinder()) goto L14;
        record.mListener.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L11
        this.mStickyModifierStateListenerRecords.remove(pid);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        throw new IllegalStateException("The calling process has a different registered StickyModifierStateListener.");     // Catch: Throwable -> L11
    L16:
        throw new IllegalStateException("The calling process has no registered StickyModifierStateListener.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void onStickyModifierStateListenerDied(int pid) {
        SparseArray<StickyModifierStateListenerRecord> r0 = this.mStickyModifierStateListenerRecords;
        monitor-enter(r0);
        this.mStickyModifierStateListenerRecords.remove(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
