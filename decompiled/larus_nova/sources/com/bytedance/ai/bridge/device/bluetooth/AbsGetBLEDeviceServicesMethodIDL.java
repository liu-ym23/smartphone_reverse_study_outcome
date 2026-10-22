package com.bytedance.ai.bridge.device.bluetooth;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL$GetBLEDeviceServicesParamModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL$GetBLEDeviceServicesResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "GetBLEDeviceServicesParamModel", "GetBLEDeviceServicesResultModel", "BluetoothService", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBLEDeviceServicesMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35261a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBLEDeviceServicesMethodIDL$BluetoothService;", "", ST.UUID_DEVICE, "", "isPrimary", "", "<init>", "(Ljava/lang/String;Z)V", "getUuid", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BluetoothService {

        @SerializedName("isPrimary")
        private final boolean isPrimary;

        @SerializedName(ST.UUID_DEVICE)
        private final String uuid;

        public static /* synthetic */ BluetoothService copy$default(BluetoothService r100, String r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.uuid;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.isPrimary;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.uuid;
        }

        public final boolean component2() {
            return this.isPrimary;
        }

        public final BluetoothService copy(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            return new BluetoothService(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BluetoothService) == true) goto L8;
            return false;
        L8:
            BluetoothService r101 = (BluetoothService) r100;
            if (Intrinsics.areEqual(this.uuid, r101.uuid) == true) goto L12;
            return false;
        L12:
            if (this.isPrimary == r101.isPrimary) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.uuid.hashCode() * 31;
            if (this.isPrimary == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public String toString() {
            return "BluetoothService(uuid=" + this.uuid + ", isPrimary=" + this.isPrimary + ')';
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final boolean isPrimary() {
            return this.isPrimary;
        }

        public BluetoothService(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            this.uuid = r100;
            this.isPrimary = r101;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "deviceId", required = true)
        String getDeviceId();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = PromotionProductPrivilegesStruct.SERVICES, required = true)
        void setServices(List<BluetoothService> r100);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetBLEDeviceServicesMethodIDL() {
        this.f35261a = "doubao.getBLEDeviceServices";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35261a;
    }
}
