package com.stepos.core.model.resilience;

import android.util.Log;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CircuitBreaker {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CircuitBreaker";
    private volatile int effectiveFailureThreshold;
    private volatile long effectiveResetTimeoutMs;
    private final AtomicInteger failureCount;
    private final int failureThreshold;
    private final int halfOpenSuccessThreshold;
    private final AtomicLong lastFailureTime;
    private final long resetTimeoutMs;
    private volatile State state;
    private final AtomicInteger successCount;
    private final AtomicLong totalCalls;
    private final AtomicLong totalCircuitOpens;
    private final AtomicLong totalFailures;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class State {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State CLOSED = new State("CLOSED", 0);
        public static final State OPEN = new State("OPEN", 1);
        public static final State HALF_OPEN = new State("HALF_OPEN", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{CLOSED, OPEN, HALF_OPEN};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.HALF_OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CircuitBreaker() {
        this(0, 0L, 0, 7, null);
    }

    public final boolean allowRequest() {
        this.totalCalls.incrementAndGet();
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i10 == 1) {
            return true;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (System.currentTimeMillis() - this.lastFailureTime.get() <= this.effectiveResetTimeoutMs) {
            Log.d(TAG, "Circuit breaker is OPEN, request rejected");
            return false;
        }
        Log.i(TAG, "Circuit breaker transitioning to HALF_OPEN");
        this.state = State.HALF_OPEN;
        this.successCount.set(0);
        return true;
    }

    public final String getState() {
        return this.state.name();
    }

    public final CircuitBreakerStatistics getStatistics() {
        return new CircuitBreakerStatistics(this.state.name(), this.failureCount.get(), this.successCount.get(), this.totalCalls.get(), this.totalFailures.get(), this.totalCircuitOpens.get(), this.effectiveFailureThreshold, this.effectiveResetTimeoutMs);
    }

    public final boolean isOpen() {
        return !allowRequest();
    }

    public final void recordFailure() {
        this.totalFailures.incrementAndGet();
        this.lastFailureTime.set(System.currentTimeMillis());
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i10 != 1) {
            if (i10 != 3) {
                return;
            }
            Log.w(TAG, "Circuit breaker re-opening from HALF_OPEN");
            this.state = State.OPEN;
            this.totalCircuitOpens.incrementAndGet();
            return;
        }
        int iIncrementAndGet = this.failureCount.incrementAndGet();
        if (iIncrementAndGet >= this.effectiveFailureThreshold) {
            Log.w(TAG, "Circuit breaker opening after " + iIncrementAndGet + " failures");
            this.state = State.OPEN;
            this.totalCircuitOpens.incrementAndGet();
        }
    }

    public final void recordSuccess() {
        int iIncrementAndGet;
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i10 == 1) {
            this.failureCount.set(0);
            return;
        }
        if (i10 == 3 && (iIncrementAndGet = this.successCount.incrementAndGet()) >= this.halfOpenSuccessThreshold) {
            Log.i(TAG, "Circuit breaker closing after " + iIncrementAndGet + " successes");
            this.state = State.CLOSED;
            this.failureCount.set(0);
        }
    }

    public final void reset() {
        Log.i(TAG, "Circuit breaker reset");
        this.state = State.CLOSED;
        this.failureCount.set(0);
        this.successCount.set(0);
    }

    public final void updateThresholds(int i10, long j10) {
        if (i10 < 1) {
            i10 = 1;
        }
        this.effectiveFailureThreshold = i10;
        if (j10 < 1000) {
            j10 = 1000;
        }
        this.effectiveResetTimeoutMs = j10;
        Log.d(TAG, "updateThresholds: failureThreshold=" + this.effectiveFailureThreshold + ", resetTimeoutMs=" + this.effectiveResetTimeoutMs);
    }

    public CircuitBreaker(int i10, long j10, int i11) {
        this.failureThreshold = i10;
        this.resetTimeoutMs = j10;
        this.halfOpenSuccessThreshold = i11;
        this.effectiveFailureThreshold = i10;
        this.effectiveResetTimeoutMs = j10;
        this.state = State.CLOSED;
        this.failureCount = new AtomicInteger(0);
        this.lastFailureTime = new AtomicLong(0L);
        this.successCount = new AtomicInteger(0);
        this.totalCalls = new AtomicLong(0L);
        this.totalFailures = new AtomicLong(0L);
        this.totalCircuitOpens = new AtomicLong(0L);
    }

    public /* synthetic */ CircuitBreaker(int i10, long j10, int i11, int i12, e eVar) {
        this((i12 & 1) != 0 ? 5 : i10, (i12 & 2) != 0 ? AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS : j10, (i12 & 4) != 0 ? 3 : i11);
    }
}
