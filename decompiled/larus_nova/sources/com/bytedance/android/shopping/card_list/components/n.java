package com.bytedance.android.shopping.card_list.components;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f171474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f171475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f171476c;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f171474a, r101.f171474a) == true) goto L8;
        return false;
    L8:
        if (this.f171475b == r101.f171475b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f171476c, r101.f171476c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.f171474a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f171475b) * 31;
        String r104 = this.f171476c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LoadMoreParams(gulReloadScene=" + this.f171474a + ", loadMoreOffsetItem=" + this.f171475b + ", errorMsg=" + this.f171476c + ")";
    }

    public /* synthetic */ n(int r100) {
        this(CollectionsKt.emptyList(), 4, "部分商品加载失败，请重试");
    }

    public n(List<String> r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        this.f171474a = r100;
        this.f171475b = r101;
        this.f171476c = r102;
    }
}
