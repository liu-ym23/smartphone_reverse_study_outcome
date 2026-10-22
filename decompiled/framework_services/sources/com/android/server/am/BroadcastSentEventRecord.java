package com.android.server.am;

import android.app.ActivityManager;
import android.content.Intent;
import android.util.IntArray;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes.dex */
final class BroadcastSentEventRecord {
    private BroadcastRecord mBroadcastRecord;
    private Intent mIntent;
    private boolean mOrdered;
    private int mOriginalIntentFlags;
    private int mRealSenderUid;
    private int mResult;
    private boolean mResultRequested;
    private int mSenderProcState;
    private int mSenderUid;
    private int mSenderUidState;
    private boolean mSticky;

    BroadcastSentEventRecord() {
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setSenderUid(int uid) {
        this.mSenderUid = uid;
    }

    public void setRealSenderUid(int uid) {
        this.mRealSenderUid = uid;
    }

    public void setOriginalIntentFlags(int flags) {
        this.mOriginalIntentFlags = flags;
    }

    public void setSticky(boolean sticky) {
        this.mSticky = sticky;
    }

    public void setOrdered(boolean ordered) {
        this.mOrdered = ordered;
    }

    public void setResultRequested(boolean resultRequested) {
        this.mResultRequested = resultRequested;
    }

    public void setSenderProcState(int procState) {
        this.mSenderProcState = procState;
    }

    public void setSenderUidState(int procState) {
        this.mSenderUidState = procState;
    }

    public void setBroadcastRecord(BroadcastRecord record) {
        this.mBroadcastRecord = record;
    }

    public void setResult(int result) {
        this.mResult = result;
    }

    public void logToStatsd() {
        int r3 = 0;
        switch(this.mResult) {
            case -2: goto L7;
            case -1: goto L6;
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        int r1 = 0;
    L8:
        int loggingResult = r1;
        int[] types = calculateTypesForLogging();
        String r5 = this.mIntent.getAction();
        int r6 = this.mIntent.getFlags();
        int r7 = this.mOriginalIntentFlags;
        int r8 = this.mSenderUid;
        int r9 = this.mRealSenderUid;
        if (this.mIntent.getPackage() == null) goto L11;
        boolean r10 = true;
    L13:
        if (this.mIntent.getComponent() == null) goto L15;
        boolean r11 = true;
    L17:
        if (this.mBroadcastRecord == null) goto L19;
        int r12 = this.mBroadcastRecord.receivers.size();
    L21:
        if (this.mBroadcastRecord == null) goto L23;
        r3 = this.mBroadcastRecord.getDeliveryGroupPolicy();
    L23:
        FrameworkStatsLog.write(FrameworkStatsLog.BROADCAST_SENT, r5, r6, r7, r8, r9, r10, r11, r12, loggingResult, r3, ActivityManager.processStateAmToProto(this.mSenderProcState), ActivityManager.processStateAmToProto(this.mSenderUidState), types);
        return;
    L19:
        r12 = 0;
        goto L21
    L15:
        r11 = false;
        goto L17
    L11:
        r10 = false;
        goto L13
    L5:
        r1 = 1;
        goto L8
    L6:
        r1 = 2;
        goto L8
    L7:
        r1 = 3;
        goto L8
    }

    private int[] calculateTypesForLogging() {
        if (this.mBroadcastRecord != null) goto L5;
        IntArray types = new IntArray();
        if (this.mSticky == false) goto L10;
        types.add(1024);
    L10:
        if (this.mOrdered == false) goto L13;
        types.add(16);
    L13:
        if (this.mResultRequested == false) goto L16;
        types.add(64);
    L16:
        return types.toArray();
    L5:
        return this.mBroadcastRecord.calculateTypesForLogging();
    }
}
