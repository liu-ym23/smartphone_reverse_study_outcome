package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class e extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    d f9061a;

    /* JADX INFO: Access modifiers changed from: protected */
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

    public d getConstraintSet() {
        if (this.f9061a == null) {
            this.f9061a = new d();
        }
        this.f9061a.h(this);
        return this.f9061a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    public static class a extends ConstraintLayout.b {

        /* renamed from: A0, reason: collision with root package name */
        public float f9062A0;

        /* renamed from: B0, reason: collision with root package name */
        public float f9063B0;

        /* renamed from: C0, reason: collision with root package name */
        public float f9064C0;

        /* renamed from: D0, reason: collision with root package name */
        public float f9065D0;

        /* renamed from: E0, reason: collision with root package name */
        public float f9066E0;

        /* renamed from: F0, reason: collision with root package name */
        public float f9067F0;

        /* renamed from: G0, reason: collision with root package name */
        public float f9068G0;

        /* renamed from: H0, reason: collision with root package name */
        public float f9069H0;

        /* renamed from: I0, reason: collision with root package name */
        public float f9070I0;

        /* renamed from: J0, reason: collision with root package name */
        public float f9071J0;

        /* renamed from: x0, reason: collision with root package name */
        public float f9072x0;

        /* renamed from: y0, reason: collision with root package name */
        public boolean f9073y0;

        /* renamed from: z0, reason: collision with root package name */
        public float f9074z0;

        public a(int i5, int i6) {
            super(i5, i6);
            this.f9072x0 = 1.0f;
            this.f9073y0 = false;
            this.f9074z0 = 0.0f;
            this.f9062A0 = 0.0f;
            this.f9063B0 = 0.0f;
            this.f9064C0 = 0.0f;
            this.f9065D0 = 1.0f;
            this.f9066E0 = 1.0f;
            this.f9067F0 = 0.0f;
            this.f9068G0 = 0.0f;
            this.f9069H0 = 0.0f;
            this.f9070I0 = 0.0f;
            this.f9071J0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9072x0 = 1.0f;
            this.f9073y0 = false;
            this.f9074z0 = 0.0f;
            this.f9062A0 = 0.0f;
            this.f9063B0 = 0.0f;
            this.f9064C0 = 0.0f;
            this.f9065D0 = 1.0f;
            this.f9066E0 = 1.0f;
            this.f9067F0 = 0.0f;
            this.f9068G0 = 0.0f;
            this.f9069H0 = 0.0f;
            this.f9070I0 = 0.0f;
            this.f9071J0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f9143K4);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.f9149L4) {
                    this.f9072x0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9072x0);
                } else if (index == i.f9215W4) {
                    this.f9074z0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9074z0);
                    this.f9073y0 = true;
                } else if (index == i.f9197T4) {
                    this.f9063B0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9063B0);
                } else if (index == i.f9203U4) {
                    this.f9064C0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9064C0);
                } else if (index == i.f9191S4) {
                    this.f9062A0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9062A0);
                } else if (index == i.f9179Q4) {
                    this.f9065D0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9065D0);
                } else if (index == i.f9185R4) {
                    this.f9066E0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9066E0);
                } else if (index == i.f9155M4) {
                    this.f9067F0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9067F0);
                } else if (index == i.f9161N4) {
                    this.f9068G0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9068G0);
                } else if (index == i.f9167O4) {
                    this.f9069H0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9069H0);
                } else if (index == i.f9173P4) {
                    this.f9070I0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9070I0);
                } else if (index == i.f9209V4) {
                    this.f9071J0 = typedArrayObtainStyledAttributes.getFloat(index, this.f9071J0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
