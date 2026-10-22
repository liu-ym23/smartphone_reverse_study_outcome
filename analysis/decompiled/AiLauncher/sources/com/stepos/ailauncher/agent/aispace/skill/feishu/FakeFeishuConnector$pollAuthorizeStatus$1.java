package com.stepos.ailauncher.agent.aispace.skill.feishu;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector", f = "FeishuConnector.kt", l = {251}, m = "pollAuthorizeStatus", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FakeFeishuConnector$pollAuthorizeStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FakeFeishuConnector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeFeishuConnector$pollAuthorizeStatus$1(FakeFeishuConnector fakeFeishuConnector, InterfaceC4014c<? super FakeFeishuConnector$pollAuthorizeStatus$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = fakeFeishuConnector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
