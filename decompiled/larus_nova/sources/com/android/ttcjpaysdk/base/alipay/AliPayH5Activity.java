package com.android.ttcjpaysdk.base.alipay;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.alipay.sdk.m.u.n;
import com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity;
import com.android.ttcjpaysdk.base.framework.mvp.nothing.LoggerNothing;
import com.android.ttcjpaysdk.base.framework.mvp.nothing.PresentorNothing;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayLoadingUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0014J\b\u0010!\u001a\u00020\u0014H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/alipay/AliPayH5Activity;", "Lcom/android/ttcjpaysdk/base/framework/mvp/MvpBaseLoggerActivity;", "Lcom/android/ttcjpaysdk/base/framework/mvp/nothing/PresentorNothing;", "Lcom/android/ttcjpaysdk/base/framework/mvp/nothing/LoggerNothing;", "()V", "isAliPayAppInstalled", "", "()Z", "setAliPayAppInstalled", "(Z)V", "mainFrameFinish", "getMainFrameFinish", "setMainFrameFinish", "rootView", "Landroid/widget/RelativeLayout;", "url", "", "webView", "Landroid/webkit/WebView;", "bindViews", "", "getLayoutId", "", "getModel", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "initActions", "initData", "initViews", "isNeedCloseAnimation", "isNeedSetStatusBar", TeaEventTrack.ACTION_DRAMA_NEXT, "onBackPressed", "onPause", "onResume", "base-pay-alipay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AliPayH5Activity extends MvpBaseLoggerActivity<PresentorNothing, LoggerNothing> {
    private boolean isAliPayAppInstalled;
    private boolean mainFrameFinish;
    private RelativeLayout rootView;
    private String url;
    private WebView webView;

    public void com_android_ttcjpaysdk_base_alipay_AliPayH5Activity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_base_alipay_AliPayH5Activity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_android_ttcjpaysdk_base_alipay_AliPayH5Activity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public int getLayoutId() {
        return R.layout.cj_pay_activity_alipay_web_layout;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public MvpModel getModel() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initActions() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public boolean isNeedCloseAnimation() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void next() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initViews() {
        if (this.isAliPayAppInstalled == false) goto L8;
        RelativeLayout r100 = this.rootView;
        if (r100 == null) goto L12;
        r100.setVisibility(8);
    L12:
        WebView r101 = this.webView;
        if (r101 == null) goto L16;
        r101.getSettings().setJavaScriptEnabled(true);
        r101.getSettings().setDefaultTextEncodingName("UTF-8");
        r101.getSettings().setDomStorageEnabled(true);
        r101.getSettings().setCacheMode(-1);
        r101.getSettings().setAllowFileAccess(false);
        r101.getSettings().setAllowContentAccess(false);
        r101.getSettings().setAllowFileAccessFromFileURLs(false);
        r101.getSettings().setAllowUniversalAccessFromFileURLs(false);
        r101.loadUrl(this.url);
        r101.setWebViewClient(new AliPayH5Activity$initViews$1$1(this));
    L16:
        if (this.isAliPayAppInstalled == false) goto L22;
        setFullScreenMode();
        View r102 = getLayoutRootView();
        if (r102 == null) goto L21;
        r102.setVisibility(8);
    L21:
        CJPayLoadingUtils.showFullPageHostLoading(this);
        return;
    L22:
        RelativeLayout r103 = this.rootView;
        if (r103 == null) goto L25;
        r103.setPadding(0, 0, 0, 0);
    L25:
        MvpBaseLoggerActivity.setTitleText$default(this, "", 0, 2, null);
        return;
    L8:
        RelativeLayout r104 = this.rootView;
        if (r104 == null) goto L12;
        r104.setVisibility(0);
        goto L12
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public boolean isNeedSetStatusBar() {
        if (this.isAliPayAppInstalled == false) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebView r100 = this.webView;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.canGoBack() == true) goto L7;
        finish();
        return;
    L7:
        r100.goBack();
    }

    public AliPayH5Activity() {
        this.url = "";
    }

    @Override // com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public void bindViews() {
        this.webView = (WebView) findViewById(R.id.cj_pay_alipay_h5_webview);
        this.rootView = (RelativeLayout) findViewById(R.id.cj_pay_alipay_h5_root_view);
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initData() {
        String r100 = getIntent().getStringExtra("alipay_h5_url");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.url = r100;
        this.isAliPayAppInstalled = CJPayBasicUtils.checkAppInstalled(this, n.f25868b);
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mainFrameFinish == true) goto L5;
        return;
    L5:
        if (this.isAliPayAppInstalled == false) goto L9;
        new Handler().postDelayed(new AnonymousClass1(this), 500);
        return;
    }

    public final boolean getMainFrameFinish() {
        return this.mainFrameFinish;
    }

    public final boolean isAliPayAppInstalled() {
        return this.isAliPayAppInstalled;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AliPayH5Activity r100) {
        r100.com_android_ttcjpaysdk_base_alipay_AliPayH5Activity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(AliPayH5Activity r110) {
        r110.com_android_ttcjpaysdk_base_alipay_AliPayH5Activity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AliPayH5Activity.class.getName()));
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

    public static void com_android_ttcjpaysdk_base_alipay_AliPayH5Activity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(AliPayH5Activity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_base_alipay_AliPayH5Activity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    public final void setAliPayAppInstalled(boolean r100) {
        this.isAliPayAppInstalled = r100;
    }

    public final void setMainFrameFinish(boolean r100) {
        this.mainFrameFinish = r100;
    }
}
