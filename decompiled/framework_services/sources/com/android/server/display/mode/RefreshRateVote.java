package com.android.server.display.mode;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
abstract class RefreshRateVote implements Vote {
    final float mMaxRefreshRate;
    final float mMinRefreshRate;

    static class PhysicalVote extends RefreshRateVote {
        PhysicalVote(float minRefreshRate, float maxRefreshRate) {
            super(minRefreshRate, maxRefreshRate);
        }

        @Override // com.android.server.display.mode.Vote
        public void updateSummary(VoteSummary summary) {
            summary.minPhysicalRefreshRate = Math.max(summary.minPhysicalRefreshRate, this.mMinRefreshRate);
            summary.maxPhysicalRefreshRate = Math.min(summary.maxPhysicalRefreshRate, this.mMaxRefreshRate);
            summary.maxRenderFrameRate = Math.min(summary.maxRenderFrameRate, this.mMaxRefreshRate);
        }

        @Override // com.android.server.display.mode.RefreshRateVote
        public boolean equals(Object o) {
            if ((o instanceof PhysicalVote) == true) goto L7;
            return false;
        L7:
            return super.equals(o);
        }

        @Override // com.android.server.display.mode.RefreshRateVote
        public String toString() {
            return "PhysicalVote{ " + super.toString() + " }";
        }
    }

    static class RenderVote extends RefreshRateVote {
        RenderVote(float minRefreshRate, float maxRefreshRate) {
            super(minRefreshRate, maxRefreshRate);
        }

        @Override // com.android.server.display.mode.Vote
        public void updateSummary(VoteSummary summary) {
            summary.minRenderFrameRate = Math.max(summary.minRenderFrameRate, this.mMinRefreshRate);
            summary.maxRenderFrameRate = Math.min(summary.maxRenderFrameRate, this.mMaxRefreshRate);
            summary.minPhysicalRefreshRate = Math.max(summary.minPhysicalRefreshRate, this.mMinRefreshRate);
        }

        @Override // com.android.server.display.mode.RefreshRateVote
        public boolean equals(Object o) {
            if ((o instanceof RenderVote) == true) goto L7;
            return false;
        L7:
            return super.equals(o);
        }

        @Override // com.android.server.display.mode.RefreshRateVote
        public String toString() {
            return "RenderVote{ " + super.toString() + " }";
        }
    }

    RefreshRateVote(float minRefreshRate, float maxRefreshRate) {
        this.mMinRefreshRate = minRefreshRate;
        this.mMaxRefreshRate = maxRefreshRate;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof RefreshRateVote) == false) goto L14;
        RefreshRateVote that = (RefreshRateVote) o;
        if (Float.compare(that.mMinRefreshRate, this.mMinRefreshRate) != 0) goto L13;
        if (Float.compare(that.mMaxRefreshRate, this.mMaxRefreshRate) != 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Float.valueOf(this.mMinRefreshRate), Float.valueOf(this.mMaxRefreshRate)});
    }

    public String toString() {
        return "RefreshRateVote{  mMinRefreshRate=" + this.mMinRefreshRate + ", mMaxRefreshRate=" + this.mMaxRefreshRate + " }";
    }
}
