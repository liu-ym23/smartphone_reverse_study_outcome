package com.android.contacts.common.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import com.android.contacts.common.R;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class LicenseActivity extends Activity {
    private static final String LICENSE_FILE = "file:///android_asset/licenses.html";
    private WebView mWebView;

    public void com_android_contacts_common_activity_LicenseActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_activity_LicenseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public LicenseActivity() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(R.layout.licenses);
        WebView r3 = (WebView) findViewById(R.id.webview);
        this.mWebView = r3;
        r3.loadUrl(LICENSE_FILE);
        ActionBar r1 = getActionBar();
        if (r1 == null) goto L6;
        r1.setDisplayOptions(4, 4);
        return;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mWebView.destroy();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 16908332) goto L7;
        finish();
        return true;
    L7:
        return super.onOptionsItemSelected(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_activity_LicenseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LicenseActivity r1) {
        r1.com_android_contacts_common_activity_LicenseActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
