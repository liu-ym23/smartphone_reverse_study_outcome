package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.page.root.p0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g extends com.bytedance.ies.sve_list.b<d0> implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f55010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f55012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f55013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f55014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.page.root.j f55015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d0> f55016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p0 f55017i;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L22;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f55010b, r101.f55010b) == true) goto L8;
        return false;
    L8:
        if (this.f55011c == r101.f55011c) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55012d, r101.f55012d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55013e, r101.f55013e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55014f, r101.f55014f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f55015g, r101.f55015g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f55016h, r101.f55016h) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f55017i, r101.f55017i) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return "scaffold";
    }

    public final int hashCode() {
        f r100 = this.f55010b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f55011c) * 31;
        a r104 = this.f55012d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f55013e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.f55014f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        com.bytedance.android.gamecp.business.gamedetail.page.root.j r113 = this.f55015g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<d0> r116 = this.f55016h;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        p0 r119 = this.f55017i;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "ScaffoldProps(data=" + this.f55010b + ", itemType=" + this.f55011c + ", titleBar=" + this.f55012d + ", bottomConvertBar=" + this.f55013e + ", bottomFloatingArea=" + this.f55014f + ", dragBar=" + this.f55015g + ", itemList=" + this.f55016h + ", outerRVScrollData=" + this.f55017i + ")";
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return this.f55011c;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(f r100, int r101, a r102, b r103, c r104, com.bytedance.android.gamecp.business.gamedetail.page.root.j r105, List<? extends d0> r106, p0 r107) {
        Intrinsics.checkNotNullParameter(r105, "dragBar");
        Intrinsics.checkNotNullParameter(r106, "itemList");
        Intrinsics.checkNotNullParameter(r107, "outerRVScrollData");
        super(r106);
        this.f55010b = r100;
        this.f55011c = r101;
        this.f55012d = r102;
        this.f55013e = r103;
        this.f55014f = r104;
        this.f55015g = r105;
        this.f55016h = r106;
        this.f55017i = r107;
    }
}
