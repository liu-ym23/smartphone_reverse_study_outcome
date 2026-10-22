package com.stepos.pps.data.util;

import android.content.Context;
import android.util.Log;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import java.util.HashMap;

/* loaded from: classes.dex */
public class DataFinderHelper {
    private static final String TAG = "DataFinderHelper";
    private static volatile boolean sStarted = false;

    public static void init(Context context) {
        Log.d(TAG, "init data finder begin");
        InitConfig initConfig = new InitConfig("20010789", "bigdata");
        initConfig.setUriConfig(UriConfig.createByDomain("https://gator.volces.com", null));
        initConfig.setAutoStart(false);
        initConfig.setAutoTrackEnabled(false);
        initConfig.setLogEnable(LogUtil.sDebug);
        initConfig.setDisplayDensityAndDpiEnabled(false);
        initConfig.setCPUAbiEnabled(false);
        initConfig.setImeiEnable(false);
        initConfig.setSerialNumberEnable(false);
        AppLog.init(context, initConfig);
        setHeaderInfo();
        maybeStart(context);
    }

    public static synchronized void maybeStart(Context context) {
        if (sStarted) {
            return;
        }
        if (Utils.canDataCollect(context)) {
            AppLog.start();
            sStarted = true;
            Log.d(TAG, "AppLog.start() invoked after data collect consented");
        } else {
            Log.w(TAG, "Skip AppLog.start() for user privacy: data collect not consented");
        }
    }

    public static void onDataCollectConsentChanged(Context context) {
        maybeStart(context);
    }

    private static void setHeaderInfo() {
        String osVersion = DeviceUtils.getOsVersion();
        String projectName = DeviceUtils.getProjectName();
        HashMap map = new HashMap();
        map.put("stepOsVersion", osVersion);
        map.put("projectName", projectName);
        AppLog.setHeaderInfo(map);
    }

    public static void checkOaid() {
        Log.d(TAG, "begin check oaid");
        if (DeviceUtils.checkDeviceId()) {
            refreshHeaderInfo();
        }
    }

    public static void refreshHeaderInfo() {
        Log.d(TAG, "refreshHeaderInfo");
        String projectName = DeviceUtils.getProjectName();
        String osVersion = DeviceUtils.getOsVersion();
        HashMap map = new HashMap();
        map.put("stepOsVersion", osVersion);
        map.put("projectName", projectName);
        AppLog.setHeaderInfo(map);
    }
}
