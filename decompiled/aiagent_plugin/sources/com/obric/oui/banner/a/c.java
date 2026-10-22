package com.obric.oui.banner.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GridIndentBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f34032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f34033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34034c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(Float.valueOf(a()), Float.valueOf(r6.a())) == true) goto L12;
        return false;
    L12:
        if (o.a(Float.valueOf(this.f34033b), Float.valueOf(r6.f34033b)) == true) goto L15;
        return false;
    L15:
        if (this.f34034c == r6.f34034c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(a()) * 31) + Float.hashCode(this.f34033b)) * 31) + Integer.hashCode(this.f34034c);
    }

    public String toString() {
        return "GridIndentBannerConfig(titleTextSizeSp=" + a() + ", bannerRatio=" + this.f34033b + ", maxHeight=" + this.f34034c + ')';
    }

    public c(float r1, float r2, int r3) {
        this.f34032a = r1;
        this.f34033b = r2;
        this.f34034c = r3;
    }

    public /* synthetic */ c(float r1, float r2, int r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = Integer.MAX_VALUE;
    L5:
        this(r1, r2, r3);
    }

    public float a() {
        return this.f34032a;
    }

    public final float b() {
        return this.f34033b;
    }

    public final int c() {
        return this.f34034c;
    }
}
