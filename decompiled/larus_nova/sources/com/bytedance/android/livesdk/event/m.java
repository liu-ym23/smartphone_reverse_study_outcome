package com.bytedance.android.livesdk.event;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f123350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f123351b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f123350a, r101.f123350a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f123351b, r101.f123351b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<n> r100 = this.f123350a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f123351b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageRelatedInfo(infoList=" + this.f123350a + ", imageType=" + this.f123351b + ")";
    }

    public m(List r100) {
        Intrinsics.checkNotNullParameter("image", "imageType");
        this.f123350a = r100;
        this.f123351b = "image";
    }
}
