package com.stepos.ailauncher.agent.aispace.market;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$update$1", f = "AgentMarketOperaManager.kt", l = {605, 385, 393, 404}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketOperaManager$update$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentMarketItem $item;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketOperaManager$update$1(AgentMarketItem agentMarketItem, InterfaceC4014c<? super AgentMarketOperaManager$update$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$item = agentMarketItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketOperaManager$update$1(this.$item, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketOperaManager$update$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|2|(5:(1:(1:(6:(1:(1:8)(2:13|14))(1:15)|68|9|59|60|61)(8:16|72|17|32|(7:34|(1:36)(1:37)|(1:39)|40|(1:42)(1:43)|(1:50)(2:47|(2:49|58))|51)(3:52|(1:54)(1:55)|56)|59|60|61))(1:21))(3:22|(1:25)|58)|73|28|(6:31|32|(0)(0)|59|60|61)|58)|70|26|27|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a4, code lost:
    
        if (r4.G(r1, com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, r19) == r9) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc A[Catch: all -> 0x0054, TryCatch #2 {all -> 0x0054, blocks: (B:17:0x0047, B:32:0x00c6, B:34:0x00cc, B:36:0x00d2, B:40:0x00dc, B:42:0x00e0, B:45:0x00e7, B:47:0x00ef, B:50:0x0130, B:52:0x016e, B:56:0x0179), top: B:72:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016e A[Catch: all -> 0x0054, TryCatch #2 {all -> 0x0054, blocks: (B:17:0x0047, B:32:0x00c6, B:34:0x00cc, B:36:0x00d2, B:40:0x00dc, B:42:0x00e0, B:45:0x00e7, B:47:0x00ef, B:50:0x0130, B:52:0x016e, B:56:0x0179), top: B:72:0x0047 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$update$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
