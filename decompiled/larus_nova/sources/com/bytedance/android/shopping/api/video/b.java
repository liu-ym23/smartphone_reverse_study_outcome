package com.bytedance.android.shopping.api.video;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f170633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CodecType f170634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f170635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f170636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f170637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f170638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f170639i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f170631a, r101.f170631a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170632b, r101.f170632b) == true) goto L10;
        return false;
    L10:
        if (this.f170633c == r101.f170633c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170634d, r101.f170634d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f170635e, r101.f170635e) == true) goto L16;
        return false;
    L16:
        if (this.f170636f == r101.f170636f) goto L18;
        return false;
    L18:
        if (this.f170637g == r101.f170637g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f170638h, r101.f170638h) == true) goto L22;
        return false;
    L22:
        if (this.f170639i == r101.f170639i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170631a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f170632b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f170633c) * 31;
        CodecType r107 = this.f170634d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f170635e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f170636f;
        int r114 = (((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.f170637g) * 31;
        String r115 = this.f170638h;
        if (r115 == null) goto L22;
        r101 = r115.hashCode();
    L22:
        return ((r114 + r101) * 31) + this.f170639i;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECPlayItem(videoKey=" + this.f170631a + ", key=" + this.f170632b + ", bitRate=" + this.f170633c + ", codecType=" + this.f170634d + ", urls=" + this.f170635e + ", size=" + this.f170636f + ", duration=" + this.f170637g + ", gearName=" + this.f170638h + ", qualityType=" + this.f170639i + ")";
    }

    public b(String r100, String r101, int r102, CodecType r103, List<String> r104, long r105, int r106, String r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "videoKey");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r103, "codecType");
        Intrinsics.checkNotNullParameter(r104, "urls");
        Intrinsics.checkNotNullParameter(r110, "gearName");
        this.f170631a = r100;
        this.f170632b = r101;
        this.f170633c = r102;
        this.f170634d = r103;
        this.f170635e = r104;
        this.f170636f = r105;
        this.f170637g = r106;
        this.f170638h = r110;
        this.f170639i = r111;
    }
}
