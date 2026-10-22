package stepos.support.v7.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class WebViewActivity extends AbstractActivityC0866k {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f14357d = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f14358a = 0;

    /* renamed from: b, reason: collision with root package name */
    public WebView f14359b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14360c;

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f14360c) {
            WebSettings settings = this.f14359b.getSettings();
            boolean z4 = (configuration.uiMode & 48) == 32;
            settings.setAlgorithmicDarkeningAllowed(z4);
            if (z4) {
                settings.setForceDark(2);
            } else {
                settings.setForceDark(0);
            }
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
        AbstractC0860e supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.l(true);
            supportActionBar.r(getIntent().getStringExtra("KEY_TITLE"));
        }
        this.f14359b = new WebView(this);
        String stringExtra = getIntent().getStringExtra("KEY_URL");
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("WebViewActivity ", "onCreate: url null");
            return;
        }
        this.f14359b.loadUrl(stringExtra);
        WebSettings settings = this.f14359b.getSettings();
        settings.setJavaScriptEnabled(getIntent().getBooleanExtra("KEY_ENABLE_JAVA_SCRIPT", true));
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        boolean booleanExtra = getIntent().getBooleanExtra("key_enable_force_dark", false);
        this.f14360c = booleanExtra;
        if (booleanExtra) {
            Configuration configuration = getResources().getConfiguration();
            WebSettings settings2 = this.f14359b.getSettings();
            boolean z4 = (configuration.uiMode & 48) == 32;
            settings2.setAlgorithmicDarkeningAllowed(z4);
            if (z4) {
                settings2.setForceDark(2);
            } else {
                settings2.setForceDark(0);
            }
        }
        this.f14359b.setWebViewClient(new d0(this));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.f14359b, new FrameLayout.LayoutParams(-1, -1));
        C0872q c0872q = new C0872q(3, this);
        WeakHashMap weakHashMap = K.S.f939a;
        K.J.u(frameLayout, c0872q);
        this.f14359b.setOverScrollMode(2);
        setContentView(frameLayout);
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
