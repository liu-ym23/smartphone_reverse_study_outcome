package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.MessageManager$saveMessages$1", f = "MessageManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class MessageManager$saveMessages$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<ChatMessage> $messages;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager$saveMessages$1(MessageManager messageManager, List<ChatMessage> list, InterfaceC4014c<? super MessageManager$saveMessages$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = messageManager;
        this.$messages = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MessageManager$saveMessages$1 messageManager$saveMessages$1 = new MessageManager$saveMessages$1(this.this$0, this.$messages, interfaceC4014c);
        messageManager$saveMessages$1.L$0 = obj;
        return messageManager$saveMessages$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MessageManager$saveMessages$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Object objB2;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!this.this$0.o("saveMessages")) {
            return Y8.t.f7040a;
        }
        MessageManager messageManager = this.this$0;
        List<ChatMessage> list = this.$messages;
        try {
            Result.Companion companion = Result.INSTANCE;
            messageManager.messageRepository.k(list);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        List<ChatMessage> list2 = this.$messages;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("MessageManager", "saveMessages failed size=" + list2.size(), thE, false, 8, null);
        }
        for (ChatMessage chatMessage : this.$messages) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                SessionActivityTracker.INSTANCE.l(chatMessage);
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                C4148a.t("MessageManager", "track session activity failed", thE2, false, 8, null);
            }
        }
        return Y8.t.f7040a;
    }
}
