package com.stepos.ailauncher.chat.input;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.input.ChatStopActions", f = "ChatStopActions.kt", l = {50, 58}, m = "cancelUnfinishedTasksAwait", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatStopActions$cancelUnfinishedTasksAwait$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatStopActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatStopActions$cancelUnfinishedTasksAwait$1(ChatStopActions chatStopActions, InterfaceC4014c<? super ChatStopActions$cancelUnfinishedTasksAwait$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = chatStopActions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, this);
    }
}
