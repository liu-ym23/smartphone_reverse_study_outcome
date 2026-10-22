package com.stepos.core.performance.data;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnrichedVerdictKt {
    public static final int getCacheEvictionRetainMb(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getCacheEvictionRetainMb();
    }

    public static final int getCbFailureThreshold(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getCbFailureThreshold();
    }

    public static final long getCbResetTimeoutMs(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getCbResetTimeoutMs();
    }

    public static final long getDeferredReleaseDelayMs(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getDeferredReleaseDelayMs();
    }

    public static final int getDspMaxConcurrent(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getDspMaxConcurrent();
    }

    public static final long getIdleTimeoutMs(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getIdleTimeoutMs();
    }

    public static final int getMaxConcurrent(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getMaxConcurrent();
    }

    public static final boolean getShouldEvictAllIdle(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getShouldEvictAllIdle();
    }

    public static final boolean getSuggestCloudRouting(EnrichedVerdict enrichedVerdict) {
        g.f(enrichedVerdict, "<this>");
        return enrichedVerdict.getGlobal().getSuggestCloudRouting();
    }
}
