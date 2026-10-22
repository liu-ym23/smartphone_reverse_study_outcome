package com.stepos.agentframework.chatui.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatui.DisplayMessage;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\b\u0005*\u0001\r\b\u0000\u0018\u00002\u00020\u0001:\u0002\n\u0010B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore;", "", "", "capacity", "<init>", "(I)V", "Lcom/stepos/agentframework/chatui/N1;", "message", "", "nowMs", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/N1;J)Ljava/lang/Long;", "I", "com/stepos/agentframework/chatui/view/CotHeaderDurationStore$entries$1", "entries", "Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore$entries$1;", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CotHeaderDurationStore {
    private final int capacity;
    private final CotHeaderDurationStore$entries$1 entries;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore$a;", "", "", "startAtMs", "durationMs", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Ljava/lang/Long;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Long;", Const.INTENT_KEY_UMID, "(Ljava/lang/Long;)V", Const.INTENT_KEY_APIKEY, "c", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private Long durationMs;
        private Long startAtMs;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final Long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: b, reason: from getter */
        public final Long getStartAtMs() {
            return this.startAtMs;
        }

        public final void c(Long l10) {
            this.durationMs = l10;
        }

        public final void d(Long l10) {
            this.startAtMs = l10;
        }

        public a(Long l10, Long l11) {
            this.startAtMs = l10;
            this.durationMs = l11;
        }

        public /* synthetic */ a(Long l10, Long l11, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : l11);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore$b;", "", "", "sessionId", "messageId", "pairId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "getMessageId", "getPairId", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.view.CotHeaderDurationStore$b, reason: from toString */
    public static final /* data */ class Key {
        private final String messageId;
        private final String pairId;
        private final String sessionId;

        public Key(String sessionId, String messageId, String pairId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(messageId, "messageId");
            kotlin.jvm.internal.p.i(pairId, "pairId");
            this.sessionId = sessionId;
            this.messageId = messageId;
            this.pairId = pairId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return kotlin.jvm.internal.p.d(this.sessionId, key.sessionId) && kotlin.jvm.internal.p.d(this.messageId, key.messageId) && kotlin.jvm.internal.p.d(this.pairId, key.pairId);
        }

        public int hashCode() {
            return (((this.sessionId.hashCode() * 31) + this.messageId.hashCode()) * 31) + this.pairId.hashCode();
        }

        public String toString() {
            return "Key(sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", pairId=" + this.pairId + ")";
        }
    }

    public CotHeaderDurationStore(int i10) {
        this.capacity = i10;
        this.entries = new CotHeaderDurationStore$entries$1(this);
    }

    public static /* synthetic */ Long c(CotHeaderDurationStore cotHeaderDurationStore, DisplayMessage displayMessage, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = System.currentTimeMillis();
        }
        return cotHeaderDurationStore.b(displayMessage, j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Long b(DisplayMessage message, long nowMs) {
        try {
            kotlin.jvm.internal.p.i(message, "message");
            Long processingDurationMs = message.getProcessingDurationMs();
            Long l10 = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            if (processingDurationMs == null || processingDurationMs.longValue() < 0) {
                processingDurationMs = null;
            }
            if (message.getRole() == AgentRole.ASSISTANT && !La.H.x0(message.getMessageId())) {
                Key key = new Key(message.getSessionId(), message.getMessageId(), message.getPairId());
                a aVar = (a) this.entries.get(key);
                int i10 = 3;
                if (!message.getStatus().isTerminal()) {
                    if ((aVar != null ? aVar.getDurationMs() : null) != null) {
                        return null;
                    }
                    Long lValueOf = Long.valueOf(message.getProcessingStartAtMs());
                    if (lValueOf.longValue() <= 0) {
                        lValueOf = null;
                    }
                    if (lValueOf == null) {
                        lValueOf = aVar != null ? aVar.getStartAtMs() : null;
                        if (lValueOf == null) {
                            lValueOf = Long.valueOf(message.M());
                            if (lValueOf.longValue() <= 0) {
                                lValueOf = null;
                            }
                        }
                    }
                    if (lValueOf != null) {
                        CotHeaderDurationStore$entries$1 cotHeaderDurationStore$entries$1 = this.entries;
                        a aVar2 = cotHeaderDurationStore$entries$1.get(key);
                        if (aVar2 == null) {
                            aVar2 = new a(l10, objArr5 == true ? 1 : 0, i10, objArr4 == true ? 1 : 0);
                            cotHeaderDurationStore$entries$1.put(key, aVar2);
                        }
                        aVar2.d(lValueOf);
                    }
                    return null;
                }
                if (processingDurationMs != null) {
                    CotHeaderDurationStore$entries$1 cotHeaderDurationStore$entries$12 = this.entries;
                    a aVar3 = cotHeaderDurationStore$entries$12.get(key);
                    if (aVar3 == null) {
                        aVar3 = new a(objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0, i10, objArr == true ? 1 : 0);
                        cotHeaderDurationStore$entries$12.put(key, aVar3);
                    }
                    a aVar4 = aVar3;
                    aVar4.c(processingDurationMs);
                    aVar4.d(null);
                    return processingDurationMs;
                }
                if (message.getStatus() != EReplyStatus.CANCELED || message.getHint() != ChatHintType.STOPPED) {
                    if (aVar != null) {
                        aVar.d(null);
                    }
                    return null;
                }
                if (aVar == null) {
                    return null;
                }
                if (aVar.getDurationMs() == null) {
                    Long startAtMs = aVar.getStartAtMs();
                    aVar.c(startAtMs != null ? Long.valueOf(C5685n.g(nowMs - startAtMs.longValue(), 0L)) : null);
                }
                aVar.d(null);
                return aVar.getDurationMs();
            }
            return processingDurationMs;
        } finally {
        }
    }

    public /* synthetic */ CotHeaderDurationStore(int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 128 : i10);
    }
}
