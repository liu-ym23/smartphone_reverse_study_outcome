package com.stepos.core.model.resilience;

import a0.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WatchdogStatistics {
    private final int currentWatching;
    private final long totalCancelled;
    private final long totalTimeouts;
    private final long totalWatched;

    public WatchdogStatistics(int i10, long j10, long j11, long j12) {
        this.currentWatching = i10;
        this.totalWatched = j10;
        this.totalTimeouts = j11;
        this.totalCancelled = j12;
    }

    public static /* synthetic */ WatchdogStatistics copy$default(WatchdogStatistics watchdogStatistics, int i10, long j10, long j11, long j12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = watchdogStatistics.currentWatching;
        }
        if ((i11 & 2) != 0) {
            j10 = watchdogStatistics.totalWatched;
        }
        if ((i11 & 4) != 0) {
            j11 = watchdogStatistics.totalTimeouts;
        }
        if ((i11 & 8) != 0) {
            j12 = watchdogStatistics.totalCancelled;
        }
        long j13 = j12;
        return watchdogStatistics.copy(i10, j10, j11, j13);
    }

    public final int component1() {
        return this.currentWatching;
    }

    public final long component2() {
        return this.totalWatched;
    }

    public final long component3() {
        return this.totalTimeouts;
    }

    public final long component4() {
        return this.totalCancelled;
    }

    public final WatchdogStatistics copy(int i10, long j10, long j11, long j12) {
        return new WatchdogStatistics(i10, j10, j11, j12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchdogStatistics)) {
            return false;
        }
        WatchdogStatistics watchdogStatistics = (WatchdogStatistics) obj;
        return this.currentWatching == watchdogStatistics.currentWatching && this.totalWatched == watchdogStatistics.totalWatched && this.totalTimeouts == watchdogStatistics.totalTimeouts && this.totalCancelled == watchdogStatistics.totalCancelled;
    }

    public final int getCurrentWatching() {
        return this.currentWatching;
    }

    public final float getTimeoutRate() {
        long j10 = this.totalWatched;
        if (j10 > 0) {
            return this.totalTimeouts / j10;
        }
        return 0.0f;
    }

    public final long getTotalCancelled() {
        return this.totalCancelled;
    }

    public final long getTotalTimeouts() {
        return this.totalTimeouts;
    }

    public final long getTotalWatched() {
        return this.totalWatched;
    }

    public int hashCode() {
        return Long.hashCode(this.totalCancelled) + a.c(a.c(Integer.hashCode(this.currentWatching) * 31, this.totalWatched, 31), this.totalTimeouts, 31);
    }

    public String toString() {
        int i10 = this.currentWatching;
        long j10 = this.totalWatched;
        long j11 = this.totalTimeouts;
        long j12 = this.totalCancelled;
        StringBuilder sb2 = new StringBuilder("WatchdogStatistics(currentWatching=");
        sb2.append(i10);
        sb2.append(", totalWatched=");
        sb2.append(j10);
        a.s(j11, ", totalTimeouts=", ", totalCancelled=", sb2);
        return ai.onnxruntime.a.m(sb2, j12, ")");
    }
}
