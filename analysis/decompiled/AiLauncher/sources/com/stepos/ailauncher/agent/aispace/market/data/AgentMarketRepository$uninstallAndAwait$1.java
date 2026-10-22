package com.stepos.ailauncher.agent.aispace.market.data;

import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.data.AgentMarketRepository", f = "AgentMarketRepository.kt", l = {156, 159, DidiCardView.FINISHED_SUMMARY_WIDTH_DP, DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP}, m = "uninstallAndAwait", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentMarketRepository$uninstallAndAwait$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentMarketRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketRepository$uninstallAndAwait$1(AgentMarketRepository agentMarketRepository, InterfaceC4014c<? super AgentMarketRepository$uninstallAndAwait$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentMarketRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.G(null, null, null, null, this);
    }
}
