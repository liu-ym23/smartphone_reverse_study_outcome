package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import bg.h;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import tc.f;
import tc.g;

/* JADX INFO: loaded from: classes4.dex */
public class OAlertDialog extends AbstractDialog implements DialogContainer {
    public final String S;
    public final FrameLayout T;
    public final FrameLayout U;
    public StyleController V;
    public TextView W;
    public TextView X;
    public final FrameLayout Y;
    public StyleController Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final FrameLayout f14448a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final ViewGroup f14449b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public StyleController f14450c0;

    public OAlertDialog(Context r10, boolean r11) {
        q.g(r10, "context");
        super(r10, false, r11);
        this.S = "OAlertDialog";
        View r12 = findViewById(R$id.bannerPanel);
        q.f(r12, "findViewById(R.id.bannerPanel)");
        this.T = (FrameLayout) r12;
        View r13 = findViewById(R$id.iconPanel);
        q.f(r13, "findViewById(R.id.iconPanel)");
        this.U = (FrameLayout) r13;
        View r14 = findViewById(R$id.header_container);
        q.f(r14, "findViewById(R.id.header_container)");
        this.f14449b0 = (ViewGroup) r14;
        TextView r15 = (TextView) findViewById(R$id.textTitle);
        this.W = r15;
        if (r15 == null) goto L6;
        r15.setIncludeFontPadding(true);
    L6:
        TextView r16 = (TextView) findViewById(R$id.textSubTitle);
        this.X = r16;
        if (r16 == null) goto L10;
        r16.setIncludeFontPadding(true);
    L10:
        View r17 = findViewById(R$id.button_container);
        q.f(r17, "findViewById(R.id.button_container)");
        this.Y = (FrameLayout) r17;
        View r18 = findViewById(R$id.body_container);
        q.f(r18, "findViewById(R.id.body_container)");
        this.f14448a0 = (FrameLayout) r18;
    }

    public static final void G0(OAlertDialog r10) {
        q.g(r10, "this$0");
        TextView r11 = r10.X;
        if (r11 == null) goto L9;
        Layout r12 = r11.getLayout();
        if (r12 == null) goto L9;
        r12.getLineCount();
    L9:
        TextView r13 = r10.X;
        if (r13 == null) goto L14;
        r13.getMaxLines();
        return;
    }

    public static final void J0(final OAlertDialog r10) {
        q.g(r10, "this$0");
        DialogAnimStyle r11 = DialogAnimStyle.f14342a;
        View r12 = r10.V();
        Window r13 = r10.getWindow();
        boolean r14 = !r10.L();
        Context r15 = r10.getContext();
        q.f(r15, "context");
        ViewPropertySpringAnimator r16 = DialogAnimStyle.j(r11, r12, r13, r14, r10.X(r15), false, 8, null).q();
        if (r10.P() == false) goto L5;
        r16.n(new OAlertDialog$performEnterAnimation$1$1(r10), new OAlertDialog$performEnterAnimation$1$2(r10), new OAlertDialog$performEnterAnimation$1$3(r10));
        return;
    L5:
        ViewPropertySpringAnimator.o(r16, null, new OAlertDialog$performEnterAnimation$1$4(r10), new OAlertDialog$performEnterAnimation$1$5(r10), 1, null);
    }

    public static /* synthetic */ void O0(OAlertDialog r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        r10.N0(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    public static /* synthetic */ void w0(OAlertDialog r10) {
        J0(r10);
    }

    public static /* synthetic */ void x0(OAlertDialog r10) {
        G0(r10);
    }

    public final int A0() {
        FrameLayout r10 = this.f14448a0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        td.c r11 = td.c.f24796a;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 != null) goto L9;
    L7:
        r12 = null;
    L10:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 != null) goto L14;
        return 0;
    L14:
        return r13.topMargin;
    L9:
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        goto L7
    }

    public final int B0() {
        FrameLayout r10 = this.Y;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        r10.measure(0, 0);
        if (this.Y.getVisibility() != 0) goto L8;
        int r12 = this.Y.getMeasuredHeight();
    L9:
        td.c r13 = td.c.f24796a;
        ViewGroup.LayoutParams r14 = this.Y.getLayoutParams();
        if (r14 != null) goto L13;
    L11:
        r14 = null;
    L14:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L19;
        r11 = r15.topMargin;
    L19:
        return r12 + r11;
    L13:
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r12 = 0;
        goto L9
    }

    public final int C0() {
        FrameLayout r10 = this.U;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        r10.measure(0, 0);
        if (this.U.getVisibility() != 0) goto L8;
        int r12 = this.U.getMeasuredHeight();
    L9:
        td.c r13 = td.c.f24796a;
        ViewGroup.LayoutParams r14 = this.U.getLayoutParams();
        if (r14 != null) goto L13;
    L11:
        r14 = null;
    L14:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L19;
        r11 = r15.topMargin;
    L19:
        return r12 + r11;
    L13:
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r12 = 0;
        goto L9
    }

    public final int D0() {
        TextView r10 = this.X;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        q.d(r10);
        r10.measure(0, 0);
        TextView r12 = this.X;
        q.d(r12);
        if (r12.getVisibility() != 0) goto L8;
        TextView r13 = this.X;
        q.d(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        td.c r15 = td.c.f24796a;
        TextView r16 = this.X;
        q.d(r16);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 != null) goto L13;
    L11:
        r17 = null;
    L14:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L19;
        r11 = r18.topMargin;
    L19:
        return r14 + r11;
    L13:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r14 = 0;
        goto L9
    }

    public final View E0() {
        td.c r10 = td.c.f24796a;
        StyleController r11 = this.Z;
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        ButtonStyleController r12 = (ButtonStyleController) r11;
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.c();
    L6:
        if ((r11 instanceof ButtonStyleController) == false) goto L4;
        goto L4
    }

    public final int F0() {
        TextView r10 = this.W;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        q.d(r10);
        r10.measure(0, 0);
        TextView r12 = this.W;
        q.d(r12);
        if (r12.getVisibility() != 0) goto L8;
        TextView r13 = this.W;
        q.d(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        td.c r15 = td.c.f24796a;
        TextView r16 = this.W;
        q.d(r16);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 != null) goto L13;
    L11:
        r17 = null;
    L14:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L19;
        r11 = r18.topMargin;
    L19:
        return r14 + r11;
    L13:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r14 = 0;
        goto L9
    }

    public final void H0() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    public void I0() {
        V().post(new b(this));
    }

    public void K0() {
        ViewPropertySpringAnimator r10 = DialogAnimStyle.g(DialogAnimStyle.f14342a, V(), getWindow(), !L(), false, 4, null);
        ViewPropertySpringAnimator.o(r10, null, new OAlertDialog$performExitAnimation$1$1(this), new OAlertDialog$performExitAnimation$1$2(this), 1, null);
        r10.q();
    }

    public final void L0(StyleController r10) {
        q.g(r10, "controller");
        this.f14450c0 = r10;
        FrameLayout r11 = this.f14448a0;
        if (U() == false) goto L5;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = 0;
        r11.setLayoutParams(r12);
    L5:
        r11.setVisibility(0);
        Context r13 = getContext();
        q.f(r13, "context");
        r10.attachToParent(r13, this);
    }

    public final void M0(StyleController r10) {
        q.g(r10, "controller");
        this.Z = r10;
        Context r11 = getContext();
        q.f(r11, "context");
        r10.attachToParent(r11, this);
    }

    public final void N0(CharSequence r10, boolean r11) {
        q.g(r10, "message");
        TextView r12 = this.X;
        if (r12 == null) goto L6;
        r12.setVisibility(0);
        r12.setText(r10);
    L6:
        TextView r13 = this.X;
        if (r13 == null) goto L11;
        r13.setMaxLines(Channel.UNLIMITED);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public View O() {
        return this.f14449b0;
    }

    public final void P0(CharSequence r10) {
        if (r10 == null) goto L9;
        TextView r11 = this.W;
        if (r11 == null) goto L10;
        r11.setVisibility(0);
        r11.setText(r10);
        r11.setPadding(0, f.r(r11, 19), 0, f.r(r11, 19));
        return;
    L10:
        return;
    }

    public final void Q0(CharSequence r10) {
        boolean r11 = TextUtils.isEmpty(r10);
        TextView r12 = this.W;
        int r13 = 0;
        if (r12 == null) goto L9;
        if (r11 == false) goto L7;
        int r14 = 8;
    L8:
        r12.setVisibility(r14);
        r12.setText(r10);
        r12.setPadding(0, 0, 0, 0);
        goto L9
    L7:
        r14 = 0;
    L9:
        TextView r15 = this.X;
        if (r15 == null) goto L22;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L21;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r11 == true) goto L18;
        r13 = f.r(r15, 8);
    L18:
        r17.topMargin = r13;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int R() {
        return R$layout.o_alert_dialog_v2;
    }

    public final void R0(StyleController r10) {
        q.g(r10, "controller");
        this.V = r10;
        Context r11 = getContext();
        q.f(r11, "context");
        r10.attachToParent(r11, this);
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        K0();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getBannerSlot() {
        return this.T;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getBodySlot() {
        return this.f14448a0;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getButtonSlot() {
        return this.Y;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DialogContainer
    public FrameLayout getIconSlot() {
        return this.U;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        if (P() == false) goto L5;
        V().setAlpha(0.0f);
    L5:
        super.onCreate(r10);
        StyleController r11 = this.V;
        if (r11 == null) goto L9;
        r11.attachToHost(this);
    L9:
        StyleController r12 = this.Z;
        if (r12 == null) goto L13;
        r12.attachToHost(this);
    L13:
        StyleController r13 = this.f14450c0;
        if (r13 == null) goto L18;
        r13.attachToHost(this);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        I0();
        TextView r10 = this.X;
        if (r10 == null) goto L7;
        r10.postDelayed(new a(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
        Context r10 = getContext();
        q.f(r10, "context");
        y0(r10);
    }

    public final void y0(Context r13) {
        FrameLayout r10 = this.f14448a0;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() == 0) goto L8;
        return;
    L8:
        if (g.f24781a.a(r13) == false) goto L26;
        int r11 = wd.a.f25402a.f(r13);     // Catch: Exception -> L12
        if (Y() == false) goto L14;
        r11 = r11 - f.b(r13, 16);     // Catch: Exception -> L12
    L14:
        int r12 = C0();     // Catch: Exception -> L12
        int r14 = F0();     // Catch: Exception -> L12
        int r15 = D0();     // Catch: Exception -> L12
        int r16 = B0();     // Catch: Exception -> L12
        int r17 = A0();     // Catch: Exception -> L12
        int r18 = f.m(r13);     // Catch: Exception -> L12
        int r19 = f.b(r13, 300);     // Catch: Exception -> L12
        int r20 = f.b(r13, 440);     // Catch: Exception -> L12
        int r110 = f.b(r13, 156);     // Catch: Exception -> L12
        if (r18 <= r19) goto L17;
        r19 = r18 - r110;     // Catch: Exception -> L12
    L17:
        int r21 = (((((r19 - r11) - r12) - r14) - r15) - r16) - r17;     // Catch: Exception -> L12
        int r111 = h.k(r21, 0, r19 - f.b(r13, 52));     // Catch: Exception -> L12
        r10.measure(View.MeasureSpec.makeMeasureSpec(r20, Integer.MIN_VALUE), 0);     // Catch: Exception -> L12
        int r22 = r10.getMeasuredHeight();     // Catch: Exception -> L12
        L.a(this.S, "adjustContentHeight, maxHeight: " + r19 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r21 + ", measured BodyHeight: " + r22 + ", maxBodyHeight: " + r111 + ", iconPanelVerticalSpace: " + r12 + ", titleVerticalSpace: " + r14 + ", messageVerticalSpace: " + r15 + ", buttonVerticalSpace: " + r16 + ", bodyMarginSpace: " + r17);     // Catch: Exception -> L12
        if (r22 <= r111) goto L27;
        L.e(this.S, "adjustContentHeight, from: " + r22 + " to: " + r111);     // Catch: Exception -> L12
        ViewGroup.LayoutParams r23 = r10.getLayoutParams();     // Catch: Exception -> L12
        r23.height = r111;     // Catch: Exception -> L12
        r10.setLayoutParams(r23);     // Catch: Exception -> L12
        return;
    L27:
        return;
    L12:
        e = move-exception;
        L.c(this.S, "adjustContentHeight error", e);
        return;
    }

    public final void z0() {
        TextView r10 = this.X;
        if (r10 == null) goto L7;
        r10.setMaxLines(Channel.UNLIMITED);
        return;
    }
}
