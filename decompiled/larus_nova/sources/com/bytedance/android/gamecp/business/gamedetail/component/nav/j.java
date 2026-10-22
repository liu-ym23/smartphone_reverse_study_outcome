package com.bytedance.android.gamecp.business.gamedetail.component.nav;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements d0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f54664i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<i> f54667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f54669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Float f54671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f54672h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L22;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f54665a, r101.f54665a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54666b, r101.f54666b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54667c, r101.f54667c) == true) goto L12;
        return false;
    L12:
        if (this.f54668d == r101.f54668d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54669e, r101.f54669e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54670f, r101.f54670f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54671g, r101.f54671g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54672h, r101.f54672h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 51;
    }

    public final int hashCode() {
        String r100 = this.f54665a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54666b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<i> r107 = this.f54667c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f54668d) * 31;
        Boolean r110 = this.f54669e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54670f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.f54671g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f54672h;
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
        return "NavTabProps(componentId=" + this.f54665a + ", componentClass=" + this.f54666b + ", tabList=" + this.f54667c + ", tabStyle=" + this.f54668d + ", hideNav=" + this.f54669e + ", currentTab=" + this.f54670f + ", dialogSlideOffset=" + this.f54671g + ", dialogState=" + this.f54672h + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54666b;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public j(String r100, String r101, List<i> r102, int r103, Boolean r104, String r105, Float r106, Integer r107) {
        Intrinsics.checkNotNullParameter(r100, "componentId");
        Intrinsics.checkNotNullParameter(r101, "componentClass");
        Intrinsics.checkNotNullParameter(r102, "tabList");
        Intrinsics.checkNotNullParameter(r105, "currentTab");
        this.f54665a = r100;
        this.f54666b = r101;
        this.f54667c = r102;
        this.f54668d = r103;
        this.f54669e = r104;
        this.f54670f = r105;
        this.f54671g = r106;
        this.f54672h = r107;
    }
}
