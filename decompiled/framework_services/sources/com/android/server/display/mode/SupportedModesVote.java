package com.android.server.display.mode;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SupportedModesVote implements Vote {
    final List<Integer> mModeIds;

    SupportedModesVote(List<Integer> modeIds) {
        this.mModeIds = Collections.unmodifiableList(modeIds);
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(VoteSummary summary) {
        if (summary.supportedModeIds != null) goto L5;
        summary.supportedModeIds = this.mModeIds;
        return;
    L5:
        summary.supportedModeIds.retainAll(this.mModeIds);
    }

    public String toString() {
        return "SupportedModesVote{ mModeIds=" + this.mModeIds + " }";
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof SupportedModesVote) == false) goto L9;
        SupportedModesVote that = (SupportedModesVote) o;
        return this.mModeIds.equals(that.mModeIds);
    L9:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mModeIds});
    }
}
