package com.bytedance.android.shopping.anchorv4.data;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f166464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f166465b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r0) == false) goto L10;
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f166464a, r101.f166464a) == true) goto L8;
        return false;
    L8:
        if (this.f166465b == r101.f166465b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        JSONObject r100 = this.f166464a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f166465b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4SliceAsyncData(data=" + this.f166464a + ", timestamp=" + this.f166465b + ")";
    }

    public r0(JSONObject r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f166464a = r100;
        this.f166465b = r101;
    }
}
