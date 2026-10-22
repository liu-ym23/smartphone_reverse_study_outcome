package com.bytedance.android.shopping.card_list.repo;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f171726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f171727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f171728c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f171726a, r101.f171726a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f171727b, r101.f171727b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f171728c, r101.f171728c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f171726a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f171727b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f171728c;
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
        return "CardListQueryApiParams(url=" + this.f171726a + ", netHost=" + this.f171727b + ", extraMap=" + this.f171728c + ")";
    }

    public a(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "netHost");
        Intrinsics.checkNotNullParameter(r102, "extraMap");
        this.f171726a = r100;
        this.f171727b = r101;
        this.f171728c = r102;
    }
}
