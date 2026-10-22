package com.stepos.common.picker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f11370a;

    public d(f fVar, int i4, int i5) {
        this.f11370a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int[] iArrCalculateDistanceToFinalSnap;
        e eVar = this.f11370a.f11372b;
        if (eVar != null) {
            WheelPicker wheelPicker = ((q) eVar).f11391a;
            wheelPicker.f11358p = true;
            LinearLayoutManager linearLayoutManager = wheelPicker.f11349g;
            if (linearLayoutManager == null || (iArrCalculateDistanceToFinalSnap = wheelPicker.f11350h.calculateDistanceToFinalSnap(linearLayoutManager, view)) == null) {
                return;
            }
            wheelPicker.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
        }
    }
}
