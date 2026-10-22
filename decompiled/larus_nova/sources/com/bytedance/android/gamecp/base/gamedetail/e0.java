package com.bytedance.android.gamecp.base.gamedetail;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f51572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f51574g;

    public e0() {
        this(0, 0, 0, 0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L20;
        e0 r101 = (e0) r100;
        if (this.f51568a == r101.f51568a) goto L8;
        return false;
    L8:
        if (this.f51569b == r101.f51569b) goto L10;
        return false;
    L10:
        if (this.f51570c == r101.f51570c) goto L12;
        return false;
    L12:
        if (this.f51571d == r101.f51571d) goto L14;
        return false;
    L14:
        if (this.f51572e == r101.f51572e) goto L16;
        return false;
    L16:
        if (this.f51573f == r101.f51573f) goto L18;
        return false;
    L18:
        if (this.f51574g == r101.f51574g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.f51568a * 31) + this.f51569b) * 31) + this.f51570c) * 31) + this.f51571d) * 31) + this.f51572e) * 31) + this.f51573f) * 31) + this.f51574g;
    }

    public final String toString() {
        return "DetailTitleDownloadViewStyle(readyBg=" + this.f51568a + ", downloadingBg=" + this.f51569b + ", downloadProgressDrawable=" + this.f51570c + ", downloadTvColor=" + this.f51571d + ", downloadUnSupportBg=" + this.f51572e + ", downloadUnSupportTvColor=" + this.f51573f + ", textTypeFace=" + this.f51574g + ")";
    }

    public /* synthetic */ e0(int r100, int r110, int r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        int r101 = R.drawable.gamecp_shape_game_detail_title_download;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r102 = R.drawable.gamecp_shape_game_detail_title_downloading;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r103 = R.drawable.gamecp_game_detail_title_pb;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r104 = R.color.white;
    L19:
        if ((r113 & 16) == 0) goto L21;
        int r105 = R.drawable.gamecp_bg_download_unsupport_btn;
    L23:
        if ((r113 & 32) == 0) goto L25;
        int r106 = R.color.gamecp_game_57161823;
    L26:
        this(r101, r102, r103, r104, r105, r106, 0);
        return;
    L25:
        r106 = 0;
        goto L26
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public e0(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.f51568a = r100;
        this.f51569b = r101;
        this.f51570c = r102;
        this.f51571d = r103;
        this.f51572e = r104;
        this.f51573f = r105;
        this.f51574g = r106;
    }
}
