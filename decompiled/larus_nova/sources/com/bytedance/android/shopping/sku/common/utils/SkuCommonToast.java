package com.bytedance.android.shopping.sku.common.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuCommonToast {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f182777a = 0;

    public SkuCommonToast() {
    }

    static {
    }

    public static void a(final String r100) {
        e.a r101 = e.f182780a;
        e.b(new SkuCommonToast$debugShowToast$1(r100));
    }

    public static void c(String r100) {
        e.a r101 = e.f182780a;
        e.b(new SkuCommonToast$showToast$1(null, r100, false));
    }

    public static void b(Context r100, String r101) {
        e.a r102 = e.f182780a;
        e.b(new SkuCommonToast$showToast$1(r100, r101, false));
    }
}
