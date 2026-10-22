package com.stepos.ailauncher.agent.ability;

import Ua.M;
import com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$scheduleRehostRetry$2", f = "RiskCardHandoffCoordinator.kt", l = {480}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class RiskCardHandoffCoordinator$scheduleRehostRetry$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ RiskCardHandoffCoordinator.a $active;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskCardHandoffCoordinator$scheduleRehostRetry$2(RiskCardHandoffCoordinator.a aVar, InterfaceC4014c<? super RiskCardHandoffCoordinator$scheduleRehostRetry$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$active = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RiskCardHandoffCoordinator$scheduleRehostRetry$2(this.$active, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RiskCardHandoffCoordinator$scheduleRehostRetry$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.C4849c.b(r4)
            goto L25
        Lf:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L17:
            kotlin.C4849c.b(r4)
            r3.label = r2
            r1 = 250(0xfa, double:1.235E-321)
            java.lang.Object r4 = Ua.U.a(r1, r3)
            if (r4 != r0) goto L25
            return r0
        L25:
            java.util.concurrent.ConcurrentHashMap r4 = com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.h()
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a r0 = r3.$active
            com.stepos.ailauncher.mcpservice.risk.p r0 = r0.getParams()
            java.lang.String r0 = r0.getRequestId()
            java.lang.Object r4 = r4.get(r0)
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a r4 = (com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.a) r4
            if (r4 != 0) goto L3e
            Y8.t r3 = Y8.t.f7040a
            return r3
        L3e:
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a r0 = r3.$active
            if (r4 == r0) goto L45
            Y8.t r3 = Y8.t.f7040a
            return r3
        L45:
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$Mode r4 = r0.getMode()
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$Mode r0 = com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.Mode.INLINE
            if (r4 != r0) goto L61
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator r4 = com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.INSTANCE
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a r0 = r3.$active
            java.lang.String r0 = r0.getSessionId()
            boolean r0 = com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.m(r4, r0)
            if (r0 == 0) goto L61
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a r3 = r3.$active
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.k(r4, r3)
            goto L67
        L61:
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a r3 = r3.$active
            r4 = 0
            r3.k(r4)
        L67:
            Y8.t r3 = Y8.t.f7040a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$scheduleRehostRetry$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
