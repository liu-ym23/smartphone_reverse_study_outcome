package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import u4.AgentMessage;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/chatcore/session/x0;", "", "Lcom/stepos/agentframework/chatcore/session/ChatRound;", "round", "", "Lu4/a;", "messages", "", "deepThinking", "", "", "meta", "<init>", "(Lcom/stepos/agentframework/chatcore/session/ChatRound;Ljava/util/List;ZLjava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/session/ChatRound;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/chatcore/session/ChatRound;", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Z", Const.INTENT_KEY_APIKEY, "()Z", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.x0, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class PendingSend {
    private final boolean deepThinking;
    private final List<AgentMessage> messages;
    private final Map<String, String> meta;
    private final ChatRound round;

    public PendingSend(ChatRound round, List<AgentMessage> messages, boolean z10, Map<String, String> map) {
        kotlin.jvm.internal.p.i(round, "round");
        kotlin.jvm.internal.p.i(messages, "messages");
        this.round = round;
        this.messages = messages;
        this.deepThinking = z10;
        this.meta = map;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDeepThinking() {
        return this.deepThinking;
    }

    public final List<AgentMessage> b() {
        return this.messages;
    }

    public final Map<String, String> c() {
        return this.meta;
    }

    /* renamed from: d, reason: from getter */
    public final ChatRound getRound() {
        return this.round;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingSend)) {
            return false;
        }
        PendingSend pendingSend = (PendingSend) other;
        return kotlin.jvm.internal.p.d(this.round, pendingSend.round) && kotlin.jvm.internal.p.d(this.messages, pendingSend.messages) && this.deepThinking == pendingSend.deepThinking && kotlin.jvm.internal.p.d(this.meta, pendingSend.meta);
    }

    public int hashCode() {
        int iHashCode = ((((this.round.hashCode() * 31) + this.messages.hashCode()) * 31) + Boolean.hashCode(this.deepThinking)) * 31;
        Map<String, String> map = this.meta;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "PendingSend(round=" + this.round + ", messages=" + this.messages + ", deepThinking=" + this.deepThinking + ", meta=" + this.meta + ")";
    }
}
