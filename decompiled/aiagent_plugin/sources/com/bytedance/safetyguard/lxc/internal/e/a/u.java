package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: LarkAuthModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SidecarBrand f10400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10404e;
    private final Set<String> f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        if (this.f10400a == r6.f10400a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10401b, r6.f10401b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10402c, r6.f10402c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f10403d, r6.f10403d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f10404e, r6.f10404e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f10400a.hashCode() * 31) + this.f10401b.hashCode()) * 31) + this.f10402c.hashCode()) * 31) + this.f10403d.hashCode()) * 31) + this.f10404e.hashCode()) * 31) + this.f.hashCode();
    }

    public u(SidecarBrand r3, String r4, String r5, String r6, String r7, Set<String> r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, PlatformConst.BUNDLE_KEY_BRAND);
        d.h.b.o.e(r4, "appId");
        d.h.b.o.e(r5, "appSecret");
        d.h.b.o.e(r6, "openId");
        d.h.b.o.e(r7, "refreshToken");
        d.h.b.o.e(r9, "scopes");
        this.f10400a = r3;
        this.f10401b = r4;
        this.f10402c = r5;
        this.f10403d = r6;
        this.f10404e = r7;
        this.f = r9;
    }

    public final SidecarBrand a() {
        return this.f10400a;
    }

    public final String b() {
        return this.f10401b;
    }

    public final String c() {
        return this.f10402c;
    }

    public final String d() {
        return this.f10403d;
    }

    public final String e() {
        return this.f10404e;
    }

    public final Set<String> f() {
        return this.f;
    }

    public String toString() {
        return "LarkTokenRefreshRequest(brand=" + this.f10400a + ", appId=" + this.f10401b + ", appSecret=<redacted>, openId=" + this.f10403d + ", refreshToken=<redacted>, scopes=" + this.f + ')';
    }
}
