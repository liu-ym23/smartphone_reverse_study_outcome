package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm.constant.PerfConsts;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.q;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.Nullable;
import td.h;

/* JADX INFO: loaded from: classes4.dex */
public class OPopover extends PopupWindow {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final c f16017l0 = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static volatile int f16018m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static boolean f16019n0;
    public boolean A;
    public boolean B;
    public boolean C;
    public float D;
    public boolean E;
    public float F;
    public Float G;
    public Float H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f16020J;
    public boolean K;
    public OPopoverLayout L;
    public ViewGroup M;
    public PopoverTextView N;
    public boolean O;
    public int P;
    public AnimatorSet Q;
    public Activity R;
    public View S;
    public OnBubbleClickListener T;
    public OnBubbleShowListener U;
    public OnBubbleDismissListener V;
    public boolean W;
    public int X;
    public int Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16021a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Animator f16022a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f16023b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Animator f16024b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16025c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f16026c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16027d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f16028d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16029e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f16030e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16031f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f16032f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16033g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f16034g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f16035h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f16036h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16037i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Point f16038i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16039j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Runnable f16040j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f16041k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final com.obric.oui.animation.engine.a f16042k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f16043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f16047p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16048q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f16049r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16050s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f16051t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f16052u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f16053v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16054w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f16055x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f16056y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f16057z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "", "clickBubble", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleClickListener {
        void clickBubble();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleDismissListener {
        void bubbleDismiss();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleShowListener {
        void bubbleShow();
    }

    public static final class a {
        public boolean A;
        public int B;
        public boolean C;
        public float D;
        public boolean E;
        public boolean F;
        public boolean G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public boolean f16058J;
        public float K;
        public Float L;
        public Float M;
        public boolean N;
        public boolean O;
        public boolean P;
        public String Q;
        public int R;
        public boolean S;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Activity f16059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f16062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f16063e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f16064f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f16065g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f16066h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16067i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f16068j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f16069k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f16070l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public View f16071m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f16072n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f16073o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f16074p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f16075q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f16076r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Typeface f16077s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f16078t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public OnBubbleClickListener f16079u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public OnBubbleDismissListener f16080v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public OnBubbleShowListener f16081w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f16082x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f16083y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f16084z;

        public a(Activity r10) {
            q.g(r10, "activity");
            this.f16059a = r10;
            this.f16063e = ContextCompat.b(r10, R$color.oui_toast_background);
            this.f16068j = 800;
            this.f16069k = Long.MIN_VALUE;
            this.f16074p = "";
            this.f16076r = 13.0f;
            Activity r11 = this.f16059a;
            int r12 = R$color.oui_toast_text;
            this.f16078t = ContextCompat.b(r11, r12);
            this.f16083y = 12.0f;
            this.f16084z = true;
            this.B = -16777216;
            this.D = 2.0f;
            this.E = true;
            this.G = true;
            this.P = true;
            this.Q = "";
            this.R = ContextCompat.b(this.f16059a, r12);
            this.S = true;
        }

        public final int A() {
            return this.B;
        }

        public final float B() {
            return this.D;
        }

        public final boolean C() {
            return this.N;
        }

        public final boolean D() {
            return this.G;
        }

        public final OnBubbleShowListener E() {
            return this.f16081w;
        }

        public final boolean F() {
            return this.S;
        }

        public final String G() {
            return this.Q;
        }

        public final int H() {
            return this.R;
        }

        public final int I() {
            return this.f16078t;
        }

        public final float J() {
            return this.f16076r;
        }

        public final Typeface K() {
            return this.f16077s;
        }

        public final boolean L() {
            return this.f16070l;
        }

        public final View M() {
            return this.f16071m;
        }

        public final int N() {
            return this.f16072n;
        }

        public final int O() {
            return this.f16066h;
        }

        public final int P() {
            return this.f16067i;
        }

        public final Float Q() {
            return this.L;
        }

        public final Float R() {
            return this.M;
        }

        public final boolean S() {
            return this.f16058J;
        }

        public final a T(int r10) {
            this.f16061c = OPopover.f16017l0.a(r10);
            return this;
        }

        public final a U(boolean r10) {
            this.f16070l = r10;
            return this;
        }

        public final a V(View r10) {
            q.g(r10, "view");
            this.f16071m = r10;
            return this;
        }

        public final a W(int r10) {
            return this;
        }

        public final OPopover a() {
            return new OPopover(this);
        }

        public final Activity b() {
            return this.f16059a;
        }

        public final float c() {
            return this.K;
        }

        public final boolean d() {
            return this.C;
        }

        public final long e() {
            return this.f16068j;
        }

        public final float f() {
            return this.f16062d;
        }

        public final long g() {
            return this.f16069k;
        }

        public final int h() {
            return this.f16063e;
        }

        public final int i() {
            return this.I;
        }

        public final int j() {
            return this.H;
        }

        public final String k() {
            return this.f16074p;
        }

        public final int l() {
            return this.f16075q;
        }

        public final OnBubbleClickListener m() {
            return this.f16079u;
        }

        public final OnBubbleDismissListener n() {
            return this.f16080v;
        }

        public final boolean o() {
            return this.f16060b;
        }

        public final boolean p() {
            return this.F;
        }

        public final int q() {
            return this.f16061c;
        }

        public final int r() {
            return this.f16073o;
        }

        public final boolean s() {
            return this.f16065g;
        }

        public final void setMClickListener(@Nullable OnBubbleClickListener r10) {
            this.f16079u = r10;
        }

        public final void setMDismissListener(@Nullable OnBubbleDismissListener r10) {
            this.f16080v = r10;
        }

        public final void setMShowListener(@Nullable OnBubbleShowListener r10) {
            this.f16081w = r10;
        }

        public final boolean t() {
            return this.P;
        }

        public final boolean u() {
            return this.f16082x;
        }

        public final boolean v() {
            return this.f16064f;
        }

        public final boolean w() {
            return this.A;
        }

        public final boolean x() {
            return this.O;
        }

        public final boolean y() {
            return this.f16084z;
        }

        public final float z() {
            return this.f16083y;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16085a;

        public b(float r10) {
            this.f16085a = r10;
        }

        public final float a() {
            return this.f16085a;
        }

        public final void b(float r10) {
            this.f16085a = r10;
        }
    }

    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker r10) {
            this();
        }

        public final int a(int r10) {
            if (r10 != 8388611) goto L5;
            return 3;
        L5:
            if (r10 != 8388613) goto L11;
            return 5;
        L11:
            return r10;
        }

        public c() {
        }
    }

    public static final class d extends com.obric.oui.animation.engine.a {
        public d() {
            super("v");
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            if (r10 == null) goto L20;
            Object r11 = r10.getTag(R$id.o_popover_anim_p);
            if (r11 == null) goto L21;
            td.c r12 = td.c.f24796a;
            Float r13 = null;
            if ((r11 instanceof b) == true) goto L12;
            r11 = null;
        L12:
            b r14 = (b) r11;
            if (r14 == null) goto L16;
            r13 = Float.valueOf(r14.a());
        L16:
            if (r13 != null) goto L19;
            return 0.0f;
        L19:
            return r13.floatValue();
        L21:
            return 0.0f;
        L20:
            return 0.0f;
        }

        public void d(View r10, float r11) {
            if (r10 == null) goto L16;
            Object r12 = r10.getTag(R$id.o_popover_anim_p);
            if (r12 == null) goto L17;
            td.c r13 = td.c.f24796a;
            if ((r12 instanceof b) == true) goto L11;
            r12 = null;
        L11:
            b r14 = (b) r12;
            if (r14 == null) goto L18;
            r14.b(r11);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OPopover f16088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f16089d;

        public e(boolean r10, ViewGroup r11, OPopover r12, Ref$ObjectRef r13) {
            this.f16086a = r10;
            this.f16087b = r11;
            this.f16088c = r12;
            this.f16089d = r13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            super.onAnimationCancel(r10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            super.onAnimationEnd(r10);
            if (this.f16086a == true) goto L10;
            this.f16087b.setVisibility(8);
            OnBubbleDismissListener r11 = OPopover.e(this.f16088c);
            if (r11 == null) goto L8;
            r11.bubbleDismiss();
        L8:
            this.f16088c.w();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            q.g(r10, "animation");
            super.onAnimationStart(r10);
            ViewPropertySpringAnimator r11 = (ViewPropertySpringAnimator) this.f16089d.element;
            if (r11 == null) goto L7;
            r11.q();
        L7:
            if (this.f16086a == false) goto L14;
            OnBubbleShowListener r12 = OPopover.f(this.f16088c);
            if (r12 == null) goto L12;
            r12.bubbleShow();
        L12:
            this.f16087b.setVisibility(0);
            return;
        }
    }

    static {
        f16017l0 = new c(null);
    }

    public OPopover(a r10) {
        q.g(r10, "builder");
        this.f16033g = -16777216;
        this.f16041k = 200;
        this.f16043l = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
        this.f16044m = true;
        this.f16047p = "";
        this.f16049r = 13.0f;
        this.f16052u = true;
        this.f16053v = 12.0f;
        this.f16056y = true;
        this.B = true;
        this.D = 2.0f;
        this.K = true;
        this.f16026c0 = "";
        this.f16028d0 = -7829368;
        this.f16030e0 = true;
        this.f16032f0 = true;
        this.R = r10.b();
        this.f16021a = r10.q();
        this.f16025c = r10.f();
        this.f16027d = r10.h();
        this.f16029e = r10.v();
        this.f16035h = Boolean.valueOf(r10.s());
        this.f16037i = r10.O();
        this.f16039j = r10.P();
        this.f16041k = r10.e();
        this.f16043l = r10.g();
        this.f16044m = r10.L();
        this.S = r10.M();
        this.f16046o = r10.r();
        this.f16045n = r10.N();
        this.f16047p = r10.k();
        this.f16048q = r10.l();
        this.f16049r = r10.J();
        this.f16050s = r10.I();
        this.f16051t = r10.K();
        this.T = r10.m();
        this.V = r10.n();
        this.U = r10.E();
        this.f16052u = r10.u();
        this.f16053v = r10.z();
        this.f16056y = r10.y();
        this.f16057z = r10.o();
        this.f16031f = r10.w();
        this.f16033g = r10.A();
        this.C = r10.d();
        this.D = r10.B();
        this.E = r10.p();
        this.W = r10.D();
        this.X = r10.j();
        this.Y = r10.i();
        this.Z = r10.S();
        this.F = r10.c();
        this.G = r10.Q();
        this.H = r10.R();
        this.I = r10.C();
        this.f16020J = r10.x();
        this.K = r10.t();
        this.f16026c0 = r10.G();
        this.f16028d0 = r10.H();
        this.f16030e0 = r10.F();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.f16057z);
        setOutsideTouchable(this.f16056y);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (this.f16044m == true) goto L10;
        View r11 = this.S;
        if (r11 == null) goto L10;
        y(r11);
        OPopoverLayout r12 = this.L;
        if (r12 != null) goto L9;
        q.y("mOBubbleLayout");
        r12 = null;
    L9:
        r12.setUseDefaultView(false);
    L11:
        t();
        setFocusable(true);
        this.f16040j0 = new com.obric.oui.popover.b(this);
        this.f16042k0 = new d();
        return;
    L10:
        B();
        goto L11
    }

    public static /* synthetic */ void J(OPopover r10, View r11, int r12, boolean r13, float r14, int r15, int r16, boolean r17, int r18, Object r19) {
        if (r19 != null) goto L10;
        if ((r18 & 64) == 0) goto L6;
        boolean r20 = false;
    L7:
        r10.H(r11, r12, r13, r14, r15, r16, r20);
        return;
    L6:
        r20 = r17;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public static /* synthetic */ void a(ViewGroup r10, float r11, float r12, float r13, float r14, float r15, float r16, DynamicAnimation r17, float r18, float r19) {
        k(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ boolean b(OPopover r10, View r11, MotionEvent r12) {
        return h(r10, r11, r12);
    }

    public static /* synthetic */ void c(OPopover r10) {
        u(r10);
    }

    public static /* synthetic */ void d(OPopover r10, View r11) {
        z(r10, r11);
    }

    public static final /* synthetic */ OnBubbleDismissListener e(OPopover r10) {
        return r10.V;
    }

    public static final /* synthetic */ OnBubbleShowListener f(OPopover r10) {
        return r10.U;
    }

    public static final boolean h(OPopover r10, View r11, MotionEvent r12) {
        q.g(r10, "this$0");
        if (r12.getAction() != 0) goto L12;
        h r13 = h.f24801a;
        OPopoverLayout r14 = r10.L;
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

    public static final void k(ViewGroup r10, float r11, float r12, float r13, float r14, float r15, float r16, DynamicAnimation r17, float r18, float r19) {
        q.g(r10, "$view");
        td.c r20 = td.c.f24796a;
        Object r21 = r10.getTag(R$id.o_popover_anim_p);
        if (r21 != null) goto L6;
    L4:
        r21 = null;
    L8:
        if (((b) r21) == null) goto L11;
        float r22 = td.b.b(r18, r11, r12);
        float r23 = r13 + ((r14 - r13) * r22);
        r10.setScaleX(r23);
        r10.setScaleY(r23);
        r10.setTranslationY(r15 + ((r16 - r15) * r22));
        return;
    L11:
        return;
    L6:
        if ((r21 instanceof b) == false) goto L4;
        goto L4
    }

    public static final void u(OPopover r10) {
        q.g(r10, "this$0");
        if (r10.B == false) goto L6;
        r10.j(false);
        return;
    }

    public static final void z(OPopover r10, View r11) {
        q.g(r10, "this$0");
        OnBubbleClickListener r12 = r10.T;
        if (r12 == null) goto L7;
        r12.clickBubble();
    L7:
        if (r10.f16020J == true) goto L10;
        r10.dismiss();
        return;
    }

    public final void A(View r11, int r12, boolean r13, boolean r14) {
        int r10 = f16017l0.a(r12);
        int[] r15 = new int[2];
        Point r16 = this.f16038i0;
        if (r16 == null) goto L6;
        q.d(r16);
        r15[0] = r16.x;
        r15[1] = r16.y;
    L9:
        int[] r17 = l(r13, r10, r11.getMeasuredWidth(), r11.getMeasuredHeight(), false, r14);
        if (this.I == false) goto L12;
        showAsDropDown(r11, r17[0], r17[1] - r11.getMeasuredHeight(), 0);
    L13:
        this.f16032f0 = false;
        m();
        return;
    L12:
        showAtLocation(r11, 0, Math.max(0, r15[0] + r17[0]), Math.max(0, r15[1] + r17[1]));
        goto L13
    L6:
        if (this.E == false) goto L8;
        r11.getLocationInWindow(r15);
        goto L9
    L8:
        r11.getLocationOnScreen(r15);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B() {
        PopoverTextView r10 = null;
        PopoverTextView r11 = new PopoverTextView(this.R, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        this.N = r11;
        if (this.f16050s == 0) goto L5;
        r11.setTextColor(this.f16050s);
    L7:
        if (this.f16051t == null) goto L12;
        PopoverTextView r12 = this.N;
        if (r12 != null) goto L11;
        q.y("mTextView");
        r12 = null;
    L11:
        r12.setTypeface(this.f16051t);
    L12:
        PopoverTextView r13 = this.N;
        if (r13 != null) goto L15;
        q.y("mTextView");
        r13 = null;
    L15:
        r13.setTextSize(1, 14.0f);
        PopoverTextView r14 = this.N;
        if (r14 != null) goto L18;
        q.y("mTextView");
        r14 = null;
    L18:
        r14.setTextAlignment(5);
        PopoverTextView r15 = this.N;
        if (r15 != null) goto L21;
        q.y("mTextView");
        r15 = null;
    L21:
        r15.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        PopoverTextView r16 = this.N;
        if (r16 != null) goto L24;
        q.y("mTextView");
        r16 = null;
    L24:
        PopoverTextView r17 = this.N;
        if (r17 != null) goto L27;
        q.y("mTextView");
        r17 = null;
    L27:
        r16.setLineHeight(tc.f.r(r17, 20));
        PopoverTextView r18 = this.N;
        if (r18 != null) goto L30;
        q.y("mTextView");
        r18 = null;
    L30:
        r18.setGravity(17);
        PopoverTextView r19 = this.N;
        if (r19 != null) goto L33;
        q.y("mTextView");
        r19 = null;
    L33:
        PopoverTextView r20 = this.N;
        if (r20 != null) goto L36;
        q.y("mTextView");
        r20 = null;
    L36:
        r19.setMaxWidth(tc.f.r(r20, 276));
        PopoverTextView r21 = this.N;
        if (r21 != null) goto L39;
        q.y("mTextView");
        r21 = null;
    L39:
        r21.setEllipsize(TextUtils.TruncateAt.END);
        PopoverTextView r22 = this.N;
        if (r22 != null) goto L42;
        q.y("mTextView");
        r22 = null;
    L42:
        y(r22);
        if (this.f16035h != null) goto L46;
        this.f16035h = Boolean.TRUE;
    L46:
        if (TextUtils.isEmpty(this.f16047p) == true) goto L58;
        if (q.b(this.f16026c0, "") == false) goto L53;
        PopoverTextView r23 = this.N;
        if (r23 != null) goto L52;
        q.y("mTextView");
        r23 = null;
    L52:
        r23.setText(this.f16047p);
        goto L58
    L53:
        SpannableString r24 = new SpannableString(this.f16047p + '\n' + this.f16026c0);
        r24.setSpan(new StyleSpan(0), 0, this.f16047p.length(), 33);
        Layout.Alignment r25 = Layout.Alignment.ALIGN_CENTER;
        r24.setSpan(new AlignmentSpan.Standard(r25), 0, this.f16047p.length(), 33);
        r24.setSpan(new AbsoluteSizeSpan(14, true), 0, this.f16047p.length(), 33);
        r24.setSpan(new ForegroundColorSpan(this.f16028d0), this.f16047p.length() + 1, r24.length(), 33);
        r24.setSpan(new AbsoluteSizeSpan(14, true), this.f16047p.length() + 1, r24.length(), 33);
        r24.setSpan(new AlignmentSpan.Standard(r25), this.f16047p.length() + 1, r24.length(), 33);
        PopoverTextView r26 = this.N;
        if (r26 != null) goto L56;
        q.y("mTextView");
        r26 = null;
    L56:
        r26.setText(r24, TextView.BufferType.SPANNABLE);
    L58:
        if (this.f16048q == 0) goto L64;
        PopoverTextView r27 = this.N;
        if (r27 != null) goto L62;
        q.y("mTextView");
        r27 = null;
    L62:
        r27.setText(this.f16048q);
    L64:
        if (this.f16049r == 0.0f) goto L71;
        PopoverTextView r28 = this.N;
        if (r28 != null) goto L69;
        q.y("mTextView");
    L70:
        r10.setTextSize(1, this.f16049r);
        goto L71
    L69:
        r10 = r28;
    L71:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        r11.setTextColor(ContextCompat.b(this.R, R$color.oui_toast_text));
        goto L7
    }

    public final void C(int r10) {
        OPopoverLayout r11 = this.L;
        if (r11 != null) goto L5;
        q.y("mOBubbleLayout");
        r11 = null;
    L5:
        r11.setBubbleOrientation(r(f16017l0.a(r10)));
    }

    public final void D(int r10) {
        OPopoverLayout r11 = this.L;
        if (r11 == null) goto L18;
        if (r10 <= 0) goto L19;
        OPopoverLayout r12 = null;
        if (r11 != null) goto L9;
        q.y("mOBubbleLayout");
        r11 = null;
    L9:
        int r13 = bg.h.d(r10 - (r11.getArrowHeight() * 2), 0);
        OPopoverLayout r14 = this.L;
        if (r14 != null) goto L12;
        q.y("mOBubbleLayout");
        r14 = null;
    L12:
        E(r14, r13);
        OPopoverLayout r15 = this.L;
        if (r15 != null) goto L15;
        q.y("mOBubbleLayout");
    L16:
        r12.requestLayout();
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L15:
        r12 = r15;
        goto L16
    L19:
        return;
    }

    public final void E(View r10, int r11) {
        if ((r10 instanceof OPopoverMenuView) == false) goto L6;
        ((OPopoverMenuView) r10).setPopoverMaxHeight(r11);
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L11;
        Iterator r12 = ViewGroupKt.a((ViewGroup) r10).iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        E((View) r12.next(), r11);
        goto L9
    L13:
        return;
    }

    public final void F(int r10) {
        this.f16037i = r10;
    }

    public final void G(int r10) {
        this.f16039j = r10;
    }

    public final void H(View r10, int r11, boolean r12, float r13, int r14, int r15, boolean r16) {
        int r17 = f16017l0.a(r11);
        this.f16037i = r14;
        this.f16039j = r15;
        this.f16025c = r13;
        I(r10, r17, r12, r16);
    }

    public final void I(View r10, int r11, boolean r12, boolean r13) {
        int r14 = f16017l0.a(r11);
        if (this.R.isFinishing() == true) goto L36;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getWindowToken() == null) goto L39;
        this.f16054w = r10.getMeasuredHeight();
        this.f16055x = r10.getMeasuredWidth();
        getContentView().removeCallbacks(this.f16040j0);
        this.f16021a = r14;
        OPopoverLayout r15 = this.L;
        OPopoverLayout r16 = null;
        if (r15 != null) goto L11;
        q.y("mOBubbleLayout");
        r15 = null;
    L11:
        this.P = r15.getPadding();
        if (isShowing() == true) goto L34;
        int r17 = r(r14);
        v();
        if (r12 == false) goto L24;
        if (r14 != 48) goto L18;
    L21:
        int r18 = q();
    L22:
        this.f16023b = r18 / 2.0f;
    L26:
        OPopoverLayout r19 = this.L;
        if (r19 != null) goto L29;
        q.y("mOBubbleLayout");
    L30:
        r16.j(r17, this.f16023b + this.f16025c);
        A(r10, r14, r12, r13);
        this.O = false;
        if (this.f16043l <= 0) goto L33;
        getContentView().postDelayed(this.f16040j0, this.f16043l);
    L33:
        f16018m0++;
        return;
    L29:
        r16 = r19;
        goto L30
    L18:
        if (r14 == 80) goto L21;
        r18 = p();
        goto L22
    L24:
        if (this.A == true) goto L26;
        this.f16025c += this.P;
        this.A = true;
        goto L26
    L34:
        super.dismiss();
        return;
    L39:
        return;
    }

    public final void K() {
        ViewGroup r10 = this.M;
        if (r10 != null) goto L5;
        q.y("mWindowFrame");
        r10 = null;
    L5:
        r10.setVisibility(0);
        OnBubbleShowListener r11 = this.U;
        if (r11 == null) goto L10;
        r11.bubbleShow();
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.O == true) goto L6;
        j(false);
        getContentView().removeCallbacks(this.f16040j0);
        this.f16037i = 0;
        this.f16039j = 0;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.widget.PopupWindow, com.obric.oui.popover.OPopover] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View] */
    public final Pair g(int r18, int r19) {
        ?? r10 = 0;
        ViewGroup r11 = null;
        if (this.f16032f0 == true) goto L15;
        ViewGroup r12 = this.M;
        if (r12 != null) goto L8;
        q.y("mWindowFrame");
        r12 = null;
    L8:
        if ((r12 instanceof SingleChildFrameLayout) == false) goto L15;
        ViewGroup r13 = this.M;
        if (r13 != null) goto L12;
        q.y("mWindowFrame");
    L13:
        r11.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r14 = getContentView().getContext();
        q.f(r14, "contentView.context");
        setWidth(tc.f.n(r14));
        return new Pair(Integer.valueOf(r18), Integer.valueOf(this.f16034g0));
    L12:
        r11 = r13;
    L15:
        View r15 = LayoutInflater.from(this.R).inflate(R$layout.o_layout_popover_shadow_frame, null);
        if (r15 == null) goto L52;
        SingleChildFrameLayout r16 = (SingleChildFrameLayout) r15;
        OPopoverLayout r17 = this.L;
        if (r17 != null) goto L20;
        q.y("mOBubbleLayout");
        r17 = null;
    L20:
        r16.addView(r17, new FrameLayout.LayoutParams(-2, -2));
        OPopoverLayout r20 = this.L;
        if (r20 != null) goto L23;
        q.y("mOBubbleLayout");
        r20 = null;
    L23:
        r16.setShadowCornerRadius(yf.b.b(r20.getCornerRadius()));
        OPopoverLayout r21 = this.L;
        if (r21 != null) goto L26;
        q.y("mOBubbleLayout");
        r21 = null;
    L26:
        int r22 = r21.getArrowHeight();
        OPopoverLayout r23 = this.L;
        if (r23 != null) goto L29;
        q.y("mOBubbleLayout");
        r23 = null;
    L29:
        r16.setShadowInsets(r22, r23.getArrowHeight());
        List r24 = OUILayoutHelper.x(this.R, R$style.OUIShadow_3);
        q.f(r24, "shadows");
        Iterator r25 = r24.iterator();
        int r26 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
    L31:
        if (r25.hasNext() == false) goto L45;
        Shadow r113 = (Shadow) r25.next();
        if ((r113.i() - r113.f()) <= r111) goto L36;
        r111 = yf.b.b(r113.i() - r113.f());
    L36:
        if ((r113.i() + r113.f()) <= r112) goto L39;
        r112 = yf.b.b(r113.i() + r113.f());
    L39:
        if ((r113.i() - r113.g()) <= r26) goto L42;
        r26 = yf.b.b(r113.i() - r113.g());
    L42:
        if ((r113.i() + r113.g()) <= r110) goto L31;
        r110 = yf.b.b(r113.i() + r113.g());
        goto L31
    L45:
        SingleChildFrameLayout r27 = new SingleChildFrameLayout(this.R, r10, 2, r10);
        Context r114 = getContentView().getContext();
        q.f(r114, "contentView.context");
        r27.setLayoutParams(new ViewGroup.MarginLayoutParams(tc.f.n(r114), -2));
        r27.addView(r16, new FrameLayout.LayoutParams(-2, -2));
        r27.setClipChildren(false);
        r27.setClipToPadding(false);
        r27.setPadding(0, r26, 0, r110);
        r16.setX(r18);
        r27.setOnTouchListener(new com.obric.oui.popover.a(this));
        this.f16034g0 = r26;
        this.M = r27;
        r27.setVisibility(4);
        ViewGroup r28 = this.M;
        if (r28 != null) goto L48;
        q.y("mWindowFrame");
    L49:
        setContentView(r10);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r29 = getContentView().getContext();
        q.f(r29, "contentView.context");
        setWidth(tc.f.n(r29));
        return new Pair(Integer.valueOf(r18), Integer.valueOf(r26));
    L48:
        r10 = r28;
        goto L49
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    }

    public final Pair i(int r10, int r11) {
        return g(r10, r11);
    }

    /* JADX WARN: Type inference failed for: r14v3, types: [T, com.obric.oui.animation.easy.ViewPropertySpringAnimator] */
    public final void j(boolean r21) {
        int r10 = 1;
        ViewGroup r11 = this.M;
        OPopoverLayout r12 = null;
        if (r11 != null) goto L6;
        q.y("mWindowFrame");
        r11 = null;
    L6:
        if (r21 == true) goto L8;
        f16018m0--;
        this.O = true;
    L8:
        this.Q = new AnimatorSet();
        int r13 = o();
        if (r13 != 3) goto L11;
        float r14 = r11.getX() + r11.getMeasuredWidth();
        float r15 = r11.getY();
        OPopoverLayout r16 = this.L;
        if (r16 != null) goto L35;
        q.y("mOBubbleLayout");
    L36:
        float r17 = r12.getBubbleOffset();
    L31:
        float r18 = r17 + r15;
    L37:
        View r19 = r11.getChildAt(0);
        if (r19 != null) goto L40;
        float r20 = 0.0f;
    L41:
        r11.setPivotY(r18);
        r11.setPivotX(r14 + r20);
        float r110 = 1.0f;
        PathInterpolator r22 = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator r23 = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        if (r21 == false) goto L44;
        float r24 = 0.0f;
    L45:
        if (r21 == false) goto L47;
        float r111 = 1.0f;
    L49:
        if (r11.getAlpha() != 0.0f) goto L52;
    L55:
        ObjectAnimator r25 = ObjectAnimator.ofFloat(r11, "alpha", new float[]{r24, r111});
        if (r21 == true) goto L59;
        r22 = r23;
    L59:
        r25.setInterpolator(r22);
        if (r21 == false) goto L62;
        long r112 = 300;
    L63:
        r25.setDuration(r112);
        r11.setVisibility(0);
        Ref$ObjectRef r26 = new Ref$ObjectRef();
        if (r21 == false) goto L71;
        Animator r27 = this.f16022a0;
        if (r27 == null) goto L71;
        AnimatorSet r28 = this.Q;
        if (r28 == null) goto L113;
        r28.play(r27);
    L113:
        AnimatorSet r29 = this.Q;
        if (r29 == null) goto L117;
        r29.addListener(new e(r21, r11, this, r26));
    L117:
        AnimatorSet r30 = this.Q;
        if (r30 == null) goto L122;
        r30.start();
        return;
    L122:
        return;
    L71:
        if (r21 == true) goto L78;
        Animator r31 = this.f16024b0;
        if (r31 == null) goto L78;
        AnimatorSet r32 = this.Q;
        if (r32 == null) goto L113;
        r32.play(r31);
    L78:
        AnimatorSet r33 = this.Q;
        if (r33 == null) goto L82;
        r33.play(r25);
    L82:
        float r34 = 0.5f;
        if (r21 == false) goto L85;
        final float r113 = 0.5f;
    L86:
        if (r21 == false) goto L89;
        r34 = 1.0f;
    L89:
        if (o() != 48) goto L93;
        r10 = -1;
    L93:
        if (r21 == false) goto L95;
        float r35 = -tc.f.u(r11, 10);
    L96:
        float r36 = r10;
        final float r114 = r35 * r36;
        if (r21 == false) goto L99;
        float r37 = 0.0f;
    L100:
        final float r38 = r36 * r37;
        if (r21 == false) goto L103;
        final float r39 = 0.0f;
    L104:
        if (r21 == false) goto L106;
        final float r40 = 10000.0f;
    L108:
        if (com.obric.oui.animation.easy.b.a(r11).l() == true) goto L110;
        r11.setScaleX(r113);
        r11.setScaleY(r113);
        r11.setTranslationY(r114);
        r11.setTag(R$id.o_popover_anim_p, new b(r39));
    L110:
        if (r21 == false) goto L112;
        r110 = 0.8f;
    L112:
        ?? r115 = ViewPropertySpringAnimator.f(com.obric.oui.animation.easy.b.a(r11).j(r110).k(439.0f), this.f16042k0, r40, null, 4, null);
        final ViewGroup r41 = r11;
        final float r116 = r34;
        r115.setUpdateListener(new com.obric.oui.popover.c(r41, r39, r40, r113, r116, r114, r38));
        r26.element = r115;
        goto L113
    L106:
        r40 = 0.0f;
        goto L108
    L103:
        r39 = 10000.0f;
        goto L104
    L99:
        r37 = -tc.f.u(r11, 10);
        goto L100
    L95:
        r35 = 0.0f;
        goto L96
    L85:
        r113 = 1.0f;
        goto L86
    L62:
        r112 = 100;
        goto L63
    L52:
        if (r11.getAlpha() == 1.0f) goto L55;
        r24 = r11.getAlpha();
        goto L55
    L47:
        r111 = 0.0f;
        goto L49
    L44:
        r24 = 1.0f;
        goto L45
    L40:
        r20 = r19.getX();
        goto L41
    L35:
        r12 = r16;
        goto L36
    L11:
        if (r13 == 5) goto L26;
        if (r13 != 48) goto L14;
        float r42 = r11.getX();
        OPopoverLayout r43 = this.L;
        if (r43 != null) goto L24;
        q.y("mOBubbleLayout");
    L25:
        r14 = r42 + r12.getBubbleOffset();
        r18 = (r11.getY() + r11.getMeasuredHeight()) - r11.getPaddingBottom();
        goto L37
    L24:
        r12 = r43;
        goto L25
    L14:
        if (r13 == 80) goto L16;
        r18 = 0.0f;
        r14 = 0.0f;
        goto L37
    L16:
        float r44 = r11.getX();
        OPopoverLayout r45 = this.L;
        if (r45 != null) goto L19;
        q.y("mOBubbleLayout");
    L20:
        r14 = r44 + r12.getBubbleOffset();
        r18 = r11.getY() + r11.getPaddingTop();
        goto L37
    L19:
        r12 = r45;
        goto L20
    L26:
        r14 = r11.getX();
        r15 = r11.getY();
        OPopoverLayout r117 = this.L;
        if (r117 != null) goto L29;
        q.y("mOBubbleLayout");
    L30:
        r17 = r12.getBubbleOffset();
        goto L31
    L29:
        r12 = r117;
        goto L30
    }

    public final int[] l(boolean r10, int r11, int r12, int r13, boolean r14, boolean r15) {
        int[] r16 = new int[2];
        if (this.C == false) goto L14;
        if (r10 == true) goto L14;
        if (r14 == true) goto L14;
        int r17 = o();
        if (r17 == 3) goto L13;
        if (r17 == 5) goto L13;
        if (r17 == 48) goto L12;
        if (r17 != 80) goto L14;
    L12:
        this.f16037i -= n();
    L13:
        this.f16039j -= n();
    L14:
        int r18 = f16017l0.a(r11);
        if (r18 == 3) goto L36;
        if (r18 == 5) goto L31;
        if (r18 == 48) goto L26;
        if (r18 == 80) goto L21;
    L40:
        return r16;
    L21:
        if ((r10 | r15) == false) goto L23;
        int r19 = (r12 - q()) / 2;
    L24:
        r16[0] = this.f16037i + r19;
        r16[1] = this.f16039j + r13;
        goto L40
    L23:
        r19 = 0;
        goto L24
    L26:
        if ((r10 | r15) == false) goto L28;
        int r110 = (r12 - q()) / 2;
    L29:
        r16[0] = this.f16037i + r110;
        r16[1] = (-p()) + this.f16039j;
        goto L40
    L28:
        r110 = 0;
        goto L29
    L31:
        if ((r10 | r15) == false) goto L33;
        int r111 = (r13 - p()) / 2;
    L34:
        r16[0] = this.f16037i + r12;
        r16[1] = this.f16039j + r111;
        goto L40
    L33:
        r111 = 0;
        goto L34
    L36:
        if ((r10 | r15) == false) goto L38;
        int r112 = (r13 - p()) / 2;
    L39:
        r16[0] = this.f16037i - q();
        r16[1] = this.f16039j + r112;
        goto L40
    L38:
        r112 = 0;
        goto L39
    }

    public final void m() {
        ViewGroup r10 = h.f24801a.d(this.R);
        if (r10 == null) goto L15;
        Sequence r11 = ViewGroupKt.a(r10);
        if (r11 == null) goto L17;
        Sequence r12 = SequencesKt___SequencesKt.j(r11, OPopover$clearFakeAnchorViewIfNecessary$1.INSTANCE);
        if (r12 == null) goto L18;
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L19;
        r10.removeView((View) r13.next());
        L.a("OPopover", "remove fake anchor view");
        goto L13
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final int n() {
        OPopoverLayout r10 = this.L;
        if (r10 == null) goto L7;
        if (r10 != null) goto L9;
        q.y("mOBubbleLayout");
        r10 = null;
    L9:
        return r10.getArrowHeight();
    L7:
        return 0;
    }

    public final int o() {
        return f16017l0.a(this.f16021a);
    }

    public final int p() {
        v();
        return getContentView().getMeasuredHeight();
    }

    public final int q() {
        v();
        return getContentView().getMeasuredWidth();
    }

    public final int r(int r10) {
        int r11 = f16017l0.a(r10);
        if (r11 != 3) goto L5;
        return 2;
    L5:
        if (r11 == 5) goto L15;
        if (r11 != 48) goto L9;
        return 3;
    L9:
        if (r11 != 80) goto L15;
        return 0;
    L15:
        return 1;
    }

    public final void s() {
        if (q.b(this.f16035h, Boolean.FALSE) == false) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(4102);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r10, int r11, int r12, int r13) {
        int r14 = f16017l0.a(r13);
        Pair r15 = i(r11, r12);     // Catch: Exception -> L6
        super.showAsDropDown(r10, r11 - ((Number) r15.getFirst()).intValue(), r12 - ((Number) r15.getSecond()).intValue(), r14);     // Catch: Exception -> L6
        this.O = false;     // Catch: Exception -> L6
        if (this.f16030e0 == false) goto L8;
        j(true);     // Catch: Exception -> L6
    L12:
        return;
    L8:
        K();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        L.c("OPopover", "showAsDropDown, error", e);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r10, int r11, int r12, int r13) {
        q.g(r10, "anchor");
        int r14 = f16017l0.a(r11);
        Pair r15 = i(r12, r13);     // Catch: Exception -> L8
        if (this.f16036h0 == false) goto L15;
        View r16 = r10.getRootView();     // Catch: Exception -> L8
        Context r17 = r10.getContext();     // Catch: Exception -> L8
        q.f(r17, "anchor.context");     // Catch: Exception -> L8
        int r18 = tc.f.n(r17);     // Catch: Exception -> L8
        Context r19 = r10.getContext();     // Catch: Exception -> L8
        q.f(r19, "anchor.context");     // Catch: Exception -> L8
        int r20 = tc.f.m(r19);     // Catch: Exception -> L8
        int r21 = wd.a.g(r10.getContext());     // Catch: Exception -> L8
        int r22 = wd.a.f25402a.f(r10.getContext());     // Catch: Exception -> L8
        if (r16.getWidth() >= r18) goto L10;
        float r23 = (r18 - r16.getWidth()) / 2.0f;     // Catch: Exception -> L8
    L11:
        int r24 = yf.b.b(r23);     // Catch: Exception -> L8
        if (r16.getHeight() >= r20) goto L14;
        int r25 = ((r20 - r16.getHeight()) + r21) + r22;     // Catch: Exception -> L8
    L16:
        super.showAtLocation(r10, r14, (r12 - ((Number) r15.getFirst()).intValue()) - r24, (r13 - ((Number) r15.getSecond()).intValue()) - r25);     // Catch: Exception -> L8
        this.O = false;     // Catch: Exception -> L8
        if (this.f16030e0 == false) goto L19;
        j(true);     // Catch: Exception -> L8
        return;
    L19:
        K();     // Catch: Exception -> L8
        return;
    L14:
        r25 = 0;
        goto L16
    L10:
        r23 = 0.0f;
        goto L11
    L15:
        r25 = 0;
        r24 = 0;
    L8:
        e = move-exception;
        L.c("OPopover", "showAtLocation, error", e);
    }

    public final void t() {
        if (q.b(this.f16035h, Boolean.TRUE) == false) goto L5;
        s();
    L5:
        OPopoverLayout r10 = null;
        if (this.f16027d == 0) goto L11;
        OPopoverLayout r11 = this.L;
        if (r11 != null) goto L10;
        q.y("mOBubbleLayout");
        r11 = null;
    L10:
        r11.setMBgColor(this.f16027d);
    L11:
        OPopoverLayout r12 = this.L;
        if (r12 != null) goto L14;
        q.y("mOBubbleLayout");
        r12 = null;
    L14:
        r12.setBubbleOrientation(r(o()));
        if (this.f16053v == 0.0f) goto L21;
        OPopoverLayout r13 = this.L;
        if (r13 != null) goto L20;
        q.y("mOBubbleLayout");
        r13 = null;
    L20:
        r13.setMPadding(this.P);
    L21:
        OPopoverLayout r14 = this.L;
        if (r14 != null) goto L24;
        q.y("mOBubbleLayout");
        r14 = null;
    L24:
        r14.getShadowConfig().e(this.f16033g);
        OPopoverLayout r15 = this.L;
        if (r15 != null) goto L27;
        q.y("mOBubbleLayout");
        r15 = null;
    L27:
        r15.getShadowConfig().h(this.D);
        OPopoverLayout r16 = this.L;
        if (r16 != null) goto L30;
        q.y("mOBubbleLayout");
        r16 = null;
    L30:
        r16.setBorderColor(this.Y);
        OPopoverLayout r17 = this.L;
        if (r17 != null) goto L33;
        q.y("mOBubbleLayout");
        r17 = null;
    L33:
        r17.setBorderWidth(this.X);
        OPopoverLayout r18 = this.L;
        if (r18 != null) goto L36;
        q.y("mOBubbleLayout");
    L37:
        r10.setTransparentBg(this.Z);
        return;
    L36:
        r10 = r18;
        goto L37
    }

    public final void v() {
        int r10 = this.f16045n;
        if (r10 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.f16046o == 0) goto L7;
        int r11 = View.MeasureSpec.makeMeasureSpec(r10, Ints.MAX_POWER_OF_TWO);
        int r12 = View.MeasureSpec.makeMeasureSpec(this.f16046o, Ints.MAX_POWER_OF_TWO);
        getContentView().measure(r11, r12);
    }

    public final void w() {
        AnimatorSet r10 = this.Q;
        if (r10 == null) goto L6;
        r10.removeAllListeners();
    L6:
        AnimatorSet r11 = this.Q;
        if (r11 == null) goto L10;
        r11.cancel();
    L10:
        this.Q = null;
        m();
        if (this.R.isFinishing() == true) goto L15;
        if (isShowing() == false) goto L15;
    L20:
        super.dismiss();     // Catch: Exception -> L19
        return;
    L22:
        return;
    L15:
        if (f16019n0 == true) goto L20;
    }

    public final void x(boolean r10) {
        this.C = r10;
    }

    public final void y(View r10) {
        OPopoverLayout r11 = new OPopoverLayout(this.R);
        this.L = r11;
        r11.setBackgroundColor(0);
        View r12 = null;
        if (this.f16044m == true) goto L5;
        OPopoverLayout r13 = this.L;
        if (r13 != null) goto L17;
        q.y("mOBubbleLayout");
        r13 = null;
    L17:
        r13.setCornerRadiusDp(OPopoverLayout.G.b());
    L19:
        if (this.F == 0.0f) goto L25;
        OPopoverLayout r14 = this.L;
        if (r14 != null) goto L24;
        q.y("mOBubbleLayout");
        r14 = null;
    L24:
        r14.setCornerRadius(this.F);
    L25:
        OPopoverLayout r15 = this.L;
        if (r15 != null) goto L28;
        q.y("mOBubbleLayout");
        r15 = null;
    L28:
        r15.setSubText(this.f16026c0);
        OPopoverLayout r16 = this.L;
        if (r16 != null) goto L31;
        q.y("mOBubbleLayout");
        r16 = null;
    L31:
        r16.setGravity(17);
        OPopoverLayout r17 = this.L;
        if (r17 != null) goto L34;
        q.y("mOBubbleLayout");
        r17 = null;
    L34:
        r17.addView(r10);
        ViewGroup.MarginLayoutParams r18 = new ViewGroup.MarginLayoutParams(-2, -2);
        OPopoverLayout r19 = this.L;
        if (r19 != null) goto L37;
        q.y("mOBubbleLayout");
        r19 = null;
    L37:
        r19.setLayoutParams(r18);
        if (this.f16027d == 0) goto L43;
        OPopoverLayout r20 = this.L;
        if (r20 != null) goto L42;
        q.y("mOBubbleLayout");
        r20 = null;
    L42:
        r20.setMBgColor(this.f16027d);
    L43:
        OPopoverLayout r21 = this.L;
        if (r21 != null) goto L46;
        q.y("mOBubbleLayout");
        r21 = null;
    L46:
        r21.setMNeedArrow(this.f16052u);
        OPopoverLayout r22 = this.L;
        if (r22 != null) goto L49;
        q.y("mOBubbleLayout");
        r22 = null;
    L49:
        r22.setMNeedShadow(this.f16031f);
        OPopoverLayout r23 = this.L;
        if (r23 != null) goto L52;
        q.y("mOBubbleLayout");
        r23 = null;
    L52:
        r23.getShadowConfig().e(this.f16033g);
        if (this.G == null) goto L59;
        OPopoverLayout r24 = this.L;
        if (r24 != null) goto L57;
        q.y("mOBubbleLayout");
        r24 = null;
    L57:
        OPopoverLayout.b r25 = r24.getShadowConfig();
        Float r26 = this.G;
        q.d(r26);
        r25.f(r26.floatValue());
    L59:
        if (this.H == null) goto L65;
        OPopoverLayout r27 = this.L;
        if (r27 != null) goto L63;
        q.y("mOBubbleLayout");
        r27 = null;
    L63:
        OPopoverLayout.b r28 = r27.getShadowConfig();
        Float r29 = this.H;
        q.d(r29);
        r28.g(r29.floatValue());
    L65:
        if (this.K == false) goto L73;
        OPopoverLayout r30 = this.L;
        if (r30 != null) goto L69;
        q.y("mOBubbleLayout");
        r30 = null;
    L69:
        r30.setClickable(true);
        OPopoverLayout r31 = this.L;
        if (r31 != null) goto L72;
        q.y("mOBubbleLayout");
        r31 = null;
    L72:
        r31.setOnClickListener(new com.obric.oui.popover.d(this));
    L77:
        OPopoverLayout r32 = this.L;
        if (r32 != null) goto L80;
        q.y("mOBubbleLayout");
        r32 = null;
    L80:
        this.M = r32;
        if (r32 != null) goto L83;
        q.y("mWindowFrame");
    L84:
        setContentView(r12);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L83:
        r12 = r32;
        goto L84
    L73:
        OPopoverLayout r33 = this.L;
        if (r33 != null) goto L76;
        q.y("mOBubbleLayout");
        r33 = null;
    L76:
        r33.setClickable(false);
        goto L77
    L5:
        if (q.b(this.f16026c0, "") == false) goto L10;
        OPopoverLayout r34 = this.L;
        if (r34 != null) goto L9;
        q.y("mOBubbleLayout");
        r34 = null;
    L9:
        r34.setCornerRadiusDp(OPopoverLayout.G.c());
        goto L19
    L10:
        OPopoverLayout r35 = this.L;
        if (r35 != null) goto L13;
        q.y("mOBubbleLayout");
        r35 = null;
    L13:
        r35.setCornerRadiusDp(OPopoverLayout.G.a());
        goto L19
    }
}
