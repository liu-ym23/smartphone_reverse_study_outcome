package com.stepos.statsapp.v3.lib.plugin.boot;

import android.content.Context;
import com.stepos.statsapp.v3.InitConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f30635a = "BootUpHelper";

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f30636b = Boolean.FALSE;

    public static void a(Context context) {
        if (InitConfig.noBootUp) {
            Logger.w(f30635a, "onBootUpEvent InitConfig.noBootUp is true");
            return;
        }
        if (f30636b.booleanValue()) {
            Logger.w(f30635a, "onBootUpEvent mBootUpEventComplete is true");
            return;
        }
        try {
            SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, UxipConstants.PREFERENCES_COMMON_NAME);
            HashMap map = new HashMap();
            map.put("daily_actived", String.valueOf(a(sharedPreferencesHelper)));
            map.put("global_actived", String.valueOf(b(sharedPreferencesHelper)));
            com.stepos.statsapp.v3.lib.plugin.sdk.a.c().d("_bootup_", map);
            f30636b = Boolean.TRUE;
        } catch (Exception e10) {
            Logger.e(f30635a, "onBootUpEvent error, " + e10);
        }
    }

    private static int b(SharedPreferencesHelper sharedPreferencesHelper) {
        if (!sharedPreferencesHelper.getConfig(UxipConstants.f30683v, true)) {
            return 0;
        }
        sharedPreferencesHelper.commitConfig(UxipConstants.f30683v, false);
        return 1;
    }

    private static int a(SharedPreferencesHelper sharedPreferencesHelper) {
        String str = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String config = sharedPreferencesHelper.getConfig(UxipConstants.f30682u, "");
        Logger.d(f30635a, "beforeGetDailyActive ------------------ current states: today:" + str + ", last:" + config);
        if (str.equals(config)) {
            return 0;
        }
        Logger.i(f30635a, "a new day");
        sharedPreferencesHelper.applyConfig(UxipConstants.f30682u, str);
        return 1;
    }
}
