package com.android.server.wm;

import android.view.SurfaceControl;
import bytedanceos.util.FeatLog;
import com.android.server.ISmartService;
import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes3.dex */
public class RefreshRatePolicySmtEx {
    public static final int SMT_REFRESH_AUTO_60 = 4;
    public static final int SMT_REFRESH_AUTO_90 = 8;
    public static final int SMT_REFRESH_CLOUD_60 = 1;
    public static final int SMT_REFRESH_CLOUD_90 = 2;
    public static final int SMT_REFRESH_NONE = 0;
    public static int sOldSmtRefreshFlag;
    public static int sSmtRefreshFlag;
    ISmartService mSmartService;

    static {
        sSmtRefreshFlag = 0;
        sOldSmtRefreshFlag = 0;
    }

    RefreshRatePolicySmtEx() {
        this.mSmartService = SysOptBridge.getFactory().getSmartService();
    }

    public static void updateAppCloudSmtRefreshFlag(int judgementId, int lowRefreshRateId) {
        sSmtRefreshFlag &= -2;
        sSmtRefreshFlag &= -3;
        if (judgementId != lowRefreshRateId) goto L5;
        sSmtRefreshFlag |= 1;
    L8:
        if (sSmtRefreshFlag == sOldSmtRefreshFlag) goto L11;
        SurfaceControl.setSmtRefreshFlag(sSmtRefreshFlag);
        sOldSmtRefreshFlag = sSmtRefreshFlag;
        FeatLog.i("RefreshRatePolicy", "FEAT_PERF_REFRESH_RATE", 10, "update cloud smtRefreshFlag : " + sSmtRefreshFlag);
        return;
    L11:
        return;
    L5:
        if (judgementId != 0) goto L8;
        sSmtRefreshFlag |= 2;
        goto L8
    }

    public static void updateAppRequestSmtRefreshFlag(int judgementId, int lowRefreshRateId) {
        sSmtRefreshFlag &= -5;
        sSmtRefreshFlag &= -9;
        if (judgementId != lowRefreshRateId) goto L5;
        sSmtRefreshFlag |= 4;
    L8:
        if (sSmtRefreshFlag == sOldSmtRefreshFlag) goto L11;
        SurfaceControl.setSmtRefreshFlag(sSmtRefreshFlag);
        sOldSmtRefreshFlag = sSmtRefreshFlag;
        FeatLog.i("RefreshRatePolicy", "FEAT_PERF_REFRESH_RATE", 10, "update app auto smtRefreshFlag : " + sSmtRefreshFlag);
        return;
    L11:
        return;
    L5:
        if (judgementId != 0) goto L8;
        sSmtRefreshFlag |= 8;
        goto L8
    }

    int judgementAutoDisplayRefreshRate(WindowState w, int lowRefreshRateId) {
        boolean detectSmartRefresh = !this.mSmartService.closeDetectSmartRefresh();
        if (detectSmartRefresh == false) goto L16;
        int flag = 0;
        if (w.mActivityRecord == null) goto L10;
        flag = w.mActivityRecord.info.getSysEx().autoDisplayFlags;
        if (flag != 0) goto L10;
        flag = w.mActivityRecord.info.applicationInfo.getSysEx().autoDisplayFlags;
    L10:
        if ((flag & 4) == 0) goto L13;
        return lowRefreshRateId;
    L13:
        if ((flag & 8) == 0) goto L18;
        return 0;
    L18:
        return -1;
    L16:
        return -1;
    }

    int judgementForceDisplayRefreshRate(WindowState w, int lowRefreshRateId) {
        int flag = 0;
        if (w.mActivityRecord == null) goto L8;
        flag = w.mActivityRecord.info.getSysEx().forceDisplayFlags;
        if (flag != 0) goto L8;
        flag = w.mActivityRecord.info.applicationInfo.getSysEx().forceDisplayFlags;
    L8:
        if ((flag & 1) == 0) goto L11;
        return lowRefreshRateId;
    L11:
        if ((flag & 2) == 0) goto L14;
        return 0;
    L14:
        return -1;
    }
}
