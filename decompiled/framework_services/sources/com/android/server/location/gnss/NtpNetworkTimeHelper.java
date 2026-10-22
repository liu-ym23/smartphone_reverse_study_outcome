package com.android.server.location.gnss;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.IndentingPrintWriter;
import android.util.LocalLog;
import android.util.Log;
import android.util.NtpTrustedTime;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class NtpNetworkTimeHelper extends NetworkTimeHelper {
    private static final boolean DEBUG = false;
    private static final long MAX_RETRY_INTERVAL = 14400000;
    static final long NTP_INTERVAL = 86400000;
    static final long RETRY_INTERVAL = 300000;
    private static final int STATE_IDLE = 2;
    private static final int STATE_PENDING_NETWORK = 0;
    private static final int STATE_RETRIEVING_AND_INJECTING = 1;
    private static final String TAG = "NtpNetworkTimeHelper";
    private static final String WAKELOCK_KEY = "NtpTimeHelper";
    private static final long WAKELOCK_TIMEOUT_MILLIS = 60000;
    private final NetworkTimeHelper.InjectTimeCallback mCallback;
    private final ConnectivityManager mConnMgr;
    private final LocalLog mDumpLog;
    private final Handler mHandler;
    private int mInjectNtpTimeState;
    private final ExponentialBackOff mNtpBackOff;
    private final NtpTrustedTime mNtpTime;
    private boolean mPeriodicTimeInjection;
    private final PowerManager.WakeLock mWakeLock;

    /* JADX INFO: renamed from: $r8$lambda$IPWGbr9Nh36EZ-h3856rT6UZpso, reason: not valid java name */
    public static /* synthetic */ void m5309$r8$lambda$IPWGbr9Nh36EZh3856rT6UZpso(NtpNetworkTimeHelper r0, String r1) {
        r0.lambda$blockingGetNtpTimeAndInject$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$OLV13z6hKfx0FRM6q4N4OOsAAtg(NtpNetworkTimeHelper r0) {
        r0.blockingGetNtpTimeAndInject();
    }

    public static /* synthetic */ void $r8$lambda$Wa7_WJDlBG8wePZdQlvHB6gM8Hw(NtpNetworkTimeHelper r0, long r1, long r3, int r5) {
        r0.lambda$maybeInjectCachedNtpTime$1(r1, r3, r5);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    NtpNetworkTimeHelper(Context context, Looper looper, NetworkTimeHelper.InjectTimeCallback callback, NtpTrustedTime ntpTime) {
        this.mDumpLog = new LocalLog(10, false);
        this.mNtpBackOff = new ExponentialBackOff(300000, 14400000);
        this.mInjectNtpTimeState = 0;
        this.mConnMgr = (ConnectivityManager) context.getSystemService("connectivity");
        this.mCallback = callback;
        this.mNtpTime = ntpTime;
        this.mHandler = new Handler(looper);
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.mWakeLock = powerManager.newWakeLock(1, WAKELOCK_KEY);
    }

    NtpNetworkTimeHelper(Context context, Looper looper, NetworkTimeHelper.InjectTimeCallback callback) {
        this(context, looper, callback, NtpTrustedTime.getInstance(context));
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    synchronized void setPeriodicTimeInjectionMode(boolean periodicTimeInjectionEnabled) {
        monitor-enter(this);
        if (periodicTimeInjectionEnabled == true) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        this.mPeriodicTimeInjection = true;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    void demandUtcTimeInjection() {
        retrieveAndInjectNtpTime("demandUtcTimeInjection");
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    synchronized void onNetworkAvailable() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mInjectNtpTimeState != 0) goto L9;
        retrieveAndInjectNtpTime("onNetworkAvailable");     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    void dump(PrintWriter pw) {
        pw.println("NtpNetworkTimeHelper:");
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.increaseIndent();
        monitor-enter(this);
        ipw.println("mInjectNtpTimeState=" + this.mInjectNtpTimeState);     // Catch: Throwable -> L8
        ipw.println("mPeriodicTimeInjection=" + this.mPeriodicTimeInjection);     // Catch: Throwable -> L8
        ipw.println("mNtpBackOff=" + this.mNtpBackOff);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        ipw.println("Debug log:");
        ipw.increaseIndent();
        this.mDumpLog.dump(ipw);
        ipw.decreaseIndent();
        ipw.println("NtpTrustedTime:");
        ipw.increaseIndent();
        this.mNtpTime.dump(ipw);
        ipw.decreaseIndent();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = this.mConnMgr.getActiveNetworkInfo();
        if (activeNetworkInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (activeNetworkInfo.isConnected() == false) goto L7;
        return true;
    }

    private synchronized void retrieveAndInjectNtpTime(String reason) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mInjectNtpTimeState != 1) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (isNetworkConnected() == true) goto L15;
        maybeInjectCachedNtpTime(reason + "[Network not connected]");     // Catch: Throwable -> L13
        this.mInjectNtpTimeState = 0;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L15:
        this.mInjectNtpTimeState = 1;     // Catch: Throwable -> L13
        this.mWakeLock.acquire(60000);     // Catch: Throwable -> L13
        new Thread(new NtpNetworkTimeHelper$$ExternalSyntheticLambda0(this)).start();     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private void blockingGetNtpTimeAndInject() {
        long debugId = SystemClock.elapsedRealtime();
        boolean refreshSuccess = true;
        NtpTrustedTime.TimeResult ntpResult = this.mNtpTime.getCachedTimeResult();
        if (ntpResult != null) goto L5;
    L6:
        refreshSuccess = this.mNtpTime.forceRefresh();
    L7:
        monitor-enter(this);
        this.mInjectNtpTimeState = 2;     // Catch: Throwable -> L12
        String injectReason = "blockingGetNtpTimeAndInject:, debugId=" + debugId + ", refreshSuccess=" + refreshSuccess;     // Catch: Throwable -> L12
        if (maybeInjectCachedNtpTime(injectReason) == false) goto L14;
        long delayMillis = 86400000;
        this.mNtpBackOff.reset();     // Catch: Throwable -> L12
    L16:
        if (this.mPeriodicTimeInjection == true) goto L18;
        if (refreshSuccess == false) goto L18;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L12
        this.mWakeLock.release();
        return;
    L18:
        String debugMsg = "blockingGetNtpTimeAndInject: Scheduling later NTP retrieval, debugId=" + debugId + ", mPeriodicTimeInjection=" + this.mPeriodicTimeInjection + ", refreshSuccess=" + refreshSuccess + ", delayMillis=" + delayMillis;     // Catch: Throwable -> L12
        logDebug(debugMsg);     // Catch: Throwable -> L12
        final String reason = "scheduled: debugId=" + debugId;     // Catch: Throwable -> L12
        this.mHandler.postDelayed(new NtpNetworkTimeHelper$$ExternalSyntheticLambda1(this, reason), delayMillis);     // Catch: Throwable -> L12
        goto L19
    L14:
        logWarn("maybeInjectCachedNtpTime() returned false");     // Catch: Throwable -> L12
        delayMillis = this.mNtpBackOff.nextBackoffMillis();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L5:
        if (ntpResult.getAgeMillis() < 86400000) goto L7;
        goto L6
    }

    private /* synthetic */ void lambda$blockingGetNtpTimeAndInject$0(String reason) {
        retrieveAndInjectNtpTime(reason);
    }

    private synchronized boolean maybeInjectCachedNtpTime(String reason) {
        monitor-enter(this);
        NtpTrustedTime.TimeResult ntpResult = this.mNtpTime.getCachedTimeResult();     // Catch: Throwable -> L16
        if (ntpResult == null) goto L19;
        if (ntpResult.getAgeMillis() >= 86400000) goto L19;
        final long unixEpochTimeMillis = ntpResult.getTimeMillis();     // Catch: Throwable -> L16
        long currentTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L16
        String debugMsg = "maybeInjectCachedNtpTime: Injecting latest NTP time, reason=" + reason + ", ntpResult=" + ntpResult + ", System time offset millis=" + (unixEpochTimeMillis - currentTimeMillis);     // Catch: Throwable -> L16
        logDebug(debugMsg);     // Catch: Throwable -> L16
        final long timeReferenceMillis = ntpResult.getElapsedRealtimeMillis();     // Catch: Throwable -> L16
        final int uncertaintyMillis = ntpResult.getUncertaintyMillis();     // Catch: Throwable -> L16
        this.mHandler.post(new NtpNetworkTimeHelper$$ExternalSyntheticLambda2(this, unixEpochTimeMillis, timeReferenceMillis, uncertaintyMillis));     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L19:
        String debugMsg2 = "maybeInjectCachedNtpTime: Not injecting latest NTP time, reason=" + reason + ", ntpResult=" + ntpResult;     // Catch: Throwable -> L14
        logDebug(debugMsg2);     // Catch: Throwable -> L14
        monitor-exit(this);
        return false;
    L16:
        th = th;
    L15:
        Throwable r13 = th;
        monitor-exit(this);     // Catch: Throwable -> L14
        throw r13;
    L14:
        th = th;
        goto L15
    }

    private /* synthetic */ void lambda$maybeInjectCachedNtpTime$1(long unixEpochTimeMillis, long timeReferenceMillis, int uncertaintyMillis) {
        this.mCallback.injectTime(unixEpochTimeMillis, timeReferenceMillis, uncertaintyMillis);
    }

    private void logWarn(String logMsg) {
        this.mDumpLog.log(logMsg);
        Log.e(TAG, logMsg);
    }

    private void logDebug(String debugMsg) {
        this.mDumpLog.log(debugMsg);
        if (DEBUG == false) goto L6;
        Log.d(TAG, debugMsg);
        return;
    }
}
