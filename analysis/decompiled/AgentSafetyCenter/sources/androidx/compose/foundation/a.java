package androidx.compose.foundation;

import a2.g;
import d1.f0;
import d1.j0;
import d1.y;
import java.lang.invoke.VarHandle;
import t.n0;
import t.p;
import t.t0;
import v.k;
import w0.h;
import w0.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static m a(m mVar, y yVar) {
        return mVar.d(new BackgroundElement(0L, yVar, f0.f2972a, 1));
    }

    public static final m b(m mVar, long j10, j0 j0Var) {
        return mVar.d(new BackgroundElement(j10, null, j0Var, 2));
    }

    public static final m c(m mVar, k kVar, n0 n0Var, boolean z10, String str, g gVar, xb.a aVar) {
        m clickableElement;
        if (n0Var instanceof t0) {
            clickableElement = new ClickableElement(kVar, (t0) n0Var, z10, str, gVar, aVar);
        } else if (n0Var == null) {
            clickableElement = new ClickableElement(kVar, null, z10, str, gVar, aVar);
        } else if (kVar != null) {
            clickableElement = c.a(n0Var, kVar).d(new ClickableElement(kVar, null, z10, str, gVar, aVar));
        } else {
            b bVar = new b(n0Var, z10, str, gVar, aVar);
            h hVar = new h();
            hVar.f15111f = bVar;
            VarHandle.storeStoreFence();
            clickableElement = hVar;
        }
        return mVar.d(clickableElement);
    }

    public static /* synthetic */ m d(m mVar, k kVar, n0 n0Var, boolean z10, g gVar, xb.a aVar, int i) {
        if ((i & 4) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i & 16) != 0) {
            gVar = null;
        }
        return c(mVar, kVar, n0Var, z11, null, gVar, aVar);
    }

    public static m e(m mVar, boolean z10, String str, xb.a aVar, int i) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        p pVar = new p(z10, str, aVar);
        h hVar = new h();
        hVar.f15111f = pVar;
        VarHandle.storeStoreFence();
        return mVar.d(hVar);
    }

    public static m f(m mVar, k kVar, xb.a aVar) {
        return mVar.d(new CombinedClickableElement(kVar, aVar));
    }

    public static m g(m mVar, k kVar) {
        HoverableElement hoverableElement = new HoverableElement();
        hoverableElement.f850c = kVar;
        VarHandle.storeStoreFence();
        return mVar.d(hoverableElement);
    }
}
