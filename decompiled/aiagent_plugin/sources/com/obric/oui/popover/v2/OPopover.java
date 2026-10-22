package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.view.ab;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.popover.FakeAnchorView;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.m;
import d.n.j;
import d.x;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: OPopover.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OPopover extends PopupWindow implements com.obric.oui.popover.v2.b<OPopover> {
    public static final b Companion = null;
    private static final String TAG = "OPopover";
    private static boolean shouldForceDismiss;
    private Animator customInAnimator;
    private Animator customOutAnimator;
    private boolean enableAutoDismiss;
    private boolean isAlreadyDismiss;
    private Boolean isHideVirtualKey;
    private Activity mActivity;
    private int mAnchorViewHeight;
    private int mAnchorViewWidth;
    private long mAnimTime;
    private long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBorderColor;
    private int mBorderWidth;
    private Context mContext;
    private boolean mCoverPreviousWhenStacked;
    private c mDismissListener;
    private final Runnable mDismissRunnable;
    private int mDisplayOrientation;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mHeight;
    private boolean mIsFirstShow;
    private boolean mIsShowInDialog;
    private OPopoverLayout mOBubbleLayout;
    private boolean mOutsideTouchable;
    private boolean mShadowEnabled;
    private int mShadowSpaceTop;
    private int mShadowStyle;
    private d mShowListener;
    private boolean mSpacingForShadow;
    private float mStackAlphaPrevious;
    private int mStackCoverColor;
    private float mStackScalePrevious;
    private e mStartDismissListener;
    private View mView;
    private int mWidth;
    private ViewGroup mWindowFrame;
    private float popoverAnchorCenterX;
    private float popoverAnchorCenterY;
    private final long popoverAnimationDurationMillis;
    private AnimatorSet popoverAnimator;
    private final boolean popoverEnableBubbleMaterial;
    private int popoverGravity;
    private final d.h.a.b<Boolean, com.obric.oui.material.c[]> popoverMaterials;
    private int popoverPopupOriginX;
    private int popoverPopupOriginY;
    private boolean popoverPushedToStack;
    private boolean popoverRemovedFromStack;
    private final boolean popoverShowWithAnimation;
    private int popoverXOffset;
    private int popoverYOffset;
    private boolean transparentBg;
    private boolean useWindowCoords;

    /* JADX INFO: compiled from: OPopover.kt */
    public static final class a extends com.obric.oui.popover.v2.c<a> {
        public a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            super(r4);
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        public final int a(int r5) {
            boolean r1 = true;
            if ((r5 & 8388611) != 8388611) goto L5;
            boolean r4 = true;
        L7:
            if ((r5 & 8388613) == 8388613) goto L10;
            r1 = false;
        L10:
            if (r4 == false) goto L12;
            r5 = ((-8388612) & r5) | 3;
        L12:
            if (r1 == true) goto L14;
            return r5;
        L14:
            return ((-8388614) & r5) | 5;
        L5:
            r4 = false;
            goto L7
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    public interface c {
        void a();
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
    static final class f extends p implements d.h.a.b<View, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f36036a = null;

        static {
            f36036a = new f();
        }

        f() {
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

    static {
        Companion = new b(null);
    }

    /* JADX INFO: renamed from: lambda$dmRUnXz-WNroEqGZ8pLwpYpDHNA, reason: not valid java name */
    public static /* synthetic */ void m1135lambda$dmRUnXzWNroEqGZ8pLwpYpDHNA(OPopover r0) {
        m1136mDismissRunnable$lambda3(r0);
    }

    public static /* synthetic */ boolean lambda$oD6BKGUVT3ejE5vm1gsw4hmpi1w(OPopover r0, View r1, MotionEvent r2) {
        return m1134addShadowFrame$lambda8(r0, r1, r2);
    }

    public OPopover(a r5) {
        o.e(r5, "builder");
        this.popoverShowWithAnimation = r5.v();
        this.popoverAnimationDurationMillis = r5.h();
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShadowEnabled = true;
        this.mShadowStyle = ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Regular, "style", "OUIShadow_Oui_Shadow_Regular");
        this.mIsFirstShow = true;
        this.popoverAnchorCenterX = Float.NaN;
        this.popoverAnchorCenterY = Float.NaN;
        this.mCoverPreviousWhenStacked = true;
        this.mStackCoverColor = Color.parseColor("#08000000");
        this.mStackAlphaPrevious = 0.3f;
        this.mStackScalePrevious = 0.98f;
        this.popoverEnableBubbleMaterial = r5.z();
        this.popoverMaterials = r5.A();
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        setPopoverGravity(r5.b());
        this.mDisplayOrientation = r5.c();
        this.mActivity = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.oui.window.a.f36851a.getActivity(this.mContext), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.mBgColor = r5.d();
        this.isHideVirtualKey = Boolean.valueOf(r5.e());
        setPopoverXOffset(r5.f());
        setPopoverYOffset(r5.g());
        this.mAnimTime = r5.h();
        this.mAutoDismissDelayMillis = r5.i();
        this.mView = r5.j();
        this.mHeight = r5.l();
        this.mWidth = r5.k();
        this.mStartDismissListener = r5.m();
        this.mDismissListener = r5.n();
        this.mShowListener = r5.o();
        this.mOutsideTouchable = r5.p();
        this.mFocusable = r5.a();
        this.mGetLocationInWindow = r5.q();
        this.mBorderWidth = r5.s();
        this.mBorderColor = r5.t();
        this.transparentBg = r5.u();
        this.mShadowEnabled = r5.w();
        this.mShadowStyle = r5.x();
        this.mSpacingForShadow = r5.y();
        this.mCoverPreviousWhenStacked = r5.B();
        this.mStackCoverColor = r5.C();
        this.mStackAlphaPrevious = r5.D();
        this.mStackScalePrevious = r5.E();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        setBubbleLayout(requirePopoverContentView(this.mView));
        initContentView();
        setFocusable(true);
        this.mDismissRunnable = new $$Lambda$OPopover$dmRUnXzWNroEqGZ8pLwpYpDHNA(this);
    }

    public static final /* synthetic */ int access$getMShadowStyle$p(OPopover r0) {
        return r0.mShadowStyle;
    }

    public static final /* synthetic */ void access$setShouldForceDismiss$cp(boolean r0) {
        shouldForceDismiss = r0;
    }

    public void afterShowInStackIfNeeded() {
        com.obric.oui.popover.v2.b.C0977b.m((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    public void beforeShowInStackIfNeeded() {
        com.obric.oui.popover.v2.b.C0977b.l((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public void cancelPopoverAnimatorInternal() {
        com.obric.oui.popover.v2.b.C0977b.h((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public OPopoverLayout createPopoverBubbleLayout(View r3, int r4) {
        return com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    @Override // com.obric.oui.popover.v2.b
    public View getContentViewInternal() {
        return com.obric.oui.popover.v2.b.C0977b.e((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    public int getDisplayRotationDegreesInternal() {
        return com.obric.oui.popover.v2.b.C0977b.d((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverAnimationIsWindowMode() {
        return com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public void measurePopoverContent(View r3, int r4, int r5) {
        com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    public void measurePopupInternal(int r3, int r4) {
        com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public void onDestroyInStackIfNeeded() {
        com.obric.oui.popover.v2.b.C0977b.n((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    public View requirePopoverContentView(View r3) {
        return com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.b
    public void resetPopoverAnimatedViewState(View r3) {
        com.obric.oui.popover.v2.b.C0977b.b((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.b
    public float resolvePopoverPivot(float r3, int r4, float r5) {
        return com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    public com.obric.oui.popover.v2.b.c resolvePopoverShadowPadding(int r3) {
        return com.obric.oui.popover.v2.b.C0977b.d((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3);
    }

    public float resolvePopoverShadowSpace(int r3) {
        return com.obric.oui.popover.v2.b.C0977b.e((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setGravityInternal(int r3) {
        com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.b
    public void setMaxContentHeightInternal(int r3, View r4) {
        com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverMaxContentHeight(int r3, View r4, int r5, int r6) {
        com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3, r4, r5, r6);
    }

    public void setXOffsetInternal(int r3) {
        com.obric.oui.popover.v2.b.C0977b.b((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setYOffsetInternal(int r3) {
        com.obric.oui.popover.v2.b.C0977b.c((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3);
    }

    public boolean shouldAnimatePopoverVisibilityInternal() {
        return com.obric.oui.popover.v2.b.C0977b.g((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public void showPopoverDirectlyInternal(ViewGroup r3, d.h.a.a<x> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r3, r5);
    }

    public void showPopoverWithoutAnimationInternal() {
        com.obric.oui.popover.v2.b.C0977b.i((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public AnimatorSet startPopoverVisibilityAnimationInternal(boolean r10, int r11, boolean r12, Animator r13, d.h.a.a<x> r14, d.h.a.a<x> r15) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        return com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13, r7, r8);
    }

    @Override // com.obric.oui.popover.v2.b
    public void updatePopoverPivotInternal() {
        com.obric.oui.popover.v2.b.C0977b.f((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverShowWithAnimation() {
        return this.popoverShowWithAnimation;
    }

    @Override // com.obric.oui.popover.v2.b
    public long getPopoverAnimationDurationMillis() {
        return this.popoverAnimationDurationMillis;
    }

    @Override // com.obric.oui.popover.v2.b
    public Animator getPopoverEnterAnimator() {
        return this.customInAnimator;
    }

    @Override // com.obric.oui.popover.v2.b
    public Animator getPopoverExitAnimator() {
        return this.customOutAnimator;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverGravity(int r1) {
        this.popoverGravity = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverGravity() {
        return Companion.a(this.popoverGravity);
    }

    public int getPopoverXOffset() {
        return this.popoverXOffset;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverXOffset(int r1) {
        this.popoverXOffset = r1;
    }

    public int getPopoverYOffset() {
        return this.popoverYOffset;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverYOffset(int r1) {
        this.popoverYOffset = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public AnimatorSet getPopoverAnimator() {
        return this.popoverAnimator;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverAnimator(AnimatorSet r1) {
        this.popoverAnimator = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverAnchorCenterX() {
        return this.popoverAnchorCenterX;
    }

    public void setPopoverAnchorCenterX(float r1) {
        this.popoverAnchorCenterX = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverAnchorCenterY() {
        return this.popoverAnchorCenterY;
    }

    public void setPopoverAnchorCenterY(float r1) {
        this.popoverAnchorCenterY = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverPopupOriginX() {
        return this.popoverPopupOriginX;
    }

    public void setPopoverPopupOriginX(int r1) {
        this.popoverPopupOriginX = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverPopupOriginY() {
        return this.popoverPopupOriginY;
    }

    public void setPopoverPopupOriginY(int r1) {
        this.popoverPopupOriginY = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverPushedToStack() {
        return this.popoverPushedToStack;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverPushedToStack(boolean r1) {
        this.popoverPushedToStack = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverRemovedFromStack() {
        return this.popoverRemovedFromStack;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverRemovedFromStack(boolean r1) {
        this.popoverRemovedFromStack = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public Context getPopoverContext() {
        return this.mContext;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverDisplayOrientation() {
        return this.mDisplayOrientation;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverBgColor() {
        return this.mBgColor;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverTransparentBg() {
        return this.transparentBg;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverWidth() {
        return this.mWidth;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverHeight() {
        return this.mHeight;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverEnableBubbleMaterial() {
        return this.popoverEnableBubbleMaterial;
    }

    @Override // com.obric.oui.popover.v2.b
    public d.h.a.b<Boolean, com.obric.oui.material.c[]> getPopoverMaterials() {
        return this.popoverMaterials;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverCoverPreviousWhenStacked() {
        return this.mCoverPreviousWhenStacked;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverStackCoverColor() {
        return this.mStackCoverColor;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverStackAlphaPrevious() {
        return this.mStackAlphaPrevious;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverStackScalePrevious() {
        return this.mStackScalePrevious;
    }

    @Override // com.obric.oui.popover.v2.b
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L6;
        o.c("mOBubbleLayout");
        return null;
    L6:
        return r0;
    }

    public void setPopoverBubbleLayout(OPopoverLayout r2) {
        o.e(r2, "value");
        this.mOBubbleLayout = r2;
    }

    @Override // com.obric.oui.popover.v2.b
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L6;
        o.c("mWindowFrame");
        return null;
    L6:
        return r0;
    }

    public void setPopoverWindowFrame(ViewGroup r2) {
        o.e(r2, "value");
        this.mWindowFrame = r2;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean isPopoverBubbleLayoutInitialized() {
        if (this.mOBubbleLayout == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void initContentView() {
        if (o.a(this.isHideVirtualKey, true) == false) goto L5;
        hideSystemUi();
    L5:
        OPopoverLayout r1 = null;
        if (this.mBgColor == 0) goto L11;
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L10;
        o.c("mOBubbleLayout");
        r0 = null;
    L10:
        r0.setBgColor(this.mBgColor);
    L11:
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L15;
        o.c("mOBubbleLayout");
        r2 = null;
    L15:
        if (r2.isEnableMaterial() == true) goto L23;
        OPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L19;
        o.c("mOBubbleLayout");
        r3 = null;
    L19:
        r3.setBorderColor(this.mBorderColor);
        OPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L22;
        o.c("mOBubbleLayout");
        r4 = null;
    L22:
        r4.setBorderWidth(this.mBorderWidth);
    L23:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L26;
        o.c("mOBubbleLayout");
    L27:
        r1.setTransparentBg(this.transparentBg);
        return;
    L26:
        r1 = r5;
        goto L27
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

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        return getDisplayRotationDegreesInternal();
    }

    public final void setXOffset(int r1) {
        setXOffsetInternal(r1);
    }

    public final void setYOffset(int r1) {
        setYOffsetInternal(r1);
    }

    public final void setGetLocationInWindow(boolean r1) {
        this.mGetLocationInWindow = r1;
    }

    public final void setOnShowListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mShowListener = r4;
    }

    public final void setOnStartDismissListener(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mStartDismissListener = r4;
    }

    public final void setOnDismissListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mDismissListener = r4;
    }

    private final void setBubbleLayout(View r6) {
        setPopoverBubbleLayout(com.obric.oui.popover.v2.b.C0977b.a((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"), r6, 0, 2, null));
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(-2, -2);
        getPopoverBubbleLayout().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setPopoverWindowFrame((ViewGroup) ZeusTransformUtils.preCheckCast(getPopoverBubbleLayout(), ViewGroup.class, "com.obric.aiagent.plugin"));
        setContentView((View) ZeusTransformUtils.preCheckCast(getPopoverWindowFrame(), View.class, "com.obric.aiagent.plugin"));
        View r8 = getContentView();
        o.c(r8, "contentView");
        measurePopoverContent(r8, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r19, int r20, int r21, int r22) {
        View r1 = r19;
        o.e(r1, "anchor");
        View r4 = r19.getRootView();
        com.obric.oui.window.a r5 = com.obric.oui.window.a.f36851a;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "anchor.context");
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getActivity(r6), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        boolean r8 = isAnchorFromPopupWindow(r4);
        if (this.mCoverPreviousWhenStacked == true) goto L5;
        this.mCoverPreviousWhenStacked = r8;
    L5:
        int r9 = Companion.a(r20);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L44
        m<Integer, Integer> r10 = addShadowFrameIfNeeded(r21, r22);     // Catch: Exception -> L44
        if (this.mGetLocationInWindow == false) goto L9;
    L12:
        boolean r11 = true;
    L13:
        this.useWindowCoords = r11;     // Catch: Exception -> L44
        int[] r14 = new int[2];     // Catch: Exception -> L44
        if (r11 == false) goto L19;
        r1.getLocationInWindow(r14);     // Catch: Exception -> L44
        if (r8 == false) goto L20;
        if (r7 == null) goto L20;
        int r12 = r14[0];     // Catch: Exception -> L44
        int r15 = r14[1];     // Catch: Exception -> L44
        ZeusTransformUtils.getWindow(r7, "com.obric.aiagent.plugin").getDecorView().getLocationOnScreen(r14);     // Catch: Exception -> L44
        int r13 = r14[0];     // Catch: Exception -> L44
        int r17 = r14[1];     // Catch: Exception -> L44
        r4.getLocationOnScreen(r14);     // Catch: Exception -> L44
        r14[0] = (r12 + r14[0]) - r13;     // Catch: Exception -> L44
        r14[1] = (r15 + r14[1]) - r17;     // Catch: Exception -> L44
    L20:
        setPopoverAnchorCenterX(r14[0] + (r19.getWidth() / 2.0f));     // Catch: Exception -> L44
        setPopoverAnchorCenterY(r14[1] + (r19.getHeight() / 2.0f));     // Catch: Exception -> L44
        if (this.mIsShowInDialog == false) goto L30;
        View r16 = r19.getRootView();     // Catch: Exception -> L44
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L44
        o.c(r18, "anchor.context");     // Catch: Exception -> L44
        int r110 = g.a(r18);     // Catch: Exception -> L44
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L44
        o.c(r111, "anchor.context");     // Catch: Exception -> L44
        int r23 = g.e(r111);     // Catch: Exception -> L44
        int r112 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L44
        int r113 = com.obric.oui.window.a.f36851a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L44
        if (r16.getWidth() >= r110) goto L25;
        float r114 = (r110 - r16.getWidth()) / 2.0f;     // Catch: Exception -> L44
    L26:
        int r115 = d.i.a.a(r114);     // Catch: Exception -> L44
        if (r16.getHeight() >= r23) goto L29;
        int r24 = ((r23 - r16.getHeight()) + r112) + r113;     // Catch: Exception -> L44
    L31:
        int r2 = (r21 - ((Number) ZeusTransformUtils.preCheckCast(r10.a(), Number.class, "com.obric.aiagent.plugin")).intValue()) - r115;     // Catch: Exception -> L44
        int r3 = (r22 - ((Number) ZeusTransformUtils.preCheckCast(r10.b(), Number.class, "com.obric.aiagent.plugin")).intValue()) - r24;     // Catch: Exception -> L44
        setPopoverPopupOriginX(r2);     // Catch: Exception -> L44
        setPopoverPopupOriginY(r3);     // Catch: Exception -> L44
        setElevation(getElevationPx());     // Catch: Exception -> L44
        if (this.mIsShowInDialog == true) goto L39;
        if (r7 == null) goto L39;
        if (o.a(r19.getWindowToken(), ZeusTransformUtils.getWindow(r7, "com.obric.aiagent.plugin").getDecorView().getWindowToken()) == true) goto L38;
        if (r8 == true) goto L38;
        r1 = r19.getRootView();     // Catch: Exception -> L44
        o.c(r1, "anchor.rootView");     // Catch: Exception -> L44
    L38:
        r1 = ZeusTransformUtils.getWindow(r7, "com.obric.aiagent.plugin").getDecorView();     // Catch: Exception -> L44
        o.c(r1, "activity.window.decorView");     // Catch: Exception -> L44
    L39:
        super.showAtLocation(r1, r9, r2, r3);     // Catch: Exception -> L44
        afterShowInStackIfNeeded();     // Catch: Exception -> L44
        setElevation(0.0f);     // Catch: Exception -> L44
        getContentView().setElevation(0.0f);     // Catch: Exception -> L44
        this.mIsFirstShow = false;     // Catch: Exception -> L44
        this.isAlreadyDismiss = false;     // Catch: Exception -> L44
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L42;
        playPopoverEnterAnimationInternal();     // Catch: Exception -> L44
        return;
    L42:
        showPopoverWithoutAnimationInternal();     // Catch: Exception -> L44
        return;
    L29:
        r24 = 0;
        goto L31
    L25:
        r114 = 0.0f;
        goto L26
    L30:
        r24 = 0;
        r115 = 0;
        goto L31
    L19:
        r1.getLocationOnScreen(r14);     // Catch: Exception -> L44
        goto L20
    L9:
        if (this.mIsShowInDialog == true) goto L12;
        r11 = false;
    L44:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "showAtLocation, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final boolean isAnchorFromPopupWindow(View r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        String r1 = r8.getClass().getName();
        if (o.a(r1, "android.widget.PopupWindow$PopupDecorView") == false) goto L37;
        return true;
    L37:
        boolean r2 = ZeusTransformUtils.instanceOf(ZeusTransformUtils.forName("android.widget.PopupWindow$PopupDecorView", "com.obric.aiagent.plugin"), r8);     // Catch: Throwable -> L10
    L11:
        if (r2 == false) goto L39;
        return true;
    L39:
        IBinder r3 = r8.getWindowToken();     // Catch: Throwable -> L36
        IBinder r4 = r8.getApplicationWindowToken();     // Catch: Throwable -> L36
        if (r3 == null) goto L19;
        if (r4 == null) goto L19;
        if (o.a(r3, r4) == true) goto L19;
        boolean r5 = true;
    L20:
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r9, WindowManager.LayoutParams.class) == false) goto L23;
        WindowManager.LayoutParams r10 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r9, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
    L24:
        if (r10 != null) goto L27;
    L25:
        boolean r11 = false;
    L31:
        if (r5 == false) goto L34;
        if (r11 == false) goto L34;
        return true;
    L34:
        o.c(r1, "className");
        return d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("PopupDecorView", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
    L27:
        if (r10.type != 1002) goto L29;
    L30:
        r11 = true;
        goto L31
    L29:
        if (r10.type != 1000) goto L25;
    L23:
        r10 = null;
    L19:
        r5 = false;
    L10:
        r2 = false;
        goto L11
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        int r14 = Companion.a(r13);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L29
        m<Integer, Integer> r1 = addShadowFrameIfNeeded(r11, r12);     // Catch: Exception -> L29
        if (this.mGetLocationInWindow == false) goto L6;
    L9:
        boolean r2 = true;
    L10:
        this.useWindowCoords = r2;     // Catch: Exception -> L29
        if (r10 != null) goto L13;
        x r3 = null;
    L18:
        if (r3 != null) goto L20;
        OPopover r4 = (OPopover) ZeusTransformUtils.preCheckCast(this, OPopover.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        r4.setPopoverAnchorCenterX(Float.NaN);     // Catch: Exception -> L29
        r4.setPopoverAnchorCenterY(Float.NaN);     // Catch: Exception -> L29
    L20:
        super.showAsDropDown(r10, r11 - ((Number) ZeusTransformUtils.preCheckCast(r1.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), r12 - ((Number) ZeusTransformUtils.preCheckCast(r1.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), r14);     // Catch: Exception -> L29
        afterShowInStackIfNeeded();     // Catch: Exception -> L29
        this.mIsFirstShow = false;     // Catch: Exception -> L29
        int[] r15 = new int[2];     // Catch: Exception -> L29
        if (this.useWindowCoords == false) goto L23;
        getContentView().getLocationInWindow(r15);     // Catch: Exception -> L29
    L24:
        setPopoverPopupOriginX(r15[0]);     // Catch: Exception -> L29
        setPopoverPopupOriginY(r15[1]);     // Catch: Exception -> L29
        this.isAlreadyDismiss = false;     // Catch: Exception -> L29
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L27;
        playPopoverEnterAnimationInternal();     // Catch: Exception -> L29
        return;
    L27:
        showPopoverWithoutAnimationInternal();     // Catch: Exception -> L29
        return;
    L23:
        getContentView().getLocationOnScreen(r15);     // Catch: Exception -> L29
        goto L24
    L13:
        int[] r6 = new int[2];     // Catch: Exception -> L29
        if (r2 == false) goto L16;
        r10.getLocationInWindow(r6);     // Catch: Exception -> L29
    L17:
        setPopoverAnchorCenterX(r6[0] + (r10.getWidth() / 2.0f));     // Catch: Exception -> L29
        setPopoverAnchorCenterY(r6[1] + (r10.getHeight() / 2.0f));     // Catch: Exception -> L29
        r3 = x.f38692a;     // Catch: Exception -> L29
        goto L18
    L16:
        r10.getLocationOnScreen(r6);     // Catch: Exception -> L29
        goto L17
    L6:
        if (this.mIsShowInDialog == true) goto L9;
        r2 = false;
    L29:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "showAsDropDown, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
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
        View r0 = getContentView();
        o.c(r0, "contentView");
        measurePopoverContent(r0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final void onDestroy() {
        cancelPopoverAnimatorInternal();
        clearFakeAnchorViewIfNecessary();
        onDestroyInStackIfNeeded();
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.oui.window.a.f36851a.getActivity(this.mContext), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L14:
        super.dismiss();     // Catch: Exception -> L13
        return;
    L16:
        return;
    L5:
        if (r0.isFinishing() == true) goto L9;
        if (isShowing() == true) goto L14;
    L9:
        if (shouldForceDismiss == true) goto L14;
    }

    public final int getMeasuredHeight() {
        if (this.mIsFirstShow == false) goto L6;
        measure();
        return getContentView().getMeasuredHeight();
    L6:
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L10;
        o.c("mOBubbleLayout");
        r1 = null;
    L10:
        return r1.getMeasuredHeight();
    }

    public final int getMeasuredWidth() {
        if (this.mIsFirstShow == false) goto L6;
        measure();
        return getContentView().getMeasuredWidth();
    L6:
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L10;
        o.c("mOBubbleLayout");
        r1 = null;
    L10:
        return r1.getMeasuredWidth();
    }

    public final View getPopoverView() {
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L6;
        o.c("mOBubbleLayout");
        r2 = null;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    public final void setMaxContentHeight(int r3) {
        if (this.mOBubbleLayout == null) goto L8;
        if (r3 <= 0) goto L9;
        View r0 = getContentView();
        o.c(r0, "contentView");
        setPopoverMaxContentHeight(r3, r0, Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: mDismissRunnable$lambda-3, reason: not valid java name */
    private static final void m1136mDismissRunnable$lambda3(OPopover r1) {
        o.e(r1, "this$0");
        if (r1.enableAutoDismiss == false) goto L6;
        r1.dismiss();
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isAlreadyDismiss == false) goto L5;
        return;
    L5:
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L7;
        playPopoverExitAnimationInternal();
    L8:
        getContentView().removeCallbacks(this.mDismissRunnable);
        setPopoverXOffset(0);
        setPopoverYOffset(0);
        return;
    L7:
        finishPopoverDismissInternal();
        goto L8
    }

    public final void setEnableAutoDismiss(boolean r1) {
        this.enableAutoDismiss = r1;
    }

    public final void dismissDirectly() {
        if (this.isAlreadyDismiss == true) goto L9;
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L7;
        o.c("mWindowFrame");
        r0 = null;
    L7:
        r0.setVisibility(8);
        finishPopoverDismissInternal();
        getContentView().removeCallbacks(this.mDismissRunnable);
        setPopoverXOffset(0);
        setPopoverYOffset(0);
        return;
    }

    @Override // com.obric.oui.popover.v2.b
    public void onPopoverShownInternal() {
        setAnimationStyle(0);
        d r1 = this.mShowListener;
        if (r1 == null) goto L7;
        r1.a();
        return;
    }

    @Override // com.obric.oui.popover.v2.b
    public int resolvePopoverAnimationGravityInternal() {
        return getPopoverGravity();
    }

    @Override // com.obric.oui.popover.v2.b
    public void onPopoverStartDismissInternal() {
        setAnimationStyle(0);
        this.isAlreadyDismiss = true;
        e r1 = this.mStartDismissListener;
        if (r1 == null) goto L7;
        r1.a();
        return;
    }

    public void playPopoverEnterAnimationInternal() {
        setAnimationStyle(0);
        com.obric.oui.popover.v2.b.C0977b.j((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    public void playPopoverExitAnimationInternal() {
        setAnimationStyle(0);
        com.obric.oui.popover.v2.b.C0977b.k((com.obric.oui.popover.v2.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.popover.v2.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public void finishPopoverDismissInternal() {
        setPopoverAnimator(null);
        c r0 = this.mDismissListener;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        onDestroy();
    }

    private final void clearFakeAnchorViewIfNecessary() {
        if (this.mActivity != null) goto L5;
        return;
    L5:
        com.obric.oui.d.h r0 = com.obric.oui.d.h.f35017a;
        Activity r4 = this.mActivity;
        o.a(r4);
        ViewGroup r5 = r0.a(r4);
        if (r5 == null) goto L18;
        j<View> r1 = ab.b(r5);
        if (r1 == null) goto L20;
        j r2 = d.n.m.a(r1, (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f36036a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (r2 == null) goto L21;
        Iterator r3 = r2.a();
    L16:
        if (r3.hasNext() == false) goto L22;
        r5.removeView((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.aiagent.plugin"));
        com.obric.oui.d.a.b.b(TAG, "remove fake anchor view");
        goto L16
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    private final m<Integer, Integer> addShadowFrameIfNeeded(int r2, int r3) {
        if (this.mShadowEnabled == false) goto L6;
        return addShadowFrame(r2, r3);
    L6:
        return new m(0, 0);
    }

    private final float getElevationPx() {
        int r0 = this.mShadowStyle;
        if (r0 == 0) goto L16;
        float r1 = resolvePopoverShadowSpace(r0);
        if (r1 > 0.0f) goto L12;
        com.obric.oui.d.a.b r2 = com.obric.oui.d.a.b.f35007a;
        if (r2.a(8) == true) goto L10;
        r2.a().a(TAG, 8, o.a("surfaceInsets elevation resolved to 0, fallback to default. shadowStyleRes=", Integer.valueOf(access$getMShadowStyle$p(this))), null);
    L10:
        return 0.0f;
    L12:
        if (this.mSpacingForShadow == false) goto L15;
        return 0.0f;
    L15:
        return r1;
    L16:
        return 0.0f;
    }

    private final m<Integer, Integer> addShadowFrame(int r20, int r21) {
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
        setWidth(g.a(r3));
        return new m(Integer.valueOf(r20), Integer.valueOf(this.mShadowSpaceTop));
    L12:
        r6 = r2;
    L15:
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), null, "com.obric.aiagent.plugin");
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
        int r13 = this.mShadowStyle;
        if (r13 != 0) goto L32;
        r13 = ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Thick, "style", "OUIShadow_Oui_Shadow_Thick");
    L32:
        if (this.mSpacingForShadow == false) goto L34;
        com.obric.oui.popover.v2.b.c r14 = resolvePopoverShadowPadding(r13);
    L35:
        r14.a();
        int r15 = r14.b();
        r14.c();
        int r16 = r14.d();
        SingleChildFrameLayout r17 = new SingleChildFrameLayout(this.mContext, null, 2, null);
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r18, "contentView.context");
        r17.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(g.a(r18), -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r17.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r17.setClipChildren(false);
        r17.setClipToPadding(false);
        r17.setPadding(0, r15, 0, r16);
        r5.setX(r20);
        r17.setOnTouchListener(new $$Lambda$OPopover$oD6BKGUVT3ejE5vm1gsw4hmpi1w(this));
        this.mShadowSpaceTop = r15;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r17, ViewGroup.class, "com.obric.aiagent.plugin");
        this.mWindowFrame = r7;
        if (r7 != null) goto L38;
        o.c("mWindowFrame");
        r7 = null;
    L38:
        r7.setVisibility(4);
        ViewGroup r19 = this.mWindowFrame;
        if (r19 != null) goto L41;
        o.c("mWindowFrame");
    L42:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r22 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContentView().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r22, "contentView.context");
        setWidth(g.a(r22));
        return new m(Integer.valueOf(r20), Integer.valueOf(r15));
    L41:
        r6 = r19;
        goto L42
    L34:
        r14 = new com.obric.oui.popover.v2.b.c(0, 0, 0, 0, 15, null);
        goto L35
    }

    /* JADX INFO: renamed from: addShadowFrame$lambda-8, reason: not valid java name */
    private static final boolean m1134addShadowFrame$lambda8(OPopover r3, View r4, MotionEvent r5) {
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

    public final void setGravity(int r1) {
        setGravityInternal(r1);
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean isPopoverShowing() {
        return isShowing();
    }
}
