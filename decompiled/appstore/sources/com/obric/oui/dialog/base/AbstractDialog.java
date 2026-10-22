package com.obric.oui.dialog.base;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.color.j0;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractDialog extends Dialog implements AlertDialogHost {
    public static final a R = null;
    public boolean A;
    public DialogInterface.OnShowListener B;
    public Integer C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public Boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f14355J;
    public boolean K;
    public ValueAnimator L;
    public Integer M;
    public Integer N;
    public Integer O;
    public final View.OnLayoutChangeListener P;
    public final e Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f14359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f14360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f14362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f14364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CloseIconStyle f14365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View.OnClickListener f14366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14369n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14370o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14371p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14372q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public jb.d f14373r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f14374s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f14375t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14376u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14377v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f14378w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14379x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14380y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f14381z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        private static final /* synthetic */ CloseIconStyle[] $values() {
            return new CloseIconStyle[]{LIGHT, DARK, CUSTOM};
        }

        static {
            LIGHT = new CloseIconStyle("LIGHT", 0);
            DARK = new CloseIconStyle("DARK", 1);
            CUSTOM = new CloseIconStyle("CUSTOM", 2);
            $VALUES = $values();
        }

        private CloseIconStyle(String r10, int r11) {
            super(r10, r11);
        }

        public static CloseIconStyle valueOf(String r10) {
            return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r10);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f14382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14385d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f14386e;

        public b(View r10, int r11, int r12, int r13, int r14) {
            q.g(r10, "container");
            this.f14382a = r10;
            this.f14383b = r11;
            this.f14384c = r12;
            this.f14385d = r13;
            this.f14386e = r14;
        }

        public final View a() {
            return this.f14382a;
        }

        public final int b() {
            return this.f14383b;
        }

        public final int c() {
            return this.f14384c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (q.b(this.f14382a, r11.f14382a) == true) goto L12;
            return false;
        L12:
            if (this.f14383b == r11.f14383b) goto L15;
            return false;
        L15:
            if (this.f14384c == r11.f14384c) goto L18;
            return false;
        L18:
            if (this.f14385d == r11.f14385d) goto L21;
            return false;
        L21:
            if (this.f14386e == r11.f14386e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f14382a.hashCode() * 31) + Integer.hashCode(this.f14383b)) * 31) + Integer.hashCode(this.f14384c)) * 31) + Integer.hashCode(this.f14385d)) * 31) + Integer.hashCode(this.f14386e);
        }

        public String toString() {
            return "HeightChange(container=" + this.f14382a + ", fromHeight=" + this.f14383b + ", toHeight=" + this.f14384c + ", rootFromHeight=" + this.f14385d + ", rootToHeight=" + this.f14386e + ')';
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14387a = null;

        static {
            int[] r10 = new int[CloseIconStyle.values().length];
            r10[CloseIconStyle.DARK.ordinal()] = 1;
            r10[CloseIconStyle.LIGHT.ordinal()] = 2;
            r10[CloseIconStyle.CUSTOM.ordinal()] = 3;
            f14387a = r10;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractDialog f14388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f14389b;

        public d(AbstractDialog r10, int r11) {
            this.f14388a = r10;
            this.f14389b = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            AbstractDialog.x(this.f14388a, null);
            AbstractDialog.y(this.f14388a, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            AbstractDialog.u(this.f14388a, Integer.valueOf(this.f14389b));
            AbstractDialog.w(this.f14388a, Integer.valueOf(this.f14389b));
            AbstractDialog.x(this.f14388a, null);
            AbstractDialog.y(this.f14388a, null);
        }
    }

    public static final class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractDialog f14390a;

        public e(AbstractDialog r10, Looper r11) {
            this.f14390a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            q.g(r10, "msg");
            super.handleMessage(r10);
            if (r10.what != 101) goto L6;
            AbstractDialog.r(this.f14390a);
            return;
        }
    }

    static {
        R = new a(null);
    }

    public AbstractDialog(Context r10, boolean r11, boolean r12) {
        q.g(r10, "context");
        super(r10);
        this.f14356a = r11;
        this.f14357b = r12;
        this.f14358c = "AbstractDialog";
        this.f14365j = CloseIconStyle.DARK;
        this.f14369n = true;
        this.f14371p = -1;
        this.f14379x = -1;
        this.f14380y = true;
        this.E = 81;
        Window r13 = getWindow();
        if (r13 == null) goto L6;
        r13.requestFeature(1);
    L6:
        Window r14 = getWindow();
        if (r14 == null) goto L10;
        r14.addFlags(512);
    L10:
        if (r12 == false) goto L12;
        setContentView(R$layout.o_base_dialog_with_match_parent_height);
    L13:
        View r15 = findViewById(R.id.content);
        if (r15 == null) goto L17;
        r15.setOnClickListener(new com.obric.oui.dialog.base.a(this));
    L17:
        View r16 = findViewById(R$id.root_view);
        q.f(r16, "findViewById(R.id.root_view)");
        q0(r16);
        V().setOnClickListener(new com.obric.oui.dialog.base.b());
        if ((V().getBackground() instanceof ColorDrawable) == false) goto L25;
        Drawable r17 = V().getBackground();
        if (r17 == null) goto L23;
        this.f14363h = ((ColorDrawable) r17).getColor();
    L36:
        V().setAlpha(0.0f);
        this.f14360e = (ImageView) findViewById(R$id.btn_close);
        this.f14359d = findViewById(R$id.close_container);
        if (r12 == false) goto L39;
        View r18 = V();
        ViewGroup.LayoutParams r19 = V().getLayoutParams();
        r19.height = -1;
        r18.setLayoutParams(r19);
    L39:
        i0(this, this.f14361f, null, 2, null);
        ViewStub r110 = (ViewStub) findViewById(R$id.contentView);
        r110.setLayoutResource(R());
        View r111 = r110.inflate();
        q.f(r111, "viewStub.inflate()");
        l0(r111);
        DialogAnimStyle.f14342a.c(V());
        if (o.e(r10) == true) goto L42;
    L44:
        boolean r112 = false;
    L45:
        this.f14370o = r112;
        if (r112 == false) goto L57;
        V().setBackgroundColor(0);
        com.obric.oui.material.b[] r113 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!td.i.a(V())));
        o.l(V(), r113, false, null, 6, null);
        if (OMaterialHelper.q(r10) != 1) goto L50;
    L51:
        j0 r114 = r113[0].j();
        if (r114 == null) goto L57;
        if ((V() instanceof DialogRootView) == false) goto L57;
        ((DialogRootView) V()).d(r114.b(), tc.f.a(r10, r114.c()));
        goto L57
    L50:
        if (r113.length == 1) goto L51;
    L57:
        this.P = new com.obric.oui.dialog.base.c(this);
        this.Q = new e(this, Looper.getMainLooper());
        return;
    L42:
        if (OMaterialHelper.w() == false) goto L44;
        r112 = true;
        goto L45
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L25:
        if ((V().getBackground() instanceof GradientDrawable) == false) goto L35;
        Drawable r20 = V().getBackground();
        if (r20 == null) goto L34;
        ColorStateList r21 = ((GradientDrawable) r20).getColor();
        if (r21 != null) goto L31;
        int r22 = 0;
    L32:
        this.f14363h = r22;
        goto L36
    L31:
        r22 = r21.getDefaultColor();
        goto L32
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L35:
        this.f14363h = 0;
        goto L36
    L12:
        setContentView(R$layout.o_base_dialog);
        goto L13
    }

    public static final void C(Window r10, AbstractDialog r11, ValueAnimator r12, ValueAnimator r13) {
        q.g(r10, "$w");
        q.g(r11, "this$0");
        q.g(r13, "it");
        if (r10.getDecorView().isAttachedToWindow() == false) goto L9;
        Object r14 = r13.getAnimatedValue();
        if (r14 == null) goto L8;
        Integer r15 = (Integer) r14;
        int r16 = r15.intValue();
        r11.N = r15;
        WindowManager.LayoutParams r17 = r10.getAttributes();
        r17.y = r16;
        r10.setAttributes(r17);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L9:
        r12.cancel();
    }

    public static /* synthetic */ void E(AbstractDialog r10, CloseIconStyle r11, Integer r12, Integer r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        r10.D(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    private final int S() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_layout_margin);
    }

    public static final void Z(AbstractDialog r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        q.g(r10, "this$0");
        if (r10.f14372q == true) goto L6;
        return;
    L6:
        if (r10.f14357b == false) goto L9;
        return;
    L9:
        if (r10.f14376u == false) goto L11;
        return;
    L11:
        int r20 = r15 - r13;
        int r21 = r19 - r17;
        if (r20 <= 0) goto L30;
        if (r21 <= 0) goto L31;
        if (r20 == r21) goto L32;
        int r22 = r20 - r21;
        int r23 = r10.V().getHeight();
        if (r23 <= 0) goto L19;
        int r24 = Math.max(1, r23 - r22);
    L21:
        if (r10.f14377v == false) goto L28;
        int r25 = r10.f14379x;
        if (r25 <= 0) goto L26;
        if (r20 != r25) goto L26;
        return;
    L26:
        r10.f14378w = Integer.valueOf(r20);
        return;
    L28:
        q.f(r11, "v");
        r10.e0(new b(r11, r21, r20, r24, r23));
        return;
    L19:
        r24 = r23;
        goto L21
    L32:
        return;
    L31:
        return;
    }

    public static /* synthetic */ boolean a(AbstractDialog r10) {
        return f0(r10);
    }

    public static /* synthetic */ void b(AbstractDialog r10, View r11) {
        i(r10, r11);
    }

    public static /* synthetic */ void c(View r10) {
        j(r10);
    }

    public static final void c0(AbstractDialog r10, b r11) {
        q.g(r10, "this$0");
        q.g(r11, "$change");
        r10.t0(r11.a(), r11.b(), r11.c());
    }

    public static /* synthetic */ void d(AbstractDialog r10, View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        Z(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ void e(AbstractDialog r10, View r11) {
        j0(r10, r11);
    }

    public static /* synthetic */ void f(Window r10, AbstractDialog r11, ValueAnimator r12, ValueAnimator r13) {
        C(r10, r11, r12, r13);
    }

    public static final boolean f0(AbstractDialog r10) {
        q.g(r10, "this$0");
        b r11 = r10.f14375t;
        r10.f14375t = null;
        if (r11 != null) goto L5;
        View r12 = null;
    L6:
        if (r12 != null) goto L8;
        r12 = r10.O();
    L8:
        if (r12 != null) goto L10;
        ViewTreeObserver r13 = null;
    L11:
        ViewTreeObserver.OnPreDrawListener r14 = r10.f14374s;
        if (r14 == null) goto L17;
        if (r13 == null) goto L17;
        if (r13.isAlive() == false) goto L17;
        r13.removeOnPreDrawListener(r14);
    L17:
        r10.f14374s = null;
        if (r11 != null) goto L21;
        return true;
    L21:
        if (r10.isShowing() == true) goto L23;
        return true;
    L23:
        r10.b0(r11);
        return false;
    L10:
        r13 = r12.getViewTreeObserver();
        goto L11
    L5:
        r12 = r11.a();
        goto L6
    }

    public static /* synthetic */ WindowInsets g(AbstractDialog r10, View r11, WindowInsets r12) {
        return p0(r10, r11, r12);
    }

    public static /* synthetic */ void h(AbstractDialog r10, b r11) {
        c0(r10, r11);
    }

    public static final void i(AbstractDialog r10, View r11) {
        q.g(r10, "this$0");
        r10.dismiss();
    }

    public static /* synthetic */ void i0(AbstractDialog r10, boolean r11, View.OnClickListener r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        r10.h0(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    public static final void j(View r10) {
    }

    public static final void j0(AbstractDialog r10, View r11) {
        q.g(r10, "this$0");
        r10.dismiss();
        View.OnClickListener r12 = r10.f14366k;
        if (r12 == null) goto L7;
        r12.onClick(r11);
        return;
    }

    public static final /* synthetic */ void k(AbstractDialog r10, View r11, boolean r12) {
        r10.J(r11, r12);
    }

    public static final /* synthetic */ int l(AbstractDialog r10) {
        return r10.f14379x;
    }

    public static final /* synthetic */ boolean m(AbstractDialog r10) {
        return r10.f14380y;
    }

    public static final /* synthetic */ Integer n(AbstractDialog r10) {
        return r10.f14378w;
    }

    public static final /* synthetic */ int o(AbstractDialog r10) {
        return r10.E;
    }

    public static final /* synthetic */ int p(AbstractDialog r10) {
        return r10.F;
    }

    public static final WindowInsets p0(AbstractDialog r11, View r12, WindowInsets r13) {
        q.g(r11, "this$0");
        q.g(r12, "v");
        q.g(r13, "insets");
        int r10 = r13.getInsets(WindowInsets.Type.ime()).bottom;
        wd.a r14 = wd.a.f25402a;
        int r15 = r14.d(r11.V());
        boolean r16 = r13.isVisible(WindowInsets.Type.ime());
        L.e(r11.f14358c, "onApplyWindowInsets-start, lastImeVisible: " + r11.H + ", nowImeVisible: " + r16 + "，imeHeightFromInsets: " + r10 + ", imeHeightFromHideApi: " + r15);
        Context r17 = r12.getContext();
        q.f(r17, "v.context");
        boolean r18 = wd.a.k(r17);
        Context r19 = r11.getContext();
        q.f(r19, "context");
        boolean r20 = r14.n(r19);
        Context r21 = r11.getContext();
        q.f(r21, "context");
        int r22 = 0;
        if (r14.m(r21) == true) goto L7;
        if (r20 == true) goto L7;
        int r23 = r14.f(r11.getContext());
    L8:
        int r24 = r11.S();
        if (r18 == true) goto L12;
        r24 = r24 + r23;
    L12:
        View r25 = r11.V();
        ViewGroup.LayoutParams r26 = r11.V().getLayoutParams();
        L.i(r11.f14358c, q.p("onApplyWindowInsets, bottomMargin: ", Integer.valueOf(r24)));
        if ((r26 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r26;
    L16:
        if (r27 == null) goto L19;
        r27.bottomMargin = r24;
    L19:
        r25.setLayoutParams(r26);
        boolean r28 = r13.isVisible(WindowInsets.Type.ime());
        if (r11.H == r28) goto L38;
        r11.H = r28;
        int r29 = Math.max(r13.getInsets(WindowInsets.Type.ime()).bottom, r14.d(r11.V()));
        L.i(r11.f14358c, "onApplyWindowInsets, systemBarHeight: " + r23 + ", imeHeight: " + r29);
        Context r30 = r11.getContext();
        q.f(r30, "context");
        if (r29 >= tc.f.m(r30)) goto L38;
        if (r29 > 0) goto L26;
        r11.f14355J = 0;
        if (r11.f14356a == false) goto L35;
        Context r110 = r11.getContext();
        q.f(r110, "context");
        int r31 = r23 - tc.f.b(r110, 16);
        r11.V().setPadding(0, 0, 0, r31);
        L.i(r11.f14358c, q.p("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r31)));
    L36:
        r11.B(r11.f14355J + r11.G);
        goto L38
    L35:
        L.i(r11.f14358c, q.p("onApplyWindowInsets, updat, insetsBaseYOffsetPx: ", Integer.valueOf(r23)));
        goto L36
    L26:
        if (r11.f14356a == false) goto L28;
        r12.setPadding(0, 0, 0, r29);
        L.i(r11.f14358c, q.p("onApplyWindowInsets, update rootView.padding, bottomPadding: ", Integer.valueOf(r29)));
        r11.f14355J = 0;
        goto L36
    L28:
        if (r18 == true) goto L31;
        r22 = r23;
    L31:
        r11.f14355J = r29 - r22;
        L.i(r11.f14358c, q.p("onApplyWindowInsets, update, insetsBaseYOffsetPx: ", Integer.valueOf(r29)));
    L38:
        return r13.consumeSystemWindowInsets();
    L15:
        r27 = null;
    L7:
        r23 = 0;
        goto L8
    }

    public static final /* synthetic */ int q(AbstractDialog r10) {
        return r10.G;
    }

    public static final /* synthetic */ void r(AbstractDialog r10) {
        r10.d0();
    }

    public static final /* synthetic */ void s(AbstractDialog r10, int r11) {
        r10.f14379x = r11;
    }

    public static final /* synthetic */ void t(AbstractDialog r10, View r11, int r12) {
        r10.k0(r11, r12);
    }

    public static final /* synthetic */ void u(AbstractDialog r10, Integer r11) {
        r10.O = r11;
    }

    public static final /* synthetic */ void v(AbstractDialog r10, Integer r11) {
        r10.f14378w = r11;
    }

    public static final /* synthetic */ void w(AbstractDialog r10, Integer r11) {
        r10.N = r11;
    }

    public static final /* synthetic */ void x(AbstractDialog r10, Integer r11) {
        r10.M = r11;
    }

    public static final /* synthetic */ void y(AbstractDialog r10, ValueAnimator r11) {
        r10.L = r11;
    }

    public static final /* synthetic */ void z(AbstractDialog r10, View r11, int r12, int r13) {
        r10.t0(r11, r12, r13);
    }

    public final void A() {
        this.f14368m = true;
    }

    public final void B(int r10) {
        final Window r11 = getWindow();
        if (r11 != null) goto L6;
        return;
    L6:
        if (isShowing() == true) goto L9;
        this.K = true;
        return;
    L9:
        Integer r12 = this.N;
        if (r12 != null) goto L14;
        r12 = this.O;
        if (r12 != null) goto L14;
        int r13 = r11.getAttributes().y;
    L15:
        if (r13 != r10) goto L24;
        ValueAnimator r14 = this.L;
        if (r14 == null) goto L20;
        r14.cancel();
    L20:
        this.L = null;
        this.M = null;
        this.N = Integer.valueOf(r10);
        this.O = Integer.valueOf(r10);
        WindowManager.LayoutParams r15 = r11.getAttributes();
        if (r15.y == r10) goto L41;
        r15.y = r10;
        r11.setAttributes(r15);
        return;
    L41:
        return;
    L24:
        ValueAnimator r16 = this.L;
        if (r16 != null) goto L28;
    L35:
        ValueAnimator r17 = this.L;
        if (r17 == null) goto L39;
        r17.cancel();
    L39:
        this.M = Integer.valueOf(r10);
        final ValueAnimator r18 = ValueAnimator.ofInt(new int[]{r13, r10});
        r18.setDuration(200);
        r18.setInterpolator(new DecelerateInterpolator(1.5f));
        r18.addUpdateListener(new f(r11, this, r18));
        r18.addListener(new d(this, r10));
        this.L = r18;
        r18.start();
        return;
    L28:
        if (r16.isRunning() != true) goto L35;
        Integer r19 = this.M;
        if (r19 == null) goto L35;
        if (r19.intValue() != r10) goto L35;
        return;
    L14:
        r13 = r12.intValue();
        goto L15
    }

    public final void D(CloseIconStyle r10, Integer r11, Integer r12) {
        q.g(r10, "style");
        if (this.f14361f == false) goto L38;
        int r13 = c.f14387a[r10.ordinal()];
        if (r13 != 1) goto L7;
        int r14 = R$color.ConstTextInverse;
        r12 = Integer.valueOf(R$color.ConstBGContainer7);
    L17:
        ImageView r15 = this.f14360e;
        if (r15 == null) goto L21;
        r15.setImageTintList(ContextCompat.c(getContext(), r14));
    L21:
        GradientDrawable r16 = null;
        if (r12 != null) goto L27;
        View r17 = this.f14359d;
        if (r17 == null) goto L40;
        r17.setBackground(null);
        return;
    L40:
        return;
    L27:
        View r18 = this.f14359d;
        if (r18 != null) goto L30;
        Drawable r19 = null;
    L32:
        if ((r19 instanceof GradientDrawable) == false) goto L34;
        r16 = (GradientDrawable) r19;
    L34:
        if (r16 == null) goto L41;
        r16.setColor(ContextCompat.c(getContext(), r12.intValue()));
        return;
    L41:
        return;
    L30:
        r19 = r18.getBackground();
        goto L32
    L7:
        if (r13 != 2) goto L9;
        r14 = R$color.TextReverse;
        r12 = Integer.valueOf(R$color.ConstTextInverse5);
        goto L17
    L9:
        if (r13 != 3) goto L14;
        if (r11 != null) goto L12;
        r14 = R$color.ConstTextInverse;
        goto L17
    L12:
        r14 = r11.intValue();
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void F() {
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (this.f14357b == false) goto L8;
        return;
    L8:
        Window r10 = getWindow();
        if (r10 != null) goto L11;
        return;
    L11:
        WindowManager.LayoutParams r11 = r10.getAttributes();
        Integer r12 = this.C;
        if (r12 != null) goto L14;
    L19:
        int r13 = this.D;
        if (r13 > 0) goto L22;
        return;
    L22:
        if (r11.height == r13) goto L27;
        r11.height = r13;
        r10.setAttributes(r11);
        return;
    L27:
        return;
    L14:
        if (r12.intValue() <= 0) goto L19;
        if (r11.height == r12.intValue()) goto L25;
        r11.height = r12.intValue();
        r10.setAttributes(r11);
        return;
    }

    public final void G() {
        final Window r10 = getWindow();
        if (r10 != null) goto L5;
        return;
    L5:
        new AbstractDialog$applyWindowPositionIfNeeded$apply$1(r10, this).invoke();
    }

    public final void H(boolean r10) {
        jb.d r11 = this.f14373r;
        if (r11 == null) goto L7;
        this.f14380y = r10;
        jb.d.c(r11, false, 1, null);
        this.f14380y = true;
        this.f14373r = null;
        return;
    }

    public final void I() {
        View r10 = this.f14381z;
        if (r10 != null) goto L5;
        r10 = O();
    L5:
        H(true);
        if (r10 != null) goto L8;
    L10:
        if (r10 == null) goto L12;
        v0(r10, false);
    L12:
        this.f14375t = null;
        this.f14378w = null;
        View r11 = O();
        if (r11 != null) goto L15;
        ViewTreeObserver r12 = null;
    L16:
        ViewTreeObserver.OnPreDrawListener r13 = this.f14374s;
        if (r11 == null) goto L23;
        if (r13 == null) goto L23;
        if (r12 == null) goto L23;
        if (r12.isAlive() == false) goto L23;
        r12.removeOnPreDrawListener(r13);
    L23:
        this.f14374s = null;
        if (r11 == null) goto L28;
        r11.removeOnLayoutChangeListener(this.P);
    L28:
        if (this.C != null) goto L31;
        this.D = 0;
        return;
    L31:
        return;
    L15:
        r12 = r11.getViewTreeObserver();
        goto L16
    L8:
        if (this.f14377v == false) goto L10;
        J(r10, true);
        goto L12
    }

    public final void J(View r10, boolean r11) {
        this.f14377v = false;
        this.f14379x = -1;
        this.f14381z = null;
        if (r11 == false) goto L5;
        this.f14376u = true;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        r12.height = -2;
        r10.setLayoutParams(r12);
        this.f14376u = false;
        r10.requestLayout();
    L5:
        v0(r10, false);
    }

    public final void K() {
        this.f14367l = true;
    }

    public final boolean L() {
        return this.f14368m;
    }

    public final DialogInterface.OnShowListener M() {
        return this.B;
    }

    public final Integer N() {
        return this.C;
    }

    public View O() {
        return null;
    }

    public final boolean P() {
        return this.f14367l;
    }

    public final int Q() {
        return this.f14355J;
    }

    public abstract int R();

    public int T(Window r10) {
        q.g(r10, "<this>");
        return r10.getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_layout_margin);
    }

    public final boolean U() {
        return this.f14357b;
    }

    public final View V() {
        View r10 = this.f14362g;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("rootView");
        return null;
    }

    public final boolean W() {
        return this.A;
    }

    public final float X(Context r10) {
        q.g(r10, "context");
        if ((r10.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return 0.8f;
    L5:
        return 0.32f;
    }

    public final boolean Y() {
        return this.f14356a;
    }

    public final void a0(Window r10) {
        if (r10 == null) goto L6;
        r10.setNavigationBarContrastEnforced(false);
    L6:
        if (r10 == null) goto L9;
        r10.clearFlags(134217728);
    L9:
        if (r10 == null) goto L12;
        r10.addFlags(Integer.MIN_VALUE);
    L12:
        if (r10 == null) goto L15;
        r10.setNavigationBarColor(0);
    L15:
        if (r10 == null) goto L18;
        r10.setDecorFitsSystemWindows(false);
    L18:
        if (r10 == null) goto L22;
        r10.setNavigationBarDividerColor(0);
        return;
    }

    public final void b0(final b r10) {
        if (r10.b() > 0) goto L5;
        return;
    L5:
        if (r10.c() > 0) goto L7;
        return;
    L7:
        if (r10.b() == r10.c()) goto L13;
        H(false);
        this.f14377v = true;
        this.f14379x = r10.b();
        this.f14381z = r10.a();
        v0(r10.a(), true);
        k0(r10.a(), r10.b());
        r10.a().requestLayout();
        r10.a().post(new h(this, r10));
        return;
    }

    public final void d0() {
    L17:
        e = move-exception;
        L.c(this.f14358c, "recheckInset failed", e);
        return;
    L3:
        if (wd.a.f25402a.d(V()) <= 0) goto L5;
        return;
    L5:
        if (this.f14356a == false) goto L23;
        td.c r10 = td.c.f24796a;     // Catch: Exception -> L17
        Object r11 = V().getParent();     // Catch: Exception -> L17
        if (r11 != null) goto L10;
    L8:
        r11 = null;
    L11:
        View r12 = (View) r11;     // Catch: Exception -> L17
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.getHeight() <= V().getHeight()) goto L25;
        V().requestLayout();     // Catch: Exception -> L17
        L.i(this.f14358c, "recheckInset, requestLayout, parentView.height: " + r12.getHeight() + ", rootView.height: " + V().getHeight());     // Catch: Exception -> L17
        return;
    L25:
        return;
    L10:
        if ((r11 instanceof View) == false) goto L8;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        V().setOnApplyWindowInsetsListener(null);
        ValueAnimator r10 = this.L;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        this.A = false;
        super.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        L.c(this.f14358c, "origin Dismiss exception!", e);
    }

    public final void e0(b r10) {
        this.f14375t = r10;
        if (this.f14374s != null) goto L5;
        this.f14374s = new g(this);
    L5:
        ViewTreeObserver.OnPreDrawListener r11 = this.f14374s;
        if (r11 == null) goto L13;
        ViewTreeObserver r12 = r10.a().getViewTreeObserver();
        if (r12.isAlive() == false) goto L12;
        r12.removeOnPreDrawListener(r11);
        r12.addOnPreDrawListener(r11);
        return;
    L12:
        return;
    }

    public final void g0(boolean r10) {
        this.f14369n = r10;
    }

    public void h0(boolean r10, View.OnClickListener r11) {
        this.f14361f = r10;
        this.f14366k = r11;
        ImageView r12 = this.f14360e;
        if (r12 == null) goto L21;
        Context r13 = getContext();
        q.f(r13, "context");
        tc.l.c(r12, tc.f.b(r13, 44));
        if (r10 == false) goto L15;
        View r14 = this.f14359d;
        if (r14 == null) goto L11;
        tc.l.m(r14);
    L11:
        E(this, this.f14365j, null, null, 6, null);
        View r15 = this.f14359d;
        if (r15 == null) goto L22;
        r15.setOnClickListener(new com.obric.oui.dialog.base.d(this));
        return;
    L22:
        return;
    L15:
        View r16 = this.f14359d;
        if (r16 == null) goto L23;
        tc.l.k(r16);
        return;
    L23:
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.AlertDialogHost
    public boolean isAutoDismiss() {
        return this.f14369n;
    }

    public final void k0(View r10, int r11) {
        this.f14376u = true;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        r12.height = r11;
        r10.setLayoutParams(r12);
        this.f14376u = false;
    }

    public final void l0(View r10) {
        q.g(r10, "<set-?>");
        this.f14364i = r10;
    }

    public final AbstractDialog m0(Boolean r10) {
        this.I = r10;
        return this;
    }

    public final void n0(int r10) {
        this.f14371p = r10;
    }

    public final void o0() {
        V().setOnApplyWindowInsetsListener(new com.obric.oui.dialog.base.e(this));
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.Q.removeCallbacksAndMessages(null);
        I();
    }

    public final void q0(View r10) {
        q.g(r10, "<set-?>");
        this.f14362g = r10;
    }

    public final AbstractDialog r0(int r10) {
        Integer r11 = Integer.valueOf(r10);
        if (r11.intValue() > 0) goto L6;
        r11 = null;
    L6:
        this.C = r11;
        F();
        return this;
    }

    public final void s0() {
        if (this.f14357b == false) goto L5;
        return;
    L5:
        View r10 = O();
        if (r10 != null) goto L8;
        return;
    L8:
        r10.removeOnLayoutChangeListener(this.P);
        r10.addOnLayoutChangeListener(this.P);
    }

    public final void setCompleteShowListener(@Nullable DialogInterface.OnShowListener r10) {
        this.B = r10;
    }

    @Override // android.app.Dialog
    public void show() {
        o0();
        super.show();
        s0();
        F();
        Window r10 = getWindow();
        if (r10 == null) goto L58;
        if (W() == false) goto L8;
        return;
    L8:
        r10.setBackgroundDrawableResource(R.color.transparent);
        Window r11 = getWindow();
        if (r11 == null) goto L13;
        r11.setWindowAnimations(0);
    L13:
        if (L() == false) goto L18;
        Window r12 = getWindow();
        if (r12 == null) goto L19;
        r12.clearFlags(2);
    L19:
        a0(r10);
        WindowManager.LayoutParams r13 = r10.getAttributes();
        r13.gravity = this.E;
        r13.x = this.F;
        r13.y = Q() + this.G;
        r13.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        RadiusLayout r14 = null;
        if (U() == false) goto L22;
        r13.height = -1;
    L33:
        if (Y() == false) goto L47;
        View r15 = V();
        ViewGroup.LayoutParams r16 = V().getLayoutParams();
        r16.width = -1;
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
    L38:
        if (r17 == null) goto L41;
        r17.bottomMargin = 0;
    L41:
        r15.setLayoutParams(r16);
        View r18 = V();
        if ((r18 instanceof RadiusLayout) == false) goto L44;
        r14 = (RadiusLayout) r18;
    L44:
        if (r14 == null) goto L53;
        float r19 = r14.getContext().getResources().getDimension(R$dimen.oui_r_l3);
        r14.c(r19, r19, 0.0f, 0.0f);
    L53:
        if (L() == false) goto L55;
        Context r20 = r10.getContext();
        q.f(r20, "context");
        r13.dimAmount = X(r20);
    L56:
        wd.a r21 = wd.a.f25402a;
        Context r22 = r10.getContext();
        q.f(r22, "context");
        Activity r23 = r21.b(r22);
        q.f(r13, "params");
        wd.a.a(r23, r13, this.I);
        r10.setAttributes(r13);
        goto L58
    L55:
        r13.dimAmount = 0.0f;
        goto L56
    L37:
        r17 = null;
        goto L38
    L47:
        Size r24 = wd.a.c(r10.getContext());
        int r25 = Math.min(r24.getWidth(), r24.getHeight()) - (T(r10) * 2);
        View r26 = V();
        ViewGroup.LayoutParams r27 = V().getLayoutParams();
        r27.width = r25;
        r26.setLayoutParams(r27);
        V().measure(View.MeasureSpec.makeMeasureSpec(r25, Integer.MIN_VALUE), 0);
        if (r24.getWidth() >= r24.getHeight()) goto L53;
        int r28 = r24.getHeight();
        Context r29 = r10.getContext();
        q.f(r29, "context");
        int r30 = r28 - tc.f.b(r29, 232);
        if (V().getMeasuredHeight() <= r30) goto L53;
        n0(V().getMeasuredHeight() - r30);
        goto L53
    L22:
        Integer r31 = N();
        if (r31 != null) goto L30;
        r31 = Integer.valueOf(this.D);
        if (r31.intValue() > 0) goto L28;
        r31 = null;
    L28:
        if (r31 != null) goto L30;
        int r32 = -2;
    L31:
        r13.height = r32;
    L30:
        r32 = r31.intValue();
        goto L31
    L18:
        r10.addFlags(2);
    L58:
        if (this.K == false) goto L60;
        G();
    L60:
        this.A = true;
    }

    public final void t0(final View r10, int r11, int r12) {
        if (this.f14372q == true) goto L5;
        return;
    L5:
        if (this.f14357b == false) goto L8;
        return;
    L8:
        if (isShowing() == true) goto L11;
        return;
    L11:
        if (r11 != r12) goto L14;
        J(r10, true);
        return;
    L14:
        this.f14377v = true;
        this.f14378w = null;
        this.f14381z = r10;
        com.obric.common.oea.foundation.animation.spec.spring.b r13 = kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null);
        r13.e(0.3f);
        Unit r14 = Unit.f21064a;
        this.f14373r = com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), r11, r12, r13, null, 8, null).g(new AbstractDialog$startHeightAnimator$2(this, r10)).f(new AbstractDialog$startHeightAnimator$3(this, r10)).c().a();
    }

    public void u0(View r10, boolean r11) {
        q.g(r10, "container");
        ViewGroup r12 = null;
        if ((r10 instanceof RadiusLayout) == false) goto L5;
        RadiusLayout r13 = (RadiusLayout) r10;
    L6:
        if (r13 != null) goto L8;
        Unit r14 = null;
    L9:
        if (r14 == null) goto L11;
        return;
    L11:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        r12 = (ViewGroup) r10;
    L13:
        if (r12 == null) goto L18;
        r12.suppressLayout(r11);
        return;
    L18:
        return;
    L8:
        r13.setSuppressChildMeasureAndLayout(r11);
        r14 = Unit.f21064a;
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    public final void v0(View r10, boolean r11) {
        u0(r10, r11);
    }
}
