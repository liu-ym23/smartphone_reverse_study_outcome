package com.stepos.familyguard.ui.common;

import J1.b;
import P1.a;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.BaseDialogFragment;

/* loaded from: classes.dex */
public class LoadingDialogFragment extends BaseDialogFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public boolean j2(DialogInterface dialogInterface, int i5, KeyEvent keyEvent) {
        return i5 == 4;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e
    public Dialog b2(Bundle bundle) {
        String string = u() == null ? null : u().getString("key_dialog_msg");
        if (string == null) {
            string = a.b(R.string.fg_ui_loading, new Object[0]);
        }
        b bVar = new b(w());
        bVar.setCancelable(false);
        bVar.b(string);
        bVar.setCanceledOnTouchOutside(false);
        bVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: s2.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i5, KeyEvent keyEvent) {
                return this.f20241a.j2(dialogInterface, i5, keyEvent);
            }
        });
        return bVar;
    }
}
