package com.bytedance.android.shopping.anchorv3.widget;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f165603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f165604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f165605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f165606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f165607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f165608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f165609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f165610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f165611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f165612j;

    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L26;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f165603a, r101.f165603a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f165604b, r101.f165604b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f165605c, r101.f165605c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f165606d, r101.f165606d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f165607e, r101.f165607e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f165608f, r101.f165608f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f165609g, r101.f165609g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f165610h, r101.f165610h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f165611i, r101.f165611i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f165612j, r101.f165612j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f165603a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f165604b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f165605c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f165606d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f165607e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f165608f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f165609g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f165610h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f165611i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, Object> r128 = this.f165612j;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "SearchParams(isLuban=" + this.f165603a + ", thirdParty=" + this.f165604b + ", productId=" + this.f165605c + ", fullscreen=" + this.f165606d + ", enterFrom=" + this.f165607e + ", authorId=" + this.f165608f + ", enterMethod=" + this.f165609g + ", enterFromSecond=" + this.f165610h + ", searchPageSchema=" + this.f165611i + ", searchPageParams=" + this.f165612j + ")";
    }

    public f(Boolean r100, Boolean r101, String r102, Boolean r103, String r104, String r105, String r106, String r110, Map r111, int r112) {
        if ((r112 & 64) == 0) goto L6;
        r105 = null;
    L6:
        if ((r112 & 128) == 0) goto L9;
        r106 = null;
    L9:
        if ((r112 & 256) == 0) goto L12;
        r110 = null;
    L12:
        if ((r112 & 512) == 0) goto L14;
        r111 = null;
    L14:
        this.f165603a = r100;
        this.f165604b = r101;
        this.f165605c = r102;
        this.f165606d = r103;
        this.f165607e = r104;
        this.f165608f = null;
        this.f165609g = r105;
        this.f165610h = r106;
        this.f165611i = r110;
        this.f165612j = r111;
    }
}
