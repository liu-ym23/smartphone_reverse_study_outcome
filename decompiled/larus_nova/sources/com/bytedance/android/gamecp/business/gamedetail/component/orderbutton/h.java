package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f54862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f54863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f54865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f54866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f54867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f54868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Float f54869j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L24;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f54861b, r101.f54861b) == true) goto L8;
        return false;
    L8:
        if (this.f54862c == r101.f54862c) goto L10;
        return false;
    L10:
        if (this.f54863d == r101.f54863d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54864e, r101.f54864e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54865f, r101.f54865f) == true) goto L16;
        return false;
    L16:
        if (this.f54866g == r101.f54866g) goto L18;
        return false;
    L18:
        if (this.f54867h == r101.f54867h) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54868i, r101.f54868i) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f54869j, r101.f54869j) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a, com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f54861b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f54862c;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f54863d;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        int r109 = (r107 + r105) * 31;
        String r110 = this.f54864e;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f54865f;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (((((r112 + r114) * 31) + this.f54866g) * 31) + this.f54867h) * 31;
        String r116 = this.f54868i;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.f54869j;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameOrderButtonItemProps(ID=" + this.f54861b + ", hasDone=" + this.f54862c + ", showLoading=" + this.f54863d + ", floatType=" + this.f54864e + ", supportPlatform=" + this.f54865f + ", totalBtnNumber=" + this.f54866g + ", reserveTheme=" + this.f54867h + ", subTitle=" + this.f54868i + ", dialogSlideOffset=" + this.f54869j + ")";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.twoactionbutton.a, com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54861b;
    }

    public static h c(h r110, boolean r111, boolean r112, Float r113, int r114) {
        String r100 = null;
        if ((r114 & 1) == 0) goto L5;
        String r101 = r110.f54861b;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r102 = r110.f54862c;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r103 = r110.f54863d;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r104 = r110.f54864e;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Long r105 = r110.f54865f;
    L23:
        if ((r114 & 32) == 0) goto L25;
        int r115 = r110.f54866g;
    L27:
        if ((r114 & 64) == 0) goto L29;
        int r116 = r110.f54867h;
    L31:
        if ((r114 & 128) == 0) goto L33;
        r100 = r110.f54868i;
    L33:
        String r117 = r100;
        if ((r114 & 256) == 0) goto L36;
        Float r118 = r110.f54869j;
    L37:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "ID");
        return new h(r101, r102, r103, r104, r105, r115, r116, r117, r118);
    L36:
        r118 = r113;
        goto L37
    L29:
        r116 = 0;
        goto L31
    L25:
        r115 = 0;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public h(String r100, boolean r101, boolean r102, String r103, Long r104, int r105, int r106, String r107, Float r110) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        super(r105);
        this.f54861b = r100;
        this.f54862c = r101;
        this.f54863d = r102;
        this.f54864e = r103;
        this.f54865f = r104;
        this.f54866g = r105;
        this.f54867h = r106;
        this.f54868i = r107;
        this.f54869j = r110;
    }
}
