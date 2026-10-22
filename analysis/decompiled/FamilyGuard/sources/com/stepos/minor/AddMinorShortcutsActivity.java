package com.stepos.minor;

import I2.c;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public class AddMinorShortcutsActivity extends com.stepos.familyguard.ui.base.a {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i5) {
        c.e(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i5) {
        finish();
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new AlertDialog.Builder(this).setView(R.layout.minorshortcuts_dialog_custom_view).setCancelable(false).setPositiveButton(R.string.fg_minor_add_shortcuts_dialog_positive_btn, new DialogInterface.OnClickListener() { // from class: F2.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f1647a.X(dialogInterface, i5);
            }
        }).setNegativeButton(R.string.fg_minor_add_shortcuts_dialog_negative_btn, new DialogInterface.OnClickListener() { // from class: F2.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f1648a.Y(dialogInterface, i5);
            }
        }).show();
        c.h(this, true);
    }
}
