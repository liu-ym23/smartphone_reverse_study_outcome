package com.android.server.display.mode;

import android.os.Trace;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import com.android.internal.util.FrameworkStatsLog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class VotesStatsReporter {
    private static final int REFRESH_RATE_NOT_LIMITED = 1000;
    private static final String TAG = "VotesStatsReporter";
    private final boolean mIgnoredRenderRate;
    private final SparseIntArray mLastMinPriorityByDisplay;

    VotesStatsReporter(boolean ignoreRenderRate) {
        this.mLastMinPriorityByDisplay = new SparseIntArray();
        this.mIgnoredRenderRate = ignoreRenderRate;
    }

    void reportVoteChanged(int displayId, int priority, Vote vote) {
        if (vote != null) goto L4;
        reportVoteRemoved(displayId, priority);
        return;
    L4:
        reportVoteAdded(displayId, priority, vote);
    }

    private void reportVoteAdded(int displayId, int priority, Vote vote) {
        int maxRefreshRate = getMaxRefreshRate(vote, this.mIgnoredRenderRate);
        Trace.traceCounter(131072, "VotesStatsReporter." + displayId + ":" + Vote.priorityToString(priority), maxRefreshRate);
        FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_MODE_DIRECTOR_VOTE_CHANGED, displayId, priority, 1, maxRefreshRate, -1);
    }

    private void reportVoteRemoved(int displayId, int priority) {
        Trace.traceCounter(131072, "VotesStatsReporter." + displayId + ":" + Vote.priorityToString(priority), -1);
        FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_MODE_DIRECTOR_VOTE_CHANGED, displayId, priority, 3, -1, -1);
    }

    void reportVotesActivated(int displayId, int minPriority, Display.Mode baseMode, SparseArray<Vote> votes) {
        int lastMinPriorityReported = this.mLastMinPriorityByDisplay.get(displayId, 24);
        if (baseMode == null) goto L5;
        int r1 = (int) baseMode.getRefreshRate();
    L6:
        int selectedRefreshRate = r1;
        int priority = 0;
    L8:
        if (priority > 23) goto L25;
        if (priority >= lastMinPriorityReported) goto L12;
        if (priority >= minPriority) goto L12;
        int displayId2 = displayId;
    L23:
        priority = priority + 1;
        displayId = displayId2;
    L12:
        Vote vote = votes.get(priority);
        if (vote != null) goto L15;
        displayId2 = displayId;
        goto L23
    L15:
        if (priority < lastMinPriorityReported) goto L18;
        if (priority >= minPriority) goto L18;
        int maxRefreshRate = getMaxRefreshRate(vote, this.mIgnoredRenderRate);
        displayId2 = displayId;
        FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_MODE_DIRECTOR_VOTE_CHANGED, displayId2, priority, 1, maxRefreshRate, selectedRefreshRate);
    L19:
        if (priority < minPriority) goto L22;
        if (priority >= lastMinPriorityReported) goto L22;
        int maxRefreshRate2 = getMaxRefreshRate(vote, this.mIgnoredRenderRate);
        FrameworkStatsLog.write(FrameworkStatsLog.DISPLAY_MODE_DIRECTOR_VOTE_CHANGED, displayId2, priority, 2, maxRefreshRate2, selectedRefreshRate);
    L22:
        this.mLastMinPriorityByDisplay.put(displayId2, minPriority);
    L18:
        displayId2 = displayId;
        goto L19
    L25:
        return;
    L5:
        r1 = -1;
        goto L6
    }

    private static int getMaxRefreshRate(Vote vote, boolean ignoreRenderRate) {
        int maxRefreshRate = 1000;
        if ((vote instanceof RefreshRateVote.PhysicalVote) == false) goto L5;
        RefreshRateVote.PhysicalVote physicalVote = (RefreshRateVote.PhysicalVote) vote;
        int maxRefreshRate2 = (int) physicalVote.mMaxRefreshRate;
        return maxRefreshRate2;
    L5:
        if (ignoreRenderRate == true) goto L10;
        if ((vote instanceof RefreshRateVote.RenderVote) == false) goto L10;
        RefreshRateVote.RenderVote renderVote = (RefreshRateVote.RenderVote) vote;
        int maxRefreshRate3 = (int) renderVote.mMaxRefreshRate;
        return maxRefreshRate3;
    L10:
        if ((vote instanceof SupportedRefreshRatesVote) == false) goto L17;
        SupportedRefreshRatesVote refreshRatesVote = (SupportedRefreshRatesVote) vote;
        int maxRefreshRate4 = 0;
        Iterator<SupportedRefreshRatesVote.RefreshRates> r2 = refreshRatesVote.mRefreshRates.iterator();
    L13:
        if (r2.hasNext() == false) goto L27;
        SupportedRefreshRatesVote.RefreshRates rr = r2.next();
        maxRefreshRate4 = Math.max(maxRefreshRate4, (int) rr.mPeakRefreshRate);
        goto L13
    L27:
        return maxRefreshRate4;
    L17:
        if ((vote instanceof CombinedVote) == false) goto L26;
        CombinedVote combinedVote = (CombinedVote) vote;
        Iterator<Vote> r3 = combinedVote.mVotes.iterator();
    L20:
        if (r3.hasNext() == false) goto L28;
        Vote subVote = r3.next();
        maxRefreshRate = Math.min(maxRefreshRate, getMaxRefreshRate(subVote, ignoreRenderRate));
        goto L20
    L28:
        return maxRefreshRate;
    L26:
        return 1000;
    }
}
