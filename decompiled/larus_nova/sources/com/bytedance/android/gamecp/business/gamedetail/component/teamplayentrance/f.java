package com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f55112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f55113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f55114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f55115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f55116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f55117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f55118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f55119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f55120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f55121m;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L32;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f55109a, r101.f55109a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55110b, r101.f55110b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55111c, r101.f55111c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55112d, r101.f55112d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55113e, r101.f55113e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f55114f, r101.f55114f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f55115g, r101.f55115g) == true) goto L20;
        return false;
    L20:
        if (this.f55116h == r101.f55116h) goto L22;
        return false;
    L22:
        if (Float.compare(this.f55117i, r101.f55117i) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f55118j, r101.f55118j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f55119k, r101.f55119k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f55120l, r101.f55120l) == true) goto L30;
        return false;
    L30:
        if (this.f55121m == r101.f55121m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 52;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f55109a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55110b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f55111c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f55112d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f55113e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f55114f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f55115g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.f55116h;
        ?? r123 = 1;
        ?? r124 = r122;
        if (r122 == false) goto L33;
        r124 = 1;
    L33:
        int r125 = (((r121 + r124) * 31) + Float.floatToIntBits(this.f55117i)) * 31;
        String r126 = this.f55118j;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f55119k;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f55120l;
        if (r132 == null) goto L44;
        r101 = r132.hashCode();
    L44:
        int r133 = (r131 + r101) * 31;
        boolean r134 = this.f55121m;
        if (r134 == true) goto L49;
        r123 = r134;
    L49:
        return r133 + r123;
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
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
        return "TeamPlayEntranceLayerProps(ID=" + this.f55109a + ", title=" + this.f55110b + ", schema=" + this.f55111c + ", mainIcon=" + this.f55112d + ", subIcon=" + this.f55113e + ", subTitle=" + this.f55114f + ", buttonText=" + this.f55115g + ", layerVisible=" + this.f55116h + ", dialogOffset=" + this.f55117i + ", ifNeedApply=" + this.f55118j + ", teamCondition=" + this.f55119k + ", btnStatus=" + this.f55120l + ", needRepeatExposure=" + this.f55121m + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55109a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public f(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, float r110, String r111, String r112, String r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f55109a = r100;
        this.f55110b = r101;
        this.f55111c = r102;
        this.f55112d = r103;
        this.f55113e = r104;
        this.f55114f = r105;
        this.f55115g = r106;
        this.f55116h = r107;
        this.f55117i = r110;
        this.f55118j = r111;
        this.f55119k = r112;
        this.f55120l = r113;
        this.f55121m = r114;
    }

    public static f c(f r110, String r111, String r112, String r113, String r114, String r115, String r210, boolean r211, float r212, String r213, String r214, String r215, boolean r216, int r217) {
        if ((r217 & 1) == 0) goto L5;
        String r100 = r110.f55109a;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r101 = r110.f55110b;
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r102 = r110.f55111c;
    L15:
        if ((r217 & 8) == 0) goto L17;
        String r103 = r110.f55112d;
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r104 = r110.f55113e;
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r105 = r110.f55114f;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r106 = r110.f55115g;
    L31:
        if ((r217 & 128) == 0) goto L33;
        boolean r107 = r110.f55116h;
    L35:
        if ((r217 & 256) == 0) goto L37;
        float r116 = r110.f55117i;
    L39:
        if ((r217 & 512) == 0) goto L41;
        String r117 = r110.f55118j;
    L43:
        if ((r217 & 1024) == 0) goto L45;
        String r118 = r110.f55119k;
    L47:
        if ((r217 & 2048) == 0) goto L49;
        String r119 = r110.f55120l;
    L51:
        if ((r217 & 4096) == 0) goto L53;
        boolean r108 = r110.f55121m;
    L54:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "ID");
        return new f(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r216;
        goto L54
    L49:
        r119 = r215;
        goto L51
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r115;
        goto L27
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
        r100 = null;
        goto L7
    }
}
