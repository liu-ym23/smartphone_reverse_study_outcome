package com.android.server.display.mode;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class DisableRefreshRateSwitchingVote implements Vote {
    final boolean mDisableRefreshRateSwitching;

    DisableRefreshRateSwitchingVote(boolean disableRefreshRateSwitching) {
        this.mDisableRefreshRateSwitching = disableRefreshRateSwitching;
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(VoteSummary summary) {
        if (summary.disableRefreshRateSwitching == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        summary.disableRefreshRateSwitching = r0;
        return;
    L5:
        if (this.mDisableRefreshRateSwitching == true) goto L8;
        r0 = false;
        goto L9
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof DisableRefreshRateSwitchingVote) == false) goto L12;
        DisableRefreshRateSwitchingVote that = (DisableRefreshRateSwitchingVote) o;
        if (this.mDisableRefreshRateSwitching != that.mDisableRefreshRateSwitching) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mDisableRefreshRateSwitching)});
    }

    public String toString() {
        return "DisableRefreshRateSwitchingVote{ mDisableRefreshRateSwitching=" + this.mDisableRefreshRateSwitching + " }";
    }
}
