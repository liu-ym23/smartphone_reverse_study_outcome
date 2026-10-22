package com.stepos.ailauncher.agent.aispace.market;

import com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager;
import com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$setEnabled$1", f = "AgentMarketOperaManager.kt", l = {448}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketOperaManager$setEnabled$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ AgentMarketItem $item;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketOperaManager$setEnabled$1(AgentMarketItem agentMarketItem, boolean z10, InterfaceC4014c<? super AgentMarketOperaManager$setEnabled$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$item = agentMarketItem;
        this.$enabled = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketOperaManager$setEnabled$1(this.$item, this.$enabled, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketOperaManager$setEnabled$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objC;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AgentMarketRepository agentMarketRepository = AgentMarketRepository.INSTANCE;
            String assetId = this.$item.getAssetId();
            boolean z10 = this.$enabled;
            this.label = 1;
            objC = agentMarketRepository.C(assetId, z10, this);
            if (objC == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objC = ((Result) obj).getValue();
        }
        if (Result.g(objC)) {
            Throwable thE = Result.e(objC);
            String message = thE != null ? thE.getMessage() : null;
            if (message == null) {
                message = "";
            }
            C2277j.b(C2277j.INSTANCE, "SetAgentEnabled FAILED: " + message + "（已回滚）", null, 2, null);
            AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
            agentMarketOperaManager.M(this.$item.getAssetId(), this.$enabled ? AgentMarketStatus.INSTALLED_DISABLED : AgentMarketStatus.INSTALLED_ENABLED);
            C4109a.a(AgentMarketOperaManager._events.a(new AgentMarketOperaManager.a.Failed(this.$item.getAssetId(), message, agentMarketOperaManager.A(thE))));
        } else {
            C2277j.b(C2277j.INSTANCE, "SetAgentEnabled ok asset_id=" + this.$item.getAssetId() + " enabled=" + this.$enabled, null, 2, null);
            W4.a.INSTANCE.b(this.$item.getAssetId(), W4.a.SOURCE_DETAIL, this.$enabled);
        }
        return Y8.t.f7040a;
    }
}
