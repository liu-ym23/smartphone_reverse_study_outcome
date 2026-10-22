package com.android.contacts.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.contacts.R;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.StyleController;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManualJoinContactDialogBodyController.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0011\u0010!\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000e¨\u0006*"}, d2 = {"Lcom/android/contacts/setting/ManualJoinContactDialogBodyController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "displayOrderPrimary", "", "(Landroid/content/Context;Z)V", "familyName", "Lcom/obric/oui/forms/OInputView;", "getFamilyName", "()Lcom/obric/oui/forms/OInputView;", "familyNameEdit", "Lcom/obric/oui/forms/OEditText;", "getFamilyNameEdit", "()Lcom/obric/oui/forms/OEditText;", "givenName", "getGivenName", "givenNameEdit", "getGivenNameEdit", "middleName", "getMiddleName", "middleNameEdit", "getMiddleNameEdit", "prefix", "getPrefix", "prefixEdit", "getPrefixEdit", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "suffix", "getSuffix", "suffixEdit", "getSuffixEdit", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "parent", "Landroid/widget/FrameLayout;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ManualJoinContactDialogBodyController implements StyleController {
    private final OInputView familyName;
    private final OEditText familyNameEdit;
    private final OInputView givenName;
    private final OEditText givenNameEdit;
    private final OInputView middleName;
    private final OEditText middleNameEdit;
    private final OInputView prefix;
    private final OEditText prefixEdit;
    private final View rootView;
    private final OInputView suffix;
    private final OEditText suffixEdit;

    public ManualJoinContactDialogBodyController(Context r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 == false) goto L5;
        View r9 = LayoutInflater.from(r7).inflate(R.layout.edit_joined_contact_splitted_name_primary, null, false);
        Intrinsics.checkNotNullExpressionValue(r9, "{\n        LayoutInflater…imary, null, false)\n    }");
    L6:
        this.rootView = r9;
        View r10 = r9.findViewById(R.id.prefix);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.oui.forms.OInputView");
        OInputView r11 = (OInputView) r10;
        this.prefix = r11;
        View r2 = r9.findViewById(R.id.family_name);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.oui.forms.OInputView");
        OInputView r3 = (OInputView) r2;
        this.familyName = r3;
        View r4 = r9.findViewById(R.id.middle_name);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.oui.forms.OInputView");
        OInputView r5 = (OInputView) r4;
        this.middleName = r5;
        View r6 = r9.findViewById(R.id.given_name);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.oui.forms.OInputView");
        OInputView r12 = (OInputView) r6;
        this.givenName = r12;
        View r13 = r9.findViewById(R.id.suffix);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.obric.oui.forms.OInputView");
        OInputView r14 = (OInputView) r13;
        this.suffix = r14;
        this.prefixEdit = r11.getVInput();
        this.familyNameEdit = r3.getVInput();
        this.middleNameEdit = r5.getVInput();
        this.givenNameEdit = r12.getVInput();
        this.suffixEdit = r14.getVInput();
        r11.setAutoHideSoftInputWhenLoseFocus(false);
        r3.setAutoHideSoftInputWhenLoseFocus(false);
        r5.setAutoHideSoftInputWhenLoseFocus(false);
        r12.setAutoHideSoftInputWhenLoseFocus(false);
        r14.setAutoHideSoftInputWhenLoseFocus(false);
        return;
    L5:
        r9 = LayoutInflater.from(r7).inflate(R.layout.edit_joined_contact_splitted_name, null, false);
        Intrinsics.checkNotNullExpressionValue(r9, "{\n        LayoutInflater…_name, null, false)\n    }");
        goto L6
    }

    public final View getRootView() {
        return this.rootView;
    }

    public final OInputView getPrefix() {
        return this.prefix;
    }

    public final OInputView getFamilyName() {
        return this.familyName;
    }

    public final OInputView getMiddleName() {
        return this.middleName;
    }

    public final OInputView getGivenName() {
        return this.givenName;
    }

    public final OInputView getSuffix() {
        return this.suffix;
    }

    public final OEditText getPrefixEdit() {
        return this.prefixEdit;
    }

    public final OEditText getFamilyNameEdit() {
        return this.familyNameEdit;
    }

    public final OEditText getMiddleNameEdit() {
        return this.middleNameEdit;
    }

    public final OEditText getGivenNameEdit() {
        return this.givenNameEdit;
    }

    public final OEditText getSuffixEdit() {
        return this.suffixEdit;
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r3, FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -2);
        ViewParent r0 = this.rootView.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ((ViewGroup) r0).removeView(this.rootView);
    L5:
        r4.addView(this.rootView, r5);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.setAutoDismiss(false);
    }
}
