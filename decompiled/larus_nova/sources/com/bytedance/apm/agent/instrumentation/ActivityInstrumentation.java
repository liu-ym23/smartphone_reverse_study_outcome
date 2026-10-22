package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.apm.agent.helper.PageShowHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ActivityInstrumentation {
    private static final String TAG = "ActivityInstrumentation";
    static boolean isFirstWindowFocusChanged;
    private static String sActivityName;
    private static HashSet<String> sMethodSet;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnWindowFocusedChangeStart;

    public ActivityInstrumentation() {
    }

    static {
        sMethodSet = new HashSet(32);
    }

    public static boolean isValid(String r100) {
        if (TextUtils.isEmpty(sActivityName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r100, sActivityName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void onTrace(String r110, String r111, boolean r112) {
        if (TextUtils.equals(WidgetCostModule.TYPE_ON_CREATE, r111) == false) goto L13;
        if (r112 == false) goto L9;
        sActivityName = r110;
        sOnCreateStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L50;
        AppInstrumentation.launcherActivityOnCreateStart(sActivityName);
        return;
    L50:
        return;
    L9:
        if (isValid(r110) == false) goto L52;
        sOnCreateEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L53;
        AppInstrumentation.launcherActivityOnCreateEnd();
        return;
    L53:
        return;
    L52:
        return;
    L13:
        boolean r100 = true;
        if (TextUtils.equals("onResume", r111) == false) goto L30;
        if (isValid(r110) == false) goto L30;
        if (r112 == false) goto L25;
        if (sOnCreateStart <= 0) goto L55;
        sOnResumeStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L23;
        AppInstrumentation.launcherActivityOnResumeStart(sActivityName);
    L23:
        PageShowHelper.onPageShowHideAction(sActivityName, true);
        return;
    L55:
        return;
    L25:
        if (sOnCreateStart <= 0) goto L57;
        sOnResumeEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L58;
        AppInstrumentation.launcherActivityOnResumeEnd();
        return;
    L58:
        return;
    L57:
        return;
    L30:
        if (TextUtils.equals("onWindowFocusChanged", r111) == true) goto L32;
        return;
    L32:
        if (isValid(r110) == true) goto L34;
        return;
    L34:
        if (sOnCreateStart > 0) goto L36;
        return;
    L36:
        if (isFirstWindowFocusChanged == true) goto L38;
        AppInstrumentation.launcherActivityOnWindowFocusChangedStart(sActivityName);
        isFirstWindowFocusChanged = true;
    L38:
        long r101 = System.currentTimeMillis();
        sOnWindowFocusedChangeStart = r101;
        if ((r101 - sOnCreateStart) < 5000) goto L48;
    L45:
        sOnCreateStart = 0;
        sActivityName = null;
        return;
    L48:
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L47
        r113.put("begin_time", sOnCreateStart);     // Catch: Exception -> L47
        r113.put("end_time", sOnWindowFocusedChangeStart);     // Catch: Exception -> L47
        r113.put("page_type", "activity");     // Catch: Exception -> L47
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L47
        r114.put(WidgetCostModule.TYPE_ON_CREATE, sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L47
        r114.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L47
        r114.put("activityOnCreateToWindowFocusChanged", sOnWindowFocusedChangeStart - sOnCreateStart);     // Catch: Exception -> L47
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L47
        r102.put("scene", sActivityName);     // Catch: Exception -> L47
        if (sMethodSet.contains(sActivityName + r111) == false) goto L44;
        r100 = false;
    L44:
        r102.put(a.KEY_IS_FIRST, r100);     // Catch: Exception -> L47
        sMethodSet.add(sActivityName + r111);     // Catch: Exception -> L47
        MonitorTool.monitorPerformance(UploadTypeInf.PAGE_LOAD, r114, r102, r113);     // Catch: Exception -> L47
        goto L45
    }
}
