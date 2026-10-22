package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.k0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f5319a;

    public p(q qVar) {
        this.f5319a = qVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        q qVar = this.f5319a;
        k0 k0Var = qVar.f5320e;
        qVar.setText(qVar.convertSelectionToString(i10 < 0 ? !k0Var.C.isShowing() ? null : k0Var.f864c.getSelectedItem() : qVar.getAdapter().getItem(i10)), false);
        AdapterView.OnItemClickListener onItemClickListener = qVar.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i10 < 0) {
                view = !k0Var.C.isShowing() ? null : k0Var.f864c.getSelectedView();
                i10 = !k0Var.C.isShowing() ? -1 : k0Var.f864c.getSelectedItemPosition();
                j10 = !k0Var.C.isShowing() ? Long.MIN_VALUE : k0Var.f864c.getSelectedItemId();
            }
            onItemClickListener.onItemClick(k0Var.f864c, view, i10, j10);
        }
        k0Var.dismiss();
    }
}
