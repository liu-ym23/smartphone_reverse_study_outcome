package com.stepos.core.ota.process;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BindAttemptState {
    private boolean binding;
    private long generation;

    public final synchronized boolean claimTimeout(long j10, boolean z) {
        if (!z) {
            if (this.binding) {
                long j11 = this.generation;
                if (j11 == j10) {
                    this.binding = false;
                    this.generation = j11 + 1;
                    return true;
                }
            }
        }
        return false;
    }

    public final synchronized boolean fail(long j10) {
        if (this.binding) {
            long j11 = this.generation;
            if (j11 == j10) {
                this.binding = false;
                this.generation = j11 + 1;
                return true;
            }
        }
        return false;
    }

    public final synchronized void invalidate() {
        this.binding = false;
        this.generation++;
    }

    public final synchronized Long tryBegin(boolean z) {
        if (!z) {
            if (!this.binding) {
                this.binding = true;
                long j10 = this.generation + 1;
                this.generation = j10;
                return Long.valueOf(j10);
            }
        }
        return null;
    }
}
