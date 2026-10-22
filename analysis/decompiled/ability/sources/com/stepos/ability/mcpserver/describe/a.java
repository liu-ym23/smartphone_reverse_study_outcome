package com.stepos.ability.mcpserver.describe;

import com.stepos.ability.api.ability.repository.IAtomicAbilityRepository;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final IAbilityManager f3171a;
    public final IAtomicAbilityRepository b;

    public a(IAbilityManager abilityManager, IAtomicAbilityRepository repository) {
        k.f(abilityManager, "abilityManager");
        k.f(repository, "repository");
        this.f3171a = abilityManager;
        this.b = repository;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        if (r2 == r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r21, kotlin.coroutines.jvm.internal.ContinuationImpl r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            boolean r3 = r2 instanceof com.stepos.ability.mcpserver.describe.ToolDescribeEngine$describe$1
            if (r3 == 0) goto L19
            r3 = r2
            com.stepos.ability.mcpserver.describe.ToolDescribeEngine$describe$1 r3 = (com.stepos.ability.mcpserver.describe.ToolDescribeEngine$describe$1) r3
            int r4 = r3.d
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.d = r4
            goto L1e
        L19:
            com.stepos.ability.mcpserver.describe.ToolDescribeEngine$describe$1 r3 = new com.stepos.ability.mcpserver.describe.ToolDescribeEngine$describe$1
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r5 = r3.d
            r6 = 0
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L40
            if (r5 == r8) goto L39
            if (r5 != r7) goto L31
            kotlin.b.b(r2)
            goto L6f
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            java.lang.String r1 = r3.f3170a
            kotlin.b.b(r2)
        L3e:
            r10 = r1
            goto L50
        L40:
            kotlin.b.b(r2)
            r3.f3170a = r1
            r3.d = r8
            com.stepos.ability.api.ability.repository.IAtomicAbilityRepository r2 = r0.b
            java.lang.Object r2 = r2.getByToolName(r1, r3)
            if (r2 != r4) goto L3e
            goto L6e
        L50:
            J3.a r2 = (J3.a) r2
            if (r2 == 0) goto L59
            com.stepos.ability.mcpserver.model.ToolDescription r0 = com.stepos.ability.mcpserver.model.ToolDescriptionKt.toToolDescription(r2)
            return r0
        L59:
            com.stepos.ability.beaninternal.ability.AbilityMetaDataReq r8 = new com.stepos.ability.beaninternal.ability.AbilityMetaDataReq
            r12 = 5
            r13 = 0
            r9 = 0
            r11 = 0
            r8.<init>(r9, r10, r11, r12, r13)
            r3.f3170a = r6
            r3.d = r7
            com.stepos.ability.commoninternal.ability.IAbilityManager r0 = r0.f3171a
            java.lang.Object r2 = r0.getAbilityMetaData(r8, r3)
            if (r2 != r4) goto L6f
        L6e:
            return r4
        L6f:
            com.stepos.ability.beaninternal.ability.AbilityMetaDataResult r2 = (com.stepos.ability.beaninternal.ability.AbilityMetaDataResult) r2
            if (r2 != 0) goto L74
            return r6
        L74:
            com.stepos.ability.mcpserver.model.ToolDescription r7 = new com.stepos.ability.mcpserver.model.ToolDescription
            java.lang.String r8 = r2.getToolName()
            java.lang.String r9 = r2.getToolName()
            java.lang.String r10 = r2.getDescription()
            java.lang.String r0 = r2.getInputSchema()
            java.util.Map r11 = com.stepos.ability.mcpserver.model.ToolDescriptionKt.parseJsonObject(r0)
            kotlin.collections.EmptyList r13 = kotlin.collections.EmptyList.f4893a
            int r14 = r2.getTimeout()
            r18 = -1
            r19 = 0
            r12 = 0
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.mcpserver.describe.a.a(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
