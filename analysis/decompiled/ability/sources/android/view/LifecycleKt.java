package android.view;

import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.b;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import p9.c;
import u9.d;
import z2.l;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "coroutineScope", "Lp9/c;", "Landroidx/lifecycle/Lifecycle$Event;", "getEventFlow", "(Landroidx/lifecycle/Lifecycle;)Lp9/c;", "eventFlow", "lifecycle-common"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        k.f(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            r0 r0VarC = AbstractC1683A.c();
            d dVar = AbstractC1691I.f5315a;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, l.H(r0VarC, s9.k.f6003a.d));
        } while (!lifecycle.getInternalScopeRef().compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }

    public static final c getEventFlow(Lifecycle lifecycle) {
        k.f(lifecycle, "<this>");
        b bVarC = kotlinx.coroutines.flow.d.c(new LifecycleKt$eventFlow$1(lifecycle, null));
        d dVar = AbstractC1691I.f5315a;
        return kotlinx.coroutines.flow.d.j(bVarC, s9.k.f6003a.d);
    }
}
