package com.android.server.display.mode;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class SizeVote implements Vote {
    final int mHeight;
    final int mMinHeight;
    final int mMinWidth;
    final int mWidth;

    SizeVote(int width, int height, int minWidth, int minHeight) {
        this.mWidth = width;
        this.mHeight = height;
        this.mMinWidth = minWidth;
        this.mMinHeight = minHeight;
    }

    @Override // com.android.server.display.mode.Vote
    public void updateSummary(VoteSummary summary) {
        if (this.mHeight > 0) goto L5;
        return;
    L5:
        if (this.mWidth > 0) goto L7;
        return;
    L7:
        if (summary.width != (-1)) goto L12;
        if (summary.height != (-1)) goto L12;
        summary.width = this.mWidth;
        summary.height = this.mHeight;
        summary.minWidth = this.mMinWidth;
        summary.minHeight = this.mMinHeight;
        return;
    L12:
        if (summary.mIsDisplayResolutionRangeVotingEnabled == false) goto L18;
        summary.width = Math.min(summary.width, this.mWidth);
        summary.height = Math.min(summary.height, this.mHeight);
        summary.minWidth = Math.max(summary.minWidth, this.mMinWidth);
        summary.minHeight = Math.max(summary.minHeight, this.mMinHeight);
        return;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof SizeVote) == false) goto L18;
        SizeVote sizeVote = (SizeVote) o;
        if (this.mWidth != sizeVote.mWidth) goto L17;
        if (this.mHeight != sizeVote.mHeight) goto L17;
        if (this.mMinWidth != sizeVote.mMinWidth) goto L17;
        if (this.mMinHeight != sizeVote.mMinHeight) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mMinWidth), Integer.valueOf(this.mMinHeight)});
    }

    public String toString() {
        return "SizeVote{ mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mMinWidth=" + this.mMinWidth + ", mMinHeight=" + this.mMinHeight + " }";
    }
}
