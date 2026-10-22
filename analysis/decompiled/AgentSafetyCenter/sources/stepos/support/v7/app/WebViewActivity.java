package stepos.support.v7.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class WebViewActivity extends j {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f12262h = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f12263c = 0;

    /* renamed from: f, reason: collision with root package name */
    public WebView f12264f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12265g;

    public final void c(Configuration configuration) {
        WebSettings settings = this.f12264f.getSettings();
        boolean z10 = (configuration.uiMode & 48) == 32;
        settings.setAlgorithmicDarkeningAllowed(z10);
        if (z10) {
            settings.setForceDark(2);
        } else {
            settings.setForceDark(0);
        }
    }

    @Override // stepos.support.v7.app.j, androidx.activity.p, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f12265g) {
            c(configuration);
        }
    }

    @Override // stepos.support.v7.app.j, androidx.fragment.app.j, androidx.activity.p, d3.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
        c supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.j(true);
            supportActionBar.o(getIntent().getStringExtra("KEY_TITLE"));
        }
        this.f12264f = new WebView(this);
        String stringExtra = getIntent().getStringExtra("KEY_URL");
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("WebViewActivity ", "onCreate: url null");
            return;
        }
        this.f12264f.loadUrl(stringExtra);
        WebSettings settings = this.f12264f.getSettings();
        settings.setJavaScriptEnabled(getIntent().getBooleanExtra("KEY_ENABLE_JAVA_SCRIPT", true));
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        boolean booleanExtra = getIntent().getBooleanExtra("key_enable_force_dark", false);
        this.f12265g = booleanExtra;
        if (booleanExtra) {
            c(getResources().getConfiguration());
        }
        this.f12264f.setWebViewClient(new r0(this));
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.f12264f, new FrameLayout.LayoutParams(-1, -1));
        f fVar = new f(4);
        fVar.f12315f = this;
        VarHandle.storeStoreFence();
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.e0.b(frameLayout, fVar);
        this.f12264f.setOverScrollMode(2);
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
}
