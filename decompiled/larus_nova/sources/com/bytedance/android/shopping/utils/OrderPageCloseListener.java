package com.bytedance.android.shopping.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/utils/OrderPageCloseListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "clear", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderPageCloseListener implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Disposable f187030a;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void clear() {
        if (this.f187030a.isDisposed() == true) goto L6;
        this.f187030a.dispose();
        return;
    }

    public OrderPageCloseListener(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f187030a = r100;
    }
}
