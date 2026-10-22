package com.bytedance.android.shopping.store.shopfeed.list;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShopFeedItemType f186230a;

    public final int hashCode() {
        return this.f186230a.hashCode() * 31;
    }

    public a(ShopFeedItemType r100) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        this.f186230a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if (this.f186230a == ((a) r100).f186230a) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewObject");
    L8:
        r102 = null;
        goto L10
    }
}
