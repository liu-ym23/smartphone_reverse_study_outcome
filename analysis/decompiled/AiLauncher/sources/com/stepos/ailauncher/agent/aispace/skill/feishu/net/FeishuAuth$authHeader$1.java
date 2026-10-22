package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuAuth", f = "FeishuAuth.kt", l = {29}, m = "authHeader", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeishuAuth$authHeader$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeishuAuth this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuAuth$authHeader$1(FeishuAuth feishuAuth, InterfaceC4014c<? super FeishuAuth$authHeader$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = feishuAuth;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
