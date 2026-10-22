package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.i;
import androidx.constraintlayout.widget.k;
import v.e;
import v.g;
import v.l;

/* loaded from: classes.dex */
public class Flow extends k {

    /* renamed from: l, reason: collision with root package name */
    private g f8651l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.k, androidx.constraintlayout.widget.b
    protected void m(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.m(attributeSet);
        this.f8651l = new g();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f9319n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.f9325o1) {
                    this.f8651l.D2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9331p1) {
                    this.f8651l.I1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9391z1) {
                    this.f8651l.N1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9080A1) {
                    this.f8651l.K1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9337q1) {
                    this.f8651l.L1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9343r1) {
                    this.f8651l.O1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9349s1) {
                    this.f8651l.M1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9355t1) {
                    this.f8651l.J1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9230Z1) {
                    this.f8651l.I2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9170P1) {
                    this.f8651l.x2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9224Y1) {
                    this.f8651l.H2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9134J1) {
                    this.f8651l.r2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9182R1) {
                    this.f8651l.z2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9146L1) {
                    this.f8651l.t2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9194T1) {
                    this.f8651l.B2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.f9158N1) {
                    this.f8651l.v2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.f9128I1) {
                    this.f8651l.q2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.f9176Q1) {
                    this.f8651l.y2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.f9140K1) {
                    this.f8651l.s2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.f9188S1) {
                    this.f8651l.A2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.f9212W1) {
                    this.f8651l.F2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == i.f9152M1) {
                    this.f8651l.u2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == i.f9206V1) {
                    this.f8651l.E2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == i.f9164O1) {
                    this.f8651l.w2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9218X1) {
                    this.f8651l.G2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == i.f9200U1) {
                    this.f8651l.C2(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f8906d = this.f8651l;
        s();
    }

    @Override // androidx.constraintlayout.widget.b
    public void n(e eVar, boolean z5) {
        this.f8651l.t1(z5);
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    protected void onMeasure(int i5, int i6) {
        t(this.f8651l, i5, i6);
    }

    public void setFirstHorizontalBias(float f5) {
        this.f8651l.q2(f5);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i5) {
        this.f8651l.r2(i5);
        requestLayout();
    }

    public void setFirstVerticalBias(float f5) {
        this.f8651l.s2(f5);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i5) {
        this.f8651l.t2(i5);
        requestLayout();
    }

    public void setHorizontalAlign(int i5) {
        this.f8651l.u2(i5);
        requestLayout();
    }

    public void setHorizontalBias(float f5) {
        this.f8651l.v2(f5);
        requestLayout();
    }

    public void setHorizontalGap(int i5) {
        this.f8651l.w2(i5);
        requestLayout();
    }

    public void setHorizontalStyle(int i5) {
        this.f8651l.x2(i5);
        requestLayout();
    }

    public void setLastHorizontalBias(float f5) {
        this.f8651l.y2(f5);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i5) {
        this.f8651l.z2(i5);
        requestLayout();
    }

    public void setLastVerticalBias(float f5) {
        this.f8651l.A2(f5);
        requestLayout();
    }

    public void setLastVerticalStyle(int i5) {
        this.f8651l.B2(i5);
        requestLayout();
    }

    public void setMaxElementsWrap(int i5) {
        this.f8651l.C2(i5);
        requestLayout();
    }

    public void setOrientation(int i5) {
        this.f8651l.D2(i5);
        requestLayout();
    }

    public void setPadding(int i5) {
        this.f8651l.I1(i5);
        requestLayout();
    }

    public void setPaddingBottom(int i5) {
        this.f8651l.J1(i5);
        requestLayout();
    }

    public void setPaddingLeft(int i5) {
        this.f8651l.L1(i5);
        requestLayout();
    }

    public void setPaddingRight(int i5) {
        this.f8651l.M1(i5);
        requestLayout();
    }

    public void setPaddingTop(int i5) {
        this.f8651l.O1(i5);
        requestLayout();
    }

    public void setVerticalAlign(int i5) {
        this.f8651l.E2(i5);
        requestLayout();
    }

    public void setVerticalBias(float f5) {
        this.f8651l.F2(f5);
        requestLayout();
    }

    public void setVerticalGap(int i5) {
        this.f8651l.G2(i5);
        requestLayout();
    }

    public void setVerticalStyle(int i5) {
        this.f8651l.H2(i5);
        requestLayout();
    }

    public void setWrapMode(int i5) {
        this.f8651l.I2(i5);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.k
    public void t(l lVar, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (lVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            lVar.C1(mode, size, mode2, size2);
            setMeasuredDimension(lVar.x1(), lVar.w1());
        }
    }
}
