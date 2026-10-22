package stepai.aios.guiagent.llm;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003JW\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lstepai/aios/guiagent/llm/Message;", "", "role", "Lstepai/aios/guiagent/llm/MessageRole;", "content", "", "Lstepai/aios/guiagent/llm/MessageContent;", HintConstants.AUTOFILL_HINT_NAME, "", "toolCalls", "Lstepai/aios/guiagent/llm/ToolCall;", Key.KEY_TOOL_CALL_ID, "timestamp", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/llm/MessageRole;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;J)V", "getRole", "()Lstepai/aios/guiagent/llm/MessageRole;", "getContent", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getToolCalls", "getToolCallId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Message {
    private final List<MessageContent> content;
    private final String name;
    private final MessageRole role;
    private final long timestamp;
    private final String toolCallId;
    private final List<ToolCall> toolCalls;

    /* JADX WARN: Multi-variable type inference failed */
    public Message(MessageRole role, List<? extends MessageContent> content, String str, List<ToolCall> list, String str2, long j5) {
        k.f(role, "role");
        k.f(content, "content");
        this.role = role;
        this.content = content;
        this.name = str;
        this.toolCalls = list;
        this.toolCallId = str2;
        this.timestamp = j5;
    }

    public static /* synthetic */ Message copy$default(Message message, MessageRole messageRole, List list, String str, List list2, String str2, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            messageRole = message.role;
        }
        if ((i & 2) != 0) {
            list = message.content;
        }
        if ((i & 4) != 0) {
            str = message.name;
        }
        if ((i & 8) != 0) {
            list2 = message.toolCalls;
        }
        if ((i & 16) != 0) {
            str2 = message.toolCallId;
        }
        if ((i & 32) != 0) {
            j5 = message.timestamp;
        }
        long j6 = j5;
        String str3 = str2;
        String str4 = str;
        return message.copy(messageRole, list, str4, list2, str3, j6);
    }

    /* renamed from: component1, reason: from getter */
    public final MessageRole getRole() {
        return this.role;
    }

    public final List<MessageContent> component2() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ToolCall> component4() {
        return this.toolCalls;
    }

    /* renamed from: component5, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Message copy(MessageRole role, List<? extends MessageContent> content, String name, List<ToolCall> toolCalls, String toolCallId, long timestamp) {
        k.f(role, "role");
        k.f(content, "content");
        return new Message(role, content, name, toolCalls, toolCallId, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return this.role == message.role && k.b(this.content, message.content) && k.b(this.name, message.name) && k.b(this.toolCalls, message.toolCalls) && k.b(this.toolCallId, message.toolCallId) && this.timestamp == message.timestamp;
    }

    public final List<MessageContent> getContent() {
        return this.content;
    }

    public final String getName() {
        return this.name;
    }

    public final MessageRole getRole() {
        return this.role;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final List<ToolCall> getToolCalls() {
        return this.toolCalls;
    }

    public int hashCode() {
        int iE = androidx.appfunctions.metadata.a.e(this.content, this.role.hashCode() * 31, 31);
        String str = this.name;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        List<ToolCall> list = this.toolCalls;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.toolCallId;
        return Long.hashCode(this.timestamp) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public String toString() {
        MessageRole messageRole = this.role;
        List<MessageContent> list = this.content;
        String str = this.name;
        List<ToolCall> list2 = this.toolCalls;
        String str2 = this.toolCallId;
        long j5 = this.timestamp;
        StringBuilder sb = new StringBuilder("Message(role=");
        sb.append(messageRole);
        sb.append(", content=");
        sb.append(list);
        sb.append(", name=");
        sb.append(str);
        sb.append(", toolCalls=");
        sb.append(list2);
        sb.append(", toolCallId=");
        B7.a.y(j5, str2, ", timestamp=", sb);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ Message(MessageRole messageRole, List list, String str, List list2, String str2, long j5, int i, e eVar) {
        this(messageRole, list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? System.currentTimeMillis() : j5);
    }
}
