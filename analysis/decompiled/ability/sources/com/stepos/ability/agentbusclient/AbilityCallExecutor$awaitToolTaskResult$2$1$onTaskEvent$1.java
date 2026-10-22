package com.stepos.ability.agentbusclient;

import C7.r;
import J7.c;
import S7.n;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.agentbusclient.AbilityCallExecutor$awaitToolTaskResult$2$1$onTaskEvent$1", f = "AbilityCallExecutor.kt", l = {137}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AbilityCallExecutor$awaitToolTaskResult$2$1$onTaskEvent$1 extends SuspendLambda implements n {
    final /* synthetic */ PendingAuth $pending;
    final /* synthetic */ String $responseJson;
    final /* synthetic */ Bundle $taskBundle;
    int label;
    final /* synthetic */ AbilityCallExecutor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityCallExecutor$awaitToolTaskResult$2$1$onTaskEvent$1(AbilityCallExecutor abilityCallExecutor, PendingAuth pendingAuth, String str, Bundle bundle, H7.c<? super AbilityCallExecutor$awaitToolTaskResult$2$1$onTaskEvent$1> cVar) {
        super(2, cVar);
        this.this$0 = abilityCallExecutor;
        this.$pending = pendingAuth;
        this.$responseJson = str;
        this.$taskBundle = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AbilityCallExecutor$awaitToolTaskResult$2$1$onTaskEvent$1(this.this$0, this.$pending, this.$responseJson, this.$taskBundle, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            AbilityCallExecutor abilityCallExecutor = this.this$0;
            PendingAuth pendingAuth = this.$pending;
            String str = this.$responseJson;
            Bundle bundle = this.$taskBundle;
            this.label = 1;
            if (abilityCallExecutor.publishResume(pendingAuth, str, bundle, this) == coroutineSingletons) {
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

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AbilityCallExecutor$awaitToolTaskResult$2$1$onTaskEvent$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
