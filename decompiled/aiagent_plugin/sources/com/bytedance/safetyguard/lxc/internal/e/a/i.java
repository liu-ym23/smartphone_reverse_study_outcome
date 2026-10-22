package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkAuthModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SidecarBrand f10370d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10367a, r6.f10367a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10368b, r6.f10368b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10369c, r6.f10369c) == true) goto L18;
        return false;
    L18:
        if (this.f10370d == r6.f10370d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f10367a.hashCode() * 31) + this.f10368b.hashCode()) * 31;
        String r1 = this.f10369c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f10370d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "LarkAppRegistrationResult(appId=" + this.f10367a + ", appSecret=" + this.f10368b + ", userOpenId=" + this.f10369c + ", brand=" + this.f10370d + ')';
    }

    public i(String r2, String r3, String r4, SidecarBrand r5) {
        d.h.b.o.e(r2, "appId");
        d.h.b.o.e(r3, "appSecret");
        d.h.b.o.e(r5, PlatformConst.BUNDLE_KEY_BRAND);
        this.f10367a = r2;
        this.f10368b = r3;
        this.f10369c = r4;
        this.f10370d = r5;
    }

    public final String a() {
        return this.f10367a;
    }

    public final String b() {
        return this.f10368b;
    }

    public final String c() {
        return this.f10369c;
    }

    public final SidecarBrand d() {
        return this.f10370d;
    }
}
