package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.cloudgameplaybutton;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.b1;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.component.cloudplaybutton.b;
import com.bytedance.android.gamecp.business.gamedetail.component.cloudplaybutton.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f54180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f54181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f54182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1 f54183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f54184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b1 f54185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1 f54186h;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f54179a, r101.f54179a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54180b, r101.f54180b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54181c, r101.f54181c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54182d, r101.f54182d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54183e, r101.f54183e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54184f, r101.f54184f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54185g, r101.f54185g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54186h, r101.f54186h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 44;
    }

    public final int hashCode() {
        String r100 = this.f54179a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f54180b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.f54181c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f54182d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        b1 r113 = this.f54183e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        b1 r116 = this.f54184f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        b1 r119 = this.f54185g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        b1 r122 = this.f54186h;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
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
        return "NewCloudPlayProps(ID=" + this.f54179a + ", data=" + this.f54180b + ", style=" + this.f54181c + ", commonData=" + this.f54182d + ", nowPlayStyle=" + this.f54183e + ", samePlayStyle=" + this.f54184f + ", teamPlayStyle=" + this.f54185g + ", interactionPlayStyle=" + this.f54186h + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54179a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, b r101, e r102, h r103, b1 r104, b1 r105, b1 r106, b1 r107) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54179a = r100;
        this.f54180b = r101;
        this.f54181c = r102;
        this.f54182d = r103;
        this.f54183e = r104;
        this.f54184f = r105;
        this.f54185g = r106;
        this.f54186h = r107;
    }
}
