package y;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.alphame.utils.Property;
import v.C0947g;

/* loaded from: classes.dex */
public abstract class t extends AbstractC0984c {

    /* renamed from: h, reason: collision with root package name */
    public boolean f16161h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16162i;

    @Override // y.AbstractC0984c
    public final void e(ConstraintLayout constraintLayout) {
        d(constraintLayout);
    }

    @Override // y.AbstractC0984c
    public void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f16152b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                if (index == 6) {
                    this.f16161h = true;
                } else if (index == 22) {
                    this.f16162i = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public abstract void j(C0947g c0947g, int i4, int i5);

    @Override // y.AbstractC0984c, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16161h || this.f16162i) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i4 = 0; i4 < this.f15946b; i4++) {
                    View view = (View) constraintLayout.f3229a.get(this.f15945a[i4]);
                    if (view != null) {
                        if (this.f16161h) {
                            view.setVisibility(visibility);
                        }
                        if (this.f16162i && elevation > Property.DEFAULT_FLOAT_VALUE) {
                            view.setTranslationZ(view.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        d((ConstraintLayout) parent);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        d((ConstraintLayout) parent);
    }
}
