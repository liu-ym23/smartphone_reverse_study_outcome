package com.stepos.agentbus.config;

import a.a;
import d7.s;
import d7.z;
import fi.iki.elonen.NanoHTTPD;
import java.util.List;
import kotlin.Metadata;
import m.x;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0099\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00064"}, d2 = {"Lcom/stepos/agentbus/config/OpenClawGatewayUpstream;", "", "endpoint", "", "discoveryEnabled", "", "tlsRequired", "tlsExpectedFingerprint", "tlsAllowTOFU", "deviceKeyFile", "operatorScopes", "", "clientId", "nodePlatform", "nodeCaps", "nodeCommands", "bootstrapToken", "<init>", "(Ljava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getEndpoint", "()Ljava/lang/String;", "getDiscoveryEnabled", "()Z", "getTlsRequired", "getTlsExpectedFingerprint", "getTlsAllowTOFU", "getDeviceKeyFile", "getOperatorScopes", "()Ljava/util/List;", "getClientId", "getNodePlatform", "getNodeCaps", "getNodeCommands", "getBootstrapToken", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OpenClawGatewayUpstream {
    private final String bootstrapToken;
    private final String clientId;
    private final String deviceKeyFile;
    private final boolean discoveryEnabled;
    private final String endpoint;
    private final List<String> nodeCaps;
    private final List<String> nodeCommands;
    private final String nodePlatform;
    private final List<String> operatorScopes;
    private final boolean tlsAllowTOFU;
    private final String tlsExpectedFingerprint;
    private final boolean tlsRequired;

    public OpenClawGatewayUpstream() {
        this(null, false, false, null, false, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ OpenClawGatewayUpstream copy$default(OpenClawGatewayUpstream openClawGatewayUpstream, String str, boolean z4, boolean z10, String str2, boolean z11, String str3, List list, String str4, String str5, List list2, List list3, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = openClawGatewayUpstream.endpoint;
        }
        if ((i2 & 2) != 0) {
            z4 = openClawGatewayUpstream.discoveryEnabled;
        }
        if ((i2 & 4) != 0) {
            z10 = openClawGatewayUpstream.tlsRequired;
        }
        if ((i2 & 8) != 0) {
            str2 = openClawGatewayUpstream.tlsExpectedFingerprint;
        }
        if ((i2 & 16) != 0) {
            z11 = openClawGatewayUpstream.tlsAllowTOFU;
        }
        if ((i2 & 32) != 0) {
            str3 = openClawGatewayUpstream.deviceKeyFile;
        }
        if ((i2 & 64) != 0) {
            list = openClawGatewayUpstream.operatorScopes;
        }
        if ((i2 & 128) != 0) {
            str4 = openClawGatewayUpstream.clientId;
        }
        if ((i2 & 256) != 0) {
            str5 = openClawGatewayUpstream.nodePlatform;
        }
        if ((i2 & 512) != 0) {
            list2 = openClawGatewayUpstream.nodeCaps;
        }
        if ((i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
            list3 = openClawGatewayUpstream.nodeCommands;
        }
        if ((i2 & 2048) != 0) {
            str6 = openClawGatewayUpstream.bootstrapToken;
        }
        List list4 = list3;
        String str7 = str6;
        String str8 = str5;
        List list5 = list2;
        List list6 = list;
        String str9 = str4;
        boolean z12 = z11;
        String str10 = str3;
        return openClawGatewayUpstream.copy(str, z4, z10, str2, z12, str10, list6, str9, str8, list5, list4, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    public final List<String> component10() {
        return this.nodeCaps;
    }

    public final List<String> component11() {
        return this.nodeCommands;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBootstrapToken() {
        return this.bootstrapToken;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDiscoveryEnabled() {
        return this.discoveryEnabled;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getTlsRequired() {
        return this.tlsRequired;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTlsExpectedFingerprint() {
        return this.tlsExpectedFingerprint;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getTlsAllowTOFU() {
        return this.tlsAllowTOFU;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeviceKeyFile() {
        return this.deviceKeyFile;
    }

    public final List<String> component7() {
        return this.operatorScopes;
    }

    /* renamed from: component8, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getNodePlatform() {
        return this.nodePlatform;
    }

    public final OpenClawGatewayUpstream copy(String endpoint, boolean discoveryEnabled, boolean tlsRequired, String tlsExpectedFingerprint, boolean tlsAllowTOFU, String deviceKeyFile, List<String> operatorScopes, String clientId, String nodePlatform, List<String> nodeCaps, List<String> nodeCommands, String bootstrapToken) {
        k.e(deviceKeyFile, "deviceKeyFile");
        k.e(operatorScopes, "operatorScopes");
        k.e(clientId, "clientId");
        k.e(nodePlatform, "nodePlatform");
        k.e(nodeCaps, "nodeCaps");
        k.e(nodeCommands, "nodeCommands");
        return new OpenClawGatewayUpstream(endpoint, discoveryEnabled, tlsRequired, tlsExpectedFingerprint, tlsAllowTOFU, deviceKeyFile, operatorScopes, clientId, nodePlatform, nodeCaps, nodeCommands, bootstrapToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenClawGatewayUpstream)) {
            return false;
        }
        OpenClawGatewayUpstream openClawGatewayUpstream = (OpenClawGatewayUpstream) other;
        return k.a(this.endpoint, openClawGatewayUpstream.endpoint) && this.discoveryEnabled == openClawGatewayUpstream.discoveryEnabled && this.tlsRequired == openClawGatewayUpstream.tlsRequired && k.a(this.tlsExpectedFingerprint, openClawGatewayUpstream.tlsExpectedFingerprint) && this.tlsAllowTOFU == openClawGatewayUpstream.tlsAllowTOFU && k.a(this.deviceKeyFile, openClawGatewayUpstream.deviceKeyFile) && k.a(this.operatorScopes, openClawGatewayUpstream.operatorScopes) && k.a(this.clientId, openClawGatewayUpstream.clientId) && k.a(this.nodePlatform, openClawGatewayUpstream.nodePlatform) && k.a(this.nodeCaps, openClawGatewayUpstream.nodeCaps) && k.a(this.nodeCommands, openClawGatewayUpstream.nodeCommands) && k.a(this.bootstrapToken, openClawGatewayUpstream.bootstrapToken);
    }

    public final String getBootstrapToken() {
        return this.bootstrapToken;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getDeviceKeyFile() {
        return this.deviceKeyFile;
    }

    public final boolean getDiscoveryEnabled() {
        return this.discoveryEnabled;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final List<String> getNodeCaps() {
        return this.nodeCaps;
    }

    public final List<String> getNodeCommands() {
        return this.nodeCommands;
    }

    public final String getNodePlatform() {
        return this.nodePlatform;
    }

    public final List<String> getOperatorScopes() {
        return this.operatorScopes;
    }

    public final boolean getTlsAllowTOFU() {
        return this.tlsAllowTOFU;
    }

    public final String getTlsExpectedFingerprint() {
        return this.tlsExpectedFingerprint;
    }

    public final boolean getTlsRequired() {
        return this.tlsRequired;
    }

    public int hashCode() {
        String str = this.endpoint;
        int iE = x.e(x.e((str == null ? 0 : str.hashCode()) * 31, 31, this.discoveryEnabled), 31, this.tlsRequired);
        String str2 = this.tlsExpectedFingerprint;
        int iH = x.h(this.nodeCommands, x.h(this.nodeCaps, x.g(this.nodePlatform, x.g(this.clientId, x.h(this.operatorScopes, x.g(this.deviceKeyFile, x.e((iE + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.tlsAllowTOFU), 31), 31), 31), 31), 31), 31);
        String str3 = this.bootstrapToken;
        return iH + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "OpenClawGatewayUpstream(endpoint=" + this.endpoint + ", discoveryEnabled=" + this.discoveryEnabled + ", tlsRequired=" + this.tlsRequired + ", tlsExpectedFingerprint=" + this.tlsExpectedFingerprint + ", tlsAllowTOFU=" + this.tlsAllowTOFU + ", deviceKeyFile=" + this.deviceKeyFile + ", operatorScopes=" + this.operatorScopes + ", clientId=" + this.clientId + ", nodePlatform=" + this.nodePlatform + ", nodeCaps=" + this.nodeCaps + ", nodeCommands=" + this.nodeCommands + ", bootstrapToken=" + this.bootstrapToken + ")";
    }

    public OpenClawGatewayUpstream(String str, boolean z4, boolean z10, String str2, boolean z11, String str3, List<String> list, String str4, String str5, List<String> list2, List<String> list3, String str6) {
        k.e(str3, "deviceKeyFile");
        k.e(list, "operatorScopes");
        k.e(str4, "clientId");
        k.e(str5, "nodePlatform");
        k.e(list2, "nodeCaps");
        k.e(list3, "nodeCommands");
        this.endpoint = str;
        this.discoveryEnabled = z4;
        this.tlsRequired = z10;
        this.tlsExpectedFingerprint = str2;
        this.tlsAllowTOFU = z11;
        this.deviceKeyFile = str3;
        this.operatorScopes = list;
        this.clientId = str4;
        this.nodePlatform = str5;
        this.nodeCaps = list2;
        this.nodeCommands = list3;
        this.bootstrapToken = str6;
    }

    public /* synthetic */ OpenClawGatewayUpstream(String str, boolean z4, boolean z10, String str2, boolean z11, String str3, List list, String str4, String str5, List list2, List list3, String str6, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? true : z4, (i2 & 4) != 0 ? false : z10, (i2 & 8) != 0 ? null : str2, (i2 & 16) == 0 ? z11 : true, (i2 & 32) != 0 ? "openclaw_device_key.bin" : str3, (i2 & 64) != 0 ? s.u0("operator.read", "operator.write", "operator.talk.secrets", "operator.admin", "operator.approvals", "operator.pairing") : list, (i2 & 128) != 0 ? "openclaw-android" : str4, (i2 & 256) != 0 ? "android" : str5, (i2 & 512) != 0 ? a.S("system") : list2, (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? z.f2978f : list3, (i2 & 2048) != 0 ? null : str6);
    }
}
