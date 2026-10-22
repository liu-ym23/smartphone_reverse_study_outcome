package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: PersistentSkillRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f19756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19759d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, dp.class) == true) goto L8;
        return false;
    L8:
        dp r10 = (dp) ZeusTransformUtils.preCheckCast(r9, dp.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19756a, r10.f19756a) == true) goto L12;
        return false;
    L12:
        if (this.f19757b == r10.f19757b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19758c, r10.f19758c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19759d, r10.f19759d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f19756a.hashCode() * 31) + Long.hashCode(this.f19757b)) * 31) + this.f19758c.hashCode()) * 31) + this.f19759d.hashCode();
    }

    public String toString() {
        return "SkillPackageExport(file=" + this.f19756a + ", fileSize=" + this.f19757b + ", sha256=" + this.f19758c + ", skillMdContent=" + this.f19759d + ')';
    }

    public dp(File r2, long r3, String r5, String r6) {
        d.h.b.o.e(r2, "file");
        d.h.b.o.e(r5, "sha256");
        d.h.b.o.e(r6, "skillMdContent");
        this.f19756a = r2;
        this.f19757b = r3;
        this.f19758c = r5;
        this.f19759d = r6;
    }

    public final File a() {
        return this.f19756a;
    }

    public final long b() {
        return this.f19757b;
    }

    public final String c() {
        return this.f19758c;
    }

    public final String d() {
        return this.f19759d;
    }
}
