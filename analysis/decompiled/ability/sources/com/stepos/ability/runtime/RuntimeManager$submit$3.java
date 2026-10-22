package com.stepos.ability.runtime;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.beaninternal.ability.AbilityTask;
import com.stepos.ability.database.dao.AbilityTaskDao;
import com.stepos.ability.database.entity.AbilityTaskEntity;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.runtime.RuntimeManager$submit$3", f = "RuntimeManager.kt", l = {179}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class RuntimeManager$submit$3 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3226a;
    public final /* synthetic */ b b;
    public final /* synthetic */ AbilityTask c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RuntimeManager$submit$3(b bVar, AbilityTask abilityTask, H7.c cVar) {
        super(2, cVar);
        this.b = bVar;
        this.c = abilityTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new RuntimeManager$submit$3(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((RuntimeManager$submit$3) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3226a;
        if (i == 0) {
            kotlin.b.b(obj);
            AbilityTaskDao abilityTaskDao = this.b.f3228a;
            if (abilityTaskDao == null) {
                k.n("taskDao");
                throw null;
            }
            AbilityTask abilityTask = this.c;
            AbilityTaskEntity abilityTaskEntity = new AbilityTaskEntity(0L, abilityTask.getTaskCode(), abilityTask.getAbilityId(), abilityTask.getPkgName(), abilityTask.getMethod(), abilityTask.getParams(), abilityTask.getExtra(), "pending", 0, abilityTask.getPriority(), System.currentTimeMillis(), abilityTask.isCloudAbility(), abilityTask.getTraceId(), abilityTask.getToolCallId(), abilityTask.getTimeout());
            this.f3226a = 1;
            if (abilityTaskDao.insert(abilityTaskEntity, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }
}
