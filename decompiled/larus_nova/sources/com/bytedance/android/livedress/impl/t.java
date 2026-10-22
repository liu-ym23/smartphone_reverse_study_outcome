package com.bytedance.android.livedress.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f102917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f102918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f102919c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L12;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f102917a, r101.f102917a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f102918b, r101.f102918b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f102919c, r101.f102919c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        JSONObject r100 = this.f102917a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f102918b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f102919c;
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
        return "SlardarReport(category=" + this.f102917a + ", metrics=" + this.f102918b + ", extra=" + this.f102919c + ")";
    }

    public t(JSONObject r100, JSONObject r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "metrics");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f102917a = r100;
        this.f102918b = r101;
        this.f102919c = r102;
    }
}
