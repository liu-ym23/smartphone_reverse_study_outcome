package com.bytedance.android.shopping.abscontainer.arch.core.starter;

import com.bytedance.android.shopping.skubuy.starter.SkuBuyPageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PageInfo f164160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f164161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f164162c;

    public c(SkuBuyPageInfo r100, yh3.b r101, Class r102) {
        Intrinsics.checkNotNullParameter(r100, "pageInfo");
        Intrinsics.checkNotNullParameter(r101, "queryAPI");
        Intrinsics.checkNotNullParameter(r102, "containerClazz");
        this.f164160a = r100;
        this.f164161b = r101;
        this.f164162c = r102;
    }
}
