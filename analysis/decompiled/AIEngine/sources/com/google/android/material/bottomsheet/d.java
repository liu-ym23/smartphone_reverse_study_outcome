package com.google.android.material.bottomsheet;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.h;
import java.util.ArrayList;
import v0.m0;
import v0.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements r {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f4716g;

    public d(h hVar) {
        this.f4716g = hVar;
    }

    @Override // v0.r
    public final m0 g(View view, m0 m0Var) {
        h hVar = this.f4716g;
        h.b bVar = hVar.f4725p;
        if (bVar != null) {
            hVar.h.b0.remove(bVar);
        }
        h.b bVar2 = new h.b(hVar.f4721l, m0Var);
        hVar.f4725p = bVar2;
        bVar2.e(hVar.getWindow());
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = hVar.h;
        h.b bVar3 = hVar.f4725p;
        ArrayList<BottomSheetBehavior.d> arrayList = bottomSheetBehavior.b0;
        if (!arrayList.contains(bVar3)) {
            arrayList.add(bVar3);
        }
        return m0Var;
    }
}
