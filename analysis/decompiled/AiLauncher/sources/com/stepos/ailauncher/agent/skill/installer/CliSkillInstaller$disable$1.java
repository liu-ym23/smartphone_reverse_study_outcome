package com.stepos.ailauncher.agent.skill.installer;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installer.CliSkillInstaller", f = "CliSkillInstaller.kt", l = {56}, m = "disable-gIAlu-s", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CliSkillInstaller$disable$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CliSkillInstaller this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CliSkillInstaller$disable$1(CliSkillInstaller cliSkillInstaller, InterfaceC4014c<? super CliSkillInstaller$disable$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = cliSkillInstaller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objH = this.this$0.h(null, this);
        return objH == C4063a.g() ? objH : Result.a(objH);
    }
}
