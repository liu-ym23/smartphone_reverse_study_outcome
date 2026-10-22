package com.bytedance.safetyguard.lxc.api.sidecar;

import com.bytedance.crypto.platform.PlatformConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarSessionEnv {
    private final String appId;
    private final SidecarBrand brand;
    private final long expiresAtMillis;
    private final String proxyKey;
    private final String sessionId;

    public static /* synthetic */ SidecarSessionEnv copy$default(SidecarSessionEnv r4, String r5, long r6, String r8, String r9, SidecarBrand r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.sessionId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.expiresAtMillis;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.appId;
    L11:
        String r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.proxyKey;
    L14:
        String r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.brand;
    L17:
        String r7 = r5;
        return r4.copy(r7, r0, r13, r2, r10);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final long component2() {
        return this.expiresAtMillis;
    }

    public final String component3() {
        return this.appId;
    }

    public final String component4() {
        return this.proxyKey;
    }

    public final SidecarBrand component5() {
        return this.brand;
    }

    public final SidecarSessionEnv copy(String r8, long r9, String r11, String r12, SidecarBrand r13) {
        o.e(r8, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r11, "appId");
        o.e(r12, "proxyKey");
        o.e(r13, PlatformConst.BUNDLE_KEY_BRAND);
        return new SidecarSessionEnv(r8, r9, r11, r12, r13);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SidecarSessionEnv.class) == true) goto L8;
        return false;
    L8:
        SidecarSessionEnv r10 = (SidecarSessionEnv) ZeusTransformUtils.preCheckCast(r9, SidecarSessionEnv.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionId, r10.sessionId) == true) goto L12;
        return false;
    L12:
        if (this.expiresAtMillis == r10.expiresAtMillis) goto L15;
        return false;
    L15:
        if (o.a(this.appId, r10.appId) == true) goto L18;
        return false;
    L18:
        if (o.a(this.proxyKey, r10.proxyKey) == true) goto L21;
        return false;
    L21:
        if (this.brand == r10.brand) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.sessionId.hashCode() * 31) + Long.hashCode(this.expiresAtMillis)) * 31) + this.appId.hashCode()) * 31) + this.proxyKey.hashCode()) * 31) + this.brand.hashCode();
    }

    public String toString() {
        return "SidecarSessionEnv(sessionId=" + this.sessionId + ", expiresAtMillis=" + this.expiresAtMillis + ", appId=" + this.appId + ", proxyKey=" + this.proxyKey + ", brand=" + this.brand + ')';
    }

    public SidecarSessionEnv(String r2, long r3, String r5, String r6, SidecarBrand r7) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r5, "appId");
        o.e(r6, "proxyKey");
        o.e(r7, PlatformConst.BUNDLE_KEY_BRAND);
        this.sessionId = r2;
        this.expiresAtMillis = r3;
        this.appId = r5;
        this.proxyKey = r6;
        this.brand = r7;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getExpiresAtMillis() {
        return this.expiresAtMillis;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getProxyKey() {
        return this.proxyKey;
    }

    public /* synthetic */ SidecarSessionEnv(String r8, long r9, String r11, String r12, SidecarBrand r13, int r14, h r15) {
        if ((r14 & 16) == 0) goto L5;
        r13 = SidecarBrand.FEISHU;
    L5:
        this(r8, r9, r11, r12, r13);
    }

    public final SidecarBrand getBrand() {
        return this.brand;
    }

    public final Map<String, String> asEnvironment() {
        Map r0 = ao.a();
        r0.put("LARKSUITE_CLI_APP_ID", this.appId);
        r0.put("LARKSUITE_CLI_PROXY_KEY", this.proxyKey);
        r0.put("LARKSUITE_CLI_BRAND", this.brand.getCliValue());
        return ao.a(r0);
    }
}
