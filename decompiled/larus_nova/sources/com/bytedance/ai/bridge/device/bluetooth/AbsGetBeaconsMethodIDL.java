package com.bytedance.ai.bridge.device.bluetooth;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL$GetBeaconsResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "EmptyMessageModel", "GetBeaconsResultModel", "BeaconInfo", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBeaconsMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35263a;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/device/bluetooth/AbsGetBeaconsMethodIDL$BeaconInfo;", "", ST.UUID_DEVICE, "", "major", "", "minor", "proximity", LocationMonitorConst.ACCURACY, "", "rssi", "<init>", "(Ljava/lang/String;IIIDI)V", "getUuid", "()Ljava/lang/String;", "getMajor", "()I", "getMinor", "getProximity", "getAccuracy", "()D", "getRssi", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BeaconInfo {

        @SerializedName(LocationMonitorConst.ACCURACY)
        private final double accuracy;

        @SerializedName("major")
        private final int major;

        @SerializedName("minor")
        private final int minor;

        @SerializedName("proximity")
        private final int proximity;

        @SerializedName("rssi")
        private final int rssi;

        @SerializedName(ST.UUID_DEVICE)
        private final String uuid;

        public static /* synthetic */ BeaconInfo copy$default(BeaconInfo r100, String r101, int r102, int r103, int r104, double r110, int r111, int r112, Object r113) {
            if ((r112 & 1) == 0) goto L6;
            r101 = r100.uuid;
        L6:
            if ((r112 & 2) == 0) goto L8;
            r102 = r100.major;
        L8:
            int r114 = r102;
            if ((r112 & 4) == 0) goto L11;
            r103 = r100.minor;
        L11:
            int r105 = r103;
            if ((r112 & 8) == 0) goto L14;
            r104 = r100.proximity;
        L14:
            int r106 = r104;
            if ((r112 & 16) == 0) goto L17;
            r110 = r100.accuracy;
        L17:
            double r107 = r110;
            if ((r112 & 32) == 0) goto L20;
            r111 = r100.rssi;
        L20:
            String r108 = r101;
            return r100.copy(r108, r114, r105, r106, r107, r111);
        }

        public final String component1() {
            return this.uuid;
        }

        public final int component2() {
            return this.major;
        }

        public final int component3() {
            return this.minor;
        }

        public final int component4() {
            return this.proximity;
        }

        public final double component5() {
            return this.accuracy;
        }

        public final int component6() {
            return this.rssi;
        }

        public final BeaconInfo copy(String r110, int r111, int r112, int r113, double r114, int r115) {
            Intrinsics.checkNotNullParameter(r110, ST.UUID_DEVICE);
            return new BeaconInfo(r110, r111, r112, r113, r114, r115);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BeaconInfo) == true) goto L8;
            return false;
        L8:
            BeaconInfo r101 = (BeaconInfo) r100;
            if (Intrinsics.areEqual(this.uuid, r101.uuid) == true) goto L12;
            return false;
        L12:
            if (this.major == r101.major) goto L15;
            return false;
        L15:
            if (this.minor == r101.minor) goto L18;
            return false;
        L18:
            if (this.proximity == r101.proximity) goto L21;
            return false;
        L21:
            if (Double.compare(this.accuracy, r101.accuracy) == 0) goto L24;
            return false;
        L24:
            if (this.rssi == r101.rssi) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r100 = ((((((this.uuid.hashCode() * 31) + this.major) * 31) + this.minor) * 31) + this.proximity) * 31;
            long r101 = Double.doubleToLongBits(this.accuracy);
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.rssi;
        }

        public String toString() {
            return "BeaconInfo(uuid=" + this.uuid + ", major=" + this.major + ", minor=" + this.minor + ", proximity=" + this.proximity + ", accuracy=" + this.accuracy + ", rssi=" + this.rssi + ')';
        }

        public final double getAccuracy() {
            return this.accuracy;
        }

        public final int getMajor() {
            return this.major;
        }

        public final int getMinor() {
            return this.minor;
        }

        public final int getProximity() {
            return this.proximity;
        }

        public final int getRssi() {
            return this.rssi;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public BeaconInfo(String r100, int r101, int r102, int r103, double r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
            this.uuid = r100;
            this.major = r101;
            this.minor = r102;
            this.proximity = r103;
            this.accuracy = r104;
            this.rssi = r105;
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "beacons", required = true)
        void setBeacons(List<BeaconInfo> r100);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetBeaconsMethodIDL() {
        this.f35263a = "doubao.getBeacons";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35263a;
    }
}
