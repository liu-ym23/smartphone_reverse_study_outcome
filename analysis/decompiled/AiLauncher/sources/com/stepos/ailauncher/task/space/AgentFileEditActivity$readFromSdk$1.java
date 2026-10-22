package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.AgentFileEditActivity", f = "AgentFileEditActivity.kt", l = {127}, m = "readFromSdk", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentFileEditActivity$readFromSdk$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentFileEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileEditActivity$readFromSdk$1(AgentFileEditActivity agentFileEditActivity, InterfaceC4014c<? super AgentFileEditActivity$readFromSdk$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentFileEditActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Y(this);
    }
}
