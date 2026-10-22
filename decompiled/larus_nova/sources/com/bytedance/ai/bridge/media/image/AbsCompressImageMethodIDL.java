package com.bytedance.ai.bridge.media.image;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/media/image/AbsCompressImageMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/media/image/AbsCompressImageMethodIDL$CompressImageParamModel;", "Lcom/bytedance/ai/bridge/media/image/AbsCompressImageMethodIDL$CompressImageResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "CompressImageParamModel", "CompressImageResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCompressImageMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35342a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "compressedHeight", required = false)
        Integer getCompressedHeight();

        @AIBridgeParamField(keyPath = "compressedWidth", required = false)
        Integer getCompressedWidth();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(intValue = 80, type = DefaultType.INT), keyPath = GearStrategyConsts.EV_QUALITY, required = false)
        int getQuality();

        @AIBridgeParamField(keyPath = "src", required = true)
        String getSrc();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "tempFilePath", required = true)
        void setTempFilePath(String r100);
    }

    public AbsCompressImageMethodIDL() {
        this.f35342a = "doubao.compressImage";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35342a;
    }
}
