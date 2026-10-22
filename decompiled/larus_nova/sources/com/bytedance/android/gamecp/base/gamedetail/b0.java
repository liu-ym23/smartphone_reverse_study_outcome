package com.bytedance.android.gamecp.base.gamedetail;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f51551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f51553g;

    public b0() {
        this(0, 0, 0, 0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L20;
        b0 r101 = (b0) r100;
        if (this.f51547a == r101.f51547a) goto L8;
        return false;
    L8:
        if (this.f51548b == r101.f51548b) goto L10;
        return false;
    L10:
        if (this.f51549c == r101.f51549c) goto L12;
        return false;
    L12:
        if (this.f51550d == r101.f51550d) goto L14;
        return false;
    L14:
        if (this.f51551e == r101.f51551e) goto L16;
        return false;
    L16:
        if (this.f51552f == r101.f51552f) goto L18;
        return false;
    L18:
        if (this.f51553g == r101.f51553g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.f51547a * 31) + this.f51548b) * 31) + this.f51549c) * 31) + this.f51550d) * 31) + this.f51551e) * 31) + this.f51552f) * 31) + this.f51553g;
    }

    public final String toString() {
        return "DetailDownloadViewStyle(readyBg=" + this.f51547a + ", downloadingBg=" + this.f51548b + ", downloadProgressDrawable=" + this.f51549c + ", downloadUnSupportBg=" + this.f51550d + ", downloadTvColor=" + this.f51551e + ", downloadUnSupportTvColor=" + this.f51552f + ", textTypeFace=" + this.f51553g + ")";
    }

    public /* synthetic */ b0(int r100, int r110, int r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        int r101 = R.drawable.gamecp_shape_game_detail_title_download_radius_8;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r102 = R.drawable.gamecp_shape_game_detail_title_downloading;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r103 = R.drawable.gamecp_game_detail_title_pb_radius_8;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r104 = R.drawable.gamecp_bg_download_unsupport_btn_radius_8;
    L19:
        if ((r113 & 16) == 0) goto L21;
        int r105 = R.color.white;
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
        r105 = r112;
        goto L23
    L17:
        r104 = 0;
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

    public b0(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.f51547a = r100;
        this.f51548b = r101;
        this.f51549c = r102;
        this.f51550d = r103;
        this.f51551e = r104;
        this.f51552f = r105;
        this.f51553g = r106;
    }
}
