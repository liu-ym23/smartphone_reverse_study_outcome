package com.bytedance.android.sdk.bdticketguard;

import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<s0> f163732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f163733c;

    public h0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == false) goto L12;
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f163731a, r101.f163731a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f163732b, r101.f163732b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f163733c, r101.f163733c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f163731a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<s0> r104 = this.f163732b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f163733c;
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
        return "RequestParams(requestType=" + this.f163731a + ", headers=" + this.f163732b + ", bodyParams=" + this.f163733c + ")";
    }

    public h0(Map r100) {
        List<s0> r101 = CollectionsKt.emptyList();
        this.f163731a = RomUtils.BRAND_HONOR;
        this.f163732b = r101;
        this.f163733c = r100;
    }
}
