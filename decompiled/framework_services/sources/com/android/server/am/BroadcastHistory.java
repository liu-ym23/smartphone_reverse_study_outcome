package com.android.server.am;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.server.slice.SliceClientPermissions;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastHistory {
    private final int MAX_BROADCAST_HISTORY;
    private final int MAX_BROADCAST_SUMMARY_HISTORY;
    final BroadcastRecord[] mBroadcastHistory;
    final Intent[] mBroadcastSummaryHistory;
    private final ArrayList<BroadcastRecord> mFrozenBroadcasts;
    int mHistoryNext;
    private final SparseArray<ArrayMap<String, Integer>> mPendingBroadcastCountsPerUid;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    final long[] mSummaryHistoryDispatchTime;
    final long[] mSummaryHistoryEnqueueTime;
    final long[] mSummaryHistoryFinishTime;
    int mSummaryHistoryNext;

    public BroadcastHistory(BroadcastConstants constants) {
        this.mFrozenBroadcasts = new ArrayList();
        this.mPendingBroadcasts = new ArrayList();
        this.mHistoryNext = 0;
        this.mSummaryHistoryNext = 0;
        this.mPendingBroadcastCountsPerUid = new SparseArray();
        this.MAX_BROADCAST_HISTORY = constants.MAX_HISTORY_COMPLETE_SIZE;
        this.MAX_BROADCAST_SUMMARY_HISTORY = constants.MAX_HISTORY_SUMMARY_SIZE;
        this.mBroadcastHistory = new BroadcastRecord[this.MAX_BROADCAST_HISTORY];
        this.mBroadcastSummaryHistory = new Intent[this.MAX_BROADCAST_SUMMARY_HISTORY];
        this.mSummaryHistoryEnqueueTime = new long[this.MAX_BROADCAST_SUMMARY_HISTORY];
        this.mSummaryHistoryDispatchTime = new long[this.MAX_BROADCAST_SUMMARY_HISTORY];
        this.mSummaryHistoryFinishTime = new long[this.MAX_BROADCAST_SUMMARY_HISTORY];
    }

    void onBroadcastFrozenLocked(BroadcastRecord r) {
        this.mFrozenBroadcasts.add(r);
    }

    void onBroadcastEnqueuedLocked(BroadcastRecord r) {
        this.mFrozenBroadcasts.remove(r);
        if (this.mPendingBroadcasts.add(r) == false) goto L6;
        updatePendingBroadcastCounterAndLogToTrace(r, 1);
        return;
    }

    void onBroadcastFinishedLocked(BroadcastRecord r) {
        if (this.mPendingBroadcasts.remove(r) == false) goto L5;
        updatePendingBroadcastCounterAndLogToTrace(r, -1);
    L5:
        addBroadcastToHistoryLocked(r);
    }

    private void updatePendingBroadcastCounterAndLogToTrace(BroadcastRecord r, int delta) {
        ArrayMap<String, Integer> pendingBroadcastCounts = this.mPendingBroadcastCountsPerUid.get(r.callingUid);
        if (pendingBroadcastCounts != null) goto L6;
        pendingBroadcastCounts = new ArrayMap();
        this.mPendingBroadcastCountsPerUid.put(r.callingUid, pendingBroadcastCounts);
    L6:
        if (r.callerPackage != null) goto L8;
        String callerPackage = "null";
    L9:
        Integer currentCount = pendingBroadcastCounts.get(callerPackage);
        if (currentCount != null) goto L12;
        int r3 = 0;
    L13:
        int newCount = r3 + delta;
        if (newCount != 0) goto L18;
        pendingBroadcastCounts.remove(callerPackage);
        if (pendingBroadcastCounts.isEmpty() == false) goto L19;
        this.mPendingBroadcastCountsPerUid.remove(r.callingUid);
    L19:
        Trace.instantForTrack(64, "Broadcasts pending per uid", callerPackage + SliceClientPermissions.SliceAuthority.DELIMITER + r.callingUid + ":" + newCount);
        Trace.traceCounter(64, "Broadcasts pending", this.mPendingBroadcasts.size());
        return;
    L18:
        pendingBroadcastCounts.put(callerPackage, Integer.valueOf(newCount));
        goto L19
    L12:
        r3 = currentCount.intValue();
        goto L13
    L8:
        callerPackage = r.callerPackage;
        goto L9
    }

    public void addBroadcastToHistoryLocked(BroadcastRecord original) {
        BroadcastRecord historyRecord = original.maybeStripForHistory();
        this.mBroadcastHistory[this.mHistoryNext] = historyRecord;
        this.mHistoryNext = ringAdvance(this.mHistoryNext, 1, this.MAX_BROADCAST_HISTORY);
        this.mBroadcastSummaryHistory[this.mSummaryHistoryNext] = historyRecord.intent;
        this.mSummaryHistoryEnqueueTime[this.mSummaryHistoryNext] = historyRecord.enqueueClockTime;
        this.mSummaryHistoryDispatchTime[this.mSummaryHistoryNext] = historyRecord.dispatchClockTime;
        this.mSummaryHistoryFinishTime[this.mSummaryHistoryNext] = System.currentTimeMillis();
        this.mSummaryHistoryNext = ringAdvance(this.mSummaryHistoryNext, 1, this.MAX_BROADCAST_SUMMARY_HISTORY);
    }

    private int ringAdvance(int x, int increment, int ringSize) {
        int x2 = x + increment;
        if (x2 < 0) goto L5;
        if (x2 < ringSize) goto L9;
        return 0;
    L9:
        return x2;
    L5:
        return ringSize - 1;
    }

    @NeverCompile
    public void dumpDebug(ProtoOutputStream proto) {
        int i = 0;
    L4:
        if (i >= this.mPendingBroadcasts.size()) goto L6;
        this.mPendingBroadcasts.get(i).dumpDebug(proto, 2246267895815L);
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= this.mFrozenBroadcasts.size()) goto L10;
        this.mFrozenBroadcasts.get(i2).dumpDebug(proto, 2246267895816L);
        i2 = i2 + 1;
        goto L8
    L10:
        int i3 = this.mHistoryNext;
        int ringIndex = i3;
    L11:
        ringIndex = ringAdvance(ringIndex, -1, this.MAX_BROADCAST_HISTORY);
        BroadcastRecord r = this.mBroadcastHistory[ringIndex];
        if (r == null) goto L14;
        r.dumpDebug(proto, 2246267895813L);
    L14:
        if (ringIndex != i3) goto L11;
        int lastIndex = this.mSummaryHistoryNext;
        int ringIndex2 = lastIndex;
    L16:
        ringIndex2 = ringAdvance(ringIndex2, -1, this.MAX_BROADCAST_SUMMARY_HISTORY);
        Intent intent = this.mBroadcastSummaryHistory[ringIndex2];
        if (intent != null) goto L19;
        ProtoOutputStream proto2 = proto;
    L20:
        if (ringIndex2 == lastIndex) goto L21;
        proto = proto2;
        goto L16
    L21:
        return;
    L19:
        long summaryToken = proto.start(2246267895814L);
        proto2 = proto;
        intent.dumpDebug(proto2, 1146756268033L, false, true, true, false);
        proto2.write(1112396529666L, this.mSummaryHistoryEnqueueTime[ringIndex2]);
        proto2.write(1112396529667L, this.mSummaryHistoryDispatchTime[ringIndex2]);
        proto2.write(1112396529668L, this.mSummaryHistoryFinishTime[ringIndex2]);
        proto2.end(summaryToken);
        goto L20
    }

    @NeverCompile
    public boolean dumpLocked(PrintWriter pw, String dumpPackage, String dumpIntentAction, SimpleDateFormat sdf, boolean dumpAll) {
        boolean needSep = true;
        String r4 = dumpIntentAction;
        dumpBroadcastList(pw, sdf, this.mFrozenBroadcasts, r4, dumpAll, "Frozen");
        dumpBroadcastList(pw, sdf, this.mPendingBroadcasts, r4, dumpAll, "Pending");
        boolean printed = false;
        int i = -1;
        int lastIndex = this.mHistoryNext;
        int ringIndex = lastIndex;
    L3:
        ringIndex = ringAdvance(ringIndex, -1, this.MAX_BROADCAST_HISTORY);
        BroadcastRecord r = this.mBroadcastHistory[ringIndex];
        String r11 = "    ";
        if (r == null) goto L36;
        i = i + 1;
        if (dumpPackage != null) goto L9;
    L11:
        if (r4 != null) goto L13;
    L15:
        if (printed == true) goto L19;
        if (needSep == false) goto L18;
        pw.println();
    L18:
        needSep = true;
        pw.println("  Historical broadcasts:");
        printed = true;
    L19:
        boolean printed2 = printed;
        if (r4 == null) goto L24;
        pw.print("  Historical Broadcast #");
        pw.print(i);
        pw.println(":");
        r.dump(pw, "    ", sdf);
        if (dumpAll == false) goto L23;
    L34:
        printed = printed2;
        goto L36
    L23:
        printed = printed2;
    L37:
        if (dumpPackage != null) goto L67;
        if (dumpIntentAction != null) goto L67;
        int lastIndex2 = this.mSummaryHistoryNext;
        int ringIndex2 = lastIndex2;
        if (dumpAll == false) goto L42;
        printed = false;
        i = -1;
    L49:
        int j = this.MAX_BROADCAST_SUMMARY_HISTORY;
        ringIndex2 = ringAdvance(ringIndex2, -1, j);
        Intent intent = this.mBroadcastSummaryHistory[ringIndex2];
        if (intent == null) goto L64;
        if (printed == true) goto L56;
        if (needSep == false) goto L55;
        pw.println();
    L55:
        needSep = true;
        pw.println("  Historical broadcasts summary:");
        printed = true;
    L56:
        if (dumpAll == false) goto L58;
    L60:
        i = i + 1;
        pw.print("  #");
        pw.print(i);
        pw.print(": ");
        boolean printed3 = printed;
        pw.println(intent.toShortString(false, true, true, false));
        pw.print(r11);
        TimeUtils.formatDuration(this.mSummaryHistoryDispatchTime[ringIndex2] - this.mSummaryHistoryEnqueueTime[ringIndex2], pw);
        pw.print(" dispatch ");
        TimeUtils.formatDuration(this.mSummaryHistoryFinishTime[ringIndex2] - this.mSummaryHistoryDispatchTime[ringIndex2], pw);
        pw.println(" finish");
        pw.print("    enq=");
        pw.print(sdf.format(new Date(this.mSummaryHistoryEnqueueTime[ringIndex2])));
        pw.print(" disp=");
        pw.print(sdf.format(new Date(this.mSummaryHistoryDispatchTime[ringIndex2])));
        pw.print(" fin=");
        pw.println(sdf.format(new Date(this.mSummaryHistoryFinishTime[ringIndex2])));
        Bundle bundle = intent.getExtras();
        if (bundle == null) goto L63;
        pw.print("    extras: ");
        pw.println(bundle.toString());
    L63:
        printed = printed3;
        goto L64
    L58:
        if (i < 50) goto L60;
        pw.println("  ...");
    L64:
        if (ringIndex2 == lastIndex2) goto L67;
        r11 = r11;
        goto L49
    L42:
        int j2 = i;
    L43:
        if (j2 <= 0) goto L49;
        if (ringIndex2 == lastIndex2) goto L49;
        ringIndex2 = ringAdvance(ringIndex2, -1, this.MAX_BROADCAST_SUMMARY_HISTORY);
        if (this.mBroadcastHistory[ringIndex2] == null) goto L43;
        j2 = j2 - 1;
    L67:
        return needSep;
    L24:
        if (dumpAll == false) goto L26;
        pw.print("  Historical Broadcast #");
        pw.print(i);
        pw.println(":");
        r.dump(pw, "    ", sdf);
        goto L34
    L26:
        pw.print("  #");
        pw.print(i);
        pw.print(": ");
        pw.println(r);
        pw.print("    ");
        pw.println(r.intent.toShortString(false, true, true, false));
        if (r.targetComp != null) goto L29;
    L31:
        Bundle bundle2 = r.intent.getExtras();
        if (bundle2 == null) goto L34;
        pw.print("    extras: ");
        pw.println(bundle2.toString());
        goto L34
    L29:
        if (r.targetComp == r.intent.getComponent()) goto L31;
        pw.print("    targetComp: ");
        pw.println(r.targetComp.toShortString());
        goto L31
    L13:
        if (Objects.equals(r4, r.intent.getAction()) == true) goto L15;
    L9:
        if (dumpPackage.equals(r.callerPackage) == true) goto L11;
    L36:
        if (ringIndex == lastIndex) goto L37;
        r4 = dumpIntentAction;
        goto L3
    }

    private void dumpBroadcastList(PrintWriter pw, SimpleDateFormat sdf, ArrayList<BroadcastRecord> broadcasts, String dumpIntentAction, boolean dumpAll, String flavor) {
        pw.print("  ");
        pw.print(flavor);
        pw.println(" broadcasts:");
        if (broadcasts.isEmpty() == false) goto L5;
        pw.println("    <empty>");
        return;
    L5:
        boolean printedAnything = false;
        int idx = broadcasts.size() - 1;
    L6:
        if (idx < 0) goto L17;
        BroadcastRecord r = broadcasts.get(idx);
        if (dumpIntentAction != null) goto L10;
    L12:
        pw.print(flavor);
        pw.print("  broadcast #");
        pw.print(idx);
        pw.println(":");
        r.dump(pw, "    ", sdf);
        printedAnything = true;
        if (dumpIntentAction == null) goto L16;
        if (dumpAll == false) goto L17;
    L16:
        idx = idx - 1;
        goto L6
    L10:
        if (Objects.equals(dumpIntentAction, r.intent.getAction()) == true) goto L12;
    L17:
        if (printedAnything == true) goto L26;
        pw.println("    <no-matches>");
        return;
    }
}
