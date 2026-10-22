package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ResourceDownloadConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f30650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f30651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f30652e;
    private final String f;
    private final int g;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, p.class) == true) goto L8;
        return false;
    L8:
        p r10 = (p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f30648a, r10.f30648a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f30649b, r10.f30649b) == true) goto L15;
        return false;
    L15:
        if (this.f30650c == r10.f30650c) goto L18;
        return false;
    L18:
        if (this.f30651d == r10.f30651d) goto L21;
        return false;
    L21:
        if (this.f30652e == r10.f30652e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.f30648a.hashCode() * 31) + this.f30649b.hashCode()) * 31) + Long.hashCode(this.f30650c)) * 31) + Integer.hashCode(this.f30651d)) * 31) + Integer.hashCode(this.f30652e)) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g);
    }

    public String toString() {
        return "ResourceDownloadConfig(appKey=" + this.f30648a + ", appSecretKey=" + this.f30649b + ", requestTimeoutMillis=" + this.f30650c + ", downloadRetryCount=" + this.f30651d + ", unzipRetryCount=" + this.f30652e + ", baseDirName=" + this.f + ", maxVersionsToKeepPerPackage=" + this.g + ')';
    }

    public p(String r2, String r3, long r4, int r6, int r7, String r8, int r9) {
        d.h.b.o.e(r2, "appKey");
        d.h.b.o.e(r3, "appSecretKey");
        d.h.b.o.e(r8, "baseDirName");
        this.f30648a = r2;
        this.f30649b = r3;
        this.f30650c = r4;
        this.f30651d = r6;
        this.f30652e = r7;
        this.f = r8;
        this.g = r9;
    }

    public /* synthetic */ p(String r12, String r13, long r14, int r16, int r17, String r18, int r19, int r20, d.h.b.h r21) {
        if ((r20 & 4) == 0) goto L5;
        long r5 = 10000;
    L7:
        if ((r20 & 8) == 0) goto L9;
        int r7 = 2;
    L11:
        if ((r20 & 16) == 0) goto L13;
        int r8 = 1;
    L15:
        if ((r20 & 32) == 0) goto L17;
        String r9 = "resource_download";
    L19:
        if ((r20 & 64) == 0) goto L21;
        int r10 = 3;
    L22:
        this(r12, r13, r5, r7, r8, r9, r10);
        return;
    L21:
        r10 = r19;
        goto L22
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final String a() {
        return this.f30648a;
    }

    public final String b() {
        return this.f30649b;
    }

    public final long c() {
        return this.f30650c;
    }

    public final int d() {
        return this.f30651d;
    }

    public final int e() {
        return this.f30652e;
    }

    public final String f() {
        return this.f;
    }
}
