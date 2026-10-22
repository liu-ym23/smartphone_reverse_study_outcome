package com.stepos.agentbus.config;

import a.a;
import d7.s;
import fi.iki.elonen.NanoHTTPD;
import java.util.List;
import kotlin.Metadata;
import m.x;
import q7.f;
import q7.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b>\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J÷\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010G\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001c¨\u0006L"}, d2 = {"Lcom/stepos/agentbus/config/OpenClawCloudUpstream;", "", "endpoint", "", "tlsRequired", "", "tlsExpectedFingerprint", "tlsAllowTOFU", "deviceKeyFile", "clientId", "operatorScopes", "", "nodeCaps", "nodeCommands", "nodePlatform", "bootstrapToken", "secureDataAppId", "mtlsRequired", "mtlsClientCertAlias", "challengeApiBaseUrl", "challengeAppId", "challengeAuthToken", "challengeGatewayAppId", "challengeGatewaySecret", "mtlsFallbackEndpoint", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEndpoint", "()Ljava/lang/String;", "getTlsRequired", "()Z", "getTlsExpectedFingerprint", "getTlsAllowTOFU", "getDeviceKeyFile", "getClientId", "getOperatorScopes", "()Ljava/util/List;", "getNodeCaps", "getNodeCommands", "getNodePlatform", "getBootstrapToken", "getSecureDataAppId", "getMtlsRequired", "getMtlsClientCertAlias", "getChallengeApiBaseUrl", "getChallengeAppId", "getChallengeAuthToken", "getChallengeGatewayAppId", "getChallengeGatewaySecret", "getMtlsFallbackEndpoint", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OpenClawCloudUpstream {
    private final String bootstrapToken;
    private final String challengeApiBaseUrl;
    private final String challengeAppId;
    private final String challengeAuthToken;
    private final String challengeGatewayAppId;
    private final String challengeGatewaySecret;
    private final String clientId;
    private final String deviceKeyFile;
    private final String endpoint;
    private final String mtlsClientCertAlias;
    private final String mtlsFallbackEndpoint;
    private final boolean mtlsRequired;
    private final List<String> nodeCaps;
    private final List<String> nodeCommands;
    private final String nodePlatform;
    private final List<String> operatorScopes;
    private final String secureDataAppId;
    private final boolean tlsAllowTOFU;
    private final String tlsExpectedFingerprint;
    private final boolean tlsRequired;

    public OpenClawCloudUpstream() {
        this(null, false, null, false, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 1048575, null);
    }

    public static /* synthetic */ OpenClawCloudUpstream copy$default(OpenClawCloudUpstream openClawCloudUpstream, String str, boolean z4, String str2, boolean z10, String str3, String str4, List list, List list2, List list3, String str5, String str6, String str7, boolean z11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, Object obj) {
        String str15;
        String str16;
        String str17 = (i2 & 1) != 0 ? openClawCloudUpstream.endpoint : str;
        boolean z12 = (i2 & 2) != 0 ? openClawCloudUpstream.tlsRequired : z4;
        String str18 = (i2 & 4) != 0 ? openClawCloudUpstream.tlsExpectedFingerprint : str2;
        boolean z13 = (i2 & 8) != 0 ? openClawCloudUpstream.tlsAllowTOFU : z10;
        String str19 = (i2 & 16) != 0 ? openClawCloudUpstream.deviceKeyFile : str3;
        String str20 = (i2 & 32) != 0 ? openClawCloudUpstream.clientId : str4;
        List list4 = (i2 & 64) != 0 ? openClawCloudUpstream.operatorScopes : list;
        List list5 = (i2 & 128) != 0 ? openClawCloudUpstream.nodeCaps : list2;
        List list6 = (i2 & 256) != 0 ? openClawCloudUpstream.nodeCommands : list3;
        String str21 = (i2 & 512) != 0 ? openClawCloudUpstream.nodePlatform : str5;
        String str22 = (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? openClawCloudUpstream.bootstrapToken : str6;
        String str23 = (i2 & 2048) != 0 ? openClawCloudUpstream.secureDataAppId : str7;
        boolean z14 = (i2 & 4096) != 0 ? openClawCloudUpstream.mtlsRequired : z11;
        String str24 = (i2 & NanoHTTPD.HTTPSession.BUFSIZE) != 0 ? openClawCloudUpstream.mtlsClientCertAlias : str8;
        String str25 = str17;
        String str26 = (i2 & 16384) != 0 ? openClawCloudUpstream.challengeApiBaseUrl : str9;
        String str27 = (i2 & 32768) != 0 ? openClawCloudUpstream.challengeAppId : str10;
        String str28 = (i2 & 65536) != 0 ? openClawCloudUpstream.challengeAuthToken : str11;
        String str29 = (i2 & 131072) != 0 ? openClawCloudUpstream.challengeGatewayAppId : str12;
        String str30 = (i2 & 262144) != 0 ? openClawCloudUpstream.challengeGatewaySecret : str13;
        if ((i2 & 524288) != 0) {
            str16 = str30;
            str15 = openClawCloudUpstream.mtlsFallbackEndpoint;
        } else {
            str15 = str14;
            str16 = str30;
        }
        return openClawCloudUpstream.copy(str25, z12, str18, z13, str19, str20, list4, list5, list6, str21, str22, str23, z14, str24, str26, str27, str28, str29, str16, str15);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* renamed from: component10, reason: from getter */
    public final String getNodePlatform() {
        return this.nodePlatform;
    }

    /* renamed from: component11, reason: from getter */
    public final String getBootstrapToken() {
        return this.bootstrapToken;
    }

    /* renamed from: component12, reason: from getter */
    public final String getSecureDataAppId() {
        return this.secureDataAppId;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getMtlsRequired() {
        return this.mtlsRequired;
    }

    /* renamed from: component14, reason: from getter */
    public final String getMtlsClientCertAlias() {
        return this.mtlsClientCertAlias;
    }

    /* renamed from: component15, reason: from getter */
    public final String getChallengeApiBaseUrl() {
        return this.challengeApiBaseUrl;
    }

    /* renamed from: component16, reason: from getter */
    public final String getChallengeAppId() {
        return this.challengeAppId;
    }

    /* renamed from: component17, reason: from getter */
    public final String getChallengeAuthToken() {
        return this.challengeAuthToken;
    }

    /* renamed from: component18, reason: from getter */
    public final String getChallengeGatewayAppId() {
        return this.challengeGatewayAppId;
    }

    /* renamed from: component19, reason: from getter */
    public final String getChallengeGatewaySecret() {
        return this.challengeGatewaySecret;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getTlsRequired() {
        return this.tlsRequired;
    }

    /* renamed from: component20, reason: from getter */
    public final String getMtlsFallbackEndpoint() {
        return this.mtlsFallbackEndpoint;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTlsExpectedFingerprint() {
        return this.tlsExpectedFingerprint;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getTlsAllowTOFU() {
        return this.tlsAllowTOFU;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDeviceKeyFile() {
        return this.deviceKeyFile;
    }

    /* renamed from: component6, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    public final List<String> component7() {
        return this.operatorScopes;
    }

    public final List<String> component8() {
        return this.nodeCaps;
    }

    public final List<String> component9() {
        return this.nodeCommands;
    }

    public final OpenClawCloudUpstream copy(String endpoint, boolean tlsRequired, String tlsExpectedFingerprint, boolean tlsAllowTOFU, String deviceKeyFile, String clientId, List<String> operatorScopes, List<String> nodeCaps, List<String> nodeCommands, String nodePlatform, String bootstrapToken, String secureDataAppId, boolean mtlsRequired, String mtlsClientCertAlias, String challengeApiBaseUrl, String challengeAppId, String challengeAuthToken, String challengeGatewayAppId, String challengeGatewaySecret, String mtlsFallbackEndpoint) {
        k.e(deviceKeyFile, "deviceKeyFile");
        k.e(clientId, "clientId");
        k.e(operatorScopes, "operatorScopes");
        k.e(nodeCaps, "nodeCaps");
        k.e(nodeCommands, "nodeCommands");
        k.e(nodePlatform, "nodePlatform");
        k.e(challengeAppId, "challengeAppId");
        return new OpenClawCloudUpstream(endpoint, tlsRequired, tlsExpectedFingerprint, tlsAllowTOFU, deviceKeyFile, clientId, operatorScopes, nodeCaps, nodeCommands, nodePlatform, bootstrapToken, secureDataAppId, mtlsRequired, mtlsClientCertAlias, challengeApiBaseUrl, challengeAppId, challengeAuthToken, challengeGatewayAppId, challengeGatewaySecret, mtlsFallbackEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenClawCloudUpstream)) {
            return false;
        }
        OpenClawCloudUpstream openClawCloudUpstream = (OpenClawCloudUpstream) other;
        return k.a(this.endpoint, openClawCloudUpstream.endpoint) && this.tlsRequired == openClawCloudUpstream.tlsRequired && k.a(this.tlsExpectedFingerprint, openClawCloudUpstream.tlsExpectedFingerprint) && this.tlsAllowTOFU == openClawCloudUpstream.tlsAllowTOFU && k.a(this.deviceKeyFile, openClawCloudUpstream.deviceKeyFile) && k.a(this.clientId, openClawCloudUpstream.clientId) && k.a(this.operatorScopes, openClawCloudUpstream.operatorScopes) && k.a(this.nodeCaps, openClawCloudUpstream.nodeCaps) && k.a(this.nodeCommands, openClawCloudUpstream.nodeCommands) && k.a(this.nodePlatform, openClawCloudUpstream.nodePlatform) && k.a(this.bootstrapToken, openClawCloudUpstream.bootstrapToken) && k.a(this.secureDataAppId, openClawCloudUpstream.secureDataAppId) && this.mtlsRequired == openClawCloudUpstream.mtlsRequired && k.a(this.mtlsClientCertAlias, openClawCloudUpstream.mtlsClientCertAlias) && k.a(this.challengeApiBaseUrl, openClawCloudUpstream.challengeApiBaseUrl) && k.a(this.challengeAppId, openClawCloudUpstream.challengeAppId) && k.a(this.challengeAuthToken, openClawCloudUpstream.challengeAuthToken) && k.a(this.challengeGatewayAppId, openClawCloudUpstream.challengeGatewayAppId) && k.a(this.challengeGatewaySecret, openClawCloudUpstream.challengeGatewaySecret) && k.a(this.mtlsFallbackEndpoint, openClawCloudUpstream.mtlsFallbackEndpoint);
    }

    public final String getBootstrapToken() {
        return this.bootstrapToken;
    }

    public final String getChallengeApiBaseUrl() {
        return this.challengeApiBaseUrl;
    }

    public final String getChallengeAppId() {
        return this.challengeAppId;
    }

    public final String getChallengeAuthToken() {
        return this.challengeAuthToken;
    }

    public final String getChallengeGatewayAppId() {
        return this.challengeGatewayAppId;
    }

    public final String getChallengeGatewaySecret() {
        return this.challengeGatewaySecret;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getDeviceKeyFile() {
        return this.deviceKeyFile;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getMtlsClientCertAlias() {
        return this.mtlsClientCertAlias;
    }

    public final String getMtlsFallbackEndpoint() {
        return this.mtlsFallbackEndpoint;
    }

    public final boolean getMtlsRequired() {
        return this.mtlsRequired;
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

    public final String getSecureDataAppId() {
        return this.secureDataAppId;
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
        int iE = x.e((str == null ? 0 : str.hashCode()) * 31, 31, this.tlsRequired);
        String str2 = this.tlsExpectedFingerprint;
        int iG = x.g(this.nodePlatform, x.h(this.nodeCommands, x.h(this.nodeCaps, x.h(this.operatorScopes, x.g(this.clientId, x.g(this.deviceKeyFile, x.e((iE + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.tlsAllowTOFU), 31), 31), 31), 31), 31), 31);
        String str3 = this.bootstrapToken;
        int iHashCode = (iG + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.secureDataAppId;
        int iE2 = x.e((iHashCode + (str4 == null ? 0 : str4.hashCode())) * 31, 31, this.mtlsRequired);
        String str5 = this.mtlsClientCertAlias;
        int iHashCode2 = (iE2 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.challengeApiBaseUrl;
        int iG2 = x.g(this.challengeAppId, (iHashCode2 + (str6 == null ? 0 : str6.hashCode())) * 31, 31);
        String str7 = this.challengeAuthToken;
        int iHashCode3 = (iG2 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.challengeGatewayAppId;
        int iHashCode4 = (iHashCode3 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.challengeGatewaySecret;
        int iHashCode5 = (iHashCode4 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.mtlsFallbackEndpoint;
        return iHashCode5 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        String str = this.endpoint;
        boolean z4 = this.tlsRequired;
        String str2 = this.tlsExpectedFingerprint;
        boolean z10 = this.tlsAllowTOFU;
        String str3 = this.deviceKeyFile;
        String str4 = this.clientId;
        List<String> list = this.operatorScopes;
        List<String> list2 = this.nodeCaps;
        List<String> list3 = this.nodeCommands;
        String str5 = this.nodePlatform;
        String str6 = this.bootstrapToken;
        String str7 = this.secureDataAppId;
        boolean z11 = this.mtlsRequired;
        String str8 = this.mtlsClientCertAlias;
        String str9 = this.challengeApiBaseUrl;
        String str10 = this.challengeAppId;
        String str11 = this.challengeAuthToken;
        String str12 = this.challengeGatewayAppId;
        String str13 = this.challengeGatewaySecret;
        String str14 = this.mtlsFallbackEndpoint;
        StringBuilder sb2 = new StringBuilder("OpenClawCloudUpstream(endpoint=");
        sb2.append(str);
        sb2.append(", tlsRequired=");
        sb2.append(z4);
        sb2.append(", tlsExpectedFingerprint=");
        sb2.append(str2);
        sb2.append(", tlsAllowTOFU=");
        sb2.append(z10);
        sb2.append(", deviceKeyFile=");
        x.w(sb2, str3, ", clientId=", str4, ", operatorScopes=");
        sb2.append(list);
        sb2.append(", nodeCaps=");
        sb2.append(list2);
        sb2.append(", nodeCommands=");
        sb2.append(list3);
        sb2.append(", nodePlatform=");
        sb2.append(str5);
        sb2.append(", bootstrapToken=");
        x.w(sb2, str6, ", secureDataAppId=", str7, ", mtlsRequired=");
        sb2.append(z11);
        sb2.append(", mtlsClientCertAlias=");
        sb2.append(str8);
        sb2.append(", challengeApiBaseUrl=");
        x.w(sb2, str9, ", challengeAppId=", str10, ", challengeAuthToken=");
        x.w(sb2, str11, ", challengeGatewayAppId=", str12, ", challengeGatewaySecret=");
        sb2.append(str13);
        sb2.append(", mtlsFallbackEndpoint=");
        sb2.append(str14);
        sb2.append(")");
        return sb2.toString();
    }

    public OpenClawCloudUpstream(String str, boolean z4, String str2, boolean z10, String str3, String str4, List<String> list, List<String> list2, List<String> list3, String str5, String str6, String str7, boolean z11, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        k.e(str3, "deviceKeyFile");
        k.e(str4, "clientId");
        k.e(list, "operatorScopes");
        k.e(list2, "nodeCaps");
        k.e(list3, "nodeCommands");
        k.e(str5, "nodePlatform");
        k.e(str10, "challengeAppId");
        this.endpoint = str;
        this.tlsRequired = z4;
        this.tlsExpectedFingerprint = str2;
        this.tlsAllowTOFU = z10;
        this.deviceKeyFile = str3;
        this.clientId = str4;
        this.operatorScopes = list;
        this.nodeCaps = list2;
        this.nodeCommands = list3;
        this.nodePlatform = str5;
        this.bootstrapToken = str6;
        this.secureDataAppId = str7;
        this.mtlsRequired = z11;
        this.mtlsClientCertAlias = str8;
        this.challengeApiBaseUrl = str9;
        this.challengeAppId = str10;
        this.challengeAuthToken = str11;
        this.challengeGatewayAppId = str12;
        this.challengeGatewaySecret = str13;
        this.mtlsFallbackEndpoint = str14;
    }

    public /* synthetic */ OpenClawCloudUpstream(String str, boolean z4, String str2, boolean z10, String str3, String str4, List list, List list2, List list3, String str5, String str6, String str7, boolean z11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? true : z4, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? false : z10, (i2 & 16) != 0 ? "openclaw_cloud_device_key.bin" : str3, (i2 & 32) != 0 ? "openclaw-android" : str4, (i2 & 64) != 0 ? s.u0("operator.read", "operator.write", "operator.admin") : list, (i2 & 128) != 0 ? a.S("system") : list2, (i2 & 256) != 0 ? s.u0("system.run", "system.which", "stepclaw.exec", "agent.call", "ability.call") : list3, (i2 & 512) != 0 ? "linux" : str5, (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? null : str6, (i2 & 2048) != 0 ? "cloud-claw-chat" : str7, (i2 & 4096) == 0 ? z11 : false, (i2 & NanoHTTPD.HTTPSession.BUFSIZE) != 0 ? null : str8, (i2 & 16384) != 0 ? null : str9, (i2 & 32768) != 0 ? "agentbus" : str10, (i2 & 65536) != 0 ? null : str11, (i2 & 131072) != 0 ? null : str12, (i2 & 262144) != 0 ? null : str13, (i2 & 524288) != 0 ? null : str14);
    }
}
