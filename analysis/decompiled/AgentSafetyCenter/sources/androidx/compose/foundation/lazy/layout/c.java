package androidx.compose.foundation.lazy.layout;

import java.lang.invoke.VarHandle;
import pc.i;
import u.f0;
import w0.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {
    public static final m a(m mVar, i iVar, x.c cVar, f0 f0Var, boolean z10) {
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = new LazyLayoutSemanticsModifier();
        lazyLayoutSemanticsModifier.f910c = iVar;
        lazyLayoutSemanticsModifier.f911f = cVar;
        lazyLayoutSemanticsModifier.f912g = f0Var;
        lazyLayoutSemanticsModifier.f913h = z10;
        VarHandle.storeStoreFence();
        return mVar.d(lazyLayoutSemanticsModifier);
    }
}
