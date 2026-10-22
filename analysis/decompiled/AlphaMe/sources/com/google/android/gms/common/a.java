package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class a extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f9604a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f9605b;

    /* renamed from: c, reason: collision with root package name */
    public AlertDialog f9606c;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f9605b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f9604a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f9606c == null) {
            Activity activity = getActivity();
            com.stepos.statsrpk.c.l(activity);
            this.f9606c = new AlertDialog.Builder(activity).create();
        }
        return this.f9606c;
    }

    @Override // android.app.DialogFragment
    public final void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
