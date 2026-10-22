package com.bytedance.safetyguard.lxc.api.sidecar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.h;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarLoginRequest {
    private final String appId;
    private final String authorizationCode;
    private final String expectedOpenId;
    private final String redirectUri;
    private final Set<String> scopes;

    public static /* synthetic */ SidecarLoginRequest copy$default(SidecarLoginRequest r6, String r7, String r8, Set r9, String r10, String r11, int r12, Object r13) {
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.expectedOpenId;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.authorizationCode;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.scopes;
    L11:
        Set<String> r3 = r14;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.appId;
    L14:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r11 = r6.redirectUri;
    L18:
        return r6.copy(r1, r2, r3, r4, r11);
    }

    public final String component1() {
        return this.expectedOpenId;
    }

    public final String component2() {
        return this.authorizationCode;
    }

    public final Set<String> component3() {
        return this.scopes;
    }

    public final String component4() {
        return this.appId;
    }

    public final String component5() {
        return this.redirectUri;
    }

    public final SidecarLoginRequest copy(String r7, String r8, Set<String> r9, String r10, String r11) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        o.e(r7, "expectedOpenId");
        o.e(r8, "authorizationCode");
        o.e(r3, "scopes");
        return new SidecarLoginRequest(r7, r8, r3, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SidecarLoginRequest.class) == true) goto L8;
        return false;
    L8:
        SidecarLoginRequest r6 = (SidecarLoginRequest) ZeusTransformUtils.preCheckCast(r5, SidecarLoginRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.expectedOpenId, r6.expectedOpenId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.authorizationCode, r6.authorizationCode) == true) goto L15;
        return false;
    L15:
        if (o.a(this.scopes, r6.scopes) == true) goto L18;
        return false;
    L18:
        if (o.a(this.appId, r6.appId) == true) goto L21;
        return false;
    L21:
        if (o.a(this.redirectUri, r6.redirectUri) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.expectedOpenId.hashCode() * 31) + this.authorizationCode.hashCode()) * 31) + this.scopes.hashCode()) * 31;
        String r1 = this.appId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.redirectUri;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SidecarLoginRequest(expectedOpenId=" + this.expectedOpenId + ", authorizationCode=" + this.authorizationCode + ", scopes=" + this.scopes + ", appId=" + this.appId + ", redirectUri=" + this.redirectUri + ')';
    }

    public SidecarLoginRequest(String r3, String r4, Set<String> r5, String r6, String r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        o.e(r3, "expectedOpenId");
        o.e(r4, "authorizationCode");
        o.e(r8, "scopes");
        this.expectedOpenId = r3;
        this.authorizationCode = r4;
        this.scopes = r8;
        this.appId = r6;
        this.redirectUri = r7;
    }

    public final String getExpectedOpenId() {
        return this.expectedOpenId;
    }

    public final String getAuthorizationCode() {
        return this.authorizationCode;
    }

    public /* synthetic */ SidecarLoginRequest(String r7, String r8, Set r9, String r10, String r11, int r12, h r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        r14 = ax.b();
    L5:
        Set r3 = r14;
        if ((r12 & 8) == 0) goto L8;
        String r4 = null;
    L10:
        if ((r12 & 16) == 0) goto L12;
        String r5 = null;
    L13:
        this(r7, r8, r3, r4, r5);
        return;
    L12:
        r5 = r11;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }

    public final Set<String> getScopes() {
        return this.scopes;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }
}
