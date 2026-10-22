package com.android.server.audio;

import android.media.IControlStreamDispatcher;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ControlStreamHelper {
    private static final int CHECK_NEW_CONTROL_STREAM_DELAY_MS = 500;
    private static final int CHECK_NEW_CONTROL_STREAM_TIMES = 4;
    private static final boolean DEBUG = true;
    private static final int MSG_CONTROL_STREAM = 1;
    private static final String TAG = null;
    private final List<DispatcherRecord> mControlStreamDispatchers;
    private long mControlStreamGeneration;
    private final ControlStreamTypeProvider mControlStreamTypeProvider;
    private volatile boolean mCurrentControlStreamInitialized;
    private volatile int mCurrentControlStreamType;
    private final Handler mHandler;
    private Looper mLooper;
    private LooperThread mLooperThread;

    interface ControlStreamTypeProvider {
        int compute();
    }

    private static final class DispatcherRecord {
        final IBinder mBinder;
        final IControlStreamDispatcher mDispatcher;
        volatile long mLastDispatchedGeneration;

        DispatcherRecord(IControlStreamDispatcher dispatcher, IBinder binder) {
            this.mLastDispatchedGeneration = -1;
            this.mDispatcher = dispatcher;
            this.mBinder = binder;
        }
    }

    private class LooperThread extends Thread {
        final /* synthetic */ ControlStreamHelper this$0;

        /* synthetic */ LooperThread(ControlStreamHelper r1, ControlStreamHelperIA r2) {
            this(r1);
        }

        private LooperThread(ControlStreamHelper r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            ControlStreamHelper r0 = this.this$0;
            monitor-enter(r0);
            ControlStreamHelper.m2137$$Nest$fputmLooper(this.this$0, Looper.myLooper());     // Catch: Throwable -> L8
            this.this$0.notify();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Looper.loop();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$iqHB9YU3DdEC9_cQMNxar8RJO-Y, reason: not valid java name */
    public static /* synthetic */ void m2135$r8$lambda$iqHB9YU3DdEC9_cQMNxar8RJOY(ControlStreamHelper r0, IBinder r1) {
        r0.lambda$registerControlStreamCallback$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$mBNXbvHq5tqUX9j0D7_xoTbgEPw(IBinder r0, DispatcherRecord r1) {
        return lambda$registerControlStreamCallback$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$q-brCxuqKj-Zxow08pW9UlSiaAU, reason: not valid java name */
    public static /* synthetic */ boolean m2136$r8$lambda$qbrCxuqKjZxow08pW9UlSiaAU(IBinder r0, DispatcherRecord r1) {
        return lambda$unregisterControlStreamCallback$2(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLooper, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2137$$Nest$fputmLooper(ControlStreamHelper r0, Looper r1) {
        r0.mLooper = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mmessageReason, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2138$$Nest$mmessageReason(ControlStreamHelper r0, Message r1) {
        return r0.messageReason(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAndDispatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2139$$Nest$mupdateAndDispatch(ControlStreamHelper r0, String r1) {
        r0.updateAndDispatch(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2140$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = ControlStreamHelper.class.getSimpleName();
    }

    public ControlStreamHelper(ControlStreamTypeProvider provider, Looper looper) {
        this.mControlStreamDispatchers = new CopyOnWriteArrayList();
        this.mCurrentControlStreamType = -1;
        provider.getClass();
        this.mControlStreamTypeProvider = provider;
        if (looper != null) goto L18;
        this.mLooperThread = new LooperThread(this, null);
        this.mLooperThread.start();
        monitor-enter(this);
    L23:
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mLooper != null) goto L14;
        wait();     // Catch: Throwable -> L10 InterruptedException -> L12
    L12:
        e = move-exception;
        Log.e(TAG, "LooperThread interrupted", e);     // Catch: Throwable -> L10
        goto L23
    L14:
        monitor-exit(this);     // Catch: Throwable -> L10
    L19:
        final Looper r1 = this.mLooper;
        r1.getClass();
        this.mHandler = new AnonymousClass1(this, r1);
        return;
    L18:
        this.mLooper = looper;
        goto L19
    }

    public int getCurrentControlStreamType() {
        return this.mControlStreamTypeProvider.compute();
    }

    public void onControlStreamInputsChanged(String reason) {
        scheduleControlStreamCheck(reason);
    }

    public synchronized void scheduleControlStreamCheck() {
        monitor-enter(this);
        scheduleControlStreamCheck("unknown");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void scheduleControlStreamCheck(String reason) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mControlStreamDispatchers.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Log.v(TAG, "scheduleControlStreamCheck reason=" + reason + " dispatchers=" + this.mControlStreamDispatchers.size());     // Catch: Throwable -> L12
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L12
        Message immediateMsg = this.mHandler.obtainMessage(1);     // Catch: Throwable -> L12
        immediateMsg.obj = reason;     // Catch: Throwable -> L12
        this.mHandler.sendMessage(immediateMsg);     // Catch: Throwable -> L12
        int i = 1;
    L9:
        if (i > 4) goto L15;
        Message msg = this.mHandler.obtainMessage(1);     // Catch: Throwable -> L12
        msg.obj = reason;     // Catch: Throwable -> L12
        this.mHandler.sendMessageDelayed(msg, i * 500);     // Catch: Throwable -> L12
        i = i + 1;
        goto L9
    L15:
        monitor-exit(this);
    }

    private synchronized long updateCurrentControlStream(int streamType, String reason) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mCurrentControlStreamInitialized == true) goto L6;
    L11:
        boolean changed = true;
    L13:
        if (changed == false) goto L15;
        Log.d(TAG, "control stream current=" + streamType + " previous=" + this.mCurrentControlStreamType + " reason=" + reason);     // Catch: Throwable -> L9
    L15:
        if (changed == false) goto L17;
        this.mControlStreamGeneration++;     // Catch: Throwable -> L9
    L17:
        this.mCurrentControlStreamType = streamType;     // Catch: Throwable -> L9
        this.mCurrentControlStreamInitialized = true;     // Catch: Throwable -> L9
        long r1 = this.mControlStreamGeneration;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    L6:
        if (this.mCurrentControlStreamType != streamType) goto L11;
        changed = false;
        goto L13
    }

    private void updateAndDispatch(String reason) {
        int streamType = this.mControlStreamTypeProvider.compute();
        long generation = updateCurrentControlStream(streamType, reason);
        Iterator<DispatcherRecord> r0 = this.mControlStreamDispatchers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DispatcherRecord record = r0.next();
        dispatchIfChanged(record, streamType, generation, reason);
        goto L4
    }

    private String messageReason(Message msg) {
        if ((msg.obj instanceof String) == true) goto L7;
        return "unknown";
    L7:
        return (String) msg.obj;
    }

    private void dispatchIfChanged(DispatcherRecord record, int streamType, long generation, String reason) {
        if (record.mLastDispatchedGeneration != generation) goto L11;
        Log.v(TAG, "skip dispatch stream=" + streamType + " reason=" + reason);
        return;
    L11:
        record.mDispatcher.dispatchControlStreamChange(streamType);     // Catch: RemoteException -> L8
        record.mLastDispatchedGeneration = generation;     // Catch: RemoteException -> L8
        Log.d(TAG, "dispatch control stream=" + streamType + " reason=" + reason);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "dispatch control stream failed", e);
        unregisterControlStreamCallback(record.mBinder);
    }

    public synchronized boolean registerControlStreamCallback(IControlStreamDispatcher csd) {
        monitor-enter(this);
        Log.d(TAG, "registerControlStreamCallback " + csd);     // Catch: Throwable -> L17
        if (csd != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        final IBinder binder = csd.asBinder();     // Catch: Throwable -> L17
        if (binder != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        if (this.mControlStreamDispatchers.stream().anyMatch(new ControlStreamHelper$$ExternalSyntheticLambda1(binder)) == false) goto L19;
        Log.w(TAG, "registerControlStreamCallback already registered " + csd);     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    L19:
        DispatcherRecord record = new DispatcherRecord(csd, binder);     // Catch: Throwable -> L17
        this.mControlStreamDispatchers.add(record);     // Catch: Throwable -> L17
        binder.linkToDeath(new ControlStreamHelper$$ExternalSyntheticLambda2(this, binder), 0);     // Catch: Throwable -> L17 RemoteException -> L22
    L24:
        scheduleControlStreamCheck("register");     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L22:
        e = move-exception;
        Log.w(TAG, "Could not link to client death", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$registerControlStreamCallback$0(IBinder binder, DispatcherRecord record) {
        if (record.mBinder != binder) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$registerControlStreamCallback$1(IBinder binder) {
        unregisterControlStreamCallback(binder);
    }

    public synchronized boolean unregisterControlStreamCallback(IControlStreamDispatcher csd) {
        monitor-enter(this);
        Log.d(TAG, "unregisterControlStreamCallback " + csd);     // Catch: Throwable -> L11
        if (csd != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r0 = unregisterControlStreamCallback(csd.asBinder());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    private synchronized boolean unregisterControlStreamCallback(final IBinder binder) {
        monitor-enter(this);
        if (binder != null) goto L19;
        monitor-exit(this);
        return false;
    L19:
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mControlStreamDispatchers.removeIf(new ControlStreamHelper$$ExternalSyntheticLambda0(binder)) == true) goto L14;
        Log.w(TAG, "unregisterControlStreamTypeCallback failed, not found " + binder);     // Catch: Throwable -> L12
        monitor-exit(this);
        return false;
    L14:
        monitor-exit(this);
        return true;
    }

    private static /* synthetic */ boolean lambda$unregisterControlStreamCallback$2(IBinder binder, DispatcherRecord record) {
        if (record.mBinder != binder) goto L5;
        return true;
    L5:
        return false;
    }
}
