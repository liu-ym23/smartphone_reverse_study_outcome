package com.google.android.material.bottomsheet;

import android.content.res.Resources;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements w0.d {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4715g;
    public final /* synthetic */ BottomSheetBehavior h;

    public c(BottomSheetBehavior bottomSheetBehavior, int i10) {
        this.h = bottomSheetBehavior;
        this.f4715g = i10;
    }

    @Override // w0.d
    public final boolean a(View view) throws Resources.NotFoundException {
        this.h.s(this.f4715g);
        return true;
    }
}
