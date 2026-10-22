package com.bytedance.android.gamecp.base.gamedetail;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShowType f51591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f51595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f51597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f51598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f51599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f51600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f51601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f51602l;

    public i0() {
        this(null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i0) == false) goto L30;
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f51591a, r101.f51591a) == true) goto L8;
        return false;
    L8:
        if (this.f51592b == r101.f51592b) goto L10;
        return false;
    L10:
        if (this.f51593c == r101.f51593c) goto L12;
        return false;
    L12:
        if (this.f51594d == r101.f51594d) goto L14;
        return false;
    L14:
        if (this.f51595e == r101.f51595e) goto L16;
        return false;
    L16:
        if (this.f51596f == r101.f51596f) goto L18;
        return false;
    L18:
        if (this.f51597g == r101.f51597g) goto L20;
        return false;
    L20:
        if (this.f51598h == r101.f51598h) goto L22;
        return false;
    L22:
        if (this.f51599i == r101.f51599i) goto L24;
        return false;
    L24:
        if (this.f51600j == r101.f51600j) goto L26;
        return false;
    L26:
        if (this.f51601k == r101.f51601k) goto L28;
        return false;
    L28:
        if (this.f51602l == r101.f51602l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        ShowType r100 = this.f51591a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((((((((((((((((r101 * 31) + this.f51592b) * 31) + this.f51593c) * 31) + this.f51594d) * 31) + this.f51595e) * 31) + this.f51596f) * 31) + this.f51597g) * 31) + this.f51598h) * 31) + this.f51599i) * 31) + this.f51600j) * 31) + this.f51601k) * 31) + this.f51602l;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "GameDetailDialogStyle(showType=" + this.f51591a + ", width=" + this.f51592b + ", height=" + this.f51593c + ", radiusLeftTop=" + this.f51594d + ", radiusLeftBottom=" + this.f51595e + ", radiusRightTop=" + this.f51596f + ", radiusRightBottom=" + this.f51597g + ", marginLeft=" + this.f51598h + ", marginTop=" + this.f51599i + ", marginRight=" + this.f51600j + ", marginBottom=" + this.f51601k + ", gravity=" + this.f51602l + ")";
    }

    public final boolean a() {
        if (this.f51591a != ShowType.SPLIT_SCREEN) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ i0(ShowType r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r110 = ShowType.NORMAL;
    L5:
        this(r110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public i0(ShowType r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "showType");
        this.f51591a = r100;
        this.f51592b = r101;
        this.f51593c = r102;
        this.f51594d = r103;
        this.f51595e = r104;
        this.f51596f = r105;
        this.f51597g = r106;
        this.f51598h = r107;
        this.f51599i = r110;
        this.f51600j = r111;
        this.f51601k = r112;
        this.f51602l = r113;
    }
}
