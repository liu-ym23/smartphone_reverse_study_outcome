package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f55072f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f55074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f55076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f55077e;

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
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f55073a, r101.f55073a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55074b, r101.f55074b) == true) goto L10;
        return false;
    L10:
        if (this.f55075c == r101.f55075c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55076d, r101.f55076d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55077e, r101.f55077e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 3;
    }

    public final int hashCode() {
        String r100 = this.f55073a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<e> r104 = this.f55074b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f55075c) * 31;
        Boolean r107 = this.f55076d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f55077e;
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
        return "GameTabProps(ID=" + this.f55073a + ", tabInfo=" + this.f55074b + ", tabStyle=" + this.f55075c + ", hideNav=" + this.f55076d + ", currentTab=" + this.f55077e + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f55073a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public f(String r100, List<e> r101, int r102, Boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r101, "tabInfo");
        Intrinsics.checkNotNullParameter(r104, "currentTab");
        this.f55073a = r100;
        this.f55074b = r101;
        this.f55075c = r102;
        this.f55076d = r103;
        this.f55077e = r104;
    }
}
