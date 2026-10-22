package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.buybutton;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.b1;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.s0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f54162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s0 f54163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f54166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f54167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f54168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f54169i;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f54161a, r101.f54161a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54162b, r101.f54162b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54163c, r101.f54163c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54164d, r101.f54164d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54165e, r101.f54165e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54166f, r101.f54166f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54167g, r101.f54167g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54168h, r101.f54168h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f54169i, r101.f54169i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 47;
    }

    public final int hashCode() {
        String r100 = this.f54161a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        h r104 = this.f54162b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        s0 r107 = this.f54163c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54164d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54165e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f54166f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f54167g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f54168h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f54169i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "NewBuyProps(ID=" + this.f54161a + ", commonParams=" + this.f54162b + ", style=" + this.f54163c + ", propId=" + this.f54164d + ", propBuySchema=" + this.f54165e + ", goodsType=" + this.f54166f + ", propType=" + this.f54167g + ", purchasePlatform=" + this.f54168h + ", autoAction=" + this.f54169i + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54161a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, h r101, b1 r102, String r103, String r104, Integer r105, Integer r106, Integer r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54161a = r100;
        this.f54162b = r101;
        this.f54163c = r102;
        this.f54164d = r103;
        this.f54165e = r104;
        this.f54166f = r105;
        this.f54167g = r106;
        this.f54168h = r107;
        this.f54169i = r110;
    }
}
