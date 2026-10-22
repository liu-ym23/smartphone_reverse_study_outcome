package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/AbsLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLifecycleOwner implements LifecycleOwner {
    public AbsLifecycleOwner() {
    }

    public abstract androidx.lifecycle.Lifecycle getLifecycleCompat();

    @Override // androidx.lifecycle.LifecycleOwner
    public final androidx.lifecycle.Lifecycle getLifecycle() {
        return getLifecycleCompat();
    }
}
