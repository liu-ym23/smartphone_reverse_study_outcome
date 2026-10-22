package com.bytedance.android.ec.core.imagex;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f44673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f44674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f44675c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f44673a, r101.f44673a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f44674b, r101.f44674b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f44675c, r101.f44675c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        JSONObject r100 = this.f44673a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f44674b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f44675c;
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
        return "ECImageFrescoTraceData(category=" + this.f44673a + ", metric=" + this.f44674b + ", extraLog=" + this.f44675c + ")";
    }

    public g(JSONObject r100, JSONObject r101, JSONObject r102) {
        this.f44673a = r100;
        this.f44674b = r101;
        this.f44675c = r102;
    }
}
