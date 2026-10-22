package com.stepos.ability.service;

import C7.r;
import J7.c;
import S7.n;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.ability.IAbilityQueryCallback;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import com.stepos.ability.bean.AbilityQueryParamsParcelable;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.service.AgentService$binder$1$queryAbilities$1", f = "AgentService.kt", l = {219}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AgentService$binder$1$queryAbilities$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3259a;
    public final /* synthetic */ AgentService b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;
    public final /* synthetic */ IAbilityQueryCallback e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentService$binder$1$queryAbilities$1(AgentService agentService, String str, List list, IAbilityQueryCallback iAbilityQueryCallback, H7.c cVar) {
        super(2, cVar);
        this.b = agentService;
        this.c = str;
        this.d = list;
        this.e = iAbilityQueryCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new AgentService$binder$1$queryAbilities$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((AgentService$binder$1$queryAbilities$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws RemoteException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3259a;
        IAbilityQueryCallback iAbilityQueryCallback = this.e;
        try {
            if (i == 0) {
                kotlin.b.b(obj);
                IAbilityManager abilityMng = this.b.getAbilityMng();
                String str = this.c;
                List<AbilityQueryParamsParcelable> list = this.d;
                this.f3259a = 1;
                obj = abilityMng.queryAbilities(str, list, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            List<AbilityMetadataParcelable> list2 = (List) obj;
            Log.d("AgentService", "queryAbilities result: " + list2);
            if (iAbilityQueryCallback != null) {
                iAbilityQueryCallback.onComplete(true, "", list2);
            }
        } catch (Exception e) {
            Log.e("AgentService", "queryAbilities error: ", e);
            if (iAbilityQueryCallback != null) {
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                iAbilityQueryCallback.onComplete(false, message, null);
            }
        }
        return r.f317a;
    }
}
