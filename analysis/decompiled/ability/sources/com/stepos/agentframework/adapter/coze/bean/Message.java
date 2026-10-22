package com.stepos.agentframework.adapter.coze.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/Message;", "", AppAgent.CONSTRUCT, "()V", "role", "", "getRole", "()Ljava/lang/String;", "setRole", "(Ljava/lang/String;)V", "type", "getType", "setType", "content_type", "getContent_type", "setContent_type", "content", "getContent", "setContent", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Message {
    private String content;
    private String role = BffConstant.Role.User;
    private String type = "question";
    private String content_type = "text";

    public final String getContent() {
        return this.content;
    }

    public final String getContent_type() {
        return this.content_type;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getType() {
        return this.type;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setContent_type(String str) {
        k.f(str, "<set-?>");
        this.content_type = str;
    }

    public final void setRole(String str) {
        k.f(str, "<set-?>");
        this.role = str;
    }

    public final void setType(String str) {
        k.f(str, "<set-?>");
        this.type = str;
    }
}
