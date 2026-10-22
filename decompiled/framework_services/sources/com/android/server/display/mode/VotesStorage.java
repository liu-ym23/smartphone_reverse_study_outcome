package com.android.server.display.mode;

import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class VotesStorage {
    static final int GLOBAL_ID = -1;
    private static final String TAG = "VotesStorage";
    private final Listener mListener;
    private boolean mLoggingEnabled;
    private final Object mStorageLock;
    private final SparseArray<SparseArray<Vote>> mVotesByDisplay;
    private final VotesStatsReporter mVotesStatsReporter;

    interface Listener {
        void onChanged();
    }

    VotesStorage(Listener listener, VotesStatsReporter votesStatsReporter) {
        this.mStorageLock = new Object();
        this.mVotesByDisplay = new SparseArray();
        this.mListener = listener;
        this.mVotesStatsReporter = votesStatsReporter;
    }

    void setLoggingEnabled(boolean loggingEnabled) {
        this.mLoggingEnabled = loggingEnabled;
    }

    SparseArray<Vote> getVotes(int displayId) {
        Object r0 = this.mStorageLock;
        monitor-enter(r0);
        SparseArray<Vote> displayVotes = this.mVotesByDisplay.get(displayId);     // Catch: Throwable -> L7
        if (displayVotes == null) goto L9;
        SparseArray<Vote> votesLocal = displayVotes.clone();     // Catch: Throwable -> L7
    L10:
        SparseArray<Vote> globalVotes = this.mVotesByDisplay.get(-1);     // Catch: Throwable -> L7
        if (globalVotes == null) goto L13;
        SparseArray<Vote> globalVotesLocal = globalVotes.clone();     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        int i = 0;
    L18:
        if (i >= globalVotesLocal.size()) goto L24;
        int priority = globalVotesLocal.keyAt(i);
        if (votesLocal.contains(priority) == true) goto L22;
        votesLocal.put(priority, globalVotesLocal.valueAt(i));
    L22:
        i = i + 1;
        goto L18
    L24:
        return votesLocal;
    L13:
        globalVotesLocal = new SparseArray();     // Catch: Throwable -> L7
        goto L15
    L9:
        votesLocal = new SparseArray();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void updateGlobalVote(int priority, Vote vote) {
        updateVote(-1, priority, vote);
    }

    void updateVote(int displayId, int priority, Vote vote) {
        if (this.mLoggingEnabled == false) goto L5;
        Slog.i(TAG, "updateVoteLocked(displayId=" + displayId + ", priority=" + Vote.priorityToString(priority) + ", vote=" + vote + ")");
    L5:
        if (priority >= 0) goto L7;
    L37:
        Slog.w(TAG, "Received a vote with an invalid priority, ignoring: priority=" + Vote.priorityToString(priority) + ", vote=" + vote);
        return;
    L7:
        if (priority > 23) goto L37;
        boolean changed = false;
        Object r1 = this.mStorageLock;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L12:
        if (this.mVotesByDisplay.contains(displayId) == false) goto L16;
        SparseArray<Vote> votes = this.mVotesByDisplay.get(displayId);     // Catch: Throwable -> L14
    L17:
        Vote currentVote = votes.get(priority);     // Catch: Throwable -> L14
        if (vote != null) goto L20;
    L22:
        if (vote != null) goto L25;
        if (currentVote == null) goto L25;
        votes.remove(priority);     // Catch: Throwable -> L14
        changed = true;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (this.mLoggingEnabled == false) goto L29;
        Slog.i(TAG, "Updated votes for display=" + displayId + " votes=" + votes);
    L29:
        if (changed == true) goto L31;
        return;
    L31:
        if (this.mVotesStatsReporter == null) goto L33;
        this.mVotesStatsReporter.reportVoteChanged(displayId, priority, vote);
    L33:
        this.mListener.onChanged();
        return;
    L20:
        if (vote.equals(currentVote) == true) goto L22;
        votes.put(priority, vote);     // Catch: Throwable -> L14
        changed = true;
        goto L25
    L16:
        votes = new SparseArray();     // Catch: Throwable -> L14
        this.mVotesByDisplay.put(displayId, votes);     // Catch: Throwable -> L14
        goto L17
    }

    void removeAllVotesForPriority(int priority) {
        if (this.mLoggingEnabled == false) goto L5;
        Slog.i(TAG, "removeAllVotesForPriority(priority=" + Vote.priorityToString(priority) + ")");
    L5:
        if (priority >= 0) goto L7;
    L35:
        Slog.w(TAG, "Received an invalid priority, ignoring: priority=" + Vote.priorityToString(priority));
        return;
    L7:
        if (priority > 23) goto L35;
        IntArray removedVotesDisplayIds = new IntArray();
        Object r1 = this.mStorageLock;
        monitor-enter(r1);
        int size = this.mVotesByDisplay.size();     // Catch: Throwable -> L16
        int i = 0;
    L12:
        if (i >= size) goto L20;
        SparseArray<Vote> votes = this.mVotesByDisplay.valueAt(i);     // Catch: Throwable -> L16
        if (votes.get(priority) == null) goto L18;
        votes.remove(priority);     // Catch: Throwable -> L16
        removedVotesDisplayIds.add(this.mVotesByDisplay.keyAt(i));     // Catch: Throwable -> L16
    L18:
        i = i + 1;     // Catch: Throwable -> L16
        goto L12
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        if (this.mLoggingEnabled == false) goto L24;
        Slog.i(TAG, "Removed votes with priority=" + priority + " for displays=" + removedVotesDisplayIds);
    L24:
        int removedVotesSize = removedVotesDisplayIds.size();
        if (removedVotesSize > 0) goto L27;
        return;
    L27:
        if (this.mVotesStatsReporter == null) goto L31;
        int i2 = 0;
    L29:
        if (i2 >= removedVotesSize) goto L31;
        this.mVotesStatsReporter.reportVoteChanged(removedVotesDisplayIds.get(i2), priority, null);
        i2 = i2 + 1;
    L31:
        this.mListener.onChanged();
        return;
    L16:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw) {
        SparseArray<SparseArray<Vote>> votesByDisplayLocal = new SparseArray();
        Object r1 = this.mStorageLock;
        monitor-enter(r1);
        int i = 0;
    L30:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mVotesByDisplay.size()) goto L11;
        votesByDisplayLocal.put(this.mVotesByDisplay.keyAt(i), this.mVotesByDisplay.valueAt(i).clone());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L30
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        pw.println("  mVotesByDisplay:");
        int i2 = 0;
    L14:
        if (i2 >= votesByDisplayLocal.size()) goto L27;
        SparseArray<Vote> votes = votesByDisplayLocal.valueAt(i2);
        if (votes.size() == 0) goto L25;
        pw.println("    " + votesByDisplayLocal.keyAt(i2) + ":");
        int p = 23;
    L19:
        if (p < 0) goto L25;
        Vote vote = votes.get(p);
        if (vote == null) goto L24;
        pw.println("      " + Vote.priorityToString(p) + " -> " + vote);
    L24:
        p = p - 1;
    L25:
        i2 = i2 + 1;
        goto L14
    }

    void injectVotesByDisplay(SparseArray<SparseArray<Vote>> votesByDisplay) {
        Object r0 = this.mStorageLock;
        monitor-enter(r0);
        this.mVotesByDisplay.clear();     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= votesByDisplay.size()) goto L11;
        this.mVotesByDisplay.put(votesByDisplay.keyAt(i), votesByDisplay.valueAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
