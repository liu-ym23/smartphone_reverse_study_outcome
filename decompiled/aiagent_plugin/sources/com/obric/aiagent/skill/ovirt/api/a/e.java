package com.obric.aiagent.skill.ovirt.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: FileTransferResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f20957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f20959d;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
        return false;
    L8:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f20956a, r8.f20956a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f20957b, r8.f20957b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f20958c, r8.f20958c) == true) goto L18;
        return false;
    L18:
        if (this.f20959d == r8.f20959d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f20956a.hashCode() * 31) + this.f20957b.hashCode()) * 31) + this.f20958c.hashCode()) * 31) + Long.hashCode(this.f20959d);
    }

    public String toString() {
        return "FileExportResult(absolutePath=" + this.f20956a + ", hostFile=" + this.f20957b + ", fileName=" + this.f20958c + ", sizeBytes=" + this.f20959d + ')';
    }

    public e(String r2, File r3, String r4, long r5) {
        o.e(r2, "absolutePath");
        o.e(r3, "hostFile");
        o.e(r4, "fileName");
        this.f20956a = r2;
        this.f20957b = r3;
        this.f20958c = r4;
        this.f20959d = r5;
    }

    public final File a() {
        return this.f20957b;
    }

    public final String b() {
        return this.f20958c;
    }

    public final long c() {
        return this.f20959d;
    }
}
