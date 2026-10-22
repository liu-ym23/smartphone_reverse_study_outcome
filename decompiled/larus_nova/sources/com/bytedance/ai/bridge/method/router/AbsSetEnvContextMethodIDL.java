package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL$SetEnvContextParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsSetEnvContextMethodIDL$SetEnvContextResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SetEnvContextParamModel", "SetEnvContextResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSetEnvContextMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35811a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "conversationId", required = true)
        String getConversationId();

        @AIBridgeParamField(keyPath = "eventType", required = true)
        int getEventType();

        @AIBridgeParamField(keyPath = "key", required = true)
        String getKey();

        @AIBridgeParamField(keyPath = "value", required = true)
        String getValue();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public AbsSetEnvContextMethodIDL() {
        this.f35811a = "applet.setEnvContext";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35811a;
    }
}
