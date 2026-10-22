package com.android.server.am;

import android.content.pm.ApplicationInfo;
import android.mifavor.MFVUtils;
import android.os.UserHandle;
import android.util.Log;
import java.io.DataInputStream;

/* JADX INFO: loaded from: classes.dex */
public interface IZswProcessList {
    public static final String TAG = "IZswProcessList";

    boolean handleMessage(int r1, int r2, DataInputStream r3);

    void handleProcessStartedLocked(int r1);

    void heartBeating(int r1);

    boolean isWechatMain(ProcessRecord r1);

    void noteStartingProcess(ProcessRecord r1, int r2);

    void reportTest();

    boolean shouldSkipKill(boolean r1, String r2);

    static int getProcessRecordLocked_DoubleApp(String processName, int uid) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return uid;
    L5:
        if (processName.equals("android.process.media") == true) goto L13;
        if (processName.equals("android.process.media.module") == true) goto L13;
        if (processName.contains("com.android.providers.media") == true) goto L13;
        if (processName.contains("com.google.android.providers.media") == true) goto L13;
        return uid;
    L13:
        if (UserHandle.getUserId(uid) != 999) goto L18;
        Log.d(TAG, "getProcessRecordLocked: android.process.media for user 0");
        return UserHandle.getUid(0, UserHandle.getAppId(uid));
    L18:
        return uid;
    }

    static void startProcessLocked_DoubleApp_01(ApplicationInfo info) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return;
    L5:
        if (info.packageName.equals("com.android.providers.media") == true) goto L11;
        if (info.packageName.equals("com.android.providers.media.module") == true) goto L11;
        if (info.packageName.contains("com.google.android.providers.media") == true) goto L11;
        return;
    L11:
        if (UserHandle.getUserId(info.uid) != 999) goto L16;
        Log.d(TAG, "startProcessLocked: com.android.providers.media init for user 0");
        info.initForUser(0);
        return;
    }

    static int[] startProcessLocked_DoubleApp_02(ProcessRecord app, int[] gids) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return gids;
    L5:
        if (UserHandle.getUserId(app.uid) != 0) goto L7;
    L10:
        boolean allowCrossProfile = true;
    L12:
        if (allowCrossProfile == false) goto L16;
        int[] temp = new int[gids.length + 1];
        System.arraycopy(gids, 0, temp, 0, gids.length);
        temp[gids.length] = UserHandle.getUserGid(999 - UserHandle.getUserId(app.uid));
        return temp;
    L16:
        return gids;
    L7:
        if (UserHandle.getUserId(app.uid) == 999) goto L10;
        allowCrossProfile = false;
        goto L12
    }
}
