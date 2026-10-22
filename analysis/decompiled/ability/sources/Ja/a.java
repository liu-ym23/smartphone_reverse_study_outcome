package Ja;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import stepai.android.llm.base.LLMGson;
import stepai.android.llm.base.twoway.TTSFlowData;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements JsonSerializer {
    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return LLMGson.gson$lambda$1((TTSFlowData) obj, type, jsonSerializationContext);
    }
}
