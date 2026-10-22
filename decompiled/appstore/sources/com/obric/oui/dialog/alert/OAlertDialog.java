package com.obric.oui.dialog.alert;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import com.ttnet.org.chromium.net.NetError;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public class OAlertDialog extends AbstractDialog {
    public final String S;
    public FrameLayout T;
    public StyleController U;
    public TextView V;
    public TextView W;
    public FrameLayout X;
    public StyleController Y;
    public FrameLayout Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public StyleController f14294a0;

    public OAlertDialog(Context r10, boolean r11, boolean r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.S = "OAlertDialog";
        this.T = (FrameLayout) findViewById(R$id.iconPanel);
        TextView r13 = (TextView) findViewById(R$id.textTitle);
        OTextView r14 = null;
        if (r13 != null) goto L6;
        r13 = null;
    L12:
        this.V = r13;
        TextView r15 = (TextView) findViewById(R$id.textSubTitle);
        if ((r15 instanceof OTextView) == false) goto L15;
        r14 = (OTextView) r15;
    L15:
        if (r14 == null) goto L18;
        r14.setEnableAutoAlignLeft(true);
    L18:
        this.W = r15;
        this.X = (FrameLayout) findViewById(R$id.button_container);
        this.Z = (FrameLayout) findViewById(R$id.body_container);
        return;
    L6:
        if ((r13 instanceof OTextView) == false) goto L8;
        OTextView r16 = (OTextView) r13;
    L9:
        if (r16 == null) goto L12;
        r16.setEnableAutoAlignLeft(true);
        goto L12
    L8:
        r16 = null;
        goto L9
    }

    private final int A0() {
        FrameLayout r10 = this.Z;
        if (r10 != null) goto L5;
        return 0;
    L5:
        td.c r11 = td.c.f24796a;
        q.d(r10);
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

    private final int B0() {
        FrameLayout r10 = this.X;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        q.d(r10);
        r10.measure(0, 0);
        FrameLayout r12 = this.X;
        q.d(r12);
        if (r12.getVisibility() != 0) goto L8;
        FrameLayout r13 = this.X;
        q.d(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        td.c r15 = td.c.f24796a;
        FrameLayout r16 = this.X;
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

    private final int C0() {
        FrameLayout r10 = this.T;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        q.d(r10);
        r10.measure(0, 0);
        FrameLayout r12 = this.T;
        q.d(r12);
        if (r12.getVisibility() != 0) goto L8;
        FrameLayout r13 = this.T;
        q.d(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        td.c r15 = td.c.f24796a;
        FrameLayout r16 = this.T;
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

    private final int D0() {
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

    private final int E0() {
        TextView r10 = this.V;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        q.d(r10);
        r10.measure(0, 0);
        TextView r12 = this.V;
        q.d(r12);
        if (r12.getVisibility() != 0) goto L8;
        TextView r13 = this.V;
        q.d(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        td.c r15 = td.c.f24796a;
        TextView r16 = this.V;
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

    public static final void F0(OAlertDialog r10) {
        q.g(r10, "this$0");
        TextView r11 = r10.W;
        if (r11 == null) goto L9;
        Layout r12 = r11.getLayout();
        if (r12 == null) goto L9;
        r12.getLineCount();
    L9:
        TextView r13 = r10.W;
        if (r13 == null) goto L14;
        r13.getMaxLines();
        return;
    }

    public static final void I0(final OAlertDialog r10) {
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

    public static /* synthetic */ void N0(OAlertDialog r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        r10.M0(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    public static /* synthetic */ void w0(OAlertDialog r10) {
        F0(r10);
    }

    public static /* synthetic */ void x0(OAlertDialog r10) {
        I0(r10);
    }

    private final void y0(Context r13) {
        FrameLayout r10 = this.Z;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() == 0) goto L8;
        return;
    L8:
        if (tc.g.f24781a.a(r13) == false) goto L26;
        int r11 = wd.a.f25402a.f(r13);     // Catch: Exception -> L12
        if (Y() == false) goto L14;
        r11 = r11 - tc.f.b(r13, 16);     // Catch: Exception -> L12
    L14:
        int r12 = C0();     // Catch: Exception -> L12
        int r14 = E0();     // Catch: Exception -> L12
        int r15 = D0();     // Catch: Exception -> L12
        int r16 = B0();     // Catch: Exception -> L12
        int r17 = A0();     // Catch: Exception -> L12
        int r18 = tc.f.m(r13);     // Catch: Exception -> L12
        int r19 = tc.f.b(r13, 300);     // Catch: Exception -> L12
        int r20 = tc.f.b(r13, 440);     // Catch: Exception -> L12
        if (r18 <= r19) goto L17;
        r19 = r18 + NetError.ERR_SSL_SERVER_CERT_CHANGED;     // Catch: Exception -> L12
    L17:
        int r21 = (((((r19 - r11) - r12) - r14) - r15) - r16) - r17;     // Catch: Exception -> L12
        int r110 = bg.h.k(r21, 0, r19 - tc.f.b(r13, 52));     // Catch: Exception -> L12
        r10.measure(View.MeasureSpec.makeMeasureSpec(r20, Integer.MIN_VALUE), 0);     // Catch: Exception -> L12
        int r22 = r10.getMeasuredHeight();     // Catch: Exception -> L12
        L.a(this.S, "adjustContentHeight, maxHeight: " + r19 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r21 + ", measured BodyHeight: " + r22 + ", maxBodyHeight: " + r110 + ", iconPanelVerticalSpace: " + r12 + ", titleVerticalSpace: " + r14 + ", messageVerticalSpace: " + r15 + ", buttonVerticalSpace: " + r16 + ", bodyMarginSpace: " + r17);     // Catch: Exception -> L12
        if (r22 <= r110) goto L27;
        L.e(this.S, "adjustContentHeight, from: " + r22 + " to: " + r110);     // Catch: Exception -> L12
        ViewGroup.LayoutParams r23 = r10.getLayoutParams();     // Catch: Exception -> L12
        r23.height = r110;     // Catch: Exception -> L12
        r10.setLayoutParams(r23);     // Catch: Exception -> L12
        return;
    L27:
        return;
    L12:
        e = move-exception;
        L.c(this.S, "adjustContentHeight error", e);
        return;
    }

    public final void G0() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    public void H0() {
        V().post(new e(this));
    }

    public void J0() {
        ViewPropertySpringAnimator r10 = DialogAnimStyle.g(DialogAnimStyle.f14342a, V(), getWindow(), !L(), false, 4, null);
        ViewPropertySpringAnimator.o(r10, null, new OAlertDialog$performExitAnimation$1$1(this), new OAlertDialog$performExitAnimation$1$2(this), 1, null);
        r10.q();
    }

    public final void K0(StyleController r10) {
        q.g(r10, "controller");
        this.f14294a0 = r10;
        FrameLayout r11 = this.Z;
        if (r11 != null) goto L6;
        return;
    L6:
        if (U() == false) goto L8;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = 0;
        r11.setLayoutParams(r12);
    L8:
        r11.setVisibility(0);
        Context r13 = getContext();
        q.f(r13, "context");
        r10.attachToParent(r13, r11);
    }

    public final void L0(StyleController r10) {
        q.g(r10, "controller");
        this.Y = r10;
        FrameLayout r11 = this.X;
        if (r11 == null) goto L7;
        Context r12 = getContext();
        q.f(r12, "context");
        r10.attachToParent(r12, r11);
        return;
    }

    public final void M0(CharSequence r10, boolean r11) {
        q.g(r10, "message");
        TextView r12 = this.W;
        if (r12 == null) goto L6;
        r12.setVisibility(0);
        r12.setText(r10);
    L6:
        TextView r13 = this.W;
        if (r13 == null) goto L11;
        r13.setMaxLines(Channel.UNLIMITED);
        return;
    }

    public final void O0(CharSequence r10) {
        q.g(r10, "title");
        TextView r11 = this.V;
        if (r11 == null) goto L7;
        r11.setVisibility(0);
        r11.setText(r10);
        r11.setPadding(0, tc.f.r(r11, 19), 0, tc.f.r(r11, 19));
        return;
    }

    public final void P0(CharSequence r10) {
        q.g(r10, "title");
        TextView r11 = this.V;
        if (r11 == null) goto L7;
        r11.setVisibility(0);
        r11.setText(r10);
        r11.setPadding(0, 0, 0, 0);
        return;
    }

    public final void Q0(StyleController r10) {
        q.g(r10, "controller");
        this.U = r10;
        FrameLayout r11 = this.T;
        if (r11 == null) goto L7;
        r11.setVisibility(0);
        Context r12 = getContext();
        q.f(r12, "context");
        r10.attachToParent(r12, r11);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int R() {
        return R$layout.o_alert_dialog;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        J0();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        if (P() == false) goto L5;
        V().setAlpha(0.0f);
    L5:
        super.onCreate(r10);
        StyleController r11 = this.U;
        if (r11 == null) goto L9;
        r11.attachToDialog(this);
    L9:
        StyleController r12 = this.Y;
        if (r12 == null) goto L13;
        r12.attachToDialog(this);
    L13:
        StyleController r13 = this.f14294a0;
        if (r13 == null) goto L18;
        r13.attachToDialog(this);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        H0();
        StyleController r10 = this.Y;
        if ((r10 instanceof ButtonStyleController) == false) goto L8;
        if (r10 == null) goto L7;
        ((ButtonStyleController) r10).d();
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
    L8:
        TextView r11 = this.W;
        if (r11 == null) goto L13;
        r11.postDelayed(new d(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
        Context r10 = getContext();
        q.f(r10, "context");
        y0(r10);
    }

    public final void z0() {
        TextView r10 = this.W;
        if (r10 == null) goto L7;
        r10.setMaxLines(Channel.UNLIMITED);
        return;
    }
}
