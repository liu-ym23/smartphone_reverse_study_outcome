package com.android.server.timezonedetector.location;

import android.app.time.LocationTimeZoneAlgorithmStatus;
import android.service.timezone.TimeZoneProviderEvent;
import android.service.timezone.TimeZoneProviderSuggestion;
import android.util.IndentingPrintWriter;
import com.android.server.timezonedetector.ConfigurationInternal;
import com.android.server.timezonedetector.Dumpable;
import com.android.server.timezonedetector.GeolocationTimeZoneSuggestion;
import com.android.server.timezonedetector.LocationAlgorithmEvent;
import com.android.server.timezonedetector.ReferenceWithHistory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class LocationTimeZoneProviderController implements Dumpable {
    static final String STATE_CERTAIN = "CERTAIN";
    static final String STATE_DESTROYED = "DESTROYED";
    static final String STATE_FAILED = "FAILED";
    static final String STATE_INITIALIZING = "INITIALIZING";
    static final String STATE_PROVIDERS_INITIALIZING = "PROVIDERS_INITIALIZING";
    static final String STATE_STOPPED = "STOPPED";
    static final String STATE_UNCERTAIN = "UNCERTAIN";
    static final String STATE_UNKNOWN = "UNKNOWN";
    private Callback mCallback;
    private ConfigurationInternal mCurrentUserConfiguration;
    private Environment mEnvironment;
    private LocationAlgorithmEvent mLastEvent;
    private final MetricsLogger mMetricsLogger;
    private final LocationTimeZoneProvider mPrimaryProvider;
    private final boolean mRecordStateChanges;
    private final ArrayList<String> mRecordedStates;
    private final LocationTimeZoneProvider mSecondaryProvider;
    private final Object mSharedLock;
    private final ReferenceWithHistory<String> mState;
    private final ThreadingDomain mThreadingDomain;
    private final ThreadingDomain.SingleRunnableQueue mUncertaintyTimeoutQueue;

    static abstract class Callback {
        protected final ThreadingDomain mThreadingDomain;

        abstract void sendEvent(LocationAlgorithmEvent r1);

        Callback(ThreadingDomain threadingDomain) {
            threadingDomain.getClass();
            this.mThreadingDomain = threadingDomain;
        }
    }

    static abstract class Environment {
        protected final Object mSharedLock;
        protected final ThreadingDomain mThreadingDomain;

        abstract void destroy();

        abstract long elapsedRealtimeMillis();

        abstract ConfigurationInternal getCurrentUserConfigurationInternal();

        abstract Duration getProviderEventFilteringAgeThreshold();

        abstract Duration getProviderInitializationTimeout();

        abstract Duration getProviderInitializationTimeoutFuzz();

        abstract Duration getUncertaintyDelay();

        Environment(ThreadingDomain threadingDomain) {
            threadingDomain.getClass();
            this.mThreadingDomain = threadingDomain;
            this.mSharedLock = threadingDomain.getLockObject();
        }
    }

    interface MetricsLogger {
        void onStateChange(String r1);
    }

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface State {
    }

    public static /* synthetic */ void $r8$lambda$_nAzsmWmruvkOKEjfajnxjHP59c(LocationTimeZoneProviderController r0, LocationTimeZoneProvider r1, long r2, Duration r4) {
        r0.lambda$handleProviderUncertainty$0(r1, r2, r4);
    }

    LocationTimeZoneProviderController(ThreadingDomain threadingDomain, MetricsLogger metricsLogger, LocationTimeZoneProvider primaryProvider, LocationTimeZoneProvider secondaryProvider, boolean recordStateChanges) {
        this.mRecordedStates = new ArrayList(0);
        this.mState = new ReferenceWithHistory(10);
        threadingDomain.getClass();
        this.mThreadingDomain = threadingDomain;
        this.mSharedLock = threadingDomain.getLockObject();
        this.mUncertaintyTimeoutQueue = threadingDomain.createSingleRunnableQueue();
        metricsLogger.getClass();
        this.mMetricsLogger = metricsLogger;
        primaryProvider.getClass();
        this.mPrimaryProvider = primaryProvider;
        secondaryProvider.getClass();
        this.mSecondaryProvider = secondaryProvider;
        this.mRecordStateChanges = recordStateChanges;
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        this.mState.set(STATE_UNKNOWN);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void initialize(Environment environment, Callback callback) {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        LocationTimeZoneManagerService.debugLog("initialize()");     // Catch: Throwable -> L7
        environment.getClass();     // Catch: Throwable -> L7
        this.mEnvironment = environment;     // Catch: Throwable -> L7
        callback.getClass();     // Catch: Throwable -> L7
        this.mCallback = callback;     // Catch: Throwable -> L7
        this.mCurrentUserConfiguration = environment.getCurrentUserConfigurationInternal();     // Catch: Throwable -> L7
        LocationTimeZoneProvider.ProviderListener providerListener = new LocationTimeZoneProviderController$$ExternalSyntheticLambda0(this);     // Catch: Throwable -> L7
        setState(STATE_PROVIDERS_INITIALIZING);     // Catch: Throwable -> L7
        this.mPrimaryProvider.initialize(providerListener);     // Catch: Throwable -> L7
        this.mSecondaryProvider.initialize(providerListener);     // Catch: Throwable -> L7
        setStateAndReportStatusOnlyEvent(STATE_STOPPED, "initialize()");     // Catch: Throwable -> L7
        alterProvidersStartedStateIfRequired(null, this.mCurrentUserConfiguration);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onConfigurationInternalChanged() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        LocationTimeZoneManagerService.debugLog("onConfigChanged()");     // Catch: Throwable -> L9
        ConfigurationInternal oldConfig = this.mCurrentUserConfiguration;     // Catch: Throwable -> L9
        ConfigurationInternal newConfig = this.mEnvironment.getCurrentUserConfigurationInternal();     // Catch: Throwable -> L9
        this.mCurrentUserConfiguration = newConfig;     // Catch: Throwable -> L9
        if (newConfig.equals(oldConfig) == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (newConfig.getUserId() == oldConfig.getUserId()) goto L11;
        String reason = "User changed. old=" + oldConfig.getUserId() + ", new=" + newConfig.getUserId();     // Catch: Throwable -> L9
        LocationTimeZoneManagerService.debugLog("Stopping providers: " + reason);     // Catch: Throwable -> L9
        stopProviders(reason);     // Catch: Throwable -> L9
        alterProvidersStartedStateIfRequired(null, newConfig);     // Catch: Throwable -> L9
        goto L12
    L11:
        alterProvidersStartedStateIfRequired(oldConfig, newConfig);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    boolean isUncertaintyTimeoutSet() {
        return this.mUncertaintyTimeoutQueue.hasQueued();
    }

    long getUncertaintyTimeoutDelayMillis() {
        return this.mUncertaintyTimeoutQueue.getQueuedDelayMillis();
    }

    void destroy() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        stopProviders("destroy()");     // Catch: Throwable -> L7
        this.mPrimaryProvider.destroy();     // Catch: Throwable -> L7
        this.mSecondaryProvider.destroy();     // Catch: Throwable -> L7
        setStateAndReportStatusOnlyEvent(STATE_DESTROYED, "destroy()");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setStateAndReportStatusOnlyEvent(String state, String reason) {
        setState(state);
        LocationAlgorithmEvent event = new LocationAlgorithmEvent(generateCurrentAlgorithmStatus(), null);
        event.addDebugInfo(new String[]{reason});
        reportEvent(event);
    }

    private void reportSuggestionEvent(GeolocationTimeZoneSuggestion suggestion, String reason) {
        LocationTimeZoneAlgorithmStatus algorithmStatus = generateCurrentAlgorithmStatus();
        LocationAlgorithmEvent event = new LocationAlgorithmEvent(algorithmStatus, suggestion);
        event.addDebugInfo(new String[]{reason});
        reportEvent(event);
    }

    private void reportEvent(LocationAlgorithmEvent event) {
        LocationTimeZoneManagerService.debugLog("makeSuggestion: suggestion=" + event);
        this.mCallback.sendEvent(event);
        this.mLastEvent = event;
    }

    private void setState(String state) {
        if (Objects.equals(this.mState.get(), state) == true) goto L9;
        this.mState.set(state);
        if (this.mRecordStateChanges == false) goto L7;
        this.mRecordedStates.add(state);
    L7:
        this.mMetricsLogger.onStateChange(state);
        return;
    }

    private void stopProviders(String reason) {
        stopProviderIfStarted(this.mPrimaryProvider);
        stopProviderIfStarted(this.mSecondaryProvider);
        cancelUncertaintyTimeout();
        setStateAndReportStatusOnlyEvent(STATE_STOPPED, "Providers stopped: " + reason);
    }

    private void stopProviderIfStarted(LocationTimeZoneProvider provider) {
        if (provider.getCurrentState().isStarted() == false) goto L6;
        stopProvider(provider);
        return;
    }

    private void stopProvider(LocationTimeZoneProvider provider) {
        LocationTimeZoneProvider.ProviderState providerState = provider.getCurrentState();
        switch(providerState.stateEnum) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        LocationTimeZoneManagerService.warnLog("Unknown provider state: " + provider);
        return;
    L5:
        LocationTimeZoneManagerService.debugLog("Unable to stop " + provider + ": it is terminated.");
        return;
    L6:
        LocationTimeZoneManagerService.debugLog("No need to stop " + provider + ": already stopped");
        return;
    L7:
        LocationTimeZoneManagerService.debugLog("Stopping " + provider);
        provider.stopUpdates();
    }

    private void alterProvidersStartedStateIfRequired(ConfigurationInternal oldConfiguration, ConfigurationInternal newConfiguration) {
        if (oldConfiguration != null) goto L4;
    L6:
        boolean oldIsGeoDetectionExecutionEnabled = false;
    L7:
        boolean newIsGeoDetectionExecutionEnabled = newConfiguration.isGeoDetectionExecutionEnabled();
        if (oldIsGeoDetectionExecutionEnabled != newIsGeoDetectionExecutionEnabled) goto L10;
        return;
    L10:
        if (newIsGeoDetectionExecutionEnabled == false) goto L17;
        setStateAndReportStatusOnlyEvent(STATE_INITIALIZING, "initializing()");
        tryStartProvider(this.mPrimaryProvider, newConfiguration);
        LocationTimeZoneProvider.ProviderState newPrimaryState = this.mPrimaryProvider.getCurrentState();
        if (newPrimaryState.isStarted() == true) goto L20;
        tryStartProvider(this.mSecondaryProvider, newConfiguration);
        LocationTimeZoneProvider.ProviderState newSecondaryState = this.mSecondaryProvider.getCurrentState();
        if (newSecondaryState.isStarted() == true) goto L21;
        String reason = "Providers are failed: primary=" + this.mPrimaryProvider.getCurrentState() + " secondary=" + this.mPrimaryProvider.getCurrentState();
        setStateAndReportStatusOnlyEvent(STATE_FAILED, reason);
        return;
    L21:
        return;
    L20:
        return;
    L17:
        stopProviders("Geo detection behavior disabled");
        return;
    L4:
        if (oldConfiguration.isGeoDetectionExecutionEnabled() == false) goto L6;
        oldIsGeoDetectionExecutionEnabled = true;
        goto L7
    }

    private void tryStartProvider(LocationTimeZoneProvider provider, ConfigurationInternal configuration) {
        LocationTimeZoneProvider.ProviderState providerState = provider.getCurrentState();
        switch(providerState.stateEnum) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        LocationTimeZoneManagerService.debugLog("Unable to start " + provider + ": it is terminated");
        return;
    L7:
        LocationTimeZoneManagerService.debugLog("Enabling " + provider);
        provider.startUpdates(configuration, this.mEnvironment.getProviderInitializationTimeout(), this.mEnvironment.getProviderInitializationTimeoutFuzz(), this.mEnvironment.getProviderEventFilteringAgeThreshold());
        return;
    L8:
        LocationTimeZoneManagerService.debugLog("No need to start " + provider + ": already started");
        return;
    L5:
        throw new IllegalStateException("Unknown provider state: provider=" + provider);
    }

    void onProviderStateChange(LocationTimeZoneProvider.ProviderState providerState) {
        this.mThreadingDomain.assertCurrentThread();
        LocationTimeZoneProvider provider = providerState.provider;
        assertProviderKnown(provider);
        Object r1 = this.mSharedLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(this.mState.get(), STATE_PROVIDERS_INITIALIZING) == false) goto L12;
        LocationTimeZoneManagerService.warnLog("onProviderStateChange: Ignoring provider state change because both providers have not yet completed initialization. providerState=" + providerState);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        switch(providerState.stateEnum) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L16;
            default: goto L13;
        };     // Catch: Throwable -> L9
    L13:
        LocationTimeZoneManagerService.warnLog("onProviderStateChange: Unexpected provider=" + provider);     // Catch: Throwable -> L9
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L14:
        LocationTimeZoneManagerService.debugLog("Received notification of permanent failure for provider=" + provider);     // Catch: Throwable -> L9
        handleProviderFailedStateChange(providerState);     // Catch: Throwable -> L9
        goto L17
    L15:
        LocationTimeZoneManagerService.debugLog("onProviderStateChange: Received notification of a state change while started, provider=" + provider);     // Catch: Throwable -> L9
        handleProviderStartedStateChange(providerState);     // Catch: Throwable -> L9
        goto L17
    L16:
        LocationTimeZoneManagerService.warnLog("onProviderStateChange: Unexpected state change for provider, provider=" + provider);     // Catch: Throwable -> L9
        goto L17
    }

    private void assertProviderKnown(LocationTimeZoneProvider provider) {
        if (provider != this.mPrimaryProvider) goto L5;
        return;
    L5:
        if (provider != this.mSecondaryProvider) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Unknown provider: " + provider);
    }

    private void handleProviderFailedStateChange(LocationTimeZoneProvider.ProviderState providerState) {
        LocationTimeZoneProvider failedProvider = providerState.provider;
        LocationTimeZoneProvider.ProviderState primaryCurrentState = this.mPrimaryProvider.getCurrentState();
        LocationTimeZoneProvider.ProviderState secondaryCurrentState = this.mSecondaryProvider.getCurrentState();
        if (failedProvider != this.mPrimaryProvider) goto L8;
        if (secondaryCurrentState.isTerminated() == true) goto L15;
        tryStartProvider(this.mSecondaryProvider, this.mCurrentUserConfiguration);
    L15:
        if (primaryCurrentState.isTerminated() == true) goto L17;
        return;
    L17:
        if (secondaryCurrentState.isTerminated() == false) goto L21;
        cancelUncertaintyTimeout();
        String reason = "Both providers are terminated: primary=" + primaryCurrentState.provider + ", secondary=" + secondaryCurrentState.provider;
        setStateAndReportStatusOnlyEvent(STATE_FAILED, reason);
        return;
    L21:
        return;
    L8:
        if (failedProvider != this.mSecondaryProvider) goto L15;
        if (primaryCurrentState.stateEnum == 3) goto L15;
        if (primaryCurrentState.isTerminated() == true) goto L15;
        LocationTimeZoneManagerService.warnLog("Secondary provider unexpected reported a failure: failed provider=" + failedProvider.getName() + ", primary provider=" + this.mPrimaryProvider + ", secondary provider=" + this.mSecondaryProvider);
        goto L15
    }

    private void handleProviderStartedStateChange(LocationTimeZoneProvider.ProviderState providerState) {
        LocationTimeZoneProvider provider = providerState.provider;
        TimeZoneProviderEvent event = providerState.event;
        if (event != null) goto L7;
        long uncertaintyStartedElapsedMillis = this.mEnvironment.elapsedRealtimeMillis();
        handleProviderUncertainty(provider, uncertaintyStartedElapsedMillis, "provider=" + provider + ", implicit uncertainty, event=null");
        return;
    L7:
        if (this.mCurrentUserConfiguration.isGeoDetectionExecutionEnabled() == true) goto L10;
        LocationTimeZoneManagerService.warnLog("Provider=" + provider + " is started, but currentUserConfiguration=" + this.mCurrentUserConfiguration + " suggests it shouldn't be.");
    L10:
        switch(event.getType()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            default: goto L11;
        };
    L11:
        LocationTimeZoneManagerService.warnLog("Unknown eventType=" + event.getType());
        return;
    L12:
        long uncertaintyStartedElapsedMillis2 = event.getCreationElapsedMillis();
        handleProviderUncertainty(provider, uncertaintyStartedElapsedMillis2, "provider=" + provider + ", explicit uncertainty. event=" + event);
        return;
    L13:
        handleProviderSuggestion(provider, event);
        return;
    L14:
        LocationTimeZoneManagerService.warnLog("Provider=" + provider + " is started, but event suggests it shouldn't be");
    }

    private void handleProviderSuggestion(LocationTimeZoneProvider provider, TimeZoneProviderEvent providerEvent) {
        cancelUncertaintyTimeout();
        if (provider != this.mPrimaryProvider) goto L5;
        stopProviderIfStarted(this.mSecondaryProvider);
    L5:
        TimeZoneProviderSuggestion providerSuggestion = providerEvent.getSuggestion();
        setState(STATE_CERTAIN);
        long effectiveFromElapsedMillis = providerSuggestion.getElapsedRealtimeMillis();
        GeolocationTimeZoneSuggestion suggestion = GeolocationTimeZoneSuggestion.createCertainSuggestion(effectiveFromElapsedMillis, providerSuggestion.getTimeZoneIds());
        String debugInfo = "Provider event received: provider=" + provider + ", providerEvent=" + providerEvent + ", suggestionCreationTime=" + this.mEnvironment.elapsedRealtimeMillis();
        reportSuggestionEvent(suggestion, debugInfo);
    }

    @Override // com.android.server.timezonedetector.Dumpable
    public void dump(IndentingPrintWriter ipw, String[] args) {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ipw.println("LocationTimeZoneProviderController:");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        ipw.println("mCurrentUserConfiguration=" + this.mCurrentUserConfiguration);     // Catch: Throwable -> L7
        ipw.println("providerInitializationTimeout=" + this.mEnvironment.getProviderInitializationTimeout());     // Catch: Throwable -> L7
        ipw.println("providerInitializationTimeoutFuzz=" + this.mEnvironment.getProviderInitializationTimeoutFuzz());     // Catch: Throwable -> L7
        ipw.println("uncertaintyDelay=" + this.mEnvironment.getUncertaintyDelay());     // Catch: Throwable -> L7
        ipw.println("mState=" + this.mState.get());     // Catch: Throwable -> L7
        ipw.println("mLastEvent=" + this.mLastEvent);     // Catch: Throwable -> L7
        ipw.println("State history:");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        this.mState.dump(ipw);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println("Primary Provider:");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        this.mPrimaryProvider.dump(ipw, args);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println("Secondary Provider:");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        this.mSecondaryProvider.dump(ipw, args);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void cancelUncertaintyTimeout() {
        this.mUncertaintyTimeoutQueue.cancel();
    }

    void handleProviderUncertainty(LocationTimeZoneProvider provider, final long uncertaintyStartedElapsedMillis, String reason) {
        provider.getClass();
        if (this.mUncertaintyTimeoutQueue.hasQueued() == false) goto L5;
        final LocationTimeZoneProviderController r2 = this;
        final LocationTimeZoneProvider provider2 = provider;
    L10:
        if (provider2 != r2.mPrimaryProvider) goto L13;
        tryStartProvider(r2.mSecondaryProvider, r2.mCurrentUserConfiguration);
        return;
    L13:
        return;
    L5:
        if (STATE_UNCERTAIN.equals(this.mState.get()) == false) goto L7;
        GeolocationTimeZoneSuggestion suggestion = GeolocationTimeZoneSuggestion.createUncertainSuggestion(uncertaintyStartedElapsedMillis);
        String debugInfo = "Uncertainty received from " + provider.getName() + ": primary=" + this.mPrimaryProvider + ", secondary=" + this.mSecondaryProvider + ", uncertaintyStarted=" + Duration.ofMillis(uncertaintyStartedElapsedMillis);
        reportSuggestionEvent(suggestion, debugInfo);
        r2 = this;
        provider2 = provider;
        goto L10
    L7:
        LocationTimeZoneManagerService.debugLog("Starting uncertainty timeout: reason=" + reason);
        final Duration uncertaintyDelay = this.mEnvironment.getUncertaintyDelay();
        r2 = this;
        provider2 = provider;
        this.mUncertaintyTimeoutQueue.runDelayed(new LocationTimeZoneProviderController$$ExternalSyntheticLambda1(r2, provider2, uncertaintyStartedElapsedMillis, uncertaintyDelay), uncertaintyDelay.toMillis());
        goto L10
    }

    private /* synthetic */ void lambda$handleProviderUncertainty$0(LocationTimeZoneProvider provider, long uncertaintyStartedElapsedMillis, Duration uncertaintyDelay) {
        onProviderUncertaintyTimeout(provider, uncertaintyStartedElapsedMillis, uncertaintyDelay);
    }

    private void onProviderUncertaintyTimeout(LocationTimeZoneProvider provider, long uncertaintyStartedElapsedMillis, Duration uncertaintyDelay) {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        long afterUncertaintyTimeoutElapsedMillis = this.mEnvironment.elapsedRealtimeMillis();     // Catch: Throwable -> L7
        setState(STATE_UNCERTAIN);     // Catch: Throwable -> L7
        GeolocationTimeZoneSuggestion suggestion = GeolocationTimeZoneSuggestion.createUncertainSuggestion(uncertaintyStartedElapsedMillis);     // Catch: Throwable -> L7
        String debugInfo = "Uncertainty timeout triggered for " + provider.getName() + ": primary=" + this.mPrimaryProvider + ", secondary=" + this.mSecondaryProvider + ", uncertaintyStarted=" + Duration.ofMillis(uncertaintyStartedElapsedMillis) + ", afterUncertaintyTimeout=" + Duration.ofMillis(afterUncertaintyTimeoutElapsedMillis) + ", uncertaintyDelay=" + uncertaintyDelay;     // Catch: Throwable -> L7
        reportSuggestionEvent(suggestion, debugInfo);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private LocationTimeZoneAlgorithmStatus generateCurrentAlgorithmStatus() {
        String controllerState = this.mState.get();
        LocationTimeZoneProvider.ProviderState primaryProviderState = this.mPrimaryProvider.getCurrentState();
        LocationTimeZoneProvider.ProviderState secondaryProviderState = this.mSecondaryProvider.getCurrentState();
        return createAlgorithmStatus(controllerState, primaryProviderState, secondaryProviderState);
    }

    private static LocationTimeZoneAlgorithmStatus createAlgorithmStatus(String controllerState, LocationTimeZoneProvider.ProviderState primaryProviderState, LocationTimeZoneProvider.ProviderState secondaryProviderState) {
        int algorithmStatus = mapControllerStateToDetectionAlgorithmStatus(controllerState);
        int primaryProviderStatus = primaryProviderState.getProviderStatus();
        int secondaryProviderStatus = secondaryProviderState.getProviderStatus();
        return new LocationTimeZoneAlgorithmStatus(algorithmStatus, primaryProviderStatus, primaryProviderState.getReportedStatus(), secondaryProviderStatus, secondaryProviderState.getReportedStatus());
    }

    private static int mapControllerStateToDetectionAlgorithmStatus(String controllerState) {
        switch(controllerState.hashCode()) {
            case -1166336595: goto L27;
            case -468307734: goto L24;
            case 433141802: goto L21;
            case 478389753: goto L18;
            case 872357833: goto L15;
            case 1386911874: goto L12;
            case 1917201485: goto L9;
            case 2066319421: goto L6;
            default: goto L29;
        };
    L29:
        byte r0 = -1;
    L30:
        switch(r0) {
            case 0: goto L32;
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L32;
            default: goto L31;
        };
    L31:
        return 2;
    L32:
        return 3;
    L6:
        if (controllerState.equals(STATE_FAILED) == false) goto L29;
        r0 = 6;
        goto L30
    L9:
        if (controllerState.equals(STATE_INITIALIZING) == false) goto L29;
        r0 = 0;
        goto L30
    L12:
        if (controllerState.equals(STATE_CERTAIN) == false) goto L29;
        r0 = 2;
        goto L30
    L15:
        if (controllerState.equals(STATE_UNCERTAIN) == false) goto L29;
        r0 = 3;
        goto L30
    L18:
        if (controllerState.equals(STATE_DESTROYED) == false) goto L29;
        r0 = 5;
        goto L30
    L21:
        if (controllerState.equals(STATE_UNKNOWN) == false) goto L29;
        r0 = 7;
        goto L30
    L24:
        if (controllerState.equals(STATE_PROVIDERS_INITIALIZING) == false) goto L29;
        r0 = 1;
        goto L30
    L27:
        if (controllerState.equals(STATE_STOPPED) == false) goto L29;
        r0 = 4;
        goto L30
    }

    void clearRecordedStates() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        this.mRecordedStates.clear();     // Catch: Throwable -> L7
        this.mPrimaryProvider.clearRecordedStates();     // Catch: Throwable -> L7
        this.mSecondaryProvider.clearRecordedStates();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    LocationTimeZoneManagerServiceState getStateForTests() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        LocationTimeZoneManagerServiceState.Builder builder = new LocationTimeZoneManagerServiceState.Builder();     // Catch: Throwable -> L7
        if (this.mLastEvent == null) goto L9;
        builder.setLastEvent(this.mLastEvent);     // Catch: Throwable -> L7
    L9:
        builder.setControllerState(this.mState.get()).setStateChanges(this.mRecordedStates).setPrimaryProviderStateChanges(this.mPrimaryProvider.getRecordedStates()).setSecondaryProviderStateChanges(this.mSecondaryProvider.getRecordedStates());     // Catch: Throwable -> L7
        LocationTimeZoneManagerServiceState r2 = builder.build();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }
}
