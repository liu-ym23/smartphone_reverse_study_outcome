package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.PushMessageCenter$foldEarlySubSessionMessages$1", f = "PushMessageCenter.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class PushMessageCenter$foldEarlySubSessionMessages$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ String $requestSessionKey;
    final /* synthetic */ String $subSessionKey;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((ChatMessage) t10).getTime()), Long.valueOf(((ChatMessage) t11).getTime()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushMessageCenter$foldEarlySubSessionMessages$1(String str, String str2, String str3, String str4, InterfaceC4014c<? super PushMessageCenter$foldEarlySubSessionMessages$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$subSessionKey = str;
        this.$agentId = str2;
        this.$requestSessionKey = str3;
        this.$taskId = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PushMessageCenter$foldEarlySubSessionMessages$1 pushMessageCenter$foldEarlySubSessionMessages$1 = new PushMessageCenter$foldEarlySubSessionMessages$1(this.$subSessionKey, this.$agentId, this.$requestSessionKey, this.$taskId, interfaceC4014c);
        pushMessageCenter$foldEarlySubSessionMessages$1.L$0 = obj;
        return pushMessageCenter$foldEarlySubSessionMessages$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PushMessageCenter$foldEarlySubSessionMessages$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        String str = this.$subSessionKey;
        String str2 = this.$agentId;
        String str3 = this.$requestSessionKey;
        String str4 = this.$taskId;
        try {
            Result.Companion companion = Result.INSTANCE;
            PushMessageCenter pushMessageCenter = PushMessageCenter.INSTANCE;
            List<ChatMessage> listG = pushMessageCenter.T().g(str);
            if (listG.isEmpty()) {
                pushMessageCenter.S().h(str2, str);
            } else {
                ChatMessage chatMessageQ = pushMessageCenter.Q(str2, str3, str4);
                if (chatMessageQ == null) {
                    C4148a.u("PushMessageCenter", "foldEarly: card not found taskId:" + str4 + " req:" + str3, false, 4, null);
                } else {
                    List listC1 = Z8.F.c1(listG, new a());
                    ArrayList<AgentMessage> arrayList = new ArrayList();
                    Iterator it = listC1.iterator();
                    while (it.hasNext()) {
                        Z8.A.E(arrayList, ((ChatMessage) it.next()).i());
                    }
                    for (AgentMessage agentMessage : arrayList) {
                        if (agentMessage.getType() == AgentMessageType.TOOL) {
                            agentMessage.k(true);
                        }
                    }
                    List<AgentMessage> listI = chatMessageQ.i();
                    PushMessageCenter pushMessageCenter2 = PushMessageCenter.INSTANCE;
                    listI.addAll(pushMessageCenter2.j0(chatMessageQ), arrayList);
                    pushMessageCenter2.T().t(chatMessageQ);
                    Iterator<T> it2 = listG.iterator();
                    while (it2.hasNext()) {
                        PushMessageCenter.INSTANCE.T().q(((ChatMessage) it2.next()).getMessageId());
                    }
                    PushMessageCenter pushMessageCenter3 = PushMessageCenter.INSTANCE;
                    pushMessageCenter3.S().h(str2, str);
                    pushMessageCenter3.N(chatMessageQ);
                    C4148a.k("PushMessageCenter", "folded " + listG.size() + " early sub-session msgs into card taskId:" + str4 + " req:" + str3, false, 4, null);
                }
            }
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("PushMessageCenter", "foldEarlySubSessionMessages failed: " + thE.getMessage(), thE, false, 8, null);
        }
        return Y8.t.f7040a;
    }
}
