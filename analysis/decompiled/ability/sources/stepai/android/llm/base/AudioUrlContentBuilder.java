package stepai.android.llm.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.agentframework.adapter.bff.BffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lstepai/android/llm/base/AudioUrlContentBuilder;", "", AppAgent.CONSTRUCT, "()V", BffConstant.Type.Url, "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lstepai/android/llm/base/LLMRequestAudioUrlContent;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AudioUrlContentBuilder {
    private String url = "";

    public final LLMRequestAudioUrlContent build() {
        return new LLMRequestAudioUrlContent(this.url);
    }

    public final AudioUrlContentBuilder url(String url) {
        k.f(url, "url");
        this.url = url;
        return this;
    }
}
