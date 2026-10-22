package com.obric.oui.dialog.v2.action;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oui.R$layout;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.text.OTextView;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class OActionDialog extends OBaseDialog {
    public static final a Z = null;
    public final b V;
    public final Lazy W;
    public final Lazy X;
    public final Lazy Y;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f14445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f14446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1 f14447c;

        public b(CharSequence r10, CharSequence r11, Function1 r12) {
            q.g(r10, "title");
            q.g(r11, "subtitle");
            this.f14445a = r10;
            this.f14446b = r11;
            this.f14447c = r12;
        }

        public final Function1 a() {
            return this.f14447c;
        }

        public final CharSequence b() {
            return this.f14446b;
        }

        public final CharSequence c() {
            return this.f14445a;
        }
    }

    static {
        Z = new a(null);
    }

    public OActionDialog(Context r10, b r11) {
        q.g(r10, "context");
        q.g(r11, "modifier");
        super(r10);
        this.V = r11;
        this.W = kotlin.b.b(new OActionDialog$titleTextView$2(this));
        this.X = kotlin.b.b(new OActionDialog$subtitleTextView$2(this));
        this.Y = kotlin.b.b(new OActionDialog$bodyContainerView$2(this));
        D0().setIncludeFontPadding(true);
        C0().setIncludeFontPadding(true);
        G0(r11.c());
        F0(r11.b());
        E0();
        g0(true);
    }

    public final ViewGroup B0() {
        Object r10 = this.Y.getValue();
        q.f(r10, "<get-bodyContainerView>(...)");
        return (ViewGroup) r10;
    }

    public final OTextView C0() {
        Object r10 = this.X.getValue();
        q.f(r10, "<get-subtitleTextView>(...)");
        return (OTextView) r10;
    }

    public final OTextView D0() {
        Object r10 = this.W.getValue();
        q.f(r10, "<get-titleTextView>(...)");
        return (OTextView) r10;
    }

    public final void E0() {
        if (this.V.a() == null) goto L6;
        View r10 = (View) this.V.a().invoke(B0());
        B0().removeAllViews();
        B0().addView(r10);
        return;
    }

    public final void F0(CharSequence r10) {
        q.g(r10, "message");
        if (r10.length() != 0) goto L5;
        C0().setVisibility(8);
        return;
    L5:
        OTextView r11 = C0();
        r11.setVisibility(0);
        r11.setText(r10);
    }

    public final void G0(CharSequence r10) {
        q.g(r10, "title");
        if (r10.length() != 0) goto L9;
        D0().setVisibility(8);
        ViewGroup.LayoutParams r11 = C0().getLayoutParams();
        if (r11 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r11).topMargin = 0;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        OTextView r12 = D0();
        r12.setVisibility(0);
        r12.setText(r10);
        OTextView r13 = C0();
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L14;
        int r15 = f.r(r13, 8);
        ((ViewGroup.MarginLayoutParams) r14).topMargin = r15;
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int R() {
        return R$layout.o_action_dialog;
    }
}
