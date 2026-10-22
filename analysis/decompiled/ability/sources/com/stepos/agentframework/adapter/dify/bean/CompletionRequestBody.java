package com.stepos.agentframework.adapter.dify.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.util.HashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/CompletionRequestBody;", "", AppAgent.CONSTRUCT, "()V", "inputs", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getInputs", "()Ljava/util/HashMap;", "setInputs", "(Ljava/util/HashMap;)V", "response_mode", "getResponse_mode", "()Ljava/lang/String;", "setResponse_mode", "(Ljava/lang/String;)V", BffConstant.Role.User, "getUser", "setUser", "query", "getQuery", "setQuery", "Companion", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CompletionRequestBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HashMap<String, String> inputs;
    private String query = "";
    private String response_mode;
    private String user;

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ:\u0010\f\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/CompletionRequestBody$Companion;", "", AppAgent.CONSTRUCT, "()V", "inputBlock", "Lcom/stepos/agentframework/adapter/dify/bean/CompletionRequestBody;", "input", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "query", "userId", "inputStreaming", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final CompletionRequestBody inputBlock(HashMap<String, String> input, String query, String userId) {
            k.f(input, "input");
            k.f(query, "query");
            k.f(userId, "userId");
            CompletionRequestBody completionRequestBody = new CompletionRequestBody();
            completionRequestBody.setInputs(input);
            completionRequestBody.setQuery(query);
            completionRequestBody.setUser(userId);
            completionRequestBody.setResponse_mode("blocking");
            return completionRequestBody;
        }

        public final CompletionRequestBody inputStreaming(HashMap<String, String> input, String query, String userId) {
            k.f(input, "input");
            k.f(query, "query");
            k.f(userId, "userId");
            CompletionRequestBody completionRequestBody = new CompletionRequestBody();
            completionRequestBody.setInputs(input);
            completionRequestBody.setQuery(query);
            completionRequestBody.setUser(userId);
            completionRequestBody.setResponse_mode("streaming");
            return completionRequestBody;
        }

        private Companion() {
        }
    }

    public final HashMap<String, String> getInputs() {
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

    public final void setInputs(HashMap<String, String> map) {
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
