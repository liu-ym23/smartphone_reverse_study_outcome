package com.android.server.timezonedetector;

import android.app.time.ITimeZoneDetectorListener;
import android.app.time.TimeZoneCapabilitiesAndConfig;
import android.app.time.TimeZoneConfiguration;
import android.app.time.TimeZoneState;
import android.app.timezonedetector.ITimeZoneDetectorService;
import android.app.timezonedetector.ManualTimeZoneSuggestion;
import android.app.timezonedetector.TelephonyTimeZoneSuggestion;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.server.FgThread;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeZoneDetectorService extends ITimeZoneDetectorService.Stub implements IBinder.DeathRecipient {
    static final boolean DBG = false;
    static final String TAG = "time_zone_detector";
    private final CallerIdentityInjector mCallerIdentityInjector;
    private final Context mContext;
    private final List<Dumpable> mDumpables;
    private final Handler mHandler;
    private final ArrayMap<IBinder, ITimeZoneDetectorListener> mListeners;
    private final TimeZoneDetectorStrategy mTimeZoneDetectorStrategy;

    public static final class Lifecycle extends SystemService {
        public Lifecycle(Context context) {
            super(context);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0, types: [android.os.IBinder, com.android.server.timezonedetector.TimeZoneDetectorService] */
        @Override // com.android.server.SystemService
        public void onStart() {
            Context context = getContext();
            Handler handler = FgThread.getHandler();
            ServiceConfigAccessor serviceConfigAccessor = ServiceConfigAccessorImpl.getInstance(context);
            final TimeZoneDetectorStrategy timeZoneDetectorStrategy = TimeZoneDetectorStrategyImpl.create(context, handler, serviceConfigAccessor);
            DeviceActivityMonitor deviceActivityMonitor = DeviceActivityMonitorImpl.create(context, handler);
            deviceActivityMonitor.addListener(new AnonymousClass1(this, timeZoneDetectorStrategy));
            CurrentUserIdentityInjector currentUserIdentityInjector = CurrentUserIdentityInjector.REAL;
            publishLocalService(TimeZoneDetectorInternal.class, new TimeZoneDetectorInternalImpl(context, handler, currentUserIdentityInjector, timeZoneDetectorStrategy));
            CallerIdentityInjector callerIdentityInjector = CallerIdentityInjector.REAL;
            ?? r8 = new TimeZoneDetectorService(context, handler, callerIdentityInjector, timeZoneDetectorStrategy);
            r8.addDumpable(deviceActivityMonitor);
            publishBinderService(TimeZoneDetectorService.TAG, r8);
        }
    }

    public static /* synthetic */ void $r8$lambda$4UJD5j1PaXEp01lpNgJbLmNA9Ws(TimeZoneDetectorService r0, LocationAlgorithmEvent r1) {
        r0.lambda$handleLocationAlgorithmEvent$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$DIVa-xqecNb2Nh3O1POYwTkpwzk, reason: not valid java name */
    public static /* synthetic */ void m8597$r8$lambda$DIVaxqecNb2Nh3O1POYwTkpwzk(TimeZoneDetectorService r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$J5BTZ2OuJb4gvpwYS14bI1HdOpU(TimeZoneDetectorService r0, TelephonyTimeZoneSuggestion r1) {
        r0.lambda$suggestTelephonyTimeZone$2(r1);
    }

    public TimeZoneDetectorService(Context context, Handler handler, CallerIdentityInjector callerIdentityInjector, TimeZoneDetectorStrategy timeZoneDetectorStrategy) {
        this.mListeners = new ArrayMap();
        this.mDumpables = new ArrayList();
        context.getClass();
        this.mContext = context;
        handler.getClass();
        this.mHandler = handler;
        callerIdentityInjector.getClass();
        this.mCallerIdentityInjector = callerIdentityInjector;
        timeZoneDetectorStrategy.getClass();
        this.mTimeZoneDetectorStrategy = timeZoneDetectorStrategy;
        this.mTimeZoneDetectorStrategy.addChangeListener(new TimeZoneDetectorService$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$new$0() {
        this.mHandler.post(new TimeZoneDetectorService$$ExternalSyntheticLambda0(this));
    }

    public TimeZoneCapabilitiesAndConfig getCapabilitiesAndConfig() {
        int userId = this.mCallerIdentityInjector.getCallingUserId();
        return getCapabilitiesAndConfig(userId);
    }

    TimeZoneCapabilitiesAndConfig getCapabilitiesAndConfig(int userId) {
        enforceManageTimeZoneDetectorPermission();
        int resolvedUserId = this.mCallerIdentityInjector.resolveUserId(userId, "getCapabilitiesAndConfig");
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        TimeZoneCapabilitiesAndConfig r4 = this.mTimeZoneDetectorStrategy.getCapabilitiesAndConfig(resolvedUserId, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r4;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public boolean updateConfiguration(TimeZoneConfiguration configuration) {
        int callingUserId = this.mCallerIdentityInjector.getCallingUserId();
        return updateConfiguration(callingUserId, configuration);
    }

    boolean updateConfiguration(int userId, TimeZoneConfiguration configuration) {
        int resolvedUserId = this.mCallerIdentityInjector.resolveUserId(userId, "updateConfiguration");
        enforceManageTimeZoneDetectorPermission();
        configuration.getClass();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r4 = this.mTimeZoneDetectorStrategy.updateConfiguration(resolvedUserId, configuration, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r4;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public void addListener(ITimeZoneDetectorListener listener) {
        enforceManageTimeZoneDetectorPermission();
        listener.getClass();
        ArrayMap<IBinder, ITimeZoneDetectorListener> r0 = this.mListeners;
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

    public void removeListener(ITimeZoneDetectorListener listener) {
        enforceManageTimeZoneDetectorPermission();
        listener.getClass();
        ArrayMap<IBinder, ITimeZoneDetectorListener> r0 = this.mListeners;
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
        ArrayMap<IBinder, ITimeZoneDetectorListener> r0 = this.mListeners;
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

    void handleChangeOnHandlerThread() {
        ArrayMap<IBinder, ITimeZoneDetectorListener> r0 = this.mListeners;
        monitor-enter(r0);
        int listenerCount = this.mListeners.size();     // Catch: Throwable -> L9
        int listenerIndex = 0;
    L5:
        if (listenerIndex >= listenerCount) goto L15;
        ITimeZoneDetectorListener listener = this.mListeners.valueAt(listenerIndex);     // Catch: Throwable -> L9
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

    void handleLocationAlgorithmEvent(final LocationAlgorithmEvent locationAlgorithmEvent) {
        enforceSuggestGeolocationTimeZonePermission();
        locationAlgorithmEvent.getClass();
        this.mHandler.post(new TimeZoneDetectorService$$ExternalSyntheticLambda1(this, locationAlgorithmEvent));
    }

    private /* synthetic */ void lambda$handleLocationAlgorithmEvent$1(LocationAlgorithmEvent locationAlgorithmEvent) {
        this.mTimeZoneDetectorStrategy.handleLocationAlgorithmEvent(locationAlgorithmEvent);
    }

    public TimeZoneState getTimeZoneState() {
        enforceManageTimeZoneDetectorPermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        TimeZoneState r2 = this.mTimeZoneDetectorStrategy.getTimeZoneState();     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    void setTimeZoneState(TimeZoneState timeZoneState) {
        enforceManageTimeZoneDetectorPermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        this.mTimeZoneDetectorStrategy.setTimeZoneState(timeZoneState);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public boolean confirmTimeZone(String timeZoneId) {
        enforceManageTimeZoneDetectorPermission();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r2 = this.mTimeZoneDetectorStrategy.confirmTimeZone(timeZoneId);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setManualTimeZone(ManualTimeZoneSuggestion suggestion) {
        enforceManageTimeZoneDetectorPermission();
        int userId = this.mCallerIdentityInjector.getCallingUserId();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r4 = this.mTimeZoneDetectorStrategy.suggestManualTimeZone(userId, suggestion, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r4;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public boolean suggestManualTimeZone(ManualTimeZoneSuggestion suggestion) {
        enforceSuggestManualTimeZonePermission();
        suggestion.getClass();
        int userId = this.mCallerIdentityInjector.getCallingUserId();
        long token = this.mCallerIdentityInjector.clearCallingIdentity();
        boolean r4 = this.mTimeZoneDetectorStrategy.suggestManualTimeZone(userId, suggestion, false);     // Catch: Throwable -> L6
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        return r4;
    L6:
        th = move-exception;
        this.mCallerIdentityInjector.restoreCallingIdentity(token);
        throw th;
    }

    public void suggestTelephonyTimeZone(final TelephonyTimeZoneSuggestion suggestion) {
        enforceSuggestTelephonyTimeZonePermission();
        suggestion.getClass();
        this.mHandler.post(new TimeZoneDetectorService$$ExternalSyntheticLambda2(this, suggestion));
    }

    private /* synthetic */ void lambda$suggestTelephonyTimeZone$2(TelephonyTimeZoneSuggestion suggestion) {
        this.mTimeZoneDetectorStrategy.suggestTelephonyTimeZone(suggestion);
    }

    boolean isTelephonyTimeZoneDetectionSupported() {
        enforceManageTimeZoneDetectorPermission();
        return this.mTimeZoneDetectorStrategy.isTelephonyTimeZoneDetectionSupported();
    }

    boolean isGeoTimeZoneDetectionSupported() {
        enforceManageTimeZoneDetectorPermission();
        return this.mTimeZoneDetectorStrategy.isGeoTimeZoneDetectionSupported();
    }

    void enableTelephonyFallback(String reason) {
        enforceManageTimeZoneDetectorPermission();
        this.mTimeZoneDetectorStrategy.enableTelephonyTimeZoneFallback(reason);
    }

    void addDumpable(Dumpable dumpable) {
        List<Dumpable> r0 = this.mDumpables;
        monitor-enter(r0);
        this.mDumpables.add(dumpable);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    MetricsTimeZoneDetectorState generateMetricsState() {
        enforceManageTimeZoneDetectorPermission();
        return this.mTimeZoneDetectorStrategy.generateMetricsState();
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        this.mTimeZoneDetectorStrategy.dump(ipw, args);
        List<Dumpable> r1 = this.mDumpables;
        monitor-enter(r1);
        Iterator<Dumpable> r2 = this.mDumpables.iterator();     // Catch: Throwable -> L11
    L9:
        if (r2.hasNext() == false) goto L13;
        Dumpable dumpable = r2.next();     // Catch: Throwable -> L11
        dumpable.dump(ipw, args);     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        ipw.flush();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new TimeZoneDetectorShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    private void enforceManageTimeZoneDetectorPermission() {
        this.mContext.enforceCallingPermission("android.permission.MANAGE_TIME_AND_ZONE_DETECTION", "manage time and time zone detection");
    }

    private void enforceSuggestGeolocationTimeZonePermission() {
        this.mContext.enforceCallingPermission("android.permission.SET_TIME_ZONE", "suggest geolocation time zone");
    }

    private void enforceSuggestTelephonyTimeZonePermission() {
        this.mContext.enforceCallingPermission("android.permission.SUGGEST_TELEPHONY_TIME_AND_ZONE", "suggest telephony time and time zone");
    }

    private void enforceSuggestManualTimeZonePermission() {
        this.mContext.enforceCallingPermission("android.permission.SUGGEST_MANUAL_TIME_AND_ZONE", "suggest manual time and time zone");
    }
}
