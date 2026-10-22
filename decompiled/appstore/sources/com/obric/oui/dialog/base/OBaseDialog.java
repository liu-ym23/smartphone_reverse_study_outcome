package com.obric.oui.dialog.base;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OBaseDialog extends AbstractDialog {
    public static final a U = null;
    public boolean S;
    public boolean T;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        U = new a(null);
    }

    public OBaseDialog(Context r10) {
        q.g(r10, "context");
        super(r10, false, false);
        this.S = true;
    }

    public static /* synthetic */ void w0(OBaseDialog r10) {
        z0(r10);
    }

    public static final void z0(final OBaseDialog r10) {
        q.g(r10, "this$0");
        DialogAnimStyle r11 = DialogAnimStyle.f14342a;
        View r12 = r10.V();
        Window r13 = r10.getWindow();
        boolean r14 = !r10.L();
        Context r15 = r10.getContext();
        q.f(r15, "context");
        ViewPropertySpringAnimator.o(r11.i(r12, r13, r14, r10.X(r15), r10.S).q(), null, new OBaseDialog$performEnterAnimation$1$1(r10), new OBaseDialog$performEnterAnimation$1$2(r10), 1, null);
    }

    public final void A0() {
        ViewPropertySpringAnimator r10 = DialogAnimStyle.f14342a.f(V(), getWindow(), !L(), this.S);
        ViewPropertySpringAnimator.o(r10, null, new OBaseDialog$performExitAnimation$1$1(this), new OBaseDialog$performExitAnimation$1$2(this), 1, null);
        r10.q();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.T == false) goto L6;
        L.a("BaseDialog", "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L6:
        this.T = true;
        A0();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.T = false;
        y0();
    }

    public void x0() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        L.c("BaseDialog", "origin Dismiss exception!", e);
    }

    public final void y0() {
        V().post(new n(this));
    }
}
