package com.bytedance.android.shopping.sku.common.utils;

import kotlin.Lazy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuCommonTaskUtilsKt$newSkuTask$1 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f182775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f182776c;

    @Override // com.bytedance.android.shopping.sku.common.utils.a
    public final void a() {
        Lazy r100 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuBaseTask", new SkuCommonTaskUtilsKt$newSkuTask$1$doTask$1(this));
        this.f182776c.invoke(this.f182778a);
    }

    public SkuCommonTaskUtilsKt$newSkuTask$1(String r100, Function1 r101) {
        this.f182775b = r100;
        this.f182776c = r101;
    }
}
