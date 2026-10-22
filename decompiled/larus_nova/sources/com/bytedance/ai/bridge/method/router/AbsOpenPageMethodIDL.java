package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "OpenPageParamModel", "OpenPageResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenPageMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35808a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = IFlowAppIntentIDL.PARAM_APPLET_ID, required = false)
        String getAppletId();

        @AIBridgeParamField(keyPath = PerfLog.PARAM_KEY_CONTEXT_ID, required = true)
        JsonObject getContext();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "full", type = DefaultType.STRING), keyPath = "mode", required = false)
        String getMode();

        @AIBridgeParamField(keyPath = "pageData", required = false)
        String getPageData();

        @AIBridgeParamField(keyPath = "pageId", required = true)
        String getPageId();

        @AIBridgeParamField(keyPath = "pageSettings", required = false)
        JsonObject getPageSettings();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "floatingShowResult", required = true)
        void setFloatingShowResult(Integer r100);

        @AIBridgeParamField(keyPath = "viewId", required = true)
        void setViewId(String r100);
    }

    public AbsOpenPageMethodIDL() {
        this.f35808a = "applet.openPage";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35808a;
    }
}
