package com.stepos.ability.manager;

import C7.r;
import J7.c;
import S7.n;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.manager.AbilityManager$setup$1$1", f = "AbilityManager.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AbilityManager$setup$1$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbilityManager f3111a;
    public final /* synthetic */ Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityManager$setup$1$1(AbilityManager abilityManager, Context context, H7.c cVar) {
        super(2, cVar);
        this.f3111a = abilityManager;
        this.b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AbilityManager$setup$1$1(this.f3111a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        AbilityManager$setup$1$1 abilityManager$setup$1$1 = (AbilityManager$setup$1$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        abilityManager$setup$1$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        AbilityManager abilityManager = this.f3111a;
        com.stepos.ability.manager.sync.a aVar = abilityManager.syncCoordinator;
        if (aVar == null) {
            k.n("syncCoordinator");
            throw null;
        }
        String str = abilityManager.deviceId;
        if (str == null) {
            k.n("deviceId");
            throw null;
        }
        Context context = this.b;
        k.f(context, "context");
        Log.i("AbilitySyncCoordinator", "onUserLoggedIn: trigger full rescan");
        AtomicReference atomicReference = aVar.f;
        Boolean bool = Boolean.FALSE;
        atomicReference.set(bool);
        aVar.e.set(bool);
        aVar.n = str;
        com.stepos.ability.manager.cache.a.e.x(context).b(new d4.a(aVar, context, 1));
        aVar.l(context, "userLoggedIn");
        return r.f317a;
    }
}
