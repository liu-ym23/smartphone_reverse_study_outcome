package com.bytedance.ai.bridge.device.bluetooth;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$GetBluetoothDevicesResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "EmptyMessageModel", "GetBluetoothDevicesResultModel", "BluetoothDevice", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBluetoothDevicesMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35265a;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\rHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJz\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$BluetoothDevice;", "", "deviceId", "", "name", "RSSI", "", "advertisData", "", "advertisServiceUUIDs", "Ljava/util/List;", "localName", "serviceData", "", "connectable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I[BLjava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;)V", "getDeviceId", "()Ljava/lang/String;", "getName", "getRSSI", "()I", "getAdvertisData", "()[B", "getAdvertisServiceUUIDs", "()Ljava/util/List;", "getLocalName", "getServiceData", "()Ljava/util/Map;", "getConnectable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;I[BLjava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBluetoothDevicesMethodIDL$BluetoothDevice;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BluetoothDevice {

        @SerializedName("RSSI")
        private final int RSSI;

        @SerializedName("advertisData")
        private final byte[] advertisData;

        @SerializedName("advertisServiceUUIDs")
        private final List<String> advertisServiceUUIDs;

        @SerializedName("connectable")
        private final Boolean connectable;

        @SerializedName("deviceId")
        private final String deviceId;

        @SerializedName("localName")
        private final String localName;

        @SerializedName("name")
        private final String name;

        @SerializedName("serviceData")
        private final Map<String, byte[]> serviceData;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BluetoothDevice copy$default(BluetoothDevice r100, String r110, String r111, int r112, byte[] r113, List r114, String r115, Map r116, Boolean r117, int r118, Object r119) {
            if ((r118 & 1) == 0) goto L5;
            String r101 = r100.deviceId;
        L7:
            if ((r118 & 2) == 0) goto L9;
            String r102 = r100.name;
        L11:
            if ((r118 & 4) == 0) goto L13;
            int r103 = r100.RSSI;
        L15:
            if ((r118 & 8) == 0) goto L17;
            byte[] r104 = r100.advertisData;
        L19:
            if ((r118 & 16) == 0) goto L21;
            List r105 = r100.advertisServiceUUIDs;
        L23:
            if ((r118 & 32) == 0) goto L25;
            String r106 = r100.localName;
        L27:
            if ((r118 & 64) == 0) goto L29;
            Map r107 = r100.serviceData;
        L31:
            if ((r118 & 128) == 0) goto L33;
            Boolean r108 = r100.connectable;
        L35:
            return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
        L33:
            r108 = r117;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }

        public final String component1() {
            return this.deviceId;
        }

        public final String component2() {
            return this.name;
        }

        public final int component3() {
            return this.RSSI;
        }

        public final byte[] component4() {
            return this.advertisData;
        }

        public final List<String> component5() {
            return this.advertisServiceUUIDs;
        }

        public final String component6() {
            return this.localName;
        }

        public final Map<String, byte[]> component7() {
            return this.serviceData;
        }

        public final Boolean component8() {
            return this.connectable;
        }

        public final BluetoothDevice copy(String r110, String r111, int r112, byte[] r113, List<String> r114, String r115, Map<String, byte[]> r116, Boolean r117) {
            Intrinsics.checkNotNullParameter(r110, "deviceId");
            Intrinsics.checkNotNullParameter(r111, "name");
            return new BluetoothDevice(r110, r111, r112, r113, r114, r115, r116, r117);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BluetoothDevice) == true) goto L8;
            return false;
        L8:
            BluetoothDevice r101 = (BluetoothDevice) r100;
            if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
            return false;
        L15:
            if (this.RSSI == r101.RSSI) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.advertisData, r101.advertisData) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.advertisServiceUUIDs, r101.advertisServiceUUIDs) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.localName, r101.localName) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.serviceData, r101.serviceData) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.connectable, r101.connectable) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            int r100 = ((((this.deviceId.hashCode() * 31) + this.name.hashCode()) * 31) + this.RSSI) * 31;
            byte[] r101 = this.advertisData;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            List<String> r105 = this.advertisServiceUUIDs;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.localName;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Map<String, byte[]> r111 = this.serviceData;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Boolean r114 = this.connectable;
            if (r114 == null) goto L23;
            r102 = r114.hashCode();
        L23:
            return r113 + r102;
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = Arrays.hashCode(r101);
            goto L6
        }

        public String toString() {
            return "BluetoothDevice(deviceId=" + this.deviceId + ", name=" + this.name + ", RSSI=" + this.RSSI + ", advertisData=" + Arrays.toString(this.advertisData) + ", advertisServiceUUIDs=" + this.advertisServiceUUIDs + ", localName=" + this.localName + ", serviceData=" + this.serviceData + ", connectable=" + this.connectable + ')';
        }

        public final byte[] getAdvertisData() {
            return this.advertisData;
        }

        public final List<String> getAdvertisServiceUUIDs() {
            return this.advertisServiceUUIDs;
        }

        public final Boolean getConnectable() {
            return this.connectable;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getLocalName() {
            return this.localName;
        }

        public final String getName() {
            return this.name;
        }

        public final int getRSSI() {
            return this.RSSI;
        }

        public final Map<String, byte[]> getServiceData() {
            return this.serviceData;
        }

        public BluetoothDevice(String r100, String r101, int r102, byte[] r103, List<String> r104, String r105, Map<String, byte[]> r106, Boolean r107) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.deviceId = r100;
            this.name = r101;
            this.RSSI = r102;
            this.advertisData = r103;
            this.advertisServiceUUIDs = r104;
            this.localName = r105;
            this.serviceData = r106;
            this.connectable = r107;
        }

        public /* synthetic */ BluetoothDevice(String r110, String r111, int r112, byte[] r113, List r114, String r115, Map r116, Boolean r210, int r211, DefaultConstructorMarker r212) {
            if ((r211 & 8) == 0) goto L5;
            byte[] r100 = null;
        L7:
            if ((r211 & 16) == 0) goto L9;
            List r101 = null;
        L11:
            if ((r211 & 32) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r211 & 64) == 0) goto L17;
            Map r117 = null;
        L19:
            if ((r211 & 128) == 0) goto L21;
            Boolean r118 = null;
        L22:
            this(r110, r111, r112, r100, r101, r102, r117, r118);
            return;
        L21:
            r118 = r210;
            goto L22
        L17:
            r117 = r116;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "devices", required = true)
        void setDevices(List<BluetoothDevice> r100);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetBluetoothDevicesMethodIDL() {
        this.f35265a = "doubao.getBluetoothDevices";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35265a;
    }
}
