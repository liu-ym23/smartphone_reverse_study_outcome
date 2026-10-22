package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.MessageManager$setLikeStatus$1", f = "MessageManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class MessageManager$setLikeStatus$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $isLike;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager$setLikeStatus$1(MessageManager messageManager, String str, int i10, InterfaceC4014c<? super MessageManager$setLikeStatus$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = messageManager;
        this.$messageId = str;
        this.$isLike = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MessageManager$setLikeStatus$1(this.this$0, this.$messageId, this.$isLike, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MessageManager$setLikeStatus$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!this.this$0.o("setLikeStatus")) {
            return Y8.t.f7040a;
        }
        ChatMessage chatMessageV = this.this$0.messageRepository.v(this.$messageId);
        if (chatMessageV != null) {
            int i10 = this.$isLike;
            MessageManager messageManager = this.this$0;
            chatMessageV.K(i10);
            messageManager.messageRepository.t(chatMessageV);
        }
        return Y8.t.f7040a;
    }
}
