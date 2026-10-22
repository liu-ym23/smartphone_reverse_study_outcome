package com.bytedance.safetyguard.lxc.internal.e.g;

import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: SidecarSessionStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SidecarBrand f10838e;
    private final String f;
    private final Set<String> g;
    private final long h;
    private final long i;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10834a, r10.f10834a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10835b, r10.f10835b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f10836c, r10.f10836c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f10837d, r10.f10837d) == true) goto L21;
        return false;
    L21:
        if (this.f10838e == r10.f10838e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((this.f10834a.hashCode() * 31) + this.f10835b.hashCode()) * 31) + this.f10836c.hashCode()) * 31) + this.f10837d.hashCode()) * 31) + this.f10838e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i);
    }

    public String toString() {
        return "SidecarSession(sessionId=" + this.f10834a + ", cliName=" + this.f10835b + ", appId=" + this.f10836c + ", userOpenId=" + this.f10837d + ", brand=" + this.f10838e + ", proxyKey=" + this.f + ", targetHosts=" + this.g + ", createdAtMillis=" + this.h + ", expiresAtMillis=" + this.i + ')';
    }

    public a(String r3, String r4, String r5, String r6, SidecarBrand r7, String r8, Set<String> r9, long r10, long r12) {
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r4, "cliName");
        o.e(r5, "appId");
        o.e(r6, "userOpenId");
        o.e(r7, PlatformConst.BUNDLE_KEY_BRAND);
        o.e(r8, "proxyKey");
        o.e(r11, "targetHosts");
        this.f10834a = r3;
        this.f10835b = r4;
        this.f10836c = r5;
        this.f10837d = r6;
        this.f10838e = r7;
        this.f = r8;
        this.g = r11;
        this.h = r10;
        this.i = r12;
    }

    public final String a() {
        return this.f10834a;
    }

    public final String b() {
        return this.f10836c;
    }

    public final String c() {
        return this.f10837d;
    }

    public final SidecarBrand d() {
        return this.f10838e;
    }

    public final String e() {
        return this.f;
    }

    public final Set<String> f() {
        return this.g;
    }

    public final long g() {
        return this.i;
    }
}
