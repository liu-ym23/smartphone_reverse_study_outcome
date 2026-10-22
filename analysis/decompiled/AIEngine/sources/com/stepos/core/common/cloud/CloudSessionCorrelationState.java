package com.stepos.core.common.cloud;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import gc.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudSessionCorrelationState {
    private final String asyncTaskId;
    private final String clientDebugTraceId;
    private final String cloudCorrelationId;
    private final long connectToOpenMs;
    private final int connectionGeneration;
    private final String gatewayTraceId;
    private final long handshakeAckToReadyMs;
    private final long headerFetchMs;
    private final long openToHandshakeAckMs;
    private final CloudCorrelationSource source;

    public CloudSessionCorrelationState() {
        this(null, null, null, null, 0, null, 0L, 0L, 0L, 0L, 1023, null);
    }

    public final String component1() {
        return this.cloudCorrelationId;
    }

    public final long component10() {
        return this.handshakeAckToReadyMs;
    }

    public final CloudCorrelationSource component2() {
        return this.source;
    }

    public final String component3() {
        return this.clientDebugTraceId;
    }

    public final String component4() {
        return this.gatewayTraceId;
    }

    public final int component5() {
        return this.connectionGeneration;
    }

    public final String component6() {
        return this.asyncTaskId;
    }

    public final long component7() {
        return this.headerFetchMs;
    }

    public final long component8() {
        return this.connectToOpenMs;
    }

    public final long component9() {
        return this.openToHandshakeAckMs;
    }

    public final CloudSessionCorrelationState copy(String cloudCorrelationId, CloudCorrelationSource cloudCorrelationSource, String clientDebugTraceId, String gatewayTraceId, int i10, String asyncTaskId, long j10, long j11, long j12, long j13) {
        kotlin.jvm.internal.g.f(cloudCorrelationId, "cloudCorrelationId");
        kotlin.jvm.internal.g.f(clientDebugTraceId, "clientDebugTraceId");
        kotlin.jvm.internal.g.f(gatewayTraceId, "gatewayTraceId");
        kotlin.jvm.internal.g.f(asyncTaskId, "asyncTaskId");
        return new CloudSessionCorrelationState(cloudCorrelationId, cloudCorrelationSource, clientDebugTraceId, gatewayTraceId, i10, asyncTaskId, j10, j11, j12, j13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudSessionCorrelationState)) {
            return false;
        }
        CloudSessionCorrelationState cloudSessionCorrelationState = (CloudSessionCorrelationState) obj;
        return kotlin.jvm.internal.g.b(this.cloudCorrelationId, cloudSessionCorrelationState.cloudCorrelationId) && this.source == cloudSessionCorrelationState.source && kotlin.jvm.internal.g.b(this.clientDebugTraceId, cloudSessionCorrelationState.clientDebugTraceId) && kotlin.jvm.internal.g.b(this.gatewayTraceId, cloudSessionCorrelationState.gatewayTraceId) && this.connectionGeneration == cloudSessionCorrelationState.connectionGeneration && kotlin.jvm.internal.g.b(this.asyncTaskId, cloudSessionCorrelationState.asyncTaskId) && this.headerFetchMs == cloudSessionCorrelationState.headerFetchMs && this.connectToOpenMs == cloudSessionCorrelationState.connectToOpenMs && this.openToHandshakeAckMs == cloudSessionCorrelationState.openToHandshakeAckMs && this.handshakeAckToReadyMs == cloudSessionCorrelationState.handshakeAckToReadyMs;
    }

    public final String getAsyncTaskId() {
        return this.asyncTaskId;
    }

    public final String getClientDebugTraceId() {
        return this.clientDebugTraceId;
    }

    public final String getCloudCorrelationId() {
        return this.cloudCorrelationId;
    }

    public final long getConnectToOpenMs() {
        return this.connectToOpenMs;
    }

    public final int getConnectionGeneration() {
        return this.connectionGeneration;
    }

    public final String getGatewayTraceId() {
        return this.gatewayTraceId;
    }

    public final long getHandshakeAckToReadyMs() {
        return this.handshakeAckToReadyMs;
    }

    public final long getHeaderFetchMs() {
        return this.headerFetchMs;
    }

    public final long getOpenToHandshakeAckMs() {
        return this.openToHandshakeAckMs;
    }

    public final CloudCorrelationSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int iHashCode = this.cloudCorrelationId.hashCode() * 31;
        CloudCorrelationSource cloudCorrelationSource = this.source;
        return Long.hashCode(this.handshakeAckToReadyMs) + a0.a.c(a0.a.c(a0.a.c(v1.d.a(ai.onnxruntime.a.d(this.connectionGeneration, v1.d.a(v1.d.a((iHashCode + (cloudCorrelationSource == null ? 0 : cloudCorrelationSource.hashCode())) * 31, 31, this.clientDebugTraceId), 31, this.gatewayTraceId), 31), 31, this.asyncTaskId), this.headerFetchMs, 31), this.connectToOpenMs, 31), this.openToHandshakeAckMs, 31);
    }

    public final CloudSessionCorrelationState mergedWith(CloudSessionCorrelationState incoming) {
        kotlin.jvm.internal.g.f(incoming, "incoming");
        String str = incoming.cloudCorrelationId;
        if (q.t0(str)) {
            str = this.cloudCorrelationId;
        }
        CloudCorrelationSource cloudCorrelationSource = incoming.source;
        if (cloudCorrelationSource == null) {
            cloudCorrelationSource = this.source;
        }
        String str2 = incoming.clientDebugTraceId;
        if (q.t0(str2)) {
            str2 = this.clientDebugTraceId;
        }
        String str3 = incoming.gatewayTraceId;
        if (q.t0(str3)) {
            str3 = this.gatewayTraceId;
        }
        int i10 = incoming.connectionGeneration;
        if (i10 == 0) {
            i10 = this.connectionGeneration;
        }
        String str4 = incoming.asyncTaskId;
        if (q.t0(str4)) {
            str4 = this.asyncTaskId;
        }
        Long lValueOf = Long.valueOf(incoming.headerFetchMs);
        if (lValueOf.longValue() < 0) {
            lValueOf = null;
        }
        long jLongValue = lValueOf != null ? lValueOf.longValue() : this.headerFetchMs;
        Long lValueOf2 = Long.valueOf(incoming.connectToOpenMs);
        if (lValueOf2.longValue() < 0) {
            lValueOf2 = null;
        }
        long jLongValue2 = lValueOf2 != null ? lValueOf2.longValue() : this.connectToOpenMs;
        Long lValueOf3 = Long.valueOf(incoming.openToHandshakeAckMs);
        if (lValueOf3.longValue() < 0) {
            lValueOf3 = null;
        }
        long jLongValue3 = lValueOf3 != null ? lValueOf3.longValue() : this.openToHandshakeAckMs;
        long j10 = jLongValue2;
        Long lValueOf4 = Long.valueOf(incoming.handshakeAckToReadyMs);
        Long l10 = lValueOf4.longValue() >= 0 ? lValueOf4 : null;
        return copy(str, cloudCorrelationSource, str2, str3, i10, str4, jLongValue, j10, jLongValue3, l10 != null ? l10.longValue() : this.handshakeAckToReadyMs);
    }

    public String toString() {
        String str = this.cloudCorrelationId;
        CloudCorrelationSource cloudCorrelationSource = this.source;
        String str2 = this.clientDebugTraceId;
        String str3 = this.gatewayTraceId;
        int i10 = this.connectionGeneration;
        String str4 = this.asyncTaskId;
        long j10 = this.headerFetchMs;
        long j11 = this.connectToOpenMs;
        long j12 = this.openToHandshakeAckMs;
        long j13 = this.handshakeAckToReadyMs;
        StringBuilder sb2 = new StringBuilder("CloudSessionCorrelationState(cloudCorrelationId=");
        sb2.append(str);
        sb2.append(", source=");
        sb2.append(cloudCorrelationSource);
        sb2.append(", clientDebugTraceId=");
        ai.onnxruntime.a.z(sb2, str2, ", gatewayTraceId=", str3, ", connectionGeneration=");
        h0.e.h(i10, ", asyncTaskId=", str4, ", headerFetchMs=", sb2);
        sb2.append(j10);
        a0.a.s(j11, ", connectToOpenMs=", ", openToHandshakeAckMs=", sb2);
        sb2.append(j12);
        return a0.a.d(j13, ", handshakeAckToReadyMs=", ")", sb2);
    }

    public CloudSessionCorrelationState(String cloudCorrelationId, CloudCorrelationSource cloudCorrelationSource, String clientDebugTraceId, String gatewayTraceId, int i10, String asyncTaskId, long j10, long j11, long j12, long j13) {
        kotlin.jvm.internal.g.f(cloudCorrelationId, "cloudCorrelationId");
        kotlin.jvm.internal.g.f(clientDebugTraceId, "clientDebugTraceId");
        kotlin.jvm.internal.g.f(gatewayTraceId, "gatewayTraceId");
        kotlin.jvm.internal.g.f(asyncTaskId, "asyncTaskId");
        this.cloudCorrelationId = cloudCorrelationId;
        this.source = cloudCorrelationSource;
        this.clientDebugTraceId = clientDebugTraceId;
        this.gatewayTraceId = gatewayTraceId;
        this.connectionGeneration = i10;
        this.asyncTaskId = asyncTaskId;
        this.headerFetchMs = j10;
        this.connectToOpenMs = j11;
        this.openToHandshakeAckMs = j12;
        this.handshakeAckToReadyMs = j13;
    }

    public /* synthetic */ CloudSessionCorrelationState(String str, CloudCorrelationSource cloudCorrelationSource, String str2, String str3, int i10, String str4, long j10, long j11, long j12, long j13, int i11, kotlin.jvm.internal.e eVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? null : cloudCorrelationSource, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? "" : str3, (i11 & 16) != 0 ? 0 : i10, (i11 & 32) == 0 ? str4 : "", (i11 & 64) != 0 ? -1L : j10, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? -1L : j11, (i11 & 256) != 0 ? -1L : j12, (i11 & VadSessionManager.FRAME_BYTES) != 0 ? -1L : j13);
    }
}
