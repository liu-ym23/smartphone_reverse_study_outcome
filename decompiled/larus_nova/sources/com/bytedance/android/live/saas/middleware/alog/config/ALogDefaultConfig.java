package com.bytedance.android.live.saas.middleware.alog.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes47.dex */
public class ALogDefaultConfig {
    public static final int ALOG_MAX_CACHE_SIZE = 20971520;
    public static final int ALOG_ZONE_SIZE = 2097152;
    public static final int DEVICE_MAX_LOG_SPACE_SIZE = 52428800;
    private static String SUFFIX_LOGS = "/logs";
    private static String sAppLogPath = "";

    public ALogDefaultConfig() {
    }

    public static String getALogFile(Context r100) {
        if (TextUtils.isEmpty(sAppLogPath) == false) goto L5;
        File r101 = BDLiveSdk.fileUtils().getExternalFilesDir(r100);
        if (r101 != null) goto L9;
        r101 = BDLiveSdk.fileUtils().getExternalCacheDir(r100);
    L9:
        if (r101 != null) goto L11;
        r101 = r100.getFilesDir();
    L11:
        String r102 = new PolarisFileWrapper(r101, SUFFIX_LOGS).getAbsolutePath();
        sAppLogPath = r102;
        return r102;
    L5:
        return sAppLogPath;
    }

    public static int getDefaultLogSize(Context r100) {
        long r101 = new PolarisFileWrapper(getALogFile(r100)).getFreeSpace() / 10;
        if (r101 <= 52428800) goto L7;
        return DEVICE_MAX_LOG_SPACE_SIZE;
    L7:
        if (r101 < 20971520) goto L9;
        return 20971520;
    L9:
        return (int) r101;
    }

    public static void setsAppLogPath(String r100) {
        sAppLogPath = r100;
    }
}
