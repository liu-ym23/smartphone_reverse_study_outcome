package com.stepos.ailauncher.chat.view.sla;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController", f = "SlaChatController.kt", l = {213, 214}, m = "awaitSessionPrepared", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaChatController$awaitSessionPrepared$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SlaChatController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaChatController$awaitSessionPrepared$1(SlaChatController slaChatController, InterfaceC4014c<? super SlaChatController$awaitSessionPrepared$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = slaChatController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.W(null, null, this);
    }
}
