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
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;

/* loaded from: classes.dex */
public class WebViewActivity extends d {

    /* renamed from: a, reason: collision with root package name */
    private int f20653a = 0;

    /* renamed from: b, reason: collision with root package name */
    private WebView f20654b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20655c;

    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            webView.loadUrl("javascript:(function(){ document.body.style.paddingBottom = '" + WebViewActivity.this.f20653a + "px'})();");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                WebViewActivity.v();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    class b implements InterfaceC0479y {
        b() {
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            view.setPadding(0, y5.k(), 0, 0);
            WebViewActivity.this.f20653a = y5.h();
            return y5.c();
        }
    }

    public interface c {
    }

    private void A(boolean z5) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z5 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    private void B(Configuration configuration) {
        WebSettings settings = this.f20654b.getSettings();
        boolean zC = a5.g.c(configuration);
        settings.setAlgorithmicDarkeningAllowed(zC);
        if (zC) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }

    static /* synthetic */ c v() {
        return null;
    }

    private void w() {
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.E(true);
        supportActionBar.Q(getIntent().getStringExtra("KEY_TITLE"));
    }

    private void z(boolean z5) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z5 ? systemUiVisibility | 16 : systemUiVisibility & (-17));
    }

    @Override // stepos.support.v7.app.d, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f20655c) {
            B(configuration);
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A(y());
        z(x());
        w();
        this.f20654b = new WebView(this);
        String stringExtra = getIntent().getStringExtra("KEY_URL");
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("WebViewActivity ", "onCreate: url null");
            return;
        }
        this.f20654b.loadUrl(stringExtra);
        WebSettings settings = this.f20654b.getSettings();
        settings.setJavaScriptEnabled(getIntent().getBooleanExtra("KEY_ENABLE_JAVA_SCRIPT", true));
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        boolean booleanExtra = getIntent().getBooleanExtra("key_enable_force_dark", false);
        this.f20655c = booleanExtra;
        if (booleanExtra) {
            B(getResources().getConfiguration());
        }
        this.f20654b.setWebViewClient(new a());
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.f20654b, new FrameLayout.LayoutParams(-1, -1));
        H.w0(frameLayout, new b());
        this.f20654b.setOverScrollMode(2);
        setContentView(frameLayout);
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
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

    protected boolean x() {
        return true;
    }

    protected boolean y() {
        return true;
    }
}
