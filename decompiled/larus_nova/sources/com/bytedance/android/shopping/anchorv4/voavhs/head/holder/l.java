package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f168690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d f168691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<KolReviewElement> f168692c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f168690a, r101.f168690a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168691b, r101.f168691b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168692c, r101.f168692c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f168690a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r104 = this.f168691b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<KolReviewElement> r107 = this.f168692c;
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
        return "PioneerVO(contentDescription=" + this.f168690a + ", headViewAction=" + this.f168691b + ", kolReviewList=" + this.f168692c + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.f168690a;
    }

    public l(String r100, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r101, List<KolReviewElement> r102) {
        this.f168690a = r100;
        this.f168691b = r101;
        this.f168692c = r102;
    }
}
