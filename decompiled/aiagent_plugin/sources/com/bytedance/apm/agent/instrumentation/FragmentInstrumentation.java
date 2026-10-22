package com.bytedance.apm.agent.instrumentation;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.apm.agent.a.c;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.trace.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    public FragmentInstrumentation() {
    }

    static /* synthetic */ WeakReference access$000() {
        return sRootViewRef;
    }

    static /* synthetic */ WeakReference access$002(WeakReference r0) {
        sRootViewRef = r0;
        return r0;
    }

    static /* synthetic */ long access$100() {
        return sCheckVisibilityStartTime;
    }

    static /* synthetic */ long access$102(long r0) {
        sCheckVisibilityStartTime = r0;
        return r0;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$200() {
        return sOnGlobalLayoutListener;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$202(ViewTreeObserver.OnGlobalLayoutListener r2) {
        ViewTreeObserver.OnGlobalLayoutListener r3 = (ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.wrapperContextForParams(r2, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin");
        sOnGlobalLayoutListener = r3;
        return r3;
    }

    static /* synthetic */ Runnable access$300() {
        return sWaitViewTimeoutRunnable;
    }

    static /* synthetic */ long access$400() {
        return sMaxWaitTime;
    }

    static /* synthetic */ String access$500() {
        return sFragmentName;
    }

    public static void onResume(Fragment r7) {
        if (r7.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r7.isHidden() == true) goto L16;
        String r1 = r7.getClass().getCanonicalName();
        c.a(r7, true);     // Catch: Exception -> L12
        if (TextUtils.equals(r1, sOnCreateFragmentName) == true) goto L10;
        return;
    L10:
        Integer r3 = a.a(r1);     // Catch: Exception -> L12
        registerOnGlobalLayoutListener(r1, r7.getView(), r3, sOnCreateTime, "fragmentOnCreateToViewShow");     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    public static void onPause(Fragment r1) {
        if (r1.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r1.isHidden() == true) goto L9;
        c.a(r1, false);
        return;
    }

    public static void onHiddenChanged(Fragment r6, boolean r7) {
        c.a(r6, !r7);
        if (r7 == true) goto L9;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L6
        registerOnGlobalLayoutListener(r0, r6.getView(), a.a(r0), System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public static void setUserVisibleHint(Fragment r6, boolean r7) {
        if (r6.isResumed() == true) goto L5;
        return;
    L5:
        if (r6.isHidden() == true) goto L14;
        c.a(r6, r7);
        if (r7 == false) goto L15;
        String r0 = r6.getClass().getCanonicalName();     // Catch: Exception -> L10
        Integer r2 = a.a(r0);     // Catch: Exception -> L10
        registerOnGlobalLayoutListener(r0, r6.getView(), r2, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    }

    public static void onCreate(String r4) {
        sOnCreateFragmentName = r4;
        sOnCreateTime = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L6;
        sMaxWaitTime = ApmDelegate.a().c().c();
        return;
    }

    private static void registerOnGlobalLayoutListener(String r2, View r3, final Integer r4, final long r5, final String r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.intValue() <= 0) goto L21;
        sFragmentName = r2;
        WeakReference<View> r6 = sRootViewRef;
        if (r6 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r3);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new AnonymousClass1(r4, r5, r7);
        r3.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new AnonymousClass2();
        com.bytedance.apm.thread.a.a().postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r6.get() == r3) goto L18;
        ViewTreeObserver r8 = ((View) ZeusTransformUtils.preCheckCast(sRootViewRef.get(), View.class, "com.obric.aiagent.plugin")).getViewTreeObserver();
        if (r8.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r0 = sOnGlobalLayoutListener;
        if (r0 == null) goto L16;
        r8.removeOnGlobalLayoutListener(r0);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        com.bytedance.apm.thread.a.a().removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }

    static {
        sMethodSet = new HashSet(32);
    }

    static boolean isValid(String r1) {
        if (TextUtils.isEmpty(sFragmentName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r1, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static void onTrace(Fragment r12, String r13, String r14, boolean r15) {
        if (TextUtils.equals("onCreate", r14) == false) goto L10;
        if (r15 == false) goto L7;
        sFragmentName = r13;
        sOnCreateStart = System.currentTimeMillis();
        return;
    L7:
        if (isValid(r13) == false) goto L59;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L59:
        return;
    L10:
        if (TextUtils.equals("onViewCreated", r14) == false) goto L21;
        if (isValid(r13) == false) goto L21;
        if (r15 == false) goto L18;
        if (sOnCreateStart <= 0) goto L61;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L61:
        return;
    L18:
        if (sOnCreateStart <= 0) goto L63;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L63:
        return;
    L21:
        if (TextUtils.equals("onActivityCreated", r14) == false) goto L32;
        if (isValid(r13) == false) goto L32;
        if (r15 == false) goto L29;
        if (sOnCreateStart <= 0) goto L65;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L65:
        return;
    L29:
        if (sOnCreateStart <= 0) goto L67;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L67:
        return;
    L32:
        if (TextUtils.equals("onResume", r14) == true) goto L34;
        return;
    L34:
        if (isValid(r13) == false) goto L70;
        if (r15 == false) goto L40;
        if (sOnCreateStart <= 0) goto L71;
        sOnResumeStart = System.currentTimeMillis();
        return;
    L71:
        return;
    L40:
        if (sOnCreateStart <= 0) goto L73;
        long r7 = System.currentTimeMillis();
        sOnResumeEnd = r7;
        if ((r7 - sOnCreateStart) < 5000) goto L56;
    L53:
        sOnCreateStart = 0;
        sFragmentName = null;
        return;
    L56:
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L55
        r16.put("begin_time", sOnCreateStart);     // Catch: Exception -> L55
        r16.put("end_time", sOnResumeEnd);     // Catch: Exception -> L55
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L55
        r8.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L55
        r8.put("onViewCreated", sOnViewCreatedEnd - sOnViewCreatedStart);     // Catch: Exception -> L55
        r8.put("onActivityCreated", sOnActivityCreatedEnd - sOnActivityCreatedStart);     // Catch: Exception -> L55
        r8.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L55
        r8.put("fragment_create_to_resume", sOnResumeEnd - sOnCreateStart);     // Catch: Exception -> L55
        if (r12 != null) goto L46;
    L48:
        r16.put("page_type", "fragment");     // Catch: Exception -> L55
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L55
        if (sMethodSet.contains(sFragmentName + r14) == true) goto L51;
        boolean r1 = true;
    L52:
        r17.put("is_first", r1);     // Catch: Exception -> L55
        r17.put(DBHelper.BATTERY_COL_SCENE, r13);     // Catch: Exception -> L55
        sMethodSet.add(sFragmentName + r14);     // Catch: Exception -> L55
        com.bytedance.apm.agent.b.a.a("page_load", r8, r17, r16);     // Catch: Exception -> L55
        goto L53
    L51:
        r1 = false;
        goto L52
    L46:
        if (((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")) == null) goto L48;
        r16.put("attached_activity", ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).getClass().getName());     // Catch: Exception -> L55
        goto L48
    L73:
        return;
    }
}
