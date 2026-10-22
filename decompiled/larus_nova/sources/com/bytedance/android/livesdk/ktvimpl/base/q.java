package com.bytedance.android.livesdk.ktvimpl.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f143299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f143300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f143301c;

    public /* synthetic */ q() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L12;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f143299a, r101.f143299a) == true) goto L8;
        return false;
    L8:
        if (Double.compare(this.f143300b, r101.f143300b) == 0) goto L10;
        return false;
    L10:
        if (this.f143301c == r101.f143301c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f143299a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = Double.doubleToLongBits(this.f143300b);
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.f143301c;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ScoreItem(label=" + this.f143299a + ", value=" + this.f143300b + ", isHighlight=" + this.f143301c + ")";
    }

    public q(String r100, double r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "label");
        this.f143299a = r100;
        this.f143300b = r101;
        this.f143301c = r102;
    }
}
