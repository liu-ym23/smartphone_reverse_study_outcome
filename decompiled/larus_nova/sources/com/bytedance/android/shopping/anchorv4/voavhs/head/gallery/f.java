package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f168653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f168654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f168655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f168656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f168657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f168658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f168659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f168660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Float f168661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f168662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f168663k;

    public f() {
        this(null, null, null, null, null, null, false, null, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L28;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f168653a, r101.f168653a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168654b, r101.f168654b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168655c, r101.f168655c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f168656d, r101.f168656d) == true) goto L14;
        return false;
    L14:
        if (this.f168657e == r101.f168657e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f168658f, r101.f168658f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f168659g, r101.f168659g) == true) goto L20;
        return false;
    L20:
        if (this.f168660h == r101.f168660h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f168661i, r101.f168661i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f168662j, r101.f168662j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f168663k, r101.f168663k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v33 */
    public final int hashCode() {
        View r100 = this.f168653a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f168654b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f168655c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.f168656d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.f168657e) * 31;
        String r113 = this.f168658f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f168659g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f168660h;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.f168661i;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f168662j;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f168663k;
        if (r128 == null) goto L41;
        r101 = r128.hashCode();
    L41:
        return r127 + r101;
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
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
        return "BrowseNode(customView=" + this.f168653a + ", remoteImage=" + this.f168654b + ", skuImageTitle=" + this.f168655c + ", videoInfo=" + this.f168656d + ", itemViewType=" + this.f168657e + ", findSameGoodsSchema=" + this.f168658f + ", contentDescription=" + this.f168659g + ", injectKolFeedFragment=" + this.f168660h + ", commentVideoProgress=" + this.f168661i + ", videoItemId=" + this.f168662j + ", tabTypeName=" + this.f168663k + ")";
    }

    public static f a(f r110, int r111, String r112) {
        View r100 = r110.f168653a;
        ECUrlModel r101 = r110.f168654b;
        String r102 = r110.f168655c;
        b r103 = r110.f168656d;
        String r104 = r110.f168658f;
        String r105 = r110.f168659g;
        boolean r106 = r110.f168660h;
        Float r107 = r110.f168661i;
        String r113 = r110.f168662j;
        r110.getClass();
        return new f(r100, r101, r102, r103, r111, r104, r105, r106, r107, r113, r112);
    }

    public /* synthetic */ f(View r110, ECUrlModel r111, String r112, t r113, String r210, String r211, boolean r212, Float r213, String r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        View r100 = null;
    L7:
        if ((r215 & 2) == 0) goto L9;
        ECUrlModel r101 = null;
    L11:
        if ((r215 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r215 & 8) == 0) goto L17;
        t r103 = null;
    L19:
        if ((r215 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r215 & 64) == 0) goto L25;
        String r114 = null;
    L27:
        if ((r215 & 128) == 0) goto L29;
        boolean r115 = false;
    L31:
        if ((r215 & 256) == 0) goto L33;
        Float r116 = null;
    L35:
        if ((r215 & 512) == 0) goto L37;
        String r117 = null;
    L38:
        this(r100, r101, r102, r103, 0, r104, r114, r115, r116, r117, null);
        return;
    L37:
        r117 = r214;
        goto L38
    L33:
        r116 = r213;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r114 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public f(View r100, ECUrlModel r101, String r102, b r103, int r104, String r105, String r106, boolean r107, Float r108, String r110, String r111) {
        this.f168653a = r100;
        this.f168654b = r101;
        this.f168655c = r102;
        this.f168656d = r103;
        this.f168657e = r104;
        this.f168658f = r105;
        this.f168659g = r106;
        this.f168660h = r107;
        this.f168661i = r108;
        this.f168662j = r110;
        this.f168663k = r111;
    }
}
