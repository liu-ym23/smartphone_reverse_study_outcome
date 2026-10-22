package com.bytedance.bdturing;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class VerifyWebView extends WebView {
    private static final int MAX_RETRY_COUNT = 3;
    private static final long RETRY_TIME_DELAY = 500;
    private static final String TAG = "VerifyWebView";
    private l mCallback;
    private WebChromeClient mChromClient;
    private boolean mIsLoadFail;
    protected boolean mIsPageFinished;
    private h mOnTouchListener;
    private boolean mRefreshCancel;
    private Runnable mRefreshWebPageTask;
    private WebViewClient mWebClient;
    private int retryTime;

    static /* synthetic */ boolean access$000(VerifyWebView r0) {
        return r0.mIsLoadFail;
    }

    static /* synthetic */ void access$100(VerifyWebView r0) {
        r0.onLoadSuccess();
    }

    static /* synthetic */ void access$200(VerifyWebView r0, int r1, String r2, String r3) {
        r0.onLoadFailed(r1, r2, r3);
    }

    static /* synthetic */ l access$300(VerifyWebView r0) {
        return r0.mCallback;
    }

    static /* synthetic */ boolean access$400(VerifyWebView r0) {
        return r0.mRefreshCancel;
    }

    public static Context getFixedContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return r4;
    L5:
        if (Build.VERSION.SDK_INT <= 22) goto L7;
        return r4;
    L7:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.createConfigurationContext(new Configuration()), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public VerifyWebView(Context r3) {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getFixedContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mChromClient = new AnonymousClass3(this);
        this.mWebClient = new AnonymousClass4(this);
        this.mRefreshWebPageTask = new AnonymousClass8(this);
    }

    public VerifyWebView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getFixedContext(r5), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mChromClient = new AnonymousClass3(this);
        this.mWebClient = new AnonymousClass4(this);
        this.mRefreshWebPageTask = new AnonymousClass8(this);
    }

    public VerifyWebView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getFixedContext(r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, r5);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mChromClient = new AnonymousClass3(this);
        this.mWebClient = new AnonymousClass4(this);
        this.mRefreshWebPageTask = new AnonymousClass8(this);
    }

    public VerifyWebView(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getFixedContext(r7), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8, r5, r6);
        this.mIsLoadFail = false;
        this.mIsPageFinished = false;
        this.retryTime = 0;
        this.mRefreshCancel = false;
        this.mChromClient = new AnonymousClass3(this);
        this.mWebClient = new AnonymousClass4(this);
        this.mRefreshWebPageTask = new AnonymousClass8(this);
    }

    public void init(l r6) {
        this.mCallback = (l) ZeusTransformUtils.wrapperContextForParams(r6, l.class, "com.obric.aiagent.plugin");
        WebSettings r7 = getSettings();
        boolean r0 = true;
        r7.setLoadWithOverviewMode(true);
        r7.setDomStorageEnabled(true);
        r7.setAppCacheEnabled(false);
        r7.setUseWideViewPort(true);
        r7.setSupportZoom(false);
        r7.setAllowFileAccessFromFileURLs(false);
        r7.setLoadsImagesAutomatically(true);
        r7.setDefaultTextEncodingName("utf-8");
        r7.setCacheMode(2);
        r7.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        r7.setTextZoom(100);
        if (b.a().b().getRegionType() == BdTuringConfig.b.f6466e) goto L6;
        r0 = false;
    L6:
        if (r0 == true) goto L8;
    L19:
        setOverScrollMode(2);     // Catch: Throwable -> L12
    L14:
        setScrollContainer(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (g.a() == false) goto L17;
        setWebChromeClient(this.mChromClient);
    L17:
        setWebViewClient(this.mWebClient);
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    L8:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        r7.setMixedContentMode(0);
        goto L19
    }

    public void setOnTouchListener(h r1) {
        this.mOnTouchListener = r1;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        h r0 = this.mOnTouchListener;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        return super.onTouchEvent(r2);
    }

    public void startOrientationChangeAnimation(int r6, int r7, int r8, int r9) {
        ValueAnimator r10 = ValueAnimator.ofObject(new AnonymousClass1(this), new Object[]{new int[]{r8, r9}, new int[]{r6, r7}});
        r10.addUpdateListener(new AnonymousClass2(this));
        r10.setDuration(300).start();
    }

    private void onLoadSuccess() {
        g.a(TAG, "onLoadSuccess");
        e.a(0, "success");
        this.mIsPageFinished = true;
        if (this.mCallback == null) goto L6;
        post(new AnonymousClass5(this));
        return;
    }

    private void onLoadFailed(final int r4, final String r5, final String r6) {
        this.mIsLoadFail = true;
        e.a(r4, r6 + "|" + r5);
        if (this.mCallback == null) goto L5;
        post(new AnonymousClass6(this, r4, r5, r6));
    L5:
        int r7 = this.retryTime;
        if (r7 >= 3) goto L9;
        this.retryTime = r7 + 1;
        VerifyTaskHandler.a().a(this.mRefreshWebPageTask, 500);
        return;
    L9:
        if (this.mCallback == null) goto L13;
        post(new AnonymousClass7(this, r4, r6));
        return;
    }

    @Override // android.webkit.WebView
    public void reload() {
        g.a(TAG, "reload called:");
        this.mIsPageFinished = false;
        this.mIsLoadFail = false;
        super.reload();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g.a(TAG, "onDetachedFromWindow:");
        this.mRefreshCancel = true;
        VerifyTaskHandler.a().b(this.mRefreshWebPageTask);
    }
}
