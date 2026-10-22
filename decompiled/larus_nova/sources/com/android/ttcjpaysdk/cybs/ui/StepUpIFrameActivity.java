package com.android.ttcjpaysdk.cybs.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.event.CJPay3DSResultEvent;
import com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity;
import com.android.ttcjpaysdk.base.framework.mvp.nothing.PresentorNothing;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.ui.CJPayInputKeyboardHelper;
import com.android.ttcjpaysdk.cybs.logger.StepUpLogger;
import com.android.ttcjpaysdk.cybs.utils.StringEscapeUtils;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/cybs/ui/StepUpIFrameActivity;", "Lcom/android/ttcjpaysdk/base/framework/mvp/MvpBaseLoggerActivity;", "Lcom/android/ttcjpaysdk/base/framework/mvp/nothing/PresentorNothing;", "Lcom/android/ttcjpaysdk/cybs/logger/StepUpLogger;", "()V", "STEP_UP_SCRIPT", "", "eventToken", "", "frameHeight", "frameToken", "frameUrl", "frameWidth", "verifyReturnUrlHost", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "bindViews", "", "getLayoutId", "getModel", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "handleVerifyCallback", "initActions", "initData", "initViews", TeaEventTrack.ACTION_DRAMA_NEXT, "onBackPressed", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StepUpIFrameActivity extends MvpBaseLoggerActivity<PresentorNothing, StepUpLogger> {
    private final String STEP_UP_SCRIPT;
    private int eventToken;
    private final String frameHeight;
    private String frameToken;
    private String frameUrl;
    private final String frameWidth;
    private final String verifyReturnUrlHost;
    private WebView webView;

    public void com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public int getLayoutId() {
        return R.layout.cj_pay_activity_step_up_iframe_layout;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public MvpModel getModel() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initActions() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void next() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private final void handleVerifyCallback() {
        EventManager.INSTANCE.notify(new CJPay3DSResultEvent(CJPay3DSResultEvent.Status.Success, this.eventToken));
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initViews() {
        WebView r100 = this.webView;
        if (r100 == null) goto L5;
        r100.getSettings().setJavaScriptEnabled(true);
        r100.getSettings().setDefaultTextEncodingName("UTF-8");
        StringEscapeUtils r101 = StringEscapeUtils.INSTANCE;
        this.frameUrl = r101.escapeHtml4(this.frameUrl);
        this.frameToken = r101.escapeHtml4(this.frameToken);
        r100.loadDataWithBaseURL(null, StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(this.STEP_UP_SCRIPT, "<heightPlaceHolder>", this.frameHeight, false, 4, null), "<widthPlaceHolder>", this.frameWidth, false, 4, null), "<actionUrlPlaceHolder>", this.frameUrl, false, 4, null), "<JWTPlaceHolder>", this.frameToken, false, 4, null), "text/html", XML.CHARSET_UTF8, null);
        r100.setWebViewClient(new StepUpIFrameActivity$initViews$1$1(this));
    L5:
        MvpBaseLoggerActivity.setTitleText$default(this, "", 0, 2, null);
    }

    public StepUpIFrameActivity() {
        this.frameWidth = "100%";
        this.frameHeight = "100%";
        this.frameUrl = "";
        this.frameToken = "";
        this.STEP_UP_SCRIPT = "    <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n            \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n    <html xmlns=\"http://www.w3.org/1999/xhtml\" style=\"height: 100%; width: 100%\">\n    <head>\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n        <title>Step-Up test</title>\n    </head>\n    <body style=\"height: 100%; width: 100%\">\n    <iframe name=\"step-up-iframe\" height=\"<heightPlaceHolder>\" width=\"<widthPlaceHolder>\" style=\"border: none;\">\n    </iframe>\n    <form id=\"step-up-form\" target=\"step-up-iframe\" method=\"post\" action=\"<actionUrlPlaceHolder>\"> \n    <input type=\"hidden\" name=\"JWT\" value=\"<JWTPlaceHolder>>\" /> \n    <input type=\"hidden\" name=\"MD\" value=\"stepuptesthtml\" /> \n    </form>\n\n    <script type=\"application/javascript\">\n    window.onload = function() {\n        var stepUpForm = document.querySelector('#step-up-form');\n        if(stepUpForm) // Step-Up form exists\n         stepUpForm.submit();\n    } \n    </script>\n    </body>\n    </html>";
        this.verifyReturnUrlHost = "dsverifyreturn";
    }

    @Override // com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public void bindViews() {
        this.webView = (WebView) findViewById(R.id.cj_pay_step_up_iframe_webview);
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initData() {
        this.eventToken = getIntent().getIntExtra("eventToken", 0);
        String r100 = getIntent().getStringExtra("url");
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.frameUrl = r100;
        String r102 = getIntent().getStringExtra("token");
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        this.frameToken = r101;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        EventManager.INSTANCE.notify(new CJPay3DSResultEvent(CJPay3DSResultEvent.Status.Cancel, this.eventToken));
        CJPayInputKeyboardHelper.hideSystemKeyboard(this);
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ StepUpLogger access$getLogger(StepUpIFrameActivity r100) {
        return r100.getLogger();
    }

    public static final /* synthetic */ String access$getVerifyReturnUrlHost$p(StepUpIFrameActivity r100) {
        return r100.verifyReturnUrlHost;
    }

    public static final /* synthetic */ void access$handleVerifyCallback(StepUpIFrameActivity r100) {
        r100.handleVerifyCallback();
    }

    public static void com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(StepUpIFrameActivity r100) {
        r100.com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(StepUpIFrameActivity r110) {
        r110.com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(StepUpIFrameActivity.class.getName()));
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

    public static void com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(StepUpIFrameActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_cybs_ui_StepUpIFrameActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    public final void setWebView(WebView r100) {
        this.webView = r100;
    }
}
