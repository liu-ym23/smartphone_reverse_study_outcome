package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f129082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f129083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f129084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f129085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f129086e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f129082a == r101.f129082a) goto L8;
        return false;
    L8:
        if (this.f129083b == r101.f129083b) goto L10;
        return false;
    L10:
        if (this.f129084c == r101.f129084c) goto L12;
        return false;
    L12:
        if (this.f129085d == r101.f129085d) goto L14;
        return false;
    L14:
        if (this.f129086e == r101.f129086e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.f129082a * 31) + this.f129083b) * 31) + this.f129084c) * 31) + this.f129085d) * 31) + this.f129086e;
    }

    public final String toString() {
        return "DownloadTypeCount(downloadType1=" + this.f129082a + ", downloadType2=" + this.f129083b + ", downloadType3=" + this.f129084c + ", downloadType4=" + this.f129085d + ", unknow=" + this.f129086e + ")";
    }

    public d(int r100) {
        this.f129082a = 0;
        this.f129083b = 0;
        this.f129084c = 0;
        this.f129085d = 0;
        this.f129086e = 0;
    }

    public final void a(int r100) {
        if (r100 != 1) goto L5;
        this.f129082a++;
        return;
    L5:
        if (r100 != 2) goto L7;
        this.f129083b++;
        return;
    L7:
        if (r100 != 3) goto L9;
        this.f129084c++;
        return;
    L9:
        if (r100 == 4) goto L11;
        this.f129086e++;
        return;
    L11:
        this.f129085d++;
    }
}
