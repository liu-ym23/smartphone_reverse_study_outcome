package com.bytedance.ai.bridge.device.bluetooth;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.lynx.canvas.KryptonCamera;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL$StartBluetoothDevicesDiscoveryParamModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "StartBluetoothDevicesDiscoveryParamModel", "EmptyMessageModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsStartBluetoothDevicesDiscoveryMethodIDL extends CoreAIBridgeMethod<b, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35274a;

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "allowDuplicatesKey", required = false)
        Boolean getAllowDuplicatesKey();

        @AIBridgeParamField(keyPath = VideoThumbInfo.KEY_INTERVAL, required = false)
        Integer getInterval();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = KryptonCamera.Config.RESOLUTION_MEDIUM, type = DefaultType.STRING), keyPath = "powerLevel", required = false)
        String getPowerLevel();

        @AIBridgeParamField(keyPath = PromotionProductPrivilegesStruct.SERVICES, required = false)
        List<String> getServices();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsStartBluetoothDevicesDiscoveryMethodIDL() {
        this.f35274a = "doubao.startBluetoothDevicesDiscovery";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35274a;
    }
}
