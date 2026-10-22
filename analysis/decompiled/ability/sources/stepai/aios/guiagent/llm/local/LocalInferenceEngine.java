package stepai.aios.guiagent.llm.local;

import C7.r;
import H7.c;
import android.content.Context;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH¦@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH¦@¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/llm/local/LocalInferenceEngine;", "", "Landroid/content/Context;", "context", "", "isAvailable", "(Landroid/content/Context;LH7/c;)Ljava/lang/Object;", "", "Lstepai/aios/guiagent/llm/local/LocalMessage;", "messages", "Lstepai/aios/guiagent/llm/local/LocalInferenceConfig;", "config", "Lstepai/aios/guiagent/llm/local/LocalInferenceResult;", "chat", "(Ljava/util/List;Lstepai/aios/guiagent/llm/local/LocalInferenceConfig;LH7/c;)Ljava/lang/Object;", "LC7/r;", "release", "(LH7/c;)Ljava/lang/Object;", "", "getEngineId", "()Ljava/lang/String;", "engineId", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LocalInferenceEngine {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object chat$default(LocalInferenceEngine localInferenceEngine, List list, LocalInferenceConfig localInferenceConfig, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chat");
        }
        if ((i & 2) != 0) {
            localInferenceConfig = new LocalInferenceConfig(0, 0.0f, 0.0f, 7, null);
        }
        return localInferenceEngine.chat(list, localInferenceConfig, cVar);
    }

    Object chat(List<LocalMessage> list, LocalInferenceConfig localInferenceConfig, c<? super LocalInferenceResult> cVar);

    String getEngineId();

    Object isAvailable(Context context, c<? super Boolean> cVar);

    Object release(c<? super r> cVar);
}
