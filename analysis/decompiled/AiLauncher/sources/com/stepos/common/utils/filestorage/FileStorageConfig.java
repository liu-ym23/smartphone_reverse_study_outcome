package com.stepos.common.utils.filestorage;

import P6.UploadBinding;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b#\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b$\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b%\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b&\u0010\u0018R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010\u001aR\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b,\u0010\u001aR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u0012\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010-\u001a\u0004\b0\u0010/R\u0017\u0010\u0013\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b1\u0010/R\u0017\u0010\u0014\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b2\u0010/¨\u00063"}, d2 = {"Lcom/stepos/common/utils/filestorage/b;", "", "", "appId", "appSecret", "defaultBizCode", "gatewayBaseUrl", "serviceName", "clientType", "defaultSourceType", "", "LP6/k;", "defaultBindings", "", "concurrency", "maxRetry", "", "retryBackoffMs", "connectTimeoutMs", "readTimeoutMs", "tosPutTimeoutMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIJJJJ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "m", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/List;", "f", "()Ljava/util/List;", "I", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "J", "l", "()J", "e", "k", "n", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: com.stepos.common.utils.filestorage.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FileStorageConfig {
    private final String appId;
    private final String appSecret;
    private final String clientType;
    private final int concurrency;
    private final long connectTimeoutMs;
    private final List<UploadBinding> defaultBindings;
    private final String defaultBizCode;
    private final String defaultSourceType;
    private final String gatewayBaseUrl;
    private final int maxRetry;
    private final long readTimeoutMs;
    private final long retryBackoffMs;
    private final String serviceName;
    private final long tosPutTimeoutMs;

    public FileStorageConfig(String appId, String appSecret, String defaultBizCode, String gatewayBaseUrl, String serviceName, String clientType, String defaultSourceType, List<UploadBinding> defaultBindings, int i10, int i11, long j10, long j11, long j12, long j13) {
        p.i(appId, "appId");
        p.i(appSecret, "appSecret");
        p.i(defaultBizCode, "defaultBizCode");
        p.i(gatewayBaseUrl, "gatewayBaseUrl");
        p.i(serviceName, "serviceName");
        p.i(clientType, "clientType");
        p.i(defaultSourceType, "defaultSourceType");
        p.i(defaultBindings, "defaultBindings");
        this.appId = appId;
        this.appSecret = appSecret;
        this.defaultBizCode = defaultBizCode;
        this.gatewayBaseUrl = gatewayBaseUrl;
        this.serviceName = serviceName;
        this.clientType = clientType;
        this.defaultSourceType = defaultSourceType;
        this.defaultBindings = defaultBindings;
        this.concurrency = i10;
        this.maxRetry = i11;
        this.retryBackoffMs = j10;
        this.connectTimeoutMs = j11;
        this.readTimeoutMs = j12;
        this.tosPutTimeoutMs = j13;
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
    public final String getClientType() {
        return this.clientType;
    }

    /* renamed from: d, reason: from getter */
    public final int getConcurrency() {
        return this.concurrency;
    }

    /* renamed from: e, reason: from getter */
    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileStorageConfig)) {
            return false;
        }
        FileStorageConfig fileStorageConfig = (FileStorageConfig) other;
        return p.d(this.appId, fileStorageConfig.appId) && p.d(this.appSecret, fileStorageConfig.appSecret) && p.d(this.defaultBizCode, fileStorageConfig.defaultBizCode) && p.d(this.gatewayBaseUrl, fileStorageConfig.gatewayBaseUrl) && p.d(this.serviceName, fileStorageConfig.serviceName) && p.d(this.clientType, fileStorageConfig.clientType) && p.d(this.defaultSourceType, fileStorageConfig.defaultSourceType) && p.d(this.defaultBindings, fileStorageConfig.defaultBindings) && this.concurrency == fileStorageConfig.concurrency && this.maxRetry == fileStorageConfig.maxRetry && this.retryBackoffMs == fileStorageConfig.retryBackoffMs && this.connectTimeoutMs == fileStorageConfig.connectTimeoutMs && this.readTimeoutMs == fileStorageConfig.readTimeoutMs && this.tosPutTimeoutMs == fileStorageConfig.tosPutTimeoutMs;
    }

    public final List<UploadBinding> f() {
        return this.defaultBindings;
    }

    /* renamed from: g, reason: from getter */
    public final String getDefaultBizCode() {
        return this.defaultBizCode;
    }

    /* renamed from: h, reason: from getter */
    public final String getDefaultSourceType() {
        return this.defaultSourceType;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.appId.hashCode() * 31) + this.appSecret.hashCode()) * 31) + this.defaultBizCode.hashCode()) * 31) + this.gatewayBaseUrl.hashCode()) * 31) + this.serviceName.hashCode()) * 31) + this.clientType.hashCode()) * 31) + this.defaultSourceType.hashCode()) * 31) + this.defaultBindings.hashCode()) * 31) + Integer.hashCode(this.concurrency)) * 31) + Integer.hashCode(this.maxRetry)) * 31) + Long.hashCode(this.retryBackoffMs)) * 31) + Long.hashCode(this.connectTimeoutMs)) * 31) + Long.hashCode(this.readTimeoutMs)) * 31) + Long.hashCode(this.tosPutTimeoutMs);
    }

    /* renamed from: i, reason: from getter */
    public final String getGatewayBaseUrl() {
        return this.gatewayBaseUrl;
    }

    /* renamed from: j, reason: from getter */
    public final int getMaxRetry() {
        return this.maxRetry;
    }

    /* renamed from: k, reason: from getter */
    public final long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    /* renamed from: l, reason: from getter */
    public final long getRetryBackoffMs() {
        return this.retryBackoffMs;
    }

    /* renamed from: m, reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    /* renamed from: n, reason: from getter */
    public final long getTosPutTimeoutMs() {
        return this.tosPutTimeoutMs;
    }

    public String toString() {
        return "FileStorageConfig(appId=" + this.appId + ", appSecret=" + this.appSecret + ", defaultBizCode=" + this.defaultBizCode + ", gatewayBaseUrl=" + this.gatewayBaseUrl + ", serviceName=" + this.serviceName + ", clientType=" + this.clientType + ", defaultSourceType=" + this.defaultSourceType + ", defaultBindings=" + this.defaultBindings + ", concurrency=" + this.concurrency + ", maxRetry=" + this.maxRetry + ", retryBackoffMs=" + this.retryBackoffMs + ", connectTimeoutMs=" + this.connectTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", tosPutTimeoutMs=" + this.tosPutTimeoutMs + ")";
    }

    public /* synthetic */ FileStorageConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, int i10, int i11, long j10, long j11, long j12, long j13, int i12, i iVar) {
        this(str, str2, str3, (i12 & 8) != 0 ? "https://biz-gw-in.zyql.com" : str4, (i12 & 16) != 0 ? "file-storage" : str5, (i12 & 32) != 0 ? "Android" : str6, (i12 & 64) != 0 ? "client" : str7, (i12 & 128) != 0 ? C1173v.m() : list, (i12 & 256) != 0 ? 5 : i10, (i12 & 512) != 0 ? 3 : i11, (i12 & 1024) != 0 ? 800L : j10, (i12 & 2048) != 0 ? 15000L : j11, (i12 & 4096) != 0 ? 60000L : j12, (i12 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? 300000L : j13);
    }
}
