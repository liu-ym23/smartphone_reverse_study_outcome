package com.android.server.am;

import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes.dex */
final class BroadcastProcessedEventRecord {
    private static final int MIN_THRESHOLD_FOR_LOGGING_TIME_MILLIS = 10;
    private int[] mBroadcastTypes;
    private String mIntentAction;
    private long mMaxReceiverFinishTimeMillis;
    private int mNumberOfReceivers;
    private String mReceiverProcessName;
    private int mReceiverUid;
    private int mSenderUid;
    private long mTotalBroadcastFinishTimeMillis;

    BroadcastProcessedEventRecord() {
        this.mMaxReceiverFinishTimeMillis = Long.MIN_VALUE;
    }

    public BroadcastProcessedEventRecord setBroadcastTypes(int[] broadcastTypes) {
        this.mBroadcastTypes = broadcastTypes;
        return this;
    }

    public BroadcastProcessedEventRecord setReceiverProcessName(String receiverProcessName) {
        this.mReceiverProcessName = receiverProcessName;
        return this;
    }

    public BroadcastProcessedEventRecord setIntentAction(String intentAction) {
        this.mIntentAction = intentAction;
        return this;
    }

    public BroadcastProcessedEventRecord setSenderUid(int uid) {
        this.mSenderUid = uid;
        return this;
    }

    public BroadcastProcessedEventRecord setReceiverUid(int uid) {
        this.mReceiverUid = uid;
        return this;
    }

    public void addReceiverFinishTime(long timeMillis) {
        this.mTotalBroadcastFinishTimeMillis += timeMillis;
        this.mMaxReceiverFinishTimeMillis = Math.max(this.mMaxReceiverFinishTimeMillis, timeMillis);
        this.mNumberOfReceivers++;
    }

    String getIntentActionForTest() {
        return this.mIntentAction;
    }

    int getSenderUidForTest() {
        return this.mSenderUid;
    }

    int getReceiverUidForTest() {
        return this.mReceiverUid;
    }

    int getNumberOfReceiversForTest() {
        return this.mNumberOfReceivers;
    }

    String getReceiverProcessNameForTest() {
        return this.mReceiverProcessName;
    }

    long getTotalBroadcastFinishTimeMillisForTest() {
        return this.mTotalBroadcastFinishTimeMillis;
    }

    long getMaxReceiverFinishTimeMillisForTest() {
        return this.mMaxReceiverFinishTimeMillis;
    }

    int[] getBroadcastTypesForTest() {
        return this.mBroadcastTypes;
    }

    public void logToStatsD() {
        if (this.mTotalBroadcastFinishTimeMillis > 10) goto L5;
        return;
    L5:
        FrameworkStatsLog.write(1028, this.mIntentAction, this.mSenderUid, this.mReceiverUid, this.mNumberOfReceivers, this.mReceiverProcessName, this.mTotalBroadcastFinishTimeMillis, this.mMaxReceiverFinishTimeMillis, this.mBroadcastTypes);
    }
}
