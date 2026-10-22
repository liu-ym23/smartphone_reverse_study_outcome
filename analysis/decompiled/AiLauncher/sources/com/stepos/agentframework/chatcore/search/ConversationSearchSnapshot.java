package com.stepos.agentframework.chatcore.search;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatcore/search/a;", "", "", "Lcom/stepos/agentframework/chatcore/search/m;", "sessions", "Lcom/stepos/agentframework/chatcore/search/g;", "messages", "<init>", "(Ljava/util/List;Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Ljava/util/List;)Lcom/stepos/agentframework/chatcore/search/a;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "c", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.search.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ConversationSearchSnapshot {
    private final List<MessageSearchHit> messages;
    private final List<SessionSearchHit> sessions;

    /* JADX WARN: Multi-variable type inference failed */
    public ConversationSearchSnapshot() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationSearchSnapshot b(ConversationSearchSnapshot conversationSearchSnapshot, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = conversationSearchSnapshot.sessions;
        }
        if ((i10 & 2) != 0) {
            list2 = conversationSearchSnapshot.messages;
        }
        return conversationSearchSnapshot.a(list, list2);
    }

    public final ConversationSearchSnapshot a(List<SessionSearchHit> sessions, List<MessageSearchHit> messages) {
        kotlin.jvm.internal.p.i(sessions, "sessions");
        kotlin.jvm.internal.p.i(messages, "messages");
        return new ConversationSearchSnapshot(sessions, messages);
    }

    public final List<MessageSearchHit> c() {
        return this.messages;
    }

    public final List<SessionSearchHit> d() {
        return this.sessions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSearchSnapshot)) {
            return false;
        }
        ConversationSearchSnapshot conversationSearchSnapshot = (ConversationSearchSnapshot) other;
        return kotlin.jvm.internal.p.d(this.sessions, conversationSearchSnapshot.sessions) && kotlin.jvm.internal.p.d(this.messages, conversationSearchSnapshot.messages);
    }

    public int hashCode() {
        return (this.sessions.hashCode() * 31) + this.messages.hashCode();
    }

    public String toString() {
        return "ConversationSearchSnapshot(sessions=" + this.sessions + ", messages=" + this.messages + ")";
    }

    public ConversationSearchSnapshot(List<SessionSearchHit> sessions, List<MessageSearchHit> messages) {
        kotlin.jvm.internal.p.i(sessions, "sessions");
        kotlin.jvm.internal.p.i(messages, "messages");
        this.sessions = sessions;
        this.messages = messages;
    }

    public /* synthetic */ ConversationSearchSnapshot(List list, List list2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? C1173v.m() : list2);
    }
}
