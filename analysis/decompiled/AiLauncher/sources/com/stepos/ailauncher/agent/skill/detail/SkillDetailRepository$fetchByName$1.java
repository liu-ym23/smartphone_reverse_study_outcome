package com.stepos.ailauncher.agent.skill.detail;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailRepository", f = "SkillDetailRepository.kt", l = {43, 45}, m = "fetchByName-0E7RQCE", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillDetailRepository$fetchByName$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailRepository$fetchByName$1(SkillDetailRepository skillDetailRepository, InterfaceC4014c<? super SkillDetailRepository$fetchByName$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = skillDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objD = this.this$0.d(null, 0, this);
        return objD == C4063a.g() ? objD : Result.a(objD);
    }
}
