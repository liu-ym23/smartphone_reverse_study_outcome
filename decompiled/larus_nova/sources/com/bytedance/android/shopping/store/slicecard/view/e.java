package com.bytedance.android.shopping.store.slicecard.view;

import android.graphics.Typeface;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f186372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f186373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f186374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f186375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Typeface f186376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f186377f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f186372a, r101.f186372a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f186373b, r101.f186373b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f186374c, r101.f186374c) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f186375d, r101.f186375d) == 0) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f186376e, r101.f186376e) == true) goto L16;
        return false;
    L16:
        if (Float.compare(this.f186377f, r101.f186377f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f186372a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        int[] r104 = this.f186373b;
        if (r104 == null) goto L9;
        int r105 = Arrays.hashCode(r104);
    L10:
        int r106 = (r103 + r105) * 31;
        float[] r107 = this.f186374c;
        if (r107 == null) goto L13;
        int r108 = Arrays.hashCode(r107);
    L14:
        int r109 = (((r106 + r108) * 31) + Float.floatToIntBits(this.f186375d)) * 31;
        Typeface r110 = this.f186376e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return ((r109 + r101) * 31) + Float.floatToIntBits(this.f186377f);
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ResolvedTextStyle(solidColor=" + this.f186372a + ", gradientColors=" + Arrays.toString(this.f186373b) + ", gradientPositions=" + Arrays.toString(this.f186374c) + ", textSizePx=" + this.f186375d + ", typeface=" + this.f186376e + ", gradientOrientation=" + this.f186377f + ")";
    }

    public e(Integer r100, int[] r101, float[] r102, float r103, Typeface r104, float r105) {
        this.f186372a = r100;
        this.f186373b = r101;
        this.f186374c = r102;
        this.f186375d = r103;
        this.f186376e = r104;
        this.f186377f = r105;
    }
}
