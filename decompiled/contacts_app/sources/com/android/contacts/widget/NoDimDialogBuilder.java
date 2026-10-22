package com.android.contacts.widget;

import android.content.Context;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/android/contacts/widget/NoDimDialogBuilder;", "Lcom/obric/oui/dialog/alert/OAlertDialogBuilder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "newDialogInstance", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "widthMatch", "", "withHeightMatchParent", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoDimDialogBuilder extends OAlertDialogBuilder {
    public NoDimDialogBuilder(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.obric.oui.dialog.alert.OAlertDialogBuilder
    public OAlertDialog newDialogInstance(Context r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new NoDimDialog(r1, r2, r3);
    }
}
