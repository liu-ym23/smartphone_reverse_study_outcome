package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;

/* loaded from: classes.dex */
public class l extends DialogInterfaceOnCancelListenerC1374l {
    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public Dialog onCreateDialog(Bundle bundle) {
        return new k(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public void setupDialog(Dialog dialog, int i10) {
        if (!(dialog instanceof k)) {
            super.setupDialog(dialog, i10);
            return;
        }
        k kVar = (k) dialog;
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        kVar.h(1);
    }
}
