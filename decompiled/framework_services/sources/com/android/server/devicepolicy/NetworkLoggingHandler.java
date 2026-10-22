package com.android.server.devicepolicy;

import android.app.AlarmManager;
import android.app.admin.NetworkEvent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.LongSparseArray;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class NetworkLoggingHandler extends Handler {
    private static final long BATCH_FINALIZATION_TIMEOUT_ALARM_INTERVAL_MS = 1800000;
    private static final long BATCH_FINALIZATION_TIMEOUT_MS = 5400000;
    private static final long FORCE_FETCH_THROTTLE_NS = 0;
    static final int LOG_NETWORK_EVENT_MSG = 1;
    private static final int MAX_BATCHES = 5;
    private static final int MAX_EVENTS_PER_BATCH = 1200;
    static final String NETWORK_EVENT_KEY = "network_event";
    private static final String NETWORK_LOGGING_TIMEOUT_ALARM_TAG = "NetworkLogging.batchTimeout";
    private static final long RETRIEVED_BATCH_DISCARD_DELAY_MS = 300000;
    private static final String TAG = null;
    private final AlarmManager mAlarmManager;
    private final AlarmManager.OnAlarmListener mBatchTimeoutAlarmListener;
    private final LongSparseArray<ArrayList<NetworkEvent>> mBatches;
    private long mCurrentBatchToken;
    private final DevicePolicyManagerService mDpm;
    private long mId;
    private long mLastFinalizationNanos;
    private long mLastRetrievedBatchToken;
    private ArrayList<NetworkEvent> mNetworkEvents;
    private boolean mPaused;
    private int mTargetUserId;

    public static /* synthetic */ void $r8$lambda$7SRoIzZIavrW4R_Hg5eSjXxrvRw(NetworkLoggingHandler r0, long r1) {
        r0.lambda$retrieveFullLogBatch$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m3506$$Nest$fgetmNetworkEvents(NetworkLoggingHandler r0) {
        return r0.mNetworkEvents;
    }

    /* JADX INFO: renamed from: -$$Nest$mfinalizeBatchAndBuildAdminMessageLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m3507$$Nest$mfinalizeBatchAndBuildAdminMessageLocked(NetworkLoggingHandler r0) {
        return r0.finalizeBatchAndBuildAdminMessageLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyDeviceOwnerOrProfileOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3508$$Nest$mnotifyDeviceOwnerOrProfileOwner(NetworkLoggingHandler r0, Bundle r1) {
        r0.notifyDeviceOwnerOrProfileOwner(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3509$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = NetworkLoggingHandler.class.getSimpleName();
        FORCE_FETCH_THROTTLE_NS = TimeUnit.SECONDS.toNanos(10);
    }

    NetworkLoggingHandler(Looper looper, DevicePolicyManagerService dpm, int targetUserId) {
        this(looper, dpm, 0, targetUserId);
    }

    NetworkLoggingHandler(Looper looper, DevicePolicyManagerService dpm, long id, int targetUserId) {
        super(looper);
        this.mLastFinalizationNanos = -1;
        this.mBatchTimeoutAlarmListener = new AnonymousClass1(this);
        this.mNetworkEvents = new ArrayList();
        this.mBatches = new LongSparseArray(5);
        this.mPaused = false;
        this.mDpm = dpm;
        this.mAlarmManager = this.mDpm.mInjector.getAlarmManager();
        this.mId = id;
        this.mTargetUserId = targetUserId;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        Slog.d(TAG, "NetworkLoggingHandler received an unknown of message.");
        return;
    L5:
        NetworkEvent networkEvent = (NetworkEvent) msg.getData().getParcelable(NETWORK_EVENT_KEY, NetworkEvent.class);
        if (networkEvent == null) goto L23;
        Bundle notificationExtras = null;
        monitor-enter(this);
        this.mNetworkEvents.add(networkEvent);     // Catch: Throwable -> L12
        if (this.mNetworkEvents.size() < MAX_EVENTS_PER_BATCH) goto L14;
        notificationExtras = finalizeBatchAndBuildAdminMessageLocked();     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);     // Catch: Throwable -> L12
        if (notificationExtras == null) goto L25;
        notifyDeviceOwnerOrProfileOwner(notificationExtras);
        return;
    L25:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void scheduleBatchFinalization() {
        long when = SystemClock.elapsedRealtime() + BATCH_FINALIZATION_TIMEOUT_MS;
        this.mAlarmManager.setWindow(2, when, 1800000, NETWORK_LOGGING_TIMEOUT_ALARM_TAG, this.mBatchTimeoutAlarmListener, this);
        Slog.d(TAG, "Scheduled a new batch finalization alarm 5400000ms from now.");
    }

    long forceBatchFinalization() {
        monitor-enter(this);
        long toWaitNanos = (this.mLastFinalizationNanos + FORCE_FETCH_THROTTLE_NS) - System.nanoTime();     // Catch: Throwable -> L8
        if (toWaitNanos <= 0) goto L10;
        long r2 = TimeUnit.NANOSECONDS.toMillis(toWaitNanos) + 1;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r2;
    L10:
        Bundle notificationExtras = finalizeBatchAndBuildAdminMessageLocked();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (notificationExtras == null) goto L14;
        notifyDeviceOwnerOrProfileOwner(notificationExtras);
    L14:
        return 0;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void pause() {
        monitor-enter(this);
        Slog.d(TAG, "Paused network logging");     // Catch: Throwable -> L6
        this.mPaused = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void resume() {
        Bundle notificationExtras = null;
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPaused == true) goto L11;
        Slog.d(TAG, "Attempted to resume network logging, but logging is not paused.");     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.d(TAG, "Resumed network logging. Current batch=" + this.mCurrentBatchToken + ", LastRetrievedBatch=" + this.mLastRetrievedBatchToken);     // Catch: Throwable -> L9
        this.mPaused = false;     // Catch: Throwable -> L9
        if (this.mBatches.size() > 0) goto L14;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L9
        if (notificationExtras == null) goto L23;
        notifyDeviceOwnerOrProfileOwner(notificationExtras);
        return;
    L23:
        return;
    L14:
        if (this.mLastRetrievedBatchToken == this.mCurrentBatchToken) goto L16;
        scheduleBatchFinalization();     // Catch: Throwable -> L9
        notificationExtras = buildAdminMessageLocked();     // Catch: Throwable -> L9
        goto L16
    }

    synchronized void discardLogs() {
        monitor-enter(this);
        this.mBatches.clear();     // Catch: Throwable -> L6
        this.mNetworkEvents = new ArrayList();     // Catch: Throwable -> L6
        Slog.d(TAG, "Discarded all network logs");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private Bundle finalizeBatchAndBuildAdminMessageLocked() {
        this.mLastFinalizationNanos = System.nanoTime();
        Bundle notificationExtras = null;
        if (this.mNetworkEvents.size() <= 0) goto L18;
        Iterator<NetworkEvent> r1 = this.mNetworkEvents.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        NetworkEvent event = r1.next();
        event.setId(this.mId);
        if (this.mId == Long.MAX_VALUE) goto L9;
        this.mId++;
        goto L6
    L9:
        Slog.i(TAG, "Reached maximum id value; wrapping around ." + this.mCurrentBatchToken);
        this.mId = 0;
        goto L6
    L13:
        if (this.mBatches.size() < 5) goto L15;
        this.mBatches.removeAt(0);
    L15:
        this.mCurrentBatchToken++;
        this.mBatches.append(this.mCurrentBatchToken, this.mNetworkEvents);
        this.mNetworkEvents = new ArrayList();
        if (this.mPaused == true) goto L19;
        notificationExtras = buildAdminMessageLocked();
    L19:
        scheduleBatchFinalization();
        return notificationExtras;
    L18:
        Slog.d(TAG, "Was about to finalize the batch, but there were no events to send to the DPC, the batchToken of last available batch: " + this.mCurrentBatchToken);
        goto L19
    }

    private Bundle buildAdminMessageLocked() {
        Bundle extras = new Bundle();
        int lastBatchSize = this.mBatches.valueAt(this.mBatches.size() - 1).size();
        extras.putLong("android.app.extra.EXTRA_NETWORK_LOGS_TOKEN", this.mCurrentBatchToken);
        extras.putInt("android.app.extra.EXTRA_NETWORK_LOGS_COUNT", lastBatchSize);
        return extras;
    }

    private void notifyDeviceOwnerOrProfileOwner(Bundle extras) {
        if (Thread.holdsLock(this) == false) goto L6;
        Slog.wtfStack(TAG, "Shouldn't be called with NetworkLoggingHandler lock held");
        return;
    L6:
        Slog.d(TAG, "Sending network logging batch broadcast to device owner or profile owner, batchToken: " + extras.getLong("android.app.extra.EXTRA_NETWORK_LOGS_TOKEN", -1));
        this.mDpm.sendDeviceOwnerOrProfileOwnerCommand("android.app.action.NETWORK_LOGS_AVAILABLE", extras, this.mTargetUserId);
    }

    synchronized List<NetworkEvent> retrieveFullLogBatch(final long batchToken) {
        monitor-enter(this);
        int index = this.mBatches.indexOfKey(batchToken);     // Catch: Throwable -> L11
        if (index >= 0) goto L8;
        monitor-exit(this);
        return null;
    L8:
        postDelayed(new NetworkLoggingHandler$$ExternalSyntheticLambda0(this, batchToken), 300000);     // Catch: Throwable -> L11
        this.mLastRetrievedBatchToken = batchToken;     // Catch: Throwable -> L11
        ArrayList<NetworkEvent> r1 = this.mBatches.valueAt(index);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$retrieveFullLogBatch$0(long batchToken) {
        monitor-enter(this);
    L14:
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mBatches.size() <= 0) goto L10;
        if (this.mBatches.keyAt(0) > batchToken) goto L10;
        this.mBatches.removeAt(0);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    }
}
