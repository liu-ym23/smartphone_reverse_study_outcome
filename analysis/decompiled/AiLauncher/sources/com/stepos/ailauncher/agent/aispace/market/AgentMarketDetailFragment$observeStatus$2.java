package com.stepos.ailauncher.agent.aispace.market;

import android.view.Lifecycle;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$2", f = "AgentMarketDetailFragment.kt", l = {312}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailFragment$observeStatus$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ AgentMarketDetailFragment this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ AgentMarketDetailFragment this$0;

        public a(AgentMarketDetailFragment agentMarketDetailFragment) {
            this.this$0 = agentMarketDetailFragment;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(AgentMarketOperaManager.a aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            boolean z10 = aVar instanceof AgentMarketOperaManager.a.UpdateSucceeded;
            if (z10) {
                this.this$0.needUpdate = false;
            }
            if (!this.this$0.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED) || this.this$0.isHidden()) {
                return Y8.t.f7040a;
            }
            if (aVar instanceof AgentMarketOperaManager.a.InstallSucceeded) {
                this.this$0.y1();
            } else if (z10) {
                AgentMarketDetailFragment agentMarketDetailFragment = this.this$0;
                AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
                AgentMarketItem agentMarketItem = agentMarketDetailFragment.item;
                AgentMarketItem agentMarketItem2 = null;
                if (agentMarketItem == null) {
                    kotlin.jvm.internal.p.A("item");
                    agentMarketItem = null;
                }
                String assetId = agentMarketItem.getAssetId();
                AgentMarketItem agentMarketItem3 = this.this$0.item;
                if (agentMarketItem3 == null) {
                    kotlin.jvm.internal.p.A("item");
                } else {
                    agentMarketItem2 = agentMarketItem3;
                }
                agentMarketDetailFragment.y0(agentMarketOperaManager.Q(assetId, agentMarketItem2.getInitialStatus()));
                this.this$0.B1("更新成功");
            } else if (!(aVar instanceof AgentMarketOperaManager.a.UninstallSucceeded)) {
                if (!(aVar instanceof AgentMarketOperaManager.a.Failed)) {
                    throw new NoWhenBranchMatchedException();
                }
                AgentMarketDetailFragment agentMarketDetailFragment2 = this.this$0;
                String message = ((AgentMarketOperaManager.a.Failed) aVar).getMessage();
                if (La.H.x0(message)) {
                    message = "请稍后重试";
                }
                agentMarketDetailFragment2.B1("操作失败：" + ((Object) message));
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailFragment$observeStatus$2(AgentMarketDetailFragment agentMarketDetailFragment, InterfaceC4014c<? super AgentMarketDetailFragment$observeStatus$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailFragment$observeStatus$2(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailFragment$observeStatus$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<AgentMarketOperaManager.a> oVarU = AgentMarketOperaManager.INSTANCE.u();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (oVarU.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
