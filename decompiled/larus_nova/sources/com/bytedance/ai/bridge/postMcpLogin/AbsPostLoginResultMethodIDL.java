package com.bytedance.ai.bridge.postMcpLogin;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$PostLoginResultRequestModel;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "PostLoginResultRequestModel", "EmptyMessageModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsPostLoginResultMethodIDL extends CoreAIBridgeMethod<b, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36066a;

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "code", required = false)
        String getCode();

        @AIBridgeParamField(keyPath = "loginType", required = false)
        Integer getLoginType();

        @AIBridgeParamField(keyPath = "result", required = true)
        boolean getResult();
    }

    public AbsPostLoginResultMethodIDL() {
        this.f36066a = "doubao.postLoginResult";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f36066a;
    }
}
