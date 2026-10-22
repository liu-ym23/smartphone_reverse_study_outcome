package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f21296a;

    public a(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f21296a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public float b(int i10) {
        float fE = e();
        return (i10 - fE) / (d() - fE);
    }

    @Override // com.google.android.material.sidesheet.d
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public int d() {
        return Math.max(0, this.f21296a.K() + this.f21296a.I());
    }

    @Override // com.google.android.material.sidesheet.d
    public int e() {
        return (-this.f21296a.B()) - this.f21296a.I();
    }

    @Override // com.google.android.material.sidesheet.d
    public int f() {
        return this.f21296a.I();
    }

    @Override // com.google.android.material.sidesheet.d
    public int g() {
        return -this.f21296a.B();
    }

    @Override // com.google.android.material.sidesheet.d
    public <V extends View> int h(V v10) {
        return v10.getRight() + this.f21296a.I();
    }

    @Override // com.google.android.material.sidesheet.d
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.d
    public int j() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean k(float f10) {
        return f10 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean l(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean m(float f10, float f11) {
        return e.a(f10, f11) && Math.abs(f10) > ((float) this.f21296a.M());
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean n(View view, float f10) {
        return Math.abs(((float) view.getLeft()) + (f10 * this.f21296a.G())) > this.f21296a.H();
    }

    @Override // com.google.android.material.sidesheet.d
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.leftMargin = i10;
    }

    @Override // com.google.android.material.sidesheet.d
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        if (i10 <= this.f21296a.L()) {
            marginLayoutParams.leftMargin = i11;
        }
    }
}
