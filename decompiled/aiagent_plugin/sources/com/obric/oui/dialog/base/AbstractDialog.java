package com.obric.oui.dialog.base;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Looper;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.d.i;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: AbstractDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractDialog extends Dialog implements AlertDialogHost {
    public static final b Companion = null;
    public static final int HORIZONTAL_MAX_HEIGHT = 300;
    public static final int HORIZONTAL_MAX_WIDTH = 440;
    public static final int HORIZONTAL_TOP_SYSBAR_HEIGHT = 156;
    public static final int MSG_RECHECK_INSET = 101;
    public static final String TAG = "AbstractDialog";
    private final String TAG$1;
    private boolean adaptWindowDim;
    private int animExpectedHeight;
    private boolean autoDismissOnButtonClick;
    private int bgColor;
    private boolean cancelRestoreToWrapOnCancel;
    private ImageView closeIcon;
    private View closeIconContainer;
    private boolean closeIconEnabled;
    private a closeIconStyle;
    private DialogInterface.OnShowListener completeShowListener;
    protected View contentRootView;
    private View currentAnimContainer;
    private boolean enableLayoutHeightChangeAnim;
    private boolean enableMaterial;
    private Integer fixedWindowHeightPx;
    private final AbstractDialog$handler$1 handler;
    private boolean heightAnimProgrammaticChange;
    private boolean heightAnimRunning;
    private com.obric.common.oea.foundation.animation.manager.d heightAnimator;
    private final View.OnLayoutChangeListener heightLayoutChangeListener;
    private ViewTreeObserver.OnPreDrawListener heightPreDrawListener;
    private boolean hideFirstFrame;
    private boolean imeVisible;
    private Boolean includeCutoutInLandscape;
    private int insetsBaseYOffsetPx;
    private Integer lastAppliedWindowYPx;
    private final boolean matchParentHeight;
    private int maxRootViewHeightGap;
    private View.OnClickListener onCloseClickListener;
    private boolean pendingApplyWindowPosition;
    private c pendingHeightChange;
    private Integer pendingTargetHeightWhileAnimating;
    public View rootView;
    private boolean showAnimRunning;
    private final boolean widthMatch;
    private int windowGravity;
    private int windowLockedMinHeightPx;
    private int windowOffsetXPx;
    private int windowOffsetYPx;
    private Integer windowYAnimCurrentPx;
    private Integer windowYAnimTargetPx;
    private ValueAnimator windowYAnimator;

    /* JADX INFO: compiled from: AbstractDialog.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35063a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f35064b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f35065c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f35066d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f35063a, f35064b, f35065c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f35066d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35063a = new a("LIGHT", 0);
            f35064b = new a("DARK", 1);
            f35065c = new a("CUSTOM", 2);
            f35066d = a();
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f35067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f35069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f35070d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f35071e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f35067a, r6.f35067a) == true) goto L12;
            return false;
        L12:
            if (this.f35068b == r6.f35068b) goto L15;
            return false;
        L15:
            if (this.f35069c == r6.f35069c) goto L18;
            return false;
        L18:
            if (this.f35070d == r6.f35070d) goto L21;
            return false;
        L21:
            if (this.f35071e == r6.f35071e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f35067a.hashCode() * 31) + Integer.hashCode(this.f35068b)) * 31) + Integer.hashCode(this.f35069c)) * 31) + Integer.hashCode(this.f35070d)) * 31) + Integer.hashCode(this.f35071e);
        }

        public String toString() {
            return "HeightChange(container=" + this.f35067a + ", fromHeight=" + this.f35068b + ", toHeight=" + this.f35069c + ", rootFromHeight=" + this.f35070d + ", rootToHeight=" + this.f35071e + ')';
        }

        public c(View r2, int r3, int r4, int r5, int r6) {
            o.e(r2, "container");
            this.f35067a = r2;
            this.f35068b = r3;
            this.f35069c = r4;
            this.f35070d = r5;
            this.f35071e = r6;
        }

        public final View a() {
            return this.f35067a;
        }

        public final int b() {
            return this.f35068b;
        }

        public final int c() {
            return this.f35069c;
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35072a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f35064b.ordinal()] = 1;
            r0[a.f35063a.ordinal()] = 2;
            r0[a.f35065c.ordinal()] = 3;
            f35072a = r0;
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f35073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f35074b;

        e(Window r1, AbstractDialog r2) {
            this.f35073a = r1;
            this.f35074b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            WindowManager.LayoutParams r0 = this.f35073a.getAttributes();
            r0.gravity = AbstractDialog.access$getWindowGravity$p(this.f35074b);
            r0.x = AbstractDialog.access$getWindowOffsetXPx$p(this.f35074b);
            r0.y = this.f35074b.getInsetsBaseYOffsetPx() + AbstractDialog.access$getWindowOffsetYPx$p(this.f35074b);
            this.f35073a.setAttributes(r0);
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    static final class f extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f35075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f35076b;

        f(AbstractDialog r1, View r2) {
            this.f35075a = r1;
            this.f35076b = r2;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            o.e(r2, "$noName_0");
            o.e(r3, "value");
            o.e(r4, "$noName_2");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            AbstractDialog.access$setAnimExpectedHeight$p(this.f35075a, (int) r5);
            AbstractDialog r6 = this.f35075a;
            AbstractDialog.access$setContainerFixedHeight(r6, this.f35076b, AbstractDialog.access$getAnimExpectedHeight$p(r6));
        }
    }

    /* JADX INFO: compiled from: AbstractDialog.kt */
    static final class g extends p implements m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f35077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f35078b;

        g(AbstractDialog r1, View r2) {
            this.f35077a = r1;
            this.f35078b = r2;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r2, Throwable r3) {
            if (r2 == false) goto L11;
            Integer r4 = AbstractDialog.access$getPendingTargetHeightWhileAnimating$p(this.f35077a);
            AbstractDialog.access$setPendingTargetHeightWhileAnimating$p(this.f35077a, null);
            if (r4 != null) goto L6;
        L10:
            AbstractDialog.access$finishHeightAnim(this.f35077a, this.f35078b, true);
            return;
        L6:
            if (r4.intValue() <= 0) goto L10;
            int r5 = this.f35078b.getHeight();
            if (r4.intValue() == r5) goto L10;
            AbstractDialog r6 = this.f35077a;
            View r1 = this.f35078b;
            AbstractDialog.access$startHeightAnimator(r6, r1, r1.getHeight(), r4.intValue());
            return;
        L11:
            AbstractDialog r7 = this.f35077a;
            AbstractDialog.access$finishHeightAnim(r7, this.f35078b, AbstractDialog.access$getCancelRestoreToWrapOnCancel$p(r7));
        }
    }

    static {
        Companion = new b(null);
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m1009_init_$lambda1(View r0) {
    }

    /* JADX INFO: renamed from: lambda$15OBmUbLj3aJ58-5D5DDP-u5B0w, reason: not valid java name */
    public static /* synthetic */ void m1012lambda$15OBmUbLj3aJ585D5DDPu5B0w(AbstractDialog r0, View r1) {
        m1017setCloseIconEnabled$lambda18$lambda17(r0, r1);
    }

    public static /* synthetic */ void lambda$4EKykAO8rGgwDrUE5LTvDDAnIcc(AbstractDialog r0, c r1) {
        m1015prepareAndStartHeightAnim$lambda10(r0, r1);
    }

    public static /* synthetic */ boolean lambda$HZB4S28FsQtv6kplUoVn92gjt80(AbstractDialog r0) {
        return m1016scheduleHeightAnim$lambda8(r0);
    }

    public static /* synthetic */ void lambda$HurmCVxFpZLkis4tlvB1esPYK3I(AbstractDialog r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m1011heightLayoutChangeListener$lambda7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$JZsfAmIdAAge0UdxoSrTc-xCsUk, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1013lambda$JZsfAmIdAAge0UdxoSrTcxCsUk(AbstractDialog r0, View r1, WindowInsets r2) {
        return m1018setOnApplyWindowInsetsListener$lambda16(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$OLvMSQjaRsRlRL0yyPddYiMsKas(View r0) {
        m1009_init_$lambda1(r0);
    }

    public static /* synthetic */ void lambda$SZ1yv0nMBMGl15J3mUxor0Bl8Hk(AbstractDialog r0, View r1) {
        m1008_init_$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$h459XWc-KZxL6z9FhVo_A1RhKFc, reason: not valid java name */
    public static /* synthetic */ void m1014lambda$h459XWcKZxL6z9FhVo_A1RhKFc(Window r0, AbstractDialog r1, ValueAnimator r2, ValueAnimator r3) {
        m1010animateWindowYTo$lambda6$lambda5(r0, r1, r2, r3);
    }

    public final void applyCloseIconStyle(a r8) {
        o.e(r8, "style");
        applyCloseIconStyle$default(this, r8, null, null, 6, null);
    }

    public final void applyCloseIconStyle(a r8, Integer r9) {
        o.e(r8, "style");
        applyCloseIconStyle$default(this, r8, r9, null, 4, null);
    }

    public View getHeightChangeAnimContainer() {
        return null;
    }

    public abstract int getLayout();

    public /* synthetic */ AbstractDialog(Context r2, boolean r3, boolean r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        this(r7, r3, r4);
    }

    public static final /* synthetic */ void access$finishHeightAnim(AbstractDialog r0, View r1, boolean r2) {
        r0.finishHeightAnim(r1, r2);
    }

    public static final /* synthetic */ int access$getAnimExpectedHeight$p(AbstractDialog r0) {
        return r0.animExpectedHeight;
    }

    public static final /* synthetic */ boolean access$getCancelRestoreToWrapOnCancel$p(AbstractDialog r0) {
        return r0.cancelRestoreToWrapOnCancel;
    }

    public static final /* synthetic */ Integer access$getPendingTargetHeightWhileAnimating$p(AbstractDialog r0) {
        return r0.pendingTargetHeightWhileAnimating;
    }

    public static final /* synthetic */ int access$getWindowGravity$p(AbstractDialog r0) {
        return r0.windowGravity;
    }

    public static final /* synthetic */ int access$getWindowOffsetXPx$p(AbstractDialog r0) {
        return r0.windowOffsetXPx;
    }

    public static final /* synthetic */ int access$getWindowOffsetYPx$p(AbstractDialog r0) {
        return r0.windowOffsetYPx;
    }

    public static final /* synthetic */ void access$recheckInset(AbstractDialog r0) {
        r0.recheckInset();
    }

    public static final /* synthetic */ void access$setAnimExpectedHeight$p(AbstractDialog r0, int r1) {
        r0.animExpectedHeight = r1;
    }

    public static final /* synthetic */ void access$setContainerFixedHeight(AbstractDialog r0, View r1, int r2) {
        r0.setContainerFixedHeight(r1, r2);
    }

    public static final /* synthetic */ void access$setLastAppliedWindowYPx$p(AbstractDialog r0, Integer r1) {
        r0.lastAppliedWindowYPx = r1;
    }

    public static final /* synthetic */ void access$setPendingTargetHeightWhileAnimating$p(AbstractDialog r0, Integer r1) {
        r0.pendingTargetHeightWhileAnimating = r1;
    }

    public static final /* synthetic */ void access$setWindowYAnimCurrentPx$p(AbstractDialog r0, Integer r1) {
        r0.windowYAnimCurrentPx = r1;
    }

    public static final /* synthetic */ void access$setWindowYAnimTargetPx$p(AbstractDialog r0, Integer r1) {
        r0.windowYAnimTargetPx = r1;
    }

    public static final /* synthetic */ void access$setWindowYAnimator$p(AbstractDialog r0, ValueAnimator r1) {
        r0.windowYAnimator = r1;
    }

    public static final /* synthetic */ void access$startHeightAnimator(AbstractDialog r0, View r1, int r2, int r3) {
        r0.startHeightAnimator(r1, r2, r3);
    }

    public final boolean getWidthMatch() {
        return this.widthMatch;
    }

    public final boolean getMatchParentHeight() {
        return this.matchParentHeight;
    }

    /* JADX WARN: Type inference failed for: r13v4, types: [com.obric.oui.dialog.base.AbstractDialog$handler$1] */
    public AbstractDialog(Context r12, boolean r13, boolean r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        super(r15);
        this.widthMatch = r13;
        this.matchParentHeight = r14;
        this.TAG$1 = TAG;
        this.closeIconStyle = a.f35064b;
        this.autoDismissOnButtonClick = true;
        this.maxRootViewHeightGap = -1;
        this.animExpectedHeight = -1;
        this.cancelRestoreToWrapOnCancel = true;
        this.windowGravity = 81;
        Window r2 = getWindow();
        if (r2 == null) goto L6;
        r2.requestFeature(1);
    L6:
        Window r3 = getWindow();
        if (r3 == null) goto L11;
        r3.addFlags(512);
    L11:
        if (r14 == false) goto L13;
        setContentView(ZeusTransformUtils.mapRes(R.layout.o_base_dialog_with_match_parent_height, "layout", "o_base_dialog_with_match_parent_height"));
    L14:
        View r4 = findViewById(android.R.id.content);
        if (r4 == null) goto L18;
        r4.setOnClickListener(new $$Lambda$AbstractDialog$SZ1yv0nMBMGl15J3mUxor0Bl8Hk(this));
    L18:
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.root_view, DbHelper.COL_ID, "root_view"));
        o.c(r5, "findViewById(R.id.root_view)");
        setRootView(r5);
        getRootView().setOnClickListener($$Lambda$AbstractDialog$OLvMSQjaRsRlRL0yyPddYiMsKas.INSTANCE);
        if (ZeusTransformUtils.instanceOf(getRootView().getBackground(), ColorDrawable.class) == false) goto L22;
        Drawable r6 = getRootView().getBackground();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        this.bgColor = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r6, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor();
    L31:
        getRootView().setAlpha(0.0f);
        this.closeIcon = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_close, DbHelper.COL_ID, "btn_close")), ImageView.class, "com.obric.aiagent.plugin");
        this.closeIconContainer = findViewById(ZeusTransformUtils.mapRes(R.id.close_container, DbHelper.COL_ID, "close_container"));
        if (r14 == false) goto L34;
        View r16 = getRootView();
        ViewGroup.LayoutParams r7 = getRootView().getLayoutParams();
        r7.height = -1;
        r16.setLayoutParams(r7);
    L34:
        setCloseIconEnabled$default(this, this.closeIconEnabled, null, 2, null);
        ViewStub r17 = (ViewStub) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.contentView, DbHelper.COL_ID, "contentView")), ViewStub.class, "com.obric.aiagent.plugin");
        r17.setLayoutResource(getLayout());
        View r18 = r17.inflate();
        o.c(r18, "viewStub.inflate()");
        setContentRootView(r18);
        com.obric.oui.dialog.a.a.f35019a.a(getRootView());
        if (k.a(r15) == true) goto L37;
    L39:
        boolean r19 = false;
    L40:
        this.enableMaterial = r19;
        if (r19 == false) goto L52;
        getRootView().setBackgroundColor(0);
        com.obric.oui.material.c[] r110 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!i.a(getRootView()))), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        k.a(getRootView(), r110, false, null, 6, null);
        if (l.b(r15) != 1) goto L45;
    L46:
        com.obric.oui.color.e r111 = r110[0].e();
        if (r111 == null) goto L52;
        if (ZeusTransformUtils.instanceOf(getRootView(), DialogRootView.class) == false) goto L52;
        ((DialogRootView) ZeusTransformUtils.preCheckCast(getRootView(), DialogRootView.class, "com.obric.aiagent.plugin")).setStroke(r111.b(), com.obric.oui.common.util.g.b(r15, r111.a()));
        goto L52
    L45:
        if (r110.length == 1) goto L46;
    L52:
        this.heightLayoutChangeListener = new $$Lambda$AbstractDialog$HurmCVxFpZLkis4tlvB1esPYK3I(this);
        final Looper r112 = Looper.getMainLooper();
        this.handler = new AbstractDialog$handler$1(this, r112);
        return;
    L37:
        if (l.d() == false) goto L39;
        r19 = true;
        goto L40
    L22:
        if (ZeusTransformUtils.instanceOf(getRootView().getBackground(), GradientDrawable.class) == true) goto L24;
    L30:
        this.bgColor = 0;
        goto L31
    L24:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        Drawable r8 = getRootView().getBackground();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ColorStateList r9 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r8, GradientDrawable.class, "com.obric.aiagent.plugin")).getColor();
        if (r9 != null) goto L28;
        int r10 = 0;
    L29:
        this.bgColor = r10;
        goto L31
    L28:
        r10 = r9.getDefaultColor();
        goto L29
    L13:
        setContentView(ZeusTransformUtils.mapRes(R.layout.o_base_dialog, "layout", "o_base_dialog"));
        goto L14
    }

    public final View getRootView() {
        View r0 = this.rootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("rootView");
        return null;
    }

    public final void setRootView(View r2) {
        o.e(r2, "<set-?>");
        this.rootView = r2;
    }

    public final View getContentRootView() {
        View r0 = this.contentRootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentRootView");
        return null;
    }

    public final void setContentRootView(View r2) {
        o.e(r2, "<set-?>");
        this.contentRootView = r2;
    }

    public final boolean getHideFirstFrame() {
        return this.hideFirstFrame;
    }

    public final void setHideFirstFrame(boolean r1) {
        this.hideFirstFrame = r1;
    }

    public final boolean getAdaptWindowDim() {
        return this.adaptWindowDim;
    }

    public final void setAdaptWindowDim(boolean r1) {
        this.adaptWindowDim = r1;
    }

    public final int getMaxRootViewHeightGap() {
        return this.maxRootViewHeightGap;
    }

    public final void setMaxRootViewHeightGap(int r1) {
        this.maxRootViewHeightGap = r1;
    }

    public final boolean getEnableLayoutHeightChangeAnim() {
        return this.enableLayoutHeightChangeAnim;
    }

    public final void setEnableLayoutHeightChangeAnim(boolean r1) {
        this.enableLayoutHeightChangeAnim = r1;
    }

    public final boolean getShowAnimRunning() {
        return this.showAnimRunning;
    }

    public final void setShowAnimRunning(boolean r1) {
        this.showAnimRunning = r1;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.completeShowListener;
    }

    public final void setCompleteShowListener(DialogInterface.OnShowListener r3) {
        this.completeShowListener = (DialogInterface.OnShowListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnShowListener.class, "com.obric.aiagent.plugin");
    }

    public final Integer getFixedWindowHeightPx() {
        return this.fixedWindowHeightPx;
    }

    public final void setFixedWindowHeightPx(Integer r1) {
        this.fixedWindowHeightPx = r1;
    }

    public final int getInsetsBaseYOffsetPx() {
        return this.insetsBaseYOffsetPx;
    }

    public final void setInsetsBaseYOffsetPx(int r1) {
        this.insetsBaseYOffsetPx = r1;
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m1008_init_$lambda0(AbstractDialog r0, View r1) {
        o.e(r0, "this$0");
        r0.dismiss();
    }

    public final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return i.a(getRootView());
    L7:
        return com.obric.oui.color.d.a(r0);
    }

    public final void setRootHeightChangeAnimEnabled(boolean r1) {
        this.enableLayoutHeightChangeAnim = r1;
        if (r1 == true) goto L6;
        cleanupRootHeightAnim();
        return;
    }

    public final AbstractDialog setWindowFixedHeight(int r3) {
        Integer r4 = Integer.valueOf(r3);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r4 = null;
    L9:
        this.fixedWindowHeightPx = r4;
        applyWindowHeightIfNeeded();
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public final AbstractDialog setWindowGravity(int r1) {
        this.windowGravity = r1;
        applyWindowPositionIfNeeded();
        return this;
    }

    public static /* synthetic */ AbstractDialog setWindowOffset$default(AbstractDialog r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = 0;
    L10:
        return r1.setWindowOffset(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWindowOffset");
    }

    public final AbstractDialog setWindowOffset(int r1, int r2) {
        this.windowOffsetXPx = r1;
        this.windowOffsetYPx = r2;
        applyWindowPositionIfNeeded();
        return this;
    }

    public static /* synthetic */ AbstractDialog setWindowOffsetDp$default(AbstractDialog r1, int r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = 0;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = 0;
    L10:
        return r1.setWindowOffsetDp(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWindowOffsetDp");
    }

    public final AbstractDialog setWindowOffsetDp(int r5, int r6) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        int r7 = com.obric.oui.common.util.g.a(r0, r5);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        return setWindowOffset(r7, com.obric.oui.common.util.g.a(r1, r6));
    }

    public final AbstractDialog setIncludeCutoutInLandscape(Boolean r1) {
        this.includeCutoutInLandscape = r1;
        return this;
    }

    private final void applyWindowPositionIfNeeded() {
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r0, this), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
    }

    private final void applyWindowGravityAndXIfNeeded() {
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        WindowManager.LayoutParams r1 = r0.getAttributes();
        if (r1.gravity == this.windowGravity) goto L8;
    L10:
        r1.gravity = this.windowGravity;
        r1.x = this.windowOffsetXPx;
        r0.setAttributes(r1);
        return;
    L8:
        if (r1.x != this.windowOffsetXPx) goto L10;
    }

    public final void animateWindowYTo(final int r6) {
        final Window r0 = getWindow();
        if (r0 != null) goto L6;
        return;
    L6:
        if (isShowing() == true) goto L9;
        this.pendingApplyWindowPosition = true;
        return;
    L9:
        Integer r1 = this.windowYAnimCurrentPx;
        if (r1 != null) goto L14;
        r1 = this.lastAppliedWindowYPx;
        if (r1 != null) goto L14;
        int r2 = r0.getAttributes().y;
    L15:
        if (r2 != r6) goto L24;
        ValueAnimator r3 = this.windowYAnimator;
        if (r3 == null) goto L20;
        r3.cancel();
    L20:
        this.windowYAnimator = null;
        this.windowYAnimTargetPx = null;
        this.windowYAnimCurrentPx = Integer.valueOf(r6);
        this.lastAppliedWindowYPx = Integer.valueOf(r6);
        WindowManager.LayoutParams r5 = r0.getAttributes();
        if (r5.y == r6) goto L46;
        r5.y = r6;
        r0.setAttributes(r5);
        return;
    L46:
        return;
    L24:
        ValueAnimator r4 = this.windowYAnimator;
        if (r4 != null) goto L28;
    L26:
        boolean r7 = false;
    L30:
        if (r7 == false) goto L37;
        Integer r8 = this.windowYAnimTargetPx;
        if (r8 == null) goto L37;
        if (r8.intValue() != r6) goto L37;
        return;
    L37:
        ValueAnimator r9 = this.windowYAnimator;
        if (r9 == null) goto L41;
        r9.cancel();
    L41:
        this.windowYAnimTargetPx = Integer.valueOf(r6);
        final ValueAnimator r10 = ValueAnimator.ofInt(new int[]{r2, r6});
        r10.setDuration(200);
        r10.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(1.5f), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r10.addUpdateListener(new $$Lambda$AbstractDialog$h459XWcKZxL6z9FhVo_A1RhKFc(r0, this, r10));
        r10.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AbstractDialog$animateWindowYTo$1$2(this, r6), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        this.windowYAnimator = r10;
        if (r10 == null) goto L47;
        r10.start();
        return;
    L47:
        return;
    L28:
        if (r4.isRunning() != true) goto L26;
        r7 = true;
    L14:
        r2 = r1.intValue();
        goto L15
    }

    /* JADX INFO: renamed from: animateWindowYTo$lambda-6$lambda-5, reason: not valid java name */
    private static final void m1010animateWindowYTo$lambda6$lambda5(Window r1, AbstractDialog r2, ValueAnimator r3, ValueAnimator r4) {
        o.e(r1, "$w");
        o.e(r2, "this$0");
        o.e(r4, "it");
        if (r1.getDecorView().isAttachedToWindow() == false) goto L5;
        Object r5 = r4.getAnimatedValue();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.windowYAnimCurrentPx = Integer.valueOf(r6);
        WindowManager.LayoutParams r7 = r1.getAttributes();
        r7.y = r6;
        r1.setAttributes(r7);
        return;
    L5:
        r3.cancel();
    }

    private final void applyWindowHeightIfNeeded() {
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (this.matchParentHeight == false) goto L8;
        return;
    L8:
        Window r0 = getWindow();
        if (r0 != null) goto L11;
        return;
    L11:
        WindowManager.LayoutParams r1 = r0.getAttributes();
        Integer r2 = this.fixedWindowHeightPx;
        if (r2 == null) goto L20;
        if (r2.intValue() <= 0) goto L20;
        if (r1.height == r2.intValue()) goto L25;
        r1.height = r2.intValue();
        r0.setAttributes(r1);
        return;
    L25:
        return;
    L20:
        if (this.windowLockedMinHeightPx <= 0) goto L26;
        int r3 = r1.height;
        int r4 = this.windowLockedMinHeightPx;
        if (r3 == r4) goto L27;
        r1.height = r4;
        r0.setAttributes(r1);
        return;
    L27:
        return;
    }

    public void suppressHeightAnimContainerChildren(View r3, boolean r4) {
        o.e(r3, "container");
        if (Build.VERSION.SDK_INT < 29) goto L19;
        ViewGroup r1 = null;
        if (ZeusTransformUtils.instanceOf(r3, RadiusLayout.class) == false) goto L7;
        RadiusLayout r2 = (RadiusLayout) ZeusTransformUtils.preCheckCast(r3, RadiusLayout.class, "com.obric.aiagent.plugin");
    L8:
        if (r2 != null) goto L10;
        x r5 = null;
    L11:
        if (r5 == null) goto L13;
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L15;
        r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
    L15:
        if (r1 == null) goto L21;
        r1.suppressLayout(r4);
        return;
    L21:
        return;
    L10:
        r2.setSuppressChildMeasureAndLayout(r4);
        r5 = x.f38692a;
        goto L11
    L7:
        r2 = null;
        goto L8
    }

    /* JADX INFO: renamed from: heightLayoutChangeListener$lambda-7, reason: not valid java name */
    private static final void m1011heightLayoutChangeListener$lambda7(AbstractDialog r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        o.e(r0, "this$0");
        if (r0.enableLayoutHeightChangeAnim == true) goto L6;
        return;
    L6:
        if (r0.matchParentHeight == false) goto L9;
        return;
    L9:
        if (r0.heightAnimProgrammaticChange == false) goto L11;
        return;
    L11:
        int r10 = r5 - r3;
        int r11 = r9 - r7;
        if (r10 <= 0) goto L30;
        if (r11 <= 0) goto L31;
        if (r10 == r11) goto L32;
        int r12 = r10 - r11;
        int r13 = r0.getRootView().getHeight();
        if (r13 <= 0) goto L19;
        int r14 = Math.max(1, r13 - r12);
    L21:
        if (r0.heightAnimRunning == false) goto L28;
        int r15 = r0.animExpectedHeight;
        if (r15 <= 0) goto L26;
        if (r10 != r15) goto L26;
        return;
    L26:
        r0.pendingTargetHeightWhileAnimating = Integer.valueOf(r10);
        return;
    L28:
        o.c(r1, "v");
        r0.scheduleHeightAnim(new c(r1, r11, r10, r14, r13));
        return;
    L19:
        r14 = r13;
        goto L21
    L32:
        return;
    L31:
        return;
    }

    private final void setupRootHeightChangeAnimIfNeeded() {
        if (this.matchParentHeight == false) goto L5;
        return;
    L5:
        View r0 = getHeightChangeAnimContainer();
        if (r0 != null) goto L8;
        return;
    L8:
        r0.removeOnLayoutChangeListener(this.heightLayoutChangeListener);
        r0.addOnLayoutChangeListener(this.heightLayoutChangeListener);
    }

    private final void scheduleHeightAnim(c r2) {
        this.pendingHeightChange = r2;
        if (this.heightPreDrawListener != null) goto L5;
        this.heightPreDrawListener = new $$Lambda$AbstractDialog$HZB4S28FsQtv6kplUoVn92gjt80(this);
    L5:
        ViewTreeObserver.OnPreDrawListener r1 = this.heightPreDrawListener;
        if (r1 == null) goto L13;
        ViewTreeObserver r3 = r2.a().getViewTreeObserver();
        if (r3.isAlive() == false) goto L12;
        r3.removeOnPreDrawListener(r1);
        r3.addOnPreDrawListener(r1);
        return;
    L12:
        return;
    }

    /* JADX INFO: renamed from: scheduleHeightAnim$lambda-8, reason: not valid java name */
    private static final boolean m1016scheduleHeightAnim$lambda8(AbstractDialog r5) {
        o.e(r5, "this$0");
        c r0 = r5.pendingHeightChange;
        r5.pendingHeightChange = null;
        if (r0 != null) goto L5;
        View r2 = null;
    L6:
        if (r2 != null) goto L8;
        r2 = r5.getHeightChangeAnimContainer();
    L8:
        if (r2 != null) goto L10;
        ViewTreeObserver r3 = null;
    L11:
        ViewTreeObserver.OnPreDrawListener r4 = r5.heightPreDrawListener;
        if (r4 == null) goto L17;
        if (r3 == null) goto L17;
        if (r3.isAlive() == false) goto L17;
        r3.removeOnPreDrawListener(r4);
    L17:
        r5.heightPreDrawListener = null;
        if (r0 != null) goto L21;
        return true;
    L21:
        if (r5.isShowing() == true) goto L23;
        return true;
    L23:
        r5.prepareAndStartHeightAnim(r0);
        return false;
    L10:
        r3 = r2.getViewTreeObserver();
        goto L11
    L5:
        r2 = r0.a();
        goto L6
    }

    private final void prepareAndStartHeightAnim(final c r3) {
        if (r3.b() > 0) goto L5;
        return;
    L5:
        if (r3.c() > 0) goto L7;
        return;
    L7:
        if (r3.b() == r3.c()) goto L13;
        cancelHeightAnimatorIfNeeded(false);
        this.heightAnimRunning = true;
        this.animExpectedHeight = r3.b();
        this.currentAnimContainer = r3.a();
        suppressInternalLayout(r3.a(), true);
        setContainerFixedHeight(r3.a(), r3.b());
        r3.a().requestLayout();
        r3.a().post(new $$Lambda$AbstractDialog$4EKykAO8rGgwDrUE5LTvDDAnIcc(this, r3));
        return;
    }

    /* JADX INFO: renamed from: prepareAndStartHeightAnim$lambda-10, reason: not valid java name */
    private static final void m1015prepareAndStartHeightAnim$lambda10(AbstractDialog r2, c r3) {
        o.e(r2, "this$0");
        o.e(r3, "$change");
        r2.startHeightAnimator(r3.a(), r3.b(), r3.c());
    }

    private final void startHeightAnimator(View r9, int r10, int r11) {
        if (this.enableLayoutHeightChangeAnim == true) goto L5;
        return;
    L5:
        if (this.matchParentHeight == false) goto L8;
        return;
    L8:
        if (isShowing() == true) goto L11;
        return;
    L11:
        if (r10 != r11) goto L14;
        finishHeightAnim(r9, true);
        return;
    L14:
        this.heightAnimRunning = true;
        this.pendingTargetHeightWhileAnimating = null;
        this.currentAnimContainer = r9;
        com.obric.common.oea.foundation.animation.a.d.a r1 = new com.obric.common.oea.foundation.animation.a.d.a();
        float r2 = r10;
        float r3 = r11;
        com.obric.common.oea.foundation.animation.g.a.b r12 = com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.f, 0, 4, null);
        r12.a(0.3f);
        x r13 = x.f38692a;
        this.heightAnimator = com.obric.common.oea.foundation.animation.a.d.a.a(r1, r2, r3, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new f(this, r9), q.class, "com.obric.aiagent.plugin")).a((m) ZeusTransformUtils.preCheckCast(new g(this, r9), m.class, "com.obric.aiagent.plugin")).a().a();
    }

    private final void cancelHeightAnimatorIfNeeded(boolean r4) {
        com.obric.common.oea.foundation.animation.manager.d r0 = this.heightAnimator;
        if (r0 == null) goto L7;
        this.cancelRestoreToWrapOnCancel = r4;
        com.obric.common.oea.foundation.animation.manager.d.a(r0, false, 1, null);
        this.cancelRestoreToWrapOnCancel = true;
        this.heightAnimator = null;
        return;
    }

    private final void finishHeightAnim(View r3, boolean r4) {
        this.heightAnimRunning = false;
        this.animExpectedHeight = -1;
        this.currentAnimContainer = null;
        if (r4 == false) goto L5;
        this.heightAnimProgrammaticChange = true;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        r5.height = -2;
        r3.setLayoutParams(r5);
        this.heightAnimProgrammaticChange = false;
        r3.requestLayout();
    L5:
        suppressInternalLayout(r3, false);
    }

    private final void setContainerFixedHeight(View r2, int r3) {
        this.heightAnimProgrammaticChange = true;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.height = r3;
        r2.setLayoutParams(r0);
        this.heightAnimProgrammaticChange = false;
    }

    private final void suppressInternalLayout(View r1, boolean r2) {
        suppressHeightAnimContainerChildren(r1, r2);
    }

    private final void cleanupRootHeightAnim() {
        View r0 = this.currentAnimContainer;
        if (r0 != null) goto L5;
        r0 = getHeightChangeAnimContainer();
    L5:
        cancelHeightAnimatorIfNeeded(true);
        if (r0 != null) goto L8;
    L10:
        if (r0 == null) goto L12;
        suppressInternalLayout(r0, false);
    L12:
        this.pendingHeightChange = null;
        this.pendingTargetHeightWhileAnimating = null;
        View r1 = getHeightChangeAnimContainer();
        if (r1 != null) goto L15;
        ViewTreeObserver r3 = null;
    L16:
        ViewTreeObserver.OnPreDrawListener r4 = this.heightPreDrawListener;
        if (r1 == null) goto L23;
        if (r4 == null) goto L23;
        if (r3 == null) goto L23;
        if (r3.isAlive() == false) goto L23;
        r3.removeOnPreDrawListener(r4);
    L23:
        this.heightPreDrawListener = null;
        if (r1 == null) goto L28;
        r1.removeOnLayoutChangeListener(this.heightLayoutChangeListener);
    L28:
        if (this.fixedWindowHeightPx != null) goto L31;
        this.windowLockedMinHeightPx = 0;
        return;
    L31:
        return;
    L15:
        r3 = r1.getViewTreeObserver();
        goto L16
    L8:
        if (this.heightAnimRunning == false) goto L10;
        finishHeightAnim(r0, true);
        goto L12
    }

    private final void setOnApplyWindowInsetsListener() {
        getRootView().setOnApplyWindowInsetsListener(new $$Lambda$AbstractDialog$JZsfAmIdAAge0UdxoSrTcxCsUk(this));
    }

    /* JADX INFO: renamed from: setOnApplyWindowInsetsListener$lambda-16, reason: not valid java name */
    private static final WindowInsets m1018setOnApplyWindowInsetsListener$lambda16(AbstractDialog r12, View r13, WindowInsets r14) {
        o.e(r12, "this$0");
        o.e(r13, "v");
        o.e(r14, "insets");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        int r0 = r14.getInsets(WindowInsets.Type.ime()).bottom;
        int r2 = com.obric.oui.window.a.f36851a.a(r12.getRootView());
        com.obric.oui.d.a.b.c(r12.TAG$1, "onApplyWindowInsets-start, lastImeVisible: " + r12.imeVisible + ", nowImeVisible: " + r14.isVisible(WindowInsets.Type.ime()) + "，imeHeightFromInsets: " + r0 + ", imeHeightFromHideApi: " + r2);
    L5:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "v.context");
        boolean r3 = com.obric.oui.window.a.f(r1);
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f36851a;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "context");
        boolean r6 = r4.g(r5);
        com.obric.oui.window.a r7 = com.obric.oui.window.a.f36851a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "context");
        boolean r9 = r7.c(r8);
        boolean r10 = true;
        if (r9 == true) goto L10;
        if (r6 == true) goto L10;
        boolean r11 = false;
    L11:
        if (r11 == false) goto L13;
        int r15 = 0;
    L14:
        if (r3 == true) goto L18;
        if (r11 == true) goto L18;
        r10 = false;
    L18:
        int r16 = r12.getLayoutMarginBottom(r10);
        if (r10 == true) goto L22;
        r16 = Math.max(r16, r15);
    L22:
        int r17 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin_to_ime, "dimen", "oui_dialog_layout_margin_to_ime"));
        View r18 = r12.getRootView();
        ViewGroup.LayoutParams r19 = r12.getRootView().getLayoutParams();
        com.obric.oui.d.a.b.a(r12.TAG$1, "onApplyWindowInsets, bottomMargin: " + r16 + " systemBarHeight: " + r15);
        if (ZeusTransformUtils.instanceOf(r19, ViewGroup.MarginLayoutParams.class) == false) goto L25;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L26:
        if (r20 == null) goto L29;
        r20.bottomMargin = r16;
    L29:
        r18.setLayoutParams(r19);
        if (Build.VERSION.SDK_INT < 30) goto L47;
        boolean r21 = r14.isVisible(WindowInsets.Type.ime());
        if (r12.imeVisible == r21) goto L47;
        r12.imeVisible = r21;
        int r22 = Math.max(r14.getInsets(WindowInsets.Type.ime()).bottom, com.obric.oui.window.a.f36851a.a(r12.getRootView()));
        com.obric.oui.d.a.b.a(r12.TAG$1, "onApplyWindowInsets, systemBarHeight: " + r15 + ", imeHeight: " + r22);
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r23, "context");
        if (r22 >= com.obric.oui.common.util.g.b(r23)) goto L47;
        if (r22 > 0) goto L38;
        r12.insetsBaseYOffsetPx = 0;
        if (r12.widthMatch == false) goto L44;
        Context r110 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r110, "context");
        int r24 = r15 - com.obric.oui.common.util.g.a(r110, 16);
        r12.getRootView().setPadding(0, 0, 0, r24);
        com.obric.oui.d.a.b.a(r12.TAG$1, o.a("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r24)));
    L45:
        r12.animateWindowYTo(r12.insetsBaseYOffsetPx + r12.windowOffsetYPx);
        goto L47
    L44:
        com.obric.oui.d.a.b.a(r12.TAG$1, o.a("onApplyWindowInsets, update, insetsBaseYOffsetPx: ", Integer.valueOf(r15)));
        goto L45
    L38:
        if (r12.widthMatch == false) goto L40;
        r13.setPadding(0, 0, 0, r22);
        com.obric.oui.d.a.b.a(r12.TAG$1, o.a("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r22)));
        r12.insetsBaseYOffsetPx = 0;
        goto L45
    L40:
        r12.insetsBaseYOffsetPx = (r22 - r16) + r17;
        com.obric.oui.d.a.b.a(r12.TAG$1, o.a("onApplyWindowInsets, update, insetsBaseYOffsetPx: ", Integer.valueOf(r22)));
    L47:
        return r14.consumeSystemWindowInsets();
    L25:
        r20 = null;
        goto L26
    L13:
        r15 = com.obric.oui.window.a.f36851a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L10:
        r11 = true;
        goto L11
    }

    private final void recheckInset() {
    L21:
        e = move-exception;
        com.obric.oui.d.a.b.b(this.TAG$1, "recheckInset failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L6;
        int r1 = com.obric.oui.window.a.f36851a.a(getRootView());     // Catch: Exception -> L21
    L7:
        if (r1 <= 0) goto L9;
        return;
    L9:
        if (this.widthMatch == false) goto L27;
        com.obric.oui.d.c r2 = com.obric.oui.d.c.f35012a;     // Catch: Exception -> L21
        ViewParent r3 = getRootView().getParent();     // Catch: Exception -> L21
        if (r3 != null) goto L14;
    L12:
        r3 = null;
    L15:
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L21
        if (r4 != null) goto L18;
        return;
    L18:
        if (r4.getHeight() <= getRootView().getHeight()) goto L29;
        getRootView().requestLayout();     // Catch: Exception -> L21
        com.obric.oui.d.a.b.a(this.TAG$1, "recheckInset, requestLayout, parentView.height: " + r4.getHeight() + ", rootView.height: " + getRootView().getHeight());     // Catch: Exception -> L21
        return;
    L29:
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L12;
    L27:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        removeCallbacksAndMessages(null);
        cleanupRootHeightAnim();
    }

    public static /* synthetic */ void setCloseIconEnabled$default(AbstractDialog r2, boolean r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r7 = null;
    L7:
        r2.setCloseIconEnabled(r3, r7);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    public void setCloseIconEnabled(boolean r7, View.OnClickListener r8) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.closeIconEnabled = r7;
        this.onCloseClickListener = r9;
        ImageView r10 = this.closeIcon;
        if (r10 == null) goto L21;
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        com.obric.oui.common.util.k.a(r11, com.obric.oui.common.util.g.a(r0, 44));
        if (r7 == false) goto L15;
        View r12 = this.closeIconContainer;
        if (r12 == null) goto L11;
        com.obric.oui.common.util.k.a(r12);
    L11:
        applyCloseIconStyle$default(this, this.closeIconStyle, null, null, 6, null);
        View r13 = this.closeIconContainer;
        if (r13 == null) goto L22;
        r13.setOnClickListener(new $$Lambda$AbstractDialog$15OBmUbLj3aJ585D5DDPu5B0w(this));
        return;
    L22:
        return;
    L15:
        View r6 = this.closeIconContainer;
        if (r6 == null) goto L23;
        com.obric.oui.common.util.k.b(r6);
        return;
    L23:
        return;
    }

    /* JADX INFO: renamed from: setCloseIconEnabled$lambda-18$lambda-17, reason: not valid java name */
    private static final void m1017setCloseIconEnabled$lambda18$lambda17(AbstractDialog r1, View r2) {
        o.e(r1, "this$0");
        r1.dismiss();
        View.OnClickListener r3 = r1.onCloseClickListener;
        if (r3 == null) goto L7;
        r3.onClick(r2);
        return;
    }

    public static /* synthetic */ void applyCloseIconStyle$default(AbstractDialog r1, a r2, Integer r3, Integer r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.applyCloseIconStyle(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    public final void applyCloseIconStyle(a r4, Integer r5, Integer r6) {
        o.e(r4, "style");
        if (this.closeIconEnabled == false) goto L38;
        int r7 = d.f35072a[r4.ordinal()];
        if (r7 != 1) goto L7;
        int r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, "color", "ConstTextInverse");
        r6 = Integer.valueOf(ZeusTransformUtils.mapRes(R.color.ConstBGContainer7, "color", "ConstBGContainer7"));
    L17:
        ImageView r9 = this.closeIcon;
        if (r9 == null) goto L21;
        r9.setImageTintList(androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8));
    L21:
        GradientDrawable r10 = null;
        if (r6 != null) goto L27;
        View r3 = this.closeIconContainer;
        if (r3 == null) goto L40;
        r3.setBackground(null);
        return;
    L40:
        return;
    L27:
        View r11 = this.closeIconContainer;
        if (r11 != null) goto L30;
        Drawable r12 = null;
    L32:
        if (ZeusTransformUtils.instanceOf(r12, GradientDrawable.class) == false) goto L34;
        r10 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r12, GradientDrawable.class, "com.obric.aiagent.plugin");
    L34:
        if (r10 == null) goto L41;
        r10.setColor(androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6.intValue()));
        return;
    L41:
        return;
    L30:
        r12 = r11.getBackground();
        goto L32
    L7:
        if (r7 != 2) goto L9;
        r8 = ZeusTransformUtils.mapRes(R.color.TextReverse, "color", "TextReverse");
        r6 = Integer.valueOf(ZeusTransformUtils.mapRes(R.color.ConstTextInverse5, "color", "ConstTextInverse5"));
        goto L17
    L9:
        if (r7 != 3) goto L14;
        if (r5 != null) goto L12;
        r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, "color", "ConstTextInverse");
        goto L17
    L12:
        r8 = r5.intValue();
        goto L17
    L14:
        throw new d.k();
    }

    @Override // android.app.Dialog
    public void show() {
        setOnApplyWindowInsetsListener();
        super.show();
        setupRootHeightChangeAnimIfNeeded();
        applyWindowHeightIfNeeded();
        Window r0 = getWindow();
        if (r0 == null) goto L61;
        if (getShowAnimRunning() == false) goto L8;
        return;
    L8:
        r0.setBackgroundDrawableResource(android.R.color.transparent);
        Window r2 = getWindow();
        if (r2 == null) goto L13;
        r2.setWindowAnimations(0);
    L13:
        if (getAdaptWindowDim() == false) goto L18;
        Window r3 = getWindow();
        if (r3 == null) goto L19;
        r3.clearFlags(2);
    L19:
        hideAndTransparentNavigationBar(r0);
        WindowManager.LayoutParams r4 = r0.getAttributes();
        r4.gravity = this.windowGravity;
        r4.x = this.windowOffsetXPx;
        r4.y = getInsetsBaseYOffsetPx() + this.windowOffsetYPx;
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        RadiusLayout r7 = null;
        if (getMatchParentHeight() == false) goto L22;
        r4.height = -1;
    L36:
        if (getWidthMatch() == false) goto L50;
        View r5 = getRootView();
        ViewGroup.LayoutParams r6 = getRootView().getLayoutParams();
        r6.width = -1;
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L40;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L41:
        if (r8 == null) goto L44;
        r8.bottomMargin = 0;
    L44:
        r5.setLayoutParams(r6);
        View r9 = getRootView();
        if (ZeusTransformUtils.instanceOf(r9, RadiusLayout.class) == false) goto L47;
        r7 = (RadiusLayout) ZeusTransformUtils.preCheckCast(r9, RadiusLayout.class, "com.obric.aiagent.plugin");
    L47:
        if (r7 == null) goto L56;
        float r10 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3, "dimen", "oui_r_l3"));
        r7.setRadius(r10, r10, 0.0f, 0.0f);
    L56:
        if (getAdaptWindowDim() == false) goto L58;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r11, "context");
        r4.dimAmount = getTargetWindowDimAmount(r11);
    L59:
        com.obric.oui.window.a r12 = com.obric.oui.window.a.f36851a;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r13, "context");
        Context r14 = (Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getActivity(r13), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "params");
        com.obric.oui.window.a.a(r14, r4, this.includeCutoutInLandscape);
        r0.setAttributes(r4);
        goto L61
    L58:
        r4.dimAmount = 0.0f;
        goto L59
    L40:
        r8 = null;
        goto L41
    L50:
        Size r15 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r16 = Math.min(r15.getWidth(), r15.getHeight()) - (getLayoutMarginHorizontal(r0) * 2);
        View r17 = getRootView();
        ViewGroup.LayoutParams r18 = getRootView().getLayoutParams();
        r18.width = r16;
        r17.setLayoutParams(r18);
        getRootView().measure(View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE), 0);
        if (r15.getWidth() >= r15.getHeight()) goto L56;
        int r19 = r15.getHeight();
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r20, "context");
        int r21 = r19 - com.obric.oui.common.util.g.a(r20, 232);
        if (getRootView().getMeasuredHeight() <= r21) goto L56;
        setMaxRootViewHeightGap(getRootView().getMeasuredHeight() - r21);
        goto L56
    L22:
        Integer r22 = getFixedWindowHeightPx();
        if (r22 != null) goto L33;
        r22 = Integer.valueOf(this.windowLockedMinHeightPx);
        if (((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L27;
        boolean r23 = true;
    L28:
        if (r23 == true) goto L31;
        r22 = null;
    L31:
        if (r22 != null) goto L33;
        int r24 = -2;
    L34:
        r4.height = r24;
        goto L36
    L27:
        r23 = false;
    L33:
        r24 = r22.intValue();
        goto L34
    L18:
        r0.addFlags(2);
    L61:
        if (this.pendingApplyWindowPosition == false) goto L63;
        applyWindowPositionIfNeeded();
    L63:
        this.showAnimRunning = true;
    }

    private final void hideAndTransparentNavigationBar(Window r3) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r3 == null) goto L7;
        r3.setNavigationBarContrastEnforced(false);
    L7:
        if (r3 == null) goto L10;
        r3.clearFlags(134217728);
    L10:
        if (r3 == null) goto L13;
        r3.addFlags(Integer.MIN_VALUE);
    L13:
        if (r3 == null) goto L17;
        r3.setNavigationBarColor(0);
    L17:
        if (Build.VERSION.SDK_INT < 30) goto L25;
        if (r3 == null) goto L21;
        r3.setDecorFitsSystemWindows(false);
    L21:
        if (r3 == null) goto L26;
        r3.setNavigationBarDividerColor(0);
        return;
    L26:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        getRootView().setOnApplyWindowInsetsListener(null);
        ValueAnimator r0 = this.windowYAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.showAnimRunning = false;
        super.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.obric.oui.d.a.b.b(this.TAG$1, "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final float getTargetWindowDimAmount(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        if ((ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r3 = false;
        goto L6
    }

    public int getLayoutMarginHorizontal(Window r3) {
        o.e(r3, "<this>");
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin, "dimen", "oui_dialog_layout_margin"));
    }

    private final int getLayoutMarginBottom(boolean r3) {
        if (r3 == false) goto L6;
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin, "dimen", "oui_dialog_layout_margin"));
    L6:
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin_with_three_button_mode, "dimen", "oui_dialog_layout_margin_with_three_button_mode"));
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }

    public final void adaptWindowDim() {
        this.adaptWindowDim = true;
    }

    public final void setAutoDismiss(boolean r1) {
        this.autoDismissOnButtonClick = r1;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.AlertDialogHost
    public boolean isAutoDismiss() {
        return this.autoDismissOnButtonClick;
    }
}
