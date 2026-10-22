package com.stepos.core.ability.speech;

import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrStreamTimelineMapper {
    public static final Companion Companion = new Companion(null);
    private final long bytesPerMs;
    private volatile long sessionBaseBytes;
    private volatile long sessionBaseMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final AsrStreamTimelineMapper forPcm16kMono() {
            return new AsrStreamTimelineMapper(32L);
        }

        private Companion() {
        }
    }

    public AsrStreamTimelineMapper(long j10) {
        this.bytesPerMs = j10;
    }

    private final long pcmBytesToMs(long j10) {
        if (j10 > 0) {
            long j11 = this.bytesPerMs;
            if (j11 > 0) {
                return j10 / j11;
            }
        }
        return 0L;
    }

    public final Pair<Long, Long> globalize(long j10, long j11) {
        return new Pair<>(Long.valueOf(this.sessionBaseMs + j10), Long.valueOf(this.sessionBaseMs + j11));
    }

    public final void onFlushDropped(long j10) {
        if (j10 <= 0) {
            return;
        }
        long j11 = this.sessionBaseBytes + j10;
        this.sessionBaseBytes = j11;
        this.sessionBaseMs = pcmBytesToMs(j11);
    }

    public final void onReconnect(long j10) {
        this.sessionBaseBytes = j10;
        this.sessionBaseMs = pcmBytesToMs(j10);
    }

    public final long sessionBaseMs() {
        return this.sessionBaseMs;
    }
}
