package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f101399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f101400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f101401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f101402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f101403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f101404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f101405g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L20;
        n r101 = (n) r100;
        if (this.f101399a == r101.f101399a) goto L8;
        return false;
    L8:
        if (this.f101400b == r101.f101400b) goto L10;
        return false;
    L10:
        if (this.f101401c == r101.f101401c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f101402d, r101.f101402d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f101403e, r101.f101403e) == true) goto L16;
        return false;
    L16:
        if (this.f101404f == r101.f101404f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f101405g, r101.f101405g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f101399a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f101400b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f101401c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.f101402d;
        int r107 = 0;
        if (r106 == null) goto L5;
        int r108 = r106.hashCode();
    L6:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f101403e;
        if (r110 == null) goto L9;
        int r111 = r110.hashCode();
    L10:
        int r112 = (((r109 + r111) * 31) + this.f101404f) * 31;
        String r113 = this.f101405g;
        if (r113 == null) goto L14;
        r107 = r113.hashCode();
    L14:
        return r112 + r107;
    L9:
        r111 = 0;
        goto L10
    L5:
        r108 = 0;
        goto L6
    }

    public final String toString() {
        return "SchemeExtraParams(jumpMusicId=" + this.f101399a + ", inplaceSongCollectionId=" + this.f101400b + ", fromAnchorSongId=" + this.f101401c + ", liveType=" + this.f101402d + ", functionType=" + this.f101403e + ", defaultFirstLevelTabValue=" + this.f101404f + ", defaultSecondLevelTabName=" + this.f101405g + ")";
    }

    public n() {
        this(0, 0, 0, "", "", FirstLevelTab.Unknown.getValue(), "");
    }

    public static n a(n r110, int r111, String r112, int r210) {
        long r100 = 0;
        if ((r210 & 1) == 0) goto L5;
        long r101 = r110.f101399a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        long r102 = r110.f101400b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        r100 = r110.f101401c;
    L13:
        long r113 = r100;
        if ((r210 & 8) == 0) goto L16;
        String r114 = r110.f101402d;
    L18:
        if ((r210 & 16) == 0) goto L20;
        String r115 = r110.f101403e;
    L22:
        if ((r210 & 32) == 0) goto L24;
        int r116 = r110.f101404f;
    L26:
        if ((r210 & 64) == 0) goto L28;
        String r103 = r110.f101405g;
    L29:
        Intrinsics.checkNotNullParameter(r114, "liveType");
        Intrinsics.checkNotNullParameter(r115, "functionType");
        Intrinsics.checkNotNullParameter(r103, "defaultSecondLevelTabName");
        return new n(r101, r102, r113, r114, r115, r116, r103);
    L28:
        r103 = r112;
        goto L29
    L24:
        r116 = r111;
        goto L26
    L20:
        r115 = null;
        goto L22
    L16:
        r114 = null;
        goto L18
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }

    public n(long r100, long r101, long r102, String r103, String r104, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r103, "liveType");
        Intrinsics.checkNotNullParameter(r104, "functionType");
        Intrinsics.checkNotNullParameter(r111, "defaultSecondLevelTabName");
        this.f101399a = r100;
        this.f101400b = r101;
        this.f101401c = r102;
        this.f101402d = r103;
        this.f101403e = r104;
        this.f101404f = r110;
        this.f101405g = r111;
    }
}
