package com.stepos.agentframework.chatcore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.C1963x;
import com.stepos.agentframework.chatcore.session.SessionConfig;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u00192\u00020\u0001:\u0003\u001a\u000b\u0015B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatcore/Configuration;", "Ljava/io/Serializable;", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "sessionConfig", "", "pageSize", "Lcom/stepos/agentframework/chatcore/Configuration$DebugLogConfig;", "debugLogConfig", "<init>", "(Lcom/stepos/agentframework/chatcore/session/SessionConfig;ILcom/stepos/agentframework/chatcore/Configuration$DebugLogConfig;)V", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "setSessionConfig", "(Lcom/stepos/agentframework/chatcore/session/SessionConfig;)V", "I", "getPageSize", "()I", "c", "(I)V", "Lcom/stepos/agentframework/chatcore/Configuration$DebugLogConfig;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/Configuration$DebugLogConfig;", "setDebugLogConfig", "(Lcom/stepos/agentframework/chatcore/Configuration$DebugLogConfig;)V", "Companion", "DebugLogConfig", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Configuration implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPENCLAW_FIXED_AGENT_ID = "agent_id_step_claw";
    private DebugLogConfig debugLogConfig;
    private int pageSize;
    private SessionConfig sessionConfig;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatcore/Configuration$DebugLogConfig;", "Ljava/io/Serializable;", "", "enableChatDebugLog", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DebugLogConfig implements Serializable {
        private boolean enableChatDebugLog;

        public DebugLogConfig() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnableChatDebugLog() {
            return this.enableChatDebugLog;
        }

        public final void b(boolean z10) {
            this.enableChatDebugLog = z10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DebugLogConfig) && this.enableChatDebugLog == ((DebugLogConfig) other).enableChatDebugLog;
        }

        public int hashCode() {
            return Boolean.hashCode(this.enableChatDebugLog);
        }

        public String toString() {
            return "DebugLogConfig(enableChatDebugLog=" + this.enableChatDebugLog + ")";
        }

        public DebugLogConfig(boolean z10) {
            this.enableChatDebugLog = z10;
        }

        public /* synthetic */ DebugLogConfig(boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? false : z10);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatcore/Configuration$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/Configuration;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/Configuration;", "", "agentId", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/Configuration$a;", "agentType", Const.INTENT_KEY_APIKEY, "sessionId", "e", "", "newSession", "c", "(Z)Lcom/stepos/agentframework/chatcore/Configuration$a;", "defaultQuestion", "Ljava/lang/String;", "customContentFilterReplyText", "stream", "Z", "defaultSessionId", "", "pageSize", "I", "enableChatDebugLog", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private String customContentFilterReplyText;
        private String defaultQuestion;
        private boolean enableChatDebugLog;
        private boolean newSession;
        private String agentId = "";
        private boolean stream = true;
        private String agentType = "remote";
        private String defaultSessionId = "";
        private int pageSize = 10;

        public final a a(String agentType) {
            kotlin.jvm.internal.p.i(agentType, "agentType");
            this.agentType = agentType;
            return this;
        }

        public final Configuration b() {
            Configuration configuration = new Configuration(null, 0, null, 7, null);
            configuration.getSessionConfig().z(this.defaultQuestion);
            String str = this.customContentFilterReplyText;
            if (str != null) {
                configuration.getSessionConfig().y(str);
            }
            configuration.getSessionConfig().D(this.stream);
            configuration.getSessionConfig().x(this.agentType);
            configuration.getSessionConfig().w(kotlin.jvm.internal.p.d(this.agentType, C1963x.AGENT_TYPE_OPENCLAW) ? Configuration.OPENCLAW_FIXED_AGENT_ID : this.agentId);
            configuration.getSessionConfig().A(this.defaultSessionId);
            configuration.getSessionConfig().C(this.newSession);
            configuration.c(this.pageSize);
            configuration.getDebugLogConfig().b(this.enableChatDebugLog);
            return configuration;
        }

        public final a c(boolean newSession) {
            this.newSession = newSession;
            return this;
        }

        public final a d(String agentId) {
            kotlin.jvm.internal.p.i(agentId, "agentId");
            this.agentId = agentId;
            return this;
        }

        public final a e(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            this.defaultSessionId = sessionId;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatcore/Configuration$b;", "", "<init>", "()V", "", "agentId", "Lcom/stepos/agentframework/chatcore/Configuration$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/Configuration$a;", "OPENCLAW_FIXED_AGENT_ID", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.Configuration$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final a a(String agentId) {
            kotlin.jvm.internal.p.i(agentId, "agentId");
            a aVar = new a();
            aVar.d(agentId);
            return aVar;
        }

        public Companion() {
        }
    }

    public Configuration() {
        this(null, 0, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final DebugLogConfig getDebugLogConfig() {
        return this.debugLogConfig;
    }

    /* renamed from: b, reason: from getter */
    public final SessionConfig getSessionConfig() {
        return this.sessionConfig;
    }

    public final void c(int i10) {
        this.pageSize = i10;
    }

    public Configuration(SessionConfig sessionConfig, int i10, DebugLogConfig debugLogConfig) {
        kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
        kotlin.jvm.internal.p.i(debugLogConfig, "debugLogConfig");
        this.sessionConfig = sessionConfig;
        this.pageSize = i10;
        this.debugLogConfig = debugLogConfig;
    }

    public /* synthetic */ Configuration(SessionConfig sessionConfig, int i10, DebugLogConfig debugLogConfig, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? new SessionConfig(null, null, 0, 0L, 0L, false, null, false, null, null, null, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 2097151, null) : sessionConfig, (i11 & 2) != 0 ? 10 : i10, (i11 & 4) != 0 ? new DebugLogConfig(false, 1, null) : debugLogConfig);
    }
}
