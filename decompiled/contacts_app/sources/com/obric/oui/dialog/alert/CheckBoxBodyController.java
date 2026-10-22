package com.obric.oui.dialog.alert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R;
import com.obric.oui.checkbox.OCheckBox;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckBoxBodyController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "已废弃")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/dialog/alert/CheckBoxBodyController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "setCheckBox", "(Lcom/obric/oui/checkbox/OCheckBox;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "parent", "Landroid/widget/FrameLayout;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckBoxBodyController implements StyleController {
    private OCheckBox checkBox;
    private View rootView;
    private TextView textView;

    public CheckBoxBodyController(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        View r5 = LayoutInflater.from(r4).inflate(R.layout.o_dialog_body_check_box, null, false);
        Intrinsics.checkNotNullExpressionValue(r5, "from(context).inflate(R.…y_check_box, null, false)");
        this.rootView = r5;
        View r6 = r5.findViewById(R.id.checkbox_button);
        Intrinsics.checkNotNullExpressionValue(r6, "rootView.findViewById(R.id.checkbox_button)");
        this.checkBox = (OCheckBox) r6;
        View r7 = this.rootView.findViewById(R.id.checkbox_text);
        Intrinsics.checkNotNullExpressionValue(r7, "rootView.findViewById(R.id.checkbox_text)");
        this.textView = (TextView) r7;
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final void setCheckBox(OCheckBox r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.checkBox = r2;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final void setTextView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textView = r2;
    }

    public final View getRootView() {
        return this.rootView;
    }

    public final void setRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootView = r2;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 1;
        r3.addView(this.rootView, r4);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.setAutoDismiss(false);
    }
}
