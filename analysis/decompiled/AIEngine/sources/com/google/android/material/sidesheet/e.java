package com.google.android.material.sidesheet;

import android.content.Context;
import android.view.View;
import com.stepos.core.cta.CTADialogGate;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5160a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5161b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5162c;

    public /* synthetic */ e(int i10, int i11, Object obj) {
        this.f5160a = i11;
        this.f5162c = obj;
        this.f5161b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5160a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f5162c;
                View view = (View) sideSheetBehavior.f5145s.get();
                if (view != null) {
                    sideSheetBehavior.j(view, this.f5161b, false);
                    break;
                }
                break;
            default:
                CTADialogGate.requestDialog$lambda$14((Context) this.f5162c, this.f5161b);
                break;
        }
    }
}
