package com.bytedance.ai.bridge.device.wifi;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$SetWifiListParamModel;", "Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SetWifiListParamModel", "EmptyMessageModel", "WifiListItem", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSetWifiListMethodIDL extends CoreAIBridgeMethod<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35297a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/device/wifi/AbsSetWifiListMethodIDL$WifiListItem;", "", "ssid", "", "bssid", "password", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getPassword", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WifiListItem {

        @SerializedName("bssid")
        private final String bssid;

        @SerializedName("password")
        private final String password;

        @SerializedName("ssid")
        private final String ssid;

        public WifiListItem() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ WifiListItem copy$default(WifiListItem r100, String r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.ssid;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.bssid;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.password;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.ssid;
        }

        public final String component2() {
            return this.bssid;
        }

        public final String component3() {
            return this.password;
        }

        public final WifiListItem copy(String r100, String r101, String r102) {
            return new WifiListItem(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WifiListItem) == true) goto L8;
            return false;
        L8:
            WifiListItem r101 = (WifiListItem) r100;
            if (Intrinsics.areEqual(this.ssid, r101.ssid) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bssid, r101.bssid) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.password, r101.password) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r100 = this.ssid;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.bssid;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.password;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "WifiListItem(ssid=" + this.ssid + ", bssid=" + this.bssid + ", password=" + this.password + ')';
        }

        public final String getBssid() {
            return this.bssid;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getSsid() {
            return this.ssid;
        }

        public WifiListItem(String r100, String r101, String r102) {
            this.ssid = r100;
            this.bssid = r101;
            this.password = r102;
        }

        public /* synthetic */ WifiListItem(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "wifiList", required = true)
        List<WifiListItem> getWifiList();
    }

    public AbsSetWifiListMethodIDL() {
        this.f35297a = "doubao.setWifiList";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f35297a;
    }
}
