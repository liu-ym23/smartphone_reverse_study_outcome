package stepai.android.llm.base;

import D7.v;
import S7.k;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import stepai.android.llm.base.LLMRequestContent;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0007J!\u0010\f\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000f\u0010\rJ!\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u0011\u0010\rJ\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015¨\u0006\u001b"}, d2 = {"Lstepai/android/llm/base/ContentBuilder;", "", AppAgent.CONSTRUCT, "()V", "", "text", "type", "(Ljava/lang/String;Ljava/lang/String;)Lstepai/android/llm/base/ContentBuilder;", "Lkotlin/Function1;", "Lstepai/android/llm/base/ImageContentBuilder;", "LC7/r;", "init", "image", "(LS7/k;)Lstepai/android/llm/base/ContentBuilder;", "Lstepai/android/llm/base/AudioUrlContentBuilder;", "audioUrl", "Lstepai/android/llm/base/AudioInputContentBuilder;", "audioInput", "", "Lstepai/android/llm/base/LLMRequestContent;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ljava/util/List;", "", "contents", "Ljava/util/List;", "imageBuilders", "getImageBuilders$llmbase_release", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContentBuilder {
    private final List<LLMRequestContent> contents = new ArrayList();
    private final List<ImageContentBuilder> imageBuilders = new ArrayList();

    public static /* synthetic */ ContentBuilder text$default(ContentBuilder contentBuilder, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "text";
        }
        return contentBuilder.text(str, str2);
    }

    public final ContentBuilder audioInput(k init) {
        kotlin.jvm.internal.k.f(init, "init");
        AudioInputContentBuilder audioInputContentBuilder = new AudioInputContentBuilder();
        init.invoke(audioInputContentBuilder);
        this.contents.add(new LLMRequestContent.AudioInput(audioInputContentBuilder.build(), null, 2, null));
        return this;
    }

    public final ContentBuilder audioUrl(k init) {
        kotlin.jvm.internal.k.f(init, "init");
        AudioUrlContentBuilder audioUrlContentBuilder = new AudioUrlContentBuilder();
        init.invoke(audioUrlContentBuilder);
        this.contents.add(new LLMRequestContent.AudioUrl(audioUrlContentBuilder.build(), null, 2, null));
        return this;
    }

    public final List<LLMRequestContent> build() {
        return v.f1(this.contents);
    }

    public final List<ImageContentBuilder> getImageBuilders$llmbase_release() {
        return this.imageBuilders;
    }

    public final ContentBuilder image(k init) {
        kotlin.jvm.internal.k.f(init, "init");
        ImageContentBuilder imageContentBuilder = new ImageContentBuilder();
        init.invoke(imageContentBuilder);
        this.imageBuilders.add(imageContentBuilder);
        this.contents.add(new LLMRequestContent.Image(imageContentBuilder.build(), null, 2, null));
        return this;
    }

    public final ContentBuilder text(String text, String type) {
        kotlin.jvm.internal.k.f(text, "text");
        kotlin.jvm.internal.k.f(type, "type");
        this.contents.add(new LLMRequestContent.Text(text, type));
        return this;
    }
}
