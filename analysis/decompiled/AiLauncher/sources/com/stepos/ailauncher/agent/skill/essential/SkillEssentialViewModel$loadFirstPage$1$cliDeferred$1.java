package com.stepos.ailauncher.agent.skill.essential;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.agent.skill.SkillItem;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1", f = "SkillEssentialViewModel.kt", l = {265, 266}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends SkillItem>>, Object> {
    final /* synthetic */ SkillEssentialUiState $state;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SkillEssentialViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1(SkillEssentialViewModel skillEssentialViewModel, SkillEssentialUiState skillEssentialUiState, InterfaceC4014c<? super SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = skillEssentialViewModel;
        this.$state = skillEssentialUiState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1 skillEssentialViewModel$loadFirstPage$1$cliDeferred$1 = new SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1(this.this$0, this.$state, interfaceC4014c);
        skillEssentialViewModel$loadFirstPage$1$cliDeferred$1.L$0 = obj;
        return skillEssentialViewModel$loadFirstPage$1$cliDeferred$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<SkillItem>> interfaceC4014c) {
        return ((SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
    
        if (r14 == r1) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = r13.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r13.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2b
            if (r2 == r4) goto L23
            if (r2 != r3) goto L1b
            java.lang.Object r13 = r13.L$1
            Ua.M r13 = (Ua.M) r13
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L92
            goto L8b
        L1b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L23:
            java.lang.Object r13 = r13.L$1
            Ua.M r13 = (Ua.M) r13
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L92
            goto L6b
        L2b:
            kotlin.C4849c.b(r14)
            com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel r14 = r13.this$0
            boolean r14 = com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel.o(r14)
            if (r14 != 0) goto L3b
            java.util.List r13 = Z8.C1173v.m()
            return r13
        L3b:
            com.stepos.ailauncher.agent.skill.essential.k r14 = r13.$state
            com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel r2 = r13.this$0
            kotlin.Result$a r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L92
            boolean r5 = r14.getIsSearching()     // Catch: java.lang.Throwable -> L92
            r6 = 0
            if (r5 == 0) goto L6e
            com.stepos.ailauncher.agent.skill.cli.d r7 = com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel.j(r2)     // Catch: java.lang.Throwable -> L92
            java.lang.String r8 = r14.getSearchQuery()     // Catch: java.lang.Throwable -> L92
            java.lang.Object r14 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L92
            r13.L$0 = r14     // Catch: java.lang.Throwable -> L92
            java.lang.Object r14 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L92
            r13.L$1 = r14     // Catch: java.lang.Throwable -> L92
            r13.I$0 = r6     // Catch: java.lang.Throwable -> L92
            r13.label = r4     // Catch: java.lang.Throwable -> L92
            r9 = 0
            r11 = 2
            r12 = 0
            r10 = r13
            java.lang.Object r14 = com.stepos.ailauncher.agent.skill.cli.d.a(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L92
            if (r14 != r1) goto L6b
            goto L8a
        L6b:
            java.util.List r14 = (java.util.List) r14     // Catch: java.lang.Throwable -> L92
            goto L8d
        L6e:
            r10 = r13
            com.stepos.ailauncher.agent.skill.cli.d r13 = com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel.j(r2)     // Catch: java.lang.Throwable -> L92
            java.lang.Object r14 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L92
            r10.L$0 = r14     // Catch: java.lang.Throwable -> L92
            java.lang.Object r14 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L92
            r10.L$1 = r14     // Catch: java.lang.Throwable -> L92
            r10.I$0 = r6     // Catch: java.lang.Throwable -> L92
            r10.label = r3     // Catch: java.lang.Throwable -> L92
            r14 = 0
            java.lang.Object r14 = com.stepos.ailauncher.agent.skill.cli.d.d(r13, r14, r10, r4, r14)     // Catch: java.lang.Throwable -> L92
            if (r14 != r1) goto L8b
        L8a:
            return r1
        L8b:
            java.util.List r14 = (java.util.List) r14     // Catch: java.lang.Throwable -> L92
        L8d:
            java.lang.Object r13 = kotlin.Result.b(r14)     // Catch: java.lang.Throwable -> L92
            goto L9e
        L92:
            r0 = move-exception
            r13 = r0
            kotlin.Result$a r14 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.C4849c.a(r13)
            java.lang.Object r13 = kotlin.Result.b(r13)
        L9e:
            java.lang.Throwable r2 = kotlin.Result.e(r13)
            if (r2 == 0) goto Laf
            r4 = 8
            r5 = 0
            java.lang.String r0 = "SkillEssentialVM"
            java.lang.String r1 = "loadCli failed"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
        Laf:
            java.util.List r14 = Z8.C1173v.m()
            boolean r0 = kotlin.Result.g(r13)
            if (r0 == 0) goto Lba
            r13 = r14
        Lba:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$loadFirstPage$1$cliDeferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends SkillItem>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<SkillItem>>) interfaceC4014c);
    }
}
