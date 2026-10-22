package com.bytedance.android.gamecp.business.download.multichannel;

import com.bytedance.android.gamecp.common.utils.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f52824b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f52823a, r101.f52823a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f52824b, r101.f52824b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f52823a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        r0 r104 = this.f52824b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InstallPkg(openUrl=" + this.f52823a + ", pkgInstallDTO=" + this.f52824b + ")";
    }

    public c(String r100, r0 r101) {
        Intrinsics.checkNotNullParameter(r101, "pkgInstallDTO");
        this.f52823a = r100;
        this.f52824b = r101;
    }
}
