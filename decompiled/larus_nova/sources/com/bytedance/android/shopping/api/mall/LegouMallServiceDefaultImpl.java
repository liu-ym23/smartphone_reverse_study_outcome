package com.bytedance.android.shopping.api.mall;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/LegouMallServiceDefaultImpl;", "Lcom/bytedance/android/shopping/api/mall/ILegouMallService;", "<init>", "()V", "legou-mall-common-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LegouMallServiceDefaultImpl implements ILegouMallService {
    public LegouMallServiceDefaultImpl() {
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void b() {
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void d() {
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void e(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void h() {
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void i() {
    }

    @Override // com.bytedance.android.shopping.api.mall.ILegouMallService
    public final void j() {
    }
}
