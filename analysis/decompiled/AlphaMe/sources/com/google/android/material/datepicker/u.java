package com.google.android.material.datepicker;

import K.InterfaceC0088u;
import K.z0;
import android.view.View;

/* loaded from: classes.dex */
public final class u implements InterfaceC0088u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10722a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f10723b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10724c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10725d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f10726e;

    public u(int i4, View view, int i5, int i6, int i7) {
        this.f10722a = i4;
        this.f10723b = view;
        this.f10724c = i5;
        this.f10725d = i6;
        this.f10726e = i7;
    }

    @Override // K.InterfaceC0088u
    public final z0 e(View view, z0 z0Var) {
        D.c cVarF = z0Var.f1023a.f(7);
        int i4 = this.f10722a;
        View view2 = this.f10723b;
        if (i4 >= 0) {
            view2.getLayoutParams().height = i4 + cVarF.f358b;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(this.f10724c + cVarF.f357a, this.f10725d + cVarF.f358b, this.f10726e + cVarF.f359c, view2.getPaddingBottom());
        return z0Var;
    }
}
