package com.stepos.ability.manager.sync;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import android.util.Log;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.C1724q;
import m9.InterfaceC1733z;
import m9.q0;

@c(c = "com.stepos.ability.manager.sync.AbilitySyncCoordinator$startFullRescan$1", f = "AbilitySyncCoordinator.kt", l = {535}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class AbilitySyncCoordinator$startFullRescan$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public kotlinx.coroutines.sync.a f3159a;
    public a b;
    public String c;
    public Context d;
    public int e;
    public final /* synthetic */ a f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Context h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilitySyncCoordinator$startFullRescan$1(a aVar, String str, Context context, H7.c cVar) {
        super(2, cVar);
        this.f = aVar;
        this.g = str;
        this.h = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilitySyncCoordinator$startFullRescan$1(this.f, this.g, this.h, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AbilitySyncCoordinator$startFullRescan$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar;
        String str;
        kotlinx.coroutines.sync.a aVar2;
        Context context;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.e;
        if (i == 0) {
            b.b(obj);
            aVar = this.f;
            kotlinx.coroutines.sync.a aVar3 = aVar.g;
            this.f3159a = aVar3;
            this.b = aVar;
            str = this.g;
            this.c = str;
            Context context2 = this.h;
            this.d = context2;
            this.e = 1;
            if (aVar3.lock(null, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            aVar2 = aVar3;
            context = context2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            context = this.d;
            str = this.c;
            aVar = this.b;
            aVar2 = this.f3159a;
            b.b(obj);
        }
        try {
            q0 q0Var = aVar.i;
            if (q0Var == null || !q0Var.isActive()) {
                q0 q0Var2 = aVar.f3163j;
                if (q0Var2 != null) {
                    q0Var2.cancel(null);
                }
                aVar.k = 0;
                aVar.l = "";
                aVar.d.set(SyncPhase.f3161a);
                aVar.e.set(Boolean.FALSE);
                C1724q c1724q = new C1724q();
                aVar.h = c1724q;
                aVar.i = AbstractC1683A.n(aVar.c, null, new AbilitySyncCoordinator$startFullRescan$1$1$1(aVar, context, c1724q, null), 3);
            } else {
                Log.i("AbilitySyncCoordinator", "startFullRescan skipped, job active. reason=" + str);
            }
            aVar2.unlock(null);
            return r.f317a;
        } catch (Throwable th) {
            aVar2.unlock(null);
            throw th;
        }
    }
}
