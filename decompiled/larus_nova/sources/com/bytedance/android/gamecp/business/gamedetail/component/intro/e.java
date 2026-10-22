package com.bytedance.android.gamecp.business.gamedetail.component.intro;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f54387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f54388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f54389d;

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f54386a, r101.f54386a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54387b, r101.f54387b) == true) goto L10;
        return false;
    L10:
        if (this.f54388c == r101.f54388c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54389d, r101.f54389d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.f54386a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f54387b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f54388c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f54389d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameIntroItemProps(ID=" + this.f54386a + ", gameInfo=" + this.f54387b + ", introExpand=" + this.f54388c + ", commonData=" + this.f54389d + ")";
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f54386a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public e(String r100, d r101, boolean r102, h r103) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        this.f54386a = r100;
        this.f54387b = r101;
        this.f54388c = r102;
        this.f54389d = r103;
    }
}
