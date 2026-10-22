package com.android.server.timedetector;

import android.R;
import android.app.AlarmManager;
import android.app.time.UnixEpochTime;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import android.util.LocalLog;
import android.util.Log;
import android.util.NtpTrustedTime;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkTimeUpdateService extends Binder {
    private static final boolean DBG = false;
    private static final String TAG = "NetworkTimeUpdateService";
    private final ConnectivityManager mCM;
    private final Context mContext;
    private Network mDefaultNetwork;
    private final Engine mEngine;
    private final Handler mHandler;
    private final Object mLock;
    private final NtpTrustedTime mNtpTrustedTime;
    private final Engine.RefreshCallbacks mRefreshCallbacks;
    private final PowerManager.WakeLock mWakeLock;

    private class AutoTimeSettingObserver extends ContentObserver {
        private final Context mContext;
        final /* synthetic */ NetworkTimeUpdateService this$0;

        AutoTimeSettingObserver(NetworkTimeUpdateService r1, Handler handler, Context context) {
            this.this$0 = r1;
            super(handler);
            context.getClass();
            this.mContext = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            if (isAutomaticTimeEnabled() == false) goto L6;
            NetworkTimeUpdateService.m8553$$Nest$monPollNetworkTime(this.this$0, "automatic time enabled");
            return;
        }

        private boolean isAutomaticTimeEnabled() {
            ContentResolver resolver = this.mContext.getContentResolver();
            if (Settings.Global.getInt(resolver, "auto_time", 0) == 0) goto L6;
            return true;
        L6:
            return false;
        }
    }

    interface Engine {

        public interface RefreshCallbacks {
            void scheduleNextRefresh(long r1);

            void submitSuggestion(NetworkTimeSuggestion r1);
        }

        void dump(PrintWriter r1);

        boolean forceRefreshForTests(Network r1, RefreshCallbacks r2);

        void refreshAndRescheduleIfRequired(Network r1, String r2, RefreshCallbacks r3);
    }

    static class EngineImpl implements Engine {
        private final Supplier<Long> mElapsedRealtimeMillisSupplier;
        private Long mLastRefreshAttemptElapsedRealtimeMillis;
        private final LocalLog mLocalDebugLog;
        private final int mNormalPollingIntervalMillis;
        private final NtpTrustedTime mNtpTrustedTime;
        private final int mShortPollingIntervalMillis;
        private int mTryAgainCounter;
        private final int mTryAgainTimesMax;

        EngineImpl(Supplier<Long> elapsedRealtimeMillisSupplier, int normalPollingIntervalMillis, int shortPollingIntervalMillis, int tryAgainTimesMax, NtpTrustedTime ntpTrustedTime) {
            this.mLocalDebugLog = new LocalLog(30, false);
            elapsedRealtimeMillisSupplier.getClass();
            this.mElapsedRealtimeMillisSupplier = elapsedRealtimeMillisSupplier;
            if (shortPollingIntervalMillis > normalPollingIntervalMillis) goto L7;
            this.mNormalPollingIntervalMillis = normalPollingIntervalMillis;
            this.mShortPollingIntervalMillis = shortPollingIntervalMillis;
            this.mTryAgainTimesMax = tryAgainTimesMax;
            ntpTrustedTime.getClass();
            this.mNtpTrustedTime = ntpTrustedTime;
            return;
        L7:
            throw new IllegalArgumentException(String.format("shortPollingIntervalMillis (%s) > normalPollingIntervalMillis (%s)", new Object[]{Integer.valueOf(shortPollingIntervalMillis), Integer.valueOf(normalPollingIntervalMillis)}));
        }

        @Override // com.android.server.timedetector.NetworkTimeUpdateService.Engine
        public boolean forceRefreshForTests(Network network, Engine.RefreshCallbacks refreshCallbacks) {
            boolean refreshSuccessful = tryRefresh(network);
            logToDebugAndDumpsys("forceRefreshForTests: refreshSuccessful=" + refreshSuccessful);
            if (refreshSuccessful == false) goto L8;
            NtpTrustedTime.TimeResult cachedTimeResult = this.mNtpTrustedTime.getCachedTimeResult();
            if (cachedTimeResult != null) goto L7;
            logToDebugAndDumpsys("forceRefreshForTests: cachedTimeResult unexpectedly null");
            goto L8
        L7:
            makeNetworkTimeSuggestion(cachedTimeResult, "EngineImpl.forceRefreshForTests()", refreshCallbacks);
        L8:
            return refreshSuccessful;
        }

        @Override // com.android.server.timedetector.NetworkTimeUpdateService.Engine
        public void refreshAndRescheduleIfRequired(Network network, String reason, Engine.RefreshCallbacks refreshCallbacks) {
            if (network != null) goto L6;
            logToDebugAndDumpsys("refreshIfRequiredAndReschedule: reason=" + reason + ": No default network available. No refresh attempted and no next attempt scheduled.");
            return;
        L6:
            NtpTrustedTime.TimeResult initialTimeResult = this.mNtpTrustedTime.getCachedTimeResult();
            monitor-enter(this);
            long currentElapsedRealtimeMillis = this.mElapsedRealtimeMillisSupplier.get().longValue();     // Catch: Throwable -> L13
            long timeResultAgeMillis = calculateTimeResultAgeMillis(initialTimeResult, currentElapsedRealtimeMillis);     // Catch: Throwable -> L13
            if (timeResultAgeMillis >= this.mNormalPollingIntervalMillis) goto L11;
        L15:
            boolean r0 = false;
        L16:
            boolean shouldAttemptRefresh = r0;
            monitor-exit(this);     // Catch: Throwable -> L13
            if (shouldAttemptRefresh == false) goto L21;
            boolean refreshSuccessful = tryRefresh(network);
            boolean refreshSuccessful2 = refreshSuccessful;
        L22:
            monitor-enter(this);
            NtpTrustedTime.TimeResult latestTimeResult = this.mNtpTrustedTime.getCachedTimeResult();     // Catch: Throwable -> L27
            long currentElapsedRealtimeMillis2 = this.mElapsedRealtimeMillisSupplier.get().longValue();     // Catch: Throwable -> L27
            long latestTimeResultAgeMillis = calculateTimeResultAgeMillis(latestTimeResult, currentElapsedRealtimeMillis2);     // Catch: Throwable -> L27
            if (shouldAttemptRefresh == false) goto L36;
            if (refreshSuccessful2 == false) goto L30;
            this.mTryAgainCounter = 0;     // Catch: Throwable -> L27
            goto L36
        L30:
            if (this.mTryAgainTimesMax >= 0) goto L32;
            this.mTryAgainCounter = 1;     // Catch: Throwable -> L27
            goto L36
        L32:
            this.mTryAgainCounter++;     // Catch: Throwable -> L27
            if (this.mTryAgainCounter <= this.mTryAgainTimesMax) goto L36;
            this.mTryAgainCounter = 0;     // Catch: Throwable -> L27
        L36:
            if (latestTimeResultAgeMillis >= this.mNormalPollingIntervalMillis) goto L39;
            this.mTryAgainCounter = 0;     // Catch: Throwable -> L27
        L39:
            if (latestTimeResultAgeMillis >= this.mNormalPollingIntervalMillis) goto L42;
            makeNetworkTimeSuggestion(latestTimeResult, reason, refreshCallbacks);     // Catch: Throwable -> L27
        L42:
            if (this.mTryAgainCounter <= 0) goto L45;
            int r10 = this.mShortPollingIntervalMillis;     // Catch: Throwable -> L27
        L44:
            long refreshAttemptDelayMillis = r10;
            if (latestTimeResultAgeMillis >= refreshAttemptDelayMillis) goto L50;
            long nextRefreshElapsedRealtimeMillis = latestTimeResult.getElapsedRealtimeMillis() + refreshAttemptDelayMillis;     // Catch: Throwable -> L27
        L54:
            if (nextRefreshElapsedRealtimeMillis > currentElapsedRealtimeMillis2) goto L56;
            long currentElapsedRealtimeMillis3 = currentElapsedRealtimeMillis2;
            Log.w(NetworkTimeUpdateService.TAG, "nextRefreshElapsedRealtimeMillis is a time in the past. Scheduling using currentElapsedRealtimeMillis instead");     // Catch: Throwable -> L27
            logToDebugAndDumpsys("nextRefreshElapsedRealtimeMillis is a time in the past. Scheduling using currentElapsedRealtimeMillis instead");     // Catch: Throwable -> L27
            nextRefreshElapsedRealtimeMillis = currentElapsedRealtimeMillis3 + refreshAttemptDelayMillis;     // Catch: Throwable -> L27
        L57:
            refreshCallbacks.scheduleNextRefresh(nextRefreshElapsedRealtimeMillis);     // Catch: Throwable -> L27
            logToDebugAndDumpsys("refreshIfRequiredAndReschedule: network=" + network + ", reason=" + reason + ", initialTimeResult=" + initialTimeResult + ", shouldAttemptRefresh=" + shouldAttemptRefresh + ", refreshSuccessful=" + refreshSuccessful2 + ", currentElapsedRealtimeMillis=" + formatElapsedRealtimeMillis(currentElapsedRealtimeMillis3) + ", latestTimeResult=" + latestTimeResult + ", mTryAgainCounter=" + this.mTryAgainCounter + ", refreshAttemptDelayMillis=" + refreshAttemptDelayMillis + ", nextRefreshElapsedRealtimeMillis=" + formatElapsedRealtimeMillis(nextRefreshElapsedRealtimeMillis));     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L56:
            currentElapsedRealtimeMillis3 = currentElapsedRealtimeMillis2;
            goto L57
        L50:
            if (this.mLastRefreshAttemptElapsedRealtimeMillis == null) goto L52;
            nextRefreshElapsedRealtimeMillis = this.mLastRefreshAttemptElapsedRealtimeMillis.longValue() + refreshAttemptDelayMillis;     // Catch: Throwable -> L27
            goto L54
        L52:
            Log.w(NetworkTimeUpdateService.TAG, "mLastRefreshAttemptElapsedRealtimeMillis unexpectedly missing. Scheduling using currentElapsedRealtimeMillis");     // Catch: Throwable -> L27
            logToDebugAndDumpsys("mLastRefreshAttemptElapsedRealtimeMillis unexpectedly missing. Scheduling using currentElapsedRealtimeMillis");     // Catch: Throwable -> L27
            nextRefreshElapsedRealtimeMillis = currentElapsedRealtimeMillis2 + refreshAttemptDelayMillis;     // Catch: Throwable -> L27
            goto L54
        L45:
            r10 = this.mNormalPollingIntervalMillis;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            throw th;
        L21:
            refreshSuccessful2 = false;
            goto L22
        L11:
            if (isRefreshAllowed(currentElapsedRealtimeMillis) == false) goto L15;
            r0 = true;
        L13:
            th = move-exception;
            throw th;
        }

        private static String formatElapsedRealtimeMillis(long elapsedRealtimeMillis) {
            return Duration.ofMillis(elapsedRealtimeMillis) + " (" + elapsedRealtimeMillis + ")";
        }

        private static long calculateTimeResultAgeMillis(NtpTrustedTime.TimeResult timeResult, long currentElapsedRealtimeMillis) {
            if (timeResult != null) goto L5;
            return Long.MAX_VALUE;
        L5:
            return timeResult.getAgeMillis(currentElapsedRealtimeMillis);
        }

        private boolean isRefreshAllowed(long currentElapsedRealtimeMillis) {
            if (this.mLastRefreshAttemptElapsedRealtimeMillis != null) goto L5;
            return true;
        L5:
            long nextRefreshAllowedElapsedRealtimeMillis = this.mLastRefreshAttemptElapsedRealtimeMillis.longValue() + ((long) this.mShortPollingIntervalMillis);
            if (currentElapsedRealtimeMillis >= nextRefreshAllowedElapsedRealtimeMillis) goto L10;
            return false;
        L10:
            return true;
        }

        private boolean tryRefresh(Network network) {
            long currentElapsedRealtimeMillis = this.mElapsedRealtimeMillisSupplier.get().longValue();
            monitor-enter(this);
            this.mLastRefreshAttemptElapsedRealtimeMillis = Long.valueOf(currentElapsedRealtimeMillis);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return this.mNtpTrustedTime.forceRefresh(network);
        L8:
            th = move-exception;
            throw th;
        }

        private void makeNetworkTimeSuggestion(NtpTrustedTime.TimeResult timeResult, String debugInfo, Engine.RefreshCallbacks refreshCallbacks) {
            UnixEpochTime timeSignal = new UnixEpochTime(timeResult.getElapsedRealtimeMillis(), timeResult.getTimeMillis());
            NetworkTimeSuggestion timeSuggestion = new NetworkTimeSuggestion(timeSignal, timeResult.getUncertaintyMillis());
            timeSuggestion.addDebugInfo(new String[]{debugInfo});
            timeSuggestion.addDebugInfo(new String[]{timeResult.toString()});
            refreshCallbacks.submitSuggestion(timeSuggestion);
        }

        @Override // com.android.server.timedetector.NetworkTimeUpdateService.Engine
        public void dump(PrintWriter pw) {
            IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
            ipw.println("mNormalPollingIntervalMillis=" + this.mNormalPollingIntervalMillis);
            ipw.println("mShortPollingIntervalMillis=" + this.mShortPollingIntervalMillis);
            ipw.println("mTryAgainTimesMax=" + this.mTryAgainTimesMax);
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mLastRefreshAttemptElapsedRealtimeMillis != null) goto L9;
            String lastRefreshAttemptValue = "null";
        L10:
            ipw.println("mLastRefreshAttemptElapsedRealtimeMillis=" + lastRefreshAttemptValue);     // Catch: Throwable -> L7
            ipw.println("mTryAgainCounter=" + this.mTryAgainCounter);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            ipw.println();
            ipw.println("NtpTrustedTime:");
            ipw.increaseIndent();
            this.mNtpTrustedTime.dump(ipw);
            ipw.decreaseIndent();
            ipw.println();
            ipw.println("Debug log:");
            ipw.increaseIndent();
            this.mLocalDebugLog.dump(ipw);
            ipw.decreaseIndent();
            ipw.println();
            return;
        L9:
            lastRefreshAttemptValue = formatElapsedRealtimeMillis(this.mLastRefreshAttemptElapsedRealtimeMillis.longValue());     // Catch: Throwable -> L7
            goto L10
        }

        private void logToDebugAndDumpsys(String logMsg) {
            this.mLocalDebugLog.log(logMsg);
        }
    }

    private class NetworkConnectivityCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkTimeUpdateService this$0;

        /* synthetic */ NetworkConnectivityCallback(NetworkTimeUpdateService r1, NetworkTimeUpdateServiceIA r2) {
            this(r1);
        }

        private NetworkConnectivityCallback(NetworkTimeUpdateService r1) {
            this.this$0 = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Log.d(NetworkTimeUpdateService.TAG, String.format("New default network %s; checking time.", new Object[]{network}));
            Object r0 = NetworkTimeUpdateService.m8551$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            NetworkTimeUpdateService.m8552$$Nest$fputmDefaultNetwork(this.this$0, network);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            NetworkTimeUpdateService.m8553$$Nest$monPollNetworkTime(this.this$0, "network available");
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities caps) {
            boolean validated = caps.hasCapability(16);
            if (validated == false) goto L6;
            Log.d(NetworkTimeUpdateService.TAG, "Network Capabilities Changed: " + network + " validated=" + validated);
            NetworkTimeUpdateService.m8552$$Nest$fputmDefaultNetwork(this.this$0, network);
            NetworkTimeUpdateService.m8553$$Nest$monPollNetworkTime(this.this$0, "network available");
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Object r0 = NetworkTimeUpdateService.m8551$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (network.equals(NetworkTimeUpdateService.m8549$$Nest$fgetmDefaultNetwork(this.this$0)) == false) goto L9;
            NetworkTimeUpdateService.m8552$$Nest$fputmDefaultNetwork(this.this$0, null);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    private class ScheduledRefreshAlarmListener implements AlarmManager.OnAlarmListener, Runnable {
        final /* synthetic */ NetworkTimeUpdateService this$0;

        /* synthetic */ ScheduledRefreshAlarmListener(NetworkTimeUpdateService r1, NetworkTimeUpdateServiceIA r2) {
            this(r1);
        }

        private ScheduledRefreshAlarmListener(NetworkTimeUpdateService r1) {
            this.this$0 = r1;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            NetworkTimeUpdateService.m8550$$Nest$fgetmHandler(this.this$0).post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkTimeUpdateService.m8553$$Nest$monPollNetworkTime(this.this$0, "scheduled refresh");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultNetwork, reason: not valid java name */
    static /* bridge */ /* synthetic */ Network m8549$$Nest$fgetmDefaultNetwork(NetworkTimeUpdateService r0) {
        return r0.mDefaultNetwork;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8550$$Nest$fgetmHandler(NetworkTimeUpdateService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8551$$Nest$fgetmLock(NetworkTimeUpdateService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDefaultNetwork, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8552$$Nest$fputmDefaultNetwork(NetworkTimeUpdateService r0, Network r1) {
        r0.mDefaultNetwork = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$monPollNetworkTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8553$$Nest$monPollNetworkTime(NetworkTimeUpdateService r0, String r1) {
        r0.onPollNetworkTime(r1);
    }

    public NetworkTimeUpdateService(Context context) {
        this.mLock = new Object();
        this.mDefaultNetwork = null;
        context.getClass();
        this.mContext = context;
        this.mCM = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        this.mWakeLock = ((PowerManager) context.getSystemService(PowerManager.class)).newWakeLock(1, TAG);
        this.mNtpTrustedTime = NtpTrustedTime.getInstance(context);
        Supplier<Long> elapsedRealtimeMillisSupplier = new NetworkTimeUpdateService$$ExternalSyntheticLambda0();
        int tryAgainTimesMax = this.mContext.getResources().getInteger(R.integer.config_pinnerMaxPinnedMemoryPercentage);
        int normalPollingIntervalMillis = this.mContext.getResources().getInteger(R.integer.config_pinnerCameraPinBytes);
        int shortPollingIntervalMillis = this.mContext.getResources().getInteger(R.integer.config_pinnerHomePinBytes);
        this.mEngine = new EngineImpl(elapsedRealtimeMillisSupplier, normalPollingIntervalMillis, shortPollingIntervalMillis, tryAgainTimesMax, this.mNtpTrustedTime);
        final AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        final TimeDetectorInternal timeDetectorInternal = (TimeDetectorInternal) LocalServices.getService(TimeDetectorInternal.class);
        this.mRefreshCallbacks = new AnonymousClass1(this, alarmManager, timeDetectorInternal);
        HandlerThread thread = new HandlerThread(TAG);
        thread.start();
        this.mHandler = thread.getThreadHandler();
    }

    public void systemRunning() {
        NetworkConnectivityCallback networkConnectivityCallback = new NetworkConnectivityCallback(this, null);
        this.mCM.registerDefaultNetworkCallback(networkConnectivityCallback, this.mHandler);
        ContentResolver resolver = this.mContext.getContentResolver();
        AutoTimeSettingObserver autoTimeSettingObserver = new AutoTimeSettingObserver(this, this.mHandler, this.mContext);
        resolver.registerContentObserver(Settings.Global.getUriFor("auto_time"), false, autoTimeSettingObserver);
    }

    void setServerConfigForTests(NtpTrustedTime.NtpConfig ntpConfig) {
        this.mContext.enforceCallingPermission("android.permission.SET_TIME", "set NTP server config for tests");
        long token = Binder.clearCallingIdentity();
        this.mNtpTrustedTime.setServerConfigForTests(ntpConfig);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    boolean forceRefreshForTests() {
        this.mContext.enforceCallingPermission("android.permission.SET_TIME", "force network time refresh");
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        Network network = this.mDefaultNetwork;     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        if (network != null) goto L10;
        Binder.restoreCallingIdentity(token);
        return false;
    L10:
        boolean r3 = this.mEngine.forceRefreshForTests(network, this.mRefreshCallbacks);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return r3;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void onPollNetworkTime(String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Network network = this.mDefaultNetwork;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        this.mWakeLock.acquire();
        this.mEngine.refreshAndRescheduleIfRequired(network, reason, this.mRefreshCallbacks);     // Catch: Throwable -> L10
        this.mWakeLock.release();
        return;
    L10:
        th = move-exception;
        this.mWakeLock.release();
        throw th;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("mDefaultNetwork=" + this.mDefaultNetwork);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mEngine.dump(pw);
        pw.println();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new NetworkTimeUpdateServiceShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }
}
