package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import bt3.b;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import ft3.a;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AutoPageTraceHelper {
    private static boolean sIsFirstWindowFocusChangedActivity;
    private static long sMaxValidTimeMs;
    private static final HashSet<String> sMethodSet = null;
    private static final ConcurrentLinkedQueue<PageTraceEntity> sPageList = null;

    public AutoPageTraceHelper() {
    }

    static {
        sMethodSet = new HashSet(32);
        sPageList = new ConcurrentLinkedQueue();
        sMaxValidTimeMs = 20000;
    }

    private static void reportStats() {
        int r100 = sPageList.size();     // Catch: Exception -> L36
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L55;
        ConcurrentLinkedQueue<PageTraceEntity> r102 = sPageList;     // Catch: Exception -> L36
        PageTraceEntity r103 = r102.peek();     // Catch: Exception -> L36
        if (r103 == null) goto L56;
        if (r103.onWindowFocusTs == 0) goto L10;
    L12:
        PageTraceEntity r104 = r102.poll();     // Catch: Exception -> L36
        if (r104.isCreateAndResumeValid() == false) goto L53;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L36
        r105.put("name", WidgetCostModule.TYPE_ON_CREATE);     // Catch: Exception -> L36
        r105.put("start", r104.onCreateStartTs);     // Catch: Exception -> L36
        r105.put("end", r104.onCreateEndTs);     // Catch: Exception -> L36
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L36
        r106.put("name", "onResume");     // Catch: Exception -> L36
        r106.put("start", r104.onResumeStartTs);     // Catch: Exception -> L36
        r106.put("end", r104.onResumeEndTs);     // Catch: Exception -> L36
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L36
        r107.put("name", "onWindowFocusChanged");     // Catch: Exception -> L36
        r107.put("start", r104.onWindowFocusTs);     // Catch: Exception -> L36
        JSONArray r110 = new JSONArray();     // Catch: Exception -> L36
        r110.put(r105);     // Catch: Exception -> L36
        r110.put(r106);     // Catch: Exception -> L36
        r110.put(r107);     // Catch: Exception -> L36
        if (r104.onViewShowTs <= 0) goto L18;
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L36
        r108.put("name", "viewShow");     // Catch: Exception -> L36
        r108.put("start", r104.onViewShowTs);     // Catch: Exception -> L36
        r110.put(r108);     // Catch: Exception -> L36
    L18:
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L36
        r109.put("name", "page_load_stats");     // Catch: Exception -> L36
        r109.put("page_type", "activity");     // Catch: Exception -> L36
        r109.put("start", r104.onCreateStartTs);     // Catch: Exception -> L36
        long r111 = r104.onViewShowTs;     // Catch: Exception -> L36
        if (r111 <= 0) goto L25;
        r109.put("end", r111);     // Catch: Exception -> L36
        long r112 = r104.onViewShowTs;     // Catch: Exception -> L36
        long r113 = r104.onCreateStartTs;     // Catch: Exception -> L36
        if ((r112 - r113) < 0) goto L35;
        if ((r112 - r113) > sMaxValidTimeMs) goto L35;
    L30:
        r109.put("spans", r110);     // Catch: Exception -> L36
        HashSet<String> r114 = sMethodSet;     // Catch: Exception -> L36
        if (r114.contains(r104.pageName) == false) goto L33;
        int r115 = 2;
    L34:
        r114.add(r104.pageName);     // Catch: Exception -> L36
        r109.put(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD, r115);     // Catch: Exception -> L36
        r109.put("collect_from", 1);     // Catch: Exception -> L36
        r109.put("page_name", r104.pageName);     // Catch: Exception -> L36
        JSONObject r116 = new JSONObject();     // Catch: Exception -> L36
        r116.put("trace", r109);     // Catch: Exception -> L36
        MonitorTool.monitorPerformance("page_load_trace", null, null, r116);     // Catch: Exception -> L36
        goto L35
    L33:
        r115 = 1;
    L35:
        r101 = r101 + 1;
        goto L4
    L25:
        r109.put("end", r104.onWindowFocusTs);     // Catch: Exception -> L36
        long r117 = r104.onWindowFocusTs;     // Catch: Exception -> L36
        long r118 = r104.onCreateStartTs;     // Catch: Exception -> L36
        if ((r117 - r118) < 0) goto L35;
        if ((r117 - r118) <= sMaxValidTimeMs) goto L30;
    L53:
        return;
    L10:
        if (r103.onViewShowTs != 0) goto L12;
        return;
    L56:
        return;
    L55:
        return;
    L36:
        e = move-exception;
        if (d.j() == false) goto L54;
        e.printStackTrace();
        return;
    }

    public static /* synthetic */ void access$000() {
        reportStats();
    }

    public static void setMaxValidTimeMs(long r100) {
        sMaxValidTimeMs = r100;
    }

    public static void reportViewIdStats(long r100, String r101) {
        PageTraceEntity r102 = sPageList.peek();
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r101, r102.pageName) == false) goto L10;
        r102.onViewShowTs = r100;
        b.d.f20539a.e(new AnonymousClass2());
        return;
    }

    public static void onTrace(String r100, String r101, boolean r102) {
        if (TextUtils.equals(WidgetCostModule.TYPE_ON_CREATE, r101) == false) goto L19;
        if (r102 == false) goto L13;
        if (sIsFirstWindowFocusChangedActivity == true) goto L8;
        AutoLaunchTraceHelper.launcherActivityOnCreateStart(r100);
    L8:
        ConcurrentLinkedQueue<PageTraceEntity> r103 = sPageList;
        if (r103.size() <= 50) goto L11;
        r103.poll();
    L11:
        r103.add(new PageTraceEntity(r100, System.currentTimeMillis()));
        return;
    L13:
        if (sIsFirstWindowFocusChangedActivity == true) goto L15;
        AutoLaunchTraceHelper.launcherActivityOnCreateEnd();
    L15:
        PageTraceEntity r104 = sPageList.peek();
        if (r104 == null) goto L57;
        r104.onCreateEndTs = System.currentTimeMillis();
        return;
    L57:
        return;
    L19:
        if (TextUtils.equals("onResume", r101) == false) goto L34;
        if (r102 == false) goto L28;
        if (sIsFirstWindowFocusChangedActivity == true) goto L24;
        AutoLaunchTraceHelper.launcherActivityOnResumeStart(r100);
    L24:
        PageTraceEntity r105 = sPageList.peek();
        if (r105 == null) goto L59;
        r105.onResumeStartTs = System.currentTimeMillis();
        return;
    L59:
        return;
    L28:
        if (sIsFirstWindowFocusChangedActivity == true) goto L30;
        AutoLaunchTraceHelper.launcherActivityOnResumeEnd();
    L30:
        PageTraceEntity r106 = sPageList.peek();
        if (r106 == null) goto L61;
        r106.onResumeEndTs = System.currentTimeMillis();
        return;
    L61:
        return;
    L34:
        if (TextUtils.equals("onWindowFocusChanged", r101) == false) goto L47;
        if (r102 == true) goto L37;
        return;
    L37:
        if (sIsFirstWindowFocusChangedActivity == true) goto L39;
        AutoLaunchTraceHelper.launcherActivityOnWindowFocusChangedStart(r100);
        sIsFirstWindowFocusChangedActivity = true;
    L39:
        PageTraceEntity r107 = sPageList.peek();
        if (r107 != null) goto L42;
        return;
    L42:
        if (r107.onWindowFocusTs != 0) goto L65;
        r107.onWindowFocusTs = System.currentTimeMillis();
        if (a.a(r100) != null) goto L66;
        b.d.f20539a.e(new AnonymousClass1());
        return;
    L66:
        return;
    L65:
        return;
    L47:
        if (TextUtils.equals(WidgetCostModule.TYPE_ON_START, r101) == false) goto L68;
        if (r102 == false) goto L53;
        if (sIsFirstWindowFocusChangedActivity == true) goto L69;
        AutoLaunchTraceHelper.launcherActivityOnStartStart(r100);
        return;
    L69:
        return;
    L53:
        if (sIsFirstWindowFocusChangedActivity == true) goto L71;
        AutoLaunchTraceHelper.launcherActivityOnStartEnd(r100);
        return;
    L71:
        return;
    }
}
