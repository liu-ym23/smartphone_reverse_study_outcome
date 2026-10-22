package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import o0.C4994b;

/* loaded from: classes.dex */
public class Barrier extends a {

    /* renamed from: j, reason: collision with root package name */
    public int f12588j;

    /* renamed from: k, reason: collision with root package name */
    public int f12589k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.a f12590l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f12590l.z1();
    }

    public int getMargin() {
        return this.f12590l.B1();
    }

    public int getType() {
        return this.f12588j;
    }

    @Override // androidx.constraintlayout.widget.a
    public void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.o(attributeSet);
        this.f12590l = new androidx.constraintlayout.core.widgets.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f12590l.E1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f12590l.G1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f12688d = this.f12590l;
        w();
    }

    @Override // androidx.constraintlayout.widget.a
    public void p(c.a aVar, C4994b c4994b, ConstraintLayout.b bVar, SparseArray<ConstraintWidget> sparseArray) {
        super.p(aVar, c4994b, bVar, sparseArray);
        if (c4994b instanceof androidx.constraintlayout.core.widgets.a) {
            androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) c4994b;
            x(aVar2, aVar.f12725e.f12783h0, ((androidx.constraintlayout.core.widgets.d) c4994b.M()).V1());
            aVar2.E1(aVar.f12725e.f12799p0);
            aVar2.G1(aVar.f12725e.f12785i0);
        }
    }

    @Override // androidx.constraintlayout.widget.a
    public void q(ConstraintWidget constraintWidget, boolean z10) {
        x(constraintWidget, this.f12588j, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f12590l.E1(z10);
    }

    public void setDpMargin(int i10) {
        this.f12590l.G1((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f12590l.G1(i10);
    }

    public void setType(int i10) {
        this.f12588j = i10;
    }

    public final void x(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f12589k = i10;
        if (z10) {
            int i11 = this.f12588j;
            if (i11 == 5) {
                this.f12589k = 1;
            } else if (i11 == 6) {
                this.f12589k = 0;
            }
        } else {
            int i12 = this.f12588j;
            if (i12 == 5) {
                this.f12589k = 0;
            } else if (i12 == 6) {
                this.f12589k = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a) constraintWidget).F1(this.f12589k);
        }
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
