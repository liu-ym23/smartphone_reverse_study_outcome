package com.obric.oui.window.permission;

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

/* JADX INFO: loaded from: classes4.dex */
public class WebViewActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f17700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f17701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f17702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f17703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17704g;

    public class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewActivity f17705a;

        public a(WebViewActivity r10) {
            this.f17705a = r10;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r10, String r11) {
            super.onPageFinished(r10, r11);
            if (WebViewActivity.J(this.f17705a) == false) goto L8;
            WebViewActivity.K(this.f17705a, false);
            if (WebViewActivity.L(this.f17705a) == null) goto L7;
            r10.removeCallbacks(WebViewActivity.L(this.f17705a));
        L7:
            WebViewActivity.M(this.f17705a).setVisibility(8);
            WebViewActivity.N(this.f17705a).setVisibility(0);
        L8:
            r10.evaluateJavascript("(function() { document.body.style.paddingTop = '80px';var style = document.createElement('style');style.type = 'text/css';style.innerHTML = 'html, body, * { text-spacing-trim: space-all !important;  }';document.head.appendChild(style);})()", null);
            r10.postDelayed(WebViewActivity.O(this.f17705a), 100);
            Log.d("WebViewActivity", "onPageFinished: " + r11);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r10, String r11, Bitmap r12) {
            Log.d("WebViewActivity", "onPageStarted: " + r11);
            super.onPageStarted(r10, r11, r12);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(WebView r10, ClientCertRequest r11) {
            if (r11 == null) goto L4;
            String r12 = r11.getHost();
        L5:
            Log.w("WebViewActivity", "onReceivedClientCertRequest: " + r12);
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
            Log.e("WebViewActivity", r13.toString());
            WebViewActivity.P(this.f17705a);
            return;
        L5:
            r14 = "unknown error";
            goto L6
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
            super.onReceivedHttpError(r10, r11, r12);
            Log.e("WebViewActivity", "onReceivedHttpError: " + r12);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView r10, SslErrorHandler r11, SslError r12) {
            Log.e("WebViewActivity", "onReceivedSslError: " + r12);
            WebViewActivity.P(this.f17705a);
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
            Log.d("WebViewActivity", "shouldInterceptRequest: " + r12);
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
            Log.e("WebViewActivity", "shouldOverrideUrlLoading can resolve : " + r12);
        L22:
            Log.d("WebViewActivity", "shouldOverrideUrlLoading: " + r12);
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
        public final /* synthetic */ WebViewActivity f17706a;

        public b(WebViewActivity r10) {
            this.f17706a = r10;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView r10, int r11) {
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f17707a;

        public c(WebView r10) {
            this.f17707a = new WeakReference(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView r10 = (WebView) this.f17707a.get();
            if (r10 == null) goto L6;
            r10.setAlpha(1.0f);
            return;
        }
    }

    public WebViewActivity() {
    }

    public static /* synthetic */ void F(WebViewActivity r10) {
        r10.S();
    }

    public static /* synthetic */ void G(WebViewActivity r10, View r11) {
        r10.Q(r11);
    }

    public static /* synthetic */ void H(WebViewActivity r10, View r11) {
        r10.T(r11);
    }

    public static /* synthetic */ WindowInsets I(WebViewActivity r10, View r11, WindowInsets r12) {
        return r10.R(r11, r12);
    }

    public static /* synthetic */ boolean J(WebViewActivity r10) {
        return r10.f17704g;
    }

    public static /* synthetic */ boolean K(WebViewActivity r10, boolean r11) {
        r10.f17704g = r11;
        return r11;
    }

    public static /* synthetic */ Runnable L(WebViewActivity r10) {
        return r10.f17703f;
    }

    public static /* synthetic */ TextView M(WebViewActivity r10) {
        return r10.f17701d;
    }

    public static /* synthetic */ WebView N(WebViewActivity r10) {
        return r10.f17700c;
    }

    public static /* synthetic */ c O(WebViewActivity r10) {
        return r10.f17702e;
    }

    public static /* synthetic */ void P(WebViewActivity r10) {
        r10.V();
    }

    private /* synthetic */ void Q(View r10) {
        onBackPressed();
    }

    private /* synthetic */ WindowInsets R(View r10, WindowInsets r11) {
        int r12 = wd.a.h(r10, r11).f2559d;
        if (wd.a.k(r10.getContext()) == false) goto L5;
        r12 = 0;
    L5:
        W(r12);
        return r11;
    }

    public static void U(Context r10, String r11, String r12) {
        Intent r13 = new Intent(r10, WebViewActivity.class);
        r13.putExtra(WebActivity.EXTRA_URL, r11);
        r13.putExtra("extra_title", r12);
        r10.startActivity(r13);
    }

    private void V() {
        Log.w("WebViewActivity", "showErrorPage");
        this.f17704g = false;
        Runnable r10 = this.f17703f;
        if (r10 == null) goto L5;
        this.f17700c.removeCallbacks(r10);
    L5:
        this.f17700c.setVisibility(8);
        this.f17701d.setVisibility(0);
        if (td.d.a(this) == false) goto L8;
        this.f17701d.setText(R$string.tip_load_fail);
    L9:
        this.f17701d.setOnClickListener(new f(this));
        return;
    L8:
        this.f17701d.setText(R$string.tip_load_fail_no_network);
        goto L9
    }

    public final /* synthetic */ void S() {
        if (this.f17704g == false) goto L6;
        Log.w("WebViewActivity", "reload timeout, keep showing error page");
        V();
        return;
    }

    public final /* synthetic */ void T(View r10) {
        if (td.d.a(this) == false) goto L9;
        this.f17701d.setVisibility(8);
        this.f17700c.setVisibility(0);
        Log.d("WebViewActivity", "onClick, reload");
        this.f17700c.reload();
        this.f17704g = true;
        if (this.f17703f != null) goto L7;
        this.f17703f = new g(this);
    L7:
        this.f17700c.removeCallbacks(this.f17703f);
        this.f17700c.postDelayed(this.f17703f, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    public void W(int r10) {
        if ((this.f17700c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) this.f17700c.getLayoutParams();
        r11.bottomMargin = r10;
        this.f17700c.setLayoutParams(r11);
        Log.d("WebViewActivity", "updateLayoutForInsetBottom, insetBottom: " + r10);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f17700c.canGoBack() == false) goto L5;
        Log.d("WebViewActivity", "onBackPressed, go back");
        this.f17700c.goBack();
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
        this.f17700c = r13;
        this.f17702e = new c(r13);
        this.f17701d = (TextView) findViewById(R$id.errorView);
        String r14 = getIntent().getStringExtra("extra_title");
        if (TextUtils.isEmpty(r14) == false) goto L5;
        r14 = getString(R$string.title_privacy_policy_and_user_agreement);
    L5:
        OFloatingTitleBar r15 = (OFloatingTitleBar) findViewById(R$id.web_activity_title_bar);
        if (r15 == null) goto L8;
        r15.setCenterTitle(r14);
        r15.k(R$drawable.o_floating_title_bar_icon_back, -1, new d(this));
    L8:
        this.f17700c.setLayerType(2, null);
        WebSettings r16 = this.f17700c.getSettings();
        r16.setJavaScriptEnabled(true);
        r16.setDomStorageEnabled(true);
        r16.setLoadWithOverviewMode(true);
        r16.setUseWideViewPort(true);
        if (r12 < 33) goto L11;
        r16.setAlgorithmicDarkeningAllowed(true);
    L11:
        this.f17700c.setAlpha(0.0f);
        this.f17700c.setWebViewClient(new a(this));
        this.f17700c.setWebChromeClient(new b(this));
        String r17 = getIntent().getStringExtra(WebActivity.EXTRA_URL);
        if (r17 == null) goto L14;
        Log.d("WebViewActivity", "onCreate: start load url " + r17);
        this.f17700c.loadUrl(r17);
    L14:
        this.f17700c.setOnApplyWindowInsetsListener(new e(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WebView r10 = this.f17700c;
        if (r10 == null) goto L9;
        r10.removeCallbacks(this.f17702e);
        Runnable r11 = this.f17703f;
        if (r11 == null) goto L7;
        this.f17700c.removeCallbacks(r11);
    L7:
        this.f17700c.stopLoading();
        this.f17700c.removeAllViews();
        this.f17700c.destroy();
        Log.d("WebViewActivity", "onDestroy, webView destroyed");
        return;
    }
}
