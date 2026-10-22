package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010(\u001a\u00020\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J|\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u00061"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "stableId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "name", "host", ConfigIpcContract.KEY_PORT, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lanHost", "tailnetDns", "gatewayPort", "canvasPort", "tlsEnabled", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tlsFingerprintSha256", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V", "getStableId", "()Ljava/lang/String;", "getName", "getHost", "getPort", "()I", "getLanHost", "getTailnetDns", "getGatewayPort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCanvasPort", "getTlsEnabled", "()Z", "getTlsFingerprintSha256", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "equals", "other", "hashCode", "toString", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayEndpoint {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer canvasPort;
    private final Integer gatewayPort;
    private final String host;
    private final String lanHost;
    private final String name;
    private final int port;
    private final String stableId;
    private final String tailnetDns;
    private final boolean tlsEnabled;
    private final String tlsFingerprintSha256;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayEndpoint$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "manual", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "host", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PORT, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final GatewayEndpoint manual(String host, int port) {
            p.e(host, "host");
            String lowerCase = host.toLowerCase(Locale.ROOT);
            p.d(lowerCase, "toLowerCase(...)");
            return new GatewayEndpoint("manual|" + lowerCase + "|" + port, host + ":" + port, host, port, null, null, null, null, false, null, 240, null);
        }

        private Companion() {
        }
    }

    public GatewayEndpoint(String stableId, String name, String host, int i8, String str, String str2, Integer num, Integer num2, boolean z, String str3) {
        p.e(stableId, "stableId");
        p.e(name, "name");
        p.e(host, "host");
        this.stableId = stableId;
        this.name = name;
        this.host = host;
        this.port = i8;
        this.lanHost = str;
        this.tailnetDns = str2;
        this.gatewayPort = num;
        this.canvasPort = num2;
        this.tlsEnabled = z;
        this.tlsFingerprintSha256 = str3;
    }

    public static /* synthetic */ GatewayEndpoint copy$default(GatewayEndpoint gatewayEndpoint, String str, String str2, String str3, int i8, String str4, String str5, Integer num, Integer num2, boolean z, String str6, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = gatewayEndpoint.stableId;
        }
        if ((i9 & 2) != 0) {
            str2 = gatewayEndpoint.name;
        }
        if ((i9 & 4) != 0) {
            str3 = gatewayEndpoint.host;
        }
        if ((i9 & 8) != 0) {
            i8 = gatewayEndpoint.port;
        }
        if ((i9 & 16) != 0) {
            str4 = gatewayEndpoint.lanHost;
        }
        if ((i9 & 32) != 0) {
            str5 = gatewayEndpoint.tailnetDns;
        }
        if ((i9 & 64) != 0) {
            num = gatewayEndpoint.gatewayPort;
        }
        if ((i9 & 128) != 0) {
            num2 = gatewayEndpoint.canvasPort;
        }
        if ((i9 & 256) != 0) {
            z = gatewayEndpoint.tlsEnabled;
        }
        if ((i9 & 512) != 0) {
            str6 = gatewayEndpoint.tlsFingerprintSha256;
        }
        boolean z2 = z;
        String str7 = str6;
        Integer num3 = num;
        Integer num4 = num2;
        String str8 = str4;
        String str9 = str5;
        return gatewayEndpoint.copy(str, str2, str3, i8, str8, str9, num3, num4, z2, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStableId() {
        return this.stableId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTlsFingerprintSha256() {
        return this.tlsFingerprintSha256;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLanHost() {
        return this.lanHost;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTailnetDns() {
        return this.tailnetDns;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getGatewayPort() {
        return this.gatewayPort;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getCanvasPort() {
        return this.canvasPort;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getTlsEnabled() {
        return this.tlsEnabled;
    }

    public final GatewayEndpoint copy(String stableId, String name, String host, int port, String lanHost, String tailnetDns, Integer gatewayPort, Integer canvasPort, boolean tlsEnabled, String tlsFingerprintSha256) {
        p.e(stableId, "stableId");
        p.e(name, "name");
        p.e(host, "host");
        return new GatewayEndpoint(stableId, name, host, port, lanHost, tailnetDns, gatewayPort, canvasPort, tlsEnabled, tlsFingerprintSha256);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayEndpoint)) {
            return false;
        }
        GatewayEndpoint gatewayEndpoint = (GatewayEndpoint) other;
        return p.a(this.stableId, gatewayEndpoint.stableId) && p.a(this.name, gatewayEndpoint.name) && p.a(this.host, gatewayEndpoint.host) && this.port == gatewayEndpoint.port && p.a(this.lanHost, gatewayEndpoint.lanHost) && p.a(this.tailnetDns, gatewayEndpoint.tailnetDns) && p.a(this.gatewayPort, gatewayEndpoint.gatewayPort) && p.a(this.canvasPort, gatewayEndpoint.canvasPort) && this.tlsEnabled == gatewayEndpoint.tlsEnabled && p.a(this.tlsFingerprintSha256, gatewayEndpoint.tlsFingerprintSha256);
    }

    public final Integer getCanvasPort() {
        return this.canvasPort;
    }

    public final Integer getGatewayPort() {
        return this.gatewayPort;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getLanHost() {
        return this.lanHost;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPort() {
        return this.port;
    }

    public final String getStableId() {
        return this.stableId;
    }

    public final String getTailnetDns() {
        return this.tailnetDns;
    }

    public final boolean getTlsEnabled() {
        return this.tlsEnabled;
    }

    public final String getTlsFingerprintSha256() {
        return this.tlsFingerprintSha256;
    }

    public int hashCode() {
        int iC = a8.b.C(this.port, a8.b.f(a8.b.f(this.stableId.hashCode() * 31, 31, this.name), 31, this.host), 31);
        String str = this.lanHost;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tailnetDns;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.gatewayPort;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.canvasPort;
        int iG = a8.b.g((iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31, 31, this.tlsEnabled);
        String str3 = this.tlsFingerprintSha256;
        return iG + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.stableId;
        String str2 = this.name;
        String str3 = this.host;
        int i8 = this.port;
        String str4 = this.lanHost;
        String str5 = this.tailnetDns;
        Integer num = this.gatewayPort;
        Integer num2 = this.canvasPort;
        boolean z = this.tlsEnabled;
        String str6 = this.tlsFingerprintSha256;
        StringBuilder sbV = a8.b.v("GatewayEndpoint(stableId=", str, ", name=", str2, ", host=");
        sbV.append(str3);
        sbV.append(", port=");
        sbV.append(i8);
        sbV.append(", lanHost=");
        a8.b.A(sbV, str4, ", tailnetDns=", str5, ", gatewayPort=");
        sbV.append(num);
        sbV.append(", canvasPort=");
        sbV.append(num2);
        sbV.append(", tlsEnabled=");
        sbV.append(z);
        sbV.append(", tlsFingerprintSha256=");
        sbV.append(str6);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ GatewayEndpoint(String str, String str2, String str3, int i8, String str4, String str5, Integer num, Integer num2, boolean z, String str6, int i9, i iVar) {
        this(str, str2, str3, i8, (i9 & 16) != 0 ? null : str4, (i9 & 32) != 0 ? null : str5, (i9 & 64) != 0 ? null : num, (i9 & 128) != 0 ? null : num2, (i9 & 256) != 0 ? false : z, (i9 & 512) != 0 ? null : str6);
    }
}
