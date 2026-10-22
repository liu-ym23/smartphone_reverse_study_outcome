package com.bytedance.android.gamecp.business.gamedetail.component.nav;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements d0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f54646h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> f54648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f54649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f54651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d0 f54652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Float f54653g;

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
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f54647a, r101.f54647a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54648b, r101.f54648b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54649c, r101.f54649c) == true) goto L12;
        return false;
    L12:
        if (this.f54650d == r101.f54650d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54651e, r101.f54651e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54652f, r101.f54652f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54653g, r101.f54653g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 32;
    }

    public final int hashCode() {
        String r100 = this.f54647a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> r104 = this.f54648b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f54649c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f54650d) * 31;
        String r110 = this.f54651e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        d0 r113 = this.f54652f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.f54653g;
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
        return "NavBarProps(ID=" + this.f54647a + ", navInfo=" + this.f54648b + ", hideNav=" + this.f54649c + ", tabStyle=" + this.f54650d + ", currentNav=" + this.f54651e + ", contentProp=" + this.f54652f + ", dialogSlideOffset=" + this.f54653g + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54647a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public c(String r100, List<com.bytedance.android.gamecp.business.gamedetail.component.nav.a> r101, Boolean r102, int r103, String r104, d0 r105, Float r106) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r101, "navInfo");
        Intrinsics.checkNotNullParameter(r104, "currentNav");
        this.f54647a = r100;
        this.f54648b = r101;
        this.f54649c = r102;
        this.f54650d = r103;
        this.f54651e = r104;
        this.f54652f = r105;
        this.f54653g = r106;
    }
}
