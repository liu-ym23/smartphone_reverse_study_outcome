package com.android.contacts.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.Window;
import com.obric.oui.animation.style.CommonStyleKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/android/contacts/widget/NoDimDialog;", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "context", "Landroid/content/Context;", "widthMatch", "", "withHeightMatchParent", "(Landroid/content/Context;ZZ)V", "performEnterAnimation", "", "performExitAnimation", "show", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoDimDialog extends OAlertDialog {
    public NoDimDialog(Context r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.obric.oui.dialog.alert.OAlertDialog
    public void performEnterAnimation() {
        CommonStyleKt.windowBottomShow(getRootView(), getWindow(), false, 0.0f).start();
    }

    @Override // com.obric.oui.dialog.alert.OAlertDialog
    public void performExitAnimation() {
        ObjectAnimator r0 = CommonStyleKt.windowBottomHide(getRootView(), getWindow(), false);
        r0.addListener(new NoDimDialog$performExitAnimation$1$1(this));
        r0.start();
    }

    @Override // com.obric.oui.dialog.alert.OAlertDialog, com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
        Window r1 = getWindow();
        if (r1 == null) goto L6;
        r1.clearFlags(2);
        return;
    }
}
