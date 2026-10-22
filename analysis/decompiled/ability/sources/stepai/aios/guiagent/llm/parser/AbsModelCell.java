package stepai.aios.guiagent.llm.parser;

import N9.j;
import W7.c;
import Y7.f;
import android.util.Size;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import g1.AbstractC1451a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.config.PromptOverrideManager;
import stepai.android.mindx.client.config.ConfigsKt;
import za.e;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0003J'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a0\u00182\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lstepai/aios/guiagent/llm/parser/AbsModelCell;", "Lstepai/aios/guiagent/llm/parser/IModelCell;", AppAgent.CONSTRUCT, "()V", "", "generateActionId", "()Ljava/lang/String;", "Lza/e;", "session", "imageBase64", "imageUrl", "", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "response", "Lstepai/aios/guiagent/config/Action;", "parseActionResponse", "(Ljava/lang/String;Lza/e;)Lstepai/aios/guiagent/config/Action;", "effectiveSystemPrompt", "LC7/r;", "clearCache", "buildRequestMessage", "(Lza/e;Ljava/lang/String;)Ljava/util/List;", "Lkotlin/Pair;", "Lstepai/aios/guiagent/config/ActionType;", "", "buildResponseAction", "(Ljava/lang/String;Lza/e;)Lkotlin/Pair;", "currentSessionId", "Ljava/lang/String;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbsModelCell implements IModelCell {
    private String currentSessionId;

    private final String generateActionId() {
        return "action_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(c.f1492a, new f(0, 999, 1));
    }

    public abstract List<Message> buildRequestMessage(e session, String imageBase64);

    public abstract Pair<ActionType, Map<String, String>> buildResponseAction(String response, e session);

    public abstract void clearCache();

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String effectiveSystemPrompt() {
        return PromptOverrideManager.INSTANCE.getEffectivePrompt(getType(), getSystemPrompt());
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ Object generateRequestMessage(e eVar, String str, LlmConfig llmConfig, String str2, String str3, H7.c<? super List<Message>> cVar) {
        return super.generateRequestMessage(eVar, str, llmConfig, str2, str3, cVar);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ Object generateRequestPayload(e eVar, String str, LlmConfig llmConfig, String str2, String str3, H7.c<? super ModelRequestPayload> cVar) {
        return super.generateRequestPayload(eVar, str, llmConfig, str2, str3, cVar);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ Size getCompressBitmapSize() {
        return super.getCompressBitmapSize();
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ Map<String, Object> getLastRequestMetadata() {
        return super.getLastRequestMetadata();
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ ModelParam getModelParam() {
        return super.getModelParam();
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ List<GUIAgentMode> getSupportedMode() {
        return super.getSupportedMode();
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void handleInquiry(e eVar, String str, String str2) {
        super.handleInquiry(eVar, str, str2);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void injectExperienceAction(String str, String str2, List<Integer> list, String str3, String str4) {
        super.injectExperienceAction(str, str2, list, str3, str4);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public Action parseActionResponse(String response, e session) throws Exception {
        k.f(response, "response");
        if (session == null) {
            throw new Exception("[parseActionResponse] session is null");
        }
        Pair<ActionType, Map<String, String>> pairBuildResponseAction = buildResponseAction(response, session);
        ActionType actionType = (ActionType) pairBuildResponseAction.f4886a;
        LinkedHashMap linkedHashMapA0 = a.a0((Map) pairBuildResponseAction.b);
        linkedHashMapA0.put(AgentBusWakeContract.EXTRA_SOURCE, "llm");
        return new Action(generateActionId(), actionType, linkedHashMapA0, null, 0L, null, 56, null);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void removeSession(String str) {
        super.removeSession(str);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public List<Message> generateRequestMessage(e session, String imageBase64, String imageUrl) throws Exception {
        if (session == null) {
            throw new Exception("[generateRequestMessage] session is null");
        }
        String str = session.f7004a;
        String str2 = this.currentSessionId;
        if (str2 != null && !k.b(str2, str)) {
            j.G("sessionId 发生变化", ConfigsKt.TAG);
            clearCache();
        }
        this.currentSessionId = str;
        return buildRequestMessage(session, imageBase64);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ ModelRequestPayload generateRequestPayload(e eVar, String str, String str2) {
        return super.generateRequestPayload(eVar, str, str2);
    }
}
