package com.bytedance.android.btm.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f42027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f42028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f42029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f42030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f42031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f42032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f42033i;

    public e() {
        this(null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f42025a, r101.f42025a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42026b, r101.f42026b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f42027c, r101.f42027c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f42028d, r101.f42028d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f42029e, r101.f42029e) == true) goto L16;
        return false;
    L16:
        if (this.f42030f == r101.f42030f) goto L18;
        return false;
    L18:
        if (this.f42031g == r101.f42031g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f42032h, r101.f42032h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f42033i, r101.f42033i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v25 */
    public final int hashCode() {
        String r100 = this.f42025a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f42026b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f42027c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f42028d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f42029e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f42030f;
        ?? r117 = r116;
        if (r116 == false) goto L25;
        r117 = 1;
    L25:
        int r118 = (((r115 + r117) * 31) + this.f42031g) * 31;
        String r119 = this.f42032h;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f42033i;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L28:
        r120 = 0;
        goto L29
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
        return "BtmPageInfo(btmShowId=" + this.f42025a + ", pageBtm=" + this.f42026b + ", pageId=" + this.f42027c + ", instanceId=" + this.f42028d + ", lastBtmShowId=" + this.f42029e + ", jumpWithToken=" + this.f42030f + ", step=" + this.f42031g + ", nodeId=" + this.f42032h + ", treeId=" + this.f42033i + ")";
    }

    public /* synthetic */ e(String r110, String r111, String r112, String r113, String r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r115 & 64) == 0) goto L25;
        int r105 = 1;
    L26:
        this(r100, r101, r102, r103, r104, false, r105, null, null);
        return;
    L25:
        r105 = 0;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public e(String r100, String r101, String r102, String r103, String r104, boolean r105, int r106, String r107, String r108) {
        this.f42025a = r100;
        this.f42026b = r101;
        this.f42027c = r102;
        this.f42028d = r103;
        this.f42029e = r104;
        this.f42030f = r105;
        this.f42031g = r106;
        this.f42032h = r107;
        this.f42033i = r108;
    }
}
