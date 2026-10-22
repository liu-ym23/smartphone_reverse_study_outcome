package com.bytedanceos.common.core.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.ClientCertRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.ui.WebActivity;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreWebViewActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f9716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f9717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f9718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f9719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f9720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f9721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9722i;

    public class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStoreWebViewActivity f9723a;

        public a(AppStoreWebViewActivity r10) {
            this.f9723a = r10;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r10, String r11) {
            super.onPageFinished(r10, r11);
            if (AppStoreWebViewActivity.K(this.f9723a) == false) goto L8;
            AppStoreWebViewActivity.L(this.f9723a, false);
            if (AppStoreWebViewActivity.M(this.f9723a) == null) goto L7;
            r10.removeCallbacks(AppStoreWebViewActivity.M(this.f9723a));
        L7:
            AppStoreWebViewActivity.N(this.f9723a).setVisibility(8);
            AppStoreWebViewActivity.O(this.f9723a).setVisibility(0);
        L8:
            r10.evaluateJavascript("(function() { document.body.style.paddingTop = '80px';var style = document.createElement('style');style.type = 'text/css';style.innerHTML = 'html, body, * { text-spacing-trim: space-all !important;  }';document.head.appendChild(style);})()", null);
            r10.postDelayed(AppStoreWebViewActivity.P(this.f9723a), 100);
            Log.d("AppStoreWebViewActivity", "onPageFinished: " + r11);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r10, String r11, Bitmap r12) {
            Log.d("AppStoreWebViewActivity", "onPageStarted: " + r11);
            super.onPageStarted(r10, r11, r12);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(WebView r10, ClientCertRequest r11) {
            if (r11 == null) goto L4;
            String r12 = r11.getHost();
        L5:
            Log.w("AppStoreWebViewActivity", "onReceivedClientCertRequest: " + r12);
            super.onReceivedClientCertRequest(r10, r11);
            return;
        L4:
            r12 = null;
            goto L5
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
            super.onReceivedError(r10, r11, r12);
            StringBuilder r13 = new StringBuilder();
            r13.append("onReceivedError: ");
            if (r12 == null) goto L5;
            CharSequence r14 = r12.getDescription();
        L6:
            r13.append(r14);
            Log.e("AppStoreWebViewActivity", r13.toString());
            AppStoreWebViewActivity.Q(this.f9723a);
            return;
        L5:
            r14 = "unknown error";
            goto L6
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
            super.onReceivedHttpError(r10, r11, r12);
            Log.e("AppStoreWebViewActivity", "onReceivedHttpError: " + r12);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView r10, SslErrorHandler r11, SslError r12) {
            Log.e("AppStoreWebViewActivity", "onReceivedSslError: " + r12);
            AppStoreWebViewActivity.Q(this.f9723a);
            super.onReceivedSslError(r10, r11, r12);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView r10, WebResourceRequest r11) {
            String r12 = null;
            if (r11 == null) goto L5;
            Uri r13 = r11.getUrl();
        L6:
            if (r13 == null) goto L8;
            r12 = r13.toString();
        L8:
            Log.d("AppStoreWebViewActivity", "shouldInterceptRequest: " + r12);
            return super.shouldInterceptRequest(r10, r11);
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r10, WebResourceRequest r11) {
            String r12 = r11.getUrl().toString();
            if (r12.startsWith("tel:") == false) goto L5;
        L24:
            r10.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(r12)));     // Catch: Exception -> L21
            return true;
        L21:
            Log.e("AppStoreWebViewActivity", "shouldOverrideUrlLoading can resolve : " + r12);
        L22:
            Log.d("AppStoreWebViewActivity", "shouldOverrideUrlLoading: " + r12);
            return false;
        L5:
            if (r12.startsWith("mailto:") == true) goto L24;
            if (r12.startsWith("sms:") == true) goto L24;
            if (r12.startsWith("smsto:") == true) goto L24;
            if (r12.startsWith("market:") == true) goto L24;
            if (r12.startsWith("geo:") == true) goto L24;
            if (r12.startsWith("whatsapp:") == true) goto L24;
            if (r12.startsWith("intent:") == false) goto L22;
            goto L22
        }
    }

    public class b extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStoreWebViewActivity f9724a;

        public b(AppStoreWebViewActivity r10) {
            this.f9724a = r10;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView r10, int r11) {
        }
    }

    public class c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f9725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppStoreWebViewActivity f9726b;

        public c(AppStoreWebViewActivity r10, View r11) {
            this.f9726b = r10;
            this.f9725a = r11;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            AppStoreWebViewActivity.R(this.f9726b, this.f9725a);
            this.f9725a.post(AppStoreWebViewActivity.S(this.f9726b));
            return true;
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f9727a;

        public d(WebView r10) {
            this.f9727a = new WeakReference(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView r10 = (WebView) this.f9727a.get();
            if (r10 == null) goto L6;
            r10.setAlpha(1.0f);
            return;
        }
    }

    public AppStoreWebViewActivity() {
    }

    public static /* synthetic */ void F(AppStoreWebViewActivity r10) {
        r10.W();
    }

    public static /* synthetic */ void G(AppStoreWebViewActivity r10, View r11) {
        r10.X(r11);
    }

    public static /* synthetic */ void H(AppStoreWebViewActivity r10, View r11) {
        r10.U(r11);
    }

    public static /* synthetic */ void I(AppStoreWebViewActivity r10, String r11) {
        r10.T(r11);
    }

    public static /* synthetic */ WindowInsets J(AppStoreWebViewActivity r10, View r11, WindowInsets r12) {
        return r10.V(r11, r12);
    }

    public static /* synthetic */ boolean K(AppStoreWebViewActivity r10) {
        return r10.f9722i;
    }

    public static /* synthetic */ boolean L(AppStoreWebViewActivity r10, boolean r11) {
        r10.f9722i = r11;
        return r11;
    }

    public static /* synthetic */ Runnable M(AppStoreWebViewActivity r10) {
        return r10.f9719f;
    }

    public static /* synthetic */ TextView N(AppStoreWebViewActivity r10) {
        return r10.f9717d;
    }

    public static /* synthetic */ WebView O(AppStoreWebViewActivity r10) {
        return r10.f9716c;
    }

    public static /* synthetic */ d P(AppStoreWebViewActivity r10) {
        return r10.f9718e;
    }

    public static /* synthetic */ void Q(AppStoreWebViewActivity r10) {
        r10.b0();
    }

    public static /* synthetic */ void R(AppStoreWebViewActivity r10, View r11) {
        r10.a0(r11);
    }

    public static /* synthetic */ Runnable S(AppStoreWebViewActivity r10) {
        return r10.f9720g;
    }

    public static void Z(Context r10, String r11, String r12) {
        Intent r13 = new Intent(r10, AppStoreWebViewActivity.class);
        r13.putExtra(WebActivity.EXTRA_URL, r11);
        r13.putExtra("extra_title", r12);
        r10.startActivity(r13);
    }

    public final /* synthetic */ void T(String r10) {
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        if (this.f9716c == null) goto L10;
        Log.d("AppStoreWebViewActivity", "start load url after first draw " + r10);
        this.f9716c.loadUrl(r10);
        return;
    }

    public final /* synthetic */ void U(View r10) {
        onBackPressed();
    }

    public final /* synthetic */ WindowInsets V(View r10, WindowInsets r11) {
        int r12 = wd.a.h(r10, r11).f2559d;
        if (wd.a.k(r10.getContext()) == false) goto L5;
        r12 = 0;
    L5:
        c0(r12);
        return r11;
    }

    public final /* synthetic */ void W() {
        if (this.f9722i == false) goto L6;
        Log.w("AppStoreWebViewActivity", "reload timeout, keep showing error page");
        b0();
        return;
    }

    public final /* synthetic */ void X(View r10) {
        if (td.d.a(this) == false) goto L9;
        this.f9717d.setVisibility(8);
        this.f9716c.setVisibility(0);
        Log.d("AppStoreWebViewActivity", "onClick, reload");
        this.f9716c.reload();
        this.f9722i = true;
        if (this.f9719f != null) goto L7;
        this.f9719f = new o(this);
    L7:
        this.f9716c.removeCallbacks(this.f9719f);
        this.f9716c.postDelayed(this.f9719f, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    public final void Y(final String r10) {
        View r11 = getWindow().getDecorView();
        this.f9720g = new n(this, r10);
        ViewTreeObserver r12 = r11.getViewTreeObserver();
        if (r12.isAlive() == true) goto L6;
        r11.post(this.f9720g);
        return;
    L6:
        c r13 = new c(this, r11);
        this.f9721h = r13;
        r12.addOnPreDrawListener(r13);
    }

    public final void a0(View r10) {
        if (this.f9721h != null) goto L5;
        return;
    L5:
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        if (r11.isAlive() == false) goto L8;
        r11.removeOnPreDrawListener(this.f9721h);
    L8:
        this.f9721h = null;
    }

    public final void b0() {
        Log.w("AppStoreWebViewActivity", "showErrorPage");
        this.f9722i = false;
        Runnable r10 = this.f9719f;
        if (r10 == null) goto L5;
        this.f9716c.removeCallbacks(r10);
    L5:
        this.f9716c.setVisibility(8);
        this.f9717d.setVisibility(0);
        if (td.d.a(this) == false) goto L8;
        this.f9717d.setText(R$string.tip_load_fail);
    L9:
        this.f9717d.setOnClickListener(new m(this));
        return;
    L8:
        this.f9717d.setText(R$string.tip_load_fail_no_network);
        goto L9
    }

    public void c0(int r10) {
        if ((this.f9716c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) this.f9716c.getLayoutParams();
        r11.bottomMargin = r10;
        this.f9716c.setLayoutParams(r11);
        Log.d("AppStoreWebViewActivity", "updateLayoutForInsetBottom, insetBottom: " + r10);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f9716c.canGoBack() == false) goto L5;
        Log.d("AppStoreWebViewActivity", "onBackPressed, go back");
        this.f9716c.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.activity_webview);
        Window r11 = getWindow();
        r11.getDecorView().setSystemUiVisibility(1792);
        int r12 = Build.VERSION.SDK_INT;
        td.a.a(this);
        r11.setStatusBarColor(0);
        r11.setNavigationBarColor(0);
        r11.setNavigationBarContrastEnforced(false);
        WebView r13 = (WebView) findViewById(R$id.webView);
        this.f9716c = r13;
        this.f9718e = new d(r13);
        this.f9717d = (TextView) findViewById(R$id.errorView);
        String r14 = getIntent().getStringExtra("extra_title");
        if (TextUtils.isEmpty(r14) == false) goto L5;
        r14 = getString(R$string.title_privacy_policy_and_user_agreement);
    L5:
        OFloatingTitleBar r15 = (OFloatingTitleBar) findViewById(R$id.web_activity_title_bar);
        if (r15 == null) goto L8;
        r15.setCenterTitle(r14);
        r15.k(R$drawable.o_floating_title_bar_icon_back, -1, new k(this));
    L8:
        this.f9716c.setLayerType(2, null);
        WebSettings r16 = this.f9716c.getSettings();
        r16.setJavaScriptEnabled(true);
        r16.setDomStorageEnabled(true);
        r16.setLoadWithOverviewMode(true);
        r16.setUseWideViewPort(true);
        if (r12 < 33) goto L11;
        r16.setAlgorithmicDarkeningAllowed(true);
    L11:
        this.f9716c.setAlpha(0.0f);
        this.f9716c.setWebViewClient(new a(this));
        this.f9716c.setWebChromeClient(new b(this));
        String r17 = getIntent().getStringExtra(WebActivity.EXTRA_URL);
        if (r17 == null) goto L14;
        Y(r17);
    L14:
        this.f9716c.setOnApplyWindowInsetsListener(new l(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        View r10 = getWindow().getDecorView();
        a0(r10);
        Runnable r11 = this.f9720g;
        if (r11 == null) goto L5;
        r10.removeCallbacks(r11);
    L5:
        super.onDestroy();
        WebView r12 = this.f9716c;
        if (r12 == null) goto L12;
        r12.removeCallbacks(this.f9718e);
        Runnable r13 = this.f9719f;
        if (r13 == null) goto L10;
        this.f9716c.removeCallbacks(r13);
    L10:
        this.f9716c.stopLoading();
        this.f9716c.removeAllViews();
        this.f9716c.destroy();
        this.f9716c = null;
        Log.d("AppStoreWebViewActivity", "onDestroy, webView destroyed");
        return;
    }
}
