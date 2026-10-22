package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.G0;

/* loaded from: classes.dex */
public final class s implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f11095a;

    public s(u uVar) {
        this.f11095a = uVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        Object item;
        u uVar = this.f11095a;
        if (i4 < 0) {
            G0 g02 = uVar.f11099e;
            item = !g02.f2846z.isShowing() ? null : g02.f2823c.getSelectedItem();
        } else {
            item = uVar.getAdapter().getItem(i4);
        }
        uVar.setText(uVar.convertSelectionToString(item), false);
        AdapterView.OnItemClickListener onItemClickListener = uVar.getOnItemClickListener();
        G0 g03 = uVar.f11099e;
        if (onItemClickListener != null) {
            if (view == null || i4 < 0) {
                view = g03.f2846z.isShowing() ? g03.f2823c.getSelectedView() : null;
                i4 = !g03.f2846z.isShowing() ? -1 : g03.f2823c.getSelectedItemPosition();
                j4 = !g03.f2846z.isShowing() ? Long.MIN_VALUE : g03.f2823c.getSelectedItemId();
            }
            onItemClickListener.onItemClick(g03.f2823c, view, i4, j4);
        }
        g03.dismiss();
    }
}
