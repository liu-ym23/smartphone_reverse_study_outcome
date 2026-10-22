package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintSet f2373a;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float H0;
        public float I0;
        public float J0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public float f2374x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public boolean f2375y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public float f2376z0;

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f2374x0 = 1.0f;
            this.f2375y0 = false;
            this.f2376z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f2374x0 = 1.0f;
            int r12 = 0;
            this.f2375y0 = false;
            this.f2376z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            this.J0 = 0.0f;
            TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.ConstraintSet);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L41;
            int r15 = r13.getIndex(r12);
            if (r15 != R$styleable.ConstraintSet_android_alpha) goto L8;
            this.f2374x0 = r13.getFloat(r15, this.f2374x0);
        L40:
            r12 = r12 + 1;
            goto L3
        L8:
            if (r15 != R$styleable.ConstraintSet_android_elevation) goto L11;
            this.f2376z0 = r13.getFloat(r15, this.f2376z0);
            this.f2375y0 = true;
            goto L40
        L11:
            if (r15 != R$styleable.ConstraintSet_android_rotationX) goto L14;
            this.B0 = r13.getFloat(r15, this.B0);
            goto L40
        L14:
            if (r15 != R$styleable.ConstraintSet_android_rotationY) goto L17;
            this.C0 = r13.getFloat(r15, this.C0);
            goto L40
        L17:
            if (r15 != R$styleable.ConstraintSet_android_rotation) goto L20;
            this.A0 = r13.getFloat(r15, this.A0);
            goto L40
        L20:
            if (r15 != R$styleable.ConstraintSet_android_scaleX) goto L23;
            this.D0 = r13.getFloat(r15, this.D0);
            goto L40
        L23:
            if (r15 != R$styleable.ConstraintSet_android_scaleY) goto L26;
            this.E0 = r13.getFloat(r15, this.E0);
            goto L40
        L26:
            if (r15 != R$styleable.ConstraintSet_android_transformPivotX) goto L29;
            this.F0 = r13.getFloat(r15, this.F0);
            goto L40
        L29:
            if (r15 != R$styleable.ConstraintSet_android_transformPivotY) goto L32;
            this.G0 = r13.getFloat(r15, this.G0);
            goto L40
        L32:
            if (r15 != R$styleable.ConstraintSet_android_translationX) goto L35;
            this.H0 = r13.getFloat(r15, this.H0);
            goto L40
        L35:
            if (r15 != R$styleable.ConstraintSet_android_translationY) goto L38;
            this.I0 = r13.getFloat(r15, this.I0);
            goto L40
        L38:
            if (r15 != R$styleable.ConstraintSet_android_translationZ) goto L40;
            this.J0 = r13.getFloat(r15, this.J0);
            goto L40
        L41:
            r13.recycle();
        }
    }

    public Constraints(Context r10) {
        super(r10);
        super.setVisibility(8);
    }

    public LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams b(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    public final void c(AttributeSet r10) {
        Log.v("Constraints", " ################# init");
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return b(r10);
    }

    public ConstraintSet getConstraintSet() {
        if (this.f2373a != null) goto L5;
        this.f2373a = new ConstraintSet();
    L5:
        this.f2373a.s(this);
        return this.f2373a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new ConstraintLayout.LayoutParams(r10);
    }

    public Constraints(Context r10, AttributeSet r11) {
        super(r10, r11);
        c(r11);
        super.setVisibility(8);
    }

    public Constraints(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        c(r11);
        super.setVisibility(8);
    }
}
