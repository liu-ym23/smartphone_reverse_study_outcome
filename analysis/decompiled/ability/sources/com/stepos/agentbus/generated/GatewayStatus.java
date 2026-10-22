package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003JF\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/stepos/agentbus/generated/GatewayStatus;", "", "isReady", "", "processAlive", Constants.PARAM_PID, "", "vendor", "", "version", AppAgent.CONSTRUCT, "(ZZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getProcessAlive", "getPid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVendor", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "(ZZLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentbus/generated/GatewayStatus;", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GatewayStatus {
    private final boolean isReady;
    private final Long pid;
    private final boolean processAlive;
    private final String vendor;
    private final String version;

    public GatewayStatus(boolean z10, boolean z11, Long l, String str, String str2) {
        this.isReady = z10;
        this.processAlive = z11;
        this.pid = l;
        this.vendor = str;
        this.version = str2;
    }

    public static /* synthetic */ GatewayStatus copy$default(GatewayStatus gatewayStatus, boolean z10, boolean z11, Long l, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = gatewayStatus.isReady;
        }
        if ((i & 2) != 0) {
            z11 = gatewayStatus.processAlive;
        }
        if ((i & 4) != 0) {
            l = gatewayStatus.pid;
        }
        if ((i & 8) != 0) {
            str = gatewayStatus.vendor;
        }
        if ((i & 16) != 0) {
            str2 = gatewayStatus.version;
        }
        String str3 = str2;
        Long l5 = l;
        return gatewayStatus.copy(z10, z11, l5, str, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsReady() {
        return this.isReady;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getProcessAlive() {
        return this.processAlive;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getPid() {
        return this.pid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVendor() {
        return this.vendor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final GatewayStatus copy(boolean isReady, boolean processAlive, Long pid, String vendor, String version) {
        return new GatewayStatus(isReady, processAlive, pid, vendor, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayStatus)) {
            return false;
        }
        GatewayStatus gatewayStatus = (GatewayStatus) other;
        return this.isReady == gatewayStatus.isReady && this.processAlive == gatewayStatus.processAlive && k.b(this.pid, gatewayStatus.pid) && k.b(this.vendor, gatewayStatus.vendor) && k.b(this.version, gatewayStatus.version);
    }

    public final Long getPid() {
        return this.pid;
    }

    public final boolean getProcessAlive() {
        return this.processAlive;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(Boolean.hashCode(this.isReady) * 31, 31, this.processAlive);
        Long l = this.pid;
        int iHashCode = (iD + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.vendor;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isReady() {
        return this.isReady;
    }

    public String toString() {
        boolean z10 = this.isReady;
        boolean z11 = this.processAlive;
        Long l = this.pid;
        String str = this.vendor;
        String str2 = this.version;
        StringBuilder sb = new StringBuilder("GatewayStatus(isReady=");
        sb.append(z10);
        sb.append(", processAlive=");
        sb.append(z11);
        sb.append(", pid=");
        sb.append(l);
        sb.append(", vendor=");
        sb.append(str);
        sb.append(", version=");
        return B7.a.q(sb, str2, ")");
    }

    public /* synthetic */ GatewayStatus(boolean z10, boolean z11, Long l, String str, String str2, int i, e eVar) {
        this(z10, z11, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }
}
