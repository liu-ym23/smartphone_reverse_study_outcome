package com.android.server.display.mode;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class BaseModeRefreshRateVote implements Vote {
    final float mAppRequestBaseModeRefreshRate;

    BaseModeRefreshRateVote(float baseModeRefreshRate) {
        this.mAppRequestBaseModeRefreshRate = baseModeRefreshRate;
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(VoteSummary summary) {
        if (summary.appRequestBaseModeRefreshRate == 0.0f) goto L5;
        return;
    L5:
        if (this.mAppRequestBaseModeRefreshRate <= 0.0f) goto L9;
        summary.appRequestBaseModeRefreshRate = this.mAppRequestBaseModeRefreshRate;
        return;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof BaseModeRefreshRateVote) == false) goto L12;
        BaseModeRefreshRateVote that = (BaseModeRefreshRateVote) o;
        if (Float.compare(that.mAppRequestBaseModeRefreshRate, this.mAppRequestBaseModeRefreshRate) != 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Float.valueOf(this.mAppRequestBaseModeRefreshRate)});
    }

    public String toString() {
        return "BaseModeRefreshRateVote{ mAppRequestBaseModeRefreshRate=" + this.mAppRequestBaseModeRefreshRate + " }";
    }
}
