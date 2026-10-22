package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$loadMoreTopConversationMessages$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$loadMoreTopConversationMessages$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $beforeMessageId;
    final /* synthetic */ long $beforeTime;
    final /* synthetic */ int $limit;
    final /* synthetic */ InterfaceC5074l<List<ChatMessage>, Y8.t> $onLoaded;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$loadMoreTopConversationMessages$1$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$loadMoreTopConversationMessages$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ List<ChatMessage> $messageList;
        final /* synthetic */ InterfaceC5074l<List<ChatMessage>, Y8.t> $onLoaded;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l, List<ChatMessage> list, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onLoaded = interfaceC5074l;
            this.$messageList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onLoaded, this.$messageList, interfaceC4014c);
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
            this.$onLoaded.invoke(this.$messageList);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$loadMoreTopConversationMessages$1(AgentSession agentSession, long j10, String str, int i10, InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l, InterfaceC4014c<? super AgentSession$loadMoreTopConversationMessages$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$beforeTime = j10;
        this.$beforeMessageId = str;
        this.$limit = i10;
        this.$onLoaded = interfaceC5074l;
    }

    public static final Comparable i(ChatMessage chatMessage) {
        return Long.valueOf(chatMessage.getTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable n(ChatMessage chatMessage) {
        return chatMessage.getMessageId();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$loadMoreTopConversationMessages$1(this.this$0, this.$beforeTime, this.$beforeMessageId, this.$limit, this.$onLoaded, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$loadMoreTopConversationMessages$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<ChatMessage> listG1;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Set setG0 = this.this$0.g0();
        if (setG0.isEmpty()) {
            listG1 = C1173v.m();
        } else if (setG0.size() == 1) {
            listG1 = this.this$0.messageRepository.x((String) Z8.F.p0(setG0), this.$beforeTime, this.$beforeMessageId, this.$limit);
        } else {
            AgentSession agentSession = this.this$0;
            long j10 = this.$beforeTime;
            String str = this.$beforeMessageId;
            int i10 = this.$limit;
            ArrayList arrayList = new ArrayList();
            Iterator it = setG0.iterator();
            while (it.hasNext()) {
                Z8.A.E(arrayList, agentSession.messageRepository.x((String) it.next(), j10, str, i10));
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (hashSet.add(((ChatMessage) obj2).getMessageId())) {
                    arrayList2.add(obj2);
                }
            }
            listG1 = Z8.F.g1(Z8.F.c1(arrayList2, b9.b.b(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.u
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return AgentSession$loadMoreTopConversationMessages$1.i((ChatMessage) obj3);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.v
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return AgentSession$loadMoreTopConversationMessages$1.n((ChatMessage) obj3);
                }
            })), this.$limit);
        }
        Function2.b(new AnonymousClass1(this.$onLoaded, listG1, null));
        return Y8.t.f7040a;
    }
}
