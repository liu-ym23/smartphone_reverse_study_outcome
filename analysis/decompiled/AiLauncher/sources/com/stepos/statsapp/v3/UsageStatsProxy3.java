package com.stepos.statsapp.v3;

import android.app.Application;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.sdk.a;
import com.stepos.statsapp.v3.utils.log.EncryptLogger;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class UsageStatsProxy3 {
    private static final String TAG = "UsageStatsProxy3";
    private static boolean sInitializated;
    private String mAppId;
    private Application mApplication;
    private int mPkgType;

    public static class InnerSingleton {
        private static final UsageStatsProxy3 singleton = new UsageStatsProxy3();

        private InnerSingleton() {
        }
    }

    public static UsageStatsProxy3 getInstance() {
        if (sInitializated) {
            return InnerSingleton.singleton;
        }
        throw new IllegalStateException("UsageStatsProxy3 is not initialised - invoke at least once with parameterised init");
    }

    public static void init(Application application, PkgType pkgType, String str) {
        init(application, pkgType, null, str);
    }

    private void initialization(Application application, int i10, InitConfig initConfig, String str, String str2) {
        File externalFilesDir;
        if (application == null) {
            throw new IllegalArgumentException("The context is null!");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("appId is null!");
        }
        if (initConfig == null) {
            throw new IllegalArgumentException("initConfig is null!");
        }
        this.mApplication = application;
        this.mAppId = str;
        this.mPkgType = i10;
        if (Logger.sDebug && (externalFilesDir = application.getExternalFilesDir(null)) != null) {
            Logger.setHook(new EncryptLogger(externalFilesDir.getAbsolutePath()));
        }
        a.c().a(this.mApplication, this.mPkgType, this.mAppId, str2);
        Logger.d(TAG, "UsageStatsProxy3 init complete");
    }

    public long getPageDuration(String str) {
        return a.c().a(str);
    }

    public String getSessionId() {
        return a.c().e();
    }

    public String getSource() {
        return a.c().f();
    }

    public String getUMID() {
        return a.c().i();
    }

    public void onAppWidgetPaused() {
        a.c().l();
    }

    public void onAppWidgetResume() {
        a.c().m();
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.c().a(str, str2, map, (Map<String, Object>) null);
    }

    public void onEventFramework(String str, String str2, Map<String, String> map, String str3, String str4, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(Parameters.PKG_NAME, str3);
        map2.put(Parameters.PKG_VER, str4);
        map2.put(Parameters.PKG_VER_CODE, Integer.valueOf(i10));
        a.c().a(str, str2, map, map2);
    }

    public void onEventLib(String str, String str2, Map<String, String> map, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(Parameters.PKG_NAME, str3);
        a.c().a(str, str2, map, map2);
    }

    public void onEventNeartime(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.c().b(str, str2, map, null);
    }

    public void onEventRealtime(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.c().c(str, str2, map, null);
    }

    public void onEventRealtimeFramework(String str, String str2, Map<String, String> map, String str3, String str4, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(Parameters.PKG_NAME, str3);
        map2.put(Parameters.PKG_VER, str4);
        map2.put(Parameters.PKG_VER_CODE, Integer.valueOf(i10));
        a.c().c(str, str2, map, map2);
    }

    public void onEventRealtimeLib(String str, String str2, Map<String, String> map, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(Parameters.PKG_NAME, str3);
        a.c().c(str, str2, map, map2);
    }

    public void onLog(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.c().a(str, map);
    }

    public void onLogRealtime(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.c().b(str, map);
    }

    public void onPageStart(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.c().b(str);
    }

    public void onPageStop(String str) {
        onPageStop(str, null);
    }

    public void refreshDeviceInfo() {
        a.c().n();
    }

    public void setAttributes(Map<String, String> map) {
        a.c().b(map);
    }

    public void setSource(String str) {
        a.c().c(str);
    }

    private UsageStatsProxy3() {
    }

    public static void init(Application application, PkgType pkgType, InitConfig initConfig, String str) {
        init(application, pkgType, initConfig, str, "StepOS");
    }

    public void onPageStop(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.c().c(str, map);
    }

    public static void init(Application application, PkgType pkgType, InitConfig initConfig, String str, String str2) {
        if (initConfig == null) {
            initConfig = new InitConfig();
        }
        InitConfig initConfig2 = initConfig;
        if (sInitializated) {
            return;
        }
        sInitializated = true;
        getInstance().initialization(application, pkgType.value(), initConfig2, str, str2);
    }

    public static void init(Application application, PkgType pkgType, String str, InitConfig initConfig, String str2, String str3) {
        init(application, pkgType, initConfig, str2, str3);
    }
}
