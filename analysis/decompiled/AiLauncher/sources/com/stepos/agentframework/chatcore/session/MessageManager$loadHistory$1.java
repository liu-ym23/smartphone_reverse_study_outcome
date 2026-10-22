package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.MessageManager$loadHistory$1", f = "MessageManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class MessageManager$loadHistory$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ p9.q<String, w4.e, List<ChatMessage>, Y8.t> $callback;
    final /* synthetic */ String $defaultSessionId;
    final /* synthetic */ int $limit;
    final /* synthetic */ boolean $usesOpenClawMainChannelSessionLogic;
    int label;
    final /* synthetic */ MessageManager this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.MessageManager$loadHistory$1$1", f = "MessageManager.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.MessageManager$loadHistory$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<String, w4.e, List<ChatMessage>, Y8.t> $callback;
        final /* synthetic */ String $defaultSessionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p9.q<? super String, ? super w4.e, ? super List<ChatMessage>, Y8.t> qVar, String str, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$callback = qVar;
            this.$defaultSessionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$callback, this.$defaultSessionId, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$callback.invoke(this.$defaultSessionId, null, C1173v.m());
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.MessageManager$loadHistory$1$3", f = "MessageManager.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.MessageManager$loadHistory$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<String, w4.e, List<ChatMessage>, Y8.t> $callback;
        final /* synthetic */ List<ChatMessage> $messageList;
        final /* synthetic */ String $sessionId;
        final /* synthetic */ w4.e $title;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(p9.q<? super String, ? super w4.e, ? super List<ChatMessage>, Y8.t> qVar, String str, w4.e eVar, List<ChatMessage> list, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$callback = qVar;
            this.$sessionId = str;
            this.$title = eVar;
            this.$messageList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(this.$callback, this.$sessionId, this.$title, this.$messageList, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$callback.invoke(this.$sessionId, this.$title, this.$messageList);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageManager$loadHistory$1(MessageManager messageManager, String str, int i10, boolean z10, String str2, p9.q<? super String, ? super w4.e, ? super List<ChatMessage>, Y8.t> qVar, InterfaceC4014c<? super MessageManager$loadHistory$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = messageManager;
        this.$defaultSessionId = str;
        this.$limit = i10;
        this.$usesOpenClawMainChannelSessionLogic = z10;
        this.$agentId = str2;
        this.$callback = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MessageManager$loadHistory$1(this.this$0, this.$defaultSessionId, this.$limit, this.$usesOpenClawMainChannelSessionLogic, this.$agentId, this.$callback, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MessageManager$loadHistory$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<ChatMessage> listP;
        Object next;
        String sessionId;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!this.this$0.o("loadHistory")) {
            Function2.b(new AnonymousClass1(this.$callback, this.$defaultSessionId, null));
            return Y8.t.f7040a;
        }
        if (this.$defaultSessionId.length() > 0) {
            sessionId = this.$defaultSessionId;
            listP = this.this$0.messageRepository.l(this.$defaultSessionId, this.$limit);
        } else if (this.$usesOpenClawMainChannelSessionLogic) {
            sessionId = this.this$0.j(this.$agentId);
            listP = sessionId.length() == 0 ? C1173v.m() : this.this$0.messageRepository.l(sessionId, this.$limit);
        } else {
            listP = this.this$0.messageRepository.p(this.$limit);
            Iterator<T> it = listP.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long time = ((ChatMessage) next).getTime();
                    do {
                        Object next2 = it.next();
                        long time2 = ((ChatMessage) next2).getTime();
                        if (time < time2) {
                            next = next2;
                            time = time2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            ChatMessage chatMessage = (ChatMessage) next;
            sessionId = chatMessage != null ? chatMessage.getSessionId() : null;
            if (sessionId == null) {
                sessionId = "";
            }
        }
        String str = sessionId;
        Function2.b(new AnonymousClass3(this.$callback, str, str.length() != 0 ? this.this$0.h(this.$agentId, str) : null, listP, null));
        return Y8.t.f7040a;
    }
}
