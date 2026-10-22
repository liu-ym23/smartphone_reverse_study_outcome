package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53986b;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f53985a, r101.f53985a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53986b, r101.f53986b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Context r100 = this.f53985a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53986b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BetaDownloadClickForPcOpenIntent(ctx=" + this.f53985a + ", schema=" + this.f53986b + ")";
    }

    public d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f53985a = r100;
        this.f53986b = r101;
    }
}
