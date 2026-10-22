package stepai.aios.guiagent.llm;

import H7.c;
import java.util.List;
import kotlin.Metadata;
import stepai.aios.guiagent.llm.biz.LlmChatBizRequest;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H¦@¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/llm/LlmService;", "", "", "isAvailable", "(LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;", "bizRequest", "Lstepai/aios/guiagent/llm/LlmChatResponse;", "chat", "(Lstepai/aios/guiagent/llm/biz/LlmChatBizRequest;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/llm/LlmChatRequest;", "request", "Lp9/c;", "Lstepai/aios/guiagent/llm/LlmStreamResponse;", "chatStream", "(Lstepai/aios/guiagent/llm/LlmChatRequest;)Lp9/c;", "", "Lstepai/aios/guiagent/llm/LlmModel;", "getSupportedModels", "()Ljava/util/List;", "", "modelName", "Lstepai/aios/guiagent/llm/ModelCapabilities;", "getModelCapabilities", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "getServiceId", "()Ljava/lang/String;", "serviceId", "getPrefersBase64Image", "()Z", "prefersBase64Image", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LlmService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getPrefersBase64Image(LlmService llmService) {
            return LlmService.super.getPrefersBase64Image();
        }
    }

    Object chat(LlmChatBizRequest llmChatBizRequest, c<? super LlmChatResponse> cVar);

    p9.c chatStream(LlmChatRequest request);

    Object getModelCapabilities(String str, c<? super ModelCapabilities> cVar);

    default boolean getPrefersBase64Image() {
        return false;
    }

    String getServiceId();

    List<LlmModel> getSupportedModels();

    Object isAvailable(c<? super Boolean> cVar);
}
