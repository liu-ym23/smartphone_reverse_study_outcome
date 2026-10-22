package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import v.C0944d;
import v.C0947g;
import w.C0956b;
import y.r;
import y.t;

/* loaded from: classes.dex */
public class Flow extends t {

    /* renamed from: j, reason: collision with root package name */
    public C0947g f3227j;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15945a = new int[32];
        this.f15951g = new HashMap();
        this.f15947c = context;
        g(attributeSet);
    }

    @Override // y.t, y.AbstractC0984c
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        C0947g c0947g = new C0947g();
        c0947g.f15657s0 = 0;
        c0947g.f15658t0 = 0;
        c0947g.f15659u0 = 0;
        c0947g.f15660v0 = 0;
        c0947g.f15661w0 = 0;
        c0947g.f15662x0 = 0;
        c0947g.f15663y0 = false;
        c0947g.f15664z0 = 0;
        c0947g.f15630A0 = 0;
        c0947g.f15631B0 = new C0956b();
        c0947g.f15632C0 = null;
        c0947g.f15633D0 = -1;
        c0947g.f15634E0 = -1;
        c0947g.f15635F0 = -1;
        c0947g.f15636G0 = -1;
        c0947g.f15637H0 = -1;
        c0947g.f15638I0 = -1;
        c0947g.f15639J0 = 0.5f;
        c0947g.f15640K0 = 0.5f;
        c0947g.f15641L0 = 0.5f;
        c0947g.f15642M0 = 0.5f;
        c0947g.f15643N0 = 0.5f;
        c0947g.f15644O0 = 0.5f;
        c0947g.f15645P0 = 0;
        c0947g.f15646Q0 = 0;
        c0947g.R0 = 2;
        c0947g.f15647S0 = 2;
        c0947g.f15648T0 = 0;
        c0947g.f15649U0 = -1;
        c0947g.f15650V0 = 0;
        c0947g.f15651W0 = new ArrayList();
        c0947g.f15652X0 = null;
        c0947g.f15653Y0 = null;
        c0947g.f15654Z0 = null;
        c0947g.f15656b1 = 0;
        this.f3227j = c0947g;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f16152b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                if (index == 0) {
                    this.f3227j.f15650V0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    C0947g c0947g2 = this.f3227j;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c0947g2.f15657s0 = dimensionPixelSize;
                    c0947g2.f15658t0 = dimensionPixelSize;
                    c0947g2.f15659u0 = dimensionPixelSize;
                    c0947g2.f15660v0 = dimensionPixelSize;
                } else if (index == 18) {
                    C0947g c0947g3 = this.f3227j;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c0947g3.f15659u0 = dimensionPixelSize2;
                    c0947g3.f15661w0 = dimensionPixelSize2;
                    c0947g3.f15662x0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f3227j.f15660v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f3227j.f15661w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f3227j.f15657s0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f3227j.f15662x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f3227j.f15658t0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f3227j.f15648T0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f3227j.f15633D0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f3227j.f15634E0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f3227j.f15635F0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f3227j.f15637H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f3227j.f15636G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f3227j.f15638I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f3227j.f15639J0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f3227j.f15641L0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f3227j.f15643N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f3227j.f15642M0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f3227j.f15644O0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f3227j.f15640K0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f3227j.R0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f3227j.f15647S0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f3227j.f15645P0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f3227j.f15646Q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f3227j.f15649U0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f15948d = this.f3227j;
        i();
    }

    @Override // y.AbstractC0984c
    public final void h(C0944d c0944d, boolean z4) {
        C0947g c0947g = this.f3227j;
        int i4 = c0947g.f15659u0;
        if (i4 > 0 || c0947g.f15660v0 > 0) {
            if (z4) {
                c0947g.f15661w0 = c0947g.f15660v0;
                c0947g.f15662x0 = i4;
            } else {
                c0947g.f15661w0 = i4;
                c0947g.f15662x0 = c0947g.f15660v0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x07f4  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0813  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x00d8 A[EDGE_INSN: B:430:0x00d8->B:59:0x00d8 BREAK  A[LOOP:1: B:53:0x00c4->B:58:0x00d4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012e  */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // y.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(v.C0947g r42, int r43, int r44) {
        /*
            Method dump skipped, instructions count: 2088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.j(v.g, int, int):void");
    }

    @Override // y.AbstractC0984c, android.view.View
    public final void onMeasure(int i4, int i5) {
        j(this.f3227j, i4, i5);
    }

    public void setFirstHorizontalBias(float f4) {
        this.f3227j.f15641L0 = f4;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i4) {
        this.f3227j.f15635F0 = i4;
        requestLayout();
    }

    public void setFirstVerticalBias(float f4) {
        this.f3227j.f15642M0 = f4;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i4) {
        this.f3227j.f15636G0 = i4;
        requestLayout();
    }

    public void setHorizontalAlign(int i4) {
        this.f3227j.R0 = i4;
        requestLayout();
    }

    public void setHorizontalBias(float f4) {
        this.f3227j.f15639J0 = f4;
        requestLayout();
    }

    public void setHorizontalGap(int i4) {
        this.f3227j.f15645P0 = i4;
        requestLayout();
    }

    public void setHorizontalStyle(int i4) {
        this.f3227j.f15633D0 = i4;
        requestLayout();
    }

    public void setLastHorizontalBias(float f4) {
        this.f3227j.f15643N0 = f4;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i4) {
        this.f3227j.f15637H0 = i4;
        requestLayout();
    }

    public void setLastVerticalBias(float f4) {
        this.f3227j.f15644O0 = f4;
        requestLayout();
    }

    public void setLastVerticalStyle(int i4) {
        this.f3227j.f15638I0 = i4;
        requestLayout();
    }

    public void setMaxElementsWrap(int i4) {
        this.f3227j.f15649U0 = i4;
        requestLayout();
    }

    public void setOrientation(int i4) {
        this.f3227j.f15650V0 = i4;
        requestLayout();
    }

    public void setPadding(int i4) {
        C0947g c0947g = this.f3227j;
        c0947g.f15657s0 = i4;
        c0947g.f15658t0 = i4;
        c0947g.f15659u0 = i4;
        c0947g.f15660v0 = i4;
        requestLayout();
    }

    public void setPaddingBottom(int i4) {
        this.f3227j.f15658t0 = i4;
        requestLayout();
    }

    public void setPaddingLeft(int i4) {
        this.f3227j.f15661w0 = i4;
        requestLayout();
    }

    public void setPaddingRight(int i4) {
        this.f3227j.f15662x0 = i4;
        requestLayout();
    }

    public void setPaddingTop(int i4) {
        this.f3227j.f15657s0 = i4;
        requestLayout();
    }

    public void setVerticalAlign(int i4) {
        this.f3227j.f15647S0 = i4;
        requestLayout();
    }

    public void setVerticalBias(float f4) {
        this.f3227j.f15640K0 = f4;
        requestLayout();
    }

    public void setVerticalGap(int i4) {
        this.f3227j.f15646Q0 = i4;
        requestLayout();
    }

    public void setVerticalStyle(int i4) {
        this.f3227j.f15634E0 = i4;
        requestLayout();
    }

    public void setWrapMode(int i4) {
        this.f3227j.f15648T0 = i4;
        requestLayout();
    }
}
