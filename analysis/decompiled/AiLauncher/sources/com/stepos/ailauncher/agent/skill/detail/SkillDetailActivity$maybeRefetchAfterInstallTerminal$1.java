package com.stepos.ailauncher.agent.skill.detail;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity", f = "SkillDetailActivity.kt", l = {369, 371}, m = "maybeRefetchAfterInstallTerminal", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillDetailActivity$maybeRefetchAfterInstallTerminal$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailActivity$maybeRefetchAfterInstallTerminal$1(SkillDetailActivity skillDetailActivity, InterfaceC4014c<? super SkillDetailActivity$maybeRefetchAfterInstallTerminal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = skillDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.E0(null, this);
    }
}
