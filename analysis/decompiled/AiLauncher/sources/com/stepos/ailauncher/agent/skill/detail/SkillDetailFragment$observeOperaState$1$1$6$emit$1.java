package com.stepos.ailauncher.agent.skill.detail;

import com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$6", f = "SkillDetailFragment.kt", l = {412}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillDetailFragment$observeOperaState$1$1$6$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillDetailFragment$observeOperaState$1.AnonymousClass1.AnonymousClass6<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SkillDetailFragment$observeOperaState$1$1$6$emit$1(SkillDetailFragment$observeOperaState$1.AnonymousClass1.AnonymousClass6<? super T> anonymousClass6, InterfaceC4014c<? super SkillDetailFragment$observeOperaState$1$1$6$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = anonymousClass6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
