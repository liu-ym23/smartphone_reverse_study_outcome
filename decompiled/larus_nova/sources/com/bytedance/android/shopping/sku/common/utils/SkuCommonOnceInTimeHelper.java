package com.bytedance.android.shopping.sku.common.utils;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuCommonOnceInTimeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f182772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f182773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f182774c;

    public final void a(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Disposable r101 = this.f182772a;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        e.a r102 = e.f182780a;
        this.f182772a = e.a(this.f182773b, this.f182774c, new SkuCommonOnceInTimeHelper$doOnceByAbortPrevious$1(r100), SkuCommonOnceInTimeHelper$doOnceByAbortPrevious$2.INSTANCE);
    }

    public SkuCommonOnceInTimeHelper(com.bytedance.android.ec.core.async.b r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "disposableScope");
        this.f182773b = r100;
        this.f182774c = r101;
    }
}
