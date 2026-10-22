package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f5159a;

    public b(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f5159a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public final float b(int i10) {
        float f8 = this.f5159a.f5143p;
        return (f8 - i10) / (f8 - d());
    }

    @Override // com.google.android.material.sidesheet.d
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int d() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5159a;
        return Math.max(0, (sideSheetBehavior.f5143p - sideSheetBehavior.f5142o) - sideSheetBehavior.r);
    }

    @Override // com.google.android.material.sidesheet.d
    public final int e() {
        return this.f5159a.f5143p;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int f() {
        return this.f5159a.f5143p;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int g() {
        return d();
    }

    @Override // com.google.android.material.sidesheet.d
    public final <V extends View> int h(V v3) {
        return v3.getLeft() - this.f5159a.r;
    }

    @Override // com.google.android.material.sidesheet.d
    public final int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.d
    public final int j() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean k(float f8) {
        return f8 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean l(View view) {
        return view.getLeft() > (d() + this.f5159a.f5143p) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean m(float f8, float f9) {
        return Math.abs(f8) > Math.abs(f9) && Math.abs(f8) > ((float) 500);
    }

    @Override // com.google.android.material.sidesheet.d
    public final boolean n(View view, float f8) {
        float right = view.getRight();
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5159a;
        float fAbs = Math.abs((f8 * sideSheetBehavior.f5141n) + right);
        sideSheetBehavior.getClass();
        return fAbs > 0.5f;
    }

    @Override // com.google.android.material.sidesheet.d
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.rightMargin = i10;
    }

    @Override // com.google.android.material.sidesheet.d
    public final void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int i12 = this.f5159a.f5143p;
        if (i10 <= i12) {
            marginLayoutParams.rightMargin = i12 - i10;
        }
    }
}
