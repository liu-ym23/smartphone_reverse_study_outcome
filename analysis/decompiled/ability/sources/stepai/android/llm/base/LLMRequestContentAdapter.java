package stepai.android.llm.base;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.LLMRequestContent;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lstepai/android/llm/base/LLMRequestContentAdapter;", "Lcom/google/gson/TypeAdapter;", "Lstepai/android/llm/base/LLMRequestContent;", AppAgent.CONSTRUCT, "()V", "Lcom/google/gson/stream/JsonWriter;", "out", "value", "LC7/r;", "write", "(Lcom/google/gson/stream/JsonWriter;Lstepai/android/llm/base/LLMRequestContent;)V", "Lcom/google/gson/stream/JsonReader;", "in", "read", "(Lcom/google/gson/stream/JsonReader;)Lstepai/android/llm/base/LLMRequestContent;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LLMRequestContentAdapter extends TypeAdapter<LLMRequestContent> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public LLMRequestContent read2(JsonReader in) throws IOException {
        k.f(in, "in");
        in.beginObject();
        LLMRequestImageContent lLMRequestImageContent = null;
        String strNextString = "";
        String strNextString2 = "text";
        while (in.hasNext()) {
            String strNextName = in.nextName();
            if (strNextName != null) {
                switch (strNextName.hashCode()) {
                    case -877823861:
                        if (!strNextName.equals("image_url")) {
                            break;
                        } else {
                            in.beginObject();
                            while (in.hasNext()) {
                                if (k.b(in.nextName(), BffConstant.Type.Url)) {
                                    String strNextString3 = in.nextString();
                                    k.e(strNextString3, "nextString(...)");
                                    lLMRequestImageContent = new LLMRequestImageContent(strNextString3);
                                }
                            }
                            in.endObject();
                            break;
                        }
                    case 3556653:
                        if (!strNextName.equals("text")) {
                            break;
                        } else {
                            strNextString = in.nextString();
                            break;
                        }
                    case 3575610:
                        if (!strNextName.equals("type")) {
                            break;
                        } else {
                            strNextString2 = in.nextString();
                            break;
                        }
                    case 188528006:
                        if (!strNextName.equals("audio_url")) {
                            break;
                        } else {
                            in.nextString();
                            break;
                        }
                }
            }
            in.skipValue();
        }
        in.endObject();
        if (!k.b(strNextString2, "image_url")) {
            return new LLMRequestContent.Text(strNextString, strNextString2);
        }
        if (lLMRequestImageContent == null) {
            lLMRequestImageContent = new LLMRequestImageContent("");
        }
        return new LLMRequestContent.Image(lLMRequestImageContent, strNextString2);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, LLMRequestContent value) throws IOException {
        k.f(out, "out");
        if (value instanceof LLMRequestContent.Text) {
            out.beginObject();
            LLMRequestContent.Text text = (LLMRequestContent.Text) value;
            out.name("text").value(text.getText());
            out.name("type").value(text.getType());
            out.endObject();
            return;
        }
        if (value instanceof LLMRequestContent.Image) {
            out.beginObject();
            out.name("image_url").beginObject();
            LLMRequestContent.Image image = (LLMRequestContent.Image) value;
            out.name(BffConstant.Type.Url).value(image.getImageUrl().getUrl());
            out.endObject();
            out.name("type").value(image.getType());
            out.endObject();
        }
    }
}
