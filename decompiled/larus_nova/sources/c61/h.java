package c61;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f22536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f22537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f22539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f22540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f22541g;

    public h() {
        this(0, 0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L20;
        h r101 = (h) r100;
        if (this.f22535a == r101.f22535a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f22536b, r101.f22536b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f22537c, r101.f22537c) == true) goto L12;
        return false;
    L12:
        if (this.f22538d == r101.f22538d) goto L14;
        return false;
    L14:
        if (this.f22539e == r101.f22539e) goto L16;
        return false;
    L16:
        if (this.f22540f == r101.f22540f) goto L18;
        return false;
    L18:
        if (this.f22541g == r101.f22541g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f22535a * 31;
        Float r101 = this.f22536b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Float r105 = this.f22537c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((((((((r104 + r102) * 31) + this.f22538d) * 31) + this.f22539e) * 31) + this.f22540f) * 31) + this.f22541g;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "InitLocationConfig(initGravity=" + this.f22535a + ", initX=" + this.f22536b + ", initY=" + this.f22537c + ", leftX=" + this.f22538d + ", topY=" + this.f22539e + ", rightX=" + this.f22540f + ", bottomY=" + this.f22541g + ")";
    }

    public h(int r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = 3;
    L5:
        int r103 = 0;
        if ((r102 & 8) == 0) goto L8;
        int r104 = -1;
    L10:
        if ((r102 & 16) == 0) goto L12;
        int r105 = -1;
    L14:
        if ((r102 & 32) == 0) goto L17;
        r103 = -1;
    L17:
        if ((r102 & 64) == 0) goto L19;
        r101 = -1;
    L19:
        this.f22535a = r100;
        this.f22536b = null;
        this.f22537c = null;
        this.f22538d = r104;
        this.f22539e = r105;
        this.f22540f = r103;
        this.f22541g = r101;
        return;
    L12:
        r105 = 0;
        goto L14
    L8:
        r104 = 0;
        goto L10
    }
}
