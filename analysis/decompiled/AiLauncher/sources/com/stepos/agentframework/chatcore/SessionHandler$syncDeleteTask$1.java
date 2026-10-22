package com.stepos.agentframework.chatcore;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler", f = "SessionHandler.kt", l = {3057}, m = "syncDeleteTask", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionHandler$syncDeleteTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$syncDeleteTask$1(SessionHandler sessionHandler, InterfaceC4014c<? super SessionHandler$syncDeleteTask$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = sessionHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c4(null, this);
    }
}
