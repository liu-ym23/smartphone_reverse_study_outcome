package com.stepos.core.performance.data;

import a0.a;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ota.d;
import h0.e;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnrichedVerdict {
    private final int batchSize;
    private final GlobalVerdict global;
    private final int maxTokens;
    private final List<VerdictReason> perRequestReasons;
    private final BackendType recommendedBackend;
    private final int threadCount;
    private final long timeoutMs;

    public EnrichedVerdict(GlobalVerdict global, BackendType recommendedBackend, int i10, int i11, int i12, long j10, List<VerdictReason> perRequestReasons) {
        g.f(global, "global");
        g.f(recommendedBackend, "recommendedBackend");
        g.f(perRequestReasons, "perRequestReasons");
        this.global = global;
        this.recommendedBackend = recommendedBackend;
        this.threadCount = i10;
        this.batchSize = i11;
        this.maxTokens = i12;
        this.timeoutMs = j10;
        this.perRequestReasons = perRequestReasons;
    }

    public static /* synthetic */ EnrichedVerdict copy$default(EnrichedVerdict enrichedVerdict, GlobalVerdict globalVerdict, BackendType backendType, int i10, int i11, int i12, long j10, List list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            globalVerdict = enrichedVerdict.global;
        }
        if ((i13 & 2) != 0) {
            backendType = enrichedVerdict.recommendedBackend;
        }
        if ((i13 & 4) != 0) {
            i10 = enrichedVerdict.threadCount;
        }
        if ((i13 & 8) != 0) {
            i11 = enrichedVerdict.batchSize;
        }
        if ((i13 & 16) != 0) {
            i12 = enrichedVerdict.maxTokens;
        }
        if ((i13 & 32) != 0) {
            j10 = enrichedVerdict.timeoutMs;
        }
        if ((i13 & 64) != 0) {
            list = enrichedVerdict.perRequestReasons;
        }
        List list2 = list;
        long j11 = j10;
        int i14 = i12;
        int i15 = i10;
        return enrichedVerdict.copy(globalVerdict, backendType, i15, i11, i14, j11, list2);
    }

    public final GlobalVerdict component1() {
        return this.global;
    }

    public final BackendType component2() {
        return this.recommendedBackend;
    }

    public final int component3() {
        return this.threadCount;
    }

    public final int component4() {
        return this.batchSize;
    }

    public final int component5() {
        return this.maxTokens;
    }

    public final long component6() {
        return this.timeoutMs;
    }

    public final List<VerdictReason> component7() {
        return this.perRequestReasons;
    }

    public final EnrichedVerdict copy(GlobalVerdict global, BackendType recommendedBackend, int i10, int i11, int i12, long j10, List<VerdictReason> perRequestReasons) {
        g.f(global, "global");
        g.f(recommendedBackend, "recommendedBackend");
        g.f(perRequestReasons, "perRequestReasons");
        return new EnrichedVerdict(global, recommendedBackend, i10, i11, i12, j10, perRequestReasons);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnrichedVerdict)) {
            return false;
        }
        EnrichedVerdict enrichedVerdict = (EnrichedVerdict) obj;
        return g.b(this.global, enrichedVerdict.global) && this.recommendedBackend == enrichedVerdict.recommendedBackend && this.threadCount == enrichedVerdict.threadCount && this.batchSize == enrichedVerdict.batchSize && this.maxTokens == enrichedVerdict.maxTokens && this.timeoutMs == enrichedVerdict.timeoutMs && g.b(this.perRequestReasons, enrichedVerdict.perRequestReasons);
    }

    public final int getBatchSize() {
        return this.batchSize;
    }

    public final GlobalVerdict getGlobal() {
        return this.global;
    }

    public final int getMaxTokens() {
        return this.maxTokens;
    }

    public final List<VerdictReason> getPerRequestReasons() {
        return this.perRequestReasons;
    }

    public final BackendType getRecommendedBackend() {
        return this.recommendedBackend;
    }

    public final int getThreadCount() {
        return this.threadCount;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public int hashCode() {
        return this.perRequestReasons.hashCode() + a.c(ai.onnxruntime.a.d(this.maxTokens, ai.onnxruntime.a.d(this.batchSize, ai.onnxruntime.a.d(this.threadCount, (this.recommendedBackend.hashCode() + (this.global.hashCode() * 31)) * 31, 31), 31), 31), this.timeoutMs, 31);
    }

    public String toString() {
        GlobalVerdict globalVerdict = this.global;
        BackendType backendType = this.recommendedBackend;
        int i10 = this.threadCount;
        int i11 = this.batchSize;
        int i12 = this.maxTokens;
        long j10 = this.timeoutMs;
        List<VerdictReason> list = this.perRequestReasons;
        StringBuilder sb2 = new StringBuilder("EnrichedVerdict(global=");
        sb2.append(globalVerdict);
        sb2.append(", recommendedBackend=");
        sb2.append(backendType);
        sb2.append(", threadCount=");
        e.l(sb2, i10, ", batchSize=", i11, ", maxTokens=");
        d.s(sb2, i12, ", timeoutMs=", j10);
        sb2.append(", perRequestReasons=");
        sb2.append(list);
        sb2.append(")");
        return sb2.toString();
    }
}
