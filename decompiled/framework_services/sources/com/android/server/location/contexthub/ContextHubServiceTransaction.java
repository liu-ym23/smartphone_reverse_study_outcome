package com.android.server.location.contexthub;

import android.hardware.location.ContextHubTransaction;
import android.hardware.location.NanoAppState;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
abstract class ContextHubServiceTransaction {
    private boolean mIsComplete;
    private final int mMessageSequenceNumber;
    private final long mNanoAppId;
    private long mNextRetryTime;
    private int mNumCompletedStartCalls;
    private final int mOwnerId;
    private final String mPackage;
    private long mTimeoutTime;
    private final int mTransactionId;
    private final int mTransactionType;

    abstract int onTransact();

    ContextHubServiceTransaction(int id, int type, String packageName) {
        this.mIsComplete = false;
        this.mTransactionId = id;
        this.mTransactionType = type;
        this.mNanoAppId = Long.MAX_VALUE;
        this.mPackage = packageName;
        this.mMessageSequenceNumber = Integer.MAX_VALUE;
        this.mNextRetryTime = Long.MAX_VALUE;
        this.mTimeoutTime = Long.MAX_VALUE;
        this.mNumCompletedStartCalls = 0;
        this.mOwnerId = Integer.MAX_VALUE;
    }

    ContextHubServiceTransaction(int id, int type, long nanoAppId, String packageName) {
        this.mIsComplete = false;
        this.mTransactionId = id;
        this.mTransactionType = type;
        this.mNanoAppId = nanoAppId;
        this.mPackage = packageName;
        this.mMessageSequenceNumber = Integer.MAX_VALUE;
        this.mNextRetryTime = Long.MAX_VALUE;
        this.mTimeoutTime = Long.MAX_VALUE;
        this.mNumCompletedStartCalls = 0;
        this.mOwnerId = Integer.MAX_VALUE;
    }

    ContextHubServiceTransaction(int id, int type, String packageName, int messageSequenceNumber, int ownerId) {
        this.mIsComplete = false;
        this.mTransactionId = id;
        this.mTransactionType = type;
        this.mNanoAppId = Long.MAX_VALUE;
        this.mPackage = packageName;
        this.mMessageSequenceNumber = messageSequenceNumber;
        this.mNextRetryTime = Long.MAX_VALUE;
        this.mTimeoutTime = Long.MAX_VALUE;
        this.mNumCompletedStartCalls = 0;
        this.mOwnerId = ownerId;
    }

    void onTransactionComplete(int result) {
    }

    void onQueryResponse(int result, List<NanoAppState> nanoAppStateList) {
    }

    int getTransactionId() {
        return this.mTransactionId;
    }

    int getTransactionType() {
        return this.mTransactionType;
    }

    int getMessageSequenceNumber() {
        return this.mMessageSequenceNumber;
    }

    long getNextRetryTime() {
        return this.mNextRetryTime;
    }

    long getTimeoutTime() {
        return this.mTimeoutTime;
    }

    int getNumCompletedStartCalls() {
        return this.mNumCompletedStartCalls;
    }

    long getOwnerId() {
        return (((long) this.mTransactionType) << 32) | (((long) this.mOwnerId) & 4294967295L);
    }

    long getTimeout(TimeUnit unit) {
        switch(this.mTransactionType) {
            case 0: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        return unit.convert(5, TimeUnit.SECONDS);
    L7:
        return unit.convert(ContextHubTransactionManager.RELIABLE_MESSAGE_TIMEOUT.toNanos(), TimeUnit.NANOSECONDS);
    L9:
        return unit.convert(30, TimeUnit.SECONDS);
    }

    void setComplete() {
        this.mIsComplete = true;
    }

    void setNextRetryTime(long nextRetryTime) {
        this.mNextRetryTime = nextRetryTime;
    }

    void setTimeoutTime(long timeoutTime) {
        this.mTimeoutTime = timeoutTime;
    }

    void setNumCompletedStartCalls(int numCompletedStartCalls) {
        this.mNumCompletedStartCalls = numCompletedStartCalls;
    }

    boolean isComplete() {
        return this.mIsComplete;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(ContextHubTransaction.typeToString(this.mTransactionType, true));
        out.append(" (");
        if (this.mNanoAppId == Long.MAX_VALUE) goto L5;
        out.append("appId = 0x");
        out.append(Long.toHexString(this.mNanoAppId));
        out.append(", ");
    L5:
        out.append("package = ");
        out.append(this.mPackage);
        if (this.mMessageSequenceNumber == Integer.MAX_VALUE) goto L9;
        out.append(", messageSequenceNumber = ");
        out.append(this.mMessageSequenceNumber);
    L9:
        if (this.mTransactionType != 5) goto L11;
    L12:
        out.append(", nextRetryTime = ");
        out.append(this.mNextRetryTime);
        out.append(", timeoutTime = ");
        out.append(this.mTimeoutTime);
        out.append(", numCompletedStartCalls = ");
        out.append(this.mNumCompletedStartCalls);
        out.append(", ownerId = ");
        out.append(getOwnerId());
    L13:
        out.append(")");
        return out.toString();
    L11:
        if (this.mTransactionType != 7) goto L13;
        goto L12
    }
}
