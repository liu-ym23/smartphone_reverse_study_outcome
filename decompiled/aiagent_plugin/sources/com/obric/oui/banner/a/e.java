package com.obric.oui.banner.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GridTriptychBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f34037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34039c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(Float.valueOf(a()), Float.valueOf(r6.a())) == true) goto L12;
        return false;
    L12:
        if (this.f34038b == r6.f34038b) goto L15;
        return false;
    L15:
        if (this.f34039c == r6.f34039c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(a()) * 31) + Integer.hashCode(this.f34038b)) * 31) + Integer.hashCode(this.f34039c);
    }

    public String toString() {
        return "GridTriptychBannerConfig(titleTextSizeSp=" + a() + ", gridSpan=" + this.f34038b + ", itemGutterDp=" + this.f34039c + ')';
    }

    public e(float r1, int r2, int r3) {
        this.f34037a = r1;
        this.f34038b = r2;
        this.f34039c = r3;
    }

    public /* synthetic */ e(float r1, int r2, int r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 8;
    L5:
        this(r1, r2, r3);
    }

    public float a() {
        return this.f34037a;
    }

    public final int b() {
        return this.f34038b;
    }

    public final int c() {
        return this.f34039c;
    }
}
