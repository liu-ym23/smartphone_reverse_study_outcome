package bd;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.q;
import tc.l;
import td.h;

/* JADX INFO: loaded from: classes4.dex */
public class d extends ButtonStyleController {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f5986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OButton f5988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OButton f5989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OButton f5990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AlertDialogHost f5991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f5992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f5993i;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5994a = null;

        static {
            int[] r10 = new int[ButtonStyleController.TextColorType.values().length];
            r10[ButtonStyleController.TextColorType.Negative.ordinal()] = 1;
            r10[ButtonStyleController.TextColorType.TextReverse.ordinal()] = 2;
            r10[ButtonStyleController.TextColorType.TextReverse2.ordinal()] = 3;
            f5994a = r10;
        }
    }

    public d(Context r10, int r11) {
        q.g(r10, "context");
        this.f5986b = r10;
        this.f5987c = r11;
    }

    public static /* synthetic */ void h(d r10, DialogInterface.OnClickListener r11, View r12) {
        r(r10, r11, r12);
    }

    public static /* synthetic */ void i(d r10, DialogInterface.OnClickListener r11, View r12) {
        q(r10, r11, r12);
    }

    public static /* synthetic */ void j(d r10, DialogInterface.OnClickListener r11, View r12) {
        p(r10, r11, r12);
    }

    public static final void p(d r10, DialogInterface.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        AlertDialogHost r13 = r10.f5991g;
        if (r13 == null) goto L10;
        if (r11 == null) goto L8;
        r11.onClick(r13, -2);
    L8:
        r10.t();
        return;
    }

    public static final void q(d r10, DialogInterface.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        AlertDialogHost r13 = r10.f5991g;
        if (r13 == null) goto L10;
        if (r11 == null) goto L8;
        r11.onClick(r13, -3);
    L8:
        r10.t();
        return;
    }

    public static final void r(d r10, DialogInterface.OnClickListener r11, View r12) {
        q.g(r10, "this$0");
        AlertDialogHost r13 = r10.f5991g;
        if (r13 == null) goto L10;
        if (r11 == null) goto L8;
        r11.onClick(r13, -1);
    L8:
        r10.t();
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* bridge */ /* synthetic */ View a() {
        return m();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToDialog(AbstractDialog r10) {
        q.g(r10, "dialog");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController, com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToHost(AlertDialogHost r10) {
        q.g(r10, "host");
        this.f5991g = r10;
        if ((r10 instanceof OAlertDialog) == false) goto L6;
        attachToDialog((AbstractDialog) r10);
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToParent(Context r10, DialogContainer r11) {
        q.g(r10, "context");
        q.g(r11, "dialogContainer");
        FrameLayout r12 = r11.getButtonSlot();
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -2);
        int r14 = k(this.f5987c);
        View r15 = LayoutInflater.from(r10).inflate(r14, r12, false);
        r12.addView(r15, r13);
        this.f5992h = r15;
        if (r15 == null) goto L6;
        r15.setVisibility(8);
    L6:
        this.f5988d = (OButton) r15.findViewById(R$id.actionPositive);
        this.f5989e = (OButton) r15.findViewById(R$id.actionNegative);
        this.f5990f = (OButton) r15.findViewById(R$id.actionNeutral);
        this.f5993i = (FrameLayout) r15.findViewById(R$id.custom_container);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* bridge */ /* synthetic */ View b() {
        return n();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* bridge */ /* synthetic */ View c() {
        return o();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void d(View r10) {
        q.g(r10, "view");
        if (this.f5987c == 2) goto L5;
        return;
    L5:
        if (this.f5993i == null) goto L20;
        View r11 = this.f5992h;
        if (r11 == null) goto L10;
        r11.setVisibility(0);
    L10:
        FrameLayout r12 = this.f5993i;
        if (r12 == null) goto L14;
        r12.addView(r10);
    L14:
        FrameLayout r13 = this.f5993i;
        if (r13 == null) goto L21;
        l.m(r13);
        return;
    L21:
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void e(CharSequence r10, final DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        OButton r13 = this.f5989e;
        if (r13 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r13.setVisibility(8);
        return;
    L9:
        View r14 = this.f5992h;
        if (r14 == null) goto L13;
        r14.setVisibility(0);
    L13:
        r13.setText(r10);
        s(r13, r12);
        r13.setVisibility(0);
        r13.setOnClickListener(new bd.a(this, r11));
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void f(CharSequence r10, final DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12) {
        OButton r13 = this.f5990f;
        if (r13 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r13.setVisibility(8);
        return;
    L9:
        View r14 = this.f5992h;
        if (r14 == null) goto L13;
        r14.setVisibility(0);
    L13:
        r13.setText(r10);
        s(r13, r12);
        r13.setVisibility(0);
        r13.setOnClickListener(new c(this, r11));
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void g(CharSequence r10, final DialogInterface.OnClickListener r11, ButtonStyleController.TextColorType r12, boolean r13) {
        OButton r14 = this.f5988d;
        if (r14 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r14.setVisibility(8);
        return;
    L9:
        View r15 = this.f5992h;
        if (r15 == null) goto L13;
        r15.setVisibility(0);
    L13:
        if (r13 == false) goto L15;
        r14.setBackgroundColor(ContextCompat.b(l(), R$color.oui_basic_fill_element_2));
        r14.setTextColor(ContextCompat.b(l(), R$color.oui_functional_red_6));
    L15:
        r14.setText(r10);
        s(r14, r12);
        r14.setVisibility(0);
        r14.setOnClickListener(new b(this, r11));
    }

    public int k(int r10) {
        if (r10 == 0) goto L8;
        if (r10 == 1) goto L13;
        return R$layout.o_dialog_button_primary;
    L13:
        return R$layout.o_dialog_button_vertical;
    L8:
        if (h.g(this.f5986b.getResources().getConfiguration().fontScale) == false) goto L11;
        return R$layout.o_dialog_button_vertical;
    L11:
        return R$layout.o_dialog_button_horizontal;
    }

    public final Context l() {
        return this.f5986b;
    }

    public OButton m() {
        return this.f5989e;
    }

    public OButton n() {
        return this.f5990f;
    }

    public OButton o() {
        return this.f5988d;
    }

    public final void s(OButton r10, ButtonStyleController.TextColorType r11) {
        if (r11 == null) goto L16;
        int r12 = a.f5994a[r11.ordinal()];
        if (r12 != 1) goto L6;
        int r13 = R$color.Negative;
    L14:
        r10.setTextColor(ContextCompat.b(r10.getContext(), r13));
        return;
    L6:
        if (r12 != 2) goto L8;
        r13 = R$color.TextReverse;
        goto L14
    L8:
        if (r12 != 3) goto L11;
        r13 = R$color.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void t() {
        AlertDialogHost r10 = this.f5991g;
        if (r10 != null) goto L6;
    L8:
        AlertDialogHost r11 = this.f5991g;
        if (r11 == null) goto L13;
        r11.dismiss();
        return;
    L13:
        return;
    L6:
        if (r10.isAutoDismiss() == true) goto L8;
    }
}
