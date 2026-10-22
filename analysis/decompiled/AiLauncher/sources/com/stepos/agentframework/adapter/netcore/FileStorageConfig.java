package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001c\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001d\u0010\u0010R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/k;", "", "", "appId", "appSecret", "defaultBizCode", "defaultSourceType", "gatewayBaseUrl", "serviceName", "Lcom/stepos/agentframework/adapter/netcore/m;", "tokenProvider", "Lcom/stepos/agentframework/adapter/netcore/l;", "headerProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/m;Lcom/stepos/agentframework/adapter/netcore/l;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/agentframework/adapter/netcore/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/adapter/netcore/m;", "Lcom/stepos/agentframework/adapter/netcore/l;", "f", "()Lcom/stepos/agentframework/adapter/netcore/l;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.k, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FileStorageConfig {
    private final String appId;
    private final String appSecret;
    private final String defaultBizCode;
    private final String defaultSourceType;
    private final String gatewayBaseUrl;
    private final l headerProvider;
    private final String serviceName;
    private final m tokenProvider;

    public FileStorageConfig(String appId, String appSecret, String defaultBizCode, String defaultSourceType, String str, String str2, m tokenProvider, l lVar) {
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(defaultBizCode, "defaultBizCode");
        kotlin.jvm.internal.p.i(defaultSourceType, "defaultSourceType");
        kotlin.jvm.internal.p.i(tokenProvider, "tokenProvider");
        this.appId = appId;
        this.appSecret = appSecret;
        this.defaultBizCode = defaultBizCode;
        this.defaultSourceType = defaultSourceType;
        this.gatewayBaseUrl = str;
        this.serviceName = str2;
        this.tokenProvider = tokenProvider;
        this.headerProvider = lVar;
    }

    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppSecret() {
        return this.appSecret;
    }

    /* renamed from: c, reason: from getter */
    public final String getDefaultBizCode() {
        return this.defaultBizCode;
    }

    /* renamed from: d, reason: from getter */
    public final String getDefaultSourceType() {
        return this.defaultSourceType;
    }

    /* renamed from: e, reason: from getter */
    public final String getGatewayBaseUrl() {
        return this.gatewayBaseUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileStorageConfig)) {
            return false;
        }
        FileStorageConfig fileStorageConfig = (FileStorageConfig) other;
        return kotlin.jvm.internal.p.d(this.appId, fileStorageConfig.appId) && kotlin.jvm.internal.p.d(this.appSecret, fileStorageConfig.appSecret) && kotlin.jvm.internal.p.d(this.defaultBizCode, fileStorageConfig.defaultBizCode) && kotlin.jvm.internal.p.d(this.defaultSourceType, fileStorageConfig.defaultSourceType) && kotlin.jvm.internal.p.d(this.gatewayBaseUrl, fileStorageConfig.gatewayBaseUrl) && kotlin.jvm.internal.p.d(this.serviceName, fileStorageConfig.serviceName) && kotlin.jvm.internal.p.d(this.tokenProvider, fileStorageConfig.tokenProvider) && kotlin.jvm.internal.p.d(this.headerProvider, fileStorageConfig.headerProvider);
    }

    /* renamed from: f, reason: from getter */
    public final l getHeaderProvider() {
        return this.headerProvider;
    }

    /* renamed from: g, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    /* renamed from: h, reason: from getter */
    public final m getTokenProvider() {
        return this.tokenProvider;
    }

    public int hashCode() {
        int iHashCode = ((((((this.appId.hashCode() * 31) + this.appSecret.hashCode()) * 31) + this.defaultBizCode.hashCode()) * 31) + this.defaultSourceType.hashCode()) * 31;
        String str = this.gatewayBaseUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.serviceName;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.tokenProvider.hashCode()) * 31;
        l lVar = this.headerProvider;
        return iHashCode3 + (lVar != null ? lVar.hashCode() : 0);
    }

    public String toString() {
        return "FileStorageConfig(appId=" + this.appId + ", appSecret=" + this.appSecret + ", defaultBizCode=" + this.defaultBizCode + ", defaultSourceType=" + this.defaultSourceType + ", gatewayBaseUrl=" + this.gatewayBaseUrl + ", serviceName=" + this.serviceName + ", tokenProvider=" + this.tokenProvider + ", headerProvider=" + this.headerProvider + ")";
    }
}
