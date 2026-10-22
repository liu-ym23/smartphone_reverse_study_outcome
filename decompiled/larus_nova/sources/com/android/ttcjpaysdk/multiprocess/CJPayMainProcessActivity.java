package com.android.ttcjpaysdk.multiprocess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.BaseActivity;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayMainProcessActivity extends BaseActivity {
    public void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public int getLayout() {
        return R.layout.cj_pay_from_sub_process_activity;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public boolean isActivityPortrait() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private void executeApi() {
        Intent r100 = getIntent();
        if (r100 != null) goto L5;
        return;
    L5:
        if ("pay".equals(r100.getStringExtra(e.f25671s)) == false) goto L9;
        pay(r100);
        return;
    }

    public void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__onDestroy$___twin___() {
        ((ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class)).ttcjPaySetObserver(null);
        super.onDestroy();
    }

    public CJPayMainProcessActivity() {
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CJPayMainProcessActivity r100) {
        r100.com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(CJPayMainProcessActivity r110) {
        r110.com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L50
        if (r103 != null) goto L10;
    L13:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L50
        monitor-exit(r102);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r110.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r100.i("ActivityLancet", "quit !resume, current state = " + r110.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r110.isFinishing() == true) goto L24;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L36;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L47
        if (r104 != null) goto L41;
        return;
    L41:
        r104.addFlags(268435456);     // Catch: Throwable -> L47
        r104.addFlags(2097152);     // Catch: Throwable -> L47
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L47
        r110.startActivity(r104);     // Catch: Throwable -> L44
        r110.overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(CJPayMainProcessActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private void pay(Intent r110) {
        Serializable r100 = r110.getSerializableExtra("host_info");
        String r101 = r110.getStringExtra("sdk_info");
        int r102 = r110.getIntExtra("service", 0);
        String r103 = r110.getStringExtra("subWay");
        String r104 = r110.getStringExtra(AppConstants.BUNDLE_REFERER);
        String r105 = r110.getStringExtra("ext");
        if (r100 == null) goto L6;
        CJPayHostInfo r106 = (CJPayHostInfo) r100;
        r106.setContext(getActivity());
        ICJPayIntegratedCounterService r107 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        r107.ttcjPaySetHostInfo(r106);
        r107.ttcjPaySetObserver(new AnonymousClass1(this));
        r107.ttcjPayDoPay(r101, r102, r103, r104, r105, new AnonymousClass2(this));
        return;
    }

    public void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);
        initTranslucentStatusBar();
        executeApi();
    }

    public static void com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(CJPayMainProcessActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_android_ttcjpaysdk_multiprocess_CJPayMainProcessActivity__onCreate$___twin___(r101);
    }

    public static void pay(Context r100, CJPayHostInfo r101, String r102, int r103, String r104, String r105, String r106) {
        CJPayRouterAPI.getInstance().build(CJPayMainProcessActivity.class).withString(e.f25671s, "pay").withSerializable("host_info", r101).withString("sdk_info", r102).withInt("service", r103).withString("subWay", r104).withString(AppConstants.BUNDLE_REFERER, r105).withString("ext", r106).navigation(r100);
    }
}
