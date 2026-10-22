package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IpAddressClassifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f9733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f9734b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f9733a == r6.f9733a) goto L12;
        return false;
    L12:
        if (this.f9734b == r6.f9734b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f9733a.hashCode() * 31;
        b r1 = this.f9734b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "IpAddressClassification(category=" + this.f9733a + ", mappedIpv4Category=" + this.f9734b + ')';
    }

    public c(b r2, b r3) {
        d.h.b.o.e(r2, "category");
        this.f9733a = r2;
        this.f9734b = r3;
    }

    public /* synthetic */ c(b r1, b r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final b a() {
        return this.f9733a;
    }

    public final b b() {
        return this.f9734b;
    }

    public final boolean c() {
        if (this.f9733a == b.f9728a) goto L5;
        return true;
    L5:
        return false;
    }
}
