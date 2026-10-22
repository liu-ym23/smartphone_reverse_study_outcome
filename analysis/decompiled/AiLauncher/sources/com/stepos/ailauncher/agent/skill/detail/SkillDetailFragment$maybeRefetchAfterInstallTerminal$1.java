package com.stepos.ailauncher.agent.skill.detail;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment", f = "SkillDetailFragment.kt", l = {469}, m = "maybeRefetchAfterInstallTerminal", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillDetailFragment$maybeRefetchAfterInstallTerminal$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailFragment$maybeRefetchAfterInstallTerminal$1(SkillDetailFragment skillDetailFragment, InterfaceC4014c<? super SkillDetailFragment$maybeRefetchAfterInstallTerminal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = skillDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.H0(null, this);
    }
}
