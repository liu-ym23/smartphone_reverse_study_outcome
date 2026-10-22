package com.bytedance.android.shopping.anchorv4.bottom;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ? extends Object> f165848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ? extends Object> f165849b;

    public k0() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k0) == false) goto L10;
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f165848a, r101.f165848a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f165849b, r101.f165849b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<String, ? extends Object> r100 = this.f165848a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, ? extends Object> r104 = this.f165849b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuTrackParam(trackParams=" + this.f165848a + ", addCartTrackMeta=" + this.f165849b + ")";
    }

    public /* synthetic */ k0(LinkedTreeMap r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public k0(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101) {
        this.f165848a = r100;
        this.f165849b = r101;
    }
}
