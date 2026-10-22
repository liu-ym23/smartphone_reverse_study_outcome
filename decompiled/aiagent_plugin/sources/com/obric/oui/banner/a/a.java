package com.obric.oui.banner.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GridFillBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f34027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f34028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34029c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(Float.valueOf(a()), Float.valueOf(r6.a())) == true) goto L12;
        return false;
    L12:
        if (o.a(Float.valueOf(this.f34028b), Float.valueOf(r6.f34028b)) == true) goto L15;
        return false;
    L15:
        if (this.f34029c == r6.f34029c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(a()) * 31) + Float.hashCode(this.f34028b)) * 31) + Integer.hashCode(this.f34029c);
    }

    public String toString() {
        return "GridFillBannerConfig(titleTextSizeSp=" + a() + ", bannerRatio=" + this.f34028b + ", maxHeight=" + this.f34029c + ')';
    }

    public a(float r1, float r2, int r3) {
        this.f34027a = r1;
        this.f34028b = r2;
        this.f34029c = r3;
    }

    public /* synthetic */ a(float r1, float r2, int r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = Integer.MAX_VALUE;
    L5:
        this(r1, r2, r3);
    }

    public float a() {
        return this.f34027a;
    }

    public final float b() {
        return this.f34028b;
    }

    public final int c() {
        return this.f34029c;
    }
}
