package com.obric.autogui.agents.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectImageFingerprint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f26355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f26357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f26359e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f26355a == r6.f26355a) goto L12;
        return false;
    L12:
        if (this.f26356b == r6.f26356b) goto L15;
        return false;
    L15:
        if (this.f26357c == r6.f26357c) goto L18;
        return false;
    L18:
        if (this.f26358d == r6.f26358d) goto L21;
        return false;
    L21:
        if (this.f26359e == r6.f26359e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.f26355a) * 31) + Boolean.hashCode(this.f26356b)) * 31) + Integer.hashCode(this.f26357c)) * 31) + Integer.hashCode(this.f26358d)) * 31) + Integer.hashCode(this.f26359e)) * 31) + Boolean.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j);
    }

    public String toString() {
        return "ActionEffectImageDifference(hammingDistance=" + this.f26355a + ", pixelComparisonAvailable=" + this.f26356b + ", changedPixelCount=" + this.f26357c + ", changedPixelPermille=" + this.f26358d + ", maxBlockChangedPixelPermille=" + this.f26359e + ", targetRegionComparisonAvailable=" + this.f + ", targetRegionPixelCount=" + this.g + ", targetRegionChangedPixelCount=" + this.h + ", targetRegionChangedPixelPermille=" + this.i + ", outsideTargetRegionChangedPixelPermille=" + this.j + ')';
    }

    public b(int r1, boolean r2, int r3, int r4, int r5, boolean r6, int r7, int r8, int r9, int r10) {
        this.f26355a = r1;
        this.f26356b = r2;
        this.f26357c = r3;
        this.f26358d = r4;
        this.f26359e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final int a() {
        return this.f26355a;
    }

    public final boolean b() {
        return this.f26356b;
    }

    public final int c() {
        return this.f26357c;
    }

    public final int d() {
        return this.f26358d;
    }

    public final int e() {
        return this.f26359e;
    }

    public final boolean f() {
        return this.f;
    }

    public final int g() {
        return this.h;
    }

    public final int h() {
        return this.i;
    }

    public final int i() {
        return this.j;
    }
}
