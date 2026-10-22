package e3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import g1.AbstractC1451a;

/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public com.stepos.statsrpk.d f4369a = new n();
    public com.stepos.statsrpk.d b = new n();
    public com.stepos.statsrpk.d c = new n();
    public com.stepos.statsrpk.d d = new n();
    public InterfaceC1415d e = new C1412a(0.0f);
    public InterfaceC1415d f = new C1412a(0.0f);
    public InterfaceC1415d g = new C1412a(0.0f);
    public InterfaceC1415d h = new C1412a(0.0f);
    public C1417f i;

    /* renamed from: j, reason: collision with root package name */
    public C1417f f4370j;
    public C1417f k;
    public C1417f l;

    public p() {
        int i = 0;
        this.i = new C1417f(i);
        this.f4370j = new C1417f(i);
        this.k = new C1417f(i);
        this.l = new C1417f(i);
    }

    public static o a(Context context, int i, int i6, C1412a c1412a) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i6 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i6, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(P2.a.f1065D);
        try {
            int i10 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i11 = typedArrayObtainStyledAttributes.getInt(3, i10);
            int i12 = typedArrayObtainStyledAttributes.getInt(4, i10);
            int i13 = typedArrayObtainStyledAttributes.getInt(2, i10);
            int i14 = typedArrayObtainStyledAttributes.getInt(1, i10);
            InterfaceC1415d interfaceC1415dC = c(typedArrayObtainStyledAttributes, 5, c1412a);
            InterfaceC1415d interfaceC1415dC2 = c(typedArrayObtainStyledAttributes, 8, interfaceC1415dC);
            InterfaceC1415d interfaceC1415dC3 = c(typedArrayObtainStyledAttributes, 9, interfaceC1415dC);
            InterfaceC1415d interfaceC1415dC4 = c(typedArrayObtainStyledAttributes, 7, interfaceC1415dC);
            InterfaceC1415d interfaceC1415dC5 = c(typedArrayObtainStyledAttributes, 6, interfaceC1415dC);
            o oVar = new o();
            com.stepos.statsrpk.d dVarX = AbstractC1451a.x(i11);
            oVar.f4367a = dVarX;
            o.b(dVarX);
            oVar.e = interfaceC1415dC2;
            com.stepos.statsrpk.d dVarX2 = AbstractC1451a.x(i12);
            oVar.b = dVarX2;
            o.b(dVarX2);
            oVar.f = interfaceC1415dC3;
            com.stepos.statsrpk.d dVarX3 = AbstractC1451a.x(i13);
            oVar.c = dVarX3;
            o.b(dVarX3);
            oVar.g = interfaceC1415dC4;
            com.stepos.statsrpk.d dVarX4 = AbstractC1451a.x(i14);
            oVar.d = dVarX4;
            o.b(dVarX4);
            oVar.h = interfaceC1415dC5;
            return oVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static o b(Context context, AttributeSet attributeSet, int i, int i6) {
        C1412a c1412a = new C1412a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.f1081w, i, i6);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, c1412a);
    }

    public static InterfaceC1415d c(TypedArray typedArray, int i, InterfaceC1415d interfaceC1415d) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i6 = typedValuePeekValue.type;
            if (i6 == 5) {
                return new C1412a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i6 == 6) {
                return new m(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return interfaceC1415d;
    }

    public final boolean d() {
        return (this.b instanceof n) && (this.f4369a instanceof n) && (this.c instanceof n) && (this.d instanceof n);
    }

    public final boolean e(RectF rectF) {
        boolean z10 = this.l.getClass().equals(C1417f.class) && this.f4370j.getClass().equals(C1417f.class) && this.i.getClass().equals(C1417f.class) && this.k.getClass().equals(C1417f.class);
        float fA = this.e.a(rectF);
        return z10 && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && d();
    }

    public final o f() {
        o oVar = new o();
        oVar.f4367a = this.f4369a;
        oVar.b = this.b;
        oVar.c = this.c;
        oVar.d = this.d;
        oVar.e = this.e;
        oVar.f = this.f;
        oVar.g = this.g;
        oVar.h = this.h;
        oVar.i = this.i;
        oVar.f4368j = this.f4370j;
        oVar.k = this.k;
        oVar.l = this.l;
        return oVar;
    }

    public final String toString() {
        return "[" + this.e + ", " + this.f + ", " + this.g + ", " + this.h + "]";
    }
}
