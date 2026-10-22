package com.bytedance.android.shopping.cache.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/cache/base/BaseLifeCycleCache$registeLifecycleEvent$1", "Landroidx/lifecycle/LifecycleEventObserver;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseLifeCycleCache$registeLifecycleEvent$1 implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        throw null;
    }
}
