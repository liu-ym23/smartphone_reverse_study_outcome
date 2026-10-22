package com.bytedance.android.gamecp.business.gamedetail.page.detail;

import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.j0;
import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f55379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f55380d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f55377a, r101.f55377a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55378b, r101.f55378b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55379c, r101.f55379c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55380d, r101.f55380d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final String toString() {
        return "DetailTabProps(tabId=" + this.f55377a + ", tabName=" + this.f55378b + ", uiStyle=" + this.f55379c + ", contentProp=" + this.f55380d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.f55377a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55378b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        j0 r107 = this.f55379c;
        if (r107 == null) goto L15;
        boolean r108 = r107.f51606a;
        ?? r109 = r108;
        if (r108 == false) goto L16;
        r109 = 1;
    L16:
        int r110 = (r106 + r109) * 31;
        d0 r111 = this.f55380d;
        if (r111 == null) goto L20;
        r101 = r111.hashCode();
    L20:
        return r110 + r101;
    L15:
        r109 = 0;
        goto L16
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public a(String r100, String r101, j0 r102, d0 r103) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Intrinsics.checkNotNullParameter(r101, "tabName");
        Intrinsics.checkNotNullParameter(r102, "uiStyle");
        this.f55377a = r100;
        this.f55378b = r101;
        this.f55379c = r102;
        this.f55380d = r103;
    }
}
