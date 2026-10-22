package com.obric.oui.window.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.GlobalProxyLancet;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oui.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.utils.ActivityUtils;
import com.obric.oui.utils.NetworkUtil;
import com.obric.oui.window.OWindowConfigController;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes4.dex */
public class WebViewActivity extends AppCompatActivity {
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private static final String TAG = "WebViewActivity";
    private TextView errorView;
    private Runnable mPendingReloadTimeoutRunnable;
    private ShowWebViewRunnable mPendingShowWebViewRunnable;
    private boolean mReloadingFromErrorPage;
    private WebView webView;

    private static class ShowWebViewRunnable implements Runnable {
        private final WeakReference<WebView> webViewRef;

        public ShowWebViewRunnable(WebView r2) {
            this.webViewRef = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView r1 = this.webViewRef.get();
            if (r1 == null) goto L6;
            r1.setAlpha(1.0f);
            return;
        }
    }

    public void com_obric_oui_window_permission_WebViewActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_obric_oui_window_permission_WebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public WebViewActivity() {
    }

    static /* synthetic */ boolean access$000(WebViewActivity r0) {
        return r0.mReloadingFromErrorPage;
    }

    static /* synthetic */ boolean access$002(WebViewActivity r0, boolean r1) {
        r0.mReloadingFromErrorPage = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$100(WebViewActivity r0) {
        return r0.mPendingReloadTimeoutRunnable;
    }

    static /* synthetic */ TextView access$200(WebViewActivity r0) {
        return r0.errorView;
    }

    static /* synthetic */ WebView access$300(WebViewActivity r0) {
        return r0.webView;
    }

    static /* synthetic */ ShowWebViewRunnable access$400(WebViewActivity r0) {
        return r0.mPendingShowWebViewRunnable;
    }

    static /* synthetic */ void access$500(WebViewActivity r0) {
        r0.showErrorPage();
    }

    public static void open(Context r2, String r3, String r4) {
        Intent r0 = new Intent(r2, WebViewActivity.class);
        r0.putExtra(EXTRA_URL, r3);
        r0.putExtra(EXTRA_TITLE, r4);
        r2.startActivity(r0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.activity_webview);
        Window r5 = getWindow();
        r5.getDecorView().setSystemUiVisibility(1792);
        ActivityUtils.adaptLightDarkSystemBars(this);
        r5.setStatusBarColor(0);
        r5.setNavigationBarColor(0);
        r5.setNavigationBarContrastEnforced(false);
        this.webView = (WebView) findViewById(R.id.webView);
        this.mPendingShowWebViewRunnable = new ShowWebViewRunnable(this.webView);
        this.errorView = (TextView) findViewById(R.id.errorView);
        String r6 = getIntent().getStringExtra(EXTRA_TITLE);
        if (TextUtils.isEmpty(r6) == false) goto L5;
        r6 = getString(R.string.title_privacy_policy_and_user_agreement);
    L5:
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.web_activity_title_bar);
        if (r0 == null) goto L8;
        r0.setCenterTitle(r6);
        r0.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new WebViewActivity$$ExternalSyntheticLambda1(this));
    L8:
        this.webView.setLayerType(2, null);
        WebSettings r7 = this.webView.getSettings();
        r7.setJavaScriptEnabled(true);
        r7.setDomStorageEnabled(true);
        r7.setLoadWithOverviewMode(true);
        r7.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT < 33) goto L11;
        r7.setAlgorithmicDarkeningAllowed(true);
    L11:
        this.webView.setAlpha(0.0f);
        this.webView.setWebViewClient(new AnonymousClass1(this));
        this.webView.setWebChromeClient(new AnonymousClass2(this));
        String r8 = getIntent().getStringExtra(EXTRA_URL);
        if (r8 == null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onCreate: start load url " + r8);
        this.webView.loadUrl(r8);
    L14:
        this.webView.setOnApplyWindowInsetsListener(new WebViewActivity$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ void m755x6c03b53d(View r1) {
        onBackPressed();
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ WindowInsets m756x6b8d4f3e(View r2, WindowInsets r3) {
        int r0 = OWindowConfigController.getSystemBarInsets(r2, r3).bottom;
        if (OWindowConfigController.isGestureNavigation(r2.getContext()) == false) goto L5;
        r0 = 0;
    L5:
        updateLayoutForInsetBottom(r0);
        return r3;
    }

    private void showErrorPage() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "showErrorPage");
        this.mReloadingFromErrorPage = false;
        Runnable r1 = this.mPendingReloadTimeoutRunnable;
        if (r1 == null) goto L5;
        this.webView.removeCallbacks(r1);
    L5:
        this.webView.setVisibility(8);
        this.errorView.setVisibility(0);
        if (NetworkUtil.isNetworkAvailable(this) == false) goto L8;
        this.errorView.setText(R.string.tip_load_fail);
    L9:
        this.errorView.setOnClickListener(new WebViewActivity$$ExternalSyntheticLambda3(this));
        return;
    L8:
        this.errorView.setText(R.string.tip_load_fail_no_network);
        goto L9
    }

    /* JADX INFO: renamed from: lambda$showErrorPage$3$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ void m758x72207c25(View r3) {
        if (NetworkUtil.isNetworkAvailable(this) == false) goto L9;
        this.errorView.setVisibility(8);
        this.webView.setVisibility(0);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onClick, reload");
        this.webView.reload();
        this.mReloadingFromErrorPage = true;
        if (this.mPendingReloadTimeoutRunnable != null) goto L7;
        this.mPendingReloadTimeoutRunnable = new WebViewActivity$$ExternalSyntheticLambda0(this);
    L7:
        this.webView.removeCallbacks(this.mPendingReloadTimeoutRunnable);
        this.webView.postDelayed(this.mPendingReloadTimeoutRunnable, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    /* JADX INFO: renamed from: lambda$showErrorPage$2$com-obric-oui-window-permission-WebViewActivity, reason: not valid java name */
    /* synthetic */ void m757x7296e224() {
        if (this.mReloadingFromErrorPage == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "reload timeout, keep showing error page");
        showErrorPage();
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.webView.canGoBack() == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onBackPressed, go back");
        this.webView.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView r0 = this.webView;
        if (r0 == null) goto L9;
        r0.removeCallbacks(this.mPendingShowWebViewRunnable);
        Runnable r1 = this.mPendingReloadTimeoutRunnable;
        if (r1 == null) goto L7;
        this.webView.removeCallbacks(r1);
    L7:
        this.webView.stopLoading();
        this.webView.removeAllViews();
        this.webView.destroy();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onDestroy, webView destroyed");
        return;
    }

    public void updateLayoutForInsetBottom(int r2) {
        if ((this.webView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.webView.getLayoutParams();
        r0.bottomMargin = r2;
        this.webView.setLayoutParams(r0);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "updateLayoutForInsetBottom, insetBottom: " + r2);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_oui_window_permission_WebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WebViewActivity r1) {
        r1.com_obric_oui_window_permission_WebViewActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
