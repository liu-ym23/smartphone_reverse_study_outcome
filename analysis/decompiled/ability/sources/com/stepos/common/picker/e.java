package com.stepos.common.picker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes3.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3588a;

    public e(f fVar, int i, int i6) {
        this.f3588a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int[] iArrCalculateDistanceToFinalSnap;
        q qVar = this.f3588a.b;
        if (qVar != null) {
            WheelPicker wheelPicker = qVar.f3598a;
            wheelPicker.p = true;
            LinearLayoutManager linearLayoutManager = wheelPicker.g;
            if (linearLayoutManager == null || (iArrCalculateDistanceToFinalSnap = wheelPicker.h.calculateDistanceToFinalSnap(linearLayoutManager, view)) == null) {
                return;
            }
            wheelPicker.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
        }
    }
}
