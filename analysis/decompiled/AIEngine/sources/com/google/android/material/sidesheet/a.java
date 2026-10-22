package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f5158a;

    public a(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f5158a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public final float b(int i10) {
        float fE = e();
        return (i10 - fE) / (d() - fE);
    }

    @Override // com.google.android.material.sidesheet.d
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int d() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5158a;
        return Math.max(0, sideSheetBehavior.f5144q + sideSheetBehavior.r);
    }

    @Override // com.google.android.material.sidesheet.d
    public final int e() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5158a;
        return (-sideSheetBehavior.f5142o) - sideSheetBehavior.r;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int f() {
        return this.f5158a.r;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int g() {
        return -this.f5158a.f5142o;
    }

    @Override // com.google.android.material.sidesheet.d
    public final <V extends View> int h(V v3) {
        return v3.getRight() + this.f5158a.r;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.d
    public final int j() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean k(float f8) {
        return f8 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean l(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean m(float f8, float f9) {
        return Math.abs(f8) > Math.abs(f9) && Math.abs(f8) > ((float) 500);
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean n(View view, float f8) {
        float left = view.getLeft();
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5158a;
        float fAbs = Math.abs((f8 * sideSheetBehavior.f5141n) + left);
        sideSheetBehavior.getClass();
        return fAbs > 0.5f;
    }

    @Override // com.google.android.material.sidesheet.d
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.leftMargin = i10;
    }

    @Override // com.google.android.material.sidesheet.d
    public final void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        if (i10 <= this.f5158a.f5143p) {
            marginLayoutParams.leftMargin = i11;
        }
    }
}
