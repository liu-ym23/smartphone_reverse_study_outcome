package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.android.gamecp.business.gamedetail.base.ComponentCriteria;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dt.b f55564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComponentCriteria f55566c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f55564a, r101.f55564a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55565b, r101.f55565b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55566c, r101.f55566c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        dt.b r100 = this.f55564a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55565b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentCriteria r107 = this.f55566c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailNetRequestBean(launchParam=" + this.f55564a + ", pageID=" + this.f55565b + ", componentCriteria=" + this.f55566c + ")";
    }

    public n(dt.b r100, String r101, ComponentCriteria r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        this.f55564a = r100;
        this.f55565b = r101;
        this.f55566c = r102;
    }
}
