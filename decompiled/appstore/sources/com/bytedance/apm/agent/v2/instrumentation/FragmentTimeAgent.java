package com.bytedance.apm.agent.v2.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.AsyncEventManager;
import h2.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentTimeAgent {
    private static final String TAG = "FragmentTimeAgent";
    private static long sCheckVisibilityStartTime = 0;
    private static String sFragmentName = null;
    private static long sMaxWaitTime = 60000;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static boolean sReported;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    static {
        sMethodSet = new HashSet(32);
    }

    public FragmentTimeAgent() {
    }

    public static /* synthetic */ String access$000() {
        return sFragmentName;
    }

    public static /* synthetic */ HashSet access$100() {
        return sMethodSet;
    }

    public static /* synthetic */ void access$200(boolean r10, String r11, long r12, long r13) {
        reportStats(r10, r11, r12, r13);
    }

    public static /* synthetic */ WeakReference access$300() {
        return sRootViewRef;
    }

    public static /* synthetic */ WeakReference access$302(WeakReference r10) {
        sRootViewRef = r10;
        return r10;
    }

    public static /* synthetic */ long access$400() {
        return sCheckVisibilityStartTime;
    }

    public static /* synthetic */ long access$402(long r10) {
        sCheckVisibilityStartTime = r10;
        return r10;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$500() {
        return sOnGlobalLayoutListener;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$502(ViewTreeObserver.OnGlobalLayoutListener r10) {
        sOnGlobalLayoutListener = r10;
        return r10;
    }

    public static /* synthetic */ Runnable access$600() {
        return sWaitViewTimeoutRunnable;
    }

    public static /* synthetic */ long access$700() {
        return sMaxWaitTime;
    }

    public static /* synthetic */ void access$800(String r10, String r11, long r12, long r13) {
        reportTraceTime(r10, r11, r12, r13);
    }

    private static boolean isValid(String r10) {
        if (sReported == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r10, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onHiddenChanged(Fragment r10, boolean r11) {
        if (r11 == false) goto L12;
        return;
    L12:
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L11
        Integer r13 = a.c(r12);     // Catch: Exception -> L11
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.intValue() <= 0) goto L15;
        registerOnGlobalLayoutListener(r12, r10.getView(), r13, System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    public static void onResumeShow(Fragment r10, String r11) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L20;
        Integer r12 = a.c(r11);     // Catch: Exception -> L14
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.intValue() <= 0) goto L19;
        registerOnGlobalLayoutListener(r11, r10.getView(), r12, sOnCreateStart, "fragmentOnCreateToViewShow");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    @Keep
    public static void onTrace(Fragment r10, String r11, String r12, boolean r13) {
        if (TextUtils.equals("onCreate", r12) == false) goto L13;
        if (r13 == false) goto L10;
        sFragmentName = r11;
        sOnCreateStart = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L8;
        sMaxWaitTime = ApmDelegate.j().h().i();
    L8:
        sReported = false;
        return;
    L10:
        if (isValid(r11) == false) goto L56;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L56:
        return;
    L13:
        if (TextUtils.equals("onViewCreated", r12) == false) goto L24;
        if (isValid(r11) == false) goto L24;
        if (r13 == false) goto L21;
        if (sOnCreateStart <= 0) goto L58;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L58:
        return;
    L21:
        if (sOnCreateStart <= 0) goto L60;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L60:
        return;
    L24:
        if (TextUtils.equals("onActivityCreated", r12) == false) goto L35;
        if (isValid(r11) == false) goto L35;
        if (r13 == false) goto L32;
        if (sOnCreateStart <= 0) goto L62;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L62:
        return;
    L32:
        if (sOnCreateStart <= 0) goto L64;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L64:
        return;
    L35:
        if (TextUtils.equals("onResume", r12) == true) goto L37;
        return;
    L37:
        if (isValid(r11) == false) goto L67;
        if (r13 == false) goto L43;
        if (sOnCreateStart <= 0) goto L68;
        sOnResumeStart = System.currentTimeMillis();
        onResumeShow(r10, r11);
        return;
    L68:
        return;
    L43:
        if (sOnCreateStart <= 0) goto L70;
        sOnResumeEnd = System.currentTimeMillis();
        Integer r14 = a.c(r11);     // Catch: Exception -> L52
        if (r14 != null) goto L48;
    L49:
        AsyncEventManager.e().h(new AnonymousClass1());     // Catch: Exception -> L52
        goto L50
    L48:
        if (r14.intValue() <= 0) goto L49;
    L50:
        sReported = true;
        sFragmentName = null;
        return;
    L70:
        return;
    }

    @TargetApi(16)
    private static void registerOnGlobalLayoutListener(String r10, View r11, final Integer r12, final long r13, final String r14) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.intValue() <= 0) goto L21;
        sFragmentName = r10;
        WeakReference<View> r15 = sRootViewRef;
        if (r15 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r11);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new AnonymousClass3(r12, r13, r14);
        r11.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new AnonymousClass4();
        d2.a.a().postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r15.get() == r11) goto L18;
        ViewTreeObserver r16 = sRootViewRef.get().getViewTreeObserver();
        if (r16.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r17 = sOnGlobalLayoutListener;
        if (r17 == null) goto L16;
        r16.removeOnGlobalLayoutListener(r17);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        d2.a.a().removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }

    private static void reportStats(boolean r10, String r11, long r12, long r13) {
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L6
        r14.put("name", "onCreate");     // Catch: Exception -> L6
        r14.put("start", sOnCreateStart);     // Catch: Exception -> L6
        r14.put("end", sOnCreateEnd);     // Catch: Exception -> L6
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L6
        r15.put("name", "onViewCreated");     // Catch: Exception -> L6
        r15.put("start", sOnViewCreatedStart);     // Catch: Exception -> L6
        r15.put("end", sOnViewCreatedEnd);     // Catch: Exception -> L6
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L6
        r16.put("name", "onActivityCreated");     // Catch: Exception -> L6
        r16.put("start", sOnActivityCreatedStart);     // Catch: Exception -> L6
        r16.put("end", sOnActivityCreatedEnd);     // Catch: Exception -> L6
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L6
        r17.put("name", "onResume");     // Catch: Exception -> L6
        r17.put("start", sOnResumeStart);     // Catch: Exception -> L6
        r17.put("end", sOnResumeEnd);     // Catch: Exception -> L6
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L6
        r18.put(r14);     // Catch: Exception -> L6
        r18.put(r15);     // Catch: Exception -> L6
        r18.put(r16);     // Catch: Exception -> L6
        r18.put(r17);     // Catch: Exception -> L6
        if (r11 == null) goto L8;
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L6
        r19.put("name", r11);     // Catch: Exception -> L6
        r19.put("start", r12);     // Catch: Exception -> L6
        r19.put("end", r13);     // Catch: Exception -> L6
        r18.put(r19);     // Catch: Exception -> L6
    L8:
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L6
        r110.put("name", TraceStatsConsts.PAGE_LOAD_STATS_NAME);     // Catch: Exception -> L6
        r110.put("page_type", "fragment");     // Catch: Exception -> L6
        r110.put("start", sOnCreateStart);     // Catch: Exception -> L6
        r110.put(TraceStatsConsts.STATS_KEY_SPANS, r18);     // Catch: Exception -> L6
        if (r10 == false) goto L11;
        int r20 = 2;
    L12:
        r110.put(TraceStatsConsts.STATS_KEY_LAUNCH_MODE, r20);     // Catch: Exception -> L6
        r110.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 1);     // Catch: Exception -> L6
        r110.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, sFragmentName);     // Catch: Exception -> L6
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L6
        r21.put(TraceStatsConsts.STATS_KEY_TRACE, r110);     // Catch: Exception -> L6
        MonitorTool.monitorPerformance("page_load_trace", null, null, r21);     // Catch: Exception -> L6
        return;
    L11:
        r20 = 1;
    L6:
        e = move-exception;
        if (c.B() == false) goto L20;
        e.printStackTrace();
        return;
    }

    private static void reportTraceTime(String r10, final String r11, final long r12, final long r13) {
        AsyncEventManager.e().h(new AnonymousClass2(r11, r12, r13));
    }

    @Keep
    public static void setUserVisibleHint(Fragment r10, boolean r11) {
        if (r11 == true) goto L4;
        return;
    L4:
        if (r10.isResumed() == true) goto L6;
        return;
    L6:
        if (r10.isHidden() == true) goto L22;
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L15
        Integer r13 = a.c(r12);     // Catch: Exception -> L15
        if (r13 != null) goto L11;
        return;
    L11:
        if (r13.intValue() <= 0) goto L21;
        registerOnGlobalLayoutListener(r12, r10.getView(), r13, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L15
        return;
    L21:
        return;
    L23:
        return;
    }
}
