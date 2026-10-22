package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.info;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.d;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.page.root.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dt.b f55218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f55219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p0 f55220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f55221f;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f55216a, r101.f55216a) == true) goto L8;
        return false;
    L8:
        if (this.f55217b == r101.f55217b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55218c, r101.f55218c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55219d, r101.f55219d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55220e, r101.f55220e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f55221f, r101.f55221f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 24;
    }

    public final int hashCode() {
        String r100 = this.f55216a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f55217b) * 31;
        dt.b r104 = this.f55218c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.f55219d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        p0 r110 = this.f55220e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        d r113 = this.f55221f;
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
        return "TitleBarInfoProps(ID=" + this.f55216a + ", style=" + this.f55217b + ", commonParams=" + this.f55218c + ", gameCommonData=" + this.f55219d + ", outerRVScrollData=" + this.f55220e + ", gameStatus=" + this.f55221f + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55216a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public static b c(b r100, int r110, p0 r111, int r112) {
        d r101 = null;
        if ((r112 & 1) == 0) goto L5;
        String r102 = r100.f55216a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r110 = r100.f55217b;
    L9:
        int r103 = r110;
        if ((r112 & 4) == 0) goto L12;
        dt.b r104 = r100.f55218c;
    L14:
        if ((r112 & 8) == 0) goto L16;
        h r105 = r100.f55219d;
    L18:
        if ((r112 & 16) == 0) goto L20;
        r111 = r100.f55220e;
    L20:
        p0 r106 = r111;
        if ((r112 & 32) == 0) goto L23;
        r101 = r100.f55221f;
    L23:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "ID");
        Intrinsics.checkNotNullParameter(r106, "outerRVScrollData");
        return new b(r102, r103, r104, r105, r106, r101);
    L16:
        r105 = null;
        goto L18
    L12:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public b(String r100, int r101, dt.b r102, h r103, p0 r104, d r105) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r104, "outerRVScrollData");
        this.f55216a = r100;
        this.f55217b = r101;
        this.f55218c = r102;
        this.f55219d = r103;
        this.f55220e = r104;
        this.f55221f = r105;
    }
}
