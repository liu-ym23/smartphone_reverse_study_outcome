package com.bytedance.android.btm.api.model;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f42067b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f42066a, r101.f42066a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f42067b, r101.f42067b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f42066a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f42067b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EventModelV3(event=" + this.f42066a + ", params=" + this.f42067b + ")";
    }

    public k(String r100, JSONObject r101) {
        this.f42066a = r100;
        this.f42067b = r101;
    }
}
