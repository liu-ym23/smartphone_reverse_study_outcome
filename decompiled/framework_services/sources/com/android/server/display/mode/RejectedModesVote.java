package com.android.server.display.mode;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class RejectedModesVote implements Vote {
    final Set<Integer> mModeIds;

    RejectedModesVote(Set<Integer> modeIds) {
        this.mModeIds = Collections.unmodifiableSet(modeIds);
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(VoteSummary summary) {
        summary.rejectedModeIds.addAll(this.mModeIds);
    }

    public String toString() {
        return "RejectedModesVote{ mModeIds=" + this.mModeIds + " }";
    }
}
