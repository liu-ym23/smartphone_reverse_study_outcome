package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f183086a = null;

    static {
        f183086a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SsResponse r101 = (SsResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "ssResp");
        SkuOuterAddToCartResponse r102 = (SkuOuterAddToCartResponse) r101.body();
        Iterator<T> r103 = r101.headers().iterator();
    L3:
        String r104 = null;
        if (r103.hasNext() == false) goto L8;
        T r105 = r103.next();
        if (Intrinsics.areEqual(((Header) r105).getName(), Constants.Keys.KEY_X_TT_LOGID.toLowerCase(Locale.getDefault())) == false) goto L3;
    L9:
        Header r106 = r105;
        if (r106 == null) goto L12;
        r104 = r106.getValue();
    L12:
        r102.setLogId(r104);
        return r102;
    L8:
        r105 = (T) null;
        goto L9
    }
}
