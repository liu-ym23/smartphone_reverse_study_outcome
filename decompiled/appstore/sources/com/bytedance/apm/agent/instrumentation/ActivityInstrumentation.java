package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.helper.PageShowHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.PerfConsts;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ActivityInstrumentation {
    private static final String TAG = "ActivityInstrumentation";
    static boolean isFirstWindowFocusChanged = false;
    private static String sActivityName;
    private static HashSet<String> sMethodSet;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnWindowFocusedChangeStart;

    static {
        sMethodSet = new HashSet(32);
    }

    public ActivityInstrumentation() {
    }

    public static boolean isValid(String r10) {
        if (TextUtils.isEmpty(sActivityName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r10, sActivityName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onTrace(String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L14;
        if (r12 == false) goto L9;
        sActivityName = r10;
        sOnCreateStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L46;
        AppInstrumentation.launcherActivityOnCreateStart(sActivityName);
        return;
    L46:
        return;
    L9:
        if (isValid(r10) == false) goto L48;
        sOnCreateEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L49;
        AppInstrumentation.launcherActivityOnCreateEnd();
        return;
    L49:
        return;
    L48:
        return;
    L14:
        if (TextUtils.equals("onResume", r11) == false) goto L30;
        if (isValid(r10) == false) goto L30;
        if (r12 == false) goto L25;
        if (sOnCreateStart <= 0) goto L51;
        sOnResumeStart = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L23;
        AppInstrumentation.launcherActivityOnResumeStart(sActivityName);
    L23:
        PageShowHelper.onPageShowHideAction(sActivityName, true);
        return;
    L51:
        return;
    L25:
        if (sOnCreateStart <= 0) goto L53;
        sOnResumeEnd = System.currentTimeMillis();
        if (isFirstWindowFocusChanged == true) goto L54;
        AppInstrumentation.launcherActivityOnResumeEnd();
        return;
    L54:
        return;
    L53:
        return;
    L30:
        if (TextUtils.equals("onWindowFocusChanged", r11) == true) goto L32;
        return;
    L32:
        if (isValid(r10) == true) goto L34;
        return;
    L34:
        if (sOnCreateStart > 0) goto L36;
        return;
    L36:
        if (isFirstWindowFocusChanged == true) goto L38;
        AppInstrumentation.launcherActivityOnWindowFocusChangedStart(sActivityName);
        isFirstWindowFocusChanged = true;
    L38:
        long r13 = System.currentTimeMillis();
        sOnWindowFocusedChangeStart = r13;
        if ((r13 - sOnCreateStart) < PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L44;
    L41:
        sOnCreateStart = 0;
        sActivityName = null;
        return;
    L44:
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L43
        r14.put("begin_time", sOnCreateStart);     // Catch: Exception -> L43
        r14.put("end_time", sOnWindowFocusedChangeStart);     // Catch: Exception -> L43
        r14.put("page_type", "activity");     // Catch: Exception -> L43
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L43
        r15.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L43
        r15.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L43
        r15.put("activityOnCreateToWindowFocusChanged", sOnWindowFocusedChangeStart - sOnCreateStart);     // Catch: Exception -> L43
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L43
        r16.put("scene", sActivityName);     // Catch: Exception -> L43
        r16.put("is_first", !sMethodSet.contains(sActivityName + r11));     // Catch: Exception -> L43
        sMethodSet.add(sActivityName + r11);     // Catch: Exception -> L43
        MonitorTool.monitorPerformance("page_load", r15, r16, r14);     // Catch: Exception -> L43
        goto L41
    }
}
