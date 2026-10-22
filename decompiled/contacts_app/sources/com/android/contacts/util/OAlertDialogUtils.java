package com.android.contacts.util;

import android.content.Context;
import android.content.DialogInterface;
import com.android.contacts.R;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAlertDialogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007Jd\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u0016"}, d2 = {"Lcom/android/contacts/util/OAlertDialogUtils;", "", "()V", "showBlacklistConfirmationDialog", "", "context", "Landroid/content/Context;", "onConfirmListener", "Landroid/content/DialogInterface$OnClickListener;", "title", "", "showConfirmationDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "message", "positiveButtonText", "positiveButtonListener", "positiveButtonColorType", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "negativeButtonText", "negativeButtonListener", "negativeButtonColorType", "showDefaultBlacklistConfirmationDialog", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OAlertDialogUtils {
    public static final OAlertDialogUtils INSTANCE = null;

    static {
        INSTANCE = new OAlertDialogUtils();
    }

    private OAlertDialogUtils() {
    }

    @JvmStatic
    public static final void showDefaultBlacklistConfirmationDialog(Context r1, DialogInterface.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "onConfirmListener");
        showBlacklistConfirmationDialog(r1, r2, null);
    }

    @JvmStatic
    public static final void showBlacklistConfirmationDialog(Context r9, DialogInterface.OnClickListener r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "onConfirmListener");
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(r9);
        if (r11 != null) goto L5;
        String r12 = r9.getString(R.string.confirm_add_to_blacklist);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(com.an…confirm_add_to_blacklist)");
        r11 = r12;
    L5:
        OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.horizontalButton$default(OAlertDialogBuilder.title$default(r0, r11, false, 2, null), false, 1, null), R.string.common_cancel, null, null, 4, null).positiveButton(R.string.common_ok, r10, ButtonStyleController.TextColorType.Negative).build().show();
    }

    public static /* synthetic */ OAlertDialog showConfirmationDialog$default(Context r12, CharSequence r13, CharSequence r14, CharSequence r15, DialogInterface.OnClickListener r16, ButtonStyleController.TextColorType r17, CharSequence r18, DialogInterface.OnClickListener r19, ButtonStyleController.TextColorType r20, int r21, Object r22) {
        if ((r21 & 32) == 0) goto L5;
        ButtonStyleController.TextColorType r8 = null;
    L7:
        if ((r21 & 256) == 0) goto L9;
        ButtonStyleController.TextColorType r11 = null;
    L11:
        return showConfirmationDialog(r12, r13, r14, r15, r16, r8, r18, r19, r11);
    L9:
        r11 = r20;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    @JvmStatic
    public static final OAlertDialog showConfirmationDialog(Context r3, CharSequence r4, CharSequence r5, CharSequence r6, DialogInterface.OnClickListener r7, ButtonStyleController.TextColorType r8, CharSequence r9, DialogInterface.OnClickListener r10, ButtonStyleController.TextColorType r11) {
        Intrinsics.checkNotNullParameter(r3, "context");
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(r3);
        if (r4 == null) goto L5;
        OAlertDialogBuilder.title$default(r0, r4, false, 2, null);
    L5:
        if (r5 == null) goto L7;
        r0.message(r5);
    L7:
        OAlertDialogBuilder.horizontalButton$default(r0, false, 1, null);
        if (r6 == null) goto L10;
        r0.positiveButton(r6, r7, r8);
    L10:
        if (r9 == null) goto L12;
        r0.negativeButton(r9, r10, r11);
    L12:
        OAlertDialog r12 = r0.build();
        r12.show();
        return r12;
    }
}
