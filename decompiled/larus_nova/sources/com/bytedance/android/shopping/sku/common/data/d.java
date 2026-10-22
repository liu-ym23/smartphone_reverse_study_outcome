package com.bytedance.android.shopping.sku.common.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f182673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f182674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f182675c;

    public d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "specName");
        Intrinsics.checkNotNullParameter(r102, "specItemId");
        this.f182673a = r100;
        this.f182674b = r101;
        this.f182675c = r102;
    }
}
