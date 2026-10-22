package com.stepos.core.ability.text;

import com.stepos.core.ability.text.RiskClassifyAbility;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import v6.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.text.RiskClassifyAbility$moderate$decision$1", f = "RiskClassifyAbility.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RiskClassifyAbility$moderate$decision$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {
    final /* synthetic */ kotlin.coroutines.d $innerContext;
    final /* synthetic */ c.g $input;
    final /* synthetic */ Object $record;
    int label;
    final /* synthetic */ RiskClassifyAbility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskClassifyAbility$moderate$decision$1(c.g gVar, kotlin.coroutines.d dVar, RiskClassifyAbility riskClassifyAbility, Object obj, qb.b<? super RiskClassifyAbility$moderate$decision$1> bVar) {
        super(2, bVar);
        this.$input = gVar;
        this.$innerContext = dVar;
        this.this$0 = riskClassifyAbility;
        this.$record = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$0(kotlin.coroutines.d dVar, RiskClassifyAbility riskClassifyAbility, Object obj, String str) {
        return (String) BuildersKt.runBlocking(dVar, new RiskClassifyAbility$moderate$decision$1$1$1(riskClassifyAbility, str, obj, null));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new RiskClassifyAbility$moderate$decision$1(this.$input, this.$innerContext, this.this$0, this.$record, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        RiskClassifyAbility.ScpAuditRuntime scpAuditRuntime = RiskClassifyAbility.ScpAuditRuntime.INSTANCE;
        String str = this.$input.f13416b;
        final kotlin.coroutines.d dVar = this.$innerContext;
        final RiskClassifyAbility riskClassifyAbility = this.this$0;
        final Object obj2 = this.$record;
        return scpAuditRuntime.checkText(str, new l() { // from class: com.stepos.core.ability.text.d
            @Override // zb.l
            public final Object invoke(Object obj3) {
                return RiskClassifyAbility$moderate$decision$1.invokeSuspend$lambda$0(dVar, riskClassifyAbility, obj2, (String) obj3);
            }
        });
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
        return ((RiskClassifyAbility$moderate$decision$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
