package com.stepos.ailauncher.agent.aispace.market;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$startProgress$1", f = "AgentMarketOperaManager.kt", l = {210}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketOperaManager$startProgress$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $assetId;
    long J$0;
    long J$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketOperaManager$startProgress$1(String str, InterfaceC4014c<? super AgentMarketOperaManager$startProgress$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$assetId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketOperaManager$startProgress$1(this.$assetId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketOperaManager$startProgress$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:12:0x0033). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            long r3 = r11.J$1
            long r5 = r11.J$0
            kotlin.C4849c.b(r12)
            goto L33
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1b:
            kotlin.C4849c.b(r12)
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 0
        L24:
            r11.J$0 = r5
            r11.J$1 = r3
            r11.label = r2
            r7 = 400(0x190, double:1.976E-321)
            java.lang.Object r12 = Ua.U.a(r7, r11)
            if (r12 != r0) goto L33
            return r0
        L33:
            long r7 = android.os.SystemClock.elapsedRealtime()
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager r12 = com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.INSTANCE
            boolean r1 = com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.h(r12)
            if (r1 == 0) goto L42
            long r3 = r7 - r3
            long r5 = r5 + r3
        L42:
            r1 = 100
            long r3 = (long) r1
            long r3 = r3 * r5
            r9 = 40000(0x9c40, double:1.97626E-319)
            long r3 = r3 / r9
            r9 = 99
            long r3 = java.lang.Math.min(r9, r3)
            int r1 = (int) r3
            java.lang.String r3 = r11.$assetId
            com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager.m(r12, r3, r1)
            r12 = 99
            if (r1 < r12) goto L5d
            Y8.t r11 = Y8.t.f7040a
            return r11
        L5d:
            r3 = r7
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager$startProgress$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
