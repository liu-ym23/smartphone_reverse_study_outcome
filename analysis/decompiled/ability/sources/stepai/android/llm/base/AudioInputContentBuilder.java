package stepai.android.llm.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lstepai/android/llm/base/AudioInputContentBuilder;", "", AppAgent.CONSTRUCT, "()V", SettingsConfig.KEY_DATA, "", "format", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lstepai/android/llm/base/LLMRequestAudioInputContent;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AudioInputContentBuilder {
    private String data = "";
    private String format = "";

    public final LLMRequestAudioInputContent build() {
        return new LLMRequestAudioInputContent(this.data, this.format);
    }

    public final AudioInputContentBuilder data(String data) {
        k.f(data, "data");
        this.data = data;
        return this;
    }

    public final AudioInputContentBuilder format(String format) {
        k.f(format, "format");
        this.format = format;
        return this;
    }
}
