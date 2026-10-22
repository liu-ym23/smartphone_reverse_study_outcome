package com.bytedance.safetyguard.lxc.api.sidecar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.h;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarAccountStatus {
    private final Long accessTokenExpiresAtMillis;
    private final SidecarAppInfo app;
    private final Set<String> grantedScopes;
    private final boolean loggedIn;
    private final Long refreshTokenExpiresAtMillis;

    public static /* synthetic */ SidecarAccountStatus copy$default(SidecarAccountStatus r6, SidecarAppInfo r7, boolean r8, Set r9, Long r10, Long r11, int r12, Object r13) {
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.app;
    L5:
        SidecarAppInfo r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.loggedIn;
    L8:
        boolean r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.grantedScopes;
    L11:
        Set<String> r3 = r14;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.accessTokenExpiresAtMillis;
    L14:
        Long r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r11 = r6.refreshTokenExpiresAtMillis;
    L18:
        return r6.copy(r1, r2, r3, r4, r11);
    }

    public final SidecarAppInfo component1() {
        return this.app;
    }

    public final boolean component2() {
        return this.loggedIn;
    }

    public final Set<String> component3() {
        return this.grantedScopes;
    }

    public final Long component4() {
        return this.accessTokenExpiresAtMillis;
    }

    public final Long component5() {
        return this.refreshTokenExpiresAtMillis;
    }

    public final SidecarAccountStatus copy(SidecarAppInfo r7, boolean r8, Set<String> r9, Long r10, Long r11) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        o.e(r3, "grantedScopes");
        return new SidecarAccountStatus(r7, r8, r3, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SidecarAccountStatus.class) == true) goto L8;
        return false;
    L8:
        SidecarAccountStatus r6 = (SidecarAccountStatus) ZeusTransformUtils.preCheckCast(r5, SidecarAccountStatus.class, "com.obric.aiagent.plugin");
        if (o.a(this.app, r6.app) == true) goto L12;
        return false;
    L12:
        if (this.loggedIn == r6.loggedIn) goto L15;
        return false;
    L15:
        if (o.a(this.grantedScopes, r6.grantedScopes) == true) goto L18;
        return false;
    L18:
        if (o.a(this.accessTokenExpiresAtMillis, r6.accessTokenExpiresAtMillis) == true) goto L21;
        return false;
    L21:
        if (o.a(this.refreshTokenExpiresAtMillis, r6.refreshTokenExpiresAtMillis) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        SidecarAppInfo r0 = this.app;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + Boolean.hashCode(this.loggedIn)) * 31) + this.grantedScopes.hashCode()) * 31;
        Long r4 = this.accessTokenExpiresAtMillis;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.refreshTokenExpiresAtMillis;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SidecarAccountStatus(app=" + this.app + ", loggedIn=" + this.loggedIn + ", grantedScopes=" + this.grantedScopes + ", accessTokenExpiresAtMillis=" + this.accessTokenExpiresAtMillis + ", refreshTokenExpiresAtMillis=" + this.refreshTokenExpiresAtMillis + ')';
    }

    public SidecarAccountStatus(SidecarAppInfo r3, boolean r4, Set<String> r5, Long r6, Long r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        o.e(r8, "grantedScopes");
        this.app = r3;
        this.loggedIn = r4;
        this.grantedScopes = r8;
        this.accessTokenExpiresAtMillis = r6;
        this.refreshTokenExpiresAtMillis = r7;
    }

    public final SidecarAppInfo getApp() {
        return this.app;
    }

    public final boolean getLoggedIn() {
        return this.loggedIn;
    }

    public /* synthetic */ SidecarAccountStatus(SidecarAppInfo r7, boolean r8, Set r9, Long r10, Long r11, int r12, h r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        r14 = ax.b();
    L5:
        Set r3 = r14;
        if ((r12 & 8) == 0) goto L8;
        Long r4 = null;
    L10:
        if ((r12 & 16) == 0) goto L12;
        Long r5 = null;
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

    public final Set<String> getGrantedScopes() {
        return this.grantedScopes;
    }

    public final Long getAccessTokenExpiresAtMillis() {
        return this.accessTokenExpiresAtMillis;
    }

    public final Long getRefreshTokenExpiresAtMillis() {
        return this.refreshTokenExpiresAtMillis;
    }
}
