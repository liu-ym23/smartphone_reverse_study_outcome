package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.huawei.hms.api.FailedBinderCallBack;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/AbsAIBridgeStopMusicMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopMusicMethodIDL$StopMusicParamModel;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopMusicMethodIDL$StopMusicResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "StopMusicParamModel", "StopMusicResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAIBridgeStopMusicMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190854a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = FailedBinderCallBack.CALLER_ID, required = false)
        String getCallId();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsAIBridgeStopMusicMethodIDL() {
        this.f190854a = "applet.stopMusic";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f190854a;
    }
}
