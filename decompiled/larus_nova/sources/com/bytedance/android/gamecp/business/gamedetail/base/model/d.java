package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.gamecp.host_api.model.ImageModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageModel f53483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageModel f53484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f53485c;

    public d() {
        this(null, null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f53483a, r101.f53483a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53484b, r101.f53484b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53485c, r101.f53485c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        ImageModel r100 = this.f53483a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ImageModel r104 = this.f53484b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f53485c;
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
        return "CommonGameStatusInfo(gameStatusImageWhite=" + this.f53483a + ", gameStatusImage=" + this.f53484b + ", gameStatusEnum=" + this.f53485c + ")";
    }

    public d(ImageModel r100, ImageModel r101, Integer r102) {
        this.f53483a = r100;
        this.f53484b = r101;
        this.f53485c = r102;
    }
}
