package com.bytedance.android.shopping.api.mall.feed;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f170540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f170541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f170542c;

    public i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f170540a, r101.f170540a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170541b, r101.f170541b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170542c, r101.f170542c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f170540a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f170541b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<Integer> r107 = this.f170542c;
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
        return "MallGulTitleUi(color=" + this.f170540a + ", fontSize=" + this.f170541b + ", padding=" + this.f170542c + ")";
    }

    public i(List r100) {
        this.f170540a = null;
        this.f170541b = null;
        this.f170542c = r100;
    }
}
