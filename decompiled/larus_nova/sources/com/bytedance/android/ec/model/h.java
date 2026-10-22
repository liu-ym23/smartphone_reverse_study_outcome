package com.bytedance.android.ec.model;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f47864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f47866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f47867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f47868e;

    public h() {
        this(null, 0, "", "", 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f47864a, r101.f47864a) == true) goto L8;
        return false;
    L8:
        if (this.f47865b == r101.f47865b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f47866c, r101.f47866c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f47867d, r101.f47867d) == true) goto L14;
        return false;
    L14:
        if (this.f47868e == r101.f47868e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f47864a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f47865b) * 31;
        String r104 = this.f47866c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f47867d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.f47868e;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECShopShareActionEntry(action=" + this.f47864a + ", iconId=" + this.f47865b + ", key=" + this.f47866c + ", labelText=" + this.f47867d + ", type=" + this.f47868e + ")";
    }

    public final int getType() {
        return this.f47868e;
    }

    public h(Function0<Unit> r100, int r101, String r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "labelText");
        this.f47864a = r100;
        this.f47865b = r101;
        this.f47866c = r102;
        this.f47867d = r103;
        this.f47868e = r104;
    }
}
