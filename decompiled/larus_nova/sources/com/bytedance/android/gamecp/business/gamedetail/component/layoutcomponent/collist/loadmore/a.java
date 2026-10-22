package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist.loadmore;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f54443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f54444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f54445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54447e;

    public a() {
        this(null, null, 0, null, 31);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f54443a, r101.f54443a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54444b, r101.f54444b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54445c, r101.f54445c) == true) goto L12;
        return false;
    L12:
        if (this.f54446d == r101.f54446d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54447e, r101.f54447e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return "col_list_bottom_loading";
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 30;
    }

    public final int hashCode() {
        Boolean r100 = this.f54443a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f54444b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f54445c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f54446d) * 31;
        String r110 = this.f54447e;
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
        return "BottomLoadingProps(isLoading=" + this.f54443a + ", isLoadError=" + this.f54444b + ", pageInfo=" + this.f54445c + ", dataSize=" + this.f54446d + ", _id=" + this.f54447e + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public /* synthetic */ a(Boolean r100, k r101, int r102, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = Boolean.TRUE;
    L5:
        Boolean r103 = r100;
        if ((r111 & 2) == 0) goto L8;
        Boolean r104 = Boolean.FALSE;
    L10:
        if ((r111 & 4) == 0) goto L12;
        k r105 = null;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r106 = 0;
    L18:
        if ((r111 & 16) == 0) goto L20;
        String r107 = null;
    L21:
        this(r103, r104, r105, r106, r107);
        return;
    L20:
        r107 = r110;
        goto L21
    L16:
        r106 = r102;
        goto L18
    L12:
        r105 = r101;
        goto L14
    L8:
        r104 = null;
        goto L10
    }

    public a(Boolean r100, Boolean r101, k r102, int r103, String r104) {
        this.f54443a = r100;
        this.f54444b = r101;
        this.f54445c = r102;
        this.f54446d = r103;
        this.f54447e = r104;
    }
}
