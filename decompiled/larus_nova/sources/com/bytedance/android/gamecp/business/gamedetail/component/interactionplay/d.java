package com.bytedance.android.gamecp.business.gamedetail.component.interactionplay;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f54367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f54368h;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L22;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f54361a, r101.f54361a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54362b, r101.f54362b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54363c, r101.f54363c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54364d, r101.f54364d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54365e, r101.f54365e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54366f, r101.f54366f) == true) goto L18;
        return false;
    L18:
        if (this.f54367g == r101.f54367g) goto L20;
        return false;
    L20:
        if (Float.compare(this.f54368h, r101.f54368h) == 0) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 54;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f54361a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54362b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f54363c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54364d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54365e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54366f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        boolean r118 = this.f54367g;
        ?? r119 = r118;
        if (r118 == false) goto L29;
        r119 = 1;
    L29:
        return ((r117 + r119) * 31) + Float.floatToIntBits(this.f54368h);
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
        return "InteractionPlayEntranceProps(ID=" + this.f54361a + ", title=" + this.f54362b + ", schema=" + this.f54363c + ", mainIcon=" + this.f54364d + ", subIcon=" + this.f54365e + ", buttonText=" + this.f54366f + ", layerVisible=" + this.f54367g + ", dialogOffset=" + this.f54368h + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54361a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public static d c(d r110, boolean r111, float r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f54361a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f54362b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = r110.f54363c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = r110.f54364d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r105 = r110.f54365e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        r100 = r110.f54366f;
    L25:
        String r106 = r100;
        if ((r113 & 64) == 0) goto L28;
        r111 = r110.f54367g;
    L28:
        boolean r107 = r111;
        if ((r113 & 128) == 0) goto L31;
        r112 = r110.f54368h;
    L31:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "ID");
        return new d(r101, r102, r103, r104, r105, r106, r107, r112);
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public d(String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, float r107) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54361a = r100;
        this.f54362b = r101;
        this.f54363c = r102;
        this.f54364d = r103;
        this.f54365e = r104;
        this.f54366f = r105;
        this.f54367g = r106;
        this.f54368h = r107;
    }
}
