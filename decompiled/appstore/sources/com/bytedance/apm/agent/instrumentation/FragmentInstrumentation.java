package com.bytedance.apm.agent.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.helper.PageShowHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.internal.ApmDelegate;
import h2.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentInstrumentation {
    private static final String TAG = "FragmentInstrumentation";
    private static long sCheckVisibilityStartTime;
    private static String sFragmentName;
    private static long sMaxWaitTime;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static String sOnCreateFragmentName;
    private static long sOnCreateStart;
    private static long sOnCreateTime;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    static {
        sMethodSet = new HashSet(32);
    }

    public FragmentInstrumentation() {
    }

    public static /* synthetic */ WeakReference access$000() {
        return sRootViewRef;
    }

    public static /* synthetic */ WeakReference access$002(WeakReference r10) {
        sRootViewRef = r10;
        return r10;
    }

    public static /* synthetic */ long access$100() {
        return sCheckVisibilityStartTime;
    }

    public static /* synthetic */ long access$102(long r10) {
        sCheckVisibilityStartTime = r10;
        return r10;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$200() {
        return sOnGlobalLayoutListener;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$202(ViewTreeObserver.OnGlobalLayoutListener r10) {
        sOnGlobalLayoutListener = r10;
        return r10;
    }

    public static /* synthetic */ Runnable access$300() {
        return sWaitViewTimeoutRunnable;
    }

    public static /* synthetic */ long access$400() {
        return sMaxWaitTime;
    }

    public static /* synthetic */ String access$500() {
        return sFragmentName;
    }

    public static boolean isValid(String r10) {
        if (TextUtils.isEmpty(sFragmentName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r10, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onCreate(String r10) {
        sOnCreateFragmentName = r10;
        sOnCreateTime = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L6;
        sMaxWaitTime = ApmDelegate.j().h().i();
        return;
    }

    @Keep
    public static void onHiddenChanged(Fragment r10, boolean r11) {
        PageShowHelper.onPageShowHideAction(r10, !r11);
        if (r11 == true) goto L9;
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L6
        registerOnGlobalLayoutListener(r12, r10.getView(), a.c(r12), System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Keep
    public static void onPause(Fragment r10) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L9;
        PageShowHelper.onPageShowHideAction(r10, false);
        return;
    }

    @Keep
    public static void onResume(Fragment r10) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L16;
        String r11 = r10.getClass().getCanonicalName();
        PageShowHelper.onPageShowHideAction(r10, true);     // Catch: Exception -> L12
        if (TextUtils.equals(r11, sOnCreateFragmentName) == true) goto L10;
        return;
    L10:
        Integer r12 = a.c(r11);     // Catch: Exception -> L12
        registerOnGlobalLayoutListener(r11, r10.getView(), r12, sOnCreateTime, "fragmentOnCreateToViewShow");     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    @Keep
    public static void onTrace(Fragment r11, String r12, String r13, boolean r14) {
        if (TextUtils.equals("onCreate", r13) == false) goto L10;
        if (r14 == false) goto L7;
        sFragmentName = r12;
        sOnCreateStart = System.currentTimeMillis();
        return;
    L7:
        if (isValid(r12) == false) goto L55;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L55:
        return;
    L10:
        if (TextUtils.equals("onViewCreated", r13) == false) goto L21;
        if (isValid(r12) == false) goto L21;
        if (r14 == false) goto L18;
        if (sOnCreateStart <= 0) goto L57;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L57:
        return;
    L18:
        if (sOnCreateStart <= 0) goto L59;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L59:
        return;
    L21:
        if (TextUtils.equals("onActivityCreated", r13) == false) goto L32;
        if (isValid(r12) == false) goto L32;
        if (r14 == false) goto L29;
        if (sOnCreateStart <= 0) goto L61;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L61:
        return;
    L29:
        if (sOnCreateStart <= 0) goto L63;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L63:
        return;
    L32:
        if (TextUtils.equals("onResume", r13) == true) goto L34;
        return;
    L34:
        if (isValid(r12) == false) goto L66;
        if (r14 == false) goto L40;
        if (sOnCreateStart <= 0) goto L67;
        sOnResumeStart = System.currentTimeMillis();
        return;
    L67:
        return;
    L40:
        if (sOnCreateStart <= 0) goto L69;
        long r10 = System.currentTimeMillis();
        sOnResumeEnd = r10;
        if ((r10 - sOnCreateStart) < PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L52;
    L49:
        sOnCreateStart = 0;
        sFragmentName = null;
        return;
    L52:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L51
        r15.put("begin_time", sOnCreateStart);     // Catch: Exception -> L51
        r15.put("end_time", sOnResumeEnd);     // Catch: Exception -> L51
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L51
        r16.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L51
        r16.put("onViewCreated", sOnViewCreatedEnd - sOnViewCreatedStart);     // Catch: Exception -> L51
        r16.put("onActivityCreated", sOnActivityCreatedEnd - sOnActivityCreatedStart);     // Catch: Exception -> L51
        r16.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L51
        r16.put("fragment_create_to_resume", sOnResumeEnd - sOnCreateStart);     // Catch: Exception -> L51
        if (r11 != null) goto L46;
    L48:
        r15.put("page_type", "fragment");     // Catch: Exception -> L51
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L51
        r17.put("is_first", !sMethodSet.contains(sFragmentName + r13));     // Catch: Exception -> L51
        r17.put("scene", r12);     // Catch: Exception -> L51
        sMethodSet.add(sFragmentName + r13);     // Catch: Exception -> L51
        MonitorTool.monitorPerformance("page_load", r16, r17, r15);     // Catch: Exception -> L51
        goto L49
    L46:
        if (r11.getActivity() == null) goto L48;
        r15.put("attached_activity", r11.getActivity().getClass().getName());     // Catch: Exception -> L51
        goto L48
    L69:
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
        sOnGlobalLayoutListener = new AnonymousClass1(r12, r13, r14);
        r11.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new AnonymousClass2();
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

    @Keep
    public static void setUserVisibleHint(Fragment r10, boolean r11) {
        if (r10.isResumed() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L14;
        PageShowHelper.onPageShowHideAction(r10, r11);
        if (r11 == false) goto L15;
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L10
        Integer r13 = a.c(r12);     // Catch: Exception -> L10
        registerOnGlobalLayoutListener(r12, r10.getView(), r13, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    }
}
