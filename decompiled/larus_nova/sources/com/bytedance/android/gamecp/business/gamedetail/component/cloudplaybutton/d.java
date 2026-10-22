package com.bytedance.android.gamecp.business.gamedetail.component.cloudplaybutton;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f53879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f53880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f53881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f53882e;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f53878a, r101.f53878a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53879b, r101.f53879b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53880c, r101.f53880c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53881d, r101.f53881d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53882e, r101.f53882e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 20;
    }

    public final int hashCode() {
        String r100 = this.f53878a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f53879b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.f53880c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f53881d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.f53882e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "CloudPlayButtonProps(ID=" + this.f53878a + ", data=" + this.f53879b + ", style=" + this.f53880c + ", commonData=" + this.f53881d + ", dialogSlideOffset=" + this.f53882e + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53878a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public d(String r100, b r101, e r102, h r103, Float r104) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53878a = r100;
        this.f53879b = r101;
        this.f53880c = r102;
        this.f53881d = r103;
        this.f53882e = r104;
    }
}
