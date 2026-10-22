package com.stepos.alphame.dailyusage.utils;

import B0.g;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.alphame.data.utils.DailyUsageMessageHelperKt;
import com.stepos.alphame.model.event.DailyUsageMzWindowMessage;
import m3.e;

/* loaded from: classes.dex */
public class AppEventMonitor {
    public static final String APP_PAUSE = "pause";
    public static final String APP_RESUME = "resume";
    private static final String TAG = "AppEventMonitor";
    private static int sWindowModeFreeform;
    private static int sWindowModePinned;
    private static boolean sWindowModesInitialized;

    public static void dispatchActivityStateChange(String str, String str2, Bundle bundle) {
        initWindowModes();
        onActivityStateChange(str, str2, bundle);
    }

    public static void dispatchProcessStateChange(String str, String str2, Bundle bundle) {
        onProcessStateChange(str, str2, bundle);
    }

    private static void initWindowModes() {
        if (sWindowModesInitialized) {
            return;
        }
        sWindowModesInitialized = true;
        Bundle windowModeConstants = AlphaMeEventIpc.getWindowModeConstants();
        sWindowModeFreeform = windowModeConstants.getInt("WINDOW_MODE_FREEFORM", 11);
        sWindowModePinned = windowModeConstants.getInt("WINDOW_MODE_PINNED", 12);
    }

    private static void onActivityStateChange(String str, String str2, Bundle bundle) {
        if (str == null || bundle == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        Object obj = null;
        String string = bundle.getString("state", null);
        if (string == null) {
            return;
        }
        int i4 = bundle.getInt("uid", 0) / ComplexPt.TEN_THOUSAND;
        int iMyUid = Process.myUid() / ComplexPt.TEN_THOUSAND;
        int i5 = bundle.getInt("windowingMode", -1);
        boolean z4 = i5 == sWindowModeFreeform || i5 == sWindowModePinned;
        int i6 = bundle.getInt("displayId", 0);
        if ("resume".equals(string) && !z4) {
            obj = "resume";
        } else if ("pause".equals(string) || z4) {
            obj = "pause";
        }
        Log.d(TAG, "state: " + string + ", windowingMode: " + i5 + ", displayId: " + i6 + ", packageName: " + str + ", className: " + str2);
        if (i4 == iMyUid || i4 >= 500) {
            if (z4) {
                e.b().e(new DailyUsageMzWindowMessage(System.currentTimeMillis(), str, string, i5));
            } else if ("resume".equals(obj)) {
                DailyUsageMessageHelperKt.sendDailyUsageWindowMessage(str, System.currentTimeMillis());
            }
        }
    }

    private static void onProcessStateChange(String str, String str2, Bundle bundle) {
        if (str == null || str2 == null || bundle == null || !"died".equals(bundle.getString("state", null))) {
            return;
        }
        g.z("onProcessStateChange pid=", bundle.getInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_PANOID, 0), TAG);
    }

    public static boolean register(Context context) {
        initWindowModes();
        Log.i(TAG, "register: delegated to NewAppEventCollector (no duplicate listener)");
        return true;
    }
}
