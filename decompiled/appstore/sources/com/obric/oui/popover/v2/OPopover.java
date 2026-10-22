package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import td.h;

/* JADX INFO: loaded from: classes4.dex */
public class OPopover extends PopupWindow implements OPopoverBase {
    public static final b Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static boolean f16212a0;
    public int A;
    public int B;
    public boolean C;
    public Animator D;
    public Animator E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f16213J;
    public boolean K;
    public float L;
    public float M;
    public boolean N;
    public int O;
    public int P;
    public boolean Q;
    public int R;
    public float S;
    public float T;
    public boolean U;
    public boolean V;
    public final boolean W;
    public final Function1 X;
    public final Runnable Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f16219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16225l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16227n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f16228o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16229p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public OPopoverLayout f16230q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f16231r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16232s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AnimatorSet f16233t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Context f16234u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Activity f16235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f16236w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OnBubbleShowListener f16237x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OnBubbleStartDismissListener f16238y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OnBubbleDismissListener f16239z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleDismissListener {
        void bubbleDismiss();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleShowListener {
        void bubbleShow();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "", "bubbleStartDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleStartDismissListener {
        void bubbleStartDismiss();
    }

    public static final class a extends f {
        public a(Context r10) {
            q.g(r10, "context");
            super(r10);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final int a(int r10) {
            boolean r11 = false;
            if ((r10 & 8388611) != 8388611) goto L5;
            boolean r12 = true;
        L7:
            if ((r10 & 8388613) != 8388613) goto L9;
            r11 = true;
        L9:
            if (r12 == false) goto L11;
            r10 = ((-8388612) & r10) | 3;
        L11:
            if (r11 == true) goto L13;
            return r10;
        L13:
            return ((-8388614) & r10) | 5;
        L5:
            r12 = false;
            goto L7
        }

        public b() {
        }
    }

    static {
        Z = new b(null);
    }

    public OPopover(a r10) {
        q.g(r10, "builder");
        this.f16214a = r10.v();
        this.f16215b = r10.d();
        this.f16222i = 200;
        this.f16223j = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
        this.f16226m = true;
        this.f16228o = true;
        this.F = true;
        this.G = R$style.OUIShadow_Oui_Shadow_Regular;
        this.I = true;
        this.L = Float.NaN;
        this.M = Float.NaN;
        this.Q = true;
        this.R = Color.parseColor("#08000000");
        this.S = 0.3f;
        this.T = 0.98f;
        this.W = r10.l();
        this.X = r10.r();
        this.f16234u = r10.c();
        setPopoverGravity(r10.o());
        this.f16217d = r10.k();
        this.f16235v = wd.a.f25402a.b(this.f16234u);
        this.f16218e = r10.f();
        this.f16219f = Boolean.valueOf(r10.q());
        setPopoverXOffset(r10.D());
        setPopoverYOffset(r10.E());
        this.f16222i = r10.d();
        this.f16223j = r10.e();
        this.f16236w = r10.B();
        this.f16225l = r10.p();
        this.f16224k = r10.C();
        this.f16238y = r10.A();
        this.f16239z = r10.j();
        this.f16237x = r10.u();
        this.f16226m = r10.s();
        this.f16227n = r10.m();
        this.f16229p = r10.n();
        this.A = r10.h();
        this.B = r10.g();
        this.C = r10.G();
        this.F = r10.t();
        this.G = r10.F();
        this.H = r10.w();
        this.Q = r10.i();
        this.R = r10.y();
        this.S = r10.x();
        this.T = r10.z();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.f16227n);
        setOutsideTouchable(this.f16226m);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        o(requirePopoverContentView(this.f16236w));
        k();
        setFocusable(true);
        this.Y = new com.obric.oui.popover.v2.b(this);
    }

    public static /* synthetic */ void a(OPopover r10) {
        m(r10);
    }

    public static /* synthetic */ boolean b(OPopover r10, View r11, MotionEvent r12) {
        return e(r10, r11, r12);
    }

    public static final /* synthetic */ int c(OPopover r10) {
        return r10.G;
    }

    public static final boolean e(OPopover r10, View r11, MotionEvent r12) {
        q.g(r10, "this$0");
        if (r12.getAction() != 0) goto L12;
        h r13 = h.f24801a;
        OPopoverLayout r14 = r10.f16230q;
        if (r14 != null) goto L7;
        q.y("mOBubbleLayout");
        r14 = null;
    L7:
        q.f(r12, "event");
        if (r13.f(r14, r12) == false) goto L13;
        r10.dismiss();
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public static final void m(OPopover r10) {
        q.g(r10, "this$0");
        if (r10.f16228o == false) goto L6;
        r10.dismiss();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void afterShowInStackIfNeeded() {
        OPopoverBase.DefaultImpls.a(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void beforeShowInStackIfNeeded() {
        OPopoverBase.DefaultImpls.b(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void cancelPopoverAnimatorInternal() {
        OPopoverBase.DefaultImpls.c(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverLayout createPopoverBubbleLayout(View r10, int r11) {
        return OPopoverBase.DefaultImpls.d(this, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [android.widget.PopupWindow, com.obric.oui.popover.v2.OPopover] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View] */
    public final Pair d(int r19, int r20) {
        ?? r10 = 0;
        ViewGroup r11 = null;
        if (this.I == true) goto L15;
        ViewGroup r12 = this.f16231r;
        if (r12 != null) goto L8;
        q.y("mWindowFrame");
        r12 = null;
    L8:
        if ((r12 instanceof SingleChildFrameLayout) == false) goto L15;
        ViewGroup r13 = this.f16231r;
        if (r13 != null) goto L12;
        q.y("mWindowFrame");
    L13:
        r11.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r14 = getContentView().getContext();
        q.f(r14, "contentView.context");
        setWidth(tc.f.n(r14));
        return new Pair(Integer.valueOf(r19), Integer.valueOf(this.f16213J));
    L12:
        r11 = r13;
    L15:
        View r15 = LayoutInflater.from(this.f16234u).inflate(R$layout.o_layout_popover_shadow_frame, null);
        if (r15 == null) goto L44;
        SingleChildFrameLayout r16 = (SingleChildFrameLayout) r15;
        OPopoverLayout r17 = this.f16230q;
        if (r17 != null) goto L20;
        q.y("mOBubbleLayout");
        r17 = null;
    L20:
        r16.addView(r17, new FrameLayout.LayoutParams(-2, -2));
        OPopoverLayout r18 = this.f16230q;
        if (r18 != null) goto L23;
        q.y("mOBubbleLayout");
        r18 = null;
    L23:
        r16.setShadowCornerRadius(yf.b.b(r18.getCornerRadius()));
        OPopoverLayout r21 = this.f16230q;
        if (r21 != null) goto L26;
        q.y("mOBubbleLayout");
        r21 = null;
    L26:
        int r22 = r21.getArrowHeight();
        OPopoverLayout r23 = this.f16230q;
        if (r23 != null) goto L29;
        q.y("mOBubbleLayout");
        r23 = null;
    L29:
        r16.setShadowInsets(r22, r23.getArrowHeight());
        int r24 = this.G;
        if (r24 != 0) goto L34;
        r24 = R$style.OUIShadow_Oui_Shadow_Thick;
    L34:
        if (this.H == false) goto L36;
        OPopoverBase.b r25 = resolvePopoverShadowPadding(r24);
    L37:
        r25.b();
        int r26 = r25.d();
        r25.c();
        int r27 = r25.a();
        SingleChildFrameLayout r28 = new SingleChildFrameLayout(this.f16234u, r10, 2, r10);
        Context r110 = getContentView().getContext();
        q.f(r110, "contentView.context");
        r28.setLayoutParams(new ViewGroup.MarginLayoutParams(tc.f.n(r110), -2));
        r28.addView(r16, new FrameLayout.LayoutParams(-2, -2));
        r28.setClipChildren(false);
        r28.setClipToPadding(false);
        r28.setPadding(0, r26, 0, r27);
        r16.setX(r19);
        r28.setOnTouchListener(new com.obric.oui.popover.v2.a(this));
        this.f16213J = r26;
        this.f16231r = r28;
        r28.setVisibility(4);
        ViewGroup r29 = this.f16231r;
        if (r29 != null) goto L40;
        q.y("mWindowFrame");
    L41:
        setContentView(r10);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r30 = getContentView().getContext();
        q.f(r30, "contentView.context");
        setWidth(tc.f.n(r30));
        return new Pair(Integer.valueOf(r19), Integer.valueOf(r26));
    L40:
        r10 = r29;
        goto L41
    L36:
        r25 = new OPopoverBase.b(0, 0, 0, 0, 15, null);
        goto L37
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.f16232s == false) goto L5;
        return;
    L5:
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L7;
        playPopoverExitAnimationInternal();
    L8:
        getContentView().removeCallbacks(this.Y);
        setPopoverXOffset(0);
        setPopoverYOffset(0);
        return;
    L7:
        finishPopoverDismissInternal();
        goto L8
    }

    public final Pair f(int r10, int r11) {
        if (this.F == false) goto L6;
        return d(r10, r11);
    L6:
        return new Pair(0, 0);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void finishPopoverDismissInternal() {
        setPopoverAnimator(null);
        OnBubbleDismissListener r10 = this.f16239z;
        if (r10 == null) goto L6;
        r10.bubbleDismiss();
    L6:
        n();
    }

    public final void g() {
        Activity r10 = this.f16235v;
        if (r10 != null) goto L5;
        return;
    L5:
        h r11 = h.f24801a;
        q.d(r10);
        ViewGroup r12 = r11.d(r10);
        if (r12 == null) goto L18;
        Sequence r13 = ViewGroupKt.a(r12);
        if (r13 == null) goto L20;
        Sequence r14 = SequencesKt___SequencesKt.j(r13, OPopover$clearFakeAnchorViewIfNecessary$1.INSTANCE);
        if (r14 == null) goto L21;
        Iterator r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L22;
        r12.removeView((View) r15.next());
        L.a("OPopover", "remove fake anchor view");
        goto L16
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public View getContentViewInternal() {
        return OPopoverBase.DefaultImpls.f(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getDisplayRotationDegreesInternal() {
        return OPopoverBase.DefaultImpls.g(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterX() {
        return this.L;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterY() {
        return this.M;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public long getPopoverAnimationDurationMillis() {
        return this.f16215b;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverAnimationIsWindowMode() {
        return OPopoverBase.DefaultImpls.h(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public AnimatorSet getPopoverAnimator() {
        return this.f16233t;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBgColor() {
        return this.f16218e;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderColor() {
        return this.B;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderWidth() {
        return this.A;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r10 = this.f16230q;
        if (r10 != null) goto L6;
        q.y("mOBubbleLayout");
        return null;
    L6:
        return r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Context getPopoverContext() {
        return this.f16234u;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverCoverPreviousWhenStacked() {
        return this.Q;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverDisplayOrientation() {
        return this.f16217d;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverEnableBubbleMaterial() {
        return this.W;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Animator getPopoverEnterAnimator() {
        return this.D;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Animator getPopoverExitAnimator() {
        return this.E;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverGravity() {
        return Z.a(this.f16216c);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverHeight() {
        return this.f16225l;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Function1 getPopoverMaterials() {
        return this.X;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginX() {
        return this.O;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginY() {
        return this.P;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverPushedToStack() {
        return this.U;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverRemovedFromStack() {
        return this.V;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverShowWithAnimation() {
        return this.f16214a;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackAlphaPrevious() {
        return this.S;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverStackCoverColor() {
        return this.R;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackScalePrevious() {
        return this.T;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverTransparentBg() {
        return this.C;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverWidth() {
        return this.f16224k;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r10 = this.f16231r;
        if (r10 != null) goto L6;
        q.y("mWindowFrame");
        return null;
    L6:
        return r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverXOffset() {
        return this.f16220g;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverYOffset() {
        return this.f16221h;
    }

    public final int h() {
        return getDisplayRotationDegreesInternal();
    }

    public final float i() {
        int r10 = this.G;
        if (r10 == 0) goto L16;
        float r11 = resolvePopoverShadowSpace(r10);
        if (r11 > 0.0f) goto L12;
        L r12 = L.f17615a;
        if (r12.f(8) == true) goto L10;
        r12.d().writeLog("OPopover", 8, q.p("surfaceInsets elevation resolved to 0, fallback to default. shadowStyleRes=", Integer.valueOf(c(this))), null);
    L10:
        return 0.0f;
    L12:
        if (this.H == false) goto L15;
        return 0.0f;
    L15:
        return r11;
    L16:
        return 0.0f;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverBubbleLayoutInitialized() {
        if (this.f16230q == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverShowing() {
        return isShowing();
    }

    public final void j() {
        if (q.b(this.f16219f, Boolean.FALSE) == false) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(4102);
    }

    public final void k() {
        if (q.b(this.f16219f, Boolean.TRUE) == false) goto L5;
        j();
    L5:
        OPopoverLayout r10 = null;
        if (this.f16218e == 0) goto L11;
        OPopoverLayout r11 = this.f16230q;
        if (r11 != null) goto L10;
        q.y("mOBubbleLayout");
        r11 = null;
    L10:
        r11.setBgColor(this.f16218e);
    L11:
        OPopoverLayout r12 = this.f16230q;
        if (r12 != null) goto L15;
        q.y("mOBubbleLayout");
        r12 = null;
    L15:
        if (r12.g() == true) goto L23;
        OPopoverLayout r13 = this.f16230q;
        if (r13 != null) goto L19;
        q.y("mOBubbleLayout");
        r13 = null;
    L19:
        r13.setBorderColor(this.B);
        OPopoverLayout r14 = this.f16230q;
        if (r14 != null) goto L22;
        q.y("mOBubbleLayout");
        r14 = null;
    L22:
        r14.setBorderWidth(this.A);
    L23:
        OPopoverLayout r15 = this.f16230q;
        if (r15 != null) goto L26;
        q.y("mOBubbleLayout");
    L27:
        r10.setTransparentBg(this.C);
        return;
    L26:
        r10 = r15;
        goto L27
    }

    public final boolean l(View r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = r10.getClass().getName();
        if (q.b(r11, "android.widget.PopupWindow$PopupDecorView") == false) goto L39;
        return true;
    L39:
        boolean r12 = Class.forName("android.widget.PopupWindow$PopupDecorView").isInstance(r10);     // Catch: Throwable -> L10
    L11:
        if (r12 == false) goto L37;
        return true;
    L37:
        IBinder r13 = r10.getWindowToken();     // Catch: Throwable -> L36
        IBinder r14 = r10.getApplicationWindowToken();     // Catch: Throwable -> L36
        if (r13 == null) goto L19;
        if (r14 == null) goto L19;
        if (q.b(r13, r14) == true) goto L19;
        boolean r15 = true;
    L20:
        ViewGroup.LayoutParams r16 = r10.getLayoutParams();
        if ((r16 instanceof WindowManager.LayoutParams) == false) goto L23;
        WindowManager.LayoutParams r17 = (WindowManager.LayoutParams) r16;
    L24:
        if (r17 != null) goto L26;
    L25:
        boolean r18 = false;
    L31:
        if (r15 == false) goto L34;
        if (r18 == false) goto L34;
        return true;
    L34:
        q.f(r11, "className");
        return StringsKt__StringsKt.E(r11, "PopupDecorView", false, 2, null);
    L26:
        int r19 = r17.type;
        if (r19 != 1002) goto L29;
    L30:
        r18 = true;
        goto L31
    L29:
        if (r19 != 1000) goto L25;
    L23:
        r17 = null;
    L19:
        r15 = false;
    L10:
        r12 = false;
        goto L11
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void measurePopoverContent(View r10, int r11, int r12) {
        OPopoverBase.DefaultImpls.k(this, r10, r11, r12);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void measurePopupInternal(int r10, int r11) {
        OPopoverBase.DefaultImpls.l(this, r10, r11);
    }

    public final void n() {
        cancelPopoverAnimatorInternal();
        g();
        onDestroyInStackIfNeeded();
        Activity r10 = wd.a.f25402a.b(this.f16234u);
        if (r10 != null) goto L5;
    L14:
        super.dismiss();     // Catch: Exception -> L13
        return;
    L16:
        return;
    L5:
        if (r10.isFinishing() == true) goto L9;
        if (isShowing() == true) goto L14;
    L9:
        if (f16212a0 == true) goto L14;
    }

    public final void o(View r10) {
        setPopoverBubbleLayout(OPopoverBase.DefaultImpls.e(this, r10, 0, 2, null));
        ViewGroup.MarginLayoutParams r11 = new ViewGroup.MarginLayoutParams(-2, -2);
        getPopoverBubbleLayout().setLayoutParams(r11);
        setPopoverWindowFrame(getPopoverBubbleLayout());
        setContentView(getPopoverWindowFrame());
        View r12 = getContentView();
        q.f(r12, "contentView");
        measurePopoverContent(r12, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onDestroyInStackIfNeeded() {
        OPopoverBase.DefaultImpls.m(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverShownInternal() {
        setAnimationStyle(0);
        OnBubbleShowListener r10 = this.f16237x;
        if (r10 == null) goto L7;
        r10.bubbleShow();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverStartDismissInternal() {
        setAnimationStyle(0);
        this.f16232s = true;
        OnBubbleStartDismissListener r10 = this.f16238y;
        if (r10 == null) goto L7;
        r10.bubbleStartDismiss();
        return;
    }

    public final void p(boolean r10) {
        this.f16229p = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverEnterAnimationInternal() {
        setAnimationStyle(0);
        OPopoverBase.DefaultImpls.n(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverExitAnimationInternal() {
        setAnimationStyle(0);
        OPopoverBase.DefaultImpls.o(this);
    }

    public final void q(int r10) {
        setGravityInternal(r10);
    }

    public final void r(int r10) {
        if (this.f16230q == null) goto L8;
        if (r10 <= 0) goto L9;
        View r11 = getContentView();
        q.f(r11, "contentView");
        setPopoverMaxContentHeight(r10, r11, Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public View requirePopoverContentView(View r10) {
        return OPopoverBase.DefaultImpls.p(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void resetPopoverAnimatedViewState(View r10) {
        OPopoverBase.DefaultImpls.q(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int resolvePopoverAnimationGravityInternal() {
        return getPopoverGravity();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float resolvePopoverPivot(float r10, int r11, float r12) {
        return OPopoverBase.DefaultImpls.s(this, r10, r11, r12);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverBase.b resolvePopoverShadowPadding(int r10) {
        return OPopoverBase.DefaultImpls.t(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float resolvePopoverShadowSpace(int r10) {
        return OPopoverBase.DefaultImpls.u(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setGravityInternal(int r10) {
        OPopoverBase.DefaultImpls.v(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setMaxContentHeightInternal(int r10, View r11) {
        OPopoverBase.DefaultImpls.w(this, r10, r11);
    }

    public final void setOnDismissListener(@NotNull OnBubbleDismissListener r10) {
        q.g(r10, "listener");
        this.f16239z = r10;
    }

    public final void setOnShowListener(@NotNull OnBubbleShowListener r10) {
        q.g(r10, "listener");
        this.f16237x = r10;
    }

    public final void setOnStartDismissListener(@NotNull OnBubbleStartDismissListener r10) {
        q.g(r10, "listener");
        this.f16238y = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnchorCenterX(float r10) {
        this.L = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnchorCenterY(float r10) {
        this.M = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnimator(AnimatorSet r10) {
        this.f16233t = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverBubbleLayout(OPopoverLayout r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.f16230q = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverGravity(int r10) {
        this.f16216c = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverMaxContentHeight(int r10, View r11, int r12, int r13) {
        OPopoverBase.DefaultImpls.y(this, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPopupOriginX(int r10) {
        this.O = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPopupOriginY(int r10) {
        this.P = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPushedToStack(boolean r10) {
        this.U = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverRemovedFromStack(boolean r10) {
        this.V = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverWindowFrame(ViewGroup r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.f16231r = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverXOffset(int r10) {
        this.f16220g = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverYOffset(int r10) {
        this.f16221h = r10;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setXOffsetInternal(int r10) {
        OPopoverBase.DefaultImpls.z(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setYOffsetInternal(int r10) {
        OPopoverBase.DefaultImpls.A(this, r10);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean shouldAnimatePopoverVisibilityInternal() {
        return OPopoverBase.DefaultImpls.B(this);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        int r14 = Z.a(r13);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L9
        Pair r15 = f(r11, r12);     // Catch: Exception -> L9
        if (this.f16229p == false) goto L6;
    L11:
        boolean r16 = true;
    L12:
        this.N = r16;     // Catch: Exception -> L9
        if (r10 != null) goto L15;
        Unit r17 = null;
    L20:
        if (r17 != null) goto L22;
        setPopoverAnchorCenterX(Float.NaN);     // Catch: Exception -> L9
        setPopoverAnchorCenterY(Float.NaN);     // Catch: Exception -> L9
    L22:
        super.showAsDropDown(r10, r11 - ((Number) r15.getFirst()).intValue(), r12 - ((Number) r15.getSecond()).intValue(), r14);     // Catch: Exception -> L9
        afterShowInStackIfNeeded();     // Catch: Exception -> L9
        this.I = false;     // Catch: Exception -> L9
        int[] r18 = new int[2];     // Catch: Exception -> L9
        if (this.N == false) goto L25;
        getContentView().getLocationInWindow(r18);     // Catch: Exception -> L9
    L26:
        setPopoverPopupOriginX(r18[0]);     // Catch: Exception -> L9
        setPopoverPopupOriginY(r18[1]);     // Catch: Exception -> L9
        this.f16232s = false;     // Catch: Exception -> L9
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L29;
        playPopoverEnterAnimationInternal();     // Catch: Exception -> L9
        return;
    L29:
        showPopoverWithoutAnimationInternal();     // Catch: Exception -> L9
        return;
    L25:
        getContentView().getLocationOnScreen(r18);     // Catch: Exception -> L9
        goto L26
    L15:
        int[] r19 = new int[2];     // Catch: Exception -> L9
        if (r16 == false) goto L18;
        r10.getLocationInWindow(r19);     // Catch: Exception -> L9
    L19:
        setPopoverAnchorCenterX(r19[0] + (r10.getWidth() / 2.0f));     // Catch: Exception -> L9
        setPopoverAnchorCenterY(r19[1] + (r10.getHeight() / 2.0f));     // Catch: Exception -> L9
        r17 = Unit.f21064a;     // Catch: Exception -> L9
        goto L20
    L18:
        r10.getLocationOnScreen(r19);     // Catch: Exception -> L9
        goto L19
    L6:
        if (this.K == true) goto L11;
        r16 = false;
    L9:
        e = move-exception;
        L.c("OPopover", "showAsDropDown, error", e);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r19, int r20, int r21, int r22) {
        View r10 = r19;
        q.g(r10, "anchor");
        View r11 = r19.getRootView();
        wd.a r12 = wd.a.f25402a;
        Context r13 = r19.getContext();
        q.f(r13, "anchor.context");
        Activity r14 = r12.b(r13);
        boolean r15 = l(r11);
        if (this.Q == true) goto L5;
        this.Q = r15;
    L5:
        int r16 = Z.a(r20);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L12
        Pair r17 = f(r21, r22);     // Catch: Exception -> L12
        if (this.f16229p == false) goto L9;
    L14:
        boolean r18 = true;
    L15:
        this.N = r18;     // Catch: Exception -> L12
        int[] r110 = new int[2];     // Catch: Exception -> L12
        if (r18 == false) goto L21;
        r10.getLocationInWindow(r110);     // Catch: Exception -> L12
        if (r15 == false) goto L22;
        if (r14 == null) goto L22;
        int r111 = r110[0];     // Catch: Exception -> L12
        int r112 = r110[1];     // Catch: Exception -> L12
        r14.getWindow().getDecorView().getLocationOnScreen(r110);     // Catch: Exception -> L12
        int r113 = r110[0];     // Catch: Exception -> L12
        int r114 = r110[1];     // Catch: Exception -> L12
        r11.getLocationOnScreen(r110);     // Catch: Exception -> L12
        r110[0] = (r111 + r110[0]) - r113;     // Catch: Exception -> L12
        r110[1] = (r112 + r110[1]) - r114;     // Catch: Exception -> L12
    L22:
        setPopoverAnchorCenterX(r110[0] + (r19.getWidth() / 2.0f));     // Catch: Exception -> L12
        setPopoverAnchorCenterY(r110[1] + (r19.getHeight() / 2.0f));     // Catch: Exception -> L12
        if (this.K == false) goto L32;
        View r23 = r19.getRootView();     // Catch: Exception -> L12
        Context r115 = r19.getContext();     // Catch: Exception -> L12
        q.f(r115, "anchor.context");     // Catch: Exception -> L12
        int r116 = tc.f.n(r115);     // Catch: Exception -> L12
        Context r117 = r19.getContext();     // Catch: Exception -> L12
        q.f(r117, "anchor.context");     // Catch: Exception -> L12
        int r24 = tc.f.k(r117);     // Catch: Exception -> L12
        int r118 = wd.a.g(r19.getContext());     // Catch: Exception -> L12
        int r25 = r12.f(r19.getContext());     // Catch: Exception -> L12
        if (r23.getWidth() >= r116) goto L27;
        float r119 = (r116 - r23.getWidth()) / 2.0f;     // Catch: Exception -> L12
    L28:
        int r120 = yf.b.b(r119);     // Catch: Exception -> L12
        if (r23.getHeight() >= r24) goto L31;
        int r26 = ((r24 - r23.getHeight()) + r118) + r25;     // Catch: Exception -> L12
    L33:
        int r27 = (r21 - ((Number) r17.getFirst()).intValue()) - r120;     // Catch: Exception -> L12
        int r28 = (r22 - ((Number) r17.getSecond()).intValue()) - r26;     // Catch: Exception -> L12
        setPopoverPopupOriginX(r27);     // Catch: Exception -> L12
        setPopoverPopupOriginY(r28);     // Catch: Exception -> L12
        setElevation(i());     // Catch: Exception -> L12
        if (this.K == true) goto L41;
        if (r14 == null) goto L41;
        if (q.b(r19.getWindowToken(), r14.getWindow().getDecorView().getWindowToken()) == true) goto L40;
        if (r15 == true) goto L40;
        r10 = r19.getRootView();     // Catch: Exception -> L12
        q.f(r10, "anchor.rootView");     // Catch: Exception -> L12
    L40:
        r10 = r14.getWindow().getDecorView();     // Catch: Exception -> L12
        q.f(r10, "activity.window.decorView");     // Catch: Exception -> L12
    L41:
        super.showAtLocation(r10, r16, r27, r28);     // Catch: Exception -> L12
        afterShowInStackIfNeeded();     // Catch: Exception -> L12
        setElevation(0.0f);     // Catch: Exception -> L12
        getContentView().setElevation(0.0f);     // Catch: Exception -> L12
        this.I = false;     // Catch: Exception -> L12
        this.f16232s = false;     // Catch: Exception -> L12
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L44;
        playPopoverEnterAnimationInternal();     // Catch: Exception -> L12
        return;
    L44:
        showPopoverWithoutAnimationInternal();     // Catch: Exception -> L12
        return;
    L31:
        r26 = 0;
        goto L33
    L27:
        r119 = 0.0f;
        goto L28
    L32:
        r26 = 0;
        r120 = 0;
        goto L33
    L21:
        r10.getLocationOnScreen(r110);     // Catch: Exception -> L12
        goto L22
    L9:
        if (this.K == true) goto L14;
        r18 = false;
    L12:
        e = move-exception;
        L.c("OPopover", "showAtLocation, error", e);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void showPopoverDirectlyInternal(ViewGroup r10, Function0 r11) {
        OPopoverBase.DefaultImpls.C(this, r10, r11);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void showPopoverWithoutAnimationInternal() {
        OPopoverBase.DefaultImpls.E(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public AnimatorSet startPopoverVisibilityAnimationInternal(boolean r10, int r11, boolean r12, Animator r13, Function0 r14, Function0 r15) {
        return OPopoverBase.DefaultImpls.F(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void updatePopoverPivotInternal() {
        OPopoverBase.DefaultImpls.H(this);
    }
}
