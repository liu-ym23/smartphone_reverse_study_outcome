package com.google.android.material.textfield;

import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5231a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f5232b;

    public /* synthetic */ a(l lVar, int i10) {
        this.f5231a = i10;
        this.f5232b = lVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        int i10 = this.f5231a;
        l lVar = this.f5232b;
        switch (i10) {
            case 0:
                c cVar = (c) lVar;
                cVar.s(cVar.t());
                break;
            default:
                j jVar = (j) lVar;
                jVar.f5253l = z;
                jVar.p();
                if (!z) {
                    jVar.s(false);
                    jVar.f5254m = false;
                    break;
                }
                break;
        }
    }
}
