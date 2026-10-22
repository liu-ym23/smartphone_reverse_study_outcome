package com.bytedance.android.shopping.collect.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CollectYataQueryFrom f172151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CollectYataSkeletonLoadingStatus f172152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f172153c;

    public a(CollectYataQueryFrom r100, CollectYataSkeletonLoadingStatus r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "queryFrom");
        Intrinsics.checkNotNullParameter(r101, "collectYataSkeletonLoadingStatus");
        this.f172151a = r100;
        this.f172152b = r101;
        this.f172153c = r102;
    }
}
