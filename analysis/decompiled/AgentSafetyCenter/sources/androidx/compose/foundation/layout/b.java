package androidx.compose.foundation.layout;

import java.lang.invoke.VarHandle;
import w.l0;
import w0.m;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {
    public static final l0 a(float f5, float f10, float f11, float f12) {
        return new l0(f5, f10, f11, f12);
    }

    public static l0 b(float f5) {
        return new l0(0, 0, 0, f5);
    }

    public static final m c(m mVar, l lVar) {
        OffsetPxElement offsetPxElement = new OffsetPxElement();
        offsetPxElement.f884c = lVar;
        offsetPxElement.f885f = true;
        VarHandle.storeStoreFence();
        return mVar.d(offsetPxElement);
    }

    public static final m d(m mVar, float f5, float f10) {
        OffsetElement offsetElement = new OffsetElement();
        offsetElement.f881c = f5;
        offsetElement.f882f = f10;
        offsetElement.f883g = true;
        VarHandle.storeStoreFence();
        return mVar.d(offsetElement);
    }

    public static final m e(m mVar, l0 l0Var) {
        PaddingValuesElement paddingValuesElement = new PaddingValuesElement();
        paddingValuesElement.f890c = l0Var;
        VarHandle.storeStoreFence();
        return mVar.d(paddingValuesElement);
    }

    public static final m f(m mVar, float f5) {
        return mVar.d(new PaddingElement(f5, f5, f5, f5));
    }

    public static final m g(m mVar, float f5, float f10) {
        return mVar.d(new PaddingElement(f5, f10, f5, f10));
    }

    public static m h(m mVar, float f5, float f10, int i) {
        if ((i & 1) != 0) {
            f5 = 0;
        }
        if ((i & 2) != 0) {
            f10 = 0;
        }
        return g(mVar, f5, f10);
    }

    public static final m i(m mVar, float f5, float f10, float f11, float f12) {
        return mVar.d(new PaddingElement(f5, f10, f11, f12));
    }

    public static m j(m mVar, float f5, float f10, float f11, float f12, int i) {
        if ((i & 1) != 0) {
            f5 = 0;
        }
        if ((i & 2) != 0) {
            f10 = 0;
        }
        if ((i & 4) != 0) {
            f11 = 0;
        }
        if ((i & 8) != 0) {
            f12 = 0;
        }
        return i(mVar, f5, f10, f11, f12);
    }
}
