package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.w;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f168681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f168682b;

    public d() {
        this(null, null);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f168681a, r101.f168681a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168682b, r101.f168682b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        w r100 = this.f168681a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f168682b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FeaturedShowVO(featuredShow=" + this.f168681a + ", contentDescription=" + this.f168682b + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.f168682b;
    }

    public d(w r100, String r101) {
        this.f168681a = r100;
        this.f168682b = r101;
    }
}
