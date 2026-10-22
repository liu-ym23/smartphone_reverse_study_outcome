package com.bytedance.android.gamecp.business.gamedetail.component.minigamebar;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f54559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f54560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f54561d;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f54558a, r101.f54558a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54559b, r101.f54559b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54560c, r101.f54560c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54561d, r101.f54561d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 16;
    }

    public final int hashCode() {
        String r100 = this.f54558a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c r104 = this.f54559b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f54560c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f54561d;
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
        return "MiniGameBarProps(ID=" + this.f54558a + ", gameData=" + this.f54559b + ", launchBtnStyle=" + this.f54560c + ", dialogSlideOffset=" + this.f54561d + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54558a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public d(String r100, c r101, b r102, Float r103) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54558a = r100;
        this.f54559b = r101;
        this.f54560c = r102;
        this.f54561d = r103;
    }
}
