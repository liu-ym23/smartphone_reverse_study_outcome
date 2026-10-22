package androidx.compose.foundation.layout;

import n0.m;
import r.c0;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final FillElement f744a = new FillElement(2);

    /* renamed from: b, reason: collision with root package name */
    public static final FillElement f745b = new FillElement(3);

    public static final m a(float f10, float f11) {
        return new UnspecifiedConstraintsElement(f10, f11);
    }

    public static final m b(m mVar, float f10) {
        return mVar.c(new SizeElement(0.0f, f10, 0.0f, f10, 5));
    }

    public static final m c(m mVar, c0 c0Var) {
        return mVar.c(new PaddingValuesElement(c0Var));
    }

    public static final m d(m mVar, float f10) {
        return mVar.c(new PaddingElement(f10, f10, f10, f10));
    }

    public static final m e(m mVar, float f10, float f11) {
        return mVar.c(new PaddingElement(f10, f11, f10, f11));
    }

    public static m f(m mVar, float f10, float f11, float f12, float f13, int i2) {
        if ((i2 & 1) != 0) {
            f10 = 0;
        }
        if ((i2 & 2) != 0) {
            f11 = 0;
        }
        if ((i2 & 4) != 0) {
            f12 = 0;
        }
        if ((i2 & 8) != 0) {
            f13 = 0;
        }
        return mVar.c(new PaddingElement(f10, f11, f12, f13));
    }

    public static final m g(m mVar, float f10) {
        return mVar.c(new SizeElement(f10, f10, f10, f10));
    }

    public static final m h(float f10) {
        return new SizeElement(f10, 0.0f, f10, 0.0f, 10);
    }
}
