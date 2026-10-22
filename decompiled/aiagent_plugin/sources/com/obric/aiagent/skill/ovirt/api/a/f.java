package com.obric.aiagent.skill.ovirt.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: FileTransferResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiagent.skill.virt.api.e f20960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f20962c;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, f.class) == true) goto L8;
        return false;
    L8:
        f r8 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f20960a, r8.f20960a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f20961b, r8.f20961b) == true) goto L15;
        return false;
    L15:
        if (this.f20962c == r8.f20962c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f20960a.hashCode() * 31) + this.f20961b.hashCode()) * 31) + Long.hashCode(this.f20962c);
    }

    public String toString() {
        return "FileImportResult(virtPath=" + this.f20960a + ", fileName=" + this.f20961b + ", sizeBytes=" + this.f20962c + ')';
    }

    public f(com.obric.aiagent.skill.virt.api.e r2, String r3, long r4) {
        o.e(r2, "virtPath");
        o.e(r3, "fileName");
        this.f20960a = r2;
        this.f20961b = r3;
        this.f20962c = r4;
    }

    public final com.obric.aiagent.skill.virt.api.e a() {
        return this.f20960a;
    }

    public final String b() {
        return this.f20961b;
    }

    public final long c() {
        return this.f20962c;
    }
}
