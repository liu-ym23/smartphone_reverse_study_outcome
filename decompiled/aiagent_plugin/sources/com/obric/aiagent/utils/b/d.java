package com.obric.aiagent.utils.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: LocalMediaMetadataExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f22323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22326d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22323a, r6.f22323a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22324b, r6.f22324b) == true) goto L15;
        return false;
    L15:
        if (this.f22325c == r6.f22325c) goto L18;
        return false;
    L18:
        if (this.f22326d == r6.f22326d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f22323a.hashCode() * 31) + this.f22324b.hashCode()) * 31) + Integer.hashCode(this.f22325c)) * 31) + Integer.hashCode(this.f22326d);
    }

    public String toString() {
        return "LocalVideoCoverInfo(file=" + this.f22323a + ", extensionName=" + this.f22324b + ", width=" + this.f22325c + ", height=" + this.f22326d + ')';
    }

    public d(File r2, String r3, int r4, int r5) {
        o.e(r2, "file");
        o.e(r3, "extensionName");
        this.f22323a = r2;
        this.f22324b = r3;
        this.f22325c = r4;
        this.f22326d = r5;
    }

    public final File a() {
        return this.f22323a;
    }

    public final String b() {
        return this.f22324b;
    }

    public final int c() {
        return this.f22325c;
    }

    public final int d() {
        return this.f22326d;
    }
}
