package com.android.server.am;

import android.content.Context;
import android.content.Intent;
import android.mifavor.MFVUtils;
import android.os.UserHandle;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public interface IZswBroadcastQueueImpl {
    public static final String TAG = "IZswBroadcastQueueImpl";

    public static class EnqueueBroadcastInfoWraper {
        public boolean mCallingFromEnqueueBroadcastLocked;
        public boolean mIs999ReceiverInstalled;
        public String mReceiverPackageName;

        public EnqueueBroadcastInfoWraper(boolean callingFromEnqueueBroadcastLocked, boolean is999ReceiverInstalled, String receiverPackageName) {
            this.mCallingFromEnqueueBroadcastLocked = false;
            this.mIs999ReceiverInstalled = true;
            this.mReceiverPackageName = null;
            this.mCallingFromEnqueueBroadcastLocked = callingFromEnqueueBroadcastLocked;
            this.mIs999ReceiverInstalled = is999ReceiverInstalled;
            this.mReceiverPackageName = receiverPackageName;
        }
    }

    public static class SkipWraper {
        public boolean mShouldSkip;
        public String mSkipReason;

        public SkipWraper(boolean shouldSkip, String reason) {
            this.mShouldSkip = false;
            this.mSkipReason = "";
            this.mShouldSkip = shouldSkip;
            this.mSkipReason = reason;
        }
    }

    boolean cleanupDisabledPackageReceiversLocked(Object r1, Intent r2, int r3, String r4);

    void enqueueBroadcastLockedMiddle(BroadcastProcessQueue r1);

    void enqueueBroadcastLockedPost();

    void enqueueBroadcastLockedPrev(BroadcastRecord r1);

    boolean finishReceiverActiveLocked(ProcessRecord r1);

    void noteBroadcastTimeoutEnd(BroadcastProcessQueue r1);

    void noteBroadcastTimeoutStart(BroadcastProcessQueue r1, long r2);

    void notifyStartedRunning(BroadcastProcessQueue r1);

    String shouldSkipReceiver(BroadcastProcessQueue r1, BroadcastRecord r2, int r3);

    boolean updateRunningListLocked(BroadcastProcessQueue r1);

    static EnqueueBroadcastInfoWraper getEnqueueBroadcastInfo_DoubleApp(int receiverUid, String action, String receiverPackageName, Context context) {
        boolean callingFromEnqueueBroadcastLocked = false;
        boolean is999ReceiverInstalled = true;
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L15;
        callingFromEnqueueBroadcastLocked = false;
        is999ReceiverInstalled = true;
        receiverPackageName = null;
    L14:
        return new EnqueueBroadcastInfoWraper(callingFromEnqueueBroadcastLocked, is999ReceiverInstalled, receiverPackageName);
    L15:
    L8:
        e = move-exception;
        Slog.e(TAG, "debug_999_broadcast enqueueBroadcastLocked e:" + e);
        goto L14
    L5:
        if (UserHandle.getUserId(receiverUid) != 999) goto L14;
        callingFromEnqueueBroadcastLocked = true;
        is999ReceiverInstalled = MFVUtils.checkAppInstalled(context, receiverPackageName, 999);     // Catch: Exception -> L8
        goto L14
    }

    static SkipWraper shouldSkipDelivery_DoubleApp(int receiverUid, String action, String receiverProcessName, boolean is999ReceiverInstalled, String receiverPackageName) {
    L16:
        e = move-exception;
        Slog.e(TAG, "enqueueBroadcastLocked e:" + e);
    L29:
        return new SkipWraper(false, "");
    L4:
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L29;
        if (UserHandle.getUserId(receiverUid) != 999) goto L29;
        if (receiverProcessName != null) goto L10;
    L20:
        if (is999ReceiverInstalled == false) goto L24;
        if (receiverPackageName == null) goto L29;
        if (receiverPackageName.contains("com.android.server.telecom") == false) goto L29;
    L24:
        Slog.d(TAG, "debug_999_broadcast enqueueBroadcastLocked,reason : skip reason : 999 broadcast to 999 receiver that not exist or telecom !,action:" + action + ",receiverProcessName:" + receiverProcessName + ",receiverPackageName:" + receiverPackageName + ",receiverUid:" + receiverUid);     // Catch: Exception -> L16
        return new SkipWraper(true, "skip reason : 999 broadcast to 999 receiver that not exist or telecom !");
    L10:
        if (receiverProcessName.contains("providers.media") == false) goto L20;
        if ("android.intent.action.BOOT_COMPLETED".equals(action) == false) goto L14;
    L18:
        Slog.d(TAG, "debug_999_broadcast enqueueBroadcastLocked3333333,skip reason : 999 system broadcast to 0 mediaprovider(dumplicated braodcasts)");     // Catch: Exception -> L16
        return new SkipWraper(true, "skip reason : 999 system broadcast to 0 mediaprovider(dumplicated braodcasts)");
    L14:
        if ("android.intent.action.LOCALE_CHANGED".equals(action) == false) goto L29;
        goto L18
    }

    static int fallbackUid_DoubleApp(int uid, String processName, boolean callingFromEnqueueBroadcastLocked, boolean is999ReceiverInstalled, String receiverPackageName) {
    L12:
        e = move-exception;
        Slog.d(TAG, "getOrCreateProcessQueue e:" + e);
    L22:
        return uid;
    L4:
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L6;
    L23:
        goto L22
    L6:
        if (UserHandle.getUserId(uid) != 999) goto L23;
        int appId = UserHandle.getAppId(uid);     // Catch: Exception -> L12
        if (processName != null) goto L10;
    L14:
        if (callingFromEnqueueBroadcastLocked == false) goto L23;
        if (is999ReceiverInstalled == false) goto L19;
        if (receiverPackageName == null) goto L23;
        if (receiverPackageName.contains("com.android.server.telecom") == false) goto L23;
    L19:
        uid = appId;
        Slog.d(TAG, "debug_999_broadcast getOrCreateProcessQueue send 999 broadcast to 0 processName:" + processName + ",result uid :" + uid);     // Catch: Exception -> L12
        goto L23
    L10:
        if (processName.contains("providers.media") == false) goto L14;
        uid = appId;
        Slog.d(TAG, "debug_999_broadcast getOrCreateProcessQueue 999 mediaprovider fallback to 0 (to get 0 queue since mediaprovider also fallback to 0),result uid :" + uid);     // Catch: Exception -> L12
        goto L23
    }
}
