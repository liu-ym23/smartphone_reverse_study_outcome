package com.bytedance.android.live.revlink.impl.pk.feedview.sei;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f96623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f96624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f96625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f96626d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f96623a == r101.f96623a) goto L8;
        return false;
    L8:
        if (this.f96624b == r101.f96624b) goto L10;
        return false;
    L10:
        if (this.f96625c == r101.f96625c) goto L12;
        return false;
    L12:
        if (this.f96626d == r101.f96626d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f96623a * 31) + this.f96624b) * 31) + this.f96625c) * 31) + this.f96626d;
    }

    public final String toString() {
        return "RenderPosition(rLeft=" + this.f96623a + ", rTop=" + this.f96624b + ", rWidth=" + this.f96625c + ", rHeight=" + this.f96626d + ")";
    }

    public a(int r100, int r101, int r102, int r103) {
        this.f96623a = r100;
        this.f96624b = r101;
        this.f96625c = r102;
        this.f96626d = r103;
    }
}
