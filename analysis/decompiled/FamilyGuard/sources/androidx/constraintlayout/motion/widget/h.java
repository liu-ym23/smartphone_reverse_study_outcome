package androidx.constraintlayout.motion.widget;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.j;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class h extends androidx.constraintlayout.widget.b implements j.d {

    /* renamed from: j, reason: collision with root package name */
    private boolean f8687j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8688k;

    /* renamed from: l, reason: collision with root package name */
    private float f8689l;

    /* renamed from: m, reason: collision with root package name */
    protected View[] f8690m;

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void a(j jVar, int i5, int i6, float f5) {
    }

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void b(j jVar, int i5, int i6) {
    }

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void c(j jVar, int i5) {
    }

    public float getProgress() {
        return this.f8689l;
    }

    @Override // androidx.constraintlayout.widget.b
    protected void m(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.m(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.a7);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == androidx.constraintlayout.widget.i.c7) {
                    this.f8687j = typedArrayObtainStyledAttributes.getBoolean(index, this.f8687j);
                } else if (index == androidx.constraintlayout.widget.i.b7) {
                    this.f8688k = typedArrayObtainStyledAttributes.getBoolean(index, this.f8688k);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f5) {
        this.f8689l = f5;
        int i5 = 0;
        if (this.f8904b > 0) {
            this.f8690m = l((ConstraintLayout) getParent());
            while (i5 < this.f8904b) {
                x(this.f8690m[i5], f5);
                i5++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i5 < childCount) {
            View childAt = viewGroup.getChildAt(i5);
            if (!(childAt instanceof h)) {
                x(childAt, f5);
            }
            i5++;
        }
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return this.f8688k;
    }

    public boolean v() {
        return this.f8687j;
    }

    public void w(Canvas canvas) {
    }

    public void x(View view, float f5) {
    }
}
