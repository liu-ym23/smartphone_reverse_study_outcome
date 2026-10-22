package androidx.compose.ui.graphics;

import androidx.recyclerview.widget.RecyclerView;
import d1.f0;
import d1.j0;
import d1.m0;
import d1.v;
import java.lang.invoke.VarHandle;
import w0.m;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static final m a(m mVar, l lVar) {
        BlockGraphicsLayerElement blockGraphicsLayerElement = new BlockGraphicsLayerElement();
        blockGraphicsLayerElement.f954c = lVar;
        VarHandle.storeStoreFence();
        return mVar.d(blockGraphicsLayerElement);
    }

    public static m b(m mVar, float f5, j0 j0Var, int i) {
        if ((i & 32) != 0) {
            f5 = 0.0f;
        }
        float f10 = f5;
        long j10 = m0.f3015b;
        if ((i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
            j0Var = f0.f2972a;
        }
        long j11 = v.f3030a;
        return c(mVar, 1.0f, f10, j10, j0Var, false, j11, j11);
    }

    public static final m c(m mVar, float f5, float f10, long j10, j0 j0Var, boolean z10, long j11, long j12) {
        GraphicsLayerElement graphicsLayerElement = new GraphicsLayerElement();
        graphicsLayerElement.f955c = 1.0f;
        graphicsLayerElement.f956f = 1.0f;
        graphicsLayerElement.f957g = f5;
        graphicsLayerElement.f958h = f10;
        graphicsLayerElement.i = 8.0f;
        graphicsLayerElement.f959j = j10;
        graphicsLayerElement.f960k = j0Var;
        graphicsLayerElement.f961l = z10;
        graphicsLayerElement.f962m = j11;
        graphicsLayerElement.f963n = j12;
        graphicsLayerElement.f964o = 3;
        VarHandle.storeStoreFence();
        return mVar.d(graphicsLayerElement);
    }

    public static m d(m mVar, float f5, j0 j0Var, int i) {
        if ((i & 4) != 0) {
            f5 = 1.0f;
        }
        float f10 = f5;
        long j10 = m0.f3015b;
        if ((i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
            j0Var = f0.f2972a;
        }
        long j11 = v.f3030a;
        return c(mVar, f10, 0.0f, j10, j0Var, true, j11, j11);
    }
}
