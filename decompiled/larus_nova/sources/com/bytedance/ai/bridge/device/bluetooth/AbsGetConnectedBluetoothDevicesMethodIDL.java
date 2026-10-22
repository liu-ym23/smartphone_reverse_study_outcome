package com.bytedance.ai.bridge.device.bluetooth;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL$GetConnectedBluetoothDevicesParamModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL$GetConnectedBluetoothDevicesResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "GetConnectedBluetoothDevicesParamModel", "GetConnectedBluetoothDevicesResultModel", "ConnectedBluetoothDevice", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetConnectedBluetoothDevicesMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35266a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetConnectedBluetoothDevicesMethodIDL$ConnectedBluetoothDevice;", "", "deviceId", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectedBluetoothDevice {

        @SerializedName("deviceId")
        private final String deviceId;

        @SerializedName("name")
        private final String name;

        public static /* synthetic */ ConnectedBluetoothDevice copy$default(ConnectedBluetoothDevice r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.deviceId;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.name;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.deviceId;
        }

        public final String component2() {
            return this.name;
        }

        public final ConnectedBluetoothDevice copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            Intrinsics.checkNotNullParameter(r101, "name");
            return new ConnectedBluetoothDevice(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ConnectedBluetoothDevice) == true) goto L8;
            return false;
        L8:
            ConnectedBluetoothDevice r101 = (ConnectedBluetoothDevice) r100;
            if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.deviceId.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "ConnectedBluetoothDevice(deviceId=" + this.deviceId + ", name=" + this.name + ')';
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getName() {
            return this.name;
        }

        public ConnectedBluetoothDevice(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.deviceId = r100;
            this.name = r101;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = PromotionProductPrivilegesStruct.SERVICES, required = true)
        List<String> getServices();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "devices", required = true)
        void setDevices(List<ConnectedBluetoothDevice> r100);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetConnectedBluetoothDevicesMethodIDL() {
        this.f35266a = "doubao.getConnectedBluetoothDevices";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35266a;
    }
}
