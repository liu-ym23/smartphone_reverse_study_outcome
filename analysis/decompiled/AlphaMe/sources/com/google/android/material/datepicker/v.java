package com.google.android.material.datepicker;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class v extends C {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10727a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.D f10728b;

    public v(androidx.fragment.app.D d4, int i4) {
        this.f10727a = i4;
        this.f10728b = d4;
    }

    @Override // com.google.android.material.datepicker.C
    public final void a() {
        int i4 = this.f10727a;
        androidx.fragment.app.D d4 = this.f10728b;
        switch (i4) {
            case 0:
                ((MaterialDatePicker) d4).f10644Q.setEnabled(false);
                break;
            default:
                Iterator it = ((w) d4).f10610a.iterator();
                while (it.hasNext()) {
                    ((C) it.next()).a();
                }
                break;
        }
    }

    @Override // com.google.android.material.datepicker.C
    public final void b(Object obj) {
        int i4 = this.f10727a;
        androidx.fragment.app.D d4 = this.f10728b;
        switch (i4) {
            case 0:
                MaterialDatePicker materialDatePicker = (MaterialDatePicker) d4;
                String strB = materialDatePicker.i().b(materialDatePicker.getContext());
                materialDatePicker.f10641N.setContentDescription(materialDatePicker.i().a(materialDatePicker.requireContext()));
                materialDatePicker.f10641N.setText(strB);
                materialDatePicker.f10644Q.setEnabled(materialDatePicker.i().m());
                break;
            default:
                Iterator it = ((w) d4).f10610a.iterator();
                while (it.hasNext()) {
                    ((C) it.next()).b(obj);
                }
                break;
        }
    }
}
