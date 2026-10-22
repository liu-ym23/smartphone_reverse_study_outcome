package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class d extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public c f12846a;

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public c getConstraintSet() {
        if (this.f12846a == null) {
            this.f12846a = new c();
        }
        this.f12846a.r(this);
        return this.f12846a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    public static class a extends ConstraintLayout.b {

        /* renamed from: A0, reason: collision with root package name */
        public float f12847A0;

        /* renamed from: B0, reason: collision with root package name */
        public float f12848B0;

        /* renamed from: C0, reason: collision with root package name */
        public float f12849C0;

        /* renamed from: D0, reason: collision with root package name */
        public float f12850D0;

        /* renamed from: E0, reason: collision with root package name */
        public float f12851E0;

        /* renamed from: F0, reason: collision with root package name */
        public float f12852F0;

        /* renamed from: G0, reason: collision with root package name */
        public float f12853G0;

        /* renamed from: H0, reason: collision with root package name */
        public float f12854H0;

        /* renamed from: I0, reason: collision with root package name */
        public float f12855I0;

        /* renamed from: J0, reason: collision with root package name */
        public float f12856J0;

        /* renamed from: x0, reason: collision with root package name */
        public float f12857x0;

        /* renamed from: y0, reason: collision with root package name */
        public boolean f12858y0;

        /* renamed from: z0, reason: collision with root package name */
        public float f12859z0;

        public a(int i10, int i11) {
            super(i10, i11);
            this.f12857x0 = 1.0f;
            this.f12858y0 = false;
            this.f12859z0 = 0.0f;
            this.f12847A0 = 0.0f;
            this.f12848B0 = 0.0f;
            this.f12849C0 = 0.0f;
            this.f12850D0 = 1.0f;
            this.f12851E0 = 1.0f;
            this.f12852F0 = 0.0f;
            this.f12853G0 = 0.0f;
            this.f12854H0 = 0.0f;
            this.f12855I0 = 0.0f;
            this.f12856J0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12857x0 = 1.0f;
            this.f12858y0 = false;
            this.f12859z0 = 0.0f;
            this.f12847A0 = 0.0f;
            this.f12848B0 = 0.0f;
            this.f12849C0 = 0.0f;
            this.f12850D0 = 1.0f;
            this.f12851E0 = 1.0f;
            this.f12852F0 = 0.0f;
            this.f12853G0 = 0.0f;
            this.f12854H0 = 0.0f;
            this.f12855I0 = 0.0f;
            this.f12856J0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintSet_android_alpha) {
                    this.f12857x0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12857x0);
                } else if (index == R$styleable.ConstraintSet_android_elevation) {
                    this.f12859z0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12859z0);
                    this.f12858y0 = true;
                } else if (index == R$styleable.ConstraintSet_android_rotationX) {
                    this.f12848B0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12848B0);
                } else if (index == R$styleable.ConstraintSet_android_rotationY) {
                    this.f12849C0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12849C0);
                } else if (index == R$styleable.ConstraintSet_android_rotation) {
                    this.f12847A0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12847A0);
                } else if (index == R$styleable.ConstraintSet_android_scaleX) {
                    this.f12850D0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12850D0);
                } else if (index == R$styleable.ConstraintSet_android_scaleY) {
                    this.f12851E0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12851E0);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotX) {
                    this.f12852F0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12852F0);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotY) {
                    this.f12853G0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12853G0);
                } else if (index == R$styleable.ConstraintSet_android_translationX) {
                    this.f12854H0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12854H0);
                } else if (index == R$styleable.ConstraintSet_android_translationY) {
                    this.f12855I0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12855I0);
                } else if (index == R$styleable.ConstraintSet_android_translationZ) {
                    this.f12856J0 = typedArrayObtainStyledAttributes.getFloat(index, this.f12856J0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
