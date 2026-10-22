package com.obric.matrix.sdk.network;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.ttnet.http.HttpRequestInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u001eBI\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/sdk/network/NetworkConfig;", "", "appName", "", "appId", "", "did", "versionCode", "versionName", "needSetCookieHandler", "", "apiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ZLcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;)V", "getApiProcessHook", "()Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "getAppId", "()I", "getAppName", "()Ljava/lang/String;", "channel", "getChannel", "getDid", "setDid", "(Ljava/lang/String;)V", "getNeedSetCookieHandler", "()Z", "getVersionCode", "getVersionName", "Builder", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkConfig {
    private final NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
    private final int appId;
    private final String appName;
    private final String channel;
    private String did;
    private final boolean needSetCookieHandler;
    private final int versionCode;
    private final String versionName;

    /* JADX INFO: compiled from: NetworkConfig.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/sdk/network/NetworkConfig$Builder;", "", "()V", "apiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "appId", "", "appName", "", "did", "needSetCookieHandler", "", "versionCode", "versionName", "build", "Lcom/obric/matrix/sdk/network/NetworkConfig;", "setApiProcessHook", "setAppId", "setAppName", "setDid", "setNeedSetCookieHandler", "setVersionCode", "setVersionName", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
        private int appId;
        private String appName;
        private String did;
        private boolean needSetCookieHandler;
        private int versionCode;
        private String versionName;

        public Builder() {
            this.appName = "";
            this.did = "";
            this.versionName = "";
            this.needSetCookieHandler = true;
        }

        public final Builder setAppName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            this.appName = r2;
            return this;
        }

        public final Builder setAppId(int r1) {
            this.appId = r1;
            return this;
        }

        public final Builder setDid(String r2) {
            Intrinsics.checkNotNullParameter(r2, "did");
            this.did = r2;
            return this;
        }

        public final Builder setVersionCode(int r1) {
            this.versionCode = r1;
            return this;
        }

        public final Builder setVersionName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "versionName");
            this.versionName = r2;
            return this;
        }

        public final Builder setNeedSetCookieHandler(boolean r1) {
            this.needSetCookieHandler = r1;
            return this;
        }

        public final Builder setApiProcessHook(NetworkParams.ApiProcessHook<HttpRequestInfo> r1) {
            this.apiProcessHook = r1;
            return this;
        }

        public final NetworkConfig build() {
            return new NetworkConfig(this.appName, this.appId, this.did, this.versionCode, this.versionName, this.needSetCookieHandler, this.apiProcessHook, null);
        }
    }

    public /* synthetic */ NetworkConfig(String r1, int r2, String r3, int r4, String r5, boolean r6, NetworkParams.ApiProcessHook r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    private NetworkConfig(String r1, int r2, String r3, int r4, String r5, boolean r6, NetworkParams.ApiProcessHook<HttpRequestInfo> r7) {
        this.appName = r1;
        this.appId = r2;
        this.did = r3;
        this.versionCode = r4;
        this.versionName = r5;
        this.needSetCookieHandler = r6;
        this.apiProcessHook = r7;
        this.channel = ProductUtils.Companion.getProductType();
    }

    /* synthetic */ NetworkConfig(String r10, int r11, String r12, int r13, String r14, boolean r15, NetworkParams.ApiProcessHook r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 64) == 0) goto L5;
        NetworkParams.ApiProcessHook r8 = null;
    L6:
        this(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getDid() {
        return this.did;
    }

    public final void setDid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.did = r2;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean getNeedSetCookieHandler() {
        return this.needSetCookieHandler;
    }

    public final NetworkParams.ApiProcessHook<HttpRequestInfo> getApiProcessHook() {
        return this.apiProcessHook;
    }

    public final String getChannel() {
        return this.channel;
    }
}
