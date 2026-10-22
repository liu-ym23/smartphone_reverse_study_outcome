package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f54707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f54709g;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f54703a, r101.f54703a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54704b, r101.f54704b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54705c, r101.f54705c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54706d, r101.f54706d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54707e, r101.f54707e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54708f, r101.f54708f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54709g, r101.f54709g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 11;
    }

    public final int hashCode() {
        String r100 = this.f54703a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54704b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f54705c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54706d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f54707e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54708f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f54709g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "AudienceGameOfficialAccountProps(ID=" + this.f54703a + ", userId=" + this.f54704b + ", name=" + this.f54705c + ", icon=" + this.f54706d + ", hasCert=" + this.f54707e + ", fansNumber=" + this.f54708f + ", isFollow=" + this.f54709g + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54703a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public a(String r100, String r101, String r102, String r103, Boolean r104, String r105, Boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54703a = r100;
        this.f54704b = r101;
        this.f54705c = r102;
        this.f54706d = r103;
        this.f54707e = r104;
        this.f54708f = r105;
        this.f54709g = r106;
    }
}
