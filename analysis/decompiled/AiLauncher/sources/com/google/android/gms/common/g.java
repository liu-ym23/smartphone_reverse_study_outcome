package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.C1669j;

/* loaded from: classes2.dex */
public class g extends DialogInterfaceOnCancelListenerC1374l {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f19719a;

    /* renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f19720b;

    /* renamed from: c, reason: collision with root package name */
    public Dialog f19721c;

    public static g o(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        g gVar = new g();
        Dialog dialog2 = (Dialog) C1669j.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        gVar.f19719a = dialog2;
        if (onCancelListener != null) {
            gVar.f19720b = onCancelListener;
        }
        return gVar;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f19720b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f19719a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f19721c == null) {
            this.f19721c = new AlertDialog.Builder((Context) C1669j.k(getContext())).create();
        }
        return this.f19721c;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
