package com.obric.matrix.platform.sdk.ones.init;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.ttnet.http.HttpRequestInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseComponentConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u001dB[\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "", "appId", "", "isBoe", "", "loopInternal", "", "useTTNet", "baseUrl", "", "appName", "needSetCookieHandler", "apiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "(IZJZLjava/lang/String;Ljava/lang/String;ZLcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;)V", "getApiProcessHook", "()Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "getAppId", "()I", "getAppName", "()Ljava/lang/String;", "getBaseUrl", "()Z", "getLoopInternal", "()J", "getNeedSetCookieHandler", "getUseTTNet", "Builder", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseComponentConfig {
    private final NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
    private final int appId;
    private final String appName;
    private final String baseUrl;
    private final boolean isBoe;
    private final long loopInternal;
    private final boolean needSetCookieHandler;
    private final boolean useTTNet;

    /* JADX INFO: compiled from: BaseComponentConfig.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig$Builder;", "", "()V", "apiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "appId", "", "appName", "", "baseUrl", "isBoe", "", "loopInternal", "", "needSetCookieHandler", "useTTNet", "build", "Lcom/obric/matrix/platform/sdk/ones/init/BaseComponentConfig;", "setApiProcessHook", "setAppId", "setAppName", "setBaseUrl", "setIsBoe", "setLoopInternal", "setNeedSetCookieHandler", "setUseTTNet", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private NetworkParams.ApiProcessHook<HttpRequestInfo> apiProcessHook;
        private int appId;
        private String appName;
        private String baseUrl;
        private boolean isBoe;
        private long loopInternal;
        private boolean needSetCookieHandler;
        private boolean useTTNet;

        public Builder() {
            this.useTTNet = true;
            this.baseUrl = "";
            this.appName = "";
            this.needSetCookieHandler = true;
        }

        public final Builder setNeedSetCookieHandler(boolean r1) {
            this.needSetCookieHandler = r1;
            return this;
        }

        public final Builder setApiProcessHook(NetworkParams.ApiProcessHook<HttpRequestInfo> r1) {
            this.apiProcessHook = r1;
            return this;
        }

        public final Builder setUseTTNet(boolean r1) {
            this.useTTNet = r1;
            return this;
        }

        public final Builder setAppName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            this.appName = r2;
            return this;
        }

        public final Builder setBaseUrl(String r2) {
            Intrinsics.checkNotNullParameter(r2, "baseUrl");
            this.baseUrl = r2;
            return this;
        }

        public final Builder setAppId(int r1) {
            this.appId = r1;
            return this;
        }

        public final Builder setIsBoe(boolean r1) {
            this.isBoe = r1;
            return this;
        }

        public final Builder setLoopInternal(long r1) {
            this.loopInternal = r1;
            return this;
        }

        public final BaseComponentConfig build() {
            return new BaseComponentConfig(this.appId, this.isBoe, this.loopInternal, this.useTTNet, this.baseUrl, this.appName, this.needSetCookieHandler, this.apiProcessHook, null);
        }
    }

    public /* synthetic */ BaseComponentConfig(int r1, boolean r2, long r3, boolean r5, String r6, String r7, boolean r8, NetworkParams.ApiProcessHook r9, DefaultConstructorMarker r10) {
        this(r1, r2, r3, r5, r6, r7, r8, r9);
    }

    private BaseComponentConfig(int r1, boolean r2, long r3, boolean r5, String r6, String r7, boolean r8, NetworkParams.ApiProcessHook<HttpRequestInfo> r9) {
        this.appId = r1;
        this.isBoe = r2;
        this.loopInternal = r3;
        this.useTTNet = r5;
        this.baseUrl = r6;
        this.appName = r7;
        this.needSetCookieHandler = r8;
        this.apiProcessHook = r9;
    }

    /* synthetic */ BaseComponentConfig(int r14, boolean r15, long r16, boolean r18, String r19, String r20, boolean r21, NetworkParams.ApiProcessHook r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 4) == 0) goto L5;
        long r6 = 0;
    L7:
        if ((r23 & 8) == 0) goto L9;
        boolean r8 = true;
    L11:
        if ((r23 & 16) == 0) goto L13;
        String r9 = "";
    L15:
        if ((r23 & 32) == 0) goto L17;
        String r10 = "";
    L19:
        if ((r23 & 64) == 0) goto L21;
        boolean r11 = true;
    L23:
        if ((r23 & 128) == 0) goto L25;
        NetworkParams.ApiProcessHook r12 = null;
    L26:
        this(r14, r15, r6, r8, r9, r10, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public final int getAppId() {
        return this.appId;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }

    public final long getLoopInternal() {
        return this.loopInternal;
    }

    public final boolean getUseTTNet() {
        return this.useTTNet;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getNeedSetCookieHandler() {
        return this.needSetCookieHandler;
    }

    public final NetworkParams.ApiProcessHook<HttpRequestInfo> getApiProcessHook() {
        return this.apiProcessHook;
    }
}
