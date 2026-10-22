package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import o.d;
import o.g;
import p.b;
import r.r;
import r.t;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class Flow extends t {

    /* renamed from: k, reason: collision with root package name */
    public final g f358k;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4912a = new int[32];
        this.f4917g = new HashMap();
        this.f4914c = context;
        super.g(attributeSet);
        g gVar = new g();
        gVar.f4278r0 = 0;
        gVar.f4279s0 = 0;
        gVar.f4280t0 = 0;
        gVar.f4281u0 = 0;
        gVar.f4282v0 = 0;
        gVar.f4283w0 = 0;
        gVar.f4284x0 = false;
        gVar.f4285y0 = 0;
        gVar.f4286z0 = 0;
        gVar.A0 = new b();
        gVar.B0 = null;
        gVar.C0 = -1;
        gVar.D0 = -1;
        gVar.E0 = -1;
        gVar.F0 = -1;
        gVar.G0 = -1;
        gVar.H0 = -1;
        gVar.I0 = 0.5f;
        gVar.J0 = 0.5f;
        gVar.K0 = 0.5f;
        gVar.L0 = 0.5f;
        gVar.M0 = 0.5f;
        gVar.N0 = 0.5f;
        gVar.O0 = 0;
        gVar.P0 = 0;
        gVar.Q0 = 2;
        gVar.R0 = 2;
        gVar.S0 = 0;
        gVar.T0 = -1;
        gVar.U0 = 0;
        gVar.V0 = new ArrayList();
        gVar.W0 = null;
        gVar.X0 = null;
        gVar.Y0 = null;
        gVar.f4277a1 = 0;
        this.f358k = gVar;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f5051b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == 0) {
                    this.f358k.U0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    g gVar2 = this.f358k;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar2.f4278r0 = dimensionPixelSize;
                    gVar2.f4279s0 = dimensionPixelSize;
                    gVar2.f4280t0 = dimensionPixelSize;
                    gVar2.f4281u0 = dimensionPixelSize;
                } else if (index == 18) {
                    g gVar3 = this.f358k;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar3.f4280t0 = dimensionPixelSize2;
                    gVar3.f4282v0 = dimensionPixelSize2;
                    gVar3.f4283w0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f358k.f4281u0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f358k.f4282v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f358k.f4278r0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f358k.f4283w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f358k.f4279s0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f358k.S0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f358k.C0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f358k.D0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f358k.E0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f358k.G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f358k.F0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f358k.H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f358k.I0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f358k.K0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f358k.M0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f358k.L0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f358k.N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f358k.J0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f358k.Q0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f358k.R0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f358k.O0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f358k.P0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f358k.T0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.d = this.f358k;
        i();
    }

    @Override // r.c
    public final void h(d dVar, boolean z) {
        g gVar = this.f358k;
        int i8 = gVar.f4280t0;
        if (i8 > 0 || gVar.f4281u0 > 0) {
            if (z) {
                gVar.f4282v0 = gVar.f4281u0;
                gVar.f4283w0 = i8;
            } else {
                gVar.f4282v0 = i8;
                gVar.f4283w0 = gVar.f4281u0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x00d7 A[EDGE_INSN: B:334:0x00d7->B:60:0x00d7 BREAK  A[LOOP:1: B:54:0x00c0->B:59:0x00d2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0100  */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6 */
    /* JADX WARN: Type inference failed for: r28v7 */
    @Override // r.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(o.g r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 1404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.j(o.g, int, int):void");
    }

    @Override // r.c, android.view.View
    public final void onMeasure(int i8, int i9) {
        j(this.f358k, i8, i9);
    }

    public void setFirstHorizontalBias(float f3) {
        this.f358k.K0 = f3;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i8) {
        this.f358k.E0 = i8;
        requestLayout();
    }

    public void setFirstVerticalBias(float f3) {
        this.f358k.L0 = f3;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i8) {
        this.f358k.F0 = i8;
        requestLayout();
    }

    public void setHorizontalAlign(int i8) {
        this.f358k.Q0 = i8;
        requestLayout();
    }

    public void setHorizontalBias(float f3) {
        this.f358k.I0 = f3;
        requestLayout();
    }

    public void setHorizontalGap(int i8) {
        this.f358k.O0 = i8;
        requestLayout();
    }

    public void setHorizontalStyle(int i8) {
        this.f358k.C0 = i8;
        requestLayout();
    }

    public void setMaxElementsWrap(int i8) {
        this.f358k.T0 = i8;
        requestLayout();
    }

    public void setOrientation(int i8) {
        this.f358k.U0 = i8;
        requestLayout();
    }

    public void setPadding(int i8) {
        g gVar = this.f358k;
        gVar.f4278r0 = i8;
        gVar.f4279s0 = i8;
        gVar.f4280t0 = i8;
        gVar.f4281u0 = i8;
        requestLayout();
    }

    public void setPaddingBottom(int i8) {
        this.f358k.f4279s0 = i8;
        requestLayout();
    }

    public void setPaddingLeft(int i8) {
        this.f358k.f4282v0 = i8;
        requestLayout();
    }

    public void setPaddingRight(int i8) {
        this.f358k.f4283w0 = i8;
        requestLayout();
    }

    public void setPaddingTop(int i8) {
        this.f358k.f4278r0 = i8;
        requestLayout();
    }

    public void setVerticalAlign(int i8) {
        this.f358k.R0 = i8;
        requestLayout();
    }

    public void setVerticalBias(float f3) {
        this.f358k.J0 = f3;
        requestLayout();
    }

    public void setVerticalGap(int i8) {
        this.f358k.P0 = i8;
        requestLayout();
    }

    public void setVerticalStyle(int i8) {
        this.f358k.D0 = i8;
        requestLayout();
    }

    public void setWrapMode(int i8) {
        this.f358k.S0 = i8;
        requestLayout();
    }
}
