package com.android.contacts.group;

import android.content.Context;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupEditorFormDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/group/GroupEditorFormDialog;", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "context", "Landroid/content/Context;", "modifier", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;", "onFinishCallback", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog$Modifier;Lkotlin/jvm/functions/Function0;)V", "originDismiss", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GroupEditorFormDialog extends OSimpleFormDialog {
    private final Function0<Unit> onFinishCallback;

    public GroupEditorFormDialog(Context r2, OSimpleFormDialog.Modifier r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "modifier");
        Intrinsics.checkNotNullParameter(r4, "onFinishCallback");
        super(r2, r3);
        this.onFinishCallback = r4;
    }

    @Override // com.obric.oui.dialog.base.OBaseDialog
    public void originDismiss() {
        super.originDismiss();
        this.onFinishCallback.invoke();
    }
}
