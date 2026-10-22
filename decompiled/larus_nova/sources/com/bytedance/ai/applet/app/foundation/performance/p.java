package com.bytedance.ai.applet.app.foundation.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f34366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppletPerformanceNavigationType f34368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f34370e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f34366a == r101.f34366a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34367b, r101.f34367b) == true) goto L15;
        return false;
    L15:
        if (this.f34368c == r101.f34368c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34369d, r101.f34369d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f34370e, r101.f34370e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f34366a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f34367b.hashCode()) * 31;
        AppletPerformanceNavigationType r102 = this.f34368c;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f34369d;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f34370e;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "PagePerformanceTraceConfig(startTime=" + this.f34366a + ", path=" + this.f34367b + ", navigationType=" + this.f34368c + ", referrerPath=" + this.f34369d + ", referrerTraceId=" + this.f34370e + ')';
    }

    public /* synthetic */ p(long r100, String r110, AppletPerformanceNavigationType r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r110, r111, null, null);
    }

    public p(long r100, String r101, AppletPerformanceNavigationType r102, String r103, Long r104) {
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f34366a = r100;
        this.f34367b = r101;
        this.f34368c = r102;
        this.f34369d = r103;
        this.f34370e = r104;
    }
}
