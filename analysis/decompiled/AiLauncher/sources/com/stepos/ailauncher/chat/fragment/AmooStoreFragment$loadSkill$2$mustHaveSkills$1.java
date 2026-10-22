package com.stepos.ailauncher.chat.fragment;

import com.stepos.ailauncher.contract.model.SkillItemBrief;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooStoreFragment$loadSkill$2$mustHaveSkills$1", f = "AmooStoreFragment.kt", l = {442}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooStoreFragment$loadSkill$2$mustHaveSkills$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super List<? extends SkillItemBrief>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public AmooStoreFragment$loadSkill$2$mustHaveSkills$1(InterfaceC4014c<? super AmooStoreFragment$loadSkill$2$mustHaveSkills$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AmooStoreFragment$loadSkill$2$mustHaveSkills$1 amooStoreFragment$loadSkill$2$mustHaveSkills$1 = new AmooStoreFragment$loadSkill$2$mustHaveSkills$1(interfaceC4014c);
        amooStoreFragment$loadSkill$2$mustHaveSkills$1.L$0 = obj;
        return amooStoreFragment$loadSkill$2$mustHaveSkills$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Ua.M m10, InterfaceC4014c<? super List<SkillItemBrief>> interfaceC4014c) {
        return ((AmooStoreFragment$loadSkill$2$mustHaveSkills$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:6:0x0013, B:16:0x004f, B:19:0x0055, B:20:0x0059, B:11:0x0022, B:13:0x0031), top: B:28:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r11.label
            r3 = 1
            if (r2 == 0) goto L1f
            if (r2 != r3) goto L17
            java.lang.Object r11 = r11.L$1
            Ua.M r11 = (Ua.M) r11
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L5e
            goto L4f
        L17:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1f:
            kotlin.C4849c.b(r12)
            kotlin.Result$a r12 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5e
            D5.a r12 = D5.a.INSTANCE     // Catch: java.lang.Throwable -> L5e
            java.lang.Class<com.stepos.ailauncher.contract.api.agent.IAgentMarketService> r2 = com.stepos.ailauncher.contract.api.agent.IAgentMarketService.class
            java.lang.Object r12 = r12.a(r2)     // Catch: java.lang.Throwable -> L5e
            r4 = r12
            com.stepos.ailauncher.contract.api.agent.IAgentMarketService r4 = (com.stepos.ailauncher.contract.api.agent.IAgentMarketService) r4     // Catch: java.lang.Throwable -> L5e
            if (r4 == 0) goto L52
            java.lang.Object r12 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L5e
            r11.L$0 = r12     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r12 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L5e
            r11.L$1 = r12     // Catch: java.lang.Throwable -> L5e
            r12 = 0
            r11.I$0 = r12     // Catch: java.lang.Throwable -> L5e
            r11.label = r3     // Catch: java.lang.Throwable -> L5e
            r5 = 1
            r6 = 0
            r7 = 0
            r9 = 6
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.stepos.ailauncher.contract.api.agent.IAgentMarketService.getSkillList$default(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5e
            if (r12 != r1) goto L4f
            return r1
        L4f:
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L5e
            goto L53
        L52:
            r12 = 0
        L53:
            if (r12 != 0) goto L59
            java.util.List r12 = Z8.C1173v.m()     // Catch: java.lang.Throwable -> L5e
        L59:
            java.lang.Object r11 = kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> L5e
            goto L6a
        L5e:
            r0 = move-exception
            r11 = r0
            kotlin.Result$a r12 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        L6a:
            java.util.List r12 = Z8.C1173v.m()
            boolean r0 = kotlin.Result.g(r11)
            if (r0 == 0) goto L75
            r11 = r12
        L75:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.fragment.AmooStoreFragment$loadSkill$2$mustHaveSkills$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super List<? extends SkillItemBrief>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<SkillItemBrief>>) interfaceC4014c);
    }
}
