package com.bytedance.android.shopping.sku.common.controller.uplink;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f182651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f182652b;

    public a(List<String> r100, List<c> r101) {
        Intrinsics.checkNotNullParameter(r100, "globalSkipTriggers");
        Intrinsics.checkNotNullParameter(r101, "moduleSkipTriggers");
        this.f182651a = r100;
        this.f182652b = r101;
    }
}
