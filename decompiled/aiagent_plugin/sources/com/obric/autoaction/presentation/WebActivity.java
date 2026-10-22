package com.obric.autoaction.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsetsController;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WebActivity extends BaseActivity implements View.OnClickListener {
    public static final a Companion = null;
    private static final String EXTRA_SESSION_ID = "session_id";
    private static final String EXTRA_SOURCE_FROM = "source_from";
    private static final String EXTRA_URL = "extra_url";
    private static final String TAG = "WebActivity";
    private final d.f errorView$delegate;
    private final d.f progressBar$delegate;
    private final d.f webView$delegate;

    /* JADX INFO: compiled from: WebActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r3, String r4, String r5, String r6) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r4, "url");
            o.e(r5, "forSessionId");
            Intent r7 = new Intent(r2, WebActivity.class);
            r7.putExtra(WebActivity.EXTRA_URL, r4);
            r7.putExtra(WebActivity.EXTRA_SESSION_ID, r5);
            if (r6 == null) goto L5;
            r7.putExtra(WebActivity.EXTRA_SOURCE_FROM, r6);
        L5:
            r7.addFlags(268435456);
            ZeusTransformUtils.startActivity(r2, r7, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ ProgressBar lambda$598svETyFqyMxJRsm7B0z69wFyg(WebActivity r0) {
        return progressBar_delegate$lambda$1(r0);
    }

    public static /* synthetic */ TextView lambda$BL0hYp458Crz87v1eCJRFCnD2QE(WebActivity r0) {
        return errorView_delegate$lambda$2(r0);
    }

    public static /* synthetic */ WebView lambda$u2YvtZlpVu55ZBQ3bOxtXEISPOU(WebActivity r0) {
        return webView_delegate$lambda$0(r0);
    }

    public WebActivity() {
        this.webView$delegate = d.g.a(new $$Lambda$WebActivity$u2YvtZlpVu55ZBQ3bOxtXEISPOU(this));
        this.progressBar$delegate = d.g.a(new $$Lambda$WebActivity$598svETyFqyMxJRsm7B0z69wFyg(this));
        this.errorView$delegate = d.g.a(new $$Lambda$WebActivity$BL0hYp458Crz87v1eCJRFCnD2QE(this));
    }

    public static final /* synthetic */ TextView access$getErrorView(WebActivity r2) {
        return ((WebActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebActivity.class, "com.obric.aiagent.plugin")).getErrorView();
    }

    public static final /* synthetic */ ProgressBar access$getProgressBar(WebActivity r2) {
        return ((WebActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebActivity.class, "com.obric.aiagent.plugin")).getProgressBar();
    }

    public static final /* synthetic */ WebView access$getWebView(WebActivity r2) {
        return ((WebActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebActivity.class, "com.obric.aiagent.plugin")).getWebView();
    }

    public static final /* synthetic */ void access$showErrorPage(WebActivity r2, CharSequence r3) {
        ((WebActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebActivity.class, "com.obric.aiagent.plugin")).showErrorPage((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final WebView getWebView() {
        Object r2 = this.webView$delegate.b();
        o.c(r2, "getValue(...)");
        return (WebView) ZeusTransformUtils.preCheckCast(r2, WebView.class, "com.obric.aiagent.plugin");
    }

    private static final WebView webView_delegate$lambda$0(WebActivity r4) {
        return (WebView) ZeusTransformUtils.preCheckCast(((WebActivity) ZeusTransformUtils.wrapperContextForParams(r4, WebActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.webView, DbHelper.COL_ID, "webView")), WebView.class, "com.obric.aiagent.plugin");
    }

    private final ProgressBar getProgressBar() {
        Object r2 = this.progressBar$delegate.b();
        o.c(r2, "getValue(...)");
        return (ProgressBar) ZeusTransformUtils.preCheckCast(r2, ProgressBar.class, "com.obric.aiagent.plugin");
    }

    private static final ProgressBar progressBar_delegate$lambda$1(WebActivity r4) {
        return (ProgressBar) ZeusTransformUtils.preCheckCast(((WebActivity) ZeusTransformUtils.wrapperContextForParams(r4, WebActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.web_progressBar, DbHelper.COL_ID, "web_progressBar")), ProgressBar.class, "com.obric.aiagent.plugin");
    }

    private static final TextView errorView_delegate$lambda$2(WebActivity r4) {
        return (TextView) ZeusTransformUtils.preCheckCast(((WebActivity) ZeusTransformUtils.wrapperContextForParams(r4, WebActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.web_errorTip, DbHelper.COL_ID, "web_errorTip")), TextView.class, "com.obric.aiagent.plugin");
    }

    private final TextView getErrorView() {
        Object r2 = this.errorView$delegate.b();
        o.c(r2, "getValue(...)");
        return (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_web, "layout", "activity_web"));
        setupStatusBar();
        setupWebView();
        loadUrl();
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.web_btnBack, DbHelper.COL_ID, "web_btnBack"));
        if (r5 == null) goto L5;
        r5.setOnClickListener((View.OnClickListener) ZeusTransformUtils.preCheckCast(this, View.OnClickListener.class, "com.obric.aiagent.plugin"));
    L5:
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.web_btnShare, DbHelper.COL_ID, "web_btnShare"));
        if (r6 == null) goto L8;
        r6.setOnClickListener((View.OnClickListener) ZeusTransformUtils.preCheckCast(this, View.OnClickListener.class, "com.obric.aiagent.plugin"));
    L8:
        getErrorView().setOnClickListener((View.OnClickListener) ZeusTransformUtils.preCheckCast(this, View.OnClickListener.class, "com.obric.aiagent.plugin"));
        getWindow().addFlags(128);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        if (r1 == null) goto L5;
        setIntent(r1);
    L5:
        loadUrl();
    }

    public final void loadUrl() {
        String r0 = getIntent().getStringExtra(EXTRA_URL);
        if (r0 == null) goto L6;
        Loog.INSTANCE.d(TAG, " shared url : " + r0);
        getWebView().loadUrl(r0);
        return;
    }

    private final void setupWebView() {
        WebSettings r0 = getWebView().getSettings();
        o.c(r0, "getSettings(...)");
        r0.setJavaScriptEnabled(true);
        r0.setDomStorageEnabled(true);
        r0.setLoadWithOverviewMode(true);
        r0.setUseWideViewPort(true);
        r0.setCacheMode(-1);
        getWebView().setWebViewClient((WebViewClient) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), WebViewClient.class, "com.obric.aiagent.plugin"));
        getWebView().setWebChromeClient((WebChromeClient) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), WebChromeClient.class, "com.obric.aiagent.plugin"));
    }

    private final void setupStatusBar() {
        Window r0 = getWindow();
        r0.setStatusBarColor(getColor(ZeusTransformUtils.mapRes(R.color.main_background, "color", "main_background")));
        r0.setNavigationBarColor(getColor(ZeusTransformUtils.mapRes(R.color.main_background, "color", "main_background")));
        WindowInsetsController r4 = r0.getInsetsController();
        if (r4 == null) goto L6;
        r4.setSystemBarsAppearance(8, 8);
        return;
    }

    private final void showErrorPage(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "showErrorPage");
        getProgressBar().setVisibility(8);
        getWebView().setVisibility(8);
        getErrorView().setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.web_error_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "web_error_tip")), CharSequence.class, "com.obric.aiagent.plugin"));
        getErrorView().setVisibility(0);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (getWebView().canGoBack() == false) goto L5;
        getWebView().goBack();
        return;
    L5:
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r11) {
        if (r11 == null) goto L5;
        Integer r12 = Integer.valueOf(r11.getId());
    L6:
        int r1 = ZeusTransformUtils.mapRes(R.id.web_btnBack, DbHelper.COL_ID, "web_btnBack");
        if (r12 != null) goto L10;
    L12:
        int r2 = ZeusTransformUtils.mapRes(R.id.web_btnShare, DbHelper.COL_ID, "web_btnShare");
        if (r12 != null) goto L16;
    L21:
        int r0 = ZeusTransformUtils.mapRes(R.id.web_errorTip, DbHelper.COL_ID, "web_errorTip");
        if (r12 != null) goto L25;
        return;
    L25:
        if (r12.intValue() != r0) goto L30;
        getErrorView().setVisibility(8);
        getWebView().reload();
        return;
    L30:
        return;
    L16:
        if (r12.intValue() != r2) goto L21;
        Intent r13 = new Intent();
        r13.setAction("android.intent.action.SEND");
        r13.putExtra("android.intent.extra.TEXT", getWebView().getUrl());
        r13.setType("text/plain");
        ZeusTransformUtils.startActivity(this, Intent.createChooser(r13, null), "com.obric.aiagent.plugin");
        String r14 = getIntent().getStringExtra(EXTRA_SESSION_ID);
        String r10 = getIntent().getStringExtra(EXTRA_SOURCE_FROM);
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L20;
        Loog.INSTANCE.d(TAG, " clicked share url to other app, sId=" + r14 + ", sourceFrom=" + r10);
    L20:
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("shared_source", r10);
        r4.put(EXTRA_SESSION_ID, r14);
        x r15 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "oauto_url_page_share_button_click", r4, false, false, null, 28, null);
        return;
    L10:
        if (r12.intValue() != r1) goto L12;
        finish();
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        WebView r6 = getWebView();
        r6.stopLoading();
        r6.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        r6.clearHistory();
        ViewParent r0 = r6.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L5;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
    L8:
        r6.destroy();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
