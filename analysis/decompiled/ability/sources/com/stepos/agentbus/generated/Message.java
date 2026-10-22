package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006*"}, d2 = {"Lcom/stepos/agentbus/generated/Message;", "", "role", "Lcom/stepos/agentbus/generated/Role;", "content", "", "attachments", "", "Lcom/stepos/agentbus/generated/Attachment;", "toolCalls", "Lcom/stepos/agentbus/generated/ToolCall;", "replyTo", "metadata", "", "delta", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/Role;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getRole", "()Lcom/stepos/agentbus/generated/Role;", "getContent", "()Ljava/lang/String;", "getAttachments", "()Ljava/util/List;", "getToolCalls", "getReplyTo", "getMetadata", "()Ljava/util/Map;", "getDelta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Message {
    private final List<Attachment> attachments;
    private final String content;
    private final String delta;
    private final Map<String, Object> metadata;
    private final String replyTo;
    private final Role role;
    private final List<ToolCall> toolCalls;

    public Message(Role role, String str, List list, List list2, String str2, Map map, String str3, int i, e eVar) {
        this(role, str, (i & 4) != 0 ? EmptyList.f4893a : list, (i & 8) != 0 ? EmptyList.f4893a : list2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? kotlin.collections.a.M() : map, (i & 64) != 0 ? null : str3);
    }

    public static /* synthetic */ Message copy$default(Message message, Role role, String str, List list, List list2, String str2, Map map, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            role = message.role;
        }
        if ((i & 2) != 0) {
            str = message.content;
        }
        if ((i & 4) != 0) {
            list = message.attachments;
        }
        if ((i & 8) != 0) {
            list2 = message.toolCalls;
        }
        if ((i & 16) != 0) {
            str2 = message.replyTo;
        }
        if ((i & 32) != 0) {
            map = message.metadata;
        }
        if ((i & 64) != 0) {
            str3 = message.delta;
        }
        Map map2 = map;
        String str4 = str3;
        String str5 = str2;
        List list3 = list;
        return message.copy(role, str, list3, list2, str5, map2, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final Role getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final List<Attachment> component3() {
        return this.attachments;
    }

    public final List<ToolCall> component4() {
        return this.toolCalls;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReplyTo() {
        return this.replyTo;
    }

    public final Map<String, Object> component6() {
        return this.metadata;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDelta() {
        return this.delta;
    }

    public final Message copy(Role role, String content, List<Attachment> attachments, List<ToolCall> toolCalls, String replyTo, Map<String, ? extends Object> metadata, String delta) {
        k.f(role, "role");
        k.f(content, "content");
        k.f(attachments, "attachments");
        k.f(toolCalls, "toolCalls");
        k.f(metadata, "metadata");
        return new Message(role, content, attachments, toolCalls, replyTo, metadata, delta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return this.role == message.role && k.b(this.content, message.content) && k.b(this.attachments, message.attachments) && k.b(this.toolCalls, message.toolCalls) && k.b(this.replyTo, message.replyTo) && k.b(this.metadata, message.metadata) && k.b(this.delta, message.delta);
    }

    public final List<Attachment> getAttachments() {
        return this.attachments;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDelta() {
        return this.delta;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getReplyTo() {
        return this.replyTo;
    }

    public final Role getRole() {
        return this.role;
    }

    public final List<ToolCall> getToolCalls() {
        return this.toolCalls;
    }

    public int hashCode() {
        int iE = androidx.appfunctions.metadata.a.e(this.toolCalls, androidx.appfunctions.metadata.a.e(this.attachments, B7.a.c(this.role.hashCode() * 31, 31, this.content), 31), 31);
        String str = this.replyTo;
        int iF = androidx.appfunctions.metadata.a.f(this.metadata, (iE + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.delta;
        return iF + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        Role role = this.role;
        String str = this.content;
        List<Attachment> list = this.attachments;
        List<ToolCall> list2 = this.toolCalls;
        String str2 = this.replyTo;
        Map<String, Object> map = this.metadata;
        String str3 = this.delta;
        StringBuilder sb = new StringBuilder("Message(role=");
        sb.append(role);
        sb.append(", content=");
        sb.append(str);
        sb.append(", attachments=");
        sb.append(list);
        sb.append(", toolCalls=");
        sb.append(list2);
        sb.append(", replyTo=");
        sb.append(str2);
        sb.append(", metadata=");
        sb.append(map);
        sb.append(", delta=");
        return B7.a.q(sb, str3, ")");
    }

    public Message(Role role, String content, List<Attachment> attachments, List<ToolCall> toolCalls, String str, Map<String, ? extends Object> metadata, String str2) {
        k.f(role, "role");
        k.f(content, "content");
        k.f(attachments, "attachments");
        k.f(toolCalls, "toolCalls");
        k.f(metadata, "metadata");
        this.role = role;
        this.content = content;
        this.attachments = attachments;
        this.toolCalls = toolCalls;
        this.replyTo = str;
        this.metadata = metadata;
        this.delta = str2;
    }
}
