package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.base.i;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.ImageStyleController;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import com.obric.oui.dialog.v2.common.IImageLoader;
import com.obric.oui.dialog.v2.common.IOImageLoadDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public class OAlertDialogBuilder extends i {
    public DialogInterface.OnClickListener A;
    public ButtonStyleController.TextColorType B;
    public CharSequence C;
    public DialogInterface.OnClickListener D;
    public ButtonStyleController.TextColorType E;
    public boolean F;
    public CharSequence G;
    public DialogInterface.OnClickListener H;
    public ButtonStyleController.TextColorType I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f14451J;
    public StyleController K;
    public StyleController L;
    public boolean M;
    public boolean N;
    public boolean O;
    public View P;
    public boolean Q;
    public boolean R;
    public Boolean S;
    public Function2 T;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f14452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f14453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f14454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f14456p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f14457q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IOImageLoadDelegate f14458r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IImageLoader f14459s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f14460t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f14461u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14462v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14463w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14464x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14465y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f14466z;

    public OAlertDialogBuilder(Context r10) {
        q.g(r10, "context");
        super(r10);
        this.f14452l = r10;
        this.f14457q = "";
        this.f14451J = true;
        super.b(false);
    }

    public static /* synthetic */ OAlertDialogBuilder B(OAlertDialogBuilder r10, int r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.y(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public static /* synthetic */ OAlertDialogBuilder C(OAlertDialogBuilder r10, CharSequence r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.z(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    private static final void D(Function2 r10, DialogInterface r11, int r12) {
        q.g(r10, "$listener");
        q.f(r11, "dialog");
        r10.mo0invoke(r11, Integer.valueOf(r12));
    }

    public static /* synthetic */ OAlertDialogBuilder K(OAlertDialogBuilder r10, int r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.G(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public static /* synthetic */ OAlertDialogBuilder L(OAlertDialogBuilder r10, CharSequence r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.I(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    private static final void M(Function2 r10, DialogInterface r11, int r12) {
        q.g(r10, "$listener");
        q.f(r11, "dialog");
        r10.mo0invoke(r11, Integer.valueOf(r12));
    }

    public static /* synthetic */ OAlertDialogBuilder P(OAlertDialogBuilder r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = false;
    L7:
        return r10.O(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    private final void Q(CharSequence r10, Function1 r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        q.d(r10);
        r11.invoke(r10);
        return;
    }

    public static /* synthetic */ void l(Function2 r10, DialogInterface r11, int r12) {
        M(r10, r11, r12);
    }

    public static /* synthetic */ void m(Function2 r10, DialogInterface r11, int r12) {
        D(r10, r11, r12);
    }

    public static final /* synthetic */ boolean n(OAlertDialogBuilder r10) {
        return r10.O;
    }

    public static /* synthetic */ OAlertDialogBuilder u(OAlertDialogBuilder r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L7;
        r11 = false;
    L7:
        return r10.t(r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalButton");
    }

    public final OAlertDialogBuilder A(CharSequence r10, final Function2 r11) {
        q.g(r10, "text");
        q.g(r11, "listener");
        this.f14466z = r10;
        this.A = new c(r11);
        return this;
    }

    public OAlertDialog E(Context r10, boolean r11) {
        q.g(r10, "context");
        return new OAlertDialog(r10, r11);
    }

    public final OAlertDialogBuilder F(int r10, DialogInterface.OnClickListener r11) {
        return K(this, r10, r11, null, 4, null);
    }

    public final OAlertDialogBuilder G(int r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        String r13 = this.f14452l.getString(r10);
        q.f(r13, "context.getString(text)");
        return I(r13, r11, r12);
    }

    public final OAlertDialogBuilder H(CharSequence r10, DialogInterface.OnClickListener r11) {
        q.g(r10, "text");
        return L(this, r10, r11, null, 4, null);
    }

    public final OAlertDialogBuilder I(CharSequence r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        q.g(r10, "text");
        this.C = r10;
        this.D = r11;
        this.E = r12;
        return this;
    }

    public final OAlertDialogBuilder J(CharSequence r10, final Function2 r11) {
        q.g(r10, "text");
        q.g(r11, "listener");
        this.C = r10;
        this.D = new d(r11);
        return this;
    }

    public final OAlertDialogBuilder N(int r10) {
        P(this, this.f14452l.getText(r10), false, 2, null);
        return this;
    }

    public final OAlertDialogBuilder O(CharSequence r10, boolean r11) {
        this.f14455o = r11;
        this.f14453m = r10;
        return this;
    }

    @Override // com.obric.oui.dialog.base.i
    public /* bridge */ /* synthetic */ AbstractDialog c() {
        return q();
    }

    public final OAlertDialogBuilder o(boolean r10) {
        this.f14451J = r10;
        return this;
    }

    public final OAlertDialogBuilder p(StyleController r10) {
        q.g(r10, "controller");
        this.K = r10;
        return this;
    }

    public OAlertDialog q() {
        final OAlertDialog r10 = E(this.f14452l, this.M);
        if (this.f14455o == false) goto L5;
        r10.P0(this.f14453m);
    L6:
        Q(this.f14454n, new OAlertDialogBuilder$createDialog$1(r10, this));
        StyleController r11 = this.L;
        if (r11 != null) goto L9;
        Unit r12 = null;
    L10:
        if (r12 != null) goto L15;
        ImageStyleController r13 = r();
        if (r13 == null) goto L15;
        r10.R0(r13);
    L15:
        r10.g0(this.f14451J);
        Function2 r14 = this.T;
        if (r14 != null) goto L18;
        ButtonStyleController r15 = null;
    L19:
        if (r15 != null) goto L21;
        r15 = new bd.d(this.f14452l, this.f14465y);
    L21:
        r10.M0(r15);
        StyleController r16 = this.K;
        if (r16 == null) goto L26;
        r10.L0(r16);
    L26:
        if (f() == true) goto L33;
        if (this.f14465y != 2) goto L30;
        boolean r17 = true;
    L31:
        i.k(this, r17, null, 2, null);
        goto L33
    L30:
        r17 = false;
    L33:
        if (this.N == false) goto L36;
        i.k(this, false, null, 2, null);
    L36:
        if (this.Q == false) goto L39;
        r10.K();
    L39:
        if (this.R == false) goto L41;
        r10.A();
    L41:
        r10.m0(this.S);
        r10.setOnShowListener(g());
        r10.setOnDismissListener(e());
        r10.setOnCancelListener(d());
        r15.g(this.C, this.D, this.E, this.F);
        r15.e(this.f14466z, this.A, this.B);
        r15.f(this.G, this.H, this.I);
        View r18 = this.P;
        if (r18 == null) goto L44;
        q.d(r18);
        r15.d(r18);
    L44:
        return r10;
    L18:
        r15 = (ButtonStyleController) r14.mo0invoke(this.f14452l, Integer.valueOf(this.f14465y));
        goto L19
    L9:
        r10.R0(r11);
        r12 = Unit.f21064a;
        goto L10
    L5:
        r10.Q0(this.f14453m);
        goto L6
    }

    public final ImageStyleController r() {
        if (this.f14457q.length() > 0) goto L5;
    L7:
        boolean r10 = false;
    L8:
        Drawable r11 = this.f14456p;
        if (r11 != null) goto L15;
        if (r10 == true) goto L15;
        if (this.f14459s != null) goto L15;
        return null;
    L15:
        boolean r12 = this.f14462v;
        ImageStyleController r13 = new ImageStyleController(this.f14452l, r12 ? 1 : 0);
        r13.e(this.f14463w);
        r13.d(this.f14464x);
        IImageLoader r14 = this.f14459s;
        if (r14 == null) goto L18;
        q.d(r14);
        r13.j(r14);
    L29:
        return r13;
    L18:
        if (r11 == null) goto L20;
        r13.f(r11);
        r13.i(this.f14460t, this.f14461u);
        goto L29
    L20:
        r13.g(this.f14457q);
        IOImageLoadDelegate r15 = this.f14458r;
        if (r15 == null) goto L24;
        r13.h(r15);
    L24:
        Integer r16 = this.f14460t;
        if (r16 == null) goto L29;
        Integer r17 = this.f14461u;
        if (r17 == null) goto L29;
        r13.i(r16, r17);
        goto L29
    L5:
        if (this.f14458r == null) goto L7;
        r10 = true;
        goto L8
    }

    public final OAlertDialogBuilder s() {
        return u(this, false, 1, null);
    }

    public final OAlertDialogBuilder t(boolean r10) {
        this.f14465y = 0;
        this.F = r10;
        return this;
    }

    public final OAlertDialogBuilder v(int r10) {
        w(this.f14452l.getText(r10));
        return this;
    }

    public final OAlertDialogBuilder w(CharSequence r10) {
        this.f14454n = r10;
        return this;
    }

    public final OAlertDialogBuilder x(int r10, DialogInterface.OnClickListener r11) {
        return B(this, r10, r11, null, 4, null);
    }

    public final OAlertDialogBuilder y(int r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        String r13 = this.f14452l.getString(r10);
        q.f(r13, "context.getString(text)");
        return C(this, r13, r11, null, 4, null);
    }

    public final OAlertDialogBuilder z(CharSequence r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        q.g(r10, "text");
        this.f14466z = r10;
        this.A = r11;
        this.B = r12;
        return this;
    }
}
