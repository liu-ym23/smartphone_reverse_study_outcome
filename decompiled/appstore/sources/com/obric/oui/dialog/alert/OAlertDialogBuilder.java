package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.obric.oui.dialog.alert.view.IOImageLoadDelegate;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.base.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class OAlertDialogBuilder extends i {
    public CharSequence A;
    public DialogInterface.OnClickListener B;
    public ButtonStyleController.TextColorType C;
    public boolean D;
    public CharSequence E;
    public DialogInterface.OnClickListener F;
    public ButtonStyleController.TextColorType G;
    public boolean H;
    public StyleController I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public StyleController f14295J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public View O;
    public boolean P;
    public boolean Q;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f14296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f14297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f14298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f14300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f14301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IOImageLoadDelegate f14302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IImageLoader f14303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f14304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f14305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f14308x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DialogInterface.OnClickListener f14309y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ButtonStyleController.TextColorType f14310z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/OAlertDialogBuilder$IImageLoader;", "", "loadTopImg", "", "imageView", "Landroid/widget/ImageView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IImageLoader {
        void loadTopImg(@NotNull ImageView r10);
    }

    public OAlertDialogBuilder(Context r10) {
        q.g(r10, "context");
        super(r10);
        this.f14296l = r10;
        this.f14301q = "";
        this.H = true;
        super.b(false);
    }

    public static /* synthetic */ OAlertDialogBuilder A(OAlertDialogBuilder r10, CharSequence r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.x(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public static final void B(Function2 r10, DialogInterface r11, int r12) {
        q.g(r10, "$listener");
        q.f(r11, "dialog");
        r10.mo0invoke(r11, Integer.valueOf(r12));
    }

    public static /* synthetic */ OAlertDialogBuilder E(OAlertDialogBuilder r10, CharSequence r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.D(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: neutralButton");
    }

    public static /* synthetic */ OAlertDialogBuilder L(OAlertDialogBuilder r10, int r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.H(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public static final void M(Function2 r10, DialogInterface r11, int r12) {
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

    public static /* synthetic */ void l(Function2 r10, DialogInterface r11, int r12) {
        M(r10, r11, r12);
    }

    public static /* synthetic */ void m(Function2 r10, DialogInterface r11, int r12) {
        B(r10, r11, r12);
    }

    public static final /* synthetic */ boolean n(OAlertDialogBuilder r10) {
        return r10.N;
    }

    public static final /* synthetic */ boolean o(OAlertDialogBuilder r10) {
        return r10.f14299o;
    }

    public static /* synthetic */ OAlertDialogBuilder z(OAlertDialogBuilder r10, int r11, DialogInterface.OnClickListener r12, ButtonStyleController.TextColorType r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = null;
    L7:
        return r10.v(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public final OAlertDialogBuilder C(int r10, DialogInterface.OnClickListener r11) {
        String r12 = this.f14296l.getString(r10);
        q.f(r12, "context.getString(text)");
        return E(this, r12, r11, null, 4, null);
    }

    public final OAlertDialogBuilder D(CharSequence r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        q.g(r10, "text");
        this.E = r10;
        this.F = r11;
        this.G = r12;
        this.f14307w = 1;
        return this;
    }

    public OAlertDialog F(Context r10, boolean r11, boolean r12) {
        q.g(r10, "context");
        return new OAlertDialog(r10, r11, r12);
    }

    public final OAlertDialogBuilder G(int r10, DialogInterface.OnClickListener r11) {
        return L(this, r10, r11, null, 4, null);
    }

    public final OAlertDialogBuilder H(int r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        String r13 = this.f14296l.getString(r10);
        q.f(r13, "context.getString(text)");
        return J(r13, r11, r12);
    }

    public final OAlertDialogBuilder I(int r10, Function2 r11) {
        q.g(r11, "listener");
        String r12 = this.f14296l.getString(r10);
        q.f(r12, "context.getString(text)");
        return K(r12, r11);
    }

    public final OAlertDialogBuilder J(CharSequence r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        q.g(r10, "text");
        this.A = r10;
        this.B = r11;
        this.C = r12;
        return this;
    }

    public final OAlertDialogBuilder K(CharSequence r10, final Function2 r11) {
        q.g(r10, "text");
        q.g(r11, "listener");
        this.A = r10;
        this.B = new g(r11);
        return this;
    }

    public final OAlertDialogBuilder N(int r10) {
        P(this, this.f14296l.getString(r10), false, 2, null);
        return this;
    }

    public final OAlertDialogBuilder O(CharSequence r10, boolean r11) {
        this.f14299o = r11;
        this.f14297m = r10;
        return this;
    }

    public final void Q(CharSequence r10, Function1 r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        q.d(r10);
        r11.invoke(r10);
        return;
    }

    @Override // com.obric.oui.dialog.base.i
    public /* bridge */ /* synthetic */ AbstractDialog c() {
        return q();
    }

    public final OAlertDialogBuilder p(StyleController r10) {
        q.g(r10, "controller");
        this.I = r10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAlertDialog q() {
        final OAlertDialog r10 = F(this.f14296l, this.L, this.K);
        Q(this.f14297m, new OAlertDialogBuilder$createDialog$1(this, r10));
        Q(this.f14298n, new OAlertDialogBuilder$createDialog$2(r10, this));
        StyleController r11 = this.f14295J;
        if (r11 != null) goto L5;
        Unit r12 = null;
    L6:
        boolean r13 = true;
        if (r12 == null) goto L9;
    L34:
        r10.g0(this.H);
        ButtonStyleController r14 = new ButtonStyleController(this.f14296l, this.f14307w);
        r10.L0(r14);
        StyleController r15 = this.I;
        if (r15 == null) goto L39;
        r10.K0(r15);
    L39:
        if (f() == true) goto L46;
        if (this.f14307w == 2) goto L44;
        r13 = false;
    L44:
        i.k(this, r13, null, 2, null);
    L46:
        if (this.M == false) goto L49;
        i.k(this, false, null, 2, null);
    L49:
        if (this.P == false) goto L52;
        r10.K();
    L52:
        if (this.Q == false) goto L54;
        r10.A();
    L54:
        r10.setOnShowListener(g());
        r10.setOnDismissListener(e());
        r10.setOnCancelListener(d());
        r14.j(this.A, this.B, this.C, this.D);
        r14.f(this.f14308x, this.f14309y, this.f14310z);
        r14.h(this.E, this.F, this.G);
        View r16 = this.O;
        if (r16 == null) goto L57;
        q.d(r16);
        r14.e(r16);
    L57:
        return r10;
    L9:
        if (this.f14301q.length() > 0) goto L11;
    L13:
        Object[] r17 = false;
    L14:
        Drawable r18 = this.f14300p;
        if (r18 != null) goto L19;
        if (r17 == true) goto L19;
        if (this.f14303s == null) goto L34;
    L19:
        ImageStyleController r19 = new ImageStyleController(this.f14296l, this.f14306v ? 1 : 0);
        IImageLoader r20 = this.f14303s;
        if (r20 == null) goto L22;
        q.d(r20);
        r19.h(r20);
    L33:
        r10.Q0(r19);
        goto L34
    L22:
        if (r18 == null) goto L24;
        r19.d(r18);
        r19.g(this.f14304t, this.f14305u);
        goto L33
    L24:
        r19.e(this.f14301q);
        IOImageLoadDelegate r21 = this.f14302r;
        if (r21 == null) goto L28;
        r19.f(r21);
    L28:
        Integer r22 = this.f14304t;
        if (r22 == null) goto L33;
        Integer r23 = this.f14305u;
        if (r23 == null) goto L33;
        r19.g(r22, r23);
        goto L33
    L11:
        if (this.f14302r == null) goto L13;
        r17 = true;
        goto L14
    L5:
        r10.Q0(r11);
        r12 = Unit.f21064a;
        goto L6
    }

    public final OAlertDialogBuilder r(Drawable r10) {
        q.g(r10, "drawable");
        this.f14300p = r10;
        this.f14306v = false;
        return this;
    }

    public final OAlertDialogBuilder s(int r10, int r11) {
        this.f14304t = Integer.valueOf(r10);
        this.f14305u = Integer.valueOf(r11);
        return this;
    }

    public final OAlertDialogBuilder t(CharSequence r10) {
        this.f14298n = r10;
        return this;
    }

    public final OAlertDialogBuilder u(int r10, DialogInterface.OnClickListener r11) {
        return z(this, r10, r11, null, 4, null);
    }

    public final OAlertDialogBuilder v(int r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        String r13 = this.f14296l.getString(r10);
        q.f(r13, "context.getString(text)");
        return A(this, r13, r11, null, 4, null);
    }

    public final OAlertDialogBuilder w(int r10, Function2 r11) {
        q.g(r11, "listener");
        String r12 = this.f14296l.getString(r10);
        q.f(r12, "context.getString(text)");
        return y(r12, r11);
    }

    public final OAlertDialogBuilder x(CharSequence r10, DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        q.g(r10, "text");
        this.f14308x = r10;
        this.f14309y = r11;
        this.f14310z = r12;
        return this;
    }

    public final OAlertDialogBuilder y(CharSequence r10, final Function2 r11) {
        q.g(r10, "text");
        q.g(r11, "listener");
        this.f14308x = r10;
        this.f14309y = new f(r11);
        return this;
    }
}
