package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Be\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b*\u0010)R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b.\u0010)¨\u0006/"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/s;", "", "", "url", "deviceId", "Lcom/stepos/agentframework/adapter/bff/a;", "authInfo", "Lcom/stepos/agentframework/adapter/bff/o;", "connectCallback", "Lcom/stepos/agentframework/adapter/bff/n;", "authCallback", "", "isAutoReconnect", "isIdleClose", "", "idleTimeout", "isLazyConnect", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/bff/a;Lcom/stepos/agentframework/adapter/bff/o;Lcom/stepos/agentframework/adapter/bff/n;ZZJZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_UMID, "Lcom/stepos/agentframework/adapter/bff/a;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/bff/a;", "Lcom/stepos/agentframework/adapter/bff/o;", "c", "()Lcom/stepos/agentframework/adapter/bff/o;", "Lcom/stepos/agentframework/adapter/bff/n;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/bff/n;", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "J", "e", "()J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.bff.s, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class Option {
    private final n authCallback;
    private final AuthInfo authInfo;
    private final o connectCallback;
    private final String deviceId;
    private final long idleTimeout;
    private final boolean isAutoReconnect;
    private final boolean isIdleClose;
    private final boolean isLazyConnect;
    private final String url;

    public Option(String url, String deviceId, AuthInfo authInfo, o oVar, n nVar, boolean z10, boolean z11, long j10, boolean z12) {
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        this.url = url;
        this.deviceId = deviceId;
        this.authInfo = authInfo;
        this.connectCallback = oVar;
        this.authCallback = nVar;
        this.isAutoReconnect = z10;
        this.isIdleClose = z11;
        this.idleTimeout = j10;
        this.isLazyConnect = z12;
    }

    /* renamed from: a, reason: from getter */
    public final n getAuthCallback() {
        return this.authCallback;
    }

    /* renamed from: b, reason: from getter */
    public final AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    /* renamed from: c, reason: from getter */
    public final o getConnectCallback() {
        return this.connectCallback;
    }

    /* renamed from: d, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: e, reason: from getter */
    public final long getIdleTimeout() {
        return this.idleTimeout;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Option)) {
            return false;
        }
        Option option = (Option) other;
        return kotlin.jvm.internal.p.d(this.url, option.url) && kotlin.jvm.internal.p.d(this.deviceId, option.deviceId) && kotlin.jvm.internal.p.d(this.authInfo, option.authInfo) && kotlin.jvm.internal.p.d(this.connectCallback, option.connectCallback) && kotlin.jvm.internal.p.d(this.authCallback, option.authCallback) && this.isAutoReconnect == option.isAutoReconnect && this.isIdleClose == option.isIdleClose && this.idleTimeout == option.idleTimeout && this.isLazyConnect == option.isLazyConnect;
    }

    /* renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsAutoReconnect() {
        return this.isAutoReconnect;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsIdleClose() {
        return this.isIdleClose;
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.deviceId.hashCode()) * 31;
        AuthInfo authInfo = this.authInfo;
        int iHashCode2 = (iHashCode + (authInfo == null ? 0 : authInfo.hashCode())) * 31;
        o oVar = this.connectCallback;
        int iHashCode3 = (iHashCode2 + (oVar == null ? 0 : oVar.hashCode())) * 31;
        n nVar = this.authCallback;
        return ((((((((iHashCode3 + (nVar != null ? nVar.hashCode() : 0)) * 31) + Boolean.hashCode(this.isAutoReconnect)) * 31) + Boolean.hashCode(this.isIdleClose)) * 31) + Long.hashCode(this.idleTimeout)) * 31) + Boolean.hashCode(this.isLazyConnect);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsLazyConnect() {
        return this.isLazyConnect;
    }

    public String toString() {
        return "Option(url=" + this.url + ", deviceId=" + this.deviceId + ", authInfo=" + this.authInfo + ", connectCallback=" + this.connectCallback + ", authCallback=" + this.authCallback + ", isAutoReconnect=" + this.isAutoReconnect + ", isIdleClose=" + this.isIdleClose + ", idleTimeout=" + this.idleTimeout + ", isLazyConnect=" + this.isLazyConnect + ")";
    }

    public /* synthetic */ Option(String str, String str2, AuthInfo authInfo, o oVar, n nVar, boolean z10, boolean z11, long j10, boolean z12, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : authInfo, (i10 & 8) != 0 ? null : oVar, (i10 & 16) != 0 ? null : nVar, (i10 & 32) != 0 ? false : z10, (i10 & 64) != 0 ? true : z11, (i10 & 128) != 0 ? 900000L : j10, (i10 & 256) != 0 ? true : z12);
    }
}
