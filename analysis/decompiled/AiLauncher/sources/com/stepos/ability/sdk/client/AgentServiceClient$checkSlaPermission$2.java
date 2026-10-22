package com.stepos.ability.sdk.client;

import Ua.M;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.bean.SlaPermissionResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ability/bean/SlaPermissionResult;", "<anonymous>", "(LUa/M;)Lcom/stepos/ability/bean/SlaPermissionResult;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ability.sdk.client.AgentServiceClient$checkSlaPermission$2", f = "AgentServiceClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentServiceClient$checkSlaPermission$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super SlaPermissionResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f22102a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f22103b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentServiceClient$checkSlaPermission$2(List<String> list, InterfaceC4014c<? super AgentServiceClient$checkSlaPermission$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f22103b = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentServiceClient$checkSlaPermission$2(this.f22103b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super SlaPermissionResult> interfaceC4014c) {
        return ((AgentServiceClient$checkSlaPermission$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SlaPermissionResult slaPermissionResultA;
        C4063a.g();
        if (this.f22102a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        IAgentServiceManager iAgentServiceManager = AgentServiceClient.serviceManager;
        if (iAgentServiceManager == null) {
            V3.b.j(V3.b.f6474a, "Ability_AgentServiceClient", "checkSlaPermission: service not bound -> UNAVAILABLE", null, 4, null);
            return SlaPermissionResult.INSTANCE.a("service not bound");
        }
        try {
            slaPermissionResultA = iAgentServiceManager.checkSlaPermissionV1(this.f22103b);
        } catch (CancellationException e10) {
            throw e10;
        } catch (Exception e11) {
            V3.b.f6474a.i("Ability_AgentServiceClient", "checkSlaPermission failed: " + e11.getMessage(), e11);
            SlaPermissionResult.Companion companion = SlaPermissionResult.INSTANCE;
            String message = e11.getMessage();
            if (message == null) {
                message = e11.getClass().getSimpleName();
            }
            slaPermissionResultA = companion.a("binder failed: " + message);
        }
        kotlin.jvm.internal.p.f(slaPermissionResultA);
        return slaPermissionResultA;
    }
}
