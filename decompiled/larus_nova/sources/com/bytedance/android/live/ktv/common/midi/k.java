package com.bytedance.android.live.ktv.common.midi;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f69860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f69861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f69862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f69863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f69864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f69865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f69866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f69867h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L22;
        k r101 = (k) r100;
        if (Float.compare(this.f69860a, r101.f69860a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f69861b, r101.f69861b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f69862c, r101.f69862c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f69863d, r101.f69863d) == 0) goto L14;
        return false;
    L14:
        if (this.f69864e == r101.f69864e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f69865f, r101.f69865f) == true) goto L18;
        return false;
    L18:
        if (this.f69866g == r101.f69866g) goto L20;
        return false;
    L20:
        if (this.f69867h == r101.f69867h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public final int hashCode() {
        int r100 = ((((((((Float.floatToIntBits(this.f69860a) * 31) + Float.floatToIntBits(this.f69861b)) * 31) + Float.floatToIntBits(this.f69862c)) * 31) + Float.floatToIntBits(this.f69863d)) * 31) + this.f69864e) * 31;
        Integer r101 = this.f69865f;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (((r100 + r102) * 31) + this.f69866g) * 31;
        boolean r104 = this.f69867h;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ScoreInfo(curTone=" + this.f69860a + ", midiTone=" + this.f69861b + ", sentenceScore=" + this.f69862c + ", avgScore=" + this.f69863d + ", curSentenceIndex=" + this.f69864e + ", hitType=" + this.f69865f + ", comboCount=" + this.f69866g + ", isSeekData=" + this.f69867h + ")";
    }

    public k(float r100, float r101, float r102, float r103, int r104, Integer r105, int r106, boolean r110, int r111) {
        if ((r111 & 32) == 0) goto L6;
        r105 = null;
    L6:
        if ((r111 & 64) == 0) goto L9;
        r106 = 0;
    L9:
        if ((r111 & 128) == 0) goto L11;
        r110 = false;
    L11:
        this.f69860a = r100;
        this.f69861b = r101;
        this.f69862c = r102;
        this.f69863d = r103;
        this.f69864e = r104;
        this.f69865f = r105;
        this.f69866g = r106;
        this.f69867h = r110;
    }
}
