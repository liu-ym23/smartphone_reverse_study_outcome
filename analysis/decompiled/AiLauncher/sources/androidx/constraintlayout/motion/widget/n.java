package androidx.constraintlayout.motion.widget;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class n extends androidx.constraintlayout.widget.a implements MotionLayout.j {

    /* renamed from: j, reason: collision with root package name */
    public boolean f12408j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12409k;

    /* renamed from: l, reason: collision with root package name */
    public float f12410l;

    /* renamed from: m, reason: collision with root package name */
    public View[] f12411m;

    public void A(MotionLayout motionLayout) {
    }

    public void B(Canvas canvas) {
    }

    public void C(Canvas canvas) {
    }

    public void D(MotionLayout motionLayout, HashMap<View, m> map) {
    }

    public void E(View view, float f10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
    public void a(MotionLayout motionLayout, int i10, int i11, float f10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
    public void b(MotionLayout motionLayout, int i10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
    public void c(MotionLayout motionLayout, int i10, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
    public void d(MotionLayout motionLayout, int i10, boolean z10, float f10) {
    }

    public float getProgress() {
        return this.f12410l;
    }

    @Override // androidx.constraintlayout.widget.a
    public void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.o(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.f12408j = typedArrayObtainStyledAttributes.getBoolean(index, this.f12408j);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.f12409k = typedArrayObtainStyledAttributes.getBoolean(index, this.f12409k);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f12410l = f10;
        int i10 = 0;
        if (this.f12686b > 0) {
            this.f12411m = n((ConstraintLayout) getParent());
            while (i10 < this.f12686b) {
                E(this.f12411m[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof n)) {
                E(childAt, f10);
            }
            i10++;
        }
    }

    public boolean x() {
        return false;
    }

    public boolean y() {
        return this.f12409k;
    }

    public boolean z() {
        return this.f12408j;
    }
}
