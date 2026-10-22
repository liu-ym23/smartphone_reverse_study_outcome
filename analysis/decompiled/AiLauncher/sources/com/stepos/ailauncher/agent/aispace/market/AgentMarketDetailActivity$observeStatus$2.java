package com.stepos.ailauncher.agent.aispace.market;

import Y4.C1117a;
import com.stepos.ailauncher.agent.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$observeStatus$2", f = "AgentMarketDetailActivity.kt", l = {234}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity$observeStatus$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ AgentMarketDetailActivity this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ AgentMarketDetailActivity this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$observeStatus$2$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0258a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AgentMarketStatus.values().length];
                try {
                    iArr[AgentMarketStatus.INSTALLING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AgentMarketStatus.QUEUED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AgentMarketStatus.UPDATING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public a(AgentMarketDetailActivity agentMarketDetailActivity) {
            this.this$0 = agentMarketDetailActivity;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Map<String, Integer> map, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
            AgentMarketItem agentMarketItem = this.this$0.item;
            C1117a c1117a = null;
            if (agentMarketItem == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem = null;
            }
            String assetId = agentMarketItem.getAssetId();
            AgentMarketItem agentMarketItem2 = this.this$0.item;
            if (agentMarketItem2 == null) {
                kotlin.jvm.internal.p.A("item");
                agentMarketItem2 = null;
            }
            int i10 = C0258a.$EnumSwitchMapping$0[agentMarketOperaManager.Q(assetId, agentMarketItem2.getInitialStatus()).ordinal()];
            Integer numF = (i10 == 1 || i10 == 2) ? C4109a.f(R$string.agent_detail_installing_percent) : i10 != 3 ? null : C4109a.f(R$string.agent_detail_updating_percent);
            if (numF != null) {
                AgentMarketItem agentMarketItem3 = this.this$0.item;
                if (agentMarketItem3 == null) {
                    kotlin.jvm.internal.p.A("item");
                    agentMarketItem3 = null;
                }
                Integer num = map.get(agentMarketItem3.getAssetId());
                int iIntValue = num != null ? num.intValue() : 0;
                C1117a c1117a2 = this.this$0.binding;
                if (c1117a2 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c1117a2 = null;
                }
                c1117a2.btnBottom.setText(this.this$0.getString(numF.intValue(), C4109a.f(iIntValue)));
                this.this$0.V0(iIntValue);
                C1117a c1117a3 = this.this$0.binding;
                if (c1117a3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c1117a = c1117a3;
                }
                c1117a.btnBottom.setProgressFraction(iIntValue / 100.0f);
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailActivity$observeStatus$2(AgentMarketDetailActivity agentMarketDetailActivity, InterfaceC4014c<? super AgentMarketDetailActivity$observeStatus$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailActivity$observeStatus$2(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailActivity$observeStatus$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Map<String, Integer>> tVarV = AgentMarketOperaManager.INSTANCE.v();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (tVarV.collect(aVar, this) == objG) {
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
