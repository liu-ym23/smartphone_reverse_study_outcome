package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.PopupWindow;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OMiddleArrowPopover.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OMiddleArrowPopover extends PopupWindow {
    public static final b Companion = null;
    public static final long OPACITY_LONG = 120;
    public static final long OPACITY_SHORT = 90;
    public static final long SCALE_LONG = 420;
    public static final long SCALE_SHORT = 120;
    private static final float TEXT_SIZE_DP = 0.0f;
    private static volatile int currentShowBubbleNumbers;
    private static boolean shouldForceDismiss;
    private Activity activity;
    private AnimatorSet animSet;
    private String bubbleText;
    private int bubbleTextRes;
    private Animator customInAnimator;
    private Animator customOutAnimator;
    private boolean enableAutoDismiss;
    private boolean hasCome;
    private boolean isAlreadyDismiss;
    private Boolean isHideVirtualKey;
    private boolean mAlignArrowPadding;
    private long mAnimTime;
    private float mArrowOffset;
    private long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBorderColor;
    private int mBorderWidth;
    private float mBubbleOffset;
    private c mClickListener;
    private float mCornerRadius;
    private d mDismissListener;
    private final Runnable mDismissRunnable;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mGravity;
    private int mHeight;
    private boolean mLayoutClickable;
    private boolean mNeedArrow;
    private boolean mNeedOverShoot;
    private boolean mNeedShadow;
    private OMiddleArrowPopoverLayout mOBubbleLayout;
    private boolean mOnClickMaintain;
    private boolean mOutsideTouchable;
    private float mPadding;
    private int mParentHeight;
    private int mParentWidth;
    private int mShadowColor;
    private float mShadowRadius;
    private boolean mShowAsDropDown;
    private boolean mShowElevationShadow;
    private e mShowListener;
    private Point mTargetLocation;
    private int mTextColor;
    private float mTextSize;
    private PopoverTextView mTextView;
    private Typeface mTypeFace;
    private boolean mUseDefaultView;
    private View mView;
    private int mWidth;
    private int mXOffset;
    private int mYOffset;
    private int padding;
    private Float shadowDx;
    private Float shadowDy;
    private boolean transparentBg;

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    public static final class a {
        private boolean A;
        private int B;
        private boolean C;
        private float D;
        private boolean E;
        private boolean F;
        private int G;
        private int H;
        private boolean I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private float f35972J;
        private Float K;
        private Float L;
        private boolean M;
        private boolean N;
        private boolean O;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Activity f35973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f35974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f35976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f35977e;
        private boolean f;
        private boolean g;
        private int h;
        private int i;
        private long j;
        private long k;
        private boolean l;
        private View m;
        private int n;
        private int o;
        private String p;
        private int q;
        private float r;
        private Typeface s;
        private int t;
        private c u;
        private d v;
        private e w;
        private boolean x;
        private float y;
        private boolean z;

        public final Activity getActivity() {
            return this.f35973a;
        }

        public final boolean a() {
            return this.f35974b;
        }

        public final int b() {
            return this.f35975c;
        }

        public final float c() {
            return this.f35976d;
        }

        public final int d() {
            return this.f35977e;
        }

        public final boolean e() {
            return this.f;
        }

        public final boolean f() {
            return this.g;
        }

        public final int g() {
            return this.h;
        }

        public final int h() {
            return this.i;
        }

        public final long i() {
            return this.j;
        }

        public final long j() {
            return this.k;
        }

        public final boolean k() {
            return this.l;
        }

        public final View l() {
            return this.m;
        }

        public final int m() {
            return this.n;
        }

        public final int n() {
            return this.o;
        }

        public final String o() {
            return this.p;
        }

        public final int p() {
            return this.q;
        }

        public final float q() {
            return this.r;
        }

        public final Typeface r() {
            return this.s;
        }

        public final int s() {
            return this.t;
        }

        public final c t() {
            return this.u;
        }

        public final d u() {
            return this.v;
        }

        public final e v() {
            return this.w;
        }

        public final boolean w() {
            return this.x;
        }

        public final float x() {
            return this.y;
        }

        public final boolean y() {
            return this.z;
        }

        public final boolean z() {
            return this.A;
        }

        public final int A() {
            return this.B;
        }

        public final boolean B() {
            return this.C;
        }

        public final float C() {
            return this.D;
        }

        public final boolean D() {
            return this.E;
        }

        public final boolean E() {
            return this.F;
        }

        public final int F() {
            return this.G;
        }

        public final int G() {
            return this.H;
        }

        public final boolean H() {
            return this.I;
        }

        public final float I() {
            return this.f35972J;
        }

        public final Float J() {
            return this.K;
        }

        public final Float K() {
            return this.L;
        }

        public final boolean L() {
            return this.M;
        }

        public final boolean M() {
            return this.N;
        }

        public final boolean N() {
            return this.O;
        }
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        public final int a(int r1) {
            if (r1 != 8388611) goto L5;
            return 3;
        L5:
            if (r1 != 8388613) goto L11;
            return 5;
        L11:
            return r1;
        }

        private b() {
        }

        public final int a() {
            return OMiddleArrowPopover.access$getCurrentShowBubbleNumbers$cp();
        }
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    public interface c {
        void a();
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    public interface d {
        void a();
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    public interface e {
        void a();
    }

    public static final int getCurrentShowBubbleNumbers() {
        return Companion.a();
    }

    /* JADX INFO: renamed from: lambda$MiXmpuQlnr9ms1NHo3bD-RzDaTU, reason: not valid java name */
    public static /* synthetic */ void m1119lambda$MiXmpuQlnr9ms1NHo3bDRzDaTU(OMiddleArrowPopover r0, View r1) {
        m1121setBubbleLayout$lambda0(r0, r1);
    }

    public static /* synthetic */ void lambda$gE1ZG_VQZiibnYtOBgxt6pObcoM(OMiddleArrowPopover r0) {
        m1120mDismissRunnable$lambda1(r0);
    }

    public OMiddleArrowPopover(a r5) {
        o.e(r5, "builder");
        this.mShadowColor = -16777216;
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mUseDefaultView = true;
        this.bubbleText = "";
        this.mTextSize = TEXT_SIZE_DP;
        this.mTypeFace = Typeface.defaultFromStyle(1);
        this.mNeedArrow = true;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShadowRadius = 2.0f;
        this.mCornerRadius = OMiddleArrowPopoverLayout.Companion.a();
        this.mLayoutClickable = true;
        this.activity = ZeusTransformUtils.wrapperContext2Activity(ZeusTransformUtils.getActivity(r5, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mGravity = r5.b();
        this.mArrowOffset = r5.c();
        this.mBgColor = r5.d();
        this.mNeedOverShoot = r5.e();
        this.isHideVirtualKey = Boolean.valueOf(r5.f());
        this.mXOffset = r5.g();
        this.mYOffset = r5.h();
        this.mAnimTime = r5.i();
        this.mAutoDismissDelayMillis = r5.j();
        this.mUseDefaultView = r5.k();
        this.mView = r5.l();
        this.mHeight = r5.n();
        this.mWidth = r5.m();
        this.bubbleText = r5.o();
        this.bubbleTextRes = r5.p();
        this.mTextSize = r5.q();
        this.mTextColor = r5.s();
        this.mTypeFace = r5.r();
        this.mClickListener = r5.t();
        this.mDismissListener = r5.u();
        this.mShowListener = r5.v();
        this.mNeedArrow = r5.w();
        this.mPadding = g.c((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"), r5.x());
        this.mOutsideTouchable = r5.y();
        this.mFocusable = r5.a();
        this.mNeedShadow = r5.z();
        this.mShadowColor = r5.A();
        this.mAlignArrowPadding = r5.B();
        this.mShadowRadius = r5.C();
        this.mGetLocationInWindow = r5.D();
        this.mShowElevationShadow = r5.E();
        this.mBorderWidth = r5.F();
        this.mBorderColor = r5.G();
        this.transparentBg = r5.H();
        this.mCornerRadius = r5.I();
        this.shadowDx = r5.J();
        this.shadowDy = r5.K();
        this.mShowAsDropDown = r5.L();
        this.mOnClickMaintain = r5.M();
        this.mLayoutClickable = r5.N();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (this.mUseDefaultView == true) goto L10;
        View r0 = this.mView;
        if (r0 == null) goto L10;
        setBubbleLayout(r0);
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L9;
        o.c("mOBubbleLayout");
        r1 = null;
    L9:
        r1.setUseDefaultView(false);
    L11:
        initContentView();
        this.mDismissRunnable = new $$Lambda$OMiddleArrowPopover$gE1ZG_VQZiibnYtOBgxt6pObcoM(this);
        return;
    L10:
        setDefaultView();
        goto L11
    }

    public static final /* synthetic */ int access$getCurrentShowBubbleNumbers$cp() {
        return currentShowBubbleNumbers;
    }

    public static final /* synthetic */ d access$getMDismissListener$p(OMiddleArrowPopover r0) {
        return r0.mDismissListener;
    }

    public static final /* synthetic */ e access$getMShowListener$p(OMiddleArrowPopover r0) {
        return r0.mShowListener;
    }

    public static final /* synthetic */ float access$getTEXT_SIZE_DP$cp() {
        return TEXT_SIZE_DP;
    }

    public static final /* synthetic */ void access$setShouldForceDismiss$cp(boolean r0) {
        shouldForceDismiss = r0;
    }

    private final int getMGravity() {
        return Companion.a(this.mGravity);
    }

    private final void initContentView() {
        int r0 = this.mWidth;
        if (r0 != 0) goto L5;
    L7:
        boolean r1 = true;
        if (o.a(this.isHideVirtualKey, true) == false) goto L10;
        hideSystemUi();
    L10:
        OMiddleArrowPopoverLayout r2 = null;
        if (this.mBgColor == 0) goto L16;
        OMiddleArrowPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L15;
        o.c("mOBubbleLayout");
        r3 = null;
    L15:
        r3.setMBgColor(this.mBgColor);
    L16:
        OMiddleArrowPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L19;
        o.c("mOBubbleLayout");
        r4 = null;
    L19:
        r4.setBubbleOrientation(getOrientation(getMGravity()));
        if (this.mPadding == 0.0f) goto L23;
        r1 = false;
    L23:
        if (r1 == true) goto L28;
        OMiddleArrowPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L27;
        o.c("mOBubbleLayout");
        r5 = null;
    L27:
        r5.setPadding(this.mPadding);
    L28:
        OMiddleArrowPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L31;
        o.c("mOBubbleLayout");
        r6 = null;
    L31:
        r6.getShadowConfig().a(this.mShadowColor);
        OMiddleArrowPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L34;
        o.c("mOBubbleLayout");
        r7 = null;
    L34:
        r7.getShadowConfig().a(this.mShadowRadius);
        OMiddleArrowPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L37;
        o.c("mOBubbleLayout");
        r8 = null;
    L37:
        r8.setBorderColor(this.mBorderColor);
        OMiddleArrowPopoverLayout r9 = this.mOBubbleLayout;
        if (r9 != null) goto L40;
        o.c("mOBubbleLayout");
        r9 = null;
    L40:
        r9.setBorderWidth(this.mBorderWidth);
        OMiddleArrowPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L43;
        o.c("mOBubbleLayout");
    L44:
        r2.setTransparentBg(this.transparentBg);
        return;
    L43:
        r2 = r10;
        goto L44
    L5:
        if (this.mHeight == 0) goto L7;
        setWidth(r0);
        setHeight(this.mHeight);
        OMiddleArrowPopoverLayout.Companion.a(getWidth());
        OMiddleArrowPopoverLayout.Companion.b(getHeight());
        goto L7
    }

    public final void setCustomAnimator(Animator r2, Animator r3) {
        o.e(r2, "inAnimator");
        o.e(r3, "outAnimator");
        this.customInAnimator = r2;
        this.customOutAnimator = r3;
    }

    public final long getInAnimTime() {
        return this.mAnimTime;
    }

    public final void setXOffset(int r1) {
        this.mXOffset = r1;
    }

    public final void setYOffset(int r1) {
        this.mYOffset = r1;
    }

    public final void setAlignArrowPadding(boolean r1) {
        this.mAlignArrowPadding = r1;
    }

    private final void setDefaultView() {
        PopoverTextView r2 = null;
        PopoverTextView r0 = new PopoverTextView((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"), null, 2, null);
        this.mTextView = r0;
        if (this.mTextColor == 0) goto L7;
        if (r0 != null) goto L6;
        o.c("mTextView");
        r0 = null;
    L6:
        r0.setTextColor(this.mTextColor);
    L11:
        if (this.mTypeFace == null) goto L16;
        PopoverTextView r1 = this.mTextView;
        if (r1 != null) goto L15;
        o.c("mTextView");
        r1 = null;
    L15:
        r1.setTypeface(this.mTypeFace);
    L16:
        PopoverTextView r3 = this.mTextView;
        if (r3 != null) goto L19;
        o.c("mTextView");
        r3 = null;
    L19:
        r3.setTextSize(1, TEXT_SIZE_DP);
        PopoverTextView r4 = this.mTextView;
        if (r4 != null) goto L22;
        o.c("mTextView");
        r4 = null;
    L22:
        r4.setTextAlignment(5);
        PopoverTextView r5 = this.mTextView;
        if (r5 != null) goto L25;
        o.c("mTextView");
        r5 = null;
    L25:
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        PopoverTextView r6 = this.mTextView;
        if (r6 != null) goto L28;
        o.c("mTextView");
        r6 = null;
    L28:
        r6.setGravity(17);
        PopoverTextView r7 = this.mTextView;
        if (r7 != null) goto L31;
        o.c("mTextView");
        r7 = null;
    L31:
        r7.setMaxWidth(g.a((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"), 276));
        PopoverTextView r8 = this.mTextView;
        if (r8 != null) goto L34;
        o.c("mTextView");
        r8 = null;
    L34:
        r8.setMaxLines(1);
        PopoverTextView r9 = this.mTextView;
        if (r9 != null) goto L37;
        o.c("mTextView");
        r9 = null;
    L37:
        r9.setEllipsize(TextUtils.TruncateAt.END);
        PopoverTextView r10 = this.mTextView;
        if (r10 != null) goto L40;
        o.c("mTextView");
        r10 = null;
    L40:
        setBubbleLayout((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        if (this.isHideVirtualKey != null) goto L44;
        this.isHideVirtualKey = true;
    L44:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.bubbleText, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L50;
        PopoverTextView r11 = this.mTextView;
        if (r11 != null) goto L48;
        o.c("mTextView");
        r11 = null;
    L48:
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.bubbleText, CharSequence.class, "com.obric.aiagent.plugin"));
    L50:
        if (this.bubbleTextRes == 0) goto L56;
        PopoverTextView r12 = this.mTextView;
        if (r12 != null) goto L54;
        o.c("mTextView");
        r12 = null;
    L54:
        r12.setText(this.bubbleTextRes);
    L56:
        if (this.mTextSize != 0.0f) goto L58;
        boolean r13 = true;
    L59:
        if (r13 == true) goto L65;
        PopoverTextView r14 = this.mTextView;
        if (r14 != null) goto L63;
        o.c("mTextView");
    L64:
        r2.setTextSize(1, this.mTextSize);
        goto L65
    L63:
        r2 = r14;
    L65:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L58:
        r13 = false;
        goto L59
    L7:
        if (r0 != null) goto L9;
        o.c("mTextView");
        r0 = null;
    L9:
        r0.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.ConstTextInverse, "color", "ConstTextInverse")));
        goto L11
    }

    private final void setBubbleLayout(View r7) {
        OMiddleArrowPopoverLayout r0 = new OMiddleArrowPopoverLayout((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"));
        this.mOBubbleLayout = r0;
        if (r0 != null) goto L5;
        o.c("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBackgroundColor(0);
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L8;
        o.c("mOBubbleLayout");
        r1 = null;
    L8:
        r1.setCornerRadius(this.mCornerRadius);
        OMiddleArrowPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L11;
        o.c("mOBubbleLayout");
        r2 = null;
    L11:
        r2.addView(r7);
        OMiddleArrowPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L14;
        o.c("mOBubbleLayout");
        r8 = null;
    L14:
        r8.setGravity(17);
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-2, -2);
        OMiddleArrowPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L17;
        o.c("mOBubbleLayout");
        r3 = null;
    L17:
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        OMiddleArrowPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L20;
        o.c("mOBubbleLayout");
        r10 = null;
    L20:
        r10.setVisibility(8);
        if (this.mBgColor == 0) goto L26;
        OMiddleArrowPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L25;
        o.c("mOBubbleLayout");
        r11 = null;
    L25:
        r11.setMBgColor(this.mBgColor);
    L26:
        OMiddleArrowPopoverLayout r12 = this.mOBubbleLayout;
        if (r12 != null) goto L29;
        o.c("mOBubbleLayout");
        r12 = null;
    L29:
        r12.setMNeedArrow(this.mNeedArrow);
        OMiddleArrowPopoverLayout r13 = this.mOBubbleLayout;
        if (r13 != null) goto L32;
        o.c("mOBubbleLayout");
        r13 = null;
    L32:
        r13.setMNeedShadow(this.mNeedShadow);
        OMiddleArrowPopoverLayout r14 = this.mOBubbleLayout;
        if (r14 != null) goto L35;
        o.c("mOBubbleLayout");
        r14 = null;
    L35:
        r14.getShadowConfig().a(this.mShadowColor);
        if (this.shadowDx == null) goto L42;
        OMiddleArrowPopoverLayout r15 = this.mOBubbleLayout;
        if (r15 != null) goto L40;
        o.c("mOBubbleLayout");
        r15 = null;
    L40:
        OMiddleArrowPopoverLayout.b r16 = r15.getShadowConfig();
        Float r4 = this.shadowDx;
        o.a(r4);
        r16.b(r4.floatValue());
    L42:
        if (this.shadowDy == null) goto L48;
        OMiddleArrowPopoverLayout r17 = this.mOBubbleLayout;
        if (r17 != null) goto L46;
        o.c("mOBubbleLayout");
        r17 = null;
    L46:
        OMiddleArrowPopoverLayout.b r18 = r17.getShadowConfig();
        Float r5 = this.shadowDy;
        o.a(r5);
        r18.c(r5.floatValue());
    L48:
        if (this.mLayoutClickable == false) goto L56;
        OMiddleArrowPopoverLayout r19 = this.mOBubbleLayout;
        if (r19 != null) goto L52;
        o.c("mOBubbleLayout");
        r19 = null;
    L52:
        r19.setClickable(true);
        OMiddleArrowPopoverLayout r20 = this.mOBubbleLayout;
        if (r20 != null) goto L55;
        o.c("mOBubbleLayout");
        r20 = null;
    L55:
        r20.setOnClickListener(new $$Lambda$OMiddleArrowPopover$MiXmpuQlnr9ms1NHo3bDRzDaTU(this));
    L60:
        OMiddleArrowPopoverLayout r21 = this.mOBubbleLayout;
        if (r21 != null) goto L63;
        o.c("mOBubbleLayout");
        r21 = null;
    L63:
        setContentView((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin"));
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 29) goto L66;
        return;
    L66:
        if (this.mShowElevationShadow == false) goto L82;
        OMiddleArrowPopoverLayout r22 = this.mOBubbleLayout;
        if (r22 != null) goto L70;
        o.c("mOBubbleLayout");
        r22 = null;
    L70:
        OMiddleArrowPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L73;
        o.c("mOBubbleLayout");
        r6 = null;
    L73:
        float r23 = r6.getMWidth();
        OMiddleArrowPopoverLayout r24 = this.mOBubbleLayout;
        if (r24 != null) goto L76;
        o.c("mOBubbleLayout");
        r24 = null;
    L76:
        r22.calculateBubbleArrowMatrix(r23, r24.getMHeight());
        setElevation(50.0f);
        this.mNeedShadow = false;
        this.mShadowRadius = 0.0f;
        getContentView().setOutlineProvider(null);
        if (Build.VERSION.SDK_INT < 28) goto L79;
        getContentView().setOutlineSpotShadowColor(Color.parseColor("#8C000000"));
    L79:
        getContentView().setClipToOutline(true);
        return;
    L82:
        return;
    L56:
        OMiddleArrowPopoverLayout r25 = this.mOBubbleLayout;
        if (r25 != null) goto L59;
        o.c("mOBubbleLayout");
        r25 = null;
    L59:
        r25.setClickable(false);
        goto L60
    }

    /* JADX INFO: renamed from: setBubbleLayout$lambda-0, reason: not valid java name */
    private static final void m1121setBubbleLayout$lambda0(OMiddleArrowPopover r0, View r1) {
        o.e(r0, "this$0");
        c r2 = r0.mClickListener;
        if (r2 == null) goto L7;
        r2.a();
    L7:
        if (r0.mOnClickMaintain == true) goto L10;
        r0.dismiss();
        return;
    }

    public final int getOrientation(int r3) {
        int r2 = Companion.a(r3);
        if (r2 != 3) goto L5;
        return 2;
    L5:
        if (r2 == 5) goto L15;
        if (r2 != 48) goto L9;
        return 3;
    L9:
        if (r2 != 80) goto L15;
        return 0;
    L15:
        return 1;
    }

    public final void setGravity$OUI_standardRelease(int r3) {
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        o.c("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBubbleOrientation(getOrientation(Companion.a(r3)));
    }

    public final void show(View r2, int r3, float r4, int r5) {
        int r6 = Companion.a(r3);
        if (r6 != 48) goto L5;
    L7:
        this.mXOffset = r5;
    L8:
        this.mArrowOffset = r4;
        show(r2, r6, false);
        return;
    L5:
        if (r6 == 80) goto L7;
        goto L7
    }

    public final void show(View r2, int r3, boolean r4, float r5, int r6, int r7) {
        int r8 = Companion.a(r3);
        this.mXOffset = r6;
        this.mYOffset = r7;
        this.mArrowOffset = r5;
        show(r2, r8, r4);
    }

    public final void show(View r7, int r8, boolean r9) {
        int r10 = Companion.a(r8);
        if (this.activity.isFinishing() == true) goto L35;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getWindowToken() == null) goto L38;
        this.mParentHeight = r7.getMeasuredHeight();
        this.mParentWidth = r7.getMeasuredWidth();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mGravity = r10;
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        OMiddleArrowPopoverLayout r1 = null;
        if (r0 != null) goto L11;
        o.c("mOBubbleLayout");
        r0 = null;
    L11:
        this.padding = r0.m1122getPadding();
        if (isShowing() == true) goto L33;
        int r2 = getOrientation(r10);
        measure();
        if (r9 == false) goto L23;
        if (r10 != 48) goto L18;
    L20:
        int r4 = getMeasuredWidth();
    L21:
        this.mBubbleOffset = r4 / 2.0f;
    L25:
        OMiddleArrowPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L28;
        o.c("mOBubbleLayout");
    L29:
        r1.setBubbleParams(r2, this.mBubbleOffset + this.mArrowOffset);
        setBubblePositionAndShow(r7, r10, r9);
        this.isAlreadyDismiss = false;
        if (this.mAutoDismissDelayMillis <= 0) goto L32;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);
    L32:
        currentShowBubbleNumbers++;
        return;
    L28:
        r1 = r5;
        goto L29
    L18:
        if (r10 == 80) goto L20;
        r4 = getMeasuredHeight();
        goto L21
    L23:
        if (this.hasCome == true) goto L25;
        this.mArrowOffset += this.padding;
        this.hasCome = true;
        goto L25
    L33:
        super.dismiss();
        return;
    L38:
        return;
    }

    public final void setAdjustHeight(int r1) {
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        o.c("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setMAdjustHeight(r1);
    }

    public final void getBubblePosition(View r10, int r11, boolean r12, Rect r13) {
        o.e(r10, "anchor");
        o.e(r13, "position");
        int r14 = Companion.a(r11);
        int[] r1 = new int[2];
        Point r2 = this.mTargetLocation;
        if (r2 == null) goto L5;
        o.a(r2);
        r1[0] = r2.x;
        r1[1] = r2.y;
    L10:
        if (r14 != 3) goto L12;
        if (r12 == false) goto L32;
        int r15 = (r10.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L33:
        r13.left = (r1[0] + this.mXOffset) - getMeasuredWidth();
        r13.right = r1[0] + this.mXOffset;
        r13.top = ((r1[1] + this.mYOffset) + r15) + g.a(r10, 1.3d);
        r13.bottom = (((r1[1] + this.mYOffset) + r10.getHeight()) - r15) - g.a(r10, 1.3d);
        return;
    L32:
        r15 = 0;
        goto L33
    L12:
        if (r14 != 5) goto L14;
        if (r12 == false) goto L28;
        int r16 = (r10.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L29:
        r13.left = (r1[0] + this.mXOffset) + r10.getWidth();
        r13.right = ((r1[0] + this.mXOffset) + r10.getWidth()) + getMeasuredWidth();
        r13.top = ((r1[1] + this.mYOffset) + r16) + g.a(r10, 1.3d);
        r13.bottom = (((r1[1] + this.mYOffset) + r10.getHeight()) - r16) - g.a(r10, 1.3d);
        return;
    L28:
        r16 = 0;
        goto L29
    L14:
        if (r14 != 48) goto L16;
        if (r12 == false) goto L24;
        int r17 = (r10.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L25:
        r13.left = ((r1[0] + this.mXOffset) + r17) + g.a(r10, 1.4d);
        r13.right = (((r1[0] + this.mXOffset) + r10.getWidth()) - r17) - g.a(r10, 1.4d);
        r13.top = ((r1[1] + this.mYOffset) - g.a(r10, 1.3d)) - getMeasuredHeight();
        r13.bottom = (r1[1] + this.mYOffset) - g.a(r10, 1.3d);
        return;
    L24:
        r17 = 0;
        goto L25
    L16:
        if (r14 != 80) goto L38;
        if (r12 == false) goto L20;
        int r18 = (r10.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L21:
        r13.left = ((r1[0] + this.mXOffset) + r18) + g.a(r10, 1.4d);
        r13.right = (((r1[0] + this.mXOffset) + r10.getWidth()) - r18) - g.a(r10, 1.4d);
        r13.top = ((r1[1] + this.mYOffset) + r10.getHeight()) + g.a(r10, 1.3d);
        r13.bottom = (((r1[1] + this.mYOffset) + r10.getHeight()) + getMeasuredHeight()) + g.a(r10, 1.3d);
        return;
    L20:
        r18 = 0;
        goto L21
    L38:
        return;
    L5:
        String r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().toString();
        o.c(r3, "anchor.context.resources.configuration.toString()");
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("hw-magic-windows", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L8;
        r10.getLocationInWindow(r1);
        goto L10
    L8:
        r10.getLocationOnScreen(r1);
        goto L10
    }

    private final void setBubblePositionAndShow(View r12, int r13, boolean r14) {
        int r3 = Companion.a(r13);
        int[] r15 = new int[2];
        Point r0 = this.mTargetLocation;
        if (r0 == null) goto L6;
        o.a(r0);
        r15[0] = r0.x;
        r15[1] = r0.y;
    L9:
        int[] r16 = calTargetPosition$OUI_standardRelease$default(this, r14, r3, r12.getMeasuredWidth(), r12.getMeasuredHeight(), false, 16, null);
        if (this.mShowAsDropDown == false) goto L12;
        showAsDropDown(r12, r16[0], r16[1] - r12.getMeasuredHeight(), 0);
        return;
    L12:
        showAtLocation(r12, 0, r15[0] + r16[0], r15[1] + r16[1]);
        return;
    L6:
        if (this.mGetLocationInWindow == false) goto L8;
        r12.getLocationInWindow(r15);
        goto L9
    L8:
        r12.getLocationOnScreen(r15);
        goto L9
    }

    public static /* synthetic */ int[] calTargetPosition$OUI_standardRelease$default(OMiddleArrowPopover r6, boolean r7, int r8, int r9, int r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = false;
    L6:
        return r6.calTargetPosition$OUI_standardRelease(r7, r8, r9, r10, r11);
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r8, int r9, int r10, int r11, boolean r12) {
        int[] r1 = new int[2];
        if (this.mAlignArrowPadding == false) goto L14;
        if (r8 == true) goto L14;
        if (r12 == true) goto L14;
        int r13 = getMGravity();
        if (r13 == 3) goto L13;
        if (r13 == 5) goto L13;
        if (r13 == 48) goto L12;
        if (r13 != 80) goto L14;
    L12:
        this.mXOffset -= getArrowHeight();
    L13:
        this.mYOffset -= getArrowHeight();
    L14:
        int r14 = Companion.a(r9);
        if (r14 == 3) goto L32;
        if (r14 == 5) goto L28;
        if (r14 == 48) goto L24;
        if (r14 != 80) goto L36;
        if (r8 == false) goto L22;
        int r15 = (r10 - getMeasuredWidth()) / 2;
    L23:
        r1[0] = this.mXOffset + r15;
        r1[1] = this.mYOffset + r11;
        goto L36
    L22:
        r15 = 0;
    L36:
        return r1;
    L24:
        if (r8 == false) goto L26;
        int r16 = (r10 - getMeasuredWidth()) / 2;
    L27:
        r1[0] = this.mXOffset + r16;
        r1[1] = (-getMeasuredHeight()) + this.mYOffset;
        goto L36
    L26:
        r16 = 0;
        goto L27
    L28:
        if (r8 == false) goto L30;
        int r17 = (r11 - getMeasuredHeight()) / 2;
    L31:
        r1[0] = this.mXOffset + r10;
        r1[1] = this.mYOffset + r17;
        goto L36
    L30:
        r17 = 0;
        goto L31
    L32:
        if (r8 == false) goto L34;
        int r18 = (r11 - getMeasuredHeight()) / 2;
    L35:
        r1[0] = this.mXOffset - getMeasuredWidth();
        r1[1] = this.mYOffset + r18;
        goto L36
    L34:
        r18 = 0;
        goto L35
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r2, int r3, int r4, int r5) {
        o.e(r2, "anchor");
        super.showAtLocation(r2, Companion.a(r3), r4, r5);     // Catch: Exception -> L5
        this.isAlreadyDismiss = false;     // Catch: Exception -> L5
        animatorEasyInOut(true);     // Catch: Exception -> L5
        return;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r2, int r3, int r4, int r5) {
        super.showAsDropDown(r2, r3, r4, Companion.a(r5));     // Catch: Exception -> L5
        this.isAlreadyDismiss = false;     // Catch: Exception -> L5
        animatorEasyInOut(true);     // Catch: Exception -> L5
        return;
    }

    public final void popupAtLocation(View r3, int r4, int r5, int r6, float r7) {
        o.e(r3, "anchor");
        int r8 = Companion.a(r4);
        this.mGravity = r8;     // Catch: Exception -> L10
        this.mArrowOffset = r7;     // Catch: Exception -> L10
        OMiddleArrowPopoverLayout r9 = this.mOBubbleLayout;     // Catch: Exception -> L10
        if (r9 != null) goto L6;
        o.c("mOBubbleLayout");     // Catch: Exception -> L10
        r9 = null;
    L6:
        r9.setBubbleParams(getOrientation(r8), this.mBubbleOffset + this.mArrowOffset);     // Catch: Exception -> L10
        showAtLocation(r3, 0, r5, r6);     // Catch: Exception -> L10
        if (this.mAutoDismissDelayMillis <= 0) goto L13;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    public final void hideView() {
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L5;
        o.c("mOBubbleLayout");
        r1 = null;
    L5:
        r1.setVisibility(8);
    }

    private final void hideSystemUi() {
        if (o.a(this.isHideVirtualKey, false) == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        getContentView().setSystemUiVisibility(8);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 19) goto L13;
        getContentView().setSystemUiVisibility(4102);
        return;
    }

    private final void measure() {
        int r0 = this.mWidth;
        if (r0 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.mHeight == 0) goto L7;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r2 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
        getContentView().measure(r1, r2);
    }

    public final void setTargetLocation(Point r2) {
        o.e(r2, "targetLocation");
        this.mTargetLocation = r2;
    }

    public final void onDestroy() {
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
    L6:
        AnimatorSet r1 = this.animSet;
        if (r1 == null) goto L10;
        r1.cancel();
    L10:
        this.animSet = null;
        if (this.activity.isFinishing() == true) goto L15;
        if (isShowing() == false) goto L15;
    L20:
        super.dismiss();     // Catch: Exception -> L19
        return;
    L22:
        return;
    L15:
        if (shouldForceDismiss == true) goto L20;
    }

    public final int getMeasuredHeight() {
        measure();
        return getContentView().getMeasuredHeight();
    }

    public final int getMeasuredWidth() {
        measure();
        return getContentView().getMeasuredWidth();
    }

    public final int getBubbledHeight() {
        measure();
        int r0 = getContentView().getMeasuredHeight();
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        o.c("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.m1122getPadding() * 4);
    }

    public final int getBubbledWidth() {
        measure();
        int r0 = getContentView().getMeasuredWidth();
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        o.c("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.m1122getPadding() * 4);
    }

    public final View getPopoverView() {
        OMiddleArrowPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L6;
        o.c("mOBubbleLayout");
        r2 = null;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    public final int getArrowHeight() {
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 == null) goto L7;
        if (r0 != null) goto L9;
        o.c("mOBubbleLayout");
        r0 = null;
    L9:
        return r0.getArrowHeight();
    L7:
        return 0;
    }

    /* JADX INFO: renamed from: mDismissRunnable$lambda-1, reason: not valid java name */
    private static final void m1120mDismissRunnable$lambda1(OMiddleArrowPopover r1) {
        o.e(r1, "this$0");
        if (r1.enableAutoDismiss == false) goto L6;
        r1.animatorEasyInOut(false);
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isAlreadyDismiss == true) goto L6;
        animatorEasyInOut(false);
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    public final void setEnableAutoDismiss(boolean r1) {
        this.enableAutoDismiss = r1;
    }

    public final void dismissDirectly() {
        if (this.isAlreadyDismiss == true) goto L9;
        currentShowBubbleNumbers--;
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L7;
        o.c("mOBubbleLayout");
        r0 = null;
    L7:
        r0.setVisibility(8);
        onDestroy();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    private final void animatorEasyInOut(final boolean r17) {
        final OMiddleArrowPopoverLayout r2 = this.mOBubbleLayout;
        OMiddleArrowPopoverLayout r3 = null;
        if (r2 != null) goto L6;
        o.c("mOBubbleLayout");
        r2 = null;
    L6:
        if (r17 == true) goto L8;
        currentShowBubbleNumbers--;
        this.isAlreadyDismiss = true;
    L8:
        this.animSet = new AnimatorSet();
        int r6 = getMGravity();
        float r8 = 0.0f;
        if (r6 != 3) goto L11;
        float r7 = r2.getX() + r2.getMeasuredWidth();
        float r9 = r2.getY();
        OMiddleArrowPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L35;
        o.c("mOBubbleLayout");
    L36:
        float r4 = r3.getBubbleOffset();
    L37:
        float r5 = r4 + r9;
    L38:
        r2.setPivotY(r5);
        r2.setPivotX(r7);
        Interpolator r11 = androidx.core.view.animation.a.a(0.0f, 0.0f, 1.0f, 1.0f);
        Object r12 = androidx.core.view.animation.a.a(0.3f, 0.0f, 0.9f, 0.6f);
        float[] r13 = new float[2];
        if (r17 == false) goto L41;
        float r14 = 0.0f;
    L42:
        r13[0] = r14;
        if (r17 == false) goto L45;
        r8 = 1.0f;
    L45:
        r13[1] = r8;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r2, "alpha", r13);
        if (r17 == false) goto L48;
        Object r16 = ZeusTransformUtils.preCheckCast(r11, TimeInterpolator.class, "com.obric.aiagent.plugin");
    L49:
        r15.setInterpolator((TimeInterpolator) r16);
        if (r17 == false) goto L52;
        long r18 = 90;
    L53:
        r15.setDuration(r18);
        float[] r19 = new float[2];
        if (r17 == false) goto L56;
        float r110 = 0.5f;
    L57:
        r19[0] = r110;
        float r111 = 0.8f;
        if (r17 == false) goto L60;
        float r112 = 1.0f;
    L61:
        r19[1] = r112;
        ObjectAnimator r20 = ObjectAnimator.ofFloat(r2, "scaleX", r19);
        if (r17 == false) goto L64;
        Object r113 = ZeusTransformUtils.preCheckCast(new SpringInterpolator(0.61f), TimeInterpolator.class, "com.obric.aiagent.plugin");
    L65:
        r20.setInterpolator((TimeInterpolator) r113);
        if (r17 == false) goto L68;
        long r114 = 420;
    L69:
        r20.setDuration(r114);
        float[] r21 = new float[2];
        if (r17 == false) goto L72;
        float r115 = 0.5f;
    L73:
        r21[0] = r115;
        if (r17 == false) goto L76;
        r111 = 1.0f;
    L76:
        r21[1] = r111;
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r2, "scaleY", r21);
        if (r17 == false) goto L79;
        r12 = new SpringInterpolator(0.61f);
    L79:
        r22.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(r12, TimeInterpolator.class, "com.obric.aiagent.plugin"));
        if (r17 == false) goto L82;
        long r116 = 420;
    L83:
        r22.setDuration(r116);
        r2.setVisibility(0);
        if (r17 == false) goto L91;
        Animator r23 = this.customInAnimator;
        if (r23 == null) goto L91;
        AnimatorSet r24 = this.animSet;
        if (r24 == null) goto L108;
        r24.play(r23);
    L108:
        AnimatorSet r25 = this.animSet;
        if (r25 == null) goto L113;
        r25.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r17, r2, this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
    L113:
        if (this.mNeedOverShoot == false) goto L119;
        if (r17 == false) goto L119;
        AnimatorSet r1 = this.animSet;
        if (r1 == null) goto L119;
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new OvershootInterpolator(1.0f), TimeInterpolator.class, "com.obric.aiagent.plugin"));
    L119:
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L124;
        r0.start();
        return;
    L124:
        return;
    L91:
        if (r17 == true) goto L98;
        Animator r26 = this.customOutAnimator;
        if (r26 == null) goto L98;
        AnimatorSet r27 = this.animSet;
        if (r27 == null) goto L108;
        r27.play(r26);
    L98:
        AnimatorSet r28 = this.animSet;
        if (r28 == null) goto L108;
        AnimatorSet.Builder r29 = r28.play((Animator) ZeusTransformUtils.preCheckCast(r20, Animator.class, "com.obric.aiagent.plugin"));
        if (r29 == null) goto L108;
        AnimatorSet.Builder r30 = r29.with((Animator) ZeusTransformUtils.preCheckCast(r22, Animator.class, "com.obric.aiagent.plugin"));
        if (r30 == null) goto L108;
        r30.with((Animator) ZeusTransformUtils.preCheckCast(r15, Animator.class, "com.obric.aiagent.plugin"));
        goto L108
    L82:
        r116 = 120;
        goto L83
    L72:
        r115 = 1.0f;
        goto L73
    L68:
        r114 = 120;
        goto L69
    L64:
        r113 = ZeusTransformUtils.preCheckCast(r12, TimeInterpolator.class, "com.obric.aiagent.plugin");
        goto L65
    L60:
        r112 = 0.8f;
        goto L61
    L56:
        r110 = 1.0f;
        goto L57
    L52:
        r18 = 120;
        goto L53
    L48:
        r16 = ZeusTransformUtils.preCheckCast(r12, TimeInterpolator.class, "com.obric.aiagent.plugin");
        goto L49
    L41:
        r14 = 1.0f;
        goto L42
    L35:
        r3 = r10;
        goto L36
    L11:
        if (r6 != 5) goto L13;
        r7 = r2.getX();
        r9 = r2.getY();
        OMiddleArrowPopoverLayout r31 = this.mOBubbleLayout;
        if (r31 != null) goto L30;
        o.c("mOBubbleLayout");
    L31:
        r4 = r3.getBubbleOffset();
        goto L37
    L30:
        r3 = r31;
        goto L31
    L13:
        if (r6 != 48) goto L15;
        float r32 = r2.getX();
        OMiddleArrowPopoverLayout r33 = this.mOBubbleLayout;
        if (r33 != null) goto L25;
        o.c("mOBubbleLayout");
    L26:
        r7 = r32 + r3.getBubbleOffset();
        r5 = r2.getY() + r2.getMeasuredHeight();
        goto L38
    L25:
        r3 = r33;
        goto L26
    L15:
        if (r6 == 80) goto L17;
        r5 = 0.0f;
        r7 = 0.0f;
        goto L38
    L17:
        float r34 = r2.getX();
        OMiddleArrowPopoverLayout r35 = this.mOBubbleLayout;
        if (r35 != null) goto L20;
        o.c("mOBubbleLayout");
    L21:
        r7 = r34 + r3.getBubbleOffset();
        r5 = r2.getY();
        goto L38
    L20:
        r3 = r35;
        goto L21
    }

    static {
        Companion = new b(null);
        TEXT_SIZE_DP = 18.0f;
    }
}
