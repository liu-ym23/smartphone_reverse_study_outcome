package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements com.bytedance.android.gamecp.base.gamedetail.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f53635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f53637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GameImageBundler f53638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f53639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f53640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f53641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e1.a f53642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f53643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f53644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a f53645m;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.basicinfo.a$a, reason: collision with other inner class name */
    public static final class C0881a {
    }

    static {
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L32;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f53633a, r101.f53633a) == true) goto L8;
        return false;
    L8:
        if (this.f53634b == r101.f53634b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53635c, r101.f53635c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53636d, r101.f53636d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53637e, r101.f53637e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53638f, r101.f53638f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f53639g, r101.f53639g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f53640h, r101.f53640h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f53641i, r101.f53641i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f53642j, r101.f53642j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f53643k, r101.f53643k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f53644l, r101.f53644l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f53645m, r101.f53645m) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 5;
    }

    public final int hashCode() {
        String r100 = this.f53633a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f53634b) * 31;
        Float r104 = this.f53635c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53636d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f53637e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        GameImageBundler r113 = this.f53638f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f53639g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f53640h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f53641i;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        e1.a r125 = this.f53642j;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f53643k;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f53644l;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a r134 = this.f53645m;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
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
        return "AudienceGameDetailInfoProps(ID=" + this.f53633a + ", style=" + this.f53634b + ", dialogSlideOffset=" + this.f53635c + ", name=" + this.f53636d + ", icon=" + this.f53637e + ", iconBundler=" + this.f53638f + ", tags=" + this.f53639g + ", showCommentSummary=" + this.f53640h + ", showSafeTag=" + this.f53641i + ", commentInfo=" + this.f53642j + ", hasMiniGame=" + this.f53643k + ", shortAdditionalDesc=" + this.f53644l + ", notice=" + this.f53645m + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53633a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public static a c(a r110, int r111, Float r210, int r211) {
        com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a r100 = null;
        if ((r211 & 1) == 0) goto L5;
        String r101 = r110.f53633a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r102 = r110.f53634b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Float r103 = r110.f53635c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r104 = r110.f53636d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        String r105 = r110.f53637e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        GameImageBundler r112 = r110.f53638f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        List<String> r113 = r110.f53639g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        Boolean r114 = r110.f53640h;
    L35:
        if ((r211 & 256) == 0) goto L37;
        Boolean r115 = r110.f53641i;
    L39:
        if ((r211 & 512) == 0) goto L41;
        e1.a r116 = r110.f53642j;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        Boolean r117 = r110.f53643k;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        String r118 = r110.f53644l;
    L51:
        if ((r211 & 4096) == 0) goto L53;
        r100 = r110.f53645m;
    L53:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "ID");
        return new a(r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r118, r100);
    L49:
        r118 = null;
        goto L51
    L45:
        r117 = null;
        goto L47
    L41:
        r116 = null;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public a(String r100, int r101, Float r102, String r103, String r104, GameImageBundler r105, List<String> r106, Boolean r107, Boolean r110, e1.a r111, Boolean r112, String r113, com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a r114) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53633a = r100;
        this.f53634b = r101;
        this.f53635c = r102;
        this.f53636d = r103;
        this.f53637e = r104;
        this.f53638f = r105;
        this.f53639g = r106;
        this.f53640h = r107;
        this.f53641i = r110;
        this.f53642j = r111;
        this.f53643k = r112;
        this.f53644l = r113;
        this.f53645m = r114;
    }
}
