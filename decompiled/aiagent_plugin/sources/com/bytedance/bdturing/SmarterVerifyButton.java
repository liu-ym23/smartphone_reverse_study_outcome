package com.bytedance.bdturing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SmarterVerifyButton extends VerifyWebView {
    public static final String TAG = "SmarterVerifyButton";
    private c mCallback;
    private boolean mIsVerifySuccess;
    private com.bytedance.bdturing.b.b mJsBridge;
    private long mLoadSuccessTime;
    private i mSmarterListener;
    private com.bytedance.bdturing.b.a mVerifyHandler;
    private l webViewListener;

    static /* synthetic */ c access$000(SmarterVerifyButton r0) {
        return r0.mCallback;
    }

    static /* synthetic */ boolean access$102(SmarterVerifyButton r0, boolean r1) {
        r0.mIsVerifySuccess = r1;
        return r1;
    }

    static /* synthetic */ long access$200(SmarterVerifyButton r2) {
        return r2.mLoadSuccessTime;
    }

    static /* synthetic */ long access$202(SmarterVerifyButton r0, long r1) {
        r0.mLoadSuccessTime = r1;
        return r1;
    }

    static /* synthetic */ l access$300(SmarterVerifyButton r0) {
        return r0.webViewListener;
    }

    static /* synthetic */ void access$401(SmarterVerifyButton r2, l r3) {
        super.init((l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ i access$500(SmarterVerifyButton r0) {
        return r0.mSmarterListener;
    }

    static /* synthetic */ void access$600(SmarterVerifyButton r0, JSONObject r1) {
        r0.callJsCode(r1);
    }

    public SmarterVerifyButton(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mSmarterListener = new i();
        this.mVerifyHandler = new AnonymousClass1(this);
        this.webViewListener = new AnonymousClass2(this);
    }

    public SmarterVerifyButton(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mSmarterListener = new i();
        this.mVerifyHandler = new AnonymousClass1(this);
        this.webViewListener = new AnonymousClass2(this);
    }

    public void init() {
        this.mJsBridge = new com.bytedance.bdturing.b.b(this.mVerifyHandler, this);
        this.mIsPageFinished = false;
        this.mIsVerifySuccess = false;
        com.bytedance.bdturing.setting.h.f6610a.a(true, new AnonymousClass3(this));
    }

    @Override // com.bytedance.bdturing.VerifyWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (b.a().c() == true) goto L5;
    L16:
        return true;
    L5:
        if (this.mIsPageFinished == false) goto L16;
        if (this.mIsVerifySuccess == true) goto L16;
        int r0 = r3.getAction();
        if (r0 != 0) goto L12;
        this.mSmarterListener.a();
    L15:
        return super.onTouchEvent(r3);
    L12:
        if (r0 != 1) goto L15;
        this.mSmarterListener.a(r3, new AnonymousClass4(this));
        goto L15
    }

    private void callJsCode(JSONObject r4) {
        String r5 = com.bytedance.bdturing.b.c.a(1, "bytedcert.verifyData", "call", r4, "bytedcert.verifyData");
        this.mJsBridge.a(r5);
    }

    public void setCallback(c r3) {
        this.mCallback = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }
}
