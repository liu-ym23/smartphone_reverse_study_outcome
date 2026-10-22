package com.bytedance.android.ec.hybrid.data.entity;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f46679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f46680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f46681c;

    public a() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f46679a, r101.f46679a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f46680b, r101.f46680b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f46681c, r101.f46681c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f46679a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f46680b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f46681c;
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
        return "ECHybridPrefetchExtraData(isPrefetchBeforeMallCreated=" + this.f46679a + ", prefetchApiKeys=" + this.f46680b + ", isLoadMore=" + this.f46681c + ")";
    }

    public a(Boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        Boolean r102 = Boolean.FALSE;
    L7:
        if ((r101 & 4) == 0) goto L9;
        r100 = null;
    L9:
        this.f46679a = r102;
        this.f46680b = null;
        this.f46681c = r100;
        return;
    L5:
        r102 = null;
        goto L7
    }
}
