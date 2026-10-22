package com.bytedance.apm.agent.tracing;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import h2.a;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class AutoPageTraceHelper {
    private static boolean sIsFirstWindowFocusChangedActivity;
    private static long sMaxValidTimeMs;
    private static final HashSet<String> sMethodSet = null;
    private static final ConcurrentLinkedQueue<PageTraceEntity> sPageList = null;

    static {
        sMethodSet = new HashSet(32);
        sPageList = new ConcurrentLinkedQueue();
        sMaxValidTimeMs = 20000;
    }

    public AutoPageTraceHelper() {
    }

    public static /* synthetic */ void access$000() {
        reportStats();
    }

    @Keep
    public static void onTrace(String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L19;
        if (r12 == false) goto L13;
        if (sIsFirstWindowFocusChangedActivity == true) goto L8;
        AutoLaunchTraceHelper.launcherActivityOnCreateStart(r10);
    L8:
        ConcurrentLinkedQueue<PageTraceEntity> r13 = sPageList;
        if (r13.size() <= 50) goto L11;
        r13.poll();
    L11:
        r13.add(new PageTraceEntity(r10, System.currentTimeMillis()));
        return;
    L13:
        if (sIsFirstWindowFocusChangedActivity == true) goto L15;
        AutoLaunchTraceHelper.launcherActivityOnCreateEnd();
    L15:
        PageTraceEntity r14 = sPageList.peek();
        if (r14 == null) goto L57;
        r14.onCreateEndTs = System.currentTimeMillis();
        return;
    L57:
        return;
    L19:
        if (TextUtils.equals("onResume", r11) == false) goto L34;
        if (r12 == false) goto L28;
        if (sIsFirstWindowFocusChangedActivity == true) goto L24;
        AutoLaunchTraceHelper.launcherActivityOnResumeStart(r10);
    L24:
        PageTraceEntity r15 = sPageList.peek();
        if (r15 == null) goto L59;
        r15.onResumeStartTs = System.currentTimeMillis();
        return;
    L59:
        return;
    L28:
        if (sIsFirstWindowFocusChangedActivity == true) goto L30;
        AutoLaunchTraceHelper.launcherActivityOnResumeEnd();
    L30:
        PageTraceEntity r16 = sPageList.peek();
        if (r16 == null) goto L61;
        r16.onResumeEndTs = System.currentTimeMillis();
        return;
    L61:
        return;
    L34:
        if (TextUtils.equals("onWindowFocusChanged", r11) == false) goto L47;
        if (r12 == true) goto L37;
        return;
    L37:
        if (sIsFirstWindowFocusChangedActivity == true) goto L39;
        AutoLaunchTraceHelper.launcherActivityOnWindowFocusChangedStart(r10);
        sIsFirstWindowFocusChangedActivity = true;
    L39:
        PageTraceEntity r17 = sPageList.peek();
        if (r17 != null) goto L42;
        return;
    L42:
        if (r17.onWindowFocusTs != 0) goto L65;
        r17.onWindowFocusTs = System.currentTimeMillis();
        if (a.c(r10) != null) goto L66;
        AsyncEventManager.e().h(new AnonymousClass1());
        return;
    L66:
        return;
    L65:
        return;
    L47:
        if (TextUtils.equals("onStart", r11) == false) goto L68;
        if (r12 == false) goto L53;
        if (sIsFirstWindowFocusChangedActivity == true) goto L69;
        AutoLaunchTraceHelper.launcherActivityOnStartStart(r10);
        return;
    L69:
        return;
    L53:
        if (sIsFirstWindowFocusChangedActivity == true) goto L71;
        AutoLaunchTraceHelper.launcherActivityOnStartEnd(r10);
        return;
    L71:
        return;
    }

    private static void reportStats() {
        int r10 = sPageList.size();     // Catch: Exception -> L12
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L59;
        ConcurrentLinkedQueue<PageTraceEntity> r12 = sPageList;     // Catch: Exception -> L12
        PageTraceEntity r13 = r12.peek();     // Catch: Exception -> L12
        if (r13 == null) goto L60;
        if (r13.onWindowFocusTs == 0) goto L10;
    L14:
        PageTraceEntity r14 = r12.poll();     // Catch: Exception -> L12
        if (r14.isCreateAndResumeValid() == false) goto L57;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L12
        r15.put("name", "onCreate");     // Catch: Exception -> L12
        r15.put("start", r14.onCreateStartTs);     // Catch: Exception -> L12
        r15.put("end", r14.onCreateEndTs);     // Catch: Exception -> L12
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L12
        r16.put("name", "onResume");     // Catch: Exception -> L12
        r16.put("start", r14.onResumeStartTs);     // Catch: Exception -> L12
        r16.put("end", r14.onResumeEndTs);     // Catch: Exception -> L12
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L12
        r17.put("name", "onWindowFocusChanged");     // Catch: Exception -> L12
        r17.put("start", r14.onWindowFocusTs);     // Catch: Exception -> L12
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L12
        r18.put(r15);     // Catch: Exception -> L12
        r18.put(r16);     // Catch: Exception -> L12
        r18.put(r17);     // Catch: Exception -> L12
        if (r14.onViewShowTs <= 0) goto L20;
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L12
        r19.put("name", "viewShow");     // Catch: Exception -> L12
        r19.put("start", r14.onViewShowTs);     // Catch: Exception -> L12
        r18.put(r19);     // Catch: Exception -> L12
    L20:
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L12
        r20.put("name", TraceStatsConsts.PAGE_LOAD_STATS_NAME);     // Catch: Exception -> L12
        r20.put("page_type", "activity");     // Catch: Exception -> L12
        r20.put("start", r14.onCreateStartTs);     // Catch: Exception -> L12
        long r21 = r14.onViewShowTs;     // Catch: Exception -> L12
        if (r21 <= 0) goto L27;
        r20.put("end", r21);     // Catch: Exception -> L12
        long r22 = r14.onViewShowTs;     // Catch: Exception -> L12
        long r110 = r14.onCreateStartTs;     // Catch: Exception -> L12
        if ((r22 - r110) < 0) goto L40;
        if ((r22 - r110) > sMaxValidTimeMs) goto L40;
    L32:
        r20.put(TraceStatsConsts.STATS_KEY_SPANS, r18);     // Catch: Exception -> L12
        HashSet<String> r23 = sMethodSet;     // Catch: Exception -> L12
        if (r23.contains(r14.pageName) == false) goto L35;
        int r24 = 2;
    L36:
        r23.add(r14.pageName);     // Catch: Exception -> L12
        r20.put(TraceStatsConsts.STATS_KEY_LAUNCH_MODE, r24);     // Catch: Exception -> L12
        r20.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);     // Catch: Exception -> L12
        r20.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r14.pageName);     // Catch: Exception -> L12
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L12
        r25.put(TraceStatsConsts.STATS_KEY_TRACE, r20);     // Catch: Exception -> L12
        if (s1.a.e() == false) goto L39;
        s1.a.b("PageLoadTrace", r20.toString());     // Catch: Exception -> L12
    L39:
        MonitorTool.monitorPerformance("page_load_trace", null, null, r25);     // Catch: Exception -> L12
        goto L40
    L35:
        r24 = 1;
    L40:
        r11 = r11 + 1;
        goto L4
    L27:
        r20.put("end", r14.onWindowFocusTs);     // Catch: Exception -> L12
        long r26 = r14.onWindowFocusTs;     // Catch: Exception -> L12
        long r111 = r14.onCreateStartTs;     // Catch: Exception -> L12
        if ((r26 - r111) < 0) goto L40;
        if ((r26 - r111) <= sMaxValidTimeMs) goto L32;
    L57:
        return;
    L10:
        if (r13.onViewShowTs != 0) goto L14;
        return;
    L60:
        return;
    L59:
        return;
    L12:
        e = move-exception;
        if (c.B() == false) goto L58;
        e.printStackTrace();
        return;
    }

    public static void reportViewIdStats(long r10, String r11) {
        PageTraceEntity r12 = sPageList.peek();
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r11, r12.pageName) == false) goto L10;
        r12.onViewShowTs = r10;
        AsyncEventManager.e().h(new AnonymousClass2());
        return;
    }

    public static void setMaxValidTimeMs(long r10) {
        sMaxValidTimeMs = r10;
    }
}
