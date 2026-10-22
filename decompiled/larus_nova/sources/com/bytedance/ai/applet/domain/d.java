package com.bytedance.ai.applet.domain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f34610e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f34606a, r101.f34606a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34607b, r101.f34607b) == true) goto L15;
        return false;
    L15:
        if (this.f34608c == r101.f34608c) goto L18;
        return false;
    L18:
        if (this.f34609d == r101.f34609d) goto L21;
        return false;
    L21:
        if (this.f34610e == r101.f34610e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f34606a.hashCode() * 31) + this.f34607b.hashCode()) * 31;
        long r101 = this.f34608c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f34609d == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        long r105 = this.f34610e;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "CachedDomainPolicy(signedPayload=" + this.f34606a + ", signature=" + this.f34607b + ", snapshotVersion=" + this.f34608c + ", domainVerifySwitch=" + this.f34609d + ", cachedAtMillis=" + this.f34610e + ')';
    }

    public d() {
        this("", "", 0, true, 0);
    }

    public d(String r100, String r101, long r102, boolean r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "signedPayload");
        Intrinsics.checkNotNullParameter(r101, "signature");
        this.f34606a = r100;
        this.f34607b = r101;
        this.f34608c = r102;
        this.f34609d = r103;
        this.f34610e = r104;
    }
}
