package com.bytedance.ai.bridge.method.router;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsCloseMethodIDL$CloseResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "altNames", "", "getAltNames", "()Ljava/util/List;", "mustRunInMain", "", "CloseParamModel", "CloseResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCloseMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f35804b;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, required = false)
        boolean getAnimated();

        @AIBridgeParamField(keyPath = "containerID", required = false)
        String getContainerID();

        @AIBridgeParamField(keyPath = "containerIDs", required = false)
        List<String> getContainerIDs();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsCloseMethodIDL() {
        this.f35803a = "applet.close";
        this.f35804b = CollectionsKt.listOf("doubao.close");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final List<String> getAltNames() {
        return this.f35804b;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35803a;
    }
}
