package com.bytedance.ai.applet.domain;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f34601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f34602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f34603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f34604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f34605h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f34598a, r101.f34598a) == true) goto L12;
        return false;
    L12:
        if (this.f34599b == r101.f34599b) goto L15;
        return false;
    L15:
        if (this.f34600c == r101.f34600c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34601d, r101.f34601d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34602e, r101.f34602e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f34603f, r101.f34603f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f34604g, r101.f34604g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f34605h, r101.f34605h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f34598a.hashCode() * 31;
        long r101 = this.f34599b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f34600c == false) goto L5;
        int r103 = 1231;
    L7:
        return ((((((((((r102 + r103) * 31) + this.f34601d.hashCode()) * 31) + this.f34602e.hashCode()) * 31) + this.f34603f.hashCode()) * 31) + this.f34604g.hashCode()) * 31) + this.f34605h.hashCode();
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "AppletDomainPolicy(appKey=" + this.f34598a + ", snapshotVersion=" + this.f34599b + ", domainVerifySwitch=" + this.f34600c + ", requestDomains=" + this.f34601d + ", downloadDomains=" + this.f34602e + ", uploadDomains=" + this.f34603f + ", socketDomains=" + this.f34604g + ", webviewDomains=" + this.f34605h + ')';
    }

    public a(String r100, long r101, boolean r102, Set<String> r103, Set<String> r104, Set<String> r105, Set<String> r106, Set<String> r110) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r103, "requestDomains");
        Intrinsics.checkNotNullParameter(r104, "downloadDomains");
        Intrinsics.checkNotNullParameter(r105, "uploadDomains");
        Intrinsics.checkNotNullParameter(r106, "socketDomains");
        Intrinsics.checkNotNullParameter(r110, "webviewDomains");
        this.f34598a = r100;
        this.f34599b = r101;
        this.f34600c = r102;
        this.f34601d = r103;
        this.f34602e = r104;
        this.f34603f = r105;
        this.f34604g = r106;
        this.f34605h = r110;
    }
}
