package com.android.server.timezonedetector.location;

import android.os.SystemClock;
import android.service.timezone.TimeZoneProviderEvent;
import android.service.timezone.TimeZoneProviderStatus;
import com.android.server.timezonedetector.ConfigurationInternal;
import com.android.server.timezonedetector.Dumpable;
import com.android.server.timezonedetector.ReferenceWithHistory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
abstract class LocationTimeZoneProvider implements Dumpable {
    final ReferenceWithHistory<ProviderState> mCurrentState;
    private final ThreadingDomain.SingleRunnableQueue mInitializationTimeoutQueue;
    ProviderListener mProviderListener;
    private final ProviderMetricsLogger mProviderMetricsLogger;
    final String mProviderName;
    private final boolean mRecordStateChanges;
    private final ArrayList<ProviderState> mRecordedStates;
    final Object mSharedLock;
    final ThreadingDomain mThreadingDomain;
    private final TimeZoneProviderEventPreProcessor mTimeZoneProviderEventPreProcessor;

    interface ProviderListener {
        void onProviderStateChange(ProviderState r1);
    }

    interface ProviderMetricsLogger {
        void onProviderStateChanged(int r1);
    }

    static class ProviderState {
        static final int PROVIDER_STATE_DESTROYED = 6;
        static final int PROVIDER_STATE_PERM_FAILED = 5;
        static final int PROVIDER_STATE_STARTED_CERTAIN = 2;
        static final int PROVIDER_STATE_STARTED_INITIALIZING = 1;
        static final int PROVIDER_STATE_STARTED_UNCERTAIN = 3;
        static final int PROVIDER_STATE_STOPPED = 4;
        static final int PROVIDER_STATE_UNKNOWN = 0;
        public final ConfigurationInternal currentUserConfiguration;
        public final TimeZoneProviderEvent event;
        private final String mDebugInfo;
        private final long mStateEntryTimeMillis;
        public final LocationTimeZoneProvider provider;
        public final int stateEnum;

        @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
        @Retention(RetentionPolicy.SOURCE)
        @interface ProviderStateEnum {
        }

        /* JADX INFO: renamed from: -$$Nest$smprettyPrintStateEnum, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8615$$Nest$smprettyPrintStateEnum(int r0) {
            return prettyPrintStateEnum(r0);
        }

        private ProviderState(LocationTimeZoneProvider provider, int stateEnum, TimeZoneProviderEvent event, ConfigurationInternal currentUserConfiguration, String debugInfo) {
            provider.getClass();
            this.provider = provider;
            this.stateEnum = stateEnum;
            this.event = event;
            this.currentUserConfiguration = currentUserConfiguration;
            this.mStateEntryTimeMillis = SystemClock.elapsedRealtime();
            this.mDebugInfo = debugInfo;
        }

        static ProviderState createStartingState(LocationTimeZoneProvider provider) {
            return new ProviderState(provider, 0, null, null, "Initial state");
        }

        ProviderState newState(int newStateEnum, TimeZoneProviderEvent event, ConfigurationInternal currentUserConfig, String debugInfo) {
            switch(this.stateEnum) {
                case 0: goto L10;
                case 1: goto L12;
                case 2: goto L12;
                case 3: goto L12;
                case 4: goto L12;
                case 5: goto L7;
                case 6: goto L7;
                default: goto L5;
            };
        L5:
            throw new IllegalArgumentException("Invalid this.stateEnum=" + this.stateEnum);
        L7:
            throw new IllegalArgumentException("Illegal transition out of " + prettyPrintStateEnum(this.stateEnum));
        L10:
            if (newStateEnum == 4) goto L12;
            throw new IllegalArgumentException("Must transition from " + prettyPrintStateEnum(0) + " to " + prettyPrintStateEnum(4));
        L12:
            switch(newStateEnum) {
                case 0: goto L31;
                case 1: goto L25;
                case 2: goto L25;
                case 3: goto L25;
                case 4: goto L20;
                case 5: goto L15;
                case 6: goto L15;
                default: goto L14;
            };
        L15:
            if (event != null) goto L19;
            if (currentUserConfig != null) goto L19;
        L27:
            return new ProviderState(this.provider, newStateEnum, event, currentUserConfig, debugInfo);
        L19:
            throw new IllegalArgumentException("Terminal state: event and currentUserConfig must be null, newStateEnum=" + newStateEnum + ", event=" + event + ", currentUserConfig=" + currentUserConfig);
        L20:
            if (event != null) goto L24;
            if (currentUserConfig == null) goto L27;
        L24:
            throw new IllegalArgumentException("Stopped state: event and currentUserConfig must be null, event=" + event + ", currentUserConfig=" + currentUserConfig);
        L25:
            if (currentUserConfig != null) goto L27;
            throw new IllegalArgumentException("Started state: currentUserConfig must not be null");
        L14:
            throw new IllegalArgumentException("Unknown newStateEnum=" + newStateEnum);
        L31:
            throw new IllegalArgumentException("Cannot transition to " + prettyPrintStateEnum(0));
        }

        boolean isStarted() {
            if (this.stateEnum != 1) goto L5;
            return true;
        L5:
            if (this.stateEnum != 2) goto L7;
            return true;
        L7:
            if (this.stateEnum == 3) goto L13;
            return false;
        L13:
            return true;
        }

        boolean isTerminated() {
            if (this.stateEnum != 5) goto L5;
        L8:
            return true;
        L5:
            if (this.stateEnum == 6) goto L8;
            return false;
        }

        public int getProviderStatus() {
            switch(this.stateEnum) {
                case 1: goto L13;
                case 2: goto L11;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L6;
                case 6: goto L8;
                default: goto L5;
            };
        L6:
            return 1;
        L8:
            return 2;
        L9:
            return 4;
        L11:
            return 3;
        L13:
            return 2;
        L5:
            throw new IllegalStateException("Unknown state enum:" + prettyPrintStateEnum(this.stateEnum));
        }

        TimeZoneProviderStatus getReportedStatus() {
            if (this.event != null) goto L6;
            return null;
        L6:
            return this.event.getTimeZoneProviderStatus();
        }

        public String toString() {
            return "ProviderState{stateEnum=" + prettyPrintStateEnum(this.stateEnum) + ", event=" + this.event + ", currentUserConfiguration=" + this.currentUserConfiguration + ", mStateEntryTimeMillis=" + this.mStateEntryTimeMillis + ", mDebugInfo=" + this.mDebugInfo + '}';
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L19;
            ProviderState state = (ProviderState) o;
            if (this.stateEnum != state.stateEnum) goto L18;
            if (Objects.equals(this.event, state.event) == false) goto L18;
            if (Objects.equals(this.currentUserConfiguration, state.currentUserConfiguration) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.stateEnum), this.event, this.currentUserConfiguration});
        }

        private static String prettyPrintStateEnum(int state) {
            switch(state) {
                case 1: goto L15;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L9;
                case 5: goto L7;
                case 6: goto L5;
                default: goto L4;
            };
        L5:
            return "Destroyed (6)";
        L7:
            return "Perm failure (5)";
        L9:
            return "Stopped (4)";
        L11:
            return "Started uncertain (3)";
        L13:
            return "Started certain (2)";
        L15:
            return "Started initializing (1)";
        L4:
            return "Unknown (" + state + ")";
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$IidBkFMF1_i-7fqMVjXAUm3OBSA, reason: not valid java name */
    public static /* synthetic */ void m8614$r8$lambda$IidBkFMF1_i7fqMVjXAUm3OBSA(LocationTimeZoneProvider r0) {
        r0.handleInitializationTimeout();
    }

    abstract void onDestroy();

    abstract boolean onInitialize();

    abstract void onStartUpdates(Duration r1, Duration r2);

    abstract void onStopUpdates();

    LocationTimeZoneProvider(ProviderMetricsLogger providerMetricsLogger, ThreadingDomain threadingDomain, String providerName, TimeZoneProviderEventPreProcessor timeZoneProviderEventPreProcessor, boolean recordStateChanges) {
        this.mRecordedStates = new ArrayList(0);
        this.mCurrentState = new ReferenceWithHistory(10);
        threadingDomain.getClass();
        this.mThreadingDomain = threadingDomain;
        providerMetricsLogger.getClass();
        this.mProviderMetricsLogger = providerMetricsLogger;
        this.mInitializationTimeoutQueue = threadingDomain.createSingleRunnableQueue();
        this.mSharedLock = threadingDomain.getLockObject();
        providerName.getClass();
        this.mProviderName = providerName;
        timeZoneProviderEventPreProcessor.getClass();
        this.mTimeZoneProviderEventPreProcessor = timeZoneProviderEventPreProcessor;
        this.mRecordStateChanges = recordStateChanges;
    }

    final void initialize(ProviderListener providerListener) {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProviderListener != null) goto L18;
        providerListener.getClass();     // Catch: Throwable -> L9
        this.mProviderListener = providerListener;     // Catch: Throwable -> L9
        ProviderState currentState = ProviderState.createStartingState(this).newState(4, null, null, "initialize");     // Catch: Throwable -> L9
        setCurrentState(currentState, false);     // Catch: Throwable -> L9
        boolean initializationSuccess = onInitialize();     // Catch: Throwable -> L9 RuntimeException -> L11
        String initializationFailureReason = "onInitialize() returned false";
    L13:
        if (initializationSuccess == true) goto L15;
        setCurrentState(currentState.newState(5, null, null, "Failed to initialize: " + initializationFailureReason), true);     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        LocationTimeZoneManagerService.warnLog("Unable to initialize the provider due to exception", e);     // Catch: Throwable -> L9
        initializationSuccess = false;
        initializationFailureReason = "onInitialize() threw exception:" + e.getMessage();     // Catch: Throwable -> L9
        goto L13
    L18:
        throw new IllegalStateException("initialize already called");     // Catch: Throwable -> L9
    }

    final void destroy() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ProviderState currentState = this.mCurrentState.get();     // Catch: Throwable -> L7
        if (currentState.isTerminated() == true) goto L9;
        ProviderState destroyedState = currentState.newState(6, null, null, "destroy");     // Catch: Throwable -> L7
        setCurrentState(destroyedState, false);     // Catch: Throwable -> L7
        onDestroy();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    final void clearRecordedStates() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        this.mRecordedStates.clear();     // Catch: Throwable -> L7
        this.mRecordedStates.trimToSize();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    final List<ProviderState> getRecordedStates() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mRecordedStates);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void setCurrentState(ProviderState newState, boolean notifyChanges) {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ProviderState oldState = this.mCurrentState.get();     // Catch: Throwable -> L9
        this.mCurrentState.set(newState);     // Catch: Throwable -> L9
        onSetCurrentState(newState);     // Catch: Throwable -> L9
        if (Objects.equals(newState, oldState) == true) goto L13;
        this.mProviderMetricsLogger.onProviderStateChanged(newState.stateEnum);     // Catch: Throwable -> L9
        if (this.mRecordStateChanges == false) goto L11;
        this.mRecordedStates.add(newState);     // Catch: Throwable -> L9
    L11:
        if (notifyChanges == false) goto L13;
        this.mProviderListener.onProviderStateChange(newState);     // Catch: Throwable -> L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void onSetCurrentState(ProviderState newState) {
    }

    final ProviderState getCurrentState() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ProviderState r1 = this.mCurrentState.get();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    final String getName() {
        this.mThreadingDomain.assertCurrentThread();
        return this.mProviderName;
    }

    final void startUpdates(ConfigurationInternal currentUserConfiguration, Duration initializationTimeout, Duration initializationTimeoutFuzz, Duration eventFilteringAgeThreshold) {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        assertCurrentState(4);     // Catch: Throwable -> L8
        ProviderState currentState = this.mCurrentState.get();     // Catch: Throwable -> L8
        ProviderState newState = currentState.newState(1, null, currentUserConfiguration, "startUpdates");     // Catch: Throwable -> L8
        setCurrentState(newState, false);     // Catch: Throwable -> L8
        Duration delay = initializationTimeout.plus(initializationTimeoutFuzz);     // Catch: Throwable -> L8
        this.mInitializationTimeoutQueue.runDelayed(new LocationTimeZoneProvider$$ExternalSyntheticLambda0(this), delay.toMillis());     // Catch: Throwable -> L8
        onStartUpdates(initializationTimeout, eventFilteringAgeThreshold);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleInitializationTimeout() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ProviderState currentState = this.mCurrentState.get();     // Catch: Throwable -> L7
        if (currentState.stateEnum != 1) goto L9;
        ProviderState newState = currentState.newState(3, null, currentState.currentUserConfiguration, "handleInitializationTimeout");     // Catch: Throwable -> L7
        setCurrentState(newState, true);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        LocationTimeZoneManagerService.warnLog("handleInitializationTimeout: Initialization timeout triggered when in an unexpected state=" + currentState);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    final void stopUpdates() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        assertIsStarted();     // Catch: Throwable -> L7
        ProviderState currentState = this.mCurrentState.get();     // Catch: Throwable -> L7
        ProviderState newState = currentState.newState(4, null, null, "stopUpdates");     // Catch: Throwable -> L7
        setCurrentState(newState, false);     // Catch: Throwable -> L7
        cancelInitializationTimeoutIfSet();     // Catch: Throwable -> L7
        onStopUpdates();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    final void handleTimeZoneProviderEvent(TimeZoneProviderEvent timeZoneProviderEvent) {
        this.mThreadingDomain.assertCurrentThread();
        timeZoneProviderEvent.getClass();
        TimeZoneProviderEvent timeZoneProviderEvent2 = this.mTimeZoneProviderEventPreProcessor.preProcess(timeZoneProviderEvent);
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        LocationTimeZoneManagerService.debugLog("handleTimeZoneProviderEvent: mProviderName=" + this.mProviderName + ", timeZoneProviderEvent=" + timeZoneProviderEvent2);     // Catch: Throwable -> L8
        ProviderState currentState = this.mCurrentState.get();     // Catch: Throwable -> L8
        int eventType = timeZoneProviderEvent2.getType();     // Catch: Throwable -> L8
        switch(currentState.stateEnum) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L10;
            default: goto L7;
        };     // Catch: Throwable -> L8
    L10:
        LocationTimeZoneManagerService.warnLog("handleTimeZoneProviderEvent: Event=" + timeZoneProviderEvent2 + " received for provider=" + this + " when in terminated state");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        switch(eventType) {
            case 1: goto L19;
            case 2: goto L16;
            case 3: goto L16;
            default: goto L15;
        };     // Catch: Throwable -> L8
    L16:
        LocationTimeZoneManagerService.warnLog("handleTimeZoneProviderEvent: event=" + timeZoneProviderEvent2 + " received for stopped provider=" + this + ", ignoring");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        String msg = "handleTimeZoneProviderEvent: Failure event=" + timeZoneProviderEvent2 + " received for stopped provider=" + this.mProviderName + ", entering permanently failed state";     // Catch: Throwable -> L8
        LocationTimeZoneManagerService.warnLog(msg);     // Catch: Throwable -> L8
        ProviderState newState = currentState.newState(5, null, null, msg);     // Catch: Throwable -> L8
        setCurrentState(newState, true);     // Catch: Throwable -> L8
        cancelInitializationTimeoutIfSet();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        throw new IllegalStateException("Unknown eventType=" + timeZoneProviderEvent2);     // Catch: Throwable -> L8
    L22:
        switch(eventType) {
            case 1: goto L32;
            case 2: goto L26;
            case 3: goto L26;
            default: goto L24;
        };     // Catch: Throwable -> L8
    L32:
        String msg2 = "handleTimeZoneProviderEvent: Failure event=" + timeZoneProviderEvent2 + " received for provider=" + this.mProviderName + " in state=" + ProviderState.m8615$$Nest$smprettyPrintStateEnum(currentState.stateEnum) + ", entering permanently failed state";     // Catch: Throwable -> L8
        LocationTimeZoneManagerService.warnLog(msg2);     // Catch: Throwable -> L8
        ProviderState newState2 = currentState.newState(5, null, null, msg2);     // Catch: Throwable -> L8
        setCurrentState(newState2, true);     // Catch: Throwable -> L8
        cancelInitializationTimeoutIfSet();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        throw new IllegalStateException("Unknown eventType=" + timeZoneProviderEvent2);     // Catch: Throwable -> L8
    L26:
        if (eventType != 3) goto L28;
        int providerStateEnum = 3;
    L29:
        ProviderState newState3 = currentState.newState(providerStateEnum, timeZoneProviderEvent2, currentState.currentUserConfiguration, "handleTimeZoneProviderEvent");     // Catch: Throwable -> L8
        setCurrentState(newState3, true);     // Catch: Throwable -> L8
        cancelInitializationTimeoutIfSet();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L28:
        providerStateEnum = 2;
        goto L29
    L7:
        throw new IllegalStateException("Unknown providerType=" + currentState);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    final void handleTemporaryFailure(String reason) {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ProviderState currentState = this.mCurrentState.get();     // Catch: Throwable -> L8
        switch(currentState.stateEnum) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            default: goto L7;
        };     // Catch: Throwable -> L8
    L10:
        LocationTimeZoneManagerService.debugLog("handleProviderLost reason=" + reason + ", mProviderName=" + this.mProviderName + ", currentState=" + currentState + ": No state change required, provider is terminated.");     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        LocationTimeZoneManagerService.debugLog("handleProviderLost reason=" + reason + ", mProviderName=" + this.mProviderName + ", currentState=" + currentState + ": No state change required, provider is stopped.");     // Catch: Throwable -> L8
        goto L13
    L12:
        String debugInfo = "handleTemporaryFailure: reason=" + reason + ", currentState=" + ProviderState.m8615$$Nest$smprettyPrintStateEnum(currentState.stateEnum);     // Catch: Throwable -> L8
        ProviderState newState = currentState.newState(3, null, currentState.currentUserConfiguration, debugInfo);     // Catch: Throwable -> L8
        setCurrentState(newState, true);     // Catch: Throwable -> L8
        cancelInitializationTimeoutIfSet();     // Catch: Throwable -> L8
        goto L13
    L7:
        throw new IllegalStateException("Unknown currentState=" + currentState);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void assertIsStarted() {
        ProviderState currentState = this.mCurrentState.get();
        if (currentState.isStarted() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Required a started state, but was " + currentState);
    }

    private void assertCurrentState(int requiredState) {
        ProviderState currentState = this.mCurrentState.get();
        if (currentState.stateEnum != requiredState) goto L6;
        return;
    L6:
        throw new IllegalStateException("Required stateEnum=" + requiredState + ", but was " + currentState);
    }

    boolean isInitializationTimeoutSet() {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        boolean r1 = this.mInitializationTimeoutQueue.hasQueued();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void cancelInitializationTimeoutIfSet() {
        if (this.mInitializationTimeoutQueue.hasQueued() == false) goto L6;
        this.mInitializationTimeoutQueue.cancel();
        return;
    }

    Duration getInitializationTimeoutDelay() {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        Duration r1 = Duration.ofMillis(this.mInitializationTimeoutQueue.getQueuedDelayMillis());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
