package com.bytedance.safetyguard.lxc.internal.e.a;

import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkAppRegistrationPollStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SidecarBrand f10341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10342b;

    public final c a(SidecarBrand r1, boolean r2) {
        d.h.b.o.e(r1, PlatformConst.BUNDLE_KEY_BRAND);
        return new c(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f10341a == r6.f10341a) goto L12;
        return false;
    L12:
        if (this.f10342b == r6.f10342b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10341a.hashCode() * 31) + Boolean.hashCode(this.f10342b);
    }

    public String toString() {
        return "AppRegistrationPollState(brand=" + this.f10341a + ", hasSwitchedBrand=" + this.f10342b + ')';
    }

    public c(SidecarBrand r2, boolean r3) {
        d.h.b.o.e(r2, PlatformConst.BUNDLE_KEY_BRAND);
        this.f10341a = r2;
        this.f10342b = r3;
    }

    public /* synthetic */ c(SidecarBrand r1, boolean r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public final SidecarBrand a() {
        return this.f10341a;
    }

    public final boolean b() {
        return this.f10342b;
    }
}
