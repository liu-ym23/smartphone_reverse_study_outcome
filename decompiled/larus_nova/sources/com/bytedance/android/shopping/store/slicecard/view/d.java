package com.bytedance.android.shopping.store.slicecard.view;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f186369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f186370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f186371c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f186369a, r101.f186369a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f186370b, r101.f186370b) == true) goto L10;
        return false;
    L10:
        if (Float.compare(this.f186371c, r101.f186371c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int[] r100 = this.f186369a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        float[] r104 = this.f186370b;
        if (r104 == null) goto L10;
        r101 = Arrays.hashCode(r104);
    L10:
        return ((r103 + r101) * 31) + Float.floatToIntBits(this.f186371c);
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GradientSpec(colors=" + Arrays.toString(this.f186369a) + ", positions=" + Arrays.toString(this.f186370b) + ", orientation=" + this.f186371c + ")";
    }

    public d(int[] r100, float[] r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f186369a = r100;
        this.f186370b = r101;
        this.f186371c = r102;
    }
}
