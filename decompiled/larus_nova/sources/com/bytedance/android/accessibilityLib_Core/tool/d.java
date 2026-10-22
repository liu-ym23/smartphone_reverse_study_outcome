package com.bytedance.android.accessibilityLib_Core.tool;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38313b;

    public d() {
        this(0, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.f38312a == r101.f38312a) goto L8;
        return false;
    L8:
        if (this.f38313b == r101.f38313b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f38312a * 31) + this.f38313b;
    }

    public final String toString() {
        return "TimeFrequencyTrigger(internalLimit=" + this.f38312a + ", frequencyLimit=" + this.f38313b + ")";
    }

    public d(int r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 1000;
    L6:
        if ((r101 & 2) == 0) goto L8;
        int r102 = 10;
    L9:
        this.f38312a = r100;
        this.f38313b = r102;
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
