package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$loadLatestTopConversationMessages$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$loadLatestTopConversationMessages$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ InterfaceC5074l<List<ChatMessage>, Y8.t> $onLoaded;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$loadLatestTopConversationMessages$1$3", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$loadLatestTopConversationMessages$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ Ref$ObjectRef<List<ChatMessage>> $messageList;
        final /* synthetic */ InterfaceC5074l<List<ChatMessage>, Y8.t> $onLoaded;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l, Ref$ObjectRef<List<ChatMessage>> ref$ObjectRef, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onLoaded = interfaceC5074l;
            this.$messageList = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(this.$onLoaded, this.$messageList, interfaceC4014c);
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
            this.$onLoaded.invoke(this.$messageList.f34820a);
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((ChatMessage) t10).getTime()), Long.valueOf(((ChatMessage) t11).getTime()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$loadLatestTopConversationMessages$1(AgentSession agentSession, int i10, InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l, InterfaceC4014c<? super AgentSession$loadLatestTopConversationMessages$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$limit = i10;
        this.$onLoaded = interfaceC5074l;
    }

    public static final Comparable i(ChatMessage chatMessage) {
        return Long.valueOf(chatMessage.getTime());
    }

    public static final Comparable n(ChatMessage chatMessage) {
        return chatMessage.getMessageId();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$loadLatestTopConversationMessages$1(this.this$0, this.$limit, this.$onLoaded, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$loadLatestTopConversationMessages$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v26, types: [T, java.util.List] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        T tG1;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Set setG0 = this.this$0.g0();
        Set set = setG0;
        AgentSession agentSession = this.this$0;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                w4.e eVarG = agentSession.conversationTitleRepository.g((String) it.next());
                if (eVarG != null && eVarG.m()) {
                    C4148a.u(this.this$0.TAG, "loadLatestTopConversationMessages refused hidden keys=" + setG0, false, 4, null);
                    this.this$0.y1("reloadMessages");
                    return Y8.t.f7040a;
                }
            }
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (setG0.isEmpty()) {
            tG1 = C1173v.m();
        } else if (setG0.size() == 1) {
            tG1 = this.this$0.messageRepository.l((String) Z8.F.p0(setG0), this.$limit);
        } else {
            AgentSession agentSession2 = this.this$0;
            int i10 = this.$limit;
            ArrayList arrayList = new ArrayList();
            Iterator it2 = setG0.iterator();
            while (it2.hasNext()) {
                Z8.A.E(arrayList, agentSession2.messageRepository.l((String) it2.next(), i10));
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (hashSet.add(((ChatMessage) obj2).getMessageId())) {
                    arrayList2.add(obj2);
                }
            }
            tG1 = Z8.F.g1(Z8.F.c1(arrayList2, b9.b.b(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return AgentSession$loadLatestTopConversationMessages$1.i((ChatMessage) obj3);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return AgentSession$loadLatestTopConversationMessages$1.n((ChatMessage) obj3);
                }
            })), this.$limit);
        }
        ref$ObjectRef.f34820a = tG1;
        ChatMessage stoppedAssistantSnapshot = this.this$0.getTopConversation().getStoppedAssistantSnapshot();
        if (stoppedAssistantSnapshot == null || stoppedAssistantSnapshot.getMessageId().length() <= 0) {
            stoppedAssistantSnapshot = null;
            break;
        }
        Iterable iterable = (Iterable) ref$ObjectRef.f34820a;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it3 = iterable.iterator();
            while (it3.hasNext()) {
                if (kotlin.jvm.internal.p.d(((ChatMessage) it3.next()).getMessageId(), stoppedAssistantSnapshot.getMessageId())) {
                    stoppedAssistantSnapshot = null;
                    break;
                }
            }
        }
        if (stoppedAssistantSnapshot != null) {
            ref$ObjectRef.f34820a = Z8.F.c1(Z8.F.T0((Collection) ref$ObjectRef.f34820a, stoppedAssistantSnapshot), new a());
            this.this$0.getTopConversation().x();
        }
        Function2.b(new AnonymousClass3(this.$onLoaded, ref$ObjectRef, null));
        return Y8.t.f7040a;
    }
}
