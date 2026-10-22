package com.stepos.agentframework.chatcore.session;

import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR'\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/q0;", "", "<init>", "()V", "", "Lw4/c;", "messages", "k", "(Ljava/util/List;)Ljava/util/List;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "COMPARATOR", "Ljava/util/Comparator;", "getCOMPARATOR", "()Ljava/util/Comparator;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.q0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1951q0 {
    public static final C1951q0 INSTANCE = new C1951q0();
    private static final Comparator<ChatMessage> COMPARATOR = b9.b.b(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.l0
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return C1951q0.f((ChatMessage) obj);
        }
    }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.m0
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return C1951q0.g((ChatMessage) obj);
        }
    }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.n0
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return C1951q0.h((ChatMessage) obj);
        }
    }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.o0
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return C1951q0.i((ChatMessage) obj);
        }
    }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.p0
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return C1951q0.j((ChatMessage) obj);
        }
    });

    public static final Comparable f(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Long.valueOf(it.getTime());
    }

    public static final Comparable g(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getPairId();
    }

    public static final Comparable h(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Integer.valueOf(C1952r0.c(it.getRole()));
    }

    public static final Comparable i(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        AgentMessage agentMessage = (AgentMessage) Z8.F.s0(it.i());
        return Integer.valueOf(C1952r0.d(agentMessage != null ? agentMessage.getType() : null));
    }

    public static final Comparable j(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getMessageId();
    }

    public final List<ChatMessage> k(List<ChatMessage> messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        return messages.size() < 2 ? messages : Z8.F.c1(messages, COMPARATOR);
    }
}
