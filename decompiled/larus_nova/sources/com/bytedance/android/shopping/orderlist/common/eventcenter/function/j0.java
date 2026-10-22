package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f179828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f179829b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == false) goto L10;
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f179828a, r101.f179828a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f179829b, r101.f179829b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f179828a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f179829b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "QueryCacheInfo(renderNodeKey=" + this.f179828a + ", fields=" + this.f179829b + ")";
    }

    public j0(String r100, Map<String, ? extends Object> r101) {
        this.f179828a = r100;
        this.f179829b = r101;
    }
}
