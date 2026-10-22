package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.i;
import o0.C4994b;

/* loaded from: classes.dex */
public class Flow extends i {

    /* renamed from: l, reason: collision with root package name */
    public e f12182l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.i, androidx.constraintlayout.widget.a
    public void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.o(attributeSet);
        this.f12182l = new e();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f12182l.I2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_padding) {
                    this.f12182l.N1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f12182l.S1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f12182l.P1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f12182l.Q1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f12182l.T1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f12182l.R1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f12182l.O1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f12182l.N2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f12182l.C2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f12182l.M2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f12182l.w2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f12182l.E2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f12182l.y2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f12182l.G2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f12182l.A2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f12182l.v2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f12182l.D2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f12182l.x2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f12182l.F2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f12182l.K2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f12182l.z2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f12182l.J2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f12182l.B2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f12182l.L2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f12182l.H2(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f12688d = this.f12182l;
        w();
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i10, int i11) {
        x(this.f12182l, i10, i11);
    }

    @Override // androidx.constraintlayout.widget.a
    public void p(c.a aVar, C4994b c4994b, ConstraintLayout.b bVar, SparseArray<ConstraintWidget> sparseArray) {
        super.p(aVar, c4994b, bVar, sparseArray);
        if (c4994b instanceof e) {
            e eVar = (e) c4994b;
            int i10 = bVar.f12625Z;
            if (i10 != -1) {
                eVar.I2(i10);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.a
    public void q(ConstraintWidget constraintWidget, boolean z10) {
        this.f12182l.y1(z10);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f12182l.v2(f10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f12182l.w2(i10);
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f12182l.x2(f10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f12182l.y2(i10);
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f12182l.z2(i10);
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f12182l.A2(f10);
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f12182l.B2(i10);
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f12182l.C2(i10);
        requestLayout();
    }

    public void setLastHorizontalBias(float f10) {
        this.f12182l.D2(f10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f12182l.E2(i10);
        requestLayout();
    }

    public void setLastVerticalBias(float f10) {
        this.f12182l.F2(f10);
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f12182l.G2(i10);
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f12182l.H2(i10);
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f12182l.I2(i10);
        requestLayout();
    }

    public void setPadding(int i10) {
        this.f12182l.N1(i10);
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f12182l.O1(i10);
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f12182l.Q1(i10);
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f12182l.R1(i10);
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f12182l.T1(i10);
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f12182l.J2(i10);
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f12182l.K2(f10);
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f12182l.L2(i10);
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f12182l.M2(i10);
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f12182l.N2(i10);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.i
    public void x(androidx.constraintlayout.core.widgets.i iVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (iVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            iVar.H1(mode, size, mode2, size2);
            setMeasuredDimension(iVar.C1(), iVar.B1());
        }
    }
}
