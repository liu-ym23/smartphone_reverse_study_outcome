package stepos.support.v7.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.a0;

/* loaded from: classes5.dex */
public class WebViewActivity extends d {

    /* renamed from: a, reason: collision with root package name */
    public int f40391a = 0;

    /* renamed from: b, reason: collision with root package name */
    public WebView f40392b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40393c;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            webView.loadUrl("javascript:(function(){ document.body.style.paddingBottom = '" + WebViewActivity.this.f40391a + "px'})();");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                WebViewActivity.t();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    public class b implements A {
        public b() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            view.setPadding(0, a0Var.m(), 0, 0);
            WebViewActivity.this.f40391a = a0Var.j();
            return a0Var.c();
        }
    }

    public interface c {
    }

    public static /* synthetic */ c t() {
        return null;
    }

    @Override // stepos.support.v7.app.d, b.q, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f40393c) {
            z(configuration);
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y(w());
        x(v());
        u();
        this.f40392b = new WebView(this);
        String stringExtra = getIntent().getStringExtra("KEY_URL");
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("WebViewActivity ", "onCreate: url null");
            return;
        }
        this.f40392b.loadUrl(stringExtra);
        WebSettings settings = this.f40392b.getSettings();
        settings.setJavaScriptEnabled(getIntent().getBooleanExtra("KEY_ENABLE_JAVA_SCRIPT", true));
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        boolean booleanExtra = getIntent().getBooleanExtra("key_enable_force_dark", false);
        this.f40393c = booleanExtra;
        if (booleanExtra) {
            z(getResources().getConfiguration());
        }
        this.f40392b.setWebViewClient(new a());
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.f40392b, new FrameLayout.LayoutParams(-1, -1));
        N.u0(frameLayout, new b());
        this.f40392b.setOverScrollMode(2);
        setContentView(frameLayout);
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void u() {
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.p(true);
        supportActionBar.u(getIntent().getStringExtra("KEY_TITLE"));
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        return true;
    }

    public final void x(boolean z10) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z10 ? systemUiVisibility | 16 : systemUiVisibility & (-17));
    }

    public final void y(boolean z10) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z10 ? systemUiVisibility | com.stepos.agentframework.chatui.longtext.b.THRESHOLD : systemUiVisibility & (-8193));
    }

    public final void z(Configuration configuration) {
        WebSettings settings = this.f40392b.getSettings();
        boolean zC = Hc.f.c(configuration);
        settings.setAlgorithmicDarkeningAllowed(zC);
        if (zC) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }
}
