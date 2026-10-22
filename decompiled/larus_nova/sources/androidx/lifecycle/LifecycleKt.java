package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/lifecycle/Lifecycle$Event;", "getEventFlow", "(Landroidx/lifecycle/Lifecycle;)Lkotlinx/coroutines/flow/Flow;", "lifecycle-common"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    L3:
        LifecycleCoroutineScopeImpl r101 = (LifecycleCoroutineScopeImpl) r100.getInternalScopeRef().get();
        if (r101 != null) goto L5;
        LifecycleCoroutineScopeImpl r102 = new LifecycleCoroutineScopeImpl(r100, SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        if (r100.getInternalScopeRef().compareAndSet(null, r102) == false) goto L3;
        r102.register();
        return r102;
    L5:
        return r101;
    }

    public static final Flow<Lifecycle.Event> getEventFlow(Lifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return kotlinx.coroutines.flow.e.w(kotlinx.coroutines.flow.e.e(new LifecycleKt$eventFlow$1(r100, null)), Dispatchers.getMain().getImmediate());
    }
}
