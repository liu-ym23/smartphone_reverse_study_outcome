package stepai.android.llm.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lstepai/android/llm/base/SimpleMessageBuilder;", "", AppAgent.CONSTRUCT, "()V", "role", "Lstepai/android/llm/base/Role;", "content", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lstepai/android/llm/base/LLMRequestSimpleMessage;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SimpleMessageBuilder {
    private String content = "";
    private Role role;

    public final LLMRequestSimpleMessage build() {
        Role role = this.role;
        if (role != null) {
            return new LLMRequestSimpleMessage(role, this.content);
        }
        k.n("role");
        throw null;
    }

    public final SimpleMessageBuilder content(String content) {
        k.f(content, "content");
        this.content = content;
        return this;
    }

    public final SimpleMessageBuilder role(Role role) {
        k.f(role, "role");
        this.role = role;
        return this;
    }
}
