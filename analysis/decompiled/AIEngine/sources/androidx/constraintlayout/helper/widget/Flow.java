package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.h;
import j0.d;
import j0.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Flow extends f {

    /* renamed from: n, reason: collision with root package name */
    public e f1235n;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // j0.f, androidx.constraintlayout.widget.b
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f1235n = new e();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f9640b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 0) {
                    this.f1235n.W0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    e eVar = this.f1235n;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    eVar.f1229t0 = dimensionPixelSize;
                    eVar.f1230u0 = dimensionPixelSize;
                    eVar.f1231v0 = dimensionPixelSize;
                    eVar.f1232w0 = dimensionPixelSize;
                } else if (index == 18) {
                    e eVar2 = this.f1235n;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    eVar2.f1231v0 = dimensionPixelSize2;
                    eVar2.f1233x0 = dimensionPixelSize2;
                    eVar2.f1234y0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f1235n.f1232w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f1235n.f1233x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f1235n.f1229t0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f1235n.f1234y0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f1235n.f1230u0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f1235n.U0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f1235n.E0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f1235n.F0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f1235n.G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f1235n.I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f1235n.H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f1235n.J0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f1235n.K0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f1235n.M0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f1235n.O0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f1235n.N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f1235n.P0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f1235n.L0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f1235n.S0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f1235n.T0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f1235n.Q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f1235n.R0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f1235n.V0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f1332d = this.f1235n;
        i();
    }

    @Override // androidx.constraintlayout.widget.b
    public final void h(ConstraintWidget constraintWidget, boolean z) {
        e eVar = this.f1235n;
        int i10 = eVar.f1231v0;
        if (i10 > 0 || eVar.f1232w0 > 0) {
            if (z) {
                eVar.f1233x0 = eVar.f1232w0;
                eVar.f1234y0 = i10;
            } else {
                eVar.f1233x0 = i10;
                eVar.f1234y0 = eVar.f1232w0;
            }
        }
    }

    @Override // j0.f
    public final void j(h hVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (hVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            hVar.T(mode, size, mode2, size2);
            setMeasuredDimension(hVar.A0, hVar.B0);
        }
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i10, int i11) {
        j(this.f1235n, i10, i11);
    }

    public void setFirstHorizontalBias(float f8) {
        this.f1235n.M0 = f8;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f1235n.G0 = i10;
        requestLayout();
    }

    public void setFirstVerticalBias(float f8) {
        this.f1235n.N0 = f8;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f1235n.H0 = i10;
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f1235n.S0 = i10;
        requestLayout();
    }

    public void setHorizontalBias(float f8) {
        this.f1235n.K0 = f8;
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f1235n.Q0 = i10;
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f1235n.E0 = i10;
        requestLayout();
    }

    public void setLastHorizontalBias(float f8) {
        this.f1235n.O0 = f8;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f1235n.I0 = i10;
        requestLayout();
    }

    public void setLastVerticalBias(float f8) {
        this.f1235n.P0 = f8;
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f1235n.J0 = i10;
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f1235n.V0 = i10;
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f1235n.W0 = i10;
        requestLayout();
    }

    public void setPadding(int i10) {
        e eVar = this.f1235n;
        eVar.f1229t0 = i10;
        eVar.f1230u0 = i10;
        eVar.f1231v0 = i10;
        eVar.f1232w0 = i10;
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f1235n.f1230u0 = i10;
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f1235n.f1233x0 = i10;
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f1235n.f1234y0 = i10;
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f1235n.f1229t0 = i10;
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f1235n.T0 = i10;
        requestLayout();
    }

    public void setVerticalBias(float f8) {
        this.f1235n.L0 = f8;
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f1235n.R0 = i10;
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f1235n.F0 = i10;
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f1235n.U0 = i10;
        requestLayout();
    }
}
