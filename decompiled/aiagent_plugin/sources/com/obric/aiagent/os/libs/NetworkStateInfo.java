package com.obric.aiagent.os.libs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NetworkStateInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkStateInfo {

    @SerializedName("CellularQoEQueue")
    private final List<CellularQoE> cellularQoEQueue;

    @SerializedName("defaultNetworkInfo")
    private final NetworkInfo defaultNetworkInfo;

    @SerializedName("isIdleMode")
    private final Boolean isIdleMode;

    @SerializedName("isPowerSaveMode")
    private final Boolean isPowerSaveMode;

    @SerializedName("isSleepMode")
    private final Boolean isSleepMode;

    @SerializedName("L4QoEQueue")
    private final List<L4QoE> l4QoEQueue;

    @SerializedName("networkChangedEvents")
    private final List<NetworkChangedEvent> networkChangedEvents;

    @SerializedName("powerModeChangedEvents")
    private final List<PowerModeChangedEvent> powerModeChangedEvents;

    @SerializedName("vipStrategyReport")
    private final VipStrategyReport vipStrategyReport;

    @SerializedName("wifiQoEQueue")
    private final List<WifiQoE> wifiQoEQueue;

    public NetworkStateInfo() {
        this(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    public static /* synthetic */ NetworkStateInfo copy$default(NetworkStateInfo r11, List r12, List r13, List r14, List r15, List r16, NetworkInfo r17, VipStrategyReport r18, Boolean r19, Boolean r20, Boolean r21, int r22, Object r23) {
        List<NetworkChangedEvent> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List<PowerModeChangedEvent> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List<WifiQoE> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        List<L4QoE> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List<CellularQoE> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if ((r22 & 1) == 0) goto L6;
        r2 = r11.networkChangedEvents;
    L6:
        if ((r22 & 2) == 0) goto L9;
        r4 = r11.powerModeChangedEvents;
    L9:
        if ((r22 & 4) == 0) goto L12;
        r5 = r11.wifiQoEQueue;
    L12:
        if ((r22 & 8) == 0) goto L15;
        r6 = r11.l4QoEQueue;
    L15:
        if ((r22 & 16) == 0) goto L18;
        r3 = r11.cellularQoEQueue;
    L18:
        if ((r22 & 32) == 0) goto L20;
        NetworkInfo r7 = r11.defaultNetworkInfo;
    L22:
        if ((r22 & 64) == 0) goto L24;
        VipStrategyReport r8 = r11.vipStrategyReport;
    L26:
        if ((r22 & 128) == 0) goto L28;
        Boolean r9 = r11.isIdleMode;
    L30:
        if ((r22 & 256) == 0) goto L32;
        Boolean r10 = r11.isPowerSaveMode;
    L34:
        if ((r22 & 512) == 0) goto L36;
        Boolean r1 = r11.isSleepMode;
    L38:
        return r11.copy(r2, r4, r5, r6, r3, r7, r8, r9, r10, r1);
    L36:
        r1 = r21;
        goto L38
    L32:
        r10 = r20;
        goto L34
    L28:
        r9 = r19;
        goto L30
    L24:
        r8 = r18;
        goto L26
    L20:
        r7 = r17;
        goto L22
    }

    public final List<NetworkChangedEvent> component1() {
        return this.networkChangedEvents;
    }

    public final Boolean component10() {
        return this.isSleepMode;
    }

    public final List<PowerModeChangedEvent> component2() {
        return this.powerModeChangedEvents;
    }

    public final List<WifiQoE> component3() {
        return this.wifiQoEQueue;
    }

    public final List<L4QoE> component4() {
        return this.l4QoEQueue;
    }

    public final List<CellularQoE> component5() {
        return this.cellularQoEQueue;
    }

    public final NetworkInfo component6() {
        return this.defaultNetworkInfo;
    }

    public final VipStrategyReport component7() {
        return this.vipStrategyReport;
    }

    public final Boolean component8() {
        return this.isIdleMode;
    }

    public final Boolean component9() {
        return this.isPowerSaveMode;
    }

    public final NetworkStateInfo copy(List<NetworkChangedEvent> r14, List<PowerModeChangedEvent> r15, List<WifiQoE> r16, List<L4QoE> r17, List<CellularQoE> r18, NetworkInfo r19, VipStrategyReport r20, Boolean r21, Boolean r22, Boolean r23) {
        return new NetworkStateInfo((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin"), r19, r20, r21, r22, r23);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NetworkStateInfo.class) == true) goto L8;
        return false;
    L8:
        NetworkStateInfo r6 = (NetworkStateInfo) ZeusTransformUtils.preCheckCast(r5, NetworkStateInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.networkChangedEvents, r6.networkChangedEvents) == true) goto L12;
        return false;
    L12:
        if (o.a(this.powerModeChangedEvents, r6.powerModeChangedEvents) == true) goto L15;
        return false;
    L15:
        if (o.a(this.wifiQoEQueue, r6.wifiQoEQueue) == true) goto L18;
        return false;
    L18:
        if (o.a(this.l4QoEQueue, r6.l4QoEQueue) == true) goto L21;
        return false;
    L21:
        if (o.a(this.cellularQoEQueue, r6.cellularQoEQueue) == true) goto L24;
        return false;
    L24:
        if (o.a(this.defaultNetworkInfo, r6.defaultNetworkInfo) == true) goto L27;
        return false;
    L27:
        if (o.a(this.vipStrategyReport, r6.vipStrategyReport) == true) goto L30;
        return false;
    L30:
        if (o.a(this.isIdleMode, r6.isIdleMode) == true) goto L33;
        return false;
    L33:
        if (o.a(this.isPowerSaveMode, r6.isPowerSaveMode) == true) goto L36;
        return false;
    L36:
        if (o.a(this.isSleepMode, r6.isSleepMode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        List<NetworkChangedEvent> r0 = this.networkChangedEvents;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<PowerModeChangedEvent> r4 = this.powerModeChangedEvents;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<WifiQoE> r7 = this.wifiQoEQueue;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<L4QoE> r10 = this.l4QoEQueue;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<CellularQoE> r13 = this.cellularQoEQueue;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        NetworkInfo r16 = this.defaultNetworkInfo;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        VipStrategyReport r19 = this.vipStrategyReport;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.isIdleMode;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.isPowerSaveMode;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.isSleepMode;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkStateInfo(networkChangedEvents=" + this.networkChangedEvents + ", powerModeChangedEvents=" + this.powerModeChangedEvents + ", wifiQoEQueue=" + this.wifiQoEQueue + ", l4QoEQueue=" + this.l4QoEQueue + ", cellularQoEQueue=" + this.cellularQoEQueue + ", defaultNetworkInfo=" + this.defaultNetworkInfo + ", vipStrategyReport=" + this.vipStrategyReport + ", isIdleMode=" + this.isIdleMode + ", isPowerSaveMode=" + this.isPowerSaveMode + ", isSleepMode=" + this.isSleepMode + ')';
    }

    public NetworkStateInfo(List<NetworkChangedEvent> r3, List<PowerModeChangedEvent> r4, List<WifiQoE> r5, List<L4QoE> r6, List<CellularQoE> r7, NetworkInfo r8, VipStrategyReport r9, Boolean r10, Boolean r11, Boolean r12) {
        List<NetworkChangedEvent> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<PowerModeChangedEvent> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<WifiQoE> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<L4QoE> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<CellularQoE> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.networkChangedEvents = r13;
        this.powerModeChangedEvents = r14;
        this.wifiQoEQueue = r15;
        this.l4QoEQueue = r16;
        this.cellularQoEQueue = r17;
        this.defaultNetworkInfo = r8;
        this.vipStrategyReport = r9;
        this.isIdleMode = r10;
        this.isPowerSaveMode = r11;
        this.isSleepMode = r12;
    }

    public /* synthetic */ NetworkStateInfo(List r12, List r13, List r14, List r15, List r16, NetworkInfo r17, VipStrategyReport r18, Boolean r19, Boolean r20, Boolean r21, int r22, h r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        Boolean r7 = null;
        if ((r22 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r22 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r22 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r22 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r22 & 16) == 0) goto L18;
        r2 = null;
    L18:
        if ((r22 & 32) == 0) goto L20;
        NetworkInfo r6 = null;
    L22:
        if ((r22 & 64) == 0) goto L24;
        VipStrategyReport r8 = null;
    L26:
        if ((r22 & 128) == 0) goto L28;
        Boolean r9 = null;
    L30:
        if ((r22 & 256) == 0) goto L32;
        Boolean r10 = null;
    L34:
        if ((r22 & 512) != 0) goto L37;
        r7 = r21;
    L37:
        this(r1, r3, r4, r5, r2, r6, r8, r9, r10, r7);
        return;
    L32:
        r10 = r20;
        goto L34
    L28:
        r9 = r19;
        goto L30
    L24:
        r8 = r18;
        goto L26
    L20:
        r6 = r17;
        goto L22
    }

    public final List<NetworkChangedEvent> getNetworkChangedEvents() {
        return this.networkChangedEvents;
    }

    public final List<PowerModeChangedEvent> getPowerModeChangedEvents() {
        return this.powerModeChangedEvents;
    }

    public final List<WifiQoE> getWifiQoEQueue() {
        return this.wifiQoEQueue;
    }

    public final List<L4QoE> getL4QoEQueue() {
        return this.l4QoEQueue;
    }

    public final List<CellularQoE> getCellularQoEQueue() {
        return this.cellularQoEQueue;
    }

    public final NetworkInfo getDefaultNetworkInfo() {
        return this.defaultNetworkInfo;
    }

    public final VipStrategyReport getVipStrategyReport() {
        return this.vipStrategyReport;
    }

    public final Boolean isIdleMode() {
        return this.isIdleMode;
    }

    public final Boolean isPowerSaveMode() {
        return this.isPowerSaveMode;
    }

    public final Boolean isSleepMode() {
        return this.isSleepMode;
    }

    public final NetworkChangedEvent getLastNetworkEvent() {
        List<NetworkChangedEvent> r10 = this.networkChangedEvents;
        Object r0 = null;
        if (r10 == null) goto L32;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r11.hasNext() == false) goto L28;
        r0 = r11.next();
        if (r11.hasNext() == false) goto L28;
        NetworkChangedEvent r1 = (NetworkChangedEvent) ZeusTransformUtils.preCheckCast(r0, NetworkChangedEvent.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        Long r2 = r1.getTimestamp();
        if (r2 == null) goto L15;
        long r5 = r2.longValue();
    L16:
        Object r3 = r11.next();
        NetworkChangedEvent r7 = (NetworkChangedEvent) ZeusTransformUtils.preCheckCast(r3, NetworkChangedEvent.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r0 = r3;
        r5 = r9;
    L26:
        if (r11.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (NetworkChangedEvent) ZeusTransformUtils.preCheckCast(r0, NetworkChangedEvent.class, "com.obric.aiagent.plugin");
    L32:
        return null;
    }

    public final PowerModeChangedEvent getLastPowerModeEvent() {
        List<PowerModeChangedEvent> r10 = this.powerModeChangedEvents;
        Object r0 = null;
        if (r10 == null) goto L32;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r11.hasNext() == false) goto L28;
        r0 = r11.next();
        if (r11.hasNext() == false) goto L28;
        PowerModeChangedEvent r1 = (PowerModeChangedEvent) ZeusTransformUtils.preCheckCast(r0, PowerModeChangedEvent.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        Long r2 = r1.getTimestamp();
        if (r2 == null) goto L15;
        long r5 = r2.longValue();
    L16:
        Object r3 = r11.next();
        PowerModeChangedEvent r7 = (PowerModeChangedEvent) ZeusTransformUtils.preCheckCast(r3, PowerModeChangedEvent.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r0 = r3;
        r5 = r9;
    L26:
        if (r11.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (PowerModeChangedEvent) ZeusTransformUtils.preCheckCast(r0, PowerModeChangedEvent.class, "com.obric.aiagent.plugin");
    L32:
        return null;
    }

    public final WifiQoE getLastWifiQoE() {
        List<WifiQoE> r10 = this.wifiQoEQueue;
        Object r0 = null;
        if (r10 == null) goto L32;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r11.hasNext() == false) goto L28;
        r0 = r11.next();
        if (r11.hasNext() == false) goto L28;
        WifiQoE r1 = (WifiQoE) ZeusTransformUtils.preCheckCast(r0, WifiQoE.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        Long r2 = r1.getTimestamp();
        if (r2 == null) goto L15;
        long r5 = r2.longValue();
    L16:
        Object r3 = r11.next();
        WifiQoE r7 = (WifiQoE) ZeusTransformUtils.preCheckCast(r3, WifiQoE.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r0 = r3;
        r5 = r9;
    L26:
        if (r11.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (WifiQoE) ZeusTransformUtils.preCheckCast(r0, WifiQoE.class, "com.obric.aiagent.plugin");
    L32:
        return null;
    }

    public final L4QoE getLastL4QoE() {
        List<L4QoE> r10 = this.l4QoEQueue;
        Object r0 = null;
        if (r10 == null) goto L32;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r11.hasNext() == false) goto L28;
        r0 = r11.next();
        if (r11.hasNext() == false) goto L28;
        L4QoE r1 = (L4QoE) ZeusTransformUtils.preCheckCast(r0, L4QoE.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        Long r2 = r1.getTimestamp();
        if (r2 == null) goto L15;
        long r5 = r2.longValue();
    L16:
        Object r3 = r11.next();
        L4QoE r7 = (L4QoE) ZeusTransformUtils.preCheckCast(r3, L4QoE.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r0 = r3;
        r5 = r9;
    L26:
        if (r11.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (L4QoE) ZeusTransformUtils.preCheckCast(r0, L4QoE.class, "com.obric.aiagent.plugin");
    L32:
        return null;
    }

    public final CellularQoE getLastCellularQoE() {
        List<CellularQoE> r10 = this.cellularQoEQueue;
        Object r0 = null;
        if (r10 == null) goto L32;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r11.hasNext() == false) goto L28;
        r0 = r11.next();
        if (r11.hasNext() == false) goto L28;
        CellularQoE r1 = (CellularQoE) ZeusTransformUtils.preCheckCast(r0, CellularQoE.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        Long r2 = r1.getTimestamp();
        if (r2 == null) goto L15;
        long r5 = r2.longValue();
    L16:
        Object r3 = r11.next();
        CellularQoE r7 = (CellularQoE) ZeusTransformUtils.preCheckCast(r3, CellularQoE.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L21;
        Long r8 = r7.getTimestamp();
        if (r8 == null) goto L21;
        long r9 = r8.longValue();
    L23:
        if (r5 >= r9) goto L26;
        r0 = r3;
        r5 = r9;
    L26:
        if (r11.hasNext() == true) goto L16;
    L21:
        r9 = 0;
    L15:
        r5 = 0;
    L28:
        return (CellularQoE) ZeusTransformUtils.preCheckCast(r0, CellularQoE.class, "com.obric.aiagent.plugin");
    L32:
        return null;
    }
}
