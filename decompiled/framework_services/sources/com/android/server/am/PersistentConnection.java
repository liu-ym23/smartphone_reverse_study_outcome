package com.android.server.am;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Log;
import android.util.TimeUtils;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class PersistentConnection<T> {
    private static final boolean DEBUG = false;
    private final Runnable mBindForBackoffRunnable;
    private boolean mBound;
    private final ComponentName mComponentName;
    private final Context mContext;
    private final Handler mHandler;
    private boolean mIsConnected;
    private long mLastConnectedTime;
    private final Object mLock;
    private long mNextBackoffMs;
    private int mNumBindingDied;
    private int mNumConnected;
    private int mNumDisconnected;
    private final double mRebindBackoffIncrease;
    private final long mRebindBackoffMs;
    private final long mRebindMaxBackoffMs;
    private boolean mRebindScheduled;
    private long mReconnectTime;
    private final long mResetBackoffDelay;
    private T mService;
    private final ServiceConnection mServiceConnection;
    private boolean mShouldBeBound;
    private final Runnable mStableCheck;
    private final String mTag;
    private final int mUserId;

    public static /* synthetic */ void $r8$lambda$CjtpKEkvktz4DIkv63_rNKq0jlA(PersistentConnection r0) {
        r0.stableConnectionCheck();
    }

    /* JADX INFO: renamed from: $r8$lambda$lRJGeY3WLqv-T605fpV8cYhSeEw, reason: not valid java name */
    public static /* synthetic */ void m1532$r8$lambda$lRJGeY3WLqvT605fpV8cYhSeEw(PersistentConnection r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1533$$Nest$fgetmBound(PersistentConnection r0) {
        return r0.mBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComponentName, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m1534$$Nest$fgetmComponentName(PersistentConnection r0) {
        return r0.mComponentName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1535$$Nest$fgetmLock(PersistentConnection r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNumBindingDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1536$$Nest$fgetmNumBindingDied(PersistentConnection r0) {
        return r0.mNumBindingDied;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNumConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1537$$Nest$fgetmNumConnected(PersistentConnection r0) {
        return r0.mNumConnected;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNumDisconnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1538$$Nest$fgetmNumDisconnected(PersistentConnection r0) {
        return r0.mNumDisconnected;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1539$$Nest$fgetmTag(PersistentConnection r0) {
        return r0.mTag;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1540$$Nest$fgetmUserId(PersistentConnection r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1541$$Nest$fputmIsConnected(PersistentConnection r0, boolean r1) {
        r0.mIsConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastConnectedTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1542$$Nest$fputmLastConnectedTime(PersistentConnection r0, long r1) {
        r0.mLastConnectedTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNumBindingDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1543$$Nest$fputmNumBindingDied(PersistentConnection r0, int r1) {
        r0.mNumBindingDied = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNumConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1544$$Nest$fputmNumConnected(PersistentConnection r0, int r1) {
        r0.mNumConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNumDisconnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1545$$Nest$fputmNumDisconnected(PersistentConnection r0, int r1) {
        r0.mNumDisconnected = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: -$$Nest$fputmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1546$$Nest$fputmService(PersistentConnection r0, Object r1) {
        r0.mService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanUpConnectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1547$$Nest$mcleanUpConnectionLocked(PersistentConnection r0) {
        r0.cleanUpConnectionLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleStableCheckLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1548$$Nest$mscheduleStableCheckLocked(PersistentConnection r0) {
        r0.scheduleStableCheckLocked();
    }

    protected abstract T asInterface(IBinder r1);

    protected abstract int getBindFlags();

    private /* synthetic */ void lambda$new$0() {
        bindForBackoff();
    }

    public PersistentConnection(String tag, Context context, Handler handler, int userId, ComponentName componentName, long rebindBackoffSeconds, double rebindBackoffIncrease, long rebindMaxBackoffSeconds, long resetBackoffDelay) {
        this.mLock = new Object();
        this.mServiceConnection = new AnonymousClass1(this);
        this.mBindForBackoffRunnable = new PersistentConnection$$ExternalSyntheticLambda0(this);
        this.mStableCheck = new PersistentConnection$$ExternalSyntheticLambda1(this);
        this.mTag = tag;
        this.mContext = context;
        this.mHandler = handler;
        this.mUserId = userId;
        this.mComponentName = componentName;
        this.mRebindBackoffMs = rebindBackoffSeconds * 1000;
        this.mRebindBackoffIncrease = rebindBackoffIncrease;
        this.mRebindMaxBackoffMs = rebindMaxBackoffSeconds * 1000;
        this.mResetBackoffDelay = 1000 * resetBackoffDelay;
        this.mNextBackoffMs = this.mRebindBackoffMs;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getUserId() {
        return this.mUserId;
    }

    public final boolean isBound() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mBound;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean isRebindScheduled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mRebindScheduled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean isConnected() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsConnected;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final T getServiceBinder() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        T r1 = this.mService;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void bind() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mShouldBeBound = true;     // Catch: Throwable -> L8
        bindInnerLocked(true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public long getNextBackoffMs() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mNextBackoffMs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getNumConnected() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mNumConnected;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getNumDisconnected() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mNumDisconnected;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getNumBindingDied() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mNumBindingDied;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void resetBackoffLocked() {
        if (this.mNextBackoffMs == this.mRebindBackoffMs) goto L6;
        this.mNextBackoffMs = this.mRebindBackoffMs;
        Log.i(this.mTag, "Backoff reset to " + this.mNextBackoffMs);
        return;
    }

    public final void bindInnerLocked(boolean resetBackoff) {
        unscheduleRebindLocked();
        if (this.mBound == false) goto L5;
        return;
    L5:
        this.mBound = true;
        unscheduleStableCheckLocked();
        if (resetBackoff == false) goto L8;
        resetBackoffLocked();
    L8:
        Intent service = new Intent().setComponent(this.mComponentName);
        boolean success = this.mContext.bindServiceAsUser(service, this.mServiceConnection, getBindFlags() | 1, this.mHandler, UserHandle.of(this.mUserId));
        if (success == true) goto L12;
        Log.e(this.mTag, "Binding: " + service.getComponent() + " u" + this.mUserId + " failed.");
        return;
    }

    final void bindForBackoff() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mShouldBeBound == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        bindInnerLocked(false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void cleanUpConnectionLocked() {
        this.mIsConnected = false;
        this.mService = null;
        unscheduleStableCheckLocked();
    }

    public final void unbind() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mShouldBeBound = false;     // Catch: Throwable -> L8
        unbindLocked();     // Catch: Throwable -> L8
        unscheduleStableCheckLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void unbindLocked() {
        unscheduleRebindLocked();
        if (this.mBound == true) goto L5;
        return;
    L5:
        Log.i(this.mTag, "Stopping: " + this.mComponentName.flattenToShortString() + " u" + this.mUserId);
        this.mBound = false;
        this.mContext.unbindService(this.mServiceConnection);
        cleanUpConnectionLocked();
    }

    void unscheduleRebindLocked() {
        injectRemoveCallbacks(this.mBindForBackoffRunnable);
        this.mRebindScheduled = false;
    }

    void scheduleRebindLocked() {
        unbindLocked();
        if (this.mRebindScheduled == true) goto L6;
        Log.i(this.mTag, "Scheduling to reconnect in " + this.mNextBackoffMs + " ms (uptime)");
        this.mReconnectTime = injectUptimeMillis() + this.mNextBackoffMs;
        injectPostAtTime(this.mBindForBackoffRunnable, this.mReconnectTime);
        this.mNextBackoffMs = Math.min(this.mRebindMaxBackoffMs, (long) (((double) this.mNextBackoffMs) * this.mRebindBackoffIncrease));
        this.mRebindScheduled = true;
        return;
    }

    private void stableConnectionCheck() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long now = injectUptimeMillis();     // Catch: Throwable -> L11
        long timeRemaining = (this.mLastConnectedTime + this.mResetBackoffDelay) - now;     // Catch: Throwable -> L11
        if (this.mBound == true) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mIsConnected == false) goto L13;
        if (timeRemaining > 0) goto L13;
        resetBackoffLocked();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void unscheduleStableCheckLocked() {
        injectRemoveCallbacks(this.mStableCheck);
    }

    private void scheduleStableCheckLocked() {
        unscheduleStableCheckLocked();
        injectPostAtTime(this.mStableCheck, injectUptimeMillis() + this.mResetBackoffDelay);
    }

    public void dump(String prefix, PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print(this.mComponentName.flattenToShortString());     // Catch: Throwable -> L7
        pw.print(" u");     // Catch: Throwable -> L7
        pw.print(this.mUserId);     // Catch: Throwable -> L7
        if (this.mBound == false) goto L9;
        String r1 = " [bound]";
    L10:
        pw.print(r1);     // Catch: Throwable -> L7
        if (this.mIsConnected == false) goto L13;
        String r2 = " [connected]";
    L14:
        pw.print(r2);     // Catch: Throwable -> L7
        if (this.mRebindScheduled == false) goto L17;
        pw.print(" reconnect in ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(this.mReconnectTime - injectUptimeMillis(), pw);     // Catch: Throwable -> L7
    L17:
        pw.println();     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("  Next backoff(sec): ");     // Catch: Throwable -> L7
        pw.print(this.mNextBackoffMs / 1000);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("  Connected: ");     // Catch: Throwable -> L7
        pw.print(this.mNumConnected);     // Catch: Throwable -> L7
        pw.print("  Disconnected: ");     // Catch: Throwable -> L7
        pw.print(this.mNumDisconnected);     // Catch: Throwable -> L7
        pw.print("  Died: ");     // Catch: Throwable -> L7
        pw.print(this.mNumBindingDied);     // Catch: Throwable -> L7
        if (this.mIsConnected == false) goto L20;
        pw.print("  Duration: ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(injectUptimeMillis() - this.mLastConnectedTime, pw);     // Catch: Throwable -> L7
    L20:
        pw.println();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L13:
        r2 = " [not connected]";
        goto L14
    L9:
        r1 = " [not bound]";
    L7:
        th = move-exception;
        throw th;
    }

    void injectRemoveCallbacks(Runnable r) {
        this.mHandler.removeCallbacks(r);
    }

    void injectPostAtTime(Runnable r, long uptimeMillis) {
        this.mHandler.postAtTime(r, uptimeMillis);
    }

    long injectUptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    long getNextBackoffMsForTest() {
        return this.mNextBackoffMs;
    }

    long getReconnectTimeForTest() {
        return this.mReconnectTime;
    }

    ServiceConnection getServiceConnectionForTest() {
        return this.mServiceConnection;
    }

    Runnable getBindForBackoffRunnableForTest() {
        return this.mBindForBackoffRunnable;
    }

    Runnable getStableCheckRunnableForTest() {
        return this.mStableCheck;
    }

    boolean shouldBeBoundForTest() {
        return this.mShouldBeBound;
    }
}
