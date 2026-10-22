package com.bytedanceos.common.ui;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Insets;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.ktx.e2e.InitialPadding;
import com.bytedanceos.common.model.WebParam;
import com.bytedanceos.common.ui.fragment.StateView;
import com.bytedanceos.common.ui.listener.WebDownloadListener;
import com.bytedanceos.common.ui.widget.ASWebView;
import com.bytedanceos.common.ui.widget.JsBridge;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.bytedanceos.common.utils.u;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class WebActivity extends FragmentActivity implements View.OnClickListener, JsBridge.JsBridgeOwner {
    public static final String EXTRA_ALLOW_INSECURE_SSL = "extra_allow_insecure_ssl";
    public static final String EXTRA_HAS_ANIM = "extra_has_anim";
    public static final String EXTRA_PARAM = "extra_param";
    public static final String EXTRA_URL = "extra_url";
    public static final String TAG = "WebActivity";
    private final int SCALE_INPERCENT;
    private boolean mAllowInsecureSsl;
    private WebParam mParam;
    private View.OnClickListener mRetryListener;
    private ViewGroup mStateView;
    private String mTitle;
    private OButton mToolbarBack;
    private ImageView mToolbarSearch;
    private TextView mToolbarTitle;
    private String mUrl;
    private WebDownloadListener mWebDownloadListener;
    private ASWebView mWebView;

    public class AsWebChromeClient extends WebChromeClient {
        final /* synthetic */ WebActivity this$0;

        public AsWebChromeClient(WebActivity r10) {
            this.this$0 = r10;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String r10, GeolocationPermissions.Callback r11) {
            r11.invoke(r10, true, false);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView r10, String r11, String r12, JsResult r13) {
            WebActivity.access$500(this.this$0, r12, r13);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView r10, String r11) {
            super.onReceivedTitle(r10, r11);
            if (TextUtils.isEmpty(r11) == true) goto L8;
            if (r11.indexOf("404 Not Found") == (-1)) goto L8;
            r10.stopLoading();
            r10.clearView();
        L8:
            if (TextUtils.isEmpty(WebActivity.access$600(this.this$0)) == false) goto L13;
            WebActivity.access$602(this.this$0, r11);
            if (TextUtils.isEmpty(r11) == true) goto L14;
            WebActivity.access$700(this.this$0).setText(r11);
            return;
        L14:
            return;
        }
    }

    public class AsWebViewClient extends WebViewClient {
        final /* synthetic */ WebActivity this$0;

        public AsWebViewClient(WebActivity r10) {
            this.this$0 = r10;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r10, String r11) {
            super.onPageFinished(r10, r11);
            WebActivity.access$200(this.this$0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r10, int r11, String r12, String r13) {
            super.onReceivedError(r10, r11, r12, r13);
            r10.stopLoading();
            r10.clearView();
            WebActivity.access$300(this.this$0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView r10, SslErrorHandler r11, SslError r12) {
            WebActivity.access$400(this.this$0);
            r11.cancel();
            r10.stopLoading();
            r10.clearView();
            WebActivity.access$300(this.this$0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r10, String r11) {
            if (TextUtils.isEmpty(r11) == false) goto L6;
            return false;
        L6:
            if (r11.contains(AdConstant.Dsp.BYTEDANCE) == false) goto L9;
            return true;
        L9:
            if (r11.startsWith("http://") == false) goto L11;
        L22:
            return false;
        L11:
            if (r11.startsWith("https://") == true) goto L22;
            if (r11.startsWith("tel:") == false) goto L16;
        L20:
            Intent r12 = new Intent("android.intent.action.VIEW", Uri.parse(r11));
            this.this$0.startActivity(r12);
            return true;
        L16:
            if (r11.startsWith("sms:") == true) goto L20;
            return com.bytedanceos.common.toolbox.e.l(this.this$0, r11);
        }
    }

    static {
    }

    public WebActivity() {
        this.mUrl = "";
        this.mTitle = "";
        this.SCALE_INPERCENT = 100;
    }

    public static /* synthetic */ void access$000(WebActivity r10) {
        r10.showLoadingView();
    }

    public static /* synthetic */ void access$100(WebActivity r10) {
        r10.loadUrl();
    }

    public static /* synthetic */ void access$200(WebActivity r10) {
        r10.hideStateView();
    }

    public static /* synthetic */ void access$300(WebActivity r10) {
        r10.showLoadError();
    }

    public static /* synthetic */ boolean access$400(WebActivity r10) {
        return r10.mAllowInsecureSsl;
    }

    public static /* synthetic */ void access$500(WebActivity r10, String r11, JsResult r12) {
        r10.onJsAlert(r11, r12);
    }

    public static /* synthetic */ String access$600(WebActivity r10) {
        return r10.mTitle;
    }

    public static /* synthetic */ String access$602(WebActivity r10, String r11) {
        r10.mTitle = r11;
        return r11;
    }

    public static /* synthetic */ TextView access$700(WebActivity r10) {
        return r10.mToolbarTitle;
    }

    private void doRequest() {
    }

    private void hideStateView() {
        if (isStateViewVisible() == false) goto L6;
        this.mStateView.setVisibility(8);
        return;
    }

    private void initData() {
        Intent r10 = getIntent();
        if (r10 == null) goto L13;
        this.mUrl = r10.getStringExtra(EXTRA_URL);     // Catch: Exception -> L8
        this.mParam = (WebParam) r10.getParcelableExtra(EXTRA_PARAM);     // Catch: Exception -> L8
        this.mAllowInsecureSsl = r10.getBooleanExtra(EXTRA_ALLOW_INSECURE_SSL, false);     // Catch: Exception -> L8
        WebParam r11 = this.mParam;     // Catch: Exception -> L8
        if (r11 == null) goto L14;
        this.mTitle = r11.getTitle();     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void initListener() {
        setWebViewSettings();
        setWebViewCallBack();
        this.mRetryListener = new AnonymousClass1(this);
        WebDownloadListener r10 = new WebDownloadListener(this);
        this.mWebDownloadListener = r10;
        WebParam r11 = this.mParam;
        if (r11 == null) goto L5;
        r10.setParam(r11);
    L5:
        this.mWebView.setDownloadListener(this.mWebDownloadListener);
    }

    private void initView() {
        if (TextUtils.isEmpty(this.mTitle) == false) goto L5;
        this.mToolbarTitle.setVisibility(8);
    L6:
        ASWebView r10 = (ASWebView) findViewById(R$id.webView);
        this.mWebView = r10;
        r10.setLayerType(2, null);
        this.mWebView.setBackgroundColor(ContextCompat.b(this, R$color.oui_bg_base_1));
        u8.c.c(this.mWebView, new m());
        this.mStateView = StateView.getStateView(this.mWebView);
        showLoadingView();
        return;
    L5:
        this.mToolbarTitle.setText(this.mTitle);
        this.mToolbarTitle.setVisibility(0);
        goto L6
    }

    private boolean isStateViewVisible() {
        ViewGroup r10 = this.mStateView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVisibility() != 0) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$initHeaderView$0(View r10) {
        onBackPressed();
    }

    private static /* synthetic */ Unit lambda$initView$1(View r10, WindowInsets r11, InitialPadding r12) {
        Insets r13 = r11.getInsets(WindowInsetsCompat.Type.d());
        r10.setPadding(r12.b(), r12.d(), r12.c(), r12.a() + r13.bottom);
        return Unit.f21064a;
    }

    private void loadUrl() {
        HashMap r10 = new HashMap();
        this.mWebView.loadUrl(this.mUrl, r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    private void onJsAlert(String r10, final JsResult r11) {
        DialogInterface.OnClickListener r12 = new AnonymousClass2(this, r11);
        AlertDialog r13 = new AlertDialog.Builder(this).setTitle(R$string.tips).setMessage(r10).setPositiveButton(R.string.ok, r12).create();
        r13.show();
        r13.setCanceledOnTouchOutside(false);
        r13.setCancelable(false);
    }

    public static /* synthetic */ Unit s(View r10, WindowInsets r11, InitialPadding r12) {
        return lambda$initView$1(r10, r11, r12);
    }

    private void setWebViewCallBack() {
        this.mWebView.setWebViewClient(new AsWebViewClient(this));
        this.mWebView.setWebChromeClient(new AsWebChromeClient(this));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void setWebViewSettings() {
        WebSettings r10 = this.mWebView.getSettings();
        if (Build.VERSION.SDK_INT < 33) goto L5;
        r10.setAlgorithmicDarkeningAllowed(true);
    L5:
        r10.setJavaScriptEnabled(true);
        r10.setJavaScriptCanOpenWindowsAutomatically(true);
        r10.setGeolocationEnabled(true);
        r10.setGeolocationDatabasePath(getFilesDir().getPath());
        r10.setSupportZoom(true);
        r10.setSaveFormData(false);
        r10.setSavePassword(false);
        r10.setPluginState(WebSettings.PluginState.ON);
        r10.setUseWideViewPort(true);
        r10.setAllowFileAccess(true);
        r10.setBlockNetworkImage(false);
        r10.setDomStorageEnabled(true);
        r10.setLoadWithOverviewMode(true);
        r10.setDefaultTextEncodingName("utf-8");
        r10.setRenderPriority(WebSettings.RenderPriority.HIGH);
        r10.setUseWideViewPort(true);
        r10.setLoadWithOverviewMode(true);
        r10.setMixedContentMode(0);
        JsBridge r11 = new JsBridge(this, this.mWebView);
        this.mWebView.addJavascriptInterface(r11, "jsbridge");
        this.mWebView.requestFocus();
        this.mWebView.setInitialScale(100);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setScrollBarStyle(0);
    }

    private void showLoadError() {
        StateView.showRefreshView(this.mStateView, this.mRetryListener);
    }

    private void showLoadingView() {
        StateView.showLoadingView(this.mStateView);
    }

    public static void start(Context r10, String r11, WebParam r12, boolean r13, boolean r14) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        Intent r15 = new Intent(r10, WebActivity.class);
        r15.putExtra(EXTRA_URL, r11);
        r15.putExtra("extra_has_anim", r13);
        r15.putExtra(EXTRA_ALLOW_INSECURE_SSL, r14);
        if (r12 == null) goto L8;
        r15.putExtra(EXTRA_PARAM, r12);
    L8:
        r10.startActivity(r15);
    }

    public static /* synthetic */ void t(WebActivity r10, View r11) {
        r10.lambda$initHeaderView$0(r11);
    }

    @Override // com.bytedanceos.common.ui.widget.JsBridge.JsBridgeOwner
    public Fragment getFragment() {
        return null;
    }

    @Override // com.bytedanceos.common.ui.widget.JsBridge.JsBridgeOwner
    public Activity getHostActivity() {
        return this;
    }

    @Override // com.bytedanceos.common.ui.widget.JsBridge.JsBridgeOwner
    public WebView getWebView() {
        return this.mWebView;
    }

    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        u.d(r10);
        this.mToolbarTitle = u.f(r10, "");
        u.a(r10, new l(this));
        return r10;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ASWebView r10 = this.mWebView;
        if (r10 != null) goto L5;
    L8:
        super.onBackPressed();
        return;
    L5:
        if (r10.canGoBack() == false) goto L8;
        this.mWebView.goBack();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10.getId() != R$id.left_action_back) goto L6;
        onBackPressed();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        ActivityUtilKt.a(this);
        setContentView(R$layout.activity_web);
        initHeaderView();
        initData();
        initView();
        initListener();
        loadUrl();
        doRequest();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ASWebView r10 = this.mWebView;
        if (r10 == null) goto L6;
        r10.setVisibility(8);
        this.mWebView.destroy();
        this.mWebView = null;
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        ASWebView r10 = this.mWebView;
        if (r10 == null) goto L5;
        r10.onResume();
    L5:
        super.onResume();
    }

    public static void start(Context r10, String r11, WebParam r12, boolean r13) {
        start(r10, r11, r12, r13, false);
    }

    public static void start(Context r10, String r11, WebParam r12) {
        start(r10, r11, r12, true);
    }

    public static void start(Context r10, String r11) {
        start(r10, r11, null);
    }
}
