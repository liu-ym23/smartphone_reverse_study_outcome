package com.android.server.location.gnss;

import android.app.time.UnixEpochTime;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.IndentingPrintWriter;
import android.util.LocalLog;
import android.util.Log;
import com.android.server.LocalServices;
import com.android.server.timedetector.NetworkTimeSuggestion;
import com.android.server.timedetector.TimeDetectorInternal;
import com.android.server.timezonedetector.StateChangeListener;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class TimeDetectorNetworkTimeHelper extends NetworkTimeHelper {
    private static final boolean DEBUG = false;
    static final int MAX_NETWORK_TIME_AGE_MILLIS = 86400000;
    static final int NTP_REFRESH_INTERVAL_MILLIS = 86400000;
    private static final String TAG = "TDNetworkTimeHelper";
    private final LocalLog mDumpLog;
    private final Environment mEnvironment;
    private final NetworkTimeHelper.InjectTimeCallback mInjectTimeCallback;
    private boolean mNetworkTimeInjected;
    private boolean mPeriodicTimeInjectionEnabled;

    interface Environment {
        void clearDelayedTimeQueryCallback();

        long elapsedRealtimeMillis();

        NetworkTimeSuggestion getLatestNetworkTime();

        void requestDelayedTimeQueryCallback(TimeDetectorNetworkTimeHelper r1, long r2);

        void requestImmediateTimeQueryCallback(TimeDetectorNetworkTimeHelper r1, String r2);

        void setNetworkTimeUpdateListener(StateChangeListener r1);
    }

    static class EnvironmentImpl implements Environment {
        private final Handler mHandler;
        private final Object mImmediateRunnableToken;
        private final Object mScheduledRunnableToken;
        private final TimeDetectorInternal mTimeDetectorInternal;

        public static /* synthetic */ void $r8$lambda$dEkDddYB5Iz8T29obuGL0xQsU6Y(TimeDetectorNetworkTimeHelper r0, String r1) {
            lambda$requestImmediateTimeQueryCallback$0(r0, r1);
        }

        EnvironmentImpl(Looper looper) {
            this.mScheduledRunnableToken = new Object();
            this.mImmediateRunnableToken = new Object();
            this.mHandler = new Handler(looper);
            this.mTimeDetectorInternal = (TimeDetectorInternal) LocalServices.getService(TimeDetectorInternal.class);
        }

        @Override // com.android.server.location.gnss.TimeDetectorNetworkTimeHelper.Environment
        public long elapsedRealtimeMillis() {
            return SystemClock.elapsedRealtime();
        }

        @Override // com.android.server.location.gnss.TimeDetectorNetworkTimeHelper.Environment
        public NetworkTimeSuggestion getLatestNetworkTime() {
            return this.mTimeDetectorInternal.getLatestNetworkSuggestion();
        }

        @Override // com.android.server.location.gnss.TimeDetectorNetworkTimeHelper.Environment
        public void setNetworkTimeUpdateListener(StateChangeListener stateChangeListener) {
            this.mTimeDetectorInternal.addNetworkTimeUpdateListener(stateChangeListener);
        }

        @Override // com.android.server.location.gnss.TimeDetectorNetworkTimeHelper.Environment
        public void requestImmediateTimeQueryCallback(final TimeDetectorNetworkTimeHelper helper, final String reason) {
            monitor-enter(this);
            this.mHandler.removeCallbacksAndMessages(this.mImmediateRunnableToken);     // Catch: Throwable -> L6
            this.mHandler.postDelayed(new TimeDetectorNetworkTimeHelper$EnvironmentImpl$$ExternalSyntheticLambda0(helper, reason), this.mImmediateRunnableToken, 0);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$requestImmediateTimeQueryCallback$0(TimeDetectorNetworkTimeHelper helper, String reason) {
            helper.queryAndInjectNetworkTime(reason);
        }

        @Override // com.android.server.location.gnss.TimeDetectorNetworkTimeHelper.Environment
        public void requestDelayedTimeQueryCallback(final TimeDetectorNetworkTimeHelper helper, long delayMillis) {
            monitor-enter(this);
            clearDelayedTimeQueryCallback();     // Catch: Throwable -> L6
            Handler r0 = this.mHandler;     // Catch: Throwable -> L6
            helper.getClass();     // Catch: Throwable -> L6
            r0.postDelayed(new TimeDetectorNetworkTimeHelper$EnvironmentImpl$$ExternalSyntheticLambda1(helper), this.mScheduledRunnableToken, delayMillis);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.location.gnss.TimeDetectorNetworkTimeHelper.Environment
        public synchronized void clearDelayedTimeQueryCallback() {
            monitor-enter(this);
            this.mHandler.removeCallbacksAndMessages(this.mScheduledRunnableToken);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static boolean isInUse() {
        return true;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    TimeDetectorNetworkTimeHelper(Environment environment, NetworkTimeHelper.InjectTimeCallback injectTimeCallback) {
        this.mDumpLog = new LocalLog(10, false);
        injectTimeCallback.getClass();
        this.mInjectTimeCallback = injectTimeCallback;
        environment.getClass();
        this.mEnvironment = environment;
        this.mEnvironment.setNetworkTimeUpdateListener(new TimeDetectorNetworkTimeHelper$$ExternalSyntheticLambda0(this));
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    synchronized void setPeriodicTimeInjectionMode(boolean periodicTimeInjectionEnabled) {
        monitor-enter(this);
        this.mPeriodicTimeInjectionEnabled = periodicTimeInjectionEnabled;     // Catch: Throwable -> L6
        if (periodicTimeInjectionEnabled == true) goto L8;
        removePeriodicNetworkTimeQuery();     // Catch: Throwable -> L6
    L8:
        String reason = "setPeriodicTimeInjectionMode(" + periodicTimeInjectionEnabled + ")";     // Catch: Throwable -> L6
        this.mEnvironment.requestImmediateTimeQueryCallback(this, reason);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void onNetworkTimeAvailable() {
        this.mEnvironment.requestImmediateTimeQueryCallback(this, "onNetworkTimeAvailable");
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    void onNetworkAvailable() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mNetworkTimeInjected == true) goto L8;
        this.mEnvironment.requestImmediateTimeQueryCallback(this, "onNetworkAvailable");     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    void demandUtcTimeInjection() {
        this.mEnvironment.requestImmediateTimeQueryCallback(this, "demandUtcTimeInjection");
    }

    void delayedQueryAndInjectNetworkTime() {
        queryAndInjectNetworkTime("delayedTimeQueryCallback");
    }

    synchronized void queryAndInjectNetworkTime(String reason) {
        monitor-enter(this);
        NetworkTimeSuggestion latestNetworkTime = this.mEnvironment.getLatestNetworkTime();     // Catch: Throwable -> L7
        maybeInjectNetworkTime(latestNetworkTime, reason);     // Catch: Throwable -> L7
        removePeriodicNetworkTimeQuery();     // Catch: Throwable -> L7
        if (this.mPeriodicTimeInjectionEnabled == false) goto L9;
        String debugMsg = "queryAndInjectNtpTime: Scheduling periodic query reason=" + reason + " latestNetworkTime=" + latestNetworkTime + " maxDelayMillis=86400000";     // Catch: Throwable -> L7
        logToDumpLog(debugMsg);     // Catch: Throwable -> L7
        this.mEnvironment.requestDelayedTimeQueryCallback(this, 86400000);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private long calculateTimeSignalAgeMillis(NetworkTimeSuggestion networkTimeSuggestion) {
        if (networkTimeSuggestion != null) goto L5;
        return Long.MAX_VALUE;
    L5:
        long suggestionElapsedRealtimeMillis = networkTimeSuggestion.getUnixEpochTime().getElapsedRealtimeMillis();
        long currentElapsedRealtimeMillis = this.mEnvironment.elapsedRealtimeMillis();
        return currentElapsedRealtimeMillis - suggestionElapsedRealtimeMillis;
    }

    private void maybeInjectNetworkTime(NetworkTimeSuggestion latestNetworkTime, String reason) {
        if (calculateTimeSignalAgeMillis(latestNetworkTime) <= 86400000) goto L6;
        String debugMsg = "maybeInjectNetworkTime: Not injecting latest network time latestNetworkTime=" + latestNetworkTime + " reason=" + reason;
        logToDumpLog(debugMsg);
        return;
    L6:
        UnixEpochTime unixEpochTime = latestNetworkTime.getUnixEpochTime();
        long unixEpochTimeMillis = unixEpochTime.getUnixEpochTimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        String debugMsg2 = "maybeInjectNetworkTime: Injecting latest network time latestNetworkTime=" + latestNetworkTime + " reason=" + reason + " System time offset millis=" + (unixEpochTimeMillis - currentTimeMillis);
        logToDumpLog(debugMsg2);
        long timeReferenceMillis = unixEpochTime.getElapsedRealtimeMillis();
        int uncertaintyMillis = latestNetworkTime.getUncertaintyMillis();
        this.mInjectTimeCallback.injectTime(unixEpochTimeMillis, timeReferenceMillis, uncertaintyMillis);
        this.mNetworkTimeInjected = true;
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper
    void dump(PrintWriter pw) {
        pw.println("TimeDetectorNetworkTimeHelper:");
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.increaseIndent();
        monitor-enter(this);
        ipw.println("mPeriodicTimeInjectionEnabled=" + this.mPeriodicTimeInjectionEnabled);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        ipw.println("Debug log:");
        this.mDumpLog.dump(ipw);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void logToDumpLog(String message) {
        this.mDumpLog.log(message);
        if (DEBUG == false) goto L6;
        Log.d(TAG, message);
        return;
    }

    private void removePeriodicNetworkTimeQuery() {
        this.mEnvironment.clearDelayedTimeQueryCallback();
    }
}
