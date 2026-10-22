package com.obric.oui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
public class c extends a {
    public Integer A;
    public boolean B;
    public Integer C;
    public Function0 D;
    public boolean E;
    public ConstraintLayout F;
    public RadiusLayout G;
    public RadiusLayout H;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f15845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f15846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f15847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f15848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.obric.oui.panel.header.b f15849r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f15850s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1 f15851t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15852u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f15853v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View.OnClickListener f15854w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15855x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f15856y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f15857z;

    public c(Context r10, int r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f15843l = -1;
        this.f15847p = true;
        this.B = true;
        this.E = true;
    }

    private final void p() {
        if (this.f15849r != null) goto L5;
        Context r10 = getContext();
        q.f(r10, "context");
        this.f15849r = new com.obric.oui.panel.header.a(r10, null, null, 6, null);
    L5:
        k();
        if (this.E == false) goto L8;
        FrameLayout r11 = i();
        q.f(r11, "bottomSheet");
        float r12 = f.u(r11, 20);
    L9:
        RadiusLayout r13 = this.G;
        if (r13 == null) goto L14;
        r13.c(r12, r12, 0.0f, 0.0f);
    L14:
        if (this.f15846o == false) goto L19;
        RadiusLayout r14 = this.H;
        if (r14 == null) goto L19;
        r14.c(r12, r12, 0.0f, 0.0f);
    L19:
        com.obric.oui.panel.header.b r15 = this.f15849r;
        if (r15 != null) goto L22;
    L21:
        ViewParent r16 = null;
    L27:
        if ((r16 instanceof ViewGroup) == false) goto L46;
        com.obric.oui.panel.header.b r17 = this.f15849r;
        if (r17 != null) goto L31;
    L30:
        ViewParent r18 = null;
    L36:
        if ((r18 instanceof ViewGroup) == false) goto L38;
        ViewGroup r19 = (ViewGroup) r18;
    L39:
        if (r19 == null) goto L46;
        com.obric.oui.panel.header.b r20 = this.f15849r;
        if (r20 != null) goto L44;
        View r21 = null;
    L45:
        r19.removeView(r21);
        goto L46
    L44:
        r21 = r20.e();
        goto L45
    L38:
        r19 = null;
        goto L39
    L31:
        View r22 = r17.e();
        if (r22 == null) goto L30;
        r18 = r22.getParent();
    L46:
        RadiusLayout r23 = this.G;
        if (r23 == null) goto L55;
        com.obric.oui.panel.header.b r24 = this.f15849r;
        if (r24 != null) goto L52;
        View r25 = null;
    L53:
        l.o(r23, r25);
        goto L55
    L52:
        r25 = r24.e();
    L55:
        if (this.f15846o == false) goto L67;
        if (this.H == null) goto L67;
        ConstraintSet r26 = new ConstraintSet();
        r26.q(this.F);
        RadiusLayout r27 = this.H;
        q.d(r27);
        r26.o(r27.getId(), 3);
        RadiusLayout r28 = this.H;
        q.d(r28);
        r26.t(r28.getId(), 3, 0, 3);
        r26.i(this.F);
        RadiusLayout r29 = this.G;
        if (r29 == null) goto L62;
        r29.setBackground(null);
    L62:
        RadiusLayout r30 = this.G;
        if (r30 == null) goto L67;
        r30.bringToFront();
    L67:
        if (this.f15847p == true) goto L73;
        Window r31 = getWindow();
        if (r31 == null) goto L73;
        r31.setDimAmount(0.0f);
    L73:
        if (this.f15848q == false) goto L95;
        Integer r32 = this.C;
        if (r32 == null) goto L77;
        int r33 = r32.intValue();
        Window r34 = getWindow();
        if (r34 == null) goto L98;
        r34.setNavigationBarColor(r33);
        return;
    L98:
        return;
    L77:
        if (this.f15850s == false) goto L83;
        if (this.f15844m == false) goto L81;
        int r35 = R$color.BGPanelTone;
    L86:
        Window r36 = getWindow();
        if (r36 == null) goto L97;
        r36.setNavigationBarColor(ContextCompat.b(getContext(), r35));
        return;
    L97:
        return;
    L81:
        r35 = R$color.BGPanelTint;
        goto L86
    L83:
        if (this.f15844m == false) goto L85;
        r35 = R$color.ConstBGPanelReverse;
        goto L86
    L85:
        r35 = R$color.ConstTextInverse;
        goto L86
    L95:
        return;
    L22:
        View r37 = r15.e();
        if (r37 == null) goto L21;
        r16 = r37.getParent();
        goto L27
    L8:
        r12 = 0.0f;
        goto L9
    }

    public final void A(int r10) {
        FrameLayout r11 = (FrameLayout) findViewById(R$id.design_bottom_sheet);
        if (r11 == null) goto L6;
        r11.getLayoutParams().height = r10;
        return;
    }

    public final void B(Integer r10) {
        this.A = r10;
    }

    public final void C(boolean r10) {
        FrameLayout r11 = (FrameLayout) findViewById(R$id.container);
        if (r11 == null) goto L7;
        r11.setFitsSystemWindows(r10);
        return;
    }

    public final void D(boolean r10) {
        this.B = r10;
    }

    public final void E(boolean r10) {
        this.f15853v = r10;
    }

    public final void F(boolean r10) {
        this.f15846o = r10;
    }

    public final void G(int r10) {
        this.f15843l = r10;
    }

    public final void H(Integer r10) {
        this.C = r10;
    }

    public final void I(Function0 r10) {
        this.D = r10;
    }

    public final void J(OBasicPanel$PadCompatConfig r10) {
    }

    public final void K(com.obric.oui.panel.header.b r10) {
        this.f15849r = r10;
    }

    public final void L(boolean r10) {
        this.f15852u = r10;
    }

    public final void M(boolean r10) {
        this.f15844m = r10;
    }

    public final View N(int r10, View r11, ViewGroup.LayoutParams r12) {
        l();
        if (r10 == 0) goto L6;
        if (r11 != null) goto L6;
        r11 = getLayoutInflater().inflate(r10, this.H, false);
    L6:
        RadiusLayout r13 = this.H;
        if (r13 == null) goto L10;
        r13.removeAllViews();
    L10:
        if (r12 != null) goto L15;
        RadiusLayout r14 = this.H;
        if (r14 == null) goto L19;
        r14.addView(r11);
    L19:
        p();
        ConstraintLayout r15 = this.F;
        q.d(r15);
        return r15;
    L15:
        RadiusLayout r16 = this.H;
        if (r16 == null) goto L19;
        r16.addView(r11, r12);
        goto L19
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "ev");
        Function1 r11 = this.f15851t;
        if (r11 == null) goto L10;
        if (((Boolean) r11.invoke(r10)).booleanValue() == false) goto L10;
        return true;
    L10:
        return super.dispatchTouchEvent(r10);
    }

    public final void k() {
    }

    public final void l() {
        if (this.F != null) goto L5;
    L8:
        RadiusLayout r10 = null;
        ConstraintLayout r11 = (ConstraintLayout) View.inflate(getContext(), R$layout.o_basic_panel, null);
        this.F = r11;
        if (r11 != null) goto L11;
        RadiusLayout r12 = null;
    L12:
        this.G = r12;
        ConstraintLayout r13 = this.F;
        if (r13 == null) goto L16;
        r10 = (RadiusLayout) r13.findViewById(R$id.content_container);
    L16:
        this.H = r10;
        return;
    L11:
        r12 = (RadiusLayout) r11.findViewById(R$id.header_container);
        goto L12
    L5:
        if (this.G == null) goto L8;
        if (this.H == null) goto L8;
    }

    public final int m() {
        if (this.f15850s == false) goto L9;
        if (this.f15844m == false) goto L7;
        int r10 = R$color.BGPanelTone;
    L13:
        return ContextCompat.b(getContext(), r10);
    L7:
        r10 = R$color.BGPanelTint;
        goto L13
    L9:
        if (this.f15844m == false) goto L11;
        r10 = R$color.ConstBGPanelReverse;
        goto L13
    L11:
        r10 = R$color.ConstTextInverse;
        goto L13
    }

    public final int n() {
        Integer r10 = this.A;
        if (r10 == null) goto L6;
        q.d(r10);
        return r10.intValue();
    L6:
        Context r11 = getContext();
        q.f(r11, "context");
        return (int) (((double) f.m(r11)) * 0.9d);
    }

    public final int o() {
        Integer r10 = this.f15857z;
        if (r10 == null) goto L6;
        q.d(r10);
        return r10.intValue();
    L6:
        Resources r11 = getContext().getResources();
        if (r11 != null) goto L9;
        Integer r12 = null;
    L10:
        boolean r13 = false;
        if (r12 == null) goto L21;
        if (r12.intValue() <= 0) goto L21;
        Resources r14 = getContext().getResources();
        if (r14 != null) goto L17;
        boolean r15 = false;
    L18:
        if (r15 == false) goto L21;
        r13 = true;
        goto L21
    L17:
        r15 = r14.getBoolean(r12.intValue());
    L21:
        if (r13 == false) goto L24;
        Context r16 = getContext();
        q.f(r16, "context");
        return (int) (((double) f.m(r16)) * 0.65d);
    L24:
        Context r17 = getContext();
        q.f(r17, "context");
        return (int) (((double) f.m(r17)) * 0.6d);
    L9:
        r12 = Integer.valueOf(r11.getIdentifier("config_showNavigationBar", "bool", "android"));
        goto L10
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onBackPressed() {
        Function0 r10 = this.D;
        if (r10 != null) goto L6;
    L8:
        super.onBackPressed();
        return;
    L6:
        if (((Boolean) r10.invoke()).booleanValue() != true) goto L8;
    }

    @Override // com.obric.oui.panel.a, androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        boolean r11 = true;
        h().setHideable(true);
        h().E = this.B;
        h().j(!this.f15856y);
        if (this.f15845n == false) goto L5;
        j(true);
        h().setPeekHeight(o());
        return;
    L5:
        BottomSheetBehavior r12 = h();
        com.obric.oui.panel.header.b r13 = this.f15849r;
        if (r13 != null) goto L9;
    L11:
        r11 = false;
    L12:
        r12.setDraggable(r11);
        if (this.f15843l <= 0) goto L19;
        h().m(this.f15843l);
        if (this.f15853v == false) goto L20;
        A(this.f15843l);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        if (r13.c() != true) goto L11;
        goto L11
    }

    @Override // com.obric.oui.panel.a, androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        if (this.f15852u == false) goto L6;
        q();
    L6:
        if (this.E == false) goto L8;
        FrameLayout r10 = i();
        q.f(r10, "bottomSheet");
        float r11 = f.u(r10, 20);
    L9:
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        r12.setCornerRadii(new float[]{r11, r11, r11, r11, 0.0f, 0.0f, 0.0f, 0.0f});
        r12.setColor(m());
        FrameLayout r13 = i();
        if (r13 == null) goto L14;
        r13.setBackground(r12);
    L14:
        if (this.f15845n == false) goto L16;
        A(n());
    L16:
        C(this.B);
        h().l(this.f15845n);
        if (this.f15854w == null) goto L22;
        View r14 = findViewById(R$id.touch_outside);
        if (r14 == null) goto L22;
        r14.setOnClickListener(this.f15854w);
    L22:
        e(this.f15855x);
        return;
    L8:
        r11 = 0.0f;
        goto L9
    }

    public final void q() {
        FrameLayout r10 = (FrameLayout) findViewById(R$id.design_bottom_sheet);
        if (r10 == null) goto L6;
        r10.setMinimumHeight(0);
        return;
    }

    public final void r(boolean r10) {
        this.f15848q = r10;
    }

    public final void s(boolean r10) {
        this.f15855x = r10;
    }

    @Override // com.obric.oui.panel.a, androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10) {
        q.g(r10, "view");
        super.setContentView(N(0, r10, null));
    }

    public final void setOutsideClickListener(@Nullable View.OnClickListener r10) {
        this.f15854w = r10;
    }

    public final void t(boolean r10) {
        this.f15850s = r10;
    }

    public final void u(boolean r10) {
        this.f15847p = r10;
    }

    public final void v(boolean r10) {
        this.E = r10;
    }

    public final void w(Integer r10) {
        this.f15857z = r10;
    }

    public final void x(boolean r10) {
        this.f15856y = r10;
    }

    public final void y(Function1 r10) {
        this.f15851t = r10;
    }

    public final void z(boolean r10) {
        this.f15845n = r10;
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r10) {
        super.setContentView(N(r10, null, null));
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        q.g(r10, "view");
        super.setContentView(N(0, r10, r11));
    }
}
