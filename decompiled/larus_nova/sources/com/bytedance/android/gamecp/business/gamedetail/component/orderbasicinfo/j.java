package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f54786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f54789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f54790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a.C0891a f54791h;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L22;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f54784a, r101.f54784a) == true) goto L8;
        return false;
    L8:
        if (this.f54785b == r101.f54785b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54786c, r101.f54786c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54787d, r101.f54787d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54788e, r101.f54788e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54789f, r101.f54789f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54790g, r101.f54790g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54791h, r101.f54791h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 4;
    }

    public final int hashCode() {
        String r100 = this.f54784a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f54785b) * 31;
        Float r104 = this.f54786c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f54787d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54788e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.f54789f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54790g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        a.C0891a r119 = this.f54791h;
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
        return "OrderGameDetailInfoProps(ID=" + this.f54784a + ", style=" + this.f54785b + ", dialogSlideOffset=" + this.f54786c + ", name=" + this.f54787d + ", icon=" + this.f54788e + ", tags=" + this.f54789f + ", shortAdditionalDesc=" + this.f54790g + ", notice=" + this.f54791h + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54784a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public static j c(j r110, int r111, Float r112, int r113) {
        a.C0891a r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f54784a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r111 = r110.f54785b;
    L9:
        int r102 = r111;
        if ((r113 & 4) == 0) goto L12;
        r112 = r110.f54786c;
    L12:
        Float r103 = r112;
        if ((r113 & 8) == 0) goto L15;
        String r104 = r110.f54787d;
    L17:
        if ((r113 & 16) == 0) goto L19;
        String r105 = r110.f54788e;
    L21:
        if ((r113 & 32) == 0) goto L23;
        List<String> r106 = r110.f54789f;
    L25:
        if ((r113 & 64) == 0) goto L27;
        String r107 = r110.f54790g;
    L29:
        if ((r113 & 128) == 0) goto L31;
        r100 = r110.f54791h;
    L31:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "ID");
        return new j(r101, r102, r103, r104, r105, r106, r107, r100);
    L27:
        r107 = null;
        goto L29
    L23:
        r106 = null;
        goto L25
    L19:
        r105 = null;
        goto L21
    L15:
        r104 = null;
        goto L17
    L5:
        r101 = null;
        goto L7
    }

    public j(String r100, int r101, Float r102, String r103, String r104, List<String> r105, String r106, a.C0891a r107) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54784a = r100;
        this.f54785b = r101;
        this.f54786c = r102;
        this.f54787d = r103;
        this.f54788e = r104;
        this.f54789f = r105;
        this.f54790g = r106;
        this.f54791h = r107;
    }
}
