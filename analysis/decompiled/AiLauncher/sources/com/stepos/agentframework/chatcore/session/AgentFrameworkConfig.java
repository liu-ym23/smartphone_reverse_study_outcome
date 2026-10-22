package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import j1.InterfaceC4757d;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/a;", "", "", "appId", "appSecret", "gatewayBaseUrl", "agentProxyBaseUrl", "Lkotlin/Function1;", "Lj1/d$c;", "dbOpenHelperFactoryProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "e", Const.INTENT_KEY_APIKEY, "Lp9/l;", Const.INTENT_KEY_UMID, "()Lp9/l;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentFrameworkConfig {
    private final String agentProxyBaseUrl;
    private final String appId;
    private final String appSecret;
    private final InterfaceC5074l<String, InterfaceC4757d.c> dbOpenHelperFactoryProvider;
    private final String gatewayBaseUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public AgentFrameworkConfig(String appId, String appSecret, String gatewayBaseUrl, String agentProxyBaseUrl, InterfaceC5074l<? super String, ? extends InterfaceC4757d.c> interfaceC5074l) {
        kotlin.jvm.internal.p.i(appId, "appId");
        kotlin.jvm.internal.p.i(appSecret, "appSecret");
        kotlin.jvm.internal.p.i(gatewayBaseUrl, "gatewayBaseUrl");
        kotlin.jvm.internal.p.i(agentProxyBaseUrl, "agentProxyBaseUrl");
        this.appId = appId;
        this.appSecret = appSecret;
        this.gatewayBaseUrl = gatewayBaseUrl;
        this.agentProxyBaseUrl = agentProxyBaseUrl;
        this.dbOpenHelperFactoryProvider = interfaceC5074l;
        if (La.H.x0(appId)) {
            throw new IllegalArgumentException("AgentFrameworkConfig: appId 不能为空");
        }
        if (La.H.x0(appSecret)) {
            throw new IllegalArgumentException("AgentFrameworkConfig: appSecret 不能为空");
        }
        if (La.H.x0(gatewayBaseUrl)) {
            throw new IllegalArgumentException("AgentFrameworkConfig: gatewayBaseUrl 不能为空");
        }
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentProxyBaseUrl() {
        return this.agentProxyBaseUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: c, reason: from getter */
    public final String getAppSecret() {
        return this.appSecret;
    }

    public final InterfaceC5074l<String, InterfaceC4757d.c> d() {
        return this.dbOpenHelperFactoryProvider;
    }

    /* renamed from: e, reason: from getter */
    public final String getGatewayBaseUrl() {
        return this.gatewayBaseUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentFrameworkConfig)) {
            return false;
        }
        AgentFrameworkConfig agentFrameworkConfig = (AgentFrameworkConfig) other;
        return kotlin.jvm.internal.p.d(this.appId, agentFrameworkConfig.appId) && kotlin.jvm.internal.p.d(this.appSecret, agentFrameworkConfig.appSecret) && kotlin.jvm.internal.p.d(this.gatewayBaseUrl, agentFrameworkConfig.gatewayBaseUrl) && kotlin.jvm.internal.p.d(this.agentProxyBaseUrl, agentFrameworkConfig.agentProxyBaseUrl) && kotlin.jvm.internal.p.d(this.dbOpenHelperFactoryProvider, agentFrameworkConfig.dbOpenHelperFactoryProvider);
    }

    public int hashCode() {
        int iHashCode = ((((((this.appId.hashCode() * 31) + this.appSecret.hashCode()) * 31) + this.gatewayBaseUrl.hashCode()) * 31) + this.agentProxyBaseUrl.hashCode()) * 31;
        InterfaceC5074l<String, InterfaceC4757d.c> interfaceC5074l = this.dbOpenHelperFactoryProvider;
        return iHashCode + (interfaceC5074l == null ? 0 : interfaceC5074l.hashCode());
    }

    public String toString() {
        return "AgentFrameworkConfig(appId=" + this.appId + ", appSecret=" + this.appSecret + ", gatewayBaseUrl=" + this.gatewayBaseUrl + ", agentProxyBaseUrl=" + this.agentProxyBaseUrl + ", dbOpenHelperFactoryProvider=" + this.dbOpenHelperFactoryProvider + ")";
    }
}
