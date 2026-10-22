package com.bytedance.android.shopping.mall.impl;

import com.bytedance.android.shopping.api.mall.IECMallTabOptService;
import com.bytedance.android.shopping.mall.homepage.i;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/impl/ECMallTabOptService;", "Lcom/bytedance/android/shopping/api/mall/IECMallTabOptService;", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallTabOptService implements IECMallTabOptService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<IECMallTabOptService.a>> f178551a;

    public ECMallTabOptService() {
        this.f178551a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.shopping.api.mall.IECMallTabOptService
    public final void a(final i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CollectionsKt.removeAll(this.f178551a, new ECMallTabOptService$unregisterJavaMemoryListener$1(r100));
    }

    @Override // com.bytedance.android.shopping.api.mall.IECMallTabOptService
    public final void b(i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        WeakReference<IECMallTabOptService.a> r101 = new WeakReference(r100);
        this.f178551a.add(r101);
    }
}
