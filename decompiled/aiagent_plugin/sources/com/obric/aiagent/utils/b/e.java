package com.obric.aiagent.utils.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LocalMediaMetadataExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f22327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f22328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f22329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f22330d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22327a, r6.f22327a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22328b, r6.f22328b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f22329c, r6.f22329c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f22330d, r6.f22330d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f22327a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f22328b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.f22329c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        d r10 = this.f22330d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LocalVideoInfo(width=" + this.f22327a + ", height=" + this.f22328b + ", durationMs=" + this.f22329c + ", cover=" + this.f22330d + ')';
    }

    public e(Integer r1, Integer r2, Long r3, d r4) {
        this.f22327a = r1;
        this.f22328b = r2;
        this.f22329c = r3;
        this.f22330d = r4;
    }

    public final Integer a() {
        return this.f22327a;
    }

    public final Integer b() {
        return this.f22328b;
    }

    public final Long c() {
        return this.f22329c;
    }

    public final d d() {
        return this.f22330d;
    }
}
