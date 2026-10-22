package com.bytedance.applet.aibridge.anniex;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL$SendEventToAnniexParamModel;", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL$SendEventToAnniexResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SendEventToAnniexParamModel", "SendEventToAnniexResultModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSendEventToAnniexMethodIDL extends CoreAIBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f190881a;

    public static final class a {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "containerId", required = false)
        String getContainerId();

        @AIBridgeParamField(keyPath = "eventName", required = true)
        String getEventName();

        @AIBridgeParamField(keyPath = "params", required = false)
        Map<String, Object> getParams();
    }

    @AIBridgeResultModel
    public interface c extends ResultModel {
    }

    static {
    }

    public AbsSendEventToAnniexMethodIDL() {
        this.f190881a = "applet.sendEventToAnniex";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f190881a;
    }
}
