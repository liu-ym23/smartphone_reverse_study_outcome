package com.android.server.timezonedetector;

import android.app.time.LocationTimeZoneAlgorithmStatus;
import android.app.time.TelephonyTimeZoneAlgorithmStatus;
import android.app.time.TimeZoneCapabilities;
import android.app.time.TimeZoneCapabilitiesAndConfig;
import android.app.time.TimeZoneConfiguration;
import android.app.time.TimeZoneDetectorStatus;
import android.app.time.TimeZoneState;
import android.app.timezonedetector.ManualTimeZoneSuggestion;
import android.app.timezonedetector.TelephonyTimeZoneSuggestion;
import android.content.Context;
import android.os.Handler;
import android.os.TimestampedValue;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.server.timedetector.TimeDetectorStrategyImpl$$ExternalSyntheticLambda0;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeZoneDetectorStrategyImpl implements TimeZoneDetectorStrategy {
    private static final boolean DBG = false;
    private static final int KEEP_SUGGESTION_HISTORY_SIZE = 10;
    private static final String LOG_TAG = "time_zone_detector";
    public static final int TELEPHONY_SCORE_HIGH = 3;
    public static final int TELEPHONY_SCORE_HIGHEST = 4;
    public static final int TELEPHONY_SCORE_LOW = 1;
    public static final int TELEPHONY_SCORE_MEDIUM = 2;
    public static final int TELEPHONY_SCORE_NONE = 0;
    public static final int TELEPHONY_SCORE_USAGE_THRESHOLD = 2;
    private final TimeZoneChangeListener mChangeTracker;
    private ConfigurationInternal mCurrentConfigurationInternal;
    private TimeZoneDetectorStatus mDetectorStatus;
    private final Environment mEnvironment;
    private final ReferenceWithHistory<LocationAlgorithmEvent> mLatestLocationAlgorithmEvent;
    private final ReferenceWithHistory<ManualTimeZoneSuggestion> mLatestManualSuggestion;
    private final ServiceConfigAccessor mServiceConfigAccessor;
    private final List<StateChangeListener> mStateChangeListeners;
    private final ArrayMapWithHistory<Integer, QualifiedTelephonyTimeZoneSuggestion> mTelephonySuggestionsBySlotIndex;
    private TimestampedValue<Boolean> mTelephonyTimeZoneFallbackEnabled;

    public static final class QualifiedTelephonyTimeZoneSuggestion {
        public final int score;
        public final TelephonyTimeZoneSuggestion suggestion;

        public QualifiedTelephonyTimeZoneSuggestion(TelephonyTimeZoneSuggestion suggestion, int score) {
            this.suggestion = suggestion;
            this.score = score;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L17;
            QualifiedTelephonyTimeZoneSuggestion that = (QualifiedTelephonyTimeZoneSuggestion) o;
            if (this.score != that.score) goto L16;
            if (this.suggestion.equals(that.suggestion) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.score), this.suggestion});
        }

        public String toString() {
            return "QualifiedTelephonyTimeZoneSuggestion{suggestion=" + this.suggestion + ", score=" + this.score + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$hV1MXuLGe7uQyLHj3fxKJrKy5nM(TimeZoneDetectorStrategyImpl r0) {
        r0.handleConfigurationInternalMaybeChanged();
    }

    public static TimeZoneDetectorStrategyImpl create(Context context, Handler handler, ServiceConfigAccessor serviceConfigAccessor) {
        Environment environment = new EnvironmentImpl(handler);
        TimeZoneChangeListener changeEventTracker = NotifyingTimeZoneChangeListener.create(handler, context, serviceConfigAccessor, environment);
        return new TimeZoneDetectorStrategyImpl(serviceConfigAccessor, environment, changeEventTracker);
    }

    public TimeZoneDetectorStrategyImpl(ServiceConfigAccessor serviceConfigAccessor, Environment environment, TimeZoneChangeListener changeEventTracker) {
        this.mTelephonySuggestionsBySlotIndex = new ArrayMapWithHistory(10);
        this.mLatestLocationAlgorithmEvent = new ReferenceWithHistory(10);
        this.mLatestManualSuggestion = new ReferenceWithHistory(10);
        this.mStateChangeListeners = new ArrayList();
        environment.getClass();
        this.mEnvironment = environment;
        serviceConfigAccessor.getClass();
        this.mServiceConfigAccessor = serviceConfigAccessor;
        changeEventTracker.getClass();
        this.mChangeTracker = changeEventTracker;
        this.mTelephonyTimeZoneFallbackEnabled = new TimestampedValue(this.mEnvironment.elapsedRealtimeMillis(), true);
        monitor-enter(this);
        StateChangeListener stateChangeListener = new TimeZoneDetectorStrategyImpl$$ExternalSyntheticLambda0(this);     // Catch: Throwable -> L7
        this.mServiceConfigAccessor.addConfigurationInternalChangeListener(stateChangeListener);     // Catch: Throwable -> L7
        updateCurrentConfigurationInternalIfRequired("TimeZoneDetectorStrategyImpl:");     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized TimeZoneCapabilitiesAndConfig getCapabilitiesAndConfig(int userId, boolean bypassUserPolicyChecks) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mCurrentConfigurationInternal.getUserId() != userId) goto L8;
        ConfigurationInternal configurationInternal = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L6
    L9:
        TimeZoneCapabilitiesAndConfig r1 = new TimeZoneCapabilitiesAndConfig(this.mDetectorStatus, configurationInternal.asCapabilities(bypassUserPolicyChecks), configurationInternal.asConfiguration());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L8:
        configurationInternal = this.mServiceConfigAccessor.getConfigurationInternal(userId);     // Catch: Throwable -> L6
        goto L9
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized boolean updateConfiguration(int userId, TimeZoneConfiguration configuration, boolean bypassUserPolicyChecks) {
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

    private void updateCurrentConfigurationInternalIfRequired(String logMsg) {
        ConfigurationInternal newCurrentConfigurationInternal = this.mServiceConfigAccessor.getCurrentUserConfigurationInternal();
        ConfigurationInternal oldCurrentConfigurationInternal = this.mCurrentConfigurationInternal;
        if (newCurrentConfigurationInternal.equals(oldCurrentConfigurationInternal) == true) goto L6;
        this.mCurrentConfigurationInternal = newCurrentConfigurationInternal;
        String logMsg2 = logMsg + " [oldConfiguration=" + oldCurrentConfigurationInternal + ", newConfiguration=" + newCurrentConfigurationInternal + "]";
        logTimeZoneDebugInfo(logMsg2);
        updateDetectorStatus();
        notifyStateChangeListenersAsynchronously();
        doAutoTimeZoneDetection(this.mCurrentConfigurationInternal, logMsg2);
        return;
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

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized void addChangeListener(StateChangeListener listener) {
        monitor-enter(this);
        this.mStateChangeListeners.add(listener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized boolean confirmTimeZone(String timeZoneId) {
        monitor-enter(this);
        timeZoneId.getClass();     // Catch: Throwable -> L12
        String currentTimeZoneId = this.mEnvironment.getDeviceTimeZone();     // Catch: Throwable -> L12
        if (currentTimeZoneId.equals(timeZoneId) == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.mEnvironment.getDeviceTimeZoneConfidence() >= 100) goto L14;
        this.mEnvironment.setDeviceTimeZoneAndConfidence(currentTimeZoneId, 100, "confirmTimeZone: timeZoneId=" + timeZoneId);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized TimeZoneState getTimeZoneState() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnvironment.getDeviceTimeZoneConfidence() >= 100) goto L6;
        boolean userShouldConfirmId = true;
    L7:
        TimeZoneState r1 = new TimeZoneState(this.mEnvironment.getDeviceTimeZone(), userShouldConfirmId);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L6:
        userShouldConfirmId = false;
        goto L7
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public void setTimeZoneState(TimeZoneState timeZoneState) {
        timeZoneState.getClass();
        if (timeZoneState.getUserShouldConfirmId() == false) goto L5;
        int confidence = 0;
    L6:
        this.mEnvironment.setDeviceTimeZoneAndConfidence(timeZoneState.getId(), confidence, "setTimeZoneState()");
        return;
    L5:
        confidence = 100;
        goto L6
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized void handleLocationAlgorithmEvent(LocationAlgorithmEvent event) {
        monitor-enter(this);
        ConfigurationInternal currentUserConfig = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L6
        event.getClass();     // Catch: Throwable -> L6
        this.mLatestLocationAlgorithmEvent.set(event);     // Catch: Throwable -> L6
        boolean statusChanged = updateDetectorStatus();     // Catch: Throwable -> L6
        if (statusChanged == false) goto L9;
        notifyStateChangeListenersAsynchronously();     // Catch: Throwable -> L6
    L9:
        if (event.getAlgorithmStatus().couldEnableTelephonyFallback() == false) goto L11;
        enableTelephonyTimeZoneFallback("handleLocationAlgorithmEvent(), event=" + event);     // Catch: Throwable -> L6
    L12:
        String reason = "New location algorithm event received. event=" + event;     // Catch: Throwable -> L6
        doAutoTimeZoneDetection(currentUserConfig, reason);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L11:
        disableTelephonyFallbackIfNeeded();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized boolean suggestManualTimeZone(int userId, ManualTimeZoneSuggestion suggestion, boolean bypassUserPolicyChecks) {
        monitor-enter(this);
        ConfigurationInternal currentUserConfig = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L8
        if (currentUserConfig.getUserId() == userId) goto L10;
        Slog.w(LOG_TAG, "Manual suggestion received but user != current user, userId=" + userId + " suggestion=" + suggestion);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L10:
        suggestion.getClass();     // Catch: Throwable -> L8
        String timeZoneId = suggestion.getZoneId();     // Catch: Throwable -> L8
        String cause = "Manual time suggestion received: suggestion=" + suggestion;     // Catch: Throwable -> L8
        TimeZoneCapabilities capabilities = currentUserConfig.asCapabilities(bypassUserPolicyChecks);     // Catch: Throwable -> L8
        if (capabilities.getSetManualTimeZoneCapability() == 40) goto L15;
        Slog.i(LOG_TAG, "User does not have the capability needed to set the time zone manually: capabilities=" + capabilities + ", timeZoneId=" + timeZoneId + ", cause=" + cause);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L15:
        this.mLatestManualSuggestion.set(suggestion);     // Catch: Throwable -> L8
        setDeviceTimeZoneIfRequired(timeZoneId, 1, userId, cause);     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized void suggestTelephonyTimeZone(TelephonyTimeZoneSuggestion suggestion) {
        monitor-enter(this);
        ConfigurationInternal currentUserConfig = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L6
        suggestion.getClass();     // Catch: Throwable -> L6
        int score = scoreTelephonySuggestion(suggestion);     // Catch: Throwable -> L6
        QualifiedTelephonyTimeZoneSuggestion scoredSuggestion = new QualifiedTelephonyTimeZoneSuggestion(suggestion, score);     // Catch: Throwable -> L6
        this.mTelephonySuggestionsBySlotIndex.put(Integer.valueOf(suggestion.getSlotIndex()), scoredSuggestion);     // Catch: Throwable -> L6
        String reason = "New telephony time zone suggested. suggestion=" + suggestion;     // Catch: Throwable -> L6
        doAutoTimeZoneDetection(currentUserConfig, reason);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized void enableTelephonyTimeZoneFallback(String reason) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (((Boolean) this.mTelephonyTimeZoneFallbackEnabled.getValue()).booleanValue() == true) goto L11;
        ConfigurationInternal currentUserConfig = this.mCurrentConfigurationInternal;     // Catch: Throwable -> L9
        this.mTelephonyTimeZoneFallbackEnabled = new TimestampedValue(this.mEnvironment.elapsedRealtimeMillis(), true);     // Catch: Throwable -> L9
        String logMsg = "enableTelephonyTimeZoneFallback:  reason=" + reason + ", currentUserConfig=" + currentUserConfig + ", mTelephonyTimeZoneFallbackEnabled=" + this.mTelephonyTimeZoneFallbackEnabled;     // Catch: Throwable -> L9
        logTimeZoneDebugInfo(logMsg);     // Catch: Throwable -> L9
        disableTelephonyFallbackIfNeeded();     // Catch: Throwable -> L9
        if (currentUserConfig.isTelephonyFallbackSupported() == false) goto L11;
        doAutoTimeZoneDetection(currentUserConfig, reason);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public synchronized MetricsTimeZoneDetectorState generateMetricsState() {
        monitor-enter(this);
        QualifiedTelephonyTimeZoneSuggestion bestQualifiedTelephonySuggestion = findBestTelephonySuggestion();     // Catch: Throwable -> L10
        if (bestQualifiedTelephonySuggestion != null) goto L6;
        TelephonyTimeZoneSuggestion r1 = null;
    L7:
        TelephonyTimeZoneSuggestion telephonySuggestion = r1;
        OrdinalGenerator<String> tzIdOrdinalGenerator = new OrdinalGenerator(new TimeZoneCanonicalizer());     // Catch: Throwable -> L10
        MetricsTimeZoneDetectorState r2 = MetricsTimeZoneDetectorState.create(tzIdOrdinalGenerator, this.mCurrentConfigurationInternal, this.mEnvironment.getDeviceTimeZone(), getLatestManualSuggestion(), telephonySuggestion, getLatestLocationAlgorithmEvent());     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    L6:
        r1 = bestQualifiedTelephonySuggestion.suggestion;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public boolean isTelephonyTimeZoneDetectionSupported() {
        monitor-enter(this);
        boolean r0 = this.mCurrentConfigurationInternal.isTelephonyDetectionSupported();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.TimeZoneDetectorStrategy
    public boolean isGeoTimeZoneDetectionSupported() {
        monitor-enter(this);
        boolean r0 = this.mCurrentConfigurationInternal.isGeoDetectionSupported();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static int scoreTelephonySuggestion(TelephonyTimeZoneSuggestion suggestion) {
        if (suggestion.getZoneId() != null) goto L5;
        return 0;
    L5:
        int score = suggestion.getMatchType();
        if (score != 5) goto L8;
    L21:
        return 4;
    L8:
        if (suggestion.getMatchType() == 4) goto L21;
        if (suggestion.getQuality() != 1) goto L13;
        return 3;
    L13:
        int score2 = suggestion.getQuality();
        if (score2 != 2) goto L16;
        return 2;
    L16:
        int score3 = suggestion.getQuality();
        if (score3 != 3) goto L20;
        return 1;
    L20:
        throw new AssertionError();
    }

    private void doAutoTimeZoneDetection(ConfigurationInternal currentUserConfig, String detectionReason) {
        int detectionMode = currentUserConfig.getDetectionMode();
        switch(detectionMode) {
            case 0: goto L14;
            case 1: goto L22;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        Slog.wtf(LOG_TAG, "Unknown detection mode: " + detectionMode);
        return;
    L5:
        doTelephonyTimeZoneDetection(detectionReason);
        return;
    L6:
        boolean isGeoDetectionCertain = doGeolocationTimeZoneDetection(detectionReason);
        if (isGeoDetectionCertain == false) goto L9;
        return;
    L9:
        if (((Boolean) this.mTelephonyTimeZoneFallbackEnabled.getValue()).booleanValue() == true) goto L11;
        return;
    L11:
        if (currentUserConfig.isTelephonyFallbackSupported() == false) goto L20;
        doTelephonyTimeZoneDetection(detectionReason + ", telephony fallback mode");
        return;
    L20:
        return;
    L14:
        Slog.i(LOG_TAG, "Unknown detection mode: " + detectionMode + ", is location off?");
        return;
    }

    private boolean doGeolocationTimeZoneDetection(String detectionReason) {
        LocationAlgorithmEvent latestLocationAlgorithmEvent = this.mLatestLocationAlgorithmEvent.get();
        if (latestLocationAlgorithmEvent != null) goto L5;
    L19:
        return false;
    L5:
        if (latestLocationAlgorithmEvent.getSuggestion() == null) goto L19;
        GeolocationTimeZoneSuggestion suggestion = latestLocationAlgorithmEvent.getSuggestion();
        List<String> zoneIds = suggestion.getZoneIds();
        if (zoneIds != null) goto L11;
        return false;
    L11:
        if (zoneIds.isEmpty() == false) goto L13;
        return true;
    L13:
        String deviceTimeZone = this.mEnvironment.getDeviceTimeZone();
        if (zoneIds.contains(deviceTimeZone) == false) goto L16;
        String timeZoneId = deviceTimeZone;
    L17:
        setDeviceTimeZoneIfRequired(timeZoneId, 3, 0, detectionReason);
        return true;
    L16:
        String timeZoneId2 = zoneIds.get(0);
        timeZoneId = timeZoneId2;
        goto L17
    }

    private void disableTelephonyFallbackIfNeeded() {
        LocationAlgorithmEvent latestLocationAlgorithmEvent = this.mLatestLocationAlgorithmEvent.get();
        if (latestLocationAlgorithmEvent != null) goto L5;
        return;
    L5:
        GeolocationTimeZoneSuggestion suggestion = latestLocationAlgorithmEvent.getSuggestion();
        boolean latestSuggestionIsNewerThanFallbackEnabled = true;
        if (suggestion != null) goto L8;
    L10:
        boolean isLatestSuggestionCertain = false;
    L11:
        if (isLatestSuggestionCertain == true) goto L13;
        return;
    L13:
        if (((Boolean) this.mTelephonyTimeZoneFallbackEnabled.getValue()).booleanValue() == true) goto L15;
        return;
    L15:
        if (suggestion.getEffectiveFromElapsedMillis() > this.mTelephonyTimeZoneFallbackEnabled.getReferenceTimeMillis()) goto L18;
        latestSuggestionIsNewerThanFallbackEnabled = false;
    L18:
        if (latestSuggestionIsNewerThanFallbackEnabled == false) goto L23;
        this.mTelephonyTimeZoneFallbackEnabled = new TimestampedValue(this.mEnvironment.elapsedRealtimeMillis(), false);
        String logMsg = "disableTelephonyFallbackIfNeeded: mTelephonyTimeZoneFallbackEnabled=" + this.mTelephonyTimeZoneFallbackEnabled;
        logTimeZoneDebugInfo(logMsg);
        return;
    L23:
        return;
    L8:
        if (suggestion.getZoneIds() == null) goto L10;
        isLatestSuggestionCertain = true;
        goto L11
    }

    private void logTimeZoneDebugInfo(String logMsg) {
        this.mEnvironment.addDebugLogEntry(logMsg);
    }

    private void doTelephonyTimeZoneDetection(String detectionReason) {
        QualifiedTelephonyTimeZoneSuggestion bestTelephonySuggestion = findBestTelephonySuggestion();
        if (bestTelephonySuggestion != null) goto L6;
        return;
    L6:
        if (bestTelephonySuggestion.score < 2) goto L8;
        boolean suggestionGoodEnough = true;
    L9:
        if (suggestionGoodEnough == true) goto L11;
        return;
    L11:
        String timeZoneId = bestTelephonySuggestion.suggestion.getZoneId();
        if (timeZoneId != null) goto L15;
        Slog.w(LOG_TAG, "Empty zone suggestion scored higher than expected. This is an error: bestTelephonySuggestion=" + bestTelephonySuggestion + ", detectionReason=" + detectionReason);
        return;
    L15:
        String cause = "Found good suggestion: bestTelephonySuggestion=" + bestTelephonySuggestion + ", detectionReason=" + detectionReason;
        setDeviceTimeZoneIfRequired(timeZoneId, 2, 0, cause);
        return;
    L8:
        suggestionGoodEnough = false;
        goto L9
    }

    private void setDeviceTimeZoneIfRequired(String newZoneId, int origin, int userId, String cause) {
        String currentZoneId = this.mEnvironment.getDeviceTimeZone();
        int currentConfidence = this.mEnvironment.getDeviceTimeZoneConfidence();
        if (newZoneId.equals(currentZoneId) == false) goto L6;
        if (100 > currentConfidence) goto L6;
        return;
    L6:
        String logInfo = "Set device time zone or higher confidence: newZoneId=" + newZoneId + ", cause=" + cause + ", newConfidence=100";
        this.mEnvironment.setDeviceTimeZoneAndConfidence(newZoneId, 100, logInfo);
    }

    private QualifiedTelephonyTimeZoneSuggestion findBestTelephonySuggestion() {
        QualifiedTelephonyTimeZoneSuggestion bestSuggestion = null;
        int i = 0;
    L4:
        if (i >= this.mTelephonySuggestionsBySlotIndex.size()) goto L20;
        QualifiedTelephonyTimeZoneSuggestion candidateSuggestion = this.mTelephonySuggestionsBySlotIndex.valueAt(i);
        if (candidateSuggestion == null) goto L18;
        if (bestSuggestion != null) goto L11;
        bestSuggestion = candidateSuggestion;
        goto L18
    L11:
        if (candidateSuggestion.score <= bestSuggestion.score) goto L14;
        bestSuggestion = candidateSuggestion;
        goto L18
    L14:
        if (candidateSuggestion.score != bestSuggestion.score) goto L18;
        int candidateSlotIndex = candidateSuggestion.suggestion.getSlotIndex();
        int bestSlotIndex = bestSuggestion.suggestion.getSlotIndex();
        if (candidateSlotIndex >= bestSlotIndex) goto L18;
        bestSuggestion = candidateSuggestion;
    L18:
        i = i + 1;
        goto L4
    L20:
        return bestSuggestion;
    }

    public synchronized QualifiedTelephonyTimeZoneSuggestion findBestTelephonySuggestionForTests() {
        monitor-enter(this);
        QualifiedTelephonyTimeZoneSuggestion r0 = findBestTelephonySuggestion();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
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

    private boolean updateDetectorStatus() {
        TimeZoneDetectorStatus newDetectorStatus = createTimeZoneDetectorStatus(this.mCurrentConfigurationInternal, this.mLatestLocationAlgorithmEvent.get());
        TimeZoneDetectorStatus oldDetectorStatus = this.mDetectorStatus;
        boolean statusChanged = !newDetectorStatus.equals(oldDetectorStatus);
        if (statusChanged == false) goto L5;
        this.mDetectorStatus = newDetectorStatus;
    L5:
        return statusChanged;
    }

    @Override // com.android.server.timezonedetector.Dumpable
    public synchronized void dump(IndentingPrintWriter ipw, String[] args) {
        monitor-enter(this);
        ipw.println("TimeZoneDetectorStrategy:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        ipw.println("mCurrentConfigurationInternal=" + this.mCurrentConfigurationInternal);     // Catch: Throwable -> L6
        ipw.println("mDetectorStatus=" + this.mDetectorStatus);     // Catch: Throwable -> L6
        ipw.println("[Capabilities=" + this.mCurrentConfigurationInternal.asCapabilities(false) + "]");     // Catch: Throwable -> L6
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L6
        r1.append("mEnvironment.getDeviceTimeZone()=");     // Catch: Throwable -> L6
        r1.append(this.mEnvironment.getDeviceTimeZone());     // Catch: Throwable -> L6
        ipw.println(r1.toString());     // Catch: Throwable -> L6
        ipw.println("mEnvironment.getDeviceTimeZoneConfidence()=" + this.mEnvironment.getDeviceTimeZoneConfidence());     // Catch: Throwable -> L6
        ipw.println("Misc state:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        ipw.println("mTelephonyTimeZoneFallbackEnabled=" + formatDebugString(this.mTelephonyTimeZoneFallbackEnabled));     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Time zone debug log:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mEnvironment.dumpDebugLog(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Manual suggestion history:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mLatestManualSuggestion.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Location algorithm event history:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mLatestLocationAlgorithmEvent.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.println("Telephony suggestion history:");     // Catch: Throwable -> L6
        ipw.increaseIndent();     // Catch: Throwable -> L6
        this.mTelephonySuggestionsBySlotIndex.dump(ipw);     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        ipw.decreaseIndent();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ManualTimeZoneSuggestion getLatestManualSuggestion() {
        monitor-enter(this);
        ManualTimeZoneSuggestion r0 = this.mLatestManualSuggestion.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized QualifiedTelephonyTimeZoneSuggestion getLatestTelephonySuggestion(int slotIndex) {
        monitor-enter(this);
        QualifiedTelephonyTimeZoneSuggestion r0 = this.mTelephonySuggestionsBySlotIndex.get(Integer.valueOf(slotIndex));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized LocationAlgorithmEvent getLatestLocationAlgorithmEvent() {
        monitor-enter(this);
        LocationAlgorithmEvent r0 = this.mLatestLocationAlgorithmEvent.get();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isTelephonyFallbackEnabledForTests() {
        monitor-enter(this);
        boolean r0 = ((Boolean) this.mTelephonyTimeZoneFallbackEnabled.getValue()).booleanValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
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

    public synchronized TimeZoneDetectorStatus getCachedDetectorStatusForTests() {
        monitor-enter(this);
        TimeZoneDetectorStatus r0 = this.mDetectorStatus;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static String formatDebugString(TimestampedValue<?> value) {
        return value.getValue() + " @ " + Duration.ofMillis(value.getReferenceTimeMillis());
    }

    private static TimeZoneDetectorStatus createTimeZoneDetectorStatus(ConfigurationInternal currentConfigurationInternal, LocationAlgorithmEvent latestLocationAlgorithmEvent) {
        if (currentConfigurationInternal.isAutoDetectionSupported() == true) goto L6;
        int detectorStatus = 1;
    L9:
        TelephonyTimeZoneAlgorithmStatus telephonyAlgorithmStatus = createTelephonyAlgorithmStatus(currentConfigurationInternal);
        LocationTimeZoneAlgorithmStatus locationAlgorithmStatus = createLocationAlgorithmStatus(currentConfigurationInternal, latestLocationAlgorithmEvent);
        return new TimeZoneDetectorStatus(detectorStatus, telephonyAlgorithmStatus, locationAlgorithmStatus);
    L6:
        if (currentConfigurationInternal.getAutoDetectionEnabledBehavior() == false) goto L8;
        detectorStatus = 3;
        goto L9
    L8:
        detectorStatus = 2;
        goto L9
    }

    private static LocationTimeZoneAlgorithmStatus createLocationAlgorithmStatus(ConfigurationInternal currentConfigurationInternal, LocationAlgorithmEvent latestLocationAlgorithmEvent) {
        if (latestLocationAlgorithmEvent == null) goto L5;
        LocationTimeZoneAlgorithmStatus locationAlgorithmStatus = latestLocationAlgorithmEvent.getAlgorithmStatus();
        return locationAlgorithmStatus;
    L5:
        if (currentConfigurationInternal.isGeoDetectionSupported() == true) goto L8;
        LocationTimeZoneAlgorithmStatus locationAlgorithmStatus2 = LocationTimeZoneAlgorithmStatus.NOT_SUPPORTED;
        return locationAlgorithmStatus2;
    L8:
        if (currentConfigurationInternal.isGeoDetectionExecutionEnabled() == false) goto L10;
        LocationTimeZoneAlgorithmStatus locationAlgorithmStatus3 = LocationTimeZoneAlgorithmStatus.RUNNING_NOT_REPORTED;
        return locationAlgorithmStatus3;
    L10:
        LocationTimeZoneAlgorithmStatus locationAlgorithmStatus4 = LocationTimeZoneAlgorithmStatus.NOT_RUNNING;
        return locationAlgorithmStatus4;
    }

    private static TelephonyTimeZoneAlgorithmStatus createTelephonyAlgorithmStatus(ConfigurationInternal currentConfigurationInternal) {
        if (currentConfigurationInternal.isTelephonyDetectionSupported() == true) goto L5;
        int algorithmStatus = 1;
    L7:
        return new TelephonyTimeZoneAlgorithmStatus(algorithmStatus);
    L5:
        algorithmStatus = 3;
        goto L7
    }
}
