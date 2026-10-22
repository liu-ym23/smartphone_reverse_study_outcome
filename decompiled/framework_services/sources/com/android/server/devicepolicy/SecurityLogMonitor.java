package com.android.server.devicepolicy;

import android.app.admin.IAuditLogEventsCallback;
import android.app.admin.SecurityLog;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.utils.Slogf;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class SecurityLogMonitor implements Runnable {
    private static final long BROADCAST_RETRY_INTERVAL_MS = 0;
    private static final int BUFFER_ENTRIES_CRITICAL_LEVEL = 9216;
    private static final int BUFFER_ENTRIES_MAXIMUM_LEVEL = 10240;
    static final int BUFFER_ENTRIES_NOTIFICATION_LEVEL = 1024;
    private static final boolean DEBUG = false;
    private static final long FORCE_FETCH_THROTTLE_NS = 0;
    private static final int MAX_AUDIT_LOG_EVENTS = 10000;
    private static final long MAX_AUDIT_LOG_EVENT_AGE_NS = 0;
    private static final long OVERLAP_NS = 0;
    private static final long POLLING_INTERVAL_MS = 0;
    private static final long RATE_LIMIT_INTERVAL_MS = 0;
    private static final String TAG = "SecurityLogMonitor";
    private boolean mAllowedToRetrieve;
    private final SparseArray<IAuditLogEventsCallback> mAuditLogCallbacks;
    private boolean mAuditLogEnabled;
    private final ArrayDeque<SecurityLog.SecurityEvent> mAuditLogEventBuffer;
    private boolean mCriticalLevelLogged;
    private int mEnabledUser;
    private final Semaphore mForceSemaphore;
    private final Handler mHandler;
    private long mId;
    private Consumer<List<SecurityLog.SecurityEvent>> mInternalEventsCallback;
    private long mLastEventNanos;
    private final ArrayList<SecurityLog.SecurityEvent> mLastEvents;
    private long mLastForceNanos;
    private boolean mLegacyLogEnabled;
    private final Lock mLock;
    private Thread mMonitorThread;
    private long mNextAllowedRetrievalTimeMillis;
    private boolean mPaused;
    private ArrayList<SecurityLog.SecurityEvent> mPendingLogs;
    private final DevicePolicyManagerService mService;

    public static /* synthetic */ void $r8$lambda$Dv4Rqfj8zOjoaAVvqgzs3p85e6s(SecurityLogMonitor r0, int r1, IAuditLogEventsCallback r2, List r3) {
        r0.lambda$scheduleSendAuditLogs$2(r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$XEvcjMYAcQL7QX80uynWLPl5xXk(SecurityLog.SecurityEvent r0, SecurityLog.SecurityEvent r1) {
        return lambda$getNextBatch$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$gdKtaFFeKfC2FTgFifE4-VlpA0A, reason: not valid java name */
    public static /* synthetic */ void m3527$r8$lambda$gdKtaFFeKfC2FTgFifE4VlpA0A(Consumer r0, ArrayList r1) {
        lambda$mergeBatchLocked$1(r0, r1);
    }

    SecurityLogMonitor(DevicePolicyManagerService service, Handler handler) {
        this.mLock = new ReentrantLock();
        this.mMonitorThread = null;
        this.mPendingLogs = new ArrayList();
        this.mAllowedToRetrieve = false;
        this.mCriticalLevelLogged = false;
        this.mLastEvents = new ArrayList();
        this.mLastEventNanos = -1;
        this.mNextAllowedRetrievalTimeMillis = -1;
        this.mPaused = false;
        this.mForceSemaphore = new Semaphore(0);
        this.mLastForceNanos = 0;
        this.mAuditLogCallbacks = new SparseArray();
        this.mAuditLogEventBuffer = new ArrayDeque();
        this.mService = service;
        this.mId = 0;
        this.mLastForceNanos = System.nanoTime();
        this.mHandler = handler;
    }

    static {
        RATE_LIMIT_INTERVAL_MS = TimeUnit.HOURS.toMillis(2);
        BROADCAST_RETRY_INTERVAL_MS = TimeUnit.MINUTES.toMillis(30);
        POLLING_INTERVAL_MS = TimeUnit.MINUTES.toMillis(1);
        OVERLAP_NS = TimeUnit.SECONDS.toNanos(3);
        FORCE_FETCH_THROTTLE_NS = TimeUnit.SECONDS.toNanos(10);
        MAX_AUDIT_LOG_EVENT_AGE_NS = TimeUnit.HOURS.toNanos(8);
    }

    void stop() {
        Slog.i(TAG, "Stopping security logging.");
        this.mLock.lock();
    L7:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L4:
        if (this.mMonitorThread == null) goto L9;
        stopMonitorThreadLocked();     // Catch: Throwable -> L7
        resetLegacyBufferLocked();     // Catch: Throwable -> L7
    L9:
        this.mLock.unlock();
    }

    void setLoggingParams(int enabledUser, boolean legacyLogEnabled, boolean auditLogEnabled) {
        Slogf.i(TAG, "Setting logging params, user = %d -> %d, legacy: %b -> %b, audit %b -> %b", new Object[]{Integer.valueOf(this.mEnabledUser), Integer.valueOf(enabledUser), Boolean.valueOf(this.mLegacyLogEnabled), Boolean.valueOf(legacyLogEnabled), Boolean.valueOf(this.mAuditLogEnabled), Boolean.valueOf(auditLogEnabled)});
        this.mLock.lock();
        this.mEnabledUser = enabledUser;     // Catch: Throwable -> L8
        if (this.mMonitorThread != null) goto L11;
        if (legacyLogEnabled == true) goto L7;
        if (auditLogEnabled == false) goto L11;
    L7:
        startMonitorThreadLocked();     // Catch: Throwable -> L8
    L16:
        if (this.mLegacyLogEnabled == legacyLogEnabled) goto L19;
        resetLegacyBufferLocked();     // Catch: Throwable -> L8
        this.mLegacyLogEnabled = legacyLogEnabled;     // Catch: Throwable -> L8
    L19:
        if (this.mAuditLogEnabled == auditLogEnabled) goto L21;
        resetAuditBufferLocked();     // Catch: Throwable -> L8
        this.mAuditLogEnabled = auditLogEnabled;     // Catch: Throwable -> L8
    L21:
        this.mLock.unlock();
        return;
    L11:
        if (this.mMonitorThread == null) goto L16;
        if (legacyLogEnabled == true) goto L16;
        if (auditLogEnabled == true) goto L16;
        stopMonitorThreadLocked();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void startMonitorThreadLocked() {
        this.mId = 0;
        this.mPaused = false;
        this.mMonitorThread = new Thread(this);
        this.mMonitorThread.start();
        SecurityLog.writeEvent(210011, new Object[0]);
        Slog.i(TAG, "Security log monitor thread started");
    }

    private void stopMonitorThreadLocked() {
        this.mMonitorThread.interrupt();
        this.mMonitorThread.join(TimeUnit.SECONDS.toMillis(5));     // Catch: InterruptedException -> L5
    L7:
        this.mMonitorThread = null;
        SecurityLog.writeEvent(210012, new Object[0]);
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Interrupted while waiting for thread to stop", e);
        goto L7
    }

    private void resetLegacyBufferLocked() {
        this.mPendingLogs = new ArrayList();
        this.mCriticalLevelLogged = false;
        this.mAllowedToRetrieve = false;
        this.mNextAllowedRetrievalTimeMillis = -1;
        Slog.i(TAG, "Legacy buffer reset.");
    }

    private void resetAuditBufferLocked() {
        this.mAuditLogEventBuffer.clear();
        this.mAuditLogCallbacks.clear();
    }

    void pause() {
        Slog.i(TAG, "Paused.");
        this.mLock.lock();
        this.mPaused = true;
        this.mAllowedToRetrieve = false;
        this.mLock.unlock();
    }

    void resume() {
        this.mLock.lock();
    L9:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L5:
        if (this.mPaused == true) goto L12;
        Log.d(TAG, "Attempted to resume, but logging is not paused.");     // Catch: Throwable -> L9
        this.mLock.unlock();
        return;
    L12:
        this.mPaused = false;     // Catch: Throwable -> L9
        this.mAllowedToRetrieve = false;     // Catch: Throwable -> L9
        this.mLock.unlock();
        Slog.i(TAG, "Resumed.");
        notifyDeviceOwnerOrProfileOwnerIfNeeded(false);     // Catch: InterruptedException -> L16
        return;
    L16:
        e = move-exception;
        Log.w(TAG, "Thread interrupted.", e);
    }

    void discardLogs() {
        this.mLock.lock();
        this.mAllowedToRetrieve = false;
        this.mPendingLogs = new ArrayList();
        this.mCriticalLevelLogged = false;
        this.mLock.unlock();
        Slog.i(TAG, "Discarded all logs.");
    }

    List<SecurityLog.SecurityEvent> retrieveLogs() {
        this.mLock.lock();
    L8:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L4:
        if (this.mAllowedToRetrieve == false) goto L10;
        this.mAllowedToRetrieve = false;     // Catch: Throwable -> L8
        this.mNextAllowedRetrievalTimeMillis = SystemClock.elapsedRealtime() + RATE_LIMIT_INTERVAL_MS;     // Catch: Throwable -> L8
        List<SecurityLog.SecurityEvent> result = this.mPendingLogs;     // Catch: Throwable -> L8
        this.mPendingLogs = new ArrayList();     // Catch: Throwable -> L8
        this.mCriticalLevelLogged = false;     // Catch: Throwable -> L8
        this.mLock.unlock();
        return result;
    L10:
        this.mLock.unlock();
        return null;
    }

    private void getNextBatch(ArrayList<SecurityLog.SecurityEvent> newLogs) throws IOException {
        if (this.mLastEventNanos >= 0) goto L6;
        SecurityLog.readEvents(newLogs);
    L10:
        int i = 0;
    L12:
        if (i >= (newLogs.size() - 1)) goto L21;
        if (newLogs.get(i).getTimeNanos() > newLogs.get(i + 1).getTimeNanos()) goto L15;
        i = i + 1;
        goto L12
    L15:
        newLogs.sort(new SecurityLogMonitor$$ExternalSyntheticLambda2());
        return;
    L21:
        return;
    L6:
        if (this.mLastEvents.isEmpty() == false) goto L8;
        long startNanos = this.mLastEventNanos;
    L9:
        SecurityLog.readEventsSince(startNanos, newLogs);
        goto L10
    L8:
        startNanos = Math.max(0, this.mLastEventNanos - OVERLAP_NS);
        goto L9
    }

    private static /* synthetic */ int lambda$getNextBatch$0(SecurityLog.SecurityEvent e1, SecurityLog.SecurityEvent e2) {
        return Long.signum(e1.getTimeNanos() - e2.getTimeNanos());
    }

    private void saveLastEvents(ArrayList<SecurityLog.SecurityEvent> newLogs) {
        this.mLastEvents.clear();
        if (newLogs.isEmpty() == false) goto L5;
        return;
    L5:
        this.mLastEventNanos = newLogs.get(newLogs.size() - 1).getTimeNanos();
        int pos = newLogs.size() - 2;
    L6:
        if (pos < 0) goto L10;
        if ((this.mLastEventNanos - newLogs.get(pos).getTimeNanos()) >= OVERLAP_NS) goto L10;
        pos = pos - 1;
    L10:
        this.mLastEvents.addAll(newLogs.subList(pos + 1, newLogs.size()));
    }

    private void mergeBatchLocked(ArrayList<SecurityLog.SecurityEvent> newLogs) {
        ArrayList<SecurityLog.SecurityEvent> dedupedLogs = new ArrayList();
        int curPos = 0;
        int lastPos = 0;
    L4:
        if (lastPos >= this.mLastEvents.size()) goto L22;
        if (curPos >= newLogs.size()) goto L22;
        SecurityLog.SecurityEvent curEvent = newLogs.get(curPos);
        long currentNanos = curEvent.getTimeNanos();
        if (currentNanos > this.mLastEventNanos) goto L22;
        SecurityLog.SecurityEvent lastEvent = this.mLastEvents.get(lastPos);
        long lastNanos = lastEvent.getTimeNanos();
        if (lastNanos > currentNanos) goto L12;
        if (lastNanos < currentNanos) goto L15;
        if (lastEvent.eventEquals(curEvent) == true) goto L20;
        dedupedLogs.add(curEvent);
    L20:
        lastPos = lastPos + 1;
        curPos = curPos + 1;
        goto L4
    L15:
        lastPos = lastPos + 1;
        goto L4
    L12:
        dedupedLogs.add(curEvent);
        curPos = curPos + 1;
    L22:
        dedupedLogs.addAll(newLogs.subList(curPos, newLogs.size()));
        if (dedupedLogs.isEmpty() == false) goto L25;
    L28:
        Iterator<SecurityLog.SecurityEvent> r3 = dedupedLogs.iterator();
    L30:
        if (r3.hasNext() == false) goto L33;
        SecurityLog.SecurityEvent event = r3.next();
        assignLogId(event);
        goto L30
    L33:
        if (this.mLegacyLogEnabled == false) goto L36;
        addToLegacyBufferLocked(dedupedLogs);
    L36:
        if (this.mAuditLogEnabled == false) goto L51;
        addAuditLogEventsLocked(dedupedLogs);
        return;
    L51:
        return;
    L25:
        if (this.mInternalEventsCallback == null) goto L27;
        final ArrayList<SecurityLog.SecurityEvent> events = new ArrayList(dedupedLogs);
        final Consumer<List<SecurityLog.SecurityEvent>> callback = this.mInternalEventsCallback;
        this.mHandler.post(new SecurityLogMonitor$$ExternalSyntheticLambda0(callback, events));
    L27:
        SecurityLog.redactEvents(dedupedLogs, this.mEnabledUser);
        goto L28
    }

    private static /* synthetic */ void lambda$mergeBatchLocked$1(Consumer callback, ArrayList events) {
        callback.accept(events);
    }

    private void addToLegacyBufferLocked(List<SecurityLog.SecurityEvent> dedupedLogs) {
        this.mPendingLogs.addAll(dedupedLogs);
        checkCriticalLevel();
        if (this.mPendingLogs.size() <= 10240) goto L6;
        this.mPendingLogs = new ArrayList(this.mPendingLogs.subList(this.mPendingLogs.size() - 5120, this.mPendingLogs.size()));
        this.mCriticalLevelLogged = false;
        Slog.i(TAG, "Pending logs buffer full. Discarding old logs.");
        return;
    }

    private void checkCriticalLevel() {
        if (SecurityLog.isLoggingEnabled() == true) goto L6;
        return;
    L6:
        if (this.mPendingLogs.size() >= BUFFER_ENTRIES_CRITICAL_LEVEL) goto L8;
        return;
    L8:
        if (this.mCriticalLevelLogged == true) goto L12;
        this.mCriticalLevelLogged = true;
        SecurityLog.writeEvent(210015, new Object[0]);
        return;
    }

    private void assignLogId(SecurityLog.SecurityEvent event) {
        event.setId(this.mId);
        if (this.mId != Long.MAX_VALUE) goto L5;
        Slog.i(TAG, "Reached maximum id value; wrapping around.");
        this.mId = 0;
        return;
    L5:
        this.mId++;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        ArrayList<SecurityLog.SecurityEvent> newLogs = new ArrayList();
    L4:
        if (Thread.currentThread().isInterrupted() == true) goto L20;
        boolean force = this.mForceSemaphore.tryAcquire(POLLING_INTERVAL_MS, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L10 IOException -> L12
        getNextBatch(newLogs);     // Catch: InterruptedException -> L10 IOException -> L12
        this.mLock.lockInterruptibly();     // Catch: InterruptedException -> L10 IOException -> L12
        mergeBatchLocked(newLogs);     // Catch: Throwable -> L15
        this.mLock.unlock();     // Catch: InterruptedException -> L10 IOException -> L12
        saveLastEvents(newLogs);     // Catch: InterruptedException -> L10 IOException -> L12
        newLogs.clear();     // Catch: InterruptedException -> L10 IOException -> L12
        if (this.mLegacyLogEnabled == false) goto L4;
        notifyDeviceOwnerOrProfileOwnerIfNeeded(force);     // Catch: InterruptedException -> L10 IOException -> L12
        goto L4
    L15:
        th = move-exception;
        this.mLock.unlock();     // Catch: InterruptedException -> L10 IOException -> L12
        throw th;     // Catch: InterruptedException -> L10 IOException -> L12
    L12:
        e = move-exception;
        Log.e(TAG, "Failed to read security log", e);
    L10:
        e = move-exception;
        Log.i(TAG, "Thread interrupted, exiting.", e);
    L20:
        this.mLastEvents.clear();
        if (this.mLastEventNanos == (-1)) goto L23;
        this.mLastEventNanos++;
    L23:
        Slog.i(TAG, "MonitorThread exit.");
    }

    private void notifyDeviceOwnerOrProfileOwnerIfNeeded(boolean force) throws InterruptedException {
        boolean allowRetrievalAndNotifyDOOrPO = false;
        this.mLock.lockInterruptibly();
    L18:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L4:
        if (this.mPaused == false) goto L7;
        this.mLock.unlock();
        return;
    L7:
        int logSize = this.mPendingLogs.size();     // Catch: Throwable -> L18
        if (logSize >= 1024) goto L12;
        if (force == false) goto L14;
        if (logSize > 0) goto L12;
    L14:
        if (logSize > 0) goto L16;
    L20:
        if (allowRetrievalAndNotifyDOOrPO == false) goto L22;
        this.mAllowedToRetrieve = true;     // Catch: Throwable -> L18
        this.mNextAllowedRetrievalTimeMillis = SystemClock.elapsedRealtime() + BROADCAST_RETRY_INTERVAL_MS;     // Catch: Throwable -> L18
    L22:
        this.mLock.unlock();
        if (allowRetrievalAndNotifyDOOrPO == false) goto L30;
        Slog.i(TAG, "notify DO or PO");
        this.mService.sendDeviceOwnerOrProfileOwnerCommand("android.app.action.SECURITY_LOGS_AVAILABLE", null, this.mEnabledUser);
        return;
    L30:
        return;
    L16:
        if (SystemClock.elapsedRealtime() < this.mNextAllowedRetrievalTimeMillis) goto L20;
        allowRetrievalAndNotifyDOOrPO = true;
    L12:
        if (this.mAllowedToRetrieve == true) goto L14;
        allowRetrievalAndNotifyDOOrPO = true;
        goto L14
    }

    public long forceLogs() {
        long nowNanos = System.nanoTime();
        Semaphore r2 = this.mForceSemaphore;
        monitor-enter(r2);
        long toWaitNanos = (this.mLastForceNanos + FORCE_FETCH_THROTTLE_NS) - nowNanos;     // Catch: Throwable -> L9
        if (toWaitNanos <= 0) goto L11;
        long r5 = TimeUnit.NANOSECONDS.toMillis(toWaitNanos) + 1;     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return r5;
    L11:
        this.mLastForceNanos = nowNanos;     // Catch: Throwable -> L9
        if (this.mForceSemaphore.availablePermits() != 0) goto L14;
        this.mForceSemaphore.release();     // Catch: Throwable -> L9
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    public void setAuditLogEventsCallback(int uid, IAuditLogEventsCallback callback) {
        this.mLock.lock();
        if (callback != null) goto L9;
        this.mAuditLogCallbacks.remove(uid);     // Catch: Throwable -> L7
        Slogf.i(TAG, "Cleared audit log callback for UID %d", new Object[]{Integer.valueOf(uid)});     // Catch: Throwable -> L7
        this.mLock.unlock();
        return;
    L9:
        List<SecurityLog.SecurityEvent> events = new ArrayList(this.mAuditLogEventBuffer);     // Catch: Throwable -> L7
        scheduleSendAuditLogs(uid, callback, events);     // Catch: Throwable -> L7
        this.mAuditLogCallbacks.append(uid, callback);     // Catch: Throwable -> L7
        this.mLock.unlock();
        Slogf.i(TAG, "Set audit log callback for UID %d", new Object[]{Integer.valueOf(uid)});
        return;
    L7:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void addAuditLogEventsLocked(List<SecurityLog.SecurityEvent> events) {
        if (this.mPaused == false) goto L6;
        return;
    L6:
        if (events.isEmpty() == true) goto L11;
        int i = 0;
    L9:
        if (i >= this.mAuditLogCallbacks.size()) goto L11;
        int uid = this.mAuditLogCallbacks.keyAt(i);
        scheduleSendAuditLogs(uid, this.mAuditLogCallbacks.valueAt(i), events);
        i = i + 1;
    L11:
        this.mAuditLogEventBuffer.addAll(events);
        trimAuditLogBufferLocked();
    }

    private void trimAuditLogBufferLocked() {
        long nowNanos = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        Iterator<SecurityLog.SecurityEvent> iterator = this.mAuditLogEventBuffer.iterator();
    L4:
        if (iterator.hasNext() == false) goto L11;
        SecurityLog.SecurityEvent event = iterator.next();
        if (this.mAuditLogEventBuffer.size() > 10000) goto L10;
        if ((nowNanos - event.getTimeNanos()) > MAX_AUDIT_LOG_EVENT_AGE_NS) goto L10;
        return;
    L10:
        iterator.remove();
        goto L4
    }

    private /* synthetic */ void lambda$scheduleSendAuditLogs$2(int uid, IAuditLogEventsCallback callback, List events) {
        sendAuditLogs(uid, callback, events);
    }

    private void scheduleSendAuditLogs(final int uid, final IAuditLogEventsCallback callback, final List<SecurityLog.SecurityEvent> events) {
        this.mHandler.post(new SecurityLogMonitor$$ExternalSyntheticLambda1(this, uid, callback, events));
    }

    private void sendAuditLogs(int uid, IAuditLogEventsCallback callback, List<SecurityLog.SecurityEvent> events) {
        events.size();     // Catch: RemoteException -> L4
        callback.onNewAuditLogEvents(events);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slogf.e(TAG, e, "Failed to invoke audit log callback for UID %d", new Object[]{Integer.valueOf(uid)});
        removeAuditLogEventsCallbackIfDead(uid, callback);
    }

    private void removeAuditLogEventsCallbackIfDead(int uid, IAuditLogEventsCallback callback) {
        IBinder binder = callback.asBinder();
        if (binder.isBinderAlive() == false) goto L6;
        Slog.i(TAG, "Callback binder is still alive, not removing.");
        return;
    L6:
        this.mLock.lock();
        int index = this.mAuditLogCallbacks.indexOfKey(uid);     // Catch: Throwable -> L12
        if (index >= 0) goto L14;
        Slogf.i(TAG, "Callback not registered for UID %d, nothing to remove", new Object[]{Integer.valueOf(uid)});     // Catch: Throwable -> L12
        this.mLock.unlock();
        return;
    L14:
        IBinder storedBinder = this.mAuditLogCallbacks.valueAt(index).asBinder();     // Catch: Throwable -> L12
        if (storedBinder.equals(binder) == true) goto L19;
        Slogf.i(TAG, "Callback is already replaced for UID %d, not removing", new Object[]{Integer.valueOf(uid)});     // Catch: Throwable -> L12
        this.mLock.unlock();
        return;
    L19:
        Slogf.i(TAG, "Removing callback for UID %d", new Object[]{Integer.valueOf(uid)});     // Catch: Throwable -> L12
        this.mAuditLogCallbacks.removeAt(index);     // Catch: Throwable -> L12
        this.mLock.unlock();
        return;
    L12:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void setInternalEventsCallback(Consumer<List<SecurityLog.SecurityEvent>> callback) {
        this.mLock.lock();
        this.mInternalEventsCallback = callback;     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }
}
