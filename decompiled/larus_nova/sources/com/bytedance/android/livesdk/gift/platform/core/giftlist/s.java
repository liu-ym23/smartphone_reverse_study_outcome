package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f130630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f130631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final py.k f130632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f130633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py.k f130634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Long> f130635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f130636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f130637h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L22;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f130630a, r101.f130630a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130631b, r101.f130631b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f130632c, r101.f130632c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f130633d, r101.f130633d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f130634e, r101.f130634e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f130635f, r101.f130635f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f130636g, r101.f130636g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f130637h, r101.f130637h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int[] r100 = this.f130630a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        int[] r104 = this.f130631b;
        if (r104 == null) goto L9;
        int r105 = Arrays.hashCode(r104);
    L10:
        int r106 = (r103 + r105) * 31;
        py.k r107 = this.f130632c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f130633d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        py.k r113 = this.f130634e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<Long> r116 = this.f130635f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f130636g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f130637h;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
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
        return "SectionInfo(sectionBgStartColor=" + Arrays.toString(this.f130630a) + ", sectionBgEndColor=" + Arrays.toString(this.f130631b) + ", sectionHeaderImg=" + this.f130632c + ", entranceText=" + this.f130633d + ", entranceIconImg=" + this.f130634e + ", gifts=" + this.f130635f + ", sectionName=" + this.f130636g + ", entranceSchema=" + this.f130637h + ")";
    }

    public s(int[] r100, int[] r101, py.k r102, String r103, py.k r104, List<Long> r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "sectionBgStartColor");
        Intrinsics.checkNotNullParameter(r101, "sectionBgEndColor");
        Intrinsics.checkNotNullParameter(r103, "entranceText");
        Intrinsics.checkNotNullParameter(r105, "gifts");
        Intrinsics.checkNotNullParameter(r106, "sectionName");
        Intrinsics.checkNotNullParameter(r107, "entranceSchema");
        this.f130630a = r100;
        this.f130631b = r101;
        this.f130632c = r102;
        this.f130633d = r103;
        this.f130634e = r104;
        this.f130635f = r105;
        this.f130636g = r106;
        this.f130637h = r107;
    }
}
