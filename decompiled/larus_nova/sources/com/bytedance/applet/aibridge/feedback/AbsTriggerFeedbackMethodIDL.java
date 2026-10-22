package com.bytedance.applet.aibridge.feedback;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonArray;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/feedback/AbsTriggerFeedbackMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/feedback/AbsTriggerFeedbackMethodIDL$BridgeParam;", "Lcom/bytedance/applet/aibridge/feedback/AbsTriggerFeedbackMethodIDL$BridgeResult;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "getFeedbackTagList", "", "Lcom/larus/bmhome/chat/feedback/TriggerFeedbackTagBean;", "BridgeParam", "BridgeResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsTriggerFeedbackMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191128a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "feedbackPlaceHolderText", required = true)
        String getFeedbackPlaceholderText();

        @AIBridgeParamField(keyPath = "feedbackInfoList", required = true)
        JsonArray getFeedbackTagListJson();

        @AIBridgeParamField(keyPath = com.heytap.mcssdk.constant.b.f276353c)
        String getMessageID();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "feedbackDetailContent", required = false)
        void setFeedbackDetailContent(String r100);

        @AIBridgeParamField(keyPath = "feedbackDetailType", required = false)
        void setFeedbackDetailType(Integer r100);

        @AIBridgeParamField(keyPath = "feedbackType", required = false)
        void setFeedbackType(Integer r100);

        @AIBridgeParamField(keyPath = LocationMonitorConst.SUBMIT, required = true)
        void setSubmit(int r100);
    }

    public AbsTriggerFeedbackMethodIDL() {
        this.f191128a = "flow.triggerFeedback";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f191128a;
    }
}
