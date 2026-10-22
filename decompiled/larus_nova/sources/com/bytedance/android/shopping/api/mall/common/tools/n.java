package com.bytedance.android.shopping.api.mall.common.tools;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f170451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f170452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f170453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f170454d;

    public n() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L14;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f170451a, r101.f170451a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170452b, r101.f170452b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170453c, r101.f170453c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f170454d, r101.f170454d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f170451a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f170452b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Throwable r107 = this.f170453c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Function1<Boolean, Unit> r110 = this.f170454d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FirstScreenPendingData(apiKey=" + this.f170451a + ", result=" + this.f170452b + ", error=" + this.f170453c + ", callback=" + this.f170454d + ")";
    }

    public n(String r100, String r101, Throwable r102, Function1 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this.f170451a = r100;
        this.f170452b = r101;
        this.f170453c = r102;
        this.f170454d = r103;
    }
}
