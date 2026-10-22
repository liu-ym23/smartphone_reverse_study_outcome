package com.bytedance.android.shopping.collect.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CollectYataQueryFrom f172156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.e f172157b;

    public d(CollectYataQueryFrom r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101) {
        Intrinsics.checkNotNullParameter(r100, "queryFrom");
        Intrinsics.checkNotNullParameter(r101, "response");
        this.f172156a = r100;
        this.f172157b = r101;
    }
}
