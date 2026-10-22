package com.bytedance.applet.aibridge.camera;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/camera/AbsStartCameraAndSendMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/camera/AbsStartCameraAndSendMethodIDL$StartCameraAndSendMethodParamModel;", "Lcom/bytedance/applet/aibridge/camera/AbsStartCameraAndSendMethodIDL$StartCameraAndSendMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "StartCameraAndSendMethodParamModel", "StartCameraAndSendMethodResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsStartCameraAndSendMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191000a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "conversationId", required = true)
        String getConversationId();

        @AIBridgeParamField(keyPath = "extraInfo", required = false)
        JSONObject getExtraInfo();

        @AIBridgeParamField(keyPath = "msgExt", required = false)
        JSONObject getMsgExt();

        @AIBridgeParamField(keyPath = "scene", required = true)
        String getScene();

        @AIBridgeParamField(keyPath = "traceInfo", required = false)
        JSONObject getTraceInfo();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "failReason", required = false)
        void setFailReason(String r100);

        @AIBridgeParamField(keyPath = "result", required = true)
        void setResult(int r100);
    }

    public AbsStartCameraAndSendMethodIDL() {
        this.f191000a = "flow.startCameraAndSend";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f191000a;
    }
}
