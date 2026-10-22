package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f21297a;

    public b(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f21297a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public float b(int i10) {
        float fE = e();
        return (fE - i10) / (fE - d());
    }

    @Override // com.google.android.material.sidesheet.d
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public int d() {
        return Math.max(0, (e() - this.f21297a.B()) - this.f21297a.I());
    }

    @Override // com.google.android.material.sidesheet.d
    public int e() {
        return this.f21297a.L();
    }

    @Override // com.google.android.material.sidesheet.d
    public int f() {
        return this.f21297a.L();
    }

    @Override // com.google.android.material.sidesheet.d
    public int g() {
        return d();
    }

    @Override // com.google.android.material.sidesheet.d
    public <V extends View> int h(V v10) {
        return v10.getLeft() - this.f21297a.I();
    }

    @Override // com.google.android.material.sidesheet.d
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.d
    public int j() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean k(float f10) {
        return f10 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean l(View view) {
        return view.getLeft() > (e() + d()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean m(float f10, float f11) {
        return e.a(f10, f11) && Math.abs(f10) > ((float) this.f21297a.M());
    }

    @Override // com.google.android.material.sidesheet.d
    public boolean n(View view, float f10) {
        return Math.abs(((float) view.getRight()) + (f10 * this.f21297a.G())) > this.f21297a.H();
    }

    @Override // com.google.android.material.sidesheet.d
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.rightMargin = i10;
    }

    @Override // com.google.android.material.sidesheet.d
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int iL = this.f21297a.L();
        if (i10 <= iL) {
            marginLayoutParams.rightMargin = iL - i10;
        }
    }
}
