package com.bytedance.android.shopping.sku.common.data;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f182668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f182669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f182670c;

    public b(List<String> r100, Map<String, String> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "specItemIdList");
        Intrinsics.checkNotNullParameter(r101, "specItemIdToNameMap");
        Intrinsics.checkNotNullParameter(r102, "otherSpecSelectedItemIdList");
        this.f182668a = r100;
        this.f182669b = r101;
        this.f182670c = r102;
    }
}
