package com.bytedance.android.ec.hybrid.list.entity;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f47065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f47066c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f47064a, r101.f47064a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f47065b, r101.f47065b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f47066c, r101.f47066c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f47064a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f47065b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f47066c;
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
        return "ECCardExtraData(recommendInfo=" + this.f47064a + ", trackCommonData=" + this.f47065b + ", trackDataKey=" + this.f47066c + ")";
    }

    public a(String r100, Map<String, ? extends Object> r101, String r102) {
        this.f47064a = r100;
        this.f47065b = r101;
        this.f47066c = r102;
    }
}
