package stepos.support.v7.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import u1.C2031a;

/* loaded from: classes4.dex */
public class WebViewActivity extends AbstractActivityC1962k {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f6239a = 0;
    public WebView b;
    public boolean c;

    @Override // stepos.support.v7.app.AbstractActivityC1962k, android.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.c) {
            q(configuration);
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
        AbstractC1955d supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.j(true);
            supportActionBar.q(getIntent().getStringExtra("KEY_TITLE"));
        }
        this.b = new WebView(this);
        String stringExtra = getIntent().getStringExtra("KEY_URL");
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("WebViewActivity ", "onCreate: url null");
            return;
        }
        this.b.loadUrl(stringExtra);
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(getIntent().getBooleanExtra("KEY_ENABLE_JAVA_SCRIPT", true));
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        boolean booleanExtra = getIntent().getBooleanExtra("key_enable_force_dark", false);
        this.c = booleanExtra;
        if (booleanExtra) {
            q(getResources().getConfiguration());
        }
        this.b.setWebViewClient(new c0(this));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        ViewCompat.setOnApplyWindowInsetsListener(frameLayout, new C2031a(this));
        this.b.setOverScrollMode(2);
        setContentView(frameLayout);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void q(Configuration configuration) {
        WebSettings settings = this.b.getSettings();
        boolean z10 = (configuration.uiMode & 48) == 32;
        settings.setAlgorithmicDarkeningAllowed(z10);
        if (z10) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }
}
