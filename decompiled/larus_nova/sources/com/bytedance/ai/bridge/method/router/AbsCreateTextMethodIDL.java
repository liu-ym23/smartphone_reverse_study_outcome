package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateTextMethodIDL$CreateTextResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "CreateTextParamModel", "CreateTextResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCreateTextMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35805a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "afterBotReply", required = false)
        Boolean getAfterBotReply();

        @AIBridgeParamField(keyPath = "content", required = true)
        String getContent();

        @AIBridgeParamField(keyPath = PerfLog.PARAM_KEY_CONTEXT_ID, required = true)
        JsonObject getContext();

        @AIBridgeParamField(keyPath = "extra", required = false)
        Map<String, String> getExtra();

        @AIBridgeParamField(keyPath = "suggests", required = false)
        List<String> getSuggests();

        @AIBridgeParamField(keyPath = "suggestsV2", required = false)
        List<String> getSuggestsV2();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public AbsCreateTextMethodIDL() {
        this.f35805a = "applet.createText";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35805a;
    }
}
