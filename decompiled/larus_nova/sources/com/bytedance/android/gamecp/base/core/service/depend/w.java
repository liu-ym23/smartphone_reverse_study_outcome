package com.bytedance.android.gamecp.base.core.service.depend;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class w implements Comparable<w> {
    public final long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f51411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f51414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f51415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f51416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f51417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f51418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f51419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f51420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f51421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f51422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f51423m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f51424n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f51425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f51426p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f51427q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double f51428r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double f51429s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f51430t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f51431u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f51432v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f51433w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f51434x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f51435y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f51436z;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        long r100 = this.A;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final int getType() {
        return this.f51421k;
    }

    public w(long r100) {
        this.A = r100;
        this.f51411a = "";
        this.f51426p = -1;
        this.f51427q = -1;
        this.f51435y = 1.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(w r100) {
        w r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "another");
        long r102 = this.f51420j;
        long r103 = r101.f51420j;
        if (r102 <= r103) goto L5;
        return -1;
    L5:
        if (r102 >= r103) goto L7;
        return 1;
    L7:
        return 0;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L9;
    L7:
        return false;
    L9:
        if (this.A != ((w) r100).A) goto L7;
        return true;
    }
}
