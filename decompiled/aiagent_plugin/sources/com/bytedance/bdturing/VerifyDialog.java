package com.bytedance.bdturing;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class VerifyDialog extends Dialog {
    private static final int HEIGHT_FEEDBACK = 304;
    private static final int MASK_COLOR = -2013265920;
    private static final String TAG = "VerifyDialog";
    private static final long TIME_OUT_TIME = 10000;
    private static final int WIDTH_FEEDBACK = 300;
    private Context context;
    private boolean isColseByH5;
    private boolean isDismissing;
    private boolean isPageLoadSuccess;
    private ImageView loading;
    private c mCallback;
    private Button mCloseBtn;
    private e.a mCloseReson;
    private FrameLayout mDialogLayout;
    private String mErrorText;
    private Button mFeedbackBtn;
    private TextView mFeedbackContent;
    private ViewGroup mFeedbackGroup;
    private boolean mIsOrientationChange;
    private com.bytedance.bdturing.b.b mJsBridge;
    private int mLastOrientation;
    private OnDialogBackgroundListener mOnDialogBackgroundListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private h mOnTouchReportListener;
    private ComponentCallbacks mOrientationListener;
    private String mUrl;
    private com.bytedance.bdturing.b.a mVerifyHandler;
    private int mVerifyType;
    private VerifyWebView mWebView;
    private com.bytedance.bdturing.verify.a.a request;
    private l webViewListener;

    static /* synthetic */ e.a access$002(VerifyDialog r0, e.a r1) {
        r0.mCloseReson = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(VerifyDialog r0) {
        return r0.isDismissing;
    }

    static /* synthetic */ DialogInterface.OnDismissListener access$1000(VerifyDialog r0) {
        return r0.mOnDismissListener;
    }

    static /* synthetic */ com.bytedance.bdturing.verify.a.a access$1100(VerifyDialog r0) {
        return r0.request;
    }

    static /* synthetic */ boolean access$1202(VerifyDialog r0, boolean r1) {
        r0.isPageLoadSuccess = r1;
        return r1;
    }

    static /* synthetic */ String access$1302(VerifyDialog r0, String r1) {
        r0.mErrorText = r1;
        return r1;
    }

    static /* synthetic */ String access$1400(VerifyDialog r0, int r1) {
        return r0.getFeedbackContent(r1);
    }

    static /* synthetic */ boolean access$1502(VerifyDialog r0, boolean r1) {
        r0.mIsOrientationChange = r1;
        return r1;
    }

    static /* synthetic */ void access$200(VerifyDialog r0) {
        r0.stopLoading();
    }

    static /* synthetic */ VerifyWebView access$300(VerifyDialog r0) {
        return r0.mWebView;
    }

    static /* synthetic */ ViewGroup access$400(VerifyDialog r0) {
        return r0.mFeedbackGroup;
    }

    static /* synthetic */ c access$500(VerifyDialog r0) {
        return r0.mCallback;
    }

    static /* synthetic */ c access$502(VerifyDialog r2, c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        r2.mCallback = r4;
        return r4;
    }

    static /* synthetic */ boolean access$602(VerifyDialog r0, boolean r1) {
        r0.isColseByH5 = r1;
        return r1;
    }

    static /* synthetic */ void access$700(VerifyDialog r0, int r1, int r2, boolean r3) {
        r0.changeDialog(r1, r2, r3);
    }

    static /* synthetic */ void access$800(VerifyDialog r0, int r1, int r2) {
        r0.changeDialogV2(r1, r2);
    }

    static /* synthetic */ int access$900(VerifyDialog r0) {
        return r0.mVerifyType;
    }

    public VerifyDialog(com.bytedance.bdturing.verify.a.a r6, c r7) {
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.aiagent.plugin");
        super(ZeusTransformUtils.getActivity(r6, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.style.VerifyDialogTheme, "style", "VerifyDialogTheme"));
        this.isPageLoadSuccess = false;
        this.isColseByH5 = false;
        this.isDismissing = false;
        this.mIsOrientationChange = false;
        this.mErrorText = null;
        this.mOnTouchReportListener = null;
        this.mCloseReson = e.a.f6550c;
        this.mVerifyHandler = new AnonymousClass5(this);
        this.webViewListener = new AnonymousClass7(this);
        this.mOrientationListener = new AnonymousClass8(this);
        this.request = r6;
        this.mVerifyType = r6.getType();
        this.mUrl = this.request.h();
        this.mCallback = r8;
        this.mLastOrientation = com.bytedance.bdturing.utils.d.a(ZeusTransformUtils.getActivity(this.request, "com.obric.aiagent.plugin"));
        this.mOnDialogBackgroundListener = new OnDialogBackgroundListener(ZeusTransformUtils.getActivity(this.request, "com.obric.aiagent.plugin"));
        this.context = ZeusTransformUtils.wrapperContext(ZeusTransformUtils.getActivity(r6, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        setListeners();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(ZeusTransformUtils.inflate(LayoutInflater.from(this.context), ZeusTransformUtils.mapRes(R.layout.layout_verify_dialog, "layout", "layout_verify_dialog"), null, "com.obric.aiagent.plugin"));
        initWindow();
        initViews();
        startLoading();
        if (ZeusTransformUtils.getActivity(this.request, "com.obric.aiagent.plugin") == null) goto L5;
        ZeusTransformUtils.getActivity(this.request, "com.obric.aiagent.plugin").registerComponentCallbacks(this.mOrientationListener);
    L5:
        this.mOnDialogBackgroundListener.registerListener();
        setCanceledOnTouchOutside(this.request.b());
        setCancelable(true);
        this.mJsBridge = new com.bytedance.bdturing.b.b(this.mVerifyHandler, this.mWebView);
        g.a(TAG, "loadUrl = " + this.mUrl);
        this.mWebView.loadUrl(this.mUrl);
        if (this.request.a() == false) goto L9;
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this.context, "com.obric.aiagent.plugin").getDisplayMetrics();
        ViewGroup.LayoutParams r0 = this.mWebView.getLayoutParams();
        r0.width = r5.widthPixels;
        r0.height = r5.heightPixels;
        this.mWebView.setLayoutParams(r0);
        this.mWebView.setVisibility(0);
        return;
    }

    private void initWindow() {
        WindowManager.LayoutParams r0 = getWindow().getAttributes();
        r0.width = -1;
        r0.height = -1;
        getWindow().setAttributes(r0);
    }

    private void startLoading() {
        if (this.request.d() == false) goto L5;
        RotateAnimation r0 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r0.setDuration(1000);
        r0.setRepeatCount(-1);
        r0.setInterpolator(new LinearInterpolator());
        this.loading.startAnimation(r0);
        this.mDialogLayout.setBackgroundColor(MASK_COLOR);
        return;
    L5:
        this.loading.setVisibility(8);
    }

    private void stopLoading() {
        if (this.request.d() == false) goto L6;
        this.loading.clearAnimation();
        this.loading.setVisibility(8);
    L6:
        if (this.request.c() == false) goto L9;
        this.mDialogLayout.setBackgroundColor(MASK_COLOR);
        return;
    }

    private void initViews() {
        this.mFeedbackGroup = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.view_feedback, DbHelper.COL_ID, "view_feedback")), ViewGroup.class, "com.obric.aiagent.plugin");
        this.mFeedbackContent = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.text_feedback_content, DbHelper.COL_ID, "text_feedback_content")), TextView.class, "com.obric.aiagent.plugin");
        this.mFeedbackBtn = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_feedback, DbHelper.COL_ID, "btn_feedback")), Button.class, "com.obric.aiagent.plugin");
        this.mCloseBtn = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_feedback_close, DbHelper.COL_ID, "btn_feedback_close")), Button.class, "com.obric.aiagent.plugin");
        this.loading = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.loading, DbHelper.COL_ID, "loading")), ImageView.class, "com.obric.aiagent.plugin");
        this.mWebView = (VerifyWebView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.verify_webview, DbHelper.COL_ID, "verify_webview")), VerifyWebView.class, "com.obric.aiagent.plugin");
        this.mDialogLayout = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.dialog_framelayout, DbHelper.COL_ID, "dialog_framelayout")), FrameLayout.class, "com.obric.aiagent.plugin");
        View.OnClickListener r0 = new AnonymousClass1(this);
        this.mFeedbackBtn.setOnClickListener(r0);
        this.mCloseBtn.setOnClickListener(r0);
        this.mWebView.init(this.webViewListener);
        h r1 = new h(this.request.g());
        this.mOnTouchReportListener = r1;
        this.mWebView.setOnTouchListener(r1);
    }

    private void changeDialog(final int r4, final int r5, boolean r6) {
        g.g(TAG, "changeDialog width = " + r4 + ", height = " + r5);
        if (this.isDismissing == false) goto L5;
        return;
    L5:
        if (isShowing() == true) goto L8;
        return;
    L8:
        if (this.request.a() == false) goto L10;
        r4 = -1;
        r5 = -1;
    L10:
        float r7 = com.bytedance.bdturing.utils.d.b(this.context);
        if (r4 <= 0) goto L14;
        if (r5 <= 0) goto L14;
        r4 = Math.round(r4 * r7);
        r5 = Math.round(r5 * r7);
    L14:
        e.a(0, "web_become_visible width=" + r4 + ":height=" + r5 + ":density=" + r7);
        final ViewGroup.LayoutParams r8 = this.mWebView.getLayoutParams();
        if (this.mIsOrientationChange == true) goto L17;
    L22:
        this.mWebView.post(new AnonymousClass2(this, r8, r4, r5));
        return;
    L17:
        if (r8.width <= 0) goto L22;
        if (r8.height <= 0) goto L22;
        this.mWebView.startOrientationChangeAnimation(r4, r5, r8.width, r8.height);
        this.mIsOrientationChange = false;
    }

    public synchronized void clearResource() {
        monitor-enter(this);
        g.a(TAG, "clearResource()");     // Catch: Throwable -> L12
        if (this.context == null) goto L6;
    L9:
        this.context = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        this.mJsBridge.a();     // Catch: Throwable -> L12
        this.mJsBridge = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L6:
        if (this.mJsBridge != null) goto L9;
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean callJsCode(String r1) {
        com.bytedance.bdturing.b.b r0 = this.mJsBridge;
        if (r0 != null) goto L6;
        g.e(TAG, "(mJsBridge == null) ");
        return false;
    L6:
        r0.a(r1);
        return true;
    }

    private void notifyJsToClose(String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("style", r4);     // Catch: JSONException -> L5
    L7:
        callJsCode(com.bytedance.bdturing.b.c.a(1, "bytedcert.goToClose", "call", r0, "bytedcert.goToClose"));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mWebView == null) goto L6;
        getWindow().getDecorView().post(new AnonymousClass3(this));
        this.mWebView = null;
    L6:
        if (this.isDismissing == false) goto L8;
        return;
    L8:
        this.isDismissing = true;
        if (isShowing() == false) goto L14;
        super.dismiss();     // Catch: Exception -> L12
    L12:
        g.c("BdTuring", "an exception caught in the stage of VerifyDialog dismissing.");
    L14:
        if (ZeusTransformUtils.getActivity(this.request, "com.obric.aiagent.plugin") == null) goto L16;
        ZeusTransformUtils.getActivity(this.request, "com.obric.aiagent.plugin").unregisterComponentCallbacks(this.mOrientationListener);
    L16:
        OnDialogBackgroundListener r2 = this.mOnDialogBackgroundListener;
        if (r2 == null) goto L19;
        r2.unregisterListener();
        this.mOnDialogBackgroundListener = null;
    L19:
        DialogInterface.OnDismissListener r3 = this.mOnDismissListener;
        if (r3 == null) goto L22;
        r3.onDismiss(this);
    L22:
        VerifyTaskHandler.a().a(1, this, TIME_OUT_TIME);
        c r0 = this.mCallback;
        if (r0 == null) goto L28;
        if (this.isPageLoadSuccess == true) goto L28;
        r0.a(3, null);
        this.mCallback = null;
    L28:
        if (this.isColseByH5 == true) goto L31;
        notifyJsToClose(this.mCloseReson.a());
    L31:
        if (this.isPageLoadSuccess == true) goto L33;
        e.a(this.mCloseReson);
        clearResource();
    L33:
        VerifyTaskHandler.a().a(3, null);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener r3) {
        this.mOnDismissListener = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent r2) {
        this.mOnTouchReportListener.a(r2);
        if (this.request.b() == false) goto L9;
        if (this.mFeedbackGroup.getVisibility() != 0) goto L7;
        this.mCloseReson = e.a.f6552e;
        goto L9
    L7:
        this.mCloseReson = e.a.f6548a;
    L9:
        return super.onTouchEvent(r2);
    }

    private void setListeners() {
        setOnKeyListener(new AnonymousClass4(this));
    }

    private void changeDialogV2(int r5, int r6) {
        g.g(TAG, "changeDialogV2 webContentWidth = " + r5 + ", webContentHeight = " + r6);
        if (this.isDismissing == false) goto L5;
        return;
    L5:
        if (isShowing() == false) goto L22;
        final int r1 = -1;
        if (this.request.a() == false) goto L10;
        final int r0 = -1;
    L11:
        e.a(0, "web_become_visible webContentWidth=" + r5 + ":webContentHeight=" + r6);
        final ViewGroup.LayoutParams r7 = this.mWebView.getLayoutParams();
        if (this.mIsOrientationChange == true) goto L14;
    L19:
        this.mWebView.post(new AnonymousClass6(this, r7, r0, r1));
        return;
    L14:
        if (r7.width <= 0) goto L19;
        if (r7.height <= 0) goto L19;
        this.mWebView.startOrientationChangeAnimation(r0, r1, r7.width, r7.height);
        this.mIsOrientationChange = false;
        return;
    L10:
        r0 = r5;
        r1 = r6;
        goto L11
    }

    private String getFeedbackContent(int r2) {
        return "Service error" + r2 + ", Please feed back to us";
    }

    public com.bytedance.bdturing.verify.a.a getRequest() {
        return this.request;
    }
}
