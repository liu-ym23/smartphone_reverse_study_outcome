package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: l, reason: collision with root package name */
    public int f1326l;

    /* renamed from: m, reason: collision with root package name */
    public int f1327m;

    /* renamed from: n, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.a f1328n;

    @Override // androidx.constraintlayout.widget.b
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f1328n = new androidx.constraintlayout.core.widgets.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j0.d.f9640b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 26) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == 25) {
                    this.f1328n.f1142u0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.f1328n.f1143v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f1332d = this.f1328n;
        i();
    }

    public boolean getAllowsGoneWidget() {
        return this.f1328n.f1142u0;
    }

    public int getMargin() {
        return this.f1328n.f1143v0;
    }

    public int getType() {
        return this.f1326l;
    }

    @Override // androidx.constraintlayout.widget.b
    public final void h(ConstraintWidget constraintWidget, boolean z) {
        int i10 = this.f1326l;
        this.f1327m = i10;
        if (z) {
            if (i10 == 5) {
                this.f1327m = 1;
            } else if (i10 == 6) {
                this.f1327m = 0;
            }
        } else if (i10 == 5) {
            this.f1327m = 0;
        } else if (i10 == 6) {
            this.f1327m = 1;
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a) constraintWidget).f1141t0 = this.f1327m;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f1328n.f1142u0 = z;
    }

    public void setDpMargin(int i10) {
        this.f1328n.f1143v0 = (int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i10) {
        this.f1328n.f1143v0 = i10;
    }

    public void setType(int i10) {
        this.f1326l = i10;
    }
}
