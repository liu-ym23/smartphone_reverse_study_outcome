package stepos.support.v7.app;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.stepos.core.ability.speech.PcmDumpBudget;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class WebViewActivity extends f {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f12065d = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f12066a = 0;

    /* renamed from: b, reason: collision with root package name */
    public WebView f12067b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12068c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            webView.loadUrl("javascript:(function(){ document.body.style.paddingBottom = '" + WebViewActivity.this.f12066a + "px'})();");
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                int i10 = WebViewActivity.f12065d;
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements v0.r {
        public b() {
        }

        @Override // v0.r
        public final v0.m0 g(View view, v0.m0 m0Var) {
            view.setPadding(0, m0Var.d(), 0, 0);
            WebViewActivity.this.f12066a = m0Var.a();
            return m0Var.f13309a.c();
        }
    }

    @Override // stepos.support.v7.app.f, b.k, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f12068c) {
            q(configuration);
        }
    }

    @Override // stepos.support.v7.app.f, androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | PcmDumpBudget.HARD_MAX_DIR_MB);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.j(true);
            supportActionBar.o(getIntent().getStringExtra("KEY_TITLE"));
        }
        this.f12067b = new WebView(this);
        String stringExtra = getIntent().getStringExtra("KEY_URL");
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("WebViewActivity ", "onCreate: url null");
            return;
        }
        this.f12067b.loadUrl(stringExtra);
        WebSettings settings = this.f12067b.getSettings();
        settings.setJavaScriptEnabled(getIntent().getBooleanExtra("KEY_ENABLE_JAVA_SCRIPT", true));
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        boolean booleanExtra = getIntent().getBooleanExtra("key_enable_force_dark", false);
        this.f12068c = booleanExtra;
        if (booleanExtra) {
            q(getResources().getConfiguration());
        }
        this.f12067b.setWebViewClient(new a());
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.f12067b, new FrameLayout.LayoutParams(-1, -1));
        b bVar = new b();
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.d.k(frameLayout, bVar);
        this.f12067b.setOverScrollMode(2);
        setContentView(frameLayout);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void q(Configuration configuration) {
        int i10 = Build.VERSION.SDK_INT;
        WebSettings settings = this.f12067b.getSettings();
        boolean z = (configuration.uiMode & 48) == 32;
        if (i10 >= 33) {
            settings.setAlgorithmicDarkeningAllowed(z);
        }
        if (z) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }
}
