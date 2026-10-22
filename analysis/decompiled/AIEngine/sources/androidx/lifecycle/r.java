package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r {
    public static final m a(q qVar) {
        kotlin.jvm.internal.g.f(qVar, "<this>");
        Lifecycle lifecycle = qVar.getLifecycle();
        kotlin.jvm.internal.g.f(lifecycle, "<this>");
        b bVar = lifecycle.f2212a;
        while (true) {
            m mVar = (m) ((AtomicReference) bVar.h).get();
            if (mVar != null) {
                return mVar;
            }
            m mVar2 = new m(lifecycle, SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
            AtomicReference atomicReference = (AtomicReference) bVar.h;
            while (!atomicReference.compareAndSet(null, mVar2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            BuildersKt__Builders_commonKt.launch$default(mVar2, Dispatchers.getMain().getImmediate(), null, new LifecycleCoroutineScopeImpl$register$1(mVar2, null), 2, null);
            return mVar2;
        }
    }
}
