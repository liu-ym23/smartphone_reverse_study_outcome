package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    final SideSheetBehavior<? extends View> f13139a;

    a(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f13139a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    float b(int i5) {
        float fD = d();
        return (i5 - fD) / (c() - fD);
    }

    @Override // com.google.android.material.sidesheet.d
    int c() {
        return Math.max(0, this.f13139a.D() + this.f13139a.B());
    }

    @Override // com.google.android.material.sidesheet.d
    int d() {
        return (-this.f13139a.w()) - this.f13139a.B();
    }

    @Override // com.google.android.material.sidesheet.d
    int e() {
        return this.f13139a.B();
    }

    @Override // com.google.android.material.sidesheet.d
    int f() {
        return -this.f13139a.w();
    }

    @Override // com.google.android.material.sidesheet.d
    <V extends View> int g(V v5) {
        return v5.getRight() + this.f13139a.B();
    }

    @Override // com.google.android.material.sidesheet.d
    public int h(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.d
    int i() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean j(float f5) {
        return f5 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean k(View view) {
        return view.getRight() < (c() - d()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean l(float f5, float f6) {
        return e.a(f5, f6) && Math.abs(f5) > ((float) this.f13139a.F());
    }

    @Override // com.google.android.material.sidesheet.d
    boolean m(View view, float f5) {
        return Math.abs(((float) view.getLeft()) + (f5 * this.f13139a.z())) > this.f13139a.A();
    }

    @Override // com.google.android.material.sidesheet.d
    void n(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6) {
        if (i5 <= this.f13139a.E()) {
            marginLayoutParams.leftMargin = i6;
        }
    }
}
