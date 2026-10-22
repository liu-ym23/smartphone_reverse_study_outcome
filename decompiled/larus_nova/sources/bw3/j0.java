package bw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f21095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f21096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f21097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f21098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Double f21099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Double f21100g;

    public j0() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f21094a, r101.f21094a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21095b, r101.f21095b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f21096c, r101.f21096c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f21097d, r101.f21097d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f21098e, r101.f21098e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f21099f, r101.f21099f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f21100g, r101.f21100g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f21094a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f21095b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f21096c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f21097d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.f21098e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Double r116 = this.f21099f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.f21100g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InnerAudioStateUpdate(src=" + this.f21094a + ", autoplay=" + this.f21095b + ", loop=" + this.f21096c + ", obeyMuteSwitch=" + this.f21097d + ", startTime=" + this.f21098e + ", volume=" + this.f21099f + ", playbackRate=" + this.f21100g + ')';
    }

    public j0(String r100, Boolean r101, Boolean r102, Double r103, Double r104, Double r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        this.f21094a = r100;
        this.f21095b = r101;
        this.f21096c = r102;
        this.f21097d = null;
        this.f21098e = r103;
        this.f21099f = r104;
        this.f21100g = r105;
    }
}
