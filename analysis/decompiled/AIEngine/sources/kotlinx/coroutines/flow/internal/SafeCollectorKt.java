package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import qb.b;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SafeCollectorKt {
    private static final q<FlowCollector<Object>, Object, b<? super n>, Object> emitFun;

    static {
        SafeCollectorKt$emitFun$1 safeCollectorKt$emitFun$1 = SafeCollectorKt$emitFun$1.INSTANCE;
        g.d(safeCollectorKt$emitFun$1, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        k.c(3, safeCollectorKt$emitFun$1);
        emitFun = safeCollectorKt$emitFun$1;
    }
}
