package com.stepos.core.common.cloud;

import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.util.TraceIdKeys;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudTransportConfig {
    private final Backpressure backpressure;
    private final Resilience resilience;
    private final Timeout timeout;
    private final Watchdog watchdog;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Backpressure {
        private final int downstreamBufferSize;
        private final long uplinkQueueLimitBytes;

        public Backpressure() {
            this(0L, 0, 3, null);
        }

        public static /* synthetic */ Backpressure copy$default(Backpressure backpressure, long j10, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j10 = backpressure.uplinkQueueLimitBytes;
            }
            if ((i11 & 2) != 0) {
                i10 = backpressure.downstreamBufferSize;
            }
            return backpressure.copy(j10, i10);
        }

        public final long component1() {
            return this.uplinkQueueLimitBytes;
        }

        public final int component2() {
            return this.downstreamBufferSize;
        }

        public final Backpressure copy(long j10, int i10) {
            return new Backpressure(j10, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Backpressure)) {
                return false;
            }
            Backpressure backpressure = (Backpressure) obj;
            return this.uplinkQueueLimitBytes == backpressure.uplinkQueueLimitBytes && this.downstreamBufferSize == backpressure.downstreamBufferSize;
        }

        public final int getDownstreamBufferSize() {
            return this.downstreamBufferSize;
        }

        public final long getUplinkQueueLimitBytes() {
            return this.uplinkQueueLimitBytes;
        }

        public int hashCode() {
            return Integer.hashCode(this.downstreamBufferSize) + (Long.hashCode(this.uplinkQueueLimitBytes) * 31);
        }

        public String toString() {
            StringBuilder sbR = ai.onnxruntime.a.r(this.uplinkQueueLimitBytes, "Backpressure(uplinkQueueLimitBytes=", ", downstreamBufferSize=", this.downstreamBufferSize);
            sbR.append(")");
            return sbR.toString();
        }

        public Backpressure(long j10, int i10) {
            this.uplinkQueueLimitBytes = j10;
            this.downstreamBufferSize = i10;
        }

        public /* synthetic */ Backpressure(long j10, int i10, int i11, kotlin.jvm.internal.e eVar) {
            this((i11 & 1) != 0 ? 8388608L : j10, (i11 & 2) != 0 ? 64 : i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Resilience {
        private final long pollBackoffCapMs;
        private final int pollBackoffFactor;
        private final int pollMaxConsecutiveFailures;
        private final long pollNetworkDownGraceMs;
        private final long reconnectBaseMs;
        private final long reconnectCapMs;
        private final int reconnectMaxAttempts;
        private final long reconnectRateLimitedBaseMs;
        private final long reconnectStableSessionMs;

        public Resilience() {
            this(0L, 0L, 0L, 0, 0L, 0, 0L, 0L, 0, 511, null);
        }

        public final long component1() {
            return this.reconnectBaseMs;
        }

        public final long component2() {
            return this.reconnectRateLimitedBaseMs;
        }

        public final long component3() {
            return this.reconnectCapMs;
        }

        public final int component4() {
            return this.reconnectMaxAttempts;
        }

        public final long component5() {
            return this.reconnectStableSessionMs;
        }

        public final int component6() {
            return this.pollBackoffFactor;
        }

        public final long component7() {
            return this.pollBackoffCapMs;
        }

        public final long component8() {
            return this.pollNetworkDownGraceMs;
        }

        public final int component9() {
            return this.pollMaxConsecutiveFailures;
        }

        public final Resilience copy(long j10, long j11, long j12, int i10, long j13, int i11, long j14, long j15, int i12) {
            return new Resilience(j10, j11, j12, i10, j13, i11, j14, j15, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resilience)) {
                return false;
            }
            Resilience resilience = (Resilience) obj;
            return this.reconnectBaseMs == resilience.reconnectBaseMs && this.reconnectRateLimitedBaseMs == resilience.reconnectRateLimitedBaseMs && this.reconnectCapMs == resilience.reconnectCapMs && this.reconnectMaxAttempts == resilience.reconnectMaxAttempts && this.reconnectStableSessionMs == resilience.reconnectStableSessionMs && this.pollBackoffFactor == resilience.pollBackoffFactor && this.pollBackoffCapMs == resilience.pollBackoffCapMs && this.pollNetworkDownGraceMs == resilience.pollNetworkDownGraceMs && this.pollMaxConsecutiveFailures == resilience.pollMaxConsecutiveFailures;
        }

        public final long getPollBackoffCapMs() {
            return this.pollBackoffCapMs;
        }

        public final int getPollBackoffFactor() {
            return this.pollBackoffFactor;
        }

        public final int getPollMaxConsecutiveFailures() {
            return this.pollMaxConsecutiveFailures;
        }

        public final long getPollNetworkDownGraceMs() {
            return this.pollNetworkDownGraceMs;
        }

        public final long getReconnectBaseMs() {
            return this.reconnectBaseMs;
        }

        public final long getReconnectCapMs() {
            return this.reconnectCapMs;
        }

        public final int getReconnectMaxAttempts() {
            return this.reconnectMaxAttempts;
        }

        public final long getReconnectRateLimitedBaseMs() {
            return this.reconnectRateLimitedBaseMs;
        }

        public final long getReconnectStableSessionMs() {
            return this.reconnectStableSessionMs;
        }

        public int hashCode() {
            return Integer.hashCode(this.pollMaxConsecutiveFailures) + a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.pollBackoffFactor, a0.a.c(ai.onnxruntime.a.d(this.reconnectMaxAttempts, a0.a.c(a0.a.c(Long.hashCode(this.reconnectBaseMs) * 31, this.reconnectRateLimitedBaseMs, 31), this.reconnectCapMs, 31), 31), this.reconnectStableSessionMs, 31), 31), this.pollBackoffCapMs, 31), this.pollNetworkDownGraceMs, 31);
        }

        public String toString() {
            long j10 = this.reconnectBaseMs;
            long j11 = this.reconnectRateLimitedBaseMs;
            long j12 = this.reconnectCapMs;
            int i10 = this.reconnectMaxAttempts;
            long j13 = this.reconnectStableSessionMs;
            int i11 = this.pollBackoffFactor;
            long j14 = this.pollBackoffCapMs;
            long j15 = this.pollNetworkDownGraceMs;
            int i12 = this.pollMaxConsecutiveFailures;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "Resilience(reconnectBaseMs=", ", reconnectRateLimitedBaseMs=");
            sbQ.append(j11);
            a0.a.s(j12, ", reconnectCapMs=", ", reconnectMaxAttempts=", sbQ);
            com.stepos.core.ota.d.s(sbQ, i10, ", reconnectStableSessionMs=", j13);
            sbQ.append(", pollBackoffFactor=");
            sbQ.append(i11);
            sbQ.append(", pollBackoffCapMs=");
            sbQ.append(j14);
            a0.a.s(j15, ", pollNetworkDownGraceMs=", ", pollMaxConsecutiveFailures=", sbQ);
            return ai.onnxruntime.a.j(")", i12, sbQ);
        }

        public Resilience(long j10, long j11, long j12, int i10, long j13, int i11, long j14, long j15, int i12) {
            this.reconnectBaseMs = j10;
            this.reconnectRateLimitedBaseMs = j11;
            this.reconnectCapMs = j12;
            this.reconnectMaxAttempts = i10;
            this.reconnectStableSessionMs = j13;
            this.pollBackoffFactor = i11;
            this.pollBackoffCapMs = j14;
            this.pollNetworkDownGraceMs = j15;
            this.pollMaxConsecutiveFailures = i12;
        }

        public /* synthetic */ Resilience(long j10, long j11, long j12, int i10, long j13, int i11, long j14, long j15, int i12, int i13, kotlin.jvm.internal.e eVar) {
            this((i13 & 1) != 0 ? 500L : j10, (i13 & 2) != 0 ? 2000L : j11, (i13 & 4) != 0 ? AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS : j12, (i13 & 8) != 0 ? 6 : i10, (i13 & 16) != 0 ? 10000L : j13, (i13 & 32) != 0 ? 2 : i11, (i13 & 64) == 0 ? j14 : TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS, (i13 & TraceIdKeys.MAX_LENGTH) != 0 ? 15000L : j15, (i13 & 256) != 0 ? 6 : i12);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Timeout {
        private final long connectMs;
        private final long pingIntervalMs;
        private final long readMs;
        private final long writeMs;

        public Timeout() {
            this(0L, 0L, 0L, 0L, 15, null);
        }

        public static /* synthetic */ Timeout copy$default(Timeout timeout, long j10, long j11, long j12, long j13, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = timeout.connectMs;
            }
            long j14 = j10;
            if ((i10 & 2) != 0) {
                j11 = timeout.readMs;
            }
            long j15 = j11;
            if ((i10 & 4) != 0) {
                j12 = timeout.writeMs;
            }
            return timeout.copy(j14, j15, j12, (i10 & 8) != 0 ? timeout.pingIntervalMs : j13);
        }

        public final long component1() {
            return this.connectMs;
        }

        public final long component2() {
            return this.readMs;
        }

        public final long component3() {
            return this.writeMs;
        }

        public final long component4() {
            return this.pingIntervalMs;
        }

        public final Timeout copy(long j10, long j11, long j12, long j13) {
            return new Timeout(j10, j11, j12, j13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Timeout)) {
                return false;
            }
            Timeout timeout = (Timeout) obj;
            return this.connectMs == timeout.connectMs && this.readMs == timeout.readMs && this.writeMs == timeout.writeMs && this.pingIntervalMs == timeout.pingIntervalMs;
        }

        public final long getConnectMs() {
            return this.connectMs;
        }

        public final long getPingIntervalMs() {
            return this.pingIntervalMs;
        }

        public final long getReadMs() {
            return this.readMs;
        }

        public final long getWriteMs() {
            return this.writeMs;
        }

        public int hashCode() {
            return Long.hashCode(this.pingIntervalMs) + a0.a.c(a0.a.c(Long.hashCode(this.connectMs) * 31, this.readMs, 31), this.writeMs, 31);
        }

        public String toString() {
            long j10 = this.connectMs;
            long j11 = this.readMs;
            long j12 = this.writeMs;
            long j13 = this.pingIntervalMs;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "Timeout(connectMs=", ", readMs=");
            sbQ.append(j11);
            a0.a.s(j12, ", writeMs=", ", pingIntervalMs=", sbQ);
            return ai.onnxruntime.a.m(sbQ, j13, ")");
        }

        public Timeout(long j10, long j11, long j12, long j13) {
            this.connectMs = j10;
            this.readMs = j11;
            this.writeMs = j12;
            this.pingIntervalMs = j13;
        }

        public /* synthetic */ Timeout(long j10, long j11, long j12, long j13, int i10, kotlin.jvm.internal.e eVar) {
            this((i10 & 1) != 0 ? TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS : j10, (i10 & 2) != 0 ? 60000L : j11, (i10 & 4) != 0 ? 60000L : j12, (i10 & 8) != 0 ? 15000L : j13);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Watchdog {
        private final long closeWaitOpenMs;
        private final long finishGraceMs;
        private final long idleCheckMs;
        private final long idleTimeoutMs;
        private final long manualCommitGraceMs;
        private final long sessionOpenTimeoutMs;
        private final long wsHandshakeTimeoutMs;

        public Watchdog() {
            this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 127, null);
        }

        public final long component1() {
            return this.idleTimeoutMs;
        }

        public final long component2() {
            return this.idleCheckMs;
        }

        public final long component3() {
            return this.finishGraceMs;
        }

        public final long component4() {
            return this.manualCommitGraceMs;
        }

        public final long component5() {
            return this.sessionOpenTimeoutMs;
        }

        public final long component6() {
            return this.wsHandshakeTimeoutMs;
        }

        public final long component7() {
            return this.closeWaitOpenMs;
        }

        public final Watchdog copy(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
            return new Watchdog(j10, j11, j12, j13, j14, j15, j16);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Watchdog)) {
                return false;
            }
            Watchdog watchdog = (Watchdog) obj;
            return this.idleTimeoutMs == watchdog.idleTimeoutMs && this.idleCheckMs == watchdog.idleCheckMs && this.finishGraceMs == watchdog.finishGraceMs && this.manualCommitGraceMs == watchdog.manualCommitGraceMs && this.sessionOpenTimeoutMs == watchdog.sessionOpenTimeoutMs && this.wsHandshakeTimeoutMs == watchdog.wsHandshakeTimeoutMs && this.closeWaitOpenMs == watchdog.closeWaitOpenMs;
        }

        public final long getCloseWaitOpenMs() {
            return this.closeWaitOpenMs;
        }

        public final long getFinishGraceMs() {
            return this.finishGraceMs;
        }

        public final long getIdleCheckMs() {
            return this.idleCheckMs;
        }

        public final long getIdleTimeoutMs() {
            return this.idleTimeoutMs;
        }

        public final long getManualCommitGraceMs() {
            return this.manualCommitGraceMs;
        }

        public final long getSessionOpenTimeoutMs() {
            return this.sessionOpenTimeoutMs;
        }

        public final long getWsHandshakeTimeoutMs() {
            return this.wsHandshakeTimeoutMs;
        }

        public int hashCode() {
            return Long.hashCode(this.closeWaitOpenMs) + a0.a.c(a0.a.c(a0.a.c(a0.a.c(a0.a.c(Long.hashCode(this.idleTimeoutMs) * 31, this.idleCheckMs, 31), this.finishGraceMs, 31), this.manualCommitGraceMs, 31), this.sessionOpenTimeoutMs, 31), this.wsHandshakeTimeoutMs, 31);
        }

        public String toString() {
            long j10 = this.idleTimeoutMs;
            long j11 = this.idleCheckMs;
            long j12 = this.finishGraceMs;
            long j13 = this.manualCommitGraceMs;
            long j14 = this.sessionOpenTimeoutMs;
            long j15 = this.wsHandshakeTimeoutMs;
            long j16 = this.closeWaitOpenMs;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "Watchdog(idleTimeoutMs=", ", idleCheckMs=");
            sbQ.append(j11);
            a0.a.s(j12, ", finishGraceMs=", ", manualCommitGraceMs=", sbQ);
            sbQ.append(j13);
            a0.a.s(j14, ", sessionOpenTimeoutMs=", ", wsHandshakeTimeoutMs=", sbQ);
            sbQ.append(j15);
            return a0.a.d(j16, ", closeWaitOpenMs=", ")", sbQ);
        }

        public Watchdog(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.idleTimeoutMs = j10;
            this.idleCheckMs = j11;
            this.finishGraceMs = j12;
            this.manualCommitGraceMs = j13;
            this.sessionOpenTimeoutMs = j14;
            this.wsHandshakeTimeoutMs = j15;
            this.closeWaitOpenMs = j16;
        }

        public /* synthetic */ Watchdog(long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i10, kotlin.jvm.internal.e eVar) {
            this((i10 & 1) != 0 ? AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS : j10, (i10 & 2) != 0 ? 5000L : j11, (i10 & 4) != 0 ? 2500L : j12, (i10 & 8) != 0 ? 15000L : j13, (i10 & 16) != 0 ? TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS : j14, (i10 & 32) == 0 ? j15 : 15000L, (i10 & 64) != 0 ? 5000L : j16);
        }
    }

    public CloudTransportConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CloudTransportConfig copy$default(CloudTransportConfig cloudTransportConfig, Timeout timeout, Resilience resilience, Backpressure backpressure, Watchdog watchdog, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            timeout = cloudTransportConfig.timeout;
        }
        if ((i10 & 2) != 0) {
            resilience = cloudTransportConfig.resilience;
        }
        if ((i10 & 4) != 0) {
            backpressure = cloudTransportConfig.backpressure;
        }
        if ((i10 & 8) != 0) {
            watchdog = cloudTransportConfig.watchdog;
        }
        return cloudTransportConfig.copy(timeout, resilience, backpressure, watchdog);
    }

    public final Timeout component1() {
        return this.timeout;
    }

    public final Resilience component2() {
        return this.resilience;
    }

    public final Backpressure component3() {
        return this.backpressure;
    }

    public final Watchdog component4() {
        return this.watchdog;
    }

    public final CloudTransportConfig copy(Timeout timeout, Resilience resilience, Backpressure backpressure, Watchdog watchdog) {
        kotlin.jvm.internal.g.f(timeout, "timeout");
        kotlin.jvm.internal.g.f(resilience, "resilience");
        kotlin.jvm.internal.g.f(backpressure, "backpressure");
        kotlin.jvm.internal.g.f(watchdog, "watchdog");
        return new CloudTransportConfig(timeout, resilience, backpressure, watchdog);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudTransportConfig)) {
            return false;
        }
        CloudTransportConfig cloudTransportConfig = (CloudTransportConfig) obj;
        return kotlin.jvm.internal.g.b(this.timeout, cloudTransportConfig.timeout) && kotlin.jvm.internal.g.b(this.resilience, cloudTransportConfig.resilience) && kotlin.jvm.internal.g.b(this.backpressure, cloudTransportConfig.backpressure) && kotlin.jvm.internal.g.b(this.watchdog, cloudTransportConfig.watchdog);
    }

    public final Backpressure getBackpressure() {
        return this.backpressure;
    }

    public final Resilience getResilience() {
        return this.resilience;
    }

    public final Timeout getTimeout() {
        return this.timeout;
    }

    public final Watchdog getWatchdog() {
        return this.watchdog;
    }

    public int hashCode() {
        return this.watchdog.hashCode() + ((this.backpressure.hashCode() + ((this.resilience.hashCode() + (this.timeout.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "CloudTransportConfig(timeout=" + this.timeout + ", resilience=" + this.resilience + ", backpressure=" + this.backpressure + ", watchdog=" + this.watchdog + ")";
    }

    public CloudTransportConfig(Timeout timeout, Resilience resilience, Backpressure backpressure, Watchdog watchdog) {
        kotlin.jvm.internal.g.f(timeout, "timeout");
        kotlin.jvm.internal.g.f(resilience, "resilience");
        kotlin.jvm.internal.g.f(backpressure, "backpressure");
        kotlin.jvm.internal.g.f(watchdog, "watchdog");
        this.timeout = timeout;
        this.resilience = resilience;
        this.backpressure = backpressure;
        this.watchdog = watchdog;
    }

    public /* synthetic */ CloudTransportConfig(Timeout timeout, Resilience resilience, Backpressure backpressure, Watchdog watchdog, int i10, kotlin.jvm.internal.e eVar) {
        Timeout timeout2;
        Resilience resilience2;
        Backpressure backpressure2;
        Watchdog watchdog2;
        if ((i10 & 1) != 0) {
            timeout2 = new Timeout(0L, 0L, 0L, 0L, 15, null);
        } else {
            timeout2 = timeout;
        }
        if ((i10 & 2) != 0) {
            resilience2 = new Resilience(0L, 0L, 0L, 0, 0L, 0, 0L, 0L, 0, 511, null);
        } else {
            resilience2 = resilience;
        }
        if ((i10 & 4) != 0) {
            backpressure2 = new Backpressure(0L, 0, 3, null);
        } else {
            backpressure2 = backpressure;
        }
        if ((i10 & 8) != 0) {
            watchdog2 = new Watchdog(0L, 0L, 0L, 0L, 0L, 0L, 0L, 127, null);
        } else {
            watchdog2 = watchdog;
        }
        this(timeout2, resilience2, backpressure2, watchdog2);
    }
}
