package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.reserverbtn;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.page.root.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f55248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f55249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f55250d;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f55247a, r101.f55247a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55248b, r101.f55248b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55249c, r101.f55249c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55250d, r101.f55250d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 26;
    }

    public final int hashCode() {
        String r100 = this.f55247a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f55248b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.f55249c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        r0 r110 = this.f55250d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "TitleReserveButtonProps(ID=" + this.f55247a + ", data=" + this.f55248b + ", commonData=" + this.f55249c + ", reserveButtonParams=" + this.f55250d + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55247a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public b(String r100, a r101, h r102, r0 r103) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f55247a = r100;
        this.f55248b = r101;
        this.f55249c = r102;
        this.f55250d = r103;
    }
}
