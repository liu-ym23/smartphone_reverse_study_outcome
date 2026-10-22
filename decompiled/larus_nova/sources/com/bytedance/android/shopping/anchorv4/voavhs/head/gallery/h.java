package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f168666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.ec.model.k> f168667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f168668c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f168666a, r101.f168666a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168667b, r101.f168667b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168668c, r101.f168668c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f168666a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.ec.model.k> r104 = this.f168667b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f168668c;
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
        return "GalleryMediaModelGroup(type=" + this.f168666a + ", models=" + this.f168667b + ", tabTypeName=" + this.f168668c + ")";
    }

    public final String getType() {
        return this.f168666a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(String r100, List<? extends com.bytedance.android.ec.model.k> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "models");
        this.f168666a = r100;
        this.f168667b = r101;
        this.f168668c = r102;
    }
}
