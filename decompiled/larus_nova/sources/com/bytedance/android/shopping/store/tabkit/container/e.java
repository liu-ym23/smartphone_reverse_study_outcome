package com.bytedance.android.shopping.store.tabkit.container;

import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f186725a = null;

    static {
        f186725a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ECStorePreloadInfoResponse r101 = (ECStorePreloadInfoResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        return r101;
    }
}
