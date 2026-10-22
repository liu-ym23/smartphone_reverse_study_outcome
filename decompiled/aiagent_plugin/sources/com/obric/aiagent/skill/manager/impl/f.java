package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("download_url")
    private final String f19856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("expires_at")
    private final long f19857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("version")
    private final String f19858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("status")
    private final String f19859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("filename")
    private final String f19860e;

    @SerializedName("file_size")
    private final long f;

    public f() {
        this(null, 0, null, null, null, 0, 63, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19856a, r10.f19856a) == true) goto L12;
        return false;
    L12:
        if (this.f19857b == r10.f19857b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19858c, r10.f19858c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19859d, r10.f19859d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19860e, r10.f19860e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.f19856a.hashCode() * 31) + Long.hashCode(this.f19857b)) * 31) + this.f19858c.hashCode()) * 31) + this.f19859d.hashCode()) * 31) + this.f19860e.hashCode()) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "CliBinaryDownloadData(downloadUrl=" + this.f19856a + ", expiresAt=" + this.f19857b + ", version=" + this.f19858c + ", status=" + this.f19859d + ", filename=" + this.f19860e + ", fileSize=" + this.f + ')';
    }

    public f(String r2, long r3, String r5, String r6, String r7, long r8) {
        d.h.b.o.e(r2, "downloadUrl");
        d.h.b.o.e(r5, "version");
        d.h.b.o.e(r6, "status");
        d.h.b.o.e(r7, "filename");
        this.f19856a = r2;
        this.f19857b = r3;
        this.f19858c = r5;
        this.f19859d = r6;
        this.f19860e = r7;
        this.f = r8;
    }

    public /* synthetic */ f(String r2, long r3, String r5, String r6, String r7, long r8, int r10, d.h.b.h r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r5 = "";
    L12:
        if ((r10 & 8) == 0) goto L15;
        r6 = "";
    L15:
        if ((r10 & 16) == 0) goto L18;
        r7 = "";
    L18:
        if ((r10 & 32) == 0) goto L20;
        r8 = -1;
    L20:
        this(r2, r3, r5, r6, r7, r8);
    }

    public final String a() {
        return this.f19856a;
    }

    public final String b() {
        return this.f19858c;
    }

    public final String c() {
        return this.f19859d;
    }

    public final String d() {
        return this.f19860e;
    }

    public final long e() {
        return this.f;
    }
}
