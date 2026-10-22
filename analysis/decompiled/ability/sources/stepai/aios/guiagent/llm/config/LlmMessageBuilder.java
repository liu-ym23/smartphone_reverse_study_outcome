package stepai.aios.guiagent.llm.config;

import D7.v;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.ToolCall;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lstepai/aios/guiagent/llm/config/LlmMessageBuilder;", "", AppAgent.CONSTRUCT, "()V", "role", "Lstepai/aios/guiagent/llm/MessageRole;", "content", "", "Lstepai/aios/guiagent/llm/MessageContent;", HintConstants.AUTOFILL_HINT_NAME, "", "toolCalls", "", "Lstepai/aios/guiagent/llm/ToolCall;", Key.KEY_TOOL_CALL_ID, "text", "image", "imageUrl", "imageBase64", "base64", "mimeType", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lstepai/aios/guiagent/llm/Message;", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LlmMessageBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String name;
    private String toolCallId;
    private List<ToolCall> toolCalls;
    private MessageRole role = MessageRole.USER;
    private final List<MessageContent> content = new ArrayList();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0007J\u001c\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¨\u0006\u0014"}, d2 = {"Lstepai/aios/guiagent/llm/config/LlmMessageBuilder$Companion;", "", AppAgent.CONSTRUCT, "()V", "system", "Lstepai/aios/guiagent/llm/Message;", "text", "", BffConstant.Role.User, "assistant", AgentCache.AGENT_CACHE_TASK_TYPE_TOOL, Key.KEY_TOOL_CALL_ID, "userWithImage", "imageBase64", "userWithImageOnly", "mimeType", "assistantWithTools", "toolCalls", "", "Lstepai/aios/guiagent/llm/ToolCall;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ Message userWithImageOnly$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "image/jpeg";
            }
            return companion.userWithImageOnly(str, str2);
        }

        public final Message assistant(String text) {
            k.f(text, "text");
            return new LlmMessageBuilder().role(MessageRole.ASSISTANT).text(text).build();
        }

        public final Message assistantWithTools(String text, List<ToolCall> toolCalls) {
            k.f(text, "text");
            k.f(toolCalls, "toolCalls");
            return new LlmMessageBuilder().role(MessageRole.ASSISTANT).text(text).toolCalls(toolCalls).build();
        }

        public final Message system(String text) {
            k.f(text, "text");
            return new LlmMessageBuilder().role(MessageRole.SYSTEM).text(text).build();
        }

        public final Message tool(String text, String toolCallId) {
            k.f(text, "text");
            k.f(toolCallId, "toolCallId");
            return new LlmMessageBuilder().role(MessageRole.TOOL).text(text).toolCallId(toolCallId).build();
        }

        public final Message user(String text) {
            k.f(text, "text");
            return new LlmMessageBuilder().role(MessageRole.USER).text(text).build();
        }

        public final Message userWithImage(String text, String imageBase64) {
            k.f(text, "text");
            k.f(imageBase64, "imageBase64");
            return LlmMessageBuilder.imageBase64$default(new LlmMessageBuilder().role(MessageRole.USER), imageBase64, null, 2, null).text(text).build();
        }

        public final Message userWithImageOnly(String imageBase64, String mimeType) {
            k.f(imageBase64, "imageBase64");
            k.f(mimeType, "mimeType");
            return new LlmMessageBuilder().role(MessageRole.USER).imageBase64(imageBase64, mimeType).build();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ LlmMessageBuilder imageBase64$default(LlmMessageBuilder llmMessageBuilder, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "image/jpeg";
        }
        return llmMessageBuilder.imageBase64(str, str2);
    }

    public final Message build() {
        return new Message(this.role, v.f1(this.content), this.name, this.toolCalls, this.toolCallId, 0L, 32, null);
    }

    public final LlmMessageBuilder image(String imageUrl) {
        k.f(imageUrl, "imageUrl");
        this.content.add(new MessageContent.Image(imageUrl));
        return this;
    }

    public final LlmMessageBuilder imageBase64(String base64, String mimeType) {
        k.f(base64, "base64");
        k.f(mimeType, "mimeType");
        this.content.add(new MessageContent.ImageBase64(base64, mimeType));
        return this;
    }

    public final LlmMessageBuilder name(String name) {
        k.f(name, "name");
        this.name = name;
        return this;
    }

    public final LlmMessageBuilder role(MessageRole role) {
        k.f(role, "role");
        this.role = role;
        return this;
    }

    public final LlmMessageBuilder text(String text) {
        k.f(text, "text");
        this.content.add(new MessageContent.Text(text));
        return this;
    }

    public final LlmMessageBuilder toolCallId(String toolCallId) {
        k.f(toolCallId, "toolCallId");
        this.toolCallId = toolCallId;
        return this;
    }

    public final LlmMessageBuilder toolCalls(List<ToolCall> toolCalls) {
        k.f(toolCalls, "toolCalls");
        this.content.add(new MessageContent.ToolCalls(toolCalls));
        return this;
    }
}
