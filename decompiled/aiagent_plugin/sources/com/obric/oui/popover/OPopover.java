package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ab;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.l.n;
import d.m;
import d.n.j;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OPopover.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OPopover extends PopupWindow {
    public static final c Companion = null;
    public static final long OPACITY_LONG = 120;
    public static final long OPACITY_SHORT = 90;
    private static final float POPUP_WINDOW_ELEVATION = 50.0f;
    public static final long SCALE_LONG = 420;
    public static final long SCALE_SHORT = 120;
    private static final String TAG = "OPopover";
    private static final boolean USE_OUI_SHADOW = true;
    private static volatile int currentShowBubbleNumbers;
    private static boolean shouldForceDismiss;
    private Activity activity;
    private final com.obric.oui.animation.engine.c<View> animFloatP;
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
    private d mClickListener;
    private float mCornerRadius;
    private e mDismissListener;
    private final Runnable mDismissRunnable;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mGravity;
    private int mHeight;
    private boolean mIsFirstShow;
    private boolean mIsShowInDialog;
    private boolean mLayoutClickable;
    private boolean mNeedArrow;
    private boolean mNeedOverShoot;
    private boolean mNeedShadow;
    private OPopoverLayout mOBubbleLayout;
    private boolean mOnClickMaintain;
    private boolean mOutsideTouchable;
    private float mPadding;
    private int mParentHeight;
    private int mParentWidth;
    private int mShadowColor;
    private float mShadowRadius;
    private int mShadowSpaceTop;
    private boolean mShowAsDropDown;
    private boolean mShowElevationShadow;
    private f mShowListener;
    private boolean mShowWithAnimation;
    private String mSubText;
    private int mSubTextColor;
    private Point mTargetLocation;
    private int mTextColor;
    private float mTextSize;
    private PopoverTextView mTextView;
    private Typeface mTypeFace;
    private boolean mUseDefaultView;
    private View mView;
    private int mWidth;
    private ViewGroup mWindowFrame;
    private int mXOffset;
    private int mYOffset;
    private int padding;
    private Float shadowDx;
    private Float shadowDy;
    private boolean transparentBg;

    /* JADX INFO: compiled from: OPopover.kt */
    public static final class a {
        private boolean A;
        private int B;
        private boolean C;
        private float D;
        private boolean E;
        private boolean F;
        private boolean G;
        private int H;
        private int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private boolean f35982J;
        private float K;
        private Float L;
        private Float M;
        private boolean N;
        private boolean O;
        private boolean P;
        private String Q;
        private int R;
        private boolean S;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Activity f35983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f35984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f35986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f35987e;
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
        private d u;
        private e v;
        private f w;
        private boolean x;
        private float y;
        private boolean z;

        public a(Activity r6) {
            Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
            o.e(r7, "activity");
            Activity r8 = ZeusTransformUtils.wrapperContext2Activity(r7, "com.obric.aiagent.plugin");
            this.f35983a = r8;
            this.f35987e = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_background, "color", "oui_toast_background"));
            this.j = 800;
            this.k = Long.MIN_VALUE;
            this.p = "";
            this.r = 13.0f;
            this.t = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this.f35983a, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_text, "color", "oui_toast_text"));
            this.y = 12.0f;
            this.z = true;
            this.B = -16777216;
            this.D = 2.0f;
            this.E = true;
            this.G = true;
            this.P = true;
            this.Q = "";
            this.R = androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this.f35983a, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_text, "color", "oui_toast_text"));
            this.S = true;
        }

        public final Activity getActivity() {
            return this.f35983a;
        }

        public final boolean a() {
            return this.f35984b;
        }

        public final int b() {
            return this.f35985c;
        }

        public final float c() {
            return this.f35986d;
        }

        public final int d() {
            return this.f35987e;
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

        public final d t() {
            return this.u;
        }

        public final e u() {
            return this.v;
        }

        public final f v() {
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
            return this.F;
        }

        public final boolean E() {
            return this.G;
        }

        public final int F() {
            return this.H;
        }

        public final int G() {
            return this.I;
        }

        public final boolean H() {
            return this.f35982J;
        }

        public final float I() {
            return this.K;
        }

        public final Float J() {
            return this.L;
        }

        public final Float K() {
            return this.M;
        }

        public final boolean L() {
            return this.N;
        }

        public final boolean M() {
            return this.O;
        }

        public final boolean N() {
            return this.P;
        }

        public final String O() {
            return this.Q;
        }

        public final int P() {
            return this.R;
        }

        public final boolean Q() {
            return this.S;
        }

        public final a a(e r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
            o.e(r4, "listener");
            this.v = r4;
            return this;
        }

        public final a a(int r1) {
            this.f35987e = r1;
            return this;
        }

        public final a a(long r1) {
            this.k = r1;
            return this;
        }

        public final a a(boolean r1) {
            this.l = r1;
            return this;
        }

        public final a a(View r2) {
            o.e(r2, "view");
            this.m = r2;
            return this;
        }

        public final a b(boolean r1) {
            this.C = r1;
            return this;
        }

        public final OPopover R() {
            return new OPopover(this);
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f35988a;

        public b(float r1) {
            this.f35988a = r1;
        }

        public final float a() {
            return this.f35988a;
        }

        public final void a(float r1) {
            this.f35988a = r1;
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    public static final class c {
        public /* synthetic */ c(d.h.b.h r1) {
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

        private c() {
        }

        public final int a() {
            return OPopover.access$getCurrentShowBubbleNumbers$cp();
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    public interface d {
        void a();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    public interface e {
        void a();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    public interface f {
        void a();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    public static final class g extends com.obric.oui.animation.engine.c<View> {
        g() {
            super("v");
        }

        @Override // com.obric.oui.animation.engine.c
        public /* synthetic */ float a(View r3) {
            return a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.animation.engine.c
        public /* synthetic */ void a(View r3, float r4) {
            a2((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"), r4);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public float a2(View r4) {
            if (r4 == null) goto L20;
            Object r5 = r4.getTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, DbHelper.COL_ID, "o_popover_anim_p"));
            if (r5 == null) goto L21;
            com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
            Float r1 = null;
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L12;
            r5 = null;
        L12:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            r1 = Float.valueOf(r6.a());
        L16:
            if (r1 != null) goto L19;
            return 0.0f;
        L19:
            return r1.floatValue();
        L21:
            return 0.0f;
        L20:
            return 0.0f;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(View r3, float r4) {
            if (r3 == null) goto L16;
            Object r2 = r3.getTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, DbHelper.COL_ID, "o_popover_anim_p"));
            if (r2 == null) goto L17;
            com.obric.oui.d.c r5 = com.obric.oui.d.c.f35012a;
            if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L11;
            r2 = null;
        L11:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L18;
            r6.a(r4);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    static final class h extends p implements d.h.a.b<View, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f35989a = null;

        static {
            f35989a = new h();
        }

        h() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(View r3) {
            return a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        }

        public final Boolean a(View r1) {
            o.e(r1, "it");
            return Boolean.valueOf(ZeusTransformUtils.instanceOf(r1, FakeAnchorView.class));
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.popover.OPopover$setBubbleLayout$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OPopover.kt */
    public static final class C11992 extends ViewOutlineProvider {
        final /* synthetic */ OPopover this$0;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.e(r0, r1);
        }

        C11992(OPopover r1) {
            this.this$0 = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r5, Outline r6) {
            OPopoverLayout r7 = OPopover.access$getMOBubbleLayout$p(this.this$0);
            OPopoverLayout r0 = null;
            if (r7 != null) goto L5;
            o.c("mOBubbleLayout");
            r7 = null;
        L5:
            OPopoverLayout r2 = OPopover.access$getMOBubbleLayout$p(this.this$0);
            if (r2 != null) goto L8;
            o.c("mOBubbleLayout");
            r2 = null;
        L8:
            float r3 = r2.getMWidth();
            OPopoverLayout r4 = OPopover.access$getMOBubbleLayout$p(this.this$0);
            if (r4 != null) goto L11;
            o.c("mOBubbleLayout");
            r4 = null;
        L11:
            r7.calculateBubbleArrowMatrix(r3, r4.getMHeight());
            if (r6 == null) goto L24;
            OPopoverLayout r8 = OPopover.access$getMOBubbleLayout$p(this.this$0);     // Catch: Exception -> L20
            if (r8 != null) goto L17;
            o.c("mOBubbleLayout");     // Catch: Exception -> L20
        L18:
            r6.setConvexPath(r0.getFullPath());     // Catch: Exception -> L20
            return;
        L17:
            r0 = r8;
        L20:
            INVOKESTATIC_com_obric_oui_popover_OPopover$setBubbleLayout$2_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(OPopover.TAG, "set convex path failed.");
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_oui_popover_OPopover$setBubbleLayout$2_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    static {
        Companion = new c(null);
    }

    public static final int getCurrentShowBubbleNumbers() {
        return Companion.a();
    }

    public static /* synthetic */ void lambda$D42NbhUFJ_PXJ5Dq96Cve8yRvjo(ViewGroup r0, float r1, float r2, float r3, float r4, float r5, float r6, com.obric.oui.animation.engine.b r7, float r8, float r9) {
        m1124animatorEasyInOut$lambda5$lambda4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ boolean lambda$_FnOsdqHV5hIn391tEGAYO0WzCE(OPopover r0, View r1, MotionEvent r2) {
        return m1123addShadowFrame$lambda10(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$hqIIllRv1iUBojTb1o8_wUnfL-Q, reason: not valid java name */
    public static /* synthetic */ void m1125lambda$hqIIllRv1iUBojTb1o8_wUnfLQ(OPopover r0) {
        m1127mDismissRunnable$lambda2(r0);
    }

    /* JADX INFO: renamed from: lambda$vZ1dIe-GWvlTUJ7aq9JXP8wQcHY, reason: not valid java name */
    public static /* synthetic */ void m1126lambda$vZ1dIeGWvlTUJ7aq9JXP8wQcHY(OPopover r0, View r1) {
        m1128setBubbleLayout$lambda0(r0, r1);
    }

    private final void setBubblePositionAndShow(View r8, int r9, boolean r10) {
        setBubblePositionAndShow$default(this, r8, r9, r10, false, 8, null);
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r10, int r11, int r12, int r13) {
        return calTargetPosition$OUI_standardRelease$default(this, r10, r11, r12, r13, false, false, 48, null);
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r10, int r11, int r12, int r13, boolean r14) {
        return calTargetPosition$OUI_standardRelease$default(this, r10, r11, r12, r13, r14, false, 32, null);
    }

    public final void show(View r9, int r10, float r11, int r12) {
        show$default(this, r9, r10, r11, r12, false, 16, null);
    }

    public final void show(View r8, int r9, boolean r10) {
        show$default(this, r8, r9, r10, false, 8, null);
    }

    public final void show(View r11, int r12, boolean r13, float r14, int r15, int r16) {
        show$default(this, r11, r12, r13, r14, r15, r16, false, 64, null);
    }

    public OPopover(a r5) {
        o.e(r5, "builder");
        this.mShadowColor = -16777216;
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mUseDefaultView = true;
        this.bubbleText = "";
        this.mTextSize = 13.0f;
        this.mNeedArrow = true;
        this.mPadding = 12.0f;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShadowRadius = 2.0f;
        this.mLayoutClickable = true;
        this.mSubText = "";
        this.mSubTextColor = -7829368;
        this.mShowWithAnimation = true;
        this.mIsFirstShow = true;
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
        this.mPadding = r5.x();
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
        this.mSubText = r5.O();
        this.mSubTextColor = r5.P();
        this.mShowWithAnimation = r5.Q();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (this.mUseDefaultView == true) goto L10;
        View r2 = this.mView;
        if (r2 == null) goto L10;
        setBubbleLayout(r2);
        OPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L9;
        o.c("mOBubbleLayout");
        r3 = null;
    L9:
        r3.setUseDefaultView(false);
    L11:
        initContentView();
        setFocusable(true);
        this.mDismissRunnable = new $$Lambda$OPopover$hqIIllRv1iUBojTb1o8_wUnfLQ(this);
        this.animFloatP = (com.obric.oui.animation.engine.c) ZeusTransformUtils.preCheckCast(new g(), com.obric.oui.animation.engine.c.class, "com.obric.aiagent.plugin");
        return;
    L10:
        setDefaultView();
        goto L11
    }

    public static final /* synthetic */ int access$getCurrentShowBubbleNumbers$cp() {
        return currentShowBubbleNumbers;
    }

    public static final /* synthetic */ e access$getMDismissListener$p(OPopover r0) {
        return r0.mDismissListener;
    }

    public static final /* synthetic */ OPopoverLayout access$getMOBubbleLayout$p(OPopover r0) {
        return r0.mOBubbleLayout;
    }

    public static final /* synthetic */ f access$getMShowListener$p(OPopover r0) {
        return r0.mShowListener;
    }

    public static final /* synthetic */ void access$setShouldForceDismiss$cp(boolean r0) {
        shouldForceDismiss = r0;
    }

    private final int getMGravity() {
        return Companion.a(this.mGravity);
    }

    private final void initContentView() {
        boolean r1 = true;
        if (o.a(this.isHideVirtualKey, true) == false) goto L5;
        hideSystemUi();
    L5:
        OPopoverLayout r2 = null;
        if (this.mBgColor == 0) goto L11;
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L10;
        o.c("mOBubbleLayout");
        r0 = null;
    L10:
        r0.setMBgColor(this.mBgColor);
    L11:
        OPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L14;
        o.c("mOBubbleLayout");
        r3 = null;
    L14:
        r3.setBubbleOrientation(getOrientation(getMGravity()));
        if (this.mPadding == 0.0f) goto L18;
        r1 = false;
    L18:
        if (r1 == true) goto L23;
        OPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L22;
        o.c("mOBubbleLayout");
        r4 = null;
    L22:
        r4.setMPadding(this.padding);
    L23:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L26;
        o.c("mOBubbleLayout");
        r5 = null;
    L26:
        r5.getShadowConfig().a(this.mShadowColor);
        OPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L29;
        o.c("mOBubbleLayout");
        r6 = null;
    L29:
        r6.getShadowConfig().a(this.mShadowRadius);
        OPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L32;
        o.c("mOBubbleLayout");
        r7 = null;
    L32:
        r7.setBorderColor(this.mBorderColor);
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L35;
        o.c("mOBubbleLayout");
        r8 = null;
    L35:
        r8.setBorderWidth(this.mBorderWidth);
        OPopoverLayout r9 = this.mOBubbleLayout;
        if (r9 != null) goto L38;
        o.c("mOBubbleLayout");
    L39:
        r2.setTransparentBg(this.transparentBg);
        return;
    L38:
        r2 = r9;
        goto L39
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
        r3.setTextSize(1, 14.0f);
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
        PopoverTextView r7 = this.mTextView;
        if (r7 != null) goto L31;
        o.c("mTextView");
        r7 = null;
    L31:
        r6.setLineHeight(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"), 20));
        PopoverTextView r8 = this.mTextView;
        if (r8 != null) goto L34;
        o.c("mTextView");
        r8 = null;
    L34:
        r8.setGravity(17);
        PopoverTextView r9 = this.mTextView;
        if (r9 != null) goto L37;
        o.c("mTextView");
        r9 = null;
    L37:
        PopoverTextView r10 = this.mTextView;
        if (r10 != null) goto L40;
        o.c("mTextView");
        r10 = null;
    L40:
        r9.setMaxWidth(com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), 276));
        PopoverTextView r11 = this.mTextView;
        if (r11 != null) goto L43;
        o.c("mTextView");
        r11 = null;
    L43:
        r11.setEllipsize(TextUtils.TruncateAt.END);
        PopoverTextView r12 = this.mTextView;
        if (r12 != null) goto L46;
        o.c("mTextView");
        r12 = null;
    L46:
        setBubbleLayout((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"));
        if (this.isHideVirtualKey != null) goto L49;
        this.isHideVirtualKey = true;
    L49:
        boolean r13 = false;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.bubbleText, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L62;
        if (o.a(this.mSubText, "") == false) goto L57;
        PopoverTextView r14 = this.mTextView;
        if (r14 != null) goto L56;
        o.c("mTextView");
        r14 = null;
    L56:
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.bubbleText, CharSequence.class, "com.obric.aiagent.plugin"));
        goto L62
    L57:
        SpannableString r15 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(this.bubbleText + '\n' + this.mSubText, CharSequence.class, "com.obric.aiagent.plugin"));
        r15.setSpan(new StyleSpan(0), 0, this.bubbleText.length(), 33);
        r15.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, this.bubbleText.length(), 33);
        r15.setSpan(new AbsoluteSizeSpan(14, true), 0, this.bubbleText.length(), 33);
        r15.setSpan(new ForegroundColorSpan(this.mSubTextColor), this.bubbleText.length() + 1, r15.length(), 33);
        r15.setSpan(new AbsoluteSizeSpan(14, true), this.bubbleText.length() + 1, r15.length(), 33);
        r15.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), this.bubbleText.length() + 1, r15.length(), 33);
        PopoverTextView r16 = this.mTextView;
        if (r16 != null) goto L60;
        o.c("mTextView");
        r16 = null;
    L60:
        r16.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), TextView.BufferType.SPANNABLE);
    L62:
        if (this.bubbleTextRes == 0) goto L68;
        PopoverTextView r17 = this.mTextView;
        if (r17 != null) goto L66;
        o.c("mTextView");
        r17 = null;
    L66:
        r17.setText(this.bubbleTextRes);
    L68:
        if (this.mTextSize != 0.0f) goto L70;
        r13 = true;
    L70:
        if (r13 == true) goto L76;
        PopoverTextView r18 = this.mTextView;
        if (r18 != null) goto L74;
        o.c("mTextView");
    L75:
        r2.setTextSize(1, this.mTextSize);
        goto L76
    L74:
        r2 = r18;
    L76:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L7:
        if (r0 != null) goto L9;
        o.c("mTextView");
        r0 = null;
    L9:
        r0.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_text, "color", "oui_toast_text")));
        goto L11
    }

    private final void setBubbleLayout(View r8) {
        OPopoverLayout r0 = new OPopoverLayout((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"));
        this.mOBubbleLayout = r0;
        ViewGroup r2 = null;
        if (r0 != null) goto L5;
        o.c("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBackgroundColor(0);
        if (this.mUseDefaultView == true) goto L8;
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L20;
        o.c("mOBubbleLayout");
        r1 = null;
    L20:
        r1.setCornerRadiusDp(OPopoverLayout.Companion.a());
    L22:
        if (this.mCornerRadius != 0.0f) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == true) goto L30;
        OPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L29;
        o.c("mOBubbleLayout");
        r4 = null;
    L29:
        r4.setCornerRadius(this.mCornerRadius);
    L30:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L33;
        o.c("mOBubbleLayout");
        r5 = null;
    L33:
        r5.setSubText(this.mSubText);
        OPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L36;
        o.c("mOBubbleLayout");
        r6 = null;
    L36:
        r6.setGravity(17);
        OPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L39;
        o.c("mOBubbleLayout");
        r7 = null;
    L39:
        r7.addView(r8);
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-2, -2);
        OPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L42;
        o.c("mOBubbleLayout");
        r10 = null;
    L42:
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        if (this.mBgColor == 0) goto L48;
        OPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L47;
        o.c("mOBubbleLayout");
        r11 = null;
    L47:
        r11.setMBgColor(this.mBgColor);
    L48:
        OPopoverLayout r12 = this.mOBubbleLayout;
        if (r12 != null) goto L51;
        o.c("mOBubbleLayout");
        r12 = null;
    L51:
        r12.setMNeedArrow(this.mNeedArrow);
        OPopoverLayout r13 = this.mOBubbleLayout;
        if (r13 != null) goto L54;
        o.c("mOBubbleLayout");
        r13 = null;
    L54:
        r13.setMNeedShadow(this.mNeedShadow);
        OPopoverLayout r14 = this.mOBubbleLayout;
        if (r14 != null) goto L57;
        o.c("mOBubbleLayout");
        r14 = null;
    L57:
        r14.getShadowConfig().a(this.mShadowColor);
        if (this.shadowDx == null) goto L64;
        OPopoverLayout r15 = this.mOBubbleLayout;
        if (r15 != null) goto L62;
        o.c("mOBubbleLayout");
        r15 = null;
    L62:
        OPopoverLayout.b r16 = r15.getShadowConfig();
        Float r17 = this.shadowDx;
        o.a(r17);
        r16.b(r17.floatValue());
    L64:
        if (this.shadowDy == null) goto L70;
        OPopoverLayout r18 = this.mOBubbleLayout;
        if (r18 != null) goto L68;
        o.c("mOBubbleLayout");
        r18 = null;
    L68:
        OPopoverLayout.b r19 = r18.getShadowConfig();
        Float r20 = this.shadowDy;
        o.a(r20);
        r19.c(r20.floatValue());
    L70:
        if (this.mLayoutClickable == false) goto L78;
        OPopoverLayout r21 = this.mOBubbleLayout;
        if (r21 != null) goto L74;
        o.c("mOBubbleLayout");
        r21 = null;
    L74:
        r21.setClickable(true);
        OPopoverLayout r22 = this.mOBubbleLayout;
        if (r22 != null) goto L77;
        o.c("mOBubbleLayout");
        r22 = null;
    L77:
        r22.setOnClickListener(new $$Lambda$OPopover$vZ1dIeGWvlTUJ7aq9JXP8wQcHY(this));
    L82:
        OPopoverLayout r23 = this.mOBubbleLayout;
        if (r23 != null) goto L85;
        o.c("mOBubbleLayout");
        r23 = null;
    L85:
        ViewGroup r24 = (ViewGroup) ZeusTransformUtils.preCheckCast(r23, ViewGroup.class, "com.obric.aiagent.plugin");
        this.mWindowFrame = r24;
        if (r24 != null) goto L88;
        o.c("mWindowFrame");
    L89:
        setContentView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int r25 = Build.VERSION.SDK_INT;
        return;
    L88:
        r2 = r24;
        goto L89
    L78:
        OPopoverLayout r26 = this.mOBubbleLayout;
        if (r26 != null) goto L81;
        o.c("mOBubbleLayout");
        r26 = null;
    L81:
        r26.setClickable(false);
        goto L82
    L24:
        r3 = false;
        goto L25
    L8:
        if (o.a(this.mSubText, "") == false) goto L13;
        OPopoverLayout r27 = this.mOBubbleLayout;
        if (r27 != null) goto L12;
        o.c("mOBubbleLayout");
        r27 = null;
    L12:
        r27.setCornerRadiusDp(OPopoverLayout.Companion.b());
        goto L22
    L13:
        OPopoverLayout r28 = this.mOBubbleLayout;
        if (r28 != null) goto L16;
        o.c("mOBubbleLayout");
        r28 = null;
    L16:
        r28.setCornerRadiusDp(OPopoverLayout.Companion.c());
        goto L22
    }

    /* JADX INFO: renamed from: setBubbleLayout$lambda-0, reason: not valid java name */
    private static final void m1128setBubbleLayout$lambda0(OPopover r0, View r1) {
        o.e(r0, "this$0");
        d r2 = r0.mClickListener;
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
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        o.c("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBubbleOrientation(getOrientation(Companion.a(r3)));
    }

    public static /* synthetic */ void show$default(OPopover r6, View r7, int r8, float r9, int r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 16) == 0) goto L6;
        r11 = false;
    L6:
        r6.show(r7, r8, r9, r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public final void show(View r2, int r3, float r4, int r5, boolean r6) {
        int r7 = Companion.a(r3);
        if (r7 != 48) goto L5;
    L7:
        this.mXOffset = r5;
    L8:
        this.mArrowOffset = r4;
        show(r2, r7, false, r6);
        return;
    L5:
        if (r7 == 80) goto L7;
        goto L7
    }

    public static /* synthetic */ void show$default(OPopover r9, View r10, int r11, boolean r12, float r13, int r14, int r15, boolean r16, int r17, Object r18) {
        if (r18 != null) goto L10;
        if ((r17 & 64) == 0) goto L6;
        boolean r8 = false;
    L7:
        r9.show(r10, r11, r12, r13, r14, r15, r8);
        return;
    L6:
        r8 = r16;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public final void show(View r2, int r3, boolean r4, float r5, int r6, int r7, boolean r8) {
        int r9 = Companion.a(r3);
        this.mXOffset = r6;
        this.mYOffset = r7;
        this.mArrowOffset = r5;
        show(r2, r9, r4, r8);
    }

    public static /* synthetic */ void show$default(OPopover r0, View r1, int r2, boolean r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        r0.show(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public final void show(View r7, int r8, boolean r9, boolean r10) {
        int r11 = Companion.a(r8);
        if (this.activity.isFinishing() == true) goto L35;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getWindowToken() == null) goto L38;
        this.mParentHeight = r7.getMeasuredHeight();
        this.mParentWidth = r7.getMeasuredWidth();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mGravity = r11;
        OPopoverLayout r0 = this.mOBubbleLayout;
        OPopoverLayout r1 = null;
        if (r0 != null) goto L11;
        o.c("mOBubbleLayout");
        r0 = null;
    L11:
        this.padding = r0.getPadding();
        if (isShowing() == true) goto L33;
        int r2 = getOrientation(r11);
        measure();
        if (r9 == false) goto L23;
        if (r11 != 48) goto L18;
    L20:
        int r4 = getMeasuredWidth();
    L21:
        this.mBubbleOffset = r4 / 2.0f;
    L25:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L28;
        o.c("mOBubbleLayout");
    L29:
        r1.setBubbleParams(r2, this.mBubbleOffset + this.mArrowOffset);
        setBubblePositionAndShow(r7, r11, r9, r10);
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
        if (r11 == 80) goto L20;
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
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        o.c("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setMAdjustHeight(r1);
    }

    public final void getBubblePosition(View r9, int r10, boolean r11, Rect r12) {
        o.e(r9, "anchor");
        o.e(r12, "position");
        int r13 = Companion.a(r10);
        int[] r1 = new int[2];
        Point r2 = this.mTargetLocation;
        if (r2 == null) goto L5;
        o.a(r2);
        r1[0] = r2.x;
        r1[1] = r2.y;
    L10:
        if (r13 != 3) goto L12;
        if (r11 == false) goto L32;
        int r14 = (r9.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L33:
        r12.left = (r1[0] + this.mXOffset) - getMeasuredWidth();
        r12.right = r1[0] + this.mXOffset;
        r12.top = ((r1[1] + this.mYOffset) + r14) + com.obric.oui.common.util.g.a(r9, 1.3f);
        r12.bottom = (((r1[1] + this.mYOffset) + r9.getHeight()) - r14) - com.obric.oui.common.util.g.a(r9, 1.3f);
        return;
    L32:
        r14 = 0;
        goto L33
    L12:
        if (r13 != 5) goto L14;
        if (r11 == false) goto L28;
        int r15 = (r9.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L29:
        r12.left = (r1[0] + this.mXOffset) + r9.getWidth();
        r12.right = ((r1[0] + this.mXOffset) + r9.getWidth()) + getMeasuredWidth();
        r12.top = ((r1[1] + this.mYOffset) + r15) + com.obric.oui.common.util.g.a(r9, 1.3f);
        r12.bottom = (((r1[1] + this.mYOffset) + r9.getHeight()) - r15) - com.obric.oui.common.util.g.a(r9, 1.3f);
        return;
    L28:
        r15 = 0;
        goto L29
    L14:
        if (r13 != 48) goto L16;
        if (r11 == false) goto L24;
        int r16 = (r9.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L25:
        r12.left = ((r1[0] + this.mXOffset) + r16) + com.obric.oui.common.util.g.a(r9, 1.4f);
        r12.right = (((r1[0] + this.mXOffset) + r9.getWidth()) - r16) - com.obric.oui.common.util.g.a(r9, 1.4f);
        r12.top = ((r1[1] + this.mYOffset) - com.obric.oui.common.util.g.a(r9, 1.3f)) - getMeasuredHeight();
        r12.bottom = (r1[1] + this.mYOffset) - com.obric.oui.common.util.g.a(r9, 1.3f);
        return;
    L24:
        r16 = 0;
        goto L25
    L16:
        if (r13 != 80) goto L38;
        if (r11 == false) goto L20;
        int r17 = (r9.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L21:
        r12.left = ((r1[0] + this.mXOffset) + r17) + com.obric.oui.common.util.g.a(r9, 1.4f);
        r12.right = (((r1[0] + this.mXOffset) + r9.getWidth()) - r17) - com.obric.oui.common.util.g.a(r9, 1.4f);
        r12.top = ((r1[1] + this.mYOffset) + r9.getHeight()) + com.obric.oui.common.util.g.a(r9, 1.3f);
        r12.bottom = (((r1[1] + this.mYOffset) + r9.getHeight()) + getMeasuredHeight()) + com.obric.oui.common.util.g.a(r9, 1.3f);
        return;
    L20:
        r17 = 0;
        goto L21
    L38:
        return;
    L5:
        String r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().toString();
        o.c(r3, "anchor.context.resources.configuration.toString()");
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("hw-magic-windows", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L8;
        r9.getLocationInWindow(r1);
        goto L10
    L8:
        r9.getLocationOnScreen(r1);
        goto L10
    }

    static /* synthetic */ void setBubblePositionAndShow$default(OPopover r0, View r1, int r2, boolean r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        r0.setBubblePositionAndShow(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBubblePositionAndShow");
    }

    private final void setBubblePositionAndShow(View r11, int r12, boolean r13, boolean r14) {
        int r3 = Companion.a(r12);
        int[] r15 = new int[2];
        Point r0 = this.mTargetLocation;
        if (r0 == null) goto L6;
        o.a(r0);
        r15[0] = r0.x;
        r15[1] = r0.y;
    L9:
        int[] r16 = calTargetPosition$OUI_standardRelease(r13, r3, r11.getMeasuredWidth(), r11.getMeasuredHeight(), false, r14);
        if (this.mShowAsDropDown == false) goto L12;
        showAsDropDown(r11, r16[0], r16[1] - r11.getMeasuredHeight(), 0);
    L13:
        this.mIsFirstShow = false;
        clearFakeAnchorViewIfNecessary();
        return;
    L12:
        showAtLocation(r11, 0, Math.max(0, r15[0] + r16[0]), Math.max(0, r15[1] + r16[1]));
        goto L13
    L6:
        if (this.mGetLocationInWindow == false) goto L8;
        r11.getLocationInWindow(r15);
        goto L9
    L8:
        r11.getLocationOnScreen(r15);
        goto L9
    }

    public static /* synthetic */ int[] calTargetPosition$OUI_standardRelease$default(OPopover r9, boolean r10, int r11, int r12, int r13, boolean r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L14;
        if ((r16 & 16) == 0) goto L6;
        boolean r7 = false;
    L8:
        if ((r16 & 32) == 0) goto L10;
        boolean r8 = false;
    L12:
        return r9.calTargetPosition$OUI_standardRelease(r10, r11, r12, r13, r7, r8);
    L10:
        r8 = r15;
        goto L12
    L6:
        r7 = r14;
        goto L8
    L14:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calTargetPosition");
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r8, int r9, int r10, int r11, boolean r12, boolean r13) {
        int[] r1 = new int[2];
        if (this.mAlignArrowPadding == false) goto L14;
        if (r8 == true) goto L14;
        if (r12 == true) goto L14;
        int r14 = getMGravity();
        if (r14 == 3) goto L13;
        if (r14 == 5) goto L13;
        if (r14 == 48) goto L12;
        if (r14 != 80) goto L14;
    L12:
        this.mXOffset -= getArrowHeight();
    L13:
        this.mYOffset -= getArrowHeight();
    L14:
        int r15 = Companion.a(r9);
        if (r15 == 3) goto L36;
        if (r15 == 5) goto L31;
        if (r15 == 48) goto L26;
        if (r15 == 80) goto L21;
    L40:
        return r1;
    L21:
        if ((r8 | r13) == false) goto L23;
        int r16 = (r10 - getMeasuredWidth()) / 2;
    L24:
        r1[0] = this.mXOffset + r16;
        r1[1] = this.mYOffset + r11;
        goto L40
    L23:
        r16 = 0;
        goto L24
    L26:
        if ((r8 | r13) == false) goto L28;
        int r17 = (r10 - getMeasuredWidth()) / 2;
    L29:
        r1[0] = this.mXOffset + r17;
        r1[1] = (-getMeasuredHeight()) + this.mYOffset;
        goto L40
    L28:
        r17 = 0;
        goto L29
    L31:
        if ((r8 | r13) == false) goto L33;
        int r18 = (r11 - getMeasuredHeight()) / 2;
    L34:
        r1[0] = this.mXOffset + r10;
        r1[1] = this.mYOffset + r18;
        goto L40
    L33:
        r18 = 0;
        goto L34
    L36:
        if ((r8 | r13) == false) goto L38;
        int r19 = (r11 - getMeasuredHeight()) / 2;
    L39:
        r1[0] = this.mXOffset - getMeasuredWidth();
        r1[1] = this.mYOffset + r19;
        goto L40
    L38:
        r19 = 0;
        goto L39
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r11, int r12, int r13, int r14) {
        o.e(r11, "anchor");
        int r15 = Companion.a(r12);
        m<Integer, Integer> r2 = addShadowFrameIfNeeded(r13, r14);     // Catch: Exception -> L19
        if (this.mIsShowInDialog == false) goto L13;
        View r3 = r11.getRootView();     // Catch: Exception -> L19
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        o.c(r5, "anchor.context");     // Catch: Exception -> L19
        int r6 = com.obric.oui.common.util.g.a(r5);     // Catch: Exception -> L19
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        o.c(r7, "anchor.context");     // Catch: Exception -> L19
        int r0 = com.obric.oui.common.util.g.b(r7);     // Catch: Exception -> L19
        int r8 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L19
        int r9 = com.obric.oui.window.a.f36851a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L19
        if (r3.getWidth() >= r6) goto L8;
        float r10 = (r6 - r3.getWidth()) / 2.0f;     // Catch: Exception -> L19
    L9:
        int r16 = d.i.a.a(r10);     // Catch: Exception -> L19
        if (r3.getHeight() >= r0) goto L12;
        int r1 = ((r0 - r3.getHeight()) + r8) + r9;     // Catch: Exception -> L19
    L14:
        super.showAtLocation(r11, r15, (r13 - ((Number) ZeusTransformUtils.preCheckCast(r2.a(), Number.class, "com.obric.aiagent.plugin")).intValue()) - r16, (r14 - ((Number) ZeusTransformUtils.preCheckCast(r2.b(), Number.class, "com.obric.aiagent.plugin")).intValue()) - r1);     // Catch: Exception -> L19
        this.isAlreadyDismiss = false;     // Catch: Exception -> L19
        if (this.mShowWithAnimation == false) goto L17;
        animatorEasyInOut(true);     // Catch: Exception -> L19
        return;
    L17:
        showDirectly();     // Catch: Exception -> L19
        return;
    L12:
        r1 = 0;
        goto L14
    L8:
        r10 = 0.0f;
        goto L9
    L13:
        r1 = 0;
        r16 = 0;
    L19:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "showAtLocation, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r5, int r6, int r7, int r8) {
        int r9 = Companion.a(r8);
        m<Integer, Integer> r1 = addShadowFrameIfNeeded(r6, r7);     // Catch: Exception -> L8
        super.showAsDropDown(r5, r6 - ((Number) ZeusTransformUtils.preCheckCast(r1.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), r7 - ((Number) ZeusTransformUtils.preCheckCast(r1.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), r9);     // Catch: Exception -> L8
        this.isAlreadyDismiss = false;     // Catch: Exception -> L8
        if (this.mShowWithAnimation == false) goto L6;
        animatorEasyInOut(true);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        showDirectly();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "showAsDropDown, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void popupAtLocation(View r3, int r4, int r5, int r6, float r7) {
        o.e(r3, "anchor");
        int r8 = Companion.a(r4);
        this.mGravity = r8;     // Catch: Exception -> L10
        this.mArrowOffset = r7;     // Catch: Exception -> L10
        OPopoverLayout r9 = this.mOBubbleLayout;     // Catch: Exception -> L10
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
        ViewGroup r1 = this.mWindowFrame;
        if (r1 != null) goto L5;
        o.c("mWindowFrame");
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
        clearFakeAnchorViewIfNecessary();
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
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        o.c("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.getPadding() * 4);
    }

    public final int getBubbledWidth() {
        measure();
        int r0 = getContentView().getMeasuredWidth();
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        o.c("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.getPadding() * 4);
    }

    public final View getPopoverView() {
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L6;
        o.c("mOBubbleLayout");
        r2 = null;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    public final int getArrowHeight() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 == null) goto L7;
        if (r0 != null) goto L9;
        o.c("mOBubbleLayout");
        r0 = null;
    L9:
        return r0.getArrowHeight();
    L7:
        return 0;
    }

    public final void setMaxContentHeight(int r6) {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 == null) goto L18;
        if (r6 <= 0) goto L19;
        OPopoverLayout r1 = null;
        if (r0 != null) goto L9;
        o.c("mOBubbleLayout");
        r0 = null;
    L9:
        int r7 = n.c(r6 - (r0.getArrowHeight() * 2), 0);
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L12;
        o.c("mOBubbleLayout");
        r2 = null;
    L12:
        setMaxContentHeightIfPossible((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), r7);
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L15;
        o.c("mOBubbleLayout");
    L16:
        r1.requestLayout();
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L15:
        r1 = r8;
        goto L16
    L19:
        return;
    }

    private final void setMaxContentHeightIfPossible(View r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r4, OPopoverMenuView.class) == false) goto L6;
        ((OPopoverMenuView) ZeusTransformUtils.preCheckCast(r4, OPopoverMenuView.class, "com.obric.aiagent.plugin")).setPopoverMaxHeight(r5);
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L11;
        Iterator<View> r6 = ab.b((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")).a();
    L9:
        if (r6.hasNext() == false) goto L13;
        setMaxContentHeightIfPossible((View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.aiagent.plugin"), r5);
        goto L9
    L13:
        return;
    }

    /* JADX INFO: renamed from: mDismissRunnable$lambda-2, reason: not valid java name */
    private static final void m1127mDismissRunnable$lambda2(OPopover r1) {
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
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L7;
        o.c("mWindowFrame");
        r0 = null;
    L7:
        r0.setVisibility(8);
        onDestroy();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    private final void showDirectly() {
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L5;
        o.c("mWindowFrame");
        r0 = null;
    L5:
        r0.setVisibility(0);
        f r2 = this.mShowListener;
        if (r2 == null) goto L10;
        r2.a();
        return;
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.obric.oui.animation.a.b] */
    private final void animatorEasyInOut(final boolean r24) {
        final ViewGroup r2 = this.mWindowFrame;
        OPopoverLayout r3 = null;
        if (r2 != null) goto L5;
        o.c("mWindowFrame");
        r2 = null;
    L5:
        int r4 = -1;
        if (r24 == true) goto L8;
        currentShowBubbleNumbers--;
        this.isAlreadyDismiss = true;
    L8:
        this.animSet = new AnimatorSet();
        int r6 = getMGravity();
        if (r6 != 3) goto L11;
        float r7 = r2.getX() + r2.getMeasuredWidth();
        float r8 = r2.getY();
        OPopoverLayout r12 = this.mOBubbleLayout;
        if (r12 != null) goto L33;
        o.c("mOBubbleLayout");
    L34:
        float r5 = r3.getBubbleOffset();
    L35:
        float r9 = r5 + r8;
    L36:
        View r10 = r2.getChildAt(0);
        if (r10 != null) goto L39;
        float r11 = 0.0f;
    L40:
        r2.setPivotY(r9);
        r2.setPivotX(r7 + r11);
        float r13 = 1.0f;
        PathInterpolator r14 = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator r15 = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        if (r24 == false) goto L43;
        float r16 = 0.0f;
    L44:
        if (r24 == false) goto L46;
        float r17 = 1.0f;
    L48:
        if (r2.getAlpha() != 0.0f) goto L50;
        boolean r18 = true;
    L51:
        if (r18 == false) goto L53;
    L58:
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{r16, r17});
        if (r24 == false) goto L61;
        Object r20 = ZeusTransformUtils.preCheckCast(r14, TimeInterpolator.class, "com.obric.aiagent.plugin");
    L62:
        r19.setInterpolator((TimeInterpolator) r20);
        if (r24 == false) goto L65;
        long r110 = 300;
    L66:
        r19.setDuration(r110);
        r2.setVisibility(0);
        final z.f r21 = new z.f();
        if (r24 == false) goto L74;
        Animator r22 = this.customInAnimator;
        if (r22 == null) goto L74;
        AnimatorSet r23 = this.animSet;
        if (r23 == null) goto L116;
        r23.play(r22);
    L116:
        AnimatorSet r25 = this.animSet;
        if (r25 == null) goto L120;
        r25.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r24, r2, this, r21), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
    L120:
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L125;
        r0.start();
        return;
    L125:
        return;
    L74:
        if (r24 == true) goto L81;
        Animator r26 = this.customOutAnimator;
        if (r26 == null) goto L81;
        AnimatorSet r27 = this.animSet;
        if (r27 == null) goto L116;
        r27.play(r26);
    L81:
        AnimatorSet r28 = this.animSet;
        if (r28 == null) goto L86;
        r28.play((Animator) ZeusTransformUtils.preCheckCast(r19, Animator.class, "com.obric.aiagent.plugin"));
    L86:
        if (r24 == false) goto L88;
        float r111 = 0.5f;
    L89:
        if (r24 == false) goto L91;
        float r112 = 1.0f;
    L93:
        if (getMGravity() == 48) goto L96;
        r4 = 1;
    L96:
        if (r24 == false) goto L98;
        float r29 = -com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), 10);
    L99:
        float r30 = r4;
        final float r113 = r29 * r30;
        if (r24 == false) goto L102;
        float r31 = 0.0f;
    L103:
        final float r114 = r31 * r30;
        if (r24 == false) goto L106;
        final float r32 = 0.0f;
    L107:
        if (r24 == false) goto L109;
        final float r33 = 10000.0f;
    L111:
        if (com.obric.oui.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")).a() == true) goto L113;
        r2.setScaleX(r111);
        r2.setScaleY(r111);
        r2.setTranslationY(r113);
        r2.setTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, DbHelper.COL_ID, "o_popover_anim_p"), new b(r32));
    L113:
        if (r24 == false) goto L115;
        r13 = 0.8f;
    L115:
        ?? r115 = com.obric.oui.animation.a.b.a(com.obric.oui.animation.a.c.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin")).a(r13).b(439.0f), this.animFloatP, r33, null, 4, null);
        final ViewGroup r34 = r2;
        final float r35 = r111;
        final float r36 = r112;
        r115.a(new $$Lambda$OPopover$D42NbhUFJ_PXJ5Dq96Cve8yRvjo(r34, r32, r33, r35, r36, r113, r114));
        r21.f38504a = r115;
        goto L116
    L109:
        r33 = 0.0f;
        goto L111
    L106:
        r32 = 10000.0f;
        goto L107
    L102:
        r31 = -com.obric.oui.common.util.g.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"), 10);
        goto L103
    L98:
        r29 = 0.0f;
        goto L99
    L91:
        r112 = 0.5f;
        goto L93
    L88:
        r111 = 1.0f;
        goto L89
    L65:
        r110 = 100;
        goto L66
    L61:
        r20 = ZeusTransformUtils.preCheckCast(r15, TimeInterpolator.class, "com.obric.aiagent.plugin");
        goto L62
    L53:
        if (r2.getAlpha() != 1.0f) goto L55;
        boolean r116 = true;
    L56:
        if (r116 == true) goto L58;
        r16 = r2.getAlpha();
        goto L58
    L55:
        r116 = false;
        goto L56
    L50:
        r18 = false;
        goto L51
    L46:
        r17 = 0.0f;
        goto L48
    L43:
        r16 = 1.0f;
        goto L44
    L39:
        r11 = r10.getX();
        goto L40
    L33:
        r3 = r12;
        goto L34
    L11:
        if (r6 == 5) goto L25;
        if (r6 == 48) goto L20;
        if (r6 == 80) goto L15;
        r9 = 0.0f;
        r7 = 0.0f;
        goto L36
    L15:
        float r37 = r2.getX();
        OPopoverLayout r38 = this.mOBubbleLayout;
        if (r38 != null) goto L18;
        o.c("mOBubbleLayout");
    L19:
        r7 = r37 + r3.getBubbleOffset();
        r9 = r2.getY() + r2.getPaddingTop();
        goto L36
    L18:
        r3 = r38;
        goto L19
    L20:
        float r39 = r2.getX();
        OPopoverLayout r40 = this.mOBubbleLayout;
        if (r40 != null) goto L23;
        o.c("mOBubbleLayout");
    L24:
        r7 = r39 + r3.getBubbleOffset();
        r9 = (r2.getY() + r2.getMeasuredHeight()) - r2.getPaddingBottom();
        goto L36
    L23:
        r3 = r40;
        goto L24
    L25:
        r7 = r2.getX();
        r8 = r2.getY();
        OPopoverLayout r117 = this.mOBubbleLayout;
        if (r117 != null) goto L28;
        o.c("mOBubbleLayout");
    L29:
        r5 = r3.getBubbleOffset();
        goto L35
    L28:
        r3 = r117;
        goto L29
    }

    /* JADX INFO: renamed from: animatorEasyInOut$lambda-5$lambda-4, reason: not valid java name */
    private static final void m1124animatorEasyInOut$lambda5$lambda4(ViewGroup r1, float r2, float r3, float r4, float r5, float r6, float r7, com.obric.oui.animation.engine.b r8, float r9, float r10) {
        o.e(r1, "$view");
        com.obric.oui.d.c r11 = com.obric.oui.d.c.f35012a;
        Object r12 = r1.getTag(ZeusTransformUtils.mapRes(R.id.o_popover_anim_p, DbHelper.COL_ID, "o_popover_anim_p"));
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L8:
        if (((b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin")) == null) goto L11;
        float r13 = com.obric.oui.d.b.a(r9, r2, r3);
        float r14 = r4 + ((r5 - r4) * r13);
        r1.setScaleX(r14);
        r1.setScaleY(r14);
        r1.setTranslationY(r6 + ((r7 - r6) * r13));
        return;
    L11:
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L4;
        goto L4
    }

    private final void clearFakeAnchorViewIfNecessary() {
        ViewGroup r4 = com.obric.oui.d.h.f35017a.a(this.activity);
        if (r4 == null) goto L15;
        j<View> r0 = ab.b(r4);
        if (r0 == null) goto L17;
        j r1 = d.n.m.a(r0, (d.h.a.b) ZeusTransformUtils.preCheckCast(h.f35989a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L18;
        Iterator r2 = r1.a();
    L13:
        if (r2.hasNext() == false) goto L19;
        r4.removeView((View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.aiagent.plugin"));
        com.obric.oui.d.a.b.b(TAG, "remove fake anchor view");
        goto L13
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    private final m<Integer, Integer> addShadowFrameIfNeeded(int r1, int r2) {
        return addShadowFrame(r1, r2);
    }

    private final m<Integer, Integer> addShadowFrame(int r18, int r19) {
        ViewGroup r6 = null;
        if (this.mIsFirstShow == true) goto L15;
        ViewGroup r1 = this.mWindowFrame;
        if (r1 != null) goto L8;
        o.c("mWindowFrame");
        r1 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r1, SingleChildFrameLayout.class) == false) goto L15;
        ViewGroup r2 = this.mWindowFrame;
        if (r2 != null) goto L12;
        o.c("mWindowFrame");
    L13:
        r6.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "contentView.context");
        setWidth(com.obric.oui.common.util.g.a(r3));
        return new m(Integer.valueOf(r18), Integer.valueOf(this.mShadowSpaceTop));
    L12:
        r6 = r2;
    L15:
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), null, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        SingleChildFrameLayout r5 = (SingleChildFrameLayout) ZeusTransformUtils.preCheckCast(r4, SingleChildFrameLayout.class, "com.obric.aiagent.plugin");
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L18;
        o.c("mOBubbleLayout");
        r8 = null;
    L18:
        r5.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        OPopoverLayout r9 = this.mOBubbleLayout;
        if (r9 != null) goto L21;
        o.c("mOBubbleLayout");
        r9 = null;
    L21:
        r5.setShadowCornerRadius(d.i.a.a(r9.getCornerRadius()));
        OPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L24;
        o.c("mOBubbleLayout");
        r10 = null;
    L24:
        int r11 = r10.getArrowHeight();
        OPopoverLayout r12 = this.mOBubbleLayout;
        if (r12 != null) goto L27;
        o.c("mOBubbleLayout");
        r12 = null;
    L27:
        r5.setShadowInsets(r11, r12.getArrowHeight());
        List<com.obric.oui.common.style.j> r13 = com.obric.oui.common.style.f.a((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.style.OUIShadow_3, "style", "OUIShadow_3"));
        o.c(r13, "shadows");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r110 = 0;
    L29:
        if (r14.hasNext() == false) goto L43;
        com.obric.oui.common.style.j r7 = (com.obric.oui.common.style.j) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.oui.common.style.j.class, "com.obric.aiagent.plugin");
        if ((r7.b() - r7.c()) <= r17) goto L34;
        r17 = d.i.a.a(r7.b() - r7.c());
    L34:
        if ((r7.b() + r7.c()) <= r110) goto L37;
        r110 = d.i.a.a(r7.b() + r7.c());
    L37:
        if ((r7.b() - r7.d()) <= r15) goto L40;
        r15 = d.i.a.a(r7.b() - r7.d());
    L40:
        if ((r7.b() + r7.d()) <= r16) goto L29;
        r16 = d.i.a.a(r7.b() + r7.d());
        goto L29
    L43:
        SingleChildFrameLayout r20 = new SingleChildFrameLayout((Context) ZeusTransformUtils.preCheckCast(this.activity, Context.class, "com.obric.aiagent.plugin"), null, 2, null);
        Context r21 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r21, "contentView.context");
        r20.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(com.obric.oui.common.util.g.a(r21), -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r20.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r20.setClipChildren(false);
        r20.setClipToPadding(false);
        r20.setPadding(0, r15, 0, r16);
        r5.setX(r18);
        r20.setOnTouchListener(new $$Lambda$OPopover$_FnOsdqHV5hIn391tEGAYO0WzCE(this));
        this.mShadowSpaceTop = r15;
        ViewGroup r22 = (ViewGroup) ZeusTransformUtils.preCheckCast(r20, ViewGroup.class, "com.obric.aiagent.plugin");
        this.mWindowFrame = r22;
        if (r22 != null) goto L46;
        o.c("mWindowFrame");
        r22 = null;
    L46:
        r22.setVisibility(4);
        ViewGroup r23 = this.mWindowFrame;
        if (r23 != null) goto L49;
        o.c("mWindowFrame");
    L50:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r24 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r24, "contentView.context");
        setWidth(com.obric.oui.common.util.g.a(r24));
        return new m(Integer.valueOf(r18), Integer.valueOf(r15));
    L49:
        r6 = r23;
        goto L50
    }

    /* JADX INFO: renamed from: addShadowFrame$lambda-10, reason: not valid java name */
    private static final boolean m1123addShadowFrame$lambda10(OPopover r3, View r4, MotionEvent r5) {
        o.e(r3, "this$0");
        if (r5.getAction() != 0) goto L12;
        com.obric.oui.d.h r6 = com.obric.oui.d.h.f35017a;
        OPopoverLayout r0 = r3.mOBubbleLayout;
        if (r0 != null) goto L7;
        o.c("mOBubbleLayout");
        r0 = null;
    L7:
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        o.c(r5, "event");
        if (r6.a(r1, r5) == false) goto L13;
        r3.dismiss();
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final void setIsShowInDialog(boolean r1) {
        this.mIsShowInDialog = r1;
    }
}
