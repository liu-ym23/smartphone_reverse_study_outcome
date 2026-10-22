package com.stepos.ailauncher.agent.skill.repository;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.repository.ApiSkillRepository", f = "ApiSkillRepository.kt", l = {90, 92}, m = "searchSkills", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiSkillRepository$searchSkills$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApiSkillRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiSkillRepository$searchSkills$1(ApiSkillRepository apiSkillRepository, InterfaceC4014c<? super ApiSkillRepository$searchSkills$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = apiSkillRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, 0, 0, this);
    }
}
