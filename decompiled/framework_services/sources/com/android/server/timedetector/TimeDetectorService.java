package com.android.server.timedetector;

import android.app.time.ExternalTimeSuggestion;
import android.app.time.ITimeDetectorListener;
import android.app.time.TimeCapabilitiesAndConfig;
import android.app.time.TimeConfiguration;
import android.app.time.TimeState;
import android.app.time.UnixEpochTime;
import android.app.timedetector.ITimeDetectorService;
import android.app.timedetector.ManualTimeSuggestion;
import android.app.timedetector.TelephonyTimeSuggestion;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.ParcelableException;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.NtpTrustedTime;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.server.FgThread;
import com.android.server.SystemService;
import com.android.server.location.gnss.TimeDetectorNetworkTimeHelper;
import com.android.server.timezonedetector.CallerIdentityInjector;
import com.android.server.timezonedetector.CurrentUserIdentityInjector;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.time.DateTimeException;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeDetectorService extends ITimeDetectorService.Stub implements IBinder.DeathRecipient {
    static final String TAG = "time_detector";
    private final CallerIdentityInjector mCallerIdentityInjector;
    private final Context mContext;
    private final Handler mHandler;
    private final ArrayMap<IBinder, ITimeDetectorListener> mListeners;
    private final NtpTrustedTime mNtpTrustedTime;
    private final TimeDetectorStrategy mTimeDetectorStrategy;

    public static class Lifecycle extends SystemService {
        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            Context context = getContext();
            Handler handler = FgThread.getHandler();
            ServiceConfigAccessor serviceConfigAccessor = ServiceConfigAccessorImpl.getInstance(context);
            TimeDetectorStrategy timeDetectorStrategy = TimeDetectorStrategyImpl.create(context, handler, serviceConfigAccessor);
            CurrentUserIdentityInjector currentUserIdentityInjector = CurrentUserIdentityInjector.REAL;
            publishLocalService(TimeDetectorInternal.class, new TimeDetectorInternalImpl(context, handler, currentUserIdentityInjector, serviceConfigAccessor, timeDetectorStrategy));
            CallerIdentityInjector callerIdentityInjector = CallerIdentityInjector.REAL;
            publishBinderService(TimeDetectorService.TAG, new TimeDetectorService(context, handler, callerIdentityInjector, timeDetectorStrategy, NtpTrustedTime.getInstance(context)));
        }
    }

    public static /* synthetic */ void $r8$lambda$DS6HlIiLYXva6vquXcmkQhr52JE(TimeDetectorService r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$EN7QZRbPYZ_SUBWF87NKCcmKHyU(TimeDetectorService r0, NetworkTimeSuggestion r1) {
        r0.lambda$suggestNetworkTime$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$_LLfcDfEebTfdqhbl7tl6sg16wM(TimeDetectorService r0) {
        r0.handleChangeOnHandlerThread();
    }

    /* JADX INFO: renamed from: $r8$lambda$sWZPzjgslPq4cdz-MjG_Hmrtt_Y, reason: not valid java name */
    public static /* synthetic */ void m8559$r8$lambda$sWZPzjgslPq4cdzMjG_Hmrtt_Y(TimeDetectorService r0, TelephonyTimeSuggestion r1) {
        r0.lambda$suggestTelephonyTime$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tuB5k22of5WkdCc-5qTKIr43d90, reason: not valid java name */
    public static /* synthetic */ void m8560$r8$lambda$tuB5k22of5WkdCc5qTKIr43d90(TimeDetectorService r0, GnssTimeSuggestion r1) {
        r0.lambda$suggestGnssTime$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$y_J75_oYh67a3FAzEJUSJOgz1UQ(TimeDetectorService r0, ExternalTimeSuggestion r1) {
        r0.lambda$suggestExternalTime$4(r1);
    }

    public TimeDetectorService(Context context, Handler handler, CallerIdentityInjector callerIdentityInjector, TimeDetectorStrategy timeDetectorStrategy, NtpTrustedTime ntpTrustedTime) {
        this.mListeners = new ArrayMap();
        context.getClass();
        this.mContext = context;
        handler.getClass();
        this.mHandler = handler;
        callerIdentityInjector.getClass();
        this.mCallerIdentityInjector = callerIdentityInjector;
        timeDetectorStrategy.getClass();
        this.mTimeDetectorStrategy = timeDetectorStrategy;
        ntpTrustedTime.getClass();
        this.mNtpTrustedTime = ntpTrustedTime;
        this.mTimeDetectorStrategy.addChangeListener(new TimeDetectorService$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$new$0() {
        this.mHandler.post(new TimeDetectorService$$ExternalSyntheticLambda0(this));
    }

    public TimeCapabilitiesAndConfig getCapabilitiesAndConfig() {
        int userId = this.mCallerIdentityInjector.getCallingUserId();
        return getTimeCapabilitiesAndConfig(userId);
    }

    private TimeCapabilitiesAndConfig getTimeCapabilitiesAndConfig(int userId) {
        enforceManageTimeDetectorPermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        TimeCapabilitiesAndConfig r3 = this.mTimeDetectorStrategy.getCapabilitiesAndConfig(userId, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r3;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public boolean updateConfiguration(TimeConfiguration configuration) {
        int callingUserId = this.mCallerIdentityInjector.getCallingUserId();
        return updateConfiguration(callingUserId, configuration);
    }

    boolean updateConfiguration(int userId, TimeConfiguration configuration) {
        int resolvedUserId = this.mCallerIdentityInjector.resolveUserId(userId, "updateConfiguration");
        enforceManageTimeDetectorPermission();
        configuration.getClass();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r4 = this.mTimeDetectorStrategy.updateConfiguration(resolvedUserId, configuration, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r4;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public void addListener(ITimeDetectorListener listener) {
        enforceManageTimeDetectorPermission();
        listener.getClass();
        ArrayMap<IBinder, ITimeDetectorListener> r0 = this.mListeners;
        monitor-enter(r0);
        IBinder listenerBinder = listener.asBinder();     // Catch: Throwable -> L8
        if (this.mListeners.containsKey(listenerBinder) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        listenerBinder.linkToDeath(this, 0);     // Catch: Throwable -> L8 RemoteException -> L13
        this.mListeners.put(listenerBinder, listener);     // Catch: Throwable -> L8 RemoteException -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        e = move-exception;
        Slog.e(TAG, "Unable to linkToDeath() for listener=" + listener, e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void removeListener(ITimeDetectorListener listener) {
        enforceManageTimeDetectorPermission();
        listener.getClass();
        ArrayMap<IBinder, ITimeDetectorListener> r0 = this.mListeners;
        monitor-enter(r0);
        IBinder listenerBinder = listener.asBinder();     // Catch: Throwable -> L7
        boolean removedListener = false;
        if (this.mListeners.remove(listenerBinder) == null) goto L9;
        listenerBinder.unlinkToDeath(this, 0);     // Catch: Throwable -> L7
        removedListener = true;
    L9:
        if (removedListener == true) goto L11;
        Slog.w(TAG, "Client asked to remove listener=" + listener + ", but no listeners were removed. mListeners=" + this.mListeners);     // Catch: Throwable -> L7
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.wtf(TAG, "binderDied() called unexpectedly.");
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(IBinder who) {
        ArrayMap<IBinder, ITimeDetectorListener> r0 = this.mListeners;
        monitor-enter(r0);
        boolean removedListener = false;
        int listenerCount = this.mListeners.size();     // Catch: Throwable -> L10
        int listenerIndex = listenerCount - 1;     // Catch: Throwable -> L10
    L6:
        if (listenerIndex < 0) goto L13;
        IBinder listenerBinder = this.mListeners.keyAt(listenerIndex);     // Catch: Throwable -> L10
        if (listenerBinder.equals(who) == true) goto L9;
        listenerIndex = listenerIndex - 1;     // Catch: Throwable -> L10
        goto L6
    L9:
        this.mListeners.removeAt(listenerIndex);     // Catch: Throwable -> L10
        removedListener = true;
    L13:
        if (removedListener == true) goto L15;
        Slog.w(TAG, "Notified of binder death for who=" + who + ", but did not remove any listeners. mListeners=" + this.mListeners);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void handleChangeOnHandlerThread() {
        ArrayMap<IBinder, ITimeDetectorListener> r0 = this.mListeners;
        monitor-enter(r0);
        int listenerCount = this.mListeners.size();     // Catch: Throwable -> L9
        int listenerIndex = 0;
    L5:
        if (listenerIndex >= listenerCount) goto L15;
        ITimeDetectorListener listener = this.mListeners.valueAt(listenerIndex);     // Catch: Throwable -> L9
        listener.onChange();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        listenerIndex = listenerIndex + 1;     // Catch: Throwable -> L9
    L11:
        e = move-exception;
        Slog.w(TAG, "Unable to notify listener=" + listener, e);     // Catch: Throwable -> L9
        goto L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public TimeState getTimeState() {
        enforceManageTimeDetectorPermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        TimeState r2 = this.mTimeDetectorStrategy.getTimeState();     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    void setTimeState(TimeState timeState) {
        enforceManageTimeDetectorPermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        this.mTimeDetectorStrategy.setTimeState(timeState);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public boolean confirmTime(UnixEpochTime time) {
        enforceManageTimeDetectorPermission();
        time.getClass();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r2 = this.mTimeDetectorStrategy.confirmTime(time);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setManualTime(ManualTimeSuggestion suggestion) {
        enforceManageTimeDetectorPermission();
        suggestion.getClass();
        int userId = this.mCallerIdentityInjector.getCallingUserId();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r4 = this.mTimeDetectorStrategy.suggestManualTime(userId, suggestion, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r4;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public void suggestTelephonyTime(final TelephonyTimeSuggestion timeSignal) {
        enforceSuggestTelephonyTimePermission();
        timeSignal.getClass();
        this.mHandler.post(new TimeDetectorService$$ExternalSyntheticLambda3(this, timeSignal));
    }

    private /* synthetic */ void lambda$suggestTelephonyTime$1(TelephonyTimeSuggestion timeSignal) {
        this.mTimeDetectorStrategy.suggestTelephonyTime(timeSignal);
    }

    public boolean suggestManualTime(ManualTimeSuggestion timeSignal) {
        enforceSuggestManualTimePermission();
        timeSignal.getClass();
        int userId = this.mCallerIdentityInjector.getCallingUserId();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r4 = this.mTimeDetectorStrategy.suggestManualTime(userId, timeSignal, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r4;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    void suggestNetworkTime(final NetworkTimeSuggestion suggestion) {
        enforceSuggestNetworkTimePermission();
        suggestion.getClass();
        this.mHandler.post(new TimeDetectorService$$ExternalSyntheticLambda5(this, suggestion));
    }

    private /* synthetic */ void lambda$suggestNetworkTime$2(NetworkTimeSuggestion suggestion) {
        this.mTimeDetectorStrategy.suggestNetworkTime(suggestion);
    }

    void clearLatestNetworkTime() {
        enforceSuggestNetworkTimePermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        this.mTimeDetectorStrategy.clearLatestNetworkSuggestion();     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public UnixEpochTime latestNetworkTime() {
        if (TimeDetectorNetworkTimeHelper.isInUse() == false) goto L5;
        NetworkTimeSuggestion latestNetworkTime = this.mTimeDetectorStrategy.getLatestNetworkSuggestion();
    L9:
        if (latestNetworkTime == null) goto L13;
        return latestNetworkTime.getUnixEpochTime();
    L13:
        throw new ParcelableException(new DateTimeException("Missing network time fix"));
    L5:
        NtpTrustedTime.TimeResult ntpResult = this.mNtpTrustedTime.getCachedTimeResult();
        if (ntpResult == null) goto L8;
        latestNetworkTime = new NetworkTimeSuggestion(new UnixEpochTime(ntpResult.getElapsedRealtimeMillis(), ntpResult.getTimeMillis()), ntpResult.getUncertaintyMillis());
        goto L9
    L8:
        latestNetworkTime = null;
        goto L9
    }

    NetworkTimeSuggestion getLatestNetworkSuggestion() {
        return this.mTimeDetectorStrategy.getLatestNetworkSuggestion();
    }

    void suggestGnssTime(final GnssTimeSuggestion timeSignal) {
        enforceSuggestGnssTimePermission();
        timeSignal.getClass();
        this.mHandler.post(new TimeDetectorService$$ExternalSyntheticLambda1(this, timeSignal));
    }

    private /* synthetic */ void lambda$suggestGnssTime$3(GnssTimeSuggestion timeSignal) {
        this.mTimeDetectorStrategy.suggestGnssTime(timeSignal);
    }

    public void suggestExternalTime(final ExternalTimeSuggestion timeSignal) {
        enforceSuggestExternalTimePermission();
        timeSignal.getClass();
        this.mHandler.post(new TimeDetectorService$$ExternalSyntheticLambda2(this, timeSignal));
    }

    private /* synthetic */ void lambda$suggestExternalTime$4(ExternalTimeSuggestion timeSignal) {
        this.mTimeDetectorStrategy.suggestExternalTime(timeSignal);
    }

    void setNetworkTimeForSystemClockForTests(UnixEpochTime unixEpochTime, int uncertaintyMillis) {
        enforceSuggestNetworkTimePermission();
        if (TimeDetectorNetworkTimeHelper.isInUse() == false) goto L5;
        NetworkTimeSuggestion suggestion = new NetworkTimeSuggestion(unixEpochTime, uncertaintyMillis);
        suggestion.addDebugInfo(new String[]{"Injected for tests"});
        this.mTimeDetectorStrategy.suggestNetworkTime(suggestion);
        return;
    L5:
        NtpTrustedTime.TimeResult timeResult = new NtpTrustedTime.TimeResult(unixEpochTime.getUnixEpochTimeMillis(), unixEpochTime.getElapsedRealtimeMillis(), uncertaintyMillis, InetSocketAddress.createUnresolved("time.set.for.tests", 123));
        this.mNtpTrustedTime.setCachedTimeResult(timeResult);
    }

    void clearNetworkTimeForSystemClockForTests() {
        enforceSuggestNetworkTimePermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    L4:
        if (TimeDetectorNetworkTimeHelper.isInUse() == false) goto L8;
        this.mTimeDetectorStrategy.clearLatestNetworkSuggestion();     // Catch: Throwable -> L6
    L9:
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return;
    L8:
        this.mNtpTrustedTime.clearCachedTimeResult();     // Catch: Throwable -> L6
        goto L9
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        this.mTimeDetectorStrategy.dump(ipw, args);
        ipw.flush();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new TimeDetectorShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    private void enforceSuggestTelephonyTimePermission() {
        this.mContext.enforceCallingPermission("android.permission.SUGGEST_TELEPHONY_TIME_AND_ZONE", "suggest telephony time and time zone");
    }

    private void enforceSuggestManualTimePermission() {
        this.mContext.enforceCallingPermission("android.permission.SUGGEST_MANUAL_TIME_AND_ZONE", "suggest manual time and time zone");
    }

    private void enforceSuggestNetworkTimePermission() {
        this.mContext.enforceCallingPermission("android.permission.SET_TIME", "suggest network time");
    }

    private void enforceSuggestGnssTimePermission() {
        this.mContext.enforceCallingPermission("android.permission.SET_TIME", "suggest gnss time");
    }

    private void enforceSuggestExternalTimePermission() {
        this.mContext.enforceCallingPermission("android.permission.SUGGEST_EXTERNAL_TIME", "suggest time from external source");
    }

    private void enforceManageTimeDetectorPermission() {
        this.mContext.enforceCallingPermission("android.permission.MANAGE_TIME_AND_ZONE_DETECTION", "manage time and time zone detection");
    }
}
