package com.stepos.ability.agentbusclient;

import C7.r;
import H4.o;
import J7.c;
import S7.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1", f = "AbilityAgentBusNodeAgentBusBinding.kt", l = {102}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1 extends SuspendLambda implements n {
    final /* synthetic */ String $name;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AbilityAgentBusNodeAgentBusBinding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, String str, H7.c<? super AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1> cVar) {
        super(2, cVar);
        this.this$0 = abilityAgentBusNodeAgentBusBinding;
        this.$name = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1 abilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1 = new AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1(this.this$0, this.$name, cVar);
        abilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1.L$0 = obj;
        return abilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        try {
            if (i == 0) {
                b.b(obj);
                AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding = this.this$0;
                String str = this.$name;
                EmptyList emptyList = EmptyList.f4893a;
                List listM = o.M(str);
                this.L$0 = null;
                this.L$1 = null;
                this.I$0 = 0;
                this.label = 1;
                if (abilityAgentBusNodeAgentBusBinding.updateCapsInternal(emptyList, listM, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
