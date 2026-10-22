package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CliPackageStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("version")
    private final String f20122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("filename")
    private final String f20123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("file_size")
    private final long f20124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("status")
    private final String f20125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("updated_at")
    private final long f20126e;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20122a, r10.f20122a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20123b, r10.f20123b) == true) goto L15;
        return false;
    L15:
        if (this.f20124c == r10.f20124c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20125d, r10.f20125d) == true) goto L21;
        return false;
    L21:
        if (this.f20126e == r10.f20126e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f20122a.hashCode() * 31) + this.f20123b.hashCode()) * 31) + Long.hashCode(this.f20124c)) * 31) + this.f20125d.hashCode()) * 31) + Long.hashCode(this.f20126e);
    }

    public String toString() {
        return "CliPackageState(version=" + this.f20122a + ", filename=" + this.f20123b + ", fileSize=" + this.f20124c + ", status=" + this.f20125d + ", updatedAt=" + this.f20126e + ')';
    }

    public j(String r2, String r3, long r4, String r6, long r7) {
        d.h.b.o.e(r2, "version");
        d.h.b.o.e(r3, "filename");
        d.h.b.o.e(r6, "status");
        this.f20122a = r2;
        this.f20123b = r3;
        this.f20124c = r4;
        this.f20125d = r6;
        this.f20126e = r7;
    }

    public final String a() {
        return this.f20122a;
    }

    public final String b() {
        return this.f20123b;
    }

    public final long c() {
        return this.f20124c;
    }
}
