package com.stepos.ailauncher.contract.api.agent;

import Y8.t;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.sla.G;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h9.InterfaceC4149a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.enums.a;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import x5.d;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001:\b3456789:J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH&¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bJ9\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001d\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJC\u0010$\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b$\u0010%J-\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b(\u0010)J-\u0010+\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b+\u0010)J-\u0010-\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b-\u0010)J-\u0010/\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b/\u0010)JC\u00100\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b0\u0010%JC\u00101\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b1\u0010%J+\u00102\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u001cH&¢\u0006\u0004\b2\u0010)¨\u0006;À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService;", "", "", "deviceToken", "agentType", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;", "callback", "LY8/t;", "bindDevice", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;)V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "listConnectedDevices", "()Ljava/util/List;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "listSidebarAgents", "deviceId", "findDevice", "(Ljava/lang/String;)Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "", "alsoDeleteData", "deleteDevice", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "newName", "renameDevice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "reconnectDevice", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "Lkotlin/Result;", "queryDeviceAgentOnline", "(Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "assetId", "reversionId", "semver", "displayName", "uninstallInstalledAgent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "agentId", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ReinstallInfo;", "resolveReinstallableAgent", "(Ljava/lang/String;Lp9/l;)V", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$UpdateInfo;", "resolveUpdatableAgent", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$DisabledInfo;", "resolveDisabledMarketAgent", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyInfo;", "resolveBusyMarketAgent", "installMarketAgent", "updateMarketAgent", "enableMarketAgent", "ReinstallInfo", "UpdateInfo", "DisabledInfo", "BusyInfo", "BusyKind", "ConnectedDevice", "SidebarAgent", "BindCallback", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IExternalAgentBindService {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BindCallback;", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", Parameters.DEVICE, "LY8/t;", "onSuccess", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;)V", "", "reason", "onFailure", "(Ljava/lang/String;)V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface BindCallback {
        void onFailure(String reason);

        void onSuccess(ConnectedDevice device);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyInfo;", "", "assetId", "", "kind", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyKind;", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyKind;)V", "getAssetId", "()Ljava/lang/String;", "getKind", "()Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyKind;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BusyInfo {
        private final String assetId;
        private final BusyKind kind;

        public BusyInfo(String assetId, BusyKind kind) {
            p.i(assetId, "assetId");
            p.i(kind, "kind");
            this.assetId = assetId;
            this.kind = kind;
        }

        public static /* synthetic */ BusyInfo copy$default(BusyInfo busyInfo, String str, BusyKind busyKind, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = busyInfo.assetId;
            }
            if ((i10 & 2) != 0) {
                busyKind = busyInfo.kind;
            }
            return busyInfo.copy(str, busyKind);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAssetId() {
            return this.assetId;
        }

        /* renamed from: component2, reason: from getter */
        public final BusyKind getKind() {
            return this.kind;
        }

        public final BusyInfo copy(String assetId, BusyKind kind) {
            p.i(assetId, "assetId");
            p.i(kind, "kind");
            return new BusyInfo(assetId, kind);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BusyInfo)) {
                return false;
            }
            BusyInfo busyInfo = (BusyInfo) other;
            return p.d(this.assetId, busyInfo.assetId) && this.kind == busyInfo.kind;
        }

        public final String getAssetId() {
            return this.assetId;
        }

        public final BusyKind getKind() {
            return this.kind;
        }

        public int hashCode() {
            return (this.assetId.hashCode() * 31) + this.kind.hashCode();
        }

        public String toString() {
            return "BusyInfo(assetId=" + this.assetId + ", kind=" + this.kind + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$BusyKind;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALLING", "UPDATING", "UNINSTALLING", "PENDING", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BusyKind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ BusyKind[] $VALUES;
        public static final BusyKind INSTALLING = new BusyKind("INSTALLING", 0);
        public static final BusyKind UPDATING = new BusyKind("UPDATING", 1);
        public static final BusyKind UNINSTALLING = new BusyKind("UNINSTALLING", 2);
        public static final BusyKind PENDING = new BusyKind("PENDING", 3);

        private static final /* synthetic */ BusyKind[] $values() {
            return new BusyKind[]{INSTALLING, UPDATING, UNINSTALLING, PENDING};
        }

        static {
            BusyKind[] busyKindArr$values = $values();
            $VALUES = busyKindArr$values;
            $ENTRIES = a.a(busyKindArr$values);
        }

        private BusyKind(String str, int i10) {
        }

        public static InterfaceC4149a<BusyKind> getEntries() {
            return $ENTRIES;
        }

        public static BusyKind valueOf(String str) {
            return (BusyKind) Enum.valueOf(BusyKind.class, str);
        }

        public static BusyKind[] values() {
            return (BusyKind[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ConnectedDevice;", "", "deviceId", "", "deviceName", "agentType", G.NETWORK_ONLINE, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getAgentType", "getOnline", "()Z", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ConnectedDevice {
        private final String agentType;
        private final String deviceId;
        private final String deviceName;
        private final boolean online;

        public ConnectedDevice(String deviceId, String deviceName, String agentType, boolean z10) {
            p.i(deviceId, "deviceId");
            p.i(deviceName, "deviceName");
            p.i(agentType, "agentType");
            this.deviceId = deviceId;
            this.deviceName = deviceName;
            this.agentType = agentType;
            this.online = z10;
        }

        public static /* synthetic */ ConnectedDevice copy$default(ConnectedDevice connectedDevice, String str, String str2, String str3, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = connectedDevice.deviceId;
            }
            if ((i10 & 2) != 0) {
                str2 = connectedDevice.deviceName;
            }
            if ((i10 & 4) != 0) {
                str3 = connectedDevice.agentType;
            }
            if ((i10 & 8) != 0) {
                z10 = connectedDevice.online;
            }
            return connectedDevice.copy(str, str2, str3, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDeviceName() {
            return this.deviceName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAgentType() {
            return this.agentType;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getOnline() {
            return this.online;
        }

        public final ConnectedDevice copy(String deviceId, String deviceName, String agentType, boolean online) {
            p.i(deviceId, "deviceId");
            p.i(deviceName, "deviceName");
            p.i(agentType, "agentType");
            return new ConnectedDevice(deviceId, deviceName, agentType, online);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectedDevice)) {
                return false;
            }
            ConnectedDevice connectedDevice = (ConnectedDevice) other;
            return p.d(this.deviceId, connectedDevice.deviceId) && p.d(this.deviceName, connectedDevice.deviceName) && p.d(this.agentType, connectedDevice.agentType) && this.online == connectedDevice.online;
        }

        public final String getAgentType() {
            return this.agentType;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getDeviceName() {
            return this.deviceName;
        }

        public final boolean getOnline() {
            return this.online;
        }

        public int hashCode() {
            return (((((this.deviceId.hashCode() * 31) + this.deviceName.hashCode()) * 31) + this.agentType.hashCode()) * 31) + Boolean.hashCode(this.online);
        }

        public String toString() {
            return "ConnectedDevice(deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", agentType=" + this.agentType + ", online=" + this.online + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$DisabledInfo;", "", "assetId", "", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAssetId", "()Ljava/lang/String;", "getDisplayName", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DisabledInfo {
        private final String assetId;
        private final String displayName;

        public DisabledInfo(String assetId, String displayName) {
            p.i(assetId, "assetId");
            p.i(displayName, "displayName");
            this.assetId = assetId;
            this.displayName = displayName;
        }

        public static /* synthetic */ DisabledInfo copy$default(DisabledInfo disabledInfo, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = disabledInfo.assetId;
            }
            if ((i10 & 2) != 0) {
                str2 = disabledInfo.displayName;
            }
            return disabledInfo.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAssetId() {
            return this.assetId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        public final DisabledInfo copy(String assetId, String displayName) {
            p.i(assetId, "assetId");
            p.i(displayName, "displayName");
            return new DisabledInfo(assetId, displayName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DisabledInfo)) {
                return false;
            }
            DisabledInfo disabledInfo = (DisabledInfo) other;
            return p.d(this.assetId, disabledInfo.assetId) && p.d(this.displayName, disabledInfo.displayName);
        }

        public final String getAssetId() {
            return this.assetId;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public int hashCode() {
            return (this.assetId.hashCode() * 31) + this.displayName.hashCode();
        }

        public String toString() {
            return "DisabledInfo(assetId=" + this.assetId + ", displayName=" + this.displayName + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$ReinstallInfo;", "", "assetId", "", "reversionId", "semver", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssetId", "()Ljava/lang/String;", "getReversionId", "getSemver", "getDisplayName", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ReinstallInfo {
        private final String assetId;
        private final String displayName;
        private final String reversionId;
        private final String semver;

        public ReinstallInfo(String assetId, String reversionId, String semver, String displayName) {
            p.i(assetId, "assetId");
            p.i(reversionId, "reversionId");
            p.i(semver, "semver");
            p.i(displayName, "displayName");
            this.assetId = assetId;
            this.reversionId = reversionId;
            this.semver = semver;
            this.displayName = displayName;
        }

        public static /* synthetic */ ReinstallInfo copy$default(ReinstallInfo reinstallInfo, String str, String str2, String str3, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = reinstallInfo.assetId;
            }
            if ((i10 & 2) != 0) {
                str2 = reinstallInfo.reversionId;
            }
            if ((i10 & 4) != 0) {
                str3 = reinstallInfo.semver;
            }
            if ((i10 & 8) != 0) {
                str4 = reinstallInfo.displayName;
            }
            return reinstallInfo.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAssetId() {
            return this.assetId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReversionId() {
            return this.reversionId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSemver() {
            return this.semver;
        }

        /* renamed from: component4, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        public final ReinstallInfo copy(String assetId, String reversionId, String semver, String displayName) {
            p.i(assetId, "assetId");
            p.i(reversionId, "reversionId");
            p.i(semver, "semver");
            p.i(displayName, "displayName");
            return new ReinstallInfo(assetId, reversionId, semver, displayName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReinstallInfo)) {
                return false;
            }
            ReinstallInfo reinstallInfo = (ReinstallInfo) other;
            return p.d(this.assetId, reinstallInfo.assetId) && p.d(this.reversionId, reinstallInfo.reversionId) && p.d(this.semver, reinstallInfo.semver) && p.d(this.displayName, reinstallInfo.displayName);
        }

        public final String getAssetId() {
            return this.assetId;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getReversionId() {
            return this.reversionId;
        }

        public final String getSemver() {
            return this.semver;
        }

        public int hashCode() {
            return (((((this.assetId.hashCode() * 31) + this.reversionId.hashCode()) * 31) + this.semver.hashCode()) * 31) + this.displayName.hashCode();
        }

        public String toString() {
            return "ReinstallInfo(assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", semver=" + this.semver + ", displayName=" + this.displayName + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$UpdateInfo;", "", "assetId", "", "reversionId", "semver", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssetId", "()Ljava/lang/String;", "getReversionId", "getSemver", "getDisplayName", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdateInfo {
        private final String assetId;
        private final String displayName;
        private final String reversionId;
        private final String semver;

        public UpdateInfo(String assetId, String reversionId, String semver, String displayName) {
            p.i(assetId, "assetId");
            p.i(reversionId, "reversionId");
            p.i(semver, "semver");
            p.i(displayName, "displayName");
            this.assetId = assetId;
            this.reversionId = reversionId;
            this.semver = semver;
            this.displayName = displayName;
        }

        public static /* synthetic */ UpdateInfo copy$default(UpdateInfo updateInfo, String str, String str2, String str3, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = updateInfo.assetId;
            }
            if ((i10 & 2) != 0) {
                str2 = updateInfo.reversionId;
            }
            if ((i10 & 4) != 0) {
                str3 = updateInfo.semver;
            }
            if ((i10 & 8) != 0) {
                str4 = updateInfo.displayName;
            }
            return updateInfo.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAssetId() {
            return this.assetId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReversionId() {
            return this.reversionId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSemver() {
            return this.semver;
        }

        /* renamed from: component4, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        public final UpdateInfo copy(String assetId, String reversionId, String semver, String displayName) {
            p.i(assetId, "assetId");
            p.i(reversionId, "reversionId");
            p.i(semver, "semver");
            p.i(displayName, "displayName");
            return new UpdateInfo(assetId, reversionId, semver, displayName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateInfo)) {
                return false;
            }
            UpdateInfo updateInfo = (UpdateInfo) other;
            return p.d(this.assetId, updateInfo.assetId) && p.d(this.reversionId, updateInfo.reversionId) && p.d(this.semver, updateInfo.semver) && p.d(this.displayName, updateInfo.displayName);
        }

        public final String getAssetId() {
            return this.assetId;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getReversionId() {
            return this.reversionId;
        }

        public final String getSemver() {
            return this.semver;
        }

        public int hashCode() {
            return (((((this.assetId.hashCode() * 31) + this.reversionId.hashCode()) * 31) + this.semver.hashCode()) * 31) + this.displayName.hashCode();
        }

        public String toString() {
            return "UpdateInfo(assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", semver=" + this.semver + ", displayName=" + this.displayName + ")";
        }
    }

    void bindDevice(String deviceToken, String agentType, BindCallback callback);

    boolean deleteDevice(String deviceId, String agentType, boolean alsoDeleteData);

    void enableMarketAgent(String assetId, InterfaceC5074l<? super Boolean, t> callback);

    ConnectedDevice findDevice(String deviceId);

    void installMarketAgent(String assetId, String reversionId, String semver, String displayName, InterfaceC5074l<? super Boolean, t> callback);

    List<ConnectedDevice> listConnectedDevices();

    List<SidebarAgent> listSidebarAgents();

    void queryDeviceAgentOnline(String deviceId, String agentType, InterfaceC5074l<? super Result<Boolean>, t> callback);

    boolean reconnectDevice(String deviceId);

    boolean renameDevice(String deviceId, String agentType, String newName);

    void resolveBusyMarketAgent(String agentId, InterfaceC5074l<? super BusyInfo, t> callback);

    void resolveDisabledMarketAgent(String agentId, InterfaceC5074l<? super DisabledInfo, t> callback);

    void resolveReinstallableAgent(String agentId, InterfaceC5074l<? super ReinstallInfo, t> callback);

    void resolveUpdatableAgent(String agentId, InterfaceC5074l<? super UpdateInfo, t> callback);

    void uninstallInstalledAgent(String assetId, String reversionId, String semver, String displayName, InterfaceC5074l<? super Boolean, t> callback);

    void updateMarketAgent(String assetId, String reversionId, String semver, String displayName, InterfaceC5074l<? super Boolean, t> callback);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "", "agentId", "", "deviceId", "displayName", "agentType", G.NETWORK_ONLINE, "", "pinned", "updateAt", "", "installed", d.EXTRA_ENABLED, "assetId", "reversionId", "semver", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgentId", "()Ljava/lang/String;", "getDeviceId", "getDisplayName", "getAgentType", "getOnline", "()Z", "getPinned", "getUpdateAt", "()J", "getInstalled", "getEnabled", "getAssetId", "getReversionId", "getSemver", "getIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SidebarAgent {
        private final String agentId;
        private final String agentType;
        private final String assetId;
        private final String deviceId;
        private final String displayName;
        private final boolean enabled;
        private final String icon;
        private final boolean installed;
        private final boolean online;
        private final boolean pinned;
        private final String reversionId;
        private final String semver;
        private final long updateAt;

        public SidebarAgent(String agentId, String deviceId, String displayName, String agentType, boolean z10, boolean z11, long j10, boolean z12, boolean z13, String assetId, String reversionId, String semver, String icon) {
            p.i(agentId, "agentId");
            p.i(deviceId, "deviceId");
            p.i(displayName, "displayName");
            p.i(agentType, "agentType");
            p.i(assetId, "assetId");
            p.i(reversionId, "reversionId");
            p.i(semver, "semver");
            p.i(icon, "icon");
            this.agentId = agentId;
            this.deviceId = deviceId;
            this.displayName = displayName;
            this.agentType = agentType;
            this.online = z10;
            this.pinned = z11;
            this.updateAt = j10;
            this.installed = z12;
            this.enabled = z13;
            this.assetId = assetId;
            this.reversionId = reversionId;
            this.semver = semver;
            this.icon = icon;
        }

        /* renamed from: component1, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        /* renamed from: component10, reason: from getter */
        public final String getAssetId() {
            return this.assetId;
        }

        /* renamed from: component11, reason: from getter */
        public final String getReversionId() {
            return this.reversionId;
        }

        /* renamed from: component12, reason: from getter */
        public final String getSemver() {
            return this.semver;
        }

        /* renamed from: component13, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getAgentType() {
            return this.agentType;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getOnline() {
            return this.online;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getPinned() {
            return this.pinned;
        }

        /* renamed from: component7, reason: from getter */
        public final long getUpdateAt() {
            return this.updateAt;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getInstalled() {
            return this.installed;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        public final SidebarAgent copy(String agentId, String deviceId, String displayName, String agentType, boolean online, boolean pinned, long updateAt, boolean installed, boolean enabled, String assetId, String reversionId, String semver, String icon) {
            p.i(agentId, "agentId");
            p.i(deviceId, "deviceId");
            p.i(displayName, "displayName");
            p.i(agentType, "agentType");
            p.i(assetId, "assetId");
            p.i(reversionId, "reversionId");
            p.i(semver, "semver");
            p.i(icon, "icon");
            return new SidebarAgent(agentId, deviceId, displayName, agentType, online, pinned, updateAt, installed, enabled, assetId, reversionId, semver, icon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SidebarAgent)) {
                return false;
            }
            SidebarAgent sidebarAgent = (SidebarAgent) other;
            return p.d(this.agentId, sidebarAgent.agentId) && p.d(this.deviceId, sidebarAgent.deviceId) && p.d(this.displayName, sidebarAgent.displayName) && p.d(this.agentType, sidebarAgent.agentType) && this.online == sidebarAgent.online && this.pinned == sidebarAgent.pinned && this.updateAt == sidebarAgent.updateAt && this.installed == sidebarAgent.installed && this.enabled == sidebarAgent.enabled && p.d(this.assetId, sidebarAgent.assetId) && p.d(this.reversionId, sidebarAgent.reversionId) && p.d(this.semver, sidebarAgent.semver) && p.d(this.icon, sidebarAgent.icon);
        }

        public final String getAgentId() {
            return this.agentId;
        }

        public final String getAgentType() {
            return this.agentType;
        }

        public final String getAssetId() {
            return this.assetId;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final boolean getInstalled() {
            return this.installed;
        }

        public final boolean getOnline() {
            return this.online;
        }

        public final boolean getPinned() {
            return this.pinned;
        }

        public final String getReversionId() {
            return this.reversionId;
        }

        public final String getSemver() {
            return this.semver;
        }

        public final long getUpdateAt() {
            return this.updateAt;
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.agentId.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.agentType.hashCode()) * 31) + Boolean.hashCode(this.online)) * 31) + Boolean.hashCode(this.pinned)) * 31) + Long.hashCode(this.updateAt)) * 31) + Boolean.hashCode(this.installed)) * 31) + Boolean.hashCode(this.enabled)) * 31) + this.assetId.hashCode()) * 31) + this.reversionId.hashCode()) * 31) + this.semver.hashCode()) * 31) + this.icon.hashCode();
        }

        public String toString() {
            return "SidebarAgent(agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", displayName=" + this.displayName + ", agentType=" + this.agentType + ", online=" + this.online + ", pinned=" + this.pinned + ", updateAt=" + this.updateAt + ", installed=" + this.installed + ", enabled=" + this.enabled + ", assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", semver=" + this.semver + ", icon=" + this.icon + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ SidebarAgent(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, boolean r23, long r24, boolean r26, boolean r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, int r32, kotlin.jvm.internal.i r33) {
            /*
                r17 = this;
                r0 = r32
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L9
                r1 = 1
                r12 = r1
                goto Lb
            L9:
                r12 = r27
            Lb:
                r1 = r0 & 512(0x200, float:7.17E-43)
                java.lang.String r2 = ""
                if (r1 == 0) goto L13
                r13 = r2
                goto L15
            L13:
                r13 = r28
            L15:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L1b
                r14 = r2
                goto L1d
            L1b:
                r14 = r29
            L1d:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L23
                r15 = r2
                goto L25
            L23:
                r15 = r30
            L25:
                r0 = r0 & 4096(0x1000, float:5.74E-42)
                if (r0 == 0) goto L3e
                r16 = r2
                r3 = r18
                r4 = r19
                r5 = r20
                r6 = r21
                r7 = r22
                r8 = r23
                r9 = r24
                r11 = r26
                r2 = r17
                goto L52
            L3e:
                r16 = r31
                r2 = r17
                r3 = r18
                r4 = r19
                r5 = r20
                r6 = r21
                r7 = r22
                r8 = r23
                r9 = r24
                r11 = r26
            L52:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService.SidebarAgent.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, long, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
        }
    }
}
