package com.bytedance.android.gamecp.business.gamedetail.component.mapplay;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f54541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f54542h;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f54535a, r101.f54535a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54536b, r101.f54536b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54537c, r101.f54537c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54538d, r101.f54538d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54539e, r101.f54539e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54540f, r101.f54540f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54541g, r101.f54541g) == true) goto L20;
        return false;
    L20:
        if (Float.compare(this.f54542h, r101.f54542h) == 0) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 53;
    }

    public final int hashCode() {
        String r100 = this.f54535a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54536b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f54537c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54538d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54539e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54540f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f54541g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return ((r118 + r101) * 31) + Float.floatToIntBits(this.f54542h);
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
        return "MapPlayEntranceProps(ID=" + this.f54535a + ", title=" + this.f54536b + ", schema=" + this.f54537c + ", mainIcon=" + this.f54538d + ", subIcon=" + this.f54539e + ", subTitle=" + this.f54540f + ", buttonText=" + this.f54541g + ", dialogOffset=" + this.f54542h + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54535a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, float r107) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54535a = r100;
        this.f54536b = r101;
        this.f54537c = r102;
        this.f54538d = r103;
        this.f54539e = r104;
        this.f54540f = r105;
        this.f54541g = r106;
        this.f54542h = r107;
    }
}
