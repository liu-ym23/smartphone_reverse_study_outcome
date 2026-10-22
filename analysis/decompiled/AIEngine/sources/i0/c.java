package i0;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import j0.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends androidx.constraintlayout.widget.b implements MotionLayout.c {

    /* renamed from: l, reason: collision with root package name */
    public boolean f9429l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9430m;

    /* renamed from: n, reason: collision with root package name */
    public float f9431n;

    /* renamed from: o, reason: collision with root package name */
    public View[] f9432o;

    @Override // androidx.constraintlayout.widget.b
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.h);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 1) {
                    this.f9429l = typedArrayObtainStyledAttributes.getBoolean(index, this.f9429l);
                } else if (index == 0) {
                    this.f9430m = typedArrayObtainStyledAttributes.getBoolean(index, this.f9430m);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public float getProgress() {
        return this.f9431n;
    }

    public void setProgress(float f8) {
        this.f9431n = f8;
        int i10 = 0;
        if (this.f1330b <= 0) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int childCount = viewGroup.getChildCount();
            while (i10 < childCount) {
                viewGroup.getChildAt(i10);
                i10++;
            }
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        View[] viewArr = this.f1334j;
        if (viewArr == null || viewArr.length != this.f1330b) {
            this.f1334j = new View[this.f1330b];
        }
        for (int i11 = 0; i11 < this.f1330b; i11++) {
            this.f1334j[i11] = constraintLayout.f1268a.get(this.f1329a[i11]);
        }
        this.f9432o = this.f1334j;
        while (i10 < this.f1330b) {
            View view = this.f9432o[i10];
            i10++;
        }
    }
}
