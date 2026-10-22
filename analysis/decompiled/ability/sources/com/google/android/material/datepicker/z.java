package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class z extends H {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2442a;
    public final /* synthetic */ Fragment b;

    public /* synthetic */ z(Fragment fragment, int i) {
        this.f2442a = i;
        this.b = fragment;
    }

    @Override // com.google.android.material.datepicker.H
    public final void a() {
        switch (this.f2442a) {
            case 0:
                ((A) this.b).f2395A.setEnabled(false);
                break;
            default:
                Iterator it = ((B) this.b).f2414a.iterator();
                while (it.hasNext()) {
                    ((H) it.next()).a();
                }
                break;
        }
    }

    @Override // com.google.android.material.datepicker.H
    public final void b(Object obj) {
        switch (this.f2442a) {
            case 0:
                A a3 = (A) this.b;
                String selectionDisplayString = a3.b().getSelectionDisplayString(a3.getContext());
                a3.f2407x.setContentDescription(a3.b().getSelectionContentDescription(a3.requireContext()));
                a3.f2407x.setText(selectionDisplayString);
                a3.f2395A.setEnabled(a3.b().isSelectionComplete());
                break;
            default:
                Iterator it = ((B) this.b).f2414a.iterator();
                while (it.hasNext()) {
                    ((H) it.next()).b(obj);
                }
                break;
        }
    }
}
