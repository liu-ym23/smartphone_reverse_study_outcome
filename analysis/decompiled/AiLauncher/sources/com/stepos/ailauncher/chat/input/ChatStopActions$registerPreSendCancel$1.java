package com.stepos.ailauncher.chat.input;

import Y8.t;
import com.stepos.agentframework.chatcore.SessionHandler;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.input.ChatStopActions$registerPreSendCancel$1", f = "ChatStopActions.kt", l = {26}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatStopActions$registerPreSendCancel$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SessionHandler $handler;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatStopActions$registerPreSendCancel$1(SessionHandler sessionHandler, InterfaceC4014c<? super ChatStopActions$registerPreSendCancel$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$handler = sessionHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new ChatStopActions$registerPreSendCancel$1(this.$handler, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ChatStopActions$registerPreSendCancel$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ChatStopActions chatStopActions = ChatStopActions.INSTANCE;
            SessionHandler sessionHandler = this.$handler;
            this.label = 1;
            if (chatStopActions.d(sessionHandler, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
