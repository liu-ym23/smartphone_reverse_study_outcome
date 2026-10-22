package kotlinx.coroutines.flow.internal;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.y;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SafeCollectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3 f21537a = null;

    static {
        SafeCollectorKt$emitFun$1 r10 = SafeCollectorKt$emitFun$1.INSTANCE;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f21537a = (Function3) y.e(r10, 3);
    }

    public static final /* synthetic */ Function3 a() {
        return f21537a;
    }
}
