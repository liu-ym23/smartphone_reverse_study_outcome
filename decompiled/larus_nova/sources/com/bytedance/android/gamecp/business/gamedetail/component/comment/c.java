package com.bytedance.android.gamecp.business.gamedetail.component.comment;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f53891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.comment.data.b> f53893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f53894e;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f53890a, r101.f53890a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53891b, r101.f53891b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53892c, r101.f53892c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f53893d, r101.f53893d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53894e, r101.f53894e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 2;
    }

    public final int hashCode() {
        String r100 = this.f53890a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f53891b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f53892c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<com.bytedance.android.gamecp.business.comment.data.b> r110 = this.f53893d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        b r113 = this.f53894e;
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
        return "GameDetailCommentProps(ID=" + this.f53890a + ", totalComment=" + this.f53891b + ", packageName=" + this.f53892c + ", comment=" + this.f53893d + ", commentEntryData=" + this.f53894e + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f53890a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, Long r101, String r102, List<? extends com.bytedance.android.gamecp.business.comment.data.b> r103, b r104) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f53890a = r100;
        this.f53891b = r101;
        this.f53892c = r102;
        this.f53893d = r103;
        this.f53894e = r104;
    }
}
