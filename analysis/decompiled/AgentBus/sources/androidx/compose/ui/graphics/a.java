package androidx.compose.ui.graphics;

import n0.m;
import p7.k;
import u0.c0;
import u0.f0;
import u0.q;
import u0.z;

/* loaded from: classes.dex */
public abstract class a {
    public static final m a(k kVar) {
        return new BlockGraphicsLayerElement(kVar);
    }

    public static m b(m mVar, float f10, c0 c0Var, int i2) {
        if ((i2 & 32) != 0) {
            f10 = 0.0f;
        }
        float f11 = f10;
        long j2 = f0.f9906a;
        if ((i2 & 2048) != 0) {
            c0Var = z.f9929a;
        }
        long j4 = q.f9922a;
        return c(mVar, f11, j2, c0Var, false, j4, j4);
    }

    public static final m c(m mVar, float f10, long j2, c0 c0Var, boolean z4, long j4, long j10) {
        return mVar.c(new GraphicsLayerElement(f10, j2, c0Var, z4, j4, j10));
    }
}
