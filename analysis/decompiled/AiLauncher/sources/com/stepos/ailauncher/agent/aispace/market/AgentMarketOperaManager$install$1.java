package com.stepos.ailauncher.agent.aispace.market;

import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$install$1", f = "AgentMarketOperaManager.kt", l = {605, 262, SubsamplingScaleImageView.ORIENTATION_270, 283}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketOperaManager$install$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentMarketItem $item;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketOperaManager$install$1(AgentMarketItem agentMarketItem, InterfaceC4014c<? super AgentMarketOperaManager$install$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$item = agentMarketItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketOperaManager$install$1(this.$item, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketOperaManager$install$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:82)|(5:(1:(1:(1:(1:(5:8|9|70|71|72)(2:13|14))(8:15|16|53|(1:58)(1:57)|59|70|71|72))(9:18|79|19|20|34|(6:36|(1:38)(1:39)|(1:41)|42|(1:44)(1:45)|(2:61|62)(3:49|(3:52|53|(3:55|58|59)(0))|69))(3:63|(1:65)(1:66)|67)|70|71|72))(1:23))(3:24|(1:27)|69)|84|30|(6:33|34|(0)(0)|70|71|72)|69)|80|28|29|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f3, code lost:
    
        if (r5.G(r0, W4.b.STEP_INSTALL, r20) == r9) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0202, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:19:0x004e, B:34:0x00df, B:36:0x00e5, B:38:0x00eb, B:42:0x00f5, B:44:0x00f9, B:47:0x0100, B:49:0x0108, B:61:0x0175, B:63:0x01be, B:67:0x01c9), top: B:79:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01be A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:19:0x004e, B:34:0x00df, B:36:0x00e5, B:38:0x00eb, B:42:0x00f5, B:44:0x00f9, B:47:0x0100, B:49:0x0108, B:61:0x0175, B:63:0x01be, B:67:0x01c9), top: B:79:0x004e }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
