package com.obric.common.upgrade;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppUpgradeResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("patch_url")
    private final String f32633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("patch_md5")
    private final String f32634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("patch_size")
    private final long f32635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("base_version_code")
    private final int f32636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("base_version_name")
    private final String f32637e;

    @SerializedName("base_apk_identity")
    private final String f;

    @SerializedName("base_md5")
    private final String g;

    @SerializedName("base_size")
    private final long h;

    public h() {
        this(null, null, 0, 0, null, null, null, 0, 255, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, h.class) == true) goto L8;
        return false;
    L8:
        h r10 = (h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.aiagent.plugin");
        if (o.a(this.f32633a, r10.f32633a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f32634b, r10.f32634b) == true) goto L15;
        return false;
    L15:
        if (this.f32635c == r10.f32635c) goto L18;
        return false;
    L18:
        if (this.f32636d == r10.f32636d) goto L21;
        return false;
    L21:
        if (o.a(this.f32637e, r10.f32637e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.f32633a.hashCode() * 31) + this.f32634b.hashCode()) * 31) + Long.hashCode(this.f32635c)) * 31) + Integer.hashCode(this.f32636d)) * 31) + this.f32637e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h);
    }

    public String toString() {
        return "PatchInfo(patchUrl=" + this.f32633a + ", patchMd5=" + this.f32634b + ", patchSize=" + this.f32635c + ", baseVersionCode=" + this.f32636d + ", baseVersionName=" + this.f32637e + ", baseApkIdentity=" + this.f + ", baseMd5=" + this.g + ", baseSize=" + this.h + ')';
    }

    public h(String r2, String r3, long r4, int r6, String r7, String r8, String r9, long r10) {
        o.e(r2, "patchUrl");
        o.e(r3, "patchMd5");
        o.e(r7, "baseVersionName");
        o.e(r8, "baseApkIdentity");
        o.e(r9, "baseMd5");
        this.f32633a = r2;
        this.f32634b = r3;
        this.f32635c = r4;
        this.f32636d = r6;
        this.f32637e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public /* synthetic */ h(String r4, String r5, long r6, int r8, String r9, String r10, String r11, long r12, int r14, d.h.b.h r15) {
        if ((r14 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = "";
    L9:
        if ((r14 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r8 = 0;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r9 = "";
    L18:
        if ((r14 & 32) == 0) goto L21;
        r10 = "";
    L21:
        if ((r14 & 64) == 0) goto L24;
        r11 = "";
    L24:
        if ((r14 & 128) == 0) goto L26;
        r12 = 0;
    L26:
        this(r4, r5, r6, r8, r9, r10, r11, r12);
    }
}
