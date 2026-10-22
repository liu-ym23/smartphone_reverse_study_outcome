package stepai.android.llm.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lstepai/android/llm/base/MessageBuilder;", "", AppAgent.CONSTRUCT, "()V", "Lstepai/android/llm/base/Role;", "role", "(Lstepai/android/llm/base/Role;)Lstepai/android/llm/base/MessageBuilder;", "Lkotlin/Function1;", "Lstepai/android/llm/base/ContentBuilder;", "LC7/r;", "init", "content", "(LS7/k;)Lstepai/android/llm/base/MessageBuilder;", "Lstepai/android/llm/base/LLMRequestMessage;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lstepai/android/llm/base/LLMRequestMessage;", "Lstepai/android/llm/base/Role;", "contentBuilder", "Lstepai/android/llm/base/ContentBuilder;", "getContentBuilder$llmbase_release", "()Lstepai/android/llm/base/ContentBuilder;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MessageBuilder {
    private final ContentBuilder contentBuilder = new ContentBuilder();
    private Role role;

    public final LLMRequestMessage build() {
        Role role = this.role;
        if (role != null) {
            return new LLMRequestMessage(role, this.contentBuilder.build());
        }
        k.n("role");
        throw null;
    }

    public final MessageBuilder content(S7.k init) {
        k.f(init, "init");
        init.invoke(this.contentBuilder);
        return this;
    }

    /* renamed from: getContentBuilder$llmbase_release, reason: from getter */
    public final ContentBuilder getContentBuilder() {
        return this.contentBuilder;
    }

    public final MessageBuilder role(Role role) {
        k.f(role, "role");
        this.role = role;
        return this;
    }
}
