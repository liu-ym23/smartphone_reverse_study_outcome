package com.stepos.agentframework.adapter.bff;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003Ji\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\fHÆ\u0001J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001cR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001c¨\u0006."}, d2 = {"Lcom/stepos/agentframework/adapter/bff/Option;", "", BffConstant.Type.Url, "", "deviceId", "authInfo", "Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "connectCallback", "Lcom/stepos/agentframework/adapter/bff/IConnectCallback;", "authCallback", "Lcom/stepos/agentframework/adapter/bff/IAuthCallback;", "isAutoReconnect", "", "isIdleClose", "idleTimeout", "", "isLazyConnect", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/bff/AuthInfo;Lcom/stepos/agentframework/adapter/bff/IConnectCallback;Lcom/stepos/agentframework/adapter/bff/IAuthCallback;ZZJZ)V", "getUrl", "()Ljava/lang/String;", "getDeviceId", "getAuthInfo", "()Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "getConnectCallback", "()Lcom/stepos/agentframework/adapter/bff/IConnectCallback;", "getAuthCallback", "()Lcom/stepos/agentframework/adapter/bff/IAuthCallback;", "()Z", "getIdleTimeout", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Option {
    private final IAuthCallback authCallback;
    private final AuthInfo authInfo;
    private final IConnectCallback connectCallback;
    private final String deviceId;
    private final long idleTimeout;
    private final boolean isAutoReconnect;
    private final boolean isIdleClose;
    private final boolean isLazyConnect;
    private final String url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Option(String url, String deviceId) {
        this(url, deviceId, null, null, null, false, false, 0L, false, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        k.f(url, "url");
        k.f(deviceId, "deviceId");
    }

    public static /* synthetic */ Option copy$default(Option option, String str, String str2, AuthInfo authInfo, IConnectCallback iConnectCallback, IAuthCallback iAuthCallback, boolean z10, boolean z11, long j5, boolean z12, int i, Object obj) {
        if ((i & 1) != 0) {
            str = option.url;
        }
        if ((i & 2) != 0) {
            str2 = option.deviceId;
        }
        if ((i & 4) != 0) {
            authInfo = option.authInfo;
        }
        if ((i & 8) != 0) {
            iConnectCallback = option.connectCallback;
        }
        if ((i & 16) != 0) {
            iAuthCallback = option.authCallback;
        }
        if ((i & 32) != 0) {
            z10 = option.isAutoReconnect;
        }
        if ((i & 64) != 0) {
            z11 = option.isIdleClose;
        }
        if ((i & 128) != 0) {
            j5 = option.idleTimeout;
        }
        if ((i & 256) != 0) {
            z12 = option.isLazyConnect;
        }
        boolean z13 = z12;
        long j6 = j5;
        boolean z14 = z10;
        boolean z15 = z11;
        IAuthCallback iAuthCallback2 = iAuthCallback;
        AuthInfo authInfo2 = authInfo;
        return option.copy(str, str2, authInfo2, iConnectCallback, iAuthCallback2, z14, z15, j6, z13);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component3, reason: from getter */
    public final AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final IConnectCallback getConnectCallback() {
        return this.connectCallback;
    }

    /* renamed from: component5, reason: from getter */
    public final IAuthCallback getAuthCallback() {
        return this.authCallback;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsAutoReconnect() {
        return this.isAutoReconnect;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsIdleClose() {
        return this.isIdleClose;
    }

    /* renamed from: component8, reason: from getter */
    public final long getIdleTimeout() {
        return this.idleTimeout;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsLazyConnect() {
        return this.isLazyConnect;
    }

    public final Option copy(String url, String deviceId, AuthInfo authInfo, IConnectCallback connectCallback, IAuthCallback authCallback, boolean isAutoReconnect, boolean isIdleClose, long idleTimeout, boolean isLazyConnect) {
        k.f(url, "url");
        k.f(deviceId, "deviceId");
        return new Option(url, deviceId, authInfo, connectCallback, authCallback, isAutoReconnect, isIdleClose, idleTimeout, isLazyConnect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Option)) {
            return false;
        }
        Option option = (Option) other;
        return k.b(this.url, option.url) && k.b(this.deviceId, option.deviceId) && k.b(this.authInfo, option.authInfo) && k.b(this.connectCallback, option.connectCallback) && k.b(this.authCallback, option.authCallback) && this.isAutoReconnect == option.isAutoReconnect && this.isIdleClose == option.isIdleClose && this.idleTimeout == option.idleTimeout && this.isLazyConnect == option.isLazyConnect;
    }

    public final IAuthCallback getAuthCallback() {
        return this.authCallback;
    }

    public final AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public final IConnectCallback getConnectCallback() {
        return this.connectCallback;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final long getIdleTimeout() {
        return this.idleTimeout;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iC = B7.a.c(this.url.hashCode() * 31, 31, this.deviceId);
        AuthInfo authInfo = this.authInfo;
        int iHashCode = (iC + (authInfo == null ? 0 : authInfo.hashCode())) * 31;
        IConnectCallback iConnectCallback = this.connectCallback;
        int iHashCode2 = (iHashCode + (iConnectCallback == null ? 0 : iConnectCallback.hashCode())) * 31;
        IAuthCallback iAuthCallback = this.authCallback;
        return Boolean.hashCode(this.isLazyConnect) + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d((iHashCode2 + (iAuthCallback != null ? iAuthCallback.hashCode() : 0)) * 31, 31, this.isAutoReconnect), 31, this.isIdleClose), 31, this.idleTimeout);
    }

    public final boolean isAutoReconnect() {
        return this.isAutoReconnect;
    }

    public final boolean isIdleClose() {
        return this.isIdleClose;
    }

    public final boolean isLazyConnect() {
        return this.isLazyConnect;
    }

    public String toString() {
        String str = this.url;
        String str2 = this.deviceId;
        AuthInfo authInfo = this.authInfo;
        IConnectCallback iConnectCallback = this.connectCallback;
        IAuthCallback iAuthCallback = this.authCallback;
        boolean z10 = this.isAutoReconnect;
        boolean z11 = this.isIdleClose;
        long j5 = this.idleTimeout;
        boolean z12 = this.isLazyConnect;
        StringBuilder sbW = B7.a.w("Option(url=", str, ", deviceId=", str2, ", authInfo=");
        sbW.append(authInfo);
        sbW.append(", connectCallback=");
        sbW.append(iConnectCallback);
        sbW.append(", authCallback=");
        sbW.append(iAuthCallback);
        sbW.append(", isAutoReconnect=");
        sbW.append(z10);
        sbW.append(", isIdleClose=");
        sbW.append(z11);
        sbW.append(", idleTimeout=");
        sbW.append(j5);
        sbW.append(", isLazyConnect=");
        sbW.append(z12);
        sbW.append(")");
        return sbW.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Option(String url, String deviceId, AuthInfo authInfo) {
        this(url, deviceId, authInfo, null, null, false, false, 0L, false, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
        k.f(url, "url");
        k.f(deviceId, "deviceId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Option(String url, String deviceId, AuthInfo authInfo, IConnectCallback iConnectCallback) {
        this(url, deviceId, authInfo, iConnectCallback, null, false, false, 0L, false, 496, null);
        k.f(url, "url");
        k.f(deviceId, "deviceId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Option(String url, String deviceId, AuthInfo authInfo, IConnectCallback iConnectCallback, IAuthCallback iAuthCallback) {
        this(url, deviceId, authInfo, iConnectCallback, iAuthCallback, false, false, 0L, false, 480, null);
        k.f(url, "url");
        k.f(deviceId, "deviceId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Option(String url, String deviceId, AuthInfo authInfo, IConnectCallback iConnectCallback, IAuthCallback iAuthCallback, boolean z10) {
        this(url, deviceId, authInfo, iConnectCallback, iAuthCallback, z10, false, 0L, false, 448, null);
        k.f(url, "url");
        k.f(deviceId, "deviceId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Option(String url, String deviceId, AuthInfo authInfo, IConnectCallback iConnectCallback, IAuthCallback iAuthCallback, boolean z10, boolean z11) {
        this(url, deviceId, authInfo, iConnectCallback, iAuthCallback, z10, z11, 0L, false, 384, null);
        k.f(url, "url");
        k.f(deviceId, "deviceId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Option(String url, String deviceId, AuthInfo authInfo, IConnectCallback iConnectCallback, IAuthCallback iAuthCallback, boolean z10, boolean z11, long j5) {
        this(url, deviceId, authInfo, iConnectCallback, iAuthCallback, z10, z11, j5, false, 256, null);
        k.f(url, "url");
        k.f(deviceId, "deviceId");
    }

    public Option(String url, String deviceId, AuthInfo authInfo, IConnectCallback iConnectCallback, IAuthCallback iAuthCallback, boolean z10, boolean z11, long j5, boolean z12) {
        k.f(url, "url");
        k.f(deviceId, "deviceId");
        this.url = url;
        this.deviceId = deviceId;
        this.authInfo = authInfo;
        this.connectCallback = iConnectCallback;
        this.authCallback = iAuthCallback;
        this.isAutoReconnect = z10;
        this.isIdleClose = z11;
        this.idleTimeout = j5;
        this.isLazyConnect = z12;
    }

    public /* synthetic */ Option(String str, String str2, AuthInfo authInfo, IConnectCallback iConnectCallback, IAuthCallback iAuthCallback, boolean z10, boolean z11, long j5, boolean z12, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : authInfo, (i & 8) != 0 ? null : iConnectCallback, (i & 16) != 0 ? null : iAuthCallback, (i & 32) != 0 ? false : z10, (i & 64) != 0 ? true : z11, (i & 128) != 0 ? 900000L : j5, (i & 256) != 0 ? true : z12);
    }
}
