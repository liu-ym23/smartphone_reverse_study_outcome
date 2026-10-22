package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/LifecycleOwnerDelegate;", "Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/AbsLifecycleOwner;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LifecycleOwnerDelegate extends AbsLifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleDelegate f180808a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.AbsLifecycleOwner
    public final androidx.lifecycle.Lifecycle getLifecycleCompat() {
        return this.f180808a;
    }

    public LifecycleOwnerDelegate(e r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f180808a = new LifecycleDelegate(r100.getLifecycle());
    }
}
