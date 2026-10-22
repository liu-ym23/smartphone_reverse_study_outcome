package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtFileBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f21574b;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, h.class) == true) goto L8;
        return false;
    L8:
        h r8 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21573a, r8.f21573a) == true) goto L12;
        return false;
    L12:
        if (this.f21574b == r8.f21574b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f21573a.hashCode() * 31) + Long.hashCode(this.f21574b);
    }

    public String toString() {
        return "ImportedFile(fileName=" + this.f21573a + ", sizeBytes=" + this.f21574b + ')';
    }

    public h(String r2, long r3) {
        d.h.b.o.e(r2, "fileName");
        this.f21573a = r2;
        this.f21574b = r3;
    }

    public final String a() {
        return this.f21573a;
    }

    public final long b() {
        return this.f21574b;
    }
}
