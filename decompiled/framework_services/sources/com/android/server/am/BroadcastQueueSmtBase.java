package com.android.server.am;

import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.util.Slog;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastQueueSmtBase {
    private static final String TAG_BROADCAST_STATISTICS = "BroadcastStatistics";
    private static final AtomicBoolean sBDReceiverStatsEnabled = null;
    private HashMap<String, SenderStats> mAllBroadcastStats;
    private HashMap<BroadcastRecord, BroadcastRecordTimer> mBDRecordTimerHM;
    private BroadcastQueue mQueue;
    final StringBuilder mStringBuilder;

    private class BroadcastRecordTimer {
        String action;
        long endTime;
        String receiver;
        long startTime;

        BroadcastRecordTimer(BroadcastQueueSmtBase r1, long startTime, long endTime, String receiver, String action) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.receiver = receiver;
            this.action = action;
        }
    }

    private class BroadcastStats {
        int count;
        String intentAction;
        boolean ordered;
        HashMap<String, ReceiverStats> receivers;

        BroadcastStats(BroadcastQueueSmtBase r2, String action, int count, boolean ordered) {
            this.receivers = new HashMap(10);
            this.intentAction = action;
            this.count = count;
            this.ordered = ordered;
        }

        public String toString() {
            Slog.d(BroadcastQueueSmtBase.TAG_BROADCAST_STATISTICS, String.format(Locale.CHINA, " %s:%d:%b", new Object[]{this.intentAction, Integer.valueOf(this.count), Boolean.valueOf(this.ordered)}));
            return String.format(Locale.CHINA, " %s:%d:%b", new Object[]{this.intentAction, Integer.valueOf(this.count), Boolean.valueOf(this.ordered)});
        }
    }

    private class ReceiverStats {
        int count;
        String receiver;
        long timeTotal;

        ReceiverStats(BroadcastQueueSmtBase r1, int count, long timeTotal) {
            this.count = count;
            this.timeTotal = timeTotal;
        }

        ReceiverStats(BroadcastQueueSmtBase r1, String receiver, int count, long timeTotal) {
            this.count = count;
            this.timeTotal = timeTotal;
            this.receiver = receiver;
        }

        public String toString() {
            Slog.d(BroadcastQueueSmtBase.TAG_BROADCAST_STATISTICS, String.format(Locale.CHINA, "  %s:%s:%s", new Object[]{this.receiver, Integer.valueOf(this.count), Long.valueOf(this.timeTotal)}));
            return String.format(Locale.CHINA, "%s:%s:%s", new Object[]{this.receiver, Integer.valueOf(this.count), Long.valueOf(this.timeTotal)});
        }
    }

    private class SenderStats {
        HashMap<String, BroadcastStats> actions;
        int count;
        String sender;

        SenderStats(BroadcastQueueSmtBase r2, String sender, int count) {
            this.actions = new HashMap(10);
            this.sender = sender;
            this.count = count;
        }

        public String toString() {
            Slog.d(BroadcastQueueSmtBase.TAG_BROADCAST_STATISTICS, String.format(Locale.CHINA, "%s:%d", new Object[]{this.sender, Integer.valueOf(this.count)}));
            return String.format(Locale.CHINA, "%s:%d", new Object[]{this.sender, Integer.valueOf(this.count)});
        }
    }

    public BroadcastQueueSmtBase(BroadcastQueue queue) {
        this.mBDRecordTimerHM = new HashMap();
        this.mAllBroadcastStats = new HashMap(16);
        this.mStringBuilder = new StringBuilder(256);
        this.mQueue = queue;
    }

    static {
        sBDReceiverStatsEnabled = new AtomicBoolean(false);
    }

    protected static void setBDReceiverStatsEnabled(boolean enable) {
        sBDReceiverStatsEnabled.set(enable);
    }

    protected void processOrdeBroadcastStats(BroadcastRecord r) {
        if (sBDReceiverStatsEnabled.get() == false) goto L26;
        if (r != null) goto L7;
        return;
    L7:
        if (this.mBDRecordTimerHM.containsKey(r) == true) goto L24;
        if (this.mBDRecordTimerHM.get(r) != null) goto L24;
        if (r.intent != null) goto L14;
        return;
    L14:
        if (r.intent.getComponent() == null) goto L17;
        String receiver = r.intent.getComponent().flattenToShortString();
        String receiver2 = receiver;
    L20:
        if (receiver2 != null) goto L22;
        return;
    L22:
        long start = SystemClock.uptimeMillis();
        BroadcastRecordTimer bDTimer = new BroadcastRecordTimer(this, start, 0, receiver2, r.intent.getAction());
        this.mBDRecordTimerHM.put(r, bDTimer);
        return;
    L17:
        if (r.intent.getPackage() == null) goto L19;
        String receiver3 = r.intent.getPackage();
        receiver2 = receiver3;
        goto L20
    L19:
        receiver2 = null;
    L24:
        return;
    }

    protected void processParallelBroadcastsStats(BroadcastRecord r, String receiver) {
        if (sBDReceiverStatsEnabled.get() == false) goto L25;
        if (r == null) goto L27;
        if (receiver != null) goto L9;
        return;
    L9:
        if (r.intent != null) goto L11;
        return;
    L11:
        String action = r.intent.getAction();
        SenderStats senderStats = this.mAllBroadcastStats.get(r.callerPackage);
        if (senderStats != null) goto L14;
        senderStats = new SenderStats(this, r.callerPackage, 1);
        this.mAllBroadcastStats.put(r.callerPackage, senderStats);
    L15:
        BroadcastStats bdStats = senderStats.actions.get(action);
        if (bdStats != null) goto L18;
        bdStats = new BroadcastStats(this, action, 1, r.ordered);
        senderStats.actions.put(action, bdStats);
    L19:
        ReceiverStats receiverStats = bdStats.receivers.get(receiver);
        if (receiverStats != null) goto L22;
        bdStats.receivers.put(receiver, new ReceiverStats(this, receiver, 1, -1));
        return;
    L22:
        receiverStats.count++;
        return;
    L18:
        bdStats.count++;
        goto L19
    L14:
        senderStats.count++;
        goto L15
    L27:
        return;
    }

    protected void finishOrderBroadcastStats(BroadcastRecord r) {
        if (sBDReceiverStatsEnabled.get() == false) goto L25;
        if (r != null) goto L7;
        return;
    L7:
        if (this.mBDRecordTimerHM.containsKey(r) == false) goto L26;
        BroadcastRecordTimer recordTimer = this.mBDRecordTimerHM.remove(r);
        if (recordTimer.startTime != 0) goto L12;
        this.mBDRecordTimerHM.remove(r);
        return;
    L12:
        String receiver = recordTimer.receiver;
        String action = recordTimer.action;
        long endTime = SystemClock.uptimeMillis();
        SenderStats senderStats = this.mAllBroadcastStats.get(r.callerPackage);
        if (senderStats != null) goto L15;
        SenderStats senderStats2 = new SenderStats(this, r.callerPackage, 1);
        this.mAllBroadcastStats.put(r.callerPackage, senderStats2);
        SenderStats senderStats3 = senderStats2;
    L16:
        BroadcastStats bdStats = senderStats3.actions.get(action);
        if (bdStats == null) goto L19;
        bdStats.count++;
        BroadcastStats bdStats2 = bdStats;
    L20:
        ReceiverStats receiverStats = bdStats2.receivers.get(receiver);
        if (receiverStats == null) goto L23;
        receiverStats.count++;
        receiverStats.timeTotal += endTime - recordTimer.startTime;
        return;
    L23:
        bdStats2.receivers.put(receiver, new ReceiverStats(this, receiver, 1, endTime - recordTimer.startTime));
        return;
    L19:
        BroadcastStats bdStats3 = new BroadcastStats(this, action, 1, r.ordered);
        senderStats3.actions.put(action, bdStats3);
        bdStats2 = bdStats3;
        goto L20
    L15:
        senderStats.count++;
        senderStats3 = senderStats;
        goto L16
    L26:
        return;
    }

    protected void outputBDReceiverStatistics() {
        if (this.mAllBroadcastStats.size() != 0) goto L5;
        return;
    L5:
        StringBuilder buf = this.mStringBuilder;
        buf.setLength(0);
        buf.append(" Broadcast Receiver Statistics :\n");
        Slog.d(TAG_BROADCAST_STATISTICS, buf.toString());
    }

    protected void clearStats() {
        this.mAllBroadcastStats.clear();
    }

    boolean isSmtClockBr(BroadcastRecord r) {
        if (r != null) goto L5;
    L11:
        return false;
    L5:
        if (r.intent == null) goto L11;
        if ((r.intent.getSmtEx().getSmFlags() & 64) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    protected boolean isBroadcastAllowStartForModern(ResolveInfo info, BroadcastRecord r) {
        if (this.mQueue.mService.getSmtEx().mProcessIntercept.isBroadcastAllowStart(info, r) == true) goto L6;
        return false;
    L6:
        return true;
    }
}
