package com.stepos.agentframework.adapter.dify.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/ChatRequestBody;", "", AppAgent.CONSTRUCT, "()V", "response_mode", "", "getResponse_mode", "()Ljava/lang/String;", "setResponse_mode", "(Ljava/lang/String;)V", "conversation_id", "getConversation_id", "setConversation_id", "query", "getQuery", "setQuery", BffConstant.Role.User, "getUser", "setUser", "inputs", "", "getInputs", "()Ljava/util/Map;", "setInputs", "(Ljava/util/Map;)V", "Companion", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatRequestBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<String, String> inputs;
    private String response_mode;
    private String user;
    private String conversation_id = "";
    private String query = "";

    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ4\u0010\f\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/ChatRequestBody$Companion;", "", AppAgent.CONSTRUCT, "()V", "inputBlock", "Lcom/stepos/agentframework/adapter/dify/bean/ChatRequestBody;", "input", "", "", "query", "conversationId", "userId", "inputStreaming", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ChatRequestBody inputBlock(Map<String, String> input, String query, String conversationId, String userId) {
            k.f(query, "query");
            k.f(conversationId, "conversationId");
            k.f(userId, "userId");
            ChatRequestBody chatRequestBody = new ChatRequestBody();
            chatRequestBody.setInputs(input);
            chatRequestBody.setQuery(query);
            chatRequestBody.setUser(userId);
            chatRequestBody.setResponse_mode("blocking");
            chatRequestBody.setConversation_id(conversationId);
            return chatRequestBody;
        }

        public final ChatRequestBody inputStreaming(Map<String, String> input, String query, String conversationId, String userId) {
            k.f(query, "query");
            k.f(conversationId, "conversationId");
            k.f(userId, "userId");
            ChatRequestBody chatRequestBody = new ChatRequestBody();
            chatRequestBody.setInputs(input);
            chatRequestBody.setQuery(query);
            chatRequestBody.setUser(userId);
            chatRequestBody.setResponse_mode("streaming");
            chatRequestBody.setConversation_id(conversationId);
            return chatRequestBody;
        }

        private Companion() {
        }
    }

    public final String getConversation_id() {
        return this.conversation_id;
    }

    public final Map<String, String> getInputs() {
        return this.inputs;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getResponse_mode() {
        return this.response_mode;
    }

    public final String getUser() {
        return this.user;
    }

    public final void setConversation_id(String str) {
        this.conversation_id = str;
    }

    public final void setInputs(Map<String, String> map) {
        this.inputs = map;
    }

    public final void setQuery(String str) {
        this.query = str;
    }

    public final void setResponse_mode(String str) {
        this.response_mode = str;
    }

    public final void setUser(String str) {
        this.user = str;
    }
}
