package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1669j;

/* loaded from: classes2.dex */
public class a extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f19485a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f19486b;

    /* renamed from: c, reason: collision with root package name */
    public Dialog f19487c;

    public static a a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        a aVar = new a();
        Dialog dialog2 = (Dialog) C1669j.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        aVar.f19485a = dialog2;
        if (onCancelListener != null) {
            aVar.f19486b = onCancelListener;
        }
        return aVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f19486b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f19485a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f19487c == null) {
            this.f19487c = new AlertDialog.Builder((Context) C1669j.k(getActivity())).create();
        }
        return this.f19487c;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
