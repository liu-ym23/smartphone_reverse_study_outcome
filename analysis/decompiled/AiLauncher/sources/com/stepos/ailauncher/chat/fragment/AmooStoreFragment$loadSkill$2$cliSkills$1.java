package com.stepos.ailauncher.chat.fragment;

import com.stepos.ailauncher.contract.model.SkillItemBrief;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooStoreFragment$loadSkill$2$cliSkills$1", f = "AmooStoreFragment.kt", l = {447}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooStoreFragment$loadSkill$2$cliSkills$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super List<? extends SkillItemBrief>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public AmooStoreFragment$loadSkill$2$cliSkills$1(InterfaceC4014c<? super AmooStoreFragment$loadSkill$2$cliSkills$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmooStoreFragment$loadSkill$2$cliSkills$1 amooStoreFragment$loadSkill$2$cliSkills$1 = new AmooStoreFragment$loadSkill$2$cliSkills$1(interfaceC4014c);
        amooStoreFragment$loadSkill$2$cliSkills$1.L$0 = obj;
        return amooStoreFragment$loadSkill$2$cliSkills$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
        return ((AmooStoreFragment$loadSkill$2$cliSkills$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:6:0x0013, B:16:0x004e, B:19:0x0054, B:20:0x0058, B:11:0x0022, B:13:0x0031), top: B:28:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.label
            r3 = 1
            if (r2 == 0) goto L1f
            if (r2 != r3) goto L17
            java.lang.Object r10 = r10.L$1
            Ua.M r10 = (Ua.M) r10
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L5d
            goto L4e
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1f:
            kotlin.C4849c.b(r11)
            kotlin.Result$a r11 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5d
            D5.a r11 = D5.a.INSTANCE     // Catch: java.lang.Throwable -> L5d
            java.lang.Class<com.stepos.ailauncher.contract.api.agent.IAgentMarketService> r2 = com.stepos.ailauncher.contract.api.agent.IAgentMarketService.class
            java.lang.Object r11 = r11.a(r2)     // Catch: java.lang.Throwable -> L5d
            r4 = r11
            com.stepos.ailauncher.contract.api.agent.IAgentMarketService r4 = (com.stepos.ailauncher.contract.api.agent.IAgentMarketService) r4     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L51
            java.lang.Object r11 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L5d
            r10.L$0 = r11     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r11 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L5d
            r10.L$1 = r11     // Catch: java.lang.Throwable -> L5d
            r11 = 0
            r10.I$0 = r11     // Catch: java.lang.Throwable -> L5d
            r10.label = r3     // Catch: java.lang.Throwable -> L5d
            r5 = 0
            r6 = 0
            r8 = 3
            r9 = 0
            r7 = r10
            java.lang.Object r11 = com.stepos.ailauncher.contract.api.agent.IAgentMarketService.getCliList$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5d
            if (r11 != r1) goto L4e
            return r1
        L4e:
            java.util.List r11 = (java.util.List) r11     // Catch: java.lang.Throwable -> L5d
            goto L52
        L51:
            r11 = 0
        L52:
            if (r11 != 0) goto L58
            java.util.List r11 = Z8.C1173v.m()     // Catch: java.lang.Throwable -> L5d
        L58:
            java.lang.Object r10 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L5d
            goto L69
        L5d:
            r0 = move-exception
            r10 = r0
            kotlin.Result$a r11 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.C4849c.a(r10)
            java.lang.Object r10 = kotlin.Result.b(r10)
        L69:
            java.util.List r11 = Z8.C1173v.m()
            boolean r0 = kotlin.Result.g(r10)
            if (r0 == 0) goto L74
            r10 = r11
        L74:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.fragment.AmooStoreFragment$loadSkill$2$cliSkills$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super List<? extends SkillItemBrief>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<SkillItemBrief>>) interfaceC4014c);
    }
}
