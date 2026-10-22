package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d0 {
    public static final Object a(q qVar, zb.p pVar, qb.b bVar) {
        Object objCoroutineScope;
        Lifecycle.State state = Lifecycle.State.f2214a;
        Lifecycle lifecycle = qVar.getLifecycle();
        Lifecycle.State state2 = Lifecycle.State.f2214a;
        if (lifecycle.b() == Lifecycle.State.f2214a || (objCoroutineScope = CoroutineScopeKt.coroutineScope(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, pVar, null), bVar)) != CoroutineSingletons.f10059a) {
            objCoroutineScope = lb.n.f10413a;
        }
        return objCoroutineScope == CoroutineSingletons.f10059a ? objCoroutineScope : lb.n.f10413a;
    }
}
