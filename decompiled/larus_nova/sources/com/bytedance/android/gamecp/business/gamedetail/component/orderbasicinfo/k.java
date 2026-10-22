package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f54794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GameImageBundler f54797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f54798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f54799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a.C0891a> f54800i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f f54801j;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L26;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f54792a, r101.f54792a) == true) goto L8;
        return false;
    L8:
        if (this.f54793b == r101.f54793b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54794c, r101.f54794c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54795d, r101.f54795d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54796e, r101.f54796e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54797f, r101.f54797f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54798g, r101.f54798g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54799h, r101.f54799h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f54800i, r101.f54800i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f54801j, r101.f54801j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 36;
    }

    public final int hashCode() {
        String r100 = this.f54792a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f54793b) * 31;
        Float r104 = this.f54794c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f54795d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54796e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        GameImageBundler r113 = this.f54797f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f54798g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f54799h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        List<a.C0891a> r122 = this.f54800i;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r125 = this.f54801j;
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
        return "OrderGameDetailInfoV3Props(ID=" + this.f54792a + ", style=" + this.f54793b + ", dialogSlideOffset=" + this.f54794c + ", name=" + this.f54795d + ", icon=" + this.f54796e + ", iconBundler=" + this.f54797f + ", tags=" + this.f54798g + ", shortAdditionalDesc=" + this.f54799h + ", noticeList=" + this.f54800i + ", officialAccountInfo=" + this.f54801j + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54792a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public k(String r100, int r101, Float r102, String r103, String r104, GameImageBundler r105, List<String> r106, String r107, List<a.C0891a> r110, com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r111) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54792a = r100;
        this.f54793b = r101;
        this.f54794c = r102;
        this.f54795d = r103;
        this.f54796e = r104;
        this.f54797f = r105;
        this.f54798g = r106;
        this.f54799h = r107;
        this.f54800i = r110;
        this.f54801j = r111;
    }
}
