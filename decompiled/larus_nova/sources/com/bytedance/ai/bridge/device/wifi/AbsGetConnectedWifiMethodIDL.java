package com.bytedance.ai.bridge.device.wifi;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$GetConnectedWifiParamModel;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$GetConnectedWifiResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetConnectedWifiParamModel", "GetConnectedWifiResultModel", "WifiInfo", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetConnectedWifiMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35295a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$WifiInfo;", "", "ssid", "", "bssid", "secure", "", "signalStrength", "", "frequency", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getSecure", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSignalStrength", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFrequency", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)Lcom/bytedance/ai/bridge/device/wifi/AbsGetConnectedWifiMethodIDL$WifiInfo;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WifiInfo {

        @SerializedName("bssid")
        private final String bssid;

        @SerializedName("frequency")
        private final Integer frequency;

        @SerializedName("secure")
        private final Boolean secure;

        @SerializedName("signalStrength")
        private final Double signalStrength;

        @SerializedName("ssid")
        private final String ssid;

        public static /* synthetic */ WifiInfo copy$default(WifiInfo r100, String r101, String r102, Boolean r103, Double r104, Integer r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.ssid;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.bssid;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.secure;
        L11:
            Boolean r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.signalStrength;
        L14:
            Double r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.frequency;
        L17:
            String r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final String component1() {
            return this.ssid;
        }

        public final String component2() {
            return this.bssid;
        }

        public final Boolean component3() {
            return this.secure;
        }

        public final Double component4() {
            return this.signalStrength;
        }

        public final Integer component5() {
            return this.frequency;
        }

        public final WifiInfo copy(String r100, String r101, Boolean r110, Double r111, Integer r112) {
            Intrinsics.checkNotNullParameter(r100, "ssid");
            return new WifiInfo(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WifiInfo) == true) goto L8;
            return false;
        L8:
            WifiInfo r101 = (WifiInfo) r100;
            if (Intrinsics.areEqual(this.ssid, r101.ssid) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bssid, r101.bssid) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.secure, r101.secure) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.signalStrength, r101.signalStrength) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.frequency, r101.frequency) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r100 = this.ssid.hashCode() * 31;
            String r101 = this.bssid;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Boolean r105 = this.secure;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Double r108 = this.signalStrength;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Integer r111 = this.frequency;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "WifiInfo(ssid=" + this.ssid + ", bssid=" + this.bssid + ", secure=" + this.secure + ", signalStrength=" + this.signalStrength + ", frequency=" + this.frequency + ')';
        }

        public final String getBssid() {
            return this.bssid;
        }

        public final Integer getFrequency() {
            return this.frequency;
        }

        public final Boolean getSecure() {
            return this.secure;
        }

        public final Double getSignalStrength() {
            return this.signalStrength;
        }

        public final String getSsid() {
            return this.ssid;
        }

        public WifiInfo(String r100, String r101, Boolean r102, Double r103, Integer r104) {
            Intrinsics.checkNotNullParameter(r100, "ssid");
            this.ssid = r100;
            this.bssid = r101;
            this.secure = r102;
            this.signalStrength = r103;
            this.frequency = r104;
        }

        public /* synthetic */ WifiInfo(String r100, String r101, Boolean r110, Double r111, Integer r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 2) == 0) goto L5;
            String r102 = null;
        L7:
            if ((r113 & 4) == 0) goto L9;
            Boolean r103 = null;
        L11:
            if ((r113 & 8) == 0) goto L13;
            Double r104 = null;
        L15:
            if ((r113 & 16) == 0) goto L17;
            Integer r105 = null;
        L18:
            this(r100, r102, r103, r104, r105);
            return;
        L17:
            r105 = r112;
            goto L18
        L13:
            r104 = r111;
            goto L15
        L9:
            r103 = r110;
            goto L11
        L5:
            r102 = r101;
            goto L7
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "partialInfo", required = false)
        Boolean getPartialInfo();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "wifi", required = true)
        void setWifi(WifiInfo r100);
    }

    public AbsGetConnectedWifiMethodIDL() {
        this.f35295a = "doubao.getConnectedWifi";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35295a;
    }
}
