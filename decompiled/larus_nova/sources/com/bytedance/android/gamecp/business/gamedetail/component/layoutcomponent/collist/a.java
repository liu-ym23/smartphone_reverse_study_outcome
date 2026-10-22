package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f54420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f54421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ies.sve_list.b<d0> f54422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f54423f;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f54418a, r101.f54418a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54419b, r101.f54419b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54420c, r101.f54420c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54421d, r101.f54421d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54422e, r101.f54422e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54423f, r101.f54423f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 101;
    }

    public final int hashCode() {
        String r100 = this.f54418a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54419b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f54420c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f54421d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        com.bytedance.ies.sve_list.b<d0> r113 = this.f54422e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        c r116 = this.f54423f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "ColListProp(ID=" + this.f54418a + ", _id=" + this.f54419b + ", selfProps=" + this.f54420c + ", listSize=" + this.f54421d + ", list=" + this.f54422e + ", style=" + this.f54423f + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54418a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, String r101, b r102, Integer r103, com.bytedance.ies.sve_list.b<d0> r104, c r105) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.ID);
        Intrinsics.checkNotNullParameter(r102, "selfProps");
        this.f54418a = r100;
        this.f54419b = r101;
        this.f54420c = r102;
        this.f54421d = r103;
        this.f54422e = r104;
        this.f54423f = r105;
    }
}
