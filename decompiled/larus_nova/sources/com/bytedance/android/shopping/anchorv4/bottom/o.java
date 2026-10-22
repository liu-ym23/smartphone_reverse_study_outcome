package com.bytedance.android.shopping.anchorv4.bottom;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ? extends Object> f165863a;

    public o() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f165863a, ((o) r100).f165863a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, ? extends Object> r100 = this.f165863a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "BuyTrackParam(trackParams=" + this.f165863a + ")";
    }

    public o(Map<String, ? extends Object> r100) {
        this.f165863a = r100;
    }
}
