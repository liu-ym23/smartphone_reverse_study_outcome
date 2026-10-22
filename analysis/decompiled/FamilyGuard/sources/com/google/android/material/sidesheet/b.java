package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    final SideSheetBehavior<? extends View> f13140a;

    b(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f13140a = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.d
    int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.d
    float b(int i5) {
        float fD = d();
        return (fD - i5) / (fD - c());
    }

    @Override // com.google.android.material.sidesheet.d
    int c() {
        return Math.max(0, (d() - this.f13140a.w()) - this.f13140a.B());
    }

    @Override // com.google.android.material.sidesheet.d
    int d() {
        return this.f13140a.E();
    }

    @Override // com.google.android.material.sidesheet.d
    int e() {
        return this.f13140a.E();
    }

    @Override // com.google.android.material.sidesheet.d
    int f() {
        return c();
    }

    @Override // com.google.android.material.sidesheet.d
    <V extends View> int g(V v5) {
        return v5.getLeft() - this.f13140a.B();
    }

    @Override // com.google.android.material.sidesheet.d
    public int h(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.d
    int i() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean j(float f5) {
        return f5 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean k(View view) {
        return view.getLeft() > (d() + c()) / 2;
    }

    @Override // com.google.android.material.sidesheet.d
    boolean l(float f5, float f6) {
        return e.a(f5, f6) && Math.abs(f5) > ((float) this.f13140a.F());
    }

    @Override // com.google.android.material.sidesheet.d
    boolean m(View view, float f5) {
        return Math.abs(((float) view.getRight()) + (f5 * this.f13140a.z())) > this.f13140a.A();
    }

    @Override // com.google.android.material.sidesheet.d
    void n(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6) {
        int iE = this.f13140a.E();
        if (i5 <= iE) {
            marginLayoutParams.rightMargin = iE - i5;
        }
    }
}
