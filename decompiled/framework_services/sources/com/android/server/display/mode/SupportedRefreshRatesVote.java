package com.android.server.display.mode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class SupportedRefreshRatesVote implements Vote {
    final List<RefreshRates> mRefreshRates;

    static class RefreshRates {
        final float mPeakRefreshRate;
        final float mVsyncRate;

        RefreshRates(float peakRefreshRate, float vsyncRate) {
            this.mPeakRefreshRate = peakRefreshRate;
            this.mVsyncRate = vsyncRate;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof RefreshRates) == false) goto L14;
            RefreshRates that = (RefreshRates) o;
            if (Float.compare(that.mPeakRefreshRate, this.mPeakRefreshRate) != 0) goto L13;
            if (Float.compare(that.mVsyncRate, this.mVsyncRate) != 0) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Float.valueOf(this.mPeakRefreshRate), Float.valueOf(this.mVsyncRate)});
        }

        public String toString() {
            return "RefreshRates{ mPeakRefreshRate=" + this.mPeakRefreshRate + ", mVsyncRate=" + this.mVsyncRate + " }";
        }
    }

    SupportedRefreshRatesVote(List<RefreshRates> refreshRates) {
        this.mRefreshRates = Collections.unmodifiableList(refreshRates);
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(VoteSummary summary) {
        if (summary.supportedRefreshRates != null) goto L5;
        summary.supportedRefreshRates = new ArrayList(this.mRefreshRates);
        return;
    L5:
        summary.supportedRefreshRates.retainAll(this.mRefreshRates);
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof SupportedRefreshRatesVote) == false) goto L9;
        SupportedRefreshRatesVote that = (SupportedRefreshRatesVote) o;
        return this.mRefreshRates.equals(that.mRefreshRates);
    L9:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mRefreshRates});
    }

    public String toString() {
        return "SupportedRefreshRatesVote{ mSupportedModes=" + this.mRefreshRates + " }";
    }
}
