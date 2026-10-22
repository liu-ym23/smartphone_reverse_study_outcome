package com.stepos.ailauncher.agent.skill.opera;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.opera.SkillOperaManager", f = "SkillOperaManager.kt", l = {421, 422, 423, 424, 425, 434, 456, 464, 493}, m = "submitInternal-hUnOzRk", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillOperaManager$submitInternal$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillOperaManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillOperaManager$submitInternal$1(SkillOperaManager skillOperaManager, InterfaceC4014c<? super SkillOperaManager$submitInternal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = skillOperaManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objL0 = this.this$0.l0(null, null, null, null, null, this);
        return objL0 == C4063a.g() ? objL0 : Result.a(objL0);
    }
}
