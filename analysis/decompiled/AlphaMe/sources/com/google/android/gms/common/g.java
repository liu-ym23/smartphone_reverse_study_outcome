package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.C0279a;
import androidx.fragment.app.Y;
import androidx.fragment.app.r;

/* loaded from: classes.dex */
public class g extends r {

    /* renamed from: q, reason: collision with root package name */
    public Dialog f9719q;

    /* renamed from: r, reason: collision with root package name */
    public DialogInterface.OnCancelListener f9720r;

    /* renamed from: s, reason: collision with root package name */
    public AlertDialog f9721s;

    @Override // androidx.fragment.app.r
    public final Dialog h() {
        Dialog dialog = this.f9719q;
        if (dialog != null) {
            return dialog;
        }
        this.f3816h = false;
        if (this.f9721s == null) {
            Context context = getContext();
            com.stepos.statsrpk.c.l(context);
            this.f9721s = new AlertDialog.Builder(context).create();
        }
        return this.f9721s;
    }

    public final void i(Y y4, String str) {
        this.f3822n = false;
        this.f3823o = true;
        y4.getClass();
        C0279a c0279a = new C0279a(y4);
        c0279a.f3703p = true;
        c0279a.e(0, this, str, 1);
        c0279a.d(false);
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f9720r;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
