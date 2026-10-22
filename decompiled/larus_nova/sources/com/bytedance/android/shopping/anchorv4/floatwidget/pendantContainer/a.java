package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f166764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f166765b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f166764a, r101.f166764a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f166765b, r101.f166765b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f166764a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f166765b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentSize(type=" + this.f166764a + ", size=" + this.f166765b + ")";
    }

    public final Integer getType() {
        return this.f166764a;
    }

    public a(Integer r100, Integer r101) {
        this.f166764a = r100;
        this.f166765b = r101;
    }
}
