package com.android.server.display.mode;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class RequestedRefreshRateVote implements Vote {
    final float mRefreshRate;

    RequestedRefreshRateVote(float refreshRate) {
        this.mRefreshRate = refreshRate;
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(VoteSummary summary) {
        summary.requestedRefreshRates.add(Float.valueOf(this.mRefreshRate));
    }

    public String toString() {
        return "RequestedRefreshRateVote{ refreshRate=" + this.mRefreshRate + " }";
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof RequestedRefreshRateVote) == false) goto L12;
        RequestedRefreshRateVote that = (RequestedRefreshRateVote) o;
        if (Float.compare(this.mRefreshRate, that.mRefreshRate) != 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Float.valueOf(this.mRefreshRate)});
    }
}
