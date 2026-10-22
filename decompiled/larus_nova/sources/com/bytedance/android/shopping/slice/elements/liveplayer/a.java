package com.bytedance.android.shopping.slice.elements.liveplayer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f183302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f183304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f183305d;

    public final int hashCode() {
        String r100 = this.f183303b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final boolean equals(Object r100) {
        String r101 = null;
        if ((r100 instanceof a) == true) goto L5;
        r100 = null;
    L5:
        a r102 = (a) r100;
        if (r102 == null) goto L9;
        r101 = r102.f183303b;
    L9:
        return Intrinsics.areEqual(r101, this.f183303b);
    }

    public a(String r100, String r101, String r102) {
        this.f183302a = r100;
        this.f183303b = r101;
        this.f183304c = r102;
        this.f183305d = null;
    }
}
