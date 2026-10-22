package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;
import u4.AgentModeration;
import u4.AgentTask;
import u4.AgentTaskComplete;
import u4.AgentTaskError;
import u4.AgentTaskPlan;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0018\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u0007\u001c\u001d\u001e\u001f R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0018!\"#$%&'()*+,-./012345678¨\u00069À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0;", "", "", "getSessionId", "()Ljava/lang/String;", "sessionId", "", Const.INTENT_KEY_APIKEY, "()J", "at", "l", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "x", "s", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "e", "c", "v", "w", "t", "u", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "o", "r", "n", "q", "p", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "Lcom/stepos/agentframework/chatcore/session/L0$a;", "Lcom/stepos/agentframework/chatcore/session/L0$b;", "Lcom/stepos/agentframework/chatcore/session/L0$c;", "Lcom/stepos/agentframework/chatcore/session/L0$d;", "Lcom/stepos/agentframework/chatcore/session/L0$e;", "Lcom/stepos/agentframework/chatcore/session/L0$f;", "Lcom/stepos/agentframework/chatcore/session/L0$g;", "Lcom/stepos/agentframework/chatcore/session/L0$h;", "Lcom/stepos/agentframework/chatcore/session/L0$i;", "Lcom/stepos/agentframework/chatcore/session/L0$j;", "Lcom/stepos/agentframework/chatcore/session/L0$k;", "Lcom/stepos/agentframework/chatcore/session/L0$l;", "Lcom/stepos/agentframework/chatcore/session/L0$m;", "Lcom/stepos/agentframework/chatcore/session/L0$n;", "Lcom/stepos/agentframework/chatcore/session/L0$o;", "Lcom/stepos/agentframework/chatcore/session/L0$p;", "Lcom/stepos/agentframework/chatcore/session/L0$q;", "Lcom/stepos/agentframework/chatcore/session/L0$r;", "Lcom/stepos/agentframework/chatcore/session/L0$s;", "Lcom/stepos/agentframework/chatcore/session/L0$t;", "Lcom/stepos/agentframework/chatcore/session/L0$u;", "Lcom/stepos/agentframework/chatcore/session/L0$v;", "Lcom/stepos/agentframework/chatcore/session/L0$w;", "Lcom/stepos/agentframework/chatcore/session/L0$x;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface L0 {
    /* renamed from: a */
    long getAt();

    String getSessionId();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$a;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "", "at", "<init>", "(Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$a, reason: from toString */
    public static final /* data */ class COTCollapseEvent implements L0 {
        private final long at;
        private final String sessionId;

        public COTCollapseEvent(String str, long j10) {
            this.sessionId = str;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof COTCollapseEvent)) {
                return false;
            }
            COTCollapseEvent cOTCollapseEvent = (COTCollapseEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, cOTCollapseEvent.sessionId) && this.at == cOTCollapseEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "COTCollapseEvent(sessionId=" + this.sessionId + ", at=" + this.at + ")";
        }

        public /* synthetic */ COTCollapseEvent(String str, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$d;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "", "at", "<init>", "(Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$d, reason: from toString */
    public static final /* data */ class ConversationMessagesCleared implements L0 {
        private final long at;
        private final String sessionId;

        public ConversationMessagesCleared(String str, long j10) {
            this.sessionId = str;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationMessagesCleared)) {
                return false;
            }
            ConversationMessagesCleared conversationMessagesCleared = (ConversationMessagesCleared) other;
            return kotlin.jvm.internal.p.d(this.sessionId, conversationMessagesCleared.sessionId) && this.at == conversationMessagesCleared.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ConversationMessagesCleared(sessionId=" + this.sessionId + ", at=" + this.at + ")";
        }

        public /* synthetic */ ConversationMessagesCleared(String str, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$c;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lw4/e;", "title", "", "at", "<init>", "(Ljava/lang/String;Lw4/e;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lw4/e;", Const.INTENT_KEY_PKGNAME, "()Lw4/e;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$c, reason: from toString */
    public static final /* data */ class ConversationDeleted implements L0 {
        private final long at;
        private final String sessionId;
        private final w4.e title;

        public ConversationDeleted(String str, w4.e eVar, long j10) {
            this.sessionId = str;
            this.title = eVar;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final w4.e getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationDeleted)) {
                return false;
            }
            ConversationDeleted conversationDeleted = (ConversationDeleted) other;
            return kotlin.jvm.internal.p.d(this.sessionId, conversationDeleted.sessionId) && kotlin.jvm.internal.p.d(this.title, conversationDeleted.title) && this.at == conversationDeleted.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            w4.e eVar = this.title;
            return ((iHashCode + (eVar != null ? eVar.hashCode() : 0)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ConversationDeleted(sessionId=" + this.sessionId + ", title=" + this.title + ", at=" + this.at + ")";
        }

        public /* synthetic */ ConversationDeleted(String str, w4.e eVar, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, eVar, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$e;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lw4/e;", "title", "", "at", "<init>", "(Ljava/lang/String;Lw4/e;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lw4/e;", Const.INTENT_KEY_PKGNAME, "()Lw4/e;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$e, reason: from toString */
    public static final /* data */ class ConversationNameChanged implements L0 {
        private final long at;
        private final String sessionId;
        private final w4.e title;

        public ConversationNameChanged(String str, w4.e eVar, long j10) {
            this.sessionId = str;
            this.title = eVar;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final w4.e getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationNameChanged)) {
                return false;
            }
            ConversationNameChanged conversationNameChanged = (ConversationNameChanged) other;
            return kotlin.jvm.internal.p.d(this.sessionId, conversationNameChanged.sessionId) && kotlin.jvm.internal.p.d(this.title, conversationNameChanged.title) && this.at == conversationNameChanged.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            w4.e eVar = this.title;
            return ((iHashCode + (eVar != null ? eVar.hashCode() : 0)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ConversationNameChanged(sessionId=" + this.sessionId + ", title=" + this.title + ", at=" + this.at + ")";
        }

        public /* synthetic */ ConversationNameChanged(String str, w4.e eVar, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, eVar, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$g;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "", "startAtMs", "at", "<init>", "(Ljava/lang/String;JJ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "J", Const.INTENT_KEY_PKGNAME, "()J", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$g, reason: from toString */
    public static final /* data */ class CotTimingStart implements L0 {
        private final long at;
        private final String sessionId;
        private final long startAtMs;

        public CotTimingStart(String str, long j10, long j11) {
            this.sessionId = str;
            this.startAtMs = j10;
            this.at = j11;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final long getStartAtMs() {
            return this.startAtMs;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CotTimingStart)) {
                return false;
            }
            CotTimingStart cotTimingStart = (CotTimingStart) other;
            return kotlin.jvm.internal.p.d(this.sessionId, cotTimingStart.sessionId) && this.startAtMs == cotTimingStart.startAtMs && this.at == cotTimingStart.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.startAtMs)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "CotTimingStart(sessionId=" + this.sessionId + ", startAtMs=" + this.startAtMs + ", at=" + this.at + ")";
        }

        public /* synthetic */ CotTimingStart(String str, long j10, long j11, int i10, kotlin.jvm.internal.i iVar) {
            this(str, j10, (i10 & 4) != 0 ? System.currentTimeMillis() : j11);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$h;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "", "elapsedMs", "at", "<init>", "(Ljava/lang/String;JJ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "J", Const.INTENT_KEY_PKGNAME, "()J", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$h, reason: from toString */
    public static final /* data */ class CotTimingTick implements L0 {
        private final long at;
        private final long elapsedMs;
        private final String sessionId;

        public CotTimingTick(String str, long j10, long j11) {
            this.sessionId = str;
            this.elapsedMs = j10;
            this.at = j11;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final long getElapsedMs() {
            return this.elapsedMs;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CotTimingTick)) {
                return false;
            }
            CotTimingTick cotTimingTick = (CotTimingTick) other;
            return kotlin.jvm.internal.p.d(this.sessionId, cotTimingTick.sessionId) && this.elapsedMs == cotTimingTick.elapsedMs && this.at == cotTimingTick.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.elapsedMs)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "CotTimingTick(sessionId=" + this.sessionId + ", elapsedMs=" + this.elapsedMs + ", at=" + this.at + ")";
        }

        public /* synthetic */ CotTimingTick(String str, long j10, long j11, int i10, kotlin.jvm.internal.i iVar) {
            this(str, j10, (i10 & 4) != 0 ? System.currentTimeMillis() : j11);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$i;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "error", "", "at", "<init>", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/AgentError;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lcom/stepos/agentframework/chatcore/session/AgentError;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/session/AgentError;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$i, reason: from toString */
    public static final /* data */ class ErrorEvent implements L0 {
        private final long at;
        private final AgentError error;
        private final String sessionId;

        public ErrorEvent(String str, AgentError error, long j10) {
            kotlin.jvm.internal.p.i(error, "error");
            this.sessionId = str;
            this.error = error;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final AgentError getError() {
            return this.error;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorEvent)) {
                return false;
            }
            ErrorEvent errorEvent = (ErrorEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, errorEvent.sessionId) && kotlin.jvm.internal.p.d(this.error, errorEvent.error) && this.at == errorEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.error.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ErrorEvent(sessionId=" + this.sessionId + ", error=" + this.error + ", at=" + this.at + ")";
        }

        public /* synthetic */ ErrorEvent(String str, AgentError agentError, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, agentError, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$j;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lw4/c;", "message", "", "at", "<init>", "(Ljava/lang/String;Lw4/c;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lw4/c;", Const.INTENT_KEY_PKGNAME, "()Lw4/c;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$j, reason: from toString */
    public static final /* data */ class MessageRemove implements L0 {
        private final long at;
        private final ChatMessage message;
        private final String sessionId;

        public MessageRemove(String str, ChatMessage message, long j10) {
            kotlin.jvm.internal.p.i(message, "message");
            this.sessionId = str;
            this.message = message;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final ChatMessage getMessage() {
            return this.message;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageRemove)) {
                return false;
            }
            MessageRemove messageRemove = (MessageRemove) other;
            return kotlin.jvm.internal.p.d(this.sessionId, messageRemove.sessionId) && kotlin.jvm.internal.p.d(this.message, messageRemove.message) && this.at == messageRemove.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "MessageRemove(sessionId=" + this.sessionId + ", message=" + this.message + ", at=" + this.at + ")";
        }

        public /* synthetic */ MessageRemove(String str, ChatMessage chatMessage, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, chatMessage, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$l;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lw4/c;", "message", "", "at", "<init>", "(Ljava/lang/String;Lw4/c;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lw4/c;", Const.INTENT_KEY_PKGNAME, "()Lw4/c;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$l, reason: from toString */
    public static final /* data */ class MessageUpsert implements L0 {
        private final long at;
        private final ChatMessage message;
        private final String sessionId;

        public MessageUpsert(String str, ChatMessage message, long j10) {
            kotlin.jvm.internal.p.i(message, "message");
            this.sessionId = str;
            this.message = message;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final ChatMessage getMessage() {
            return this.message;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageUpsert)) {
                return false;
            }
            MessageUpsert messageUpsert = (MessageUpsert) other;
            return kotlin.jvm.internal.p.d(this.sessionId, messageUpsert.sessionId) && kotlin.jvm.internal.p.d(this.message, messageUpsert.message) && this.at == messageUpsert.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "MessageUpsert(sessionId=" + this.sessionId + ", message=" + this.message + ", at=" + this.at + ")";
        }

        public /* synthetic */ MessageUpsert(String str, ChatMessage chatMessage, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, chatMessage, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$n;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lcom/stepos/agentframework/chatcore/session/TalkPhase;", "phase", "", "at", "<init>", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/TalkPhase;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lcom/stepos/agentframework/chatcore/session/TalkPhase;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/session/TalkPhase;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$n, reason: from toString */
    public static final /* data */ class NetworkToastEvent implements L0 {
        private final long at;
        private final TalkPhase phase;
        private final String sessionId;

        public NetworkToastEvent(String str, TalkPhase phase, long j10) {
            kotlin.jvm.internal.p.i(phase, "phase");
            this.sessionId = str;
            this.phase = phase;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final TalkPhase getPhase() {
            return this.phase;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkToastEvent)) {
                return false;
            }
            NetworkToastEvent networkToastEvent = (NetworkToastEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, networkToastEvent.sessionId) && this.phase == networkToastEvent.phase && this.at == networkToastEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.phase.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "NetworkToastEvent(sessionId=" + this.sessionId + ", phase=" + this.phase + ", at=" + this.at + ")";
        }

        public /* synthetic */ NetworkToastEvent(String str, TalkPhase talkPhase, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, talkPhase, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$p;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "reason", "", "at", "<init>", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ReconnectReason;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$p, reason: from toString */
    public static final /* data */ class ReconnectPromptDismissEvent implements L0 {
        private final long at;
        private final ReconnectReason reason;
        private final String sessionId;

        public ReconnectPromptDismissEvent(String str, ReconnectReason reconnectReason, long j10) {
            this.sessionId = str;
            this.reason = reconnectReason;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final ReconnectReason getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReconnectPromptDismissEvent)) {
                return false;
            }
            ReconnectPromptDismissEvent reconnectPromptDismissEvent = (ReconnectPromptDismissEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, reconnectPromptDismissEvent.sessionId) && this.reason == reconnectPromptDismissEvent.reason && this.at == reconnectPromptDismissEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            ReconnectReason reconnectReason = this.reason;
            return ((iHashCode + (reconnectReason != null ? reconnectReason.hashCode() : 0)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ReconnectPromptDismissEvent(sessionId=" + this.sessionId + ", reason=" + this.reason + ", at=" + this.at + ")";
        }

        public /* synthetic */ ReconnectPromptDismissEvent(String str, ReconnectReason reconnectReason, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? null : reconnectReason, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$t;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lu4/f;", "task", "", "at", "<init>", "(Ljava/lang/String;Lu4/f;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lu4/f;", Const.INTENT_KEY_PKGNAME, "()Lu4/f;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$t, reason: from toString */
    public static final /* data */ class TaskCompleteEvent implements L0 {
        private final long at;
        private final String sessionId;
        private final AgentTaskComplete task;

        public TaskCompleteEvent(String str, AgentTaskComplete task, long j10) {
            kotlin.jvm.internal.p.i(task, "task");
            this.sessionId = str;
            this.task = task;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final AgentTaskComplete getTask() {
            return this.task;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskCompleteEvent)) {
                return false;
            }
            TaskCompleteEvent taskCompleteEvent = (TaskCompleteEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, taskCompleteEvent.sessionId) && kotlin.jvm.internal.p.d(this.task, taskCompleteEvent.task) && this.at == taskCompleteEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.task.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "TaskCompleteEvent(sessionId=" + this.sessionId + ", task=" + this.task + ", at=" + this.at + ")";
        }

        public /* synthetic */ TaskCompleteEvent(String str, AgentTaskComplete agentTaskComplete, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, agentTaskComplete, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$u;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lu4/g;", "task", "", "at", "<init>", "(Ljava/lang/String;Lu4/g;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lu4/g;", Const.INTENT_KEY_PKGNAME, "()Lu4/g;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$u, reason: from toString */
    public static final /* data */ class TaskFailedEvent implements L0 {
        private final long at;
        private final String sessionId;
        private final AgentTaskError task;

        public TaskFailedEvent(String str, AgentTaskError task, long j10) {
            kotlin.jvm.internal.p.i(task, "task");
            this.sessionId = str;
            this.task = task;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final AgentTaskError getTask() {
            return this.task;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskFailedEvent)) {
                return false;
            }
            TaskFailedEvent taskFailedEvent = (TaskFailedEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, taskFailedEvent.sessionId) && kotlin.jvm.internal.p.d(this.task, taskFailedEvent.task) && this.at == taskFailedEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.task.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "TaskFailedEvent(sessionId=" + this.sessionId + ", task=" + this.task + ", at=" + this.at + ")";
        }

        public /* synthetic */ TaskFailedEvent(String str, AgentTaskError agentTaskError, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, agentTaskError, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$v;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lu4/i;", "taskPlan", "", "at", "<init>", "(Ljava/lang/String;Lu4/i;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lu4/i;", Const.INTENT_KEY_PKGNAME, "()Lu4/i;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$v, reason: from toString */
    public static final /* data */ class TaskPlanEvent implements L0 {
        private final long at;
        private final String sessionId;
        private final AgentTaskPlan taskPlan;

        public TaskPlanEvent(String str, AgentTaskPlan taskPlan, long j10) {
            kotlin.jvm.internal.p.i(taskPlan, "taskPlan");
            this.sessionId = str;
            this.taskPlan = taskPlan;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final AgentTaskPlan getTaskPlan() {
            return this.taskPlan;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskPlanEvent)) {
                return false;
            }
            TaskPlanEvent taskPlanEvent = (TaskPlanEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, taskPlanEvent.sessionId) && kotlin.jvm.internal.p.d(this.taskPlan, taskPlanEvent.taskPlan) && this.at == taskPlanEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.taskPlan.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "TaskPlanEvent(sessionId=" + this.sessionId + ", taskPlan=" + this.taskPlan + ", at=" + this.at + ")";
        }

        public /* synthetic */ TaskPlanEvent(String str, AgentTaskPlan agentTaskPlan, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, agentTaskPlan, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$w;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lu4/e;", "task", "", "at", "<init>", "(Ljava/lang/String;Lu4/e;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lu4/e;", Const.INTENT_KEY_PKGNAME, "()Lu4/e;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$w, reason: from toString */
    public static final /* data */ class TaskUpdateEvent implements L0 {
        private final long at;
        private final String sessionId;
        private final AgentTask task;

        public TaskUpdateEvent(String str, AgentTask task, long j10) {
            kotlin.jvm.internal.p.i(task, "task");
            this.sessionId = str;
            this.task = task;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final AgentTask getTask() {
            return this.task;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskUpdateEvent)) {
                return false;
            }
            TaskUpdateEvent taskUpdateEvent = (TaskUpdateEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, taskUpdateEvent.sessionId) && kotlin.jvm.internal.p.d(this.task, taskUpdateEvent.task) && this.at == taskUpdateEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.task.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "TaskUpdateEvent(sessionId=" + this.sessionId + ", task=" + this.task + ", at=" + this.at + ")";
        }

        public /* synthetic */ TaskUpdateEvent(String str, AgentTask agentTask, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, agentTask, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$x;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lw4/c;", "message", "", "at", "<init>", "(Ljava/lang/String;Lw4/c;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lw4/c;", Const.INTENT_KEY_PKGNAME, "()Lw4/c;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$x, reason: from toString */
    public static final /* data */ class ToolMessageUpsert implements L0 {
        private final long at;
        private final ChatMessage message;
        private final String sessionId;

        public ToolMessageUpsert(String str, ChatMessage message, long j10) {
            kotlin.jvm.internal.p.i(message, "message");
            this.sessionId = str;
            this.message = message;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final ChatMessage getMessage() {
            return this.message;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolMessageUpsert)) {
                return false;
            }
            ToolMessageUpsert toolMessageUpsert = (ToolMessageUpsert) other;
            return kotlin.jvm.internal.p.d(this.sessionId, toolMessageUpsert.sessionId) && kotlin.jvm.internal.p.d(this.message, toolMessageUpsert.message) && this.at == toolMessageUpsert.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ToolMessageUpsert(sessionId=" + this.sessionId + ", message=" + this.message + ", at=" + this.at + ")";
        }

        public /* synthetic */ ToolMessageUpsert(String str, ChatMessage chatMessage, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, chatMessage, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$b;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lw4/e;", "title", "", "Lw4/c;", "messages", "", "at", "<init>", "(Ljava/lang/String;Lw4/e;Ljava/util/List;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lw4/e;", "c", "()Lw4/e;", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$b, reason: from toString */
    public static final /* data */ class ConversationChanged implements L0 {
        private final long at;
        private final List<ChatMessage> messages;
        private final String sessionId;
        private final w4.e title;

        public ConversationChanged(String str, w4.e eVar, List<ChatMessage> messages, long j10) {
            kotlin.jvm.internal.p.i(messages, "messages");
            this.sessionId = str;
            this.title = eVar;
            this.messages = messages;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        public final List<ChatMessage> b() {
            return this.messages;
        }

        /* renamed from: c, reason: from getter */
        public final w4.e getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationChanged)) {
                return false;
            }
            ConversationChanged conversationChanged = (ConversationChanged) other;
            return kotlin.jvm.internal.p.d(this.sessionId, conversationChanged.sessionId) && kotlin.jvm.internal.p.d(this.title, conversationChanged.title) && kotlin.jvm.internal.p.d(this.messages, conversationChanged.messages) && this.at == conversationChanged.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            w4.e eVar = this.title;
            return ((((iHashCode + (eVar != null ? eVar.hashCode() : 0)) * 31) + this.messages.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ConversationChanged(sessionId=" + this.sessionId + ", title=" + this.title + ", messages=" + this.messages + ", at=" + this.at + ")";
        }

        public /* synthetic */ ConversationChanged(String str, w4.e eVar, List list, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, eVar, (i10 & 4) != 0 ? C1173v.m() : list, (i10 & 8) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$f;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "", "durationMs", "", "toolCount", "at", "<init>", "(Ljava/lang/String;JIJ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "J", Const.INTENT_KEY_PKGNAME, "()J", "I", "c", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$f, reason: from toString */
    public static final /* data */ class CotTimingEnd implements L0 {
        private final long at;
        private final long durationMs;
        private final String sessionId;
        private final int toolCount;

        public CotTimingEnd(String str, long j10, int i10, long j11) {
            this.sessionId = str;
            this.durationMs = j10;
            this.toolCount = i10;
            this.at = j11;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: c, reason: from getter */
        public final int getToolCount() {
            return this.toolCount;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CotTimingEnd)) {
                return false;
            }
            CotTimingEnd cotTimingEnd = (CotTimingEnd) other;
            return kotlin.jvm.internal.p.d(this.sessionId, cotTimingEnd.sessionId) && this.durationMs == cotTimingEnd.durationMs && this.toolCount == cotTimingEnd.toolCount && this.at == cotTimingEnd.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.durationMs)) * 31) + Integer.hashCode(this.toolCount)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "CotTimingEnd(sessionId=" + this.sessionId + ", durationMs=" + this.durationMs + ", toolCount=" + this.toolCount + ", at=" + this.at + ")";
        }

        public /* synthetic */ CotTimingEnd(String str, long j10, int i10, long j11, int i11, kotlin.jvm.internal.i iVar) {
            this(str, j10, i10, (i11 & 8) != 0 ? System.currentTimeMillis() : j11);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$o;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "pairId", "", "at", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", Const.INTENT_KEY_PKGNAME, "c", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$o, reason: from toString */
    public static final /* data */ class NoMessageIdResponseEvent implements L0 {
        private final long at;
        private final String content;
        private final String pairId;
        private final String sessionId;

        public NoMessageIdResponseEvent(String str, String content, String pairId, long j10) {
            kotlin.jvm.internal.p.i(content, "content");
            kotlin.jvm.internal.p.i(pairId, "pairId");
            this.sessionId = str;
            this.content = content;
            this.pairId = pairId;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: c, reason: from getter */
        public final String getPairId() {
            return this.pairId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NoMessageIdResponseEvent)) {
                return false;
            }
            NoMessageIdResponseEvent noMessageIdResponseEvent = (NoMessageIdResponseEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, noMessageIdResponseEvent.sessionId) && kotlin.jvm.internal.p.d(this.content, noMessageIdResponseEvent.content) && kotlin.jvm.internal.p.d(this.pairId, noMessageIdResponseEvent.pairId) && this.at == noMessageIdResponseEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + this.content.hashCode()) * 31) + this.pairId.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "NoMessageIdResponseEvent(sessionId=" + this.sessionId + ", content=" + this.content + ", pairId=" + this.pairId + ", at=" + this.at + ")";
        }

        public /* synthetic */ NoMessageIdResponseEvent(String str, String str2, String str3, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$q;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "", "roundAlive", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "reason", "", "at", "<init>", "(Ljava/lang/String;ZLcom/stepos/agentframework/chatcore/session/ReconnectReason;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Z", "c", "()Z", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$q, reason: from toString */
    public static final /* data */ class ReconnectPromptEvent implements L0 {
        private final long at;
        private final ReconnectReason reason;
        private final boolean roundAlive;
        private final String sessionId;

        public ReconnectPromptEvent(String str, boolean z10, ReconnectReason reason, long j10) {
            kotlin.jvm.internal.p.i(reason, "reason");
            this.sessionId = str;
            this.roundAlive = z10;
            this.reason = reason;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final ReconnectReason getReason() {
            return this.reason;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getRoundAlive() {
            return this.roundAlive;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReconnectPromptEvent)) {
                return false;
            }
            ReconnectPromptEvent reconnectPromptEvent = (ReconnectPromptEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, reconnectPromptEvent.sessionId) && this.roundAlive == reconnectPromptEvent.roundAlive && this.reason == reconnectPromptEvent.reason && this.at == reconnectPromptEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.roundAlive)) * 31) + this.reason.hashCode()) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ReconnectPromptEvent(sessionId=" + this.sessionId + ", roundAlive=" + this.roundAlive + ", reason=" + this.reason + ", at=" + this.at + ")";
        }

        public /* synthetic */ ReconnectPromptEvent(String str, boolean z10, ReconnectReason reconnectReason, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? ReconnectReason.NETWORK_FAILED : reconnectReason, (i10 & 8) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$s;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "tempSessionId", "createdSessionId", "sessionId", "", "at", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, "getSessionId", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$s, reason: from toString */
    public static final /* data */ class SessionCreated implements L0 {
        private final long at;
        private final String createdSessionId;
        private final String sessionId;
        private final String tempSessionId;

        public SessionCreated(String str, String createdSessionId, String str2, long j10) {
            kotlin.jvm.internal.p.i(createdSessionId, "createdSessionId");
            this.tempSessionId = str;
            this.createdSessionId = createdSessionId;
            this.sessionId = str2;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final String getCreatedSessionId() {
            return this.createdSessionId;
        }

        /* renamed from: c, reason: from getter */
        public final String getTempSessionId() {
            return this.tempSessionId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionCreated)) {
                return false;
            }
            SessionCreated sessionCreated = (SessionCreated) other;
            return kotlin.jvm.internal.p.d(this.tempSessionId, sessionCreated.tempSessionId) && kotlin.jvm.internal.p.d(this.createdSessionId, sessionCreated.createdSessionId) && kotlin.jvm.internal.p.d(this.sessionId, sessionCreated.sessionId) && this.at == sessionCreated.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.tempSessionId;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.createdSessionId.hashCode()) * 31;
            String str2 = this.sessionId;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "SessionCreated(tempSessionId=" + this.tempSessionId + ", createdSessionId=" + this.createdSessionId + ", sessionId=" + this.sessionId + ", at=" + this.at + ")";
        }

        public /* synthetic */ SessionCreated(String str, String str2, String str3, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, str2, (i10 & 4) != 0 ? str2 : str3, (i10 & 8) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$k;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "oldMessageId", "Lw4/c;", "message", "", "at", "", "isVariantSwitch", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lw4/c;JZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "c", "Lw4/c;", Const.INTENT_KEY_PKGNAME, "()Lw4/c;", "J", Const.INTENT_KEY_APIKEY, "()J", "Z", Const.INTENT_KEY_UMID, "()Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$k, reason: from toString */
    public static final /* data */ class MessageReplace implements L0 {
        private final long at;
        private final boolean isVariantSwitch;
        private final ChatMessage message;
        private final String oldMessageId;
        private final String sessionId;

        public MessageReplace(String str, String oldMessageId, ChatMessage message, long j10, boolean z10) {
            kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
            kotlin.jvm.internal.p.i(message, "message");
            this.sessionId = str;
            this.oldMessageId = oldMessageId;
            this.message = message;
            this.at = j10;
            this.isVariantSwitch = z10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final ChatMessage getMessage() {
            return this.message;
        }

        /* renamed from: c, reason: from getter */
        public final String getOldMessageId() {
            return this.oldMessageId;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsVariantSwitch() {
            return this.isVariantSwitch;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageReplace)) {
                return false;
            }
            MessageReplace messageReplace = (MessageReplace) other;
            return kotlin.jvm.internal.p.d(this.sessionId, messageReplace.sessionId) && kotlin.jvm.internal.p.d(this.oldMessageId, messageReplace.oldMessageId) && kotlin.jvm.internal.p.d(this.message, messageReplace.message) && this.at == messageReplace.at && this.isVariantSwitch == messageReplace.isVariantSwitch;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            return ((((((((str == null ? 0 : str.hashCode()) * 31) + this.oldMessageId.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.at)) * 31) + Boolean.hashCode(this.isVariantSwitch);
        }

        public String toString() {
            return "MessageReplace(sessionId=" + this.sessionId + ", oldMessageId=" + this.oldMessageId + ", message=" + this.message + ", at=" + this.at + ", isVariantSwitch=" + this.isVariantSwitch + ")";
        }

        public /* synthetic */ MessageReplace(String str, String str2, ChatMessage chatMessage, long j10, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, str2, chatMessage, (i10 & 8) != 0 ? System.currentTimeMillis() : j10, (i10 & 16) != 0 ? false : z10);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\rR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$m;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "Lu4/c;", "moderation", "channelMessageId", "idempotencyKey", "", "at", "<init>", "(Ljava/lang/String;Lu4/c;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lu4/c;", "c", "()Lu4/c;", "getChannelMessageId", Const.INTENT_KEY_PKGNAME, "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$m, reason: from toString */
    public static final /* data */ class ModerationEvent implements L0 {
        private final long at;
        private final String channelMessageId;
        private final String idempotencyKey;
        private final AgentModeration moderation;
        private final String sessionId;

        public ModerationEvent(String str, AgentModeration moderation, String str2, String str3, long j10) {
            kotlin.jvm.internal.p.i(moderation, "moderation");
            this.sessionId = str;
            this.moderation = moderation;
            this.channelMessageId = str2;
            this.idempotencyKey = str3;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final String getIdempotencyKey() {
            return this.idempotencyKey;
        }

        /* renamed from: c, reason: from getter */
        public final AgentModeration getModeration() {
            return this.moderation;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModerationEvent)) {
                return false;
            }
            ModerationEvent moderationEvent = (ModerationEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, moderationEvent.sessionId) && kotlin.jvm.internal.p.d(this.moderation, moderationEvent.moderation) && kotlin.jvm.internal.p.d(this.channelMessageId, moderationEvent.channelMessageId) && kotlin.jvm.internal.p.d(this.idempotencyKey, moderationEvent.idempotencyKey) && this.at == moderationEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.moderation.hashCode()) * 31;
            String str2 = this.channelMessageId;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.idempotencyKey;
            return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "ModerationEvent(sessionId=" + this.sessionId + ", moderation=" + this.moderation + ", channelMessageId=" + this.channelMessageId + ", idempotencyKey=" + this.idempotencyKey + ", at=" + this.at + ")";
        }

        public /* synthetic */ ModerationEvent(String str, AgentModeration agentModeration, String str2, String str3, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, agentModeration, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? System.currentTimeMillis() : j10);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\"\u0010\u0010R\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/L0$r;", "Lcom/stepos/agentframework/chatcore/session/L0;", "", "sessionId", "", "messageIds", "", "success", "", "code", "message", "", "at", "<init>", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "Z", "e", "()Z", "Ljava/lang/Integer;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Integer;", "c", "J", Const.INTENT_KEY_APIKEY, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.L0$r, reason: from toString */
    public static final /* data */ class SendAckEvent implements L0 {
        private final long at;
        private final Integer code;
        private final String message;
        private final List<String> messageIds;
        private final String sessionId;
        private final boolean success;

        public SendAckEvent(String str, List<String> messageIds, boolean z10, Integer num, String str2, long j10) {
            kotlin.jvm.internal.p.i(messageIds, "messageIds");
            this.sessionId = str;
            this.messageIds = messageIds;
            this.success = z10;
            this.code = num;
            this.message = str2;
            this.at = j10;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        /* renamed from: a, reason: from getter */
        public long getAt() {
            return this.at;
        }

        /* renamed from: b, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        /* renamed from: c, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final List<String> d() {
            return this.messageIds;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendAckEvent)) {
                return false;
            }
            SendAckEvent sendAckEvent = (SendAckEvent) other;
            return kotlin.jvm.internal.p.d(this.sessionId, sendAckEvent.sessionId) && kotlin.jvm.internal.p.d(this.messageIds, sendAckEvent.messageIds) && this.success == sendAckEvent.success && kotlin.jvm.internal.p.d(this.code, sendAckEvent.code) && kotlin.jvm.internal.p.d(this.message, sendAckEvent.message) && this.at == sendAckEvent.at;
        }

        @Override // com.stepos.agentframework.chatcore.session.L0
        public String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.messageIds.hashCode()) * 31) + Boolean.hashCode(this.success)) * 31;
            Integer num = this.code;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.message;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.at);
        }

        public String toString() {
            return "SendAckEvent(sessionId=" + this.sessionId + ", messageIds=" + this.messageIds + ", success=" + this.success + ", code=" + this.code + ", message=" + this.message + ", at=" + this.at + ")";
        }

        public /* synthetic */ SendAckEvent(String str, List list, boolean z10, Integer num, String str2, long j10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, list, z10, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? System.currentTimeMillis() : j10);
        }
    }
}
