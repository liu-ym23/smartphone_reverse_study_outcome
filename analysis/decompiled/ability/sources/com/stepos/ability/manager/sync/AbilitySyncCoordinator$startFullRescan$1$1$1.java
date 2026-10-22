package com.stepos.ability.manager.sync;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1724q;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.sync.AbilitySyncCoordinator$startFullRescan$1$1$1", f = "AbilitySyncCoordinator.kt", l = {280}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilitySyncCoordinator$startFullRescan$1$1$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3160a;
    public final /* synthetic */ a b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ C1724q d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilitySyncCoordinator$startFullRescan$1$1$1(a aVar, Context context, C1724q c1724q, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
        this.c = context;
        this.d = c1724q;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilitySyncCoordinator$startFullRescan$1$1$1(this.b, this.c, this.d, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilitySyncCoordinator$startFullRescan$1$1$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3160a;
        if (i == 0) {
            b.b(obj);
            this.f3160a = 1;
            if (a.b(this.b, this.c, this.d, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return r.f317a;
    }
}
