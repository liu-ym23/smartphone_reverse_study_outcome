package com.android.server.display.mode;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class CombinedVote implements Vote {
    final List<Vote> mVotes;

    /* JADX INFO: renamed from: $r8$lambda$rrga5zG_A-L-8Aik_bKJ2yYPSpk, reason: not valid java name */
    public static /* synthetic */ void m4066$r8$lambda$rrga5zG_AL8Aik_bKJ2yYPSpk(VoteSummary r0, Vote r1) {
        lambda$updateSummary$0(r0, r1);
    }

    CombinedVote(List<Vote> votes) {
        this.mVotes = Collections.unmodifiableList(votes);
    }

    private static /* synthetic */ void lambda$updateSummary$0(VoteSummary summary, Vote vote) {
        vote.updateSummary(summary);
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(final VoteSummary summary) {
        this.mVotes.forEach(new CombinedVote$$ExternalSyntheticLambda0(summary));
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof CombinedVote) == false) goto L9;
        CombinedVote that = (CombinedVote) o;
        return Objects.equals(this.mVotes, that.mVotes);
    L9:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mVotes});
    }

    public String toString() {
        return "CombinedVote{ mVotes=" + this.mVotes + " }";
    }
}
