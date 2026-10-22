package com.stepos.ailauncher.agent.skill.installed.viewmodel;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel", f = "InstalledSkillViewModel.kt", l = {531, 533}, m = "fetchCliPage", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstalledSkillViewModel$fetchCliPage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InstalledSkillViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstalledSkillViewModel$fetchCliPage$1(InstalledSkillViewModel installedSkillViewModel, InterfaceC4014c<? super InstalledSkillViewModel$fetchCliPage$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = installedSkillViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A(null, 0, 0, this);
    }
}
