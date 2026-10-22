package com.bytedance.ai.applet.app.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f34499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f34502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f34503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f34504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f34505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f34506j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f34497a == r101.f34497a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34498b, r101.f34498b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34499c, r101.f34499c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34500d, r101.f34500d) == true) goto L21;
        return false;
    L21:
        if (this.f34501e == r101.f34501e) goto L24;
        return false;
    L24:
        if (this.f34502f == r101.f34502f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f34503g, r101.f34503g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f34504h, r101.f34504h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f34505i, r101.f34505i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f34506j, r101.f34506j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f34497a * 31) + this.f34498b.hashCode()) * 31;
        Integer r101 = this.f34499c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f34500d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f34501e) * 31;
        if (this.f34502f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        Integer r110 = this.f34503g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f34504h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f34505i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f34506j;
        if (r119 == null) goto L31;
        r102 = r119.hashCode();
    L31:
        return r118 + r102;
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
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuItem(itemId=" + this.f34497a + ", title=" + this.f34498b + ", iconRes=" + this.f34499c + ", iconUrl=" + this.f34500d + ", order=" + this.f34501e + ", enable=" + this.f34502f + ", backgroundRes=" + this.f34503g + ", backgroundUrl=" + this.f34504h + ", trackValue=" + this.f34505i + ", titleColor=" + this.f34506j + ')';
    }

    public static m a(m r110, String r111, Integer r112, boolean r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        int r100 = r110.f34497a;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = r110.f34498b;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Integer r102 = r110.f34499c;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r103 = r110.f34500d;
    L19:
        if ((r114 & 16) == 0) goto L21;
        int r104 = r110.f34501e;
    L23:
        if ((r114 & 32) == 0) goto L25;
        boolean r115 = r110.f34502f;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r116 = r110.f34503g;
    L31:
        if ((r114 & 128) == 0) goto L33;
        String r117 = r110.f34504h;
    L35:
        if ((r114 & 256) == 0) goto L37;
        String r118 = r110.f34505i;
    L39:
        if ((r114 & 512) == 0) goto L41;
        Integer r119 = r110.f34506j;
    L42:
        Intrinsics.checkNotNullParameter(r101, "title");
        return new m(r100, r101, r102, r103, r104, r115, r116, r117, r118, r119);
    L41:
        r119 = null;
        goto L42
    L37:
        r118 = null;
        goto L39
    L33:
        r117 = null;
        goto L35
    L29:
        r116 = null;
        goto L31
    L25:
        r115 = r113;
        goto L27
    L21:
        r104 = 0;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }

    public /* synthetic */ m(int r110, String r111, Integer r112, int r113, boolean r114, Integer r210, String r211, Integer r212, int r213) {
        if ((r213 & 4) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r213 & 64) == 0) goto L9;
        Integer r115 = null;
    L11:
        if ((r213 & 256) == 0) goto L13;
        String r116 = null;
    L15:
        if ((r213 & 512) == 0) goto L17;
        Integer r117 = null;
    L18:
        this(r110, r111, r100, null, r113, r114, r115, null, r116, r117);
        return;
    L17:
        r117 = r212;
        goto L18
    L13:
        r116 = r211;
        goto L15
    L9:
        r115 = r210;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public m(int r100, String r101, Integer r102, String r103, int r104, boolean r105, Integer r106, String r107, String r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f34497a = r100;
        this.f34498b = r101;
        this.f34499c = r102;
        this.f34500d = r103;
        this.f34501e = r104;
        this.f34502f = r105;
        this.f34503g = r106;
        this.f34504h = r107;
        this.f34505i = r110;
        this.f34506j = r111;
    }
}
