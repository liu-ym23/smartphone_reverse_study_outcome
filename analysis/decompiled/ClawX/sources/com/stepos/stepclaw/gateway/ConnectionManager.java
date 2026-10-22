package com.stepos.stepclaw.gateway;

import android.os.Build;
import c5.l;
import c5.m;
import c5.s;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.handlers.InstallVersionResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001f¨\u0006!"}, d2 = {"Lcom/stepos/stepclaw/gateway/ConnectionManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/SecurePrefs;", "prefs", "Lkotlin/Function0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "manualTls", "<init>", "(Lcom/stepos/stepclaw/SecurePrefs;Lp5/a;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "buildCapabilities", "()Ljava/util/List;", "resolvedVersionName", "()Ljava/lang/String;", "resolveModelIdentifier", "buildUserAgent", "clientId", "clientMode", "Lcom/stepos/stepclaw/gateway/GatewayClientInfo;", "buildClientInfo", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/gateway/GatewayClientInfo;", "Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", "buildOperatorConnectOptions", "()Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "endpoint", "Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "resolveTlsParams", "(Lcom/stepos/stepclaw/gateway/GatewayEndpoint;)Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "Lcom/stepos/stepclaw/SecurePrefs;", "Lp5/a;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConnectionManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final p5.a manualTls;
    private final SecurePrefs prefs;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/gateway/ConnectionManager$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "resolveTlsParamsForEndpoint", "Lcom/stepos/stepclaw/gateway/GatewayTlsParams;", "endpoint", "Lcom/stepos/stepclaw/gateway/GatewayEndpoint;", "storedFingerprint", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "manualTlsEnabled", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "resolveTlsParamsForEndpoint$step_runtime_release", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final GatewayTlsParams resolveTlsParamsForEndpoint$step_runtime_release(GatewayEndpoint endpoint, String storedFingerprint, boolean manualTlsEnabled) {
            String tlsFingerprintSha256;
            p.e(endpoint, "endpoint");
            String stableId = endpoint.getStableId();
            String string = storedFingerprint != null ? n.T1(storedFingerprint).toString() : null;
            if (string == null || string.length() == 0) {
                string = null;
            }
            if (u.c1(stableId, "manual|", false)) {
                if (manualTlsEnabled) {
                    return (string == null || n.t1(string)) ? new GatewayTlsParams(true, null, false, stableId) : new GatewayTlsParams(true, string, false, stableId);
                }
            } else {
                if (string != null && !n.t1(string)) {
                    return new GatewayTlsParams(true, string, false, stableId);
                }
                if (endpoint.getTlsEnabled() || ((tlsFingerprintSha256 = endpoint.getTlsFingerprintSha256()) != null && !n.t1(tlsFingerprintSha256))) {
                    return new GatewayTlsParams(true, null, false, stableId);
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    public ConnectionManager(SecurePrefs prefs, p5.a manualTls) {
        p.e(prefs, "prefs");
        p.e(manualTls, "manualTls");
        this.prefs = prefs;
        this.manualTls = manualTls;
    }

    public final List<String> buildCapabilities() {
        return s.f1092a;
    }

    public final GatewayClientInfo buildClientInfo(String clientId, String clientMode) {
        p.e(clientId, "clientId");
        p.e(clientMode, "clientMode");
        return new GatewayClientInfo(clientId, (String) this.prefs.getDisplayName().getValue(), resolvedVersionName(), "android", clientMode, (String) this.prefs.getInstanceId().getValue(), "Android", resolveModelIdentifier());
    }

    public final GatewayConnectOptions buildOperatorConnectOptions() {
        List listK0 = c5.n.k0("operator.read", "operator.write", "operator.talk.secrets", "operator.admin", "operator.approvals", "operator.pairing");
        GatewayClientInfo gatewayClientInfoBuildClientInfo = buildClientInfo("openclaw-android", "ui");
        String strBuildUserAgent = buildUserAgent();
        s sVar = s.f1092a;
        return new GatewayConnectOptions("operator", listK0, sVar, sVar, t.f1093a, gatewayClientInfoBuildClientInfo, strBuildUserAgent);
    }

    public final String buildUserAgent() {
        String strResolvedVersionName = resolvedVersionName();
        String str = Build.VERSION.RELEASE;
        String string = str != null ? n.T1(str).toString() : null;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (string.length() == 0) {
            string = "unknown";
        }
        return m0.f.e(a8.b.v("OpenClawAndroid/", strResolvedVersionName, " (Android ", string, "; SDK "), Build.VERSION.SDK_INT, ")");
    }

    public final String resolveModelIdentifier() {
        String string = n.T1(m.A0(l.d0(new String[]{Build.MANUFACTURER, Build.MODEL}), " ", null, null, null, 62)).toString();
        if (string.length() == 0) {
            return null;
        }
        return string;
    }

    public final GatewayTlsParams resolveTlsParams(GatewayEndpoint endpoint) {
        p.e(endpoint, "endpoint");
        return INSTANCE.resolveTlsParamsForEndpoint$step_runtime_release(endpoint, this.prefs.loadGatewayTlsFingerprint(endpoint.getStableId()), ((Boolean) this.manualTls.invoke()).booleanValue());
    }

    public final String resolvedVersionName() {
        return InstallVersionResolver.DEFAULT_VERSION;
    }
}
