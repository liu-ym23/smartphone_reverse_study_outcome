package com.bytedance.applet.aibridge.ecommerce.api;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/api/AbsRequestTradeAuthMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsRequestTradeAuthMethodIDL$RequestTradeAuthMethodParamModel;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsRequestTradeAuthMethodIDL$RequestTradeAuthMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "RequestTradeAuthMethodParamModel", "RequestTradeAuthMethodResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsRequestTradeAuthMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191099a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "currentPage", required = false)
        String getCurrentPage();

        @AIBridgeParamField(keyPath = "entryType", required = false)
        String getEntryType();

        @AIBridgeParamField(keyPath = "source", required = false)
        String getSource();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "accessToken", required = false)
        void setAccessToken(String r100);

        @AIBridgeParamField(keyPath = "isCancel", required = false)
        void setCancel(Boolean r100);
    }

    public AbsRequestTradeAuthMethodIDL() {
        this.f191099a = "applet.requestTradeAuth";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f191099a;
    }
}
