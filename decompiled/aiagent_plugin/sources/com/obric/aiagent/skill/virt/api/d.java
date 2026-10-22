package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtFileBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f21562c;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, d.class) == true) goto L8;
        return false;
    L8:
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21560a, r8.f21560a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21561b, r8.f21561b) == true) goto L15;
        return false;
    L15:
        if (this.f21562c == r8.f21562c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f21560a.hashCode() * 31) + this.f21561b.hashCode()) * 31) + Long.hashCode(this.f21562c);
    }

    public String toString() {
        return "ExportedFile(hostPath=" + this.f21560a + ", fileName=" + this.f21561b + ", sizeBytes=" + this.f21562c + ')';
    }

    public d(String r2, String r3, long r4) {
        d.h.b.o.e(r2, "hostPath");
        d.h.b.o.e(r3, "fileName");
        this.f21560a = r2;
        this.f21561b = r3;
        this.f21562c = r4;
    }

    public final String a() {
        return this.f21560a;
    }

    public final String b() {
        return this.f21561b;
    }

    public final long c() {
        return this.f21562c;
    }
}
