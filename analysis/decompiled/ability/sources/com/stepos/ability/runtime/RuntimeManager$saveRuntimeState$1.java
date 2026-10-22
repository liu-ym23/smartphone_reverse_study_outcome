package com.stepos.ability.runtime;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.runtime.RuntimeManager$saveRuntimeState$1", f = "RuntimeManager.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class RuntimeManager$saveRuntimeState$1 extends SuspendLambda implements n {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new RuntimeManager$saveRuntimeState$1(2, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        RuntimeManager$saveRuntimeState$1 runtimeManager$saveRuntimeState$1 = (RuntimeManager$saveRuntimeState$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        runtimeManager$saveRuntimeState$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        return r.f317a;
    }
}
