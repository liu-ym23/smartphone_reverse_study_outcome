package com.android.server.timedetector;

import android.app.time.ExternalTimeSuggestion;
import android.app.time.TimeCapabilities;
import android.app.time.TimeCapabilitiesAndConfig;
import android.app.time.TimeConfiguration;
import android.app.time.TimeState;
import android.app.time.UnixEpochTime;
import android.app.timedetector.ManualTimeSuggestion;
import android.app.timedetector.TelephonyTimeSuggestion;
import android.content.Context;
import android.os.Handler;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.os.ApplicationSharedMemory;
import com.android.server.SystemClockTime;
import com.android.server.timezonedetector.ArrayMapWithHistory;
import com.android.server.timezonedetector.ReferenceWithHistory;
import com.android.server.timezonedetector.StateChangeListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeDetectorStrategyImpl implements TimeDetectorStrategy {
    private static final boolean DBG = false;
    private static final int KEEP_SUGGESTION_HISTORY_SIZE = 10;
    private static final String LOG_TAG = "time_detector";
    static final long MAX_SUGGESTION_TIME_AGE_MILLIS = 86400000;
    private static final long SYSTEM_CLOCK_PARANOIA_THRESHOLD_MILLIS = 2000;
    private static final int TELEPHONY_BUCKET_COUNT = 24;
    static final int TELEPHONY_BUCKET_SIZE_MILLIS = 3600000;
    private static final int TELEPHONY_INVALID_SCORE = -1;
    private ConfigurationInternal mCurrentConfigurationInternal;
    private final Environment mEnvironment;
    private UnixEpochTime mLastAutoSystemClockTimeSet;
    private final ReferenceWithHistory<ExternalTimeSuggestion> mLastExternalSuggestion;
    private final ReferenceWithHistory<GnssTimeSuggestion> mLastGnssSuggestion;
    private final ReferenceWithHistory<NetworkTimeSuggestion> mLastNetworkSuggestion;
    private final ArraySet<StateChangeListener> mNetworkTimeUpdateListeners;
    private final ServiceConfigAccessor mServiceConfigAccessor;
    private final List<StateChangeListener> mStateChangeListeners;
    private final ArrayMapWithHistory<Integer, TelephonyTimeSuggestion> mSuggestionBySlotIndex;

    public interface Environment {
        void acquireWakeLock();

        void addDebugLogEntry(String r1);

        void dumpDebugLog(IndentingPrintWriter r1);

        long elapsedRealtimeMillis();

        void releaseWakeLock();

        void runAsync(Runnable r1);

        void setSystemClock(long r1, int r3, String r4);

        void setSystemClockConfidence(int r1, String r2);

        int systemClockConfidence();

        long systemClockMillis();
    }

    public static /* synthetic */ void $r8$lambda$Ev1hBuSMiy0SsdTUkkpw6YwrYmA(TimeDetectorStrategyImpl r0) {
        r0.handleConfigurationInternalMaybeChanged();
    }

    static TimeDetectorStrategy create(Context context, Handler handler, ServiceConfigAccessor serviceConfigAccessor) {
        Environment environment = new EnvironmentImpl(context, handler);
        return new TimeDetectorStrategyImpl(environment, serviceConfigAccessor);
    }

    TimeDetectorStrategyImpl(Environment environment, ServiceConfigAccessor serviceConfigAccessor) {
        this.mStateChangeListeners = new ArrayList();
        this.mSuggestionBySlotIndex = new ArrayMapWithHistory(10);
        this.mLastNetworkSuggestion = new ReferenceWithHistory(10);
        this.mLastGnssSuggestion = new ReferenceWithHistory(10);
        this.mLastExternalSuggestion = new ReferenceWithHistory(10);
        this.mNetworkTimeUpdateListeners = new ArraySet();
        environment.getClass();
        this.mEnvironment = environment;
        serviceConfigAccessor.getClass();
        this.mServiceConfigAccessor = serviceConfigAccessor;
        monitor-enter(this);
        StateChangeListener stateChangeListener = new TimeDetectorStrategyImpl$$ExternalSyntheticLambda1(this);     // Catch: Throwable -> L7
        this.mServiceConfigAccessor.addConfigurationInternalChangeListener(stateChangeListener);     // Catch: Throwable -> L7
        updateCurrentConfigurationInternalIfRequired("TimeDetectorStrategyImpl:");     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void suggestExternalTime(ExternalTimeSuggestion suggestion) {
        monitor-enter(this);
        ConfigurationInternal r0 = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L10
        suggestion.getClass();     // Catch: Throwable -> L10
        UnixEpochTime newUnixEpochTime = suggestion.getUnixEpochTime();     // Catch: Throwable -> L10
        if (validateAutoSuggestionTime(newUnixEpochTime, suggestion) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mLastExternalSuggestion.set(suggestion);     // Catch: Throwable -> L10
        String reason = "External time suggestion received: suggestion=" + suggestion;     // Catch: Throwable -> L10
        doAutoTimeDetection(reason);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void suggestGnssTime(GnssTimeSuggestion suggestion) {
        monitor-enter(this);
        ConfigurationInternal r0 = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L10
        suggestion.getClass();     // Catch: Throwable -> L10
        UnixEpochTime newUnixEpochTime = suggestion.getUnixEpochTime();     // Catch: Throwable -> L10
        if (validateAutoSuggestionTime(newUnixEpochTime, suggestion) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mLastGnssSuggestion.set(suggestion);     // Catch: Throwable -> L10
        String reason = "GNSS time suggestion received: suggestion=" + suggestion;     // Catch: Throwable -> L10
        doAutoTimeDetection(reason);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized boolean suggestManualTime(int userId, ManualTimeSuggestion suggestion, boolean bypassUserPolicyChecks) {
        monitor-enter(this);
        ConfigurationInternal currentUserConfig = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L8
        if (currentUserConfig.getUserId() == userId) goto L10;
        Slog.w(LOG_TAG, "Manual suggestion received but user != current user, userId=" + userId + " suggestion=" + suggestion);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L10:
        suggestion.getClass();     // Catch: Throwable -> L8
        String cause = "Manual time suggestion received: suggestion=" + suggestion;     // Catch: Throwable -> L8
        TimeCapabilitiesAndConfig capabilitiesAndConfig = currentUserConfig.createCapabilitiesAndConfig(bypassUserPolicyChecks);     // Catch: Throwable -> L8
        TimeCapabilities capabilities = capabilitiesAndConfig.getCapabilities();     // Catch: Throwable -> L8
        if (capabilities.getSetManualTimeCapability() == 40) goto L15;
        Slog.i(LOG_TAG, "User does not have the capability needed to set the time manually: capabilities=" + capabilities + ", suggestion=" + suggestion + ", cause=" + cause);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L15:
        UnixEpochTime newUnixEpochTime = suggestion.getUnixEpochTime();     // Catch: Throwable -> L8
        if (validateManualSuggestionTime(newUnixEpochTime, suggestion) == true) goto L20;
        monitor-exit(this);
        return false;
    L20:
        boolean r2 = setSystemClockAndConfidenceIfRequired(2, newUnixEpochTime, cause);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void suggestNetworkTime(NetworkTimeSuggestion suggestion) {
        monitor-enter(this);
        ConfigurationInternal r0 = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L12
        suggestion.getClass();     // Catch: Throwable -> L12
        if (validateAutoSuggestionTime(suggestion.getUnixEpochTime(), suggestion) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        NetworkTimeSuggestion lastNetworkSuggestion = this.mLastNetworkSuggestion.get();     // Catch: Throwable -> L12
        if (lastNetworkSuggestion != null) goto L10;
    L14:
        UnixEpochTime networkUnixEpochTime = suggestion.getUnixEpochTime();     // Catch: Throwable -> L12
        long lastNetworkTimeUnixEpochMillisAtZeroElapsedRealtimeMillis = networkUnixEpochTime.getUnixEpochTimeMillis() - networkUnixEpochTime.getElapsedRealtimeMillis();     // Catch: Throwable -> L12
        ApplicationSharedMemory.getInstance().setLatestNetworkTimeUnixEpochMillisAtZeroElapsedRealtimeMillis(lastNetworkTimeUnixEpochMillisAtZeroElapsedRealtimeMillis);     // Catch: Throwable -> L12
        this.mLastNetworkSuggestion.set(suggestion);     // Catch: Throwable -> L12
        notifyNetworkTimeUpdateListenersAsynchronously();     // Catch: Throwable -> L12
    L15:
        String reason = "New network time suggested. suggestion=" + suggestion;     // Catch: Throwable -> L12
        doAutoTimeDetection(reason);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L10:
        if (lastNetworkSuggestion.equals(suggestion) == true) goto L15;
    L12:
        th = move-exception;
        throw th;
    }

    private void notifyNetworkTimeUpdateListenersAsynchronously() {
        Iterator<StateChangeListener> r0 = this.mNetworkTimeUpdateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        StateChangeListener listener = r0.next();
        Environment r2 = this.mEnvironment;
        listener.getClass();
        r2.runAsync(new TimeDetectorStrategyImpl$$ExternalSyntheticLambda0(listener));
        goto L4
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void addNetworkTimeUpdateListener(StateChangeListener networkSuggestionUpdateListener) {
        monitor-enter(this);
        this.mNetworkTimeUpdateListeners.add(networkSuggestionUpdateListener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized NetworkTimeSuggestion getLatestNetworkSuggestion() {
        monitor-enter(this);
        NetworkTimeSuggestion r0 = this.mLastNetworkSuggestion.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void clearLatestNetworkSuggestion() {
        monitor-enter(this);
        ApplicationSharedMemory.getInstance().clearLatestNetworkTimeUnixEpochMillisAtZeroElapsedRealtimeMillis();     // Catch: Throwable -> L6
        this.mLastNetworkSuggestion.set(null);     // Catch: Throwable -> L6
        notifyNetworkTimeUpdateListenersAsynchronously();     // Catch: Throwable -> L6
        doAutoTimeDetection("Network time cleared");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized TimeState getTimeState() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnvironment.systemClockConfidence() >= 100) goto L6;
        boolean userShouldConfirmTime = true;
    L7:
        UnixEpochTime unixEpochTime = new UnixEpochTime(this.mEnvironment.elapsedRealtimeMillis(), this.mEnvironment.systemClockMillis());     // Catch: Throwable -> L10
        TimeState r2 = new TimeState(unixEpochTime, userShouldConfirmTime);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    L6:
        userShouldConfirmTime = false;
        goto L7
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void setTimeState(TimeState timeState) {
        monitor-enter(this);
        timeState.getClass();     // Catch: Throwable -> L13
        if (timeState.getUserShouldConfirmTime() == false) goto L6;
        int confidence = 0;
    L7:
        this.mEnvironment.acquireWakeLock();     // Catch: Throwable -> L13
        UnixEpochTime unixEpochTime = timeState.getUnixEpochTime();     // Catch: Throwable -> L15
        setSystemClockAndConfidenceUnderWakeLock(2, unixEpochTime, confidence, "setTimeState()");     // Catch: Throwable -> L15
        this.mEnvironment.releaseWakeLock();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        this.mEnvironment.releaseWakeLock();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L6:
        confidence = 100;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized boolean confirmTime(UnixEpochTime confirmationTime) {
        monitor-enter(this);
        confirmationTime.getClass();     // Catch: Throwable -> L30
        this.mEnvironment.acquireWakeLock();     // Catch: Throwable -> L30
        long currentElapsedRealtimeMillis = this.mEnvironment.elapsedRealtimeMillis();     // Catch: Throwable -> L26
        long currentSystemClockMillis = this.mEnvironment.systemClockMillis();     // Catch: Throwable -> L26
        TimeDetectorStrategyImpl r2 = this;
        boolean timeConfirmed = r2.isTimeWithinConfidenceThreshold(confirmationTime, currentElapsedRealtimeMillis, currentSystemClockMillis);     // Catch: Throwable -> L24
        if (timeConfirmed == true) goto L36;
    L19:
        r2.mEnvironment.releaseWakeLock();     // Catch: Throwable -> L22
        monitor-exit(this);
        return timeConfirmed;
    L36:
        int currentTimeConfidence = r2.mEnvironment.systemClockConfidence();     // Catch: Throwable -> L16
        if (currentTimeConfidence >= 100) goto L12;
        boolean confidenceUpgradeRequired = true;
    L13:
        if (confidenceUpgradeRequired == false) goto L19;
        String logMsg = "Confirm system clock time. confirmationTime=" + confirmationTime + " newTimeConfidence=100 currentElapsedRealtimeMillis=" + currentElapsedRealtimeMillis + " currentSystemClockMillis=" + currentSystemClockMillis + " (old) currentTimeConfidence=" + currentTimeConfidence;     // Catch: Throwable -> L16
        r2.mEnvironment.setSystemClockConfidence(100, logMsg);     // Catch: Throwable -> L16
        goto L19
    L12:
        confidenceUpgradeRequired = false;
    L16:
        th = move-exception;
        Throwable r12 = th;
    L28:
        r2.mEnvironment.releaseWakeLock();     // Catch: Throwable -> L22
        throw r12;     // Catch: Throwable -> L22
    L24:
        th = move-exception;
        r12 = th;
    L26:
        th = move-exception;
        r2 = this;
        r12 = th;
    L22:
        th = th;
    L23:
        Throwable r13 = th;
        monitor-exit(this);     // Catch: Throwable -> L22
        throw r13;
    L30:
        th = th;
        goto L23
    }

    private void notifyStateChangeListenersAsynchronously() {
        Iterator<StateChangeListener> r0 = this.mStateChangeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        StateChangeListener listener = r0.next();
        Environment r2 = this.mEnvironment;
        listener.getClass();
        r2.runAsync(new TimeDetectorStrategyImpl$$ExternalSyntheticLambda0(listener));
        goto L4
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void addChangeListener(StateChangeListener listener) {
        monitor-enter(this);
        this.mStateChangeListeners.add(listener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized TimeCapabilitiesAndConfig getCapabilitiesAndConfig(int userId, boolean bypassUserPolicyChecks) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mCurrentConfigurationInternal.getUserId() != userId) goto L8;
        ConfigurationInternal configurationInternal = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L6
    L9:
        TimeCapabilitiesAndConfig r1 = configurationInternal.createCapabilitiesAndConfig(bypassUserPolicyChecks);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L8:
        configurationInternal = this.mServiceConfigAccessor.getConfigurationInternal(userId);     // Catch: Throwable -> L6
        goto L9
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized boolean updateConfiguration(int userId, TimeConfiguration configuration, boolean bypassUserPolicyChecks) {
        monitor-enter(this);
        boolean updateSuccessful = this.mServiceConfigAccessor.updateConfiguration(userId, configuration, bypassUserPolicyChecks);     // Catch: Throwable -> L7
        if (updateSuccessful == false) goto L9;
        String logMsg = "updateConfiguration: userId=" + userId + ", configuration=" + configuration + ", bypassUserPolicyChecks=" + bypassUserPolicyChecks;     // Catch: Throwable -> L7
        updateCurrentConfigurationInternalIfRequired(logMsg);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return updateSuccessful;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timedetector.TimeDetectorStrategy
    public synchronized void suggestTelephonyTime(TelephonyTimeSuggestion suggestion) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (suggestion.getUnixEpochTime() != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (validateAutoSuggestionTime(suggestion.getUnixEpochTime(), suggestion) == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (storeTelephonySuggestion(suggestion) == true) goto L15;
        monitor-exit(this);
        return;
    L15:
        String reason = "New telephony time suggested. suggestion=" + suggestion;     // Catch: Throwable -> L18
        doAutoTimeDetection(reason);     // Catch: Throwable -> L18
        monitor-exit(this);
    }

    private synchronized void handleConfigurationInternalMaybeChanged() {
        monitor-enter(this);
        updateCurrentConfigurationInternalIfRequired("handleConfigurationInternalMaybeChanged:");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void updateCurrentConfigurationInternalIfRequired(String logMsg) {
        ConfigurationInternal newCurrentConfigurationInternal = this.mServiceConfigAccessor.getCurrentUserConfigurationInternal();
        ConfigurationInternal oldCurrentConfigurationInternal = this.mCurrentConfigurationInternal;
        if (newCurrentConfigurationInternal.equals(oldCurrentConfigurationInternal) == true) goto L9;
        this.mCurrentConfigurationInternal = newCurrentConfigurationInternal;
        addDebugLogEntry(logMsg + " [oldConfiguration=" + oldCurrentConfigurationInternal + ", newConfiguration=" + newCurrentConfigurationInternal + "]");
        notifyStateChangeListenersAsynchronously();
        boolean autoDetectionEnabled = this.mCurrentConfigurationInternal.getAutoDetectionEnabledBehavior();
        if (autoDetectionEnabled == false) goto L7;
        doAutoTimeDetection("Auto time detection config changed.");
        return;
    L7:
        this.mLastAutoSystemClockTimeSet = null;
        return;
    }

    private void addDebugLogEntry(String logMsg) {
        this.mEnvironment.addDebugLogEntry(logMsg);
    }

    @Override // com.android.server.timezonedetector.Dumpable
    public synchronized void dump(IndentingPrintWriter ipw, String[] args) {
        monitor-enter(this);
        ipw.println("TimeDetectorStrategy:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        ipw.println("mLastAutoSystemClockTimeSet=" + this.mLastAutoSystemClockTimeSet);     // Catch: Throwable -> L6
        ipw.println("mCurrentConfigurationInternal=" + this.mCurrentConfigurationInternal);     // Catch: Throwable -> L6
        ipw.println("[Capabilities=" + this.mCurrentConfigurationInternal.createCapabilitiesAndConfig(false) + "]");     // Catch: Throwable -> L6
        ipw.println("mEnvironment:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mEnvironment.dumpDebugLog(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Time change log:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        SystemClockTime.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Telephony suggestion history:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mSuggestionBySlotIndex.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Network suggestion history:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mLastNetworkSuggestion.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Gnss suggestion history:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mLastGnssSuggestion.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("External suggestion history:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mLastExternalSuggestion.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ConfigurationInternal getCachedCapabilitiesAndConfigForTests() {
        monitor-enter(this);
        ConfigurationInternal r0 = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean storeTelephonySuggestion(TelephonyTimeSuggestion suggestion) {
        UnixEpochTime newUnixEpochTime = suggestion.getUnixEpochTime();
        int slotIndex = suggestion.getSlotIndex();
        TelephonyTimeSuggestion previousSuggestion = this.mSuggestionBySlotIndex.get(Integer.valueOf(slotIndex));
        if (previousSuggestion != null) goto L5;
    L12:
        this.mSuggestionBySlotIndex.put(Integer.valueOf(slotIndex), suggestion);
        return true;
    L5:
        if (previousSuggestion.getUnixEpochTime() != null) goto L8;
        Slog.w(LOG_TAG, "Previous suggestion is null or has a null time. previousSuggestion=" + previousSuggestion + ", suggestion=" + suggestion);
        return false;
    L8:
        long referenceTimeDifference = UnixEpochTime.elapsedRealtimeDifference(newUnixEpochTime, previousSuggestion.getUnixEpochTime());
        if (referenceTimeDifference >= 0) goto L12;
        Slog.w(LOG_TAG, "Out of order telephony suggestion received. referenceTimeDifference=" + referenceTimeDifference + " previousSuggestion=" + previousSuggestion + " suggestion=" + suggestion);
        return false;
    }

    private boolean validateSuggestionCommon(UnixEpochTime newUnixEpochTime, Object suggestion) {
        long elapsedRealtimeMillis = this.mEnvironment.elapsedRealtimeMillis();
        if (elapsedRealtimeMillis >= newUnixEpochTime.getElapsedRealtimeMillis()) goto L7;
        Slog.w(LOG_TAG, "New elapsed realtime is in the future? Ignoring. elapsedRealtimeMillis=" + elapsedRealtimeMillis + ", suggestion=" + suggestion);
        return false;
    L7:
        if (newUnixEpochTime.getUnixEpochTimeMillis() <= this.mCurrentConfigurationInternal.getSuggestionUpperBound().toEpochMilli()) goto L10;
        Slog.w(LOG_TAG, "Suggested value is above max time supported by this device. suggestion=" + suggestion);
        return false;
    L10:
        return true;
    }

    private boolean validateAutoSuggestionTime(UnixEpochTime newUnixEpochTime, Object suggestion) {
        Instant lowerBound = this.mCurrentConfigurationInternal.getAutoSuggestionLowerBound();
        if (validateSuggestionCommon(newUnixEpochTime, suggestion) == true) goto L5;
    L7:
        return false;
    L5:
        if (validateSuggestionAgainstLowerBound(newUnixEpochTime, suggestion, lowerBound) == false) goto L7;
        return true;
    }

    private boolean validateManualSuggestionTime(UnixEpochTime newUnixEpochTime, Object suggestion) {
        Instant lowerBound = this.mCurrentConfigurationInternal.getManualSuggestionLowerBound();
        if (validateSuggestionCommon(newUnixEpochTime, suggestion) == true) goto L5;
    L7:
        return false;
    L5:
        if (validateSuggestionAgainstLowerBound(newUnixEpochTime, suggestion, lowerBound) == false) goto L7;
        return true;
    }

    private boolean validateSuggestionAgainstLowerBound(UnixEpochTime newUnixEpochTime, Object suggestion, Instant lowerBound) {
        if (lowerBound.toEpochMilli() <= newUnixEpochTime.getUnixEpochTimeMillis()) goto L6;
        Slog.w(LOG_TAG, "Suggestion points to time before lower bound, skipping it. suggestion=" + suggestion + ", lower bound=" + lowerBound);
        return false;
    L6:
        return true;
    }

    private void doAutoTimeDetection(String detectionReason) {
        int[] originPriorities = this.mCurrentConfigurationInternal.getAutoOriginPriorities();
        int r1 = originPriorities.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L36;
        int origin = originPriorities[r2];
        UnixEpochTime newUnixEpochTime = null;
        String cause = null;
        if (origin != 1) goto L11;
        TelephonyTimeSuggestion bestTelephonySuggestion = findBestTelephonySuggestion();
        if (bestTelephonySuggestion == null) goto L29;
        newUnixEpochTime = bestTelephonySuggestion.getUnixEpochTime();
        cause = "Found good telephony suggestion., bestTelephonySuggestion=" + bestTelephonySuggestion + ", detectionReason=" + detectionReason;
    L29:
        if (newUnixEpochTime != null) goto L31;
        r2 = r2 + 1;
        goto L3
    L31:
        if (this.mCurrentConfigurationInternal.getAutoDetectionEnabledBehavior() == false) goto L33;
        setSystemClockAndConfidenceIfRequired(origin, newUnixEpochTime, cause);
        return;
    L33:
        upgradeSystemClockConfidenceIfRequired(newUnixEpochTime, cause);
        return;
    L11:
        if (origin != 3) goto L17;
        NetworkTimeSuggestion networkSuggestion = findLatestValidNetworkSuggestion();
        if (networkSuggestion == null) goto L29;
        newUnixEpochTime = networkSuggestion.getUnixEpochTime();
        cause = "Found good network suggestion., networkSuggestion=" + networkSuggestion + ", detectionReason=" + detectionReason;
        goto L29
    L17:
        if (origin != 4) goto L23;
        GnssTimeSuggestion gnssSuggestion = findLatestValidGnssSuggestion();
        if (gnssSuggestion == null) goto L29;
        newUnixEpochTime = gnssSuggestion.getUnixEpochTime();
        cause = "Found good gnss suggestion., gnssSuggestion=" + gnssSuggestion + ", detectionReason=" + detectionReason;
        goto L29
    L23:
        if (origin != 5) goto L28;
        ExternalTimeSuggestion externalSuggestion = findLatestValidExternalSuggestion();
        if (externalSuggestion == null) goto L29;
        newUnixEpochTime = externalSuggestion.getUnixEpochTime();
        cause = "Found good external suggestion., externalSuggestion=" + externalSuggestion + ", detectionReason=" + detectionReason;
        goto L29
    L28:
        Slog.w(LOG_TAG, "Unknown or unsupported origin=" + origin + " in " + Arrays.toString(originPriorities) + ": Skipping");
        goto L29
    }

    private TelephonyTimeSuggestion findBestTelephonySuggestion() {
        long elapsedRealtimeMillis = this.mEnvironment.elapsedRealtimeMillis();
        TelephonyTimeSuggestion bestSuggestion = null;
        int bestScore = -1;
        int i = 0;
    L4:
        if (i >= this.mSuggestionBySlotIndex.size()) goto L24;
        Integer slotIndex = this.mSuggestionBySlotIndex.keyAt(i);
        TelephonyTimeSuggestion candidateSuggestion = this.mSuggestionBySlotIndex.valueAt(i);
        if (candidateSuggestion != null) goto L9;
        Slog.w(LOG_TAG, "Latest suggestion unexpectedly null for slotIndex. slotIndex=" + slotIndex);
    L22:
        i = i + 1;
        goto L4
    L9:
        if (candidateSuggestion.getUnixEpochTime() != null) goto L11;
        Slog.w(LOG_TAG, "Latest suggestion unexpectedly empty.  candidateSuggestion=" + candidateSuggestion);
        goto L22
    L11:
        int candidateScore = scoreTelephonySuggestion(elapsedRealtimeMillis, candidateSuggestion);
        if (candidateScore == (-1)) goto L22;
        if (bestSuggestion == null) goto L21;
        if (bestScore < candidateScore) goto L21;
        if (bestScore != candidateScore) goto L22;
        int candidateSlotIndex = candidateSuggestion.getSlotIndex();
        int bestSlotIndex = bestSuggestion.getSlotIndex();
        if (candidateSlotIndex >= bestSlotIndex) goto L22;
        bestSuggestion = candidateSuggestion;
    L21:
        bestSuggestion = candidateSuggestion;
        bestScore = candidateScore;
        goto L22
    L24:
        return bestSuggestion;
    }

    private static int scoreTelephonySuggestion(long elapsedRealtimeMillis, TelephonyTimeSuggestion suggestion) {
        UnixEpochTime unixEpochTime = suggestion.getUnixEpochTime();
        if (validateSuggestionUnixEpochTime(elapsedRealtimeMillis, unixEpochTime) == true) goto L6;
        Slog.w(LOG_TAG, "Existing suggestion found to be invalid elapsedRealtimeMillis=" + elapsedRealtimeMillis + ", suggestion=" + suggestion);
        return -1;
    L6:
        long ageMillis = elapsedRealtimeMillis - unixEpochTime.getElapsedRealtimeMillis();
        int bucketIndex = (int) (ageMillis / 3600000);
        if (bucketIndex < 24) goto L10;
        return -1;
    L10:
        return 24 - bucketIndex;
    }

    private NetworkTimeSuggestion findLatestValidNetworkSuggestion() {
        NetworkTimeSuggestion networkSuggestion = this.mLastNetworkSuggestion.get();
        if (networkSuggestion != null) goto L5;
        return null;
    L5:
        UnixEpochTime unixEpochTime = networkSuggestion.getUnixEpochTime();
        long elapsedRealTimeMillis = this.mEnvironment.elapsedRealtimeMillis();
        if (validateSuggestionUnixEpochTime(elapsedRealTimeMillis, unixEpochTime) == true) goto L8;
        return null;
    L8:
        return networkSuggestion;
    }

    private GnssTimeSuggestion findLatestValidGnssSuggestion() {
        GnssTimeSuggestion gnssTimeSuggestion = this.mLastGnssSuggestion.get();
        if (gnssTimeSuggestion != null) goto L5;
        return null;
    L5:
        UnixEpochTime unixEpochTime = gnssTimeSuggestion.getUnixEpochTime();
        long elapsedRealTimeMillis = this.mEnvironment.elapsedRealtimeMillis();
        if (validateSuggestionUnixEpochTime(elapsedRealTimeMillis, unixEpochTime) == true) goto L8;
        return null;
    L8:
        return gnssTimeSuggestion;
    }

    private ExternalTimeSuggestion findLatestValidExternalSuggestion() {
        ExternalTimeSuggestion externalTimeSuggestion = this.mLastExternalSuggestion.get();
        if (externalTimeSuggestion != null) goto L5;
        return null;
    L5:
        UnixEpochTime unixEpochTime = externalTimeSuggestion.getUnixEpochTime();
        long elapsedRealTimeMillis = this.mEnvironment.elapsedRealtimeMillis();
        if (validateSuggestionUnixEpochTime(elapsedRealTimeMillis, unixEpochTime) == true) goto L8;
        return null;
    L8:
        return externalTimeSuggestion;
    }

    private boolean setSystemClockAndConfidenceIfRequired(int origin, UnixEpochTime time, String cause) {
        boolean isOriginAutomatic = isOriginAutomatic(origin);
        if (isOriginAutomatic == false) goto L8;
        if (this.mCurrentConfigurationInternal.getAutoDetectionEnabledBehavior() == true) goto L10;
        return false;
    L10:
        this.mEnvironment.acquireWakeLock();
        boolean r2 = setSystemClockAndConfidenceUnderWakeLock(origin, time, 100, cause);     // Catch: Throwable -> L14
        this.mEnvironment.releaseWakeLock();
        return r2;
    L14:
        th = move-exception;
        this.mEnvironment.releaseWakeLock();
        throw th;
    L8:
        if (this.mCurrentConfigurationInternal.getAutoDetectionEnabledBehavior() == false) goto L10;
        return false;
    }

    private void upgradeSystemClockConfidenceIfRequired(UnixEpochTime autoDetectedUnixEpochTime, String cause) {
        int currentTimeConfidence = this.mEnvironment.systemClockConfidence();
        if (currentTimeConfidence >= 100) goto L5;
        boolean r0 = true;
    L6:
        boolean confidenceUpgradeRequired = r0;
        if (confidenceUpgradeRequired == true) goto L9;
        return;
    L9:
        this.mEnvironment.acquireWakeLock();
        long currentElapsedRealtimeMillis = this.mEnvironment.elapsedRealtimeMillis();     // Catch: Throwable -> L20
        long currentSystemClockMillis = this.mEnvironment.systemClockMillis();     // Catch: Throwable -> L20
        TimeDetectorStrategyImpl r6 = this;
        boolean updateConfidenceRequired = r6.isTimeWithinConfidenceThreshold(autoDetectedUnixEpochTime, currentElapsedRealtimeMillis, currentSystemClockMillis);     // Catch: Throwable -> L16
        if (updateConfidenceRequired == false) goto L18;
        String logMsg = "Upgrade system clock confidence. autoDetectedUnixEpochTime=" + autoDetectedUnixEpochTime + " newTimeConfidence=100 cause=" + cause + " currentElapsedRealtimeMillis=" + currentElapsedRealtimeMillis + " currentSystemClockMillis=" + currentSystemClockMillis + " currentTimeConfidence=" + currentTimeConfidence;     // Catch: Throwable -> L16
        r6.mEnvironment.setSystemClockConfidence(100, logMsg);     // Catch: Throwable -> L16
    L18:
        r6.mEnvironment.releaseWakeLock();
        return;
    L16:
        th = move-exception;
        Throwable r13 = th;
    L22:
        r6.mEnvironment.releaseWakeLock();
        throw r13;
    L20:
        th = move-exception;
        r6 = this;
        r13 = th;
        goto L22
    L5:
        r0 = false;
        goto L6
    }

    private static boolean isOriginAutomatic(int origin) {
        if (origin == 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isTimeWithinConfidenceThreshold(UnixEpochTime timeToCheck, long currentElapsedRealtimeMillis, long currentSystemClockMillis) {
        long adjustedAutoDetectedUnixEpochMillis = timeToCheck.at(currentElapsedRealtimeMillis).getUnixEpochTimeMillis();
        long absTimeDifferenceMillis = Math.abs(adjustedAutoDetectedUnixEpochMillis - currentSystemClockMillis);
        int confidenceUpgradeThresholdMillis = this.mCurrentConfigurationInternal.getSystemClockConfidenceThresholdMillis();
        if (absTimeDifferenceMillis > confidenceUpgradeThresholdMillis) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean setSystemClockAndConfidenceUnderWakeLock(int origin, UnixEpochTime newTime, int newTimeConfidence, String cause) {
        long elapsedRealtimeMillis = this.mEnvironment.elapsedRealtimeMillis();
        boolean isOriginAutomatic = isOriginAutomatic(origin);
        long actualSystemClockMillis = this.mEnvironment.systemClockMillis();
        if (isOriginAutomatic == false) goto L12;
        if (this.mLastAutoSystemClockTimeSet == null) goto L12;
        long expectedTimeMillis = this.mLastAutoSystemClockTimeSet.at(elapsedRealtimeMillis).getUnixEpochTimeMillis();
        long absSystemClockDifference = Math.abs(expectedTimeMillis - actualSystemClockMillis);
        if (absSystemClockDifference <= 2000) goto L12;
        Slog.w(LOG_TAG, "System clock has not tracked elapsed real time clock. A clock may be inaccurate or something unexpectedly set the system clock. origin=" + TimeDetectorStrategy.originToString(origin) + " elapsedRealtimeMillis=" + elapsedRealtimeMillis + " expectedTimeMillis=" + expectedTimeMillis + " actualTimeMillis=" + actualSystemClockMillis + " cause=" + cause);
    L12:
        long newSystemClockMillis = newTime.at(elapsedRealtimeMillis).getUnixEpochTimeMillis();
        long absTimeDifference = Math.abs(newSystemClockMillis - actualSystemClockMillis);
        long absTimeDifference2 = this.mCurrentConfigurationInternal.getSystemClockUpdateThresholdMillis();
        if (absTimeDifference < absTimeDifference2) goto L15;
        boolean updateSystemClockRequired = true;
    L16:
        int currentTimeConfidence = this.mEnvironment.systemClockConfidence();
        if (newTimeConfidence == currentTimeConfidence) goto L19;
        boolean updateConfidenceRequired = true;
    L21:
        if (updateSystemClockRequired == false) goto L27;
        String logMsg = "Set system clock & confidence. origin=" + TimeDetectorStrategy.originToString(origin) + " newTime=" + newTime + " newTimeConfidence=" + newTimeConfidence + " cause=" + cause + " elapsedRealtimeMillis=" + elapsedRealtimeMillis + " (old) actualSystemClockMillis=" + actualSystemClockMillis + " newSystemClockMillis=" + newSystemClockMillis + " currentTimeConfidence=" + currentTimeConfidence;
        this.mEnvironment.setSystemClock(newSystemClockMillis, newTimeConfidence, logMsg);
        if (isOriginAutomatic(origin) == false) goto L25;
        this.mLastAutoSystemClockTimeSet = newTime;
    L30:
        return true;
    L25:
        this.mLastAutoSystemClockTimeSet = null;
        goto L30
    L27:
        if (updateConfidenceRequired == false) goto L30;
        String logMsg2 = "Set system clock confidence. origin=" + TimeDetectorStrategy.originToString(origin) + " newTime=" + newTime + " newTimeConfidence=" + newTimeConfidence + " cause=" + cause + " elapsedRealtimeMillis=" + elapsedRealtimeMillis + " (old) actualSystemClockMillis=" + actualSystemClockMillis + " newSystemClockMillis=" + newSystemClockMillis + " currentTimeConfidence=" + currentTimeConfidence;
        this.mEnvironment.setSystemClockConfidence(newTimeConfidence, logMsg2);
        goto L30
    L19:
        updateConfidenceRequired = false;
        goto L21
    L15:
        updateSystemClockRequired = false;
        goto L16
    }

    public synchronized TelephonyTimeSuggestion findBestTelephonySuggestionForTests() {
        monitor-enter(this);
        TelephonyTimeSuggestion r0 = findBestTelephonySuggestion();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized NetworkTimeSuggestion findLatestValidNetworkSuggestionForTests() {
        monitor-enter(this);
        NetworkTimeSuggestion r0 = findLatestValidNetworkSuggestion();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized GnssTimeSuggestion findLatestValidGnssSuggestionForTests() {
        monitor-enter(this);
        GnssTimeSuggestion r0 = findLatestValidGnssSuggestion();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ExternalTimeSuggestion findLatestValidExternalSuggestionForTests() {
        monitor-enter(this);
        ExternalTimeSuggestion r0 = findLatestValidExternalSuggestion();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized TelephonyTimeSuggestion getLatestTelephonySuggestion(int slotIndex) {
        monitor-enter(this);
        TelephonyTimeSuggestion r0 = this.mSuggestionBySlotIndex.get(Integer.valueOf(slotIndex));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized GnssTimeSuggestion getLatestGnssSuggestion() {
        monitor-enter(this);
        GnssTimeSuggestion r0 = this.mLastGnssSuggestion.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ExternalTimeSuggestion getLatestExternalSuggestion() {
        monitor-enter(this);
        ExternalTimeSuggestion r0 = this.mLastExternalSuggestion.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static boolean validateSuggestionUnixEpochTime(long currentElapsedRealtimeMillis, UnixEpochTime unixEpochTime) {
        long suggestionElapsedRealtimeMillis = unixEpochTime.getElapsedRealtimeMillis();
        if (suggestionElapsedRealtimeMillis <= currentElapsedRealtimeMillis) goto L5;
        return false;
    L5:
        long ageMillis = currentElapsedRealtimeMillis - suggestionElapsedRealtimeMillis;
        if (ageMillis > 86400000) goto L9;
        return true;
    L9:
        return false;
    }
}
