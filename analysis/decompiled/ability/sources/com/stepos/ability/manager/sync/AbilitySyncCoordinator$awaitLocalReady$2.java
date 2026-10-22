package com.stepos.ability.manager.sync;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1724q;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.sync.AbilitySyncCoordinator$awaitLocalReady$2", f = "AbilitySyncCoordinator.kt", l = {256}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilitySyncCoordinator$awaitLocalReady$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3151a;
    public final /* synthetic */ a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilitySyncCoordinator$awaitLocalReady$2(a aVar, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilitySyncCoordinator$awaitLocalReady$2(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilitySyncCoordinator$awaitLocalReady$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3151a;
        if (i == 0) {
            b.b(obj);
            C1724q c1724q = this.b.h;
            if (c1724q == null) {
                return null;
            }
            this.f3151a = 1;
            obj = c1724q.z(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return (Boolean) obj;
    }
}
