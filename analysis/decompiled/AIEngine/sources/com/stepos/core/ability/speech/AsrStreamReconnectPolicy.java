package com.stepos.core.ability.speech;

import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrStreamReconnectPolicy {
    public static final AsrStreamReconnectPolicy INSTANCE = new AsrStreamReconnectPolicy();
    public static final long RISK_BLOCKED_FIXED_RETRY_MS = 2000;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Decision {
        private final int backoffAttempt;
        private final boolean exhausted;
        private final int nextAttempt;
        private final boolean riskBlockedExempt;

        public Decision(int i10, boolean z, int i11, boolean z3) {
            this.nextAttempt = i10;
            this.exhausted = z;
            this.backoffAttempt = i11;
            this.riskBlockedExempt = z3;
        }

        public static /* synthetic */ Decision copy$default(Decision decision, int i10, boolean z, int i11, boolean z3, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = decision.nextAttempt;
            }
            if ((i12 & 2) != 0) {
                z = decision.exhausted;
            }
            if ((i12 & 4) != 0) {
                i11 = decision.backoffAttempt;
            }
            if ((i12 & 8) != 0) {
                z3 = decision.riskBlockedExempt;
            }
            return decision.copy(i10, z, i11, z3);
        }

        public final int component1() {
            return this.nextAttempt;
        }

        public final boolean component2() {
            return this.exhausted;
        }

        public final int component3() {
            return this.backoffAttempt;
        }

        public final boolean component4() {
            return this.riskBlockedExempt;
        }

        public final Decision copy(int i10, boolean z, int i11, boolean z3) {
            return new Decision(i10, z, i11, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Decision)) {
                return false;
            }
            Decision decision = (Decision) obj;
            return this.nextAttempt == decision.nextAttempt && this.exhausted == decision.exhausted && this.backoffAttempt == decision.backoffAttempt && this.riskBlockedExempt == decision.riskBlockedExempt;
        }

        public final int getBackoffAttempt() {
            return this.backoffAttempt;
        }

        public final boolean getExhausted() {
            return this.exhausted;
        }

        public final int getNextAttempt() {
            return this.nextAttempt;
        }

        public final boolean getRiskBlockedExempt() {
            return this.riskBlockedExempt;
        }

        public int hashCode() {
            return Boolean.hashCode(this.riskBlockedExempt) + ai.onnxruntime.a.d(this.backoffAttempt, ai.onnxruntime.a.f(Integer.hashCode(this.nextAttempt) * 31, 31, this.exhausted), 31);
        }

        public String toString() {
            return "Decision(nextAttempt=" + this.nextAttempt + ", exhausted=" + this.exhausted + ", backoffAttempt=" + this.backoffAttempt + ", riskBlockedExempt=" + this.riskBlockedExempt + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class RiskBlockedRecovery {
        private final boolean active;
        private final boolean reconnectFailedOnce;

        /* JADX WARN: Illegal instructions before constructor call */
        public RiskBlockedRecovery() {
            boolean z = false;
            this(z, z, 3, null);
        }

        public static /* synthetic */ RiskBlockedRecovery copy$default(RiskBlockedRecovery riskBlockedRecovery, boolean z, boolean z3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z = riskBlockedRecovery.active;
            }
            if ((i10 & 2) != 0) {
                z3 = riskBlockedRecovery.reconnectFailedOnce;
            }
            return riskBlockedRecovery.copy(z, z3);
        }

        public final boolean component1() {
            return this.active;
        }

        public final boolean component2() {
            return this.reconnectFailedOnce;
        }

        public final RiskBlockedRecovery copy(boolean z, boolean z3) {
            return new RiskBlockedRecovery(z, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RiskBlockedRecovery)) {
                return false;
            }
            RiskBlockedRecovery riskBlockedRecovery = (RiskBlockedRecovery) obj;
            return this.active == riskBlockedRecovery.active && this.reconnectFailedOnce == riskBlockedRecovery.reconnectFailedOnce;
        }

        public final boolean getActive() {
            return this.active;
        }

        public final boolean getReconnectFailedOnce() {
            return this.reconnectFailedOnce;
        }

        public int hashCode() {
            return Boolean.hashCode(this.reconnectFailedOnce) + (Boolean.hashCode(this.active) * 31);
        }

        public String toString() {
            return "RiskBlockedRecovery(active=" + this.active + ", reconnectFailedOnce=" + this.reconnectFailedOnce + ")";
        }

        public RiskBlockedRecovery(boolean z, boolean z3) {
            this.active = z;
            this.reconnectFailedOnce = z3;
        }

        public /* synthetic */ RiskBlockedRecovery(boolean z, boolean z3, int i10, kotlin.jvm.internal.e eVar) {
            this((i10 & 1) != 0 ? false : z, (i10 & 2) != 0 ? false : z3);
        }
    }

    private AsrStreamReconnectPolicy() {
    }

    public final RiskBlockedRecovery clearRiskBlockedRecovery() {
        boolean z = false;
        return new RiskBlockedRecovery(z, z, 3, null);
    }

    public final RiskBlockedRecovery enterRiskBlockedRecovery() {
        return new RiskBlockedRecovery(true, false);
    }

    public final Decision evaluate(int i10, int i11, long j10, long j11, int i12, boolean z) {
        if (i10 == 270007) {
            return new Decision(i11, false, 0, true);
        }
        int i13 = (z || j10 <= j11) ? i11 + 1 : 0;
        return new Decision(i13, i13 >= i12, i13, false);
    }

    public final Pair<Long, RiskBlockedRecovery> planRiskBlockedDelay(RiskBlockedRecovery recovery, long j10) {
        kotlin.jvm.internal.g.f(recovery, "recovery");
        if (recovery.getActive()) {
            return !recovery.getReconnectFailedOnce() ? new Pair<>(Long.valueOf(j10), RiskBlockedRecovery.copy$default(recovery, false, true, 1, null)) : new Pair<>(2000L, recovery);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
