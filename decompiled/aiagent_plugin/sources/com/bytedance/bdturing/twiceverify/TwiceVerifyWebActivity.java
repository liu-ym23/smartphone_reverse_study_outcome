package com.bytedance.bdturing.twiceverify;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.VerifyWebView;
import com.bytedance.bdturing.b.d;
import com.bytedance.bdturing.l;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.bdturing.verify.a.i;
import com.bytedance.bdturing.verify.a.n;
import com.bytedance.common.utility.k;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class TwiceVerifyWebActivity extends AppCompatActivity {
    private com.bytedance.bdturing.b.b jsBridgeModule;
    private com.bytedance.bdturing.verify.a.a mRequest;
    private View mTobBgView;
    private VerifyWebView mWebView;
    private l webViewListener;

    public TwiceVerifyWebActivity() {
        this.mWebView = null;
        this.mTobBgView = null;
        this.webViewListener = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(TwiceVerifyWebActivity r2) {
        ((TwiceVerifyWebActivity) ZeusTransformUtils.wrapperContextForParams(r2, TwiceVerifyWebActivity.class, "com.obric.aiagent.plugin")).showContentView();
    }

    static /* synthetic */ void access$100(TwiceVerifyWebActivity r2) {
        ((TwiceVerifyWebActivity) ZeusTransformUtils.wrapperContextForParams(r2, TwiceVerifyWebActivity.class, "com.obric.aiagent.plugin")).hideContentView();
    }

    static /* synthetic */ void access$200(TwiceVerifyWebActivity r2, int r3, String r4) {
        ((TwiceVerifyWebActivity) ZeusTransformUtils.wrapperContextForParams(r2, TwiceVerifyWebActivity.class, "com.obric.aiagent.plugin")).closePageAndNoticeResult(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(ZeusTransformUtils.mapRes(R.layout.bdturing_twice_verify_activity_web, "layout", "bdturing_twice_verify_activity_web"));
        c.a().c().a(this, "");
        this.mRequest = c.a().f();
        this.mTobBgView = findViewById(ZeusTransformUtils.mapRes(R.id.tob_bg_view, DbHelper.COL_ID, "tob_bg_view"));
        initWebView();
        if (c.a().d() == null) goto L6;
        Drawable r5 = androidx.core.graphics.drawable.a.g(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.bdturing_twice_verify_top_radius_bg, "drawable", "bdturing_twice_verify_top_radius_bg")));
        androidx.core.graphics.drawable.a.a(r5, c.a().d().b());
        this.mTobBgView.setBackgroundDrawable(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void initWebView() {
        if (this.mWebView != null) goto L5;
        VerifyWebView r0 = (VerifyWebView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.bdturing_webview, DbHelper.COL_ID, "bdturing_webview")), VerifyWebView.class, "com.obric.aiagent.plugin");
        this.mWebView = r0;
        r0.init(this.webViewListener);
    L5:
        hideContentView();
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.jsBridgeModule = new com.bytedance.bdturing.b.b(new d(this), this.mWebView);
        HashMap r1 = new HashMap();
        com.bytedance.bdturing.verify.a.a r2 = this.mRequest;
        if (r2 == null) goto L8;
        String r3 = r2.h();
    L9:
        this.mWebView.loadUrl(r3, r1);
        return;
    L8:
        r3 = "";
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.mWebView = null;
        c.a().g();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        closePageAndNoticeResult(2, "user close");
    }

    private void closePageAndNoticeResult(int r1, String r2) {
        finish();
        c.a r0 = c.a().e();
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = getWindow().getDecorView();
        setFinishOnTouchOutside(false);
        WindowManager.LayoutParams r1 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
        r1.gravity = 80;
        r1.width = k.a(this);
        if (c.a().d() != null) goto L5;
    L7:
        r1.height = (int) k.a(this, 304.0f);
        com.bytedance.bdturing.verify.a.a r3 = this.mRequest;
        if (r3 != null) goto L10;
    L18:
        getWindowManager().updateViewLayout(r0, r1);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.bdturing.verify.a.b.class) == false) goto L13;
        r1.height = (int) k.a(this, 290.0f);
        goto L18
    L13:
        if (ZeusTransformUtils.instanceOf(this.mRequest, n.class) == false) goto L16;
        r1.height = (int) k.a(this, 304.0f);
        goto L18
    L16:
        if (ZeusTransformUtils.instanceOf(this.mRequest, i.class) == false) goto L18;
        r1.height = (int) k.a(this, 272.0f);
        goto L18
    L5:
        if (c.a().d().a() <= 0) goto L7;
        r1.height = c.a().d().a();
        goto L18
    }

    private void hideContentView() {
        VerifyWebView r0 = this.mWebView;
        if (r0 == null) goto L5;
        r0.setVisibility(4);
    L5:
        View r2 = this.mTobBgView;
        if (r2 == null) goto L9;
        r2.setVisibility(4);
        return;
    }

    private void showContentView() {
        VerifyWebView r0 = this.mWebView;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r2 = this.mTobBgView;
        if (r2 == null) goto L9;
        r2.setVisibility(0);
        return;
    }
}
